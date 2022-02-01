package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.g.a.ur.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.ad.d.m.d;
import com.tencent.mm.plugin.sns.ad.d.m.e;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
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
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.base.n.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements com.tencent.mm.ak.g, n.d
{
  private Activity activity;
  private int dbL;
  private ClipboardManager qRg;
  protected com.tencent.mm.plugin.sns.ad.d.i yJJ;
  private com.tencent.mm.ui.base.p yyh;
  private ae yyv;
  private View zgh;
  private String zgi;
  private TimeLineObject zgj;
  
  public a(Activity paramActivity, int paramInt, ae paramae)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.dbL = paramInt;
    this.qRg = ((ClipboardManager)ai.getContext().getSystemService("clipboard"));
    this.yyv = paramae;
    AppMethodBeat.o(100192);
  }
  
  private void avX(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = af.dHR().auT(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dLV();
    if (((com.tencent.mm.plugin.sns.storage.p)localObject2).Pe(32))
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dME();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H((com.tencent.mm.plugin.sns.storage.p)localObject2);
      if (!bs.isNullOrNil(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localTimeLineObject.yCb)
    {
      localObject3 = bv.L((String)localObject1, "adxml");
      if (localObject3 != null) {
        break;
      }
      AppMethodBeat.o(100196);
      return;
    }
    if (!((Map)localObject3).containsKey(".adxml.adCanvasInfo"))
    {
      com.tencent.mm.ui.base.h.l(this.activity, 2131758895, 0);
      AppMethodBeat.o(100196);
      return;
    }
    String str1 = y.xJ(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
    String str2 = bs.bG((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bs.bG((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bs.bG((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cs();
    ur localur = new ur();
    localur.dxn.dxq = paramString;
    localur.dxn.dxr = ((cs)localObject2);
    localur.dxn.url = str3;
    com.tencent.mm.sdk.b.a.GpY.l(localur);
    if (!localur.dxo.dbS)
    {
      if (((cs)localObject2).dck.dcp == 0) {
        ((cs)localObject2).dck.dcp = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(this.activity, ((cs)localObject2).dck.dcp, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((cs)localObject2).dck.sessionId = str1;
    ((cs)localObject2).dck.title = str2;
    ((cs)localObject2).dck.desc = ((String)localObject3);
    paramString = ((cs)localObject2).dck.dcm;
    if ((paramString != null) && (paramString.nxC != null) && (paramString.nxC.size() > 0) && (paramString.nxC.get(0) != null))
    {
      ((agx)paramString.nxC.get(0)).aJb((String)localObject1);
      if (bs.isNullOrNil(((agx)paramString.nxC.get(0)).title)) {
        ((agx)paramString.nxC.get(0)).aIC(((cs)localObject2).dck.title);
      }
      if (bs.isNullOrNil(((agx)paramString.nxC.get(0)).desc)) {
        ((agx)paramString.nxC.get(0)).aID(((cs)localObject2).dck.desc);
      }
      localObject1 = new aht();
      ((aht)localObject1).aJC(localTimeLineObject.ncR);
      ((aht)localObject1).aJD(u.axw());
      ((aht)localObject1).XV(2);
      ((aht)localObject1).zY(bs.eWj());
      paramString.a((aht)localObject1);
    }
    ((cs)localObject2).dck.activity = this.activity;
    ((cs)localObject2).dck.dcq = 28;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private String dRQ()
  {
    AppMethodBeat.i(100193);
    if ((this.zgh != null) && ((this.zgh instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.zgh != null) && ((this.zgh.getTag() instanceof ba)) && (((ba)this.zgh.getTag()).dQd()))
    {
      Object localObject = aq.atX(af.dHR().auT(this.zgi).getSnsId());
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).result;
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
      if (this.dbL == 2)
      {
        paramp = paramp.dLS();
        AppMethodBeat.o(100194);
        return paramp;
      }
      paramp = paramp.dFQ();
      AppMethodBeat.o(100194);
      return paramp;
    }
    AppMethodBeat.o(100194);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.zgh = paramView;
    this.zgi = paramString;
    this.zgj = paramTimeLineObject;
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.yJJ = parami;
  }
  
  public final void cVE()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        com.tencent.mm.plugin.sns.storage.p localp = af.dHR().auT(this.zgi);
        Object localObject1 = (btz)this.zgj.FQo.Etz.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((btz)localObject1);
        paramIntent = bs.S(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localp.Pe(32))
          {
            str3 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((btz)localObject1);
            TimeLineObject localTimeLineObject = localp.dLV();
            com.tencent.mm.plugin.sns.storage.b localb = localp.dFR();
            dev localdev = new dev();
            localdev.EBs = ((btz)localObject1).yYY;
            localdev.hjV = ((btz)localObject1).Fjo;
            if (localTimeLineObject.FQo.Ety == 15)
            {
              localdev.hkb = f(localp).dtx;
              localdev.hkc = localTimeLineObject.Id;
              localdev.hjX = localTimeLineObject.FQl;
              if (!bs.isNullOrNil(((btz)localObject1).Fjr)) {
                break label551;
              }
              paramIntent = ((btz)localObject1).Fjh;
              label288:
              localdev.hka = paramIntent;
              if ((localb != null) && (localb.yfC == 0))
              {
                localdev.hjZ = localb.yfE;
                localdev.hjY = localb.yfD;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.q.ate(str3);
              ac.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((btz)localObject1).Fjo, Integer.valueOf(((btz)localObject1).yYY), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.j.dck().a(this.activity, str1, str3, str2, 43, paramInt1, localdev, localTimeLineObject.yAj, null);
              com.tencent.mm.plugin.messenger.a.j.dck().hF((String)localObject2, str1);
              paramInt2 = this.dbL;
              if (this.dbL != 0) {
                break label560;
              }
              paramInt1 = 1;
              label443:
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(paramInt2, paramInt1, localp.field_snsId, 12, 0));
              boolean bool = w.sQ(str1);
              localObject1 = m.d.xKN;
              if (!bool) {
                break label565;
              }
              paramIntent = m.c.xKK;
              label484:
              localObject2 = m.e.xKT;
              if (!bool) {
                break label572;
              }
            }
            label551:
            label560:
            label565:
            label572:
            for (paramInt1 = com.tencent.mm.model.q.wb(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.ad.d.m.a((m.d)localObject1, paramIntent, (m.e)localObject2, paramInt1, localp, this.dbL);
              AppMethodBeat.o(100197);
              return;
              localdev.hkb = localTimeLineObject.FQt.hkb;
              localdev.hkc = localTimeLineObject.FQt.hkc;
              break;
              paramIntent = ((btz)localObject1).Fjr;
              break label288;
              paramInt1 = 2;
              break label443;
              paramIntent = m.c.xKJ;
              break label484;
            }
          }
          String str3 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((btz)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.q.ate(str3);
          ac.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((btz)localObject1).Fjo, Integer.valueOf(((btz)localObject1).yYY), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.j.dck().a(this.activity, str1, str3, str2, 43, paramInt1, this.zgj.yAj, null);
          com.tencent.mm.plugin.messenger.a.j.dck().hF((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this.activity, this.activity.getString(2131760233));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = af.dHR().auT(this.zgi);
      if (paramIntent == null)
      {
        ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.zgi });
        AppMethodBeat.o(100197);
        return;
      }
      paramInt2 = this.dbL;
      if (this.dbL != 0) {
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
    if (this.zgh == null)
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
    case 23: 
    case 9: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
    case 11: 
    case 13: 
    case 14: 
    case 15: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                AppMethodBeat.o(100195);
                return;
                Object localObject1 = dRQ();
                paramMenuItem = (MenuItem)localObject1;
                if (bs.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.zgj.FQl;
                }
                this.qRg.setText(paramMenuItem);
                com.tencent.mm.ui.base.h.cg(this.activity, this.activity.getString(2131755702));
                localObject1 = com.tencent.mm.plugin.secinforeport.a.a.xnM;
                com.tencent.mm.plugin.secinforeport.a.a.o(2, this.zgj.Id, bs.aLq(paramMenuItem));
                AppMethodBeat.o(100195);
                return;
                localObject1 = dRQ();
                paramMenuItem = (MenuItem)localObject1;
                if (bs.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.zgj.FQl;
                }
                this.yyv.dHw().jj(this.zgi, this.zgj.Id);
                localObject1 = new cs();
                com.tencent.mm.plugin.sns.k.a.a((cs)localObject1, this.zgi, paramMenuItem);
                ((cs)localObject1).dck.activity = this.activity;
                ((cs)localObject1).dck.dcq = 30;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(100195);
                return;
                this.yyv.dHw().jj(this.zgi, this.zgj.Id);
                localObject1 = new cs();
                paramMenuItem = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
                if ((paramMenuItem.Pe(32)) && (paramMenuItem.dFR().dJG()))
                {
                  avX(this.zgi);
                  if (paramMenuItem.Pe(32))
                  {
                    i = this.dbL;
                    if (this.dbL != 0) {
                      break label589;
                    }
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, this.yJJ, paramMenuItem, 11);
                  com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                  if (this.zgj.exP == 1)
                  {
                    com.tencent.mm.plugin.sns.k.a.a((cs)localObject1, this.zgi, 0);
                    ((cs)localObject1).dck.activity = this.activity;
                    ((cs)localObject1).dck.dcq = 31;
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
                    break;
                  }
                  if (!(this.zgh.getTag() instanceof aw)) {
                    break;
                  }
                  localObject3 = (aw)this.zgh.getTag();
                  com.tencent.mm.plugin.sns.k.a.a((cs)localObject1, this.zgi, ((aw)localObject3).index);
                  ((cs)localObject1).dck.activity = this.activity;
                  ((cs)localObject1).dck.dcq = 31;
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
                  break;
                }
                this.yyv.dHw().jj(this.zgi, this.zgj.Id);
                paramMenuItem = af.dHR().auT(this.zgi);
                if (this.zgj.FQo.Etz.size() != 0)
                {
                  localObject1 = (btz)this.zgj.FQo.Etz.get(0);
                  if ((paramMenuItem == null) || (localObject1 == null))
                  {
                    ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject3 = new cs();
                  if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.yvp != 0)) {
                    break label771;
                  }
                  ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                }
                for (((cs)localObject3).dck.dcp = 2131758885;; ((cs)localObject3).dck.dcp = 2131758903)
                {
                  ((cs)localObject3).dck.activity = this.activity;
                  ((cs)localObject3).dck.dcq = 25;
                  com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                  AppMethodBeat.o(100195);
                  return;
                  if (!af.dHA()) {
                    break;
                  }
                  ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                }
                localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.wW(paramMenuItem.field_snsId), ((btz)localObject1).Id });
                localObject4 = new ahn();
                localObject5 = new aht();
                ac.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
                ((aht)localObject5).aJC(paramMenuItem.field_userName);
                ((aht)localObject5).aJD(u.axw());
                ((aht)localObject5).XV(2);
                ((aht)localObject5).zY(paramMenuItem.field_createTime * 1000L);
                ((aht)localObject5).aJH(paramMenuItem.getSnsId());
                ((aht)localObject5).aJE((String)localObject7);
                localObject6 = new agx();
                ((agx)localObject6).aIU((String)localObject7);
                ((agx)localObject6).aIJ(((btz)localObject1).Url);
                ((agx)localObject6).aIK(((btz)localObject1).Fjl);
                ((agx)localObject6).aII(paramMenuItem.dLV().FQo.Url);
                localObject7 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((btz)localObject1);
                if (com.tencent.mm.vfs.i.eA((String)localObject7)) {
                  ((agx)localObject6).aIR((String)localObject7);
                }
                for (;;)
                {
                  ((agx)localObject6).aJi(((btz)localObject1).songAlbumUrl);
                  ((agx)localObject6).aJj(((btz)localObject1).songLyric);
                  ((agx)localObject6).XM(7);
                  ((agx)localObject6).aIC(((btz)localObject1).Title);
                  ((agx)localObject6).aID(((btz)localObject1).Desc);
                  ((agx)localObject6).vy(true);
                  ((ahn)localObject4).nxC.add(localObject6);
                  ((ahn)localObject4).a((aht)localObject5);
                  ((cs)localObject3).dck.dcm = ((ahn)localObject4);
                  ((cs)localObject3).dck.type = 7;
                  com.tencent.mm.plugin.sns.k.a.a((agx)localObject6, paramMenuItem);
                  break;
                  ((agx)localObject6).vz(true);
                  ((agx)localObject6).aIL(((btz)localObject1).Fjh);
                  localObject7 = new aic();
                  ((aic)localObject7).aJS(((btz)localObject1).Fjh);
                  ((ahn)localObject4).b((aic)localObject7);
                }
                paramMenuItem = this.activity;
                localObject3 = af.dHR().auT(this.zgi);
                if (localObject3 != null)
                {
                  localObject1 = new Intent();
                  if (((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().FQo.Ety != 1) {
                    break label1417;
                  }
                  paramInt = 0;
                  if ((this.zgh.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
                    paramInt = ((aw)this.zgh.getTag()).index;
                  }
                  localObject3 = aj.a((com.tencent.mm.plugin.sns.storage.p)localObject3, paramInt);
                  if (localObject3 == null)
                  {
                    ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject4 = ((btz)localObject3).Id;
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.g(com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.q.k((btz)localObject3), paramMenuItem));
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                }
                while (((((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().FQo.Ety != 4) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().FQo.Ety != 15) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().FQo.Ety != 3)) || ((btz)((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().FQo.Etz.get(0) != null))
                {
                  ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                  ((Intent)localObject1).putExtra("sns_local_id", this.zgi);
                  ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                  com.tencent.mm.br.d.e(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                }
                ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                AppMethodBeat.o(100195);
                return;
                localObject1 = this.activity;
                paramMenuItem = af.dHR().auT(this.zgi);
                if (paramMenuItem == null)
                {
                  ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                  AppMethodBeat.o(100195);
                  return;
                }
                if (paramMenuItem.Pe(32))
                {
                  ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                  AppMethodBeat.o(100195);
                  return;
                }
                if ((paramMenuItem.dLV() == null) || (paramMenuItem.dLV().FQo == null) || (bs.gY(paramMenuItem.dLV().FQo.Etz)))
                {
                  ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject3 = (btz)paramMenuItem.dLV().FQo.Etz.get(0);
                if (localObject3 == null)
                {
                  ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject4 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject3).Id);
                paramMenuItem = "";
                localObject5 = com.tencent.mm.plugin.sns.data.q.i((btz)localObject3);
                if (com.tencent.mm.vfs.i.eA((String)localObject4 + (String)localObject5)) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d((btz)localObject3);
                }
                if (com.tencent.mm.vfs.i.eA((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o((btz)localObject3))) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m((btz)localObject3);
                }
                localObject3 = new Intent();
                ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                ((Intent)localObject3).putExtra("intent_localid", this.zgi);
                ((Intent)localObject3).putExtra("intent_from_scene", this.dbL);
                ((Intent)localObject3).putExtra("intent_ismute", true);
                if ((localObject1 instanceof SnsTimeLineUI)) {
                  ((Intent)localObject3).putExtra("sns_video_scene", 1);
                }
                for (;;)
                {
                  if (this.zgh != null)
                  {
                    paramMenuItem = new int[2];
                    this.zgh.getLocationInWindow(paramMenuItem);
                    paramInt = this.zgh.getWidth();
                    i = this.zgh.getHeight();
                    ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                    ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                    ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                    ((Intent)localObject3).putExtra("img_gallery_height", i);
                  }
                  paramMenuItem = this.activity;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject3);
                  com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
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
                this.yyv.dHw().jj(this.zgi, this.zgj.Id);
                localObject1 = be.avM(this.zgj.FQo.Url);
                if (bs.isNullOrNil((String)localObject1))
                {
                  ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                paramMenuItem = new cs();
                localObject3 = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
                if (localObject3 != null)
                {
                  localObject4 = y.xJ(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId);
                  localObject5 = y.ayq().F((String)localObject4, true);
                  ((y.b)localObject5).l("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId));
                  ((y.b)localObject5).l("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_userName);
                  ((y.b)localObject5).l("preChatName", "");
                  ((y.b)localObject5).l("url", localObject1);
                  ((y.b)localObject5).l("preMsgIndex", Integer.valueOf(0));
                  ((y.b)localObject5).l("sendAppMsgScene", Integer.valueOf(1));
                  ((y.b)localObject5).l("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject3).dLV().yAj);
                  paramMenuItem.dck.sessionId = ((String)localObject4);
                }
                localObject4 = af.dHR().auT(this.zgi);
                if ((localObject4 != null) && (this.zgj.FQo.Ety == 18)) {
                  com.tencent.mm.plugin.sns.ad.d.m.a(m.d.xKO, m.c.xKI, m.e.xKT, 0, (com.tencent.mm.plugin.sns.storage.p)localObject4, this.dbL);
                }
                if (!bs.isNullOrNil(this.zgj.yCb))
                {
                  avX(((com.tencent.mm.plugin.sns.storage.p)localObject4).dMu());
                  AppMethodBeat.o(100195);
                  return;
                }
                if (((com.tencent.mm.plugin.sns.storage.p)localObject4).Pe(32))
                {
                  i = this.dbL;
                  if (this.dbL != 0) {
                    break label2650;
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject3 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject3, this.yJJ, (com.tencent.mm.plugin.sns.storage.p)localObject4, 11);
                  com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
                  com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, (String)localObject1, this.zgi);
                  paramMenuItem.dck.activity = this.activity;
                  paramMenuItem.dck.dcq = 28;
                  com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
                  if (paramMenuItem.dcl.ret == 0)
                  {
                    l = bs.aNx();
                    if (!bs.isNullOrNil((String)localObject1))
                    {
                      ac.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
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
                      ac.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                  AppMethodBeat.o(100195);
                  return;
                }
                this.yyv.dHw().jj(this.zgi, this.zgj.Id);
              } while (this.zgj == null);
              paramMenuItem = new cs();
              localObject5 = this.zgj;
              if (localObject5 == null)
              {
                ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.dck.dcp = 2131758885;
              }
              for (;;)
              {
                paramMenuItem.dck.activity = this.activity;
                paramMenuItem.dck.dcq = 26;
                com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
                AppMethodBeat.o(100195);
                return;
                localObject2 = new ahn();
                localObject3 = new aht();
                localObject4 = new ahm();
                ((aht)localObject3).aJC(((TimeLineObject)localObject5).ncR);
                ((aht)localObject3).aJD(u.axw());
                ((aht)localObject3).XV(2);
                ((aht)localObject3).zY(bs.eWj());
                if (((TimeLineObject)localObject5).FQn != null) {
                  ((aht)localObject3).aJI(((TimeLineObject)localObject5).FQn.Id);
                }
                if (((TimeLineObject)localObject5).FQo != null)
                {
                  ((ahm)localObject4).aJv(((TimeLineObject)localObject5).FQo.Title);
                  ((ahm)localObject4).aJw(((TimeLineObject)localObject5).FQo.Desc);
                  if ((((TimeLineObject)localObject5).FQo.Etz != null) && (!((TimeLineObject)localObject5).FQo.Etz.isEmpty()))
                  {
                    localObject5 = (btz)((TimeLineObject)localObject5).FQo.Etz.get(0);
                    ((ahm)localObject4).XS(((btz)localObject5).subType);
                    ((ahm)localObject4).aJy(((btz)localObject5).yyV);
                    ((ahm)localObject4).aJx(((btz)localObject5).Fjh);
                  }
                }
                paramMenuItem.dck.title = ((ahm)localObject4).title;
                paramMenuItem.dck.desc = ((ahm)localObject4).desc;
                paramMenuItem.dck.dcm = ((ahn)localObject2);
                paramMenuItem.dck.type = 10;
                ((ahn)localObject2).a((aht)localObject3);
                ((ahn)localObject2).b((ahm)localObject4);
              }
              paramMenuItem = this.zgj.FQu;
              if ((this.zgj == null) || (paramMenuItem == null))
              {
                ac.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                AppMethodBeat.o(100195);
                return;
              }
              localObject5 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(paramMenuItem.username);
              localObject3 = new agv();
              ((agv)localObject3).username = paramMenuItem.username;
              if (localObject5 != null) {
                ((agv)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
              }
              ((agv)localObject3).cYQ = paramMenuItem.path;
              ((agv)localObject3).dib = paramMenuItem.BZZ;
              ((agv)localObject3).version = paramMenuItem.version;
              ((agv)localObject3).dxK = paramMenuItem.dxK;
              ((agv)localObject3).subType = paramMenuItem.subType;
              paramMenuItem = null;
              localObject4 = new agx();
              ((agx)localObject4).XM(19);
              if (this.zgj.FQo != null)
              {
                paramMenuItem = this.zgj.FQo.Title;
                if ((this.zgj.FQo.Etz != null) && (!this.zgj.FQo.Etz.isEmpty()))
                {
                  localObject2 = (btz)this.zgj.FQo.Etz.get(0);
                  localObject2 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((btz)localObject2);
                  ((agx)localObject4).aIQ((String)localObject2);
                  ((agx)localObject4).aIR((String)localObject2);
                  localObject2 = paramMenuItem;
                  if (bs.isNullOrNil(paramMenuItem)) {
                    if ((localObject5 == null) || (bs.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                      break label3539;
                    }
                  }
                }
              }
              for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(2131755945))
              {
                ((agx)localObject4).aIC((String)localObject2);
                ((agx)localObject4).aID((String)localObject2);
                ((agx)localObject4).aIP(com.tencent.mm.plugin.fav.a.b.cY(localObject4.toString(), 19));
                localObject5 = new aht();
                ((aht)localObject5).aJC(u.axw());
                ((aht)localObject5).zY(bs.eWj());
                ((aht)localObject5).XV(2);
                paramMenuItem = new ahn();
                paramMenuItem.nxC.add(localObject4);
                paramMenuItem.c((agv)localObject3);
                paramMenuItem.a((aht)localObject5);
                paramMenuItem.aJA((String)localObject2);
                localObject3 = new cs();
                ((cs)localObject3).dck.activity = this.activity;
                ((cs)localObject3).dck.title = ((String)localObject2);
                ((cs)localObject3).dck.desc = ((String)localObject2);
                ((cs)localObject3).dck.dcm = paramMenuItem;
                ((cs)localObject3).dck.type = 19;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
                AppMethodBeat.o(100195);
                return;
                ((agx)localObject4).vz(true);
                break;
                ((agx)localObject4).vz(true);
                break;
              }
              this.yyv.dHw().jj(this.zgi, this.zgj.Id);
            } while (this.zgj == null);
            paramMenuItem = new cs();
            localObject5 = this.zgj;
            if (localObject5 == null)
            {
              ac.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
              paramMenuItem.dck.dcp = 2131758885;
            }
            for (;;)
            {
              paramMenuItem.dck.activity = this.activity;
              paramMenuItem.dck.dcq = 27;
              com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
              AppMethodBeat.o(100195);
              return;
              localObject2 = new ahn();
              localObject3 = new aht();
              localObject4 = new ahw();
              ((aht)localObject3).aJC(((TimeLineObject)localObject5).ncR);
              ((aht)localObject3).aJD(u.axw());
              ((aht)localObject3).XV(8);
              ((aht)localObject3).zY(bs.eWj());
              if (((TimeLineObject)localObject5).FQn != null) {
                ((aht)localObject3).aJI(((TimeLineObject)localObject5).FQn.Id);
              }
              if (((TimeLineObject)localObject5).FQo != null)
              {
                ((ahw)localObject4).aJL(((TimeLineObject)localObject5).FQo.Title);
                ((ahw)localObject4).aJM(((TimeLineObject)localObject5).FQo.Desc);
                if ((((TimeLineObject)localObject5).FQo.Etz != null) && (!((TimeLineObject)localObject5).FQo.Etz.isEmpty()))
                {
                  localObject5 = (btz)((TimeLineObject)localObject5).FQo.Etz.get(0);
                  ((ahw)localObject4).aJO(((btz)localObject5).yyV);
                  ((ahw)localObject4).aJN(((btz)localObject5).Fjh);
                }
              }
              paramMenuItem.dck.title = ((ahw)localObject4).title;
              paramMenuItem.dck.desc = ((ahw)localObject4).desc;
              paramMenuItem.dck.dcm = ((ahn)localObject2);
              paramMenuItem.dck.type = 15;
              ((ahn)localObject2).a((aht)localObject3);
              ((ahn)localObject2).b((ahw)localObject4);
            }
            paramMenuItem = af.dHR().auT(this.zgi).getSnsId();
            localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.zgh.getTag();
            if (x.avo(paramMenuItem))
            {
              paramMenuItem = new com.tencent.mm.plugin.sns.model.q(x.asL(paramMenuItem), 6, ((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(paramMenuItem, 0);
            }
            for (;;)
            {
              localObject2 = this.activity;
              this.activity.getString(2131755906);
              this.yyh = com.tencent.mm.ui.base.h.b((Context)localObject2, this.activity.getString(2131763798), true, new a.1(this, paramMenuItem));
              AppMethodBeat.o(100195);
              return;
              paramMenuItem = new com.tencent.mm.plugin.sns.model.q(x.asL(paramMenuItem), 4, ((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a(paramMenuItem, 0);
            }
            paramMenuItem = af.dHR().auT(this.zgi);
          } while (paramMenuItem == null);
          com.tencent.mm.plugin.sns.abtest.a.b(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
          ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.field_userName);
          ((Intent)localObject2).putExtra("sns_permission_anim", true);
          ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
          this.activity.startActivityForResult((Intent)localObject2, 11);
          AppMethodBeat.o(100195);
          return;
          this.yyv.dHw().jj(this.zgi, this.zgj.Id);
          paramMenuItem = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
          if ((paramMenuItem != null) && (paramMenuItem.Pe(32)) && (paramMenuItem.dFR().dJG()))
          {
            localObject2 = af.dHR().auT(this.zgi);
            if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Pe(32)))
            {
              i = this.dbL;
              if (this.dbL != 0) {
                break label4302;
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.yJJ, paramMenuItem, 11);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              avX(this.zgi);
              AppMethodBeat.o(100195);
              return;
            }
          }
          paramMenuItem = this.zgi;
          paramMenuItem = af.dHR().auT(paramMenuItem);
          if (paramMenuItem != null) {
            if (paramMenuItem.Pe(32))
            {
              com.tencent.mm.plugin.sns.ad.d.m.a(m.d.xKN, m.c.xKI, m.e.xKT, 0, paramMenuItem, this.dbL);
              i = this.dbL;
              if (this.dbL != 0) {
                break label4454;
              }
            }
          }
          for (paramInt = 1;; paramInt = 2)
          {
            localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.yJJ, paramMenuItem, 11);
            com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
            localObject2 = new cs();
            com.tencent.mm.plugin.sns.k.a.a((cs)localObject2, paramMenuItem);
            ((cs)localObject2).dck.activity = this.activity;
            ((cs)localObject2).dck.dcq = 29;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
            AppMethodBeat.o(100195);
            return;
          }
          paramMenuItem = (btz)this.zgj.FQo.Etz.get(0);
          paramMenuItem = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.q.d(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.br.d.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
          AppMethodBeat.o(100195);
          return;
        } while (!(this.zgh.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
        paramMenuItem = (com.tencent.mm.plugin.sns.ui.m)this.zgh.getTag();
        this.qRg.setText(paramMenuItem.hkR);
        com.tencent.mm.ui.base.h.cg(this.activity, this.activity.getString(2131755702));
        if (paramMenuItem.xRC != null)
        {
          localObject2 = com.tencent.mm.plugin.secinforeport.a.a.xnM;
          com.tencent.mm.plugin.secinforeport.a.a.o(4, this.zgj.Id + ":" + paramMenuItem.xRC.FIZ, bs.aLq(paramMenuItem.hkR));
        }
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = af.dHR().auT(this.zgi);
        com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject2 = af.dHR().auT(this.zgi);
        if (localObject2 != null) {
          if (this.dbL != 0) {
            break label4818;
          }
        }
        for (paramMenuItem = com.tencent.mm.modelsns.d.ps(714);; paramMenuItem = com.tencent.mm.modelsns.d.pt(714))
        {
          paramMenuItem.Dn(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject2)).pv(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_type).eQ(((com.tencent.mm.plugin.sns.storage.p)localObject2).Pe(32)).Dn(((com.tencent.mm.plugin.sns.storage.p)localObject2).dMD());
          paramMenuItem.aHZ();
          aq.v((com.tencent.mm.plugin.sns.storage.p)localObject2);
          AppMethodBeat.o(100195);
          return;
        }
      } while (!(this.zgh.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.zgh.getTag();
      localObject3 = af.dHR().auS(((com.tencent.mm.plugin.sns.ui.m)localObject2).yyH);
      if (localObject3 != null)
      {
        if (this.dbL != 0) {
          break label4995;
        }
        paramMenuItem = com.tencent.mm.modelsns.d.ps(715);
        paramMenuItem.Dn(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject3)).pv(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_type).eQ(((com.tencent.mm.plugin.sns.storage.p)localObject3).Pe(32)).Dn(((com.tencent.mm.plugin.sns.storage.p)localObject3).dMD());
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC == null) {
          break label5031;
        }
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC.FIZ != 0) {
          break label5005;
        }
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC.FJb;
        paramMenuItem.Dn((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.aHZ();
        aq.a((com.tencent.mm.plugin.sns.ui.m)this.zgh.getTag());
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = com.tencent.mm.modelsns.d.pt(715);
        break;
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).xRC.FIZ;
        break label4963;
        paramMenuItem.Dn("");
      }
    case 20: 
      label3539:
      label4454:
      this.yyv.dHw().jj(this.zgi, this.zgj.Id);
      label4302:
      label4818:
      label4963:
      paramMenuItem = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
      label4995:
      label5005:
      label5031:
      if ((paramMenuItem != null) && (paramMenuItem.Pe(32)) && (paramMenuItem.dFR().dJG()))
      {
        localObject2 = af.dHR().auT(this.zgi);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Pe(32)) && (this.zgj != null))
        {
          i = this.dbL;
          if (this.dbL != 0) {
            break label5193;
          }
        }
        label5193:
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.yJJ, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
          avX(this.zgi);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.zgi;
      localObject3 = af.dHR().auT(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((com.tencent.mm.plugin.sns.storage.p)localObject3).Pe(32))
        {
          localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dMC();
          paramMenuItem = (MenuItem)localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dMB();
          }
        }
      }
      if (bs.isNullOrNil(paramMenuItem)) {
        paramMenuItem = be.avM(this.zgj.FQo.Url);
      }
      break;
    }
    for (;;)
    {
      if (bs.isNullOrNil(paramMenuItem))
      {
        ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = new cs();
      localObject4 = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
      if (localObject4 != null)
      {
        localObject5 = y.xJ(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId);
        localObject6 = y.ayq().F((String)localObject5, true);
        ((y.b)localObject6).l("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        ((y.b)localObject6).l("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((y.b)localObject6).l("preChatName", "");
        ((y.b)localObject6).l("url", paramMenuItem);
        ((y.b)localObject6).l("preMsgIndex", Integer.valueOf(0));
        ((y.b)localObject6).l("sendAppMsgScene", Integer.valueOf(1));
        ((y.b)localObject6).l("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject4).dLV().yAj);
        ((cs)localObject2).dck.sessionId = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.zgj.FQo.Ety == 18) || (((com.tencent.mm.plugin.sns.storage.p)localObject3).Pe(32))))
      {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.d.xKO, m.c.xKI, m.e.xKT, 0, (com.tencent.mm.plugin.sns.storage.p)localObject3, this.dbL);
        if (this.zgj != null)
        {
          i = this.dbL;
          if (this.dbL != 0) {
            break label5618;
          }
        }
      }
      label5618:
      for (paramInt = 1;; paramInt = 2)
      {
        localObject4 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, this.yJJ, (com.tencent.mm.plugin.sns.storage.p)localObject3, 11);
        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
        if (bs.isNullOrNil(this.zgj.yCb)) {
          break;
        }
        avX(((com.tencent.mm.plugin.sns.storage.p)localObject3).dMu());
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.plugin.sns.k.a.a((cs)localObject2, paramMenuItem, this.zgi);
      ((cs)localObject2).dck.activity = this.activity;
      ((cs)localObject2).dck.dcq = 28;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((cs)localObject2).dcl.ret == 0)
      {
        l = bs.aNx();
        if (!bs.isNullOrNil(paramMenuItem))
        {
          ac.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject2 = "";
        }
      }
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.h.wUl.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(100195);
        return;
      }
      catch (UnsupportedEncodingException paramMenuItem)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
          paramMenuItem = (MenuItem)localObject2;
        }
      }
      aq.w(af.dHR().auT(this.zgi));
      AppMethodBeat.o(100195);
      return;
      if (!(this.zgh.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
        break;
      }
      aq.b((com.tencent.mm.plugin.sns.ui.m)this.zgh.getTag());
      AppMethodBeat.o(100195);
      return;
      localObject4 = com.tencent.mm.plugin.sns.storage.h.auT(this.zgi);
      if (localObject4 == null)
      {
        ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        AppMethodBeat.o(100195);
        return;
      }
      if ((this.zgh.getTag() == null) || (!(this.zgh.getTag() instanceof aw)))
      {
        ac.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = (aw)this.zgh.getTag();
      localObject3 = this.activity;
      localObject5 = paramMenuItem.getIntent();
      if (this.dbL == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        i = this.dbL;
        paramMenuItem = this.yyv;
        if (localObject5 != null) {
          break;
        }
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
        AppMethodBeat.o(100195);
        return;
      }
      if (paramMenuItem == null)
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
        AppMethodBeat.o(100195);
        return;
      }
      if (localObject4 == null)
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
        AppMethodBeat.o(100195);
        return;
      }
      localObject6 = ((aw)localObject2).dgl;
      int j = ((aw)localObject2).index;
      int k = ((aw)localObject2).position;
      localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dLV();
      if ((((TimeLineObject)localObject2).FQo == null) || (((TimeLineObject)localObject2).FQo.Etz.size() == 0))
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem.dHw().D((com.tencent.mm.plugin.sns.storage.p)localObject4);
      localObject7 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dLV();
      if (j < ((TimeLineObject)localObject7).FQo.Etz.size()) {}
      for (paramMenuItem = (btz)((TimeLineObject)localObject7).FQo.Etz.get(j); !af.dHO().B(paramMenuItem); paramMenuItem = new btz())
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.dwR) });
        AppMethodBeat.o(100195);
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = com.tencent.mm.modelsns.d.ps(716);
        ((com.tencent.mm.modelsns.d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject4)).pv(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eQ(((com.tencent.mm.plugin.sns.storage.p)localObject4).Pe(32)).Dn(((com.tencent.mm.plugin.sns.storage.p)localObject4).dMD()).Dn(paramMenuItem.Id).pv(j).pv(((TimeLineObject)localObject7).FQo.Etz.size());
        ((com.tencent.mm.modelsns.d)localObject2).aHZ();
        if (paramInt != 1) {
          break label6663;
        }
      }
      label6663:
      for (paramMenuItem = com.tencent.mm.modelsns.d.ps(744);; paramMenuItem = com.tencent.mm.modelsns.d.pt(744))
      {
        paramMenuItem.Dn(com.tencent.mm.plugin.sns.data.q.l((com.tencent.mm.plugin.sns.storage.p)localObject4)).pv(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eQ(((com.tencent.mm.plugin.sns.storage.p)localObject4).Pe(32)).Dn(((com.tencent.mm.plugin.sns.storage.p)localObject4).dMD());
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
        paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        paramMenuItem.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(localObject5);
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, paramMenuItem.aeD(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).startActivity((Intent)paramMenuItem.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).overridePendingTransition(0, 0);
        AppMethodBeat.o(100195);
        return;
        localObject2 = com.tencent.mm.modelsns.d.pt(716);
        break;
      }
      if (this.zgj == null)
      {
        ac.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem = new cs();
      com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, this.zgi);
      paramMenuItem.dck.activity = this.activity;
      paramMenuItem.dck.dcq = 28;
      com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(100198);
    ac.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.yyh != null) && (this.yyh.isShowing())) {
      this.yyh.dismiss();
    }
    AppMethodBeat.o(100198);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a
 * JD-Core Version:    0.7.0.1
 */