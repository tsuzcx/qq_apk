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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vo.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.ad.e.n.c;
import com.tencent.mm.plugin.sns.ad.e.n.d;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
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
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.akw;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
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
  implements f, com.tencent.mm.ui.base.n.e
{
  private String APA;
  private TimeLineObject APB;
  View APz;
  com.tencent.mm.ui.base.p AgA;
  private ag AgN;
  protected com.tencent.mm.plugin.sns.ad.e.j Asq;
  Activity activity;
  private int doj;
  private ClipboardManager rJr;
  
  public b(Activity paramActivity, int paramInt, ag paramag)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.doj = paramInt;
    this.rJr = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
    this.AgN = paramag;
    AppMethodBeat.o(100192);
  }
  
  private void aCv(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = ah.dXE().aBr(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.storage.p)localObject2).ebP();
    if (((com.tencent.mm.plugin.sns.storage.p)localObject2).Rt(32))
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.p)localObject2).ecy();
      str1 = i.J((com.tencent.mm.plugin.sns.storage.p)localObject2);
      if (!bu.isNullOrNil(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localTimeLineObject.AkC)
    {
      localObject3 = bx.M((String)localObject1, "adxml");
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
    String str1 = z.Br(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_snsId);
    String str2 = bu.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bu.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bu.bI((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cw();
    vo localvo = new vo();
    localvo.dKN.dKQ = paramString;
    localvo.dKN.dKR = ((cw)localObject2);
    localvo.dKN.url = str3;
    com.tencent.mm.sdk.b.a.IvT.l(localvo);
    if (!localvo.dKO.doq)
    {
      if (((cw)localObject2).doL.doQ == 0) {
        ((cw)localObject2).doL.doQ = 2131758893;
      }
      com.tencent.mm.ui.base.h.l(this.activity, ((cw)localObject2).doL.doQ, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((cw)localObject2).doL.sessionId = str1;
    ((cw)localObject2).doL.title = str2;
    ((cw)localObject2).doL.desc = ((String)localObject3);
    paramString = ((cw)localObject2).doL.doN;
    if ((paramString != null) && (paramString.oeJ != null) && (paramString.oeJ.size() > 0) && (paramString.oeJ.get(0) != null))
    {
      ((ajx)paramString.oeJ.get(0)).aQb((String)localObject1);
      if (bu.isNullOrNil(((ajx)paramString.oeJ.get(0)).title)) {
        ((ajx)paramString.oeJ.get(0)).aPC(((cw)localObject2).doL.title);
      }
      if (bu.isNullOrNil(((ajx)paramString.oeJ.get(0)).desc)) {
        ((ajx)paramString.oeJ.get(0)).aPD(((cw)localObject2).doL.desc);
      }
      localObject1 = new akt();
      ((akt)localObject1).aQC(localTimeLineObject.nIJ);
      ((akt)localObject1).aQD(v.aAC());
      ((akt)localObject1).aax(2);
      ((akt)localObject1).Dk(bu.fpO());
      paramString.a((akt)localObject1);
    }
    ((cw)localObject2).doL.activity = this.activity;
    ((cw)localObject2).doL.doR = 28;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private String ehS()
  {
    AppMethodBeat.i(100193);
    if ((this.APz != null) && ((this.APz instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.APz != null) && ((this.APz.getTag() instanceof bd)) && (((bd)this.APz.getTag()).ega()))
    {
      Object localObject = as.aAt(ah.dXE().aBr(this.APA).getSnsId());
      if (localObject != null)
      {
        localObject = ((as.b)localObject).result;
        AppMethodBeat.o(100193);
        return localObject;
      }
    }
    AppMethodBeat.o(100193);
    return null;
  }
  
  private com.tencent.mm.plugin.sns.storage.a g(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(100194);
    if (paramp != null)
    {
      if (this.doj == 2)
      {
        paramp = paramp.ebM();
        AppMethodBeat.o(100194);
        return paramp;
      }
      paramp = paramp.dVi();
      AppMethodBeat.o(100194);
      return paramp;
    }
    AppMethodBeat.o(100194);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.APz = paramView;
    this.APA = paramString;
    this.APB = paramTimeLineObject;
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.e.j paramj)
  {
    this.Asq = paramj;
  }
  
  public final void dhH()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        com.tencent.mm.plugin.sns.storage.p localp = ah.dXE().aBr(this.APA);
        Object localObject1 = (bzh)this.APB.HUG.Gtx.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.d((bzh)localObject1);
        paramIntent = bu.U(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localp.Rt(32))
          {
            str3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.i((bzh)localObject1);
            TimeLineObject localTimeLineObject = localp.ebP();
            com.tencent.mm.plugin.sns.storage.b localb = localp.dVj();
            dld localdld = new dld();
            localdld.GBN = ((bzh)localObject1).AIa;
            localdld.hET = ((bzh)localObject1).Hmq;
            if (localTimeLineObject.HUG.Gtw == 15)
            {
              localdld.hEZ = g(localp).dGD;
              localdld.hFa = localTimeLineObject.Id;
              localdld.hEV = localTimeLineObject.HUD;
              if (!bu.isNullOrNil(((bzh)localObject1).Hmt)) {
                break label551;
              }
              paramIntent = ((bzh)localObject1).Hmj;
              label288:
              localdld.hEY = paramIntent;
              if ((localb != null) && (localb.zMZ == 0))
              {
                localdld.hEX = localb.zNb;
                localdld.hEW = localb.zNa;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.r.azA(str3);
              ae.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bzh)localObject1).Hmq, Integer.valueOf(((bzh)localObject1).AIa), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.g.doC().a(this.activity, str1, str3, str2, 43, paramInt1, localdld, localTimeLineObject.AiG, null);
              com.tencent.mm.plugin.messenger.a.g.doC().hW((String)localObject2, str1);
              paramInt2 = this.doj;
              if (this.doj != 0) {
                break label560;
              }
              paramInt1 = 1;
              label443:
              com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(paramInt2, paramInt1, localp.field_snsId, 12, 0));
              boolean bool = com.tencent.mm.model.x.wb(str1);
              localObject1 = n.d.zqD;
              if (!bool) {
                break label565;
              }
              paramIntent = n.c.zqA;
              label484:
              localObject2 = com.tencent.mm.plugin.sns.ad.e.n.e.zqJ;
              if (!bool) {
                break label572;
              }
            }
            label551:
            label560:
            label565:
            label572:
            for (paramInt1 = com.tencent.mm.model.r.zC(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.ad.e.n.a((n.d)localObject1, paramIntent, (com.tencent.mm.plugin.sns.ad.e.n.e)localObject2, paramInt1, localp, this.doj);
              AppMethodBeat.o(100197);
              return;
              localdld.hEZ = localTimeLineObject.HUL.hEZ;
              localdld.hFa = localTimeLineObject.HUL.hFa;
              break;
              paramIntent = ((bzh)localObject1).Hmt;
              break label288;
              paramInt1 = 2;
              break label443;
              paramIntent = n.c.zqz;
              break label484;
            }
          }
          String str3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.i((bzh)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.r.azA(str3);
          ae.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bzh)localObject1).Hmq, Integer.valueOf(((bzh)localObject1).AIa), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.doC().a(this.activity, str1, str3, str2, 43, paramInt1, this.APB.AiG, null);
          com.tencent.mm.plugin.messenger.a.g.doC().hW((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this.activity, this.activity.getString(2131760233));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = ah.dXE().aBr(this.APA);
      if (paramIntent == null)
      {
        ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.APA });
        AppMethodBeat.o(100197);
        return;
      }
      paramInt2 = this.doj;
      if (this.doj != 0) {
        break label828;
      }
    }
    label828:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(100197);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.APz == null)
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
                Object localObject1 = ehS();
                paramMenuItem = (MenuItem)localObject1;
                if (bu.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.APB.HUD;
                }
                this.rJr.setText(paramMenuItem);
                com.tencent.mm.ui.base.h.cm(this.activity, this.activity.getString(2131755702));
                localObject1 = com.tencent.mm.plugin.secinforeport.a.a.yRN;
                com.tencent.mm.plugin.secinforeport.a.a.o(2, this.APB.Id, bu.aSt(paramMenuItem));
                AppMethodBeat.o(100195);
                return;
                localObject1 = ehS();
                paramMenuItem = (MenuItem)localObject1;
                if (bu.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.APB.HUD;
                }
                this.AgN.dXi().jC(this.APA, this.APB.Id);
                localObject1 = new cw();
                com.tencent.mm.plugin.sns.k.a.a((cw)localObject1, this.APA, paramMenuItem);
                ((cw)localObject1).doL.activity = this.activity;
                ((cw)localObject1).doL.doR = 30;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(100195);
                return;
                this.AgN.dXi().jC(this.APA, this.APB.Id);
                localObject1 = new cw();
                paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
                if ((paramMenuItem.Rt(32)) && (paramMenuItem.dVj().dZv()))
                {
                  aCv(this.APA);
                  if (paramMenuItem.Rt(32))
                  {
                    i = this.doj;
                    if (this.doj != 0) {
                      break label597;
                    }
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, this.Asq, paramMenuItem, 11);
                  com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                  if (this.APB.eQZ == 1)
                  {
                    com.tencent.mm.plugin.sns.k.a.a((cw)localObject1, this.APA, 0);
                    ((cw)localObject1).doL.activity = this.activity;
                    ((cw)localObject1).doL.doR = 31;
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
                    break;
                  }
                  if (!(this.APz.getTag() instanceof az)) {
                    break;
                  }
                  localObject3 = (az)this.APz.getTag();
                  com.tencent.mm.plugin.sns.k.a.a((cw)localObject1, this.APA, ((az)localObject3).index);
                  ((cw)localObject1).doL.activity = this.activity;
                  ((cw)localObject1).doL.doR = 31;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
                  break;
                }
                this.AgN.dXi().jC(this.APA, this.APB.Id);
                paramMenuItem = ah.dXE().aBr(this.APA);
                if (this.APB.HUG.Gtx.size() != 0)
                {
                  localObject1 = (bzh)this.APB.HUG.Gtx.get(0);
                  if ((paramMenuItem == null) || (localObject1 == null))
                  {
                    ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject3 = new cw();
                  if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.AdJ != 0)) {
                    break label779;
                  }
                  ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                }
                for (((cw)localObject3).doL.doQ = 2131758885;; ((cw)localObject3).doL.doQ = 2131758903)
                {
                  ((cw)localObject3).doL.activity = this.activity;
                  ((cw)localObject3).doL.doR = 25;
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                  AppMethodBeat.o(100195);
                  return;
                  if (!ah.dXn()) {
                    break;
                  }
                  ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                }
                localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.r.zV(paramMenuItem.field_snsId), ((bzh)localObject1).Id });
                localObject4 = new akn();
                localObject5 = new akt();
                ae.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
                ((akt)localObject5).aQC(paramMenuItem.field_userName);
                ((akt)localObject5).aQD(v.aAC());
                ((akt)localObject5).aax(2);
                ((akt)localObject5).Dk(paramMenuItem.field_createTime * 1000L);
                ((akt)localObject5).aQH(paramMenuItem.getSnsId());
                ((akt)localObject5).aQE((String)localObject7);
                localObject6 = new ajx();
                ((ajx)localObject6).aPU((String)localObject7);
                ((ajx)localObject6).aPJ(((bzh)localObject1).Url);
                ((ajx)localObject6).aPK(((bzh)localObject1).Hmn);
                ((ajx)localObject6).aPI(paramMenuItem.ebP().HUG.Url);
                localObject7 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id) + com.tencent.mm.plugin.sns.data.r.d((bzh)localObject1);
                if (com.tencent.mm.vfs.o.fB((String)localObject7)) {
                  ((ajx)localObject6).aPR((String)localObject7);
                }
                for (;;)
                {
                  ((ajx)localObject6).aQi(((bzh)localObject1).songAlbumUrl);
                  ((ajx)localObject6).aQj(((bzh)localObject1).songLyric);
                  ((ajx)localObject6).aao(7);
                  ((ajx)localObject6).aPC(((bzh)localObject1).Title);
                  ((ajx)localObject6).aPD(((bzh)localObject1).Desc);
                  ((ajx)localObject6).ws(true);
                  ((akn)localObject4).oeJ.add(localObject6);
                  ((akn)localObject4).a((akt)localObject5);
                  ((cw)localObject3).doL.doN = ((akn)localObject4);
                  ((cw)localObject3).doL.type = 7;
                  com.tencent.mm.plugin.sns.k.a.a((ajx)localObject6, paramMenuItem);
                  break;
                  ((ajx)localObject6).wt(true);
                  ((ajx)localObject6).aPL(((bzh)localObject1).Hmj);
                  localObject7 = new alc();
                  ((alc)localObject7).aQS(((bzh)localObject1).Hmj);
                  ((akn)localObject4).b((alc)localObject7);
                }
                paramMenuItem = this.activity;
                localObject3 = ah.dXE().aBr(this.APA);
                if (localObject3 != null)
                {
                  localObject1 = new Intent();
                  if (((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().HUG.Gtw != 1) {
                    break label1425;
                  }
                  paramInt = 0;
                  if ((this.APz.getTag() instanceof aq)) {
                    paramInt = ((az)this.APz.getTag()).index;
                  }
                  localObject3 = al.b((com.tencent.mm.plugin.sns.storage.p)localObject3, paramInt);
                  if (localObject3 == null)
                  {
                    ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject4 = ((bzh)localObject3).Id;
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.g(ap.jv(ah.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.r.k((bzh)localObject3), paramMenuItem));
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                }
                while (((((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().HUG.Gtw != 4) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().HUG.Gtw != 15) && (((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().HUG.Gtw != 3)) || ((bzh)((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().HUG.Gtx.get(0) != null))
                {
                  ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                  ((Intent)localObject1).putExtra("sns_local_id", this.APA);
                  ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                  com.tencent.mm.br.d.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                }
                ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                AppMethodBeat.o(100195);
                return;
                localObject1 = this.activity;
                paramMenuItem = ah.dXE().aBr(this.APA);
                if (paramMenuItem == null)
                {
                  ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                  AppMethodBeat.o(100195);
                  return;
                }
                if (paramMenuItem.Rt(32))
                {
                  ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                  AppMethodBeat.o(100195);
                  return;
                }
                if ((paramMenuItem.ebP() == null) || (paramMenuItem.ebP().HUG == null) || (bu.ht(paramMenuItem.ebP().HUG.Gtx)))
                {
                  ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject3 = (bzh)paramMenuItem.ebP().HUG.Gtx.get(0);
                if (localObject3 == null)
                {
                  ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject4 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject3).Id);
                paramMenuItem = "";
                localObject5 = com.tencent.mm.plugin.sns.data.r.i((bzh)localObject3);
                if (com.tencent.mm.vfs.o.fB((String)localObject4 + (String)localObject5)) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.r.d((bzh)localObject3);
                }
                if (com.tencent.mm.vfs.o.fB((String)localObject4 + com.tencent.mm.plugin.sns.data.r.o((bzh)localObject3))) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.r.m((bzh)localObject3);
                }
                localObject3 = new Intent();
                ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                ((Intent)localObject3).putExtra("intent_localid", this.APA);
                ((Intent)localObject3).putExtra("intent_from_scene", this.doj);
                ((Intent)localObject3).putExtra("intent_ismute", true);
                if ((localObject1 instanceof SnsTimeLineUI)) {
                  ((Intent)localObject3).putExtra("sns_video_scene", 1);
                }
                for (;;)
                {
                  if (this.APz != null)
                  {
                    paramMenuItem = new int[2];
                    this.APz.getLocationInWindow(paramMenuItem);
                    paramInt = this.APz.getWidth();
                    i = this.APz.getHeight();
                    ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                    ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                    ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                    ((Intent)localObject3).putExtra("img_gallery_height", i);
                  }
                  paramMenuItem = this.activity;
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
                  com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
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
                this.AgN.dXi().jC(this.APA, this.APB.Id);
                localObject1 = bh.aCk(this.APB.HUG.Url);
                if (bu.isNullOrNil((String)localObject1))
                {
                  ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                  AppMethodBeat.o(100195);
                  return;
                }
                paramMenuItem = new cw();
                localObject3 = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
                if (localObject3 != null)
                {
                  localObject4 = z.Br(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId);
                  localObject5 = z.aBG().F((String)localObject4, true);
                  ((z.b)localObject5).k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId));
                  ((z.b)localObject5).k("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_userName);
                  ((z.b)localObject5).k("preChatName", "");
                  ((z.b)localObject5).k("url", localObject1);
                  ((z.b)localObject5).k("preMsgIndex", Integer.valueOf(0));
                  ((z.b)localObject5).k("sendAppMsgScene", Integer.valueOf(1));
                  ((z.b)localObject5).k("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject3).ebP().AiG);
                  paramMenuItem.doL.sessionId = ((String)localObject4);
                }
                localObject4 = ah.dXE().aBr(this.APA);
                if ((localObject4 != null) && (this.APB.HUG.Gtw == 18)) {
                  com.tencent.mm.plugin.sns.ad.e.n.a(n.d.zqE, n.c.zqy, com.tencent.mm.plugin.sns.ad.e.n.e.zqJ, 0, (com.tencent.mm.plugin.sns.storage.p)localObject4, this.doj);
                }
                if (!bu.isNullOrNil(this.APB.AkC))
                {
                  aCv(((com.tencent.mm.plugin.sns.storage.p)localObject4).eco());
                  AppMethodBeat.o(100195);
                  return;
                }
                if (((com.tencent.mm.plugin.sns.storage.p)localObject4).Rt(32))
                {
                  i = this.doj;
                  if (this.doj != 0) {
                    break label2658;
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject3 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject3).field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject3, this.Asq, (com.tencent.mm.plugin.sns.storage.p)localObject4, 11);
                  com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject3);
                  com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, (String)localObject1, this.APA);
                  paramMenuItem.doL.activity = this.activity;
                  paramMenuItem.doL.doR = 28;
                  com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
                  if (paramMenuItem.doM.ret == 0)
                  {
                    l = bu.aRi();
                    if (!bu.isNullOrNil((String)localObject1))
                    {
                      ae.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
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
                      ae.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
                    }
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                  AppMethodBeat.o(100195);
                  return;
                }
                this.AgN.dXi().jC(this.APA, this.APB.Id);
              } while (this.APB == null);
              paramMenuItem = new cw();
              localObject5 = this.APB;
              if (localObject5 == null)
              {
                ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.doL.doQ = 2131758885;
              }
              for (;;)
              {
                paramMenuItem.doL.activity = this.activity;
                paramMenuItem.doL.doR = 26;
                com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
                AppMethodBeat.o(100195);
                return;
                localObject2 = new akn();
                localObject3 = new akt();
                localObject4 = new akm();
                ((akt)localObject3).aQC(((TimeLineObject)localObject5).nIJ);
                ((akt)localObject3).aQD(v.aAC());
                ((akt)localObject3).aax(2);
                ((akt)localObject3).Dk(bu.fpO());
                if (((TimeLineObject)localObject5).HUF != null) {
                  ((akt)localObject3).aQI(((TimeLineObject)localObject5).HUF.Id);
                }
                if (((TimeLineObject)localObject5).HUG != null)
                {
                  ((akm)localObject4).aQv(((TimeLineObject)localObject5).HUG.Title);
                  ((akm)localObject4).aQw(((TimeLineObject)localObject5).HUG.Desc);
                  if ((((TimeLineObject)localObject5).HUG.Gtx != null) && (!((TimeLineObject)localObject5).HUG.Gtx.isEmpty()))
                  {
                    localObject5 = (bzh)((TimeLineObject)localObject5).HUG.Gtx.get(0);
                    ((akm)localObject4).aau(((bzh)localObject5).subType);
                    ((akm)localObject4).aQy(((bzh)localObject5).Aho);
                    ((akm)localObject4).aQx(((bzh)localObject5).Hmj);
                  }
                }
                paramMenuItem.doL.title = ((akm)localObject4).title;
                paramMenuItem.doL.desc = ((akm)localObject4).desc;
                paramMenuItem.doL.doN = ((akn)localObject2);
                paramMenuItem.doL.type = 10;
                ((akn)localObject2).a((akt)localObject3);
                ((akn)localObject2).b((akm)localObject4);
              }
              paramMenuItem = this.APB.HUM;
              if ((this.APB == null) || (paramMenuItem == null))
              {
                ae.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                AppMethodBeat.o(100195);
                return;
              }
              localObject5 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob(paramMenuItem.username);
              localObject3 = new ajv();
              ((ajv)localObject3).username = paramMenuItem.username;
              if (localObject5 != null) {
                ((ajv)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
              }
              ((ajv)localObject3).dlk = paramMenuItem.path;
              ((ajv)localObject3).duK = paramMenuItem.DUS;
              ((ajv)localObject3).version = paramMenuItem.version;
              ((ajv)localObject3).dLl = paramMenuItem.dLl;
              ((ajv)localObject3).subType = paramMenuItem.subType;
              paramMenuItem = null;
              localObject4 = new ajx();
              ((ajx)localObject4).aao(19);
              if (this.APB.HUG != null)
              {
                paramMenuItem = this.APB.HUG.Title;
                if ((this.APB.HUG.Gtx != null) && (!this.APB.HUG.Gtx.isEmpty()))
                {
                  localObject2 = (bzh)this.APB.HUG.Gtx.get(0);
                  localObject2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject2).Id) + com.tencent.mm.plugin.sns.data.r.d((bzh)localObject2);
                  ((ajx)localObject4).aPQ((String)localObject2);
                  ((ajx)localObject4).aPR((String)localObject2);
                  localObject2 = paramMenuItem;
                  if (bu.isNullOrNil(paramMenuItem)) {
                    if ((localObject5 == null) || (bu.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                      break label3547;
                    }
                  }
                }
              }
              for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(2131755945))
              {
                ((ajx)localObject4).aPC((String)localObject2);
                ((ajx)localObject4).aPD((String)localObject2);
                ((ajx)localObject4).aPP(com.tencent.mm.plugin.fav.a.b.dm(localObject4.toString(), 19));
                localObject5 = new akt();
                ((akt)localObject5).aQC(v.aAC());
                ((akt)localObject5).Dk(bu.fpO());
                ((akt)localObject5).aax(2);
                paramMenuItem = new akn();
                paramMenuItem.oeJ.add(localObject4);
                paramMenuItem.c((ajv)localObject3);
                paramMenuItem.a((akt)localObject5);
                paramMenuItem.aQA((String)localObject2);
                localObject3 = new cw();
                ((cw)localObject3).doL.activity = this.activity;
                ((cw)localObject3).doL.title = ((String)localObject2);
                ((cw)localObject3).doL.desc = ((String)localObject2);
                ((cw)localObject3).doL.doN = paramMenuItem;
                ((cw)localObject3).doL.type = 19;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
                AppMethodBeat.o(100195);
                return;
                ((ajx)localObject4).wt(true);
                break;
                ((ajx)localObject4).wt(true);
                break;
              }
              this.AgN.dXi().jC(this.APA, this.APB.Id);
            } while (this.APB == null);
            paramMenuItem = new cw();
            localObject5 = this.APB;
            if (localObject5 == null)
            {
              ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
              paramMenuItem.doL.doQ = 2131758885;
            }
            for (;;)
            {
              paramMenuItem.doL.activity = this.activity;
              paramMenuItem.doL.doR = 27;
              com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
              AppMethodBeat.o(100195);
              return;
              localObject2 = new akn();
              localObject3 = new akt();
              localObject4 = new akw();
              ((akt)localObject3).aQC(((TimeLineObject)localObject5).nIJ);
              ((akt)localObject3).aQD(v.aAC());
              ((akt)localObject3).aax(8);
              ((akt)localObject3).Dk(bu.fpO());
              if (((TimeLineObject)localObject5).HUF != null) {
                ((akt)localObject3).aQI(((TimeLineObject)localObject5).HUF.Id);
              }
              if (((TimeLineObject)localObject5).HUG != null)
              {
                ((akw)localObject4).aQL(((TimeLineObject)localObject5).HUG.Title);
                ((akw)localObject4).aQM(((TimeLineObject)localObject5).HUG.Desc);
                if ((((TimeLineObject)localObject5).HUG.Gtx != null) && (!((TimeLineObject)localObject5).HUG.Gtx.isEmpty()))
                {
                  localObject5 = (bzh)((TimeLineObject)localObject5).HUG.Gtx.get(0);
                  ((akw)localObject4).aQO(((bzh)localObject5).Aho);
                  ((akw)localObject4).aQN(((bzh)localObject5).Hmj);
                }
              }
              paramMenuItem.doL.title = ((akw)localObject4).title;
              paramMenuItem.doL.desc = ((akw)localObject4).desc;
              paramMenuItem.doL.doN = ((akn)localObject2);
              paramMenuItem.doL.type = 15;
              ((akn)localObject2).a((akt)localObject3);
              ((akn)localObject2).b((akw)localObject4);
            }
            paramMenuItem = ah.dXE().aBr(this.APA);
            if (paramMenuItem == null)
            {
              ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
              AppMethodBeat.o(100195);
              return;
            }
            new f.a(this.activity).aZq(this.activity.getResources().getString(2131766981)).aZu(this.activity.getResources().getString(2131755707)).afZ(this.activity.getResources().getColor(2131100800)).b(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                int i = 0;
                AppMethodBeat.i(220110);
                paramAnonymousString = paramMenuItem.getSnsId();
                Object localObject = (m)b.this.APz.getTag();
                if (localObject != null)
                {
                  if (!com.tencent.mm.plugin.sns.storage.x.aBM(paramAnonymousString)) {
                    break label184;
                  }
                  paramAnonymousString = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.x.aze(paramAnonymousString), 6, ((m)localObject).zyl);
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousString, 0);
                  b localb = b.this;
                  Activity localActivity = b.this.activity;
                  b.this.activity.getString(2131755906);
                  localb.AgA = com.tencent.mm.ui.base.h.b(localActivity, b.this.activity.getString(2131763798), true, new b.2.1(this, paramAnonymousString));
                  if (((m)localObject).zyl == null) {
                    break label221;
                  }
                  i = ((m)localObject).zyl.HNk;
                }
                label184:
                label221:
                for (paramAnonymousString = ((m)localObject).zyl.Username;; paramAnonymousString = "")
                {
                  localObject = com.tencent.mm.plugin.sns.j.e.zKO;
                  com.tencent.mm.plugin.sns.j.e.b(paramMenuItem, i, paramAnonymousString, 1);
                  AppMethodBeat.o(220110);
                  return;
                  paramAnonymousString = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.x.aze(paramAnonymousString), 4, ((m)localObject).zyl);
                  com.tencent.mm.kernel.g.ajS();
                  com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousString, 0);
                  break;
                }
              }
            }).aZv(this.activity.getResources().getString(2131755691)).a(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(220108);
                paramAnonymousString = (m)b.this.APz.getTag();
                int i = 0;
                if ((paramAnonymousString != null) && (paramAnonymousString.zyl != null)) {
                  i = paramAnonymousString.zyl.HNk;
                }
                for (paramAnonymousString = paramAnonymousString.zyl.Username;; paramAnonymousString = "")
                {
                  com.tencent.mm.plugin.sns.j.e locale = com.tencent.mm.plugin.sns.j.e.zKO;
                  com.tencent.mm.plugin.sns.j.e.b(paramMenuItem, i, paramAnonymousString, 2);
                  AppMethodBeat.o(220108);
                  return;
                }
              }
            }).show();
            AppMethodBeat.o(100195);
            return;
            paramMenuItem = ah.dXE().aBr(this.APA);
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
          this.AgN.dXi().jC(this.APA, this.APB.Id);
          paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
          if ((paramMenuItem != null) && (paramMenuItem.Rt(32)) && (paramMenuItem.dVj().dZv()))
          {
            localObject2 = ah.dXE().aBr(this.APA);
            if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Rt(32)))
            {
              i = this.doj;
              if (this.doj != 0) {
                break label4292;
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.Asq, paramMenuItem, 11);
              com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject2);
              aCv(this.APA);
              AppMethodBeat.o(100195);
              return;
            }
          }
          paramMenuItem = this.APA;
          paramMenuItem = ah.dXE().aBr(paramMenuItem);
          if (paramMenuItem != null) {
            if (paramMenuItem.Rt(32))
            {
              com.tencent.mm.plugin.sns.ad.e.n.a(n.d.zqD, n.c.zqy, com.tencent.mm.plugin.sns.ad.e.n.e.zqJ, 0, paramMenuItem, this.doj);
              i = this.doj;
              if (this.doj != 0) {
                break label4444;
              }
            }
          }
          for (paramInt = 1;; paramInt = 2)
          {
            localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.Asq, paramMenuItem, 11);
            com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject2);
            localObject2 = new cw();
            com.tencent.mm.plugin.sns.k.a.a((cw)localObject2, paramMenuItem);
            ((cw)localObject2).doL.activity = this.activity;
            ((cw)localObject2).doL.doR = 29;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            AppMethodBeat.o(100195);
            return;
          }
          paramMenuItem = (bzh)this.APB.HUG.Gtx.get(0);
          paramMenuItem = ap.jv(ah.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.r.d(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.br.d.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
          AppMethodBeat.o(100195);
          return;
        } while (!(this.APz.getTag() instanceof m));
        paramMenuItem = (m)this.APz.getTag();
        this.rJr.setText(paramMenuItem.hFS);
        com.tencent.mm.ui.base.h.cm(this.activity, this.activity.getString(2131755702));
        if (paramMenuItem.zyl != null)
        {
          localObject2 = com.tencent.mm.plugin.secinforeport.a.a.yRN;
          com.tencent.mm.plugin.secinforeport.a.a.o(4, this.APB.Id + ":" + paramMenuItem.zyl.HNk, bu.aSt(paramMenuItem.hFS));
        }
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = ah.dXE().aBr(this.APA);
        com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject2 = ah.dXE().aBr(this.APA);
        if (localObject2 != null) {
          if (this.doj != 0) {
            break label4808;
          }
        }
        for (paramMenuItem = com.tencent.mm.modelsns.e.pY(714);; paramMenuItem = com.tencent.mm.modelsns.e.pZ(714))
        {
          paramMenuItem.GU(com.tencent.mm.plugin.sns.data.r.o((com.tencent.mm.plugin.sns.storage.p)localObject2)).qb(((com.tencent.mm.plugin.sns.storage.p)localObject2).field_type).eV(((com.tencent.mm.plugin.sns.storage.p)localObject2).Rt(32)).GU(((com.tencent.mm.plugin.sns.storage.p)localObject2).ecx());
          paramMenuItem.aLH();
          as.x((com.tencent.mm.plugin.sns.storage.p)localObject2);
          AppMethodBeat.o(100195);
          return;
        }
      } while (!(this.APz.getTag() instanceof m));
      localObject2 = (m)this.APz.getTag();
      localObject3 = ah.dXE().aBq(((m)localObject2).AgZ);
      if (localObject3 != null)
      {
        if (this.doj != 0) {
          break label4985;
        }
        paramMenuItem = com.tencent.mm.modelsns.e.pY(715);
        paramMenuItem.GU(com.tencent.mm.plugin.sns.data.r.o((com.tencent.mm.plugin.sns.storage.p)localObject3)).qb(((com.tencent.mm.plugin.sns.storage.p)localObject3).field_type).eV(((com.tencent.mm.plugin.sns.storage.p)localObject3).Rt(32)).GU(((com.tencent.mm.plugin.sns.storage.p)localObject3).ecx());
        if (((m)localObject2).zyl == null) {
          break label5021;
        }
        if (((m)localObject2).zyl.HNk != 0) {
          break label4995;
        }
        localObject2 = ((m)localObject2).zyl.HNm;
        paramMenuItem.GU((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.aLH();
        as.a((m)this.APz.getTag());
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = com.tencent.mm.modelsns.e.pZ(715);
        break;
        localObject2 = ((m)localObject2).zyl.HNk;
        break label4953;
        paramMenuItem.GU("");
      }
    case 20: 
      label3547:
      label4444:
      label4985:
      this.AgN.dXi().jC(this.APA, this.APB.Id);
      label4292:
      label4808:
      label4953:
      paramMenuItem = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
      label4995:
      label5021:
      if ((paramMenuItem != null) && (paramMenuItem.Rt(32)) && (paramMenuItem.dVj().dZv()))
      {
        localObject2 = ah.dXE().aBr(this.APA);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject2).Rt(32)) && (this.APB != null))
        {
          i = this.doj;
          if (this.doj != 0) {
            break label5183;
          }
        }
        label5183:
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.Asq, paramMenuItem, 11);
          com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject2);
          aCv(this.APA);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.APA;
      localObject3 = ah.dXE().aBr(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((com.tencent.mm.plugin.sns.storage.p)localObject3).Rt(32))
        {
          localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject3).ecw();
          paramMenuItem = (MenuItem)localObject2;
          if (bu.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((com.tencent.mm.plugin.sns.storage.p)localObject3).ecv();
          }
        }
      }
      if (bu.isNullOrNil(paramMenuItem)) {
        paramMenuItem = bh.aCk(this.APB.HUG.Url);
      }
      break;
    }
    for (;;)
    {
      if (bu.isNullOrNil(paramMenuItem))
      {
        ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = new cw();
      localObject4 = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
      if (localObject4 != null)
      {
        localObject5 = z.Br(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId);
        localObject6 = z.aBG().F((String)localObject5, true);
        ((z.b)localObject6).k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        ((z.b)localObject6).k("preUsername", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((z.b)localObject6).k("preChatName", "");
        ((z.b)localObject6).k("url", paramMenuItem);
        ((z.b)localObject6).k("preMsgIndex", Integer.valueOf(0));
        ((z.b)localObject6).k("sendAppMsgScene", Integer.valueOf(1));
        ((z.b)localObject6).k("adExtStr", ((com.tencent.mm.plugin.sns.storage.p)localObject4).ebP().AiG);
        ((cw)localObject2).doL.sessionId = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.APB.HUG.Gtw == 18) || (((com.tencent.mm.plugin.sns.storage.p)localObject3).Rt(32))))
      {
        com.tencent.mm.plugin.sns.ad.e.n.a(n.d.zqE, n.c.zqy, com.tencent.mm.plugin.sns.ad.e.n.e.zqJ, 0, (com.tencent.mm.plugin.sns.storage.p)localObject3, this.doj);
        if (this.APB != null)
        {
          i = this.doj;
          if (this.doj != 0) {
            break label5608;
          }
        }
      }
      label5608:
      for (paramInt = 1;; paramInt = 2)
      {
        localObject4 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, this.Asq, (com.tencent.mm.plugin.sns.storage.p)localObject3, 11);
        com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject4);
        if (bu.isNullOrNil(this.APB.AkC)) {
          break;
        }
        aCv(((com.tencent.mm.plugin.sns.storage.p)localObject3).eco());
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.plugin.sns.k.a.a((cw)localObject2, paramMenuItem, this.APA);
      ((cw)localObject2).doL.activity = this.activity;
      ((cw)localObject2).doL.doR = 28;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((cw)localObject2).doM.ret == 0)
      {
        l = bu.aRi();
        if (!bu.isNullOrNil(paramMenuItem))
        {
          ae.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject2 = "";
        }
      }
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.g.yxI.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(100195);
        return;
      }
      catch (UnsupportedEncodingException paramMenuItem)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
          paramMenuItem = (MenuItem)localObject2;
        }
      }
      as.y(ah.dXE().aBr(this.APA));
      AppMethodBeat.o(100195);
      return;
      if (!(this.APz.getTag() instanceof m)) {
        break;
      }
      as.b((m)this.APz.getTag());
      AppMethodBeat.o(100195);
      return;
      localObject4 = com.tencent.mm.plugin.sns.storage.h.aBr(this.APA);
      if (localObject4 == null)
      {
        ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        AppMethodBeat.o(100195);
        return;
      }
      if ((this.APz.getTag() == null) || (!(this.APz.getTag() instanceof az)))
      {
        ae.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = (az)this.APz.getTag();
      localObject3 = this.activity;
      localObject5 = paramMenuItem.getIntent();
      if (this.doj == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        i = this.doj;
        paramMenuItem = this.AgN;
        if (localObject5 != null) {
          break;
        }
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
        AppMethodBeat.o(100195);
        return;
      }
      if (paramMenuItem == null)
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
        AppMethodBeat.o(100195);
        return;
      }
      if (localObject4 == null)
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
        AppMethodBeat.o(100195);
        return;
      }
      localObject6 = ((az)localObject2).dsN;
      int j = ((az)localObject2).index;
      int k = ((az)localObject2).position;
      localObject2 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).ebP();
      if ((((TimeLineObject)localObject2).HUG == null) || (((TimeLineObject)localObject2).HUG.Gtx.size() == 0))
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem.dXi().F((com.tencent.mm.plugin.sns.storage.p)localObject4);
      localObject7 = ((com.tencent.mm.plugin.sns.storage.p)localObject4).ebP();
      if (j < ((TimeLineObject)localObject7).HUG.Gtx.size()) {}
      for (paramMenuItem = (bzh)((TimeLineObject)localObject7).HUG.Gtx.get(j); !ah.dXB().B(paramMenuItem); paramMenuItem = new bzh())
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.dKr) });
        AppMethodBeat.o(100195);
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = com.tencent.mm.modelsns.e.pY(716);
        ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.data.r.o((com.tencent.mm.plugin.sns.storage.p)localObject4)).qb(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eV(((com.tencent.mm.plugin.sns.storage.p)localObject4).Rt(32)).GU(((com.tencent.mm.plugin.sns.storage.p)localObject4).ecx()).GU(paramMenuItem.Id).qb(j).qb(((TimeLineObject)localObject7).HUG.Gtx.size());
        ((com.tencent.mm.modelsns.e)localObject2).aLH();
        if (paramInt != 1) {
          break label6653;
        }
      }
      label6653:
      for (paramMenuItem = com.tencent.mm.modelsns.e.pY(744);; paramMenuItem = com.tencent.mm.modelsns.e.pZ(744))
      {
        paramMenuItem.GU(com.tencent.mm.plugin.sns.data.r.o((com.tencent.mm.plugin.sns.storage.p)localObject4)).qb(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_type).eV(((com.tencent.mm.plugin.sns.storage.p)localObject4).Rt(32)).GU(((com.tencent.mm.plugin.sns.storage.p)localObject4).ecx());
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
        paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((com.tencent.mm.plugin.sns.storage.p)localObject4).field_snsId));
        paramMenuItem.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.p)localObject4).field_userName);
        ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
        paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(localObject5);
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, paramMenuItem.ahE(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).startActivity((Intent)paramMenuItem.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject3).overridePendingTransition(0, 0);
        AppMethodBeat.o(100195);
        return;
        localObject2 = com.tencent.mm.modelsns.e.pZ(716);
        break;
      }
      if (this.APB == null)
      {
        ae.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem = new cw();
      com.tencent.mm.plugin.sns.k.a.a(paramMenuItem, this.APA);
      paramMenuItem.doL.activity = this.activity;
      paramMenuItem.doL.doR = 28;
      com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
      AppMethodBeat.o(100195);
      return;
      if ((this.APB == null) || (this.APB.HUG == null)) {
        break;
      }
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).c(this.APB.HUG.GtD);
      com.tencent.mm.ui.base.h.cm(this.activity, this.activity.getString(2131758936));
      AppMethodBeat.o(100195);
      return;
      if ((this.APB == null) || (this.APB.HUG == null) || (this.APB.HUG.Gtw != 28)) {
        break;
      }
      paramMenuItem = new cw();
      localObject2 = this.APB;
      if (localObject2 == null)
      {
        ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
        paramMenuItem.doL.doQ = 2131758886;
      }
      for (;;)
      {
        paramMenuItem.doL.activity = this.activity;
        com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
        break;
        localObject3 = String.format("%s", new Object[] { ((TimeLineObject)localObject2).Id });
        localObject4 = new akn();
        localObject5 = new akt();
        localObject6 = new ajx();
        ((akt)localObject5).aQC(((TimeLineObject)localObject2).nIJ);
        ((akt)localObject5).aQD(v.aAC());
        ((akt)localObject5).aax(2);
        ((akt)localObject5).Dk(((TimeLineObject)localObject2).CreateTime * 1000L);
        ((akt)localObject5).aQH(((TimeLineObject)localObject2).Id);
        ((akt)localObject5).aQE((String)localObject3);
        ((ajx)localObject6).aPU((String)localObject3);
        com.tencent.mm.plugin.sns.k.a.a((ajx)localObject6, (TimeLineObject)localObject2);
        ((ajx)localObject6).aao(20);
        ((akn)localObject4).oeJ.add(localObject6);
        ((akn)localObject4).a((akt)localObject5);
        ((akn)localObject4).d(((TimeLineObject)localObject2).HUG.GtB);
        paramMenuItem.doL.doN = ((akn)localObject4);
        paramMenuItem.doL.type = 20;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(100198);
    ae.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.AgA != null) && (this.AgA.isShowing())) {
      this.AgA.dismiss();
    }
    long l2;
    long l1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.sns.model.r)) && ((((com.tencent.mm.plugin.sns.model.r)paramn).type == 4) || (((com.tencent.mm.plugin.sns.model.r)paramn).type == 6)))
    {
      t.v(this.activity, this.activity.getResources().getString(2131766984), 2131690391);
      paramString = (com.tencent.mm.plugin.sns.model.r)paramn;
      if (paramString.zyl != null) {
        break label217;
      }
      paramString = "";
      if (!bu.lX(paramString, v.aAC()))
      {
        paramInt1 = 9;
        if (((com.tencent.mm.plugin.sns.model.r)paramn).type == 6) {
          paramInt1 = 10;
        }
        l2 = ((com.tencent.mm.plugin.sns.model.r)paramn).zyk;
        paramString = ah.dXJ();
        paramn = (com.tencent.mm.plugin.sns.model.r)paramn;
        if (paramn.zyl != null) {
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
        paramString.ebX();
        ah.dXJ().update(paramString.systemRowid, paramString);
      }
      AppMethodBeat.o(100198);
      return;
      label217:
      paramString = paramString.zyl.Username;
      break;
      label228:
      if (paramn.type == 6) {
        l1 = paramn.zyl.HNm;
      } else {
        l1 = paramn.zyl.HNk;
      }
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */