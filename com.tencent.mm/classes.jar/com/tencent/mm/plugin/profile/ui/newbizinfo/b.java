package com.tencent.mm.plugin.profile.ui.newbizinfo;

import a.f.b.j;
import a.o;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.aj.d.a;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.dd.b;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.dh.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.a.a;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.e.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class b
  implements com.tencent.mm.ai.f, com.tencent.mm.pluginsdk.b.a
{
  public ad contact;
  public long eaj;
  public long endTime;
  private List<d.a> fuX;
  private d.b fuY;
  private String fvh;
  public int gyR;
  private com.tencent.mm.sdk.b.c hCe;
  boolean isLoading;
  public String mVw;
  ContactInfoUI pDe;
  public lj pDf;
  com.tencent.mm.plugin.profile.ui.newbizinfo.b.c pDg;
  private int pDh;
  private boolean pDi;
  private boolean pDj;
  private Parcelable pDk;
  public com.tencent.mm.aj.d pyd;
  boolean pyp;
  private String pyu;
  public List<WxaAttributes.WxaEntryInfo> pzH;
  private wc pzI;
  private int pzM;
  private Bundle pzQ;
  SnsAdClick pzR;
  private String pzS;
  com.tencent.mm.ui.base.preference.f screen;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public b(ContactInfoUI paramContactInfoUI, String paramString, wc paramwc)
  {
    AppMethodBeat.i(153589);
    this.pzM = 0;
    this.pzR = null;
    this.pzS = null;
    this.pDg = null;
    this.hCe = new b.1(this);
    this.pDh = 0;
    this.pDi = true;
    this.isLoading = false;
    this.pDj = false;
    this.tipDialog = null;
    this.pDe = paramContactInfoUI;
    this.pyu = paramString;
    this.pzI = paramwc;
    paramString = paramContactInfoUI.getListView();
    ccJ();
    paramString.setOnScrollListener(new b.3(this, paramString, am.getStatusBarHeight(paramContactInfoUI), paramContactInfoUI));
    AppMethodBeat.o(153589);
  }
  
  private void a(String paramString, com.tencent.mm.bv.b paramb)
  {
    AppMethodBeat.i(153594);
    if (this.isLoading)
    {
      ab.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(153594);
      return;
    }
    this.isLoading = true;
    Object localObject = new b.a();
    ((b.a)localObject).funcId = 2656;
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    li localli = new li();
    localli.wxM = paramString;
    if (paramb != null)
    {
      localli.wzE = 1;
      localli.wzC = paramb;
      localli.wzF = 20;
      ((b.a)localObject).fsX = localli;
      ((b.a)localObject).fsY = new lj();
      localObject = ((b.a)localObject).ado();
      paramb = new b.8(this, paramb);
      if (!(this.pDe instanceof com.tencent.mm.vending.e.b)) {
        break label175;
      }
    }
    label175:
    for (paramString = this.pDe;; paramString = null)
    {
      w.a((com.tencent.mm.ai.b)localObject, paramb, false, paramString);
      AppMethodBeat.o(153594);
      return;
      localli.wzE = 0;
      localli.wzF = 5;
      break;
    }
  }
  
  private void ccJ()
  {
    AppMethodBeat.i(153591);
    if (this.pDg != null)
    {
      AppMethodBeat.o(153591);
      return;
    }
    com.tencent.mm.ui.base.preference.h localh = (com.tencent.mm.ui.base.preference.h)this.pDe.getListView().getAdapter();
    if (localh == null)
    {
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
      AppMethodBeat.o(153591);
      return;
    }
    this.pDg = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.c(this.pDe, this, localh, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
    localh.zrP = this.pDg;
    AppMethodBeat.o(153591);
  }
  
  private void ccK()
  {
    AppMethodBeat.i(23812);
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    com.tencent.mm.aj.d locald2 = com.tencent.mm.aj.f.rS(this.contact.field_username);
    this.fuX = null;
    this.fuY = null;
    this.pzH = null;
    com.tencent.mm.aj.d locald1;
    if (locald2 != null)
    {
      locald1 = locald2;
      if (locald2.cU(false) != null) {}
    }
    else
    {
      locald1 = locald2;
      if (this.pzI != null)
      {
        locald1 = new com.tencent.mm.aj.d();
        locald1.field_username = this.contact.field_username;
        locald1.field_brandFlag = this.pzI.gxd;
        locald1.field_brandIconURL = this.pzI.gxg;
        locald1.field_brandInfo = this.pzI.gxf;
        locald1.field_extInfo = this.pzI.gxe;
        locald1.field_type = locald1.cU(false).getServiceType();
      }
    }
    if ((locald1 != null) && (locald1.field_brandInfo == null) && (locald1.field_extInfo == null) && (this.pzI != null))
    {
      locald1.field_username = this.contact.field_username;
      locald1.field_brandFlag = this.pzI.gxd;
      locald1.field_brandIconURL = this.pzI.gxg;
      locald1.field_brandInfo = this.pzI.gxf;
      locald1.field_extInfo = this.pzI.gxe;
      locald1.field_type = locald1.cU(false).getServiceType();
    }
    if (locald1 != null)
    {
      this.pyd = locald1;
      this.fuX = locald1.aep();
      this.fuY = locald1.cU(false);
      this.pzH = this.fuY.getWxaEntryInfoList();
      if ((this.fuY.aet() != null) && (this.fuY.aet().length() > 0)) {
        this.fvh = this.fuY.aet();
      }
    }
    AppMethodBeat.o(23812);
  }
  
  private boolean ccN()
  {
    boolean bool1 = true;
    AppMethodBeat.i(23815);
    try
    {
      String str = this.fuY.aew();
      boolean bool2 = bo.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(23815);
        return false;
      }
      long l = bo.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        ab.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(23815);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(23815);
    }
  }
  
  private void ccO()
  {
    AppMethodBeat.i(23822);
    Object localObject2 = this.pDe.getIntent();
    int i = com.tencent.mm.plugin.profile.ui.newbizinfo.b.g.BQ(((Intent)localObject2).getIntExtra("Contact_Scene", 0));
    String str3 = ((Intent)localObject2).getStringExtra("preChatName");
    String str4 = ((Intent)localObject2).getStringExtra("preUsername");
    int j = com.tencent.mm.plugin.profile.ui.newbizinfo.b.g.aW(((Intent)localObject2).getIntExtra("preChatTYPE", 0), str3);
    Object localObject1 = ((Intent)localObject2).getStringExtra("rawUrl");
    String str2 = ((Intent)localObject2).getStringExtra("url");
    Object localObject4 = ((Intent)localObject2).getBundleExtra("Contact_Ext_Args");
    String str1 = "";
    if (localObject4 != null) {
      str1 = ((Bundle)localObject4).getString("Contact_Ext_Args_Query_String", "");
    }
    int k = e.a.NY(((Intent)localObject2).getIntExtra("qbarScene", -1));
    String str5 = this.contact.field_username;
    if (!bo.isNullOrNil(str1)) {}
    for (;;)
    {
      try
      {
        str1 = URLEncoder.encode(bo.nullAsNil(str1), "UTF-8");
        localObject2 = localObject1;
        ab.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", localUnsupportedEncodingException1, "", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          localObject1 = URLEncoder.encode(bo.nullAsNil((String)localObject1), "UTF-8");
          localObject2 = localObject1;
          localObject4 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
          localObject2 = localObject4;
          com.tencent.mm.plugin.report.service.h.qsU.e(16232, new Object[] { Integer.valueOf(i), Integer.valueOf(j), str3, str4, localObject1, localObject2, str1, Integer.valueOf(k), str5 });
          if (!bo.isNullOrNil(this.pzS)) {
            com.tencent.mm.plugin.report.service.h.qsU.kvStat(16697, this.pzS);
          }
          AppMethodBeat.o(23822);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;)
          {
            localObject1 = localObject3;
            localObject3 = localUnsupportedEncodingException2;
          }
        }
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        str1 = "";
      }
      Object localObject3 = str2;
      continue;
      str1 = "";
      localObject3 = str2;
    }
  }
  
  private void cce()
  {
    AppMethodBeat.i(23816);
    if ((this.contact != null) && ((t.oB(this.contact.field_username)) || (t.oL(this.contact.field_username))) && (com.tencent.mm.n.a.je(this.contact.field_type)))
    {
      this.screen.cl("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(23816);
      return;
    }
    this.screen.cl("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(23816);
  }
  
  private boolean ccg()
  {
    AppMethodBeat.i(23824);
    if (this.pDe.getIntent() == null)
    {
      AppMethodBeat.o(23824);
      return false;
    }
    String str1 = this.pDe.getIntent().getStringExtra("device_id");
    String str2 = this.pDe.getIntent().getStringExtra("device_type");
    dh localdh = new dh();
    localdh.cqL.bYu = str1;
    localdh.cqL.cqJ = str2;
    com.tencent.mm.sdk.b.a.ymk.l(localdh);
    boolean bool = localdh.cqM.cqN;
    AppMethodBeat.o(23824);
    return bool;
  }
  
  final void BK(int paramInt)
  {
    AppMethodBeat.i(23825);
    if ((this.pzQ == null) || ((this.gyR != 39) && (this.gyR != 56) && (this.gyR != 35) && (this.gyR != 87) && (this.gyR != 88) && (this.gyR != 89) && (this.gyR != 85)))
    {
      ab.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(23825);
      return;
    }
    if (this.contact == null)
    {
      ab.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(23825);
      return;
    }
    String str2 = this.pzQ.getString("Contact_Ext_Args_Search_Id");
    String str3 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Args_Query_String"));
    int j = this.pzQ.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.gyR)
    {
    default: 
      i = 0;
      str1 = bo.nullAsNil(this.pzQ.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + bo.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (bo.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      ab.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10866, str1);
      AppMethodBeat.o(23825);
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
  
  public final long FH()
  {
    return this.eaj;
  }
  
  public final boolean Ke(String paramString)
  {
    AppMethodBeat.i(23820);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(23820);
      return false;
    }
    ab.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s", new Object[] { paramString });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (!com.tencent.mm.model.gdpr.c.abL()) {
        ccf();
      }
      for (;;)
      {
        if (this.pzM != 0) {
          com.tencent.mm.plugin.report.service.h.qsU.e(11263, new Object[] { Integer.valueOf(this.pzM), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cZ(this.contact.field_username, 200);
        AppMethodBeat.o(23820);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.pDe, com.tencent.mm.model.gdpr.a.foz, this.contact.field_username, new b.9(this));
      }
    }
    AppMethodBeat.o(23820);
    return true;
  }
  
  final void a(lg paramlg)
  {
    AppMethodBeat.i(153592);
    ccJ();
    if (this.pDg != null)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.b.c localc = this.pDg;
      j.q(paramlg, "msgList");
      com.tencent.mm.plugin.profile.ui.newbizinfo.b.a locala = localc.pEs;
      j.q(paramlg, "msgList");
      locala.elu.clear();
      j.p(Calendar.getInstance(), "Calendar.getInstance()");
      new Date();
      Object localObject = paramlg.wzA;
      j.p(localObject, "msgList.Msg");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        lf locallf = (lf)((Iterator)localObject).next();
        locala.elu.add(new o(a.a.pEi, locallf));
        locala.elu.add(new o(a.a.pEj, locallf));
      }
      if (paramlg.wzB.wzD == 0) {
        locala.elu.add(new o(a.a.pEk, new lf()));
      }
      localc.pEz.notifyDataSetChanged();
    }
    AppMethodBeat.o(153592);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23811);
    if (this.pDe.isFinishing())
    {
      AppMethodBeat.o(23811);
      return true;
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bo.nullAsNil(paramad.field_username).length() <= 0) {
        break label333;
      }
      bool = true;
      label63:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label339;
      }
    }
    label333:
    label339:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.screen = paramf;
      this.contact = paramad;
      this.pyp = paramBoolean;
      this.gyR = paramInt;
      this.pzR = ((SnsAdClick)this.pDe.getIntent().getParcelableExtra("KSnsAdTag"));
      this.pzS = this.pDe.getIntent().getStringExtra("key_add_contact_report_info");
      this.pzM = this.pDe.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.pzQ = this.pDe.getIntent().getBundleExtra("Contact_Ext_Args");
      if (this.pDi)
      {
        this.pDi = false;
        initActionBar();
        this.pDf = c.Xj(this.contact.field_username);
        ccd();
        a(paramad.field_username, null);
        paramf = this.pDe.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!bo.isNullOrNil(paramf))
        {
          this.pDe.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.pDe, paramf, "", this.pDe.getString(2131297018), null);
        }
      }
      if (paramad != null) {
        z.afu().rw(paramad.field_username);
      }
      if (this.pDk != null)
      {
        paramf = this.pDe.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.pDk);
        }
      }
      AppMethodBeat.o(23811);
      return true;
      bool = false;
      break;
      bool = false;
      break label63;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23818);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    if (this.screen == null)
    {
      AppMethodBeat.o(23818);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.atx("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.pDe.getListView();
    if (localObject != null) {
      this.pDk = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(23818);
    return true;
  }
  
  public final void ccL()
  {
    AppMethodBeat.i(153593);
    if ((this.pDj) && (this.pDf.wzJ != null) && (this.pDf.wzJ.wzB.wzD == 0)) {
      a(this.contact.field_username, this.pDf.wzJ.wzB.wzC);
    }
    AppMethodBeat.o(153593);
  }
  
  public final ad ccM()
  {
    return this.contact;
  }
  
  public final int ccP()
  {
    return this.gyR;
  }
  
  final void ccd()
  {
    AppMethodBeat.i(23813);
    bkb();
    ccK();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131165213);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.atx("contact_info_header_newbizinfo");
    if ((localObject != null) && (!bo.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.pyu, this.pyd, this.pDf);
      this.pDj = true;
      if (this.pDf == null) {
        break label585;
      }
      if (!com.tencent.mm.n.a.je(this.contact.field_type)) {
        break label556;
      }
      this.screen.cl("contact_info_biz_add", true);
      this.screen.cl("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.atx("contact_info_biz_go_chatting")).pyo = this;
      label159:
      if ((this.pDf != null) && (this.pDf.wzH != null) && (this.pDf.wzJ != null) && (this.pDf.wzJ.wzB != null)) {
        a(this.pDf.wzJ);
      }
      if ((this.pDf != null) && (!isNormal()) && (!com.tencent.mm.n.a.je(this.contact.field_type))) {
        this.pDe.showOptionMenu(false);
      }
      if ((this.pDf == null) || (this.pDf.wzM == null)) {
        break label627;
      }
      this.screen.cl("contact_info_biz_menu_newbizinfo", false);
      if (this.pDf != null) {
        ((NewBizInfoMenuPreference)this.screen.atx("contact_info_biz_menu_newbizinfo")).a(this.pDf.wzM, this.contact);
      }
    }
    for (;;)
    {
      this.screen.cl("contact_info_biz_err_msg", true);
      ab.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.pDe.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.pDe.getIntent() == null) || (!this.pDe.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label664;
      }
      ab.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = ccg();
      ab.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.n.a.je(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.n.a.je(this.contact.field_type)) && (bool)) {
        break label657;
      }
      ab.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      cce();
      localObject = (NewBizInfoNotFollowPreference)this.screen.atx("contact_info_biz_add");
      this.screen.cl("contact_info_biz_add", false);
      if (localObject == null) {
        break label657;
      }
      if (!bool) {
        break label643;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.pDe.getString(2131298551));
      AppMethodBeat.o(23813);
      return;
      ab.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.cl("contact_info_header_bizinfo", true);
      break;
      label556:
      this.screen.cl("contact_info_biz_add", false);
      this.screen.cl("contact_info_biz_go_chatting", true);
      break label159;
      label585:
      this.screen.cl("contact_info_biz_add", true);
      this.screen.cl("contact_info_biz_go_chatting", true);
      this.screen.cl("contact_info_biz_space", false);
      break label159;
      label627:
      this.screen.cl("contact_info_biz_menu_newbizinfo", true);
    }
    label643:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.pDe.getString(2131298537));
    label657:
    AppMethodBeat.o(23813);
    return;
    label664:
    if (ccN())
    {
      this.screen.cl("contact_info_biz_loading", false);
      this.screen.cl("contact_info_biz_add", true);
      this.screen.cl("contact_info_biz_go_chatting", true);
      this.screen.cl("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(23813);
  }
  
  final void ccf()
  {
    AppMethodBeat.i(23821);
    if ((NewBizInfoHeaderPreference)this.screen.atx("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.kT(System.currentTimeMillis());
    }
    if ((this.pDe.getIntent() != null) && (this.pDe.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.pDe.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!bo.isNullOrNil((String)localObject1)) {
        break label229;
      }
      ab.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label229:
    while (ccg())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.pDe, new b.2(this));
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.gyR));
      if (this.fvh != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSP = this.fvh;
      }
      if (!bo.isNullOrNil(this.mVw)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).mVw = this.mVw;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSV = true;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).vSW = this.pDe.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).kbN = e.a.NY(this.pDe.getIntent().getIntExtra("qbarScene", -1));
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.pzS);
      ccO();
      AppMethodBeat.o(23821);
      return;
    }
    ab.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    aw.Rc().a(536, this);
    Object localObject2 = new dd();
    ((dd)localObject2).cqA.cqC = ((String)localObject1);
    ((dd)localObject2).cqA.opType = 1;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
    Object localObject1 = ((dd)localObject2).cqB.cqE;
    localObject2 = this.pDe;
    this.pDe.getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, this.pDe.getString(2131297112), true, new b.10(this, (m)localObject1));
    AppMethodBeat.o(23821);
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(153590);
    this.pDe.setMMTitle(bo.nullAsNil(this.contact.field_nickname));
    this.pDe.setMMTitleColor(0);
    this.pDe.setTitleDividerVis(false);
    this.pDe.setIsDarkActionbarBg(false);
    this.pDe.setActionbarColor(-1);
    this.pDe.hideActionbarLine();
    this.pDe.setBackBtn(new b.4(this), 2131230737);
    Drawable localDrawable = this.pDe.getResources().getDrawable(2130839668);
    localDrawable.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
    this.pDe.removeAllOptionMenu();
    this.pDe.addIconOptionMenu(1, 2131304318, 2131230741, new b.5(this));
    this.pDe.addIconOptionMenu(0, "", localDrawable, new b.6(this));
    AppMethodBeat.o(153590);
  }
  
  final boolean isNormal()
  {
    AppMethodBeat.i(23814);
    if ((this.pDf != null) && (this.pDf.wzH != null) && (this.pDf.wzH.wwH == 0) && (!ccN()))
    {
      AppMethodBeat.o(23814);
      return true;
    }
    AppMethodBeat.o(23814);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23819);
    if (this.pDe == null)
    {
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(23819);
      return;
    }
    ab.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(23819);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.bPJ().q(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.bPJ().fh(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.l(this.pDe, this.pDe.getString(2131299979));
      AppMethodBeat.o(23819);
      return;
    }
    AppMethodBeat.o(23819);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(23823);
    ab.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramm == null)
    {
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(23823);
      return;
    }
    aw.Rc().b(paramm.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
      AppMethodBeat.o(23823);
      return;
    }
    ab.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramm.getType()) });
    if (paramm.getType() == 536)
    {
      aw.Rc().b(536, this);
      ccd();
    }
    AppMethodBeat.o(23823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b
 * JD-Core Version:    0.7.0.1
 */