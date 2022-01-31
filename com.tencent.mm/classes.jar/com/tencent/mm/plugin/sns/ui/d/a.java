package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.c;
import com.tencent.mm.plugin.sns.a.b.k.d;
import com.tencent.mm.plugin.sns.a.b.k.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.base.n.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements f, n.d
{
  private Activity activity;
  private int cpt;
  private ClipboardManager mAZ;
  private af rFN;
  private com.tencent.mm.ui.base.p rFz;
  protected com.tencent.mm.plugin.sns.a.b.g rOU;
  private View sjj;
  private String sjk;
  private TimeLineObject sjl;
  
  public a(Activity paramActivity, int paramInt, af paramaf)
  {
    AppMethodBeat.i(40232);
    this.activity = paramActivity;
    this.cpt = paramInt;
    this.mAZ = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    this.rFN = paramaf;
    if (((paramActivity instanceof SnsTimeLineUI)) && (paramInt == 0)) {
      this.rOU = ((SnsTimeLineUI)paramActivity).cwf();
    }
    AppMethodBeat.o(40232);
  }
  
  private void acq(String paramString)
  {
    AppMethodBeat.i(40236);
    Object localObject2 = ag.cpf().abv(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(40236);
      return;
    }
    TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.storage.n)localObject2).csh();
    if (((com.tencent.mm.plugin.sns.storage.n)localObject2).Ex(32))
    {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject2).csQ();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.y((com.tencent.mm.plugin.sns.storage.n)localObject2);
      if (!bo.isNullOrNil(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localTimeLineObject.sbN)
    {
      localObject3 = br.F((String)localObject1, "adxml");
      if (localObject3 != null) {
        break;
      }
      AppMethodBeat.o(40236);
      return;
    }
    if (!((Map)localObject3).containsKey(".adxml.adCanvasInfo"))
    {
      com.tencent.mm.ui.base.h.h(this.activity, 2131299723, 0);
      AppMethodBeat.o(40236);
      return;
    }
    String str1 = com.tencent.mm.model.v.oQ(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_snsId);
    String str2 = bo.bf((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bo.bf((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bo.bf((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cm();
    sm localsm = new sm();
    localsm.cIK.cIN = paramString;
    localsm.cIK.cIO = ((cm)localObject2);
    localsm.cIK.url = str3;
    com.tencent.mm.sdk.b.a.ymk.l(localsm);
    if (!localsm.cIL.cpz)
    {
      if (((cm)localObject2).cpR.cpX == 0) {
        ((cm)localObject2).cpR.cpX = 2131299721;
      }
      com.tencent.mm.ui.base.h.h(this.activity, ((cm)localObject2).cpR.cpX, 0);
      AppMethodBeat.o(40236);
      return;
    }
    ((cm)localObject2).cpR.cpW = str1;
    ((cm)localObject2).cpR.title = str2;
    ((cm)localObject2).cpR.desc = ((String)localObject3);
    paramString = ((cm)localObject2).cpR.cpT;
    if ((paramString != null) && (paramString.wVc != null) && (paramString.wVc.size() > 0) && (paramString.wVc.get(0) != null))
    {
      ((aca)paramString.wVc.get(0)).anP((String)localObject1);
      if (bo.isNullOrNil(((aca)paramString.wVc.get(0)).title)) {
        ((aca)paramString.wVc.get(0)).anq(((cm)localObject2).cpR.title);
      }
      if (bo.isNullOrNil(((aca)paramString.wVc.get(0)).desc)) {
        ((aca)paramString.wVc.get(0)).anr(((cm)localObject2).cpR.desc);
      }
      localObject1 = new acw();
      ((acw)localObject1).aon(localTimeLineObject.jJA);
      ((acw)localObject1).aoo(com.tencent.mm.model.r.Zn());
      ((acw)localObject1).MR(2);
      ((acw)localObject1).nI(bo.aoy());
      paramString.a((acw)localObject1);
    }
    ((cm)localObject2).cpR.activity = this.activity;
    ((cm)localObject2).cpR.cpY = 28;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    AppMethodBeat.o(40236);
  }
  
  private String cwX()
  {
    AppMethodBeat.i(40233);
    if ((this.sjj != null) && ((this.sjj.getTag() instanceof as)) && (((as)this.sjj.getTag()).cvI()))
    {
      Object localObject = aq.aaD(ag.cpf().abv(this.sjk).getSnsId());
      if (localObject != null)
      {
        localObject = ((aq.b)localObject).result;
        AppMethodBeat.o(40233);
        return localObject;
      }
    }
    AppMethodBeat.o(40233);
    return null;
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(40234);
    if (paramn != null)
    {
      if (this.cpt == 2)
      {
        paramn = paramn.cse();
        AppMethodBeat.o(40234);
        return paramn;
      }
      paramn = paramn.csd();
      AppMethodBeat.o(40234);
      return paramn;
    }
    AppMethodBeat.o(40234);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.sjj = paramView;
    this.sjk = paramString;
    this.sjl = paramTimeLineObject;
  }
  
  public final void bKw()
  {
    AppMethodBeat.i(40230);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(218, this);
    AppMethodBeat.o(40230);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(40237);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().abv(this.sjk);
        Object localObject1 = (bcs)this.sjl.xTS.wOa.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + com.tencent.mm.plugin.sns.data.i.e((bcs)localObject1);
        paramIntent = bo.P(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localn.Ex(32))
          {
            str3 = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + com.tencent.mm.plugin.sns.data.i.j((bcs)localObject1);
            TimeLineObject localTimeLineObject = localn.csh();
            com.tencent.mm.plugin.sns.storage.b localb = localn.csb();
            cii localcii = new cii();
            localcii.wUJ = ((bcs)localObject1).sdf;
            localcii.fiO = ((bcs)localObject1).xrZ;
            if (localTimeLineObject.xTS.wNZ == 15)
            {
              localcii.fiU = f(localn).cFe;
              localcii.fiV = localTimeLineObject.Id;
              localcii.fiQ = localTimeLineObject.xTP;
              if (!bo.isNullOrNil(((bcs)localObject1).xsc)) {
                break label550;
              }
              paramIntent = ((bcs)localObject1).xrS;
              label288:
              localcii.fiT = paramIntent;
              if ((localb != null) && (localb.rpX == 0))
              {
                localcii.fiS = localb.rpZ;
                localcii.fiR = localb.rpY;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.i.ZO(str3);
              ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bcs)localObject1).xrZ, Integer.valueOf(((bcs)localObject1).sdf), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.g.bPJ().a(this.activity, str1, str3, str2, 43, paramInt1, localcii, localTimeLineObject.rHA);
              com.tencent.mm.plugin.messenger.a.g.bPJ().fh((String)localObject2, str1);
              paramInt2 = this.cpt;
              if (this.cpt != 0) {
                break label559;
              }
              paramInt1 = 1;
              label442:
              com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(paramInt2, paramInt1, localn.field_snsId, 12, 0));
              boolean bool = t.lA(str1);
              localObject1 = k.d.rax;
              if (!bool) {
                break label564;
              }
              paramIntent = k.c.rau;
              label483:
              localObject2 = k.e.raD;
              if (!bool) {
                break label571;
              }
            }
            label550:
            label559:
            label564:
            label571:
            for (paramInt1 = com.tencent.mm.model.n.nv(str1);; paramInt1 = 0)
            {
              k.a((k.d)localObject1, paramIntent, (k.e)localObject2, paramInt1, localn, this.cpt);
              AppMethodBeat.o(40237);
              return;
              localcii.fiU = localTimeLineObject.xTX.fiU;
              localcii.fiV = localTimeLineObject.xTX.fiV;
              break;
              paramIntent = ((bcs)localObject1).xsc;
              break label288;
              paramInt1 = 2;
              break label442;
              paramIntent = k.c.rat;
              break label483;
            }
          }
          String str3 = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + com.tencent.mm.plugin.sns.data.i.j((bcs)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.i.ZO(str3);
          ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((bcs)localObject1).xrZ, Integer.valueOf(((bcs)localObject1).sdf), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.bPJ().a(this.activity, str1, str3, str2, 43, paramInt1, this.sjl.rHA);
          com.tencent.mm.plugin.messenger.a.g.bPJ().fh((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.l(this.activity, this.activity.getString(2131300637));
        AppMethodBeat.o(40237);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = ag.cpf().abv(this.sjk);
      if (paramIntent == null)
      {
        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.sjk });
        AppMethodBeat.o(40237);
        return;
      }
      paramInt2 = this.cpt;
      if (this.cpt != 0) {
        break label826;
      }
    }
    label826:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(40237);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(40235);
    if (this.sjj == null)
    {
      AppMethodBeat.o(40235);
      return;
    }
    int i;
    label413:
    long l;
    Object localObject3;
    label577:
    label582:
    Object localObject7;
    label777:
    Object localObject4;
    Object localObject5;
    Object localObject6;
    label1400:
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
                AppMethodBeat.o(40235);
                return;
                Object localObject1 = cwX();
                paramMenuItem = (MenuItem)localObject1;
                if (bo.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.sjl.xTP;
                }
                this.mAZ.setText(paramMenuItem);
                com.tencent.mm.ui.base.h.bO(this.activity, this.activity.getString(2131296896));
                localObject1 = com.tencent.mm.plugin.secinforeport.a.a.qEl;
                com.tencent.mm.plugin.secinforeport.a.a.i(2, this.sjl.Id, bo.apL(paramMenuItem));
                AppMethodBeat.o(40235);
                return;
                localObject1 = cwX();
                paramMenuItem = (MenuItem)localObject1;
                if (bo.isNullOrNil((String)localObject1)) {
                  paramMenuItem = this.sjl.xTP;
                }
                this.rFN.coJ().gs(this.sjk, this.sjl.Id);
                localObject1 = new cm();
                com.tencent.mm.plugin.sns.j.a.a((cm)localObject1, this.sjk, paramMenuItem);
                ((cm)localObject1).cpR.activity = this.activity;
                ((cm)localObject1).cpR.cpY = 30;
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
                AppMethodBeat.o(40235);
                return;
                this.rFN.coJ().gs(this.sjk, this.sjl.Id);
                localObject1 = new cm();
                paramMenuItem = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
                if ((paramMenuItem.Ex(32)) && (paramMenuItem.csb().cqk()))
                {
                  acq(this.sjk);
                  if (paramMenuItem.Ex(32))
                  {
                    i = this.cpt;
                    if (this.cpt != 0) {
                      break label577;
                    }
                    paramInt = 1;
                    localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                    if (this.rOU != null) {
                      break label582;
                    }
                  }
                }
                for (l = 0L;; l = this.rOU.di(paramMenuItem.csH(), 11))
                {
                  ((SnsAdClick)localObject1).fQA = l;
                  com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject1);
                  AppMethodBeat.o(40235);
                  return;
                  if (this.sjl.dqG == 1)
                  {
                    com.tencent.mm.plugin.sns.j.a.a((cm)localObject1, this.sjk, 0);
                    ((cm)localObject1).cpR.activity = this.activity;
                    ((cm)localObject1).cpR.cpY = 31;
                    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
                    break;
                  }
                  localObject3 = (com.tencent.mm.plugin.sns.ui.ao)this.sjj.getTag();
                  com.tencent.mm.plugin.sns.j.a.a((cm)localObject1, this.sjk, ((com.tencent.mm.plugin.sns.ui.ao)localObject3).index);
                  ((cm)localObject1).cpR.activity = this.activity;
                  ((cm)localObject1).cpR.cpY = 31;
                  com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
                  break;
                  paramInt = 2;
                  break label413;
                }
                this.rFN.coJ().gs(this.sjk, this.sjl.Id);
                paramMenuItem = ag.cpf().abv(this.sjk);
                if (this.sjl.xTS.wOa.size() != 0)
                {
                  localObject1 = (bcs)this.sjl.xTS.wOa.get(0);
                  if ((paramMenuItem == null) || (localObject1 == null))
                  {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                    AppMethodBeat.o(40235);
                    return;
                  }
                  localObject3 = new cm();
                  if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.rCV != 0)) {
                    break label777;
                  }
                  ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                }
                for (((cm)localObject3).cpR.cpX = 2131299713;; ((cm)localObject3).cpR.cpX = 2131299731)
                {
                  ((cm)localObject3).cpR.activity = this.activity;
                  ((cm)localObject3).cpR.cpY = 25;
                  com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
                  AppMethodBeat.o(40235);
                  return;
                  if (!ag.coN()) {
                    break;
                  }
                  ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                }
                localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.i.lq(paramMenuItem.field_snsId), ((bcs)localObject1).Id });
                localObject4 = new acq();
                localObject5 = new acw();
                ab.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
                ((acw)localObject5).aon(paramMenuItem.field_userName);
                ((acw)localObject5).aoo(com.tencent.mm.model.r.Zn());
                ((acw)localObject5).MR(2);
                ((acw)localObject5).nI(paramMenuItem.field_createTime * 1000L);
                ((acw)localObject5).aos(paramMenuItem.getSnsId());
                ((acw)localObject5).aop((String)localObject7);
                localObject6 = new aca();
                ((aca)localObject6).anI((String)localObject7);
                ((aca)localObject6).anx(((bcs)localObject1).Url);
                ((aca)localObject6).any(((bcs)localObject1).xrW);
                ((aca)localObject6).anw(paramMenuItem.csh().xTS.Url);
                localObject7 = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id) + com.tencent.mm.plugin.sns.data.i.e((bcs)localObject1);
                if (com.tencent.mm.vfs.e.cN((String)localObject7)) {
                  ((aca)localObject6).anF((String)localObject7);
                }
                for (;;)
                {
                  ((aca)localObject6).MI(7);
                  ((aca)localObject6).anq(((bcs)localObject1).Title);
                  ((aca)localObject6).anr(((bcs)localObject1).Desc);
                  ((aca)localObject6).py(true);
                  ((acq)localObject4).wVc.add(localObject6);
                  ((acq)localObject4).a((acw)localObject5);
                  ((cm)localObject3).cpR.cpT = ((acq)localObject4);
                  ((cm)localObject3).cpR.type = 7;
                  com.tencent.mm.plugin.sns.j.a.a((aca)localObject6, paramMenuItem);
                  break;
                  ((aca)localObject6).pz(true);
                  ((aca)localObject6).anz(((bcs)localObject1).xrS);
                  localObject7 = new adf();
                  ((adf)localObject7).aoD(((bcs)localObject1).xrS);
                  ((acq)localObject4).b((adf)localObject7);
                }
                paramMenuItem = this.activity;
                localObject3 = ag.cpf().abv(this.sjk);
                if (localObject3 != null)
                {
                  localObject1 = new Intent();
                  if (((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().xTS.wNZ != 1) {
                    break label1400;
                  }
                  paramInt = 0;
                  if ((this.sjj.getTag() instanceof aj)) {
                    paramInt = ((com.tencent.mm.plugin.sns.ui.ao)this.sjj.getTag()).index;
                  }
                  localObject3 = ak.a((com.tencent.mm.plugin.sns.storage.n)localObject3, paramInt);
                  if (localObject3 == null)
                  {
                    ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                    AppMethodBeat.o(40235);
                    return;
                  }
                  localObject4 = ((bcs)localObject3).Id;
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.h(com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.i.l((bcs)localObject3), paramMenuItem));
                  ((Intent)localObject1).putExtra("sns_send_data_ui_image_position", paramInt);
                }
                while (((((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().xTS.wNZ != 4) && (((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().xTS.wNZ != 15) && (((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().xTS.wNZ != 3)) || ((bcs)((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().xTS.wOa.get(0) != null))
                {
                  ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                  ((Intent)localObject1).putExtra("sns_local_id", this.sjk);
                  ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                  com.tencent.mm.bq.d.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                  AppMethodBeat.o(40235);
                  return;
                }
                ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                AppMethodBeat.o(40235);
                return;
                localObject1 = this.activity;
                paramMenuItem = ag.cpf().abv(this.sjk);
                if (paramMenuItem == null)
                {
                  ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                  AppMethodBeat.o(40235);
                  return;
                }
                if (paramMenuItem.Ex(32))
                {
                  ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                  AppMethodBeat.o(40235);
                  return;
                }
                localObject3 = (bcs)paramMenuItem.csh().xTS.wOa.get(0);
                if (localObject3 == null)
                {
                  ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                  AppMethodBeat.o(40235);
                  return;
                }
                localObject4 = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), ((bcs)localObject3).Id);
                paramMenuItem = "";
                localObject5 = com.tencent.mm.plugin.sns.data.i.j((bcs)localObject3);
                if (com.tencent.mm.vfs.e.cN((String)localObject4 + (String)localObject5)) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.i.e((bcs)localObject3);
                }
                if (com.tencent.mm.vfs.e.cN((String)localObject4 + com.tencent.mm.plugin.sns.data.i.p((bcs)localObject3))) {
                  paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.i.n((bcs)localObject3);
                }
                localObject3 = new Intent();
                ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                ((Intent)localObject3).putExtra("intent_localid", this.sjk);
                ((Intent)localObject3).putExtra("intent_from_scene", this.cpt);
                ((Intent)localObject3).putExtra("intent_ismute", true);
                if ((localObject1 instanceof SnsTimeLineUI)) {
                  ((Intent)localObject3).putExtra("sns_video_scene", 1);
                }
                for (;;)
                {
                  if (this.sjj != null)
                  {
                    paramMenuItem = new int[2];
                    this.sjj.getLocationInWindow(paramMenuItem);
                    paramInt = this.sjj.getWidth();
                    i = this.sjj.getHeight();
                    ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                    ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                    ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                    ((Intent)localObject3).putExtra("img_gallery_height", i);
                  }
                  this.activity.startActivity((Intent)localObject3);
                  this.activity.overridePendingTransition(0, 0);
                  AppMethodBeat.o(40235);
                  return;
                  if ((localObject1 instanceof SnsCommentDetailUI)) {
                    ((Intent)localObject3).putExtra("sns_video_scene", 5);
                  } else if ((localObject1 instanceof SnsUploadUI)) {
                    ((Intent)localObject3).putExtra("sns_video_scene", 6);
                  }
                }
                this.rFN.coJ().gs(this.sjk, this.sjl.Id);
                localObject1 = av.ack(this.sjl.xTS.Url);
                if (bo.isNullOrNil((String)localObject1))
                {
                  ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                  AppMethodBeat.o(40235);
                  return;
                }
                paramMenuItem = new cm();
                localObject3 = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
                if (localObject3 != null)
                {
                  localObject4 = com.tencent.mm.model.v.oQ(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId);
                  localObject5 = com.tencent.mm.model.v.aae().z((String)localObject4, true);
                  ((v.b)localObject5).i("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
                  ((v.b)localObject5).i("preUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
                  ((v.b)localObject5).i("preChatName", "");
                  ((v.b)localObject5).i("url", localObject1);
                  ((v.b)localObject5).i("preMsgIndex", Integer.valueOf(0));
                  ((v.b)localObject5).i("sendAppMsgScene", Integer.valueOf(1));
                  ((v.b)localObject5).i("adExtStr", ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh().rHA);
                  paramMenuItem.cpR.cpW = ((String)localObject4);
                }
                localObject4 = ag.cpf().abv(this.sjk);
                if ((localObject4 != null) && (this.sjl.xTS.wNZ == 18)) {
                  k.a(k.d.ray, k.c.ras, k.e.raD, 0, (com.tencent.mm.plugin.sns.storage.n)localObject4, this.cpt);
                }
                if (!bo.isNullOrNil(this.sjl.sbN))
                {
                  acq(((com.tencent.mm.plugin.sns.storage.n)localObject4).csH());
                  AppMethodBeat.o(40235);
                  return;
                }
                if (((com.tencent.mm.plugin.sns.storage.n)localObject4).Ex(32))
                {
                  i = this.cpt;
                  if (this.cpt != 0) {
                    break label2516;
                  }
                  paramInt = 1;
                  localObject3 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId, 11, 0);
                  if (this.rOU != null) {
                    break label2521;
                  }
                }
                for (l = 0L;; l = this.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject4).csH(), 11))
                {
                  ((SnsAdClick)localObject3).fQA = l;
                  com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject3);
                  com.tencent.mm.plugin.sns.j.a.a(paramMenuItem, (String)localObject1, this.sjk);
                  paramMenuItem.cpR.activity = this.activity;
                  paramMenuItem.cpR.cpY = 28;
                  com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
                  if (paramMenuItem.cpS.ret == 0)
                  {
                    l = bo.aox();
                    if (!bo.isNullOrNil((String)localObject1))
                    {
                      ab.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
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
                      ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
                    }
                  }
                  com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                  AppMethodBeat.o(40235);
                  return;
                  paramInt = 2;
                  break;
                }
                this.rFN.coJ().gs(this.sjk, this.sjl.Id);
              } while (this.sjl == null);
              paramMenuItem = new cm();
              localObject5 = this.sjl;
              if (localObject5 == null)
              {
                ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.cpR.cpX = 2131299713;
              }
              for (;;)
              {
                paramMenuItem.cpR.activity = this.activity;
                paramMenuItem.cpR.cpY = 26;
                com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
                AppMethodBeat.o(40235);
                return;
                localObject2 = new acq();
                localObject3 = new acw();
                localObject4 = new acp();
                ((acw)localObject3).aon(((TimeLineObject)localObject5).jJA);
                ((acw)localObject3).aoo(com.tencent.mm.model.r.Zn());
                ((acw)localObject3).MR(2);
                ((acw)localObject3).nI(bo.aoy());
                if (((TimeLineObject)localObject5).xTR != null) {
                  ((acw)localObject3).aot(((TimeLineObject)localObject5).xTR.Id);
                }
                if (((TimeLineObject)localObject5).xTS != null)
                {
                  ((acp)localObject4).aog(((TimeLineObject)localObject5).xTS.Title);
                  ((acp)localObject4).aoh(((TimeLineObject)localObject5).xTS.Desc);
                  if ((((TimeLineObject)localObject5).xTS.wOa != null) && (!((TimeLineObject)localObject5).xTS.wOa.isEmpty()))
                  {
                    localObject5 = (bcs)((TimeLineObject)localObject5).xTS.wOa.get(0);
                    ((acp)localObject4).MO(((bcs)localObject5).subType);
                    ((acp)localObject4).aoj(((bcs)localObject5).rGh);
                    ((acp)localObject4).aoi(((bcs)localObject5).xrS);
                  }
                }
                paramMenuItem.cpR.title = ((acp)localObject4).title;
                paramMenuItem.cpR.desc = ((acp)localObject4).desc;
                paramMenuItem.cpR.cpT = ((acq)localObject2);
                paramMenuItem.cpR.type = 10;
                ((acq)localObject2).a((acw)localObject3);
                ((acq)localObject2).b((acp)localObject4);
              }
              this.rFN.coJ().gs(this.sjk, this.sjl.Id);
            } while (this.sjl == null);
            paramMenuItem = new cm();
            localObject5 = this.sjl;
            if (localObject5 == null)
            {
              ab.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
              paramMenuItem.cpR.cpX = 2131299713;
            }
            for (;;)
            {
              paramMenuItem.cpR.activity = this.activity;
              paramMenuItem.cpR.cpY = 27;
              com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
              AppMethodBeat.o(40235);
              return;
              localObject2 = new acq();
              localObject3 = new acw();
              localObject4 = new acz();
              ((acw)localObject3).aon(((TimeLineObject)localObject5).jJA);
              ((acw)localObject3).aoo(com.tencent.mm.model.r.Zn());
              ((acw)localObject3).MR(8);
              ((acw)localObject3).nI(bo.aoy());
              if (((TimeLineObject)localObject5).xTR != null) {
                ((acw)localObject3).aot(((TimeLineObject)localObject5).xTR.Id);
              }
              if (((TimeLineObject)localObject5).xTS != null)
              {
                ((acz)localObject4).aow(((TimeLineObject)localObject5).xTS.Title);
                ((acz)localObject4).aox(((TimeLineObject)localObject5).xTS.Desc);
                if ((((TimeLineObject)localObject5).xTS.wOa != null) && (!((TimeLineObject)localObject5).xTS.wOa.isEmpty()))
                {
                  localObject5 = (bcs)((TimeLineObject)localObject5).xTS.wOa.get(0);
                  ((acz)localObject4).aoz(((bcs)localObject5).rGh);
                  ((acz)localObject4).aoy(((bcs)localObject5).xrS);
                }
              }
              paramMenuItem.cpR.title = ((acz)localObject4).title;
              paramMenuItem.cpR.desc = ((acz)localObject4).desc;
              paramMenuItem.cpR.cpT = ((acq)localObject2);
              paramMenuItem.cpR.type = 15;
              ((acq)localObject2).a((acw)localObject3);
              ((acq)localObject2).b((acz)localObject4);
            }
            paramMenuItem = ag.cpf().abv(this.sjk).getSnsId();
            localObject2 = (l)this.sjj.getTag();
            if (com.tencent.mm.plugin.sns.storage.v.abN(paramMenuItem))
            {
              paramMenuItem = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.v.abO(paramMenuItem), 6, ((l)localObject2).reJ);
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RK().eHt.a(paramMenuItem, 0);
            }
            for (;;)
            {
              localObject2 = this.activity;
              this.activity.getString(2131297087);
              this.rFz = com.tencent.mm.ui.base.h.b((Context)localObject2, this.activity.getString(2131303795), true, new a.1(this, paramMenuItem));
              AppMethodBeat.o(40235);
              return;
              paramMenuItem = new com.tencent.mm.plugin.sns.model.r(com.tencent.mm.plugin.sns.storage.v.abO(paramMenuItem), 4, ((l)localObject2).reJ);
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RK().eHt.a(paramMenuItem, 0);
            }
            paramMenuItem = ag.cpf().abv(this.sjk);
          } while (paramMenuItem == null);
          com.tencent.mm.plugin.sns.abtest.a.b(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
          ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.field_userName);
          ((Intent)localObject2).putExtra("sns_permission_anim", true);
          ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
          this.activity.startActivityForResult((Intent)localObject2, 11);
          AppMethodBeat.o(40235);
          return;
          this.rFN.coJ().gs(this.sjk, this.sjl.Id);
          paramMenuItem = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
          if ((paramMenuItem.Ex(32)) && (paramMenuItem.csb().cqk()))
          {
            localObject2 = ag.cpf().abv(this.sjk);
            if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).Ex(32)))
            {
              i = this.cpt;
              if (this.cpt != 0) {
                break label3668;
              }
              paramInt = 1;
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              if (this.rOU != null) {
                break label3673;
              }
            }
            for (l = 0L;; l = this.rOU.di(paramMenuItem.csH(), 11))
            {
              ((SnsAdClick)localObject2).fQA = l;
              com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
              acq(this.sjk);
              AppMethodBeat.o(40235);
              return;
              paramInt = 2;
              break;
            }
          }
          paramMenuItem = this.sjk;
          paramMenuItem = ag.cpf().abv(paramMenuItem);
          if (paramMenuItem != null) {
            if (paramMenuItem.Ex(32))
            {
              k.a(k.d.rax, k.c.ras, k.e.raD, 0, paramMenuItem, this.cpt);
              i = this.cpt;
              if (this.cpt != 0) {
                break label3843;
              }
              paramInt = 1;
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              if (this.rOU != null) {
                break label3848;
              }
            }
          }
          for (l = 0L;; l = this.rOU.di(paramMenuItem.csH(), 11))
          {
            ((SnsAdClick)localObject2).fQA = l;
            com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
            localObject2 = new cm();
            com.tencent.mm.plugin.sns.j.a.a((cm)localObject2, paramMenuItem);
            ((cm)localObject2).cpR.activity = this.activity;
            ((cm)localObject2).cpR.cpY = 29;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
            AppMethodBeat.o(40235);
            return;
            paramInt = 2;
            break;
          }
          paramMenuItem = (bcs)this.sjl.xTS.wOa.get(0);
          paramMenuItem = com.tencent.mm.plugin.sns.model.ao.gl(ag.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.i.e(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.bq.d.b(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
          AppMethodBeat.o(40235);
          return;
        } while (!(this.sjj.getTag() instanceof l));
        paramMenuItem = (l)this.sjj.getTag();
        this.mAZ.setText(paramMenuItem.ntu);
        com.tencent.mm.ui.base.h.bO(this.activity, this.activity.getString(2131296896));
        if (paramMenuItem.reJ != null)
        {
          localObject2 = com.tencent.mm.plugin.secinforeport.a.a.qEl;
          com.tencent.mm.plugin.secinforeport.a.a.i(4, this.sjl.Id + ":" + paramMenuItem.reJ.xNY, bo.apL(paramMenuItem.ntu));
        }
        AppMethodBeat.o(40235);
        return;
        paramMenuItem = ag.cpf().abv(this.sjk);
        com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
        AppMethodBeat.o(40235);
        return;
        localObject2 = ag.cpf().abv(this.sjk);
        if (localObject2 != null) {
          if (this.cpt != 0) {
            break label4225;
          }
        }
        for (paramMenuItem = com.tencent.mm.modelsns.b.lV(714);; paramMenuItem = com.tencent.mm.modelsns.b.lW(714))
        {
          paramMenuItem.uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject2)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject2).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject2).Ex(32)).uv(((com.tencent.mm.plugin.sns.storage.n)localObject2).csP());
          paramMenuItem.ake();
          aq.r((com.tencent.mm.plugin.sns.storage.n)localObject2);
          AppMethodBeat.o(40235);
          return;
        }
      } while (!(this.sjj.getTag() instanceof l));
      localObject2 = (l)this.sjj.getTag();
      localObject3 = ag.cpf().abu(((l)localObject2).rFY);
      if (localObject3 != null)
      {
        if (this.cpt != 0) {
          break label4402;
        }
        paramMenuItem = com.tencent.mm.modelsns.b.lV(715);
        paramMenuItem.uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject3)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)).uv(((com.tencent.mm.plugin.sns.storage.n)localObject3).csP());
        if (((l)localObject2).reJ == null) {
          break label4438;
        }
        if (((l)localObject2).reJ.xNY != 0) {
          break label4412;
        }
        localObject2 = ((l)localObject2).reJ.xOa;
        paramMenuItem.uv((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.ake();
        aq.a((l)this.sjj.getTag());
        AppMethodBeat.o(40235);
        return;
        paramMenuItem = com.tencent.mm.modelsns.b.lW(715);
        break;
        localObject2 = ((l)localObject2).reJ.xNY;
        break label4370;
        paramMenuItem.uv("");
      }
    case 20: 
      label2516:
      label2521:
      this.rFN.coJ().gs(this.sjk, this.sjl.Id);
      label3668:
      label3673:
      localObject2 = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
      label3843:
      label3848:
      label4370:
      label4402:
      label4412:
      label4438:
      if ((((com.tencent.mm.plugin.sns.storage.n)localObject2).Ex(32)) && (((com.tencent.mm.plugin.sns.storage.n)localObject2).csb().cqk()))
      {
        paramMenuItem = ag.cpf().abv(this.sjk);
        if ((paramMenuItem != null) && (paramMenuItem.Ex(32)) && (this.sjl != null))
        {
          i = this.cpt;
          if (this.cpt != 0) {
            break label4602;
          }
          paramInt = 1;
          localObject2 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.n)localObject2).field_snsId, 11, 0);
          if (this.rOU != null) {
            break label4607;
          }
        }
        label4602:
        label4607:
        for (l = 0L;; l = this.rOU.di(paramMenuItem.csH(), 11))
        {
          ((SnsAdClick)localObject2).fQA = l;
          com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
          acq(this.sjk);
          AppMethodBeat.o(40235);
          return;
          paramInt = 2;
          break;
        }
      }
      label4225:
      paramMenuItem = this.sjk;
      localObject3 = ag.cpf().abv(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32))
        {
          localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csO();
          paramMenuItem = (MenuItem)localObject2;
          if (bo.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((com.tencent.mm.plugin.sns.storage.n)localObject3).getAdLink();
          }
        }
      }
      if (bo.isNullOrNil(paramMenuItem)) {
        paramMenuItem = av.ack(this.sjl.xTS.Url);
      }
      break;
    }
    for (;;)
    {
      if (bo.isNullOrNil(paramMenuItem))
      {
        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(40235);
        return;
      }
      localObject2 = new cm();
      localObject4 = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
      if (localObject4 != null)
      {
        localObject5 = com.tencent.mm.model.v.oQ(((com.tencent.mm.plugin.sns.storage.n)localObject4).field_snsId);
        localObject6 = com.tencent.mm.model.v.aae().z((String)localObject5, true);
        ((v.b)localObject6).i("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject4).field_snsId));
        ((v.b)localObject6).i("preUsername", ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_userName);
        ((v.b)localObject6).i("preChatName", "");
        ((v.b)localObject6).i("url", paramMenuItem);
        ((v.b)localObject6).i("preMsgIndex", Integer.valueOf(0));
        ((v.b)localObject6).i("sendAppMsgScene", Integer.valueOf(1));
        ((v.b)localObject6).i("adExtStr", ((com.tencent.mm.plugin.sns.storage.n)localObject4).csh().rHA);
        ((cm)localObject2).cpR.cpW = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.sjl.xTS.wNZ == 18) || (((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32))))
      {
        k.a(k.d.ray, k.c.ras, k.e.raD, 0, (com.tencent.mm.plugin.sns.storage.n)localObject3, this.cpt);
        if (this.sjl != null)
        {
          i = this.cpt;
          if (this.cpt != 0) {
            break label5049;
          }
          paramInt = 1;
          localObject4 = new SnsAdClick(i, paramInt, ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_snsId, 11, 0);
          if (this.rOU != null) {
            break label5054;
          }
        }
      }
      label5049:
      label5054:
      for (l = 0L;; l = this.rOU.di(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH(), 11))
      {
        ((SnsAdClick)localObject4).fQA = l;
        com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject4);
        if (bo.isNullOrNil(this.sjl.sbN)) {
          break label5073;
        }
        acq(((com.tencent.mm.plugin.sns.storage.n)localObject3).csH());
        AppMethodBeat.o(40235);
        return;
        paramInt = 2;
        break;
      }
      label5073:
      com.tencent.mm.plugin.sns.j.a.a((cm)localObject2, paramMenuItem, this.sjk);
      ((cm)localObject2).cpR.activity = this.activity;
      ((cm)localObject2).cpR.cpY = 28;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      if (((cm)localObject2).cpS.ret == 0)
      {
        l = bo.aox();
        if (!bo.isNullOrNil(paramMenuItem))
        {
          ab.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject2 = "";
        }
      }
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.h.qsU.e(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(40235);
        return;
      }
      catch (UnsupportedEncodingException paramMenuItem)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
          paramMenuItem = (MenuItem)localObject2;
        }
      }
      aq.s(ag.cpf().abv(this.sjk));
      AppMethodBeat.o(40235);
      return;
      if (!(this.sjj.getTag() instanceof l)) {
        break;
      }
      aq.b((l)this.sjj.getTag());
      AppMethodBeat.o(40235);
      return;
      localObject3 = com.tencent.mm.plugin.sns.storage.h.abv(this.sjk);
      if (localObject3 == null)
      {
        ab.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        AppMethodBeat.o(40235);
        return;
      }
      localObject2 = (com.tencent.mm.plugin.sns.ui.ao)this.sjj.getTag();
      localObject4 = this.activity;
      localObject5 = paramMenuItem.getIntent();
      if (this.cpt == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        i = this.cpt;
        paramMenuItem = this.rFN;
        if (localObject5 != null) {
          break;
        }
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
        AppMethodBeat.o(40235);
        return;
      }
      if (paramMenuItem == null)
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
        AppMethodBeat.o(40235);
        return;
      }
      if (localObject3 == null)
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
        AppMethodBeat.o(40235);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
        AppMethodBeat.o(40235);
        return;
      }
      localObject6 = ((com.tencent.mm.plugin.sns.ui.ao)localObject2).ctV;
      int j = ((com.tencent.mm.plugin.sns.ui.ao)localObject2).index;
      int k = ((com.tencent.mm.plugin.sns.ui.ao)localObject2).position;
      localObject2 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh();
      if ((((TimeLineObject)localObject2).xTS == null) || (((TimeLineObject)localObject2).xTS.wOa.size() == 0))
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
        AppMethodBeat.o(40235);
        return;
      }
      paramMenuItem.coJ().x((com.tencent.mm.plugin.sns.storage.n)localObject3);
      localObject7 = ((com.tencent.mm.plugin.sns.storage.n)localObject3).csh();
      if (j < ((TimeLineObject)localObject7).xTS.wOa.size()) {}
      for (paramMenuItem = (bcs)((TimeLineObject)localObject7).xTS.wOa.get(j); !ag.cpc().B(paramMenuItem); paramMenuItem = new bcs())
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.cIp) });
        AppMethodBeat.o(40235);
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = com.tencent.mm.modelsns.b.lV(716);
        ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject3)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)).uv(((com.tencent.mm.plugin.sns.storage.n)localObject3).csP()).uv(paramMenuItem.Id).lY(j).lY(((TimeLineObject)localObject7).xTS.wOa.size());
        ((com.tencent.mm.modelsns.b)localObject2).ake();
        if (paramInt != 1) {
          break label6005;
        }
      }
      label6005:
      for (paramMenuItem = com.tencent.mm.modelsns.b.lV(744);; paramMenuItem = com.tencent.mm.modelsns.b.lW(744))
      {
        paramMenuItem.uv(com.tencent.mm.plugin.sns.data.i.j((com.tencent.mm.plugin.sns.storage.n)localObject3)).lY(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_type).de(((com.tencent.mm.plugin.sns.storage.n)localObject3).Ex(32)).uv(((com.tencent.mm.plugin.sns.storage.n)localObject3).csP());
        paramMenuItem.b((Intent)localObject5, "intent_key_StatisticsOplog");
        ((Intent)localObject5).putExtra("sns_soon_enter_photoedit_ui", true);
        ((Intent)localObject5).putExtra("sns_gallery_localId", (String)localObject6);
        ((Intent)localObject5).putExtra("sns_gallery_position", j);
        ((Intent)localObject5).putExtra("sns_position", k);
        ((Intent)localObject5).putExtra("sns_gallery_showtype", 1);
        ((Intent)localObject5).putExtra("K_ad_scene", paramInt);
        ((Intent)localObject5).putExtra("K_ad_source", i);
        ((Intent)localObject5).putExtra("k_is_from_sns_main_timeline", true);
        ((Intent)localObject5).setClass((Context)localObject4, SnsBrowseUI.class);
        paramMenuItem = new Bundle();
        paramMenuItem.putInt("stat_scene", 3);
        paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.i.lq(((com.tencent.mm.plugin.sns.storage.n)localObject3).field_snsId));
        paramMenuItem.putString("stat_send_msg_user", ((com.tencent.mm.plugin.sns.storage.n)localObject3).field_userName);
        ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
        ((Activity)localObject4).startActivity((Intent)localObject5);
        ((Activity)localObject4).overridePendingTransition(0, 0);
        AppMethodBeat.o(40235);
        return;
        localObject2 = com.tencent.mm.modelsns.b.lW(716);
        break;
      }
      if (this.sjl == null)
      {
        ab.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        AppMethodBeat.o(40235);
        return;
      }
      paramMenuItem = new cm();
      com.tencent.mm.plugin.sns.j.a.a(paramMenuItem, this.sjk);
      paramMenuItem.cpR.activity = this.activity;
      paramMenuItem.cpR.cpY = 28;
      com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(40238);
    ab.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.rFz != null) && (this.rFz.isShowing())) {
      this.rFz.dismiss();
    }
    AppMethodBeat.o(40238);
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(40231);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(218, this);
    AppMethodBeat.o(40231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a
 * JD-Core Version:    0.7.0.1
 */