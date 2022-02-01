package com.tencent.mm.plugin.sns.ui.listener;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.zn;
import com.tencent.mm.autogen.a.zn.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sns.ad.g.p.c;
import com.tencent.mm.plugin.sns.ad.g.p.d;
import com.tencent.mm.plugin.sns.ad.g.p.e;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.statistics.e;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.mm.am.h, u.i
{
  private View RPL;
  private String RPM;
  private TimeLineObject RPN;
  private com.tencent.mm.ui.base.w RbN;
  private ak Rca;
  protected com.tencent.mm.plugin.sns.ad.g.l RoZ;
  private Activity activity;
  private int source;
  
  public b(Activity paramActivity, int paramInt, ak paramak)
  {
    AppMethodBeat.i(100192);
    this.activity = paramActivity;
    this.source = paramInt;
    this.Rca = paramak;
    AppMethodBeat.o(100192);
  }
  
  private void bbc(String paramString)
  {
    AppMethodBeat.i(100196);
    Object localObject2 = al.hgB().aZL(paramString);
    if (localObject2 == null)
    {
      AppMethodBeat.o(100196);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if (((SnsInfo)localObject2).isAd())
    {
      localObject1 = ((SnsInfo)localObject2).getAdSnsInfo();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T((SnsInfo)localObject2);
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
      k.s(this.activity, b.j.favorite_fail_parse_error, 0);
      AppMethodBeat.o(100196);
      return;
    }
    String str1 = ad.Jo(((SnsInfo)localObject2).field_snsId);
    String str2 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = Util.nullAs((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new dn();
    zn localzn = new zn();
    localzn.icF.icI = paramString;
    localzn.icF.icJ = ((dn)localObject2);
    localzn.icF.url = str3;
    localzn.publish();
    if (!localzn.icG.hCQ)
    {
      if (((dn)localObject2).hDr.hDx == 0) {
        ((dn)localObject2).hDr.hDx = b.j.favorite_fail_nonsupport;
      }
      k.s(this.activity, ((dn)localObject2).hDr.hDx, 0);
      AppMethodBeat.o(100196);
      return;
    }
    ((dn)localObject2).hDr.sessionId = str1;
    ((dn)localObject2).hDr.title = str2;
    ((dn)localObject2).hDr.desc = ((String)localObject3);
    paramString = ((dn)localObject2).hDr.hDt;
    if ((paramString != null) && (paramString.vEn != null) && (paramString.vEn.size() > 0) && (paramString.vEn.get(0) != null))
    {
      ((arf)paramString.vEn.get(0)).bsN((String)localObject1);
      if (Util.isNullOrNil(((arf)paramString.vEn.get(0)).title)) {
        ((arf)paramString.vEn.get(0)).bso(((dn)localObject2).hDr.title);
      }
      if (Util.isNullOrNil(((arf)paramString.vEn.get(0)).desc)) {
        ((arf)paramString.vEn.get(0)).bsp(((dn)localObject2).hDr.desc);
      }
      localObject1 = new asb();
      ((asb)localObject1).bto(localTimeLineObject.UserName);
      ((asb)localObject1).btp(z.bAM());
      ((asb)localObject1).axH(2);
      ((asb)localObject1).yu(Util.nowMilliSecond());
      paramString.a((asb)localObject1);
    }
    ((dn)localObject2).hDr.activity = this.activity;
    ((dn)localObject2).hDr.hDy = 28;
    ((dn)localObject2).publish();
    AppMethodBeat.o(100196);
  }
  
  private void bbd(String paramString)
  {
    AppMethodBeat.i(308529);
    SnsInfo localSnsInfo = al.hgB().aZL(paramString);
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
      paramString = bn.baN(this.RPN.ContentObj.Url);
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString))
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        AppMethodBeat.o(308529);
        return;
      }
      localObject1 = new dn();
      Object localObject2 = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
      if (localObject2 != null)
      {
        String str = ad.Jo(((SnsInfo)localObject2).field_snsId);
        ad.b localb = ad.bCb().M(str, true);
        localb.q("prePublishId", "sns_" + t.uA(((SnsInfo)localObject2).field_snsId));
        localb.q("preUsername", ((SnsInfo)localObject2).field_userName);
        localb.q("preChatName", "");
        localb.q("url", paramString);
        localb.q("preMsgIndex", Integer.valueOf(0));
        localb.q("sendAppMsgScene", Integer.valueOf(1));
        localb.q("adExtStr", ((SnsInfo)localObject2).getTimeLine().statExtStr);
        ((dn)localObject1).hDr.sessionId = str;
      }
      int j;
      if ((localSnsInfo != null) && ((this.RPN.ContentObj.Zpq == 18) || (localSnsInfo.isAd())))
      {
        com.tencent.mm.plugin.sns.ad.g.p.a(p.d.PXp, p.c.PXj, p.e.PXu, 0, localSnsInfo, this.source);
        if (this.RPN != null)
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
        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.RoZ, localSnsInfo, 11);
        t.a((SnsAdClick)localObject2);
        if (Util.isNullOrNil(this.RPN.canvasInfo)) {
          break;
        }
        bbc(localSnsInfo.getLocalid());
        AppMethodBeat.o(308529);
        return;
      }
      com.tencent.mm.plugin.sns.n.a.a((dn)localObject1, paramString, this.RPM);
      ((dn)localObject1).hDr.activity = this.activity;
      ((dn)localObject1).hDr.hDy = 28;
      ((dn)localObject1).publish();
      long l;
      if (((dn)localObject1).hDs.ret == 0)
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
        com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramString, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        AppMethodBeat.o(308529);
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
  
  private String hri()
  {
    AppMethodBeat.i(100193);
    if ((this.RPL != null) && ((this.RPL instanceof SnsPostDescPreloadTextView)))
    {
      AppMethodBeat.o(100193);
      return null;
    }
    if ((this.RPL != null) && ((this.RPL.getTag() instanceof bj)) && (((bj)this.RPL.getTag()).hph()))
    {
      Object localObject = av.aYE(al.hgB().aZL(this.RPM).getSnsId());
      if (localObject != null)
      {
        localObject = ((av.b)localObject).result;
        AppMethodBeat.o(100193);
        return localObject;
      }
    }
    AppMethodBeat.o(100193);
    return null;
  }
  
  private ADInfo j(SnsInfo paramSnsInfo)
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
    this.RPL = paramView;
    this.RPM = paramString;
    this.RPN = paramTimeLineObject;
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    this.RoZ = paraml;
  }
  
  public final void fSy()
  {
    AppMethodBeat.i(100190);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(218, this);
    AppMethodBeat.o(100190);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(100197);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 15)
      {
        SnsInfo localSnsInfo = al.hgB().aZL(this.RPM);
        Object localObject1 = (dmz)this.RPN.ContentObj.Zpr.get(0);
        String str1 = paramIntent.getStringExtra("Select_Conv_User");
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        String str2 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id) + t.d((dmz)localObject1);
        paramIntent = Util.stringsToList(str1.split(",")).iterator();
        while (paramIntent.hasNext())
        {
          str1 = (String)paramIntent.next();
          if (localSnsInfo.isAd())
          {
            str3 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id) + t.i((dmz)localObject1);
            TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
            ADXml localADXml = localSnsInfo.getAdXml();
            fjp localfjp = new fjp();
            localfjp.ZBc = ((dmz)localObject1).RGm;
            localfjp.nTu = ((dmz)localObject1).aaTr;
            if (localTimeLineObject.ContentObj.Zpq == 15)
            {
              localfjp.nTA = j(localSnsInfo).uxInfo;
              localfjp.nTB = localTimeLineObject.Id;
              localfjp.nTw = localTimeLineObject.ContentDesc;
              if (!Util.isNullOrNil(((dmz)localObject1).aaTu)) {
                break label549;
              }
              paramIntent = ((dmz)localObject1).aaTl;
              label286:
              localfjp.nTz = paramIntent;
              if ((localADXml != null) && (localADXml.attachShareLinkIsHidden == 0))
              {
                localfjp.nTy = localADXml.attachShareLinkUrl;
                localfjp.nTx = localADXml.attachShareLinkWording;
              }
              paramInt1 = t.aXE(str3);
              Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((dmz)localObject1).aaTr, Integer.valueOf(((dmz)localObject1).RGm), Integer.valueOf(paramInt1) });
              g.gaI().a(this.activity, str1, str3, str2, 43, paramInt1, localfjp, localTimeLineObject.statExtStr, null);
              g.gaI().ke((String)localObject2, str1);
              paramInt2 = this.source;
              if (this.source != 0) {
                break label558;
              }
              paramInt1 = 1;
              label441:
              t.a(new SnsAdClick(paramInt2, paramInt1, localSnsInfo.field_snsId, 12, 0));
              boolean bool = au.bwE(str1);
              localObject1 = p.d.PXo;
              if (!bool) {
                break label563;
              }
              paramIntent = p.c.PXl;
              label482:
              localObject2 = p.e.PXu;
              if (!bool) {
                break label570;
              }
            }
            label549:
            label558:
            label563:
            label570:
            for (paramInt1 = v.getMembersCountByChatRoomName(str1);; paramInt1 = 0)
            {
              com.tencent.mm.plugin.sns.ad.g.p.a((p.d)localObject1, paramIntent, (p.e)localObject2, paramInt1, localSnsInfo, this.source);
              AppMethodBeat.o(100197);
              return;
              localfjp.nTA = localTimeLineObject.streamvideo.nTA;
              localfjp.nTB = localTimeLineObject.streamvideo.nTB;
              break;
              paramIntent = ((dmz)localObject1).aaTu;
              break label286;
              paramInt1 = 2;
              break label441;
              paramIntent = p.c.PXk;
              break label482;
            }
          }
          String str3 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id) + t.i((dmz)localObject1);
          paramInt1 = t.aXE(str3);
          Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((dmz)localObject1).aaTr, Integer.valueOf(((dmz)localObject1).RGm), Integer.valueOf(paramInt1) });
          g.gaI().a(this.activity, str1, str3, str2, 43, paramInt1, this.RPN.statExtStr, null);
          g.gaI().ke((String)localObject2, str1);
        }
        com.tencent.mm.ui.widget.snackbar.b.u(this.activity, this.activity.getString(b.j.has_send));
        AppMethodBeat.o(100197);
      }
    }
    else if (paramInt1 == 15)
    {
      paramIntent = al.hgB().aZL(this.RPM);
      if (paramIntent == null)
      {
        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.RPM });
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
      t.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      AppMethodBeat.o(100197);
      return;
    }
  }
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(100195);
    if (this.RPL == null)
    {
      AppMethodBeat.o(100195);
      return;
    }
    Object localObject3;
    label624:
    Object localObject4;
    label809:
    Object localObject5;
    Object localObject6;
    label1576:
    label3627:
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
                      Object localObject1 = hri();
                      paramMenuItem = (MenuItem)localObject1;
                      if (Util.isNullOrNil((String)localObject1)) {
                        paramMenuItem = this.RPN.ContentDesc;
                      }
                      if (ClipboardHelper.setTextSwallowException(paramMenuItem))
                      {
                        k.cZ(this.activity, this.activity.getString(b.j.app_copy_ok));
                        localObject1 = com.tencent.mm.plugin.secinforeport.a.a.PlY;
                        com.tencent.mm.plugin.secinforeport.a.a.x(2, this.RPN.Id, Util.getUTF8ByteLength(paramMenuItem));
                        AppMethodBeat.o(100195);
                        return;
                      }
                      k.cZ(this.activity, this.activity.getString(b.j.app_copy_failed));
                      AppMethodBeat.o(100195);
                      return;
                      localObject1 = hri();
                      paramMenuItem = (MenuItem)localObject1;
                      if (Util.isNullOrNil((String)localObject1)) {
                        paramMenuItem = this.RPN.ContentDesc;
                      }
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                      localObject1 = new dn();
                      com.tencent.mm.plugin.sns.n.a.a((dn)localObject1, this.RPM, paramMenuItem);
                      ((dn)localObject1).hDr.activity = this.activity;
                      ((dn)localObject1).hDr.hDy = 30;
                      ((dn)localObject1).publish();
                      AppMethodBeat.o(100195);
                      return;
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                      localObject1 = new dn();
                      paramMenuItem = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
                      if ((paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
                      {
                        bbc(this.RPM);
                        if (paramMenuItem.isAd())
                        {
                          i = this.source;
                          if (this.source != 0) {
                            break label624;
                          }
                        }
                      }
                      for (paramInt = 1;; paramInt = 2)
                      {
                        localObject1 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, this.RoZ, paramMenuItem, 11);
                        t.a((SnsAdClick)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                        if (this.RPN.showFlag == 1)
                        {
                          com.tencent.mm.plugin.sns.n.a.a((dn)localObject1, this.RPM, 0);
                          ((dn)localObject1).hDr.activity = this.activity;
                          ((dn)localObject1).hDr.hDy = 31;
                          ((dn)localObject1).publish();
                          break;
                        }
                        if (!(this.RPL.getTag() instanceof bf)) {
                          break;
                        }
                        localObject3 = (bf)this.RPL.getTag();
                        com.tencent.mm.plugin.sns.n.a.a((dn)localObject1, this.RPM, ((bf)localObject3).index);
                        ((dn)localObject1).hDr.activity = this.activity;
                        ((dn)localObject1).hDr.hDy = 31;
                        ((dn)localObject1).publish();
                        break;
                      }
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                      paramMenuItem = al.hgB().aZL(this.RPM);
                      Object localObject7;
                      if (this.RPN.ContentObj.Zpr.size() != 0)
                      {
                        localObject7 = (dmz)this.RPN.ContentObj.Zpr.get(0);
                        if ((paramMenuItem == null) || (localObject7 == null))
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject1 = new dn();
                        localObject3 = this.RPN;
                        if ((localObject7 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                          break label809;
                        }
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        ((dn)localObject1).hDr.hDx = b.j.favorite_fail_argument_error;
                      }
                      Object localObject8;
                      for (;;)
                      {
                        ((dn)localObject1).hDr.activity = this.activity;
                        ((dn)localObject1).hDr.hDy = 25;
                        ((dn)localObject1).publish();
                        AppMethodBeat.o(100195);
                        return;
                        if (al.isInValid())
                        {
                          Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                          ((dn)localObject1).hDr.hDx = b.j.favorite_fail_system_error;
                        }
                        else
                        {
                          localObject8 = String.format("%s#%s", new Object[] { t.uA(paramMenuItem.field_snsId), ((dmz)localObject7).Id });
                          localObject4 = new arv();
                          localObject5 = new asb();
                          Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                          ((asb)localObject5).bto(paramMenuItem.getUserName());
                          ((asb)localObject5).btp(z.bAM());
                          ((asb)localObject5).axH(2);
                          ((asb)localObject5).yu(paramMenuItem.getCreateTime() * 1000L);
                          ((asb)localObject5).btt(paramMenuItem.getSnsId());
                          ((asb)localObject5).btq((String)localObject8);
                          if ((localObject3 != null) && (((TimeLineObject)localObject3).AppInfo != null)) {
                            ((asb)localObject5).btu(((TimeLineObject)localObject3).AppInfo.Id);
                          }
                          localObject6 = new arf();
                          ((arf)localObject6).bsG((String)localObject8);
                          ((arf)localObject6).bsv(((dmz)localObject7).Url);
                          ((arf)localObject6).bsw(((dmz)localObject7).aaTo);
                          ((arf)localObject6).bsu(paramMenuItem.getTimeLine().ContentObj.Url);
                          i = 0;
                          paramInt = i;
                          if (localObject3 != null)
                          {
                            paramInt = i;
                            if (((TimeLineObject)localObject3).ContentObj.oPb != null)
                            {
                              paramInt = i;
                              if (y.ZC(((TimeLineObject)localObject3).ContentObj.oPb.oPc))
                              {
                                paramInt = 1;
                                ((arf)localObject6).bsD(((TimeLineObject)localObject3).ContentObj.oPb.oPc);
                              }
                            }
                          }
                          localObject8 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject7).Id) + t.d((dmz)localObject7);
                          if (y.ZC((String)localObject8))
                          {
                            paramInt = 1;
                            ((arf)localObject6).bsD((String)localObject8);
                          }
                          if (paramInt == 0)
                          {
                            ((arf)localObject6).Kk(true);
                            ((arf)localObject6).bsx(((dmz)localObject7).aaTl);
                            localObject8 = new ask();
                            ((ask)localObject8).btE(((dmz)localObject7).aaTl);
                            ((arv)localObject4).c((ask)localObject8);
                          }
                          ((arf)localObject6).bsU(((dmz)localObject7).songAlbumUrl);
                          ((arf)localObject6).bsV(((dmz)localObject7).songLyric);
                          ((arf)localObject6).axy(7);
                          ((arf)localObject6).bso(((dmz)localObject7).hAP);
                          ((arf)localObject6).bsp(((dmz)localObject7).IGG);
                          ((arf)localObject6).Kj(true);
                          if ((localObject3 != null) && (((TimeLineObject)localObject3).ContentObj != null) && (((TimeLineObject)localObject3).ContentObj.oPb != null))
                          {
                            localObject7 = new arg();
                            ((arg)localObject7).e(((TimeLineObject)localObject3).ContentObj.oPb);
                            ((arf)localObject6).a((arg)localObject7);
                          }
                          ((arv)localObject4).vEn.add(localObject6);
                          ((arv)localObject4).a((asb)localObject5);
                          ((dn)localObject1).hDr.hDt = ((arv)localObject4);
                          ((dn)localObject1).hDr.type = 7;
                          com.tencent.mm.plugin.sns.n.a.a((arf)localObject6, paramMenuItem);
                        }
                      }
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                      paramMenuItem = al.hgB().aZL(this.RPM);
                      if (this.RPN.ContentObj.Zpr.size() != 0)
                      {
                        localObject7 = (dmz)this.RPN.ContentObj.Zpr.get(0);
                        if ((paramMenuItem == null) || (localObject7 == null))
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject1 = new dn();
                        localObject8 = this.RPN;
                        localObject3 = this.RPN.ContentObj.oPb;
                        if ((localObject7 != null) && (paramMenuItem != null) && (paramMenuItem.localid != 0)) {
                          break label1576;
                        }
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        ((dn)localObject1).hDr.hDx = b.j.favorite_fail_argument_error;
                      }
                      for (;;)
                      {
                        ((dn)localObject1).hDr.activity = this.activity;
                        ((dn)localObject1).hDr.hDy = 25;
                        ((dn)localObject1).publish();
                        AppMethodBeat.o(100195);
                        return;
                        if (al.isInValid())
                        {
                          Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                          ((dn)localObject1).hDr.hDx = b.j.favorite_fail_system_error;
                        }
                        else
                        {
                          String str = String.format("%s#%s", new Object[] { t.uA(paramMenuItem.field_snsId), ((dmz)localObject7).Id });
                          localObject4 = new arv();
                          localObject5 = new asb();
                          Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.getUserName() });
                          ((asb)localObject5).bto(paramMenuItem.getUserName());
                          ((asb)localObject5).btp(z.bAM());
                          ((asb)localObject5).axH(2);
                          ((asb)localObject5).yu(paramMenuItem.getCreateTime() * 1000L);
                          ((asb)localObject5).btt(paramMenuItem.getSnsId());
                          ((asb)localObject5).btq(str);
                          if ((localObject8 != null) && (((TimeLineObject)localObject8).AppInfo != null)) {
                            ((asb)localObject5).btu(((TimeLineObject)localObject8).AppInfo.Id);
                          }
                          localObject6 = new arf();
                          ((arf)localObject6).bsG(str);
                          ((arf)localObject6).bsv(((dmz)localObject7).Url);
                          ((arf)localObject6).bsw(((dmz)localObject7).aaTo);
                          ((arf)localObject6).bsu(paramMenuItem.getTimeLine().ContentObj.Url);
                          i = 0;
                          paramInt = i;
                          if (localObject8 != null)
                          {
                            paramInt = i;
                            if (((TimeLineObject)localObject8).ContentObj.oPb != null)
                            {
                              paramInt = i;
                              if (y.ZC(((TimeLineObject)localObject8).ContentObj.oPb.oPc))
                              {
                                paramInt = 1;
                                ((arf)localObject6).bsD(((TimeLineObject)localObject8).ContentObj.oPb.oPc);
                              }
                            }
                          }
                          localObject8 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject7).Id) + t.d((dmz)localObject7);
                          if (y.ZC((String)localObject8))
                          {
                            paramInt = 1;
                            ((arf)localObject6).bsD((String)localObject8);
                          }
                          if (paramInt == 0)
                          {
                            ((arf)localObject6).Kk(true);
                            ((arf)localObject6).bsx(((dmz)localObject7).aaTl);
                            localObject8 = new ask();
                            ((ask)localObject8).btE(((dmz)localObject7).aaTl);
                            ((arv)localObject4).c((ask)localObject8);
                          }
                          ((arf)localObject6).bsU(((dmz)localObject7).songAlbumUrl);
                          ((arf)localObject6).bsV(((dmz)localObject7).songLyric);
                          ((arf)localObject6).axy(29);
                          ((arf)localObject6).bso(((dmz)localObject7).hAP);
                          ((arf)localObject6).bsp(((dmz)localObject7).IGG);
                          ((arf)localObject6).Kj(true);
                          if (localObject3 != null)
                          {
                            localObject7 = new arg();
                            ((arg)localObject7).e((dtj)localObject3);
                            ((arf)localObject6).a((arg)localObject7);
                          }
                          ((arv)localObject4).vEn.add(localObject6);
                          ((arv)localObject4).a((asb)localObject5);
                          ((dn)localObject1).hDr.hDt = ((arv)localObject4);
                          ((dn)localObject1).hDr.type = 21;
                          com.tencent.mm.plugin.sns.n.a.a((arf)localObject6, paramMenuItem);
                        }
                      }
                      paramMenuItem = this.activity;
                      localObject3 = al.hgB().aZL(this.RPM);
                      if (localObject3 != null)
                      {
                        localObject1 = new Intent();
                        if (((SnsInfo)localObject3).getTimeLine().ContentObj.Zpq != 1) {
                          break label2342;
                        }
                        paramInt = 0;
                        if ((this.RPL.getTag() instanceof aw)) {
                          paramInt = ((bf)this.RPL.getTag()).index;
                        }
                        localObject3 = ap.d((SnsInfo)localObject3, paramInt);
                        if (localObject3 == null)
                        {
                          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                          AppMethodBeat.o(100195);
                          return;
                        }
                        localObject4 = ((dmz)localObject3).Id;
                        ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.j(com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), (String)localObject4) + t.k((dmz)localObject3), paramMenuItem));
                        ((Intent)localObject1).putExtra("sns_send_data_ui_image_media_id", (String)localObject4);
                      }
                      while (((((SnsInfo)localObject3).getTimeLine().ContentObj.Zpq != 4) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Zpq != 42) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Zpq != 15) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Zpq != 3)) || ((!((SnsInfo)localObject3).getTimeLine().ContentObj.Zpr.isEmpty()) && (((SnsInfo)localObject3).getTimeLine().ContentObj.Zpr.get(0) != null)))
                      {
                        ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                        ((Intent)localObject1).putExtra("sns_local_id", this.RPM);
                        ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.br.c.g(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                        AppMethodBeat.o(100195);
                        return;
                      }
                      Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                      AppMethodBeat.o(100195);
                      return;
                      localObject1 = this.activity;
                      paramMenuItem = al.hgB().aZL(this.RPM);
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
                      if ((paramMenuItem.getTimeLine() == null) || (paramMenuItem.getTimeLine().ContentObj == null) || (Util.isNullOrNil(paramMenuItem.getTimeLine().ContentObj.Zpr)))
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      localObject3 = (dmz)paramMenuItem.getTimeLine().ContentObj.Zpr.get(0);
                      if (localObject3 == null)
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      localObject4 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject3).Id);
                      paramMenuItem = "";
                      localObject5 = t.i((dmz)localObject3);
                      if (y.ZC((String)localObject4 + (String)localObject5)) {
                        paramMenuItem = (String)localObject4 + t.d((dmz)localObject3);
                      }
                      if (y.ZC((String)localObject4 + t.o((dmz)localObject3))) {
                        paramMenuItem = (String)localObject4 + t.m((dmz)localObject3);
                      }
                      localObject3 = new Intent();
                      ((Intent)localObject3).setClass(this.activity, SnsOnlineVideoActivity.class);
                      ((Intent)localObject3).putExtra("intent_thumbpath", paramMenuItem);
                      ((Intent)localObject3).putExtra("intent_localid", this.RPM);
                      ((Intent)localObject3).putExtra("intent_from_scene", this.source);
                      ((Intent)localObject3).putExtra("intent_ismute", true);
                      paramMenuItem = com.tencent.mm.plugin.sns.ui.helper.a.RKs;
                      ((Intent)localObject3).putExtra("intent_third_sdk_msg", com.tencent.mm.plugin.sns.ui.helper.a.baW(this.RPN.actionInfo.YCC.YCn));
                      if ((localObject1 instanceof SnsTimeLineUI)) {
                        ((Intent)localObject3).putExtra("sns_video_scene", 1);
                      }
                      for (;;)
                      {
                        if (this.RPL != null)
                        {
                          paramMenuItem = new int[2];
                          this.RPL.getLocationInWindow(paramMenuItem);
                          paramInt = this.RPL.getWidth();
                          i = this.RPL.getHeight();
                          ((Intent)localObject3).putExtra("img_gallery_left", paramMenuItem[0]);
                          ((Intent)localObject3).putExtra("img_gallery_top", paramMenuItem[1]);
                          ((Intent)localObject3).putExtra("img_gallery_width", paramInt);
                          ((Intent)localObject3).putExtra("img_gallery_height", i);
                        }
                        paramMenuItem = this.activity;
                        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
                        com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
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
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                      localObject1 = bn.baN(this.RPN.ContentObj.Url);
                      if (Util.isNullOrNil((String)localObject1))
                      {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        AppMethodBeat.o(100195);
                        return;
                      }
                      paramMenuItem = new dn();
                      localObject3 = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
                      if (localObject3 != null)
                      {
                        localObject4 = ad.Jo(((SnsInfo)localObject3).field_snsId);
                        localObject5 = ad.bCb().M((String)localObject4, true);
                        ((ad.b)localObject5).q("prePublishId", "sns_" + t.uA(((SnsInfo)localObject3).field_snsId));
                        ((ad.b)localObject5).q("preUsername", ((SnsInfo)localObject3).field_userName);
                        ((ad.b)localObject5).q("preChatName", "");
                        ((ad.b)localObject5).q("url", localObject1);
                        ((ad.b)localObject5).q("preMsgIndex", Integer.valueOf(0));
                        ((ad.b)localObject5).q("sendAppMsgScene", Integer.valueOf(1));
                        ((ad.b)localObject5).q("adExtStr", ((SnsInfo)localObject3).getTimeLine().statExtStr);
                        paramMenuItem.hDr.sessionId = ((String)localObject4);
                      }
                      localObject4 = al.hgB().aZL(this.RPM);
                      if ((localObject4 != null) && (this.RPN.ContentObj.Zpq == 18)) {
                        com.tencent.mm.plugin.sns.ad.g.p.a(p.d.PXp, p.c.PXj, p.e.PXu, 0, (SnsInfo)localObject4, this.source);
                      }
                      if (!Util.isNullOrNil(this.RPN.canvasInfo))
                      {
                        bbc(((SnsInfo)localObject4).getLocalid());
                        AppMethodBeat.o(100195);
                        return;
                      }
                      if (((SnsInfo)localObject4).isAd())
                      {
                        i = this.source;
                        if (this.source != 0) {
                          break label3627;
                        }
                      }
                      for (paramInt = 1;; paramInt = 2)
                      {
                        localObject3 = new SnsAdClick(i, paramInt, ((SnsInfo)localObject3).field_snsId, 11, 0);
                        com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject3, this.RoZ, (SnsInfo)localObject4, 11);
                        t.a((SnsAdClick)localObject3);
                        com.tencent.mm.plugin.sns.n.a.a(paramMenuItem, (String)localObject1, this.RPM);
                        paramMenuItem.hDr.activity = this.activity;
                        paramMenuItem.hDr.hDy = 28;
                        paramMenuItem.publish();
                        long l;
                        if (paramMenuItem.hDs.ret == 0)
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
                        com.tencent.mm.plugin.report.service.h.OAn.b(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                        AppMethodBeat.o(100195);
                        return;
                      }
                      this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                    } while (this.RPN == null);
                    paramMenuItem = new dn();
                    localObject5 = this.RPN;
                    if (localObject5 == null)
                    {
                      Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                      paramMenuItem.hDr.hDx = b.j.favorite_fail_argument_error;
                    }
                    for (;;)
                    {
                      paramMenuItem.hDr.activity = this.activity;
                      paramMenuItem.hDr.hDy = 26;
                      paramMenuItem.publish();
                      AppMethodBeat.o(100195);
                      return;
                      localObject2 = new arv();
                      localObject3 = new asb();
                      localObject4 = new aru();
                      ((asb)localObject3).bto(((TimeLineObject)localObject5).UserName);
                      ((asb)localObject3).btp(z.bAM());
                      ((asb)localObject3).axH(2);
                      ((asb)localObject3).yu(Util.nowMilliSecond());
                      if (((TimeLineObject)localObject5).AppInfo != null) {
                        ((asb)localObject3).btu(((TimeLineObject)localObject5).AppInfo.Id);
                      }
                      if (((TimeLineObject)localObject5).ContentObj != null)
                      {
                        ((aru)localObject4).bth(((TimeLineObject)localObject5).ContentObj.hAP);
                        ((aru)localObject4).bti(((TimeLineObject)localObject5).ContentObj.IGG);
                        if ((((TimeLineObject)localObject5).ContentObj.Zpr != null) && (!((TimeLineObject)localObject5).ContentObj.Zpr.isEmpty()))
                        {
                          localObject5 = (dmz)((TimeLineObject)localObject5).ContentObj.Zpr.get(0);
                          ((aru)localObject4).axE(((dmz)localObject5).subType);
                          ((aru)localObject4).btk(((dmz)localObject5).RcB);
                          ((aru)localObject4).btj(((dmz)localObject5).aaTl);
                        }
                      }
                      paramMenuItem.hDr.title = ((aru)localObject4).title;
                      paramMenuItem.hDr.desc = ((aru)localObject4).desc;
                      paramMenuItem.hDr.hDt = ((arv)localObject2);
                      paramMenuItem.hDr.type = 10;
                      ((arv)localObject2).a((asb)localObject3);
                      ((arv)localObject2).b((aru)localObject4);
                    }
                    paramMenuItem = this.RPN.weappInfo;
                    if ((this.RPN == null) || (paramMenuItem == null))
                    {
                      Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                      AppMethodBeat.o(100195);
                      return;
                    }
                    localObject5 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramMenuItem.username);
                    localObject3 = new ard();
                    ((ard)localObject3).username = paramMenuItem.username;
                    if (localObject5 != null) {
                      ((ard)localObject3).appId = ((WxaAttributes)localObject5).field_appId;
                    }
                    ((ard)localObject3).hzy = paramMenuItem.path;
                    ((ard)localObject3).hJK = paramMenuItem.tgv;
                    ((ard)localObject3).version = paramMenuItem.version;
                    ((ard)localObject3).idf = paramMenuItem.idf;
                    ((ard)localObject3).subType = paramMenuItem.subType;
                    paramMenuItem = null;
                    localObject4 = new arf();
                    ((arf)localObject4).axy(19);
                    if (this.RPN.ContentObj != null)
                    {
                      paramMenuItem = this.RPN.ContentObj.hAP;
                      if ((this.RPN.ContentObj.Zpr != null) && (!this.RPN.ContentObj.Zpr.isEmpty()))
                      {
                        localObject2 = (dmz)this.RPN.ContentObj.Zpr.get(0);
                        localObject2 = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), ((dmz)localObject2).Id) + t.d((dmz)localObject2);
                        ((arf)localObject4).bsC((String)localObject2);
                        ((arf)localObject4).bsD((String)localObject2);
                        localObject2 = paramMenuItem;
                        if (Util.isNullOrNil(paramMenuItem)) {
                          if ((localObject5 == null) || (Util.isNullOrNil(((WxaAttributes)localObject5).field_nickname))) {
                            break label4510;
                          }
                        }
                      }
                    }
                    for (localObject2 = ((WxaAttributes)localObject5).field_nickname;; localObject2 = this.activity.getString(b.j.appbrand_app_name))
                    {
                      ((arf)localObject4).bso((String)localObject2);
                      ((arf)localObject4).bsp((String)localObject2);
                      ((arf)localObject4).bsB(com.tencent.mm.plugin.fav.a.b.er(localObject4.toString(), 19));
                      localObject5 = new asb();
                      ((asb)localObject5).bto(z.bAM());
                      ((asb)localObject5).yu(Util.nowMilliSecond());
                      ((asb)localObject5).axH(2);
                      paramMenuItem = new arv();
                      paramMenuItem.vEn.add(localObject4);
                      paramMenuItem.c((ard)localObject3);
                      paramMenuItem.a((asb)localObject5);
                      paramMenuItem.btm((String)localObject2);
                      localObject3 = new dn();
                      ((dn)localObject3).hDr.activity = this.activity;
                      ((dn)localObject3).hDr.title = ((String)localObject2);
                      ((dn)localObject3).hDr.desc = ((String)localObject2);
                      ((dn)localObject3).hDr.hDt = paramMenuItem;
                      ((dn)localObject3).hDr.type = 19;
                      ((dn)localObject3).publish();
                      AppMethodBeat.o(100195);
                      return;
                      ((arf)localObject4).Kk(true);
                      break;
                      ((arf)localObject4).Kk(true);
                      break;
                    }
                    this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                  } while (this.RPN == null);
                  paramMenuItem = new dn();
                  localObject5 = this.RPN;
                  if (localObject5 == null)
                  {
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                    paramMenuItem.hDr.hDx = b.j.favorite_fail_argument_error;
                  }
                  for (;;)
                  {
                    paramMenuItem.hDr.activity = this.activity;
                    paramMenuItem.hDr.hDy = 27;
                    paramMenuItem.publish();
                    AppMethodBeat.o(100195);
                    return;
                    localObject2 = new arv();
                    localObject3 = new asb();
                    localObject4 = new ase();
                    ((asb)localObject3).bto(((TimeLineObject)localObject5).UserName);
                    ((asb)localObject3).btp(z.bAM());
                    ((asb)localObject3).axH(8);
                    ((asb)localObject3).yu(Util.nowMilliSecond());
                    if (((TimeLineObject)localObject5).AppInfo != null) {
                      ((asb)localObject3).btu(((TimeLineObject)localObject5).AppInfo.Id);
                    }
                    if (((TimeLineObject)localObject5).ContentObj != null)
                    {
                      ((ase)localObject4).btx(((TimeLineObject)localObject5).ContentObj.hAP);
                      ((ase)localObject4).bty(((TimeLineObject)localObject5).ContentObj.IGG);
                      if ((((TimeLineObject)localObject5).ContentObj.Zpr != null) && (!((TimeLineObject)localObject5).ContentObj.Zpr.isEmpty()))
                      {
                        localObject5 = (dmz)((TimeLineObject)localObject5).ContentObj.Zpr.get(0);
                        ((ase)localObject4).btA(((dmz)localObject5).RcB);
                        ((ase)localObject4).btz(((dmz)localObject5).aaTl);
                      }
                    }
                    paramMenuItem.hDr.title = ((ase)localObject4).title;
                    paramMenuItem.hDr.desc = ((ase)localObject4).desc;
                    paramMenuItem.hDr.hDt = ((arv)localObject2);
                    paramMenuItem.hDr.type = 15;
                    ((arv)localObject2).a((asb)localObject3);
                    ((arv)localObject2).b((ase)localObject4);
                  }
                  paramMenuItem = al.hgB().aZL(this.RPM);
                  if (paramMenuItem == null)
                  {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
                    AppMethodBeat.o(100195);
                    return;
                  }
                  new g.a(this.activity).bDE(this.activity.getResources().getString(b.j.sns_comment_delete_alert_title)).bDI(this.activity.getResources().getString(b.j.app_delete)).aEY(this.activity.getResources().getColor(b.c.red_text_color)).b(new g.c()
                  {
                    public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
                    {
                      int i = 0;
                      AppMethodBeat.i(308521);
                      paramAnonymousString = paramMenuItem.getSnsId();
                      Object localObject = (com.tencent.mm.plugin.sns.ui.m)b.a(b.this).getTag();
                      if (localObject != null)
                      {
                        if (!ai.bao(paramAnonymousString)) {
                          break label187;
                        }
                        paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(ai.aXe(paramAnonymousString), 6, ((com.tencent.mm.plugin.sns.ui.m)localObject).Qsv);
                        com.tencent.mm.kernel.h.baF();
                        com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousString, 0);
                        b localb = b.this;
                        Activity localActivity = b.b(b.this);
                        b.b(b.this).getString(b.j.app_tip);
                        b.a(localb, k.a(localActivity, b.b(b.this).getString(b.j.sns_deling_sns), true, new b.2.1(this, paramAnonymousString)));
                        if (((com.tencent.mm.plugin.sns.ui.m)localObject).Qsv == null) {
                          break label224;
                        }
                        i = ((com.tencent.mm.plugin.sns.ui.m)localObject).Qsv.abDh;
                      }
                      label187:
                      label224:
                      for (paramAnonymousString = ((com.tencent.mm.plugin.sns.ui.m)localObject).Qsv.Username;; paramAnonymousString = "")
                      {
                        localObject = j.QFS;
                        j.b(paramMenuItem, i, paramAnonymousString, 1);
                        AppMethodBeat.o(308521);
                        return;
                        paramAnonymousString = new com.tencent.mm.plugin.sns.model.s(ai.aXe(paramAnonymousString), 4, ((com.tencent.mm.plugin.sns.ui.m)localObject).Qsv);
                        com.tencent.mm.kernel.h.baF();
                        com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousString, 0);
                        break;
                      }
                    }
                  }).bDJ(this.activity.getResources().getString(b.j.app_cancel)).a(new g.c()
                  {
                    public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString)
                    {
                      AppMethodBeat.i(308522);
                      paramAnonymousString = (com.tencent.mm.plugin.sns.ui.m)b.a(b.this).getTag();
                      int i = 0;
                      if ((paramAnonymousString != null) && (paramAnonymousString.Qsv != null)) {
                        i = paramAnonymousString.Qsv.abDh;
                      }
                      for (paramAnonymousString = paramAnonymousString.Qsv.Username;; paramAnonymousString = "")
                      {
                        j localj = j.QFS;
                        j.b(paramMenuItem, i, paramAnonymousString, 2);
                        AppMethodBeat.o(308522);
                        return;
                      }
                    }
                  }).show();
                  AppMethodBeat.o(100195);
                  return;
                  paramMenuItem = al.hgB().aZL(this.RPM);
                } while (paramMenuItem == null);
                com.tencent.mm.plugin.sns.abtest.a.c(paramMenuItem);
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
                ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.getUserName());
                ((Intent)localObject2).putExtra("sns_permission_anim", true);
                ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
                com.tencent.mm.hellhoundlib.a.a.a(this.activity, com.tencent.mm.hellhoundlib.b.c.a(11, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
                AppMethodBeat.o(100195);
                return;
                this.Rca.hgf().mr(this.RPM, this.RPN.Id);
                paramMenuItem = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
                if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
                {
                  localObject2 = al.hgB().aZL(this.RPM);
                  if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()))
                  {
                    i = this.source;
                    if (this.source != 0) {
                      break label5283;
                    }
                  }
                  for (paramInt = 1;; paramInt = 2)
                  {
                    localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.RoZ, paramMenuItem, 11);
                    t.a((SnsAdClick)localObject2);
                    bbc(this.RPM);
                    AppMethodBeat.o(100195);
                    return;
                  }
                }
                paramMenuItem = this.RPM;
                paramMenuItem = al.hgB().aZL(paramMenuItem);
                if (paramMenuItem != null) {
                  if (paramMenuItem.isAd())
                  {
                    com.tencent.mm.plugin.sns.ad.g.p.a(p.d.PXo, p.c.PXj, p.e.PXu, 0, paramMenuItem, this.source);
                    i = this.source;
                    if (this.source != 0) {
                      break label5430;
                    }
                  }
                }
                for (paramInt = 1;; paramInt = 2)
                {
                  localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
                  com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.RoZ, paramMenuItem, 11);
                  t.a((SnsAdClick)localObject2);
                  localObject2 = new dn();
                  com.tencent.mm.plugin.sns.n.a.a((dn)localObject2, paramMenuItem);
                  ((dn)localObject2).hDr.activity = this.activity;
                  ((dn)localObject2).hDr.hDy = 29;
                  ((dn)localObject2).publish();
                  AppMethodBeat.o(100195);
                  return;
                }
                paramMenuItem = (dmz)this.RPN.ContentObj.Zpr.get(0);
                paramMenuItem = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), paramMenuItem.Id) + t.d(paramMenuItem);
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
                ((Intent)localObject2).putExtra("select_is_ret", true);
                ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
                ((Intent)localObject2).putExtra("image_path", paramMenuItem);
                ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
                com.tencent.mm.br.c.d(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
                AppMethodBeat.o(100195);
                return;
              } while (!(this.RPL.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
              paramMenuItem = (com.tencent.mm.plugin.sns.ui.m)this.RPL.getTag();
              if (ClipboardHelper.setTextSwallowException(paramMenuItem.nUB))
              {
                k.cZ(this.activity, this.activity.getString(b.j.app_copy_ok));
                if (paramMenuItem.Qsv != null)
                {
                  localObject2 = com.tencent.mm.plugin.secinforeport.a.a.PlY;
                  com.tencent.mm.plugin.secinforeport.a.a.x(4, this.RPN.Id + ":" + paramMenuItem.Qsv.abDh, Util.getUTF8ByteLength(paramMenuItem.nUB));
                  AppMethodBeat.o(100195);
                }
              }
              else
              {
                k.cZ(this.activity, this.activity.getString(b.j.app_copy_failed));
              }
              AppMethodBeat.o(100195);
              return;
              paramMenuItem = al.hgB().aZL(this.RPM);
              com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
              AppMethodBeat.o(100195);
              return;
            } while (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.RPL.getContext()));
            localObject2 = al.hgB().aZL(this.RPM);
            if (localObject2 != null) {
              if (this.source != 0) {
                break label5832;
              }
            }
            for (paramMenuItem = com.tencent.mm.modelsns.l.wO(714);; paramMenuItem = com.tencent.mm.modelsns.l.wP(714))
            {
              paramMenuItem.Ph(t.x((SnsInfo)localObject2)).wR(((SnsInfo)localObject2).field_type).hm(((SnsInfo)localObject2).isAd()).Ph(((SnsInfo)localObject2).getUxinfo());
              paramMenuItem.bMH();
              av.G((SnsInfo)localObject2);
              AppMethodBeat.o(100195);
              return;
            }
          } while ((!(this.RPL.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)) || (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.RPL.getContext())));
          localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.RPL.getTag();
          localObject3 = al.hgB().aZK(((com.tencent.mm.plugin.sns.ui.m)localObject2).Rcm);
          if (localObject3 != null)
          {
            if (this.source != 0) {
              break label6023;
            }
            paramMenuItem = com.tencent.mm.modelsns.l.wO(715);
            paramMenuItem.Ph(t.x((SnsInfo)localObject3)).wR(((SnsInfo)localObject3).field_type).hm(((SnsInfo)localObject3).isAd()).Ph(((SnsInfo)localObject3).getUxinfo());
            if (((com.tencent.mm.plugin.sns.ui.m)localObject2).Qsv == null) {
              break label6059;
            }
            if (((com.tencent.mm.plugin.sns.ui.m)localObject2).Qsv.abDh != 0) {
              break label6033;
            }
            localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).Qsv.abDj;
            paramMenuItem.Ph((String)localObject2);
          }
          for (;;)
          {
            paramMenuItem.bMH();
            av.a((com.tencent.mm.plugin.sns.ui.m)this.RPL.getTag());
            AppMethodBeat.o(100195);
            return;
            paramMenuItem = com.tencent.mm.modelsns.l.wP(715);
            break;
            localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).Qsv.abDh;
            break label5991;
            paramMenuItem.Ph("");
          }
          this.Rca.hgf().mr(this.RPM, this.RPN.Id);
          paramMenuItem = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
          if ((paramMenuItem != null) && (paramMenuItem.isAd()) && (paramMenuItem.getAdXml().isLandingPagesAd()))
          {
            localObject2 = al.hgB().aZL(this.RPM);
            if ((localObject2 != null) && (((SnsInfo)localObject2).isAd()) && (this.RPN != null))
            {
              i = this.source;
              if (this.source != 0) {
                break label6217;
              }
            }
            for (paramInt = 1;; paramInt = 2)
            {
              localObject2 = new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, this.RoZ, paramMenuItem, 11);
              t.a((SnsAdClick)localObject2);
              bbc(this.RPM);
              AppMethodBeat.o(100195);
              return;
            }
          }
          bbd(this.RPM);
          AppMethodBeat.o(100195);
          return;
          av.H(al.hgB().aZL(this.RPM));
          AppMethodBeat.o(100195);
          return;
        } while (!(this.RPL.getTag() instanceof com.tencent.mm.plugin.sns.ui.m));
        av.b((com.tencent.mm.plugin.sns.ui.m)this.RPL.getTag());
        AppMethodBeat.o(100195);
        return;
        localObject2 = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
        if (localObject2 == null)
        {
          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
          AppMethodBeat.o(100195);
          return;
        }
        if ((this.RPL.getTag() == null) || (!(this.RPL.getTag() instanceof bf)))
        {
          Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
          AppMethodBeat.o(100195);
          return;
        }
        localObject3 = (bf)this.RPL.getTag();
        localObject4 = this.activity;
        paramMenuItem = paramMenuItem.getIntent();
        if (this.source == 0) {}
        for (paramInt = 1;; paramInt = 2)
        {
          be.a((Activity)localObject4, paramMenuItem, (SnsInfo)localObject2, (bf)localObject3, paramInt, this.source, this.Rca);
          AppMethodBeat.o(100195);
          return;
        }
        if (this.RPN == null)
        {
          Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
          AppMethodBeat.o(100195);
          return;
        }
        paramMenuItem = new dn();
        com.tencent.mm.plugin.sns.n.a.a(paramMenuItem, this.RPM);
        paramMenuItem.hDr.activity = this.activity;
        paramMenuItem.hDr.hDy = 28;
        paramMenuItem.publish();
        AppMethodBeat.o(100195);
        return;
      } while ((this.RPN == null) || (this.RPN.ContentObj == null));
      ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).c(this.RPN.ContentObj.Zpw);
      k.cZ(this.activity, this.activity.getString(b.j.favorite_ok));
      AppMethodBeat.o(100195);
      return;
    case 25: 
      if ((this.RPN != null) && (this.RPN.ContentObj != null) && (this.RPN.ContentObj.Zpq == 28))
      {
        paramMenuItem = new dn();
        localObject2 = this.RPN;
        if (localObject2 != null) {
          break label6655;
        }
        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
        paramMenuItem.hDr.hDx = b.j.favorite_fail_attachment_not_exists;
      }
      for (;;)
      {
        paramMenuItem.hDr.activity = this.activity;
        paramMenuItem.publish();
        AppMethodBeat.o(100195);
        return;
        localObject6 = String.format("%s", new Object[] { ((TimeLineObject)localObject2).Id });
        localObject3 = new arv();
        localObject4 = new asb();
        localObject5 = new arf();
        ((asb)localObject4).bto(((TimeLineObject)localObject2).UserName);
        ((asb)localObject4).btp(z.bAM());
        ((asb)localObject4).axH(2);
        ((asb)localObject4).yu(((TimeLineObject)localObject2).CreateTime * 1000L);
        ((asb)localObject4).btt(((TimeLineObject)localObject2).Id);
        ((asb)localObject4).btq((String)localObject6);
        ((arf)localObject5).bsG((String)localObject6);
        com.tencent.mm.plugin.sns.n.a.a((arf)localObject5, (TimeLineObject)localObject2);
        ((arf)localObject5).axy(20);
        if (((TimeLineObject)localObject2).ContentObj.oPb != null)
        {
          localObject6 = new arg();
          ((arg)localObject6).e(((TimeLineObject)localObject2).ContentObj.oPb);
          ((arf)localObject5).a((arg)localObject6);
        }
        ((arv)localObject3).vEn.add(localObject5);
        ((arv)localObject3).a((asb)localObject4);
        ((arv)localObject3).h(((TimeLineObject)localObject2).ContentObj.hKU);
        paramMenuItem.hDr.hDt = ((arv)localObject3);
        paramMenuItem.hDr.type = 20;
      }
    case 26: 
      label2342:
      label5430:
      label5832:
      label5991:
      label6655:
      localObject2 = com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM);
      label4510:
      label5283:
      label6059:
      label6217:
      paramMenuItem = (bf)this.RPL.getTag();
      label6023:
      label6033:
      localObject3 = ((SnsInfo)localObject2).getTimeLine();
      if (paramMenuItem.index < ((TimeLineObject)localObject3).ContentObj.Zpr.size())
      {
        paramMenuItem = (dmz)((TimeLineObject)localObject3).ContentObj.Zpr.get(paramMenuItem.index);
        localObject3 = new com.tencent.mm.plugin.websearch.api.o();
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).context = this.activity;
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).hET = (com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), paramMenuItem.Id) + t.k(paramMenuItem));
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).WnO = ((SnsInfo)localObject2).field_userName;
        if (!(this.activity instanceof SnsTimeLineUI)) {
          break label7093;
        }
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).hDy = 10;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).Qsr = paramMenuItem;
        ((com.tencent.mm.plugin.websearch.api.o)localObject3).hQX = t.uA(((SnsInfo)localObject2).field_snsId);
        ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch((com.tencent.mm.plugin.websearch.api.o)localObject3);
        AppMethodBeat.o(100195);
        return;
        paramMenuItem = new dmz();
        break;
        label7093:
        if ((this.activity instanceof SnsCommentDetailUI)) {
          ((com.tencent.mm.plugin.websearch.api.o)localObject3).hDy = 7;
        }
      }
    }
    if (29 == paramMenuItem.getItemId())
    {
      localObject2 = (com.tencent.mm.plugin.sns.ui.m)this.RPL.getTag();
      if (localObject2 == null) {
        break label7425;
      }
      localObject2 = ((com.tencent.mm.plugin.sns.ui.m)localObject2).nUB;
    }
    for (;;)
    {
      label7148:
      if (Util.isNullOrNil((String)localObject2)) {
        localObject2 = this.RPN.ContentDesc;
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.plugin.fts.a.d.We(77);
        localObject4 = new ah();
        ((ah)localObject4).sessionId = ((String)localObject3);
        ((ah)localObject4).context = this.activity;
        ((ah)localObject4).query = ((String)localObject2);
        ((ah)localObject4).scene = 77;
        ((ah)localObject4).WoH = true;
        ((ah)localObject4).WoI = true;
        ((ah)localObject4).WoJ = false;
        ((ah)localObject4).WoS = true;
        ((ah)localObject4).WoL = com.tencent.mm.cd.a.w(this.activity, b.c.white);
        ((ah)localObject4).WoM = false;
        ((ah)localObject4).hVt.put("chatSearch", "1");
        ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((ah)localObject4);
        paramInt = 0;
        if ((this.activity instanceof SnsCommentDetailUI)) {
          if (paramMenuItem.getItemId() != 29) {
            paramInt = 5;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.websearch.api.as.a(2, (String)localObject3, 77, 0, "", "", t.uA(com.tencent.mm.plugin.sns.storage.l.aZL(this.RPM).field_snsId), 3, "", 0L, ((String)localObject2).length(), paramInt, "", "", -1);
          break;
          localObject2 = hri();
          break label7148;
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
      label7425:
      localObject2 = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(100198);
    Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.RbN != null) && (this.RbN.isShowing())) {
      this.RbN.dismiss();
    }
    long l2;
    long l1;
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.sns.model.s)) && ((((com.tencent.mm.plugin.sns.model.s)paramp).type == 4) || (((com.tencent.mm.plugin.sns.model.s)paramp).type == 6)))
    {
      aa.y(this.activity, this.activity.getResources().getString(b.j.sns_toast_tip_comment_deleted), b.i.icons_filled_done);
      paramString = (com.tencent.mm.plugin.sns.model.s)paramp;
      if (paramString.Qsv != null) {
        break label217;
      }
      paramString = "";
      if (!Util.isEqual(paramString, z.bAM()))
      {
        paramInt1 = 9;
        if (((com.tencent.mm.plugin.sns.model.s)paramp).type == 6) {
          paramInt1 = 10;
        }
        l2 = ((com.tencent.mm.plugin.sns.model.s)paramp).Qsu;
        paramString = al.hgH();
        paramp = (com.tencent.mm.plugin.sns.model.s)paramp;
        if (paramp.Qsv != null) {
          break label228;
        }
        l1 = 0L;
      }
    }
    for (;;)
    {
      paramString = paramString.o(l2, l1, paramInt1);
      if (paramString != null)
      {
        paramString.hkI();
        al.hgH().update(paramString.systemRowid, paramString);
      }
      AppMethodBeat.o(100198);
      return;
      label217:
      paramString = paramString.Qsv.Username;
      break;
      label228:
      if (paramp.type == 6) {
        l1 = paramp.Qsv.abDj;
      } else {
        l1 = paramp.Qsv.abDh;
      }
    }
  }
  
  public final void removeListener()
  {
    AppMethodBeat.i(100191);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(218, this);
    AppMethodBeat.o(100191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.b
 * JD-Core Version:    0.7.0.1
 */