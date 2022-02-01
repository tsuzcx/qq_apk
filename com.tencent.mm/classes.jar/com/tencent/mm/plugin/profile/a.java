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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.bd.a;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zi.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FinderPreference;
import com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aso;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.protocal.protobuf.eoz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements i.a, com.tencent.mm.plugin.story.api.d, com.tencent.mm.pluginsdk.b.a
{
  com.tencent.mm.plugin.profile.a.b Bcm;
  private boolean Bcn;
  final List<String> Bco;
  private com.tencent.mm.ui.widget.a.e Bcp;
  String Bcq;
  IListener<bd> Bcr;
  private boolean Bcs;
  ah gtd;
  String gwx;
  private long lastUpdateTime;
  private int mScene;
  com.tencent.mm.ui.base.preference.f nRm;
  MMActivity pQZ;
  private boolean readOnly;
  as rjX;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.Bco = new LinkedList();
    this.Bcq = null;
    this.Bcr = new IListener() {};
    this.Bcs = false;
    this.lastUpdateTime = 0L;
    this.pQZ = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    Log.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.bmg("contact_info_invite_source");
    paramf.jdMethod_do("contact_info_invite_source", false);
    paramf = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.c(paramActivity, paramActivity.getResources().getString(2131757923, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131100063)), 0, paramString2.length(), 33);
    localKeyValuePreference.alL(2);
    localKeyValuePreference.OYB = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (eDJ())
    {
      paramf.jdMethod_do("contact_profile_setting_desc", true);
      paramf.jdMethod_do("contact_profile_setting_permission", true);
      paramf.jdMethod_do("contact_profile_phone", true);
      paramf.jdMethod_do("contact_profile_info_more", true);
      paramf.jdMethod_do("contact_profile_sns", as.bjp(paramas.field_username));
      if ((z.aUd() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.s(this.pQZ, "com.tencent.wework");
        bg.aVF();
        Object localObject = (Integer)com.tencent.mm.model.c.azQ().get(ar.a.NTm, Integer.valueOf(0));
        Log.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(z.aUd()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!Util.isEqual(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.s(this.pQZ, "com.tencent.wework")))) {
          break label325;
        }
        paramf.jdMethod_do("contact_profile_accept_contact_by_wework", false);
        localObject = com.tencent.mm.plugin.profile.ui.q.a(this.pQZ, paramas, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label434;
        }
      }
    }
    label434:
    for (paramas = com.tencent.mm.plugin.profile.ui.q.b(this.pQZ, paramas, this.mScene);; paramas = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.aKm(this.rjX.field_username)) {
        ((ButtonPreference)paramf.bmg("contact_profile_accept_contact_by_wework")).gX(this.pQZ.getString(2131757920), this.pQZ.getResources().getColor(2131100063));
      }
      if ((!Util.isNullOrNil(paramas)) && (com.tencent.mm.plugin.profile.b.e.aKl(paramas) == 2) && (paramBoolean)) {
        paramf.jdMethod_do("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label325:
      if (this.pQZ.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramas = (ButtonPreference)paramf.bmg("contact_profile_accept_contact");
        paramas.gX(this.pQZ.getString(2131755233), this.pQZ.getResources().getColor(2131100283));
        paramas.setEnabled(false);
      }
      paramf.jdMethod_do("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.jdMethod_do("contact_profile_accept_contact", true);
      paramf.jdMethod_do("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(String paramString, as paramas)
  {
    AppMethodBeat.i(26849);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(26849);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramas.field_username);
    paramString.putExtra("Contact_Nick", paramas.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramas.field_conRemark);
    b.jRt.m(paramString, this.pQZ);
    AppMethodBeat.o(26849);
  }
  
  static String b(ah paramah, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramah == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    Object localObject1 = localObject2;
    if (localas != null)
    {
      localObject1 = localObject2;
      if ((int)localas.gMZ > 0) {
        localObject1 = localas.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = paramah.getDisplayName(paramString);
    }
    paramah = (ah)localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      paramah = (ah)localObject2;
      if (localas != null) {
        paramah = localas.arI();
      }
    }
    AppMethodBeat.o(26854);
    return paramah;
  }
  
  static void b(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(231797);
    if ((paramObject instanceof eoy))
    {
      paramObject = (eoy)paramObject;
      if (paramObject.LNI == 1)
      {
        paramf.jdMethod_do("contact_profile_finder_recent_like", false);
        FinderRecentLikePreference localFinderRecentLikePreference = (FinderRecentLikePreference)paramf.bmg("contact_profile_finder_recent_like");
        if (!paramf.bmh(FinderPreference.NAME))
        {
          paramf = localObject;
          if (paramObject.LNJ != null)
          {
            paramf = localObject;
            if (!Util.isNullOrNil(paramObject.LNJ.LDv))
            {
              paramf = new eoz();
              paramf.LCW.addAll(paramObject.LNJ.LDv);
            }
          }
          localFinderRecentLikePreference.a(paramf);
          AppMethodBeat.o(231797);
          return;
        }
        localFinderRecentLikePreference.a(null);
        AppMethodBeat.o(231797);
        return;
      }
    }
    paramf.jdMethod_do("contact_profile_finder_recent_like", true);
    AppMethodBeat.o(231797);
  }
  
  private boolean eDF()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = ab.iCO;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.rjX.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = eDG();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean eDG()
  {
    AppMethodBeat.i(26843);
    boolean bool = ab.Jv(this.rjX.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean eDH()
  {
    AppMethodBeat.i(231795);
    boolean bool = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avl(this.rjX.field_username);
    AppMethodBeat.o(231795);
    return bool;
  }
  
  private boolean eDI()
  {
    AppMethodBeat.i(26844);
    boolean bool = as.IG(this.rjX.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean eDJ()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (this.pQZ.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean eDK()
  {
    AppMethodBeat.i(26846);
    if (this.pQZ.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean eDL()
  {
    AppMethodBeat.i(26847);
    if (this.pQZ.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean eDM()
  {
    AppMethodBeat.i(26848);
    int i = this.pQZ.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean eDN()
  {
    return this.rjX.field_deleteFlag == 1;
  }
  
  final void a(as paramas, Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.Bcp = new com.tencent.mm.ui.widget.a.e(this.pQZ, 1, false);
    this.Bcp.HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(231791);
        paramAnonymousm.aS(2, 2131755840, 2131691478);
        paramAnonymousm.aS(1, 2131755842, 2131691479);
        AppMethodBeat.o(231791);
      }
    };
    this.Bcp.HLY = new a.15(this, paramas, paramContext);
    this.Bcp.dGm();
    AppMethodBeat.o(26850);
  }
  
  final void a(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    AppMethodBeat.i(231796);
    if ((paramObject instanceof eoy))
    {
      paramObject = (eoy)paramObject;
      FinderPreference localFinderPreference = (FinderPreference)paramf.bmg(FinderPreference.NAME);
      if (paramObject.contact == null)
      {
        paramf.jdMethod_do(FinderPreference.NAME, true);
        AppMethodBeat.o(231796);
        return;
      }
      if (!this.Bcs) {
        com.tencent.mm.plugin.report.service.h.CyF.a(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      }
      paramf.jdMethod_do(FinderPreference.NAME, false);
      localFinderPreference.a(paramObject);
      this.Bcs = true;
      AppMethodBeat.o(231796);
      return;
    }
    paramf.jdMethod_do(FinderPreference.NAME, true);
    AppMethodBeat.o(231796);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.nRm.bmg("contact_profile_sns");
    if ((paramString != null) && (o.DCN != null))
    {
      paramString.bfe(this.rjX.field_username);
      com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePP = paramString.grS();
      if (o.DCR != null) {
        o.DCR.a(this, 3);
      }
      this.nRm.notifyDataSetChanged();
      if (paramb.eZe())
      {
        Log.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (o.DCR != null) {
          o.DCR.aNX(this.rjX.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.nRm = paramf;
    this.rjX = paramas;
    this.mScene = paramInt;
    this.gwx = this.pQZ.getIntent().getStringExtra("room_name");
    bg.aVF();
    this.gtd = com.tencent.mm.model.c.aSX().Kd(this.gwx);
    this.Bcn = this.pQZ.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.Bcm == null)
    {
      this.Bcm = new com.tencent.mm.plugin.profile.a.b(this.pQZ, paramas);
      this.Bcm.eeh();
    }
    Log.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramas.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2132017240);
    Object localObject3 = (NormalProfileHeaderPreference)paramf.bmg("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject3).nRm = paramf;
    ((NormalProfileHeaderPreference)localObject3).a(paramas, paramInt, paramBoolean, this.Bcm);
    Object localObject1 = (ButtonPreference)paramf.bmg("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).OXn = 2131299140;
    }
    Object localObject2 = (ButtonPreference)paramf.bmg("contact_profile_add_contact");
    Object localObject5 = this.pQZ;
    Object localObject4 = this.rjX;
    int j;
    if ((as.bjp(((ax)localObject4).field_username)) && (((ax)localObject4).fva != 0))
    {
      i = paramf.indexOf("contact_info_category_1");
      Object localObject6 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(((ax)localObject4).field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.a.a.jGS);
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = new PreferenceTitleCategory((Context)localObject5);
        ((Preference)localObject7).setTitle((CharSequence)localObject6);
        paramf.a((Preference)localObject7, i);
        ((Preference)localObject7).OZp = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject6 = new com.tencent.mm.openim.a.b();
      ((com.tencent.mm.openim.a.b)localObject6).Sa(((ax)localObject4).fvb);
      localObject6 = ((com.tencent.mm.openim.a.b)localObject6).jGV.iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (com.tencent.mm.openim.a.b.a)((Iterator)localObject6).next();
        Iterator localIterator = ((com.tencent.mm.openim.a.b.a)localObject7).jGW.iterator();
        while (localIterator.hasNext())
        {
          b.b localb = (b.b)localIterator.next();
          j = i + 1;
          com.tencent.mm.plugin.profile.a.a.2 local2 = new com.tencent.mm.plugin.profile.a.a.2((Context)localObject5, localb);
          local2.OFU = ((com.tencent.mm.openim.a.b.a)localObject7).title;
          local2.alL(2);
          local2.OYB = false;
          local2.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, localb.Sb(((ax)localObject4).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.alO(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.OZp = new com.tencent.mm.plugin.profile.a.a.3(localb, (as)localObject4, (com.tencent.mm.openim.a.b.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.OZp = new com.tencent.mm.plugin.profile.a.a.4(localb, (as)localObject4, (com.tencent.mm.openim.a.b.a)localObject7, (Context)localObject5);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.OZp = new com.tencent.mm.plugin.profile.a.a.5(localb, (as)localObject4, (com.tencent.mm.openim.a.b.a)localObject7);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.OZp = new com.tencent.mm.plugin.profile.a.a.6(localb, (as)localObject4, (com.tencent.mm.openim.a.b.a)localObject7);
              i = j;
            }
          }
        }
      }
      i += 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject5), i);
      localObject6 = new KeyValuePreference((Context)localObject5);
      ((KeyValuePreference)localObject6).setTitle(2131757876);
      Object localObject7 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(((ax)localObject4).field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.a.a.jGS);
      ((KeyValuePreference)localObject6).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject5, (CharSequence)localObject7));
      localObject5 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(((ax)localObject4).field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.a.a.jGT);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((Preference)localObject6).OZp = new com.tencent.mm.plugin.profile.a.a.7((String)localObject5, (as)localObject4, (String)localObject7);
      }
      paramf.a((Preference)localObject6, i + 1);
    }
    if (eDG())
    {
      paramf.removeAll();
      paramf.c((Preference)localObject3);
      paramf.c(new PreferenceSmallCategory(this.pQZ));
      paramas = new KeyValuePreference(this.pQZ);
      paramas.setTitle(2131757925);
      paramas.setSummary(2131758156);
      paramas.alL(2147483647);
      paramas.OYB = false;
      paramas.alO(8);
      paramf.c(paramas);
      paramf.c(new PreferenceSmallCategory(this.pQZ));
      if (com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
        paramf.c((Preference)localObject1);
      }
      for (;;)
      {
        this.Bcm.qdG.removeAllOptionMenu();
        AppMethodBeat.o(26837);
        return true;
        paramf.c((Preference)localObject2);
      }
    }
    localObject3 = this.rjX;
    int i = this.pQZ.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.pQZ.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = Util.nullAs(this.pQZ.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new ebj();
    ((ebj)localObject2).kej = i;
    ((ebj)localObject2).kel = l;
    ((ebj)localObject2).kek = ((String)localObject1);
    localObject1 = localObject2;
    if (o.DCN != null) {
      localObject1 = o.DCN.b(((ax)localObject3).field_username, (ebj)localObject2);
    }
    bg.aVF();
    final boolean bool1 = com.tencent.mm.model.c.aSN().bjG(((ax)localObject3).field_username);
    boolean bool2 = z.aTY().equals(((ax)localObject3).field_username);
    if ((((ebj)localObject1).kej & 0x1) > 0)
    {
      paramBoolean = true;
      Log.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((as.bjn(((ax)localObject3).field_username)) || (!paramBoolean)) && (!eDJ()) && (!bool2)) {
        break label3515;
      }
      this.nRm.jdMethod_do("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.nRm.bmg("contact_profile_sns");
      if (o.DCR != null)
      {
        o.DCR.a(3, ((ax)localObject3).field_username, this);
        i = this.pQZ.getIntent().getIntExtra("Sns_from_Scene", 0);
        o.DCR.a(2, ((ax)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).bfe(((ax)localObject3).field_username);
      label1305:
      if (as.bjp(((ax)localObject3).field_username)) {
        this.nRm.jdMethod_do("contact_profile_sns", true);
      }
      localObject2 = paramf.bmg("contact_profile_setting_desc");
      if (!as.bjp(this.rjX.field_username)) {
        break label3531;
      }
      localObject1 = this.pQZ.getText(2131758167).toString();
      label1369:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.bmg("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.pQZ.getString(2131763884);
      if (!this.rjX.arD()) {
        break label3551;
      }
      ((MultiSummaryPreference)localObject1).Bgt = new String[] { this.pQZ.getString(2131764059) };
      localObject1 = (KeyValuePreference)paramf.bmg("contact_profile_source");
      paramInt = this.pQZ.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.pQZ, this.rjX, paramInt, this.rjX.field_username, eDJ());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).alL(2);
      ((KeyValuePreference)localObject1).OYB = false;
      ((KeyValuePreference)localObject1).gPN = (com.tencent.mm.cb.a.E(this.pQZ, (int)this.pQZ.getResources().getDimension(2131165535)) * com.tencent.mm.cb.a.ez(this.pQZ));
      ((KeyValuePreference)localObject1).alO(8);
      if ((!com.tencent.mm.contact.c.oR(paramas.field_type)) && (!Util.isNullOrNil((CharSequence)localObject2)) && ((!eDK()) || (eDJ()))) {
        break label3814;
      }
      paramBoolean = true;
      label1588:
      paramf.jdMethod_do("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.bmg("contact_profile_label");
      ((LabelPreference)localObject1).rjX = paramas;
      if (!com.tencent.mm.contact.c.oR(((LabelPreference)localObject1).rjX.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).rjX.field_encryptUsername;
        if (!Util.isNullOrNil((String)localObject2))
        {
          bg.aVF();
          ((LabelPreference)localObject1).BzG = com.tencent.mm.model.c.aSO().aEZ((String)localObject2);
        }
        if ((((LabelPreference)localObject1).BzG != null) && (((LabelPreference)localObject1).BzG.systemRowid < 0L))
        {
          bg.aVF();
          ((LabelPreference)localObject1).BzG = com.tencent.mm.model.c.aSO().aEZ(((LabelPreference)localObject1).rjX.field_username);
        }
      }
      if ((!com.tencent.mm.contact.c.oR(((LabelPreference)localObject1).rjX.field_type)) || (Util.isNullOrNil(((LabelPreference)localObject1).rjX.field_contactLabelIds))) {
        break label3819;
      }
      paramInt = 1;
      label1747:
      if (paramInt != 0) {
        break label3853;
      }
      paramBoolean = true;
      label1754:
      paramf.jdMethod_do("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.bmg("contact_profile_phone");
      ((PhoneNumPreference)localObject3).nRm = paramf;
      localObject4 = this.pQZ.getIntent();
      ((PhoneNumPreference)localObject3).rjX = paramas;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      Log.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramas.arF() });
      if (!paramas.arF())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject4))) {
          break label3866;
        }
        if (!Util.isNullOrNil(paramas.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramas.field_username);
          localObject4 = paramas.field_username;
          if (localObject2 != null) {
            break label3858;
          }
          localObject1 = "true";
          label1923:
          Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1950:
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())))
        {
          ((PhoneNumPreference)localObject3).KcI = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnP()).replace(" ", "");
          Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramas.field_username, ((PhoneNumPreference)localObject3).KcI });
        }
        ((PhoneNumPreference)localObject3).grR();
      }
      ((PhoneNumPreference)localObject3).KcJ = PhoneNumPreference.b(((PhoneNumPreference)localObject3).KcI, paramas);
      ((PhoneNumPreference)localObject3).nRm.jdMethod_do("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).grR();
      ((PhoneNumPreference)localObject3).alO(8);
      localObject1 = (ProfileDescribePreference)paramf.bmg("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).rjX = paramas;
      if (!com.tencent.mm.contact.c.oR(((ProfileDescribePreference)localObject1).rjX.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).rjX.field_encryptUsername;
        if (!Util.isNullOrNil((String)localObject2))
        {
          bg.aVF();
          ((ProfileDescribePreference)localObject1).BzG = com.tencent.mm.model.c.aSO().aEZ((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).BzG != null) && (((ProfileDescribePreference)localObject1).BzG.systemRowid < 0L))
        {
          bg.aVF();
          ((ProfileDescribePreference)localObject1).BzG = com.tencent.mm.model.c.aSO().aEZ(((ProfileDescribePreference)localObject1).rjX.field_username);
        }
      }
      if (com.tencent.mm.contact.c.oR(((ProfileDescribePreference)localObject1).rjX.field_type)) {
        break label4008;
      }
      if ((((ProfileDescribePreference)localObject1).BzG == null) || (Util.isNullOrNil(((ProfileDescribePreference)localObject1).BzG.field_conDescription))) {
        break label4002;
      }
      paramInt = 1;
      label2217:
      if (paramInt != 0) {
        break label4062;
      }
      paramBoolean = true;
      label2224:
      paramf.jdMethod_do("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.contact.c.oR(paramas.field_type)) || (Util.isNullOrNil(paramas.signature))) {
        break label4067;
      }
      localObject1 = (KeyValuePreference)paramf.bmg("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).gPN = (com.tencent.mm.cb.a.E(this.pQZ, (int)this.pQZ.getResources().getDimension(2131165535)) * com.tencent.mm.cb.a.ez(this.pQZ));
        ((KeyValuePreference)localObject1).OYB = false;
        ((KeyValuePreference)localObject1).setTitle(this.pQZ.getString(2131758062));
        ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.pQZ, paramas.signature));
        ((KeyValuePreference)localObject1).BC(false);
        ((KeyValuePreference)localObject1).alL(5);
        ((KeyValuePreference)localObject1).alO(8);
      }
      label2365:
      if ((paramf.bmj("contact_profile_desc") >= 0) || (paramf.bmj("contact_profile_label") >= 0)) {
        break label4080;
      }
      paramf.jdMethod_do("contact_profile_setting_desc", false);
      label2399:
      if (!com.tencent.mm.contact.c.oR(paramas.field_type)) {
        paramf.jdMethod_do("contact_profile_setting_desc", false);
      }
      paramf.jdMethod_do("contact_profile_set_des_category", true);
      if ((!as.bjp(this.rjX.field_username)) || (!Util.isNullOrNil(this.rjX.field_conRemark))) {
        break label4093;
      }
      paramf.jdMethod_do("contact_profile_setting_desc", false);
      paramf.jdMethod_do("contact_profile_set_des_category", true);
      label2477:
      paramf.bmg("contact_profile_info_more").setTitle(this.pQZ.getText(2131757972).toString());
      ((TextPreference)paramf.bmg("contact_profile_hint")).ar(this.pQZ.getText(2131757977));
      if (!paramas.ary()) {
        break label4137;
      }
      paramf.jdMethod_do("contact_profile_hint", false);
      label2546:
      localObject2 = (MultiButtonPreference)paramf.bmg("contact_profile_multi_button");
      if (!eDH()) {
        break label4151;
      }
      ((MultiButtonPreference)localObject2).a(this.pQZ.getString(2131757906), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26820);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26820);
        }
      });
      label2590:
      if ((eDF()) || ((com.tencent.mm.contact.c.oR(paramas.field_type)) && (!paramas.ary())) || ((!eDJ()) && (eDK()))) {
        paramf.jdMethod_do("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!eDJ()) && (!eDN()) && (!eDI())) {
        break label4341;
      }
      paramf.jdMethod_do("contact_profile_send", true);
      paramf.jdMethod_do("contact_profile_voip", true);
      label2695:
      if ((!com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!eDJ()) && (!eDN()) && (!eDM()) && (!eDL()) && (!z.aTY().equals(this.rjX.field_username))) {
        break label4372;
      }
      paramf.jdMethod_do("contact_profile_add_contact", true);
      label2763:
      a(paramf, paramas, false);
      if ((eDJ()) || (com.tencent.mm.contact.c.oR(paramas.field_type)) || ((!eDI()) && (!eDM()) && (!eDL()))) {
        break label4426;
      }
      paramf.jdMethod_do("contact_profile_info_more", true);
      paramf.jdMethod_do("contact_profile_say_hi", false);
      label2829:
      if (z.Im(this.rjX.field_username))
      {
        paramf.jdMethod_do("contact_profile_multi_button", true);
        paramf.jdMethod_do("contact_profile_info_more", Util.isNullOrNil(paramas.signature));
        paramf.jdMethod_do("contact_profile_setting_desc", true);
        paramf.jdMethod_do("contact_profile_setting_permission", true);
        paramf.jdMethod_do("contact_profile_voip", true);
        this.Bcm.qdG.removeAllOptionMenu();
      }
      localObject1 = this.rjX;
      paramf.jdMethod_do("contact_info_invite_source", true);
      if (this.gtd != null) {
        break label4473;
      }
      paramBoolean = this.pQZ.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label2948:
      if ((this.mScene == 14) && (paramBoolean) && (this.gtd != null) && (!((ax)localObject1).field_username.equals(this.gtd.field_roomowner))) {
        break label4490;
      }
      paramInt = this.mScene;
      if (this.gtd != null) {
        break label4484;
      }
      bool1 = true;
      label3002:
      Log.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.jdMethod_do("contact_info_invite_source", true);
      label3047:
      this.nRm.jdMethod_do("contact_profile_story", true);
      bg.aVF();
      paramBoolean = com.tencent.mm.model.c.aSN().bjG(paramas.field_username);
      bool1 = z.aTY().equals(paramas.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().fnd())
      {
        Log.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!as.bjn(paramas.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.nRm.bmg("contact_profile_story");
          paramf.onCreate(paramas.field_username);
          paramf.a(this);
          paramf.fmY();
          paramf.fmX();
        }
      }
      paramf = this.nRm;
      if (!eDH()) {
        break label4744;
      }
      paramf.jdMethod_do("contact_profile_add_contact", true);
      paramf.jdMethod_do("contact_profile_accept_contact_by_wework", true);
      paramf.jdMethod_do("contact_profile_setting_desc", true);
      paramf.jdMethod_do("contact_profile_send", true);
      paramf.jdMethod_do("contact_profile_voip", true);
      paramf.jdMethod_do("contact_profile_say_hi", true);
      paramf.jdMethod_do("contact_profile_info_more", true);
      paramf.jdMethod_do("contact_profile_setting_permission", true);
      paramf.jdMethod_do("contact_profile_voip", true);
      paramf.jdMethod_do("contact_profile_multi_button", false);
      paramf.jdMethod_do("contact_profile_set_des_category", true);
      paramf.jdMethod_do("contact_info_category_1", true);
      paramf.jdMethod_do("line1", false);
      paramf.jdMethod_do("line2", false);
      paramf.jdMethod_do("line3", false);
      paramf.jdMethod_do("line4", false);
      this.Bcm.qdG.removeAllOptionMenu();
      label3390:
      paramf = this.nRm;
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderWxNameCardFinderAndRecentLikeFinderClose", 0) != 1) {
        break label4758;
      }
      paramBoolean = true;
      label3422:
      bool1 = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderSwitchApi().dCu();
      Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, dontRequestCgi:" + paramBoolean + ", switchC:" + bool1);
      if (!paramBoolean) {
        break label4763;
      }
      paramf.jdMethod_do(FinderPreference.NAME, true);
      paramf.jdMethod_do("contact_profile_finder_recent_like", true);
    }
    for (;;)
    {
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3515:
      this.nRm.jdMethod_do("contact_profile_sns", true);
      break label1305;
      label3531:
      localObject1 = this.pQZ.getText(2131758166).toString();
      break label1369;
      label3551:
      paramBoolean = paramas.arB();
      bool1 = o.DCP.aKt(paramas.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3716;
        }
        localObject3 = this.pQZ;
        if (paramas.fuA == 2)
        {
          i = 2131764053;
          label3627:
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        }
      }
      else if (bool1)
      {
        if (j != 0) {
          break label3769;
        }
        localObject3 = this.pQZ;
        if (paramas.fuA != 2) {
          break label3761;
        }
      }
      label3716:
      label3761:
      for (i = 2131764048;; i = 2131764050)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).Bgt = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = 2131764055;
        break label3627;
        localObject3 = this.pQZ;
        if (paramas.fuA == 2) {}
        for (i = 2131764054;; i = 2131764056)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3769:
      localObject3 = this.pQZ;
      if (paramas.fuA == 2) {}
      for (i = 2131764049;; i = 2131764051)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3814:
      paramBoolean = false;
      break label1588;
      label3819:
      if ((((LabelPreference)localObject1).BzG != null) && (!Util.isNullOrNil(((LabelPreference)localObject1).BzG.field_contactLabels)))
      {
        paramInt = 1;
        break label1747;
      }
      paramInt = 0;
      break label1747;
      label3853:
      paramBoolean = false;
      break label1754;
      label3858:
      localObject1 = "false";
      break label1923;
      label3866:
      if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil((String)localObject4))) {
        break label1950;
      }
      Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramas.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).getMd5())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject4);
      }
      localObject4 = paramas.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label4002:
      paramInt = 0;
      break label2217;
      label4008:
      if (!Util.isNullOrNil(((ProfileDescribePreference)localObject1).rjX.fuS)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((Util.isNullOrNil(((ProfileDescribePreference)localObject1).rjX.fuR)) && (paramInt == 0)) {
          break label4056;
        }
        paramInt = 1;
        break;
      }
      label4056:
      paramInt = 0;
      break label2217;
      label4062:
      paramBoolean = false;
      break label2224;
      label4067:
      paramf.bmi("contact_info_signature");
      break label2365;
      label4080:
      paramf.jdMethod_do("contact_profile_setting_desc", true);
      break label2399;
      label4093:
      if ((!as.bjp(this.rjX.field_username)) && (!eDH())) {
        break label2477;
      }
      paramf.jdMethod_do("contact_profile_setting_desc", true);
      paramf.jdMethod_do("contact_profile_set_des_category", true);
      break label2477;
      label4137:
      paramf.jdMethod_do("contact_profile_hint", true);
      break label2546;
      label4151:
      if (!eDJ())
      {
        if ((!com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) == 2))
        {
          paramInt = 1;
          label4192:
          if (paramInt == 0) {
            break label4294;
          }
        }
      }
      else {
        if (!this.rjX.ary()) {
          break label4279;
        }
      }
      label4279:
      for (localObject1 = this.pQZ.getString(2131757978);; localObject1 = this.pQZ.getString(2131757973))
      {
        ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            a.this.Bcm.sE(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26828);
          }
        });
        localObject1 = this.pQZ.getString(2131756736);
        localObject3 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26829);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            a.this.Bcm.eDX();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26829);
          }
        };
        ((MultiButtonPreference)localObject2).Bgo = ((String)localObject1);
        ((MultiButtonPreference)localObject2).Bgr = ((View.OnClickListener)localObject3);
        break;
        paramInt = 0;
        break label4192;
      }
      label4294:
      if ((!paramas.ary()) && (!eDM()) && (!eDL())) {
        break label2590;
      }
      ((MultiButtonPreference)localObject2).a(this.pQZ.getString(2131756736), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(231789);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          a.this.Bcm.eDX();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231789);
        }
      });
      break label2590;
      label4341:
      paramf.jdMethod_do("contact_profile_send", false);
      paramf.jdMethod_do("contact_profile_voip", this.rjX.ary());
      break label2695;
      label4372:
      paramf.jdMethod_do("contact_profile_add_contact", false);
      paramf.jdMethod_do("contact_profile_setting_desc", false);
      paramf.jdMethod_do("contact_profile_setting_permission", true);
      paramf.jdMethod_do("contact_profile_phone", true);
      paramf.jdMethod_do("contact_profile_info_more", true);
      break label2763;
      label4426:
      paramf.jdMethod_do("contact_profile_say_hi", true);
      if (!com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        paramf.jdMethod_do("contact_profile_info_more", true);
        break label2829;
      }
      paramf.jdMethod_do("contact_profile_info_more", false);
      break label2829;
      label4473:
      paramBoolean = this.gtd.amD();
      break label2948;
      label4484:
      bool1 = false;
      break label3002;
      label4490:
      this.Bcq = this.pQZ.getIntent().getStringExtra("inviteer");
      if (Util.isNullOrNil(this.Bcq)) {
        this.Bcq = this.gtd.bjg(((ax)localObject1).field_username);
      }
      if (Util.isNullOrNil(this.Bcq)) {
        this.Bcq = v.aF(((ax)localObject1).field_username, this.gwx);
      }
      if (Util.isNullOrNil(this.Bcq))
      {
        Log.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.gwx, ((ax)localObject1).field_username });
        this.Bcr.alive();
        this.Bco.add(((ax)localObject1).field_username);
        ay.a.iDq.a(((ax)localObject1).field_username, this.gwx, new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(26824);
            Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.gwx, Boolean.valueOf(paramAnonymousBoolean) });
            a.this.Bcr.dead();
            AppMethodBeat.o(26824);
          }
        });
        break label3047;
      }
      this.pQZ.getIntent().putExtra("inviteer", this.Bcq);
      localObject2 = b(this.gtd, this.Bcq);
      if (Util.isNullOrNil((String)localObject2))
      {
        this.Bco.add(((ax)localObject1).field_username);
        ay.a.iDq.a(((ax)localObject1).field_username, "", new ay.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(231782);
            Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.gwx, Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              bg.aVF();
              paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(paramAnonymousString).arI();
              a.a(paramf, a.this.pQZ, a.this.Bcq, paramAnonymousString);
            }
            AppMethodBeat.o(231782);
          }
        });
        break label3047;
      }
      a(paramf, this.pQZ, this.Bcq, (String)localObject2);
      break label3047;
      label4744:
      paramf.jdMethod_do("line4", true);
      break label3390;
      label4758:
      paramBoolean = false;
      break label3422;
      label4763:
      l = cl.aWy();
      if (l - this.lastUpdateTime >= 1000L) {
        break label4821;
      }
      Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, lastUpdateTime:" + this.lastUpdateTime + ", curTime:" + l);
    }
    label4821:
    this.lastUpdateTime = l;
    paramas = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().a(paramas.field_username, this.pQZ, new af.a()new af.a
    {
      public final void bn(Object paramAnonymousObject)
      {
        AppMethodBeat.i(231787);
        if (bool1) {
          a.this.a(paramf, paramAnonymousObject);
        }
        a.b(paramf, paramAnonymousObject);
        AppMethodBeat.o(231787);
      }
    }, new af.a() {});
    if (bool1) {
      a(paramf, paramas);
    }
    for (;;)
    {
      b(paramf, paramas);
      break;
      paramf.jdMethod_do(FinderPreference.NAME, true);
    }
  }
  
  public final boolean alD(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        u.g(this.pQZ, null);
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
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.rjX.field_username });
      if (this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.pQZ.getIntent();
        paramString.putExtra("sns_source", this.pQZ.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.rjX.signature);
        paramString.putExtra("sns_nickName", this.rjX.arI());
        paramString.putExtra("sns_title", this.rjX.arJ());
        paramString.putExtra("sns_rpt_scene", d.aP(this.pQZ.getIntent()));
        if ((o.DCR == null) || (i == 0)) {
          break label289;
        }
        paramString = o.DCR.g(paramString, this.rjX.field_username);
        if (paramString != null) {
          break label307;
        }
        this.pQZ.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.nRm.bmg("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePP = paramString.grS();
        break;
        i = 0;
        break label115;
        label289:
        paramString.putExtra("sns_userName", this.rjX.field_username);
        break label235;
        label307:
        com.tencent.mm.br.c.b(this.pQZ, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.pQZ.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.rjX;
        if (localObject1 == null) {
          Log.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label641;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.rjX.field_username });
          break;
          if (!com.tencent.mm.contact.c.oR(((ax)localObject1).field_type))
          {
            if (!Util.isNullOrNil(((ax)localObject1).field_encryptUsername)) {
              a(((ax)localObject1).field_encryptUsername, (as)localObject1);
            } else {
              a(((ax)localObject1).field_username, (as)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.nRm.bmg("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((ax)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.pQZ.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).KcI);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((ax)localObject1).fuX);
            b.jRt.l((Intent)localObject3, this.pQZ);
          }
        }
      }
      else
      {
        label641:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 0);
          localObject1 = this.pQZ;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.rjX.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.pQZ.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.pQZ;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.Bcm != null) {
            this.Bcm.eDQ();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.rjX;
            if (Util.nullAs(Boolean.valueOf(ab.IQ(((ax)localObject1).field_username)), false))
            {
              localObject1 = ((ax)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.pQZ.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.rjX.field_username });
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.pQZ, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.pQZ;
              paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((ax)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.pQZ.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((ax)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.pQZ, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.pQZ;
                paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.rjX;
            localObject1 = new zi();
            EventCenter.instance.publish((IEvent)localObject1);
            com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.rjX.field_username });
            if ((!paramString.field_username.equals(((zi)localObject1).efv.talker)) && ((((zi)localObject1).efv.dCH) || (((zi)localObject1).efv.dCI)))
            {
              if (((zi)localObject1).efv.efw) {}
              for (i = 2131756942;; i = 2131756943)
              {
                Toast.makeText(this.pQZ, i, 0).show();
                Log.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.q.a.cA(this.pQZ)) && (!com.tencent.mm.q.a.cE(this.pQZ)) && (!com.tencent.mm.q.a.p(this.pQZ, true)))
            {
              localObject1 = new xq();
              ((xq)localObject1).edR.edT = true;
              EventCenter.instance.publish((IEvent)localObject1);
              localObject1 = ((xq)localObject1).edS.edV;
              if (!Util.isNullOrNil((String)localObject1))
              {
                Log.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.h.c(this.pQZ, this.pQZ.getString(2131766611), "", this.pQZ.getString(2131755921), this.pQZ.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26822);
                    Object localObject = new xq();
                    ((xq)localObject).edR.edU = true;
                    EventCenter.instance.publish((IEvent)localObject);
                    localObject = new fo();
                    ((fo)localObject).dIN.username = com.tencent.mm.bi.d.jpB.bgL();
                    EventCenter.instance.publish((IEvent)localObject);
                    a.this.a(paramString, a.this.pQZ);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(26822);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(231781);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(231781);
                  }
                });
              }
              else
              {
                a(paramString, this.pQZ);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2283;
            }
            localObject4 = this.pQZ;
            localObject1 = this.rjX;
            i = this.mScene;
            if ((i != 17) || (!this.Bcn)) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this.pQZ, this.pQZ.getString(2131764040), "", this.pQZ.getString(2131768713), null);
          }
        }
      }
    }
    paramString = (String)localObject1;
    if ((int)((com.tencent.mm.contact.c)localObject1).gMZ == 0)
    {
      bg.aVF();
      paramString = (String)localObject1;
      if (com.tencent.mm.model.c.aSN().aq((as)localObject1) != -1)
      {
        bg.aVF();
        paramString = com.tencent.mm.model.c.aSN().Kn(((ax)localObject1).field_username);
      }
    }
    Object localObject2 = this.pQZ.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.pQZ.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = Util.nullAsNil((String)localObject2);
    localObject1 = Util.nullAsNil((String)localObject1);
    if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject2);
      if (localObject3 != null) {
        break label3638;
      }
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject1);
      localObject2 = localObject1;
    }
    label3500:
    label3638:
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.pQZ, new com.tencent.mm.pluginsdk.ui.applet.a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(231793);
          if (paramAnonymousBoolean1)
          {
            a locala = a.this;
            paramAnonymousString2 = paramString;
            int i = i;
            if (Util.isNullOrNil(paramAnonymousString1))
            {
              Log.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
              com.tencent.mm.plugin.report.service.h.CyF.dN(931, 21);
            }
            if ((int)paramAnonymousString2.gMZ == 0)
            {
              if (!Util.isNullOrNil(paramAnonymousString1)) {
                paramAnonymousString2.setUsername(paramAnonymousString1);
              }
              bg.aVF();
              com.tencent.mm.model.c.aSN().aq(paramAnonymousString2);
              bg.aVF();
              com.tencent.mm.model.c.aSN().Kn(paramAnonymousString2.field_username);
            }
            if ((int)paramAnonymousString2.gMZ <= 0)
            {
              Log.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
              AppMethodBeat.o(231793);
              return;
            }
            com.tencent.mm.plugin.report.service.h localh;
            String str;
            if ((!com.tencent.mm.contact.c.oR(paramAnonymousString2.field_type)) && (i == 15))
            {
              paramAnonymousString1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramAnonymousString2.field_username);
              if ((paramAnonymousString1 != null) && (!Util.isNullOrNil(paramAnonymousString2.fuX)))
              {
                localh = com.tencent.mm.plugin.report.service.h.CyF;
                str = paramAnonymousString2.field_username;
                if (!Util.isNullOrNil(paramAnonymousString1.getMd5())) {
                  break label308;
                }
              }
            }
            label308:
            for (i = 0;; i = 1)
            {
              localh.a(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.contact.a.f(paramAnonymousString2)) });
              ab.B(paramAnonymousString2);
              locala.nRm.notifyDataSetChanged();
              au.aI(paramAnonymousString2.field_encryptUsername, 0);
              paramAnonymousString1 = new re();
              paramAnonymousString1.dXU.username = paramAnonymousString2.field_encryptUsername;
              paramAnonymousString1.dXU.type = 1;
              EventCenter.instance.publish(paramAnonymousString1);
              AppMethodBeat.o(231793);
              return;
            }
          }
          if (paramAnonymousBoolean2)
          {
            com.tencent.mm.bj.d.bgN().gP(paramAnonymousString1, 2);
            au.aI(paramString.field_encryptUsername, 1);
            paramAnonymousString1 = new re();
            paramAnonymousString1.dXU.username = paramString.field_encryptUsername;
            paramAnonymousString1.dXU.type = 1;
            EventCenter.instance.publish(paramAnonymousString1);
            AppMethodBeat.o(231793);
            return;
          }
          Log.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
          AppMethodBeat.o(231793);
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).mz((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).Kea = new a.b()
      {
        public final boolean aE(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(231794);
          String str = this.knk.getIntent().getStringExtra("room_name");
          int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 2);
          int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slT, 1000);
          SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
          Object localObject;
          if ((!as.bjp(paramString.field_username)) && (i == 1))
          {
            localObject = SayHiWithSnsPermissionUI2.class;
            localObject = new Intent(this.knk, (Class)localObject);
            ((Intent)localObject).putExtra("Contact_User", paramString.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramString.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramString.field_conRemark);
            if ((i != 14) && (i != 8)) {
              break label407;
            }
            ((Intent)localObject).putExtra("Contact_RoomNickname", this.knk.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("Contact_Scene", i);
            ((Intent)localObject).putExtra("room_name", str);
            ((Intent)localObject).putExtra("source_from_user_name", this.BcD);
            ((Intent)localObject).putExtra("source_from_nick_name", str);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
            ((Intent)localObject).putExtra(e.d.OyT, paramAnonymousString);
            ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
            ((Intent)localObject).putExtra("key_msg_id", l);
            paramAnonymousString = this.knk;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(231794);
            return true;
            localObject = localSayHiWithSnsPermissionUI;
            if (as.bjp(paramString.field_username)) {
              break;
            }
            localObject = localSayHiWithSnsPermissionUI;
            if (i != 2) {
              break;
            }
            localObject = localSayHiWithSnsPermissionUI;
            if (ab.aVc() < j) {
              break;
            }
            localObject = SayHiWithSnsPermissionUI3.class;
            break;
            label407:
            if (i == 17) {
              ((Intent)localObject).putExtra("key_msg_id", this.knk.getIntent().getLongExtra("key_msg_id", 0L));
            }
          }
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.d.OyT);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).beC((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, "", (LinkedList)localObject3);
      }
      for (;;)
      {
        if (!com.tencent.mm.plugin.messenger.e.a.Hh(l)) {
          break label2281;
        }
        com.tencent.mm.plugin.messenger.e.a.Q(l, 3);
        break;
        if (TextUtils.isEmpty(str))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).beC(paramString.fuY);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).h(paramString.field_username, (LinkedList)localObject3);
        }
        else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).wZz))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
        }
        else
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSN().Kn(paramString.field_username);
          if (localObject1 != null) {}
          for (localObject1 = Util.nullAs(((ax)localObject1).fuY, "");; localObject1 = "")
          {
            Log.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2237;
            }
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).beC((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
            break;
          }
          label2237:
          this.Bco.add(paramString.field_username);
          ay.a.iDq.a(paramString.field_username, str, new ay.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(231780);
              bg.aVF();
              paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(paramString.field_username);
              if (paramAnonymousString != null) {}
              for (paramAnonymousString = Util.nullAs(paramAnonymousString.fuY, "");; paramAnonymousString = "")
              {
                this.Bcu.beC(paramAnonymousString);
                this.Bcu.d(paramString.field_username, str, this.Bcw);
                AppMethodBeat.o(231780);
                return;
              }
            }
          });
        }
      }
      label2281:
      break;
      label2283:
      if (paramString.equals("contact_profile_accept_contact"))
      {
        localObject2 = this.pQZ;
        localObject3 = this.rjX;
        ((MMActivity)localObject2).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 2);
        int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slT, 1000);
        localObject1 = SayHiWithSnsPermissionUI.class;
        if ((!as.bjp(((ax)localObject3).field_username)) && (i == 1)) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject2, paramString);
          paramString.putExtra("Contact_User", ((ax)localObject3).field_username);
          paramString.putExtra("room_name", this.gwx);
          paramString.putExtra("Contact_Nick", ((ax)localObject3).field_nickname);
          paramString.putExtra("Contact_RemarkName", ((ax)localObject3).field_conRemark);
          if ((this.mScene == 14) || (this.mScene == 8)) {
            paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject2).getIntent().getStringExtra("Contact_RoomNickname"));
          }
          paramString.putExtra("Contact_Scene", this.mScene);
          paramString.putExtra("Verify_ticket", Util.nullAsNil(((Activity)localObject2).getIntent().getStringExtra("Verify_ticket")));
          paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
          paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
          paramString.putExtra("sayhi_with_sns_perm_set_label", true);
          paramString.putExtra("sayhi_with_sns_permission", ((as)localObject3).arB());
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramString.axQ(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramString = (String)localObject1;
          if (!as.bjp(((ax)localObject3).field_username))
          {
            paramString = (String)localObject1;
            if (i == 2)
            {
              paramString = (String)localObject1;
              if (ab.aVc() >= j) {
                paramString = SayHiWithSnsPermissionUI3.class;
              }
            }
          }
        }
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.rjX;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.d.OyT, paramString.fuY);
        b.jRt.a((Intent)localObject1, this.pQZ);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.Bcm == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.pQZ, this.rjX);
        com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.rjX.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.nRm.bmg("contact_info_invite_source")).getExtras().getString("inviter");
        if (Util.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.gtd, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.gwx);
        bg.aVF();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.aSN().Kn(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.gwx);
        b.jRt.c((Intent)localObject2, this.pQZ);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.rjX;
        localObject3 = Util.nullAsNil(this.pQZ.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = com.tencent.mm.plugin.profile.ui.q.a(this.pQZ, (as)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].iAq;
          paramString = com.tencent.mm.plugin.profile.ui.q.b(this.pQZ, (as)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((ax)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.aAg().hqi.iMw, new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            AppMethodBeat.i(231790);
            paramAnonymousq.setHasCallbackToQueue(true);
            paramAnonymousString = (com.tencent.mm.plugin.profile.b.a)paramAnonymousq;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              if (paramAnonymousString.BcU == null) {
                paramAnonymousString.BcU = ((brt)paramAnonymousString.rr.iLL.iLR);
              }
              String str = paramAnonymousString.BcU.LYY;
              paramAnonymousString = null;
              try
              {
                paramAnonymousq = Uri.parse(str);
                paramAnonymousString = paramAnonymousq;
              }
              catch (Exception paramAnonymousq)
              {
                for (;;)
                {
                  Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramAnonymousq.getMessage() });
                }
              }
              paramAnonymousString = new Intent("android.intent.action.VIEW", paramAnonymousString);
              a.this.pQZ.startActivityForResult(paramAnonymousString, 111);
              Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
              AppMethodBeat.o(231790);
              return;
            }
            Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (paramAnonymousString.BcU == null) {
              paramAnonymousString.BcU = ((brt)paramAnonymousString.rr.iLL.iLR);
            }
            if ((paramAnonymousString.BcU.BaseResponse != null) && (paramAnonymousString.BcU.BaseResponse.ErrMsg != null)) {}
            for (paramAnonymousString = Util.nullAsNil(paramAnonymousString.BcU.BaseResponse.ErrMsg.MTo);; paramAnonymousString = paramAnonymousString.errMsg)
            {
              paramAnonymousq = paramAnonymousString;
              if (Util.isNullOrNil(paramAnonymousString)) {
                paramAnonymousq = a.this.pQZ.getString(2131763793);
              }
              com.tencent.mm.ui.base.h.c(a.this.pQZ, paramAnonymousq, a.this.pQZ.getString(2131766783), false);
              AppMethodBeat.o(231790);
              return;
            }
          }
        });
        break;
      }
      if (paramString.equals("contact_profile_story"))
      {
        paramString = (AbsStoryPreference)this.nRm.bmg("contact_profile_story");
        if (paramString == null) {
          break;
        }
        paramString.fmZ();
        break;
      }
      if (paramString.equals(FinderPreference.NAME))
      {
        paramString = (FinderPreference)this.nRm.bmg(FinderPreference.NAME);
        boolean bool;
        if ((paramString.Kpr != null) && (paramString.Kpr.contact != null))
        {
          localObject2 = paramString.Kpr.contact.username;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
            ((Intent)localObject1).putExtra("key_enter_profile_type", 14);
            bool = ((String)localObject2).equals(z.aUg());
            localObject2 = (aj)com.tencent.mm.kernel.g.ah(aj.class);
            if (!bool) {
              break label3500;
            }
          }
        }
        for (i = 33;; i = 32)
        {
          ((aj)localObject2).fillContextIdToIntent(14, 2, i, (Intent)localObject1);
          ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", bool);
          ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(paramString.mContext, (Intent)localObject1);
          com.tencent.mm.plugin.report.service.h.CyF.n(1585L, 2L, 1L);
          ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().awv(this.rjX.field_username);
          com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(24), Integer.valueOf(1), this.rjX.field_username });
          com.tencent.mm.plugin.report.service.h.CyF.a(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
          break;
        }
      }
      if (!paramString.equals("contact_profile_finder_recent_like")) {
        break;
      }
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().b(this.pQZ, this.rjX.field_username, this.rjX.field_nickname, 79);
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(d.aP(this.pQZ.getIntent())), Integer.valueOf(25), Integer.valueOf(1), this.rjX.field_username });
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderUtilApi().awv(this.rjX.field_username);
      break;
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean cCs()
  {
    AppMethodBeat.i(26839);
    this.nRm.bmg("contact_profile_sns");
    if (o.DCR != null) {
      o.DCR.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.nRm.bmg("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.nRm.bmg("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.Bcr.dead();
    if (this.Bcm != null) {
      this.Bcm.destroy();
    }
    localObject = this.Bco.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ay.a.iDq.JZ(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void fP(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.nRm.jdMethod_do("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.nRm.jdMethod_do("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.nRm, this.rjX, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */