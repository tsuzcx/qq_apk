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
  public MediaPlayer NZS;
  public int NZT;
  public long NZU;
  public long NZV;
  a NZW;
  public boolean isStarted;
  MMHandler knk;
  private AudioManager mAudioManager;
  public Context mContext;
  private com.tencent.mm.compatible.util.b mlj;
  private Vibrator rqy;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(115686);
    this.isStarted = false;
    this.NZT = 65536;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = com.tencent.mm.plugin.audio.c.a.crn().audioManager;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.rqy = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    AppMethodBeat.o(115686);
  }
  
  private void gDv()
  {
    AppMethodBeat.i(115691);
    Object localObject = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool;
    if (d.qV(26)) {
      bool = ((SharedPreferences)localObject).getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      Log.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.rqy = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.rqy == null)
        {
          AppMethodBeat.o(115691);
          return;
          bool = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
        }
        else
        {
          if (d.qV(26))
          {
            localObject = new AudioAttributes.Builder().setUsage(6).build();
            this.rqy.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
            AppMethodBeat.o(115691);
            return;
          }
          this.rqy.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
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
  
  private void gDw()
  {
    AppMethodBeat.i(115692);
    if (this.rqy != null)
    {
      this.rqy.cancel();
      this.rqy = null;
    }
    AppMethodBeat.o(115692);
  }
  
  public final void Bo(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(115687);
    Log.printInfoStack("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (af.juI.jox < 0)) {
        break label169;
      }
      j = af.juI.jox;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        Log.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.plugin.audio.c.a.crn().b(j, null);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        Log.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.audio.c.a.crn().kC(paramBoolean);
      }
      AppMethodBeat.o(115687);
      return;
      if (d.qV(21)) {
        break;
      }
      i = 2;
      break;
      label169:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (af.juI.jov >= 0) {
          j = af.juI.jov;
        }
      }
    }
  }
  
  public final void Bp(boolean paramBoolean)
  {
    AppMethodBeat.i(237043);
    if (this.isStarted)
    {
      AppMethodBeat.o(237043);
      return;
    }
    Log.i("MicroMsg.RingPlayer", "now we start play ");
    for (;;)
    {
      try
      {
        Object localObject = RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1);
        this.NZS = k.d(this.mContext, (Uri)localObject);
        localObject = this.NZS;
        if (localObject == null)
        {
          AppMethodBeat.o(237043);
          return;
        }
        this.NZS.stop();
        this.NZS.prepare();
        this.NZS.setLooping(true);
        Bo(true);
        if (paramBoolean) {
          this.NZS.setVolume(0.6F, 0.6F);
        }
        switch (this.mAudioManager.getRingerMode())
        {
        case 2: 
          this.isStarted = true;
          AppMethodBeat.o(237043);
          return;
          gDv();
          continue;
          if (this.NZS == null) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("ex", localException.getMessage());
        AppMethodBeat.o(237043);
        return;
      }
      this.NZS.start();
    }
  }
  
  /* Error */
  public final void L(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 306	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
    //   9: ifeq +932 -> 941
    //   12: iload_2
    //   13: ifne +119 -> 132
    //   16: invokestatic 312	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   19: invokevirtual 318	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   22: ldc_w 319
    //   25: getstatic 323	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   28: invokevirtual 328	com/tencent/mm/storage/ao:b	(ILjava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 209	java/lang/Boolean
    //   34: invokevirtual 331	java/lang/Boolean:booleanValue	()Z
    //   37: istore 6
    //   39: bipush 28
    //   41: invokestatic 334	com/tencent/mm/compatible/util/d:qX	(I)Z
    //   44: ifeq +124 -> 168
    //   47: invokestatic 339	com/tencent/mm/n/b:awm	()Z
    //   50: istore 8
    //   52: invokestatic 342	com/tencent/mm/n/b:awn	()Z
    //   55: istore 7
    //   57: ldc 151
    //   59: ldc_w 344
    //   62: iconst_4
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: iload 6
    //   70: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: iload 8
    //   78: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload 7
    //   86: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: iload_3
    //   93: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   96: aastore
    //   97: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: iload 7
    //   102: istore 6
    //   104: iload_3
    //   105: ifeq +10 -> 115
    //   108: iconst_1
    //   109: istore 8
    //   111: iload 7
    //   113: istore 6
    //   115: iload 8
    //   117: ifne +130 -> 247
    //   120: iload 6
    //   122: ifne +125 -> 247
    //   125: ldc_w 303
    //   128: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: iload_2
    //   133: iconst_1
    //   134: if_icmpeq +8 -> 142
    //   137: iload_2
    //   138: iconst_2
    //   139: if_icmpne +802 -> 941
    //   142: invokestatic 312	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
    //   145: invokevirtual 318	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
    //   148: ldc_w 345
    //   151: getstatic 323	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   154: invokevirtual 328	com/tencent/mm/storage/ao:b	(ILjava/lang/Object;)Ljava/lang/Object;
    //   157: checkcast 209	java/lang/Boolean
    //   160: invokevirtual 331	java/lang/Boolean:booleanValue	()Z
    //   163: istore 6
    //   165: goto -126 -> 39
    //   168: bipush 26
    //   170: invokestatic 137	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   173: ifeq +16 -> 189
    //   176: invokestatic 348	com/tencent/mm/n/b:awt	()Z
    //   179: istore 8
    //   181: invokestatic 351	com/tencent/mm/n/b:awu	()Z
    //   184: istore 7
    //   186: goto -129 -> 57
    //   189: invokestatic 354	com/tencent/mm/n/b:awk	()Z
    //   192: istore 8
    //   194: invokestatic 357	com/tencent/mm/n/b:awo	()Z
    //   197: istore 7
    //   199: goto -142 -> 57
    //   202: astore 9
    //   204: iconst_1
    //   205: istore 6
    //   207: ldc 151
    //   209: new 359	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 361
    //   216: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload 9
    //   221: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: iconst_1
    //   234: istore 7
    //   236: iload 6
    //   238: istore 8
    //   240: iload 7
    //   242: istore 6
    //   244: goto -129 -> 115
    //   247: aload_0
    //   248: getfield 58	com/tencent/mm/plugin/voip/video/e:isStarted	Z
    //   251: ifeq +10 -> 261
    //   254: ldc_w 303
    //   257: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: return
    //   261: iload 8
    //   263: ifeq +643 -> 906
    //   266: aload_0
    //   267: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   270: putfield 379	com/tencent/mm/plugin/voip/video/e:NZU	J
    //   273: aload_0
    //   274: new 261	com/tencent/mm/compatible/b/k
    //   277: dup
    //   278: invokespecial 380	com/tencent/mm/compatible/b/k:<init>	()V
    //   281: putfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   284: aload_0
    //   285: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   288: aload_0
    //   289: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   292: new 359	java/lang/StringBuilder
    //   295: dup
    //   296: ldc_w 382
    //   299: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_0
    //   303: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   306: invokevirtual 385	android/content/Context:getPackageName	()Ljava/lang/String;
    //   309: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 387
    //   315: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: iload_1
    //   319: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 396	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   328: invokevirtual 400	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   331: aload_0
    //   332: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   335: new 6	com/tencent/mm/plugin/voip/video/e$1
    //   338: dup
    //   339: aload_0
    //   340: invokespecial 403	com/tencent/mm/plugin/voip/video/e$1:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   343: invokevirtual 407	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   346: aload_0
    //   347: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   350: new 8	com/tencent/mm/plugin/voip/video/e$2
    //   353: dup
    //   354: aload_0
    //   355: invokespecial 408	com/tencent/mm/plugin/voip/video/e$2:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   358: invokevirtual 412	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   361: invokestatic 415	com/tencent/mm/plugin/audio/c/a:cro	()Z
    //   364: ifeq +205 -> 569
    //   367: invokestatic 418	com/tencent/mm/plugin/audio/c/a:crp	()Z
    //   370: ifeq +199 -> 569
    //   373: iconst_1
    //   374: istore 7
    //   376: invokestatic 421	com/tencent/mm/plugin/audio/c/a:crh	()Z
    //   379: istore 8
    //   381: ldc 151
    //   383: ldc_w 423
    //   386: iconst_2
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: iload 7
    //   394: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   397: aastore
    //   398: dup
    //   399: iconst_1
    //   400: iload 8
    //   402: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   405: aastore
    //   406: invokestatic 425	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   409: iload 7
    //   411: ifeq +164 -> 575
    //   414: invokestatic 428	com/tencent/mm/plugin/audio/c/a:cri	()I
    //   417: istore_1
    //   418: aload_0
    //   419: iconst_0
    //   420: invokevirtual 280	com/tencent/mm/plugin/voip/video/e:Bo	(Z)V
    //   423: bipush 28
    //   425: invokestatic 334	com/tencent/mm/compatible/util/d:qX	(I)Z
    //   428: ifeq +239 -> 667
    //   431: aload_0
    //   432: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   435: new 168	android/media/AudioAttributes$Builder
    //   438: dup
    //   439: invokespecial 169	android/media/AudioAttributes$Builder:<init>	()V
    //   442: bipush 6
    //   444: invokevirtual 173	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   447: iload_1
    //   448: invokevirtual 431	android/media/AudioAttributes$Builder:setLegacyStreamType	(I)Landroid/media/AudioAttributes$Builder;
    //   451: iconst_4
    //   452: invokevirtual 434	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   455: invokevirtual 177	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   458: invokevirtual 438	android/media/MediaPlayer:setAudioAttributes	(Landroid/media/AudioAttributes;)V
    //   461: ldc 151
    //   463: ldc_w 440
    //   466: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto +478 -> 947
    //   472: invokestatic 82	com/tencent/mm/plugin/audio/c/a:crn	()Lcom/tencent/mm/plugin/audio/b/a;
    //   475: iload_1
    //   476: invokevirtual 444	com/tencent/mm/plugin/audio/b/a:getStreamMaxVolume	(I)I
    //   479: istore 5
    //   481: invokestatic 82	com/tencent/mm/plugin/audio/c/a:crn	()Lcom/tencent/mm/plugin/audio/b/a;
    //   484: iload_1
    //   485: invokevirtual 447	com/tencent/mm/plugin/audio/b/a:getStreamVolume	(I)I
    //   488: istore 4
    //   490: iload 4
    //   492: istore_2
    //   493: iload 4
    //   495: iload 5
    //   497: iconst_2
    //   498: idiv
    //   499: if_icmple +8 -> 507
    //   502: iload 5
    //   504: iconst_2
    //   505: idiv
    //   506: istore_2
    //   507: invokestatic 82	com/tencent/mm/plugin/audio/c/a:crn	()Lcom/tencent/mm/plugin/audio/b/a;
    //   510: iload_1
    //   511: iload_2
    //   512: invokevirtual 451	com/tencent/mm/plugin/audio/b/a:fp	(II)V
    //   515: aload_0
    //   516: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   519: iconst_1
    //   520: invokevirtual 278	android/media/MediaPlayer:setLooping	(Z)V
    //   523: aload_0
    //   524: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   527: invokevirtual 275	android/media/MediaPlayer:prepare	()V
    //   530: aload_0
    //   531: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   534: invokevirtual 298	android/media/MediaPlayer:start	()V
    //   537: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   540: aload_0
    //   541: getfield 379	com/tencent/mm/plugin/voip/video/e:NZU	J
    //   544: lsub
    //   545: ldc2_w 452
    //   548: lcmp
    //   549: ifle +8 -> 557
    //   552: aload_0
    //   553: iconst_3
    //   554: putfield 61	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   557: aload_0
    //   558: iconst_1
    //   559: putfield 58	com/tencent/mm/plugin/voip/video/e:isStarted	Z
    //   562: ldc_w 303
    //   565: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   568: return
    //   569: iconst_0
    //   570: istore 7
    //   572: goto -196 -> 376
    //   575: iload_3
    //   576: ifne +8 -> 584
    //   579: iload 8
    //   581: ifeq +56 -> 637
    //   584: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   587: getfield 456	com/tencent/mm/compatible/deviceinfo/b:jou	I
    //   590: iflt +346 -> 936
    //   593: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   596: getfield 456	com/tencent/mm/compatible/deviceinfo/b:jou	I
    //   599: istore_1
    //   600: goto +360 -> 960
    //   603: aload_0
    //   604: iconst_0
    //   605: invokevirtual 280	com/tencent/mm/plugin/voip/video/e:Bo	(Z)V
    //   608: goto -185 -> 423
    //   611: iconst_3
    //   612: istore_1
    //   613: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   616: getfield 459	com/tencent/mm/compatible/deviceinfo/b:jor	I
    //   619: iflt +10 -> 629
    //   622: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   625: getfield 459	com/tencent/mm/compatible/deviceinfo/b:jor	I
    //   628: istore_1
    //   629: aload_0
    //   630: iconst_1
    //   631: invokevirtual 280	com/tencent/mm/plugin/voip/video/e:Bo	(Z)V
    //   634: goto -211 -> 423
    //   637: invokestatic 415	com/tencent/mm/plugin/audio/c/a:cro	()Z
    //   640: ifne +291 -> 931
    //   643: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   646: getfield 462	com/tencent/mm/compatible/deviceinfo/b:jow	I
    //   649: iflt +282 -> 931
    //   652: getstatic 228	com/tencent/mm/compatible/deviceinfo/af:juI	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   655: getfield 462	com/tencent/mm/compatible/deviceinfo/b:jow	I
    //   658: istore_1
    //   659: aload_0
    //   660: iconst_1
    //   661: invokevirtual 280	com/tencent/mm/plugin/voip/video/e:Bo	(Z)V
    //   664: goto -241 -> 423
    //   667: aload_0
    //   668: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   671: iload_1
    //   672: invokevirtual 465	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   675: goto +272 -> 947
    //   678: astore 9
    //   680: ldc 151
    //   682: new 359	java/lang/StringBuilder
    //   685: dup
    //   686: ldc_w 467
    //   689: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   692: aload 9
    //   694: invokevirtual 468	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   697: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: aload_0
    //   707: iconst_2
    //   708: putfield 61	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   711: aload_0
    //   712: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   715: iconst_1
    //   716: invokestatic 259	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   719: astore 9
    //   721: aload_0
    //   722: aload_0
    //   723: getfield 76	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   726: aload 9
    //   728: invokestatic 265	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   731: putfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   734: aload_0
    //   735: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   738: astore 9
    //   740: aload 9
    //   742: ifnonnull +77 -> 819
    //   745: ldc_w 303
    //   748: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   751: return
    //   752: iload_3
    //   753: ifeq +54 -> 807
    //   756: aload_0
    //   757: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   760: ldc_w 281
    //   763: ldc_w 281
    //   766: invokevirtual 285	android/media/MediaPlayer:setVolume	(FF)V
    //   769: goto -254 -> 515
    //   772: astore 9
    //   774: ldc 151
    //   776: new 359	java/lang/StringBuilder
    //   779: dup
    //   780: ldc_w 470
    //   783: invokespecial 364	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   786: aload 9
    //   788: invokevirtual 471	java/lang/Exception:toString	()Ljava/lang/String;
    //   791: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: ldc_w 303
    //   803: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   806: return
    //   807: iload 6
    //   809: ifeq -294 -> 515
    //   812: aload_0
    //   813: invokespecial 287	com/tencent/mm/plugin/voip/video/e:gDv	()V
    //   816: goto -301 -> 515
    //   819: aload_0
    //   820: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   823: invokevirtual 272	android/media/MediaPlayer:stop	()V
    //   826: aload_0
    //   827: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   830: invokevirtual 275	android/media/MediaPlayer:prepare	()V
    //   833: aload_0
    //   834: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   837: iconst_1
    //   838: invokevirtual 278	android/media/MediaPlayer:setLooping	(Z)V
    //   841: iload_3
    //   842: ifeq +52 -> 894
    //   845: aload_0
    //   846: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   849: ldc_w 281
    //   852: ldc_w 281
    //   855: invokevirtual 285	android/media/MediaPlayer:setVolume	(FF)V
    //   858: aload_0
    //   859: getfield 267	com/tencent/mm/plugin/voip/video/e:NZS	Landroid/media/MediaPlayer;
    //   862: invokevirtual 298	android/media/MediaPlayer:start	()V
    //   865: aload_0
    //   866: iconst_0
    //   867: putfield 61	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   870: goto -313 -> 557
    //   873: astore 9
    //   875: ldc_w 289
    //   878: aload 9
    //   880: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   883: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: aload_0
    //   887: iconst_2
    //   888: putfield 61	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   891: goto -334 -> 557
    //   894: iload 6
    //   896: ifeq -38 -> 858
    //   899: aload_0
    //   900: invokespecial 287	com/tencent/mm/plugin/voip/video/e:gDv	()V
    //   903: goto -45 -> 858
    //   906: iload 6
    //   908: ifeq +11 -> 919
    //   911: iload_3
    //   912: ifne +7 -> 919
    //   915: aload_0
    //   916: invokespecial 287	com/tencent/mm/plugin/voip/video/e:gDv	()V
    //   919: ldc_w 303
    //   922: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   925: return
    //   926: astore 9
    //   928: goto -721 -> 207
    //   931: iconst_2
    //   932: istore_1
    //   933: goto -274 -> 659
    //   936: iconst_0
    //   937: istore_1
    //   938: goto +22 -> 960
    //   941: iconst_1
    //   942: istore 6
    //   944: goto -905 -> 39
    //   947: iload 8
    //   949: ifne -477 -> 472
    //   952: iload 7
    //   954: ifeq -202 -> 752
    //   957: goto -485 -> 472
    //   960: iload 8
    //   962: ifne -359 -> 603
    //   965: iload_2
    //   966: iconst_1
    //   967: if_icmpne -356 -> 611
    //   970: goto -367 -> 603
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	973	0	this	e
    //   0	973	1	paramInt1	int
    //   0	973	2	paramInt2	int
    //   0	973	3	paramBoolean	boolean
    //   488	12	4	i	int
    //   479	27	5	j	int
    //   37	906	6	bool1	boolean
    //   55	898	7	bool2	boolean
    //   50	911	8	bool3	boolean
    //   202	18	9	localException1	Exception
    //   678	15	9	localThrowable	Throwable
    //   719	22	9	localObject	Object
    //   772	15	9	localException2	Exception
    //   873	6	9	localException3	Exception
    //   926	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   6	12	202	java/lang/Exception
    //   16	39	202	java/lang/Exception
    //   142	165	202	java/lang/Exception
    //   284	373	678	java/lang/Throwable
    //   376	409	678	java/lang/Throwable
    //   414	423	678	java/lang/Throwable
    //   423	469	678	java/lang/Throwable
    //   472	490	678	java/lang/Throwable
    //   493	507	678	java/lang/Throwable
    //   507	515	678	java/lang/Throwable
    //   515	557	678	java/lang/Throwable
    //   584	600	678	java/lang/Throwable
    //   603	608	678	java/lang/Throwable
    //   613	629	678	java/lang/Throwable
    //   629	634	678	java/lang/Throwable
    //   637	659	678	java/lang/Throwable
    //   659	664	678	java/lang/Throwable
    //   667	675	678	java/lang/Throwable
    //   756	769	678	java/lang/Throwable
    //   812	816	678	java/lang/Throwable
    //   266	284	772	java/lang/Exception
    //   284	373	772	java/lang/Exception
    //   376	409	772	java/lang/Exception
    //   414	423	772	java/lang/Exception
    //   423	469	772	java/lang/Exception
    //   472	490	772	java/lang/Exception
    //   493	507	772	java/lang/Exception
    //   507	515	772	java/lang/Exception
    //   515	557	772	java/lang/Exception
    //   557	562	772	java/lang/Exception
    //   584	600	772	java/lang/Exception
    //   603	608	772	java/lang/Exception
    //   613	629	772	java/lang/Exception
    //   629	634	772	java/lang/Exception
    //   637	659	772	java/lang/Exception
    //   659	664	772	java/lang/Exception
    //   667	675	772	java/lang/Exception
    //   680	711	772	java/lang/Exception
    //   756	769	772	java/lang/Exception
    //   812	816	772	java/lang/Exception
    //   875	891	772	java/lang/Exception
    //   711	740	873	java/lang/Exception
    //   819	841	873	java/lang/Exception
    //   845	858	873	java/lang/Exception
    //   858	870	873	java/lang/Exception
    //   899	903	873	java/lang/Exception
    //   39	57	926	java/lang/Exception
    //   57	100	926	java/lang/Exception
    //   168	186	926	java/lang/Exception
    //   189	199	926	java/lang/Exception
  }
  
  public final void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(237046);
    this.NZT = 0;
    if (paramInt1 == 0)
    {
      Bp(paramBoolean);
      AppMethodBeat.o(237046);
      return;
    }
    L(paramInt1, paramInt2, paramBoolean);
    AppMethodBeat.o(237046);
  }
  
  public final void a(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(115690);
    this.NZU = System.currentTimeMillis();
    this.NZS = new k();
    try
    {
      this.NZS.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.NZS.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115679);
          if (System.currentTimeMillis() - e.this.NZU > 70000L) {
            e.this.NZT = 4;
          }
          if (e.this.isStarted)
          {
            e.this.NZW = new e.a(e.this, paramInt1, paramLong, paramInt2, this.val$streamType);
            e.this.knk.postDelayed(e.this.NZW, paramLong);
          }
          AppMethodBeat.o(115679);
        }
      });
      this.NZS.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115680);
          e.this.NZT = 1;
          Log.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(115680);
          return false;
        }
      });
      this.NZS.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.NZS.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.NZS.setLooping(false);
        this.NZS.prepare();
        this.NZS.start();
        if (System.currentTimeMillis() - this.NZU > 2000L) {
          this.NZT = 3;
        }
        AppMethodBeat.o(115690);
        return;
        gDv();
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(115690);
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(237047);
    if (((paramInt1 == b.f.playend) || (paramInt1 == b.f.close_lower_volume)) && (!com.tencent.mm.plugin.audio.c.a.cro()) && (!com.tencent.mm.plugin.audio.c.a.crh()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(237047);
      return;
    }
    boolean bool = this.mContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_shake", true);
    if (paramBoolean1) {
      Util.shake(this.mContext, bool);
    }
    Log.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.NZV = System.currentTimeMillis();
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
          if (System.currentTimeMillis() - e.this.NZV > 5000L) {
            e.this.NZT = 8;
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
            e.this.NZT = 5;
            Log.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(115682);
          return false;
        }
      });
      Bo(com.tencent.mm.plugin.audio.c.a.crl());
      if (paramBoolean2)
      {
        if (!com.tencent.mm.plugin.audio.c.a.cro()) {
          break label361;
        }
        paramInt2 = com.tencent.mm.plugin.audio.c.a.cri();
        localk.setAudioStreamType(paramInt2);
        if (!d.qX(28)) {
          break label366;
        }
        localk.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(paramInt2).setContentType(4).build());
        Log.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
      }
      for (;;)
      {
        if ((paramInt1 == b.f.playend) && ((com.tencent.mm.plugin.audio.c.a.cro()) || (com.tencent.mm.plugin.audio.c.a.crh()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.NZV > 2000L) {
          this.NZT = 7;
        }
        AppMethodBeat.o(237047);
        return;
        label361:
        paramInt2 = 0;
        break;
        label366:
        localk.setAudioStreamType(paramInt2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
      this.NZT = 6;
      AppMethodBeat.o(237047);
    }
  }
  
  public final boolean adI()
  {
    return !this.isStarted;
  }
  
  public final int gDx()
  {
    AppMethodBeat.i(115696);
    Log.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.NZT);
    int i = this.NZT;
    AppMethodBeat.o(115696);
    return i;
  }
  
  public final void i(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(237048);
    a(paramInt1, paramBoolean, paramInt2, true);
    AppMethodBeat.o(237048);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115688);
    Log.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.isStarted) });
    gDw();
    if ((this.NZS == null) || (!this.isStarted))
    {
      AppMethodBeat.o(115688);
      return;
    }
    try
    {
      this.NZS.stop();
      this.NZS.release();
      if (this.NZW != null) {
        this.knk.removeCallbacks(this.NZW);
      }
      this.isStarted = false;
      com.tencent.mm.plugin.audio.c.a.crg();
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
    private boolean Oab;
    private long interval;
    private int resId;
    private int streamType;
    
    public a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.resId = paramInt1;
      this.interval = paramLong;
      this.Oab = paramBoolean;
      this.streamType = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(115685);
      e.this.a(this.resId, this.interval, this.Oab, this.streamType);
      AppMethodBeat.o(115685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */