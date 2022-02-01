package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.xu;
import com.tencent.mm.f.a.xu.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.ad.f.p;
import com.tencent.mm.plugin.sns.ad.f.p.c;
import com.tencent.mm.plugin.sns.ad.f.p.d;
import com.tencent.mm.plugin.sns.ad.f.p.e;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.an.i, q.g
{
  private com.tencent.mm.ui.base.s KCf;
  private ai KCs;
  protected com.tencent.mm.plugin.sns.ad.f.l KPn;
  private View LoG;
  private String LoH;
  private TimeLineObject LoI;
  private Activity activity;
  private int source;
  
  public b(Activity paramActivity, int paramInt, ai paramai)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.source = paramInt;
    this.KCs = paramai;
    AppMethodBeat.o(100192);
  }
  
  private void bcv(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = aj.fOI().bbl(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if (((SnsInfo)localObject2).isAd())
    {
      localObject1 = ((SnsInfo)localObject2).getAdSnsInfo();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R((SnsInfo)localObject2);
      if (!Util.isNullOrNil(str1)) {
        ((AdSnsInfo)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((AdSnsInfo)localObject1).field_adxml;; localObject1 = localTimeLineObject.canvasInfo)
    {
      localObject3 = XmlParser.parseXml((String)localObject1, "adxml", null);
      if (localObject3 != null) {
        break;
      }
      AppMethodBeat.o(100196);
      return;
    }
    if (!((Map)localObject3).containsKey(".adxml.adCanvasInfo"))
    {
      com.tencent.mm.ui.base.h.p(this.activity, i.j.favorite_fail_parse_error, 0);
      AppMethodBeat.o(100196);
      return;
    }
    String str1 = ad.Rp(((SnsInfo)localObject2).field_snsId);
    String str2 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new dd();
    xu localxu = new xu();
    localxu.fWG.fWJ = paramString;
    localxu.fWG.fWK = ((dd)localObject2);
    localxu.fWG.url = str3;
    EventCenter.instance.publish(localxu);
    if (!localxu.fWH.fyl)
    {
      if (((dd)localObject2).fyI.fyO == 0) {
        ((dd)localObject2).fyI.fyO = i.j.favorite_fail_nonsupport;
      }
      com.tencent.mm.ui.base.h.p(this.activity, ((dd)localObject2).fyI.fyO, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((dd)localObject2).fyI.sessionId = str1;
    ((dd)localObject2).fyI.title = str2;
    ((dd)localObject2).fyI.desc = ((String)localObject3);
    paramString = ((dd)localObject2).fyI.fyK;
    if ((paramString != null) && (paramString.syG != null) && (paramString.syG.size() > 0) && (paramString.syG.get(0) != null))
    {
      ((anm)paramString.syG.get(0)).bsW((String)localObject1);
      if (Util.isNullOrNil(((anm)paramString.syG.get(0)).title)) {
        ((anm)paramString.syG.get(0)).bsx(((dd)localObject2).fyI.title);
      }
      if (Util.isNullOrNil(((anm)paramString.syG.get(0)).desc)) {
        ((anm)paramString.syG.get(0)).bsy(((dd)localObject2).fyI.desc);
      }
      localObject1 = new aoi();
      ((aoi)localObject1).btx(localTimeLineObject.UserName);
      ((aoi)localObject1).bty(z.bcZ());
      ((aoi)localObject1).arz(2);
      ((aoi)localObject1).Ue(Util.nowMilliSecond());
      paramString.a((aoi)localObject1);
    }
    ((dd)localObject2).fyI.activity = this.activity;
    ((dd)localObject2).fyI.fyP = 28;
    EventCenter.instance.publish((IEvent)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private void bcw(String paramString)
  {
    AppMethodBeat.i(234762);
    SnsInfo localSnsInfo = aj.fOI().bbl(paramString);
    Object localObject1 = null;
    paramString = (String)localObject1;
    if (localSnsInfo != null)
    {
      paramString = (String)localObject1;
      if (localSnsInfo.isAd())
      {
        localObject1 = localSnsInfo.getAdInfoLink();
        paramString = (String)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          paramString = localSnsInfo.getAdLink();
        }
      }
    }
    if (Util.isNullOrNil(paramString)) {
      paramString = bm.bch(this.LoI.ContentObj.Url);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString))
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(234762);
        return;
      }
      localObject1 = new dd();
      Object localObject2 = f.bbl(this.LoH);
      if (localObject2 != null)
      {
        String str = ad.Rp(((SnsInfo)localObject2).field_snsId);
        ad.b localb = ad.beh().I(str, true);
        localb.k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject2).field_snsId));
        localb.k("preUsername", ((SnsInfo)localObject2).field_userName);
        localb.k("preChatName", "");
        localb.k("url", paramString);
        localb.k("preMsgIndex", Integer.valueOf(0));
        localb.k("sendAppMsgScene", Integer.valueOf(1));
        localb.k("adExtStr", ((SnsInfo)localObject2).getTimeLine().statExtStr);
        ((dd)localObject1).fyI.sessionId = str;
      }
      int j;
      if ((localSnsInfo != null) && ((this.LoI.ContentObj.Sqq == 18) || (localSnsInfo.isAd())))
      {
        p.a(p.d.JGp, p.c.JGj, p.e.JGu, 0, localSnsInfo, this.source);
        if (this.LoI != null)
        {
          j = this.source;
          if (this.source != 0) {
            break label417;
          }
        }
      }
      label417:
      for (int i = 1;; i = 2)
      {
        localObject2 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.KPn, localSnsInfo, 11);
        com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject2);
        if (Util.isNullOrNil(this.LoI.canvasInfo)) {
          break;
        }
        bcv(localSnsInfo.getLocalid());
        AppMethodBeat.o(234762);
        return;
      }
      com.tencent.mm.plugin.sns.l.a.a((dd)localObject1, paramString, this.LoH);
      ((dd)localObject1).fyI.activity = this.activity;
      ((dd)localObject1).fyI.fyP = 28;
      EventCenter.instance.publish((IEvent)localObject1);
      long l;
      if (((dd)localObject1).fyJ.ret == 0)
      {
        l = Util.nowSecond();
        if (!Util.isNullOrNil(paramString))
        {
          Log.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramString, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject1 = "";
        }
      }
      try
      {
        paramString = URLEncoder.encode(paramString, "UTF-8");
        com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramString, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(234762);
        return;
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramString, "", new Object[0]);
          paramString = (String)localObject1;
        }
      }
    }
  }
  
  private String fYD()
  {
    AppMethodBeat.i(100193);
    if ((this.LoG != null) && ((this.LoG instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.LoG != null) && ((this.LoG.getTag() instanceof bi)) && (((bi)this.LoG.getTag()).fWO()))
    {
      Object localObject = at.bal(aj.fOI().bbl(this.LoH).getSnsId());
      if (localObject != null)
      {
        localObject = ((at.b)localObject).result;
        AppMethodBeat.o(100193);
        return localObject;
      }
    }
    AppMethodBeat.o(100193);
    return null;
  }
  
  private ADInfo h(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(100194);
    if (paramSnsInfo != null)
    {
      if (this.source == 2)
      {
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        AppMethodBeat.o(100194);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdInfo();
      AppMethodBeat.o(100194);
      return paramSnsInfo;
    }
    AppMethodBeat.o(100194);
    return null;
  }
  
  public final void a(View paramView, String paramString, TimeLineObject paramTimeLineObject)
  {
    this.LoG = paramView;
    this.LoH = paramString;
    this.LoI = paramTimeLineObject;
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    this.KPn = paraml;
  }
  
  public final void eKx()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        SnsInfo localSnsInfo = aj.fOI().bbl(this.LoH);
        Object localObject1 = (cvt)this.LoI.ContentObj.Sqr.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id) + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject1);
        paramIntent = Util.stringsToList(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localSnsInfo.isAd())
          {
            str3 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id) + com.tencent.mm.plugin.sns.data.t.i((cvt)localObject1);
            TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
            ADXml localADXml = localSnsInfo.getAdXml();
            eor localeor = new eor();
            localeor.SAk = ((cvt)localObject1).Lgc;
            localeor.lor = ((cvt)localObject1).TDL;
            if (localTimeLineObject.ContentObj.Sqq == 15)
            {
              localeor.lox = h(localSnsInfo).uxInfo;
              localeor.loy = localTimeLineObject.Id;
              localeor.lot = localTimeLineObject.ContentDesc;
              if (!Util.isNullOrNil(((cvt)localObject1).TDO)) {
                break label549;
              }
              paramIntent = ((cvt)localObject1).TDF;
              label286:
              localeor.low = paramIntent;
              if ((localADXml != null) && (localADXml.attachShareLinkIsHidden == 0))
              {
                localeor.lov = localADXml.attachShareLinkUrl;
                localeor.lou = localADXml.attachShareLinkWording;
              }
              paramInt1 = com.tencent.mm.plugin.sns.data.t.aZt(str3);
              Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((cvt)localObject1).TDL, Integer.valueOf(((cvt)localObject1).Lgc), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.g.eRW().a(this.activity, str1, str3, str2, 43, paramInt1, localeor, localTimeLineObject.statExtStr, null);
              com.tencent.mm.plugin.messenger.a.g.eRW().iQ((String)localObject2, str1);
              paramInt2 = this.source;
              if (this.source != 0) {
                break label558;
              }
              paramInt1 = 1;
              label441:
              com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(paramInt2, paramInt1, localSnsInfo.field_snsId, 12, 0));
              boolean bool = ab.Lj(str1);
              localObject1 = p.d.JGo;
              if (!bool) {
                break label563;
              }
              paramIntent = p.c.JGl;
              label482:
              localObject2 = p.e.JGu;
              if (!bool) {
                break label570;
              }
            }
            label549:
            label558:
            label563:
            label570:
            for (paramInt1 = v.Pu(str1);; paramInt1 = 0)
            {
              p.a((p.d)localObject1, paramIntent, (p.e)localObject2, paramInt1, localSnsInfo, this.source);
              AppMethodBeat.o(100197);
              return;
              localeor.lox = localTimeLineObject.streamvideo.lox;
              localeor.loy = localTimeLineObject.streamvideo.loy;
              break;
              paramIntent = ((cvt)localObject1).TDO;
              break label286;
              paramInt1 = 2;
              break label441;
              paramIntent = p.c.JGk;
              break label482;
            }
          }
          String str3 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id) + com.tencent.mm.plugin.sns.data.t.i((cvt)localObject1);
          paramInt1 = com.tencent.mm.plugin.sns.data.t.aZt(str3);
          Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((cvt)localObject1).TDL, Integer.valueOf(((cvt)localObject1).Lgc), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.eRW().a(this.activity, str1, str3, str2, 43, paramInt1, this.LoI.statExtStr, null);
          com.tencent.mm.plugin.messenger.a.g.eRW().iQ((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this.activity, this.activity.getString(i.j.has_send));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = aj.fOI().bbl(this.LoH);
      if (paramIntent == null)
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.LoH });
        AppMethodBeat.o(100197);
        return;
      }
      paramInt2 = this.source;
      if (this.source != 0) {
        break label826;
      }
    }
    label826:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(100197);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.LoG == null)
    {
      AppMethodBeat.o(100195);
      return;
    }
    Object localObject3;
    label633:
    Object localObject4;
    label821:
    Object localObject5;
    Object localObject6;
    label1591:
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    case 6: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 28: 
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
    case 20: 
    case 16: 
    case 17: 
    case 21: 
    case 22: 
    case 24: 
      do
      {
        do
        {
          int i;
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
                    do
                    {
                      AppMethodBeat.o(100195);
                      return;
                      Object localObject1 = fYD();
                      paramMenuItem = (MenuItem)localObject1;
                      if (Util.isNullOrNil((String)localObject1)) {
                        paramMenuItem = this.LoI.ContentDesc;
                      }
                      if (ClipboardHelper.setTextSwallowException(paramMenuItem))
                      {
                        com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(i.j.app_copy_ok));
                        localObject1 = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
                        com.tencent.mm.plugin.secinforeport.a.a.s(2, this.LoI.Id, Util.getUTF8ByteLength(paramMenuItem));
                        AppMethodBeat.o(100195);
                        return;
                      }
                      com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(i.j.app_copy_failed));
                      AppMethodBeat.o(100195);
                      return;
                      localObject1 = fYD();
                      paramMenuItem = (MenuItem)localObject1;
                      if (Util.isNullOrNil((String)localObject1)) {
                        paramMenuItem = this.LoI.ContentDesc;
                      }
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                      localObject1 = new dd();
                      com.tencent.mm.plugin.sns.l.a.a((dd)localObject1, this.LoH, paramMenuItem);
                      ((dd)localObject1).fyI.activity = this.activity;
                      ((dd)localObject1).fyI.fyP = 30;
                      EventCenter.instance.publish((IEvent)localObject1);
                      AppMethodBeat.o(100195);
                      return;
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                      localObject1 = new dd();
                      paramMenuItem = f.bbl(this.LoH);
                      if ((paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
                      {
                        bcv(this.LoH);
                        if (paramMenuItem.isAd())
                        {
                          i = this.source;
                          if (this.source != 0) {
                            break label633;
                          }
                        }
                      }
                      for (paramInt = 1;; paramInt = 2)
                      {
                        localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, this.KPn, paramMenuItem, 11);
                        com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                        if (this.LoI.showFlag == 1)
                        {
                          com.tencent.mm.plugin.sns.l.a.a((dd)localObject1, this.LoH, 0);
                          ((dd)localObject1).fyI.activity = this.activity;
                          ((dd)localObject1).fyI.fyP = 31;
                          EventCenter.instance.publish((IEvent)localObject1);
                          break;
                        }
                        if (!(this.LoG.getTag() instanceof be)) {
                          break;
                        }
                        localObject3 = (be)this.LoG.getTag();
                        com.tencent.mm.plugin.sns.l.a.a((dd)localObject1, this.LoH, ((be)localObject3).index);
                        ((dd)localObject1).fyI.activity = this.activity;
                        ((dd)localObject1).fyI.fyP = 31;
                        EventCenter.instance.publish((IEvent)localObject1);
                        break;
                      }
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                      paramMenuItem = aj.fOI().bbl(this.LoH);
                      Object localObject7;
                      if (this.LoI.ContentObj.Sqr.size() != 0)
                      {
                        localObject7 = (cvt)this.LoI.ContentObj.Sqr.get(0);
                        if ((paramMenuItem == null) || (localObject7 == null))
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject1 = new dd();
                        localObject3 = this.LoI;
                        if ((localObject7 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                          break label821;
                        }
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        ((dd)localObject1).fyI.fyO = i.j.favorite_fail_argument_error;
                      }
                      Object localObject8;
                      for (;;)
                      {
                        ((dd)localObject1).fyI.activity = this.activity;
                        ((dd)localObject1).fyI.fyP = 25;
                        EventCenter.instance.publish((IEvent)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                        if (aj.isInValid())
                        {
                          Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                          ((dd)localObject1).fyI.fyO = i.j.favorite_fail_system_error;
                        }
                        else
                        {
                          localObject8 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.t.Qu(paramMenuItem.field_snsId), ((cvt)localObject7).Id });
                          localObject4 = new aoc();
                          localObject5 = new aoi();
                          Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                          ((aoi)localObject5).btx(paramMenuItem.getUserName());
                          ((aoi)localObject5).bty(z.bcZ());
                          ((aoi)localObject5).arz(2);
                          ((aoi)localObject5).Ue(paramMenuItem.getCreateTime() * 1000L);
                          ((aoi)localObject5).btC(paramMenuItem.getSnsId());
                          ((aoi)localObject5).btz((String)localObject8);
                          if ((localObject3 != null) && (((TimeLineObject)localObject3).AppInfo != null)) {
                            ((aoi)localObject5).btD(((TimeLineObject)localObject3).AppInfo.Id);
                          }
                          localObject6 = new anm();
                          ((anm)localObject6).bsP((String)localObject8);
                          ((anm)localObject6).bsE(((cvt)localObject7).Url);
                          ((anm)localObject6).bsF(((cvt)localObject7).TDI);
                          ((anm)localObject6).bsD(paramMenuItem.getTimeLine().ContentObj.Url);
                          i = 0;
                          paramInt = i;
                          if (localObject3 != null)
                          {
                            paramInt = i;
                            if (((TimeLineObject)localObject3).ContentObj.lVY != null)
                            {
                              paramInt = i;
                              if (u.agG(((TimeLineObject)localObject3).ContentObj.lVY.lVZ))
                              {
                                paramInt = 1;
                                ((anm)localObject6).bsM(((TimeLineObject)localObject3).ContentObj.lVY.lVZ);
                              }
                            }
                          }
                          localObject8 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject7).Id) + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject7);
                          if (u.agG((String)localObject8))
                          {
                            paramInt = 1;
                            ((anm)localObject6).bsM((String)localObject8);
                          }
                          if (paramInt == 0)
                          {
                            ((anm)localObject6).Ey(true);
                            ((anm)localObject6).bsG(((cvt)localObject7).TDF);
                            localObject8 = new aor();
                            ((aor)localObject8).btN(((cvt)localObject7).TDF);
                            ((aoc)localObject4).c((aor)localObject8);
                          }
                          ((anm)localObject6).btd(((cvt)localObject7).songAlbumUrl);
                          ((anm)localObject6).bte(((cvt)localObject7).songLyric);
                          ((anm)localObject6).arq(7);
                          ((anm)localObject6).bsx(((cvt)localObject7).fwr);
                          ((anm)localObject6).bsy(((cvt)localObject7).CMB);
                          ((anm)localObject6).Ex(true);
                          if ((localObject3 != null) && (((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.lVY != null))
                          {
                            localObject7 = new ann();
                            ((ann)localObject7).e(((TimeLineObject)localObject3).ContentObj.lVY);
                            ((anm)localObject6).a((ann)localObject7);
                          }
                          ((aoc)localObject4).syG.add(localObject6);
                          ((aoc)localObject4).a((aoi)localObject5);
                          ((dd)localObject1).fyI.fyK = ((aoc)localObject4);
                          ((dd)localObject1).fyI.type = 7;
                          com.tencent.mm.plugin.sns.l.a.a((anm)localObject6, paramMenuItem);
                        }
                      }
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                      paramMenuItem = aj.fOI().bbl(this.LoH);
                      if (this.LoI.ContentObj.Sqr.size() != 0)
                      {
                        localObject7 = (cvt)this.LoI.ContentObj.Sqr.get(0);
                        if ((paramMenuItem == null) || (localObject7 == null))
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject1 = new dd();
                        localObject8 = this.LoI;
                        localObject3 = this.LoI.ContentObj.lVY;
                        if ((localObject7 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                          break label1591;
                        }
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        ((dd)localObject1).fyI.fyO = i.j.favorite_fail_argument_error;
                      }
                      for (;;)
                      {
                        ((dd)localObject1).fyI.activity = this.activity;
                        ((dd)localObject1).fyI.fyP = 25;
                        EventCenter.instance.publish((IEvent)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                        if (aj.isInValid())
                        {
                          Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                          ((dd)localObject1).fyI.fyO = i.j.favorite_fail_system_error;
                        }
                        else
                        {
                          String str = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.t.Qu(paramMenuItem.field_snsId), ((cvt)localObject7).Id });
                          localObject4 = new aoc();
                          localObject5 = new aoi();
                          Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                          ((aoi)localObject5).btx(paramMenuItem.getUserName());
                          ((aoi)localObject5).bty(z.bcZ());
                          ((aoi)localObject5).arz(2);
                          ((aoi)localObject5).Ue(paramMenuItem.getCreateTime() * 1000L);
                          ((aoi)localObject5).btC(paramMenuItem.getSnsId());
                          ((aoi)localObject5).btz(str);
                          if ((localObject8 != null) && (((TimeLineObject)localObject8).AppInfo != null)) {
                            ((aoi)localObject5).btD(((TimeLineObject)localObject8).AppInfo.Id);
                          }
                          localObject6 = new anm();
                          ((anm)localObject6).bsP(str);
                          ((anm)localObject6).bsE(((cvt)localObject7).Url);
                          ((anm)localObject6).bsF(((cvt)localObject7).TDI);
                          ((anm)localObject6).bsD(paramMenuItem.getTimeLine().ContentObj.Url);
                          i = 0;
                          paramInt = i;
                          if (localObject8 != null)
                          {
                            paramInt = i;
                            if (((TimeLineObject)localObject8).ContentObj.lVY != null)
                            {
                              paramInt = i;
                              if (u.agG(((TimeLineObject)localObject8).ContentObj.lVY.lVZ))
                              {
                                paramInt = 1;
                                ((anm)localObject6).bsM(((TimeLineObject)localObject8).ContentObj.lVY.lVZ);
                              }
                            }
                          }
                          localObject8 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject7).Id) + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject7);
                          if (u.agG((String)localObject8))
                          {
                            paramInt = 1;
                            ((anm)localObject6).bsM((String)localObject8);
                          }
                          if (paramInt == 0)
                          {
                            ((anm)localObject6).Ey(true);
                            ((anm)localObject6).bsG(((cvt)localObject7).TDF);
                            localObject8 = new aor();
                            ((aor)localObject8).btN(((cvt)localObject7).TDF);
                            ((aoc)localObject4).c((aor)localObject8);
                          }
                          ((anm)localObject6).btd(((cvt)localObject7).songAlbumUrl);
                          ((anm)localObject6).bte(((cvt)localObject7).songLyric);
                          ((anm)localObject6).arq(29);
                          ((anm)localObject6).bsx(((cvt)localObject7).fwr);
                          ((anm)localObject6).bsy(((cvt)localObject7).CMB);
                          ((anm)localObject6).Ex(true);
                          if (localObject3 != null)
                          {
                            localObject7 = new ann();
                            ((ann)localObject7).e((dbr)localObject3);
                            ((anm)localObject6).a((ann)localObject7);
                          }
                          ((aoc)localObject4).syG.add(localObject6);
                          ((aoc)localObject4).a((aoi)localObject5);
                          ((dd)localObject1).fyI.fyK = ((aoc)localObject4);
                          ((dd)localObject1).fyI.type = 21;
                          com.tencent.mm.plugin.sns.l.a.a((anm)localObject6, paramMenuItem);
                        }
                      }
                      paramMenuItem = this.activity;
                      localObject3 = aj.fOI().bbl(this.LoH);
                      if (localObject3 != null)
                      {
                        localObject1 = new Intent();
                        if (((SnsInfo)localObject3).getTimeLine().ContentObj.Sqq != 1) {
                          break label2357;
                        }
                        paramInt = 0;
                        if ((this.LoG.getTag() instanceof av)) {
                          paramInt = ((be)this.LoG.getTag()).index;
                        }
                        localObject3 = an.c((SnsInfo)localObject3, paramInt);
                        if (localObject3 == null)
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject4 = ((cvt)localObject3).Id;
                        ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.k(aq.kD(aj.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.t.k((cvt)localObject3), paramMenuItem));
                        ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                      }
                      while (((((SnsInfo)localObject3).getTimeLine().ContentObj.Sqq != 4) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Sqq != 42) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Sqq != 15) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Sqq != 3)) || ((!((SnsInfo)localObject3).getTimeLine().ContentObj.Sqr.isEmpty()) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Sqr.get(0) != null)))
                      {
                        ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                        ((Intent)localObject1).putExtra("sns_local_id", this.LoH);
                        ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.by.c.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                      }
                      Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                      AppMethodBeat.o(100195);
                      return;
                      localObject1 = this.activity;
                      paramMenuItem = aj.fOI().bbl(this.LoH);
                      if (paramMenuItem == null)
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      if (paramMenuItem.isAd())
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      if ((paramMenuItem.getTimeLine() == null) || (paramMenuItem.getTimeLine().ContentObj == null) || (Util.isNullOrNil(paramMenuItem.getTimeLine().ContentObj.Sqr)))
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      localObject3 = (cvt)paramMenuItem.getTimeLine().ContentObj.Sqr.get(0);
                      if (localObject3 == null)
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      localObject4 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject3).Id);
                      paramMenuItem = "";
                      localObject5 = com.tencent.mm.plugin.sns.data.t.i((cvt)localObject3);
                      if (u.agG((String)localObject4 + (String)localObject5)) {
                        paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject3);
                      }
                      if (u.agG((String)localObject4 + com.tencent.mm.plugin.sns.data.t.o((cvt)localObject3))) {
                        paramMenuItem = (String)localObject4 + com.tencent.mm.plugin.sns.data.t.m((cvt)localObject3);
                      }
                      localObject3 = new Intent();
                      ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                      ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                      ((Intent)localObject3).putExtra("intent_localid", this.LoH);
                      ((Intent)localObject3).putExtra("intent_from_scene", this.source);
                      ((Intent)localObject3).putExtra("intent_ismute", true);
                      if ((localObject1 instanceof SnsTimeLineUI)) {
                        ((Intent)localObject3).putExtra("sns_video_scene", 1);
                      }
                      for (;;)
                      {
                        if (this.LoG != null)
                        {
                          paramMenuItem = new int[2];
                          this.LoG.getLocationInWindow(paramMenuItem);
                          paramInt = this.LoG.getWidth();
                          i = this.LoG.getHeight();
                          ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                          ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                          ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                          ((Intent)localObject3).putExtra("img_gallery_height", i);
                        }
                        paramMenuItem = this.activity;
                        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
                        com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                        com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        this.activity.overridePendingTransition(0, 0);
                        AppMethodBeat.o(100195);
                        return;
                        if ((localObject1 instanceof SnsCommentDetailUI)) {
                          ((Intent)localObject3).putExtra("sns_video_scene", 5);
                        } else if ((localObject1 instanceof SnsUploadUI)) {
                          ((Intent)localObject3).putExtra("sns_video_scene", 6);
                        }
                      }
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                      localObject1 = bm.bch(this.LoI.ContentObj.Url);
                      if (Util.isNullOrNil((String)localObject1))
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      paramMenuItem = new dd();
                      localObject3 = f.bbl(this.LoH);
                      if (localObject3 != null)
                      {
                        localObject4 = ad.Rp(((SnsInfo)localObject3).field_snsId);
                        localObject5 = ad.beh().I((String)localObject4, true);
                        ((ad.b)localObject5).k("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject3).field_snsId));
                        ((ad.b)localObject5).k("preUsername", ((SnsInfo)localObject3).field_userName);
                        ((ad.b)localObject5).k("preChatName", "");
                        ((ad.b)localObject5).k("url", localObject1);
                        ((ad.b)localObject5).k("preMsgIndex", Integer.valueOf(0));
                        ((ad.b)localObject5).k("sendAppMsgScene", Integer.valueOf(1));
                        ((ad.b)localObject5).k("adExtStr", ((SnsInfo)localObject3).getTimeLine().statExtStr);
                        paramMenuItem.fyI.sessionId = ((String)localObject4);
                      }
                      localObject4 = aj.fOI().bbl(this.LoH);
                      if ((localObject4 != null) && (this.LoI.ContentObj.Sqq == 18)) {
                        p.a(p.d.JGp, p.c.JGj, p.e.JGu, 0, (SnsInfo)localObject4, this.source);
                      }
                      if (!Util.isNullOrNil(this.LoI.canvasInfo))
                      {
                        bcv(((SnsInfo)localObject4).getLocalid());
                        AppMethodBeat.o(100195);
                        return;
                      }
                      if (((SnsInfo)localObject4).isAd())
                      {
                        i = this.source;
                        if (this.source != 0) {
                          break label3616;
                        }
                      }
                      for (paramInt = 1;; paramInt = 2)
                      {
                        localObject3 = new SnsAdClick(i, paramInt, ((SnsInfo)localObject3).field_snsId, 11, 0);
                        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject3, this.KPn, (SnsInfo)localObject4, 11);
                        com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject3);
                        com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, (String)localObject1, this.LoH);
                        paramMenuItem.fyI.activity = this.activity;
                        paramMenuItem.fyI.fyP = 28;
                        EventCenter.instance.publish(paramMenuItem);
                        long l;
                        if (paramMenuItem.fyJ.ret == 0)
                        {
                          l = Util.nowSecond();
                          if (!Util.isNullOrNil((String)localObject1))
                          {
                            Log.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
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
                            Log.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
                          }
                        }
                        com.tencent.mm.plugin.report.service.h.IzE.a(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                        AppMethodBeat.o(100195);
                        return;
                      }
                      this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                    } while (this.LoI == null);
                    paramMenuItem = new dd();
                    localObject5 = this.LoI;
                    if (localObject5 == null)
                    {
                      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                      paramMenuItem.fyI.fyO = i.j.favorite_fail_argument_error;
                    }
                    for (;;)
                    {
                      paramMenuItem.fyI.activity = this.activity;
                      paramMenuItem.fyI.fyP = 26;
                      EventCenter.instance.publish(paramMenuItem);
                      AppMethodBeat.o(100195);
                      return;
                      localObject2 = new aoc();
                      localObject3 = new aoi();
                      localObject4 = new aob();
                      ((aoi)localObject3).btx(((TimeLineObject)localObject5).UserName);
                      ((aoi)localObject3).bty(z.bcZ());
                      ((aoi)localObject3).arz(2);
                      ((aoi)localObject3).Ue(Util.nowMilliSecond());
                      if (((TimeLineObject)localObject5).AppInfo != null) {
                        ((aoi)localObject3).btD(((TimeLineObject)localObject5).AppInfo.Id);
                      }
                      if (((TimeLineObject)localObject5).ContentObj != null)
                      {
                        ((aob)localObject4).btq(((TimeLineObject)localObject5).ContentObj.fwr);
                        ((aob)localObject4).btr(((TimeLineObject)localObject5).ContentObj.CMB);
                        if ((((TimeLineObject)localObject5).ContentObj.Sqr != null) && (!((TimeLineObject)localObject5).ContentObj.Sqr.isEmpty()))
                        {
                          localObject5 = (cvt)((TimeLineObject)localObject5).ContentObj.Sqr.get(0);
                          ((aob)localObject4).arw(((cvt)localObject5).subType);
                          ((aob)localObject4).btt(((cvt)localObject5).KCT);
                          ((aob)localObject4).bts(((cvt)localObject5).TDF);
                        }
                      }
                      paramMenuItem.fyI.title = ((aob)localObject4).title;
                      paramMenuItem.fyI.desc = ((aob)localObject4).desc;
                      paramMenuItem.fyI.fyK = ((aoc)localObject2);
                      paramMenuItem.fyI.type = 10;
                      ((aoc)localObject2).a((aoi)localObject3);
                      ((aoc)localObject2).b((aob)localObject4);
                    }
                    paramMenuItem = this.LoI.weappInfo;
                    if ((this.LoI == null) || (paramMenuItem == null))
                    {
                      Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                      AppMethodBeat.o(100195);
                      return;
                    }
                    localObject5 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramMenuItem.username);
                    localObject3 = new ank();
                    ((ank)localObject3).username = paramMenuItem.username;
                    if (localObject5 != null) {
                      ((ank)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
                    }
                    ((ank)localObject3).fve = paramMenuItem.path;
                    ((ank)localObject3).fES = paramMenuItem.qbu;
                    ((ank)localObject3).version = paramMenuItem.version;
                    ((ank)localObject3).fXg = paramMenuItem.fXg;
                    ((ank)localObject3).subType = paramMenuItem.subType;
                    paramMenuItem = null;
                    localObject4 = new anm();
                    ((anm)localObject4).arq(19);
                    if (this.LoI.ContentObj != null)
                    {
                      paramMenuItem = this.LoI.ContentObj.fwr;
                      if ((this.LoI.ContentObj.Sqr != null) && (!this.LoI.ContentObj.Sqr.isEmpty()))
                      {
                        localObject2 = (cvt)this.LoI.ContentObj.Sqr.get(0);
                        localObject2 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject2).Id) + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject2);
                        ((anm)localObject4).bsL((String)localObject2);
                        ((anm)localObject4).bsM((String)localObject2);
                        localObject2 = paramMenuItem;
                        if (Util.isNullOrNil(paramMenuItem)) {
                          if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                            break label4505;
                          }
                        }
                      }
                    }
                    for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(i.j.appbrand_app_name))
                    {
                      ((anm)localObject4).bsx((String)localObject2);
                      ((anm)localObject4).bsy((String)localObject2);
                      ((anm)localObject4).bsK(com.tencent.mm.plugin.fav.a.b.dN(localObject4.toString(), 19));
                      localObject5 = new aoi();
                      ((aoi)localObject5).btx(z.bcZ());
                      ((aoi)localObject5).Ue(Util.nowMilliSecond());
                      ((aoi)localObject5).arz(2);
                      paramMenuItem = new aoc();
                      paramMenuItem.syG.add(localObject4);
                      paramMenuItem.c((ank)localObject3);
                      paramMenuItem.a((aoi)localObject5);
                      paramMenuItem.btv((String)localObject2);
                      localObject3 = new dd();
                      ((dd)localObject3).fyI.activity = this.activity;
                      ((dd)localObject3).fyI.title = ((String)localObject2);
                      ((dd)localObject3).fyI.desc = ((String)localObject2);
                      ((dd)localObject3).fyI.fyK = paramMenuItem;
                      ((dd)localObject3).fyI.type = 19;
                      EventCenter.instance.publish((IEvent)localObject3);
                      AppMethodBeat.o(100195);
                      return;
                      ((anm)localObject4).Ey(true);
                      break;
                      ((anm)localObject4).Ey(true);
                      break;
                    }
                    this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                  } while (this.LoI == null);
                  paramMenuItem = new dd();
                  localObject5 = this.LoI;
                  if (localObject5 == null)
                  {
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                    paramMenuItem.fyI.fyO = i.j.favorite_fail_argument_error;
                  }
                  for (;;)
                  {
                    paramMenuItem.fyI.activity = this.activity;
                    paramMenuItem.fyI.fyP = 27;
                    EventCenter.instance.publish(paramMenuItem);
                    AppMethodBeat.o(100195);
                    return;
                    localObject2 = new aoc();
                    localObject3 = new aoi();
                    localObject4 = new aol();
                    ((aoi)localObject3).btx(((TimeLineObject)localObject5).UserName);
                    ((aoi)localObject3).bty(z.bcZ());
                    ((aoi)localObject3).arz(8);
                    ((aoi)localObject3).Ue(Util.nowMilliSecond());
                    if (((TimeLineObject)localObject5).AppInfo != null) {
                      ((aoi)localObject3).btD(((TimeLineObject)localObject5).AppInfo.Id);
                    }
                    if (((TimeLineObject)localObject5).ContentObj != null)
                    {
                      ((aol)localObject4).btG(((TimeLineObject)localObject5).ContentObj.fwr);
                      ((aol)localObject4).btH(((TimeLineObject)localObject5).ContentObj.CMB);
                      if ((((TimeLineObject)localObject5).ContentObj.Sqr != null) && (!((TimeLineObject)localObject5).ContentObj.Sqr.isEmpty()))
                      {
                        localObject5 = (cvt)((TimeLineObject)localObject5).ContentObj.Sqr.get(0);
                        ((aol)localObject4).btJ(((cvt)localObject5).KCT);
                        ((aol)localObject4).btI(((cvt)localObject5).TDF);
                      }
                    }
                    paramMenuItem.fyI.title = ((aol)localObject4).title;
                    paramMenuItem.fyI.desc = ((aol)localObject4).desc;
                    paramMenuItem.fyI.fyK = ((aoc)localObject2);
                    paramMenuItem.fyI.type = 15;
                    ((aoc)localObject2).a((aoi)localObject3);
                    ((aoc)localObject2).b((aol)localObject4);
                  }
                  paramMenuItem = aj.fOI().bbl(this.LoH);
                  if (paramMenuItem == null)
                  {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  new f.a(this.activity).bBl(this.activity.getResources().getString(i.j.sns_comment_delete_alert_title)).bBp(this.activity.getResources().getString(i.j.app_delete)).ayq(this.activity.getResources().getColor(i.c.red_text_color)).b(new f.c()
                  {
                    public final void g(boolean paramAnonymousBoolean, final String paramAnonymousString)
                    {
                      int i = 0;
                      AppMethodBeat.i(266405);
                      paramAnonymousString = paramMenuItem.getSnsId();
                      Object localObject = (com.tencent.mm.plugin.sns.ui.m)b.a(b.this).getTag();
                      if (localObject != null)
                      {
                        if (!y.bbH(paramAnonymousString)) {
                          break label187;
                        }
                        paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(y.aYS(paramAnonymousString), 6, ((com.tencent.mm.plugin.sns.ui.m)localObject).JVu);
                        com.tencent.mm.kernel.h.aHH();
                        com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousString, 0);
                        b localb = b.this;
                        Activity localActivity = b.b(b.this);
                        b.b(b.this).getString(i.j.app_tip);
                        b.a(localb, com.tencent.mm.ui.base.h.a(localActivity, b.b(b.this).getString(i.j.sns_deling_sns), true, new DialogInterface.OnCancelListener()
                        {
                          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                          {
                            AppMethodBeat.i(270546);
                            com.tencent.mm.kernel.h.aHH();
                            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousString);
                            AppMethodBeat.o(270546);
                          }
                        }));
                        if (((com.tencent.mm.plugin.sns.ui.m)localObject).JVu == null) {
                          break label224;
                        }
                        i = ((com.tencent.mm.plugin.sns.ui.m)localObject).JVu.Uln;
                      }
                      label187:
                      label224:
                      for (paramAnonymousString = ((com.tencent.mm.plugin.sns.ui.m)localObject).JVu.Username;; paramAnonymousString = "")
                      {
                        localObject = com.tencent.mm.plugin.sns.k.g.Kia;
                        com.tencent.mm.plugin.sns.k.g.b(paramMenuItem, i, paramAnonymousString, 1);
                        AppMethodBeat.o(266405);
                        return;
                        paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(y.aYS(paramAnonymousString), 4, ((com.tencent.mm.plugin.sns.ui.m)localObject).JVu);
                        com.tencent.mm.kernel.h.aHH();
                        com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousString, 0);
                        break;
                      }
                    }
                  }).bBq(this.activity.getResources().getString(i.j.app_cancel)).a(new f.c()
                  {
                    public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
                    {
                      AppMethodBeat.i(202979);
                      paramAnonymousString = (com.tencent.mm.plugin.sns.ui.m)b.a(b.this).getTag();
                      int i = 0;
                      if ((paramAnonymousString != null) && (paramAnonymousString.JVu != null)) {
                        i = paramAnonymousString.JVu.Uln;
                      }
                      for (paramAnonymousString = paramAnonymousString.JVu.Username;; paramAnonymousString = "")
                      {
                        com.tencent.mm.plugin.sns.k.g localg = com.tencent.mm.plugin.sns.k.g.Kia;
                        com.tencent.mm.plugin.sns.k.g.b(paramMenuItem, i, paramAnonymousString, 2);
                        AppMethodBeat.o(202979);
                        return;
                      }
                    }
                  }).show();
                  AppMethodBeat.o(100195);
                  return;
                  paramMenuItem = aj.fOI().bbl(this.LoH);
                } while (paramMenuItem == null);
                com.tencent.mm.plugin.sns.abtest.a.b(paramMenuItem);
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
                ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.getUserName());
                ((Intent)localObject2).putExtra("sns_permission_anim", true);
                ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
                this.activity.startActivityForResult((Intent)localObject2, 11);
                AppMethodBeat.o(100195);
                return;
                this.KCs.fOn().kK(this.LoH, this.LoI.Id);
                paramMenuItem = f.bbl(this.LoH);
                if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
                {
                  localObject2 = aj.fOI().bbl(this.LoH);
                  if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()))
                  {
                    i = this.source;
                    if (this.source != 0) {
                      break label5246;
                    }
                  }
                  for (paramInt = 1;; paramInt = 2)
                  {
                    localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.KPn, paramMenuItem, 11);
                    com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject2);
                    bcv(this.LoH);
                    AppMethodBeat.o(100195);
                    return;
                  }
                }
                paramMenuItem = this.LoH;
                paramMenuItem = aj.fOI().bbl(paramMenuItem);
                if (paramMenuItem != null) {
                  if (paramMenuItem.isAd())
                  {
                    p.a(p.d.JGo, p.c.JGj, p.e.JGu, 0, paramMenuItem, this.source);
                    i = this.source;
                    if (this.source != 0) {
                      break label5396;
                    }
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.KPn, paramMenuItem, 11);
                  com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject2);
                  localObject2 = new dd();
                  com.tencent.mm.plugin.sns.l.a.a((dd)localObject2, paramMenuItem);
                  ((dd)localObject2).fyI.activity = this.activity;
                  ((dd)localObject2).fyI.fyP = 29;
                  EventCenter.instance.publish((IEvent)localObject2);
                  AppMethodBeat.o(100195);
                  return;
                }
                paramMenuItem = (cvt)this.LoI.ContentObj.Sqr.get(0);
                paramMenuItem = aq.kD(aj.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.t.d(paramMenuItem);
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject2).putExtra("select_is_ret", true);
                ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
                ((Intent)localObject2).putExtra("image_path", paramMenuItem);
                ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
                com.tencent.mm.by.c.d(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
                AppMethodBeat.o(100195);
                return;
              } while (!(this.LoG.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
              paramMenuItem = (com.tencent.mm.plugin.sns.ui.m)this.LoG.getTag();
              if (ClipboardHelper.setTextSwallowException(paramMenuItem.lpy))
              {
                com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(i.j.app_copy_ok));
                if (paramMenuItem.JVu != null)
                {
                  localObject2 = com.tencent.mm.plugin.secinforeport.a.a.Jcj;
                  com.tencent.mm.plugin.secinforeport.a.a.s(4, this.LoI.Id + ":" + paramMenuItem.JVu.Uln, Util.getUTF8ByteLength(paramMenuItem.lpy));
                  AppMethodBeat.o(100195);
                }
              }
              else
              {
                com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(i.j.app_copy_failed));
              }
              AppMethodBeat.o(100195);
              return;
              paramMenuItem = aj.fOI().bbl(this.LoH);
              com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
              AppMethodBeat.o(100195);
              return;
            } while (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.LoG.getContext()));
            localObject2 = aj.fOI().bbl(this.LoH);
            if (localObject2 != null) {
              if (this.source != 0) {
                break label5798;
              }
            }
            for (paramMenuItem = com.tencent.mm.modelsns.l.wO(714);; paramMenuItem = com.tencent.mm.modelsns.l.wP(714))
            {
              paramMenuItem.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).gx(((SnsInfo)localObject2).isAd()).Xf(((SnsInfo)localObject2).getUxinfo());
              paramMenuItem.bpa();
              at.F((SnsInfo)localObject2);
              AppMethodBeat.o(100195);
              return;
            }
          } while ((!(this.LoG.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) || (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.LoG.getContext())));
          localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.LoG.getTag();
          localObject3 = aj.fOI().bbk(((com.tencent.mm.plugin.sns.ui.m)localObject2).KCE);
          if (localObject3 != null)
          {
            if (this.source != 0) {
              break label5989;
            }
            paramMenuItem = com.tencent.mm.modelsns.l.wO(715);
            paramMenuItem.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject3)).wR(((SnsInfo)localObject3).field_type).gx(((SnsInfo)localObject3).isAd()).Xf(((SnsInfo)localObject3).getUxinfo());
            if (((com.tencent.mm.plugin.sns.ui.m)localObject2).JVu == null) {
              break label6025;
            }
            if (((com.tencent.mm.plugin.sns.ui.m)localObject2).JVu.Uln != 0) {
              break label5999;
            }
            localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).JVu.Ulp;
            paramMenuItem.Xf((String)localObject2);
          }
          for (;;)
          {
            paramMenuItem.bpa();
            at.a((com.tencent.mm.plugin.sns.ui.m)this.LoG.getTag());
            AppMethodBeat.o(100195);
            return;
            paramMenuItem = com.tencent.mm.modelsns.l.wP(715);
            break;
            localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).JVu.Uln;
            break label5957;
            paramMenuItem.Xf("");
          }
          this.KCs.fOn().kK(this.LoH, this.LoI.Id);
          paramMenuItem = f.bbl(this.LoH);
          if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
          {
            localObject2 = aj.fOI().bbl(this.LoH);
            if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()) && (this.LoI != null))
            {
              i = this.source;
              if (this.source != 0) {
                break label6183;
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.KPn, paramMenuItem, 11);
              com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject2);
              bcv(this.LoH);
              AppMethodBeat.o(100195);
              return;
            }
          }
          bcw(this.LoH);
          AppMethodBeat.o(100195);
          return;
          at.G(aj.fOI().bbl(this.LoH));
          AppMethodBeat.o(100195);
          return;
        } while (!(this.LoG.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
        at.b((com.tencent.mm.plugin.sns.ui.m)this.LoG.getTag());
        AppMethodBeat.o(100195);
        return;
        localObject2 = f.bbl(this.LoH);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
          AppMethodBeat.o(100195);
          return;
        }
        if ((this.LoG.getTag() == null) || (!(this.LoG.getTag() instanceof be)))
        {
          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
          AppMethodBeat.o(100195);
          return;
        }
        localObject3 = (be)this.LoG.getTag();
        localObject4 = this.activity;
        paramMenuItem = paramMenuItem.getIntent();
        if (this.source == 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          bd.a((Activity)localObject4, paramMenuItem, (SnsInfo)localObject2, (be)localObject3, paramInt, this.source, this.KCs);
          AppMethodBeat.o(100195);
          return;
        }
        if (this.LoI == null)
        {
          Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
          AppMethodBeat.o(100195);
          return;
        }
        paramMenuItem = new dd();
        com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, this.LoH);
        paramMenuItem.fyI.activity = this.activity;
        paramMenuItem.fyI.fyP = 28;
        EventCenter.instance.publish(paramMenuItem);
        AppMethodBeat.o(100195);
        return;
      } while ((this.LoI == null) || (this.LoI.ContentObj == null));
      ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).c(this.LoI.ContentObj.Sqw);
      com.tencent.mm.ui.base.h.cO(this.activity, this.activity.getString(i.j.favorite_ok));
      AppMethodBeat.o(100195);
      return;
    case 25: 
      if ((this.LoI != null) && (this.LoI.ContentObj != null) && (this.LoI.ContentObj.Sqq == 28))
      {
        paramMenuItem = new dd();
        localObject2 = this.LoI;
        if (localObject2 != null) {
          break label6627;
        }
        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
        paramMenuItem.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
      }
      for (;;)
      {
        paramMenuItem.fyI.activity = this.activity;
        EventCenter.instance.publish(paramMenuItem);
        AppMethodBeat.o(100195);
        return;
        localObject6 = String.format("%s", new Object[] { ((TimeLineObject)localObject2).Id });
        localObject3 = new aoc();
        localObject4 = new aoi();
        localObject5 = new anm();
        ((aoi)localObject4).btx(((TimeLineObject)localObject2).UserName);
        ((aoi)localObject4).bty(z.bcZ());
        ((aoi)localObject4).arz(2);
        ((aoi)localObject4).Ue(((TimeLineObject)localObject2).CreateTime * 1000L);
        ((aoi)localObject4).btC(((TimeLineObject)localObject2).Id);
        ((aoi)localObject4).btz((String)localObject6);
        ((anm)localObject5).bsP((String)localObject6);
        com.tencent.mm.plugin.sns.l.a.a((anm)localObject5, (TimeLineObject)localObject2);
        ((anm)localObject5).arq(20);
        if (((TimeLineObject)localObject2).ContentObj.lVY != null)
        {
          localObject6 = new ann();
          ((ann)localObject6).e(((TimeLineObject)localObject2).ContentObj.lVY);
          ((anm)localObject5).a((ann)localObject6);
        }
        ((aoc)localObject3).syG.add(localObject5);
        ((aoc)localObject3).a((aoi)localObject4);
        ((aoc)localObject3).d(((TimeLineObject)localObject2).ContentObj.fFJ);
        paramMenuItem.fyI.fyK = ((aoc)localObject3);
        paramMenuItem.fyI.type = 20;
      }
    case 26: 
      label2357:
      label5246:
      localObject2 = f.bbl(this.LoH);
      label3616:
      label5798:
      label5957:
      label5989:
      label5999:
      paramMenuItem = (be)this.LoG.getTag();
      label4505:
      label6183:
      label6627:
      localObject3 = ((SnsInfo)localObject2).getTimeLine();
      label5396:
      if (paramMenuItem.index < ((TimeLineObject)localObject3).ContentObj.Sqr.size())
      {
        paramMenuItem = (cvt)((TimeLineObject)localObject3).ContentObj.Sqr.get(paramMenuItem.index);
        localObject3 = new o();
        ((o)localObject3).context = this.activity;
        ((o)localObject3).fAh = (aq.kD(aj.getAccSnsPath(), paramMenuItem.Id) + com.tencent.mm.plugin.sns.data.t.k(paramMenuItem));
        ((o)localObject3).PxI = ((SnsInfo)localObject2).field_userName;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label7065;
        }
        ((o)localObject3).fyP = 10;
      }
      for (;;)
      {
        label6025:
        ((o)localObject3).JVq = paramMenuItem;
        ((o)localObject3).fLp = com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject2).field_snsId);
        ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch((o)localObject3);
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = new cvt();
        break;
        label7065:
        if ((this.activity instanceof SnsCommentDetailUI)) {
          ((o)localObject3).fyP = 7;
        }
      }
    }
    if (29 == paramMenuItem.getItemId())
    {
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.LoG.getTag();
      if (localObject2 == null) {
        break label7397;
      }
      localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).lpy;
    }
    for (;;)
    {
      label7120:
      if (Util.isNullOrNil((String)localObject2)) {
        localObject2 = this.LoI.ContentDesc;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.fts.a.d.Sx(77);
        localObject4 = new ag();
        ((ag)localObject4).sessionId = ((String)localObject3);
        ((ag)localObject4).context = this.activity;
        ((ag)localObject4).query = ((String)localObject2);
        ((ag)localObject4).scene = 77;
        ((ag)localObject4).PyA = true;
        ((ag)localObject4).PyB = true;
        ((ag)localObject4).PyC = true;
        ((ag)localObject4).PyD = 1;
        ((ag)localObject4).PyE = com.tencent.mm.ci.a.w(this.activity, i.c.white);
        ((ag)localObject4).PyF = true;
        ((ag)localObject4).fPy.put("chatSearch", "1");
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject4);
        paramInt = 0;
        if ((this.activity instanceof SnsCommentDetailUI)) {
          if (paramMenuItem.getItemId() != 29) {
            paramInt = 5;
          }
        }
        for (;;)
        {
          ar.a(2, (String)localObject3, 77, 0, "", "", com.tencent.mm.plugin.sns.data.t.Qu(f.bbl(this.LoH).field_snsId), 3, "", 0L, ((String)localObject2).length(), paramInt, "", "", -1);
          break;
          localObject2 = fYD();
          break label7120;
          paramInt = 7;
          continue;
          if ((this.activity instanceof SnsWsFoldDetailUI)) {
            paramInt = 6;
          } else if ((this.activity instanceof SnsTimeLineUI)) {
            if (paramMenuItem.getItemId() != 29) {
              paramInt = 5;
            } else {
              paramInt = 7;
            }
          }
        }
      }
      label7397:
      localObject2 = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(100198);
    Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.KCf != null) && (this.KCf.isShowing())) {
      this.KCf.dismiss();
    }
    long l2;
    long l1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.sns.model.s)) && ((((com.tencent.mm.plugin.sns.model.s)paramq).type == 4) || (((com.tencent.mm.plugin.sns.model.s)paramq).type == 6)))
    {
      w.w(this.activity, this.activity.getResources().getString(i.j.sns_toast_tip_comment_deleted), i.i.icons_filled_done);
      paramString = (com.tencent.mm.plugin.sns.model.s)paramq;
      if (paramString.JVu != null) {
        break label217;
      }
      paramString = "";
      if (!Util.isEqual(paramString, z.bcZ()))
      {
        paramInt1 = 9;
        if (((com.tencent.mm.plugin.sns.model.s)paramq).type == 6) {
          paramInt1 = 10;
        }
        l2 = ((com.tencent.mm.plugin.sns.model.s)paramq).JVt;
        paramString = aj.fON();
        paramq = (com.tencent.mm.plugin.sns.model.s)paramq;
        if (paramq.JVu != null) {
          break label228;
        }
        l1 = 0L;
      }
    }
    for (;;)
    {
      paramString = paramString.i(l2, l1, paramInt1);
      if (paramString != null)
      {
        paramString.fSx();
        aj.fON().update(paramString.systemRowid, paramString);
      }
      AppMethodBeat.o(100198);
      return;
      label217:
      paramString = paramString.JVu.Username;
      break;
      label228:
      if (paramq.type == 6) {
        l1 = paramq.JVu.Ulp;
      } else {
        l1 = paramq.JVu.Uln;
      }
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */