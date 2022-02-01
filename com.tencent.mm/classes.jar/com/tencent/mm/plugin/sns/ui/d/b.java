package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.a.wo.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sns.ad.g.o.c;
import com.tencent.mm.plugin.sns.ad.g.o.d;
import com.tencent.mm.plugin.sns.ad.g.o.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
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
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.ak.i, o.g
{
  protected com.tencent.mm.plugin.sns.ad.g.k EBv;
  com.tencent.mm.ui.base.q EoW;
  private ai Epj;
  View Fai;
  private String Faj;
  private TimeLineObject Fak;
  Activity activity;
  private int source;
  
  public b(Activity paramActivity, int paramInt, ai paramai)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.source = paramInt;
    this.Epj = paramai;
    AppMethodBeat.o(100192);
  }
  
  private void aRr(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = aj.faO().aQm(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if (((SnsInfo)localObject2).isAd())
    {
      localObject1 = ((SnsInfo)localObject2).getAdSnsInfo();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q((SnsInfo)localObject2);
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
      com.tencent.mm.ui.base.h.n(this.activity, 2131759219, 0);
      AppMethodBeat.o(100196);
      return;
    }
    String str1 = ad.JX(((SnsInfo)localObject2).field_snsId);
    String str2 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cz();
    wo localwo = new wo();
    localwo.ecC.ecF = paramString;
    localwo.ecC.ecG = ((cz)localObject2);
    localwo.ecC.url = str3;
    EventCenter.instance.publish(localwo);
    if (!localwo.ecD.dFE)
    {
      if (((cz)localObject2).dFZ.dGe == 0) {
        ((cz)localObject2).dFZ.dGe = 2131759217;
      }
      com.tencent.mm.ui.base.h.n(this.activity, ((cz)localObject2).dFZ.dGe, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((cz)localObject2).dFZ.sessionId = str1;
    ((cz)localObject2).dFZ.title = str2;
    ((cz)localObject2).dFZ.desc = ((String)localObject3);
    paramString = ((cz)localObject2).dFZ.dGb;
    if ((paramString != null) && (paramString.ppH != null) && (paramString.ppH.size() > 0) && (paramString.ppH.get(0) != null))
    {
      ((aml)paramString.ppH.get(0)).bgE((String)localObject1);
      if (Util.isNullOrNil(((aml)paramString.ppH.get(0)).title)) {
        ((aml)paramString.ppH.get(0)).bgf(((cz)localObject2).dFZ.title);
      }
      if (Util.isNullOrNil(((aml)paramString.ppH.get(0)).desc)) {
        ((aml)paramString.ppH.get(0)).bgg(((cz)localObject2).dFZ.desc);
      }
      localObject1 = new anh();
      ((anh)localObject1).bhf(localTimeLineObject.UserName);
      ((anh)localObject1).bhg(z.aTY());
      ((anh)localObject1).ajm(2);
      ((anh)localObject1).MA(Util.nowMilliSecond());
      paramString.a((anh)localObject1);
    }
    ((cz)localObject2).dFZ.activity = this.activity;
    ((cz)localObject2).dFZ.dGf = 28;
    EventCenter.instance.publish((IEvent)localObject2);
    AppMethodBeat.o(100196);
  }
  
  private String fkt()
  {
    AppMethodBeat.i(100193);
    if ((this.Fai != null) && ((this.Fai instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.Fai != null) && ((this.Fai.getTag() instanceof bg)) && (((bg)this.Fai.getTag()).fiA()))
    {
      Object localObject = au.aPp(aj.faO().aQm(this.Faj).getSnsId());
      if (localObject != null)
      {
        localObject = ((au.b)localObject).result;
        AppMethodBeat.o(100193);
        return localObject;
      }
    }
    AppMethodBeat.o(100193);
    return null;
  }
  
  private ADInfo g(SnsInfo paramSnsInfo)
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
    this.Fai = paramView;
    this.Faj = paramString;
    this.Fak = paramTimeLineObject;
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.g.k paramk)
  {
    this.EBv = paramk;
  }
  
  public final void ebz()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        SnsInfo localSnsInfo = aj.faO().aQm(this.Faj);
        Object localObject1 = (cnb)this.Fak.ContentObj.LoV.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + r.e((cnb)localObject1);
        paramIntent = Util.stringsToList(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localSnsInfo.isAd())
          {
            str3 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + r.j((cnb)localObject1);
            TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
            ADXml localADXml = localSnsInfo.getAdXml();
            eeq localeeq = new eeq();
            localeeq.LxJ = ((cnb)localObject1).ERX;
            localeeq.iyZ = ((cnb)localObject1).MsF;
            if (localTimeLineObject.ContentObj.LoU == 15)
            {
              localeeq.izf = g(localSnsInfo).uxInfo;
              localeeq.izg = localTimeLineObject.Id;
              localeeq.izb = localTimeLineObject.ContentDesc;
              if (!Util.isNullOrNil(((cnb)localObject1).MsI)) {
                break label549;
              }
              paramIntent = ((cnb)localObject1).Msz;
              label286:
              localeeq.ize = paramIntent;
              if ((localADXml != null) && (localADXml.attachShareLinkIsHidden == 0))
              {
                localeeq.izd = localADXml.attachShareLinkUrl;
                localeeq.izc = localADXml.attachShareLinkWording;
              }
              paramInt1 = r.aOx(str3);
              Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((cnb)localObject1).MsF, Integer.valueOf(((cnb)localObject1).ERX), Integer.valueOf(paramInt1) });
              com.tencent.mm.plugin.messenger.a.g.eir().a(this.activity, str1, str3, str2, 43, paramInt1, localeeq, localTimeLineObject.statExtStr, null);
              com.tencent.mm.plugin.messenger.a.g.eir().iF((String)localObject2, str1);
              paramInt2 = this.source;
              if (this.source != 0) {
                break label558;
              }
              paramInt1 = 1;
              label441:
              r.a(new SnsAdClick(paramInt2, paramInt1, localSnsInfo.field_snsId, 12, 0));
              boolean bool = ab.Eq(str1);
              localObject1 = o.d.DwM;
              if (!bool) {
                break label563;
              }
              paramIntent = o.c.DwJ;
              label482:
              localObject2 = o.e.DwS;
              if (!bool) {
                break label570;
              }
            }
            label549:
            label558:
            label563:
            label570:
            for (paramInt1 = v.Ie(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.ad.g.o.a((o.d)localObject1, paramIntent, (o.e)localObject2, paramInt1, localSnsInfo, this.source);
              AppMethodBeat.o(100197);
              return;
              localeeq.izf = localTimeLineObject.streamvideo.izf;
              localeeq.izg = localTimeLineObject.streamvideo.izg;
              break;
              paramIntent = ((cnb)localObject1).MsI;
              break label286;
              paramInt1 = 2;
              break label441;
              paramIntent = o.c.DwI;
              break label482;
            }
          }
          String str3 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + r.j((cnb)localObject1);
          paramInt1 = r.aOx(str3);
          Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((cnb)localObject1).MsF, Integer.valueOf(((cnb)localObject1).ERX), Integer.valueOf(paramInt1) });
          com.tencent.mm.plugin.messenger.a.g.eir().a(this.activity, str1, str3, str2, 43, paramInt1, this.Fak.statExtStr, null);
          com.tencent.mm.plugin.messenger.a.g.eir().iF((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this.activity, this.activity.getString(2131761619));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = aj.faO().aQm(this.Faj);
      if (paramIntent == null)
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.Faj });
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
      r.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(100197);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.Fai == null)
    {
      AppMethodBeat.o(100195);
      return;
    }
    int i;
    Object localObject3;
    label601:
    Object localObject4;
    label783:
    Object localObject5;
    Object localObject6;
    label1402:
    long l;
    label2078:
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
                  Object localObject1 = fkt();
                  paramMenuItem = (MenuItem)localObject1;
                  if (Util.isNullOrNil((String)localObject1)) {
                    paramMenuItem = this.Fak.ContentDesc;
                  }
                  ClipboardHelper.setText(paramMenuItem);
                  com.tencent.mm.ui.base.h.cD(this.activity, this.activity.getString(2131755773));
                  localObject1 = com.tencent.mm.plugin.secinforeport.a.a.CWD;
                  com.tencent.mm.plugin.secinforeport.a.a.q(2, this.Fak.Id, Util.getUTF8ByteLength(paramMenuItem));
                  AppMethodBeat.o(100195);
                  return;
                  localObject1 = fkt();
                  paramMenuItem = (MenuItem)localObject1;
                  if (Util.isNullOrNil((String)localObject1)) {
                    paramMenuItem = this.Fak.ContentDesc;
                  }
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                  localObject1 = new cz();
                  com.tencent.mm.plugin.sns.l.a.a((cz)localObject1, this.Faj, paramMenuItem);
                  ((cz)localObject1).dFZ.activity = this.activity;
                  ((cz)localObject1).dFZ.dGf = 30;
                  EventCenter.instance.publish((IEvent)localObject1);
                  AppMethodBeat.o(100195);
                  return;
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                  localObject1 = new cz();
                  paramMenuItem = f.aQm(this.Faj);
                  if ((paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
                  {
                    aRr(this.Faj);
                    if (paramMenuItem.isAd())
                    {
                      i = this.source;
                      if (this.source != 0) {
                        break label601;
                      }
                    }
                  }
                  for (paramInt = 1;; paramInt = 2)
                  {
                    localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, this.EBv, paramMenuItem, 11);
                    r.a((SnsAdClick)localObject1);
                    AppMethodBeat.o(100195);
                    return;
                    if (this.Fak.showFlag == 1)
                    {
                      com.tencent.mm.plugin.sns.l.a.a((cz)localObject1, this.Faj, 0);
                      ((cz)localObject1).dFZ.activity = this.activity;
                      ((cz)localObject1).dFZ.dGf = 31;
                      EventCenter.instance.publish((IEvent)localObject1);
                      break;
                    }
                    if (!(this.Fai.getTag() instanceof bc)) {
                      break;
                    }
                    localObject3 = (bc)this.Fai.getTag();
                    com.tencent.mm.plugin.sns.l.a.a((cz)localObject1, this.Faj, ((bc)localObject3).index);
                    ((cz)localObject1).dFZ.activity = this.activity;
                    ((cz)localObject1).dFZ.dGf = 31;
                    EventCenter.instance.publish((IEvent)localObject1);
                    break;
                  }
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                  paramMenuItem = aj.faO().aQm(this.Faj);
                  if (this.Fak.ContentObj.LoV.size() != 0)
                  {
                    localObject1 = (cnb)this.Fak.ContentObj.LoV.get(0);
                    if ((paramMenuItem == null) || (localObject1 == null))
                    {
                      Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                      AppMethodBeat.o(100195);
                      return;
                    }
                    localObject3 = new cz();
                    if ((localObject1 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                      break label783;
                    }
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                  }
                  for (((cz)localObject3).dFZ.dGe = 2131759209;; ((cz)localObject3).dFZ.dGe = 2131759227)
                  {
                    ((cz)localObject3).dFZ.activity = this.activity;
                    ((cz)localObject3).dFZ.dGf = 25;
                    EventCenter.instance.publish((IEvent)localObject3);
                    AppMethodBeat.o(100195);
                    return;
                    if (!aj.isInValid()) {
                      break;
                    }
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  }
                  Object localObject7 = String.format("%s#%s", new Object[] { r.Jb(paramMenuItem.field_snsId), ((cnb)localObject1).Id });
                  localObject4 = new anb();
                  localObject5 = new anh();
                  Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                  ((anh)localObject5).bhf(paramMenuItem.getUserName());
                  ((anh)localObject5).bhg(z.aTY());
                  ((anh)localObject5).ajm(2);
                  ((anh)localObject5).MA(paramMenuItem.getCreateTime() * 1000L);
                  ((anh)localObject5).bhk(paramMenuItem.getSnsId());
                  ((anh)localObject5).bhh((String)localObject7);
                  localObject6 = new aml();
                  ((aml)localObject6).bgx((String)localObject7);
                  ((aml)localObject6).bgm(((cnb)localObject1).Url);
                  ((aml)localObject6).bgn(((cnb)localObject1).MsC);
                  ((aml)localObject6).bgl(paramMenuItem.getTimeLine().ContentObj.Url);
                  localObject7 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject1).Id) + r.e((cnb)localObject1);
                  if (com.tencent.mm.vfs.s.YS((String)localObject7)) {
                    ((aml)localObject6).bgu((String)localObject7);
                  }
                  for (;;)
                  {
                    ((aml)localObject6).bgL(((cnb)localObject1).songAlbumUrl);
                    ((aml)localObject6).bgM(((cnb)localObject1).songLyric);
                    ((aml)localObject6).ajd(7);
                    ((aml)localObject6).bgf(((cnb)localObject1).Title);
                    ((aml)localObject6).bgg(((cnb)localObject1).Desc);
                    ((aml)localObject6).As(true);
                    ((anb)localObject4).ppH.add(localObject6);
                    ((anb)localObject4).a((anh)localObject5);
                    ((cz)localObject3).dFZ.dGb = ((anb)localObject4);
                    ((cz)localObject3).dFZ.type = 7;
                    com.tencent.mm.plugin.sns.l.a.a((aml)localObject6, paramMenuItem);
                    break;
                    ((aml)localObject6).At(true);
                    ((aml)localObject6).bgo(((cnb)localObject1).Msz);
                    localObject7 = new anq();
                    ((anq)localObject7).bhv(((cnb)localObject1).Msz);
                    ((anb)localObject4).b((anq)localObject7);
                  }
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                  paramMenuItem = aj.faO().aQm(this.Faj);
                  if (this.Fak.ContentObj.LoV.size() != 0)
                  {
                    localObject7 = (cnb)this.Fak.ContentObj.LoV.get(0);
                    if ((paramMenuItem == null) || (localObject7 == null))
                    {
                      Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                      AppMethodBeat.o(100195);
                      return;
                    }
                    localObject1 = new cz();
                    localObject3 = this.Fak.ContentObj.jfy;
                    if ((localObject7 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                      break label1402;
                    }
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                  }
                  for (((cz)localObject1).dFZ.dGe = 2131759209;; ((cz)localObject1).dFZ.dGe = 2131759227)
                  {
                    ((cz)localObject1).dFZ.activity = this.activity;
                    ((cz)localObject1).dFZ.dGf = 25;
                    EventCenter.instance.publish((IEvent)localObject1);
                    AppMethodBeat.o(100195);
                    return;
                    if (!aj.isInValid()) {
                      break;
                    }
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  }
                  Object localObject8 = String.format("%s#%s", new Object[] { r.Jb(paramMenuItem.field_snsId), ((cnb)localObject7).Id });
                  localObject4 = new anb();
                  localObject5 = new anh();
                  Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                  ((anh)localObject5).bhf(paramMenuItem.getUserName());
                  ((anh)localObject5).bhg(z.aTY());
                  ((anh)localObject5).ajm(2);
                  ((anh)localObject5).MA(paramMenuItem.getCreateTime() * 1000L);
                  ((anh)localObject5).bhk(paramMenuItem.getSnsId());
                  ((anh)localObject5).bhh((String)localObject8);
                  localObject6 = new aml();
                  ((aml)localObject6).bgx((String)localObject8);
                  ((aml)localObject6).bgm(((cnb)localObject7).Url);
                  ((aml)localObject6).bgn(((cnb)localObject7).MsC);
                  ((aml)localObject6).bgl(paramMenuItem.getTimeLine().ContentObj.Url);
                  localObject8 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject7).Id) + r.e((cnb)localObject7);
                  if (com.tencent.mm.vfs.s.YS((String)localObject8)) {
                    ((aml)localObject6).bgu((String)localObject8);
                  }
                  for (;;)
                  {
                    ((aml)localObject6).bgL(((cnb)localObject7).songAlbumUrl);
                    ((aml)localObject6).bgM(((cnb)localObject7).songLyric);
                    ((aml)localObject6).ajd(29);
                    ((aml)localObject6).bgf(((cnb)localObject7).Title);
                    ((aml)localObject6).bgg(((cnb)localObject7).Desc);
                    ((aml)localObject6).As(true);
                    if (localObject3 != null)
                    {
                      localObject7 = new amm();
                      ((amm)localObject7).e((css)localObject3);
                      ((aml)localObject6).a((amm)localObject7);
                    }
                    ((anb)localObject4).ppH.add(localObject6);
                    ((anb)localObject4).a((anh)localObject5);
                    ((cz)localObject1).dFZ.dGb = ((anb)localObject4);
                    ((cz)localObject1).dFZ.type = 21;
                    com.tencent.mm.plugin.sns.l.a.a((aml)localObject6, paramMenuItem);
                    break;
                    ((aml)localObject6).At(true);
                    ((aml)localObject6).bgo(((cnb)localObject7).Msz);
                    localObject8 = new anq();
                    ((anq)localObject8).bhv(((cnb)localObject7).Msz);
                    ((anb)localObject4).b((anq)localObject8);
                  }
                  paramMenuItem = this.activity;
                  localObject3 = aj.faO().aQm(this.Faj);
                  if (localObject3 != null)
                  {
                    localObject1 = new Intent();
                    if (((SnsInfo)localObject3).getTimeLine().ContentObj.LoU != 1) {
                      break label2078;
                    }
                    paramInt = 0;
                    if ((this.Fai.getTag() instanceof at)) {
                      paramInt = ((bc)this.Fai.getTag()).index;
                    }
                    localObject3 = an.b((SnsInfo)localObject3, paramInt);
                    if (localObject3 == null)
                    {
                      Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                      AppMethodBeat.o(100195);
                      return;
                    }
                    localObject4 = ((cnb)localObject3).Id;
                    ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.i(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), (String)localObject4) + r.l((cnb)localObject3), paramMenuItem));
                    ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                  }
                  while (((((SnsInfo)localObject3).getTimeLine().ContentObj.LoU != 4) && (((SnsInfo)localObject3).getTimeLine().ContentObj.LoU != 42) && (((SnsInfo)localObject3).getTimeLine().ContentObj.LoU != 15) && (((SnsInfo)localObject3).getTimeLine().ContentObj.LoU != 3)) || ((!((SnsInfo)localObject3).getTimeLine().ContentObj.LoV.isEmpty()) && (((SnsInfo)localObject3).getTimeLine().ContentObj.LoV.get(0) != null)))
                  {
                    ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                    ((Intent)localObject1).putExtra("sns_local_id", this.Faj);
                    ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.br.c.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                    AppMethodBeat.o(100195);
                    return;
                  }
                  Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                  AppMethodBeat.o(100195);
                  return;
                  localObject1 = this.activity;
                  paramMenuItem = aj.faO().aQm(this.Faj);
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
                  if ((paramMenuItem.getTimeLine() == null) || (paramMenuItem.getTimeLine().ContentObj == null) || (Util.isNullOrNil(paramMenuItem.getTimeLine().ContentObj.LoV)))
                  {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject3 = (cnb)paramMenuItem.getTimeLine().ContentObj.LoV.get(0);
                  if (localObject3 == null)
                  {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  localObject4 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject3).Id);
                  paramMenuItem = "";
                  localObject5 = r.j((cnb)localObject3);
                  if (com.tencent.mm.vfs.s.YS((String)localObject4 + (String)localObject5)) {
                    paramMenuItem = (String)localObject4 + r.e((cnb)localObject3);
                  }
                  if (com.tencent.mm.vfs.s.YS((String)localObject4 + r.p((cnb)localObject3))) {
                    paramMenuItem = (String)localObject4 + r.n((cnb)localObject3);
                  }
                  localObject3 = new Intent();
                  ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                  ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                  ((Intent)localObject3).putExtra("intent_localid", this.Faj);
                  ((Intent)localObject3).putExtra("intent_from_scene", this.source);
                  ((Intent)localObject3).putExtra("intent_ismute", true);
                  if ((localObject1 instanceof SnsTimeLineUI)) {
                    ((Intent)localObject3).putExtra("sns_video_scene", 1);
                  }
                  for (;;)
                  {
                    if (this.Fai != null)
                    {
                      paramMenuItem = new int[2];
                      this.Fai.getLocationInWindow(paramMenuItem);
                      paramInt = this.Fai.getWidth();
                      i = this.Fai.getHeight();
                      ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                      ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                      ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                      ((Intent)localObject3).putExtra("img_gallery_height", i);
                    }
                    paramMenuItem = this.activity;
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
                    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
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
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                  localObject1 = bk.aRg(this.Fak.ContentObj.Url);
                  if (Util.isNullOrNil((String)localObject1))
                  {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  paramMenuItem = new cz();
                  localObject3 = f.aQm(this.Faj);
                  if (localObject3 != null)
                  {
                    localObject4 = ad.JX(((SnsInfo)localObject3).field_snsId);
                    localObject5 = ad.aVe().G((String)localObject4, true);
                    ((ad.b)localObject5).l("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject3).field_snsId));
                    ((ad.b)localObject5).l("preUsername", ((SnsInfo)localObject3).field_userName);
                    ((ad.b)localObject5).l("preChatName", "");
                    ((ad.b)localObject5).l("url", localObject1);
                    ((ad.b)localObject5).l("preMsgIndex", Integer.valueOf(0));
                    ((ad.b)localObject5).l("sendAppMsgScene", Integer.valueOf(1));
                    ((ad.b)localObject5).l("adExtStr", ((SnsInfo)localObject3).getTimeLine().statExtStr);
                    paramMenuItem.dFZ.sessionId = ((String)localObject4);
                  }
                  localObject4 = aj.faO().aQm(this.Faj);
                  if ((localObject4 != null) && (this.Fak.ContentObj.LoU == 18)) {
                    com.tencent.mm.plugin.sns.ad.g.o.a(o.d.DwN, o.c.DwH, o.e.DwS, 0, (SnsInfo)localObject4, this.source);
                  }
                  if (!Util.isNullOrNil(this.Fak.canvasInfo))
                  {
                    aRr(((SnsInfo)localObject4).getLocalid());
                    AppMethodBeat.o(100195);
                    return;
                  }
                  if (((SnsInfo)localObject4).isAd())
                  {
                    i = this.source;
                    if (this.source != 0) {
                      break label3337;
                    }
                  }
                  for (paramInt = 1;; paramInt = 2)
                  {
                    localObject3 = new SnsAdClick(i, paramInt, ((SnsInfo)localObject3).field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject3, this.EBv, (SnsInfo)localObject4, 11);
                    r.a((SnsAdClick)localObject3);
                    com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, (String)localObject1, this.Faj);
                    paramMenuItem.dFZ.activity = this.activity;
                    paramMenuItem.dFZ.dGf = 28;
                    EventCenter.instance.publish(paramMenuItem);
                    if (paramMenuItem.dGa.ret == 0)
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
                    com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                    AppMethodBeat.o(100195);
                    return;
                  }
                  this.Epj.fat().kp(this.Faj, this.Fak.Id);
                } while (this.Fak == null);
                paramMenuItem = new cz();
                localObject5 = this.Fak;
                if (localObject5 == null)
                {
                  Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                  paramMenuItem.dFZ.dGe = 2131759209;
                }
                for (;;)
                {
                  paramMenuItem.dFZ.activity = this.activity;
                  paramMenuItem.dFZ.dGf = 26;
                  EventCenter.instance.publish(paramMenuItem);
                  AppMethodBeat.o(100195);
                  return;
                  localObject2 = new anb();
                  localObject3 = new anh();
                  localObject4 = new ana();
                  ((anh)localObject3).bhf(((TimeLineObject)localObject5).UserName);
                  ((anh)localObject3).bhg(z.aTY());
                  ((anh)localObject3).ajm(2);
                  ((anh)localObject3).MA(Util.nowMilliSecond());
                  if (((TimeLineObject)localObject5).AppInfo != null) {
                    ((anh)localObject3).bhl(((TimeLineObject)localObject5).AppInfo.Id);
                  }
                  if (((TimeLineObject)localObject5).ContentObj != null)
                  {
                    ((ana)localObject4).bgY(((TimeLineObject)localObject5).ContentObj.Title);
                    ((ana)localObject4).bgZ(((TimeLineObject)localObject5).ContentObj.Desc);
                    if ((((TimeLineObject)localObject5).ContentObj.LoV != null) && (!((TimeLineObject)localObject5).ContentObj.LoV.isEmpty()))
                    {
                      localObject5 = (cnb)((TimeLineObject)localObject5).ContentObj.LoV.get(0);
                      ((ana)localObject4).ajj(((cnb)localObject5).subType);
                      ((ana)localObject4).bhb(((cnb)localObject5).EpK);
                      ((ana)localObject4).bha(((cnb)localObject5).Msz);
                    }
                  }
                  paramMenuItem.dFZ.title = ((ana)localObject4).title;
                  paramMenuItem.dFZ.desc = ((ana)localObject4).desc;
                  paramMenuItem.dFZ.dGb = ((anb)localObject2);
                  paramMenuItem.dFZ.type = 10;
                  ((anb)localObject2).a((anh)localObject3);
                  ((anb)localObject2).b((ana)localObject4);
                }
                paramMenuItem = this.Fak.weappInfo;
                if ((this.Fak == null) || (paramMenuItem == null))
                {
                  Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                  AppMethodBeat.o(100195);
                  return;
                }
                localObject5 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramMenuItem.username);
                localObject3 = new amj();
                ((amj)localObject3).username = paramMenuItem.username;
                if (localObject5 != null) {
                  ((amj)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
                }
                ((amj)localObject3).dCx = paramMenuItem.path;
                ((amj)localObject3).dMe = paramMenuItem.nbf;
                ((amj)localObject3).version = paramMenuItem.version;
                ((amj)localObject3).eda = paramMenuItem.eda;
                ((amj)localObject3).subType = paramMenuItem.subType;
                paramMenuItem = null;
                localObject4 = new aml();
                ((aml)localObject4).ajd(19);
                if (this.Fak.ContentObj != null)
                {
                  paramMenuItem = this.Fak.ContentObj.Title;
                  if ((this.Fak.ContentObj.LoV != null) && (!this.Fak.ContentObj.LoV.isEmpty()))
                  {
                    localObject2 = (cnb)this.Fak.ContentObj.LoV.get(0);
                    localObject2 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject2).Id) + r.e((cnb)localObject2);
                    ((aml)localObject4).bgt((String)localObject2);
                    ((aml)localObject4).bgu((String)localObject2);
                    localObject2 = paramMenuItem;
                    if (Util.isNullOrNil(paramMenuItem)) {
                      if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                        break label4226;
                      }
                    }
                  }
                }
                for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(2131756040))
                {
                  ((aml)localObject4).bgf((String)localObject2);
                  ((aml)localObject4).bgg((String)localObject2);
                  ((aml)localObject4).bgs(com.tencent.mm.plugin.fav.a.b.ds(localObject4.toString(), 19));
                  localObject5 = new anh();
                  ((anh)localObject5).bhf(z.aTY());
                  ((anh)localObject5).MA(Util.nowMilliSecond());
                  ((anh)localObject5).ajm(2);
                  paramMenuItem = new anb();
                  paramMenuItem.ppH.add(localObject4);
                  paramMenuItem.c((amj)localObject3);
                  paramMenuItem.a((anh)localObject5);
                  paramMenuItem.bhd((String)localObject2);
                  localObject3 = new cz();
                  ((cz)localObject3).dFZ.activity = this.activity;
                  ((cz)localObject3).dFZ.title = ((String)localObject2);
                  ((cz)localObject3).dFZ.desc = ((String)localObject2);
                  ((cz)localObject3).dFZ.dGb = paramMenuItem;
                  ((cz)localObject3).dFZ.type = 19;
                  EventCenter.instance.publish((IEvent)localObject3);
                  AppMethodBeat.o(100195);
                  return;
                  ((aml)localObject4).At(true);
                  break;
                  ((aml)localObject4).At(true);
                  break;
                }
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
              } while (this.Fak == null);
              paramMenuItem = new cz();
              localObject5 = this.Fak;
              if (localObject5 == null)
              {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.dFZ.dGe = 2131759209;
              }
              for (;;)
              {
                paramMenuItem.dFZ.activity = this.activity;
                paramMenuItem.dFZ.dGf = 27;
                EventCenter.instance.publish(paramMenuItem);
                AppMethodBeat.o(100195);
                return;
                localObject2 = new anb();
                localObject3 = new anh();
                localObject4 = new ank();
                ((anh)localObject3).bhf(((TimeLineObject)localObject5).UserName);
                ((anh)localObject3).bhg(z.aTY());
                ((anh)localObject3).ajm(8);
                ((anh)localObject3).MA(Util.nowMilliSecond());
                if (((TimeLineObject)localObject5).AppInfo != null) {
                  ((anh)localObject3).bhl(((TimeLineObject)localObject5).AppInfo.Id);
                }
                if (((TimeLineObject)localObject5).ContentObj != null)
                {
                  ((ank)localObject4).bho(((TimeLineObject)localObject5).ContentObj.Title);
                  ((ank)localObject4).bhp(((TimeLineObject)localObject5).ContentObj.Desc);
                  if ((((TimeLineObject)localObject5).ContentObj.LoV != null) && (!((TimeLineObject)localObject5).ContentObj.LoV.isEmpty()))
                  {
                    localObject5 = (cnb)((TimeLineObject)localObject5).ContentObj.LoV.get(0);
                    ((ank)localObject4).bhr(((cnb)localObject5).EpK);
                    ((ank)localObject4).bhq(((cnb)localObject5).Msz);
                  }
                }
                paramMenuItem.dFZ.title = ((ank)localObject4).title;
                paramMenuItem.dFZ.desc = ((ank)localObject4).desc;
                paramMenuItem.dFZ.dGb = ((anb)localObject2);
                paramMenuItem.dFZ.type = 15;
                ((anb)localObject2).a((anh)localObject3);
                ((anb)localObject2).b((ank)localObject4);
              }
              paramMenuItem = aj.faO().aQm(this.Faj);
              if (paramMenuItem == null)
              {
                Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
                AppMethodBeat.o(100195);
                return;
              }
              new f.a(this.activity).bow(this.activity.getResources().getString(2131766016)).boA(this.activity.getResources().getString(2131755778)).apb(this.activity.getResources().getColor(2131100996)).b(new f.c()
              {
                public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  int i = 0;
                  AppMethodBeat.i(203952);
                  paramAnonymousString = paramMenuItem.getSnsId();
                  Object localObject = (m)b.this.Fai.getTag();
                  if (localObject != null)
                  {
                    if (!y.aQH(paramAnonymousString)) {
                      break label184;
                    }
                    paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(y.aOa(paramAnonymousString), 6, ((m)localObject).DIu);
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousString, 0);
                    b localb = b.this;
                    Activity localActivity = b.this.activity;
                    b.this.activity.getString(2131755998);
                    localb.EoW = com.tencent.mm.ui.base.h.a(localActivity, b.this.activity.getString(2131766022), true, new b.2.1(this, paramAnonymousString));
                    if (((m)localObject).DIu == null) {
                      break label221;
                    }
                    i = ((m)localObject).DIu.MYT;
                  }
                  label184:
                  label221:
                  for (paramAnonymousString = ((m)localObject).DIu.Username;; paramAnonymousString = "")
                  {
                    localObject = e.DUQ;
                    e.b(paramMenuItem, i, paramAnonymousString, 1);
                    AppMethodBeat.o(203952);
                    return;
                    paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(y.aOa(paramAnonymousString), 4, ((m)localObject).DIu);
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousString, 0);
                    break;
                  }
                }
              }).boB(this.activity.getResources().getString(2131755761)).a(new f.c()
              {
                public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(203950);
                  paramAnonymousString = (m)b.this.Fai.getTag();
                  int i = 0;
                  if ((paramAnonymousString != null) && (paramAnonymousString.DIu != null)) {
                    i = paramAnonymousString.DIu.MYT;
                  }
                  for (paramAnonymousString = paramAnonymousString.DIu.Username;; paramAnonymousString = "")
                  {
                    e locale = e.DUQ;
                    e.b(paramMenuItem, i, paramAnonymousString, 2);
                    AppMethodBeat.o(203950);
                    return;
                  }
                }
              }).show();
              AppMethodBeat.o(100195);
              return;
              paramMenuItem = aj.faO().aQm(this.Faj);
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
            this.Epj.fat().kp(this.Faj, this.Fak.Id);
            paramMenuItem = f.aQm(this.Faj);
            if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
            {
              localObject2 = aj.faO().aQm(this.Faj);
              if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()))
              {
                i = this.source;
                if (this.source != 0) {
                  break label4967;
                }
              }
              for (paramInt = 1;; paramInt = 2)
              {
                localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.EBv, paramMenuItem, 11);
                r.a((SnsAdClick)localObject2);
                aRr(this.Faj);
                AppMethodBeat.o(100195);
                return;
              }
            }
            paramMenuItem = this.Faj;
            paramMenuItem = aj.faO().aQm(paramMenuItem);
            if (paramMenuItem != null) {
              if (paramMenuItem.isAd())
              {
                com.tencent.mm.plugin.sns.ad.g.o.a(o.d.DwM, o.c.DwH, o.e.DwS, 0, paramMenuItem, this.source);
                i = this.source;
                if (this.source != 0) {
                  break label5117;
                }
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.EBv, paramMenuItem, 11);
              r.a((SnsAdClick)localObject2);
              localObject2 = new cz();
              com.tencent.mm.plugin.sns.l.a.a((cz)localObject2, paramMenuItem);
              ((cz)localObject2).dFZ.activity = this.activity;
              ((cz)localObject2).dFZ.dGf = 29;
              EventCenter.instance.publish((IEvent)localObject2);
              AppMethodBeat.o(100195);
              return;
            }
            paramMenuItem = (cnb)this.Fak.ContentObj.LoV.get(0);
            paramMenuItem = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramMenuItem.Id) + r.e(paramMenuItem);
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
            ((Intent)localObject2).putExtra("select_is_ret", true);
            ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
            ((Intent)localObject2).putExtra("image_path", paramMenuItem);
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
            com.tencent.mm.br.c.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
            AppMethodBeat.o(100195);
            return;
          } while (!(this.Fai.getTag() instanceof m));
          paramMenuItem = (m)this.Fai.getTag();
          ClipboardHelper.setText(paramMenuItem.iAc);
          com.tencent.mm.ui.base.h.cD(this.activity, this.activity.getString(2131755773));
          if (paramMenuItem.DIu != null)
          {
            localObject2 = com.tencent.mm.plugin.secinforeport.a.a.CWD;
            com.tencent.mm.plugin.secinforeport.a.a.q(4, this.Fak.Id + ":" + paramMenuItem.DIu.MYT, Util.getUTF8ByteLength(paramMenuItem.iAc));
          }
          AppMethodBeat.o(100195);
          return;
          paramMenuItem = aj.faO().aQm(this.Faj);
          com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
          AppMethodBeat.o(100195);
          return;
        } while (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.Fai.getContext()));
        localObject2 = aj.faO().aQm(this.Faj);
        if (localObject2 != null) {
          if (this.source != 0) {
            break label5491;
          }
        }
        for (paramMenuItem = com.tencent.mm.modelsns.k.tO(714);; paramMenuItem = com.tencent.mm.modelsns.k.tP(714))
        {
          paramMenuItem.PH(r.v((SnsInfo)localObject2)).tR(((SnsInfo)localObject2).field_type).fL(((SnsInfo)localObject2).isAd()).PH(((SnsInfo)localObject2).getUxinfo());
          paramMenuItem.bfK();
          au.E((SnsInfo)localObject2);
          AppMethodBeat.o(100195);
          return;
        }
      } while ((!(this.Fai.getTag() instanceof m)) || (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.Fai.getContext())));
      localObject2 = (m)this.Fai.getTag();
      localObject3 = aj.faO().aQl(((m)localObject2).Epv);
      if (localObject3 != null)
      {
        if (this.source != 0) {
          break label5682;
        }
        paramMenuItem = com.tencent.mm.modelsns.k.tO(715);
        paramMenuItem.PH(r.v((SnsInfo)localObject3)).tR(((SnsInfo)localObject3).field_type).fL(((SnsInfo)localObject3).isAd()).PH(((SnsInfo)localObject3).getUxinfo());
        if (((m)localObject2).DIu == null) {
          break label5718;
        }
        if (((m)localObject2).DIu.MYT != 0) {
          break label5692;
        }
        localObject2 = ((m)localObject2).DIu.MYV;
        paramMenuItem.PH((String)localObject2);
      }
      for (;;)
      {
        paramMenuItem.bfK();
        au.a((m)this.Fai.getTag());
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = com.tencent.mm.modelsns.k.tP(715);
        break;
        localObject2 = ((m)localObject2).DIu.MYT;
        break label5650;
        paramMenuItem.PH("");
      }
    case 20: 
      label3337:
      label4967:
      label5117:
      this.Epj.fat().kp(this.Faj, this.Fak.Id);
      label4226:
      label5491:
      paramMenuItem = f.aQm(this.Faj);
      label5650:
      label5682:
      label5692:
      label5718:
      if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
      {
        localObject2 = aj.faO().aQm(this.Faj);
        if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()) && (this.Fak != null))
        {
          i = this.source;
          if (this.source != 0) {
            break label5876;
          }
        }
        label5876:
        for (paramInt = 1;; paramInt = 2)
        {
          localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, this.EBv, paramMenuItem, 11);
          r.a((SnsAdClick)localObject2);
          aRr(this.Faj);
          AppMethodBeat.o(100195);
          return;
        }
      }
      paramMenuItem = this.Faj;
      localObject3 = aj.faO().aQm(paramMenuItem);
      localObject2 = null;
      paramMenuItem = (MenuItem)localObject2;
      if (localObject3 != null)
      {
        paramMenuItem = (MenuItem)localObject2;
        if (((SnsInfo)localObject3).isAd())
        {
          localObject2 = ((SnsInfo)localObject3).getAdInfoLink();
          paramMenuItem = (MenuItem)localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            paramMenuItem = ((SnsInfo)localObject3).getAdLink();
          }
        }
      }
      if (Util.isNullOrNil(paramMenuItem)) {
        paramMenuItem = bk.aRg(this.Fak.ContentObj.Url);
      }
      break;
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramMenuItem))
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(100195);
        return;
      }
      localObject2 = new cz();
      localObject4 = f.aQm(this.Faj);
      if (localObject4 != null)
      {
        localObject5 = ad.JX(((SnsInfo)localObject4).field_snsId);
        localObject6 = ad.aVe().G((String)localObject5, true);
        ((ad.b)localObject6).l("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject4).field_snsId));
        ((ad.b)localObject6).l("preUsername", ((SnsInfo)localObject4).field_userName);
        ((ad.b)localObject6).l("preChatName", "");
        ((ad.b)localObject6).l("url", paramMenuItem);
        ((ad.b)localObject6).l("preMsgIndex", Integer.valueOf(0));
        ((ad.b)localObject6).l("sendAppMsgScene", Integer.valueOf(1));
        ((ad.b)localObject6).l("adExtStr", ((SnsInfo)localObject4).getTimeLine().statExtStr);
        ((cz)localObject2).dFZ.sessionId = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.Fak.ContentObj.LoU == 18) || (((SnsInfo)localObject3).isAd())))
      {
        com.tencent.mm.plugin.sns.ad.g.o.a(o.d.DwN, o.c.DwH, o.e.DwS, 0, (SnsInfo)localObject3, this.source);
        if (this.Fak != null)
        {
          i = this.source;
          if (this.source != 0) {
            break label6297;
          }
        }
      }
      label6297:
      for (paramInt = 1;; paramInt = 2)
      {
        localObject4 = new SnsAdClick(i, paramInt, ((SnsInfo)localObject4).field_snsId, 11, 0);
        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, this.EBv, (SnsInfo)localObject3, 11);
        r.a((SnsAdClick)localObject4);
        if (Util.isNullOrNil(this.Fak.canvasInfo)) {
          break;
        }
        aRr(((SnsInfo)localObject3).getLocalid());
        AppMethodBeat.o(100195);
        return;
      }
      com.tencent.mm.plugin.sns.l.a.a((cz)localObject2, paramMenuItem, this.Faj);
      ((cz)localObject2).dFZ.activity = this.activity;
      ((cz)localObject2).dFZ.dGf = 28;
      EventCenter.instance.publish((IEvent)localObject2);
      if (((cz)localObject2).dGa.ret == 0)
      {
        l = Util.nowSecond();
        if (!Util.isNullOrNil(paramMenuItem))
        {
          Log.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
          localObject2 = "";
        }
      }
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.h.CyF.a(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(100195);
        return;
      }
      catch (UnsupportedEncodingException paramMenuItem)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
          paramMenuItem = (MenuItem)localObject2;
        }
      }
      au.F(aj.faO().aQm(this.Faj));
      AppMethodBeat.o(100195);
      return;
      if (!(this.Fai.getTag() instanceof m)) {
        break;
      }
      au.b((m)this.Fai.getTag());
      AppMethodBeat.o(100195);
      return;
      localObject2 = f.aQm(this.Faj);
      if (localObject2 == null)
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        AppMethodBeat.o(100195);
        return;
      }
      if ((this.Fai.getTag() == null) || (!(this.Fai.getTag() instanceof bc)))
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
        AppMethodBeat.o(100195);
        return;
      }
      localObject3 = (bc)this.Fai.getTag();
      localObject4 = this.activity;
      paramMenuItem = paramMenuItem.getIntent();
      if (this.source == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        bb.a((Activity)localObject4, paramMenuItem, (SnsInfo)localObject2, (bc)localObject3, paramInt, this.source, this.Epj);
        AppMethodBeat.o(100195);
        return;
      }
      if (this.Fak == null)
      {
        Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        AppMethodBeat.o(100195);
        return;
      }
      paramMenuItem = new cz();
      com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, this.Faj);
      paramMenuItem.dFZ.activity = this.activity;
      paramMenuItem.dFZ.dGf = 28;
      EventCenter.instance.publish(paramMenuItem);
      AppMethodBeat.o(100195);
      return;
      if ((this.Fak == null) || (this.Fak.ContentObj == null)) {
        break;
      }
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).c(this.Fak.ContentObj.Lpa);
      com.tencent.mm.ui.base.h.cD(this.activity, this.activity.getString(2131759260));
      AppMethodBeat.o(100195);
      return;
      if ((this.Fak != null) && (this.Fak.ContentObj != null) && (this.Fak.ContentObj.LoU == 28))
      {
        paramMenuItem = new cz();
        com.tencent.mm.plugin.sns.l.a.a(paramMenuItem, this.Fak);
        paramMenuItem.dFZ.activity = this.activity;
        EventCenter.instance.publish(paramMenuItem);
      }
      AppMethodBeat.o(100195);
      return;
      localObject2 = f.aQm(this.Faj);
      paramMenuItem = (bc)this.Fai.getTag();
      localObject3 = ((SnsInfo)localObject2).getTimeLine();
      if (paramMenuItem.index < ((TimeLineObject)localObject3).ContentObj.LoV.size())
      {
        paramMenuItem = (cnb)((TimeLineObject)localObject3).ContentObj.LoV.get(paramMenuItem.index);
        localObject3 = new com.tencent.mm.plugin.websearch.api.o();
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).context = this.activity;
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).dHq = (com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramMenuItem.Id) + r.l(paramMenuItem));
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).IDs = ((SnsInfo)localObject2).field_userName;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label7108;
        }
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).dGf = 10;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).DIq = paramMenuItem;
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).dRS = r.Jb(((SnsInfo)localObject2).field_snsId);
        ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch((com.tencent.mm.plugin.websearch.api.o)localObject3);
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = new cnb();
        break;
        label7108:
        if ((this.activity instanceof SnsCommentDetailUI)) {
          ((com.tencent.mm.plugin.websearch.api.o)localObject3).dGf = 7;
        }
      }
      paramMenuItem = fkt();
      if (Util.isNullOrNil(paramMenuItem)) {
        paramMenuItem = this.Fak.ContentDesc;
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.fts.a.d.Nj(77);
        localObject3 = new ag();
        ((ag)localObject3).sessionId = ((String)localObject2);
        ((ag)localObject3).context = this.activity;
        ((ag)localObject3).query = paramMenuItem;
        ((ag)localObject3).scene = 77;
        ((ag)localObject3).IEk = true;
        ((ag)localObject3).IEl = true;
        ((ag)localObject3).IEm = true;
        ((ag)localObject3).IEn = 1;
        ((ag)localObject3).statusBarColor = com.tencent.mm.cb.a.n(this.activity, 2131101424);
        ((ag)localObject3).IEo = true;
        ((ag)localObject3).dVU.put("chatSearch", "1");
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class)).a((ag)localObject3);
        if ((this.activity instanceof SnsTimeLineUI)) {}
        for (paramInt = 3;; paramInt = 5)
        {
          com.tencent.mm.plugin.websearch.api.ar.a(2, (String)localObject2, 77, 0, "", "", r.Jb(f.aQm(this.Faj).field_snsId), paramInt, "", 0L, paramMenuItem.length());
          break;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(100198);
    Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.EoW != null) && (this.EoW.isShowing())) {
      this.EoW.dismiss();
    }
    long l2;
    long l1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.sns.model.s)) && ((((com.tencent.mm.plugin.sns.model.s)paramq).type == 4) || (((com.tencent.mm.plugin.sns.model.s)paramq).type == 6)))
    {
      u.u(this.activity, this.activity.getResources().getString(2131766279), 2131690537);
      paramString = (com.tencent.mm.plugin.sns.model.s)paramq;
      if (paramString.DIu != null) {
        break label217;
      }
      paramString = "";
      if (!Util.isEqual(paramString, z.aTY()))
      {
        paramInt1 = 9;
        if (((com.tencent.mm.plugin.sns.model.s)paramq).type == 6) {
          paramInt1 = 10;
        }
        l2 = ((com.tencent.mm.plugin.sns.model.s)paramq).DIt;
        paramString = aj.faT();
        paramq = (com.tencent.mm.plugin.sns.model.s)paramq;
        if (paramq.DIu != null) {
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
        paramString.feD();
        aj.faT().update(paramString.systemRowid, paramString);
      }
      AppMethodBeat.o(100198);
      return;
      label217:
      paramString = paramString.DIu.Username;
      break;
      label228:
      if (paramq.type == 6) {
        l1 = paramq.DIu.MYV;
      } else {
        l1 = paramq.DIu.MYT;
      }
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */