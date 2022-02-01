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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public boolean aJn;
  ap gAC;
  private com.tencent.mm.compatible.util.b hDB;
  private Vibrator lRO;
  private AudioManager mAudioManager;
  public Context mContext;
  public MediaPlayer zwa;
  public int zwb;
  public long zwc;
  public long zwd;
  a zwe;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(115686);
    this.aJn = false;
    this.zwb = 65536;
    this.gAC = new ap(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = com.tencent.mm.plugin.audio.c.a.bvB().audioManager;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.lRO = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.hDB = new com.tencent.mm.compatible.util.b(aj.getContext());
    AppMethodBeat.o(115686);
  }
  
  private void dXm()
  {
    AppMethodBeat.i(115691);
    Object localObject = this.mContext.getSharedPreferences(aj.eFD(), 0);
    boolean bool;
    if (d.lf(26)) {
      bool = ((SharedPreferences)localObject).getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      ad.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.lRO = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.lRO == null)
        {
          AppMethodBeat.o(115691);
          return;
          bool = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
        }
        else
        {
          if (d.lf(26))
          {
            localObject = new AudioAttributes.Builder().setUsage(7).build();
            this.lRO.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
            AppMethodBeat.o(115691);
            return;
          }
          this.lRO.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
          AppMethodBeat.o(115691);
        }
      }
      else
      {
        ad.i("MicroMsg.RingPlayer", "system not open vibrate");
      }
    }
    AppMethodBeat.o(115691);
  }
  
  private void dXn()
  {
    AppMethodBeat.i(115692);
    if (this.lRO != null)
    {
      this.lRO.cancel();
      this.lRO = null;
    }
    AppMethodBeat.o(115692);
  }
  
  /* Error */
  public final void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_2
    //   6: ifne +112 -> 118
    //   9: invokestatic 215	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   12: invokevirtual 221	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   15: ldc 222
    //   17: getstatic 228	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   20: invokevirtual 234	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 224	java/lang/Boolean
    //   26: invokevirtual 238	java/lang/Boolean:booleanValue	()Z
    //   29: istore 6
    //   31: bipush 28
    //   33: invokestatic 241	com/tencent/mm/compatible/util/d:lh	(I)Z
    //   36: ifeq +117 -> 153
    //   39: invokestatic 246	com/tencent/mm/m/a:Yo	()Z
    //   42: istore 8
    //   44: invokestatic 249	com/tencent/mm/m/a:Yp	()Z
    //   47: istore 7
    //   49: ldc 151
    //   51: ldc 251
    //   53: iconst_4
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: iload 6
    //   61: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: iload 8
    //   69: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: iload 7
    //   77: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   80: aastore
    //   81: dup
    //   82: iconst_3
    //   83: iload_3
    //   84: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   87: aastore
    //   88: invokestatic 164	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: iload_3
    //   92: ifeq +6 -> 98
    //   95: iconst_1
    //   96: istore 8
    //   98: iload 8
    //   100: istore 6
    //   102: iload 6
    //   104: ifne +120 -> 224
    //   107: iload 7
    //   109: ifne +115 -> 224
    //   112: ldc 209
    //   114: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: return
    //   118: iload_2
    //   119: iconst_1
    //   120: if_icmpeq +8 -> 128
    //   123: iload_2
    //   124: iconst_2
    //   125: if_icmpne +772 -> 897
    //   128: invokestatic 215	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
    //   131: invokevirtual 221	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
    //   134: ldc 255
    //   136: getstatic 228	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   139: invokevirtual 234	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 224	java/lang/Boolean
    //   145: invokevirtual 238	java/lang/Boolean:booleanValue	()Z
    //   148: istore 6
    //   150: goto -119 -> 31
    //   153: bipush 26
    //   155: invokestatic 137	com/tencent/mm/compatible/util/d:lf	(I)Z
    //   158: ifeq +16 -> 174
    //   161: invokestatic 258	com/tencent/mm/m/a:Yv	()Z
    //   164: istore 8
    //   166: invokestatic 261	com/tencent/mm/m/a:Yw	()Z
    //   169: istore 7
    //   171: goto -122 -> 49
    //   174: invokestatic 264	com/tencent/mm/m/a:Ym	()Z
    //   177: istore 8
    //   179: invokestatic 267	com/tencent/mm/m/a:Yq	()Z
    //   182: istore 7
    //   184: goto -135 -> 49
    //   187: astore 9
    //   189: iconst_1
    //   190: istore 6
    //   192: ldc 151
    //   194: new 269	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 271
    //   201: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: aload 9
    //   206: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: iconst_1
    //   219: istore 7
    //   221: goto -119 -> 102
    //   224: aload_0
    //   225: getfield 58	com/tencent/mm/plugin/voip/video/i:aJn	Z
    //   228: ifeq +9 -> 237
    //   231: ldc 209
    //   233: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: return
    //   237: iload 6
    //   239: ifeq +624 -> 863
    //   242: aload_0
    //   243: invokestatic 293	java/lang/System:currentTimeMillis	()J
    //   246: putfield 295	com/tencent/mm/plugin/voip/video/i:zwc	J
    //   249: aload_0
    //   250: new 297	com/tencent/mm/compatible/b/k
    //   253: dup
    //   254: invokespecial 298	com/tencent/mm/compatible/b/k:<init>	()V
    //   257: putfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   260: aload_0
    //   261: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   264: aload_0
    //   265: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   268: new 269	java/lang/StringBuilder
    //   271: dup
    //   272: ldc_w 302
    //   275: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   282: invokevirtual 305	android/content/Context:getPackageName	()Ljava/lang/String;
    //   285: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 307
    //   291: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: iload_1
    //   295: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 316	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   304: invokevirtual 322	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   307: aload_0
    //   308: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   311: new 6	com/tencent/mm/plugin/voip/video/i$1
    //   314: dup
    //   315: aload_0
    //   316: invokespecial 325	com/tencent/mm/plugin/voip/video/i$1:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   319: invokevirtual 329	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   322: aload_0
    //   323: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   326: new 8	com/tencent/mm/plugin/voip/video/i$2
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 330	com/tencent/mm/plugin/voip/video/i$2:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   334: invokevirtual 334	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   337: invokestatic 337	com/tencent/mm/plugin/audio/c/a:bvC	()Z
    //   340: istore 6
    //   342: invokestatic 340	com/tencent/mm/plugin/audio/c/a:bvw	()Z
    //   345: istore 8
    //   347: ldc 151
    //   349: ldc_w 342
    //   352: iconst_2
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: iload 6
    //   360: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: aastore
    //   364: dup
    //   365: iconst_1
    //   366: iload 8
    //   368: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   371: aastore
    //   372: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: iload 6
    //   377: ifeq +157 -> 534
    //   380: invokestatic 348	com/tencent/mm/plugin/audio/c/a:bvx	()I
    //   383: istore_1
    //   384: aload_0
    //   385: iconst_0
    //   386: invokevirtual 352	com/tencent/mm/plugin/voip/video/i:rW	(Z)V
    //   389: bipush 28
    //   391: invokestatic 241	com/tencent/mm/compatible/util/d:lh	(I)Z
    //   394: ifeq +232 -> 626
    //   397: aload_0
    //   398: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   401: new 168	android/media/AudioAttributes$Builder
    //   404: dup
    //   405: invokespecial 169	android/media/AudioAttributes$Builder:<init>	()V
    //   408: bipush 6
    //   410: invokevirtual 173	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   413: iload_1
    //   414: invokevirtual 355	android/media/AudioAttributes$Builder:setLegacyStreamType	(I)Landroid/media/AudioAttributes$Builder;
    //   417: iconst_4
    //   418: invokevirtual 358	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   421: invokevirtual 177	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   424: invokevirtual 362	android/media/MediaPlayer:setAudioAttributes	(Landroid/media/AudioAttributes;)V
    //   427: ldc 151
    //   429: ldc_w 364
    //   432: invokestatic 197	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: goto +468 -> 903
    //   438: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bvB	()Lcom/tencent/mm/plugin/audio/b/a;
    //   441: iload_1
    //   442: invokevirtual 368	com/tencent/mm/plugin/audio/b/a:getStreamMaxVolume	(I)I
    //   445: istore 5
    //   447: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bvB	()Lcom/tencent/mm/plugin/audio/b/a;
    //   450: iload_1
    //   451: invokevirtual 371	com/tencent/mm/plugin/audio/b/a:getStreamVolume	(I)I
    //   454: istore 4
    //   456: iload 4
    //   458: istore_2
    //   459: iload 4
    //   461: iload 5
    //   463: iconst_2
    //   464: idiv
    //   465: if_icmple +8 -> 473
    //   468: iload 5
    //   470: iconst_2
    //   471: idiv
    //   472: istore_2
    //   473: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bvB	()Lcom/tencent/mm/plugin/audio/b/a;
    //   476: iload_1
    //   477: iload_2
    //   478: invokevirtual 375	com/tencent/mm/plugin/audio/b/a:ex	(II)V
    //   481: aload_0
    //   482: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   485: iconst_1
    //   486: invokevirtual 378	android/media/MediaPlayer:setLooping	(Z)V
    //   489: aload_0
    //   490: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   493: invokevirtual 381	android/media/MediaPlayer:prepare	()V
    //   496: aload_0
    //   497: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   500: invokevirtual 384	android/media/MediaPlayer:start	()V
    //   503: invokestatic 293	java/lang/System:currentTimeMillis	()J
    //   506: aload_0
    //   507: getfield 295	com/tencent/mm/plugin/voip/video/i:zwc	J
    //   510: lsub
    //   511: ldc2_w 385
    //   514: lcmp
    //   515: ifle +8 -> 523
    //   518: aload_0
    //   519: iconst_3
    //   520: putfield 61	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   523: aload_0
    //   524: iconst_1
    //   525: putfield 58	com/tencent/mm/plugin/voip/video/i:aJn	Z
    //   528: ldc 209
    //   530: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   533: return
    //   534: iload_3
    //   535: ifne +8 -> 543
    //   538: iload 8
    //   540: ifeq +56 -> 596
    //   543: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   546: getfield 397	com/tencent/mm/compatible/deviceinfo/b:fzS	I
    //   549: iflt +343 -> 892
    //   552: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   555: getfield 397	com/tencent/mm/compatible/deviceinfo/b:fzS	I
    //   558: istore_1
    //   559: goto +357 -> 916
    //   562: aload_0
    //   563: iconst_0
    //   564: invokevirtual 352	com/tencent/mm/plugin/voip/video/i:rW	(Z)V
    //   567: goto -178 -> 389
    //   570: iconst_3
    //   571: istore_1
    //   572: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   575: getfield 400	com/tencent/mm/compatible/deviceinfo/b:fzP	I
    //   578: iflt +10 -> 588
    //   581: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   584: getfield 400	com/tencent/mm/compatible/deviceinfo/b:fzP	I
    //   587: istore_1
    //   588: aload_0
    //   589: iconst_1
    //   590: invokevirtual 352	com/tencent/mm/plugin/voip/video/i:rW	(Z)V
    //   593: goto -204 -> 389
    //   596: invokestatic 337	com/tencent/mm/plugin/audio/c/a:bvC	()Z
    //   599: ifne +288 -> 887
    //   602: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   605: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fzU	I
    //   608: iflt +279 -> 887
    //   611: getstatic 392	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   614: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fzU	I
    //   617: istore_1
    //   618: aload_0
    //   619: iconst_1
    //   620: invokevirtual 352	com/tencent/mm/plugin/voip/video/i:rW	(Z)V
    //   623: goto -234 -> 389
    //   626: aload_0
    //   627: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   630: iload_1
    //   631: invokevirtual 406	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   634: goto +269 -> 903
    //   637: astore 9
    //   639: ldc 151
    //   641: new 269	java/lang/StringBuilder
    //   644: dup
    //   645: ldc_w 408
    //   648: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   651: aload 9
    //   653: invokevirtual 409	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   656: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   665: aload_0
    //   666: iconst_2
    //   667: putfield 61	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   670: aload_0
    //   671: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   674: iconst_1
    //   675: invokestatic 415	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   678: astore 9
    //   680: aload_0
    //   681: aload_0
    //   682: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   685: aload 9
    //   687: invokestatic 418	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   690: putfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   693: aload_0
    //   694: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   697: astore 9
    //   699: aload 9
    //   701: ifnonnull +75 -> 776
    //   704: ldc 209
    //   706: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: return
    //   710: iload_3
    //   711: ifeq +53 -> 764
    //   714: aload_0
    //   715: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   718: ldc_w 419
    //   721: ldc_w 419
    //   724: invokevirtual 423	android/media/MediaPlayer:setVolume	(FF)V
    //   727: goto -246 -> 481
    //   730: astore 9
    //   732: ldc 151
    //   734: new 269	java/lang/StringBuilder
    //   737: dup
    //   738: ldc_w 425
    //   741: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   744: aload 9
    //   746: invokevirtual 426	java/lang/Exception:toString	()Ljava/lang/String;
    //   749: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   758: ldc 209
    //   760: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   763: return
    //   764: iload 7
    //   766: ifeq -285 -> 481
    //   769: aload_0
    //   770: invokespecial 428	com/tencent/mm/plugin/voip/video/i:dXm	()V
    //   773: goto -292 -> 481
    //   776: aload_0
    //   777: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   780: invokevirtual 431	android/media/MediaPlayer:stop	()V
    //   783: aload_0
    //   784: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   787: invokevirtual 381	android/media/MediaPlayer:prepare	()V
    //   790: aload_0
    //   791: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   794: iconst_1
    //   795: invokevirtual 378	android/media/MediaPlayer:setLooping	(Z)V
    //   798: iload_3
    //   799: ifeq +52 -> 851
    //   802: aload_0
    //   803: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   806: ldc_w 419
    //   809: ldc_w 419
    //   812: invokevirtual 423	android/media/MediaPlayer:setVolume	(FF)V
    //   815: aload_0
    //   816: getfield 300	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
    //   819: invokevirtual 384	android/media/MediaPlayer:start	()V
    //   822: aload_0
    //   823: iconst_0
    //   824: putfield 61	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   827: goto -304 -> 523
    //   830: astore 9
    //   832: ldc_w 432
    //   835: aload 9
    //   837: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   840: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   843: aload_0
    //   844: iconst_2
    //   845: putfield 61	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   848: goto -325 -> 523
    //   851: iload 7
    //   853: ifeq -38 -> 815
    //   856: aload_0
    //   857: invokespecial 428	com/tencent/mm/plugin/voip/video/i:dXm	()V
    //   860: goto -45 -> 815
    //   863: iload 7
    //   865: ifeq +11 -> 876
    //   868: iload_3
    //   869: ifne +7 -> 876
    //   872: aload_0
    //   873: invokespecial 428	com/tencent/mm/plugin/voip/video/i:dXm	()V
    //   876: ldc 209
    //   878: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: return
    //   882: astore 9
    //   884: goto -692 -> 192
    //   887: iconst_2
    //   888: istore_1
    //   889: goto -271 -> 618
    //   892: iconst_0
    //   893: istore_1
    //   894: goto +22 -> 916
    //   897: iconst_1
    //   898: istore 6
    //   900: goto -869 -> 31
    //   903: iload 8
    //   905: ifne -467 -> 438
    //   908: iload 6
    //   910: ifeq -200 -> 710
    //   913: goto -475 -> 438
    //   916: iload 8
    //   918: ifne -356 -> 562
    //   921: iload_2
    //   922: iconst_1
    //   923: if_icmpne -353 -> 570
    //   926: goto -364 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	929	0	this	i
    //   0	929	1	paramInt1	int
    //   0	929	2	paramInt2	int
    //   0	929	3	paramBoolean	boolean
    //   454	12	4	i	int
    //   445	27	5	j	int
    //   29	880	6	bool1	boolean
    //   47	817	7	bool2	boolean
    //   42	875	8	bool3	boolean
    //   187	18	9	localException1	Exception
    //   637	15	9	localThrowable	Throwable
    //   678	22	9	localObject	Object
    //   730	15	9	localException2	Exception
    //   830	6	9	localException3	Exception
    //   882	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   9	31	187	java/lang/Exception
    //   128	150	187	java/lang/Exception
    //   260	375	637	java/lang/Throwable
    //   380	389	637	java/lang/Throwable
    //   389	435	637	java/lang/Throwable
    //   438	456	637	java/lang/Throwable
    //   459	473	637	java/lang/Throwable
    //   473	481	637	java/lang/Throwable
    //   481	523	637	java/lang/Throwable
    //   543	559	637	java/lang/Throwable
    //   562	567	637	java/lang/Throwable
    //   572	588	637	java/lang/Throwable
    //   588	593	637	java/lang/Throwable
    //   596	618	637	java/lang/Throwable
    //   618	623	637	java/lang/Throwable
    //   626	634	637	java/lang/Throwable
    //   714	727	637	java/lang/Throwable
    //   769	773	637	java/lang/Throwable
    //   242	260	730	java/lang/Exception
    //   260	375	730	java/lang/Exception
    //   380	389	730	java/lang/Exception
    //   389	435	730	java/lang/Exception
    //   438	456	730	java/lang/Exception
    //   459	473	730	java/lang/Exception
    //   473	481	730	java/lang/Exception
    //   481	523	730	java/lang/Exception
    //   523	528	730	java/lang/Exception
    //   543	559	730	java/lang/Exception
    //   562	567	730	java/lang/Exception
    //   572	588	730	java/lang/Exception
    //   588	593	730	java/lang/Exception
    //   596	618	730	java/lang/Exception
    //   618	623	730	java/lang/Exception
    //   626	634	730	java/lang/Exception
    //   639	670	730	java/lang/Exception
    //   714	727	730	java/lang/Exception
    //   769	773	730	java/lang/Exception
    //   832	848	730	java/lang/Exception
    //   670	699	830	java/lang/Exception
    //   776	798	830	java/lang/Exception
    //   802	815	830	java/lang/Exception
    //   815	827	830	java/lang/Exception
    //   856	860	830	java/lang/Exception
    //   31	49	882	java/lang/Exception
    //   49	91	882	java/lang/Exception
    //   153	171	882	java/lang/Exception
    //   174	184	882	java/lang/Exception
  }
  
  public final boolean Nc()
  {
    return !this.aJn;
  }
  
  public final void Y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205021);
    a(2131691034, paramBoolean, paramInt, true);
    AppMethodBeat.o(205021);
  }
  
  public final void a(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(115690);
    this.zwc = System.currentTimeMillis();
    this.zwa = new k();
    try
    {
      this.zwa.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.zwa.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115679);
          if (System.currentTimeMillis() - i.this.zwc > 70000L) {
            i.this.zwb = 4;
          }
          if (i.this.aJn)
          {
            i.this.zwe = new i.a(i.this, paramInt1, paramLong, paramInt2, this.val$streamType);
            i.this.gAC.postDelayed(i.this.zwe, paramLong);
          }
          AppMethodBeat.o(115679);
        }
      });
      this.zwa.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115680);
          i.this.zwb = 1;
          ad.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(115680);
          return false;
        }
      });
      this.zwa.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.zwa.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.zwa.setLooping(false);
        this.zwa.prepare();
        this.zwa.start();
        if (System.currentTimeMillis() - this.zwc > 2000L) {
          this.zwb = 3;
        }
        AppMethodBeat.o(115690);
        return;
        dXm();
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(115690);
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(205020);
    if ((paramInt1 == 2131691034) && (!com.tencent.mm.plugin.audio.c.a.bvC()) && (!com.tencent.mm.plugin.audio.c.a.bvw()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(205020);
      return;
    }
    boolean bool = this.mContext.getSharedPreferences(aj.eFD(), 0).getBoolean("settings_shake", true);
    if (paramBoolean1) {
      bt.C(this.mContext, bool);
    }
    ad.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.zwd = System.currentTimeMillis();
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
          if (System.currentTimeMillis() - i.this.zwd > 5000L) {
            i.this.zwb = 8;
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
            i.this.zwb = 5;
            ad.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(115682);
          return false;
        }
      });
      rW(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn());
      if (paramBoolean2)
      {
        if (!com.tencent.mm.plugin.audio.c.a.bvC()) {
          break label354;
        }
        paramInt2 = com.tencent.mm.plugin.audio.c.a.bvx();
        localk.setAudioStreamType(paramInt2);
        if (!d.lh(28)) {
          break label359;
        }
        localk.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(paramInt2).setContentType(4).build());
        ad.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
      }
      for (;;)
      {
        if ((paramInt1 == 2131691034) && ((com.tencent.mm.plugin.audio.c.a.bvC()) || (com.tencent.mm.plugin.audio.c.a.bvw()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.zwd > 2000L) {
          this.zwb = 7;
        }
        AppMethodBeat.o(205020);
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
      ad.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
      this.zwb = 6;
      AppMethodBeat.o(205020);
    }
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115693);
    this.zwb = 0;
    A(2131691029, paramInt, paramBoolean);
    AppMethodBeat.o(115693);
  }
  
  public final int dXo()
  {
    AppMethodBeat.i(115696);
    ad.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.zwb);
    int i = this.zwb;
    AppMethodBeat.o(115696);
    return i;
  }
  
  public final void rW(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(115687);
    ad.m("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (ae.fFx.fzV < 0)) {
        break label174;
      }
      j = ae.fFx.fzV;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        ad.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.plugin.audio.c.a.bvB().a(j, null);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        ad.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.audio.c.a.bvB().hL(paramBoolean);
      }
      AppMethodBeat.o(115687);
      return;
      if (d.lf(21)) {
        break;
      }
      i = 2;
      break;
      label174:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ae.fFx.fzT >= 0) {
          j = ae.fFx.fzT;
        }
      }
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115688);
    ad.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.aJn) });
    dXn();
    if ((this.zwa == null) || (!this.aJn))
    {
      AppMethodBeat.o(115688);
      return;
    }
    try
    {
      this.zwa.stop();
      this.zwa.release();
      if (this.zwe != null) {
        this.gAC.removeCallbacks(this.zwe);
      }
      this.aJn = false;
      com.tencent.mm.plugin.audio.c.a.bvv();
      AppMethodBeat.o(115688);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.RingPlayer", localException.toString());
      AppMethodBeat.o(115688);
    }
  }
  
  final class a
    implements Runnable
  {
    private long interval;
    private int resId;
    private int streamType;
    private boolean zwj;
    
    public a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.resId = paramInt1;
      this.interval = paramLong;
      this.zwj = paramBoolean;
      this.streamType = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(115685);
      i.this.a(this.resId, this.interval, this.zwj, this.streamType);
      AppMethodBeat.o(115685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i
 * JD-Core Version:    0.7.0.1
 */