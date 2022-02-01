package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public MediaPlayer UNP;
  public int UNQ;
  public long UNR;
  public long UNS;
  a UNT;
  private Vibrator cqQ;
  public boolean isStarted;
  private AudioManager mAudioManager;
  public Context mContext;
  MMHandler mRi;
  private com.tencent.mm.compatible.util.b peV;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(115686);
    this.isStarted = false;
    this.UNQ = 65536;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = com.tencent.mm.plugin.audio.c.a.cTW().audioManager;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.cqQ = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(115686);
  }
  
  private void icr()
  {
    AppMethodBeat.i(115691);
    Object localObject = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool;
    if (d.rb(26)) {
      bool = ((SharedPreferences)localObject).getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      Log.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.cqQ = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.cqQ == null)
        {
          AppMethodBeat.o(115691);
          return;
          bool = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
        }
        else
        {
          if (d.rb(26))
          {
            localObject = new AudioAttributes.Builder().setUsage(6).build();
            this.cqQ.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
            AppMethodBeat.o(115691);
            return;
          }
          this.cqQ.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
          AppMethodBeat.o(115691);
        }
      }
      else
      {
        Log.i("MicroMsg.RingPlayer", "system not open vibrate");
      }
    }
    AppMethodBeat.o(115691);
  }
  
  private void ics()
  {
    AppMethodBeat.i(115692);
    if (this.cqQ != null)
    {
      this.cqQ.cancel();
      this.cqQ = null;
    }
    AppMethodBeat.o(115692);
  }
  
  public final void BN(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(115687);
    Log.printInfoStack("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (af.lXZ.lRF < 0)) {
        break label169;
      }
      j = af.lXZ.lRF;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        Log.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.plugin.audio.c.a.cTW().b(j, null);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        Log.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.audio.c.a.cTW().lP(paramBoolean);
      }
      AppMethodBeat.o(115687);
      return;
      if (d.rb(21)) {
        break;
      }
      i = 2;
      break;
      label169:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (af.lXZ.lRD >= 0) {
          j = af.lXZ.lRD;
        }
      }
    }
  }
  
  public final void GS(boolean paramBoolean)
  {
    AppMethodBeat.i(292868);
    if (this.isStarted)
    {
      AppMethodBeat.o(292868);
      return;
    }
    Log.i("MicroMsg.RingPlayer", "now we start play ");
    for (;;)
    {
      try
      {
        Object localObject = RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1);
        this.UNP = k.b(this.mContext, (Uri)localObject);
        localObject = this.UNP;
        if (localObject == null)
        {
          AppMethodBeat.o(292868);
          return;
        }
        this.UNP.stop();
        this.UNP.prepare();
        this.UNP.setLooping(true);
        BN(true);
        this.UNP.setVolume(0.6F, 0.6F);
        switch (this.mAudioManager.getRingerMode())
        {
        case 2: 
          this.isStarted = true;
          AppMethodBeat.o(292868);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("ex", localException.getMessage());
        AppMethodBeat.o(292868);
        return;
      }
      if (this.UNP != null) {
        this.UNP.start();
      }
    }
  }
  
  /* Error */
  public final void R(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 298
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 301	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   9: ifeq +790 -> 799
    //   12: iload_2
    //   13: ifne +102 -> 115
    //   16: invokestatic 307	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   19: invokevirtual 313	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   22: ldc_w 314
    //   25: getstatic 318	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   28: invokevirtual 324	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 209	java/lang/Boolean
    //   34: invokevirtual 327	java/lang/Boolean:booleanValue	()Z
    //   37: istore_3
    //   38: bipush 26
    //   40: invokestatic 137	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   43: ifeq +107 -> 150
    //   46: invokestatic 332	com/tencent/mm/k/b:aQT	()Z
    //   49: istore 7
    //   51: invokestatic 335	com/tencent/mm/k/b:aQU	()Z
    //   54: istore 6
    //   56: ldc 151
    //   58: ldc_w 337
    //   61: iconst_4
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: iload_3
    //   68: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: iload 7
    //   76: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   79: aastore
    //   80: dup
    //   81: iconst_2
    //   82: iload 6
    //   84: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: dup
    //   89: iconst_3
    //   90: getstatic 318	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: aastore
    //   94: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: iconst_1
    //   98: istore_3
    //   99: iload_3
    //   100: ifne +99 -> 199
    //   103: iload 6
    //   105: ifne +94 -> 199
    //   108: ldc_w 298
    //   111: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: iload_2
    //   116: iconst_1
    //   117: if_icmpeq +8 -> 125
    //   120: iload_2
    //   121: iconst_2
    //   122: if_icmpne +677 -> 799
    //   125: invokestatic 307	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   128: invokevirtual 313	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   131: ldc_w 338
    //   134: getstatic 318	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   137: invokevirtual 324	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 209	java/lang/Boolean
    //   143: invokevirtual 327	java/lang/Boolean:booleanValue	()Z
    //   146: istore_3
    //   147: goto -109 -> 38
    //   150: invokestatic 341	com/tencent/mm/k/b:aQL	()Z
    //   153: istore 7
    //   155: invokestatic 344	com/tencent/mm/k/b:aQN	()Z
    //   158: istore 6
    //   160: goto -104 -> 56
    //   163: astore 8
    //   165: iconst_1
    //   166: istore_3
    //   167: ldc 151
    //   169: new 346	java/lang/StringBuilder
    //   172: dup
    //   173: ldc_w 348
    //   176: invokespecial 351	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   179: aload 8
    //   181: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: iconst_1
    //   194: istore 6
    //   196: goto -97 -> 99
    //   199: aload_0
    //   200: getfield 58	com/tencent/mm/plugin/voip/video/e:isStarted	Z
    //   203: ifeq +10 -> 213
    //   206: ldc_w 298
    //   209: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: return
    //   213: iload_3
    //   214: ifeq +568 -> 782
    //   217: aload_0
    //   218: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   221: putfield 366	com/tencent/mm/plugin/voip/video/e:UNR	J
    //   224: aload_0
    //   225: new 261	com/tencent/mm/compatible/b/k
    //   228: dup
    //   229: invokespecial 367	com/tencent/mm/compatible/b/k:<init>	()V
    //   232: putfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   235: aload_0
    //   236: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   239: aload_0
    //   240: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   243: new 346	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 369
    //   250: invokespecial 351	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_0
    //   254: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   257: invokevirtual 372	android/content/Context:getPackageName	()Ljava/lang/String;
    //   260: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc_w 374
    //   266: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: iload_1
    //   270: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   273: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 383	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   279: invokevirtual 387	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   282: aload_0
    //   283: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   286: new 6	com/tencent/mm/plugin/voip/video/e$1
    //   289: dup
    //   290: aload_0
    //   291: invokespecial 390	com/tencent/mm/plugin/voip/video/e$1:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   294: invokevirtual 394	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   297: aload_0
    //   298: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   301: new 8	com/tencent/mm/plugin/voip/video/e$2
    //   304: dup
    //   305: aload_0
    //   306: invokespecial 395	com/tencent/mm/plugin/voip/video/e$2:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   309: invokevirtual 399	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   312: invokestatic 402	com/tencent/mm/plugin/audio/c/a:cTX	()Z
    //   315: ifeq +202 -> 517
    //   318: invokestatic 405	com/tencent/mm/plugin/audio/c/a:cTY	()Z
    //   321: ifeq +196 -> 517
    //   324: iconst_1
    //   325: istore_3
    //   326: invokestatic 408	com/tencent/mm/plugin/audio/c/a:cTQ	()Z
    //   329: istore 6
    //   331: ldc 151
    //   333: ldc_w 410
    //   336: iconst_2
    //   337: anewarray 4	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: iload_3
    //   343: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: iload 6
    //   351: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   354: aastore
    //   355: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   358: iload_3
    //   359: ifeq +163 -> 522
    //   362: invokestatic 415	com/tencent/mm/plugin/audio/c/a:cTR	()I
    //   365: istore_1
    //   366: aload_0
    //   367: iconst_0
    //   368: invokevirtual 279	com/tencent/mm/plugin/voip/video/e:BN	(Z)V
    //   371: bipush 28
    //   373: invokestatic 418	com/tencent/mm/compatible/util/d:rd	(I)Z
    //   376: ifeq +199 -> 575
    //   379: aload_0
    //   380: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   383: new 168	android/media/AudioAttributes$Builder
    //   386: dup
    //   387: invokespecial 169	android/media/AudioAttributes$Builder:<init>	()V
    //   390: bipush 6
    //   392: invokevirtual 173	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   395: iload_1
    //   396: invokevirtual 421	android/media/AudioAttributes$Builder:setLegacyStreamType	(I)Landroid/media/AudioAttributes$Builder;
    //   399: iconst_4
    //   400: invokevirtual 424	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   403: invokevirtual 177	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   406: invokevirtual 428	android/media/MediaPlayer:setAudioAttributes	(Landroid/media/AudioAttributes;)V
    //   409: ldc 151
    //   411: ldc_w 430
    //   414: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto +387 -> 804
    //   420: invokestatic 82	com/tencent/mm/plugin/audio/c/a:cTW	()Lcom/tencent/mm/plugin/audio/b/a;
    //   423: iload_1
    //   424: invokevirtual 434	com/tencent/mm/plugin/audio/b/a:getStreamMaxVolume	(I)I
    //   427: istore 5
    //   429: invokestatic 82	com/tencent/mm/plugin/audio/c/a:cTW	()Lcom/tencent/mm/plugin/audio/b/a;
    //   432: iload_1
    //   433: invokevirtual 437	com/tencent/mm/plugin/audio/b/a:getStreamVolume	(I)I
    //   436: istore 4
    //   438: iload 4
    //   440: istore_2
    //   441: iload 4
    //   443: iload 5
    //   445: iconst_2
    //   446: idiv
    //   447: if_icmple +8 -> 455
    //   450: iload 5
    //   452: iconst_2
    //   453: idiv
    //   454: istore_2
    //   455: invokestatic 82	com/tencent/mm/plugin/audio/c/a:cTW	()Lcom/tencent/mm/plugin/audio/b/a;
    //   458: iload_1
    //   459: iload_2
    //   460: invokevirtual 441	com/tencent/mm/plugin/audio/b/a:gi	(II)V
    //   463: aload_0
    //   464: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   467: iconst_1
    //   468: invokevirtual 277	android/media/MediaPlayer:setLooping	(Z)V
    //   471: aload_0
    //   472: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   475: invokevirtual 274	android/media/MediaPlayer:prepare	()V
    //   478: aload_0
    //   479: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   482: invokevirtual 287	android/media/MediaPlayer:start	()V
    //   485: invokestatic 364	java/lang/System:currentTimeMillis	()J
    //   488: aload_0
    //   489: getfield 366	com/tencent/mm/plugin/voip/video/e:UNR	J
    //   492: lsub
    //   493: ldc2_w 442
    //   496: lcmp
    //   497: ifle +8 -> 505
    //   500: aload_0
    //   501: iconst_3
    //   502: putfield 61	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   505: aload_0
    //   506: iconst_1
    //   507: putfield 58	com/tencent/mm/plugin/voip/video/e:isStarted	Z
    //   510: ldc_w 298
    //   513: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: return
    //   517: iconst_0
    //   518: istore_3
    //   519: goto -193 -> 326
    //   522: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:lXZ	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   525: getfield 446	com/tencent/mm/compatible/deviceinfo/b:lRC	I
    //   528: iflt +266 -> 794
    //   531: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:lXZ	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   534: getfield 446	com/tencent/mm/compatible/deviceinfo/b:lRC	I
    //   537: istore_1
    //   538: goto +278 -> 816
    //   541: aload_0
    //   542: iconst_0
    //   543: invokevirtual 279	com/tencent/mm/plugin/voip/video/e:BN	(Z)V
    //   546: goto -175 -> 371
    //   549: iconst_3
    //   550: istore_1
    //   551: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:lXZ	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   554: getfield 449	com/tencent/mm/compatible/deviceinfo/b:lRz	I
    //   557: iflt +10 -> 567
    //   560: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:lXZ	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   563: getfield 449	com/tencent/mm/compatible/deviceinfo/b:lRz	I
    //   566: istore_1
    //   567: aload_0
    //   568: iconst_1
    //   569: invokevirtual 279	com/tencent/mm/plugin/voip/video/e:BN	(Z)V
    //   572: goto -201 -> 371
    //   575: aload_0
    //   576: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   579: iload_1
    //   580: invokevirtual 452	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   583: goto +221 -> 804
    //   586: astore 8
    //   588: ldc 151
    //   590: new 346	java/lang/StringBuilder
    //   593: dup
    //   594: ldc_w 454
    //   597: invokespecial 351	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   600: aload 8
    //   602: invokevirtual 457	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   605: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_0
    //   615: iconst_2
    //   616: putfield 61	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   619: aload_0
    //   620: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   623: iconst_1
    //   624: invokestatic 259	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   627: astore 8
    //   629: aload_0
    //   630: aload_0
    //   631: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   634: aload 8
    //   636: invokestatic 264	com/tencent/mm/compatible/b/k:b	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   639: putfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   642: aload_0
    //   643: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   646: astore 8
    //   648: aload 8
    //   650: ifnonnull +26 -> 676
    //   653: ldc_w 298
    //   656: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   659: return
    //   660: aload_0
    //   661: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   664: ldc_w 280
    //   667: ldc_w 280
    //   670: invokevirtual 284	android/media/MediaPlayer:setVolume	(FF)V
    //   673: goto -210 -> 463
    //   676: aload_0
    //   677: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   680: invokevirtual 271	android/media/MediaPlayer:stop	()V
    //   683: aload_0
    //   684: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   687: invokevirtual 274	android/media/MediaPlayer:prepare	()V
    //   690: aload_0
    //   691: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   694: iconst_1
    //   695: invokevirtual 277	android/media/MediaPlayer:setLooping	(Z)V
    //   698: aload_0
    //   699: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   702: ldc_w 280
    //   705: ldc_w 280
    //   708: invokevirtual 284	android/media/MediaPlayer:setVolume	(FF)V
    //   711: aload_0
    //   712: getfield 266	com/tencent/mm/plugin/voip/video/e:UNP	Landroid/media/MediaPlayer;
    //   715: invokevirtual 287	android/media/MediaPlayer:start	()V
    //   718: aload_0
    //   719: iconst_0
    //   720: putfield 61	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   723: goto -218 -> 505
    //   726: astore 8
    //   728: ldc_w 289
    //   731: aload 8
    //   733: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   736: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   739: aload_0
    //   740: iconst_2
    //   741: putfield 61	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   744: goto -239 -> 505
    //   747: astore 8
    //   749: ldc 151
    //   751: new 346	java/lang/StringBuilder
    //   754: dup
    //   755: ldc_w 459
    //   758: invokespecial 351	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: aload 8
    //   763: invokevirtual 460	java/lang/Exception:toString	()Ljava/lang/String;
    //   766: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   775: ldc_w 298
    //   778: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   781: return
    //   782: ldc_w 298
    //   785: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   788: return
    //   789: astore 8
    //   791: goto -624 -> 167
    //   794: iconst_0
    //   795: istore_1
    //   796: goto +20 -> 816
    //   799: iconst_1
    //   800: istore_3
    //   801: goto -763 -> 38
    //   804: iload 6
    //   806: ifne -386 -> 420
    //   809: iload_3
    //   810: ifeq -150 -> 660
    //   813: goto -393 -> 420
    //   816: iload 6
    //   818: ifne -277 -> 541
    //   821: iload_2
    //   822: iconst_1
    //   823: if_icmpne -274 -> 549
    //   826: goto -285 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	this	e
    //   0	829	1	paramInt1	int
    //   0	829	2	paramInt2	int
    //   0	829	3	paramBoolean	boolean
    //   436	12	4	i	int
    //   427	27	5	j	int
    //   54	763	6	bool1	boolean
    //   49	105	7	bool2	boolean
    //   163	17	8	localException1	Exception
    //   586	15	8	localObject1	Object
    //   627	22	8	localObject2	Object
    //   726	6	8	localException2	Exception
    //   747	15	8	localException3	Exception
    //   789	1	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   6	12	163	java/lang/Exception
    //   16	38	163	java/lang/Exception
    //   125	147	163	java/lang/Exception
    //   235	324	586	finally
    //   326	358	586	finally
    //   362	371	586	finally
    //   371	417	586	finally
    //   420	438	586	finally
    //   441	455	586	finally
    //   455	463	586	finally
    //   463	505	586	finally
    //   522	538	586	finally
    //   541	546	586	finally
    //   551	567	586	finally
    //   567	572	586	finally
    //   575	583	586	finally
    //   660	673	586	finally
    //   619	648	726	java/lang/Exception
    //   676	723	726	java/lang/Exception
    //   217	235	747	java/lang/Exception
    //   505	510	747	java/lang/Exception
    //   588	619	747	java/lang/Exception
    //   728	744	747	java/lang/Exception
    //   38	56	789	java/lang/Exception
    //   56	97	789	java/lang/Exception
    //   150	160	789	java/lang/Exception
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(292891);
    if (((paramInt1 == b.f.playend) || (paramInt1 == b.f.close_lower_volume)) && (!com.tencent.mm.plugin.audio.c.a.cTX()) && (!com.tencent.mm.plugin.audio.c.a.cTQ()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(292891);
      return;
    }
    boolean bool = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_shake", true);
    if (paramBoolean1) {
      Util.shake(this.mContext, bool);
    }
    Log.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.UNS = System.currentTimeMillis();
    k localk = new k();
    try
    {
      localk.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      localk.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115681);
          paramAnonymousMediaPlayer.release();
          if (System.currentTimeMillis() - e.this.UNS > 5000L) {
            e.this.UNQ = 8;
          }
          AppMethodBeat.o(115681);
        }
      });
      localk.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115682);
          if (paramAnonymousMediaPlayer != null)
          {
            paramAnonymousMediaPlayer.release();
            e.this.UNQ = 5;
            Log.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(115682);
          return false;
        }
      });
      BN(com.tencent.mm.plugin.audio.c.a.cTU());
      if (paramBoolean2)
      {
        if (!com.tencent.mm.plugin.audio.c.a.cTX()) {
          break label361;
        }
        paramInt2 = com.tencent.mm.plugin.audio.c.a.cTR();
        localk.setAudioStreamType(paramInt2);
        if (!d.rd(28)) {
          break label366;
        }
        localk.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(paramInt2).setContentType(4).build());
        Log.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
      }
      for (;;)
      {
        if ((paramInt1 == b.f.playend) && ((com.tencent.mm.plugin.audio.c.a.cTX()) || (com.tencent.mm.plugin.audio.c.a.cTQ()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.UNS > 2000L) {
          this.UNQ = 7;
        }
        AppMethodBeat.o(292891);
        return;
        label361:
        paramInt2 = 0;
        break;
        label366:
        localk.setAudioStreamType(paramInt2);
      }
      return;
    }
    finally
    {
      Log.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localObject });
      this.UNQ = 6;
      AppMethodBeat.o(292891);
    }
  }
  
  public final boolean aFG()
  {
    return !this.isStarted;
  }
  
  public final void b(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(115690);
    this.UNR = System.currentTimeMillis();
    this.UNP = new k();
    try
    {
      this.UNP.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.UNP.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115679);
          if (System.currentTimeMillis() - e.this.UNR > 70000L) {
            e.this.UNQ = 4;
          }
          if (e.this.isStarted)
          {
            e.this.UNT = new e.a(e.this, paramInt1, paramLong, paramInt2, this.val$streamType);
            e.this.mRi.postDelayed(e.this.UNT, paramLong);
          }
          AppMethodBeat.o(115679);
        }
      });
      this.UNP.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115680);
          e.this.UNQ = 1;
          Log.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(115680);
          return false;
        }
      });
      this.UNP.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.UNP.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.UNP.setLooping(false);
        this.UNP.prepare();
        this.UNP.start();
        if (System.currentTimeMillis() - this.UNR > 2000L) {
          this.UNQ = 3;
        }
        AppMethodBeat.o(115690);
        return;
        icr();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(115690);
    }
  }
  
  public final int ict()
  {
    AppMethodBeat.i(115696);
    Log.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.UNQ);
    int i = this.UNQ;
    AppMethodBeat.o(115696);
    return i;
  }
  
  public final void mK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292887);
    this.UNQ = 0;
    if (paramInt1 == 0)
    {
      GS(true);
      AppMethodBeat.o(292887);
      return;
    }
    R(paramInt1, paramInt2, true);
    AppMethodBeat.o(292887);
  }
  
  public final void p(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(292892);
    a(paramInt1, paramBoolean, paramInt2, true);
    AppMethodBeat.o(292892);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115688);
    Log.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.isStarted) });
    ics();
    if ((this.UNP == null) || (!this.isStarted))
    {
      AppMethodBeat.o(115688);
      return;
    }
    try
    {
      this.UNP.stop();
      this.UNP.release();
      if (this.UNT != null) {
        this.mRi.removeCallbacks(this.UNT);
      }
      this.isStarted = false;
      com.tencent.mm.plugin.audio.c.a.cTP();
      AppMethodBeat.o(115688);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RingPlayer", localException.toString());
      AppMethodBeat.o(115688);
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean UNY;
    private long interval;
    private int resId;
    private int streamType;
    
    public a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.resId = paramInt1;
      this.interval = paramLong;
      this.UNY = paramBoolean;
      this.streamType = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(115685);
      e.this.b(this.resId, this.interval, this.UNY, this.streamType);
      AppMethodBeat.o(115685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */