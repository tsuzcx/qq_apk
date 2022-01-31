package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public final class h
{
  public boolean bVD;
  ak faV;
  private com.tencent.mm.compatible.util.b gaP;
  private Vibrator jbU;
  private AudioManager mAudioManager;
  public Context mContext;
  public MediaPlayer tHn;
  public int tHo;
  public long tHp;
  public long tHq;
  h.a tHr;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(5101);
    this.bVD = false;
    this.tHo = 65536;
    this.faV = new ak(Looper.getMainLooper());
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.mAudioManager = g.KC().elW;
      if (this.mAudioManager == null) {
        this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.jbU = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    AppMethodBeat.o(5101);
  }
  
  private void cPM()
  {
    AppMethodBeat.i(5106);
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences(ah.dsP(), 0);
    boolean bool;
    if (d.fv(26)) {
      bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", true);
    }
    while (bool)
    {
      int i = this.mAudioManager.getRingerMode();
      ab.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i == 1) || (i == 2))
      {
        this.jbU = ((Vibrator)this.mContext.getSystemService("vibrator"));
        if (this.jbU == null)
        {
          AppMethodBeat.o(5106);
          return;
          bool = localSharedPreferences.getBoolean("settings_shake", true);
        }
        else
        {
          this.jbU.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
          AppMethodBeat.o(5106);
        }
      }
      else
      {
        ab.i("MicroMsg.RingPlayer", "system not open vibrate");
      }
    }
    AppMethodBeat.o(5106);
  }
  
  private void cPN()
  {
    AppMethodBeat.i(5107);
    if (this.jbU != null)
    {
      this.jbU.cancel();
      this.jbU = null;
    }
    AppMethodBeat.o(5107);
  }
  
  public final boolean Dt()
  {
    return !this.bVD;
  }
  
  public final void HA(int paramInt)
  {
    AppMethodBeat.i(5110);
    r(2131231865, paramInt, true);
    AppMethodBeat.o(5110);
  }
  
  public final void a(final int paramInt1, final long paramLong, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(5105);
    this.tHp = System.currentTimeMillis();
    this.tHn = new k();
    try
    {
      this.tHn.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.tHn.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(5094);
          if (System.currentTimeMillis() - h.this.tHp > 70000L) {
            h.this.tHo = 4;
          }
          if (h.this.bVD)
          {
            h.this.tHr = new h.a(h.this, paramInt1, paramLong, paramInt2, this.tHw);
            h.this.faV.postDelayed(h.this.tHr, paramLong);
          }
          AppMethodBeat.o(5094);
        }
      });
      this.tHn.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(5095);
          h.this.tHo = 1;
          ab.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + paramAnonymousInt1 + ":extra:" + paramAnonymousInt2);
          AppMethodBeat.o(5095);
          return false;
        }
      });
      this.tHn.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.tHn.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.tHn.setLooping(false);
        this.tHn.prepare();
        this.tHn.start();
        if (System.currentTimeMillis() - this.tHp > 2000L) {
          this.tHo = 3;
        }
        AppMethodBeat.o(5105);
        return;
        cPM();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
      AppMethodBeat.o(5105);
    }
  }
  
  public final void aq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(5108);
    this.tHo = 0;
    q(2131231860, paramInt, paramBoolean);
    AppMethodBeat.o(5108);
  }
  
  public final int cPO()
  {
    AppMethodBeat.i(5111);
    ab.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.tHo);
    int i = this.tHo;
    AppMethodBeat.o(5111);
    return i;
  }
  
  public final void nf(boolean paramBoolean)
  {
    int i = 3;
    AppMethodBeat.i(5102);
    ab.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b, isSpeakerphoneOn: %s, mode: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.mAudioManager.isSpeakerphoneOn()), Integer.valueOf(this.mAudioManager.getMode()) });
    int j;
    if (paramBoolean)
    {
      i = 0;
      if ((!paramBoolean) || (ac.erv.enn < 0)) {
        break label175;
      }
      j = ac.erv.enn;
    }
    for (;;)
    {
      if (j != this.mAudioManager.getMode())
      {
        ab.i("MicroMsg.RingPlayer", "set AudioManager mode: %s", new Object[] { Integer.valueOf(j) });
        this.mAudioManager.setMode(j);
      }
      if (paramBoolean != this.mAudioManager.isSpeakerphoneOn())
      {
        ab.i("MicroMsg.RingPlayer", "set AudioManager speakerphoneOn: %s", new Object[] { Boolean.valueOf(paramBoolean) });
        this.mAudioManager.setSpeakerphoneOn(paramBoolean);
      }
      AppMethodBeat.o(5102);
      return;
      if (d.fv(21)) {
        break;
      }
      i = 2;
      break;
      label175:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (ac.erv.enl >= 0) {
          j = ac.erv.enl;
        }
      }
    }
  }
  
  /* Error */
  public final void q(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 5104
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_2
    //   7: ifne +115 -> 122
    //   10: invokestatic 329	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   13: invokevirtual 335	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   16: ldc_w 336
    //   19: getstatic 340	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   22: invokevirtual 346	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 288	java/lang/Boolean
    //   28: invokevirtual 349	java/lang/Boolean:booleanValue	()Z
    //   31: istore 6
    //   33: bipush 26
    //   35: invokestatic 126	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   38: ifeq +120 -> 158
    //   41: invokestatic 354	com/tencent/mm/m/a:MI	()Z
    //   44: istore 8
    //   46: invokestatic 357	com/tencent/mm/m/a:MJ	()Z
    //   49: istore 7
    //   51: ldc 140
    //   53: ldc_w 359
    //   56: iconst_4
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload 6
    //   64: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload 8
    //   72: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: iload 7
    //   80: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   83: aastore
    //   84: dup
    //   85: iconst_3
    //   86: iload_3
    //   87: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   90: aastore
    //   91: invokestatic 153	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: iload_3
    //   95: ifeq +6 -> 101
    //   98: iconst_1
    //   99: istore 8
    //   101: iload 8
    //   103: istore 6
    //   105: iload 6
    //   107: ifne +101 -> 208
    //   110: iload 7
    //   112: ifne +96 -> 208
    //   115: sipush 5104
    //   118: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: iload_2
    //   123: iconst_1
    //   124: if_icmpeq +8 -> 132
    //   127: iload_2
    //   128: iconst_2
    //   129: if_icmpne +724 -> 853
    //   132: invokestatic 329	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   135: invokevirtual 335	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   138: ldc_w 360
    //   141: getstatic 340	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   144: invokevirtual 346	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 288	java/lang/Boolean
    //   150: invokevirtual 349	java/lang/Boolean:booleanValue	()Z
    //   153: istore 6
    //   155: goto -122 -> 33
    //   158: invokestatic 363	com/tencent/mm/m/a:MB	()Z
    //   161: istore 8
    //   163: invokestatic 366	com/tencent/mm/m/a:MD	()Z
    //   166: istore 7
    //   168: goto -117 -> 51
    //   171: astore 9
    //   173: iconst_1
    //   174: istore 6
    //   176: ldc 140
    //   178: new 197	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 368
    //   185: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload 9
    //   190: invokevirtual 371	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: iconst_1
    //   203: istore 7
    //   205: goto -100 -> 105
    //   208: aload_0
    //   209: getfield 50	com/tencent/mm/plugin/voip/video/h:bVD	Z
    //   212: ifeq +10 -> 222
    //   215: sipush 5104
    //   218: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: return
    //   222: iload 6
    //   224: ifeq +594 -> 818
    //   227: aload_0
    //   228: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   231: putfield 190	com/tencent/mm/plugin/voip/video/h:tHp	J
    //   234: aload_0
    //   235: new 192	com/tencent/mm/compatible/b/k
    //   238: dup
    //   239: invokespecial 193	com/tencent/mm/compatible/b/k:<init>	()V
    //   242: putfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   245: aload_0
    //   246: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   249: aload_0
    //   250: getfield 68	com/tencent/mm/plugin/voip/video/h:mContext	Landroid/content/Context;
    //   253: new 197	java/lang/StringBuilder
    //   256: dup
    //   257: ldc 199
    //   259: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 68	com/tencent/mm/plugin/voip/video/h:mContext	Landroid/content/Context;
    //   266: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   269: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 211
    //   274: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_1
    //   278: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 223	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   287: invokevirtual 229	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   290: aload_0
    //   291: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   294: new 373	com/tencent/mm/plugin/voip/video/h$1
    //   297: dup
    //   298: aload_0
    //   299: invokespecial 374	com/tencent/mm/plugin/voip/video/h$1:<init>	(Lcom/tencent/mm/plugin/voip/video/h;)V
    //   302: invokevirtual 236	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   305: aload_0
    //   306: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   309: new 376	com/tencent/mm/plugin/voip/video/h$2
    //   312: dup
    //   313: aload_0
    //   314: invokespecial 377	com/tencent/mm/plugin/voip/video/h$2:<init>	(Lcom/tencent/mm/plugin/voip/video/h;)V
    //   317: invokevirtual 243	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   320: invokestatic 74	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   323: invokevirtual 380	com/tencent/mm/compatible/b/g:KH	()Z
    //   326: istore 6
    //   328: invokestatic 74	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   331: invokevirtual 383	com/tencent/mm/compatible/b/g:KN	()Z
    //   334: istore 8
    //   336: ldc 140
    //   338: ldc_w 385
    //   341: iconst_2
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: iload 6
    //   349: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: iload 8
    //   357: invokestatic 291	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   360: aastore
    //   361: invokestatic 387	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: iload 6
    //   366: ifeq +133 -> 499
    //   369: invokestatic 74	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   372: invokevirtual 390	com/tencent/mm/compatible/b/g:KU	()I
    //   375: istore_1
    //   376: aload_0
    //   377: iconst_0
    //   378: invokevirtual 392	com/tencent/mm/plugin/voip/video/h:nf	(Z)V
    //   381: aload_0
    //   382: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   385: iload_1
    //   386: invokevirtual 246	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   389: iload 8
    //   391: ifne +8 -> 399
    //   394: iload 6
    //   396: ifeq +198 -> 594
    //   399: aload_0
    //   400: getfield 79	com/tencent/mm/plugin/voip/video/h:mAudioManager	Landroid/media/AudioManager;
    //   403: iload_1
    //   404: invokevirtual 396	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   407: istore 5
    //   409: aload_0
    //   410: getfield 79	com/tencent/mm/plugin/voip/video/h:mAudioManager	Landroid/media/AudioManager;
    //   413: iload_1
    //   414: invokevirtual 399	android/media/AudioManager:getStreamVolume	(I)I
    //   417: istore 4
    //   419: iload 4
    //   421: istore_2
    //   422: iload 4
    //   424: iload 5
    //   426: iconst_2
    //   427: idiv
    //   428: if_icmple +8 -> 436
    //   431: iload 5
    //   433: iconst_2
    //   434: idiv
    //   435: istore_2
    //   436: aload_0
    //   437: getfield 79	com/tencent/mm/plugin/voip/video/h:mAudioManager	Landroid/media/AudioManager;
    //   440: iload_1
    //   441: iload_2
    //   442: invokestatic 405	com/tencent/mm/compatible/b/a:b	(Landroid/media/AudioManager;II)V
    //   445: aload_0
    //   446: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   449: iconst_1
    //   450: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   453: aload_0
    //   454: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   457: invokevirtual 258	android/media/MediaPlayer:prepare	()V
    //   460: aload_0
    //   461: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   464: invokevirtual 261	android/media/MediaPlayer:start	()V
    //   467: invokestatic 188	java/lang/System:currentTimeMillis	()J
    //   470: aload_0
    //   471: getfield 190	com/tencent/mm/plugin/voip/video/h:tHp	J
    //   474: lsub
    //   475: ldc2_w 262
    //   478: lcmp
    //   479: ifle +8 -> 487
    //   482: aload_0
    //   483: iconst_3
    //   484: putfield 53	com/tencent/mm/plugin/voip/video/h:tHo	I
    //   487: aload_0
    //   488: iconst_1
    //   489: putfield 50	com/tencent/mm/plugin/voip/video/h:bVD	Z
    //   492: sipush 5104
    //   495: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: return
    //   499: iload_3
    //   500: ifne +8 -> 508
    //   503: iload 8
    //   505: ifeq +56 -> 561
    //   508: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   511: getfield 408	com/tencent/mm/compatible/e/b:enk	I
    //   514: iflt +334 -> 848
    //   517: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   520: getfield 408	com/tencent/mm/compatible/e/b:enk	I
    //   523: istore_1
    //   524: goto +335 -> 859
    //   527: aload_0
    //   528: iconst_0
    //   529: invokevirtual 392	com/tencent/mm/plugin/voip/video/h:nf	(Z)V
    //   532: goto -151 -> 381
    //   535: iconst_3
    //   536: istore_1
    //   537: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   540: getfield 411	com/tencent/mm/compatible/e/b:enh	I
    //   543: iflt +10 -> 553
    //   546: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   549: getfield 411	com/tencent/mm/compatible/e/b:enh	I
    //   552: istore_1
    //   553: aload_0
    //   554: iconst_1
    //   555: invokevirtual 392	com/tencent/mm/plugin/voip/video/h:nf	(Z)V
    //   558: goto -177 -> 381
    //   561: invokestatic 74	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   564: invokevirtual 380	com/tencent/mm/compatible/b/g:KH	()Z
    //   567: ifne +276 -> 843
    //   570: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   573: getfield 414	com/tencent/mm/compatible/e/b:enm	I
    //   576: iflt +267 -> 843
    //   579: getstatic 303	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
    //   582: getfield 414	com/tencent/mm/compatible/e/b:enm	I
    //   585: istore_1
    //   586: aload_0
    //   587: iconst_1
    //   588: invokevirtual 392	com/tencent/mm/plugin/voip/video/h:nf	(Z)V
    //   591: goto -210 -> 381
    //   594: iload_3
    //   595: ifeq +91 -> 686
    //   598: aload_0
    //   599: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   602: ldc 247
    //   604: ldc 247
    //   606: invokevirtual 251	android/media/MediaPlayer:setVolume	(FF)V
    //   609: goto -164 -> 445
    //   612: astore 9
    //   614: ldc 140
    //   616: new 197	java/lang/StringBuilder
    //   619: dup
    //   620: ldc_w 416
    //   623: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload 9
    //   628: invokevirtual 417	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   631: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload_0
    //   641: iconst_2
    //   642: putfield 53	com/tencent/mm/plugin/voip/video/h:tHo	I
    //   645: aload_0
    //   646: getfield 68	com/tencent/mm/plugin/voip/video/h:mContext	Landroid/content/Context;
    //   649: iconst_1
    //   650: invokestatic 423	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   653: astore 9
    //   655: aload_0
    //   656: aload_0
    //   657: getfield 68	com/tencent/mm/plugin/voip/video/h:mContext	Landroid/content/Context;
    //   660: aload 9
    //   662: invokestatic 426	com/tencent/mm/compatible/b/k:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/k;
    //   665: putfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   668: aload_0
    //   669: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   672: astore 9
    //   674: aload 9
    //   676: ifnonnull +57 -> 733
    //   679: sipush 5104
    //   682: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   685: return
    //   686: iload 7
    //   688: ifeq -243 -> 445
    //   691: aload_0
    //   692: invokespecial 265	com/tencent/mm/plugin/voip/video/h:cPM	()V
    //   695: goto -250 -> 445
    //   698: astore 9
    //   700: ldc 140
    //   702: new 197	java/lang/StringBuilder
    //   705: dup
    //   706: ldc_w 267
    //   709: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   712: aload 9
    //   714: invokevirtual 268	java/lang/Exception:toString	()Ljava/lang/String;
    //   717: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: sipush 5104
    //   729: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   732: return
    //   733: aload_0
    //   734: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   737: invokevirtual 429	android/media/MediaPlayer:stop	()V
    //   740: aload_0
    //   741: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   744: invokevirtual 258	android/media/MediaPlayer:prepare	()V
    //   747: aload_0
    //   748: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   751: iconst_1
    //   752: invokevirtual 255	android/media/MediaPlayer:setLooping	(Z)V
    //   755: iload_3
    //   756: ifeq +50 -> 806
    //   759: aload_0
    //   760: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   763: ldc 247
    //   765: ldc 247
    //   767: invokevirtual 251	android/media/MediaPlayer:setVolume	(FF)V
    //   770: aload_0
    //   771: getfield 195	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
    //   774: invokevirtual 261	android/media/MediaPlayer:start	()V
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 53	com/tencent/mm/plugin/voip/video/h:tHo	I
    //   782: goto -295 -> 487
    //   785: astore 9
    //   787: ldc_w 431
    //   790: aload 9
    //   792: invokevirtual 371	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   795: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: aload_0
    //   799: iconst_2
    //   800: putfield 53	com/tencent/mm/plugin/voip/video/h:tHo	I
    //   803: goto -316 -> 487
    //   806: iload 7
    //   808: ifeq -38 -> 770
    //   811: aload_0
    //   812: invokespecial 265	com/tencent/mm/plugin/voip/video/h:cPM	()V
    //   815: goto -45 -> 770
    //   818: iload 7
    //   820: ifeq +11 -> 831
    //   823: iload_3
    //   824: ifne +7 -> 831
    //   827: aload_0
    //   828: invokespecial 265	com/tencent/mm/plugin/voip/video/h:cPM	()V
    //   831: sipush 5104
    //   834: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   837: return
    //   838: astore 9
    //   840: goto -664 -> 176
    //   843: iconst_2
    //   844: istore_1
    //   845: goto -259 -> 586
    //   848: iconst_0
    //   849: istore_1
    //   850: goto +9 -> 859
    //   853: iconst_1
    //   854: istore 6
    //   856: goto -823 -> 33
    //   859: iload 8
    //   861: ifne -334 -> 527
    //   864: iload_2
    //   865: iconst_1
    //   866: if_icmpne -331 -> 535
    //   869: goto -342 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	872	0	this	h
    //   0	872	1	paramInt1	int
    //   0	872	2	paramInt2	int
    //   0	872	3	paramBoolean	boolean
    //   417	12	4	i	int
    //   407	28	5	j	int
    //   31	824	6	bool1	boolean
    //   49	770	7	bool2	boolean
    //   44	816	8	bool3	boolean
    //   171	18	9	localException1	Exception
    //   612	15	9	localThrowable	Throwable
    //   653	22	9	localObject	Object
    //   698	15	9	localException2	Exception
    //   785	6	9	localException3	Exception
    //   838	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   10	33	171	java/lang/Exception
    //   132	155	171	java/lang/Exception
    //   245	364	612	java/lang/Throwable
    //   369	381	612	java/lang/Throwable
    //   381	389	612	java/lang/Throwable
    //   399	419	612	java/lang/Throwable
    //   422	436	612	java/lang/Throwable
    //   436	445	612	java/lang/Throwable
    //   445	487	612	java/lang/Throwable
    //   508	524	612	java/lang/Throwable
    //   527	532	612	java/lang/Throwable
    //   537	553	612	java/lang/Throwable
    //   553	558	612	java/lang/Throwable
    //   561	586	612	java/lang/Throwable
    //   586	591	612	java/lang/Throwable
    //   598	609	612	java/lang/Throwable
    //   691	695	612	java/lang/Throwable
    //   227	245	698	java/lang/Exception
    //   245	364	698	java/lang/Exception
    //   369	381	698	java/lang/Exception
    //   381	389	698	java/lang/Exception
    //   399	419	698	java/lang/Exception
    //   422	436	698	java/lang/Exception
    //   436	445	698	java/lang/Exception
    //   445	487	698	java/lang/Exception
    //   487	492	698	java/lang/Exception
    //   508	524	698	java/lang/Exception
    //   527	532	698	java/lang/Exception
    //   537	553	698	java/lang/Exception
    //   553	558	698	java/lang/Exception
    //   561	586	698	java/lang/Exception
    //   586	591	698	java/lang/Exception
    //   598	609	698	java/lang/Exception
    //   614	645	698	java/lang/Exception
    //   691	695	698	java/lang/Exception
    //   787	803	698	java/lang/Exception
    //   645	674	785	java/lang/Exception
    //   733	755	785	java/lang/Exception
    //   759	770	785	java/lang/Exception
    //   770	782	785	java/lang/Exception
    //   811	815	785	java/lang/Exception
    //   33	51	838	java/lang/Exception
    //   51	94	838	java/lang/Exception
    //   158	168	838	java/lang/Exception
  }
  
  public final void r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(5109);
    if ((paramInt1 == 2131231865) && (!g.KC().KH()) && (!g.KC().KN()) && ((this.mAudioManager.getRingerMode() == 0) || (this.mAudioManager.getRingerMode() == 1)))
    {
      AppMethodBeat.o(5109);
      return;
    }
    this.mContext.getSharedPreferences(ah.dsP(), 0).getBoolean("settings_shake", true);
    ab.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.FALSE });
    this.tHq = System.currentTimeMillis();
    k localk = new k();
    try
    {
      localk.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      localk.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          AppMethodBeat.i(5096);
          paramAnonymousMediaPlayer.release();
          if (System.currentTimeMillis() - h.this.tHq > 5000L) {
            h.this.tHo = 8;
          }
          AppMethodBeat.o(5096);
        }
      });
      localk.setOnErrorListener(new MediaPlayer.OnErrorListener()
      {
        public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(5097);
          if (paramAnonymousMediaPlayer != null)
          {
            paramAnonymousMediaPlayer.release();
            h.this.tHo = 5;
            ab.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramAnonymousMediaPlayer, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
          AppMethodBeat.o(5097);
          return false;
        }
      });
      if (paramBoolean) {
        if (!g.KC().KH()) {
          break label300;
        }
      }
      label300:
      for (paramInt2 = g.KC().KU();; paramInt2 = 0)
      {
        localk.setAudioStreamType(paramInt2);
        if ((paramInt1 == 2131231865) && ((g.KC().KH()) || (g.KC().KN()))) {
          localk.setVolume(0.5F, 0.5F);
        }
        localk.prepare();
        localk.setLooping(false);
        localk.start();
        if (System.currentTimeMillis() - this.tHq > 2000L) {
          this.tHo = 7;
        }
        AppMethodBeat.o(5109);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
      this.tHo = 6;
      AppMethodBeat.o(5109);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(5103);
    ab.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.bVD) });
    cPN();
    if ((this.tHn == null) || (!this.bVD))
    {
      AppMethodBeat.o(5103);
      return;
    }
    try
    {
      this.tHn.stop();
      this.tHn.release();
      if (this.tHr != null) {
        this.faV.removeCallbacks(this.tHr);
      }
      this.bVD = false;
      g.KC().setMode(0);
      AppMethodBeat.o(5103);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.RingPlayer", localException.toString());
      AppMethodBeat.o(5103);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.h
 * JD-Core Version:    0.7.0.1
 */