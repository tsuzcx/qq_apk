package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aap.a;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.FinderPreference;
import com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.protocal.protobuf.ezj;
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
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements j.a, com.tencent.mm.plugin.story.api.d, com.tencent.mm.pluginsdk.c.a
{
  private boolean GWk;
  com.tencent.mm.plugin.profile.a.b GWl;
  private boolean GWm;
  final List<String> GWn;
  private com.tencent.mm.ui.widget.a.e GWo;
  String GWp;
  IListener<com.tencent.mm.f.a.bh> GWq;
  private boolean GWr;
  ah iXp;
  String jaK;
  private long lastUpdateTime;
  private int mScene;
  com.tencent.mm.ui.base.preference.f mrf;
  private boolean readOnly;
  MMActivity tmY;
  as uNk;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.GWk = false;
    this.GWn = new LinkedList();
    this.GWp = null;
    this.GWq = new a.7(this);
    this.GWr = false;
    this.lastUpdateTime = 0L;
    this.tmY = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    Log.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.byG("contact_info_invite_source");
    paramf.dz("contact_info_invite_source", false);
    paramf = new SpannableString(l.c(paramActivity, paramActivity.getResources().getString(R.l.eyB, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(R.e.brand_text_color)), 0, paramString2.length(), 33);
    localKeyValuePreference.auK(2);
    localKeyValuePreference.WrK = false;
    localKeyValuePreference.aF(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (fpB())
    {
      paramf.dz("contact_profile_setting_desc", true);
      paramf.dz("contact_profile_setting_permission", true);
      paramf.dz("contact_profile_phone", true);
      paramf.dz("contact_profile_info_more", true);
      paramf.dz("contact_profile_sns", as.bvK(paramas.field_username));
      if ((z.bde() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.u(this.tmY, "com.tencent.wework");
        com.tencent.mm.model.bh.beI();
        Object localObject = (Integer)com.tencent.mm.model.c.aHp().get(ar.a.Vhm, Integer.valueOf(0));
        Log.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(z.bde()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!Util.isEqual(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.u(this.tmY, "com.tencent.wework")))) {
          break label326;
        }
        paramf.dz("contact_profile_accept_contact_by_wework", false);
        localObject = com.tencent.mm.plugin.profile.ui.q.a(this.tmY, paramas, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label435;
        }
      }
    }
    label435:
    for (paramas = com.tencent.mm.plugin.profile.ui.q.b(this.tmY, paramas, this.mScene);; paramas = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.aUL(this.uNk.field_username)) {
        ((ButtonPreference)paramf.byG("contact_profile_accept_contact_by_wework")).hG(this.tmY.getString(R.l.contact_info_goto_wework_send_msg), this.tmY.getResources().getColor(R.e.brand_text_color));
      }
      if ((!Util.isNullOrNil(paramas)) && (com.tencent.mm.plugin.profile.b.e.aUK(paramas) == 2) && (paramBoolean)) {
        paramf.dz("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label326:
      if (this.tmY.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramas = (ButtonPreference)paramf.byG("contact_profile_accept_contact");
        paramas.hG(this.tmY.getString(R.l.enz), this.tmY.getResources().getColor(R.e.disable_text_color));
        paramas.setEnabled(false);
      }
      paramf.dz("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.dz("contact_profile_accept_contact", true);
      paramf.dz("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    AppMethodBeat.i(290131);
    if ((paramObject instanceof ezi))
    {
      paramf = (NormalProfileHeaderPreference)paramf.byG("contact_profile_header_normal");
      if (paramf != null)
      {
        paramf.Hah = ((ezi)paramObject).contact;
        this.mrf.notifyDataSetChanged();
      }
      AppMethodBeat.o(290131);
      return;
    }
    paramf = (NormalProfileHeaderPreference)paramf.byG("contact_profile_header_normal");
    if (paramf != null)
    {
      paramf.Hah = null;
      this.mrf.notifyDataSetChanged();
    }
    AppMethodBeat.o(290131);
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
    b.mIG.l(paramString, this.tmY);
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
    com.tencent.mm.model.bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(paramString);
    Object localObject1 = localObject2;
    if (localas != null)
    {
      localObject1 = localObject2;
      if ((int)localas.jxt > 0) {
        localObject1 = localas.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = paramah.PJ(paramString);
    }
    paramah = (ah)localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      paramah = (ah)localObject2;
      if (localas != null) {
        paramah = localas.ayr();
      }
    }
    AppMethodBeat.o(26854);
    return paramah;
  }
  
  private boolean fpA()
  {
    AppMethodBeat.i(26844);
    boolean bool = as.PY(this.uNk.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean fpB()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (this.tmY.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean fpC()
  {
    AppMethodBeat.i(26846);
    if (this.tmY.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean fpD()
  {
    AppMethodBeat.i(26847);
    if (this.tmY.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean fpE()
  {
    AppMethodBeat.i(26848);
    int i = this.tmY.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean fpF()
  {
    return this.uNk.field_deleteFlag == 1;
  }
  
  private boolean fpx()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = com.tencent.mm.model.ab.lsO;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.uNk.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = fpy();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean fpy()
  {
    AppMethodBeat.i(26843);
    boolean bool = com.tencent.mm.model.ab.QO(this.uNk.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean fpz()
  {
    AppMethodBeat.i(290127);
    boolean bool = ((com.tencent.mm.plugin.findersdk.a.ab)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.ab.class)).aEF(this.uNk.field_username);
    AppMethodBeat.o(290127);
    return bool;
  }
  
  final void a(as paramas, Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.GWo = new com.tencent.mm.ui.widget.a.e(this.tmY, 1, false);
    this.GWo.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(290459);
        paramAnonymouso.aW(2, R.l.app_field_voip, R.k.sharemore_videovoip);
        paramAnonymouso.aW(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
        AppMethodBeat.o(290459);
      }
    };
    this.GWo.ODU = new a.16(this, paramas, paramContext);
    this.GWo.eik();
    AppMethodBeat.o(26850);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.mrf.byG("contact_profile_sns");
    if ((paramString != null) && (p.JPd != null))
    {
      paramString.brA(this.uNk.field_username);
      com.tencent.mm.plugin.sns.k.g.Kia.Kio.gQl = paramString.hmS();
      if (p.JPh != null) {
        p.JPh.a(this, 3);
      }
      this.mrf.notifyDataSetChanged();
      if (paramb.fMT())
      {
        Log.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (p.JPh != null) {
          p.JPh.aYP(this.uNk.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.mrf = paramf;
    this.uNk = paramas;
    this.mScene = paramInt;
    this.jaK = this.tmY.getIntent().getStringExtra("room_name");
    com.tencent.mm.model.bh.beI();
    this.iXp = com.tencent.mm.model.c.bbV().Rw(this.jaK);
    this.GWm = this.tmY.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.GWl == null)
    {
      this.GWl = new com.tencent.mm.plugin.profile.a.b(this.tmY, paramas);
      localObject1 = this.GWl;
      ((com.tencent.mm.plugin.profile.a.b)localObject1).tzD.addIconOptionMenu(0, R.l.app_more, R.k.icons_outlined_more, (MenuItem.OnMenuItemClickListener)localObject1);
    }
    Log.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramas.field_username });
    paramf.removeAll();
    paramf.auC(R.o.eXI);
    Object localObject3 = (NormalProfileHeaderPreference)paramf.byG("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject3).mrf = paramf;
    ((NormalProfileHeaderPreference)localObject3).a(paramas, paramInt, paramBoolean, this.GWl);
    Object localObject1 = (ButtonPreference)paramf.byG("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).Wqx = R.h.dCj;
    }
    Object localObject2 = (ButtonPreference)paramf.byG("contact_profile_add_contact");
    Object localObject4;
    as localas;
    Object localObject5;
    Object localObject6;
    int j;
    if ((as.bvK(paramas.field_username)) && (paramas.hDz != 0))
    {
      paramBoolean = true;
      this.GWk = paramBoolean;
      localObject4 = this.tmY;
      localas = this.uNk;
      if ((as.bvK(localas.field_username)) && (localas.hDz != 0))
      {
        i = paramf.bf("contact_info_category_1");
        localObject5 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).c(localas.field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.a.a.mxX);
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          localObject6 = new PreferenceTitleCategory((Context)localObject4);
          ((Preference)localObject6).setLayoutResource(a.h.mm_preference_info_smalltext);
          ((Preference)localObject6).setTitle((CharSequence)localObject5);
          paramf.a((Preference)localObject6, i);
          ((Preference)localObject6).Wsy = new com.tencent.mm.plugin.profile.a.a.1();
        }
        localObject5 = new com.tencent.mm.openim.a.b();
        ((com.tencent.mm.openim.a.b)localObject5).ZC(localas.hDA);
        localObject5 = ((com.tencent.mm.openim.a.b)localObject5).mxJ.iterator();
      }
    }
    else
    {
      label733:
      for (;;)
      {
        if (!((Iterator)localObject5).hasNext()) {
          break label736;
        }
        localObject6 = (com.tencent.mm.openim.a.b.a)((Iterator)localObject5).next();
        Iterator localIterator = ((com.tencent.mm.openim.a.b.a)localObject6).mya.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label733;
          }
          b.b localb = (b.b)localIterator.next();
          j = i + 1;
          com.tencent.mm.plugin.profile.a.a.2 local2 = new com.tencent.mm.plugin.profile.a.a.2((Context)localObject4, localb);
          local2.DJc = ((com.tencent.mm.openim.a.b.a)localObject6).title;
          local2.auK(2);
          local2.WrK = false;
          local2.aF(l.c((Context)localObject4, localb.ZD(localas.field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.auO(8);
            i = j;
            continue;
            paramBoolean = false;
            break;
          }
          if (localb.action == 2)
          {
            local2.Wsy = new com.tencent.mm.plugin.profile.a.a.3(localb, localas, (com.tencent.mm.openim.a.b.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.Wsy = new com.tencent.mm.plugin.profile.a.a.4(localb, localas, (com.tencent.mm.openim.a.b.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.Wsy = new com.tencent.mm.plugin.profile.a.a.5(localb, localas, (com.tencent.mm.openim.a.b.a)localObject6);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.Wsy = new com.tencent.mm.plugin.profile.a.a.6(localb, localas, (com.tencent.mm.openim.a.b.a)localObject6);
              i = j;
            }
          }
        }
      }
    }
    label736:
    if (fpy())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject3);
      paramf.b(new PreferenceSmallCategory(this.tmY));
      paramas = new KeyValuePreference(this.tmY);
      paramas.setTitle(R.l.eyC);
      paramas.auI(R.l.eAn);
      paramas.auK(2147483647);
      paramas.WrK = false;
      paramas.auO(8);
      paramf.b(paramas);
      paramf.b(new PreferenceSmallCategory(this.tmY));
      if (com.tencent.mm.contact.d.rk(this.uNk.field_type)) {
        paramf.b((Preference)localObject1);
      }
      for (;;)
      {
        this.GWl.tzD.removeAllOptionMenu();
        AppMethodBeat.o(26837);
        return true;
        paramf.b((Preference)localObject2);
      }
    }
    localObject3 = this.uNk;
    int i = this.tmY.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.tmY.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = Util.nullAs(this.tmY.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new elj();
    ((elj)localObject2).mVJ = i;
    ((elj)localObject2).mVL = l;
    ((elj)localObject2).mVK = ((String)localObject1);
    localObject1 = localObject2;
    if (p.JPd != null) {
      localObject1 = p.JPd.b(((ax)localObject3).field_username, (elj)localObject2);
    }
    com.tencent.mm.model.bh.beI();
    final boolean bool1 = com.tencent.mm.model.c.bbL().bwd(((ax)localObject3).field_username);
    boolean bool2 = z.bcZ().equals(((ax)localObject3).field_username);
    if ((((elj)localObject1).mVJ & 0x1) > 0)
    {
      paramBoolean = true;
      Log.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((as.bvI(((ax)localObject3).field_username)) || (!paramBoolean)) && (!fpB()) && (!bool2)) {
        break label3520;
      }
      this.mrf.dz("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.mrf.byG("contact_profile_sns");
      if (p.JPh != null)
      {
        p.JPh.a(3, ((ax)localObject3).field_username, this);
        i = this.tmY.getIntent().getIntExtra("Sns_from_Scene", 0);
        p.JPh.a(2, ((ax)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).brA(((ax)localObject3).field_username);
      label1212:
      if (as.bvK(((ax)localObject3).field_username)) {
        this.mrf.dz("contact_profile_sns", true);
      }
      localObject2 = paramf.byG("contact_profile_setting_desc");
      if (!as.bvK(this.uNk.field_username)) {
        break label3536;
      }
      localObject1 = this.tmY.getText(R.l.eAq).toString();
      label1276:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.byG("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.tmY.getString(R.l.eOO);
      if (!this.uNk.ayk()) {
        break label3556;
      }
      ((MultiSummaryPreference)localObject1).Hab = new String[] { this.tmY.getString(R.l.ePQ) };
      localObject1 = (KeyValuePreference)paramf.byG("contact_profile_source");
      paramInt = this.tmY.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.tmY, this.uNk, paramInt, this.uNk.field_username, fpB());
      ((KeyValuePreference)localObject1).aF((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).auK(2);
      ((KeyValuePreference)localObject1).WrK = false;
      ((KeyValuePreference)localObject1).jAg = (com.tencent.mm.ci.a.H(this.tmY, (int)this.tmY.getResources().getDimension(R.f.NormalTextSize)) * com.tencent.mm.ci.a.ez(this.tmY));
      ((KeyValuePreference)localObject1).auO(8);
      if ((!com.tencent.mm.contact.d.rk(paramas.field_type)) && (!Util.isNullOrNil((CharSequence)localObject2)) && ((!fpC()) || (fpB()))) {
        break label3819;
      }
      paramBoolean = true;
      label1495:
      paramf.dz("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.byG("contact_profile_label");
      ((LabelPreference)localObject1).uNk = paramas;
      if (!com.tencent.mm.contact.d.rk(((LabelPreference)localObject1).uNk.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).uNk.field_encryptUsername;
        if (!Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.bh.beI();
          ((LabelPreference)localObject1).Hvc = com.tencent.mm.model.c.bbM().aPj((String)localObject2);
        }
        if ((((LabelPreference)localObject1).Hvc != null) && (((LabelPreference)localObject1).Hvc.systemRowid < 0L))
        {
          com.tencent.mm.model.bh.beI();
          ((LabelPreference)localObject1).Hvc = com.tencent.mm.model.c.bbM().aPj(((LabelPreference)localObject1).uNk.field_username);
        }
      }
      if ((!com.tencent.mm.contact.d.rk(((LabelPreference)localObject1).uNk.field_type)) || (Util.isNullOrNil(((LabelPreference)localObject1).uNk.field_contactLabelIds))) {
        break label3824;
      }
      paramInt = 1;
      label1654:
      if (paramInt != 0) {
        break label3858;
      }
      paramBoolean = true;
      label1661:
      paramf.dz("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.byG("contact_profile_phone");
      ((PhoneNumPreference)localObject3).mrf = paramf;
      localObject4 = this.tmY.getIntent();
      ((PhoneNumPreference)localObject3).uNk = paramas;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      Log.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramas.ayo() });
      if (!paramas.ayo())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject4))) {
          break label3871;
        }
        if (!Util.isNullOrNil(paramas.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramas.field_username);
          localObject4 = paramas.field_username;
          if (localObject2 != null) {
            break label3863;
          }
          localObject1 = "true";
          label1830:
          Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1857:
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())))
        {
          ((PhoneNumPreference)localObject3).Rdn = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxY()).replace(" ", "");
          Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramas.field_username, ((PhoneNumPreference)localObject3).Rdn });
        }
        ((PhoneNumPreference)localObject3).hmR();
      }
      ((PhoneNumPreference)localObject3).Rdo = PhoneNumPreference.b(((PhoneNumPreference)localObject3).Rdn, paramas);
      ((PhoneNumPreference)localObject3).mrf.dz("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).hmR();
      ((PhoneNumPreference)localObject3).auO(8);
      localObject1 = (ProfileDescribePreference)paramf.byG("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).uNk = paramas;
      if (!com.tencent.mm.contact.d.rk(((ProfileDescribePreference)localObject1).uNk.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).uNk.field_encryptUsername;
        if (!Util.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.bh.beI();
          ((ProfileDescribePreference)localObject1).Hvc = com.tencent.mm.model.c.bbM().aPj((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).Hvc != null) && (((ProfileDescribePreference)localObject1).Hvc.systemRowid < 0L))
        {
          com.tencent.mm.model.bh.beI();
          ((ProfileDescribePreference)localObject1).Hvc = com.tencent.mm.model.c.bbM().aPj(((ProfileDescribePreference)localObject1).uNk.field_username);
        }
      }
      if (com.tencent.mm.contact.d.rk(((ProfileDescribePreference)localObject1).uNk.field_type)) {
        break label4013;
      }
      if ((((ProfileDescribePreference)localObject1).Hvc == null) || (Util.isNullOrNil(((ProfileDescribePreference)localObject1).Hvc.field_conDescription))) {
        break label4007;
      }
      paramInt = 1;
      label2124:
      if (paramInt != 0) {
        break label4067;
      }
      paramBoolean = true;
      label2131:
      paramf.dz("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.contact.d.rk(paramas.field_type)) || (Util.isNullOrNil(paramas.signature))) {
        break label4072;
      }
      localObject1 = (KeyValuePreference)paramf.byG("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).jAg = (com.tencent.mm.ci.a.H(this.tmY, (int)this.tmY.getResources().getDimension(R.f.NormalTextSize)) * com.tencent.mm.ci.a.ez(this.tmY));
        ((KeyValuePreference)localObject1).WrK = false;
        ((KeyValuePreference)localObject1).setTitle(this.tmY.getString(R.l.ezr));
        ((KeyValuePreference)localObject1).aF(l.c(this.tmY, paramas.signature));
        ((KeyValuePreference)localObject1).FU(false);
        ((KeyValuePreference)localObject1).auK(5);
        ((KeyValuePreference)localObject1).auO(8);
      }
      label2272:
      if ((paramf.byJ("contact_profile_desc") >= 0) || (paramf.byJ("contact_profile_label") >= 0)) {
        break label4085;
      }
      paramf.dz("contact_profile_setting_desc", false);
      label2306:
      if (!com.tencent.mm.contact.d.rk(paramas.field_type)) {
        paramf.dz("contact_profile_setting_desc", false);
      }
      paramf.dz("contact_profile_set_des_category", true);
      if ((!as.bvK(this.uNk.field_username)) || (!Util.isNullOrNil(this.uNk.field_conRemark))) {
        break label4098;
      }
      paramf.dz("contact_profile_setting_desc", false);
      paramf.dz("contact_profile_set_des_category", true);
      label2384:
      paramf.byG("contact_profile_info_more").setTitle(this.tmY.getText(R.l.eyK).toString());
      ((TextPreference)paramf.byG("contact_profile_hint")).aG(this.tmY.getText(R.l.eyO));
      if (!paramas.ayc()) {
        break label4142;
      }
      paramf.dz("contact_profile_hint", false);
      label2453:
      localObject2 = (MultiButtonPreference)paramf.byG("contact_profile_multi_button");
      if (!fpz()) {
        break label4156;
      }
      ((MultiButtonPreference)localObject2).a(this.tmY.getString(R.l.contact_info_finder_in_blacklist), new a.1(this));
      label2497:
      if ((fpx()) || ((com.tencent.mm.contact.d.rk(paramas.field_type)) && (!paramas.ayc())) || ((!fpB()) && (fpC()))) {
        paramf.dz("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (!fpB()) && (!fpF()) && (!fpA())) {
        break label4346;
      }
      paramf.dz("contact_profile_send", true);
      paramf.dz("contact_profile_voip", true);
      label2602:
      if ((!com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (!fpB()) && (!fpF()) && (!fpE()) && (!fpD()) && (!z.bcZ().equals(this.uNk.field_username))) {
        break label4377;
      }
      paramf.dz("contact_profile_add_contact", true);
      label2670:
      a(paramf, paramas, false);
      if ((fpB()) || (com.tencent.mm.contact.d.rk(paramas.field_type)) || ((!fpA()) && (!fpE()) && (!fpD()))) {
        break label4431;
      }
      paramf.dz("contact_profile_info_more", true);
      paramf.dz("contact_profile_say_hi", false);
      label2736:
      if (z.PD(this.uNk.field_username))
      {
        paramf.dz("contact_profile_multi_button", true);
        paramf.dz("contact_profile_info_more", Util.isNullOrNil(paramas.signature));
        paramf.dz("contact_profile_setting_desc", true);
        paramf.dz("contact_profile_setting_permission", true);
        paramf.dz("contact_profile_voip", true);
        this.GWl.tzD.removeAllOptionMenu();
      }
      localObject2 = this.uNk;
      paramf.dz("contact_info_invite_source", true);
      if (this.iXp != null) {
        break label4478;
      }
      paramBoolean = this.tmY.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label2855:
      if ((this.mScene == 14) && (paramBoolean) && (this.iXp != null) && (!((ax)localObject2).field_username.equals(this.iXp.field_roomowner))) {
        break label4495;
      }
      paramInt = this.mScene;
      if (this.iXp != null) {
        break label4489;
      }
      bool1 = true;
      label2909:
      Log.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.dz("contact_info_invite_source", true);
      label2954:
      this.mrf.dz("contact_profile_story", true);
      com.tencent.mm.model.bh.beI();
      paramBoolean = com.tencent.mm.model.c.bbL().bwd(paramas.field_username);
      bool1 = z.bcZ().equals(paramas.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().gbw())
      {
        Log.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!as.bvI(paramas.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.mrf.byG("contact_profile_story");
          paramf.onCreate(paramas.field_username);
          paramf.a(this);
          paramf.gbr();
          paramf.gbq();
        }
      }
      paramf = this.mrf;
      if (!fpz()) {
        break label4779;
      }
      paramf.dz("contact_profile_add_contact", true);
      paramf.dz("contact_profile_accept_contact_by_wework", true);
      paramf.dz("contact_profile_setting_desc", true);
      paramf.dz("contact_profile_send", true);
      paramf.dz("contact_profile_voip", true);
      paramf.dz("contact_profile_say_hi", true);
      paramf.dz("contact_profile_info_more", true);
      paramf.dz("contact_profile_setting_permission", true);
      paramf.dz("contact_profile_voip", true);
      paramf.dz("contact_profile_multi_button", false);
      paramf.dz("contact_profile_set_des_category", true);
      paramf.dz("contact_info_category_1", true);
      paramf.dz("line1", false);
      paramf.dz("line2", false);
      paramf.dz("line3", false);
      paramf.dz("line4", false);
      this.GWl.tzD.removeAllOptionMenu();
      label3297:
      paramf = this.tmY;
      localObject2 = this.mrf;
      if (this.GWk)
      {
        ((com.tencent.mm.ui.base.preference.f)localObject2).byI(FinderPreference.NAME);
        paramInt = ((com.tencent.mm.ui.base.preference.f)localObject2).bf("openim_from_pref_key");
        localObject1 = new FinderPreference(paramf);
        ((FinderPreference)localObject1).setKey(FinderPreference.NAME);
        ((FinderPreference)localObject1).mTitle = paramf.getString(R.l.find_friends_by_finder);
        ((com.tencent.mm.ui.base.preference.f)localObject2).a((Preference)localObject1, paramInt);
        ((com.tencent.mm.ui.base.preference.f)localObject2).a(new PreferenceSmallCategory(paramf), paramInt + 1);
      }
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("FinderWxNameCardFinderAndRecentLikeFinderClose", 0) != 1) {
        break label4793;
      }
      paramBoolean = true;
      label3425:
      bool1 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().edQ();
      Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, dontRequestCgi:" + paramBoolean + ", switchC:" + bool1);
      if (!paramBoolean) {
        break label4798;
      }
      ((com.tencent.mm.ui.base.preference.f)localObject2).dz(FinderPreference.NAME, true);
      ((com.tencent.mm.ui.base.preference.f)localObject2).dz("contact_profile_finder_recent_like", true);
    }
    for (;;)
    {
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3520:
      this.mrf.dz("contact_profile_sns", true);
      break label1212;
      label3536:
      localObject1 = this.tmY.getText(R.l.eAp).toString();
      break label1276;
      label3556:
      paramBoolean = paramas.ayi();
      bool1 = p.JPf.aUR(paramas.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3721;
        }
        localObject3 = this.tmY;
        if (paramas.sex == 2)
        {
          i = R.l.ePK;
          label3632:
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        }
      }
      else if (bool1)
      {
        if (j != 0) {
          break label3774;
        }
        localObject3 = this.tmY;
        if (paramas.sex != 2) {
          break label3766;
        }
      }
      label3721:
      label3766:
      for (i = R.l.ePG;; i = R.l.ePI)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).Hab = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = R.l.ePM;
        break label3632;
        localObject3 = this.tmY;
        if (paramas.sex == 2) {}
        for (i = R.l.ePL;; i = R.l.ePN)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3774:
      localObject3 = this.tmY;
      if (paramas.sex == 2) {}
      for (i = R.l.ePH;; i = R.l.ePJ)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3819:
      paramBoolean = false;
      break label1495;
      label3824:
      if ((((LabelPreference)localObject1).Hvc != null) && (!Util.isNullOrNil(((LabelPreference)localObject1).Hvc.field_contactLabels)))
      {
        paramInt = 1;
        break label1654;
      }
      paramInt = 0;
      break label1654;
      label3858:
      paramBoolean = false;
      break label1661;
      label3863:
      localObject1 = "false";
      break label1830;
      label3871:
      if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil((String)localObject4))) {
        break label1857;
      }
      Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramas.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).getMd5())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject4);
      }
      localObject4 = paramas.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label4007:
      paramInt = 0;
      break label2124;
      label4013:
      if (!Util.isNullOrNil(((ProfileDescribePreference)localObject1).uNk.hDr)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((Util.isNullOrNil(((ProfileDescribePreference)localObject1).uNk.hDq)) && (paramInt == 0)) {
          break label4061;
        }
        paramInt = 1;
        break;
      }
      label4061:
      paramInt = 0;
      break label2124;
      label4067:
      paramBoolean = false;
      break label2131;
      label4072:
      paramf.byI("contact_info_signature");
      break label2272;
      label4085:
      paramf.dz("contact_profile_setting_desc", true);
      break label2306;
      label4098:
      if ((!as.bvK(this.uNk.field_username)) && (!fpz())) {
        break label2384;
      }
      paramf.dz("contact_profile_setting_desc", true);
      paramf.dz("contact_profile_set_des_category", true);
      break label2384;
      label4142:
      paramf.dz("contact_profile_hint", true);
      break label2453;
      label4156:
      if (!fpB())
      {
        if ((!com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (this.tmY.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) == 2))
        {
          paramInt = 1;
          label4197:
          if (paramInt == 0) {
            break label4299;
          }
        }
      }
      else {
        if (!this.uNk.ayc()) {
          break label4284;
        }
      }
      label4284:
      for (localObject1 = this.tmY.getString(R.l.contact_info_moveout_blacklist);; localObject1 = this.tmY.getString(R.l.contact_info_movein_blacklist))
      {
        ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            a.this.GWl.vV(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26828);
          }
        });
        localObject1 = this.tmY.getString(R.l.biz_report_text);
        localObject3 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26829);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            a.this.GWl.fpQ();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26829);
          }
        };
        ((MultiButtonPreference)localObject2).GZW = ((String)localObject1);
        ((MultiButtonPreference)localObject2).GZZ = ((View.OnClickListener)localObject3);
        break;
        paramInt = 0;
        break label4197;
      }
      label4299:
      if ((!paramas.ayc()) && (!fpE()) && (!fpD())) {
        break label2497;
      }
      ((MultiButtonPreference)localObject2).a(this.tmY.getString(R.l.biz_report_text), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(277236);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          a.this.GWl.fpQ();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277236);
        }
      });
      break label2497;
      label4346:
      paramf.dz("contact_profile_send", false);
      paramf.dz("contact_profile_voip", this.uNk.ayc());
      break label2602;
      label4377:
      paramf.dz("contact_profile_add_contact", false);
      paramf.dz("contact_profile_setting_desc", false);
      paramf.dz("contact_profile_setting_permission", true);
      paramf.dz("contact_profile_phone", true);
      paramf.dz("contact_profile_info_more", true);
      break label2670;
      label4431:
      paramf.dz("contact_profile_say_hi", true);
      if (!com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        paramf.dz("contact_profile_info_more", true);
        break label2736;
      }
      paramf.dz("contact_profile_info_more", false);
      break label2736;
      label4478:
      paramBoolean = this.iXp.asE();
      break label2855;
      label4489:
      bool1 = false;
      break label2909;
      label4495:
      this.GWp = this.tmY.getIntent().getStringExtra("inviteer");
      if (Util.isNullOrNil(this.GWp))
      {
        localObject1 = this.iXp.bvz(((ax)localObject2).field_username);
        if (localObject1 != null) {
          break label4665;
        }
      }
      label4665:
      for (localObject1 = "";; localObject1 = Util.nullAs(((com.tencent.mm.k.a.a.b)localObject1).jmD, ""))
      {
        this.GWp = ((String)localObject1);
        if (Util.isNullOrNil(this.GWp)) {
          this.GWp = v.aI(((ax)localObject2).field_username, this.jaK);
        }
        if (!Util.isNullOrNil(this.GWp)) {
          break label4681;
        }
        Log.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.jaK, ((ax)localObject2).field_username });
        this.GWq.alive();
        this.GWn.add(((ax)localObject2).field_username);
        az.a.ltq.a(((ax)localObject2).field_username, this.jaK, new a.5(this));
        break;
      }
      label4681:
      this.tmY.getIntent().putExtra("inviteer", this.GWp);
      localObject1 = b(this.iXp, this.GWp);
      if (Util.isNullOrNil((String)localObject1))
      {
        this.GWn.add(((ax)localObject2).field_username);
        az.a.ltq.a(((ax)localObject2).field_username, "", new a.6(this, paramf));
        break label2954;
      }
      a(paramf, this.tmY, this.GWp, (String)localObject1);
      break label2954;
      label4779:
      paramf.dz("line4", true);
      break label3297;
      label4793:
      paramBoolean = false;
      break label3425;
      label4798:
      l = cm.bfC();
      if (l - this.lastUpdateTime >= 1000L) {
        break label4856;
      }
      Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, lastUpdateTime:" + this.lastUpdateTime + ", curTime:" + l);
    }
    label4856:
    this.lastUpdateTime = l;
    if (this.GWk)
    {
      localObject1 = "";
      com.tencent.mm.kernel.h.aHH();
      localObject3 = ((PluginOpenIM)com.tencent.mm.kernel.h.ag(PluginOpenIM.class)).getFinderInfoStg();
      paramas = paramas.field_username;
      paramf = "";
      localObject3 = ((com.tencent.mm.openim.e.f)localObject3).lvy.rawQuery("select finder_username from OpenIMFinderInfo where openIMUsername=? ", new String[] { paramas }, 2);
      if (((Cursor)localObject3).moveToFirst())
      {
        paramas = ((Cursor)localObject3).getString(0);
        paramf = paramas;
        if (paramas == null) {
          paramf = "";
        }
      }
      ((Cursor)localObject3).close();
      paramas = paramf;
      paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
      label4964:
      Log.i("MicroMsg.NewContactWidgetNormal", "isOpenIM:" + this.GWk + ",wxUsername:" + paramf + ",openimFinderUsername:" + paramas);
      paramf = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().a(paramf, paramas, this.tmY, new a.8(this, bool1, (com.tencent.mm.ui.base.preference.f)localObject2), new ag.a() {});
      if (!bool1) {
        break label5093;
      }
      b((com.tencent.mm.ui.base.preference.f)localObject2, paramf);
    }
    for (;;)
    {
      c((com.tencent.mm.ui.base.preference.f)localObject2, paramf);
      break;
      paramf = paramas.field_username;
      paramas = "";
      break label4964;
      label5093:
      ((com.tencent.mm.ui.base.preference.f)localObject2).dz(FinderPreference.NAME, true);
    }
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      com.tencent.mm.model.bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        w.g(this.tmY, null);
      }
    }
    final int i;
    label81:
    label255:
    Object localObject3;
    label201:
    Object localObject4;
    for (;;)
    {
      AppMethodBeat.o(26840);
      return true;
      d.a(this.tmY.getIntent(), 3, 1, this.uNk.field_username);
      if (this.tmY.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.tmY.getIntent();
        paramString.putExtra("sns_source", this.tmY.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.uNk.signature);
        paramString.putExtra("sns_nickName", this.uNk.ayr());
        paramString.putExtra("sns_title", this.uNk.ays());
        paramString.putExtra("sns_rpt_scene", d.aO(this.tmY.getIntent()));
        if ((p.JPh == null) || (i == 0)) {
          break label255;
        }
        paramString = p.JPh.f(paramString, this.uNk.field_username);
        if (paramString != null) {
          break label273;
        }
        this.tmY.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.mrf.byG("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.k.g.Kia.Kio.gQl = paramString.hmS();
        break;
        i = 0;
        break label81;
        paramString.putExtra("sns_userName", this.uNk.field_username);
        break label201;
        label273:
        com.tencent.mm.by.c.b(this.tmY, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.tmY.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.uNk;
        if (localObject1 == null) {
          Log.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label573;
          }
          d.a(this.tmY.getIntent(), 2, 1, this.uNk.field_username);
          break;
          if (!com.tencent.mm.contact.d.rk(((ax)localObject1).field_type))
          {
            if (!Util.isNullOrNil(((ax)localObject1).field_encryptUsername)) {
              a(((ax)localObject1).field_encryptUsername, (as)localObject1);
            } else {
              a(((ax)localObject1).field_username, (as)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.mrf.byG("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((ax)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.tmY.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).Rdn);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((ax)localObject1).hDw);
            b.mIG.k((Intent)localObject3, this.tmY);
          }
        }
      }
      else
      {
        label573:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 0);
          localObject1 = this.tmY;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.uNk.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.tmY.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.tmY;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.GWl != null) {
            this.GWl.fpJ();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.uNk;
            if (Util.nullAs(Boolean.valueOf(com.tencent.mm.model.ab.Qj(((ax)localObject1).field_username)), false))
            {
              localObject1 = ((ax)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.tmY.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              d.a(this.tmY.getIntent(), 4, 1, this.uNk.field_username);
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.tmY, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.tmY;
              paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((ax)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.tmY.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((ax)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.tmY, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.tmY;
                paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.uNk;
            localObject1 = new aap();
            EventCenter.instance.publish((IEvent)localObject1);
            d.a(this.tmY.getIntent(), 5, 1, this.uNk.field_username);
            if ((!paramString.field_username.equals(((aap)localObject1).fZK.talker)) && ((((aap)localObject1).fZK.fvo) || (((aap)localObject1).fZK.fvp)))
            {
              if (((aap)localObject1).fZK.fZL) {}
              for (i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
              {
                Toast.makeText(this.tmY, i, 0).show();
                Log.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.q.a.cw(this.tmY)) && (!com.tencent.mm.q.a.cB(this.tmY)) && (!com.tencent.mm.q.a.q(this.tmY, true)))
            {
              localObject1 = new yx();
              ((yx)localObject1).fYg.fYi = true;
              EventCenter.instance.publish((IEvent)localObject1);
              localObject1 = ((yx)localObject1).fYh.fYk;
              if (!Util.isNullOrNil((String)localObject1))
              {
                Log.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.h.c(this.tmY, this.tmY.getString(R.l.eTP), "", this.tmY.getString(R.l.app_ok), this.tmY.getString(R.l.app_cancel), new a.3(this, paramString), new a.4(this));
              }
              else
              {
                a(paramString, this.tmY);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2592;
            }
            localObject4 = this.tmY;
            paramString = this.uNk;
            i = this.mScene;
            if ((i != 17) || (!this.GWm)) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this.tmY, this.tmY.getString(R.l.ePE), "", this.tmY.getString(R.l.welcome_i_know), null);
          }
        }
      }
    }
    Object localObject1 = paramString;
    if ((int)paramString.jxt == 0)
    {
      com.tencent.mm.model.bh.beI();
      localObject1 = paramString;
      if (com.tencent.mm.model.c.bbL().aw(paramString) != -1)
      {
        com.tencent.mm.model.bh.beI();
        localObject1 = com.tencent.mm.model.c.bbL().RG(paramString.field_username);
      }
    }
    Object localObject2 = this.tmY.getIntent().getStringExtra("Contact_Mobile_MD5");
    paramString = this.tmY.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = Util.nullAsNil((String)localObject2);
    paramString = Util.nullAsNil(paramString);
    if ((!((String)localObject2).equals("")) || (!paramString.equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject2);
      if (localObject3 != null) {
        break label3845;
      }
      localObject3 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(paramString);
      localObject2 = paramString;
    }
    label2563:
    label3845:
    for (paramString = (String)localObject3;; paramString = (String)localObject3)
    {
      if (paramString != null) {
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a((String)localObject2, paramString);
      }
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(i));
      localObject3 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      final String str2 = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      if (this.GWk)
      {
        localObject5 = new com.tencent.mm.pluginsdk.ui.applet.a(this.tmY, new com.tencent.mm.pluginsdk.ui.applet.a.a()
        {
          public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(276413);
            if (paramAnonymousBoolean1)
            {
              a locala = a.this;
              paramAnonymousString2 = this.jkl;
              int i = i;
              if (Util.isNullOrNil(paramAnonymousString1))
              {
                Log.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
                com.tencent.mm.plugin.report.service.h.IzE.el(931, 21);
              }
              if ((int)paramAnonymousString2.jxt == 0)
              {
                if (!Util.isNullOrNil(paramAnonymousString1)) {
                  paramAnonymousString2.setUsername(paramAnonymousString1);
                }
                com.tencent.mm.model.bh.beI();
                com.tencent.mm.model.c.bbL().aw(paramAnonymousString2);
                com.tencent.mm.model.bh.beI();
                com.tencent.mm.model.c.bbL().RG(paramAnonymousString2.field_username);
              }
              while ((int)paramAnonymousString2.jxt <= 0)
              {
                Log.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
                AppMethodBeat.o(276413);
                return;
                if ((Util.isEqual(paramAnonymousString2.field_username, paramAnonymousString2.field_encryptUsername)) && (!Util.isNullOrNil(paramAnonymousString1)))
                {
                  Log.i("MicroMsg.NewContactWidgetNormal", "addContact respUsername:%s, username:%s, encryptUsername:%s", new Object[] { paramAnonymousString1, Util.nullAs(paramAnonymousString2.field_username, ""), Util.nullAs(paramAnonymousString2.field_encryptUsername, "") });
                  paramAnonymousString2.setUsername(paramAnonymousString1);
                }
              }
              com.tencent.mm.plugin.report.service.h localh;
              String str;
              if ((!com.tencent.mm.contact.d.rk(paramAnonymousString2.field_type)) && (i == 15))
              {
                paramAnonymousString1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramAnonymousString2.field_username);
                if ((paramAnonymousString1 != null) && (!Util.isNullOrNil(paramAnonymousString2.hDw)))
                {
                  localh = com.tencent.mm.plugin.report.service.h.IzE;
                  str = paramAnonymousString2.field_username;
                  if (!Util.isNullOrNil(paramAnonymousString1.getMd5())) {
                    break label381;
                  }
                }
              }
              label381:
              for (i = 0;; i = 1)
              {
                localh.a(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.contact.a.f(paramAnonymousString2)) });
                com.tencent.mm.model.ab.H(paramAnonymousString2);
                locala.mrf.notifyDataSetChanged();
                au.bb(paramAnonymousString2.field_encryptUsername, 0);
                paramAnonymousString1 = new se();
                paramAnonymousString1.fRL.username = paramAnonymousString2.field_encryptUsername;
                paramAnonymousString1.fRL.type = 1;
                EventCenter.instance.publish(paramAnonymousString1);
                AppMethodBeat.o(276413);
                return;
              }
            }
            if (paramAnonymousBoolean2)
            {
              com.tencent.mm.bl.d.bqc().hx(paramAnonymousString1, 2);
              au.bb(this.jkl.field_encryptUsername, 1);
              paramAnonymousString1 = new se();
              paramAnonymousString1.fRL.username = this.jkl.field_encryptUsername;
              paramAnonymousString1.fRL.type = 1;
              EventCenter.instance.publish(paramAnonymousString1);
              AppMethodBeat.o(276413);
              return;
            }
            Log.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
            AppMethodBeat.o(276413);
          }
        });
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).np((String)localObject3, str1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).ReH = new a.b()
        {
          public final boolean m(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
          {
            AppMethodBeat.i(284472);
            String str = this.nfc.getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 2);
            int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWG, 5000);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            if ((!as.bvK(this.jkl.field_username)) && (i == 1))
            {
              paramAnonymousString2 = SayHiWithSnsPermissionUI2.class;
              paramAnonymousString2 = new Intent(this.nfc, paramAnonymousString2);
              paramAnonymousString2.putExtra("Contact_User", this.jkl.field_username);
              paramAnonymousString2.putExtra("Contact_Nick", this.jkl.field_nickname);
              paramAnonymousString2.putExtra("Contact_RemarkName", this.jkl.field_conRemark);
              if ((i != 14) && (i != 8)) {
                break label385;
              }
              paramAnonymousString2.putExtra("Contact_RoomNickname", this.nfc.getIntent().getStringExtra("Contact_RoomNickname"));
            }
            for (;;)
            {
              paramAnonymousString2.putExtra("Contact_Scene", i);
              paramAnonymousString2.putExtra("room_name", str);
              paramAnonymousString2.putExtra("source_from_user_name", this.GWD);
              paramAnonymousString2.putExtra("source_from_nick_name", str1);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_set_label", false);
              paramAnonymousString2.putExtra(f.d.VRW, paramAnonymousString1);
              paramAnonymousString2.putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              paramAnonymousString2.putExtra("key_msg_id", l);
              paramAnonymousString1 = this.nfc;
              paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousString2);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$9", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(284472);
              return true;
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (as.bvK(this.jkl.field_username)) {
                break;
              }
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (i != 2) {
                break;
              }
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (com.tencent.mm.model.ab.bef() < j) {
                break;
              }
              paramAnonymousString2 = SayHiWithSnsPermissionUI3.class;
              break;
              label385:
              if (i == 17) {
                paramAnonymousString2.putExtra("key_msg_id", this.nfc.getIntent().getLongExtra("key_msg_id", 0L));
              }
            }
          }
        };
        paramString = ((MMActivity)localObject4).getIntent().getStringExtra(f.d.VRW);
        if (!TextUtils.isEmpty(paramString))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).bqY(paramString);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).d(((ax)localObject1).field_username, "", (LinkedList)localObject2);
        }
        for (;;)
        {
          if (!com.tencent.mm.plugin.messenger.f.a.Ow(l)) {
            break label2141;
          }
          com.tencent.mm.plugin.messenger.f.a.Z(l, 3);
          break;
          if (TextUtils.isEmpty(str2))
          {
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).bqY(((ax)localObject1).hDx);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).i(((ax)localObject1).field_username, (LinkedList)localObject2);
          }
          else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).BLy))
          {
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).d(((ax)localObject1).field_username, str2, (LinkedList)localObject2);
          }
          else
          {
            com.tencent.mm.model.bh.beI();
            paramString = com.tencent.mm.model.c.bbL().RG(((ax)localObject1).field_username);
            if (paramString != null) {}
            for (paramString = Util.nullAs(paramString.hDx, "");; paramString = "")
            {
              Log.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { ((ax)localObject1).field_username, str2, paramString });
              if (TextUtils.isEmpty(paramString)) {
                break label2094;
              }
              ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).bqY(paramString);
              ((com.tencent.mm.pluginsdk.ui.applet.a)localObject5).d(((ax)localObject1).field_username, str2, (LinkedList)localObject2);
              break;
            }
            label2094:
            this.GWn.add(((ax)localObject1).field_username);
            az.a.ltq.a(((ax)localObject1).field_username, str2, new az.b.a()
            {
              public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(287251);
                com.tencent.mm.model.bh.beI();
                paramAnonymousString = com.tencent.mm.model.c.bbL().RG(this.jkl.field_username);
                if (paramAnonymousString != null) {}
                for (paramAnonymousString = Util.nullAs(paramAnonymousString.hDx, "");; paramAnonymousString = "")
                {
                  this.GWt.bqY(paramAnonymousString);
                  this.GWt.d(this.jkl.field_username, str2, this.GWv);
                  AppMethodBeat.o(287251);
                  return;
                }
              }
            });
          }
        }
        label2141:
        break;
      }
      str2 = ((MMActivity)localObject4).getIntent().getStringExtra(f.d.VRW);
      if (com.tencent.mm.plugin.messenger.f.a.Ow(l)) {
        com.tencent.mm.plugin.messenger.f.a.Z(l, 3);
      }
      Object localObject5 = ((Activity)localObject4).getIntent().getStringExtra("room_name");
      int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 2);
      int k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWG, 5000);
      localObject2 = SayHiWithSnsPermissionUI.class;
      if ((!as.bvK(((ax)localObject1).field_username)) && (j == 1))
      {
        paramString = SayHiWithSnsPermissionUI2.class;
        label2249:
        paramString = new Intent((Context)localObject4, paramString);
        paramString.putExtra("Contact_User", ((ax)localObject1).field_username);
        paramString.putExtra("Contact_Nick", ((ax)localObject1).field_nickname);
        paramString.putExtra("Contact_RemarkName", ((ax)localObject1).field_conRemark);
        if ((i != 14) && (i != 8)) {
          break label2563;
        }
        paramString.putExtra("Contact_RoomNickname", ((Activity)localObject4).getIntent().getStringExtra("Contact_RoomNickname"));
      }
      for (;;)
      {
        paramString.putExtra("Contact_Scene", i);
        paramString.putExtra("Contact_Source_Add", ((Activity)localObject4).getIntent().getIntExtra("Contact_Source_Add", -1));
        paramString.putExtra("room_name", (String)localObject5);
        paramString.putExtra("source_from_user_name", (String)localObject3);
        paramString.putExtra("source_from_nick_name", str1);
        paramString.putExtra("sayhi_with_sns_perm_send_verify", true);
        paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
        paramString.putExtra("sayhi_with_sns_perm_set_label", false);
        paramString.putExtra(f.d.VRW, str2);
        paramString.putExtra("sayhi_verify_add_errcode", -1);
        paramString.putExtra("key_msg_id", l);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(localObject4, paramString.aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Activity)localObject4).startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject4, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break;
        paramString = (String)localObject2;
        if (as.bvK(((ax)localObject1).field_username)) {
          break label2249;
        }
        paramString = (String)localObject2;
        if (j != 2) {
          break label2249;
        }
        paramString = (String)localObject2;
        if (com.tencent.mm.model.ab.bef() < k) {
          break label2249;
        }
        paramString = SayHiWithSnsPermissionUI3.class;
        break label2249;
        if (i == 17) {
          paramString.putExtra("key_msg_id", ((Activity)localObject4).getIntent().getLongExtra("key_msg_id", 0L));
        }
      }
      label2592:
      if (paramString.equals("contact_profile_accept_contact"))
      {
        localObject2 = this.tmY;
        localObject3 = this.uNk;
        ((MMActivity)localObject2).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 2);
        j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWG, 5000);
        localObject1 = SayHiWithSnsPermissionUI.class;
        if ((!as.bvK(((ax)localObject3).field_username)) && (i == 1)) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject2, paramString);
          paramString.putExtra("Contact_User", ((ax)localObject3).field_username);
          paramString.putExtra("room_name", this.jaK);
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
          paramString.putExtra("sayhi_with_sns_permission", ((as)localObject3).ayi());
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramString.aFh(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramString = (String)localObject1;
          if (!as.bvK(((ax)localObject3).field_username))
          {
            paramString = (String)localObject1;
            if (i == 2)
            {
              paramString = (String)localObject1;
              if (com.tencent.mm.model.ab.bef() >= j) {
                paramString = SayHiWithSnsPermissionUI3.class;
              }
            }
          }
        }
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.uNk;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(f.d.VRW, paramString.hDx);
        b.mIG.a((Intent)localObject1, this.tmY);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.GWl == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.tmY, this.uNk);
        d.a(this.tmY.getIntent(), 6, 1, this.uNk.field_username);
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.mrf.byG("contact_info_invite_source")).getExtras().getString("inviter");
        if (Util.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.iXp, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.jaK);
        com.tencent.mm.model.bh.beI();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.bbL().RG(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.jaK);
        b.mIG.c((Intent)localObject2, this.tmY);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.uNk;
        localObject3 = Util.nullAsNil(this.tmY.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = com.tencent.mm.plugin.profile.ui.q.a(this.tmY, (as)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].lpM;
          paramString = com.tencent.mm.plugin.profile.ui.q.b(this.tmY, (as)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((ax)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.h.aHF().kcd.lCD, new a.14(this));
        break;
      }
      if (paramString.equals("contact_profile_story"))
      {
        paramString = (AbsStoryPreference)this.mrf.byG("contact_profile_story");
        if (paramString == null) {
          break;
        }
        paramString.gbs();
        break;
      }
      if (paramString.equals(FinderPreference.NAME))
      {
        paramString = (FinderPreference)this.mrf.byG(FinderPreference.NAME);
        boolean bool;
        if ((paramString.Rqh != null) && (paramString.Rqh.contact != null))
        {
          localObject2 = paramString.Rqh.contact.username;
          if (!Util.isNullOrNil((String)localObject2))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
            ((Intent)localObject1).putExtra("key_enter_profile_type", 14);
            bool = ((String)localObject2).equals(z.bdh());
            localObject2 = (ak)com.tencent.mm.kernel.h.ag(ak.class);
            if (!bool) {
              break label3741;
            }
          }
        }
        label3741:
        for (i = 33;; i = 32)
        {
          ((ak)localObject2).fillContextIdToIntent(14, 2, i, (Intent)localObject1);
          ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", bool);
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(paramString.mContext, (Intent)localObject1);
          com.tencent.mm.plugin.report.service.h.IzE.p(1585L, 2L, 1L);
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().aFX(this.uNk.field_username);
          d.a(this.tmY.getIntent(), 24, 1, this.uNk.field_username);
          com.tencent.mm.plugin.report.service.h.IzE.a(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
          break;
        }
      }
      if (!paramString.equals("contact_profile_finder_recent_like")) {
        break;
      }
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().c(this.tmY, this.uNk.field_username, this.uNk.field_nickname, 79);
      d.a(this.tmY.getIntent(), 25, 1, this.uNk.field_username);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().aFX(this.uNk.field_username);
      break;
    }
  }
  
  final void b(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    AppMethodBeat.i(290132);
    ezi localezi;
    FinderPreference localFinderPreference;
    if ((paramObject instanceof ezi))
    {
      localezi = (ezi)paramObject;
      localFinderPreference = (FinderPreference)paramf.byG(FinderPreference.NAME);
      if (localezi.contact == null) {
        paramf.dz(FinderPreference.NAME, true);
      }
    }
    for (;;)
    {
      a(paramf, paramObject);
      AppMethodBeat.o(290132);
      return;
      if (!this.GWr) {
        com.tencent.mm.plugin.report.service.h.IzE.a(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      }
      paramf.dz(FinderPreference.NAME, false);
      localFinderPreference.a(localezi);
      this.GWr = true;
      continue;
      paramf.dz(FinderPreference.NAME, true);
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  final void c(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(290134);
    if (((paramObject instanceof ezi)) && (!this.GWk))
    {
      paramObject = (ezi)paramObject;
      if (paramObject.SVT == 1)
      {
        paramf.dz("contact_profile_finder_recent_like", false);
        FinderRecentLikePreference localFinderRecentLikePreference = (FinderRecentLikePreference)paramf.byG("contact_profile_finder_recent_like");
        if (!paramf.byH(FinderPreference.NAME))
        {
          paramf = localObject;
          if (paramObject.SVU != null)
          {
            paramf = localObject;
            if (!Util.isNullOrNil(paramObject.SVU.SGN))
            {
              paramf = new ezj();
              paramf.SGi.addAll(paramObject.SVU.SGN);
            }
          }
          localFinderRecentLikePreference.a(paramf);
          AppMethodBeat.o(290134);
          return;
        }
        localFinderRecentLikePreference.a(null);
        AppMethodBeat.o(290134);
        return;
      }
    }
    paramf.dz("contact_profile_finder_recent_like", true);
    AppMethodBeat.o(290134);
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(26839);
    this.mrf.byG("contact_profile_sns");
    if (p.JPh != null) {
      p.JPh.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.mrf.byG("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.mrf.byG("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.GWq.dead();
    if (this.GWl != null) {
      this.GWl.destroy();
    }
    localObject = this.GWn.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      az.a.ltq.Rr(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void gt(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.mrf.dz("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.mrf.dz("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.mrf, this.uNk, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */