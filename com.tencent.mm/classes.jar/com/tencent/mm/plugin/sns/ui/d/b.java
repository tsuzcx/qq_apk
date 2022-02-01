package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vk.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.ad.d.m.d;
import com.tencent.mm.plugin.sns.ad.d.m.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.aks;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.al.f, n.e
{
  protected com.tencent.mm.plugin.sns.ad.d.i Abd;
  View Ayg;
  private String Ayh;
  private TimeLineObject Ayi;
  Activity activity;
  private int dnh;
  private ClipboardManager rBg;
  private af zPG;
  com.tencent.mm.ui.base.p zPt;
  
  public b(Activity paramActivity, int paramInt, af paramaf)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.dnh = paramInt;
    this.rBg = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    this.zPG = paramaf;
    AppMethodBeat.o(100192);
  }
  
  private void aBe(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = ag.dUe().aAa(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dYl();
    if (((com.tencent.mm.plugin.sns.storage.p)localObject2).QM(32))
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).dYU();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J((com.tencent.mm.plugin.sns.storage.p)localObject2);
      if (!bt.isNullOrNil(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localTimeLineObject.zTv)
    {
      localObject3 = bw.M((String)localObject1, "adxml");
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
    String str1 = y.AH(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
    String str2 = bt.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bt.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bt.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cv();
    vk localvk = new vk();
    localvk.dJz.dJC = paramString;
    localvk.dJz.dJD = ((cv)localObject2);
    localvk.dJz.url = str3;
    com.tencent.mm.sdk.b.a.IbL.l(localvk);
    if (!localvk.dJA.dno)
    {
      if (((cv)localObject2).dnG.dnL == 0) {
        ((cv)localObject2).dnG.dnL = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(this.activity, ((cv)localObject2).dnG.dnL, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((cv)localObject2).dnG.sessionId = str1;
    ((cv)localObject2).dnG.title = str2;
    ((cv)localObject2).dnG.desc = ((String)localObject3);
    paramString = ((cv)localObject2).dnG.dnI;
    if ((paramString != null) && (paramString.nZa != null) && (paramString.nZa.size() > 0) && (paramString.nZa.get(0) != null))
    {
      ((ajn)paramString.nZa.get(0)).aOE((String)localObject1);
      if (bt.isNullOrNil(((ajn)paramString.nZa.get(0)).title)) {
        ((ajn)paramString.nZa.get(0)).aOf(((cv)localObject2).dnG.title);
      }
      if (bt.isNullOrNil(((ajn)paramString.nZa.get(0)).desc)) {
        ((ajn)paramString.nZa.get(0)).aOg(((cv)localObject2).dnG.desc);
      }
      localObject1 = new akj();
      ((akj)localObject1).aPf(localTimeLineObject.nDo);
      ((akj)localObject1).aPg(u.aAm());
      ((akj)localObject1).ZR(2);
      ((akj)localObject1).CM(bt.flT());
      paramString.a((akj)localObject1);
    }
    ((cv)localObject2).dnG.activity = this.activity;
    ((cv)localObject2).dnG.dnM = 28;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private String eek()
  {
    AppMethodBeat.i(100193);
    if ((this.Ayg != null) && ((this.Ayg instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.Ayg != null) && ((this.Ayg.getTag() instanceof bd)) && (((bd)this.Ayg.getTag()).ect()))
    {
      Object localObject = ar.azc(ag.dUe().aAa(this.Ayh).getSnsId());
      if (localObject != null)
      {
        localObject = ((ar.b)localObject).result;
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
      if (this.dnh == 2)
      {
        paramp = paramp.dYi();
        AppMethodBeat.o(100194);
        return paramp;
      }
      paramp = paramp.dRK();
      AppMethodBeat.o(100194);
      return paramp;
    }
    AppMethodBeat.o(100194);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.Ayg = paramView;
    this.Ayh = paramString;
    this.Ayi = paramTimeLineObject;
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.Abd = parami;
  }
  
  public final void deP()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        com.tencent.mm.plugin.sns.storage.p localp = ag.dUe().aAa(this.Ayh);
        Object localObject1 = (byn)this.Ayi.HAT.GaQ.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((byn)localObject1);
        paramIntent = bt.U(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localp.QM(32))
          {
            str3 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((byn)localObject1);
            TimeLineObject localTimeLineObject = localp.dYl();
            com.tencent.mm.plugin.sns.storage.b localb = localp.dRL();
            dki localdki = new dki();
            localdki.Gje = ((byn)localObject1).AqM;
            localdki.hCe = ((byn)localObject1).GSP;
            if (localTimeLineObject.HAT.GaP == 15)
            {
              localdki.hCk = f(localp).dFy;
              localdki.hCl = localTimeLineObject.Id;
              localdki.hCg = localTimeLineObject.HAQ;
              if (!bt.isNullOrNil(((byn)localObject1).GSS)) {
                break label551;
              }
              paramIntent = ((byn)localObject1).GSI;
              label288:
              localdki.hCj = paramIntent;
              if ((localb != null) && (localb.zvE == 0))
              {
                localdki.hCi = localb.zvG;
                localdki.hCh = localb.zvF;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.q.ayj(str3);
              ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((byn)localObject1).GSP, Integer.valueOf(((byn)localObject1).AqM), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.g.dlD().a(this.activity, str1, str3, str2, 43, paramInt1, localdki, localTimeLineObject.zRz, null);
              com.tencent.mm.plugin.messenger.a.g.dlD().hP((String)localObject2, str1);
              paramInt2 = this.dnh;
              if (this.dnh != 0) {
                break label560;
              }
              paramInt1 = 1;
              label443:
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(paramInt2, paramInt1, localp.field_snsId, 12, 0));
              boolean bool = w.vF(str1);
              localObject1 = m.d.zac;
              if (!bool) {
                break label565;
              }
              paramIntent = m.c.yZZ;
              label484:
              localObject2 = m.e.zai;
              if (!bool) {
                break label572;
              }
            }
            label551:
            label560:
            label565:
            label572:
            for (paramInt1 = com.tencent.mm.model.q.yS(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.ad.d.m.a((m.d)localObject1, paramIntent, (m.e)localObject2, paramInt1, localp, this.dnh);
              AppMethodBeat.o(100197);
              return;
              localdki.hCk = localTimeLineObject.HAY.hCk;
              localdki.hCl = localTimeLineObject.HAY.hCl;
              break;
              paramIntent = ((byn)localObject1).GSS;
              break label288;
              paramInt1 = 2;
              break label443;
              paramIntent = m.c.yZY;
              break label484;
            }
          }
          String str3 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.i((byn)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.q.ayj(str3);
          ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((byn)localObject1).GSP, Integer.valueOf(((byn)localObject1).AqM), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.dlD().a(this.activity, str1, str3, str2, 43, paramInt1, this.Ayi.zRz, null);
          com.tencent.mm.plugin.messenger.a.g.dlD().hP((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this.activity, this.activity.getString(2131760233));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = ag.dUe().aAa(this.Ayh);
      if (paramIntent == null)
      {
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.Ayh });
        AppMethodBeat.o(100197);
        return;
      }
      paramInt2 = this.dnh;
      if (this.dnh != 0) {
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
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.Ayg == null)
    {
      AppMethodBeat.o(100195);
      return;
    }
    int i;
    Object localObject3;
    label597:
    Object localObject7;
    label779:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    label1425:
    long l;
    label2658:
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
                Object localObject1 = eek();
                paramMenuItem = (MenuItem)localObject1;
                if (bt.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.Ayi.HAQ;
                }
                this.rBg.setText(paramMenuItem);
                com.tencent.mm.ui.base.h.cl(this.activity, this.activity.getString(2131755702));
                localObject1 = com.tencent.mm.plugin.secinforeport.a.a.yBN;
                com.tencent.mm.plugin.secinforeport.a.a.o(2, this.Ayi.Id, bt.aQW(paramMenuItem));
                AppMethodBeat.o(100195);
                return;
                localObject1 = eek();
                paramMenuItem = (MenuItem)localObject1;
                if (bt.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.Ayi.HAQ;
                }
                this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
                localObject1 = new cv();
                com.tencent.mm.plugin.sns.k.a.a((cv)localObject1, this.Ayh, paramMenuItem);
                ((cv)localObject1).dnG.activity = this.activity;
                ((cv)localObject1).dnG.dnM = 30;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(100195);
                return;
                this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
                localObject1 = new cv();
                paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
                if ((paramMenuItem.QM(32)) && (paramMenuItem.dRL().dVU()))
                {
                  aBe(this.Ayh);
                  if (paramMenuItem.QM(32))
                  {
                    i = this.dnh;
                    if (this.dnh != 0) {
                      break label597;
                    }
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, this.Abd, paramMenuItem, 11);
                  com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                  if (this.Ayi.ePo == 1)
                  {
                    com.tencent.mm.plugin.sns.k.a.a((cv)localObject1, this.Ayh, 0);
                    ((cv)localObject1).dnG.activity = this.activity;
                    ((cv)localObject1).dnG.dnM = 31;
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
                    break;
                  }
                  if (!(this.Ayg.getTag() instanceof az)) {
                    break;
                  }
                  localObject3 = (az)this.Ayg.getTag();
                  com.tencent.mm.plugin.sns.k.a.a((cv)localObject1, this.Ayh, ((az)localObject3).index);
                  ((cv)localObject1).dnG.activity = this.activity;
                  ((cv)localObject1).dnG.dnM = 31;
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
                  break;
                }
                this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
                paramMenuItem = ag.dUe().aAa(this.Ayh);
                if (this.Ayi.HAT.GaQ.size() != 0)
                {
                  localObject1 = (byn)this.Ayi.HAT.GaQ.get(0);
                  if ((paramMenuItem == null) || (localObject1 == null))
                  {
                    ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject3 = new cv();
                  if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.zMC != 0)) {
                    break label779;
                  }
                  ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                }
                for (((cv)localObject3).dnG.dnL = 2131758885;; ((cv)localObject3).dnG.dnL = 2131758903)
                {
                  ((cv)localObject3).dnG.activity = this.activity;
                  ((cv)localObject3).dnG.dnM = 25;
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                  AppMethodBeat.o(100195);
                  return;
                  if (!ag.dTN()) {
                    break;
                  }
                  ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                }
                localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.q.zw(paramMenuItem.field_snsId), ((byn)localObject1).Id });
                localObject4 = new akd();
                localObject5 = new akj();
                ad.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
                ((akj)localObject5).aPf(paramMenuItem.field_userName);
                ((akj)localObject5).aPg(u.aAm());
                ((akj)localObject5).ZR(2);
                ((akj)localObject5).CM(paramMenuItem.field_createTime * 1000L);
                ((akj)localObject5).aPk(paramMenuItem.getSnsId());
                ((akj)localObject5).aPh((String)localObject7);
                localObject6 = new ajn();
                ((ajn)localObject6).aOx((String)localObject7);
                ((ajn)localObject6).aOm(((byn)localObject1).Url);
                ((ajn)localObject6).aOn(((byn)localObject1).GSM);
                ((ajn)localObject6).aOl(paramMenuItem.dYl().HAT.Url);
                localObject7 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id) + com.tencent.mm.plugin.sns.data.q.d((byn)localObject1);
                if (com.tencent.mm.vfs.i.fv((String)localObject7)) {
                  ((ajn)localObject6).aOu((String)localObject7);
                }
                for (;;)
                {
                  ((ajn)localObject6).aOL(((byn)localObject1).songAlbumUrl);
                  ((ajn)localObject6).aOM(((byn)localObject1).songLyric);
                  ((ajn)localObject6).ZI(7);
                  ((ajn)localObject6).aOf(((byn)localObject1).Title);
                  ((ajn)localObject6).aOg(((byn)localObject1).Desc);
                  ((ajn)localObject6).wk(true);
                  ((akd)localObject4).nZa.add(localObject6);
                  ((akd)localObject4).a((akj)localObject5);
                  ((cv)localObject3).dnG.dnI = ((akd)localObject4);
                  ((cv)localObject3).dnG.type = 7;
                  com.tencent.mm.plugin.sns.k.a.a((ajn)localObject6, paramMenuItem);
                  break;
                  ((ajn)localObject6).wl(true);
                  ((ajn)localObject6).aOo(((byn)localObject1).GSI);
                  localObject7 = new aks();
                  ((aks)localObject7).aPv(((byn)localObject1).GSI);
                  ((akd)localObject4).b((aks)localObject7);
                }
                paramMenuItem = this.activity;
                localObject3 = ag.dUe().aAa(this.Ayh);
                if (localObject3 != null)
                {
                  localObject1 = new Intent();
                  if (((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().HAT.GaP != 1) {
                    break label1425;
                  }
                  paramInt = 0;
                  if ((this.Ayg.getTag() instanceof aq)) {
                    paramInt = ((az)this.Ayg.getTag()).index;
                  }
                  localObject3 = ak.b((com.tencent.mm.plugin.sns.storage.p)localObject3, paramInt);
                  if (localObject3 == null)
                  {
                    ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject4 = ((byn)localObject3).Id;
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.g(ao.jo(ag.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.q.k((byn)localObject3), paramMenuItem));
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                }
                while (((((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().HAT.GaP != 4) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().HAT.GaP != 15) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().HAT.GaP != 3)) || ((byn)((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().HAT.GaQ.get(0) != null))
                {
                  ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                  ((Intent)localObject1).putExtra("sns_local_id", this.Ayh);
                  ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                  com.tencent.mm.bs.d.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                }
                ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                AppMethodBeat.o(100195);
                return;
                localObject1 = this.activity;
                paramMenuItem = ag.dUe().aAa(this.Ayh);
                if (paramMenuItem == null)
                {
                  ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                  AppMethodBeat.o(100195);
                  return;
                }
                if (paramMenuItem.QM(32))
                {
                  ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                  AppMethodBeat.o(100195);
                  return;
                }
                if ((paramMenuItem.dYl() == null) || (paramMenuItem.dYl().HAT == null) || (bt.hj(paramMenuItem.dYl().HAT.GaQ)))
                {
                  ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject3 = (byn)paramMenuItem.dYl().HAT.GaQ.get(0);
                if (localObject3 == null)
                {
                  ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject4 = ao.jo(ag.getAccSnsPath(), ((byn)localObject3).Id);
                paramMenuItem = "";
                localObject5 = com.tencent.mm.plugin.sns.data.q.i((byn)localObject3);
                if (com.tencent.mm.vfs.i.fv((String)localObject4 + (String)localObject5)) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d((byn)localObject3);
                }
                if (com.tencent.mm.vfs.i.fv((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o((byn)localObject3))) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m((byn)localObject3);
                }
                localObject3 = new Intent();
                ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                ((Intent)localObject3).putExtra("intent_localid", this.Ayh);
                ((Intent)localObject3).putExtra("intent_from_scene", this.dnh);
                ((Intent)localObject3).putExtra("intent_ismute", true);
                if ((localObject1 instanceof SnsTimeLineUI)) {
                  ((Intent)localObject3).putExtra("sns_video_scene", 1);
                }
                for (;;)
                {
                  if (this.Ayg != null)
                  {
                    paramMenuItem = new int[2];
                    this.Ayg.getLocationInWindow(paramMenuItem);
                    paramInt = this.Ayg.getWidth();
                    i = this.Ayg.getHeight();
                    ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                    ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                    ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                    ((Intent)localObject3).putExtra("img_gallery_height", i);
                  }
                  paramMenuItem = this.activity;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
                  com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
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
                this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
                localObject1 = bh.aAT(this.Ayi.HAT.Url);
                if (bt.isNullOrNil((String)localObject1))
                {
                  ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                paramMenuItem = new cv();
                localObject3 = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
                if (localObject3 != null)
                {
                  localObject4 = y.AH(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId);
                  localObject5 = y.aBq().F((String)localObject4, true);
                  ((y.b)localObject5).k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId));
                  ((y.b)localObject5).k("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_userName);
                  ((y.b)localObject5).k("preChatName", "");
                  ((y.b)localObject5).k("url", localObject1);
                  ((y.b)localObject5).k("preMsgIndex", Integer.valueOf(0));
                  ((y.b)localObject5).k("sendAppMsgScene", Integer.valueOf(1));
                  ((y.b)localObject5).k("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject3).dYl().zRz);
                  paramMenuItem.dnG.sessionId = ((String)localObject4);
                }
                localObject4 = ag.dUe().aAa(this.Ayh);
                if ((localObject4 != null) && (this.Ayi.HAT.GaP == 18)) {
                  com.tencent.mm.plugin.sns.ad.d.m.a(m.d.zad, m.c.yZX, m.e.zai, 0, (com.tencent.mm.plugin.sns.storage.p)localObject4, this.dnh);
                }
                if (!bt.isNullOrNil(this.Ayi.zTv))
                {
                  aBe(((com.tencent.mm.plugin.sns.storage.p)localObject4).dYK());
                  AppMethodBeat.o(100195);
                  return;
                }
                if (((com.tencent.mm.plugin.sns.storage.p)localObject4).QM(32))
                {
                  i = this.dnh;
                  if (this.dnh != 0) {
                    break label2658;
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject3 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject3, this.Abd, (com.tencent.mm.plugin.sns.storage.p)localObject4, 11);
                  com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
                  com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, (String)localObject1, this.Ayh);
                  paramMenuItem.dnG.activity = this.activity;
                  paramMenuItem.dnG.dnM = 28;
                  com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
                  if (paramMenuItem.dnH.ret == 0)
                  {
                    l = bt.aQJ();
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
                  com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                  AppMethodBeat.o(100195);
                  return;
                }
                this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
              } while (this.Ayi == null);
              paramMenuItem = new cv();
              localObject5 = this.Ayi;
              if (localObject5 == null)
              {
                ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.dnG.dnL = 2131758885;
              }
              for (;;)
              {
                paramMenuItem.dnG.activity = this.activity;
                paramMenuItem.dnG.dnM = 26;
                com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
                AppMethodBeat.o(100195);
                return;
                localObject2 = new akd();
                localObject3 = new akj();
                localObject4 = new akc();
                ((akj)localObject3).aPf(((TimeLineObject)localObject5).nDo);
                ((akj)localObject3).aPg(u.aAm());
                ((akj)localObject3).ZR(2);
                ((akj)localObject3).CM(bt.flT());
                if (((TimeLineObject)localObject5).HAS != null) {
                  ((akj)localObject3).aPl(((TimeLineObject)localObject5).HAS.Id);
                }
                if (((TimeLineObject)localObject5).HAT != null)
                {
                  ((akc)localObject4).aOY(((TimeLineObject)localObject5).HAT.Title);
                  ((akc)localObject4).aOZ(((TimeLineObject)localObject5).HAT.Desc);
                  if ((((TimeLineObject)localObject5).HAT.GaQ != null) && (!((TimeLineObject)localObject5).HAT.GaQ.isEmpty()))
                  {
                    localObject5 = (byn)((TimeLineObject)localObject5).HAT.GaQ.get(0);
                    ((akc)localObject4).ZO(((byn)localObject5).subType);
                    ((akc)localObject4).aPb(((byn)localObject5).zQh);
                    ((akc)localObject4).aPa(((byn)localObject5).GSI);
                  }
                }
                paramMenuItem.dnG.title = ((akc)localObject4).title;
                paramMenuItem.dnG.desc = ((akc)localObject4).desc;
                paramMenuItem.dnG.dnI = ((akd)localObject2);
                paramMenuItem.dnG.type = 10;
                ((akd)localObject2).a((akj)localObject3);
                ((akd)localObject2).b((akc)localObject4);
              }
              paramMenuItem = this.Ayi.HAZ;
              if ((this.Ayi == null) || (paramMenuItem == null))
              {
                ad.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                AppMethodBeat.o(100195);
                return;
              }
              localObject5 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramMenuItem.username);
              localObject3 = new ajl();
              ((ajl)localObject3).username = paramMenuItem.username;
              if (localObject5 != null) {
                ((ajl)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
              }
              ((ajl)localObject3).dki = paramMenuItem.path;
              ((ajl)localObject3).dtF = paramMenuItem.DCU;
              ((ajl)localObject3).version = paramMenuItem.version;
              ((ajl)localObject3).dJW = paramMenuItem.dJW;
              ((ajl)localObject3).subType = paramMenuItem.subType;
              paramMenuItem = null;
              localObject4 = new ajn();
              ((ajn)localObject4).ZI(19);
              if (this.Ayi.HAT != null)
              {
                paramMenuItem = this.Ayi.HAT.Title;
                if ((this.Ayi.HAT.GaQ != null) && (!this.Ayi.HAT.GaQ.isEmpty()))
                {
                  localObject2 = (byn)this.Ayi.HAT.GaQ.get(0);
                  localObject2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject2).Id) + com.tencent.mm.plugin.sns.data.q.d((byn)localObject2);
                  ((ajn)localObject4).aOt((String)localObject2);
                  ((ajn)localObject4).aOu((String)localObject2);
                  localObject2 = paramMenuItem;
                  if (bt.isNullOrNil(paramMenuItem)) {
                    if ((localObject5 == null) || (bt.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                      break label3547;
                    }
                  }
                }
              }
              for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(2131755945))
              {
                ((ajn)localObject4).aOf((String)localObject2);
                ((ajn)localObject4).aOg((String)localObject2);
                ((ajn)localObject4).aOs(com.tencent.mm.plugin.fav.a.b.di(localObject4.toString(), 19));
                localObject5 = new akj();
                ((akj)localObject5).aPf(u.aAm());
                ((akj)localObject5).CM(bt.flT());
                ((akj)localObject5).ZR(2);
                paramMenuItem = new akd();
                paramMenuItem.nZa.add(localObject4);
                paramMenuItem.c((ajl)localObject3);
                paramMenuItem.a((akj)localObject5);
                paramMenuItem.aPd((String)localObject2);
                localObject3 = new cv();
                ((cv)localObject3).dnG.activity = this.activity;
                ((cv)localObject3).dnG.title = ((String)localObject2);
                ((cv)localObject3).dnG.desc = ((String)localObject2);
                ((cv)localObject3).dnG.dnI = paramMenuItem;
                ((cv)localObject3).dnG.type = 19;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
                AppMethodBeat.o(100195);
                return;
                ((ajn)localObject4).wl(true);
                break;
                ((ajn)localObject4).wl(true);
                break;
              }
              this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
            } while (this.Ayi == null);
            paramMenuItem = new cv();
            localObject5 = this.Ayi;
            if (localObject5 == null)
            {
              ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
              paramMenuItem.dnG.dnL = 2131758885;
            }
            for (;;)
            {
              paramMenuItem.dnG.activity = this.activity;
              paramMenuItem.dnG.dnM = 27;
              com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
              AppMethodBeat.o(100195);
              return;
              localObject2 = new akd();
              localObject3 = new akj();
              localObject4 = new akm();
              ((akj)localObject3).aPf(((TimeLineObject)localObject5).nDo);
              ((akj)localObject3).aPg(u.aAm());
              ((akj)localObject3).ZR(8);
              ((akj)localObject3).CM(bt.flT());
              if (((TimeLineObject)localObject5).HAS != null) {
                ((akj)localObject3).aPl(((TimeLineObject)localObject5).HAS.Id);
              }
              if (((TimeLineObject)localObject5).HAT != null)
              {
                ((akm)localObject4).aPo(((TimeLineObject)localObject5).HAT.Title);
                ((akm)localObject4).aPp(((TimeLineObject)localObject5).HAT.Desc);
                if ((((TimeLineObject)localObject5).HAT.GaQ != null) && (!((TimeLineObject)localObject5).HAT.GaQ.isEmpty()))
                {
                  localObject5 = (byn)((TimeLineObject)localObject5).HAT.GaQ.get(0);
                  ((akm)localObject4).aPr(((byn)localObject5).zQh);
                  ((akm)localObject4).aPq(((byn)localObject5).GSI);
                }
              }
              paramMenuItem.dnG.title = ((akm)localObject4).title;
              paramMenuItem.dnG.desc = ((akm)localObject4).desc;
              paramMenuItem.dnG.dnI = ((akd)localObject2);
              paramMenuItem.dnG.type = 15;
              ((akd)localObject2).a((akj)localObject3);
              ((akd)localObject2).b((akm)localObject4);
            }
            paramMenuItem = ag.dUe().aAa(this.Ayh);
            if (paramMenuItem == null)
            {
              ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
              AppMethodBeat.o(100195);
              return;
            }
            new f.a(this.activity).aXO(this.activity.getResources().getString(2131766981)).aXS(this.activity.getResources().getString(2131755707)).afq(this.activity.getResources().getColor(2131100800)).b(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                int i = 0;
                AppMethodBeat.i(198565);
                paramAnonymousString = paramMenuItem.getSnsId();
                Object localObject = (com.tencent.mm.plugin.sns.ui.m)b.this.Ayg.getTag();
                if (localObject != null)
                {
                  if (!x.aAv(paramAnonymousString)) {
                    break label184;
                  }
                  paramAnonymousString = new com.tencent.mm.plugin.sns.model.q(x.axN(paramAnonymousString), 6, ((com.tencent.mm.plugin.sns.ui.m)localObject).zhw);
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousString, 0);
                  b localb = b.this;
                  Activity localActivity = b.this.activity;
                  b.this.activity.getString(2131755906);
                  localb.zPt = com.tencent.mm.ui.base.h.b(localActivity, b.this.activity.getString(2131763798), true, new b.2.1(this, paramAnonymousString));
                  if (((com.tencent.mm.plugin.sns.ui.m)localObject).zhw == null) {
                    break label221;
                  }
                  i = ((com.tencent.mm.plugin.sns.ui.m)localObject).zhw.HtH;
                }
                label184:
                label221:
                for (paramAnonymousString = ((com.tencent.mm.plugin.sns.ui.m)localObject).zhw.Username;; paramAnonymousString = "")
                {
                  localObject = com.tencent.mm.plugin.sns.j.e.ztz;
                  com.tencent.mm.plugin.sns.j.e.b(paramMenuItem, i, paramAnonymousString, 1);
                  AppMethodBeat.o(198565);
                  return;
                  paramAnonymousString = new com.tencent.mm.plugin.sns.model.q(x.axN(paramAnonymousString), 4, ((com.tencent.mm.plugin.sns.ui.m)localObject).zhw);
                  com.tencent.mm.kernel.g.ajD();
                  com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousString, 0);
                  break;
                }
              }
            }).aXT(this.activity.getResources().getString(2131755691)).a(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(198563);
                paramAnonymousString = (com.tencent.mm.plugin.sns.ui.m)b.this.Ayg.getTag();
                int i = 0;
                if ((paramAnonymousString != null) && (paramAnonymousString.zhw != null)) {
                  i = paramAnonymousString.zhw.HtH;
                }
                for (paramAnonymousString = paramAnonymousString.zhw.Username;; paramAnonymousString = "")
                {
                  com.tencent.mm.plugin.sns.j.e locale = com.tencent.mm.plugin.sns.j.e.ztz;
                  com.tencent.mm.plugin.sns.j.e.b(paramMenuItem, i, paramAnonymousString, 2);
                  AppMethodBeat.o(198563);
                  return;
                }
              }
            }).show();
            AppMethodBeat.o(100195);
            return;
            paramMenuItem = ag.dUe().aAa(this.Ayh);
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
          this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
          paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
          if ((paramMenuItem != null) && (paramMenuItem.QM(32)) && (paramMenuItem.dRL().dVU()))
          {
            localObject2 = ag.dUe().aAa(this.Ayh);
            if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).QM(32)))
            {
              i = this.dnh;
              if (this.dnh != 0) {
                break label4292;
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.Abd, paramMenuItem, 11);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              aBe(this.Ayh);
              AppMethodBeat.o(100195);
              return;
            }
          }
          paramMenuItem = this.Ayh;
          paramMenuItem = ag.dUe().aAa(paramMenuItem);
          if (paramMenuItem != null) {
            if (paramMenuItem.QM(32))
            {
              com.tencent.mm.plugin.sns.ad.d.m.a(m.d.zac, m.c.yZX, m.e.zai, 0, paramMenuItem, this.dnh);
              i = this.dnh;
              if (this.dnh != 0) {
                break label4444;
              }
            }
          }
          for (paramInt = 1;; paramInt = 2)
          {
            localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.Abd, paramMenuItem, 11);
            com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
            localObject2 = new cv();
            com.tencent.mm.plugin.sns.k.a.a((cv)localObject2, paramMenuItem);
            ((cv)localObject2).dnG.activity = this.activity;
            ((cv)localObject2).dnG.dnM = 29;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            AppMethodBeat.o(100195);
            return;
          }
          paramMenuItem = (byn)this.Ayi.HAT.GaQ.get(0);
          paramMenuItem = ao.jo(ag.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.q.d(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.bs.d.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
          AppMethodBeat.o(100195);
          return;
        } while (!(this.Ayg.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
        paramMenuItem = (com.tencent.mm.plugin.sns.ui.m)this.Ayg.getTag();
        this.rBg.setText(paramMenuItem.hDa);
        com.tencent.mm.ui.base.h.cl(this.activity, this.activity.getString(2131755702));
        if (paramMenuItem.zhw != null)
        {
          localObject2 = com.tencent.mm.plugin.secinforeport.a.a.yBN;
          com.tencent.mm.plugin.secinforeport.a.a.o(4, this.Ayi.Id + ":" + paramMenuItem.zhw.HtH, bt.aQW(paramMenuItem.hDa));
        }
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = ag.dUe().aAa(this.Ayh);
        com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject2 = ag.dUe().aAa(this.Ayh);
        if (localObject2 != null) {
          if (this.dnh != 0) {
            break label4808;
          }
        }
        for (paramMenuItem = com.tencent.mm.modelsns.e.pV(714);; paramMenuItem = com.tencent.mm.modelsns.e.pW(714))
        {
          paramMenuItem.Gs(com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject2)).pY(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_type).eS(((com.tencent.mm.plugin.sns.storage.p)localObject2).QM(32)).Gs(((com.tencent.mm.plugin.sns.storage.p)localObject2).dYT());
          paramMenuItem.aLk();
          ar.x((com.tencent.mm.plugin.sns.storage.p)localObject2);
          AppMethodBeat.o(100195);
          return;
        }
      } while (!(this.Ayg.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.Ayg.getTag();
      localObject3 = ag.dUe().azZ(((com.tencent.mm.plugin.sns.ui.m)localObject2).zPS);
      if (localObject3 != null)
      {
        if (this.dnh != 0) {
          break label4985;
        }
        paramMenuItem = com.tencent.mm.modelsns.e.pV(715);
        paramMenuItem.Gs(com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject3)).pY(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_type).eS(((com.tencent.mm.plugin.sns.storage.p)localObject3).QM(32)).Gs(((com.tencent.mm.plugin.sns.storage.p)localObject3).dYT());
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).zhw == null) {
          break label5021;
        }
        if (((com.tencent.mm.plugin.sns.ui.m)localObject2).zhw.HtH != 0) {
          break label4995;
        }
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).zhw.HtJ;
        paramMenuItem.Gs((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.aLk();
        ar.a((com.tencent.mm.plugin.sns.ui.m)this.Ayg.getTag());
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = com.tencent.mm.modelsns.e.pW(715);
        break;
        localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).zhw.HtH;
        break label4953;
        paramMenuItem.Gs("");
      }
    case 20: 
      label3547:
      label4444:
      label4985:
      this.zPG.dTI().jv(this.Ayh, this.Ayi.Id);
      label4292:
      label4808:
      label4953:
      paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
      label4995:
      label5021:
      if ((paramMenuItem != null) && (paramMenuItem.QM(32)) && (paramMenuItem.dRL().dVU()))
      {
        localObject2 = ag.dUe().aAa(this.Ayh);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).QM(32)) && (this.Ayi != null))
        {
          i = this.dnh;
          if (this.dnh != 0) {
            break label5183;
          }
        }
        label5183:
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, this.Abd, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
          aBe(this.Ayh);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.Ayh;
      localObject3 = ag.dUe().aAa(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((com.tencent.mm.plugin.sns.storage.p)localObject3).QM(32))
        {
          localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dYS();
          paramMenuItem = (MenuItem)localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((com.tencent.mm.plugin.sns.storage.p)localObject3).dYR();
          }
        }
      }
      if (bt.isNullOrNil(paramMenuItem)) {
        paramMenuItem = bh.aAT(this.Ayi.HAT.Url);
      }
      break;
    }
    for (;;)
    {
      if (bt.isNullOrNil(paramMenuItem))
      {
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = new cv();
      localObject4 = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
      if (localObject4 != null)
      {
        localObject5 = y.AH(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId);
        localObject6 = y.aBq().F((String)localObject5, true);
        ((y.b)localObject6).k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        ((y.b)localObject6).k("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((y.b)localObject6).k("preChatName", "");
        ((y.b)localObject6).k("url", paramMenuItem);
        ((y.b)localObject6).k("preMsgIndex", Integer.valueOf(0));
        ((y.b)localObject6).k("sendAppMsgScene", Integer.valueOf(1));
        ((y.b)localObject6).k("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject4).dYl().zRz);
        ((cv)localObject2).dnG.sessionId = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.Ayi.HAT.GaP == 18) || (((com.tencent.mm.plugin.sns.storage.p)localObject3).QM(32))))
      {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.d.zad, m.c.yZX, m.e.zai, 0, (com.tencent.mm.plugin.sns.storage.p)localObject3, this.dnh);
        if (this.Ayi != null)
        {
          i = this.dnh;
          if (this.dnh != 0) {
            break label5608;
          }
        }
      }
      label5608:
      for (paramInt = 1;; paramInt = 2)
      {
        localObject4 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, this.Abd, (com.tencent.mm.plugin.sns.storage.p)localObject3, 11);
        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
        if (bt.isNullOrNil(this.Ayi.zTv)) {
          break;
        }
        aBe(((com.tencent.mm.plugin.sns.storage.p)localObject3).dYK());
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.plugin.sns.k.a.a((cv)localObject2, paramMenuItem, this.Ayh);
      ((cv)localObject2).dnG.activity = this.activity;
      ((cv)localObject2).dnG.dnM = 28;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((cv)localObject2).dnH.ret == 0)
      {
        l = bt.aQJ();
        if (!bt.isNullOrNil(paramMenuItem))
        {
          ad.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject2 = "";
        }
      }
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.g.yhR.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
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
      ar.y(ag.dUe().aAa(this.Ayh));
      AppMethodBeat.o(100195);
      return;
      if (!(this.Ayg.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) {
        break;
      }
      ar.b((com.tencent.mm.plugin.sns.ui.m)this.Ayg.getTag());
      AppMethodBeat.o(100195);
      return;
      localObject4 = com.tencent.mm.plugin.sns.storage.h.aAa(this.Ayh);
      if (localObject4 == null)
      {
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        AppMethodBeat.o(100195);
        return;
      }
      if ((this.Ayg.getTag() == null) || (!(this.Ayg.getTag() instanceof az)))
      {
        ad.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = (az)this.Ayg.getTag();
      localObject3 = this.activity;
      localObject5 = paramMenuItem.getIntent();
      if (this.dnh == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        i = this.dnh;
        paramMenuItem = this.zPG;
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
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
        AppMethodBeat.o(100195);
        return;
      }
      localObject6 = ((az)localObject2).drH;
      int j = ((az)localObject2).index;
      int k = ((az)localObject2).position;
      localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dYl();
      if ((((TimeLineObject)localObject2).HAT == null) || (((TimeLineObject)localObject2).HAT.GaQ.size() == 0))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem.dTI().F((com.tencent.mm.plugin.sns.storage.p)localObject4);
      localObject7 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).dYl();
      if (j < ((TimeLineObject)localObject7).HAT.GaQ.size()) {}
      for (paramMenuItem = (byn)((TimeLineObject)localObject7).HAT.GaQ.get(j); !ag.dUb().B(paramMenuItem); paramMenuItem = new byn())
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.dJd) });
        AppMethodBeat.o(100195);
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = com.tencent.mm.modelsns.e.pV(716);
        ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject4)).pY(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eS(((com.tencent.mm.plugin.sns.storage.p)localObject4).QM(32)).Gs(((com.tencent.mm.plugin.sns.storage.p)localObject4).dYT()).Gs(paramMenuItem.Id).pY(j).pY(((TimeLineObject)localObject7).HAT.GaQ.size());
        ((com.tencent.mm.modelsns.e)localObject2).aLk();
        if (paramInt != 1) {
          break label6653;
        }
      }
      label6653:
      for (paramMenuItem = com.tencent.mm.modelsns.e.pV(744);; paramMenuItem = com.tencent.mm.modelsns.e.pW(744))
      {
        paramMenuItem.Gs(com.tencent.mm.plugin.sns.data.q.n((com.tencent.mm.plugin.sns.storage.p)localObject4)).pY(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eS(((com.tencent.mm.plugin.sns.storage.p)localObject4).QM(32)).Gs(((com.tencent.mm.plugin.sns.storage.p)localObject4).dYT());
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
        paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        paramMenuItem.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject5);
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, paramMenuItem.ahp(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).startActivity((Intent)paramMenuItem.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).overridePendingTransition(0, 0);
        AppMethodBeat.o(100195);
        return;
        localObject2 = com.tencent.mm.modelsns.e.pW(716);
        break;
      }
      if (this.Ayi == null)
      {
        ad.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem = new cv();
      com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, this.Ayh);
      paramMenuItem.dnG.activity = this.activity;
      paramMenuItem.dnG.dnM = 28;
      com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
      AppMethodBeat.o(100195);
      return;
      if ((this.Ayi == null) || (this.Ayi.HAT == null)) {
        break;
      }
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).c(this.Ayi.HAT.GaW);
      com.tencent.mm.ui.base.h.cl(this.activity, this.activity.getString(2131758936));
      AppMethodBeat.o(100195);
      return;
      if ((this.Ayi == null) || (this.Ayi.HAT == null) || (this.Ayi.HAT.GaP != 28)) {
        break;
      }
      paramMenuItem = new cv();
      localObject2 = this.Ayi;
      if (localObject2 == null)
      {
        ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
        paramMenuItem.dnG.dnL = 2131758886;
      }
      for (;;)
      {
        paramMenuItem.dnG.activity = this.activity;
        com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
        break;
        localObject3 = String.format("%s", new Object[] { ((TimeLineObject)localObject2).Id });
        localObject4 = new akd();
        localObject5 = new akj();
        localObject6 = new ajn();
        ((akj)localObject5).aPf(((TimeLineObject)localObject2).nDo);
        ((akj)localObject5).aPg(u.aAm());
        ((akj)localObject5).ZR(2);
        ((akj)localObject5).CM(((TimeLineObject)localObject2).CreateTime * 1000L);
        ((akj)localObject5).aPk(((TimeLineObject)localObject2).Id);
        ((akj)localObject5).aPh((String)localObject3);
        ((ajn)localObject6).aOx((String)localObject3);
        com.tencent.mm.plugin.sns.k.a.a((ajn)localObject6, (TimeLineObject)localObject2);
        ((ajn)localObject6).ZI(20);
        ((akd)localObject4).nZa.add(localObject6);
        ((akd)localObject4).a((akj)localObject5);
        ((akd)localObject4).d(((TimeLineObject)localObject2).HAT.GaU);
        paramMenuItem.dnG.dnI = ((akd)localObject4);
        paramMenuItem.dnG.type = 20;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(100198);
    ad.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.zPt != null) && (this.zPt.isShowing())) {
      this.zPt.dismiss();
    }
    long l2;
    long l1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.sns.model.q)) && ((((com.tencent.mm.plugin.sns.model.q)paramn).type == 4) || (((com.tencent.mm.plugin.sns.model.q)paramn).type == 6)))
    {
      t.w(this.activity, this.activity.getResources().getString(2131766984), 2131690391);
      paramString = (com.tencent.mm.plugin.sns.model.q)paramn;
      if (paramString.zhw != null) {
        break label217;
      }
      paramString = "";
      if (!bt.lQ(paramString, u.aAm()))
      {
        paramInt1 = 9;
        if (((com.tencent.mm.plugin.sns.model.q)paramn).type == 6) {
          paramInt1 = 10;
        }
        l2 = ((com.tencent.mm.plugin.sns.model.q)paramn).zhv;
        paramString = ag.dUj();
        paramn = (com.tencent.mm.plugin.sns.model.q)paramn;
        if (paramn.zhw != null) {
          break label228;
        }
        l1 = 0L;
      }
    }
    for (;;)
    {
      paramString = paramString.h(l2, l1, paramInt1);
      if (paramString != null)
      {
        paramString.dYt();
        ag.dUj().update(paramString.systemRowid, paramString);
      }
      AppMethodBeat.o(100198);
      return;
      label217:
      paramString = paramString.zhw.Username;
      break;
      label228:
      if (paramn.type == 6) {
        l1 = paramn.zhw.HtJ;
      } else {
        l1 = paramn.zhw.HtH;
      }
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */