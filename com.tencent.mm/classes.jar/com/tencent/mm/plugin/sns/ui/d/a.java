package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.uh.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.a.b.m.c;
import com.tencent.mm.plugin.sns.a.b.m.d;
import com.tencent.mm.plugin.sns.a.b.m.e;
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agn;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.base.n.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements com.tencent.mm.al.g, n.d
{
  private Activity activity;
  private int dep;
  private ClipboardManager qiE;
  private View xTl;
  private String xTm;
  private TimeLineObject xTn;
  private ae xlD;
  private com.tencent.mm.ui.base.p xlp;
  protected com.tencent.mm.plugin.sns.a.b.i xwT;
  
  public a(Activity paramActivity, int paramInt, ae paramae)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.dep = paramInt;
    this.qiE = ((ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard"));
    this.xlD = paramae;
    AppMethodBeat.o(100192);
  }
  
  private void aqO(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = af.dtu().apK(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dxy();
    if (((com.tencent.mm.plugin.sns.storage.p)localObject2).Nb(32))
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dyh();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G((com.tencent.mm.plugin.sns.storage.p)localObject2);
      if (!bt.isNullOrNil(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localTimeLineObject.xpl)
    {
      localObject3 = bw.K((String)localObject1, "adxml");
      if (localObject3 != null) {
        break;
      }
      AppMethodBeat.o(100196);
      return;
    }
    if (!((Map)localObject3).containsKey(".adxml.adCanvasInfo"))
    {
      com.tencent.mm.ui.base.h.j(this.activity, 2131758895, 0);
      AppMethodBeat.o(100196);
      return;
    }
    String str1 = y.tD(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
    String str2 = bt.by((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bt.by((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bt.by((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cs();
    uh localuh = new uh();
    localuh.dzB.dzE = paramString;
    localuh.dzB.dzF = ((cs)localObject2);
    localuh.dzB.url = str3;
    com.tencent.mm.sdk.b.a.ESL.l(localuh);
    if (!localuh.dzC.dew)
    {
      if (((cs)localObject2).deQ.deV == 0) {
        ((cs)localObject2).deQ.deV = 2131758893;
      }
      com.tencent.mm.ui.base.h.j(this.activity, ((cs)localObject2).deQ.deV, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((cs)localObject2).deQ.sessionId = str1;
    ((cs)localObject2).deQ.title = str2;
    ((cs)localObject2).deQ.desc = ((String)localObject3);
    paramString = ((cs)localObject2).deQ.deS;
    if ((paramString != null) && (paramString.mVb != null) && (paramString.mVb.size() > 0) && (paramString.mVb.get(0) != null))
    {
      ((afy)paramString.mVb.get(0)).aDK((String)localObject1);
      if (bt.isNullOrNil(((afy)paramString.mVb.get(0)).title)) {
        ((afy)paramString.mVb.get(0)).aDl(((cs)localObject2).deQ.title);
      }
      if (bt.isNullOrNil(((afy)paramString.mVb.get(0)).desc)) {
        ((afy)paramString.mVb.get(0)).aDm(((cs)localObject2).deQ.desc);
      }
      localObject1 = new agu();
      ((agu)localObject1).aEl(localTimeLineObject.mAQ);
      ((agu)localObject1).aEm(u.aqG());
      ((agu)localObject1).VM(2);
      ((agu)localObject1).vv(bt.eGO());
      paramString.a((agu)localObject1);
    }
    ((cs)localObject2).deQ.activity = this.activity;
    ((cs)localObject2).deQ.deW = 28;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private String dDs()
  {
    AppMethodBeat.i(100193);
    if ((this.xTl != null) && ((this.xTl instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.xTl != null) && ((this.xTl.getTag() instanceof ba)) && (((ba)this.xTl.getTag()).dBG()))
    {
      Object localObject = ap.aoL(af.dtu().apK(this.xTm).getSnsId());
      if (localObject != null)
      {
        localObject = ((ap.b)localObject).result;
        AppMethodBeat.o(100193);
        return localObject;
      }
    }
    AppMethodBeat.o(100193);
    return null;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100194);
    if (paramp != null)
    {
      if (this.dep == 2)
      {
        paramp = paramp.dxv();
        AppMethodBeat.o(100194);
        return paramp;
      }
      paramp = paramp.dxu();
      AppMethodBeat.o(100194);
      return paramp;
    }
    AppMethodBeat.o(100194);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.xTl = paramView;
    this.xTm = paramString;
    this.xTn = paramTimeLineObject;
  }
  
  public final void b(com.tencent.mm.plugin.sns.a.b.i parami)
  {
    this.xwT = parami;
  }
  
  public final void cIt()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        com.tencent.mm.plugin.sns.storage.p localp = af.dtu().apK(this.xTm);
        Object localObject1 = (bpi)this.xTn.Etm.DaC.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject1);
        paramIntent = bt.S(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localp.Nb(32))
          {
            str3 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((bpi)localObject1);
            TimeLineObject localTimeLineObject = localp.dxy();
            com.tencent.mm.plugin.sns.storage.b localb = localp.dxs();
            czj localczj = new czj();
            localczj.Dim = ((bpi)localObject1).xMj;
            localczj.gJv = ((bpi)localObject1).DMX;
            if (localTimeLineObject.Etm.DaB == 15)
            {
              localczj.gJB = f(localp).dvK;
              localczj.gJC = localTimeLineObject.Id;
              localczj.gJx = localTimeLineObject.Etj;
              if (!bt.isNullOrNil(((bpi)localObject1).DNa)) {
                break label551;
              }
              paramIntent = ((bpi)localObject1).DMQ;
              label288:
              localczj.gJA = paramIntent;
              if ((localb != null) && (localb.wSS == 0))
              {
                localczj.gJz = localb.wSU;
                localczj.gJy = localb.wST;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.q.anS(str3);
              ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bpi)localObject1).DMX, Integer.valueOf(((bpi)localObject1).xMj), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.j.cOB().a(this.activity, str1, str3, str2, 43, paramInt1, localczj, localTimeLineObject.xns, null);
              com.tencent.mm.plugin.messenger.a.j.cOB().hm((String)localObject2, str1);
              paramInt2 = this.dep;
              if (this.dep != 0) {
                break label560;
              }
              paramInt1 = 1;
              label443:
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(paramInt2, paramInt1, localp.field_snsId, 12, 0));
              boolean bool = w.pF(str1);
              localObject1 = m.d.wzm;
              if (!bool) {
                break label565;
              }
              paramIntent = m.c.wzj;
              label484:
              localObject2 = m.e.wzs;
              if (!bool) {
                break label572;
              }
            }
            label551:
            label560:
            label565:
            label572:
            for (paramInt1 = com.tencent.mm.model.q.rY(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.a.b.m.a((m.d)localObject1, paramIntent, (m.e)localObject2, paramInt1, localp, this.dep);
              AppMethodBeat.o(100197);
              return;
              localczj.gJB = localTimeLineObject.Etr.gJB;
              localczj.gJC = localTimeLineObject.Etr.gJC;
              break;
              paramIntent = ((bpi)localObject1).DNa;
              break label288;
              paramInt1 = 2;
              break label443;
              paramIntent = m.c.wzi;
              break label484;
            }
          }
          String str3 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((bpi)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.q.anS(str3);
          ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bpi)localObject1).DMX, Integer.valueOf(((bpi)localObject1).xMj), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.j.cOB().a(this.activity, str1, str3, str2, 43, paramInt1, this.xTn.xns, null);
          com.tencent.mm.plugin.messenger.a.j.cOB().hm((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this.activity, this.activity.getString(2131760233));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = af.dtu().apK(this.xTm);
      if (paramIntent == null)
      {
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.xTm });
        AppMethodBeat.o(100197);
        return;
      }
      paramInt2 = this.dep;
      if (this.dep != 0) {
        break label828;
      }
    }
    label828:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(100197);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.xTl == null)
    {
      AppMethodBeat.o(100195);
      return;
    }
    int i;
    Object localObject3;
    label589:
    Object localObject7;
    label771:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    label1417:
    long l;
    label2650:
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    case 6: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 18: 
    case 19: 
    case 3: 
    case 5: 
      do
      {
        AppMethodBeat.o(100195);
        return;
        Object localObject1 = dDs();
        paramMenuItem = (MenuItem)localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          paramMenuItem = this.xTn.Etj;
        }
        this.qiE.setText(paramMenuItem);
        com.tencent.mm.ui.base.h.cf(this.activity, this.activity.getString(2131755702));
        localObject1 = com.tencent.mm.plugin.secinforeport.a.a.wcB;
        com.tencent.mm.plugin.secinforeport.a.a.m(2, this.xTn.Id, bt.aFZ(paramMenuItem));
        AppMethodBeat.o(100195);
        return;
        localObject1 = dDs();
        paramMenuItem = (MenuItem)localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          paramMenuItem = this.xTn.Etj;
        }
        this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
        localObject1 = new cs();
        com.tencent.mm.plugin.sns.l.a.a((cs)localObject1, this.xTm, paramMenuItem);
        ((cs)localObject1).deQ.activity = this.activity;
        ((cs)localObject1).deQ.deW = 30;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        AppMethodBeat.o(100195);
        return;
        this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
        localObject1 = new cs();
        paramMenuItem = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
        if ((paramMenuItem.Nb(32)) && (paramMenuItem.dxs().dvh()))
        {
          aqO(this.xTm);
          if (paramMenuItem.Nb(32))
          {
            i = this.dep;
            if (this.dep != 0) {
              break label589;
            }
          }
        }
        for (paramInt = 1;; paramInt = 2)
        {
          localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, this.xwT, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject1);
          AppMethodBeat.o(100195);
          return;
          if (this.xTn.evt == 1)
          {
            com.tencent.mm.plugin.sns.l.a.a((cs)localObject1, this.xTm, 0);
            ((cs)localObject1).deQ.activity = this.activity;
            ((cs)localObject1).deQ.deW = 31;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            break;
          }
          if (!(this.xTl.getTag() instanceof aw)) {
            break;
          }
          localObject3 = (aw)this.xTl.getTag();
          com.tencent.mm.plugin.sns.l.a.a((cs)localObject1, this.xTm, ((aw)localObject3).index);
          ((cs)localObject1).deQ.activity = this.activity;
          ((cs)localObject1).deQ.deW = 31;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
          break;
        }
        this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
        paramMenuItem = af.dtu().apK(this.xTm);
        if (this.xTn.Etm.DaC.size() != 0)
        {
          localObject1 = (bpi)this.xTn.Etm.DaC.get(0);
          if ((paramMenuItem == null) || (localObject1 == null))
          {
            ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
            AppMethodBeat.o(100195);
            return;
          }
          localObject3 = new cs();
          if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.xiB != 0)) {
            break label771;
          }
          ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
        }
        for (((cs)localObject3).deQ.deV = 2131758885;; ((cs)localObject3).deQ.deV = 2131758903)
        {
          ((cs)localObject3).deQ.activity = this.activity;
          ((cs)localObject3).deQ.deW = 25;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
          AppMethodBeat.o(100195);
          return;
          if (!af.dtd()) {
            break;
          }
          ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
        }
        localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.st(paramMenuItem.field_snsId), ((bpi)localObject1).Id });
        localObject4 = new ago();
        localObject5 = new agu();
        ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
        ((agu)localObject5).aEl(paramMenuItem.field_userName);
        ((agu)localObject5).aEm(u.aqG());
        ((agu)localObject5).VM(2);
        ((agu)localObject5).vv(paramMenuItem.field_createTime * 1000L);
        ((agu)localObject5).aEq(paramMenuItem.getSnsId());
        ((agu)localObject5).aEn((String)localObject7);
        localObject6 = new afy();
        ((afy)localObject6).aDD((String)localObject7);
        ((afy)localObject6).aDs(((bpi)localObject1).Url);
        ((afy)localObject6).aDt(((bpi)localObject1).DMU);
        ((afy)localObject6).aDr(paramMenuItem.dxy().Etm.Url);
        localObject7 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject1);
        if (com.tencent.mm.vfs.i.eK((String)localObject7)) {
          ((afy)localObject6).aDA((String)localObject7);
        }
        for (;;)
        {
          ((afy)localObject6).aDR(((bpi)localObject1).songAlbumUrl);
          ((afy)localObject6).aDS(((bpi)localObject1).songLyric);
          ((afy)localObject6).VD(7);
          ((afy)localObject6).aDl(((bpi)localObject1).Title);
          ((afy)localObject6).aDm(((bpi)localObject1).Desc);
          ((afy)localObject6).uw(true);
          ((ago)localObject4).mVb.add(localObject6);
          ((ago)localObject4).a((agu)localObject5);
          ((cs)localObject3).deQ.deS = ((ago)localObject4);
          ((cs)localObject3).deQ.type = 7;
          com.tencent.mm.plugin.sns.l.a.a((afy)localObject6, paramMenuItem);
          break;
          ((afy)localObject6).ux(true);
          ((afy)localObject6).aDu(((bpi)localObject1).DMQ);
          localObject7 = new ahd();
          ((ahd)localObject7).aEB(((bpi)localObject1).DMQ);
          ((ago)localObject4).b((ahd)localObject7);
        }
        paramMenuItem = this.activity;
        localObject3 = af.dtu().apK(this.xTm);
        if (localObject3 != null)
        {
          localObject1 = new Intent();
          if (((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().Etm.DaB != 1) {
            break label1417;
          }
          paramInt = 0;
          if ((this.xTl.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
            paramInt = ((aw)this.xTl.getTag()).index;
          }
          localObject3 = com.tencent.mm.plugin.sns.model.aj.a((com.tencent.mm.plugin.sns.storage.p)localObject3, paramInt);
          if (localObject3 == null)
          {
            ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
            AppMethodBeat.o(100195);
            return;
          }
          localObject4 = ((bpi)localObject3).Id;
          ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.g(com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.q.k((bpi)localObject3), paramMenuItem));
          ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
        }
        while (((((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().Etm.DaB != 4) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().Etm.DaB != 15) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().Etm.DaB != 3)) || ((bpi)((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().Etm.DaC.get(0) != null))
        {
          ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
          ((Intent)localObject1).putExtra("sns_local_id", this.xTm);
          ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
          com.tencent.mm.bs.d.e(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
          AppMethodBeat.o(100195);
          return;
        }
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
        AppMethodBeat.o(100195);
        return;
        localObject1 = this.activity;
        paramMenuItem = af.dtu().apK(this.xTm);
        if (paramMenuItem == null)
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
          AppMethodBeat.o(100195);
          return;
        }
        if (paramMenuItem.Nb(32))
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
          AppMethodBeat.o(100195);
          return;
        }
        if ((paramMenuItem.dxy() == null) || (paramMenuItem.dxy().Etm == null) || (bt.gL(paramMenuItem.dxy().Etm.DaC)))
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
          AppMethodBeat.o(100195);
          return;
        }
        localObject3 = (bpi)paramMenuItem.dxy().Etm.DaC.get(0);
        if (localObject3 == null)
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
          AppMethodBeat.o(100195);
          return;
        }
        localObject4 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject3).Id);
        paramMenuItem = "";
        localObject5 = com.tencent.mm.plugin.sns.data.q.i((bpi)localObject3);
        if (com.tencent.mm.vfs.i.eK((String)localObject4 + (String)localObject5)) {
          paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject3);
        }
        if (com.tencent.mm.vfs.i.eK((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o((bpi)localObject3))) {
          paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m((bpi)localObject3);
        }
        localObject3 = new Intent();
        ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
        ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
        ((Intent)localObject3).putExtra("intent_localid", this.xTm);
        ((Intent)localObject3).putExtra("intent_from_scene", this.dep);
        ((Intent)localObject3).putExtra("intent_ismute", true);
        if ((localObject1 instanceof SnsTimeLineUI)) {
          ((Intent)localObject3).putExtra("sns_video_scene", 1);
        }
        for (;;)
        {
          if (this.xTl != null)
          {
            paramMenuItem = new int[2];
            this.xTl.getLocationInWindow(paramMenuItem);
            paramInt = this.xTl.getWidth();
            i = this.xTl.getHeight();
            ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
            ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
            ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
            ((Intent)localObject3).putExtra("img_gallery_height", i);
          }
          paramMenuItem = this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.activity.overridePendingTransition(0, 0);
          AppMethodBeat.o(100195);
          return;
          if ((localObject1 instanceof SnsCommentDetailUI)) {
            ((Intent)localObject3).putExtra("sns_video_scene", 5);
          } else if ((localObject1 instanceof SnsUploadUI)) {
            ((Intent)localObject3).putExtra("sns_video_scene", 6);
          }
        }
        this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
        localObject1 = be.aqD(this.xTn.Etm.Url);
        if (bt.isNullOrNil((String)localObject1))
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
          AppMethodBeat.o(100195);
          return;
        }
        paramMenuItem = new cs();
        localObject3 = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
        if (localObject3 != null)
        {
          localObject4 = y.tD(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId);
          localObject5 = y.arz().E((String)localObject4, true);
          ((y.b)localObject5).m("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId));
          ((y.b)localObject5).m("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_userName);
          ((y.b)localObject5).m("preChatName", "");
          ((y.b)localObject5).m("url", localObject1);
          ((y.b)localObject5).m("preMsgIndex", Integer.valueOf(0));
          ((y.b)localObject5).m("sendAppMsgScene", Integer.valueOf(1));
          ((y.b)localObject5).m("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject3).dxy().xns);
          paramMenuItem.deQ.sessionId = ((String)localObject4);
        }
        localObject4 = af.dtu().apK(this.xTm);
        if ((localObject4 != null) && (this.xTn.Etm.DaB == 18)) {
          com.tencent.mm.plugin.sns.a.b.m.a(m.d.wzn, m.c.wzh, m.e.wzs, 0, (com.tencent.mm.plugin.sns.storage.p)localObject4, this.dep);
        }
        if (!bt.isNullOrNil(this.xTn.xpl))
        {
          aqO(((com.tencent.mm.plugin.sns.storage.p)localObject4).dxX());
          AppMethodBeat.o(100195);
          return;
        }
        if (((com.tencent.mm.plugin.sns.storage.p)localObject4).Nb(32))
        {
          i = this.dep;
          if (this.dep != 0) {
            break label2650;
          }
        }
        for (paramInt = 1;; paramInt = 2)
        {
          localObject3 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject3, this.xwT, (com.tencent.mm.plugin.sns.storage.p)localObject4, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
          com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, (String)localObject1, this.xTm);
          paramMenuItem.deQ.activity = this.activity;
          paramMenuItem.deQ.deW = 28;
          com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
          if (paramMenuItem.deR.ret == 0)
          {
            l = bt.aGK();
            if (!bt.isNullOrNil((String)localObject1))
            {
              ad.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
              paramMenuItem = "";
            }
          }
          try
          {
            localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
            paramMenuItem = (MenuItem)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          AppMethodBeat.o(100195);
          return;
        }
        this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
      } while (this.xTn == null);
      paramMenuItem = new cs();
      localObject5 = this.xTn;
      if (localObject5 == null)
      {
        ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
        paramMenuItem.deQ.deV = 2131758885;
      }
      for (;;)
      {
        paramMenuItem.deQ.activity = this.activity;
        paramMenuItem.deQ.deW = 26;
        com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject2 = new ago();
        localObject3 = new agu();
        localObject4 = new agn();
        ((agu)localObject3).aEl(((TimeLineObject)localObject5).mAQ);
        ((agu)localObject3).aEm(u.aqG());
        ((agu)localObject3).VM(2);
        ((agu)localObject3).vv(bt.eGO());
        if (((TimeLineObject)localObject5).Etl != null) {
          ((agu)localObject3).aEr(((TimeLineObject)localObject5).Etl.Id);
        }
        if (((TimeLineObject)localObject5).Etm != null)
        {
          ((agn)localObject4).aEe(((TimeLineObject)localObject5).Etm.Title);
          ((agn)localObject4).aEf(((TimeLineObject)localObject5).Etm.Desc);
          if ((((TimeLineObject)localObject5).Etm.DaC != null) && (!((TimeLineObject)localObject5).Etm.DaC.isEmpty()))
          {
            localObject5 = (bpi)((TimeLineObject)localObject5).Etm.DaC.get(0);
            ((agn)localObject4).VJ(((bpi)localObject5).subType);
            ((agn)localObject4).aEh(((bpi)localObject5).xmd);
            ((agn)localObject4).aEg(((bpi)localObject5).DMQ);
          }
        }
        paramMenuItem.deQ.title = ((agn)localObject4).title;
        paramMenuItem.deQ.desc = ((agn)localObject4).desc;
        paramMenuItem.deQ.deS = ((ago)localObject2);
        paramMenuItem.deQ.type = 10;
        ((ago)localObject2).a((agu)localObject3);
        ((ago)localObject2).b((agn)localObject4);
      }
    case 23: 
      paramMenuItem = this.xTn.Ets;
      if ((this.xTn == null) || (paramMenuItem == null))
      {
        ad.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
        AppMethodBeat.o(100195);
        return;
      }
      localObject5 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(paramMenuItem.username);
      localObject3 = new afw();
      ((afw)localObject3).username = paramMenuItem.username;
      if (localObject5 != null) {
        ((afw)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
      }
      ((afw)localObject3).dbu = paramMenuItem.path;
      ((afw)localObject3).dkC = paramMenuItem.AHI;
      ((afw)localObject3).version = paramMenuItem.version;
      ((afw)localObject3).dzY = paramMenuItem.dzY;
      ((afw)localObject3).subType = paramMenuItem.subType;
      paramMenuItem = null;
      localObject4 = new afy();
      ((afy)localObject4).VD(19);
      if (this.xTn.Etm != null)
      {
        paramMenuItem = this.xTn.Etm.Title;
        if ((this.xTn.Etm.DaC == null) || (this.xTn.Etm.DaC.isEmpty())) {
          break label6725;
        }
        localObject2 = (bpi)this.xTn.Etm.DaC.get(0);
        ((afy)localObject4).aDz(com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject2));
      }
      break;
    }
    label3517:
    label6725:
    for (;;)
    {
      localObject2 = paramMenuItem;
      if (bt.isNullOrNil(paramMenuItem)) {
        if ((localObject5 == null) || (bt.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
          break label3517;
        }
      }
      for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(2131755945))
      {
        ((afy)localObject4).aDl((String)localObject2);
        ((afy)localObject4).aDm((String)localObject2);
        ((afy)localObject4).aDy(com.tencent.mm.plugin.fav.a.b.cT(localObject4.toString(), 19));
        localObject5 = new agu();
        ((agu)localObject5).aEl(u.aqG());
        ((agu)localObject5).vv(bt.eGO());
        ((agu)localObject5).VM(2);
        paramMenuItem = new ago();
        paramMenuItem.mVb.add(localObject4);
        paramMenuItem.c((afw)localObject3);
        paramMenuItem.a((agu)localObject5);
        paramMenuItem.aEj((String)localObject2);
        localObject3 = new cs();
        ((cs)localObject3).deQ.activity = this.activity;
        ((cs)localObject3).deQ.title = ((String)localObject2);
        ((cs)localObject3).deQ.desc = ((String)localObject2);
        ((cs)localObject3).deQ.deS = paramMenuItem;
        ((cs)localObject3).deQ.type = 19;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
        AppMethodBeat.o(100195);
        return;
        ((afy)localObject4).ux(true);
        break;
      }
      this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
      if (this.xTn == null) {
        break;
      }
      paramMenuItem = new cs();
      localObject5 = this.xTn;
      if (localObject5 == null)
      {
        ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
        paramMenuItem.deQ.deV = 2131758885;
      }
      for (;;)
      {
        paramMenuItem.deQ.activity = this.activity;
        paramMenuItem.deQ.deW = 27;
        com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject2 = new ago();
        localObject3 = new agu();
        localObject4 = new agx();
        ((agu)localObject3).aEl(((TimeLineObject)localObject5).mAQ);
        ((agu)localObject3).aEm(u.aqG());
        ((agu)localObject3).VM(8);
        ((agu)localObject3).vv(bt.eGO());
        if (((TimeLineObject)localObject5).Etl != null) {
          ((agu)localObject3).aEr(((TimeLineObject)localObject5).Etl.Id);
        }
        if (((TimeLineObject)localObject5).Etm != null)
        {
          ((agx)localObject4).aEu(((TimeLineObject)localObject5).Etm.Title);
          ((agx)localObject4).aEv(((TimeLineObject)localObject5).Etm.Desc);
          if ((((TimeLineObject)localObject5).Etm.DaC != null) && (!((TimeLineObject)localObject5).Etm.DaC.isEmpty()))
          {
            localObject5 = (bpi)((TimeLineObject)localObject5).Etm.DaC.get(0);
            ((agx)localObject4).aEx(((bpi)localObject5).xmd);
            ((agx)localObject4).aEw(((bpi)localObject5).DMQ);
          }
        }
        paramMenuItem.deQ.title = ((agx)localObject4).title;
        paramMenuItem.deQ.desc = ((agx)localObject4).desc;
        paramMenuItem.deQ.deS = ((ago)localObject2);
        paramMenuItem.deQ.type = 15;
        ((ago)localObject2).a((agu)localObject3);
        ((ago)localObject2).b((agx)localObject4);
      }
      paramMenuItem = af.dtu().apK(this.xTm).getSnsId();
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.xTl.getTag();
      if (x.aqf(paramMenuItem))
      {
        paramMenuItem = new com.tencent.mm.plugin.sns.model.q(x.anz(paramMenuItem), 6, ((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramMenuItem, 0);
      }
      for (;;)
      {
        localObject2 = this.activity;
        this.activity.getString(2131755906);
        this.xlp = com.tencent.mm.ui.base.h.b((Context)localObject2, this.activity.getString(2131763798), true, new a.1(this, paramMenuItem));
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = new com.tencent.mm.plugin.sns.model.q(x.anz(paramMenuItem), 4, ((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramMenuItem, 0);
      }
      paramMenuItem = af.dtu().apK(this.xTm);
      if (paramMenuItem == null) {
        break;
      }
      com.tencent.mm.plugin.sns.abtest.a.b(paramMenuItem);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
      ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.field_userName);
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
      this.activity.startActivityForResult((Intent)localObject2, 11);
      AppMethodBeat.o(100195);
      return;
      this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
      paramMenuItem = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
      if ((paramMenuItem != null) && (paramMenuItem.Nb(32)) && (paramMenuItem.dxs().dvh()))
      {
        localObject2 = af.dtu().apK(this.xTm);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Nb(32)))
        {
          i = this.dep;
          if (this.dep != 0) {
            break label4280;
          }
        }
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.xwT, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
          aqO(this.xTm);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.xTm;
      paramMenuItem = af.dtu().apK(paramMenuItem);
      if (paramMenuItem != null) {
        if (paramMenuItem.Nb(32))
        {
          com.tencent.mm.plugin.sns.a.b.m.a(m.d.wzm, m.c.wzh, m.e.wzs, 0, paramMenuItem, this.dep);
          i = this.dep;
          if (this.dep != 0) {
            break label4432;
          }
        }
      }
      label4432:
      for (paramInt = 1;; paramInt = 2)
      {
        localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.xwT, paramMenuItem, 11);
        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
        localObject2 = new cs();
        com.tencent.mm.plugin.sns.l.a.a((cs)localObject2, paramMenuItem);
        ((cs)localObject2).deQ.activity = this.activity;
        ((cs)localObject2).deQ.deW = 29;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem = (bpi)this.xTn.Etm.DaC.get(0);
      paramMenuItem = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.q.d(paramMenuItem);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
      ((Intent)localObject2).putExtra("select_is_ret", true);
      ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
      ((Intent)localObject2).putExtra("image_path", paramMenuItem);
      ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
      com.tencent.mm.bs.d.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
      AppMethodBeat.o(100195);
      return;
      if (!(this.xTl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
        break;
      }
      paramMenuItem = (com.tencent.mm.plugin.sns.ui.m)this.xTl.getTag();
      this.qiE.setText(paramMenuItem.gKr);
      com.tencent.mm.ui.base.h.cf(this.activity, this.activity.getString(2131755702));
      if (paramMenuItem.wFh != null)
      {
        localObject2 = com.tencent.mm.plugin.secinforeport.a.a.wcB;
        com.tencent.mm.plugin.secinforeport.a.a.m(4, this.xTn.Id + ":" + paramMenuItem.wFh.Ema, bt.aFZ(paramMenuItem.gKr));
      }
      AppMethodBeat.o(100195);
      return;
      paramMenuItem = af.dtu().apK(this.xTm);
      com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
      AppMethodBeat.o(100195);
      return;
      localObject2 = af.dtu().apK(this.xTm);
      if (localObject2 != null) {
        if (this.dep != 0) {
          break label4796;
        }
      }
      for (paramMenuItem = com.tencent.mm.modelsns.d.oE(714);; paramMenuItem = com.tencent.mm.modelsns.d.oF(714))
      {
        paramMenuItem.zi(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject2)).oH(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_type).ew(((com.tencent.mm.plugin.sns.storage.p)localObject2).Nb(32)).zi(((com.tencent.mm.plugin.sns.storage.p)localObject2).dyg());
        paramMenuItem.aBj();
        ap.u((com.tencent.mm.plugin.sns.storage.p)localObject2);
        AppMethodBeat.o(100195);
        return;
      }
      if (!(this.xTl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
        break;
      }
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.xTl.getTag();
      localObject3 = af.dtu().apJ(((com.tencent.mm.plugin.sns.ui.m)localObject2).xlP);
      if (localObject3 != null)
      {
        if (this.dep != 0) {
          break label4973;
        }
        paramMenuItem = com.tencent.mm.modelsns.d.oE(715);
        paramMenuItem.zi(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject3)).oH(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_type).ew(((com.tencent.mm.plugin.sns.storage.p)localObject3).Nb(32)).zi(((com.tencent.mm.plugin.sns.storage.p)localObject3).dyg());
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh == null) {
          break label5009;
        }
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh.Ema != 0) {
          break label4983;
        }
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh.Emc;
        label4941:
        paramMenuItem.zi((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.aBj();
        ap.a((com.tencent.mm.plugin.sns.ui.m)this.xTl.getTag());
        AppMethodBeat.o(100195);
        return;
        label4973:
        paramMenuItem = com.tencent.mm.modelsns.d.oF(715);
        break;
        label4983:
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).wFh.Ema;
        break label4941;
        paramMenuItem.zi("");
      }
      this.xlD.dsZ().iM(this.xTm, this.xTn.Id);
      paramMenuItem = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
      if ((paramMenuItem != null) && (paramMenuItem.Nb(32)) && (paramMenuItem.dxs().dvh()))
      {
        localObject2 = af.dtu().apK(this.xTm);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Nb(32)) && (this.xTn != null))
        {
          i = this.dep;
          if (this.dep != 0) {
            break label5171;
          }
        }
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.xwT, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
          aqO(this.xTm);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.xTm;
      localObject3 = af.dtu().apK(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((com.tencent.mm.plugin.sns.storage.p)localObject3).Nb(32))
        {
          localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dyf();
          paramMenuItem = (MenuItem)localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dye();
          }
        }
      }
      if (bt.isNullOrNil(paramMenuItem)) {
        paramMenuItem = be.aqD(this.xTn.Etm.Url);
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramMenuItem))
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
          AppMethodBeat.o(100195);
          return;
        }
        localObject2 = new cs();
        localObject4 = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
        if (localObject4 != null)
        {
          localObject5 = y.tD(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId);
          localObject6 = y.arz().E((String)localObject5, true);
          ((y.b)localObject6).m("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
          ((y.b)localObject6).m("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
          ((y.b)localObject6).m("preChatName", "");
          ((y.b)localObject6).m("url", paramMenuItem);
          ((y.b)localObject6).m("preMsgIndex", Integer.valueOf(0));
          ((y.b)localObject6).m("sendAppMsgScene", Integer.valueOf(1));
          ((y.b)localObject6).m("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject4).dxy().xns);
          ((cs)localObject2).deQ.sessionId = ((String)localObject5);
        }
        if ((localObject3 != null) && ((this.xTn.Etm.DaB == 18) || (((com.tencent.mm.plugin.sns.storage.p)localObject3).Nb(32))))
        {
          com.tencent.mm.plugin.sns.a.b.m.a(m.d.wzn, m.c.wzh, m.e.wzs, 0, (com.tencent.mm.plugin.sns.storage.p)localObject3, this.dep);
          if (this.xTn != null)
          {
            i = this.dep;
            if (this.dep != 0) {
              break label5596;
            }
          }
        }
        label5596:
        for (paramInt = 1;; paramInt = 2)
        {
          localObject4 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, this.xwT, (com.tencent.mm.plugin.sns.storage.p)localObject3, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
          if (bt.isNullOrNil(this.xTn.xpl)) {
            break;
          }
          aqO(((com.tencent.mm.plugin.sns.storage.p)localObject3).dxX());
          AppMethodBeat.o(100195);
          return;
        }
        com.tencent.mm.plugin.sns.l.a.a((cs)localObject2, paramMenuItem, this.xTm);
        ((cs)localObject2).deQ.activity = this.activity;
        ((cs)localObject2).deQ.deW = 28;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        if (((cs)localObject2).deR.ret == 0)
        {
          l = bt.aGK();
          if (!bt.isNullOrNil(paramMenuItem))
          {
            ad.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
            localObject2 = "";
          }
        }
        try
        {
          paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
          com.tencent.mm.plugin.report.service.h.vKh.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          AppMethodBeat.o(100195);
          return;
        }
        catch (UnsupportedEncodingException paramMenuItem)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
            paramMenuItem = (MenuItem)localObject2;
          }
        }
        ap.v(af.dtu().apK(this.xTm));
        AppMethodBeat.o(100195);
        return;
        if (!(this.xTl.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
          break;
        }
        ap.b((com.tencent.mm.plugin.sns.ui.m)this.xTl.getTag());
        AppMethodBeat.o(100195);
        return;
        localObject4 = com.tencent.mm.plugin.sns.storage.h.apK(this.xTm);
        if (localObject4 == null)
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
          AppMethodBeat.o(100195);
          return;
        }
        if ((this.xTl.getTag() == null) || (!(this.xTl.getTag() instanceof aw)))
        {
          ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
          AppMethodBeat.o(100195);
          return;
        }
        localObject2 = (aw)this.xTl.getTag();
        localObject3 = this.activity;
        localObject5 = paramMenuItem.getIntent();
        if (this.dep == 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          i = this.dep;
          paramMenuItem = this.xlD;
          if (localObject5 != null) {
            break;
          }
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
          AppMethodBeat.o(100195);
          return;
        }
        if (paramMenuItem == null)
        {
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
          AppMethodBeat.o(100195);
          return;
        }
        if (localObject4 == null)
        {
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
          AppMethodBeat.o(100195);
          return;
        }
        com.tencent.mm.kernel.g.afC();
        if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
        {
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
          AppMethodBeat.o(100195);
          return;
        }
        localObject6 = ((aw)localObject2).diQ;
        int j = ((aw)localObject2).index;
        int k = ((aw)localObject2).position;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dxy();
        if ((((TimeLineObject)localObject2).Etm == null) || (((TimeLineObject)localObject2).Etm.DaC.size() == 0))
        {
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
          AppMethodBeat.o(100195);
          return;
        }
        paramMenuItem.dsZ().C((com.tencent.mm.plugin.sns.storage.p)localObject4);
        localObject7 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dxy();
        if (j < ((TimeLineObject)localObject7).Etm.DaC.size()) {}
        for (paramMenuItem = (bpi)((TimeLineObject)localObject7).Etm.DaC.get(j); !af.dtr().B(paramMenuItem); paramMenuItem = new bpi())
        {
          ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.dzf) });
          AppMethodBeat.o(100195);
          return;
        }
        if (paramInt == 1)
        {
          localObject2 = com.tencent.mm.modelsns.d.oE(716);
          ((com.tencent.mm.modelsns.d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject4)).oH(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).ew(((com.tencent.mm.plugin.sns.storage.p)localObject4).Nb(32)).zi(((com.tencent.mm.plugin.sns.storage.p)localObject4).dyg()).zi(paramMenuItem.Id).oH(j).oH(((TimeLineObject)localObject7).Etm.DaC.size());
          ((com.tencent.mm.modelsns.d)localObject2).aBj();
          if (paramInt != 1) {
            break label6641;
          }
        }
        label6641:
        for (paramMenuItem = com.tencent.mm.modelsns.d.oE(744);; paramMenuItem = com.tencent.mm.modelsns.d.oF(744))
        {
          paramMenuItem.zi(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject4)).oH(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).ew(((com.tencent.mm.plugin.sns.storage.p)localObject4).Nb(32)).zi(((com.tencent.mm.plugin.sns.storage.p)localObject4).dyg());
          paramMenuItem.b((Intent)localObject5, "intent_key_StatisticsOplog");
          ((Intent)localObject5).putExtra("sns_soon_enter_photoedit_ui", true);
          ((Intent)localObject5).putExtra("sns_gallery_localId", (String)localObject6);
          ((Intent)localObject5).putExtra("sns_gallery_position", j);
          ((Intent)localObject5).putExtra("sns_position", k);
          ((Intent)localObject5).putExtra("sns_gallery_showtype", 1);
          ((Intent)localObject5).putExtra("K_ad_scene", paramInt);
          ((Intent)localObject5).putExtra("K_ad_source", i);
          ((Intent)localObject5).putExtra("k_is_from_sns_main_timeline", true);
          ((Intent)localObject5).setClass((Context)localObject3, SnsBrowseUI.class);
          paramMenuItem = new Bundle();
          paramMenuItem.putInt("stat_scene", 3);
          paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
          paramMenuItem.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
          ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, paramMenuItem.adn(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).overridePendingTransition(0, 0);
          AppMethodBeat.o(100195);
          return;
          localObject2 = com.tencent.mm.modelsns.d.oF(716);
          break;
        }
        if (this.xTn == null)
        {
          ad.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
          AppMethodBeat.o(100195);
          return;
        }
        paramMenuItem = new cs();
        com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, this.xTm);
        paramMenuItem.deQ.activity = this.activity;
        paramMenuItem.deQ.deW = 28;
        com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
        break;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(100198);
    ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.xlp != null) && (this.xlp.isShowing())) {
      this.xlp.dismiss();
    }
    AppMethodBeat.o(100198);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a
 * JD-Core Version:    0.7.0.1
 */