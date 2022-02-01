package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
{
  public MediaPlayer AOR;
  public int AOS;
  public long AOT;
  public long AOU;
  a AOV;
  public boolean aKd;
  ao gox;
  private com.tencent.mm.compatible.util.b ied;
  private AudioManager mAudioManager;
  public Context mContext;
  private Vibrator mtQ;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(115686);
    this.aKd = false;
    this.AOS = 65536;
    this.gox = new ao(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = com.tencent.mm.plugin.audio.c.a.bCx().audioManager;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.mtQ = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.ied = new com.tencent.mm.compatible.util.b(ai.getContext());
    AppMethodBeat.o(115686);
  }
  
  private void emH()
  {
    AppMethodBeat.i(115691);
    Object localObject = this.mContext.getSharedPreferences(ai.eUX(), 0);
    boolean bool;
    if (d.kZ(26)) {
      bool = ((SharedPreferences)localObject).getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      ac.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.mtQ = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.mtQ == null)
        {
          AppMethodBeat.o(115691);
          return;
          bool = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
        }
        else
        {
          if (d.kZ(26))
          {
            localObject = new AudioAttributes.Builder().setUsage(7).build();
            this.mtQ.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
            AppMethodBeat.o(115691);
            return;
          }
          this.mtQ.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
          AppMethodBeat.o(115691);
        }
      }
      else
      {
        ac.i("MicroMsg.RingPlayer", "system not open vibrate");
      }
    }
    AppMethodBeat.o(115691);
  }
  
  private void emI()
  {
    AppMethodBeat.i(115692);
    if (this.mtQ != null)
    {
      this.mtQ.cancel();
      this.mtQ = null;
    }
    AppMethodBeat.o(115692);
  }
  
  /* Error */
  public final void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 213	com/tencent/mm/sdk/platformtools/ai:ciE	()Z
    //   8: ifeq +908 -> 916
    //   11: iload_2
    //   12: ifne +116 -> 128
    //   15: invokestatic 219	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   18: invokevirtual 225	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   21: ldc 226
    //   23: getstatic 232	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   26: invokevirtual 238	com/tencent/mm/storage/ae:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 228	java/lang/Boolean
    //   32: invokevirtual 241	java/lang/Boolean:booleanValue	()Z
    //   35: istore 6
    //   37: bipush 28
    //   39: invokestatic 244	com/tencent/mm/compatible/util/d:lb	(I)Z
    //   42: ifeq +122 -> 164
    //   45: invokestatic 249	com/tencent/mm/m/a:Zl	()Z
    //   48: istore 8
    //   50: invokestatic 252	com/tencent/mm/m/a:Zm	()Z
    //   53: istore 7
    //   55: ldc 151
    //   57: ldc 254
    //   59: iconst_4
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload 6
    //   67: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: iload 8
    //   75: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: iload 7
    //   83: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: dup
    //   88: iconst_3
    //   89: iload_3
    //   90: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   93: aastore
    //   94: invokestatic 164	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: iload 7
    //   99: istore 6
    //   101: iload_3
    //   102: ifeq +10 -> 112
    //   105: iconst_1
    //   106: istore 8
    //   108: iload 7
    //   110: istore 6
    //   112: iload 8
    //   114: ifne +129 -> 243
    //   117: iload 6
    //   119: ifne +124 -> 243
    //   122: ldc 209
    //   124: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: return
    //   128: iload_2
    //   129: iconst_1
    //   130: if_icmpeq +8 -> 138
    //   133: iload_2
    //   134: iconst_2
    //   135: if_icmpne +781 -> 916
    //   138: invokestatic 219	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   141: invokevirtual 225	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   144: ldc_w 258
    //   147: getstatic 232	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   150: invokevirtual 238	com/tencent/mm/storage/ae:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 228	java/lang/Boolean
    //   156: invokevirtual 241	java/lang/Boolean:booleanValue	()Z
    //   159: istore 6
    //   161: goto -124 -> 37
    //   164: bipush 26
    //   166: invokestatic 137	com/tencent/mm/compatible/util/d:kZ	(I)Z
    //   169: ifeq +16 -> 185
    //   172: invokestatic 261	com/tencent/mm/m/a:Zs	()Z
    //   175: istore 8
    //   177: invokestatic 264	com/tencent/mm/m/a:Zt	()Z
    //   180: istore 7
    //   182: goto -127 -> 55
    //   185: invokestatic 267	com/tencent/mm/m/a:Zj	()Z
    //   188: istore 8
    //   190: invokestatic 270	com/tencent/mm/m/a:Zn	()Z
    //   193: istore 7
    //   195: goto -140 -> 55
    //   198: astore 9
    //   200: iconst_1
    //   201: istore 6
    //   203: ldc 151
    //   205: new 272	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 274
    //   212: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload 9
    //   217: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 290	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_1
    //   230: istore 7
    //   232: iload 6
    //   234: istore 8
    //   236: iload 7
    //   238: istore 6
    //   240: goto -128 -> 112
    //   243: aload_0
    //   244: getfield 58	com/tencent/mm/plugin/voip/video/i:aKd	Z
    //   247: ifeq +9 -> 256
    //   250: ldc 209
    //   252: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: return
    //   256: iload 8
    //   258: ifeq +624 -> 882
    //   261: aload_0
    //   262: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   265: putfield 298	com/tencent/mm/plugin/voip/video/i:AOT	J
    //   268: aload_0
    //   269: new 300	com/tencent/mm/compatible/b/k
    //   272: dup
    //   273: invokespecial 301	com/tencent/mm/compatible/b/k:<init>	()V
    //   276: putfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   279: aload_0
    //   280: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   283: aload_0
    //   284: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   287: new 272	java/lang/StringBuilder
    //   290: dup
    //   291: ldc_w 305
    //   294: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: aload_0
    //   298: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   301: invokevirtual 308	android/content/Context:getPackageName	()Ljava/lang/String;
    //   304: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 310
    //   310: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload_1
    //   314: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 319	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   323: invokevirtual 325	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   326: aload_0
    //   327: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   330: new 6	com/tencent/mm/plugin/voip/video/i$1
    //   333: dup
    //   334: aload_0
    //   335: invokespecial 328	com/tencent/mm/plugin/voip/video/i$1:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   338: invokevirtual 332	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   341: aload_0
    //   342: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   345: new 8	com/tencent/mm/plugin/voip/video/i$2
    //   348: dup
    //   349: aload_0
    //   350: invokespecial 333	com/tencent/mm/plugin/voip/video/i$2:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   353: invokevirtual 337	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   356: invokestatic 340	com/tencent/mm/plugin/audio/c/a:bCy	()Z
    //   359: istore 7
    //   361: invokestatic 343	com/tencent/mm/plugin/audio/c/a:bCs	()Z
    //   364: istore 8
    //   366: ldc 151
    //   368: ldc_w 345
    //   371: iconst_2
    //   372: anewarray 4	java/lang/Object
    //   375: dup
    //   376: iconst_0
    //   377: iload 7
    //   379: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: iload 8
    //   387: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   390: aastore
    //   391: invokestatic 348	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: iload 7
    //   396: ifeq +157 -> 553
    //   399: invokestatic 351	com/tencent/mm/plugin/audio/c/a:bCt	()I
    //   402: istore_1
    //   403: aload_0
    //   404: iconst_0
    //   405: invokevirtual 355	com/tencent/mm/plugin/voip/video/i:sX	(Z)V
    //   408: bipush 28
    //   410: invokestatic 244	com/tencent/mm/compatible/util/d:lb	(I)Z
    //   413: ifeq +232 -> 645
    //   416: aload_0
    //   417: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   420: new 168	android/media/AudioAttributes$Builder
    //   423: dup
    //   424: invokespecial 169	android/media/AudioAttributes$Builder:<init>	()V
    //   427: bipush 6
    //   429: invokevirtual 173	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   432: iload_1
    //   433: invokevirtual 358	android/media/AudioAttributes$Builder:setLegacyStreamType	(I)Landroid/media/AudioAttributes$Builder;
    //   436: iconst_4
    //   437: invokevirtual 361	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   440: invokevirtual 177	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   443: invokevirtual 365	android/media/MediaPlayer:setAudioAttributes	(Landroid/media/AudioAttributes;)V
    //   446: ldc 151
    //   448: ldc_w 367
    //   451: invokestatic 197	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: goto +468 -> 922
    //   457: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bCx	()Lcom/tencent/mm/plugin/audio/b/a;
    //   460: iload_1
    //   461: invokevirtual 371	com/tencent/mm/plugin/audio/b/a:getStreamMaxVolume	(I)I
    //   464: istore 5
    //   466: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bCx	()Lcom/tencent/mm/plugin/audio/b/a;
    //   469: iload_1
    //   470: invokevirtual 374	com/tencent/mm/plugin/audio/b/a:getStreamVolume	(I)I
    //   473: istore 4
    //   475: iload 4
    //   477: istore_2
    //   478: iload 4
    //   480: iload 5
    //   482: iconst_2
    //   483: idiv
    //   484: if_icmple +8 -> 492
    //   487: iload 5
    //   489: iconst_2
    //   490: idiv
    //   491: istore_2
    //   492: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bCx	()Lcom/tencent/mm/plugin/audio/b/a;
    //   495: iload_1
    //   496: iload_2
    //   497: invokevirtual 378	com/tencent/mm/plugin/audio/b/a:eA	(II)V
    //   500: aload_0
    //   501: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   504: iconst_1
    //   505: invokevirtual 381	android/media/MediaPlayer:setLooping	(Z)V
    //   508: aload_0
    //   509: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   512: invokevirtual 384	android/media/MediaPlayer:prepare	()V
    //   515: aload_0
    //   516: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   519: invokevirtual 387	android/media/MediaPlayer:start	()V
    //   522: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   525: aload_0
    //   526: getfield 298	com/tencent/mm/plugin/voip/video/i:AOT	J
    //   529: lsub
    //   530: ldc2_w 388
    //   533: lcmp
    //   534: ifle +8 -> 542
    //   537: aload_0
    //   538: iconst_3
    //   539: putfield 61	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   542: aload_0
    //   543: iconst_1
    //   544: putfield 58	com/tencent/mm/plugin/voip/video/i:aKd	Z
    //   547: ldc 209
    //   549: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: return
    //   553: iload_3
    //   554: ifne +8 -> 562
    //   557: iload 8
    //   559: ifeq +56 -> 615
    //   562: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   565: getfield 400	com/tencent/mm/compatible/deviceinfo/b:fDz	I
    //   568: iflt +343 -> 911
    //   571: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   574: getfield 400	com/tencent/mm/compatible/deviceinfo/b:fDz	I
    //   577: istore_1
    //   578: goto +357 -> 935
    //   581: aload_0
    //   582: iconst_0
    //   583: invokevirtual 355	com/tencent/mm/plugin/voip/video/i:sX	(Z)V
    //   586: goto -178 -> 408
    //   589: iconst_3
    //   590: istore_1
    //   591: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   594: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fDw	I
    //   597: iflt +10 -> 607
    //   600: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   603: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fDw	I
    //   606: istore_1
    //   607: aload_0
    //   608: iconst_1
    //   609: invokevirtual 355	com/tencent/mm/plugin/voip/video/i:sX	(Z)V
    //   612: goto -204 -> 408
    //   615: invokestatic 340	com/tencent/mm/plugin/audio/c/a:bCy	()Z
    //   618: ifne +288 -> 906
    //   621: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   624: getfield 406	com/tencent/mm/compatible/deviceinfo/b:fDB	I
    //   627: iflt +279 -> 906
    //   630: getstatic 395	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   633: getfield 406	com/tencent/mm/compatible/deviceinfo/b:fDB	I
    //   636: istore_1
    //   637: aload_0
    //   638: iconst_1
    //   639: invokevirtual 355	com/tencent/mm/plugin/voip/video/i:sX	(Z)V
    //   642: goto -234 -> 408
    //   645: aload_0
    //   646: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   649: iload_1
    //   650: invokevirtual 409	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   653: goto +269 -> 922
    //   656: astore 9
    //   658: ldc 151
    //   660: new 272	java/lang/StringBuilder
    //   663: dup
    //   664: ldc_w 411
    //   667: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: aload 9
    //   672: invokevirtual 412	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   675: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 290	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload_0
    //   685: iconst_2
    //   686: putfield 61	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   689: aload_0
    //   690: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   693: iconst_1
    //   694: invokestatic 418	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   697: astore 9
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   704: aload 9
    //   706: invokestatic 421	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   709: putfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   712: aload_0
    //   713: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   716: astore 9
    //   718: aload 9
    //   720: ifnonnull +75 -> 795
    //   723: ldc 209
    //   725: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   728: return
    //   729: iload_3
    //   730: ifeq +53 -> 783
    //   733: aload_0
    //   734: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   737: ldc_w 422
    //   740: ldc_w 422
    //   743: invokevirtual 426	android/media/MediaPlayer:setVolume	(FF)V
    //   746: goto -246 -> 500
    //   749: astore 9
    //   751: ldc 151
    //   753: new 272	java/lang/StringBuilder
    //   756: dup
    //   757: ldc_w 428
    //   760: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   763: aload 9
    //   765: invokevirtual 429	java/lang/Exception:toString	()Ljava/lang/String;
    //   768: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 290	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: ldc 209
    //   779: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   782: return
    //   783: iload 6
    //   785: ifeq -285 -> 500
    //   788: aload_0
    //   789: invokespecial 431	com/tencent/mm/plugin/voip/video/i:emH	()V
    //   792: goto -292 -> 500
    //   795: aload_0
    //   796: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   799: invokevirtual 434	android/media/MediaPlayer:stop	()V
    //   802: aload_0
    //   803: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   806: invokevirtual 384	android/media/MediaPlayer:prepare	()V
    //   809: aload_0
    //   810: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   813: iconst_1
    //   814: invokevirtual 381	android/media/MediaPlayer:setLooping	(Z)V
    //   817: iload_3
    //   818: ifeq +52 -> 870
    //   821: aload_0
    //   822: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   825: ldc_w 422
    //   828: ldc_w 422
    //   831: invokevirtual 426	android/media/MediaPlayer:setVolume	(FF)V
    //   834: aload_0
    //   835: getfield 303	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
    //   838: invokevirtual 387	android/media/MediaPlayer:start	()V
    //   841: aload_0
    //   842: iconst_0
    //   843: putfield 61	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   846: goto -304 -> 542
    //   849: astore 9
    //   851: ldc_w 436
    //   854: aload 9
    //   856: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   859: invokestatic 290	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   862: aload_0
    //   863: iconst_2
    //   864: putfield 61	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   867: goto -325 -> 542
    //   870: iload 6
    //   872: ifeq -38 -> 834
    //   875: aload_0
    //   876: invokespecial 431	com/tencent/mm/plugin/voip/video/i:emH	()V
    //   879: goto -45 -> 834
    //   882: iload 6
    //   884: ifeq +11 -> 895
    //   887: iload_3
    //   888: ifne +7 -> 895
    //   891: aload_0
    //   892: invokespecial 431	com/tencent/mm/plugin/voip/video/i:emH	()V
    //   895: ldc 209
    //   897: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   900: return
    //   901: astore 9
    //   903: goto -700 -> 203
    //   906: iconst_2
    //   907: istore_1
    //   908: goto -271 -> 637
    //   911: iconst_0
    //   912: istore_1
    //   913: goto +22 -> 935
    //   916: iconst_1
    //   917: istore 6
    //   919: goto -882 -> 37
    //   922: iload 8
    //   924: ifne -467 -> 457
    //   927: iload 7
    //   929: ifeq -200 -> 729
    //   932: goto -475 -> 457
    //   935: iload 8
    //   937: ifne -356 -> 581
    //   940: iload_2
    //   941: iconst_1
    //   942: if_icmpne -353 -> 589
    //   945: goto -364 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	i
    //   0	948	1	paramInt1	int
    //   0	948	2	paramInt2	int
    //   0	948	3	paramBoolean	boolean
    //   473	12	4	i	int
    //   464	27	5	j	int
    //   35	883	6	bool1	boolean
    //   53	875	7	bool2	boolean
    //   48	888	8	bool3	boolean
    //   198	18	9	localException1	Exception
    //   656	15	9	localThrowable	Throwable
    //   697	22	9	localObject	Object
    //   749	15	9	localException2	Exception
    //   849	6	9	localException3	Exception
    //   901	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   5	11	198	java/lang/Exception
    //   15	37	198	java/lang/Exception
    //   138	161	198	java/lang/Exception
    //   279	394	656	java/lang/Throwable
    //   399	408	656	java/lang/Throwable
    //   408	454	656	java/lang/Throwable
    //   457	475	656	java/lang/Throwable
    //   478	492	656	java/lang/Throwable
    //   492	500	656	java/lang/Throwable
    //   500	542	656	java/lang/Throwable
    //   562	578	656	java/lang/Throwable
    //   581	586	656	java/lang/Throwable
    //   591	607	656	java/lang/Throwable
    //   607	612	656	java/lang/Throwable
    //   615	637	656	java/lang/Throwable
    //   637	642	656	java/lang/Throwable
    //   645	653	656	java/lang/Throwable
    //   733	746	656	java/lang/Throwable
    //   788	792	656	java/lang/Throwable
    //   261	279	749	java/lang/Exception
    //   279	394	749	java/lang/Exception
    //   399	408	749	java/lang/Exception
    //   408	454	749	java/lang/Exception
    //   457	475	749	java/lang/Exception
    //   478	492	749	java/lang/Exception
    //   492	500	749	java/lang/Exception
    //   500	542	749	java/lang/Exception
    //   542	547	749	java/lang/Exception
    //   562	578	749	java/lang/Exception
    //   581	586	749	java/lang/Exception
    //   591	607	749	java/lang/Exception
    //   607	612	749	java/lang/Exception
    //   615	637	749	java/lang/Exception
    //   637	642	749	java/lang/Exception
    //   645	653	749	java/lang/Exception
    //   658	689	749	java/lang/Exception
    //   733	746	749	java/lang/Exception
    //   788	792	749	java/lang/Exception
    //   851	867	749	java/lang/Exception
    //   689	718	849	java/lang/Exception
    //   795	817	849	java/lang/Exception
    //   821	834	849	java/lang/Exception
    //   834	846	849	java/lang/Exception
    //   875	879	849	java/lang/Exception
    //   37	55	901	java/lang/Exception
    //   55	97	901	java/lang/Exception
    //   164	182	901	java/lang/Exception
    //   185	195	901	java/lang/Exception
  }
  
  public final boolean Na()
  {
    return !this.aKd;
  }
  
  public final void T(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(208521);
    a(2131691034, paramBoolean, paramInt, true);
    AppMethodBeat.o(208521);
  }
  
  public final void a(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(115690);
    this.AOT = System.currentTimeMillis();
    this.AOR = new k();
    try
    {
      this.AOR.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.AOR.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115679);
          if (System.currentTimeMillis() - i.this.AOT > 70000L) {
            i.this.AOS = 4;
          }
          if (i.this.aKd)
          {
            i.this.AOV = new i.a(i.this, paramInt1, paramLong, paramInt2, this.val$streamType);
            i.this.gox.postDelayed(i.this.AOV, paramLong);
          }
          AppMethodBeat.o(115679);
        }
      });
      this.AOR.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115680);
          i.this.AOS = 1;
          ac.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(115680);
          return false;
        }
      });
      this.AOR.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.AOR.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.AOR.setLooping(false);
        this.AOR.prepare();
        this.AOR.start();
        if (System.currentTimeMillis() - this.AOT > 2000L) {
          this.AOS = 3;
        }
        AppMethodBeat.o(115690);
        return;
        emH();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(115690);
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(208520);
    if ((paramInt1 == 2131691034) && (!com.tencent.mm.plugin.audio.c.a.bCy()) && (!com.tencent.mm.plugin.audio.c.a.bCs()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(208520);
      return;
    }
    boolean bool = this.mContext.getSharedPreferences(ai.eUX(), 0).getBoolean("settings_shake", true);
    if (paramBoolean1) {
      bs.D(this.mContext, bool);
    }
    ac.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.AOU = System.currentTimeMillis();
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
          if (System.currentTimeMillis() - i.this.AOU > 5000L) {
            i.this.AOS = 8;
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
            i.this.AOS = 5;
            ac.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(115682);
          return false;
        }
      });
      sX(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn());
      if (paramBoolean2)
      {
        if (!com.tencent.mm.plugin.audio.c.a.bCy()) {
          break label354;
        }
        paramInt2 = com.tencent.mm.plugin.audio.c.a.bCt();
        localk.setAudioStreamType(paramInt2);
        if (!d.lb(28)) {
          break label359;
        }
        localk.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(paramInt2).setContentType(4).build());
        ac.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
      }
      for (;;)
      {
        if ((paramInt1 == 2131691034) && ((com.tencent.mm.plugin.audio.c.a.bCy()) || (com.tencent.mm.plugin.audio.c.a.bCs()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.AOU > 2000L) {
          this.AOS = 7;
        }
        AppMethodBeat.o(208520);
        return;
        label354:
        paramInt2 = 0;
        break;
        label359:
        localk.setAudioStreamType(paramInt2);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
      this.AOS = 6;
      AppMethodBeat.o(208520);
    }
  }
  
  public final void aI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115693);
    this.AOS = 0;
    A(2131691029, paramInt, paramBoolean);
    AppMethodBeat.o(115693);
  }
  
  public final int emJ()
  {
    AppMethodBeat.i(115696);
    ac.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.AOS);
    int i = this.AOS;
    AppMethodBeat.o(115696);
    return i;
  }
  
  public final void sX(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(115687);
    ac.m("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (ae.fJe.fDC < 0)) {
        break label174;
      }
      j = ae.fJe.fDC;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        ac.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.plugin.audio.c.a.bCx().b(j, null);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        ac.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.audio.c.a.bCx().ij(paramBoolean);
      }
      AppMethodBeat.o(115687);
      return;
      if (d.kZ(21)) {
        break;
      }
      i = 2;
      break;
      label174:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ae.fJe.fDA >= 0) {
          j = ae.fJe.fDA;
        }
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115688);
    ac.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.aKd) });
    emI();
    if ((this.AOR == null) || (!this.aKd))
    {
      AppMethodBeat.o(115688);
      return;
    }
    try
    {
      this.AOR.stop();
      this.AOR.release();
      if (this.AOV != null) {
        this.gox.removeCallbacks(this.AOV);
      }
      this.aKd = false;
      com.tencent.mm.plugin.audio.c.a.bCr();
      AppMethodBeat.o(115688);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.RingPlayer", localException.toString());
      AppMethodBeat.o(115688);
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean APa;
    private long interval;
    private int resId;
    private int streamType;
    
    public a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.resId = paramInt1;
      this.interval = paramLong;
      this.APa = paramBoolean;
      this.streamType = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(115685);
      i.this.a(this.resId, this.interval, this.APa, this.streamType);
      AppMethodBeat.o(115685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i
 * JD-Core Version:    0.7.0.1
 */