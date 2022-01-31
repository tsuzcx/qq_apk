package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  public boolean bus = false;
  ah dPi = new ah(Looper.getMainLooper());
  private AudioManager dzw;
  private com.tencent.mm.compatible.util.b eLi;
  private Vibrator hpm;
  public Context mContext;
  public MediaPlayer qbB;
  public int qbC = 65536;
  public long qbD;
  public long qbE;
  i.a qbF;
  
  public i(Context paramContext)
  {
    this.mContext = paramContext;
    if (this.mContext != null)
    {
      this.dzw = f.yi().dui;
      if (this.dzw == null) {
        this.dzw = ((AudioManager)this.mContext.getSystemService("audio"));
      }
      this.hpm = ((Vibrator)this.mContext.getSystemService("vibrator"));
    }
    this.eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
  }
  
  private void bSA()
  {
    if (this.mContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_shake", true))
    {
      int i = this.dzw.getRingerMode();
      y.i("MicroMsg.RingPlayer", "system ringer mode: %s", new Object[] { Integer.valueOf(i) });
      if ((i != 1) && (i != 2)) {
        break label118;
      }
      this.hpm = ((Vibrator)this.mContext.getSystemService("vibrator"));
      if (this.hpm != null) {}
    }
    else
    {
      return;
    }
    this.hpm.vibrate(new long[] { 1000L, 1000L, 1000L, 1000L }, 0);
    return;
    label118:
    y.i("MicroMsg.RingPlayer", "system not open vibrate");
  }
  
  public final void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.qbD = System.currentTimeMillis();
    this.qbB = new j();
    try
    {
      this.qbB.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
      this.qbB.setOnCompletionListener(new i.3(this, paramInt1, paramLong, paramBoolean, paramInt2));
      this.qbB.setOnErrorListener(new i.4(this));
      this.qbB.setAudioStreamType(paramInt2);
      if (paramBoolean) {
        this.qbB.setVolume(0.6F, 0.6F);
      }
      for (;;)
      {
        this.qbB.setLooping(false);
        this.qbB.prepare();
        this.qbB.start();
        if (System.currentTimeMillis() - this.qbD <= 2000L) {
          break;
        }
        this.qbC = 3;
        return;
        bSA();
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException.toString());
    }
  }
  
  public final boolean amn()
  {
    return !this.bus;
  }
  
  public final int bSB()
  {
    y.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.qbC);
    return this.qbC;
  }
  
  public final void kg(boolean paramBoolean)
  {
    int i = 0;
    y.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    int j;
    if (paramBoolean)
    {
      if ((!paramBoolean) || (q.dye.dvw < 0)) {
        break label101;
      }
      j = q.dye.dvw;
    }
    for (;;)
    {
      if (j != this.dzw.getMode()) {
        this.dzw.setMode(j);
      }
      if (paramBoolean != this.dzw.isSpeakerphoneOn()) {
        this.dzw.setSpeakerphoneOn(paramBoolean);
      }
      return;
      if (d.gF(21))
      {
        i = 3;
        break;
      }
      i = 2;
      break;
      label101:
      j = i;
      if (!paramBoolean)
      {
        j = i;
        if (q.dye.dvu >= 0) {
          j = q.dye.dvu;
        }
      }
    }
  }
  
  public final void kh(boolean paramBoolean)
  {
    if (this.bus) {
      return;
    }
    y.i("MicroMsg.RingPlayer", "now we start play ");
    for (;;)
    {
      try
      {
        Uri localUri = RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1);
        this.qbB = j.d(this.mContext, localUri);
        if (this.qbB == null) {
          break;
        }
        this.qbB.stop();
        this.qbB.prepare();
        this.qbB.setLooping(true);
        kg(true);
        if (paramBoolean)
        {
          this.qbB.setVolume(0.6F, 0.6F);
          switch (this.dzw.getRingerMode())
          {
          case 2: 
            this.bus = true;
            return;
          }
        }
      }
      catch (Exception localException)
      {
        y.e("ex", localException.getMessage());
        return;
      }
      bSA();
      continue;
      if (this.qbB != null) {
        this.qbB.start();
      }
    }
  }
  
  /* Error */
  public final void m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifne +110 -> 111
    //   4: invokestatic 318	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   7: invokevirtual 324	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   10: ldc_w 325
    //   13: iconst_1
    //   14: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   17: invokevirtual 331	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 251	java/lang/Boolean
    //   23: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   26: istore 6
    //   28: invokestatic 339	com/tencent/mm/m/a:zT	()Z
    //   31: istore 7
    //   33: invokestatic 342	com/tencent/mm/m/a:zV	()Z
    //   36: istore 8
    //   38: ldc 115
    //   40: ldc_w 344
    //   43: iconst_4
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: iload 6
    //   51: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: iload 7
    //   59: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: iload 8
    //   67: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: iload_3
    //   74: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   77: aastore
    //   78: invokestatic 129	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: iload 7
    //   83: istore 6
    //   85: iload_3
    //   86: ifeq +6 -> 92
    //   89: iconst_1
    //   90: istore 6
    //   92: iload 6
    //   94: istore 7
    //   96: iload 8
    //   98: istore 6
    //   100: iload 7
    //   102: ifne +91 -> 193
    //   105: iload 6
    //   107: ifne +86 -> 193
    //   110: return
    //   111: iload_2
    //   112: iconst_1
    //   113: if_icmpeq +8 -> 121
    //   116: iload_2
    //   117: iconst_2
    //   118: if_icmpne +687 -> 805
    //   121: invokestatic 318	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   124: invokevirtual 324	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   127: ldc_w 345
    //   130: iconst_1
    //   131: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   134: invokevirtual 331	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 251	java/lang/Boolean
    //   140: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   143: istore 6
    //   145: goto -117 -> 28
    //   148: astore 9
    //   150: iconst_1
    //   151: istore 6
    //   153: ldc 115
    //   155: new 159	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 347
    //   162: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload 9
    //   167: invokevirtual 308	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 238	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: iconst_1
    //   180: istore 8
    //   182: iload 6
    //   184: istore 7
    //   186: iload 8
    //   188: istore 6
    //   190: goto -90 -> 100
    //   193: aload_0
    //   194: getfield 34	com/tencent/mm/plugin/voip/video/i:bus	Z
    //   197: ifne -87 -> 110
    //   200: iload 7
    //   202: ifeq +569 -> 771
    //   205: aload_0
    //   206: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   209: putfield 152	com/tencent/mm/plugin/voip/video/i:qbD	J
    //   212: aload_0
    //   213: new 154	com/tencent/mm/compatible/b/j
    //   216: dup
    //   217: invokespecial 155	com/tencent/mm/compatible/b/j:<init>	()V
    //   220: putfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   223: aload_0
    //   224: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   227: aload_0
    //   228: getfield 52	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   231: new 159	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 161
    //   237: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload_0
    //   241: getfield 52	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   244: invokevirtual 167	android/content/Context:getPackageName	()Ljava/lang/String;
    //   247: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 173
    //   252: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload_1
    //   256: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 185	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   265: invokevirtual 191	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   268: aload_0
    //   269: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   272: new 349	com/tencent/mm/plugin/voip/video/i$1
    //   275: dup
    //   276: aload_0
    //   277: invokespecial 350	com/tencent/mm/plugin/voip/video/i$1:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   280: invokevirtual 200	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   283: aload_0
    //   284: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   287: new 352	com/tencent/mm/plugin/voip/video/i$2
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 353	com/tencent/mm/plugin/voip/video/i$2:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   295: invokevirtual 209	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   298: invokestatic 58	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   301: invokevirtual 356	com/tencent/mm/compatible/b/f:yn	()Z
    //   304: istore 7
    //   306: invokestatic 58	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   309: invokevirtual 359	com/tencent/mm/compatible/b/f:yt	()Z
    //   312: istore 8
    //   314: ldc 115
    //   316: ldc_w 361
    //   319: iconst_2
    //   320: anewarray 4	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: iload 7
    //   327: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   330: aastore
    //   331: dup
    //   332: iconst_1
    //   333: iload 8
    //   335: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   338: aastore
    //   339: invokestatic 363	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   342: iload 7
    //   344: ifeq +156 -> 500
    //   347: invokestatic 58	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   350: invokevirtual 366	com/tencent/mm/compatible/b/f:yz	()I
    //   353: istore_1
    //   354: aload_0
    //   355: iconst_0
    //   356: invokevirtual 303	com/tencent/mm/plugin/voip/video/i:kg	(Z)V
    //   359: aload_0
    //   360: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   363: iload_1
    //   364: invokevirtual 213	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   367: iload 8
    //   369: ifne +8 -> 377
    //   372: iload 7
    //   374: ifeq +219 -> 593
    //   377: aload_0
    //   378: getfield 63	com/tencent/mm/plugin/voip/video/i:dzw	Landroid/media/AudioManager;
    //   381: iload_1
    //   382: invokevirtual 370	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   385: istore 5
    //   387: aload_0
    //   388: getfield 63	com/tencent/mm/plugin/voip/video/i:dzw	Landroid/media/AudioManager;
    //   391: iload_1
    //   392: invokevirtual 373	android/media/AudioManager:getStreamVolume	(I)I
    //   395: istore 4
    //   397: iload 4
    //   399: istore_2
    //   400: iload 4
    //   402: iload 5
    //   404: iconst_2
    //   405: idiv
    //   406: if_icmple +8 -> 414
    //   409: iload 5
    //   411: iconst_2
    //   412: idiv
    //   413: istore_2
    //   414: aload_0
    //   415: getfield 63	com/tencent/mm/plugin/voip/video/i:dzw	Landroid/media/AudioManager;
    //   418: iload_1
    //   419: iload_2
    //   420: iconst_0
    //   421: invokevirtual 377	android/media/AudioManager:setStreamVolume	(III)V
    //   424: aload_0
    //   425: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   428: iconst_1
    //   429: invokevirtual 222	android/media/MediaPlayer:setLooping	(Z)V
    //   432: aload_0
    //   433: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   436: invokevirtual 225	android/media/MediaPlayer:prepare	()V
    //   439: aload_0
    //   440: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   443: invokevirtual 228	android/media/MediaPlayer:start	()V
    //   446: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   449: aload_0
    //   450: getfield 152	com/tencent/mm/plugin/voip/video/i:qbD	J
    //   453: lsub
    //   454: ldc2_w 229
    //   457: lcmp
    //   458: ifle +8 -> 466
    //   461: aload_0
    //   462: iconst_3
    //   463: putfield 37	com/tencent/mm/plugin/voip/video/i:qbC	I
    //   466: aload_0
    //   467: iconst_1
    //   468: putfield 34	com/tencent/mm/plugin/voip/video/i:bus	Z
    //   471: return
    //   472: astore 9
    //   474: ldc 115
    //   476: new 159	java/lang/StringBuilder
    //   479: dup
    //   480: ldc 234
    //   482: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload 9
    //   487: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   490: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 238	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: return
    //   500: iload_3
    //   501: ifne +8 -> 509
    //   504: iload 8
    //   506: ifeq +54 -> 560
    //   509: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   512: getfield 380	com/tencent/mm/compatible/e/b:dvt	I
    //   515: iflt +285 -> 800
    //   518: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   521: getfield 380	com/tencent/mm/compatible/e/b:dvt	I
    //   524: istore_1
    //   525: goto +286 -> 811
    //   528: aload_0
    //   529: iconst_0
    //   530: invokevirtual 303	com/tencent/mm/plugin/voip/video/i:kg	(Z)V
    //   533: goto -174 -> 359
    //   536: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   539: getfield 383	com/tencent/mm/compatible/e/b:dvq	I
    //   542: iflt +253 -> 795
    //   545: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   548: getfield 383	com/tencent/mm/compatible/e/b:dvq	I
    //   551: istore_1
    //   552: aload_0
    //   553: iconst_1
    //   554: invokevirtual 303	com/tencent/mm/plugin/voip/video/i:kg	(Z)V
    //   557: goto -198 -> 359
    //   560: invokestatic 58	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
    //   563: invokevirtual 356	com/tencent/mm/compatible/b/f:yn	()Z
    //   566: ifne +224 -> 790
    //   569: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   572: getfield 386	com/tencent/mm/compatible/e/b:dvv	I
    //   575: iflt +215 -> 790
    //   578: getstatic 260	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
    //   581: getfield 386	com/tencent/mm/compatible/e/b:dvv	I
    //   584: istore_1
    //   585: aload_0
    //   586: iconst_1
    //   587: invokevirtual 303	com/tencent/mm/plugin/voip/video/i:kg	(Z)V
    //   590: goto -231 -> 359
    //   593: iload_3
    //   594: ifeq +153 -> 747
    //   597: aload_0
    //   598: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   601: ldc 214
    //   603: ldc 214
    //   605: invokevirtual 218	android/media/MediaPlayer:setVolume	(FF)V
    //   608: goto -184 -> 424
    //   611: astore 9
    //   613: ldc 115
    //   615: new 159	java/lang/StringBuilder
    //   618: dup
    //   619: ldc_w 388
    //   622: invokespecial 164	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   625: aload 9
    //   627: invokevirtual 389	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   630: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 238	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   639: aload_0
    //   640: iconst_2
    //   641: putfield 37	com/tencent/mm/plugin/voip/video/i:qbC	I
    //   644: aload_0
    //   645: getfield 52	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   648: iconst_1
    //   649: invokestatic 295	android/media/RingtoneManager:getActualDefaultRingtoneUri	(Landroid/content/Context;I)Landroid/net/Uri;
    //   652: astore 9
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 52	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   659: aload 9
    //   661: invokestatic 298	com/tencent/mm/compatible/b/j:d	(Landroid/content/Context;Landroid/net/Uri;)Lcom/tencent/mm/compatible/b/j;
    //   664: putfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   667: aload_0
    //   668: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   671: ifnull -561 -> 110
    //   674: aload_0
    //   675: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   678: invokevirtual 301	android/media/MediaPlayer:stop	()V
    //   681: aload_0
    //   682: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   685: invokevirtual 225	android/media/MediaPlayer:prepare	()V
    //   688: aload_0
    //   689: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   692: iconst_1
    //   693: invokevirtual 222	android/media/MediaPlayer:setLooping	(Z)V
    //   696: iload_3
    //   697: ifeq +62 -> 759
    //   700: aload_0
    //   701: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   704: ldc 214
    //   706: ldc 214
    //   708: invokevirtual 218	android/media/MediaPlayer:setVolume	(FF)V
    //   711: aload_0
    //   712: getfield 157	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
    //   715: invokevirtual 228	android/media/MediaPlayer:start	()V
    //   718: aload_0
    //   719: iconst_0
    //   720: putfield 37	com/tencent/mm/plugin/voip/video/i:qbC	I
    //   723: goto -257 -> 466
    //   726: astore 9
    //   728: ldc_w 305
    //   731: aload 9
    //   733: invokevirtual 308	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   736: invokestatic 238	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   739: aload_0
    //   740: iconst_2
    //   741: putfield 37	com/tencent/mm/plugin/voip/video/i:qbC	I
    //   744: goto -278 -> 466
    //   747: iload 6
    //   749: ifeq -325 -> 424
    //   752: aload_0
    //   753: invokespecial 232	com/tencent/mm/plugin/voip/video/i:bSA	()V
    //   756: goto -332 -> 424
    //   759: iload 6
    //   761: ifeq -50 -> 711
    //   764: aload_0
    //   765: invokespecial 232	com/tencent/mm/plugin/voip/video/i:bSA	()V
    //   768: goto -57 -> 711
    //   771: iload 6
    //   773: ifeq -663 -> 110
    //   776: iload_3
    //   777: ifne -667 -> 110
    //   780: aload_0
    //   781: invokespecial 232	com/tencent/mm/plugin/voip/video/i:bSA	()V
    //   784: return
    //   785: astore 9
    //   787: goto -634 -> 153
    //   790: iconst_2
    //   791: istore_1
    //   792: goto -207 -> 585
    //   795: iconst_3
    //   796: istore_1
    //   797: goto -245 -> 552
    //   800: iconst_0
    //   801: istore_1
    //   802: goto +9 -> 811
    //   805: iconst_1
    //   806: istore 6
    //   808: goto -780 -> 28
    //   811: iload 8
    //   813: ifne -285 -> 528
    //   816: iload_2
    //   817: iconst_1
    //   818: if_icmpne -282 -> 536
    //   821: goto -293 -> 528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	i
    //   0	824	1	paramInt1	int
    //   0	824	2	paramInt2	int
    //   0	824	3	paramBoolean	boolean
    //   395	12	4	i	int
    //   385	28	5	j	int
    //   26	781	6	bool1	boolean
    //   31	342	7	bool2	boolean
    //   36	776	8	bool3	boolean
    //   148	18	9	localException1	Exception
    //   472	14	9	localException2	Exception
    //   611	15	9	localThrowable	Throwable
    //   652	8	9	localUri	Uri
    //   726	6	9	localException3	Exception
    //   785	1	9	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   4	28	148	java/lang/Exception
    //   121	145	148	java/lang/Exception
    //   205	223	472	java/lang/Exception
    //   223	342	472	java/lang/Exception
    //   347	359	472	java/lang/Exception
    //   359	367	472	java/lang/Exception
    //   377	397	472	java/lang/Exception
    //   400	414	472	java/lang/Exception
    //   414	424	472	java/lang/Exception
    //   424	466	472	java/lang/Exception
    //   466	471	472	java/lang/Exception
    //   509	525	472	java/lang/Exception
    //   528	533	472	java/lang/Exception
    //   536	552	472	java/lang/Exception
    //   552	557	472	java/lang/Exception
    //   560	585	472	java/lang/Exception
    //   585	590	472	java/lang/Exception
    //   597	608	472	java/lang/Exception
    //   613	644	472	java/lang/Exception
    //   728	744	472	java/lang/Exception
    //   752	756	472	java/lang/Exception
    //   223	342	611	java/lang/Throwable
    //   347	359	611	java/lang/Throwable
    //   359	367	611	java/lang/Throwable
    //   377	397	611	java/lang/Throwable
    //   400	414	611	java/lang/Throwable
    //   414	424	611	java/lang/Throwable
    //   424	466	611	java/lang/Throwable
    //   509	525	611	java/lang/Throwable
    //   528	533	611	java/lang/Throwable
    //   536	552	611	java/lang/Throwable
    //   552	557	611	java/lang/Throwable
    //   560	585	611	java/lang/Throwable
    //   585	590	611	java/lang/Throwable
    //   597	608	611	java/lang/Throwable
    //   752	756	611	java/lang/Throwable
    //   644	696	726	java/lang/Exception
    //   700	711	726	java/lang/Exception
    //   711	723	726	java/lang/Exception
    //   764	768	726	java/lang/Exception
    //   28	81	785	java/lang/Exception
  }
  
  public final void n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.qbC = 0;
    if (paramInt1 == 0)
    {
      kh(paramBoolean);
      return;
    }
    m(paramInt1, paramInt2, paramBoolean);
  }
  
  public final void o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 == a.d.playend) && (!f.yi().yn()) && (!f.yi().yt()) && ((this.dzw.getRingerMode() == 0) || (this.dzw.getRingerMode() == 1))) {
      return;
    }
    this.mContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_shake", true);
    y.i("MicroMsg.RingPlayer", "playSound, type: %s, changeStreamType: %s, shake: %s", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Boolean.valueOf(false) });
    this.qbE = System.currentTimeMillis();
    j localj = new j();
    for (;;)
    {
      try
      {
        localj.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + paramInt1));
        localj.setOnCompletionListener(new i.5(this));
        localj.setOnErrorListener(new i.6(this));
        if (paramBoolean)
        {
          if (f.yi().yn())
          {
            paramInt2 = f.yi().yz();
            localj.setAudioStreamType(paramInt2);
          }
        }
        else
        {
          if ((paramInt1 == a.d.playend) && ((f.yi().yn()) || (f.yi().yt()))) {
            localj.setVolume(0.5F, 0.5F);
          }
          localj.prepare();
          localj.setLooping(false);
          localj.start();
          if (System.currentTimeMillis() - this.qbE <= 2000L) {
            break;
          }
          this.qbC = 7;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        y.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
        this.qbC = 6;
        return;
      }
      paramInt2 = 0;
    }
  }
  
  public final void stop()
  {
    y.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[] { Boolean.valueOf(this.bus) });
    if (this.hpm != null)
    {
      this.hpm.cancel();
      this.hpm = null;
    }
    if ((this.qbB == null) || (!this.bus)) {
      return;
    }
    try
    {
      this.qbB.stop();
      this.qbB.release();
      if (this.qbF != null) {
        this.dPi.removeCallbacks(this.qbF);
      }
      this.bus = false;
      f.yi().setMode(0);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.RingPlayer", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i
 * JD-Core Version:    0.7.0.1
 */