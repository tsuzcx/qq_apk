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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.bb.a;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.a.b.b;
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
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
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
  ac fNS;
  String fRo;
  com.tencent.mm.ui.base.preference.f mEx;
  private int mScene;
  MMActivity oDq;
  an pSY;
  private boolean readOnly;
  com.tencent.mm.plugin.profile.a.b xeK;
  private boolean xeL;
  final List<String> xeM;
  private com.tencent.mm.ui.widget.a.e xeN;
  String xeO;
  com.tencent.mm.sdk.b.c<bb> xeP;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.xeM = new LinkedList();
    this.xeO = null;
    this.xeP = new com.tencent.mm.sdk.b.c() {};
    this.oDq = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    ae.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.aXe("contact_info_invite_source");
    paramf.cT("contact_info_invite_source", false);
    paramf = new SpannableString(k.c(paramActivity, paramActivity.getResources().getString(2131757692, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.ada(2);
    localKeyValuePreference.JNz = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (dDr())
    {
      paramf.cT("contact_profile_setting_desc", true);
      paramf.cT("contact_profile_setting_permission", true);
      paramf.cT("contact_profile_phone", true);
      paramf.cT("contact_profile_info_more", true);
      paramf.cT("contact_profile_sns", an.aUq(paraman.field_username));
      if ((v.aAH() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.s(this.oDq, "com.tencent.wework");
        bc.aCg();
        Object localObject = (Integer)com.tencent.mm.model.c.ajA().get(am.a.ILl, Integer.valueOf(0));
        ae.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(v.aAH()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bu.jB(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.s(this.oDq, "com.tencent.wework")))) {
          break label325;
        }
        paramf.cT("contact_profile_accept_contact_by_wework", false);
        localObject = com.tencent.mm.plugin.profile.ui.p.a(this.oDq, paraman, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label434;
        }
      }
    }
    label434:
    for (paraman = com.tencent.mm.plugin.profile.ui.p.b(this.oDq, paraman, this.mScene);; paraman = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.avU(this.pSY.field_username)) {
        ((ButtonPreference)paramf.aXe("contact_profile_accept_contact_by_wework")).gE(this.oDq.getString(2131757689), this.oDq.getResources().getColor(2131100035));
      }
      if ((!bu.isNullOrNil(paraman)) && (com.tencent.mm.plugin.profile.b.e.avT(paraman) == 2) && (paramBoolean)) {
        paramf.cT("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label325:
      if (this.oDq.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paraman = (ButtonPreference)paramf.aXe("contact_profile_accept_contact");
        paraman.gE(this.oDq.getString(2131755200), this.oDq.getResources().getColor(2131100249));
        paraman.setEnabled(false);
      }
      paramf.cT("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.cT("contact_profile_accept_contact", true);
      paramf.cT("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(String paramString, an paraman)
  {
    AppMethodBeat.i(26849);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(26849);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paraman.field_username);
    paramString.putExtra("Contact_Nick", paraman.field_nickname);
    paramString.putExtra("Contact_RemarkName", paraman.field_conRemark);
    b.iUz.n(paramString, this.oDq);
    AppMethodBeat.o(26849);
  }
  
  static String b(ac paramac, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramac == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramString);
    Object localObject1 = localObject2;
    if (localan != null)
    {
      localObject1 = localObject2;
      if ((int)localan.ght > 0) {
        localObject1 = localan.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bu.isNullOrNil((String)localObject1)) {
      localObject2 = paramac.zP(paramString);
    }
    paramac = (ac)localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      paramac = (ac)localObject2;
      if (localan != null) {
        paramac = localan.adF();
      }
    }
    AppMethodBeat.o(26854);
    return paramac;
  }
  
  private boolean dDn()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = x.hIe;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.pSY.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = dDo();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean dDo()
  {
    AppMethodBeat.i(26843);
    boolean bool = x.AQ(this.pSY.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean dDp()
  {
    AppMethodBeat.i(186500);
    boolean bool = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aji(this.pSY.field_username);
    AppMethodBeat.o(186500);
    return bool;
  }
  
  private boolean dDq()
  {
    AppMethodBeat.i(26844);
    boolean bool = an.Ac(this.pSY.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean dDr()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (this.oDq.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean dDs()
  {
    AppMethodBeat.i(26846);
    if (this.oDq.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean dDt()
  {
    AppMethodBeat.i(26847);
    if (this.oDq.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean dDu()
  {
    AppMethodBeat.i(26848);
    int i = this.oDq.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean dDv()
  {
    return this.pSY.field_deleteFlag == 1;
  }
  
  final void a(final an paraman, final Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.xeN = new com.tencent.mm.ui.widget.a.e(this.oDq, 1, false);
    this.xeN.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(186496);
        paramAnonymousl.aM(2, 2131755762, 2131691164);
        paramAnonymousl.aM(1, 2131755764, 2131691165);
        AppMethodBeat.o(186496);
      }
    };
    this.xeN.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(186497);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186497);
          return;
          paramAnonymousMenuItem = paraman;
          Context localContext = paramContext;
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
          ae.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), localContext });
          yh localyh;
          if (bool)
          {
            localyh = new yh();
            localyh.dNE.dto = 5;
            localyh.dNE.talker = paramAnonymousMenuItem.field_username;
            localyh.dNE.context = localContext;
            localyh.dNE.dNA = 4;
            com.tencent.mm.sdk.b.a.IvT.l(localyh);
          }
          AppMethodBeat.o(186497);
          return;
          paramAnonymousMenuItem = paraman;
          localContext = paramContext;
          bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
          ae.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), localContext });
          if (bool)
          {
            bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
            ae.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), localContext });
            if (bool)
            {
              localyh = new yh();
              localyh.dNE.dto = 5;
              localyh.dNE.talker = paramAnonymousMenuItem.field_username;
              localyh.dNE.context = localContext;
              localyh.dNE.dNA = 2;
              com.tencent.mm.sdk.b.a.IvT.l(localyh);
            }
          }
        }
      }
    };
    this.xeN.cPF();
    AppMethodBeat.o(26850);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.mEx.aXe("contact_profile_sns");
    if ((paramString != null) && (o.zsw != null))
    {
      paramString.aOC(this.pSY.field_username);
      com.tencent.mm.plugin.sns.j.e.zKO.zLc.emh = paramString.fiG();
      if (o.zsA != null) {
        o.zsA.a(this, 3);
      }
      this.mEx.notifyDataSetChanged();
      if (paramb.dVT())
      {
        ae.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (o.zsA != null) {
          o.zsA.azb(this.pSY.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.mEx = paramf;
    this.pSY = paraman;
    this.mScene = paramInt;
    this.fRo = this.oDq.getIntent().getStringExtra("room_name");
    bc.aCg();
    this.fNS = com.tencent.mm.model.c.azP().Bx(this.fRo);
    this.xeL = this.oDq.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.xeK == null)
    {
      this.xeK = new com.tencent.mm.plugin.profile.a.b(this.oDq, paraman);
      this.xeK.dkv();
    }
    ae.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paraman.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2131951696);
    Object localObject3 = (NormalProfileHeaderPreference)paramf.aXe("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject3).mEx = paramf;
    ((NormalProfileHeaderPreference)localObject3).a(paraman, paramInt, paramBoolean, this.xeK);
    Object localObject1 = (ButtonPreference)paramf.aXe("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).JMq = 2131298702;
    }
    Object localObject2 = (ButtonPreference)paramf.aXe("contact_profile_add_contact");
    Object localObject5 = this.oDq;
    Object localObject4 = this.pSY;
    int j;
    if ((an.aUq(((aw)localObject4).field_username)) && (((aw)localObject4).eRx != 0))
    {
      j = paramf.indexOf("contact_info_category_1");
      Object localObject6 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(((aw)localObject4).field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.a.a.iKm);
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = new PreferenceTitleCategory((Context)localObject5);
        ((Preference)localObject7).setTitle((CharSequence)localObject6);
        paramf.a((Preference)localObject7, j);
        ((Preference)localObject7).JOj = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject6 = new com.tencent.mm.openim.a.b();
      ((com.tencent.mm.openim.a.b)localObject6).Jd(((aw)localObject4).eRy);
      localObject6 = ((com.tencent.mm.openim.a.b)localObject6).iKp.iterator();
      if (((Iterator)localObject6).hasNext())
      {
        localObject7 = (com.tencent.mm.openim.a.b.a)((Iterator)localObject6).next();
        Iterator localIterator = ((com.tencent.mm.openim.a.b.a)localObject7).iKq.iterator();
        i = j;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          b.b localb = (b.b)localIterator.next();
          j = i + 1;
          com.tencent.mm.plugin.profile.a.a.2 local2 = new com.tencent.mm.plugin.profile.a.a.2((Context)localObject5, localb);
          local2.Jvz = ((com.tencent.mm.openim.a.b.a)localObject7).title;
          local2.ada(2);
          local2.JNz = false;
          local2.setSummary(k.c((Context)localObject5, localb.Je(((aw)localObject4).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.ade(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.JOj = new com.tencent.mm.plugin.profile.a.a.3(localb, (an)localObject4, (com.tencent.mm.openim.a.b.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.JOj = new com.tencent.mm.plugin.profile.a.a.4(localb, (an)localObject4, (com.tencent.mm.openim.a.b.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.JOj = new com.tencent.mm.plugin.profile.a.a.5(localb, (an)localObject4, (com.tencent.mm.openim.a.b.a)localObject7);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.JOj = new com.tencent.mm.plugin.profile.a.a.6(localb, (an)localObject4, (com.tencent.mm.openim.a.b.a)localObject7);
              i = j;
            }
          }
        }
      }
      i = j + 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject5), i);
      localObject6 = new KeyValuePreference((Context)localObject5);
      ((KeyValuePreference)localObject6).setTitle(2131757648);
      Object localObject7 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(((aw)localObject4).field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.a.a.iKm);
      ((KeyValuePreference)localObject6).setSummary(k.c((Context)localObject5, (CharSequence)localObject7));
      localObject5 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(((aw)localObject4).field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.a.a.iKn);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((Preference)localObject6).JOj = new com.tencent.mm.plugin.profile.a.a.7((String)localObject5, (an)localObject4, (String)localObject7);
      }
      paramf.a((Preference)localObject6, i + 1);
    }
    if (dDo())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject3);
      paramf.b(new PreferenceSmallCategory(this.oDq));
      paraman = new KeyValuePreference(this.oDq);
      paraman.setTitle(2131757694);
      paraman.setSummary(2131757916);
      paraman.ada(2147483647);
      paraman.JNz = false;
      paraman.ade(8);
      paramf.b(paraman);
      paramf.b(new PreferenceSmallCategory(this.oDq));
      if (com.tencent.mm.contact.c.lO(this.pSY.field_type)) {
        paramf.b((Preference)localObject1);
      }
      for (;;)
      {
        this.xeK.oPS.removeAllOptionMenu();
        AppMethodBeat.o(26837);
        return true;
        paramf.b((Preference)localObject2);
      }
    }
    localObject3 = this.pSY;
    int i = this.oDq.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.oDq.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = bu.bI(this.oDq.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new dia();
    ((dia)localObject2).jgg = i;
    ((dia)localObject2).jgi = l;
    ((dia)localObject2).jgh = ((String)localObject1);
    localObject1 = localObject2;
    if (o.zsw != null) {
      localObject1 = o.zsw.b(((aw)localObject3).field_username, (dia)localObject2);
    }
    bc.aCg();
    boolean bool1 = com.tencent.mm.model.c.azF().aUH(((aw)localObject3).field_username);
    boolean bool2 = v.aAC().equals(((aw)localObject3).field_username);
    if ((((dia)localObject1).jgg & 0x1) > 0)
    {
      paramBoolean = true;
      ae.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((an.aUo(((aw)localObject3).field_username)) || (!paramBoolean)) && (!dDr()) && (!bool2)) {
        break label3408;
      }
      this.mEx.cT("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.mEx.aXe("contact_profile_sns");
      if (o.zsA != null)
      {
        o.zsA.a(3, ((aw)localObject3).field_username, this);
        i = this.oDq.getIntent().getIntExtra("Sns_from_Scene", 0);
        o.zsA.a(2, ((aw)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).aOC(((aw)localObject3).field_username);
      label1310:
      if (an.aUq(((aw)localObject3).field_username)) {
        this.mEx.cT("contact_profile_sns", true);
      }
      localObject2 = paramf.aXe("contact_profile_setting_desc");
      if (!an.aUq(this.pSY.field_username)) {
        break label3424;
      }
      localObject1 = this.oDq.getText(2131757927).toString();
      label1374:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.aXe("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.oDq.getString(2131761879);
      if (!this.pSY.adA()) {
        break label3444;
      }
      ((MultiSummaryPreference)localObject1).xiz = new String[] { this.oDq.getString(2131762042) };
      localObject1 = (KeyValuePreference)paramf.aXe("contact_profile_source");
      paramInt = this.oDq.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.oDq, this.pSY, paramInt, this.pSY.field_username, dDr());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).ada(2);
      ((KeyValuePreference)localObject1).JNz = false;
      ((KeyValuePreference)localObject1).pDQ = (com.tencent.mm.cb.a.aA(this.oDq, (int)this.oDq.getResources().getDimension(2131165517)) * com.tencent.mm.cb.a.ef(this.oDq));
      ((KeyValuePreference)localObject1).ade(8);
      if ((!com.tencent.mm.contact.c.lO(paraman.field_type)) && (!bu.ah((CharSequence)localObject2)) && ((!dDs()) || (dDr()))) {
        break label3707;
      }
      paramBoolean = true;
      label1593:
      paramf.cT("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.aXe("contact_profile_label");
      ((LabelPreference)localObject1).pSY = paraman;
      if (!com.tencent.mm.contact.c.lO(((LabelPreference)localObject1).pSY.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).pSY.field_encryptUsername;
        if (!bu.isNullOrNil((String)localObject2))
        {
          bc.aCg();
          ((LabelPreference)localObject1).xzF = com.tencent.mm.model.c.azG().arE((String)localObject2);
        }
        if ((((LabelPreference)localObject1).xzF != null) && (((LabelPreference)localObject1).xzF.systemRowid < 0L))
        {
          bc.aCg();
          ((LabelPreference)localObject1).xzF = com.tencent.mm.model.c.azG().arE(((LabelPreference)localObject1).pSY.field_username);
        }
      }
      if ((!com.tencent.mm.contact.c.lO(((LabelPreference)localObject1).pSY.field_type)) || (bu.isNullOrNil(((LabelPreference)localObject1).pSY.field_contactLabelIds))) {
        break label3712;
      }
      paramInt = 1;
      label1752:
      if (paramInt != 0) {
        break label3746;
      }
      paramBoolean = true;
      label1759:
      paramf.cT("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.aXe("contact_profile_phone");
      ((PhoneNumPreference)localObject3).mEx = paramf;
      localObject4 = this.oDq.getIntent();
      ((PhoneNumPreference)localObject3).pSY = paraman;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      ae.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paraman.adC() });
      if (!paraman.adC())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!bu.isNullOrNil((String)localObject2)) || (!bu.isNullOrNil((String)localObject4))) {
          break label3759;
        }
        if (!bu.isNullOrNil(paraman.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paraman.field_username);
          localObject4 = paraman.field_username;
          if (localObject2 != null) {
            break label3751;
          }
          localObject1 = "true";
          label1928:
          ae.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1955:
        if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lj())))
        {
          ((PhoneNumPreference)localObject3).FlQ = bu.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aTc()).replace(" ", "");
          ae.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paraman.field_username, ((PhoneNumPreference)localObject3).FlQ });
        }
        ((PhoneNumPreference)localObject3).fiE();
      }
      ((PhoneNumPreference)localObject3).FlR = PhoneNumPreference.b(((PhoneNumPreference)localObject3).FlQ, paraman);
      ((PhoneNumPreference)localObject3).mEx.cT("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).fiE();
      ((PhoneNumPreference)localObject3).ade(8);
      localObject1 = (ProfileDescribePreference)paramf.aXe("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).pSY = paraman;
      if (!com.tencent.mm.contact.c.lO(((ProfileDescribePreference)localObject1).pSY.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).pSY.field_encryptUsername;
        if (!bu.isNullOrNil((String)localObject2))
        {
          bc.aCg();
          ((ProfileDescribePreference)localObject1).xzF = com.tencent.mm.model.c.azG().arE((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).xzF != null) && (((ProfileDescribePreference)localObject1).xzF.systemRowid < 0L))
        {
          bc.aCg();
          ((ProfileDescribePreference)localObject1).xzF = com.tencent.mm.model.c.azG().arE(((ProfileDescribePreference)localObject1).pSY.field_username);
        }
      }
      if (com.tencent.mm.contact.c.lO(((ProfileDescribePreference)localObject1).pSY.field_type)) {
        break label3901;
      }
      if ((((ProfileDescribePreference)localObject1).xzF == null) || (bu.isNullOrNil(((ProfileDescribePreference)localObject1).xzF.field_conDescription))) {
        break label3895;
      }
      paramInt = 1;
      label2222:
      if (paramInt != 0) {
        break label3955;
      }
      paramBoolean = true;
      label2229:
      paramf.cT("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.contact.c.lO(paraman.field_type)) || (bu.isNullOrNil(paraman.signature))) {
        break label3960;
      }
      localObject1 = (KeyValuePreference)paramf.aXe("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).pDQ = (com.tencent.mm.cb.a.aA(this.oDq, (int)this.oDq.getResources().getDimension(2131165517)) * com.tencent.mm.cb.a.ef(this.oDq));
        ((KeyValuePreference)localObject1).JNz = false;
        ((KeyValuePreference)localObject1).setTitle(this.oDq.getString(2131757822));
        ((KeyValuePreference)localObject1).setSummary(k.c(this.oDq, paraman.signature));
        ((KeyValuePreference)localObject1).xN(false);
        ((KeyValuePreference)localObject1).ada(5);
        ((KeyValuePreference)localObject1).ade(8);
      }
      label2370:
      if ((paramf.aXg("contact_profile_desc") >= 0) || (paramf.aXg("contact_profile_label") >= 0)) {
        break label3973;
      }
      paramf.cT("contact_profile_setting_desc", false);
      label2404:
      if (!com.tencent.mm.contact.c.lO(paraman.field_type)) {
        paramf.cT("contact_profile_setting_desc", false);
      }
      paramf.cT("contact_profile_set_des_category", true);
      if ((!an.aUq(this.pSY.field_username)) || (!bu.isNullOrNil(this.pSY.field_conRemark))) {
        break label3986;
      }
      paramf.cT("contact_profile_setting_desc", false);
      paramf.cT("contact_profile_set_des_category", true);
      label2482:
      paramf.aXe("contact_profile_info_more").setTitle(this.oDq.getText(2131757735).toString());
      ((TextPreference)paramf.aXe("contact_profile_hint")).al(this.oDq.getText(2131757740));
      if (!paraman.adv()) {
        break label4030;
      }
      paramf.cT("contact_profile_hint", false);
      label2551:
      localObject2 = (MultiButtonPreference)paramf.aXe("contact_profile_multi_button");
      if (!dDp()) {
        break label4044;
      }
      ((MultiButtonPreference)localObject2).a(this.oDq.getString(2131763804), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26820);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26820);
        }
      });
      label2595:
      if ((dDn()) || ((com.tencent.mm.contact.c.lO(paraman.field_type)) && (!paraman.adv())) || ((!dDr()) && (dDs()))) {
        paramf.cT("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!dDr()) && (!dDv()) && (!dDq())) {
        break label4234;
      }
      paramf.cT("contact_profile_send", true);
      paramf.cT("contact_profile_voip", true);
      label2700:
      if ((!com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!dDr()) && (!dDv()) && (!dDu()) && (!dDt()) && (!v.aAC().equals(this.pSY.field_username))) {
        break label4265;
      }
      paramf.cT("contact_profile_add_contact", true);
      label2768:
      a(paramf, paraman, false);
      if ((dDr()) || (com.tencent.mm.contact.c.lO(paraman.field_type)) || ((!dDq()) && (!dDu()) && (!dDt()))) {
        break label4319;
      }
      paramf.cT("contact_profile_info_more", true);
      paramf.cT("contact_profile_say_hi", false);
      label2834:
      if (v.zK(this.pSY.field_username))
      {
        paramf.cT("contact_profile_multi_button", true);
        paramf.cT("contact_profile_info_more", bu.isNullOrNil(paraman.signature));
        paramf.cT("contact_profile_setting_desc", true);
        paramf.cT("contact_profile_setting_permission", true);
        paramf.cT("contact_profile_voip", true);
        this.xeK.oPS.removeAllOptionMenu();
      }
      localObject1 = this.pSY;
      paramf.cT("contact_info_invite_source", true);
      if (this.fNS != null) {
        break label4366;
      }
      paramBoolean = this.oDq.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label2953:
      if ((this.mScene == 14) && (paramBoolean) && (this.fNS != null) && (!((aw)localObject1).field_username.equals(this.fNS.field_roomowner))) {
        break label4383;
      }
      paramInt = this.mScene;
      if (this.fNS != null) {
        break label4377;
      }
      bool1 = true;
      label3007:
      ae.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.cT("contact_info_invite_source", true);
      label3052:
      this.mEx.cT("contact_profile_story", true);
      bc.aCg();
      paramBoolean = com.tencent.mm.model.c.azF().aUH(paraman.field_username);
      bool1 = v.aAC().equals(paraman.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().ekC())
      {
        ae.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!an.aUo(paraman.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.mEx.aXe("contact_profile_story");
          paramf.onCreate(paraman.field_username);
          paramf.a(this);
          paramf.ekx();
          paramf.ekw();
        }
      }
      paramf = this.mEx;
      if (!dDp()) {
        break label4637;
      }
      paramf.cT("contact_profile_add_contact", true);
      paramf.cT("contact_profile_accept_contact_by_wework", true);
      paramf.cT("contact_profile_setting_desc", true);
      paramf.cT("contact_profile_send", true);
      paramf.cT("contact_profile_voip", true);
      paramf.cT("contact_profile_say_hi", true);
      paramf.cT("contact_profile_info_more", true);
      paramf.cT("contact_profile_setting_permission", true);
      paramf.cT("contact_profile_voip", true);
      paramf.cT("contact_profile_multi_button", false);
      paramf.cT("contact_profile_set_des_category", true);
      paramf.cT("contact_info_category_1", true);
      paramf.cT("line1", false);
      paramf.cT("line2", false);
      paramf.cT("line3", false);
      paramf.cT("line4", false);
      this.xeK.oPS.removeAllOptionMenu();
    }
    for (;;)
    {
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3408:
      this.mEx.cT("contact_profile_sns", true);
      break label1310;
      label3424:
      localObject1 = this.oDq.getText(2131757926).toString();
      break label1374;
      label3444:
      paramBoolean = paraman.ady();
      bool1 = o.zsy.awb(paraman.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3609;
        }
        localObject3 = this.oDq;
        if (paraman.eQV == 2)
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
        localObject3 = this.oDq;
        if (paraman.eQV != 2) {
          break label3654;
        }
      }
      label3609:
      label3654:
      for (i = 2131762031;; i = 2131762033)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).xiz = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = 2131762038;
        break label3520;
        localObject3 = this.oDq;
        if (paraman.eQV == 2) {}
        for (i = 2131762037;; i = 2131762039)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3662:
      localObject3 = this.oDq;
      if (paraman.eQV == 2) {}
      for (i = 2131762032;; i = 2131762034)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3707:
      paramBoolean = false;
      break label1593;
      label3712:
      if ((((LabelPreference)localObject1).xzF != null) && (!bu.isNullOrNil(((LabelPreference)localObject1).xzF.field_contactLabels)))
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
      if ((bu.isNullOrNil((String)localObject2)) && (bu.isNullOrNil((String)localObject4))) {
        break label1955;
      }
      ae.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paraman.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lj())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject4);
      }
      localObject4 = paraman.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        ae.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label3895:
      paramInt = 0;
      break label2222;
      label3901:
      if (!bu.isNullOrNil(((ProfileDescribePreference)localObject1).pSY.eRp)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((bu.isNullOrNil(((ProfileDescribePreference)localObject1).pSY.eRo)) && (paramInt == 0)) {
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
      paramf.aXf("contact_info_signature");
      break label2370;
      label3973:
      paramf.cT("contact_profile_setting_desc", true);
      break label2404;
      label3986:
      if ((!an.aUq(this.pSY.field_username)) && (!dDp())) {
        break label2482;
      }
      paramf.cT("contact_profile_setting_desc", true);
      paramf.cT("contact_profile_set_des_category", true);
      break label2482;
      label4030:
      paramf.cT("contact_profile_hint", true);
      break label2551;
      label4044:
      if (!dDr())
      {
        if ((!com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (this.oDq.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) == 2))
        {
          paramInt = 1;
          label4085:
          if (paramInt == 0) {
            break label4187;
          }
        }
      }
      else {
        if (!this.pSY.adv()) {
          break label4172;
        }
      }
      label4172:
      for (localObject1 = this.oDq.getString(2131757741);; localObject1 = this.oDq.getString(2131757736))
      {
        ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            a.this.xeK.pw(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26828);
          }
        });
        localObject1 = this.oDq.getString(2131756596);
        localObject3 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26829);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            a.this.xeK.dDG();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26829);
          }
        };
        ((MultiButtonPreference)localObject2).xiu = ((String)localObject1);
        ((MultiButtonPreference)localObject2).xix = ((View.OnClickListener)localObject3);
        break;
        paramInt = 0;
        break label4085;
      }
      label4187:
      if ((!paraman.adv()) && (!dDu()) && (!dDt())) {
        break label2595;
      }
      ((MultiButtonPreference)localObject2).a(this.oDq.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186494);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          a.this.xeK.dDG();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186494);
        }
      });
      break label2595;
      label4234:
      paramf.cT("contact_profile_send", false);
      paramf.cT("contact_profile_voip", this.pSY.adv());
      break label2700;
      label4265:
      paramf.cT("contact_profile_add_contact", false);
      paramf.cT("contact_profile_setting_desc", false);
      paramf.cT("contact_profile_setting_permission", true);
      paramf.cT("contact_profile_phone", true);
      paramf.cT("contact_profile_info_more", true);
      break label2768;
      label4319:
      paramf.cT("contact_profile_say_hi", true);
      if (!com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        paramf.cT("contact_profile_info_more", true);
        break label2834;
      }
      paramf.cT("contact_profile_info_more", false);
      break label2834;
      label4366:
      paramBoolean = this.fNS.YQ();
      break label2953;
      label4377:
      bool1 = false;
      break label3007;
      label4383:
      this.xeO = this.oDq.getIntent().getStringExtra("inviteer");
      if (bu.isNullOrNil(this.xeO)) {
        this.xeO = this.fNS.aUh(((aw)localObject1).field_username);
      }
      if (bu.isNullOrNil(this.xeO)) {
        this.xeO = r.aD(((aw)localObject1).field_username, this.fRo);
      }
      if (bu.isNullOrNil(this.xeO))
      {
        ae.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.fRo, ((aw)localObject1).field_username });
        this.xeP.alive();
        this.xeM.add(((aw)localObject1).field_username);
        au.a.hIG.a(((aw)localObject1).field_username, this.fRo, new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(26824);
            ae.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fRo, Boolean.valueOf(paramAnonymousBoolean) });
            a.this.xeP.dead();
            AppMethodBeat.o(26824);
          }
        });
        break label3052;
      }
      this.oDq.getIntent().putExtra("inviteer", this.xeO);
      localObject2 = b(this.fNS, this.xeO);
      if (bu.isNullOrNil((String)localObject2))
      {
        this.xeM.add(((aw)localObject1).field_username);
        au.a.hIG.a(((aw)localObject1).field_username, "", new au.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(186489);
            ae.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fRo, Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              bc.aCg();
              paramAnonymousString = com.tencent.mm.model.c.azF().BH(paramAnonymousString).adF();
              a.a(paramf, a.this.oDq, a.this.xeO, paramAnonymousString);
            }
            AppMethodBeat.o(186489);
          }
        });
        break label3052;
      }
      a(paramf, this.oDq, this.xeO, (String)localObject2);
      break label3052;
      label4637:
      paramf.cT("line4", true);
    }
  }
  
  public final boolean abx(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(this.oDq, null);
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
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(this.oDq.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.pSY.field_username });
      if (this.oDq.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.oDq.getIntent();
        paramString.putExtra("sns_source", this.oDq.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.pSY.signature);
        paramString.putExtra("sns_nickName", this.pSY.adF());
        paramString.putExtra("sns_title", this.pSY.adG());
        paramString.putExtra("sns_rpt_scene", c.aH(this.oDq.getIntent()));
        if ((o.zsA == null) || (i == 0)) {
          break label289;
        }
        paramString = o.zsA.f(paramString, this.pSY.field_username);
        if (paramString != null) {
          break label307;
        }
        this.oDq.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.mEx.aXe("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.j.e.zKO.zLc.emh = paramString.fiG();
        break;
        i = 0;
        break label115;
        label289:
        paramString.putExtra("sns_userName", this.pSY.field_username);
        break label235;
        label307:
        com.tencent.mm.br.d.b(this.oDq, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.oDq.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.pSY;
        if (localObject1 == null) {
          ae.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label641;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(this.oDq.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.pSY.field_username });
          break;
          if (!com.tencent.mm.contact.c.lO(((aw)localObject1).field_type))
          {
            if (!bu.isNullOrNil(((aw)localObject1).field_encryptUsername)) {
              a(((aw)localObject1).field_encryptUsername, (an)localObject1);
            } else {
              a(((aw)localObject1).field_username, (an)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.mEx.aXe("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((aw)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.oDq.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).FlQ);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((aw)localObject1).eRu);
            b.iUz.m((Intent)localObject3, this.oDq);
          }
        }
      }
      else
      {
        label641:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
          localObject1 = this.oDq;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.pSY.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.oDq.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.oDq;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.xeK != null) {
            this.xeK.dDz();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.pSY;
            if (bu.a(Boolean.valueOf(x.Al(((aw)localObject1).field_username)), false))
            {
              localObject1 = ((aw)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.oDq.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(this.oDq.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.pSY.field_username });
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.oDq, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.oDq;
              paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahE(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((aw)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.oDq.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((aw)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.oDq, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.oDq;
                paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahE(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.pSY;
            localObject1 = new yg();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(this.oDq.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.pSY.field_username });
            if ((!paramString.field_username.equals(((yg)localObject1).dNC.talker)) && ((((yg)localObject1).dNC.dlr) || (((yg)localObject1).dNC.dls)))
            {
              if (((yg)localObject1).dNC.dND) {}
              for (i = 2131756778;; i = 2131756779)
              {
                Toast.makeText(this.oDq, i, 0).show();
                ae.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.r.a.cf(this.oDq)) && (!com.tencent.mm.r.a.cj(this.oDq)))
            {
              localObject1 = new wq();
              ((wq)localObject1).dMc.dMe = true;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = ((wq)localObject1).dMd.dMg;
              if (!bu.isNullOrNil((String)localObject1))
              {
                ae.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                h.e(this.oDq, this.oDq.getString(2131764350), "", this.oDq.getString(2131755835), this.oDq.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26822);
                    Object localObject = new wq();
                    ((wq)localObject).dMc.dMf = true;
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = new fl();
                    ((fl)localObject).drB.username = com.tencent.mm.bi.d.iup.aMK();
                    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                    a.this.a(paramString, a.this.oDq);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(26822);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(186488);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(186488);
                  }
                });
              }
              else
              {
                a(paramString, this.oDq);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2268;
            }
            localObject4 = this.oDq;
            localObject1 = this.pSY;
            i = this.mScene;
            if ((i != 17) || (!this.xeL)) {
              break;
            }
            h.a(this.oDq, this.oDq.getString(2131762026), "", this.oDq.getString(2131766205), null);
          }
        }
      }
    }
    paramString = (String)localObject1;
    if ((int)((com.tencent.mm.contact.c)localObject1).ght == 0)
    {
      bc.aCg();
      paramString = (String)localObject1;
      if (com.tencent.mm.model.c.azF().ao((an)localObject1) != -1)
      {
        bc.aCg();
        paramString = com.tencent.mm.model.c.azF().BH(((aw)localObject1).field_username);
      }
    }
    Object localObject2 = this.oDq.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.oDq.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = bu.nullAsNil((String)localObject2);
    localObject1 = bu.nullAsNil((String)localObject1);
    if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject2);
      if (localObject3 != null) {
        break label3156;
      }
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject1);
      localObject2 = localObject1;
    }
    label2222:
    label3156:
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.oDq, new com.tencent.mm.pluginsdk.ui.applet.a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(186498);
          if (paramAnonymousBoolean1)
          {
            a locala = a.this;
            paramAnonymousString2 = paramString;
            int i = i;
            if (bu.isNullOrNil(paramAnonymousString1))
            {
              ae.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
              com.tencent.mm.plugin.report.service.g.yxI.dD(931, 21);
            }
            if ((int)paramAnonymousString2.ght == 0)
            {
              if (!bu.isNullOrNil(paramAnonymousString1)) {
                paramAnonymousString2.setUsername(paramAnonymousString1);
              }
              bc.aCg();
              com.tencent.mm.model.c.azF().ao(paramAnonymousString2);
              bc.aCg();
              com.tencent.mm.model.c.azF().BH(paramAnonymousString2.field_username);
            }
            if ((int)paramAnonymousString2.ght <= 0)
            {
              ae.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
              AppMethodBeat.o(186498);
              return;
            }
            com.tencent.mm.plugin.report.service.g localg;
            String str;
            if ((!com.tencent.mm.contact.c.lO(paramAnonymousString2.field_type)) && (i == 15))
            {
              paramAnonymousString1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paramAnonymousString2.field_username);
              if ((paramAnonymousString1 != null) && (!bu.isNullOrNil(paramAnonymousString2.eRu)))
              {
                localg = com.tencent.mm.plugin.report.service.g.yxI;
                str = paramAnonymousString2.field_username;
                if (!bu.isNullOrNil(paramAnonymousString1.Lj())) {
                  break label308;
                }
              }
            }
            label308:
            for (i = 0;; i = 1)
            {
              localg.f(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.contact.a.f(paramAnonymousString2)) });
              x.B(paramAnonymousString2);
              locala.mEx.notifyDataSetChanged();
              au.aE(paramAnonymousString2.field_encryptUsername, 0);
              paramAnonymousString1 = new qk();
              paramAnonymousString1.dGj.username = paramAnonymousString2.field_encryptUsername;
              paramAnonymousString1.dGj.type = 1;
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString1);
              AppMethodBeat.o(186498);
              return;
            }
          }
          if (paramAnonymousBoolean2)
          {
            com.tencent.mm.bj.d.aMM().gw(paramAnonymousString1, 2);
            au.aE(paramString.field_encryptUsername, 1);
            paramAnonymousString1 = new qk();
            paramAnonymousString1.dGj.username = paramString.field_encryptUsername;
            paramAnonymousString1.dGj.type = 1;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousString1);
            AppMethodBeat.o(186498);
            return;
          }
          ae.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
          AppMethodBeat.o(186498);
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).lB((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).Fni = new a.b()
      {
        public final boolean aA(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(186499);
          String str = this.cXn.getIntent().getStringExtra("room_name");
          int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
          SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
          Object localObject;
          if ((!an.aUq(paramString.field_username)) && (i == 1))
          {
            localObject = SayHiWithSnsPermissionUI2.class;
            localObject = new Intent(this.cXn, (Class)localObject);
            ((Intent)localObject).putExtra("Contact_User", paramString.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramString.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramString.field_conRemark);
            if ((i != 14) && (i != 8)) {
              break label374;
            }
            ((Intent)localObject).putExtra("Contact_RoomNickname", this.cXn.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("Contact_Scene", i);
            ((Intent)localObject).putExtra("room_name", str);
            ((Intent)localObject).putExtra("source_from_user_name", this.xeZ);
            ((Intent)localObject).putExtra("source_from_nick_name", str);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
            ((Intent)localObject).putExtra(e.c.JoX, paramAnonymousString);
            ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
            ((Intent)localObject).putExtra("key_msg_id", l);
            paramAnonymousString = this.cXn;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(186499);
            return true;
            localObject = localSayHiWithSnsPermissionUI;
            if (an.aUq(paramString.field_username)) {
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
              ((Intent)localObject).putExtra("key_msg_id", this.cXn.getIntent().getLongExtra("key_msg_id", 0L));
            }
          }
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.c.JoX);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aOa((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, "", (LinkedList)localObject3);
      }
      for (;;)
      {
        if (!com.tencent.mm.plugin.messenger.e.a.yy(l)) {
          break label2266;
        }
        com.tencent.mm.plugin.messenger.e.a.R(l, 3);
        break;
        if (TextUtils.isEmpty(str))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aOa(paramString.eRv);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).h(paramString.field_username, (LinkedList)localObject3);
        }
        else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).tIA))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
        }
        else
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azF().BH(paramString.field_username);
          if (localObject1 != null) {}
          for (localObject1 = bu.bI(((aw)localObject1).eRv, "");; localObject1 = "")
          {
            ae.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2222;
            }
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aOa((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
            break;
          }
          this.xeM.add(paramString.field_username);
          au.a.hIG.a(paramString.field_username, str, new au.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(186487);
              bc.aCg();
              paramAnonymousString = com.tencent.mm.model.c.azF().BH(paramString.field_username);
              if (paramAnonymousString != null) {}
              for (paramAnonymousString = bu.bI(paramAnonymousString.eRv, "");; paramAnonymousString = "")
              {
                this.xeR.aOa(paramAnonymousString);
                this.xeR.d(paramString.field_username, str, this.xeT);
                AppMethodBeat.o(186487);
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
        localObject2 = this.oDq;
        localObject3 = this.pSY;
        ((MMActivity)localObject2).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOK, 0);
        localObject1 = SayHiWithSnsPermissionUI.class;
        if ((!an.aUq(((aw)localObject3).field_username)) && (i == 1)) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject2, paramString);
          paramString.putExtra("Contact_User", ((aw)localObject3).field_username);
          paramString.putExtra("room_name", this.fRo);
          paramString.putExtra("Contact_Nick", ((aw)localObject3).field_nickname);
          paramString.putExtra("Contact_RemarkName", ((aw)localObject3).field_conRemark);
          if ((this.mScene == 14) || (this.mScene == 8)) {
            paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject2).getIntent().getStringExtra("Contact_RoomNickname"));
          }
          paramString.putExtra("Contact_Scene", this.mScene);
          paramString.putExtra("Verify_ticket", bu.nullAsNil(((Activity)localObject2).getIntent().getStringExtra("Verify_ticket")));
          paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
          paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
          paramString.putExtra("sayhi_with_sns_perm_set_label", true);
          paramString.putExtra("sayhi_with_sns_permission", ((an)localObject3).ady());
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramString.ahE(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramString = (String)localObject1;
          if (!an.aUq(((aw)localObject3).field_username))
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
        paramString = this.pSY;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.c.JoX, paramString.eRv);
        b.iUz.a((Intent)localObject1, this.oDq);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.xeK == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.oDq, this.pSY);
        com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(c.aH(this.oDq.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.pSY.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.mEx.aXe("contact_info_invite_source")).getExtras().getString("inviter");
        if (bu.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.fNS, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fRo);
        bc.aCg();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.azF().BH(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fRo);
        b.iUz.c((Intent)localObject2, this.oDq);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.pSY;
        localObject3 = bu.nullAsNil(this.oDq.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = com.tencent.mm.plugin.profile.ui.p.a(this.oDq, (an)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].hGg;
          paramString = com.tencent.mm.plugin.profile.ui.p.b(this.oDq, (an)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((aw)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.ajQ().gDv.hRo, new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
          {
            AppMethodBeat.i(186495);
            paramAnonymousn.setHasCallbackToQueue(true);
            paramAnonymousString = (com.tencent.mm.plugin.profile.b.a)paramAnonymousn;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              if (paramAnonymousString.xfo == null) {
                paramAnonymousString.xfo = ((bfx)paramAnonymousString.rr.hQE.hQJ);
              }
              String str = paramAnonymousString.xfo.GUG;
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
                  ae.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramAnonymousn.getMessage() });
                }
              }
              paramAnonymousString = new Intent("android.intent.action.VIEW", paramAnonymousString);
              a.this.oDq.startActivityForResult(paramAnonymousString, 111);
              ae.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
              AppMethodBeat.o(186495);
              return;
            }
            ae.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (paramAnonymousString.xfo == null) {
              paramAnonymousString.xfo = ((bfx)paramAnonymousString.rr.hQE.hQJ);
            }
            if ((paramAnonymousString.xfo.BaseResponse != null) && (paramAnonymousString.xfo.BaseResponse.ErrMsg != null)) {}
            for (paramAnonymousString = bu.nullAsNil(paramAnonymousString.xfo.BaseResponse.ErrMsg.HId);; paramAnonymousString = paramAnonymousString.errMsg)
            {
              paramAnonymousn = paramAnonymousString;
              if (bu.isNullOrNil(paramAnonymousString)) {
                paramAnonymousn = a.this.oDq.getString(2131761817);
              }
              h.c(a.this.oDq, paramAnonymousn, a.this.oDq.getString(2131764439), false);
              AppMethodBeat.o(186495);
              return;
            }
          }
        });
        break;
      }
      if (!paramString.equals("contact_profile_story")) {
        break;
      }
      paramString = (AbsStoryPreference)this.mEx.aXe("contact_profile_story");
      if (paramString == null) {
        break;
      }
      paramString.eky();
      break;
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean ceC()
  {
    AppMethodBeat.i(26839);
    this.mEx.aXe("contact_profile_sns");
    if (o.zsA != null) {
      o.zsA.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.mEx.aXe("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.mEx.aXe("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.xeP.dead();
    if (this.xeK != null) {
      this.xeK.destroy();
    }
    localObject = this.xeM.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      au.a.hIG.Bt(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void eU(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.mEx.cT("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    ae.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.mEx.cT("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.mEx, this.pSY, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */