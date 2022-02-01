package com.tencent.mm.plugin.music.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.network.b.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.model.notification.b.1;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class m
  extends g
  implements com.tencent.mm.ak.f, e
{
  private Object lockObj;
  private int mode;
  private com.tencent.mm.plugin.music.model.b.b wAa;
  private com.tencent.mm.plugin.music.model.b.a wAb;
  private com.tencent.mm.plugin.music.model.b.c wAc;
  private boolean wAd;
  private int wzX;
  private List<String> wzY;
  private com.tencent.mm.plugin.music.model.notification.b wzZ;
  
  public m()
  {
    AppMethodBeat.i(62966);
    this.mode = 1;
    this.wzY = new ArrayList();
    this.wzZ = new com.tencent.mm.plugin.music.model.notification.b();
    this.lockObj = new Object();
    AppMethodBeat.o(62966);
  }
  
  private void dws()
  {
    AppMethodBeat.i(62980);
    com.tencent.mm.sdk.g.b.c(new m.a(this, (byte)0), "music_get_list_task");
    AppMethodBeat.o(62980);
  }
  
  public final void Ji(int paramInt)
  {
    AppMethodBeat.i(62979);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(285L, 2L, 1L, false);
    if (this.mode == 1)
    {
      if (this.wAd)
      {
        ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "already running get list");
        AppMethodBeat.o(62979);
        return;
      }
      this.mode = 2;
      if (this.wzY.size() <= 1) {
        dws();
      }
      for (;;)
      {
        com.tencent.mm.plugin.music.model.d.e.an(1, 2, paramInt);
        AppMethodBeat.o(62979);
        return;
        localmg = new mg();
        localmg.dAP.action = 5;
        com.tencent.mm.sdk.b.a.IvT.l(localmg);
      }
    }
    this.mode = 1;
    mg localmg = new mg();
    localmg.dAP.action = 5;
    com.tencent.mm.sdk.b.a.IvT.l(localmg);
    com.tencent.mm.plugin.music.model.d.e.an(2, 1, paramInt);
    AppMethodBeat.o(62979);
  }
  
  public final boolean LP(int paramInt)
  {
    AppMethodBeat.i(62986);
    boolean bool = com.tencent.mm.plugin.music.model.c.a.LP(paramInt);
    AppMethodBeat.o(62986);
    return bool;
  }
  
  public final void LR(int paramInt)
  {
    AppMethodBeat.i(62981);
    if (this.wzY.size() == 0)
    {
      AppMethodBeat.o(62981);
      return;
    }
    int i = (paramInt - 100000) % this.wzY.size();
    paramInt = i;
    if (i < 0) {
      paramInt = i + this.wzY.size();
    }
    if (paramInt != this.wzX)
    {
      this.wzX = paramInt;
      this.wzO.s(null);
    }
    AppMethodBeat.o(62981);
  }
  
  public final String YI(String paramString)
  {
    AppMethodBeat.i(62987);
    paramString = com.tencent.mm.plugin.music.model.a.b.YI(paramString);
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "contain shake tag playUrl:%s", new Object[] { paramString });
    paramString = com.tencent.mm.plugin.music.model.a.b.atS(paramString);
    AppMethodBeat.o(62987);
    return paramString;
  }
  
  public final void a(com.tencent.mm.ay.f paramf, int paramInt)
  {
    AppMethodBeat.i(62994);
    super.a(paramf, paramInt);
    com.tencent.mm.plugin.music.model.d.e.dwC();
    AppMethodBeat.o(62994);
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(220667);
    if (parama == null)
    {
      AppMethodBeat.o(220667);
      return;
    }
    if (this.wAa != null)
    {
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAa);
      this.wAa = null;
    }
    if ((parama.field_songId <= 0) && (TextUtils.isEmpty(parama.field_songMId)))
    {
      ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "can't get songId and mid is empty");
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10911, "1");
      AppMethodBeat.o(220667);
      return;
    }
    this.wAa = new com.tencent.mm.plugin.music.model.b.b(parama, paramBoolean1, paramBoolean2);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAa, 0);
    AppMethodBeat.o(220667);
  }
  
  public final URL atO(String paramString)
  {
    AppMethodBeat.i(62988);
    paramString = new b.b(paramString).url;
    AppMethodBeat.o(62988);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.music.model.e.a atP(String paramString)
  {
    AppMethodBeat.i(62975);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62975);
      return null;
    }
    com.tencent.mm.plugin.music.model.e.a locala = com.tencent.mm.plugin.music.model.f.dwu().atW(paramString);
    if (locala != null)
    {
      this.wzY.add(paramString);
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data exist in db , id:%s", new Object[] { paramString });
    }
    for (;;)
    {
      AppMethodBeat.o(62975);
      return locala;
      ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "getMusicByDBMusicId, music data not exist in db , id:%s", new Object[] { paramString });
    }
  }
  
  public final com.tencent.mm.ay.f dwa()
  {
    AppMethodBeat.i(62977);
    synchronized (this.lockObj)
    {
      if (this.wzY.size() == 0)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      if (this.wzY.size() <= this.wzX)
      {
        AppMethodBeat.o(62977);
        return null;
      }
      Object localObject2 = (String)this.wzY.get(this.wzX);
      localObject2 = com.tencent.mm.plugin.music.model.f.dwu().atW((String)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.music.model.e.a)localObject2).dwG();
        AppMethodBeat.o(62977);
        return localObject2;
      }
      AppMethodBeat.o(62977);
      return null;
    }
  }
  
  public final com.tencent.mm.plugin.music.model.e.a dwe()
  {
    AppMethodBeat.i(62976);
    synchronized (this.lockObj)
    {
      if (this.wzY.size() == 0)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      if (this.wzY.size() <= this.wzX)
      {
        AppMethodBeat.o(62976);
        return null;
      }
      Object localObject2 = (String)this.wzY.get(this.wzX);
      localObject2 = com.tencent.mm.plugin.music.model.f.dwu().atW((String)localObject2);
      AppMethodBeat.o(62976);
      return localObject2;
    }
  }
  
  public final boolean dwf()
  {
    AppMethodBeat.i(62978);
    com.tencent.mm.plugin.music.model.e.a locala = dwe();
    if (locala != null) {}
    switch (locala.field_musicType)
    {
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    default: 
      AppMethodBeat.o(62978);
      return false;
    }
    AppMethodBeat.o(62978);
    return true;
  }
  
  public final List<String> dwg()
  {
    return this.wzY;
  }
  
  public final void dwh()
  {
    this.mode = 1;
  }
  
  public final void dwi()
  {
    AppMethodBeat.i(62982);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62982);
      return;
    }
    this.wzX += 1;
    this.wzX %= this.wzY.size();
    this.wzO.pk(true);
    this.wzO.s(null);
    AppMethodBeat.o(62982);
  }
  
  public final void dwj()
  {
    AppMethodBeat.i(62983);
    if (this.mode == 1)
    {
      AppMethodBeat.o(62983);
      return;
    }
    this.wzX = (this.wzX + this.wzY.size() - 1);
    this.wzX %= this.wzY.size();
    this.wzO.pk(true);
    this.wzO.s(null);
    AppMethodBeat.o(62983);
  }
  
  public final int dwk()
  {
    return this.wzX;
  }
  
  public final void dwl()
  {
    AppMethodBeat.i(62984);
    if (!this.wzO.dwc().aJZ())
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "really exit music");
      this.mode = 1;
    }
    AppMethodBeat.o(62984);
  }
  
  public final boolean dwm()
  {
    AppMethodBeat.i(62985);
    if ((this.wzY.size() > 0) && (this.mode == 2))
    {
      AppMethodBeat.o(62985);
      return true;
    }
    AppMethodBeat.o(62985);
    return false;
  }
  
  public final void e(List<com.tencent.mm.ay.f> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(62974);
        if ((paramList == null) || (paramList.size() == 0))
        {
          ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "appendMusicList error");
          AppMethodBeat.o(62974);
          return;
        }
        localObject = this.lockObj;
        if (paramBoolean) {}
        try
        {
          this.wzY.clear();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.ay.f localf = (com.tencent.mm.ay.f)paramList.next();
            this.wzY.add(com.tencent.mm.plugin.music.h.b.O(localf));
            com.tencent.mm.plugin.music.model.f.dwu().B(localf);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          AppMethodBeat.o(62974);
        }
      }
      finally {}
      AppMethodBeat.o(62974);
    }
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  public final boolean i(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62969);
    if (paramf == null)
    {
      ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is false, do not start music");
      AppMethodBeat.o(62969);
      return false;
    }
    com.tencent.mm.plugin.music.model.e.a locala = dwe();
    int i;
    if (locala != null)
    {
      if (locala != null) {
        break label71;
      }
      i = 0;
    }
    while (i == 0)
    {
      ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "music or url is null, do not start music");
      this.wzO.u(paramf);
      AppMethodBeat.o(62969);
      return false;
      label71:
      if ((TextUtils.isEmpty(locala.field_songWifiUrl)) && (TextUtils.isEmpty(locala.field_songWapLinkUrl)) && (TextUtils.isEmpty(locala.field_songWebUrl))) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if (locala.field_isBlock == 1)
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "not play music, music is block %s", new Object[] { locala.field_musicId });
      this.wzO.u(paramf);
      com.tencent.mm.plugin.music.model.d.e.a(paramf, true);
      AppMethodBeat.o(62969);
      return false;
    }
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicType %d", new Object[] { Integer.valueOf(locala.field_musicType) });
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "music protocol:%s", new Object[] { locala.field_protocol });
    locala.playUrl = paramf.playUrl;
    if (this.wAb != null) {
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAb);
    }
    com.tencent.mm.kernel.g.ajQ().gDv.a(940, this);
    this.wAb = new com.tencent.mm.plugin.music.model.b.a(locala.field_musicType, locala);
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAb, 0);
    if (com.tencent.mm.plugin.music.model.a.b.b(locala))
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "get shake music new url to play");
      paramf = locala.playUrl;
      if (TextUtils.isEmpty(paramf)) {
        ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is null");
      }
      for (;;)
      {
        AppMethodBeat.o(62969);
        return false;
        if (this.wAc != null)
        {
          com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAc);
          this.wAc = null;
        }
        ae.e("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl, url is %s", new Object[] { paramf });
        this.wAc = new com.tencent.mm.plugin.music.model.b.c(paramf);
        com.tencent.mm.kernel.g.ajQ().gDv.a(this.wAc, 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(558L, 213L, 1L, true);
      }
    }
    AppMethodBeat.o(62969);
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(62967);
    super.init();
    com.tencent.mm.kernel.g.ajQ().gDv.a(520, this);
    com.tencent.mm.kernel.g.ajQ().gDv.a(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.wzZ;
    ae.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
    localb.kzS = new b.1(localb);
    localb.kzS.alive();
    AppMethodBeat.o(62967);
  }
  
  public final com.tencent.mm.ay.f j(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62970);
    String str = com.tencent.mm.plugin.music.h.b.O(paramf);
    for (;;)
    {
      synchronized (this.lockObj)
      {
        if (this.wzY == null) {
          break label226;
        }
        i = 0;
        if (i >= this.wzY.size()) {
          break label221;
        }
        if (str.equals(this.wzY.get(i)))
        {
          this.wzX = i;
          i = 1;
          j = i;
          if (this.wzY.size() > 1)
          {
            j = i;
            if (paramf.iku)
            {
              this.mode = 2;
              j = i;
            }
          }
          if (j != 0)
          {
            ??? = dwa();
            AppMethodBeat.o(62970);
            return ???;
          }
        }
        else
        {
          i += 1;
        }
      }
      synchronized (this.lockObj)
      {
        this.wzY.clear();
        this.wzY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wzX = 0;
        com.tencent.mm.plugin.music.model.f.dwu().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        dws();
        ??? = paramf;
      }
      label221:
      int i = 0;
      continue;
      label226:
      int j = 0;
    }
  }
  
  public final com.tencent.mm.ay.f k(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62971);
    if ((paramf == null) && (this.wzY.size() == 0))
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "musicWrapper is null && musicList's size is 0");
      AppMethodBeat.o(62971);
      return null;
    }
    if (paramf == null) {
      ??? = dwa();
    }
    for (;;)
    {
      AppMethodBeat.o(62971);
      return ???;
      synchronized (this.lockObj)
      {
        this.wzY.clear();
        this.wzY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wzX = 0;
        com.tencent.mm.plugin.music.model.f.dwu().B(paramf);
        ??? = paramf;
        if (this.mode != 2) {
          continue;
        }
        dws();
        ??? = paramf;
      }
    }
  }
  
  public final void l(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62973);
    if (paramf != null) {
      synchronized (this.lockObj)
      {
        this.wzY.clear();
        this.wzY.add(com.tencent.mm.plugin.music.h.b.O(paramf));
        this.wzX = 0;
        com.tencent.mm.plugin.music.model.f.dwu().B(paramf);
        AppMethodBeat.o(62973);
        return;
      }
    }
    ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "shake music item is null");
    AppMethodBeat.o(62973);
  }
  
  public final void m(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(220666);
    super.m(paramf);
    com.tencent.mm.plugin.music.model.f.dwu().B(paramf);
    AppMethodBeat.o(220666);
  }
  
  public final void n(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62989);
    super.n(paramf);
    com.tencent.mm.plugin.music.model.d.e.dwC();
    com.tencent.mm.plugin.music.model.d.e.hOz = System.currentTimeMillis();
    com.tencent.mm.plugin.music.model.d.e.f(dwe());
    AppMethodBeat.o(62989);
  }
  
  public final void o(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62990);
    super.o(paramf);
    com.tencent.mm.plugin.music.model.d.e.hOz = System.currentTimeMillis();
    AppMethodBeat.o(62990);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(62995);
    Object localObject1;
    if ((paramn instanceof com.tencent.mm.plugin.music.model.b.a))
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd errCode:%d", new Object[] { Integer.valueOf(paramInt2) });
      com.tencent.mm.kernel.g.ajQ().gDv.b(940, this);
      if ((paramInt1 == 4) && (paramInt2 == -24))
      {
        paramn = ((com.tencent.mm.plugin.music.model.b.a)paramn).wAM;
        if ((dwe() != null) && (paramn.ijZ.equals(dwe().field_musicId))) {
          this.wzO.aJX();
        }
        paramString = com.tencent.mm.plugin.music.model.f.dwu();
        paramn = paramn.ijZ;
        localObject1 = new ContentValues();
        ((ContentValues)localObject1).put("isBlock", Integer.valueOf(1));
        paramString.db.update("Music", (ContentValues)localObject1, "musicId=?", new String[] { paramn });
        paramString = (com.tencent.mm.plugin.music.model.e.a)paramString.wBy.get(paramn);
        if (paramString != null) {
          paramString.field_isBlock = 1;
        }
        ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "onSceneEnd music is block %s", new Object[] { dwe().field_musicId });
        AppMethodBeat.o(62995);
      }
    }
    else
    {
      if ((paramn instanceof com.tencent.mm.plugin.music.model.b.b))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(62995);
          return;
        }
        paramString = (com.tencent.mm.plugin.music.model.b.b)paramn;
        localObject1 = paramString.wAN;
        String str = paramString.wAD.field_musicId;
        if ((localObject1 != null) && (str != null))
        {
          Object localObject2 = this.wzY.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramn = (String)((Iterator)localObject2).next();
            if (paramn.equals(str))
            {
              str = z.b(((bhj)localObject1).GVC);
              localObject2 = z.b(((bhj)localObject1).GVD);
              localObject1 = z.b(((bhj)localObject1).GVB);
              h.MqF.aO(new m.1(this, paramn, str, (String)localObject2, (String)localObject1, paramString));
              ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "get response %s %s %s", new Object[] { str, localObject2, localObject1 });
              if (!bu.isNullOrNil((String)localObject2))
              {
                paramn = new mg();
                paramn.dAP.action = 6;
                paramn.dAP.dAQ = paramString.wAD.field_musicId;
                com.tencent.mm.sdk.b.a.IvT.a(paramn, Looper.getMainLooper());
                AppMethodBeat.o(62995);
                return;
              }
            }
          }
        }
        AppMethodBeat.o(62995);
        return;
      }
      if ((paramn instanceof com.tencent.mm.plugin.music.model.b.c))
      {
        ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramString = (com.tencent.mm.plugin.music.model.b.c)paramn;
        ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[] { paramString.playUrl, paramString.wAR });
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(558L, 214L, 1L, true);
        }
        for (;;)
        {
          paramn = dwe();
          if ((paramn == null) || (TextUtils.isEmpty(paramn.playUrl)) || (!paramn.playUrl.equalsIgnoreCase(paramString.playUrl))) {
            break;
          }
          ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is same, start to play shake music");
          this.wzO.t(paramn.dwG());
          AppMethodBeat.o(62995);
          return;
          com.tencent.mm.plugin.music.model.a.b.ip(paramString.playUrl, paramString.wAR);
        }
        if (paramn != null) {
          ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[] { paramn.playUrl, paramString.playUrl });
        }
      }
    }
    AppMethodBeat.o(62995);
  }
  
  public final void p(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62991);
    super.p(paramf);
    com.tencent.mm.plugin.music.model.d.e.aJV();
    AppMethodBeat.o(62991);
  }
  
  public final void q(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62992);
    super.q(paramf);
    com.tencent.mm.plugin.music.model.d.e.dwC();
    AppMethodBeat.o(62992);
  }
  
  public final void r(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(62993);
    super.r(paramf);
    com.tencent.mm.plugin.music.model.d.e.dwC();
    if ((this.mode == 2) && ((this.wzX < this.wzY.size() - 1) || (paramf.iku)))
    {
      paramf = new mg();
      paramf.dAP.action = 15;
      paramf.dAP.state = "";
      com.tencent.mm.sdk.b.a.IvT.a(paramf, Looper.getMainLooper());
      dwi();
    }
    AppMethodBeat.o(62993);
  }
  
  public final void release()
  {
    AppMethodBeat.i(62968);
    this.wzY.clear();
    com.tencent.mm.kernel.g.ajQ().gDv.b(520, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(940, this);
    com.tencent.mm.kernel.g.ajQ().gDv.b(769, this);
    com.tencent.mm.plugin.music.model.notification.b localb = this.wzZ;
    ae.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
    Intent localIntent = new Intent();
    localIntent.setClass(ak.getContext(), MMMusicPlayerService.class);
    ak.getContext().stopService(localIntent);
    localb.wAS = null;
    localb.kzS.dead();
    AppMethodBeat.o(62968);
  }
  
  public final com.tencent.mm.ay.f u(List<com.tencent.mm.ay.f> paramList, int paramInt)
  {
    AppMethodBeat.i(62972);
    if ((paramList == null) || (paramList.size() == 0) || (paramInt >= paramList.size()))
    {
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "music wrapper list error");
      AppMethodBeat.o(62972);
      return null;
    }
    synchronized (this.lockObj)
    {
      this.wzY.clear();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject2 = (com.tencent.mm.ay.f)paramList.get(i);
        this.wzY.add(com.tencent.mm.plugin.music.h.b.O((com.tencent.mm.ay.f)localObject2));
        com.tencent.mm.plugin.music.model.f.dwu().B((com.tencent.mm.ay.f)localObject2);
        i += 1;
      }
      this.wzX = paramInt;
      this.mode = 2;
      ae.i("MicroMsg.Music.MusicWechatPrivateLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(this.wzX) });
      paramList = dwa();
      if (paramList.dez > 0)
      {
        ??? = com.tencent.mm.plugin.music.h.b.O(paramList);
        localObject2 = com.tencent.mm.plugin.music.model.f.dwu();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("startTime", Integer.valueOf(0));
        ((com.tencent.mm.plugin.music.model.e.b)localObject2).db.update("Music", localContentValues, "musicId=?", new String[] { ??? });
        ??? = (com.tencent.mm.plugin.music.model.e.a)((com.tencent.mm.plugin.music.model.e.b)localObject2).wBy.get(???);
        if (??? != null) {
          ((com.tencent.mm.plugin.music.model.e.a)???).field_startTime = 0;
        }
      }
      AppMethodBeat.o(62972);
      return paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.e.m
 * JD-Core Version:    0.7.0.1
 */