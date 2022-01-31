package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.da;
import com.tencent.mm.h.a.da.b;
import com.tencent.mm.h.a.de;
import com.tencent.mm.h.a.de.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.ah.f, com.tencent.mm.pluginsdk.b.a
{
  public long diQ;
  com.tencent.mm.ui.base.preference.f dnn;
  public ad dnp;
  private List<com.tencent.mm.ai.d.a> eeV;
  private d.b eeW;
  private String eff;
  public long endTime;
  public int fhj;
  public String kzG;
  boolean mVI;
  private String mVN;
  public com.tencent.mm.ai.d mVy;
  public List<WxaAttributes.WxaEntryInfo> mWM;
  private sg mWN;
  private int mWR = 0;
  private Bundle mWV;
  SnsAdClick mWW = null;
  private String mWX = null;
  ContactInfoUI mZy;
  public com.tencent.mm.plugin.profile.ui.newbizinfo.b.d mZz;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  public b(ContactInfoUI paramContactInfoUI, String paramString, sg paramsg)
  {
    this.mZy = paramContactInfoUI;
    this.mVN = paramString;
    this.mWN = paramsg;
  }
  
  private boolean bsA()
  {
    if (this.mZy.getIntent() == null) {
      return false;
    }
    String str1 = this.mZy.getIntent().getStringExtra("device_id");
    String str2 = this.mZy.getIntent().getStringExtra("device_type");
    de localde = new de();
    localde.bJr.bwK = str1;
    localde.bJr.bJp = str2;
    com.tencent.mm.sdk.b.a.udP.m(localde);
    return localde.bJs.bJt;
  }
  
  private boolean bsR()
  {
    boolean bool = true;
    try
    {
      String str = this.eeW.LO();
      if (bk.bl(str)) {
        return false;
      }
      long l = bk.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        y.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool) });
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception localException) {}
  }
  
  private com.tencent.mm.ai.d.a bsS()
  {
    if ((this.eeV == null) || (this.eeV.size() < 0))
    {
      y.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
      return null;
    }
    Iterator localIterator = this.eeV.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.ai.d.a locala = (com.tencent.mm.ai.d.a)localIterator.next();
      if (locala.eeZ.equals("__mp_wording__brandinfo_history_massmsg")) {
        return locala;
      }
    }
    y.w("MicroMsg.ContactWidgetNewBizInfo", "brandInfoList is null not show all message");
    return null;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label441;
      }
      bool = true;
      label28:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label447;
      }
      bool = true;
      label40:
      Assert.assertTrue(bool);
      this.dnn = paramf;
      this.dnp = paramad;
      this.mVI = paramBoolean;
      this.fhj = paramInt;
      this.mWW = ((SnsAdClick)this.mZy.getIntent().getParcelableExtra("KSnsAdTag"));
      this.mWX = this.mZy.getIntent().getStringExtra("key_add_contact_report_info");
      this.mWR = this.mZy.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.mWV = this.mZy.getIntent().getBundleExtra("Contact_Ext_Args");
      this.mZy.setMMTitle("");
      this.mZy.oX(-16777216);
      com.tencent.mm.ui.s.czy();
      this.mZy.mS(false);
      this.mZy.ta(-1);
      if (Build.VERSION.SDK_INT >= 21) {
        com.tencent.mm.ui.statusbar.a.d(this.mZy.mController.uMz, this.mZy.getWindow().getStatusBarColor(), com.tencent.mm.ui.statusbar.d.c(this.mZy.getWindow()));
      }
      this.mZy.czo();
      this.mZy.setBackBtn(new b.1(this), R.k.actionbar_icon_dark_back);
      paramf = this.mZy.getResources().getDrawable(R.g.mm_title_btn_menu);
      paramf.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      this.mZy.a(0, "", paramf, new b.2(this));
      this.mZz = com.tencent.mm.plugin.profile.b.bsq().Lb(this.dnp.field_username);
      bsx();
      paramf = paramad.field_username;
      if (this.mZz == null) {
        break label459;
      }
      localObject1 = this.mZz;
      if (System.currentTimeMillis() - ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject1).field_cacheTime >= 60000L) {
        break label453;
      }
    }
    label441:
    label447:
    label453:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label459;
      }
      y.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      paramf = this.mZy.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
      if (!bk.bl(paramf))
      {
        this.mZy.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
        com.tencent.mm.ui.base.h.a(this.mZy, paramf, "", this.mZy.getString(R.l.app_ok), null);
      }
      if (paramad != null) {
        z.MK().kC(paramad.field_username);
      }
      return true;
      bool = false;
      break;
      bool = false;
      break label28;
      bool = false;
      break label40;
    }
    label459:
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecG = 2656;
    ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofile";
    ((b.a)localObject1).ecJ = 0;
    ((b.a)localObject1).ecK = 0;
    Object localObject2 = new jc();
    ((jc)localObject2).sCE = paramf;
    ((b.a)localObject1).ecH = ((com.tencent.mm.bv.a)localObject2);
    ((b.a)localObject1).ecI = new jd();
    localObject1 = ((b.a)localObject1).Kt();
    localObject2 = new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
      {
        y.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        paramAnonymousString = (jd)paramAnonymousb.ecF.ecN;
        boolean bool;
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
        {
          y.d("MicroMsg.ContactWidgetNewBizInfo", "BizProfileResp:%d", new Object[] { Integer.valueOf(paramAnonymousString.sAP.size()) });
          b.this.mZz = com.tencent.mm.plugin.profile.ui.newbizinfo.b.d.a(b.this.dnp.field_username, paramAnonymousString);
          if (b.this.mZz != null)
          {
            paramAnonymousString = com.tencent.mm.plugin.profile.b.bsq();
            paramAnonymousb = b.this.mZz;
            if (paramAnonymousb != null) {
              break label210;
            }
            y.e("MicroMsg.ProfileInfoStorage", "profileInfo is null, err");
            bool = false;
          }
        }
        for (;;)
        {
          y.i("MicroMsg.ContactWidgetNewBizInfo", "username:%s insert db :%b", new Object[] { b.this.mZz.field_username, Boolean.valueOf(bool) });
          b.this.bsx();
          paramAnonymousString = b.this;
          if ((paramAnonymousString.dnp != null) && (paramAnonymousString.mVy != null) && (paramAnonymousString.mZz != null)) {
            break;
          }
          y.w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
          return 0;
          label210:
          paramAnonymousm = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.d();
          paramAnonymousm.field_username = paramAnonymousb.field_username;
          bool = paramAnonymousString.b(paramAnonymousm, new String[0]);
          y.i("MicroMsg.ProfileInfoStorage", "insertOrUpdate username:%s", new Object[] { paramAnonymousb.field_username });
          if (bool) {
            bool = paramAnonymousString.c(paramAnonymousb, new String[0]);
          } else {
            bool = paramAnonymousString.b(paramAnonymousb);
          }
        }
        paramAnonymousb = paramAnonymousString.dnp.field_username;
        int i = paramAnonymousString.fhj;
        int j = paramAnonymousString.mVy.field_type;
        long l = paramAnonymousString.diQ;
        label336:
        int k;
        int m;
        if (com.tencent.mm.n.a.gR(paramAnonymousString.dnp.field_type))
        {
          paramAnonymousInt1 = 1;
          k = paramAnonymousString.mZz.field_originalArticleCount;
          m = paramAnonymousString.mZz.field_friendSubscribeCount;
          if (paramAnonymousString.mWM == null) {
            break label526;
          }
        }
        label526:
        for (paramAnonymousInt2 = paramAnonymousString.mWM.size();; paramAnonymousInt2 = 0)
        {
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(paramAnonymousb, i, j, l, paramAnonymousInt1, k, m, paramAnonymousInt2, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bY(paramAnonymousString.mZz.bsV()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bZ(paramAnonymousString.mZz.bsW()), paramAnonymousString.mZz.field_decryptUserName);
          if ((paramAnonymousString.mZz != null) && (paramAnonymousString.mZz.bsZ())) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(paramAnonymousString.dnp.field_username, 104);
          }
          if ((paramAnonymousString.mZz != null) && (paramAnonymousString.mZz.bsY())) {
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(paramAnonymousString.dnp.field_username, 101);
          }
          if ((paramAnonymousString.mZz == null) || (!paramAnonymousString.isNormal()) || (paramAnonymousString.mWM == null) || (paramAnonymousString.mWM.size() <= 0)) {
            break;
          }
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(paramAnonymousString.dnp.field_username, 105);
          break;
          paramAnonymousInt1 = 0;
          break label336;
        }
      }
    };
    if ((this.mZy instanceof com.tencent.mm.vending.e.b)) {}
    for (paramf = this.mZy;; paramf = null)
    {
      w.a((com.tencent.mm.ah.b)localObject1, (w.a)localObject2, false, paramf);
      break;
    }
  }
  
  public final boolean awZ()
  {
    NewBizInfoHeaderPreference localNewBizInfoHeaderPreference = (NewBizInfoHeaderPreference)this.dnn.add("contact_info_header_newbizinfo");
    if (localNewBizInfoHeaderPreference != null) {
      localNewBizInfoHeaderPreference.onDetach();
    }
    return true;
  }
  
  final void bsx()
  {
    awZ();
    Object localObject2 = com.tencent.mm.ai.f.kX(this.dnp.field_username);
    this.eeV = null;
    this.eeW = null;
    this.mWM = null;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((com.tencent.mm.ai.d)localObject2).bS(false) != null) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.mWN != null)
      {
        localObject1 = new com.tencent.mm.ai.d();
        ((com.tencent.mm.ai.d)localObject1).field_username = this.dnp.field_username;
        ((com.tencent.mm.ai.d)localObject1).field_brandFlag = this.mWN.ffv;
        ((com.tencent.mm.ai.d)localObject1).field_brandIconURL = this.mWN.ffy;
        ((com.tencent.mm.ai.d)localObject1).field_brandInfo = this.mWN.ffx;
        ((com.tencent.mm.ai.d)localObject1).field_extInfo = this.mWN.ffw;
        ((com.tencent.mm.ai.d)localObject1).field_type = ((com.tencent.mm.ai.d)localObject1).bS(false).LW();
      }
    }
    if ((localObject1 != null) && (((com.tencent.mm.ai.d)localObject1).field_brandInfo == null) && (((com.tencent.mm.ai.d)localObject1).field_extInfo == null) && (this.mWN != null))
    {
      ((com.tencent.mm.ai.d)localObject1).field_username = this.dnp.field_username;
      ((com.tencent.mm.ai.d)localObject1).field_brandFlag = this.mWN.ffv;
      ((com.tencent.mm.ai.d)localObject1).field_brandIconURL = this.mWN.ffy;
      ((com.tencent.mm.ai.d)localObject1).field_brandInfo = this.mWN.ffx;
      ((com.tencent.mm.ai.d)localObject1).field_extInfo = this.mWN.ffw;
      ((com.tencent.mm.ai.d)localObject1).field_type = ((com.tencent.mm.ai.d)localObject1).bS(false).LW();
    }
    if (localObject1 != null)
    {
      this.mVy = ((com.tencent.mm.ai.d)localObject1);
      this.eeV = ((com.tencent.mm.ai.d)localObject1).LH();
      this.eeW = ((com.tencent.mm.ai.d)localObject1).bS(false);
      this.mWM = this.eeW.getWxaEntryInfoList();
      if ((this.eeW.LL() != null) && (this.eeW.LL().length() > 0)) {
        this.eff = this.eeW.LL();
      }
    }
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.contact_info_pref_newbizinfo);
    Object localObject1 = (NewBizInfoHeaderPreference)this.dnn.add("contact_info_header_newbizinfo");
    Object localObject3;
    Object localObject4;
    if ((localObject1 != null) && (!bk.bl(this.dnp.field_username)))
    {
      localObject2 = this.dnp;
      localObject3 = this.mVN;
      localObject4 = this.mVy;
      ((NewBizInfoHeaderPreference)localObject1).onDetach();
      ((NewBizInfoHeaderPreference)localObject1).mVx = ((String)localObject3);
      ((NewBizInfoHeaderPreference)localObject1).mVy = ((com.tencent.mm.ai.d)localObject4);
      ((NewBizInfoHeaderPreference)localObject1).dnp = ((ad)localObject2);
      au.Hx();
      com.tencent.mm.model.c.Fw().a((m.b)localObject1);
      o.JQ().d((com.tencent.mm.ag.d.a)localObject1);
      ((NewBizInfoHeaderPreference)localObject1).initView();
      ((NewBizInfoDescPreference)this.dnn.add("contact_info_desc_newbizinfo")).mZz = this.mZz;
      if (!com.tencent.mm.n.a.gR(this.dnp.field_type)) {
        break label1312;
      }
      this.dnn.bJ("contact_info_biz_add", true);
      this.dnn.bJ("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.dnn.add("contact_info_biz_go_chatting")).mVH = this;
      label488:
      if ((this.mZz != null) && (isNormal())) {
        break label1379;
      }
      this.dnn.bJ("contact_info_biz_loading", false);
      localObject1 = (NewBizInfoLoadingPreference)this.dnn.add("contact_info_biz_loading");
      localObject2 = this.mZz;
      boolean bool = bsR();
      ((NewBizInfoLoadingPreference)localObject1).mZz = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject2);
      ((NewBizInfoLoadingPreference)localObject1).mZK = bool;
      if ((((NewBizInfoLoadingPreference)localObject1).mZz == null) || (((NewBizInfoLoadingPreference)localObject1).mZz.isNormal())) {
        break label1341;
      }
      ((NewBizInfoLoadingPreference)localObject1).state = 2;
      label573:
      ((NewBizInfoLoadingPreference)localObject1).initView();
      label577:
      if ((this.mZz != null) && (!isNormal()) && (!com.tencent.mm.n.a.gR(this.dnp.field_type))) {
        this.mZy.showOptionMenu(false);
      }
      if ((this.mZz == null) || (!this.mZz.bsZ())) {
        break label1681;
      }
      this.dnn.bJ("contact_info_biz_menu_newbizinfo", false);
      if (this.mZz != null)
      {
        localObject1 = (NewBizInfoMenuPreference)this.dnn.add("contact_info_biz_menu_newbizinfo");
        localObject2 = this.mZz;
        localObject3 = this.dnp;
        if (localObject2 != null)
        {
          ((NewBizInfoMenuPreference)localObject1).dnp = ((ad)localObject3);
          ((NewBizInfoMenuPreference)localObject1).mZz = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject2);
          localObject3 = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject2).bsW();
          localObject2 = new ArrayList();
          if (localObject3 != null) {
            break label1395;
          }
          y.e("MicroMsg.NewBizInfoUtil", "serviceInfoList is null, err");
          label719:
          ((NewBizInfoMenuPreference)localObject1).mZM = ((List)localObject2);
          if ((((NewBizInfoMenuPreference)localObject1).mZz == null) || (((NewBizInfoMenuPreference)localObject1).mZz.isNormal())) {
            break label1585;
          }
          ((NewBizInfoMenuPreference)localObject1).state = 4;
          label746:
          ((NewBizInfoMenuPreference)localObject1).initView();
        }
      }
      label750:
      if ((this.mZz == null) || (!this.mZz.bsY())) {
        break label1768;
      }
      this.dnn.bJ("contact_info_message_newbizinfo", false);
      localObject1 = (NewBizInfoMessagePreference)this.dnn.add("contact_info_message_newbizinfo");
      localObject2 = this.mZz;
      if (localObject2 != null)
      {
        ((NewBizInfoMessagePreference)localObject1).mZz = ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject2);
        ((NewBizInfoMessagePreference)localObject1).mZQ = new NewBizInfoMessagePreference.a(((NewBizInfoMessagePreference)localObject1).bER, ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.d)localObject2).bsV());
        if ((((NewBizInfoMessagePreference)localObject1).mZz == null) || (((NewBizInfoMessagePreference)localObject1).mZz.isNormal())) {
          break label1697;
        }
        ((NewBizInfoMessagePreference)localObject1).state = 4;
        label851:
        ((NewBizInfoMessagePreference)localObject1).initView();
      }
      label855:
      if ((this.mZz == null) || (!this.mZz.bsX()) || (bsS() == null)) {
        break label1784;
      }
      this.dnn.bJ("contact_info_all_message_newbizinfo", false);
      ((NewBizInfoAllMessagePreference)this.dnn.add("contact_info_all_message_newbizinfo")).mZz = this.mZz;
      label914:
      if ((this.mZz == null) || (!isNormal()) || (this.mWM == null) || (this.mWM.size() <= 0)) {
        break label1812;
      }
      this.dnn.bJ("contact_info_new_bindwxainfo", false);
      localObject1 = (NewBizBindWxaInfoPreference)this.dnn.add("contact_info_new_bindwxainfo");
      localObject2 = this.mVy;
      localObject3 = this.mWM;
      ((NewBizBindWxaInfoPreference)localObject1).mVy = ((com.tencent.mm.ai.d)localObject2);
      if (((NewBizBindWxaInfoPreference)localObject1).hoi != null) {
        break label1800;
      }
      ((NewBizBindWxaInfoPreference)localObject1).hoi = new LinkedList();
      label1010:
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((NewBizBindWxaInfoPreference)localObject1).hoi.addAll((Collection)localObject3);
      }
      ((NewBizBindWxaInfoPreference)localObject1).ju();
      label1041:
      y.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.mZy.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.mZy.getIntent() == null) || (!this.mZy.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label1852;
      }
      y.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      bool = bsA();
      y.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.gR(this.dnp.field_type)), Boolean.valueOf(bool) });
      if ((!com.tencent.mm.n.a.gR(this.dnp.field_type)) || (!bool))
      {
        y.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.dnp.field_username });
        if ((this.dnp == null) || ((!com.tencent.mm.model.s.hS(this.dnp.field_username)) && (!com.tencent.mm.model.s.ic(this.dnp.field_username))) || (!com.tencent.mm.n.a.gR(this.dnp.field_type))) {
          break label1828;
        }
        this.dnn.bJ("contact_info_biz_go_chatting", false);
        localObject1 = this.dnn.add("contact_info_biz_add");
        this.dnn.bJ("contact_info_biz_add", false);
        if (localObject1 != null)
        {
          if (!bool) {
            break label1844;
          }
          ((Preference)localObject1).setTitle(R.l.contact_info_biz_new_follow);
        }
      }
    }
    label1312:
    label1341:
    label1379:
    label1395:
    label1784:
    while (!bsR())
    {
      for (;;)
      {
        return;
        y.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
        this.dnn.bJ("contact_info_header_bizinfo", true);
        break;
        this.dnn.bJ("contact_info_biz_add", false);
        this.dnn.bJ("contact_info_biz_go_chatting", true);
        break label488;
        if (((NewBizInfoLoadingPreference)localObject1).mZK)
        {
          ((NewBizInfoLoadingPreference)localObject1).state = 3;
          break label573;
        }
        if (((NewBizInfoLoadingPreference)localObject1).mZz != null)
        {
          ((NewBizInfoLoadingPreference)localObject1).state = 0;
          break label573;
        }
        ((NewBizInfoLoadingPreference)localObject1).state = 1;
        break label573;
        this.dnn.bJ("contact_info_biz_loading", true);
        break label577;
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (e)((Iterator)localObject3).next();
          if (((e)localObject4).type == 0)
          {
            Object localObject5 = ((e)localObject4).nap;
            ((e)localObject4).nap = new ArrayList();
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              e locale = (e)((Iterator)localObject5).next();
              if ((locale.type == 2) || (locale.type == 5)) {
                ((e)localObject4).nap.add(locale);
              }
            }
            if (((e)localObject4).nap.size() > 0) {
              ((List)localObject2).add(localObject4);
            }
          }
          else if (((e)localObject4).type == 2)
          {
            ((List)localObject2).add(localObject4);
          }
          else if (((e)localObject4).type == 5)
          {
            ((List)localObject2).add(localObject4);
          }
        }
        break label719;
        if ((((NewBizInfoMenuPreference)localObject1).mZz != null) && (((NewBizInfoMenuPreference)localObject1).mZz.bsZ()))
        {
          if ((((NewBizInfoMenuPreference)localObject1).mZz != null) && (((NewBizInfoMenuPreference)localObject1).mZM != null) && (((NewBizInfoMenuPreference)localObject1).mZM.size() <= 0))
          {
            ((NewBizInfoMenuPreference)localObject1).state = 2;
            break label746;
          }
          if ((((NewBizInfoMenuPreference)localObject1).mZz == null) || (((NewBizInfoMenuPreference)localObject1).mZM == null) || (((NewBizInfoMenuPreference)localObject1).mZz.bsW().size() <= 0)) {
            break label746;
          }
          ((NewBizInfoMenuPreference)localObject1).state = 3;
          break label746;
        }
        ((NewBizInfoMenuPreference)localObject1).state = 0;
        break label746;
        this.dnn.bJ("contact_info_biz_menu_newbizinfo", true);
        break label750;
        if ((((NewBizInfoMessagePreference)localObject1).mZz != null) && (((NewBizInfoMessagePreference)localObject1).mZz.bsY()))
        {
          if (((NewBizInfoMessagePreference)localObject1).mZz.bsV().size() <= 0)
          {
            ((NewBizInfoMessagePreference)localObject1).state = 2;
            break label851;
          }
          if (((NewBizInfoMessagePreference)localObject1).mZz.bsV().size() <= 0) {
            break label851;
          }
          ((NewBizInfoMessagePreference)localObject1).state = 3;
          break label851;
        }
        ((NewBizInfoMessagePreference)localObject1).state = 0;
        break label851;
        this.dnn.bJ("contact_info_message_newbizinfo", true);
        break label855;
        this.dnn.bJ("contact_info_all_message_newbizinfo", true);
        break label914;
        ((NewBizBindWxaInfoPreference)localObject1).hoi.clear();
        break label1010;
        this.dnn.bJ("contact_info_new_bindwxainfo", true);
        break label1041;
        this.dnn.bJ("contact_info_biz_go_chatting", true);
      }
      ((Preference)localObject1).setTitle(R.l.contact_info_biz_bind_exdevice);
      return;
    }
    label1585:
    label1768:
    this.dnn.bJ("contact_info_biz_loading", false);
    label1681:
    label1697:
    label1828:
    label1844:
    label1852:
    this.dnn.bJ("contact_info_biz_add", true);
    label1800:
    label1812:
    this.dnn.bJ("contact_info_biz_go_chatting", true);
    this.dnn.bJ("contact_info_message_newbizinfo", true);
    this.dnn.bJ("contact_info_biz_menu_newbizinfo", true);
    this.dnn.bJ("contact_info_all_message_newbizinfo", true);
    this.dnn.bJ("contact_info_new_bindwxainfo", true);
  }
  
  final void bsz()
  {
    if ((this.mZy.getIntent() != null) && (this.mZy.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.mZy.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bk.bl((String)localObject1)) {
        break label151;
      }
      y.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label151:
    while (bsA())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.mZy, new b.7(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.fhj));
      if (this.eff != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbI = this.eff;
      }
      if (!bk.bl(this.kzG)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).kzG = this.kzG;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).sbO = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.dnp.field_username, (LinkedList)localObject2, this.mWX);
      return;
    }
    y.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    au.Dk().a(536, this);
    Object localObject2 = new da();
    ((da)localObject2).bJg.bJi = ((String)localObject1);
    ((da)localObject2).bJg.opType = 1;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((da)localObject2).bJh.bJk;
    localObject2 = this.mZy;
    this.mZy.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.mZy.getString(R.l.app_waiting), true, new b.6(this, (m)localObject1));
  }
  
  final boolean isNormal()
  {
    return (this.mZz != null) && (this.mZz.isNormal()) && (!bsR());
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mZy == null) {
      y.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
    }
    do
    {
      return;
      y.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while ((paramInt2 != -1) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("be_send_card_name");
    String str2 = paramIntent.getStringExtra("received_card_name");
    boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
    paramIntent = paramIntent.getStringExtra("custom_send_text");
    g.bhI().o(str1, str2, bool);
    g.bhI().dO(paramIntent, str2);
    com.tencent.mm.ui.widget.snackbar.b.h(this.mZy, this.mZy.getString(R.l.finish_sent));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramm == null) {
      y.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
    }
    do
    {
      return;
      au.Dk().b(paramm.getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
        return;
      }
      y.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    } while (paramm.getType() != 536);
    au.Dk().b(536, this);
    bsx();
  }
  
  final void wf(int paramInt)
  {
    if ((this.mWV == null) || ((this.fhj != 39) && (this.fhj != 56) && (this.fhj != 35) && (this.fhj != 87) && (this.fhj != 88) && (this.fhj != 89) && (this.fhj != 85)))
    {
      y.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      return;
    }
    if (this.dnp == null)
    {
      y.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      return;
    }
    String str2 = this.mWV.getString("Contact_Ext_Args_Search_Id");
    String str3 = bk.pm(this.mWV.getString("Contact_Ext_Args_Query_String"));
    int j = this.mWV.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.fhj)
    {
    default: 
      i = 0;
      str1 = bk.pm(this.mWV.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bk.pm(this.dnp.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bk.bl(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      y.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10866, str1);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
    }
  }
  
  public final boolean xQ(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      return false;
    }
    y.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[] { paramString });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.IO()) {
        bsz();
      }
      for (;;)
      {
        if (this.mWR != 0) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11263, new Object[] { Integer.valueOf(this.mWR), this.dnp.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 200);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.mZy, com.tencent.mm.model.gdpr.a.dYu, this.dnp.field_username, new b.5(this));
      }
    }
    if ("contact_info_all_message_newbizinfo".endsWith(paramString))
    {
      paramString = this.mZz.field_historyArticlesUrl;
      y.i("MicroMsg.ContactWidgetNewBizInfo", "contact_info_all_message_newbizinfo click:%s", new Object[] { this.mZz.field_historyArticlesUrl });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("geta8key_scene", 3);
      localIntent.putExtra("KPublisherId", "brand_profile");
      localIntent.putExtra("prePublishId", "brand_profile");
      com.tencent.mm.br.d.b(this.mZy, "webview", ".ui.tools.WebViewUI", localIntent);
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(this.dnp.field_username, 400);
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b
 * JD-Core Version:    0.7.0.1
 */