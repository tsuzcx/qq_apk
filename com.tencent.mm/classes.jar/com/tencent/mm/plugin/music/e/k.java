package com.tencent.mm.plugin.music.e;

import android.text.TextUtils;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends h
{
  static k myZ;
  public a myY = null;
  private com.tencent.mm.plugin.music.h.a mza;
  
  private k(a parama)
  {
    this.myY = parama;
  }
  
  /* Error */
  public static void a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/mm/plugin/music/e/k:myZ	Lcom/tencent/mm/plugin/music/e/k;
    //   6: ifnull +36 -> 42
    //   9: ldc 23
    //   11: ldc 25
    //   13: invokestatic 31	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 21	com/tencent/mm/plugin/music/e/k:myZ	Lcom/tencent/mm/plugin/music/e/k;
    //   19: aload_0
    //   20: putfield 17	com/tencent/mm/plugin/music/e/k:myY	Lcom/tencent/mm/plugin/music/e/a;
    //   23: aload_0
    //   24: getstatic 21	com/tencent/mm/plugin/music/e/k:myZ	Lcom/tencent/mm/plugin/music/e/k;
    //   27: invokeinterface 36 2 0
    //   32: aload_0
    //   33: invokeinterface 39 1 0
    //   38: ldc 2
    //   40: monitorexit
    //   41: return
    //   42: new 2	com/tencent/mm/plugin/music/e/k
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 41	com/tencent/mm/plugin/music/e/k:<init>	(Lcom/tencent/mm/plugin/music/e/a;)V
    //   50: putstatic 21	com/tencent/mm/plugin/music/e/k:myZ	Lcom/tencent/mm/plugin/music/e/k;
    //   53: aload_0
    //   54: getstatic 21	com/tencent/mm/plugin/music/e/k:myZ	Lcom/tencent/mm/plugin/music/e/k;
    //   57: invokeinterface 36 2 0
    //   62: aload_0
    //   63: invokeinterface 39 1 0
    //   68: goto -30 -> 38
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	parama	a
    // Exception table:
    //   from	to	target	type
    //   3	38	71	finally
    //   42	68	71	finally
  }
  
  public static k bnl()
  {
    if (myZ == null) {
      throw new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
    }
    if (myZ.myY == null) {
      myZ.myY = new i();
    }
    return myZ;
  }
  
  public static void bnm()
  {
    try
    {
      if (myZ != null) {
        myZ.finish();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.mm.plugin.music.h.a bnn()
  {
    if (bnl().mza == null) {
      bnl().mza = new com.tencent.mm.plugin.music.h.a();
    }
    return bnl().mza;
  }
  
  public final void Ps()
  {
    super.Ps();
  }
  
  public final com.tencent.mm.av.e bmW()
  {
    return this.myY.bmW();
  }
  
  public final com.tencent.mm.plugin.music.f.a.d bmY()
  {
    return super.bmY();
  }
  
  public final void finish()
  {
    super.finish();
    this.myY.release();
    this.mza = null;
  }
  
  public final void hR(boolean paramBoolean)
  {
    super.hR(paramBoolean);
  }
  
  public final void p(com.tencent.mm.av.e parame)
  {
    if (parame != null) {
      y.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[] { Integer.valueOf(parame.euv) });
    }
    y.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
    t(this.myY.i(parame));
  }
  
  public final void release()
  {
    y.i("MicroMsg.Music.MusicPlayerManager", "release");
    super.release();
  }
  
  final void t(com.tencent.mm.av.e parame)
  {
    boolean bool1;
    Object localObject2;
    Object localObject1;
    label71:
    String str2;
    int i;
    label131:
    int j;
    label141:
    label178:
    String str3;
    String str1;
    if (parame == null)
    {
      y.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
      if (this.myY.g(parame)) {
        q(parame);
      }
    }
    else
    {
      bool1 = aq.isWifi(ae.getContext());
      boolean bool2 = aq.isNetworkConnected(ae.getContext());
      localObject2 = new PBool();
      if (bk.bl(parame.euD))
      {
        localObject1 = parame.euF;
        String str4 = parame.euE;
        str2 = com.tencent.mm.plugin.music.h.e.a((String)localObject1, str4, bool1, (PBool)localObject2);
        y.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", new Object[] { str2 });
        y.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", new Object[] { parame.euD });
        if (!bool1) {
          break label332;
        }
        i = 1;
        if (!((PBool)localObject2).value) {
          break label337;
        }
        j = 1;
        y.i("MicroMsg.Music.MusicUrlParser", "isWifi:%d, isQQMusic:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bool1) {
          break label342;
        }
        bool1 = ((PBool)localObject2).value;
        if (com.tencent.mm.plugin.music.h.e.JK(str2))
        {
          y.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
          bool1 = true;
        }
        str3 = "";
        if (bool2) {
          break label448;
        }
        y.i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
        str1 = com.tencent.mm.plugin.music.h.e.a((String)localObject1, str4, true, (PBool)localObject2);
        localObject2 = com.tencent.mm.plugin.music.h.e.a((String)localObject1, str4, false, (PBool)localObject2);
        if (str1 != null)
        {
          localObject1 = str3;
          if (str1.equals(localObject2)) {}
        }
        else
        {
          if (!c.L(parame)) {
            break label348;
          }
          y.i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
          localObject1 = str3;
        }
        label273:
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(str2))) {
          break label448;
        }
        y.i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", new Object[] { localObject1 });
      }
    }
    for (;;)
    {
      parame.playUrl = ((String)localObject1);
      g.aM((String)localObject1, bool1);
      break;
      localObject1 = parame.euD;
      break label71;
      label332:
      i = 0;
      break label131;
      label337:
      j = 0;
      break label141;
      label342:
      bool1 = false;
      break label178;
      label348:
      if (c.vb(parame.euv))
      {
        y.i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
        if (com.tencent.mm.plugin.music.h.d.JJ(str1))
        {
          localObject1 = str1;
          break label273;
        }
        localObject1 = str3;
        if (!com.tencent.mm.plugin.music.h.d.JJ((String)localObject2)) {
          break label273;
        }
        localObject1 = localObject2;
        break label273;
      }
      if (com.tencent.mm.plugin.music.h.d.d(parame, true)) {
        localObject1 = str1;
      }
      for (;;)
      {
        y.i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
        break;
        localObject1 = localObject2;
        if (!com.tencent.mm.plugin.music.h.d.d(parame, false)) {
          localObject1 = "";
        }
      }
      y.e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
      return;
      label448:
      localObject1 = str2;
    }
  }
  
  public final void uM(int paramInt)
  {
    super.uM(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.k
 * JD-Core Version:    0.7.0.1
 */