package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.a.ra;
import com.tencent.mm.h.a.ra.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.a.b.j.d;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.l;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private ClipboardManager kgn;
  private com.tencent.mm.ui.base.p oNQ;
  private ae oOe;
  private View poq;
  private String por;
  private bxk pot;
  private int source;
  
  public a(Activity paramActivity, int paramInt, ae paramae)
  {
    this.activity = paramActivity;
    this.source = paramInt;
    this.kgn = ((ClipboardManager)paramActivity.getSystemService("clipboard"));
    this.oOe = paramae;
  }
  
  private void Ps(String paramString)
  {
    Object localObject2 = af.bDF().OB(paramString);
    if (localObject2 == null) {
      return;
    }
    bxk localbxk = ((n)localObject2).bGe();
    if (((n)localObject2).yr(32))
    {
      localObject1 = ((n)localObject2).bGN();
      str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z((n)localObject2);
      if (!bk.bl(str1)) {
        ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml = str1;
      }
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).field_adxml;; localObject1 = localbxk.pjl)
    {
      localObject3 = bn.s((String)localObject1, "adxml");
      if (localObject3 == null) {
        break;
      }
      if (((Map)localObject3).containsKey(".adxml.adCanvasInfo")) {
        break label109;
      }
      com.tencent.mm.ui.base.h.h(this.activity, i.j.favorite_fail_parse_error, 0);
      return;
    }
    label109:
    String str1 = u.ij(((n)localObject2).field_snsId);
    String str2 = bk.aM((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareTitle"), "");
    String str3 = bk.aM((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareWebUrl"), "");
    Object localObject3 = bk.aM((String)((Map)localObject3).get(".adxml.adCanvasInfo.shareDesc"), "");
    localObject2 = new cj();
    ra localra = new ra();
    localra.cak.can = paramString;
    localra.cak.cao = ((cj)localObject2);
    localra.cak.url = str3;
    com.tencent.mm.sdk.b.a.udP.m(localra);
    if (!localra.cal.bIe)
    {
      if (((cj)localObject2).bIw.bIC == 0) {
        ((cj)localObject2).bIw.bIC = i.j.favorite_fail_nonsupport;
      }
      com.tencent.mm.ui.base.h.h(this.activity, ((cj)localObject2).bIw.bIC, 0);
      return;
    }
    ((cj)localObject2).bIw.bIB = str1;
    ((cj)localObject2).bIw.title = str2;
    ((cj)localObject2).bIw.desc = ((String)localObject3);
    paramString = ((cj)localObject2).bIw.bIy;
    if ((paramString != null) && (paramString.sXc != null) && (paramString.sXc.size() > 0) && (paramString.sXc.get(0) != null))
    {
      ((xv)paramString.sXc.get(0)).XT((String)localObject1);
      if (bk.bl(((xv)paramString.sXc.get(0)).title)) {
        ((xv)paramString.sXc.get(0)).Xu(((cj)localObject2).bIw.title);
      }
      if (bk.bl(((xv)paramString.sXc.get(0)).desc)) {
        ((xv)paramString.sXc.get(0)).Xv(((cj)localObject2).bIw.desc);
      }
      localObject1 = new yp();
      ((yp)localObject1).Yq(localbxk.hPY);
      ((yp)localObject1).Yr(q.Gj());
      ((yp)localObject1).EQ(2);
      ((yp)localObject1).hl(bk.UY());
      paramString.a((yp)localObject1);
    }
    ((cj)localObject2).bIw.activity = this.activity;
    ((cj)localObject2).bIw.bID = 28;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
  }
  
  private String bKk()
  {
    if ((this.poq != null) && ((this.poq.getTag() instanceof ar)) && (((ar)this.poq.getTag()).bJh()))
    {
      ap.b localb = ap.NJ(af.bDF().OB(this.por).bGk());
      if (localb != null) {
        return localb.result;
      }
    }
    return null;
  }
  
  public final void a(View paramView, String paramString, bxk parambxk)
  {
    this.poq = paramView;
    this.por = paramString;
    this.pot = parambxk;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if (paramInt1 == 15)
      {
        localn = af.bDF().OB(this.por);
        localObject1 = (awd)this.pot.tNr.sPJ.get(0);
        str1 = paramIntent.getStringExtra("Select_Conv_User");
        localObject2 = paramIntent.getStringExtra("custom_send_text");
        str2 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + com.tencent.mm.plugin.sns.data.i.e((awd)localObject1);
        paramIntent = bk.G(str1.split(",")).iterator();
        if (!paramIntent.hasNext()) {
          break label730;
        }
        str1 = (String)paramIntent.next();
        if (!localn.yr(32)) {
          break label592;
        }
        str3 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
        localbxk = localn.bGe();
        localb = localn.bFZ();
        localbwa = new bwa();
        localbwa.sWK = ((awd)localObject1).pkD;
        localbwa.dSP = ((awd)localObject1).trW;
        if (localbxk.tNr.sPI != 15) {
          break label537;
        }
        if (localn == null) {
          break label532;
        }
        if (this.source != 2) {
          break label523;
        }
        paramIntent = localn.bGc();
        localbwa.dSV = paramIntent.ovV;
        localbwa.dSW = localbxk.lsK;
        localbwa.dSR = localbxk.tNo;
        if (!bk.bl(((awd)localObject1).trZ)) {
          break label566;
        }
        paramIntent = ((awd)localObject1).trP;
        localbwa.dSU = paramIntent;
        if ((localb != null) && (localb.oAN == 0))
        {
          localbwa.dST = localb.oAP;
          localbwa.dSS = localb.oAO;
        }
        paramInt1 = com.tencent.mm.plugin.sns.data.i.Nh(str3);
        y.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((awd)localObject1).trW, Integer.valueOf(((awd)localObject1).pkD), Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.messenger.a.g.bhI().a(this.activity, str1, str3, str2, 43, paramInt1, localbwa, localbxk.oPO);
        com.tencent.mm.plugin.messenger.a.g.bhI().dO((String)localObject2, str1);
        paramInt2 = this.source;
        if (this.source != 0) {
          break label575;
        }
        paramInt1 = 1;
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(paramInt2, paramInt1, localn.field_snsId, 12, 0));
        bool = s.fn(str1);
        localObject1 = j.d.omj;
        if (!bool) {
          break label580;
        }
        paramIntent = j.c.omg;
        localObject2 = j.e.omp;
        if (!bool) {
          break label587;
        }
        paramInt1 = com.tencent.mm.model.m.gM(str1);
        j.a((j.d)localObject1, paramIntent, (j.e)localObject2, paramInt1, localn, this.source);
      }
    }
    label523:
    label532:
    label537:
    label566:
    label575:
    label580:
    label587:
    label592:
    label730:
    while (paramInt1 != 15)
    {
      for (;;)
      {
        n localn;
        Object localObject1;
        String str1;
        Object localObject2;
        String str2;
        bxk localbxk;
        com.tencent.mm.plugin.sns.storage.b localb;
        bwa localbwa;
        boolean bool;
        return;
        paramIntent = localn.bGb();
        continue;
        paramIntent = null;
        continue;
        localbwa.dSV = localbxk.tNw.dSV;
        localbwa.dSW = localbxk.tNw.dSW;
        continue;
        paramIntent = ((awd)localObject1).trZ;
        continue;
        paramInt1 = 2;
        continue;
        paramIntent = j.c.omf;
        continue;
        paramInt1 = 0;
        continue;
        String str3 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
        paramInt1 = com.tencent.mm.plugin.sns.data.i.Nh(str3);
        y.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[] { str1, str3, str2, ((awd)localObject1).trW, Integer.valueOf(((awd)localObject1).pkD), Integer.valueOf(paramInt1) });
        com.tencent.mm.plugin.messenger.a.g.bhI().a(this.activity, str1, str3, str2, 43, paramInt1, this.pot.oPO);
        com.tencent.mm.plugin.messenger.a.g.bhI().dO((String)localObject2, str1);
      }
      com.tencent.mm.ui.widget.snackbar.b.h(this.activity, this.activity.getString(i.j.has_send));
      return;
    }
    paramIntent = af.bDF().OB(this.por);
    if (paramIntent == null)
    {
      y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[] { this.por });
      return;
    }
    paramInt2 = this.source;
    if (this.source == 0) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(paramInt2, paramInt1, paramIntent.field_snsId, 13, 0));
      return;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.poq == null) {}
    int i;
    label407:
    Object localObject7;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    long l;
    label2291:
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
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                        switch (paramMenuItem.getItemId())
                        {
                        case 6: 
                        default: 
                          return;
                        case 0: 
                          localObject1 = bKk();
                          paramMenuItem = (MenuItem)localObject1;
                          if (bk.bl((String)localObject1)) {
                            paramMenuItem = this.pot.tNo;
                          }
                          this.kgn.setText(paramMenuItem);
                          com.tencent.mm.ui.base.h.bC(this.activity, this.activity.getString(i.j.app_copy_ok));
                          localObject1 = com.tencent.mm.plugin.secinforeport.a.a.nQo;
                          com.tencent.mm.plugin.secinforeport.a.a.f(2, this.pot.lsK, bk.ZH(paramMenuItem));
                          return;
                        case 1: 
                          localObject1 = bKk();
                          paramMenuItem = (MenuItem)localObject1;
                          if (bk.bl((String)localObject1)) {
                            paramMenuItem = this.pot.tNo;
                          }
                          this.oOe.bDk().eP(this.por, this.pot.lsK);
                          localObject1 = new cj();
                          com.tencent.mm.plugin.sns.i.a.a((cj)localObject1, this.por, paramMenuItem);
                          ((cj)localObject1).bIw.activity = this.activity;
                          ((cj)localObject1).bIw.bID = 30;
                          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
                          return;
                        case 2: 
                          this.oOe.bDk().eP(this.por, this.pot.lsK);
                          paramMenuItem = new cj();
                          localObject1 = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
                          if ((!((n)localObject1).yr(32)) || (!((n)localObject1).bFZ().bEE())) {
                            break label407;
                          }
                          Ps(this.por);
                        }
                      } while (!((n)localObject1).yr(32));
                      i = this.source;
                      if (this.source == 0) {}
                      for (paramInt = 1;; paramInt = 2)
                      {
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, ((n)localObject1).field_snsId, 11, 0));
                        return;
                        if (this.pot.cCu == 1)
                        {
                          com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, this.por, 0);
                          paramMenuItem.bIw.activity = this.activity;
                          paramMenuItem.bIw.bID = 31;
                          com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
                          break;
                        }
                        localObject3 = (ao)this.poq.getTag();
                        com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, this.por, ((ao)localObject3).index);
                        paramMenuItem.bIw.activity = this.activity;
                        paramMenuItem.bIw.bID = 31;
                        com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
                        break;
                      }
                      this.oOe.bDk().eP(this.por, this.pot.lsK);
                      paramMenuItem = af.bDF().OB(this.por);
                    } while (this.pot.tNr.sPJ.size() == 0);
                    localObject1 = (awd)this.pot.tNr.sPJ.get(0);
                    if ((paramMenuItem == null) || (localObject1 == null))
                    {
                      y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                      return;
                    }
                    localObject3 = new cj();
                    if ((localObject1 == null) || (paramMenuItem == null) || (paramMenuItem.oLk == 0)) {
                      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                    }
                    for (((cj)localObject3).bIw.bIC = i.j.favorite_fail_argument_error;; ((cj)localObject3).bIw.bIC = i.j.favorite_fail_system_error)
                    {
                      ((cj)localObject3).bIw.activity = this.activity;
                      ((cj)localObject3).bIw.bID = 25;
                      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
                      return;
                      if (!af.bDo()) {
                        break;
                      }
                      y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                    }
                    localObject7 = String.format("%s#%s", new Object[] { com.tencent.mm.plugin.sns.data.i.fN(paramMenuItem.field_snsId), ((awd)localObject1).lsK });
                    localObject4 = new yj();
                    localObject5 = new yp();
                    y.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[] { paramMenuItem.field_userName });
                    ((yp)localObject5).Yq(paramMenuItem.field_userName);
                    ((yp)localObject5).Yr(q.Gj());
                    ((yp)localObject5).EQ(2);
                    ((yp)localObject5).hl(paramMenuItem.field_createTime * 1000L);
                    ((yp)localObject5).Yv(paramMenuItem.bGk());
                    ((yp)localObject5).Ys((String)localObject7);
                    localObject6 = new xv();
                    ((xv)localObject6).XM((String)localObject7);
                    ((xv)localObject6).XB(((awd)localObject1).kSC);
                    ((xv)localObject6).XC(((awd)localObject1).trT);
                    ((xv)localObject6).XA(paramMenuItem.bGe().tNr.kSC);
                    localObject7 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK) + com.tencent.mm.plugin.sns.data.i.e((awd)localObject1);
                    if (com.tencent.mm.vfs.e.bK((String)localObject7)) {
                      ((xv)localObject6).XJ((String)localObject7);
                    }
                    for (;;)
                    {
                      ((xv)localObject6).EH(7);
                      ((xv)localObject6).Xu(((awd)localObject1).bGw);
                      ((xv)localObject6).Xv(((awd)localObject1).kRN);
                      ((xv)localObject6).mj(true);
                      ((yj)localObject4).sXc.add(localObject6);
                      ((yj)localObject4).a((yp)localObject5);
                      ((cj)localObject3).bIw.bIy = ((yj)localObject4);
                      ((cj)localObject3).bIw.type = 7;
                      com.tencent.mm.plugin.sns.i.a.a((xv)localObject6, paramMenuItem);
                      break;
                      ((xv)localObject6).mk(true);
                      ((xv)localObject6).XD(((awd)localObject1).trP);
                      localObject7 = new yy();
                      ((yy)localObject7).YG(((awd)localObject1).trP);
                      ((yj)localObject4).b((yy)localObject7);
                    }
                    paramMenuItem = this.activity;
                    localObject3 = af.bDF().OB(this.por);
                  } while (localObject3 == null);
                  Object localObject1 = new Intent();
                  if (((n)localObject3).bGe().tNr.sPI == 1)
                  {
                    paramInt = 0;
                    if ((this.poq.getTag() instanceof com.tencent.mm.plugin.sns.ui.aj)) {
                      paramInt = ((ao)this.poq.getTag()).index;
                    }
                    localObject3 = com.tencent.mm.plugin.sns.model.aj.a((n)localObject3, paramInt);
                    if (localObject3 == null)
                    {
                      y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                      return;
                    }
                    localObject4 = ((awd)localObject3).lsK;
                    ((Intent)localObject1).putExtra("sns_send_data_ui_image_path", FlipView.g(an.eJ(af.getAccSnsPath(), (String)localObject4) + com.tencent.mm.plugin.sns.data.i.l((awd)localObject3), paramMenuItem));
                    ((Intent)localObject1).putExtra("sns_send_data_ui_image_position", paramInt);
                  }
                  while (((((n)localObject3).bGe().tNr.sPI != 4) && (((n)localObject3).bGe().tNr.sPI != 15) && (((n)localObject3).bGe().tNr.sPI != 3)) || ((awd)((n)localObject3).bGe().tNr.sPJ.get(0) != null))
                  {
                    ((Intent)localObject1).putExtra("exdevice_open_scene_type", 1);
                    ((Intent)localObject1).putExtra("sns_local_id", this.por);
                    ((Intent)localObject1).putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.br.d.e(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", (Intent)localObject1);
                    return;
                  }
                  y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                  return;
                  paramMenuItem = af.bDF().OB(this.por);
                  if (paramMenuItem == null)
                  {
                    y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                    return;
                  }
                  if (paramMenuItem.yr(32))
                  {
                    y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                    return;
                  }
                  localObject1 = (awd)paramMenuItem.bGe().tNr.sPJ.get(0);
                  if (localObject1 == null)
                  {
                    y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                    return;
                  }
                  localObject3 = an.eJ(af.getAccSnsPath(), ((awd)localObject1).lsK);
                  paramMenuItem = "";
                  localObject4 = com.tencent.mm.plugin.sns.data.i.j((awd)localObject1);
                  if (com.tencent.mm.vfs.e.bK((String)localObject3 + (String)localObject4)) {
                    paramMenuItem = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.e((awd)localObject1);
                  }
                  if (com.tencent.mm.vfs.e.bK((String)localObject3 + com.tencent.mm.plugin.sns.data.i.p((awd)localObject1))) {
                    paramMenuItem = (String)localObject3 + com.tencent.mm.plugin.sns.data.i.n((awd)localObject1);
                  }
                  localObject1 = new Intent();
                  ((Intent)localObject1).setClass(this.activity, SnsOnlineVideoActivity.class);
                  ((Intent)localObject1).putExtra("intent_thumbpath", paramMenuItem);
                  ((Intent)localObject1).putExtra("intent_localid", this.por);
                  ((Intent)localObject1).putExtra("intent_from_scene", this.source);
                  ((Intent)localObject1).putExtra("intent_ismute", true);
                  if (this.poq != null)
                  {
                    paramMenuItem = new int[2];
                    this.poq.getLocationInWindow(paramMenuItem);
                    paramInt = this.poq.getWidth();
                    i = this.poq.getHeight();
                    ((Intent)localObject1).putExtra("img_gallery_left", paramMenuItem[0]);
                    ((Intent)localObject1).putExtra("img_gallery_top", paramMenuItem[1]);
                    ((Intent)localObject1).putExtra("img_gallery_width", paramInt);
                    ((Intent)localObject1).putExtra("img_gallery_height", i);
                  }
                  this.activity.startActivity((Intent)localObject1);
                  this.activity.overridePendingTransition(0, 0);
                  return;
                  this.oOe.bDk().eP(this.por, this.pot.lsK);
                  paramMenuItem = this.pot.tNr.kSC;
                  localObject1 = this.pot.tNq.lsK;
                  localObject1 = au.Pr(paramMenuItem);
                  if (bk.bl((String)localObject1))
                  {
                    y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    return;
                  }
                  paramMenuItem = new cj();
                  localObject3 = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
                  if (localObject3 != null)
                  {
                    localObject4 = u.ij(((n)localObject3).field_snsId);
                    localObject5 = u.Hc().v((String)localObject4, true);
                    ((u.b)localObject5).h("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
                    ((u.b)localObject5).h("preUsername", ((n)localObject3).field_userName);
                    ((u.b)localObject5).h("preChatName", "");
                    ((u.b)localObject5).h("url", localObject1);
                    ((u.b)localObject5).h("preMsgIndex", Integer.valueOf(0));
                    ((u.b)localObject5).h("sendAppMsgScene", Integer.valueOf(1));
                    ((u.b)localObject5).h("adExtStr", ((n)localObject3).bGe().oPO);
                    paramMenuItem.bIw.bIB = ((String)localObject4);
                  }
                  localObject4 = af.bDF().OB(this.por);
                  if ((localObject4 != null) && (this.pot.tNr.sPI == 18)) {
                    j.a(j.d.omk, j.c.ome, j.e.omp, 0, (n)localObject4, this.source);
                  }
                  if (!bk.bl(this.pot.pjl))
                  {
                    Ps(((n)localObject4).bGE());
                    return;
                  }
                  if (((n)localObject4).yr(32))
                  {
                    i = this.source;
                    if (this.source != 0) {
                      break label2291;
                    }
                  }
                  for (paramInt = 1;; paramInt = 2)
                  {
                    com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, ((n)localObject3).field_snsId, 11, 0));
                    com.tencent.mm.plugin.sns.i.a.a(paramMenuItem, (String)localObject1, this.por);
                    paramMenuItem.bIw.activity = this.activity;
                    paramMenuItem.bIw.bID = 28;
                    com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
                    if (paramMenuItem.bIx.ret != 0) {
                      break;
                    }
                    l = bk.UX();
                    if (bk.bl((String)localObject1)) {
                      break;
                    }
                    y.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), localObject1, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                    paramMenuItem = "";
                    try
                    {
                      localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
                      paramMenuItem = (MenuItem)localObject1;
                    }
                    catch (UnsupportedEncodingException localUnsupportedEncodingException)
                    {
                      for (;;)
                      {
                        y.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", localUnsupportedEncodingException, "", new Object[0]);
                      }
                    }
                    com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
                    return;
                  }
                  this.oOe.bDk().eP(this.por, this.pot.lsK);
                } while (this.pot == null);
                paramMenuItem = new cj();
                localObject5 = this.pot;
                if (localObject5 == null)
                {
                  y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                  paramMenuItem.bIw.bIC = i.j.favorite_fail_argument_error;
                }
                for (;;)
                {
                  paramMenuItem.bIw.activity = this.activity;
                  paramMenuItem.bIw.bID = 26;
                  com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
                  return;
                  localObject2 = new yj();
                  localObject3 = new yp();
                  localObject4 = new yi();
                  ((yp)localObject3).Yq(((bxk)localObject5).hPY);
                  ((yp)localObject3).Yr(q.Gj());
                  ((yp)localObject3).EQ(2);
                  ((yp)localObject3).hl(bk.UY());
                  if (((bxk)localObject5).tNq != null) {
                    ((yp)localObject3).Yw(((bxk)localObject5).tNq.lsK);
                  }
                  if (((bxk)localObject5).tNr != null)
                  {
                    ((yi)localObject4).Yj(((bxk)localObject5).tNr.bGw);
                    ((yi)localObject4).Yk(((bxk)localObject5).tNr.kRN);
                    if ((((bxk)localObject5).tNr.sPJ != null) && (!((bxk)localObject5).tNr.sPJ.isEmpty()))
                    {
                      localObject5 = (awd)((bxk)localObject5).tNr.sPJ.get(0);
                      ((yi)localObject4).EN(((awd)localObject5).brC);
                      ((yi)localObject4).Ym(((awd)localObject5).oOw);
                      ((yi)localObject4).Yl(((awd)localObject5).trP);
                    }
                  }
                  paramMenuItem.bIw.title = ((yi)localObject4).title;
                  paramMenuItem.bIw.desc = ((yi)localObject4).desc;
                  paramMenuItem.bIw.bIy = ((yj)localObject2);
                  paramMenuItem.bIw.type = 10;
                  ((yj)localObject2).a((yp)localObject3);
                  ((yj)localObject2).b((yi)localObject4);
                }
                this.oOe.bDk().eP(this.por, this.pot.lsK);
              } while (this.pot == null);
              paramMenuItem = new cj();
              localObject5 = this.pot;
              if (localObject5 == null)
              {
                y.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                paramMenuItem.bIw.bIC = i.j.favorite_fail_argument_error;
              }
              for (;;)
              {
                paramMenuItem.bIw.activity = this.activity;
                paramMenuItem.bIw.bID = 27;
                com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
                return;
                localObject2 = new yj();
                localObject3 = new yp();
                localObject4 = new ys();
                ((yp)localObject3).Yq(((bxk)localObject5).hPY);
                ((yp)localObject3).Yr(q.Gj());
                ((yp)localObject3).EQ(8);
                ((yp)localObject3).hl(bk.UY());
                if (((bxk)localObject5).tNq != null) {
                  ((yp)localObject3).Yw(((bxk)localObject5).tNq.lsK);
                }
                if (((bxk)localObject5).tNr != null)
                {
                  ((ys)localObject4).Yz(((bxk)localObject5).tNr.bGw);
                  ((ys)localObject4).YA(((bxk)localObject5).tNr.kRN);
                  if ((((bxk)localObject5).tNr.sPJ != null) && (!((bxk)localObject5).tNr.sPJ.isEmpty()))
                  {
                    localObject5 = (awd)((bxk)localObject5).tNr.sPJ.get(0);
                    ((ys)localObject4).YC(((awd)localObject5).oOw);
                    ((ys)localObject4).YB(((awd)localObject5).trP);
                  }
                }
                paramMenuItem.bIw.title = ((ys)localObject4).title;
                paramMenuItem.bIw.desc = ((ys)localObject4).desc;
                paramMenuItem.bIw.bIy = ((yj)localObject2);
                paramMenuItem.bIw.type = 15;
                ((yj)localObject2).a((yp)localObject3);
                ((yj)localObject2).b((ys)localObject4);
              }
              paramMenuItem = af.bDF().OB(this.por).bGk();
              localObject2 = (l)this.poq.getTag();
              if (v.OT(paramMenuItem))
              {
                paramMenuItem = new r(v.OU(paramMenuItem), 6, ((l)localObject2).oqc);
                com.tencent.mm.kernel.g.DQ();
                com.tencent.mm.kernel.g.DO().dJT.a(paramMenuItem, 0);
              }
              for (;;)
              {
                localObject2 = this.activity;
                this.activity.getString(i.j.app_tip);
                this.oNQ = com.tencent.mm.ui.base.h.b((Context)localObject2, this.activity.getString(i.j.sns_deling_sns), true, new a.1(this, paramMenuItem));
                return;
                paramMenuItem = new r(v.OU(paramMenuItem), 4, ((l)localObject2).oqc);
                com.tencent.mm.kernel.g.DQ();
                com.tencent.mm.kernel.g.DO().dJT.a(paramMenuItem, 0);
              }
              paramMenuItem = af.bDF().OB(this.por);
            } while (paramMenuItem == null);
            com.tencent.mm.plugin.sns.abtest.a.b(paramMenuItem);
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("sns_permission_snsinfo_svr_id", paramMenuItem.field_snsId);
            ((Intent)localObject2).putExtra("sns_permission_userName", paramMenuItem.field_userName);
            ((Intent)localObject2).putExtra("sns_permission_anim", true);
            ((Intent)localObject2).setClass(this.activity, SnsPermissionUI.class);
            this.activity.startActivityForResult((Intent)localObject2, 11);
            return;
            this.oOe.bDk().eP(this.por, this.pot.lsK);
            paramMenuItem = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
            if ((paramMenuItem.yr(32)) && (paramMenuItem.bFZ().bEE()))
            {
              localObject2 = af.bDF().OB(this.por);
              if ((localObject2 != null) && (((n)localObject2).yr(32)))
              {
                i = this.source;
                if (this.source != 0) {
                  break label3373;
                }
              }
              for (paramInt = 1;; paramInt = 2)
              {
                com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0));
                Ps(this.por);
                return;
              }
            }
            paramMenuItem = this.por;
            paramMenuItem = af.bDF().OB(paramMenuItem);
          } while (paramMenuItem == null);
          if (paramMenuItem.yr(32))
          {
            j.a(j.d.omj, j.c.ome, j.e.omp, 0, paramMenuItem, this.source);
            i = this.source;
            if (this.source != 0) {
              break label3503;
            }
          }
          for (paramInt = 1;; paramInt = 2)
          {
            com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0));
            localObject2 = new cj();
            com.tencent.mm.plugin.sns.i.a.a((cj)localObject2, paramMenuItem);
            ((cj)localObject2).bIw.activity = this.activity;
            ((cj)localObject2).bIw.bID = 29;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
            return;
          }
          paramMenuItem = (awd)this.pot.tNr.sPJ.get(0);
          paramMenuItem = an.eJ(af.getAccSnsPath(), paramMenuItem.lsK) + com.tencent.mm.plugin.sns.data.i.e(paramMenuItem);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
          ((Intent)localObject2).putExtra("select_is_ret", true);
          ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
          ((Intent)localObject2).putExtra("image_path", paramMenuItem);
          ((Intent)localObject2).putExtra("Retr_Msg_Type", 11);
          com.tencent.mm.br.d.c(this.activity, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 15);
          return;
        } while (!(this.poq.getTag() instanceof l));
        paramMenuItem = (l)this.poq.getTag();
        this.kgn.setText(paramMenuItem.kVs);
        com.tencent.mm.ui.base.h.bC(this.activity, this.activity.getString(i.j.app_copy_ok));
      } while (paramMenuItem.oqc == null);
      localObject2 = com.tencent.mm.plugin.secinforeport.a.a.nQo;
      com.tencent.mm.plugin.secinforeport.a.a.f(4, this.pot.lsK + ":" + paramMenuItem.oqc.tJu, bk.ZH(paramMenuItem.kVs));
      return;
      paramMenuItem = af.bDF().OB(this.por);
      com.tencent.mm.plugin.sns.abtest.a.a(this.activity, paramMenuItem);
      return;
      localObject2 = af.bDF().OB(this.por);
      if (localObject2 != null) {
        if (this.source != 0) {
          break label3843;
        }
      }
      for (paramMenuItem = com.tencent.mm.modelsns.b.jd(714);; paramMenuItem = com.tencent.mm.modelsns.b.je(714))
      {
        paramMenuItem.ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject2)).jg(((n)localObject2).field_type).cb(((n)localObject2).yr(32)).ni(((n)localObject2).bGM());
        paramMenuItem.QX();
        ap.r((n)localObject2);
        return;
      }
    } while (!(this.poq.getTag() instanceof l));
    label3373:
    label3503:
    Object localObject2 = (l)this.poq.getTag();
    label3843:
    Object localObject3 = af.bDF().OA(((l)localObject2).oOn);
    if (localObject3 != null)
    {
      if (this.source != 0) {
        break label4014;
      }
      paramMenuItem = com.tencent.mm.modelsns.b.jd(715);
      paramMenuItem.ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject3)).jg(((n)localObject3).field_type).cb(((n)localObject3).yr(32)).ni(((n)localObject3).bGM());
      if (((l)localObject2).oqc == null) {
        break label4050;
      }
      if (((l)localObject2).oqc.tJu != 0) {
        break label4024;
      }
      localObject2 = ((l)localObject2).oqc.tJx;
      label3988:
      paramMenuItem.ni((String)localObject2);
    }
    for (;;)
    {
      paramMenuItem.QX();
      ap.a((l)this.poq.getTag());
      return;
      label4014:
      paramMenuItem = com.tencent.mm.modelsns.b.je(715);
      break;
      label4024:
      localObject2 = ((l)localObject2).oqc.tJu;
      break label3988;
      label4050:
      paramMenuItem.ni("");
    }
    this.oOe.bDk().eP(this.por, this.pot.lsK);
    paramMenuItem = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
    if ((paramMenuItem.yr(32)) && (paramMenuItem.bFZ().bEE()))
    {
      localObject2 = af.bDF().OB(this.por);
      if ((localObject2 != null) && (((n)localObject2).yr(32)) && (this.pot != null))
      {
        i = this.source;
        if (this.source != 0) {
          break label4186;
        }
      }
      label4186:
      for (paramInt = 1;; paramInt = 2)
      {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, paramMenuItem.field_snsId, 11, 0));
        Ps(this.por);
        return;
      }
    }
    paramMenuItem = this.por;
    localObject3 = af.bDF().OB(paramMenuItem);
    localObject2 = null;
    paramMenuItem = (MenuItem)localObject2;
    if (localObject3 != null)
    {
      paramMenuItem = (MenuItem)localObject2;
      if (((n)localObject3).yr(32))
      {
        localObject2 = ((n)localObject3).bGL();
        paramMenuItem = (MenuItem)localObject2;
        if (bk.bl((String)localObject2)) {
          paramMenuItem = ((n)localObject3).getAdLink();
        }
      }
    }
    if (bk.bl(paramMenuItem))
    {
      paramMenuItem = this.pot.tNr.kSC;
      localObject2 = this.pot.tNq.lsK;
      paramMenuItem = au.Pr(paramMenuItem);
    }
    for (;;)
    {
      if (bk.bl(paramMenuItem))
      {
        y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
        return;
      }
      localObject2 = new cj();
      localObject4 = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
      if (localObject4 != null)
      {
        localObject5 = u.ij(((n)localObject4).field_snsId);
        localObject6 = u.Hc().v((String)localObject5, true);
        ((u.b)localObject6).h("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject4).field_snsId));
        ((u.b)localObject6).h("preUsername", ((n)localObject4).field_userName);
        ((u.b)localObject6).h("preChatName", "");
        ((u.b)localObject6).h("url", paramMenuItem);
        ((u.b)localObject6).h("preMsgIndex", Integer.valueOf(0));
        ((u.b)localObject6).h("sendAppMsgScene", Integer.valueOf(1));
        ((u.b)localObject6).h("adExtStr", ((n)localObject4).bGe().oPO);
        ((cj)localObject2).bIw.bIB = ((String)localObject5);
      }
      if ((localObject3 != null) && ((this.pot.tNr.sPI == 18) || (((n)localObject3).yr(32))))
      {
        j.a(j.d.omk, j.c.ome, j.e.omp, 0, (n)localObject3, this.source);
        if (this.pot != null)
        {
          i = this.source;
          if (this.source != 0) {
            break label4596;
          }
        }
      }
      label4596:
      for (paramInt = 1;; paramInt = 2)
      {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(i, paramInt, ((n)localObject4).field_snsId, 11, 0));
        if (bk.bl(this.pot.pjl)) {
          break;
        }
        Ps(((n)localObject3).bGE());
        return;
      }
      com.tencent.mm.plugin.sns.i.a.a((cj)localObject2, paramMenuItem, this.por);
      ((cj)localObject2).bIw.activity = this.activity;
      ((cj)localObject2).bIw.bID = 28;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      if (((cj)localObject2).bIx.ret != 0) {
        break;
      }
      l = bk.UX();
      if (bk.bl(paramMenuItem)) {
        break;
      }
      y.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[] { Integer.valueOf(13378), paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
      localObject2 = "";
      try
      {
        paramMenuItem = URLEncoder.encode(paramMenuItem, "UTF-8");
        com.tencent.mm.plugin.report.service.h.nFQ.f(13378, new Object[] { paramMenuItem, Long.valueOf(l), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1) });
        return;
      }
      catch (UnsupportedEncodingException paramMenuItem)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", paramMenuItem, "", new Object[0]);
          paramMenuItem = (MenuItem)localObject2;
        }
      }
      ap.s(af.bDF().OB(this.por));
      return;
      if (!(this.poq.getTag() instanceof l)) {
        break;
      }
      ap.b((l)this.poq.getTag());
      return;
      localObject3 = com.tencent.mm.plugin.sns.storage.h.OB(this.por);
      if (localObject3 == null)
      {
        y.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
        return;
      }
      localObject2 = (ao)this.poq.getTag();
      localObject4 = this.activity;
      localObject5 = paramMenuItem.getIntent();
      if (this.source == 0) {}
      for (paramInt = 1;; paramInt = 2)
      {
        i = this.source;
        paramMenuItem = this.oOe;
        if (localObject5 != null) {
          break;
        }
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
        return;
      }
      if (paramMenuItem == null)
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
        return;
      }
      if (localObject3 == null)
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
        return;
      }
      com.tencent.mm.kernel.g.DQ();
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
        return;
      }
      localObject6 = ((ao)localObject2).bMB;
      int j = ((ao)localObject2).index;
      int k = ((ao)localObject2).position;
      localObject2 = ((n)localObject3).bGe();
      if ((((bxk)localObject2).tNr == null) || (((bxk)localObject2).tNr.sPJ.size() == 0))
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
        return;
      }
      paramMenuItem.bDk().y((n)localObject3);
      localObject7 = ((n)localObject3).bGe();
      if (j < ((bxk)localObject7).tNr.sPJ.size()) {}
      for (paramMenuItem = (awd)((bxk)localObject7).tNr.sPJ.get(j); !af.bDC().B(paramMenuItem); paramMenuItem = new awd())
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(paramMenuItem.onc) });
        return;
      }
      if (paramInt == 1)
      {
        localObject2 = com.tencent.mm.modelsns.b.jd(716);
        ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject3)).jg(((n)localObject3).field_type).cb(((n)localObject3).yr(32)).ni(((n)localObject3).bGM()).ni(paramMenuItem.lsK).jg(j).jg(((bxk)localObject7).tNr.sPJ.size());
        ((com.tencent.mm.modelsns.b)localObject2).QX();
        if (paramInt != 1) {
          break label5467;
        }
      }
      label5467:
      for (paramMenuItem = com.tencent.mm.modelsns.b.jd(744);; paramMenuItem = com.tencent.mm.modelsns.b.je(744))
      {
        paramMenuItem.ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject3)).jg(((n)localObject3).field_type).cb(((n)localObject3).yr(32)).ni(((n)localObject3).bGM());
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
        paramMenuItem.putString("stat_msg_id", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
        paramMenuItem.putString("stat_send_msg_user", ((n)localObject3).field_userName);
        ((Intent)localObject5).putExtra("_stat_obj", paramMenuItem);
        ((Activity)localObject4).startActivity((Intent)localObject5);
        ((Activity)localObject4).overridePendingTransition(0, 0);
        return;
        localObject2 = com.tencent.mm.modelsns.b.je(716);
        break;
      }
      if (this.pot == null)
      {
        y.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
        return;
      }
      paramMenuItem = new cj();
      com.tencent.mm.plugin.sns.i.a.b(paramMenuItem, this.por);
      paramMenuItem.bIw.activity = this.activity;
      paramMenuItem.bIw.bID = 28;
      com.tencent.mm.sdk.b.a.udP.m(paramMenuItem);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
    if ((this.oNQ != null) && (this.oNQ.isShowing())) {
      this.oNQ.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a
 * JD-Core Version:    0.7.0.1
 */