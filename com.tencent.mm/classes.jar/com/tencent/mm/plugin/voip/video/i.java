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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
{
  public MediaPlayer CFQ;
  public int CFR;
  public long CFS;
  public long CFT;
  a CFU;
  public boolean aLU;
  aq gKO;
  private com.tencent.mm.compatible.util.b iAr;
  private AudioManager mAudioManager;
  public Context mContext;
  private Vibrator mZD;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(115686);
    this.aLU = false;
    this.CFR = 65536;
    this.gKO = new aq(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = com.tencent.mm.plugin.audio.c.a.bHy().audioManager;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.mZD = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    AppMethodBeat.o(115686);
  }
  
  private void eEn()
  {
    AppMethodBeat.i(115691);
    Object localObject = this.mContext.getSharedPreferences(ak.fow(), 0);
    boolean bool;
    if (d.lA(26)) {
      bool = ((SharedPreferences)localObject).getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.mZD = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.mZD == null)
        {
          AppMethodBeat.o(115691);
          return;
          bool = ((SharedPreferences)localObject).getBoolean("settings_shake", true);
        }
        else
        {
          if (d.lA(26))
          {
            localObject = new AudioAttributes.Builder().setUsage(7).build();
            this.mZD.vibrate(VibrationEffect.createWaveform(new long[] { 1000L, 1000L, 1000L, 1000L }, 0), (AudioAttributes)localObject);
            AppMethodBeat.o(115691);
            return;
          }
          this.mZD.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
          AppMethodBeat.o(115691);
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "system not open vibrate");
      }
    }
    AppMethodBeat.o(115691);
  }
  
  private void eEo()
  {
    AppMethodBeat.i(115692);
    if (this.mZD != null)
    {
      this.mZD.cancel();
      this.mZD = null;
    }
    AppMethodBeat.o(115692);
  }
  
  /* Error */
  public final void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 209
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 213	com/tencent/mm/sdk/platformtools/ak:cpe	()Z
    //   8: ifeq +924 -> 932
    //   11: iload_2
    //   12: ifne +116 -> 128
    //   15: invokestatic 219	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   18: invokevirtual 225	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   21: ldc 226
    //   23: getstatic 232	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   26: invokevirtual 238	com/tencent/mm/storage/aj:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 228	java/lang/Boolean
    //   32: invokevirtual 241	java/lang/Boolean:booleanValue	()Z
    //   35: istore 6
    //   37: bipush 28
    //   39: invokestatic 244	com/tencent/mm/compatible/util/d:lC	(I)Z
    //   42: ifeq +122 -> 164
    //   45: invokestatic 249	com/tencent/mm/n/a:abU	()Z
    //   48: istore 8
    //   50: invokestatic 252	com/tencent/mm/n/a:abV	()Z
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
    //   94: invokestatic 164	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   135: if_icmpne +797 -> 932
    //   138: invokestatic 219	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
    //   141: invokevirtual 225	com/tencent/mm/kernel/e:ajA	()Lcom/tencent/mm/storage/aj;
    //   144: ldc_w 258
    //   147: getstatic 232	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   150: invokevirtual 238	com/tencent/mm/storage/aj:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   153: checkcast 228	java/lang/Boolean
    //   156: invokevirtual 241	java/lang/Boolean:booleanValue	()Z
    //   159: istore 6
    //   161: goto -124 -> 37
    //   164: bipush 26
    //   166: invokestatic 137	com/tencent/mm/compatible/util/d:lA	(I)Z
    //   169: ifeq +16 -> 185
    //   172: invokestatic 261	com/tencent/mm/n/a:acb	()Z
    //   175: istore 8
    //   177: invokestatic 264	com/tencent/mm/n/a:acc	()Z
    //   180: istore 7
    //   182: goto -127 -> 55
    //   185: invokestatic 267	com/tencent/mm/n/a:abS	()Z
    //   188: istore 8
    //   190: invokestatic 270	com/tencent/mm/n/a:abW	()Z
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
    //   226: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_1
    //   230: istore 7
    //   232: iload 6
    //   234: istore 8
    //   236: iload 7
    //   238: istore 6
    //   240: goto -128 -> 112
    //   243: aload_0
    //   244: getfield 58	com/tencent/mm/plugin/voip/video/i:aLU	Z
    //   247: ifeq +9 -> 256
    //   250: ldc 209
    //   252: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: return
    //   256: iload 8
    //   258: ifeq +640 -> 898
    //   261: aload_0
    //   262: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   265: putfield 298	com/tencent/mm/plugin/voip/video/i:CFS	J
    //   268: aload_0
    //   269: new 300	com/tencent/mm/compatible/b/k
    //   272: dup
    //   273: invokespecial 301	com/tencent/mm/compatible/b/k:<init>	()V
    //   276: putfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   279: aload_0
    //   280: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
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
    //   327: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   330: new 6	com/tencent/mm/plugin/voip/video/i$1
    //   333: dup
    //   334: aload_0
    //   335: invokespecial 328	com/tencent/mm/plugin/voip/video/i$1:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   338: invokevirtual 332	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   341: aload_0
    //   342: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   345: new 8	com/tencent/mm/plugin/voip/video/i$2
    //   348: dup
    //   349: aload_0
    //   350: invokespecial 333	com/tencent/mm/plugin/voip/video/i$2:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   353: invokevirtual 337	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   356: invokestatic 340	com/tencent/mm/plugin/audio/c/a:bHz	()Z
    //   359: ifeq +204 -> 563
    //   362: invokestatic 343	com/tencent/mm/plugin/audio/c/a:bHA	()Z
    //   365: ifeq +198 -> 563
    //   368: iconst_1
    //   369: istore 7
    //   371: invokestatic 346	com/tencent/mm/plugin/audio/c/a:bHt	()Z
    //   374: istore 8
    //   376: ldc 151
    //   378: ldc_w 348
    //   381: iconst_2
    //   382: anewarray 4	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: iload 7
    //   389: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: iload 8
    //   397: invokestatic 257	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   400: aastore
    //   401: invokestatic 351	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   404: iload 7
    //   406: ifeq +163 -> 569
    //   409: invokestatic 354	com/tencent/mm/plugin/audio/c/a:bHu	()I
    //   412: istore_1
    //   413: aload_0
    //   414: iconst_0
    //   415: invokevirtual 358	com/tencent/mm/plugin/voip/video/i:tO	(Z)V
    //   418: bipush 28
    //   420: invokestatic 244	com/tencent/mm/compatible/util/d:lC	(I)Z
    //   423: ifeq +238 -> 661
    //   426: aload_0
    //   427: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   430: new 168	android/media/AudioAttributes$Builder
    //   433: dup
    //   434: invokespecial 169	android/media/AudioAttributes$Builder:<init>	()V
    //   437: bipush 6
    //   439: invokevirtual 173	android/media/AudioAttributes$Builder:setUsage	(I)Landroid/media/AudioAttributes$Builder;
    //   442: iload_1
    //   443: invokevirtual 361	android/media/AudioAttributes$Builder:setLegacyStreamType	(I)Landroid/media/AudioAttributes$Builder;
    //   446: iconst_4
    //   447: invokevirtual 364	android/media/AudioAttributes$Builder:setContentType	(I)Landroid/media/AudioAttributes$Builder;
    //   450: invokevirtual 177	android/media/AudioAttributes$Builder:build	()Landroid/media/AudioAttributes;
    //   453: invokevirtual 368	android/media/MediaPlayer:setAudioAttributes	(Landroid/media/AudioAttributes;)V
    //   456: ldc 151
    //   458: ldc_w 370
    //   461: invokestatic 197	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: goto +474 -> 938
    //   467: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bHy	()Lcom/tencent/mm/plugin/audio/b/a;
    //   470: iload_1
    //   471: invokevirtual 374	com/tencent/mm/plugin/audio/b/a:getStreamMaxVolume	(I)I
    //   474: istore 5
    //   476: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bHy	()Lcom/tencent/mm/plugin/audio/b/a;
    //   479: iload_1
    //   480: invokevirtual 377	com/tencent/mm/plugin/audio/b/a:getStreamVolume	(I)I
    //   483: istore 4
    //   485: iload 4
    //   487: istore_2
    //   488: iload 4
    //   490: iload 5
    //   492: iconst_2
    //   493: idiv
    //   494: if_icmple +8 -> 502
    //   497: iload 5
    //   499: iconst_2
    //   500: idiv
    //   501: istore_2
    //   502: invokestatic 82	com/tencent/mm/plugin/audio/c/a:bHy	()Lcom/tencent/mm/plugin/audio/b/a;
    //   505: iload_1
    //   506: iload_2
    //   507: invokevirtual 381	com/tencent/mm/plugin/audio/b/a:eD	(II)V
    //   510: aload_0
    //   511: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   514: iconst_1
    //   515: invokevirtual 384	android/media/MediaPlayer:setLooping	(Z)V
    //   518: aload_0
    //   519: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   522: invokevirtual 387	android/media/MediaPlayer:prepare	()V
    //   525: aload_0
    //   526: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   529: invokevirtual 390	android/media/MediaPlayer:start	()V
    //   532: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   535: aload_0
    //   536: getfield 298	com/tencent/mm/plugin/voip/video/i:CFS	J
    //   539: lsub
    //   540: ldc2_w 391
    //   543: lcmp
    //   544: ifle +8 -> 552
    //   547: aload_0
    //   548: iconst_3
    //   549: putfield 61	com/tencent/mm/plugin/voip/video/i:CFR	I
    //   552: aload_0
    //   553: iconst_1
    //   554: putfield 58	com/tencent/mm/plugin/voip/video/i:aLU	Z
    //   557: ldc 209
    //   559: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: return
    //   563: iconst_0
    //   564: istore 7
    //   566: goto -195 -> 371
    //   569: iload_3
    //   570: ifne +8 -> 578
    //   573: iload 8
    //   575: ifeq +56 -> 631
    //   578: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   581: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fYT	I
    //   584: iflt +343 -> 927
    //   587: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   590: getfield 403	com/tencent/mm/compatible/deviceinfo/b:fYT	I
    //   593: istore_1
    //   594: goto +357 -> 951
    //   597: aload_0
    //   598: iconst_0
    //   599: invokevirtual 358	com/tencent/mm/plugin/voip/video/i:tO	(Z)V
    //   602: goto -184 -> 418
    //   605: iconst_3
    //   606: istore_1
    //   607: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   610: getfield 406	com/tencent/mm/compatible/deviceinfo/b:fYQ	I
    //   613: iflt +10 -> 623
    //   616: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   619: getfield 406	com/tencent/mm/compatible/deviceinfo/b:fYQ	I
    //   622: istore_1
    //   623: aload_0
    //   624: iconst_1
    //   625: invokevirtual 358	com/tencent/mm/plugin/voip/video/i:tO	(Z)V
    //   628: goto -210 -> 418
    //   631: invokestatic 340	com/tencent/mm/plugin/audio/c/a:bHz	()Z
    //   634: ifne +288 -> 922
    //   637: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   640: getfield 409	com/tencent/mm/compatible/deviceinfo/b:fYV	I
    //   643: iflt +279 -> 922
    //   646: getstatic 398	com/tencent/mm/compatible/deviceinfo/ae:geN	Lcom/tencent/mm/compatible/deviceinfo/b;
    //   649: getfield 409	com/tencent/mm/compatible/deviceinfo/b:fYV	I
    //   652: istore_1
    //   653: aload_0
    //   654: iconst_1
    //   655: invokevirtual 358	com/tencent/mm/plugin/voip/video/i:tO	(Z)V
    //   658: goto -240 -> 418
    //   661: aload_0
    //   662: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   665: iload_1
    //   666: invokevirtual 412	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   669: goto +269 -> 938
    //   672: astore 9
    //   674: ldc 151
    //   676: new 272	java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w 414
    //   683: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload 9
    //   688: invokevirtual 415	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   691: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload_0
    //   701: iconst_2
    //   702: putfield 61	com/tencent/mm/plugin/voip/video/i:CFR	I
    //   705: aload_0
    //   706: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   709: iconst_1
    //   710: invokestatic 421	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   713: astore 9
    //   715: aload_0
    //   716: aload_0
    //   717: getfield 76	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   720: aload 9
    //   722: invokestatic 424	com/tencent/mm/compatible/b/k:e	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   725: putfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   728: aload_0
    //   729: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   732: astore 9
    //   734: aload 9
    //   736: ifnonnull +75 -> 811
    //   739: ldc 209
    //   741: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: return
    //   745: iload_3
    //   746: ifeq +53 -> 799
    //   749: aload_0
    //   750: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   753: ldc_w 425
    //   756: ldc_w 425
    //   759: invokevirtual 429	android/media/MediaPlayer:setVolume	(FF)V
    //   762: goto -252 -> 510
    //   765: astore 9
    //   767: ldc 151
    //   769: new 272	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 431
    //   776: invokespecial 277	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: aload 9
    //   781: invokevirtual 432	java/lang/Exception:toString	()Ljava/lang/String;
    //   784: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: ldc 209
    //   795: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   798: return
    //   799: iload 6
    //   801: ifeq -291 -> 510
    //   804: aload_0
    //   805: invokespecial 434	com/tencent/mm/plugin/voip/video/i:eEn	()V
    //   808: goto -298 -> 510
    //   811: aload_0
    //   812: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   815: invokevirtual 437	android/media/MediaPlayer:stop	()V
    //   818: aload_0
    //   819: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   822: invokevirtual 387	android/media/MediaPlayer:prepare	()V
    //   825: aload_0
    //   826: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   829: iconst_1
    //   830: invokevirtual 384	android/media/MediaPlayer:setLooping	(Z)V
    //   833: iload_3
    //   834: ifeq +52 -> 886
    //   837: aload_0
    //   838: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   841: ldc_w 425
    //   844: ldc_w 425
    //   847: invokevirtual 429	android/media/MediaPlayer:setVolume	(FF)V
    //   850: aload_0
    //   851: getfield 303	com/tencent/mm/plugin/voip/video/i:CFQ	Landroid/media/MediaPlayer;
    //   854: invokevirtual 390	android/media/MediaPlayer:start	()V
    //   857: aload_0
    //   858: iconst_0
    //   859: putfield 61	com/tencent/mm/plugin/voip/video/i:CFR	I
    //   862: goto -310 -> 552
    //   865: astore 9
    //   867: ldc_w 439
    //   870: aload 9
    //   872: invokevirtual 280	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   875: invokestatic 290	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload_0
    //   879: iconst_2
    //   880: putfield 61	com/tencent/mm/plugin/voip/video/i:CFR	I
    //   883: goto -331 -> 552
    //   886: iload 6
    //   888: ifeq -38 -> 850
    //   891: aload_0
    //   892: invokespecial 434	com/tencent/mm/plugin/voip/video/i:eEn	()V
    //   895: goto -45 -> 850
    //   898: iload 6
    //   900: ifeq +11 -> 911
    //   903: iload_3
    //   904: ifne +7 -> 911
    //   907: aload_0
    //   908: invokespecial 434	com/tencent/mm/plugin/voip/video/i:eEn	()V
    //   911: ldc 209
    //   913: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: return
    //   917: astore 9
    //   919: goto -716 -> 203
    //   922: iconst_2
    //   923: istore_1
    //   924: goto -271 -> 653
    //   927: iconst_0
    //   928: istore_1
    //   929: goto +22 -> 951
    //   932: iconst_1
    //   933: istore 6
    //   935: goto -898 -> 37
    //   938: iload 8
    //   940: ifne -473 -> 467
    //   943: iload 7
    //   945: ifeq -200 -> 745
    //   948: goto -481 -> 467
    //   951: iload 8
    //   953: ifne -356 -> 597
    //   956: iload_2
    //   957: iconst_1
    //   958: if_icmpne -353 -> 605
    //   961: goto -364 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	964	0	this	i
    //   0	964	1	paramInt1	int
    //   0	964	2	paramInt2	int
    //   0	964	3	paramBoolean	boolean
    //   483	12	4	i	int
    //   474	27	5	j	int
    //   35	899	6	bool1	boolean
    //   53	891	7	bool2	boolean
    //   48	904	8	bool3	boolean
    //   198	18	9	localException1	Exception
    //   672	15	9	localThrowable	Throwable
    //   713	22	9	localObject	Object
    //   765	15	9	localException2	Exception
    //   865	6	9	localException3	Exception
    //   917	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   5	11	198	java/lang/Exception
    //   15	37	198	java/lang/Exception
    //   138	161	198	java/lang/Exception
    //   279	368	672	java/lang/Throwable
    //   371	404	672	java/lang/Throwable
    //   409	418	672	java/lang/Throwable
    //   418	464	672	java/lang/Throwable
    //   467	485	672	java/lang/Throwable
    //   488	502	672	java/lang/Throwable
    //   502	510	672	java/lang/Throwable
    //   510	552	672	java/lang/Throwable
    //   578	594	672	java/lang/Throwable
    //   597	602	672	java/lang/Throwable
    //   607	623	672	java/lang/Throwable
    //   623	628	672	java/lang/Throwable
    //   631	653	672	java/lang/Throwable
    //   653	658	672	java/lang/Throwable
    //   661	669	672	java/lang/Throwable
    //   749	762	672	java/lang/Throwable
    //   804	808	672	java/lang/Throwable
    //   261	279	765	java/lang/Exception
    //   279	368	765	java/lang/Exception
    //   371	404	765	java/lang/Exception
    //   409	418	765	java/lang/Exception
    //   418	464	765	java/lang/Exception
    //   467	485	765	java/lang/Exception
    //   488	502	765	java/lang/Exception
    //   502	510	765	java/lang/Exception
    //   510	552	765	java/lang/Exception
    //   552	557	765	java/lang/Exception
    //   578	594	765	java/lang/Exception
    //   597	602	765	java/lang/Exception
    //   607	623	765	java/lang/Exception
    //   623	628	765	java/lang/Exception
    //   631	653	765	java/lang/Exception
    //   653	658	765	java/lang/Exception
    //   661	669	765	java/lang/Exception
    //   674	705	765	java/lang/Exception
    //   749	762	765	java/lang/Exception
    //   804	808	765	java/lang/Exception
    //   867	883	765	java/lang/Exception
    //   705	734	865	java/lang/Exception
    //   811	833	865	java/lang/Exception
    //   837	850	865	java/lang/Exception
    //   850	862	865	java/lang/Exception
    //   891	895	865	java/lang/Exception
    //   37	55	917	java/lang/Exception
    //   55	97	917	java/lang/Exception
    //   164	182	917	java/lang/Exception
    //   185	195	917	java/lang/Exception
  }
  
  public final boolean OH()
  {
    return !this.aLU;
  }
  
  public final void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(210248);
    a(2131691034, paramBoolean, paramInt, true);
    AppMethodBeat.o(210248);
  }
  
  public final void a(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(115690);
    this.CFS = System.currentTimeMillis();
    this.CFQ = new k();
    try
    {
      this.CFQ.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.CFQ.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(115679);
          if (System.currentTimeMillis() - i.this.CFS > 70000L) {
            i.this.CFR = 4;
          }
          if (i.this.aLU)
          {
            i.this.CFU = new i.a(i.this, paramInt1, paramLong, paramInt2, this.val$streamType);
            i.this.gKO.postDelayed(i.this.CFU, paramLong);
          }
          AppMethodBeat.o(115679);
        }
      });
      this.CFQ.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(115680);
          i.this.CFR = 1;
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(115680);
          return false;
        }
      });
      this.CFQ.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.CFQ.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.CFQ.setLooping(false);
        this.CFQ.prepare();
        this.CFQ.start();
        if (System.currentTimeMillis() - this.CFS > 2000L) {
          this.CFR = 3;
        }
        AppMethodBeat.o(115690);
        return;
        eEn();
      }
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(115690);
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(210247);
    if ((paramInt1 == 2131691034) && (!com.tencent.mm.plugin.audio.c.a.bHz()) && (!com.tencent.mm.plugin.audio.c.a.bHt()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(210247);
      return;
    }
    boolean bool = this.mContext.getSharedPreferences(ak.fow(), 0).getBoolean("settings_shake", true);
    if (paramBoolean1) {
      bu.F(this.mContext, bool);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.CFT = System.currentTimeMillis();
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
          if (System.currentTimeMillis() - i.this.CFT > 5000L) {
            i.this.CFR = 8;
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
            i.this.CFR = 5;
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(115682);
          return false;
        }
      });
      tO(com.tencent.mm.plugin.audio.c.a.isSpeakerphoneOn());
      if (paramBoolean2)
      {
        if (!com.tencent.mm.plugin.audio.c.a.bHz()) {
          break label354;
        }
        paramInt2 = com.tencent.mm.plugin.audio.c.a.bHu();
        localk.setAudioStreamType(paramInt2);
        if (!d.lC(28)) {
          break label359;
        }
        localk.setAudioAttributes(new AudioAttributes.Builder().setUsage(6).setLegacyStreamType(paramInt2).setContentType(4).build());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "use audio attribute to play ring");
      }
      for (;;)
      {
        if ((paramInt1 == 2131691034) && ((com.tencent.mm.plugin.audio.c.a.bHz()) || (com.tencent.mm.plugin.audio.c.a.bHt()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.CFT > 2000L) {
          this.CFR = 7;
        }
        AppMethodBeat.o(210247);
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
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
      this.CFR = 6;
      AppMethodBeat.o(210247);
    }
  }
  
  public final void aU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(115693);
    this.CFR = 0;
    A(2131691029, paramInt, paramBoolean);
    AppMethodBeat.o(115693);
  }
  
  public final int eEp()
  {
    AppMethodBeat.i(115696);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.CFR);
    int i = this.CFR;
    AppMethodBeat.o(115696);
    return i;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(115688);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.aLU) });
    eEo();
    if ((this.CFQ == null) || (!this.aLU))
    {
      AppMethodBeat.o(115688);
      return;
    }
    try
    {
      this.CFQ.stop();
      this.CFQ.release();
      if (this.CFU != null) {
        this.gKO.removeCallbacks(this.CFU);
      }
      this.aLU = false;
      com.tencent.mm.plugin.audio.c.a.bHs();
      AppMethodBeat.o(115688);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.RingPlayer", localException.toString());
      AppMethodBeat.o(115688);
    }
  }
  
  public final void tO(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(115687);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYW < 0)) {
        break label174;
      }
      j = com.tencent.mm.compatible.deviceinfo.ae.geN.fYW;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.plugin.audio.c.a.bHy().b(j, null);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.audio.c.a.bHy().iq(paramBoolean);
      }
      AppMethodBeat.o(115687);
      return;
      if (d.lA(21)) {
        break;
      }
      i = 2;
      break;
      label174:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYU >= 0) {
          j = com.tencent.mm.compatible.deviceinfo.ae.geN.fYU;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    private boolean CFZ;
    private long interval;
    private int resId;
    private int streamType;
    
    public a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
    {
      this.resId = paramInt1;
      this.interval = paramLong;
      this.CFZ = paramBoolean;
      this.streamType = paramInt2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(115685);
      i.this.a(this.resId, this.interval, this.CFZ, this.streamType);
      AppMethodBeat.o(115685);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i
 * JD-Core Version:    0.7.0.1
 */