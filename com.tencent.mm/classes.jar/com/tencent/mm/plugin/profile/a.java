package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bb.a;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.ya.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements i.a, com.tencent.mm.plugin.story.api.d, com.tencent.mm.pluginsdk.b.a
{
  ab fLO;
  String fPi;
  private int mScene;
  com.tencent.mm.ui.base.preference.f mzx;
  MMActivity owO;
  am pMt;
  private boolean readOnly;
  com.tencent.mm.plugin.profile.a.b wOW;
  private boolean wOX;
  final List<String> wOY;
  private com.tencent.mm.ui.widget.a.e wOZ;
  String wPa;
  com.tencent.mm.sdk.b.c<bb> wPb;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.wOY = new LinkedList();
    this.wPa = null;
    this.wPb = new com.tencent.mm.sdk.b.c() {};
    this.owO = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    ad.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.aVD("contact_info_invite_source");
    paramf.cP("contact_info_invite_source", false);
    paramf = new SpannableString(k.c(paramActivity, paramActivity.getResources().getString(2131757692, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.act(2);
    localKeyValuePreference.JsK = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (dAa())
    {
      paramf.cP("contact_profile_setting_desc", true);
      paramf.cP("contact_profile_setting_permission", true);
      paramf.cP("contact_profile_phone", true);
      paramf.cP("contact_profile_info_more", true);
      paramf.cP("contact_profile_sns", am.aSQ(paramam.field_username));
      if ((u.aAr() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.s(this.owO, "com.tencent.wework");
        ba.aBQ();
        Object localObject = (Integer)com.tencent.mm.model.c.ajl().get(al.a.IqP, Integer.valueOf(0));
        ad.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(u.aAr()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bt.jx(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.s(this.owO, "com.tencent.wework")))) {
          break label325;
        }
        paramf.cP("contact_profile_accept_contact_by_wework", false);
        localObject = com.tencent.mm.plugin.profile.ui.p.a(this.owO, paramam, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label434;
        }
      }
    }
    label434:
    for (paramam = com.tencent.mm.plugin.profile.ui.p.b(this.owO, paramam, this.mScene);; paramam = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.auF(this.pMt.field_username)) {
        ((ButtonPreference)paramf.aVD("contact_profile_accept_contact_by_wework")).gv(this.owO.getString(2131757689), this.owO.getResources().getColor(2131100035));
      }
      if ((!bt.isNullOrNil(paramam)) && (com.tencent.mm.plugin.profile.b.e.auE(paramam) == 2) && (paramBoolean)) {
        paramf.cP("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label325:
      if (this.owO.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramam = (ButtonPreference)paramf.aVD("contact_profile_accept_contact");
        paramam.gv(this.owO.getString(2131755200), this.owO.getResources().getColor(2131100249));
        paramam.setEnabled(false);
      }
      paramf.cP("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.cP("contact_profile_accept_contact", true);
      paramf.cP("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(String paramString, am paramam)
  {
    AppMethodBeat.i(26849);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(26849);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramam.field_username);
    paramString.putExtra("Contact_Nick", paramam.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramam.field_conRemark);
    b.iRG.n(paramString, this.owO);
    AppMethodBeat.o(26849);
  }
  
  static String b(ab paramab, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramab == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramString);
    Object localObject1 = localObject2;
    if (localam != null)
    {
      localObject1 = localObject2;
      if ((int)localam.gfj > 0) {
        localObject1 = localam.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = paramab.zf(paramString);
    }
    paramab = (ab)localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      paramab = (ab)localObject2;
      if (localam != null) {
        paramab = localam.adu();
      }
    }
    AppMethodBeat.o(26854);
    return paramab;
  }
  
  private boolean dAa()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.o.b.lM(this.pMt.field_type)) && (this.owO.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean dAb()
  {
    AppMethodBeat.i(26846);
    if (this.owO.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean dAc()
  {
    AppMethodBeat.i(26847);
    if (this.owO.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean dAd()
  {
    AppMethodBeat.i(26848);
    int i = this.owO.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean dAe()
  {
    return this.pMt.field_deleteFlag == 1;
  }
  
  private boolean dzW()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = w.hFm;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.pMt.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = dzX();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean dzX()
  {
    AppMethodBeat.i(26843);
    boolean bool = w.Ag(this.pMt.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean dzY()
  {
    AppMethodBeat.i(193237);
    boolean bool = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ail(this.pMt.field_username);
    AppMethodBeat.o(193237);
    return bool;
  }
  
  private boolean dzZ()
  {
    AppMethodBeat.i(26844);
    boolean bool = am.zs(this.pMt.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  final void a(final am paramam, final Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.wOZ = new com.tencent.mm.ui.widget.a.e(this.owO, 1, false);
    this.wOZ.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(193233);
        paramAnonymousl.aL(2, 2131755762, 2131691164);
        paramAnonymousl.aL(1, 2131755764, 2131691165);
        AppMethodBeat.o(193233);
      }
    };
    this.wOZ.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(193234);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193234);
          return;
          paramAnonymousMenuItem = paramam;
          Context localContext = paramContext;
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
          ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), localContext });
          yb localyb;
          if (bool)
          {
            localyb = new yb();
            localyb.dMo.dsi = 5;
            localyb.dMo.talker = paramAnonymousMenuItem.field_username;
            localyb.dMo.context = localContext;
            localyb.dMo.dMk = 4;
            com.tencent.mm.sdk.b.a.IbL.l(localyb);
          }
          AppMethodBeat.o(193234);
          return;
          paramAnonymousMenuItem = paramam;
          localContext = paramContext;
          bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
          ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), localContext });
          if (bool)
          {
            bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
            ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), localContext });
            if (bool)
            {
              localyb = new yb();
              localyb.dMo.dsi = 5;
              localyb.dMo.talker = paramAnonymousMenuItem.field_username;
              localyb.dMo.context = localContext;
              localyb.dMo.dMk = 2;
              com.tencent.mm.sdk.b.a.IbL.l(localyb);
            }
          }
        }
      }
    };
    this.wOZ.cMW();
    AppMethodBeat.o(26850);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.mzx.aVD("contact_profile_sns");
    if ((paramString != null) && (o.zbT != null))
    {
      paramString.aNf(this.pMt.field_username);
      com.tencent.mm.plugin.sns.j.e.ztz.ztL.ekA = paramString.feQ();
      if (o.zbX != null) {
        o.zbX.a(this, 3);
      }
      this.mzx.notifyDataSetChanged();
      if (paramb.dSv())
      {
        ad.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (o.zbX != null) {
          o.zbX.axK(this.pMt.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.mzx = paramf;
    this.pMt = paramam;
    this.mScene = paramInt;
    this.fPi = this.owO.getIntent().getStringExtra("room_name");
    ba.aBQ();
    this.fLO = com.tencent.mm.model.c.azz().AN(this.fPi);
    this.wOX = this.owO.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.wOW == null)
    {
      this.wOW = new com.tencent.mm.plugin.profile.a.b(this.owO, paramam);
      this.wOW.dhw();
    }
    ad.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramam.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2131951696);
    Object localObject3 = (NormalProfileHeaderPreference)paramf.aVD("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject3).mzx = paramf;
    ((NormalProfileHeaderPreference)localObject3).a(paramam, paramInt, paramBoolean, this.wOW);
    Object localObject1 = (ButtonPreference)paramf.aVD("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).JrB = 2131298702;
    }
    Object localObject2 = (ButtonPreference)paramf.aVD("contact_profile_add_contact");
    Object localObject5 = this.owO;
    Object localObject4 = this.pMt;
    int j;
    if ((am.aSQ(((aw)localObject4).field_username)) && (((aw)localObject4).ePM != 0))
    {
      j = paramf.indexOf("contact_info_category_1");
      Object localObject6 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((aw)localObject4).field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.b.a.iHt);
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = new PreferenceTitleCategory((Context)localObject5);
        ((Preference)localObject7).setTitle((CharSequence)localObject6);
        paramf.a((Preference)localObject7, j);
        ((Preference)localObject7).Jtu = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject6 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject6).IE(((aw)localObject4).ePN);
      localObject6 = ((com.tencent.mm.openim.a.c)localObject6).iHw.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject7 = (c.a)((Iterator)localObject6).next();
        Iterator localIterator = ((c.a)localObject7).iHx.iterator();
        i = j;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          c.b localb = (c.b)localIterator.next();
          j = i + 1;
          com.tencent.mm.plugin.profile.a.a.2 local2 = new com.tencent.mm.plugin.profile.a.a.2((Context)localObject5, localb);
          local2.JaR = ((c.a)localObject7).title;
          local2.act(2);
          local2.JsK = false;
          local2.setSummary(k.c((Context)localObject5, localb.IF(((aw)localObject4).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.acw(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.Jtu = new com.tencent.mm.plugin.profile.a.a.3(localb, (am)localObject4, (c.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.Jtu = new com.tencent.mm.plugin.profile.a.a.4(localb, (am)localObject4, (c.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.Jtu = new com.tencent.mm.plugin.profile.a.a.5(localb, (am)localObject4, (c.a)localObject7);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.Jtu = new com.tencent.mm.plugin.profile.a.a.6(localb, (am)localObject4, (c.a)localObject7);
              i = j;
            }
          }
        }
      }
      i = j + 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject5), i);
      localObject6 = new KeyValuePreference((Context)localObject5);
      ((KeyValuePreference)localObject6).setTitle(2131757648);
      Object localObject7 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((aw)localObject4).field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.b.a.iHt);
      ((KeyValuePreference)localObject6).setSummary(k.c((Context)localObject5, (CharSequence)localObject7));
      localObject5 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((aw)localObject4).field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.b.a.iHu);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((Preference)localObject6).Jtu = new com.tencent.mm.plugin.profile.a.a.7((String)localObject5, (am)localObject4, (String)localObject7);
      }
      paramf.a((Preference)localObject6, i + 1);
    }
    if (dzX())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject3);
      paramf.b(new PreferenceSmallCategory(this.owO));
      paramam = new KeyValuePreference(this.owO);
      paramam.setTitle(2131757694);
      paramam.setSummary(2131757916);
      paramam.act(2147483647);
      paramam.JsK = false;
      paramam.acw(8);
      paramf.b(paramam);
      paramf.b(new PreferenceSmallCategory(this.owO));
      if (com.tencent.mm.o.b.lM(this.pMt.field_type)) {
        paramf.b((Preference)localObject1);
      }
      for (;;)
      {
        this.wOW.oJq.removeAllOptionMenu();
        AppMethodBeat.o(26837);
        return true;
        paramf.b((Preference)localObject2);
      }
    }
    localObject3 = this.pMt;
    int i = this.owO.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.owO.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = bt.bI(this.owO.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new dhg();
    ((dhg)localObject2).jdn = i;
    ((dhg)localObject2).jdp = l;
    ((dhg)localObject2).jdo = ((String)localObject1);
    localObject1 = localObject2;
    if (o.zbT != null) {
      localObject1 = o.zbT.b(((aw)localObject3).field_username, (dhg)localObject2);
    }
    ba.aBQ();
    boolean bool1 = com.tencent.mm.model.c.azp().aTg(((aw)localObject3).field_username);
    boolean bool2 = u.aAm().equals(((aw)localObject3).field_username);
    if ((((dhg)localObject1).jdn & 0x1) > 0)
    {
      paramBoolean = true;
      ad.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((am.aSO(((aw)localObject3).field_username)) || (!paramBoolean)) && (!dAa()) && (!bool2)) {
        break label3408;
      }
      this.mzx.cP("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.mzx.aVD("contact_profile_sns");
      if (o.zbX != null)
      {
        o.zbX.a(3, ((aw)localObject3).field_username, this);
        i = this.owO.getIntent().getIntExtra("Sns_from_Scene", 0);
        o.zbX.a(2, ((aw)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).aNf(((aw)localObject3).field_username);
      label1310:
      if (am.aSQ(((aw)localObject3).field_username)) {
        this.mzx.cP("contact_profile_sns", true);
      }
      localObject2 = paramf.aVD("contact_profile_setting_desc");
      if (!am.aSQ(this.pMt.field_username)) {
        break label3424;
      }
      localObject1 = this.owO.getText(2131757927).toString();
      label1374:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.aVD("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.owO.getString(2131761879);
      if (!this.pMt.adp()) {
        break label3444;
      }
      ((MultiSummaryPreference)localObject1).wSI = new String[] { this.owO.getString(2131762042) };
      localObject1 = (KeyValuePreference)paramf.aVD("contact_profile_source");
      paramInt = this.owO.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.owO, this.pMt, paramInt, this.pMt.field_username, dAa());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).act(2);
      ((KeyValuePreference)localObject1).JsK = false;
      ((KeyValuePreference)localObject1).pxm = (com.tencent.mm.cc.a.aA(this.owO, (int)this.owO.getResources().getDimension(2131165517)) * com.tencent.mm.cc.a.eb(this.owO));
      ((KeyValuePreference)localObject1).acw(8);
      if ((!com.tencent.mm.o.b.lM(paramam.field_type)) && (!bt.ai((CharSequence)localObject2)) && ((!dAb()) || (dAa()))) {
        break label3707;
      }
      paramBoolean = true;
      label1593:
      paramf.cP("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.aVD("contact_profile_label");
      ((LabelPreference)localObject1).pMt = paramam;
      if (!com.tencent.mm.o.b.lM(((LabelPreference)localObject1).pMt.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).pMt.field_encryptUsername;
        if (!bt.isNullOrNil((String)localObject2))
        {
          ba.aBQ();
          ((LabelPreference)localObject1).xjI = com.tencent.mm.model.c.azq().aqz((String)localObject2);
        }
        if ((((LabelPreference)localObject1).xjI != null) && (((LabelPreference)localObject1).xjI.systemRowid < 0L))
        {
          ba.aBQ();
          ((LabelPreference)localObject1).xjI = com.tencent.mm.model.c.azq().aqz(((LabelPreference)localObject1).pMt.field_username);
        }
      }
      if ((!com.tencent.mm.o.b.lM(((LabelPreference)localObject1).pMt.field_type)) || (bt.isNullOrNil(((LabelPreference)localObject1).pMt.field_contactLabelIds))) {
        break label3712;
      }
      paramInt = 1;
      label1752:
      if (paramInt != 0) {
        break label3746;
      }
      paramBoolean = true;
      label1759:
      paramf.cP("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.aVD("contact_profile_phone");
      ((PhoneNumPreference)localObject3).mzx = paramf;
      localObject4 = this.owO.getIntent();
      ((PhoneNumPreference)localObject3).pMt = paramam;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      ad.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramam.adr() });
      if (!paramam.adr())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject4))) {
          break label3759;
        }
        if (!bt.isNullOrNil(paramam.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramam.field_username);
          localObject4 = paramam.field_username;
          if (localObject2 != null) {
            break label3751;
          }
          localObject1 = "true";
          label1928:
          ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1955:
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lb())))
        {
          ((PhoneNumPreference)localObject3).ETv = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSD()).replace(" ", "");
          ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramam.field_username, ((PhoneNumPreference)localObject3).ETv });
        }
        ((PhoneNumPreference)localObject3).feO();
      }
      ((PhoneNumPreference)localObject3).ETw = PhoneNumPreference.b(((PhoneNumPreference)localObject3).ETv, paramam);
      ((PhoneNumPreference)localObject3).mzx.cP("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).feO();
      ((PhoneNumPreference)localObject3).acw(8);
      localObject1 = (ProfileDescribePreference)paramf.aVD("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).pMt = paramam;
      if (!com.tencent.mm.o.b.lM(((ProfileDescribePreference)localObject1).pMt.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).pMt.field_encryptUsername;
        if (!bt.isNullOrNil((String)localObject2))
        {
          ba.aBQ();
          ((ProfileDescribePreference)localObject1).xjI = com.tencent.mm.model.c.azq().aqz((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).xjI != null) && (((ProfileDescribePreference)localObject1).xjI.systemRowid < 0L))
        {
          ba.aBQ();
          ((ProfileDescribePreference)localObject1).xjI = com.tencent.mm.model.c.azq().aqz(((ProfileDescribePreference)localObject1).pMt.field_username);
        }
      }
      if (com.tencent.mm.o.b.lM(((ProfileDescribePreference)localObject1).pMt.field_type)) {
        break label3901;
      }
      if ((((ProfileDescribePreference)localObject1).xjI == null) || (bt.isNullOrNil(((ProfileDescribePreference)localObject1).xjI.field_conDescription))) {
        break label3895;
      }
      paramInt = 1;
      label2222:
      if (paramInt != 0) {
        break label3955;
      }
      paramBoolean = true;
      label2229:
      paramf.cP("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.o.b.lM(paramam.field_type)) || (bt.isNullOrNil(paramam.signature))) {
        break label3960;
      }
      localObject1 = (KeyValuePreference)paramf.aVD("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).pxm = (com.tencent.mm.cc.a.aA(this.owO, (int)this.owO.getResources().getDimension(2131165517)) * com.tencent.mm.cc.a.eb(this.owO));
        ((KeyValuePreference)localObject1).JsK = false;
        ((KeyValuePreference)localObject1).setTitle(this.owO.getString(2131757822));
        ((KeyValuePreference)localObject1).setSummary(k.c(this.owO, paramam.signature));
        ((KeyValuePreference)localObject1).xG(false);
        ((KeyValuePreference)localObject1).act(5);
        ((KeyValuePreference)localObject1).acw(8);
      }
      label2370:
      if ((paramf.aVF("contact_profile_desc") >= 0) || (paramf.aVF("contact_profile_label") >= 0)) {
        break label3973;
      }
      paramf.cP("contact_profile_setting_desc", false);
      label2404:
      if (!com.tencent.mm.o.b.lM(paramam.field_type)) {
        paramf.cP("contact_profile_setting_desc", false);
      }
      paramf.cP("contact_profile_set_des_category", true);
      if ((!am.aSQ(this.pMt.field_username)) || (!bt.isNullOrNil(this.pMt.field_conRemark))) {
        break label3986;
      }
      paramf.cP("contact_profile_setting_desc", false);
      paramf.cP("contact_profile_set_des_category", true);
      label2482:
      paramf.aVD("contact_profile_info_more").setTitle(this.owO.getText(2131757735).toString());
      ((TextPreference)paramf.aVD("contact_profile_hint")).am(this.owO.getText(2131757740));
      if (!paramam.adk()) {
        break label4030;
      }
      paramf.cP("contact_profile_hint", false);
      label2551:
      localObject2 = (MultiButtonPreference)paramf.aVD("contact_profile_multi_button");
      if (!dzY()) {
        break label4044;
      }
      ((MultiButtonPreference)localObject2).a(this.owO.getString(2131763804), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26820);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26820);
        }
      });
      label2595:
      if ((dzW()) || ((com.tencent.mm.o.b.lM(paramam.field_type)) && (!paramam.adk())) || ((!dAa()) && (dAb()))) {
        paramf.cP("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!dAa()) && (!dAe()) && (!dzZ())) {
        break label4234;
      }
      paramf.cP("contact_profile_send", true);
      paramf.cP("contact_profile_voip", true);
      label2700:
      if ((!com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!dAa()) && (!dAe()) && (!dAd()) && (!dAc()) && (!u.aAm().equals(this.pMt.field_username))) {
        break label4265;
      }
      paramf.cP("contact_profile_add_contact", true);
      label2768:
      a(paramf, paramam, false);
      if ((dAa()) || (com.tencent.mm.o.b.lM(paramam.field_type)) || ((!dzZ()) && (!dAd()) && (!dAc()))) {
        break label4319;
      }
      paramf.cP("contact_profile_info_more", true);
      paramf.cP("contact_profile_say_hi", false);
      label2834:
      if (u.za(this.pMt.field_username))
      {
        paramf.cP("contact_profile_multi_button", true);
        paramf.cP("contact_profile_info_more", bt.isNullOrNil(paramam.signature));
        paramf.cP("contact_profile_setting_desc", true);
        paramf.cP("contact_profile_setting_permission", true);
        paramf.cP("contact_profile_voip", true);
        this.wOW.oJq.removeAllOptionMenu();
      }
      localObject1 = this.pMt;
      paramf.cP("contact_info_invite_source", true);
      if (this.fLO != null) {
        break label4366;
      }
      paramBoolean = this.owO.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label2953:
      if ((this.mScene == 14) && (paramBoolean) && (this.fLO != null) && (!((aw)localObject1).field_username.equals(this.fLO.field_roomowner))) {
        break label4383;
      }
      paramInt = this.mScene;
      if (this.fLO != null) {
        break label4377;
      }
      bool1 = true;
      label3007:
      ad.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.cP("contact_info_invite_source", true);
      label3052:
      this.mzx.cP("contact_profile_story", true);
      ba.aBQ();
      paramBoolean = com.tencent.mm.model.c.azp().aTg(paramam.field_username);
      bool1 = u.aAm().equals(paramam.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().egU())
      {
        ad.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!am.aSO(paramam.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.mzx.aVD("contact_profile_story");
          paramf.onCreate(paramam.field_username);
          paramf.a(this);
          paramf.egP();
          paramf.egO();
        }
      }
      paramf = this.mzx;
      if (!dzY()) {
        break label4637;
      }
      paramf.cP("contact_profile_add_contact", true);
      paramf.cP("contact_profile_accept_contact_by_wework", true);
      paramf.cP("contact_profile_setting_desc", true);
      paramf.cP("contact_profile_send", true);
      paramf.cP("contact_profile_voip", true);
      paramf.cP("contact_profile_say_hi", true);
      paramf.cP("contact_profile_info_more", true);
      paramf.cP("contact_profile_setting_permission", true);
      paramf.cP("contact_profile_voip", true);
      paramf.cP("contact_profile_multi_button", false);
      paramf.cP("contact_profile_set_des_category", true);
      paramf.cP("contact_info_category_1", true);
      paramf.cP("line1", false);
      paramf.cP("line2", false);
      paramf.cP("line3", false);
      paramf.cP("line4", false);
      this.wOW.oJq.removeAllOptionMenu();
    }
    for (;;)
    {
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3408:
      this.mzx.cP("contact_profile_sns", true);
      break label1310;
      label3424:
      localObject1 = this.owO.getText(2131757926).toString();
      break label1374;
      label3444:
      paramBoolean = paramam.adn();
      bool1 = o.zbV.auM(paramam.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3609;
        }
        localObject3 = this.owO;
        if (paramam.ePk == 2)
        {
          i = 2131762036;
          label3520:
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        }
      }
      else if (bool1)
      {
        if (j != 0) {
          break label3662;
        }
        localObject3 = this.owO;
        if (paramam.ePk != 2) {
          break label3654;
        }
      }
      label3609:
      label3654:
      for (i = 2131762031;; i = 2131762033)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).wSI = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = 2131762038;
        break label3520;
        localObject3 = this.owO;
        if (paramam.ePk == 2) {}
        for (i = 2131762037;; i = 2131762039)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3662:
      localObject3 = this.owO;
      if (paramam.ePk == 2) {}
      for (i = 2131762032;; i = 2131762034)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3707:
      paramBoolean = false;
      break label1593;
      label3712:
      if ((((LabelPreference)localObject1).xjI != null) && (!bt.isNullOrNil(((LabelPreference)localObject1).xjI.field_contactLabels)))
      {
        paramInt = 1;
        break label1752;
      }
      paramInt = 0;
      break label1752;
      label3746:
      paramBoolean = false;
      break label1759;
      label3751:
      localObject1 = "false";
      break label1928;
      label3759:
      if ((bt.isNullOrNil((String)localObject2)) && (bt.isNullOrNil((String)localObject4))) {
        break label1955;
      }
      ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramam.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lb())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject4);
      }
      localObject4 = paramam.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label3895:
      paramInt = 0;
      break label2222;
      label3901:
      if (!bt.isNullOrNil(((ProfileDescribePreference)localObject1).pMt.ePE)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((bt.isNullOrNil(((ProfileDescribePreference)localObject1).pMt.ePD)) && (paramInt == 0)) {
          break label3949;
        }
        paramInt = 1;
        break;
      }
      label3949:
      paramInt = 0;
      break label2222;
      label3955:
      paramBoolean = false;
      break label2229;
      label3960:
      paramf.aVE("contact_info_signature");
      break label2370;
      label3973:
      paramf.cP("contact_profile_setting_desc", true);
      break label2404;
      label3986:
      if ((!am.aSQ(this.pMt.field_username)) && (!dzY())) {
        break label2482;
      }
      paramf.cP("contact_profile_setting_desc", true);
      paramf.cP("contact_profile_set_des_category", true);
      break label2482;
      label4030:
      paramf.cP("contact_profile_hint", true);
      break label2551;
      label4044:
      if (!dAa())
      {
        if ((!com.tencent.mm.o.b.lM(this.pMt.field_type)) && (this.owO.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) == 2))
        {
          paramInt = 1;
          label4085:
          if (paramInt == 0) {
            break label4187;
          }
        }
      }
      else {
        if (!this.pMt.adk()) {
          break label4172;
        }
      }
      label4172:
      for (localObject1 = this.owO.getString(2131757741);; localObject1 = this.owO.getString(2131757736))
      {
        ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            a.this.wOW.po(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26828);
          }
        });
        localObject1 = this.owO.getString(2131756596);
        localObject3 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26829);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            a.this.wOW.dAp();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26829);
          }
        };
        ((MultiButtonPreference)localObject2).wSD = ((String)localObject1);
        ((MultiButtonPreference)localObject2).wSG = ((View.OnClickListener)localObject3);
        break;
        paramInt = 0;
        break label4085;
      }
      label4187:
      if ((!paramam.adk()) && (!dAd()) && (!dAc())) {
        break label2595;
      }
      ((MultiButtonPreference)localObject2).a(this.owO.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(193231);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          a.this.wOW.dAp();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193231);
        }
      });
      break label2595;
      label4234:
      paramf.cP("contact_profile_send", false);
      paramf.cP("contact_profile_voip", this.pMt.adk());
      break label2700;
      label4265:
      paramf.cP("contact_profile_add_contact", false);
      paramf.cP("contact_profile_setting_desc", false);
      paramf.cP("contact_profile_setting_permission", true);
      paramf.cP("contact_profile_phone", true);
      paramf.cP("contact_profile_info_more", true);
      break label2768;
      label4319:
      paramf.cP("contact_profile_say_hi", true);
      if (!com.tencent.mm.o.b.lM(paramam.field_type))
      {
        paramf.cP("contact_profile_info_more", true);
        break label2834;
      }
      paramf.cP("contact_profile_info_more", false);
      break label2834;
      label4366:
      paramBoolean = this.fLO.YH();
      break label2953;
      label4377:
      bool1 = false;
      break label3007;
      label4383:
      this.wPa = this.owO.getIntent().getStringExtra("inviteer");
      if (bt.isNullOrNil(this.wPa)) {
        this.wPa = this.fLO.aSI(((aw)localObject1).field_username);
      }
      if (bt.isNullOrNil(this.wPa)) {
        this.wPa = com.tencent.mm.model.q.aC(((aw)localObject1).field_username, this.fPi);
      }
      if (bt.isNullOrNil(this.wPa))
      {
        ad.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.fPi, ((aw)localObject1).field_username });
        this.wPb.alive();
        this.wOY.add(((aw)localObject1).field_username);
        as.a.hFO.a(((aw)localObject1).field_username, this.fPi, new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(26824);
            ad.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fPi, Boolean.valueOf(paramAnonymousBoolean) });
            a.this.wPb.dead();
            AppMethodBeat.o(26824);
          }
        });
        break label3052;
      }
      this.owO.getIntent().putExtra("inviteer", this.wPa);
      localObject2 = b(this.fLO, this.wPa);
      if (bt.isNullOrNil((String)localObject2))
      {
        this.wOY.add(((aw)localObject1).field_username);
        as.a.hFO.a(((aw)localObject1).field_username, "", new as.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(193226);
            ad.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fPi, Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              ba.aBQ();
              paramAnonymousString = com.tencent.mm.model.c.azp().Bf(paramAnonymousString).adu();
              a.a(paramf, a.this.owO, a.this.wPa, paramAnonymousString);
            }
            AppMethodBeat.o(193226);
          }
        });
        break label3052;
      }
      a(paramf, this.owO, this.wPa, (String)localObject2);
      break label3052;
      label4637:
      paramf.cP("line4", true);
    }
  }
  
  public final boolean aaG(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(this.owO, null);
      }
    }
    final int i;
    label115:
    Object localObject3;
    label235:
    Object localObject4;
    for (;;)
    {
      AppMethodBeat.o(26840);
      return true;
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.owO.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.pMt.field_username });
      if (this.owO.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.owO.getIntent();
        paramString.putExtra("sns_source", this.owO.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.pMt.signature);
        paramString.putExtra("sns_nickName", this.pMt.adu());
        paramString.putExtra("sns_title", this.pMt.adv());
        paramString.putExtra("sns_rpt_scene", c.aG(this.owO.getIntent()));
        if ((o.zbX == null) || (i == 0)) {
          break label289;
        }
        paramString = o.zbX.f(paramString, this.pMt.field_username);
        if (paramString != null) {
          break label307;
        }
        this.owO.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.mzx.aVD("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.j.e.ztz.ztL.ekA = paramString.feQ();
        break;
        i = 0;
        break label115;
        label289:
        paramString.putExtra("sns_userName", this.pMt.field_username);
        break label235;
        label307:
        com.tencent.mm.bs.d.b(this.owO, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.owO.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.pMt;
        if (localObject1 == null) {
          ad.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label641;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.owO.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.pMt.field_username });
          break;
          if (!com.tencent.mm.o.b.lM(((aw)localObject1).field_type))
          {
            if (!bt.isNullOrNil(((aw)localObject1).field_encryptUsername)) {
              a(((aw)localObject1).field_encryptUsername, (am)localObject1);
            } else {
              a(((aw)localObject1).field_username, (am)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.mzx.aVD("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((aw)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.owO.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).ETv);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((aw)localObject1).ePJ);
            b.iRG.m((Intent)localObject3, this.owO);
          }
        }
      }
      else
      {
        label641:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
          localObject1 = this.owO;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.pMt.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.owO.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.owO;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.wOW != null) {
            this.wOW.dAi();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.pMt;
            if (bt.a(Boolean.valueOf(w.zB(((aw)localObject1).field_username)), false))
            {
              localObject1 = ((aw)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.owO.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.owO.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.pMt.field_username });
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.owO, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.owO;
              paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahp(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((aw)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.owO.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((aw)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.owO, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.owO;
                paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahp(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.pMt;
            localObject1 = new ya();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.owO.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.pMt.field_username });
            if ((!paramString.field_username.equals(((ya)localObject1).dMm.talker)) && ((((ya)localObject1).dMm.dkp) || (((ya)localObject1).dMm.dkq)))
            {
              if (((ya)localObject1).dMm.dMn) {}
              for (i = 2131756778;; i = 2131756779)
              {
                Toast.makeText(this.owO, i, 0).show();
                ad.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.s.a.cd(this.owO)) && (!com.tencent.mm.s.a.ch(this.owO)))
            {
              localObject1 = new wm();
              ((wm)localObject1).dKN.dKP = true;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = ((wm)localObject1).dKO.dKR;
              if (!bt.isNullOrNil((String)localObject1))
              {
                ad.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                h.e(this.owO, this.owO.getString(2131764350), "", this.owO.getString(2131755835), this.owO.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26822);
                    Object localObject = new wm();
                    ((wm)localObject).dKN.dKQ = true;
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = new fk();
                    ((fk)localObject).dqw.username = com.tencent.mm.bj.d.irv.aMm();
                    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                    a.this.a(paramString, a.this.owO);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(26822);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(193225);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(193225);
                  }
                });
              }
              else
              {
                a(paramString, this.owO);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2268;
            }
            localObject4 = this.owO;
            localObject1 = this.pMt;
            i = this.mScene;
            if ((i != 17) || (!this.wOX)) {
              break;
            }
            h.a(this.owO, this.owO.getString(2131762026), "", this.owO.getString(2131766205), null);
          }
        }
      }
    }
    paramString = (String)localObject1;
    if ((int)((com.tencent.mm.o.b)localObject1).gfj == 0)
    {
      ba.aBQ();
      paramString = (String)localObject1;
      if (com.tencent.mm.model.c.azp().ah((am)localObject1) != -1)
      {
        ba.aBQ();
        paramString = com.tencent.mm.model.c.azp().Bf(((aw)localObject1).field_username);
      }
    }
    Object localObject2 = this.owO.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.owO.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = bt.nullAsNil((String)localObject2);
    localObject1 = bt.nullAsNil((String)localObject1);
    if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject2);
      if (localObject3 != null) {
        break label3156;
      }
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject1);
      localObject2 = localObject1;
    }
    label2222:
    label3156:
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.owO, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(193235);
          if (paramAnonymousBoolean1)
          {
            a locala = a.this;
            paramAnonymousString2 = paramString;
            int i = i;
            if (bt.isNullOrNil(paramAnonymousString1))
            {
              ad.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
              com.tencent.mm.plugin.report.service.g.yhR.dD(931, 21);
            }
            if ((int)paramAnonymousString2.gfj == 0)
            {
              if (!bt.isNullOrNil(paramAnonymousString1)) {
                paramAnonymousString2.setUsername(paramAnonymousString1);
              }
              ba.aBQ();
              com.tencent.mm.model.c.azp().ah(paramAnonymousString2);
              ba.aBQ();
              com.tencent.mm.model.c.azp().Bf(paramAnonymousString2.field_username);
            }
            if ((int)paramAnonymousString2.gfj <= 0)
            {
              ad.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
              AppMethodBeat.o(193235);
              return;
            }
            com.tencent.mm.plugin.report.service.g localg;
            String str;
            if ((!com.tencent.mm.o.b.lM(paramAnonymousString2.field_type)) && (i == 15))
            {
              paramAnonymousString1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramAnonymousString2.field_username);
              if ((paramAnonymousString1 != null) && (!bt.isNullOrNil(paramAnonymousString2.ePJ)))
              {
                localg = com.tencent.mm.plugin.report.service.g.yhR;
                str = paramAnonymousString2.field_username;
                if (!bt.isNullOrNil(paramAnonymousString1.Lb())) {
                  break label308;
                }
              }
            }
            label308:
            for (i = 0;; i = 1)
            {
              localg.f(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.o.a.f(paramAnonymousString2)) });
              w.u(paramAnonymousString2);
              locala.mzx.notifyDataSetChanged();
              au.aD(paramAnonymousString2.field_encryptUsername, 0);
              paramAnonymousString1 = new qj();
              paramAnonymousString1.dFe.username = paramAnonymousString2.field_encryptUsername;
              paramAnonymousString1.dFe.type = 1;
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString1);
              AppMethodBeat.o(193235);
              return;
            }
          }
          if (paramAnonymousBoolean2)
          {
            com.tencent.mm.bk.d.aMo().gn(paramAnonymousString1, 2);
            au.aD(paramString.field_encryptUsername, 1);
            paramAnonymousString1 = new qj();
            paramAnonymousString1.dFe.username = paramString.field_encryptUsername;
            paramAnonymousString1.dFe.type = 1;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousString1);
            AppMethodBeat.o(193235);
            return;
          }
          ad.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
          AppMethodBeat.o(193235);
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).lu((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).EUN = new a.b()
      {
        public final boolean az(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(193236);
          String str = this.cWq.getIntent().getStringExtra("room_name");
          int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
          SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
          Object localObject;
          if ((!am.aSQ(paramString.field_username)) && (i == 1))
          {
            localObject = SayHiWithSnsPermissionUI2.class;
            localObject = new Intent(this.cWq, (Class)localObject);
            ((Intent)localObject).putExtra("Contact_User", paramString.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramString.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramString.field_conRemark);
            if ((i != 14) && (i != 8)) {
              break label374;
            }
            ((Intent)localObject).putExtra("Contact_RoomNickname", this.cWq.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("Contact_Scene", i);
            ((Intent)localObject).putExtra("room_name", str);
            ((Intent)localObject).putExtra("source_from_user_name", this.wPl);
            ((Intent)localObject).putExtra("source_from_nick_name", str);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
            ((Intent)localObject).putExtra(e.c.IUp, paramAnonymousString);
            ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
            ((Intent)localObject).putExtra("key_msg_id", l);
            paramAnonymousString = this.cWq;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(193236);
            return true;
            localObject = localSayHiWithSnsPermissionUI;
            if (am.aSQ(paramString.field_username)) {
              break;
            }
            localObject = localSayHiWithSnsPermissionUI;
            if (i != 2) {
              break;
            }
            localObject = SayHiWithSnsPermissionUI3.class;
            break;
            label374:
            if (i == 17) {
              ((Intent)localObject).putExtra("key_msg_id", this.cWq.getIntent().getLongExtra("key_msg_id", 0L));
            }
          }
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.c.IUp);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aME((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, "", (LinkedList)localObject3);
      }
      for (;;)
      {
        if (!com.tencent.mm.plugin.messenger.e.a.ye(l)) {
          break label2266;
        }
        com.tencent.mm.plugin.messenger.e.a.R(l, 3);
        break;
        if (TextUtils.isEmpty(str))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aME(paramString.ePK);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).h(paramString.field_username, (LinkedList)localObject3);
        }
        else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).txJ))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
        }
        else
        {
          ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azp().Bf(paramString.field_username);
          if (localObject1 != null) {}
          for (localObject1 = bt.bI(((aw)localObject1).ePK, "");; localObject1 = "")
          {
            ad.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2222;
            }
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aME((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
            break;
          }
          this.wOY.add(paramString.field_username);
          as.a.hFO.a(paramString.field_username, str, new as.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(193224);
              ba.aBQ();
              paramAnonymousString = com.tencent.mm.model.c.azp().Bf(paramString.field_username);
              if (paramAnonymousString != null) {}
              for (paramAnonymousString = bt.bI(paramAnonymousString.ePK, "");; paramAnonymousString = "")
              {
                this.wPd.aME(paramAnonymousString);
                this.wPd.d(paramString.field_username, str, this.wPf);
                AppMethodBeat.o(193224);
                return;
              }
            }
          });
        }
      }
      label2266:
      break;
      label2268:
      if (paramString.equals("contact_profile_accept_contact"))
      {
        localObject2 = this.owO;
        localObject3 = this.pMt;
        ((MMActivity)localObject2).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
        localObject1 = SayHiWithSnsPermissionUI.class;
        if ((!am.aSQ(((aw)localObject3).field_username)) && (i == 1)) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject2, paramString);
          paramString.putExtra("Contact_User", ((aw)localObject3).field_username);
          paramString.putExtra("room_name", this.fPi);
          paramString.putExtra("Contact_Nick", ((aw)localObject3).field_nickname);
          paramString.putExtra("Contact_RemarkName", ((aw)localObject3).field_conRemark);
          if ((this.mScene == 14) || (this.mScene == 8)) {
            paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject2).getIntent().getStringExtra("Contact_RoomNickname"));
          }
          paramString.putExtra("Contact_Scene", this.mScene);
          paramString.putExtra("Verify_ticket", bt.nullAsNil(((Activity)localObject2).getIntent().getStringExtra("Verify_ticket")));
          paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
          paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
          paramString.putExtra("sayhi_with_sns_perm_set_label", true);
          paramString.putExtra("sayhi_with_sns_permission", ((am)localObject3).adn());
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramString.ahp(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramString = (String)localObject1;
          if (!am.aSQ(((aw)localObject3).field_username))
          {
            paramString = (String)localObject1;
            if (i == 2) {
              paramString = SayHiWithSnsPermissionUI3.class;
            }
          }
        }
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.pMt;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.c.IUp, paramString.ePK);
        b.iRG.a((Intent)localObject1, this.owO);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.wOW == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.owO, this.pMt);
        com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(c.aG(this.owO.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.pMt.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.mzx.aVD("contact_info_invite_source")).getExtras().getString("inviter");
        if (bt.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.fLO, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fPi);
        ba.aBQ();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.azp().Bf(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fPi);
        b.iRG.c((Intent)localObject2, this.owO);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.pMt;
        localObject3 = bt.nullAsNil(this.owO.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = com.tencent.mm.plugin.profile.ui.p.a(this.owO, (am)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].hDo;
          paramString = com.tencent.mm.plugin.profile.ui.p.b(this.owO, (am)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((aw)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.ajB().gAO.hOv, new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
          {
            AppMethodBeat.i(193232);
            paramAnonymousn.setHasCallbackToQueue(true);
            paramAnonymousString = (com.tencent.mm.plugin.profile.b.a)paramAnonymousn;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              if (paramAnonymousString.wPx == null) {
                paramAnonymousString.wPx = ((bfh)paramAnonymousString.rr.hNL.hNQ);
              }
              String str = paramAnonymousString.wPx.GBg;
              paramAnonymousString = null;
              try
              {
                paramAnonymousn = Uri.parse(str);
                paramAnonymousString = paramAnonymousn;
              }
              catch (Exception paramAnonymousn)
              {
                for (;;)
                {
                  ad.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramAnonymousn.getMessage() });
                }
              }
              paramAnonymousString = new Intent("android.intent.action.VIEW", paramAnonymousString);
              a.this.owO.startActivityForResult(paramAnonymousString, 111);
              ad.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
              AppMethodBeat.o(193232);
              return;
            }
            ad.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (paramAnonymousString.wPx == null) {
              paramAnonymousString.wPx = ((bfh)paramAnonymousString.rr.hNL.hNQ);
            }
            if ((paramAnonymousString.wPx.BaseResponse != null) && (paramAnonymousString.wPx.BaseResponse.ErrMsg != null)) {}
            for (paramAnonymousString = bt.nullAsNil(paramAnonymousString.wPx.BaseResponse.ErrMsg.HoB);; paramAnonymousString = paramAnonymousString.errMsg)
            {
              paramAnonymousn = paramAnonymousString;
              if (bt.isNullOrNil(paramAnonymousString)) {
                paramAnonymousn = a.this.owO.getString(2131761817);
              }
              h.c(a.this.owO, paramAnonymousn, a.this.owO.getString(2131764439), false);
              AppMethodBeat.o(193232);
              return;
            }
          }
        });
        break;
      }
      if (!paramString.equals("contact_profile_story")) {
        break;
      }
      paramString = (AbsStoryPreference)this.mzx.aVD("contact_profile_story");
      if (paramString == null) {
        break;
      }
      paramString.egQ();
      break;
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean cdn()
  {
    AppMethodBeat.i(26839);
    this.mzx.aVD("contact_profile_sns");
    if (o.zbX != null) {
      o.zbX.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.mzx.aVD("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.mzx.aVD("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.wPb.dead();
    if (this.wOW != null) {
      this.wOW.destroy();
    }
    localObject = this.wOY.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      as.a.hFO.AJ(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void eM(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.mzx.cP("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    ad.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.mzx.cP("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.mzx, this.pMt, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */