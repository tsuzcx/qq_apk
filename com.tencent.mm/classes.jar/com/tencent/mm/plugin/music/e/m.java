package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.h.a.jx;
import com.tencent.mm.h.a.jx.b;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.ah.f, e
{
  private int mode = 1;
  private int mzb;
  private List<String> mzc = new ArrayList();
  private com.tencent.mm.plugin.music.model.notification.b mzd = new com.tencent.mm.plugin.music.model.notification.b();
  private com.tencent.mm.plugin.music.model.b.b mze;
  private com.tencent.mm.plugin.music.model.b.a mzf;
  private com.tencent.mm.plugin.music.model.b.c mzg;
  private boolean mzh;
  
  private void bno()
  {
    com.tencent.mm.sdk.f.e.post(new a((byte)0), "music_get_list_task");
  }
  
  public final String Jw(String paramString)
  {
    paramString = com.tencent.mm.plugin.music.model.a.b.Jw(paramString);
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    return com.tencent.mm.plugin.music.model.a.b.JB(paramString);
  }
  
  public final URL Jx(String paramString)
  {
    return new b.b(paramString).url;
  }
  
  public final void a(com.tencent.mm.av.e parame, int paramInt)
  {
    super.a(parame, paramInt);
    com.tencent.mm.plugin.music.model.d.d.bnx();
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    if (this.mze != null)
    {
      com.tencent.mm.kernel.g.DO().dJT.c(this.mze);
      this.mze = null;
    }
    if (parama.field_songId <= 0)
    {
      y.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId ");
      h.nFQ.aC(10911, "1");
      return;
    }
    this.mze = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean);
    com.tencent.mm.kernel.g.DO().dJT.a(this.mze, 0);
  }
  
  public final com.tencent.mm.av.e bmW()
  {
    if (this.mzc.size() <= this.mzb) {
      return null;
    }
    Object localObject = (String)this.mzc.get(this.mzb);
    localObject = com.tencent.mm.plugin.music.model.e.bnq().JE((String)localObject);
    if (localObject != null) {
      return ((com.tencent.mm.plugin.music.model.e.a)localObject).bnB();
    }
    return null;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a bna()
  {
    if (this.mzc.size() <= this.mzb) {
      return null;
    }
    String str = (String)this.mzc.get(this.mzb);
    return com.tencent.mm.plugin.music.model.e.bnq().JE(str);
  }
  
  public final boolean bnb()
  {
    com.tencent.mm.plugin.music.model.e.a locala = bna();
    if (locala != null) {}
    switch (locala.field_musicType)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      return false;
    }
    return true;
  }
  
  public final List<String> bnc()
  {
    return this.mzc;
  }
  
  public final void bnd()
  {
    this.mode = 1;
  }
  
  public final void bne()
  {
    if (this.mode == 1) {
      return;
    }
    this.mzb += 1;
    this.mzb %= this.mzc.size();
    this.myR.hR(true);
    this.myR.p(null);
  }
  
  public final void bnf()
  {
    if (this.mode == 1) {
      return;
    }
    this.mzb = (this.mzb + this.mzc.size() - 1);
    this.mzb %= this.mzc.size();
    this.myR.hR(true);
    this.myR.p(null);
  }
  
  public final int bng()
  {
    return this.mzb;
  }
  
  public final void bnh()
  {
    if (!this.myR.bmY().Pu())
    {
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
  }
  
  public final boolean bni()
  {
    return (this.mzc.size() > 0) && (this.mode == 2);
  }
  
  /* Error */
  public final void d(List<com.tencent.mm.av.e> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokeinterface 165 1 0
    //   12: ifne +13 -> 25
    //   15: ldc 74
    //   17: ldc 236
    //   19: invokestatic 231	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iload_2
    //   26: ifeq +12 -> 38
    //   29: aload_0
    //   30: getfield 40	com/tencent/mm/plugin/music/e/m:mzc	Ljava/util/List;
    //   33: invokeinterface 239 1 0
    //   38: aload_1
    //   39: invokeinterface 243 1 0
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 248 1 0
    //   51: ifeq -29 -> 22
    //   54: aload_1
    //   55: invokeinterface 252 1 0
    //   60: checkcast 254	com/tencent/mm/av/e
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 40	com/tencent/mm/plugin/music/e/m:mzc	Ljava/util/List;
    //   68: aload_3
    //   69: invokestatic 260	com/tencent/mm/plugin/music/h/b:K	(Lcom/tencent/mm/av/e;)Ljava/lang/String;
    //   72: invokeinterface 264 2 0
    //   77: pop
    //   78: invokestatic 177	com/tencent/mm/plugin/music/model/e:bnq	()Lcom/tencent/mm/plugin/music/model/e/b;
    //   81: aload_3
    //   82: invokevirtual 268	com/tencent/mm/plugin/music/model/e/b:x	(Lcom/tencent/mm/av/e;)Lcom/tencent/mm/plugin/music/model/e/a;
    //   85: pop
    //   86: goto -41 -> 45
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	m
    //   0	94	1	paramList	List<com.tencent.mm.av.e>
    //   0	94	2	paramBoolean	boolean
    //   63	19	3	locale	com.tencent.mm.av.e
    // Exception table:
    //   from	to	target	type
    //   6	15	89	finally
    //   15	22	89	finally
    //   29	38	89	finally
    //   38	45	89	finally
    //   45	86	89	finally
  }
  
  public final boolean g(com.tencent.mm.av.e parame)
  {
    boolean bool = true;
    if (parame == null)
    {
      y.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      bool = false;
    }
    com.tencent.mm.plugin.music.model.e.a locala;
    label60:
    do
    {
      return bool;
      locala = bna();
      int i;
      if (locala != null)
      {
        if (locala != null) {
          break label60;
        }
        i = 0;
      }
      while (i == 0)
      {
        y.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
        this.myR.r(parame);
        return false;
        if ((TextUtils.isEmpty(locala.field_songWifiUrl)) && (TextUtils.isEmpty(locala.field_songWapLinkUrl)) && (TextUtils.isEmpty(locala.field_songWebUrl))) {
          i = 0;
        } else {
          i = 1;
        }
      }
      if (locala.field_isBlock == 1)
      {
        y.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
        this.myR.r(parame);
        com.tencent.mm.plugin.music.model.d.d.s(parame);
        return false;
      }
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
      locala.playUrl = parame.playUrl;
      if (this.mzf != null) {
        com.tencent.mm.kernel.g.DO().dJT.c(this.mzf);
      }
      com.tencent.mm.kernel.g.DO().dJT.a(940, this);
      this.mzf = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
      com.tencent.mm.kernel.g.DO().dJT.a(this.mzf, 0);
    } while (!com.tencent.mm.plugin.music.model.a.b.b(locala));
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
    parame = locala.playUrl;
    if (TextUtils.isEmpty(parame)) {
      y.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
    }
    for (;;)
    {
      return false;
      if (this.mzg != null)
      {
        com.tencent.mm.kernel.g.DO().dJT.c(this.mzg);
        this.mzg = null;
      }
      y.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { parame });
      this.mzg = new com.tencent.mm.plugin.music.model.b.c(parame);
      com.tencent.mm.kernel.g.DO().dJT.a(this.mzg, 0);
      h.nFQ.a(558L, 213L, 1L, true);
    }
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final com.tencent.mm.av.e h(com.tencent.mm.av.e parame)
  {
    Object localObject = com.tencent.mm.plugin.music.h.b.K(parame);
    int i;
    if (this.mzc != null)
    {
      i = 0;
      if (i < this.mzc.size()) {
        if (((String)localObject).equals(this.mzc.get(i)))
        {
          this.mzb = i;
          i = 1;
          label53:
          j = i;
          if (this.mzc.size() > 1)
          {
            j = i;
            if (parame.euS) {
              this.mode = 2;
            }
          }
        }
      }
    }
    for (int j = i;; j = 0)
    {
      if (j != 0) {
        localObject = bmW();
      }
      do
      {
        return localObject;
        i += 1;
        break;
        this.mzc.clear();
        this.mzc.add(com.tencent.mm.plugin.music.h.b.K(parame));
        this.mzb = 0;
        com.tencent.mm.plugin.music.model.e.bnq().x(parame);
        localObject = parame;
      } while (this.mode != 2);
      bno();
      return parame;
      i = 0;
      break label53;
    }
  }
  
  public final com.tencent.mm.av.e h(List<com.tencent.mm.av.e> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      return null;
    }
    this.mzc.clear();
    int i = 0;
    while (i < paramList.size())
    {
      com.tencent.mm.av.e locale = (com.tencent.mm.av.e)paramList.get(i);
      this.mzc.add(com.tencent.mm.plugin.music.h.b.K(locale));
      com.tencent.mm.plugin.music.model.e.bnq().x(locale);
      i += 1;
    }
    this.mzb = paramInt;
    this.mode = 2;
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.mzb) });
    return bmW();
  }
  
  public final com.tencent.mm.av.e i(com.tencent.mm.av.e parame)
  {
    com.tencent.mm.av.e locale;
    if ((parame == null) && (this.mzc.size() == 0))
    {
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      locale = null;
    }
    do
    {
      return locale;
      if (parame == null) {
        return bmW();
      }
      this.mzc.clear();
      this.mzc.add(com.tencent.mm.plugin.music.h.b.K(parame));
      this.mzb = 0;
      com.tencent.mm.plugin.music.model.e.bnq().x(parame);
      locale = parame;
    } while (this.mode != 2);
    bno();
    return parame;
  }
  
  public final void init()
  {
    super.init();
    com.tencent.mm.kernel.g.DO().dJT.a(520, this);
    com.tencent.mm.kernel.g.DO().dJT.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.mzd;
    y.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.giK = new b.1(localb);
    localb.giK.cqo();
  }
  
  public final void j(com.tencent.mm.av.e parame)
  {
    if (parame != null)
    {
      this.mzc.clear();
      this.mzc.add(com.tencent.mm.plugin.music.h.b.K(parame));
      this.mzb = 0;
      com.tencent.mm.plugin.music.model.e.bnq().x(parame);
      return;
    }
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
  }
  
  public final void k(com.tencent.mm.av.e parame)
  {
    super.k(parame);
    com.tencent.mm.plugin.music.model.d.d.bnx();
    com.tencent.mm.plugin.music.model.d.d.eaQ = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.d.e(bna());
  }
  
  public final void l(com.tencent.mm.av.e parame)
  {
    super.l(parame);
    com.tencent.mm.plugin.music.model.d.d.eaQ = System.currentTimeMillis();
  }
  
  public final void m(com.tencent.mm.av.e parame)
  {
    super.m(parame);
    com.tencent.mm.plugin.music.model.d.d.yu();
  }
  
  public final void n(com.tencent.mm.av.e parame)
  {
    super.n(parame);
    com.tencent.mm.plugin.music.model.d.d.bnx();
  }
  
  public final void o(com.tencent.mm.av.e parame)
  {
    super.o(parame);
    com.tencent.mm.plugin.music.model.d.d.bnx();
    if (this.mode == 2) {
      bne();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject1;
    if ((paramm instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.DO().dJT.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramm = ((com.tencent.mm.plugin.music.model.b.a)paramm).mzG;
        if ((bna() != null) && (paramm.eux.equals(bna().field_musicId))) {
          this.myR.Ps();
        }
        paramString = com.tencent.mm.plugin.music.model.e.bnq();
        paramm = paramm.eux;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.dXw.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramm });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.mAr.get(paramm);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        y.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { bna().field_musicId });
      }
      return;
      break label257;
    }
    label257:
    do
    {
      do
      {
        for (;;)
        {
          if ((paramm instanceof com.tencent.mm.plugin.music.model.b.b)) {
            if ((paramInt1 == 0) && (paramInt2 == 0))
            {
              paramString = (com.tencent.mm.plugin.music.model.b.b)paramm;
              Object localObject3 = paramString.mzH;
              localObject1 = paramString.mzx.field_musicId;
              if ((localObject3 != null) && (localObject1 != null))
              {
                Object localObject2 = this.mzc.iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  paramm = (String)((Iterator)localObject2).next();
                  if (!paramm.equals(localObject1)) {
                    break;
                  }
                  localObject1 = aa.b(((ajj)localObject3).tfY);
                  localObject2 = aa.b(((ajj)localObject3).tfZ);
                  localObject3 = aa.b(((ajj)localObject3).tfX);
                  com.tencent.mm.plugin.music.model.e.b localb = com.tencent.mm.plugin.music.model.e.bnq();
                  boolean bool = paramString.mzI;
                  com.tencent.mm.plugin.music.model.e.a locala = localb.JE(paramm);
                  if (locala == null) {
                    y.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[] { paramm });
                  }
                  for (;;)
                  {
                    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { localObject1, localObject2, localObject3 });
                    if (bk.bl((String)localObject2)) {
                      break;
                    }
                    paramm = new jy();
                    paramm.bSA.action = 6;
                    paramm.bSA.bSB = paramString.mzx.field_musicId;
                    com.tencent.mm.sdk.b.a.udP.a(paramm, Looper.getMainLooper());
                    return;
                    if (!bk.bl((String)localObject1)) {
                      locala.field_songAlbumUrl = ((String)localObject1);
                    }
                    locala.field_songHAlbumUrl = ((String)localObject2);
                    locala.field_songLyric = ((String)localObject3);
                    localb.c(locala, new String[] { "songAlbumUrl", "songHAlbumUrl", "songLyric" });
                    localb.mAr.put(paramm, locala);
                    localb.b(locala, bool);
                  }
                }
              }
            }
          }
        }
      } while (!(paramm instanceof com.tencent.mm.plugin.music.model.b.c));
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (com.tencent.mm.plugin.music.model.b.c)paramm;
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.mzK });
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        h.nFQ.a(558L, 214L, 1L, true);
      }
      for (;;)
      {
        paramm = bna();
        if ((paramm == null) || (TextUtils.isEmpty(paramm.playUrl)) || (!paramm.playUrl.equalsIgnoreCase(paramString.playUrl))) {
          break;
        }
        y.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
        this.myR.q(paramm.bnB());
        return;
        com.tencent.mm.plugin.music.model.a.b.ef(paramString.playUrl, paramString.mzK);
      }
    } while (paramm == null);
    y.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramm.playUrl, paramString.playUrl });
  }
  
  public final void release()
  {
    this.mzc.clear();
    com.tencent.mm.kernel.g.DO().dJT.b(520, this);
    com.tencent.mm.kernel.g.DO().dJT.b(940, this);
    com.tencent.mm.kernel.g.DO().dJT.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.mzd;
    y.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(ae.getContext(), MMMusicPlayerService.class);
    ae.getContext().stopService(localIntent);
    localb.mzL = null;
    localb.giK.dead();
  }
  
  public final void sP(int paramInt)
  {
    h.nFQ.a(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.mzh)
      {
        y.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        return;
      }
      this.mode = 2;
      if (this.mzc.size() <= 1) {
        bno();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.d.R(1, 2, paramInt);
        return;
        localjy = new jy();
        localjy.bSA.action = 5;
        com.tencent.mm.sdk.b.a.udP.m(localjy);
      }
    }
    this.mode = 1;
    jy localjy = new jy();
    localjy.bSA.action = 5;
    com.tencent.mm.sdk.b.a.udP.m(localjy);
    com.tencent.mm.plugin.music.model.d.d.R(2, 1, paramInt);
  }
  
  public final boolean uJ(int paramInt)
  {
    return com.tencent.mm.plugin.music.model.c.a.uJ(paramInt);
  }
  
  public final void uL(int paramInt)
  {
    if (this.mzc.size() == 0) {}
    do
    {
      return;
      int i = (paramInt - 100000) % this.mzc.size();
      paramInt = i;
      if (i < 0) {
        paramInt = i + this.mzc.size();
      }
    } while (paramInt == this.mzb);
    this.mzb = paramInt;
    this.myR.p(null);
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      long l = System.currentTimeMillis();
      m.a(m.this, true);
      Object localObject1 = m.this.bmW();
      ArrayList localArrayList = new ArrayList();
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper.MusicType:%d", new Object[] { Integer.valueOf(((com.tencent.mm.av.e)localObject1).euv) });
      int i;
      label114:
      Object localObject2;
      switch (((com.tencent.mm.av.e)localObject1).euv)
      {
      case 2: 
      case 3: 
      case 5: 
      case 7: 
      default: 
        localObject1 = null;
        if (localObject1 == null) {
          break label356;
        }
        i = 0;
        if (i >= ((List)localObject1).size()) {
          break label356;
        }
        localObject2 = (com.tencent.mm.av.e)((List)localObject1).get(i);
        if (localObject2 == null) {
          y.e("MicroMsg.Music.MusicWechatPrivateLogic", "wrapper is null, continue");
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break label114;
        localObject1 = new gf();
        ((gf)localObject1).bNF.type = 18;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((gf)localObject1).bNG.bNT;
        break;
        localObject1 = new jx();
        ((jx)localObject1).bSs.action = -4;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((jx)localObject1).bSt.bNT;
        break;
        localObject1 = new jx();
        ((jx)localObject1).bSs.action = -5;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = ((jx)localObject1).bSt.bNT;
        break;
        localObject2 = new jx();
        ((jx)localObject2).bSs.action = -6;
        ((jx)localObject2).bSs.bSu = ((com.tencent.mm.av.e)localObject1);
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        localObject1 = ((jx)localObject2).bSt.bNT;
        break;
        com.tencent.mm.plugin.music.model.e.bnq().x((com.tencent.mm.av.e)localObject2);
        localArrayList.add(com.tencent.mm.plugin.music.h.b.K((com.tencent.mm.av.e)localObject2));
      }
      label356:
      y.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetMusicWrapperListTask run time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      m.a(m.this, false);
      localObject1 = new m.b(m.this, (byte)0);
      ((m.b)localObject1).mzj = localArrayList;
      ai.d((Runnable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */