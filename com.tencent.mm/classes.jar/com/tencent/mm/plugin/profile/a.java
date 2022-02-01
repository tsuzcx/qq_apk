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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.az.a;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.profile.ui.p;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  x ftP;
  String fvZ;
  com.tencent.mm.ui.base.preference.f lZC;
  private int mScene;
  MMActivity nTt;
  ai piT;
  private boolean readOnly;
  com.tencent.mm.plugin.profile.a.b vHP;
  private boolean vHQ;
  final List<String> vHR;
  private com.tencent.mm.ui.widget.a.e vHS;
  String vHT;
  com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.az> vHU;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.vHR = new LinkedList();
    this.vHT = null;
    this.vHU = new com.tencent.mm.sdk.b.c() {};
    this.nTt = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    ac.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.aPN("contact_info_invite_source");
    paramf.cK("contact_info_invite_source", false);
    paramf = new SpannableString(k.c(paramActivity, paramActivity.getResources().getString(2131757692, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.aaj(2);
    localKeyValuePreference.HET = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (dpx())
    {
      paramf.cK("contact_profile_setting_desc", true);
      paramf.cK("contact_profile_setting_permission", true);
      paramf.cK("contact_profile_phone", true);
      paramf.cK("contact_profile_info_more", true);
      paramf.cK("contact_profile_sns", ai.aNc(paramai.field_username));
      if ((u.axB() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.t(this.nTt, "com.tencent.wework");
        com.tencent.mm.model.az.ayM();
        Object localObject = (Integer)com.tencent.mm.model.c.agA().get(ah.a.GEw, Integer.valueOf(0));
        ac.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(u.axB()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bs.jl(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.t(this.nTt, "com.tencent.wework")))) {
          break label325;
        }
        paramf.cK("contact_profile_accept_contact_by_wework", false);
        localObject = p.a(this.nTt, paramai, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label434;
        }
      }
    }
    label434:
    for (paramai = p.b(this.nTt, paramai, this.mScene);; paramai = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.apz(this.piT.field_username)) {
        ((ButtonPreference)paramf.aPN("contact_profile_accept_contact_by_wework")).fY(this.nTt.getString(2131757689), this.nTt.getResources().getColor(2131100035));
      }
      if ((!bs.isNullOrNil(paramai)) && (com.tencent.mm.plugin.profile.b.e.apy(paramai) == 2) && (paramBoolean)) {
        paramf.cK("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label325:
      if (this.nTt.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramai = (ButtonPreference)paramf.aPN("contact_profile_accept_contact");
        paramai.fY(this.nTt.getString(2131755200), this.nTt.getResources().getColor(2131100249));
        paramai.setEnabled(false);
      }
      paramf.cK("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.cK("contact_profile_accept_contact", true);
      paramf.cK("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(String paramString, ai paramai)
  {
    AppMethodBeat.i(26849);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(26849);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramai.field_username);
    paramString.putExtra("Contact_Nick", paramai.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramai.field_conRemark);
    b.iyx.n(paramString, this.nTt);
    AppMethodBeat.o(26849);
  }
  
  static String b(x paramx, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramx == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    com.tencent.mm.model.az.ayM();
    ai localai = com.tencent.mm.model.c.awB().aNt(paramString);
    Object localObject1 = localObject2;
    if (localai != null)
    {
      localObject1 = localObject2;
      if ((int)localai.fLJ > 0) {
        localObject1 = localai.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      localObject2 = paramx.wk(paramString);
    }
    paramx = (x)localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      paramx = (x)localObject2;
      if (localai != null) {
        paramx = localai.aaR();
      }
    }
    AppMethodBeat.o(26854);
    return paramx;
  }
  
  private boolean dpA()
  {
    AppMethodBeat.i(26848);
    int i = this.nTt.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean dpB()
  {
    return this.piT.field_deleteFlag == 1;
  }
  
  private boolean dpu()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = w.hmW;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.piT.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = dpv();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean dpv()
  {
    AppMethodBeat.i(26843);
    boolean bool = w.xj(this.piT.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean dpw()
  {
    AppMethodBeat.i(26844);
    boolean bool = ai.ww(this.piT.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean dpx()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.n.b.ln(this.piT.field_type)) && (this.nTt.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean dpy()
  {
    AppMethodBeat.i(26846);
    if (this.nTt.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean dpz()
  {
    AppMethodBeat.i(26847);
    if (this.nTt.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  public final boolean WZ(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      com.tencent.mm.model.az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(this.nTt, null);
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
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.nTt.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.piT.field_username });
      if (this.nTt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.nTt.getIntent();
        paramString.putExtra("sns_source", this.nTt.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.piT.signature);
        paramString.putExtra("sns_nickName", this.piT.aaR());
        paramString.putExtra("sns_title", this.piT.aaS());
        paramString.putExtra("sns_rpt_scene", c.aB(this.nTt.getIntent()));
        if ((o.xMf == null) || (i == 0)) {
          break label289;
        }
        paramString = o.xMf.f(paramString, this.piT.field_username);
        if (paramString != null) {
          break label307;
        }
        this.nTt.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.lZC.aPN("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dUi = paramString.ePO();
        break;
        i = 0;
        break label115;
        label289:
        paramString.putExtra("sns_userName", this.piT.field_username);
        break label235;
        label307:
        com.tencent.mm.br.d.b(this.nTt, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.nTt.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.piT;
        if (localObject1 == null) {
          ac.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label641;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.nTt.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.piT.field_username });
          break;
          if (!com.tencent.mm.n.b.ln(((av)localObject1).field_type))
          {
            if (!bs.isNullOrNil(((av)localObject1).field_encryptUsername)) {
              a(((av)localObject1).field_encryptUsername, (ai)localObject1);
            } else {
              a(((av)localObject1).field_username, (ai)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.lZC.aPN("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((av)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.nTt.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).Dop);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((av)localObject1).eyl);
            b.iyx.m((Intent)localObject3, this.nTt);
          }
        }
      }
      else
      {
        label641:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
          localObject1 = this.nTt;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.piT.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.nTt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.nTt;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.vHP != null) {
            this.vHP.dpF();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.piT;
            if (bs.a(Boolean.valueOf(w.wE(((av)localObject1).field_username)), false))
            {
              localObject1 = ((av)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.nTt.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.nTt.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.piT.field_username });
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.nTt, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.nTt;
              paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.aeD(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((av)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.nTt.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((av)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.nTt, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.nTt;
                paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.aeD(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.piT;
            localObject1 = new xg();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.nTt.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.piT.field_username });
            if ((!paramString.field_username.equals(((xg)localObject1).dzZ.talker)) && ((((xg)localObject1).dzZ.cYX) || (((xg)localObject1).dzZ.cYY)))
            {
              if (((xg)localObject1).dzZ.dAa) {}
              for (i = 2131756778;; i = 2131756779)
              {
                Toast.makeText(this.nTt, i, 0).show();
                ac.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.r.a.cf(this.nTt)) && (!com.tencent.mm.r.a.ck(this.nTt)))
            {
              localObject1 = new vt();
              ((vt)localObject1).dyB.dyD = true;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = ((vt)localObject1).dyC.dyF;
              if (!bs.isNullOrNil((String)localObject1))
              {
                ac.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.h.d(this.nTt, this.nTt.getString(2131764350), "", this.nTt.getString(2131755835), this.nTt.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26821);
                    Object localObject = new vt();
                    ((vt)localObject).dyB.dyE = true;
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = new fh();
                    ((fh)localObject).dfa.username = com.tencent.mm.bi.d.hXZ.aJc();
                    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                    a.this.a(paramString, a.this.nTt);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(26821);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26822);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(26822);
                  }
                });
              }
              else
              {
                a(paramString, this.nTt);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2268;
            }
            localObject4 = this.nTt;
            localObject1 = this.piT;
            i = this.mScene;
            if ((i != 17) || (!this.vHQ)) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this.nTt, this.nTt.getString(2131762026), "", this.nTt.getString(2131766205), null);
          }
        }
      }
    }
    paramString = (String)localObject1;
    if ((int)((com.tencent.mm.n.b)localObject1).fLJ == 0)
    {
      com.tencent.mm.model.az.ayM();
      paramString = (String)localObject1;
      if (com.tencent.mm.model.c.awB().ah((ai)localObject1) != -1)
      {
        com.tencent.mm.model.az.ayM();
        paramString = com.tencent.mm.model.c.awB().aNt(((av)localObject1).field_username);
      }
    }
    Object localObject2 = this.nTt.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.nTt.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = bs.nullAsNil((String)localObject2);
    localObject1 = bs.nullAsNil((String)localObject1);
    if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject2);
      if (localObject3 != null) {
        break label3127;
      }
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject1);
      localObject2 = localObject1;
    }
    label2222:
    label3127:
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.nTt, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(26833);
          if (paramAnonymousBoolean1)
          {
            a locala = a.this;
            paramAnonymousString2 = paramString;
            int i = i;
            if (bs.isNullOrNil(paramAnonymousString1))
            {
              ac.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
              com.tencent.mm.plugin.report.service.h.wUl.dB(931, 21);
            }
            if ((int)paramAnonymousString2.fLJ == 0)
            {
              if (!bs.isNullOrNil(paramAnonymousString1)) {
                paramAnonymousString2.setUsername(paramAnonymousString1);
              }
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awB().ah(paramAnonymousString2);
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awB().aNt(paramAnonymousString2.field_username);
            }
            if ((int)paramAnonymousString2.fLJ <= 0)
            {
              ac.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
              AppMethodBeat.o(26833);
              return;
            }
            com.tencent.mm.plugin.report.service.h localh;
            String str;
            if ((!com.tencent.mm.n.b.ln(paramAnonymousString2.field_type)) && (i == 15))
            {
              paramAnonymousString1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramAnonymousString2.field_username);
              if ((paramAnonymousString1 != null) && (!bs.isNullOrNil(paramAnonymousString2.eyl)))
              {
                localh = com.tencent.mm.plugin.report.service.h.wUl;
                str = paramAnonymousString2.field_username;
                if (!bs.isNullOrNil(paramAnonymousString1.JC())) {
                  break label311;
                }
              }
            }
            label311:
            for (i = 0;; i = 1)
            {
              localh.f(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.n.a.f(paramAnonymousString2)) });
              w.u(paramAnonymousString2);
              locala.lZC.notifyDataSetChanged();
              au.aB(paramAnonymousString2.field_encryptUsername, 0);
              paramAnonymousString1 = new py();
              paramAnonymousString1.dtc.username = paramAnonymousString2.field_encryptUsername;
              paramAnonymousString1.dtc.type = 1;
              com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString1);
              AppMethodBeat.o(26833);
              return;
            }
          }
          if (paramAnonymousBoolean2)
          {
            com.tencent.mm.bj.d.aJe().fQ(paramAnonymousString1, 2);
            au.aB(paramString.field_encryptUsername, 1);
            paramAnonymousString1 = new py();
            paramAnonymousString1.dtc.username = paramString.field_encryptUsername;
            paramAnonymousString1.dtc.type = 1;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString1);
            AppMethodBeat.o(26833);
            return;
          }
          ac.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
          AppMethodBeat.o(26833);
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).kX((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).DpJ = new a.b()
      {
        public final boolean ax(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(26834);
          String str = this.cLd.getIntent().getStringExtra("room_name");
          int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
          Object localObject = SayHiWithSnsPermissionUI.class;
          if (i == 1)
          {
            localObject = SayHiWithSnsPermissionUI2.class;
            localObject = new Intent(this.cLd, (Class)localObject);
            ((Intent)localObject).putExtra("Contact_User", paramString.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramString.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramString.field_conRemark);
            if ((i != 14) && (i != 8)) {
              break label342;
            }
            ((Intent)localObject).putExtra("Contact_RoomNickname", this.cLd.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("Contact_Scene", i);
            ((Intent)localObject).putExtra("room_name", str);
            ((Intent)localObject).putExtra("source_from_user_name", this.vIb);
            ((Intent)localObject).putExtra("source_from_nick_name", str);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
            ((Intent)localObject).putExtra(e.c.HgZ, paramAnonymousString);
            ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
            ((Intent)localObject).putExtra("key_msg_id", l);
            paramAnonymousString = this.cLd;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$8", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$8", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(26834);
            return true;
            if (i != 2) {
              break;
            }
            localObject = SayHiWithSnsPermissionUI3.class;
            break;
            label342:
            if (i == 17) {
              ((Intent)localObject).putExtra("key_msg_id", this.cLd.getIntent().getLongExtra("key_msg_id", 0L));
            }
          }
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.c.HgZ);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aHb((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, "", (LinkedList)localObject3);
      }
      for (;;)
      {
        if (!com.tencent.mm.plugin.messenger.e.a.vV(l)) {
          break label2266;
        }
        com.tencent.mm.plugin.messenger.e.a.N(l, 3);
        break;
        if (TextUtils.isEmpty(str))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aHb(paramString.eym);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).i(paramString.field_username, (LinkedList)localObject3);
        }
        else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).sBi))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
        }
        else
        {
          com.tencent.mm.model.az.ayM();
          localObject1 = com.tencent.mm.model.c.awB().aNt(paramString.field_username);
          if (localObject1 != null) {}
          for (localObject1 = bs.bG(((av)localObject1).eym, "");; localObject1 = "")
          {
            ac.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2222;
            }
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aHb((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
            break;
          }
          this.vHR.add(paramString.field_username);
          ar.a.hnw.a(paramString.field_username, str, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(26835);
              com.tencent.mm.model.az.ayM();
              paramAnonymousString = com.tencent.mm.model.c.awB().aNt(paramString.field_username);
              if (paramAnonymousString != null) {}
              for (paramAnonymousString = bs.bG(paramAnonymousString.eym, "");; paramAnonymousString = "")
              {
                this.vId.aHb(paramAnonymousString);
                this.vId.d(paramString.field_username, str, this.vIf);
                AppMethodBeat.o(26835);
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
        localObject1 = this.nTt;
        localObject2 = this.piT;
        ((MMActivity)localObject1).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
        paramString = SayHiWithSnsPermissionUI.class;
        if (i == 1) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject1, paramString);
          paramString.putExtra("Contact_User", ((av)localObject2).field_username);
          paramString.putExtra("room_name", this.fvZ);
          paramString.putExtra("Contact_Nick", ((av)localObject2).field_nickname);
          paramString.putExtra("Contact_RemarkName", ((av)localObject2).field_conRemark);
          if ((this.mScene == 14) || (this.mScene == 8)) {
            paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject1).getIntent().getStringExtra("Contact_RoomNickname"));
          }
          paramString.putExtra("Contact_Scene", this.mScene);
          paramString.putExtra("Verify_ticket", bs.nullAsNil(((Activity)localObject1).getIntent().getStringExtra("Verify_ticket")));
          paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
          paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
          paramString.putExtra("sayhi_with_sns_perm_set_label", true);
          paramString.putExtra("sayhi_with_sns_permission", ((ai)localObject2).aaK());
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.aeD(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          if (i == 2) {
            paramString = SayHiWithSnsPermissionUI3.class;
          }
        }
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.piT;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.c.HgZ, paramString.eym);
        b.iyx.a((Intent)localObject1, this.nTt);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.vHP == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.nTt, this.piT);
        com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(c.aB(this.nTt.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.piT.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.lZC.aPN("contact_info_invite_source")).getExtras().getString("inviter");
        if (bs.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.ftP, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fvZ);
        com.tencent.mm.model.az.ayM();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.awB().aNt(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fvZ);
        b.iyx.c((Intent)localObject2, this.nTt);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.piT;
        localObject3 = bs.nullAsNil(this.nTt.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = p.a(this.nTt, (ai)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].hlf;
          paramString = p.b(this.nTt, (ai)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((av)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.agQ().ghe.hwg, new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(26830);
            paramAnonymousn.setHasCallbackToQueue(true);
            paramAnonymousString = (com.tencent.mm.plugin.profile.b.a)paramAnonymousn;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              if (paramAnonymousString.vIq == null) {
                paramAnonymousString.vIq = ((bbd)paramAnonymousString.rr.hvs.hvw);
              }
              String str = paramAnonymousString.vIq.ERO;
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
                  ac.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramAnonymousn.getMessage() });
                }
              }
              paramAnonymousString = new Intent("android.intent.action.VIEW", paramAnonymousString);
              a.this.nTt.startActivityForResult(paramAnonymousString, 111);
              ac.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
              AppMethodBeat.o(26830);
              return;
            }
            ac.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (paramAnonymousString.vIq == null) {
              paramAnonymousString.vIq = ((bbd)paramAnonymousString.rr.hvs.hvw);
            }
            if ((paramAnonymousString.vIq.BaseResponse != null) && (paramAnonymousString.vIq.BaseResponse.ErrMsg != null)) {}
            for (paramAnonymousString = bs.nullAsNil(paramAnonymousString.vIq.BaseResponse.ErrMsg.FEm);; paramAnonymousString = paramAnonymousString.errMsg)
            {
              paramAnonymousn = paramAnonymousString;
              if (bs.isNullOrNil(paramAnonymousString)) {
                paramAnonymousn = a.this.nTt.getString(2131761817);
              }
              com.tencent.mm.ui.base.h.c(a.this.nTt, paramAnonymousn, a.this.nTt.getString(2131764439), false);
              AppMethodBeat.o(26830);
              return;
            }
          }
        });
        break;
      }
      if (!paramString.equals("contact_profile_story")) {
        break;
      }
      paramString = (AbsStoryPreference)this.lZC.aPN("contact_profile_story");
      if (paramString == null) {
        break;
      }
      paramString.dUC();
      break;
    }
  }
  
  final void a(final ai paramai, final Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.vHS = new com.tencent.mm.ui.widget.a.e(this.nTt, 1, false);
    this.vHS.ISu = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(26831);
        paramAnonymousl.aJ(2, 2131755762, 2131691164);
        paramAnonymousl.aJ(1, 2131755764, 2131691165);
        AppMethodBeat.o(26831);
      }
    };
    this.vHS.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(26832);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(26832);
          return;
          paramAnonymousMenuItem = paramai;
          Context localContext = paramContext;
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
          ac.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), localContext });
          xh localxh;
          if (bool)
          {
            localxh = new xh();
            localxh.dAb.dgL = 5;
            localxh.dAb.talker = paramAnonymousMenuItem.field_username;
            localxh.dAb.context = localContext;
            localxh.dAb.dzX = 4;
            com.tencent.mm.sdk.b.a.GpY.l(localxh);
          }
          AppMethodBeat.o(26832);
          return;
          paramAnonymousMenuItem = paramai;
          localContext = paramContext;
          bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
          ac.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), localContext });
          if (bool)
          {
            bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
            ac.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), localContext });
            if (bool)
            {
              localxh = new xh();
              localxh.dAb.dgL = 5;
              localxh.dAb.talker = paramAnonymousMenuItem.field_username;
              localxh.dAb.context = localContext;
              localxh.dAb.dzX = 2;
              com.tencent.mm.sdk.b.a.GpY.l(localxh);
            }
          }
        }
      }
    };
    this.vHS.cED();
    AppMethodBeat.o(26850);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.lZC.aPN("contact_profile_sns");
    if ((paramString != null) && (o.xMb != null))
    {
      paramString.aHC(this.piT.field_username);
      com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dUi = paramString.ePO();
      if (o.xMf != null) {
        o.xMf.a(this, 3);
      }
      this.lZC.notifyDataSetChanged();
      if (paramb.dGi())
      {
        ac.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (o.xMf != null) {
          o.xMf.asI(this.piT.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.lZC = paramf;
    this.piT = paramai;
    this.mScene = paramInt;
    this.fvZ = this.nTt.getIntent().getStringExtra("room_name");
    com.tencent.mm.model.az.ayM();
    this.ftP = com.tencent.mm.model.c.awK().xN(this.fvZ);
    this.vHQ = this.nTt.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.vHP == null)
    {
      this.vHP = new com.tencent.mm.plugin.profile.a.b(this.nTt, paramai);
      this.vHP.cYk();
    }
    ac.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramai.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2131951696);
    Object localObject2 = (NormalProfileHeaderPreference)paramf.aPN("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject2).lZC = paramf;
    ((NormalProfileHeaderPreference)localObject2).a(paramai, paramInt, paramBoolean, this.vHP);
    Object localObject1 = (ButtonPreference)paramf.aPN("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).HDL = 2131298702;
    }
    Object localObject4 = this.nTt;
    Object localObject3 = this.piT;
    int j;
    if ((ai.aNc(((av)localObject3).field_username)) && (((av)localObject3).eyo != 0))
    {
      j = paramf.indexOf("contact_info_category_1");
      Object localObject5 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((av)localObject3).field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.b.a.inW);
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject6 = new PreferenceTitleCategory((Context)localObject4);
        ((Preference)localObject6).setTitle((CharSequence)localObject5);
        paramf.a((Preference)localObject6, j);
        ((Preference)localObject6).HFD = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject5 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject5).Fo(((av)localObject3).eyp);
      localObject5 = ((com.tencent.mm.openim.a.c)localObject5).inZ.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = (c.a)((Iterator)localObject5).next();
        Iterator localIterator = ((c.a)localObject6).ioa.iterator();
        i = j;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          c.b localb = (c.b)localIterator.next();
          j = i + 1;
          com.tencent.mm.plugin.profile.a.a.2 local2 = new com.tencent.mm.plugin.profile.a.a.2((Context)localObject4, localb);
          local2.Hnl = ((c.a)localObject6).title;
          local2.aaj(2);
          local2.HET = false;
          local2.setSummary(k.c((Context)localObject4, localb.Fp(((av)localObject3).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.aam(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.HFD = new com.tencent.mm.plugin.profile.a.a.3(localb, (ai)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.HFD = new com.tencent.mm.plugin.profile.a.a.4(localb, (ai)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.HFD = new com.tencent.mm.plugin.profile.a.a.5(localb, (ai)localObject3, (c.a)localObject6);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.HFD = new com.tencent.mm.plugin.profile.a.a.6(localb, (ai)localObject3, (c.a)localObject6);
              i = j;
            }
          }
        }
      }
      i = j + 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject4), i);
      localObject5 = new KeyValuePreference((Context)localObject4);
      ((KeyValuePreference)localObject5).setTitle(2131757648);
      Object localObject6 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((av)localObject3).field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.b.a.inW);
      ((KeyValuePreference)localObject5).setSummary(k.c((Context)localObject4, (CharSequence)localObject6));
      localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((av)localObject3).field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.b.a.inX);
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((Preference)localObject5).HFD = new com.tencent.mm.plugin.profile.a.a.7((String)localObject4, (ai)localObject3, (String)localObject6);
      }
      paramf.a((Preference)localObject5, i + 1);
    }
    if (dpv())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject2);
      paramf.b(new PreferenceSmallCategory(this.nTt));
      paramai = new KeyValuePreference(this.nTt);
      paramai.setTitle(2131757694);
      paramai.setSummary(2131757916);
      paramai.aaj(2147483647);
      paramai.HET = false;
      paramai.aam(8);
      paramf.b(paramai);
      paramf.b(new PreferenceSmallCategory(this.nTt));
      paramf.b((Preference)localObject1);
      this.vHP.ofX.removeAllOptionMenu();
      AppMethodBeat.o(26837);
      return true;
    }
    localObject3 = this.piT;
    int i = this.nTt.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.nTt.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = bs.bG(this.nTt.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new dbt();
    ((dbt)localObject2).iKe = i;
    ((dbt)localObject2).iKg = l;
    ((dbt)localObject2).iKf = ((String)localObject1);
    localObject1 = localObject2;
    if (o.xMb != null) {
      localObject1 = o.xMb.b(((av)localObject3).field_username, (dbt)localObject2);
    }
    com.tencent.mm.model.az.ayM();
    boolean bool1 = com.tencent.mm.model.c.awB().aNo(((av)localObject3).field_username);
    boolean bool2 = u.axw().equals(((av)localObject3).field_username);
    if ((((dbt)localObject1).iKe & 0x1) > 0)
    {
      paramBoolean = true;
      ac.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((ai.aNa(((av)localObject3).field_username)) || (!paramBoolean)) && (!dpx()) && (!bool2)) {
        break label3310;
      }
      this.lZC.cK("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.lZC.aPN("contact_profile_sns");
      if (o.xMf != null)
      {
        o.xMf.a(3, ((av)localObject3).field_username, this);
        i = this.nTt.getIntent().getIntExtra("Sns_from_Scene", 0);
        o.xMf.a(2, ((av)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).aHC(((av)localObject3).field_username);
      label1272:
      if (ai.aNc(((av)localObject3).field_username)) {
        this.lZC.cK("contact_profile_sns", true);
      }
      localObject2 = paramf.aPN("contact_profile_setting_desc");
      if (!ai.aNc(this.piT.field_username)) {
        break label3326;
      }
      localObject1 = this.nTt.getText(2131757927).toString();
      label1336:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.aPN("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.nTt.getString(2131761879);
      if (!this.piT.aaM()) {
        break label3346;
      }
      ((MultiSummaryPreference)localObject1).vLz = new String[] { this.nTt.getString(2131762042) };
      localObject1 = (KeyValuePreference)paramf.aPN("contact_profile_source");
      paramInt = this.nTt.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.nTt, this.piT, paramInt, this.piT.field_username, dpx());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).aaj(2);
      ((KeyValuePreference)localObject1).HET = false;
      ((KeyValuePreference)localObject1).oTC = (com.tencent.mm.cc.a.ax(this.nTt, (int)this.nTt.getResources().getDimension(2131165517)) * com.tencent.mm.cc.a.eb(this.nTt));
      ((KeyValuePreference)localObject1).aam(8);
      if ((!com.tencent.mm.n.b.ln(paramai.field_type)) && (!bs.aj((CharSequence)localObject2)) && ((!dpy()) || (dpx()))) {
        break label3609;
      }
      paramBoolean = true;
      label1555:
      paramf.cK("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.aPN("contact_profile_label");
      ((LabelPreference)localObject1).piT = paramai;
      if (!com.tencent.mm.n.b.ln(((LabelPreference)localObject1).piT.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).piT.field_encryptUsername;
        if (!bs.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.az.ayM();
          ((LabelPreference)localObject1).wbZ = com.tencent.mm.model.c.awC().alK((String)localObject2);
        }
        if ((((LabelPreference)localObject1).wbZ != null) && (((LabelPreference)localObject1).wbZ.systemRowid < 0L))
        {
          com.tencent.mm.model.az.ayM();
          ((LabelPreference)localObject1).wbZ = com.tencent.mm.model.c.awC().alK(((LabelPreference)localObject1).piT.field_username);
        }
      }
      if ((!com.tencent.mm.n.b.ln(((LabelPreference)localObject1).piT.field_type)) || (bs.isNullOrNil(((LabelPreference)localObject1).piT.field_contactLabelIds))) {
        break label3614;
      }
      paramInt = 1;
      label1714:
      if (paramInt != 0) {
        break label3648;
      }
      paramBoolean = true;
      label1721:
      paramf.cK("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.aPN("contact_profile_phone");
      ((PhoneNumPreference)localObject3).lZC = paramf;
      localObject4 = this.nTt.getIntent();
      ((PhoneNumPreference)localObject3).piT = paramai;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      ac.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramai.aaO() });
      if (!paramai.aaO())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!bs.isNullOrNil((String)localObject2)) || (!bs.isNullOrNil((String)localObject4))) {
          break label3661;
        }
        if (!bs.isNullOrNil(paramai.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramai.field_username);
          localObject4 = paramai.field_username;
          if (localObject2 != null) {
            break label3653;
          }
          localObject1 = "true";
          label1890:
          ac.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1917:
        if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JC())))
        {
          ((PhoneNumPreference)localObject3).Dop = bs.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPr()).replace(" ", "");
          ac.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramai.field_username, ((PhoneNumPreference)localObject3).Dop });
        }
        ((PhoneNumPreference)localObject3).ePM();
      }
      ((PhoneNumPreference)localObject3).Doq = PhoneNumPreference.b(((PhoneNumPreference)localObject3).Dop, paramai);
      ((PhoneNumPreference)localObject3).lZC.cK("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).ePM();
      ((PhoneNumPreference)localObject3).aam(8);
      localObject1 = (ProfileDescribePreference)paramf.aPN("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).piT = paramai;
      if (!com.tencent.mm.n.b.ln(((ProfileDescribePreference)localObject1).piT.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).piT.field_encryptUsername;
        if (!bs.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.az.ayM();
          ((ProfileDescribePreference)localObject1).wbZ = com.tencent.mm.model.c.awC().alK((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).wbZ != null) && (((ProfileDescribePreference)localObject1).wbZ.systemRowid < 0L))
        {
          com.tencent.mm.model.az.ayM();
          ((ProfileDescribePreference)localObject1).wbZ = com.tencent.mm.model.c.awC().alK(((ProfileDescribePreference)localObject1).piT.field_username);
        }
      }
      if (com.tencent.mm.n.b.ln(((ProfileDescribePreference)localObject1).piT.field_type)) {
        break label3803;
      }
      if ((((ProfileDescribePreference)localObject1).wbZ == null) || (bs.isNullOrNil(((ProfileDescribePreference)localObject1).wbZ.field_conDescription))) {
        break label3797;
      }
      paramInt = 1;
      label2184:
      if (paramInt != 0) {
        break label3857;
      }
      paramBoolean = true;
      label2191:
      paramf.cK("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.n.b.ln(paramai.field_type)) || (bs.isNullOrNil(paramai.signature))) {
        break label3862;
      }
      localObject1 = (KeyValuePreference)paramf.aPN("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).oTC = (com.tencent.mm.cc.a.ax(this.nTt, (int)this.nTt.getResources().getDimension(2131165517)) * com.tencent.mm.cc.a.eb(this.nTt));
        ((KeyValuePreference)localObject1).HET = false;
        ((KeyValuePreference)localObject1).setTitle(this.nTt.getString(2131757822));
        ((KeyValuePreference)localObject1).setSummary(k.c(this.nTt, paramai.signature));
        ((KeyValuePreference)localObject1).wV(false);
        ((KeyValuePreference)localObject1).aaj(5);
        ((KeyValuePreference)localObject1).aam(8);
      }
      label2332:
      if ((paramf.aPP("contact_profile_desc") >= 0) || (paramf.aPP("contact_profile_label") >= 0)) {
        break label3875;
      }
      paramf.cK("contact_profile_setting_desc", false);
      label2366:
      if (!com.tencent.mm.n.b.ln(paramai.field_type)) {
        paramf.cK("contact_profile_setting_desc", false);
      }
      paramf.cK("contact_profile_set_des_category", true);
      if ((!ai.aNc(this.piT.field_username)) || (!bs.isNullOrNil(this.piT.field_conRemark))) {
        break label3888;
      }
      paramf.cK("contact_profile_setting_desc", false);
      paramf.cK("contact_profile_set_des_category", true);
      label2444:
      if ((this.piT != null) && (ai.aNc(this.piT.field_username)) && ("3552365301".equals(this.piT.field_openImAppid))) {
        paramf.cK("contact_profile_setting_permission", true);
      }
      paramf.aPN("contact_profile_info_more").setTitle(this.nTt.getText(2131757735).toString());
      ((TextPreference)paramf.aPN("contact_profile_hint")).am(this.nTt.getText(2131757740));
      if (!paramai.aaH()) {
        break label3925;
      }
      paramf.cK("contact_profile_hint", false);
      label2559:
      localObject2 = (MultiButtonPreference)paramf.aPN("contact_profile_multi_button");
      if (!dpx())
      {
        if ((com.tencent.mm.n.b.ln(this.piT.field_type)) || (this.nTt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2)) {
          break label3939;
        }
        paramInt = 1;
        label2614:
        if (paramInt == 0) {
          break label3960;
        }
      }
      if (!this.piT.aaH()) {
        break label3945;
      }
      localObject1 = this.nTt.getString(2131757741);
      label2641:
      ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26820);
          a.this.vHP.oP(true);
          AppMethodBeat.o(26820);
        }
      });
      localObject1 = this.nTt.getString(2131756596);
      localObject3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26828);
          a.this.vHP.dpM();
          AppMethodBeat.o(26828);
        }
      };
      ((MultiButtonPreference)localObject2).vLu = ((String)localObject1);
      ((MultiButtonPreference)localObject2).vLx = ((View.OnClickListener)localObject3);
      label2692:
      if ((dpu()) || ((com.tencent.mm.n.b.ln(paramai.field_type)) && (!paramai.aaH())) || ((!dpx()) && (dpy()))) {
        paramf.cK("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.n.b.ln(this.piT.field_type)) && (!dpx()) && (!dpB()) && (!dpw())) {
        break label4007;
      }
      paramf.cK("contact_profile_send", true);
      paramf.cK("contact_profile_voip", true);
      label2797:
      if ((!com.tencent.mm.n.b.ln(this.piT.field_type)) && (!dpx()) && (!dpB()) && (!dpA()) && (!dpz()) && (!u.axw().equals(this.piT.field_username))) {
        break label4038;
      }
      paramf.cK("contact_profile_add_contact", true);
      label2865:
      a(paramf, paramai, false);
      if ((dpx()) || (com.tencent.mm.n.b.ln(paramai.field_type)) || ((!dpw()) && (!dpA()) && (!dpz()))) {
        break label4092;
      }
      paramf.cK("contact_profile_info_more", true);
      paramf.cK("contact_profile_say_hi", false);
      label2931:
      if (u.wh(this.piT.field_username))
      {
        paramf.cK("contact_profile_multi_button", true);
        paramf.cK("contact_profile_info_more", bs.isNullOrNil(paramai.signature));
        paramf.cK("contact_profile_setting_desc", true);
        paramf.cK("contact_profile_setting_permission", true);
        paramf.cK("contact_profile_voip", true);
        this.vHP.ofX.removeAllOptionMenu();
      }
      localObject1 = this.piT;
      paramf.cK("contact_info_invite_source", true);
      if (this.ftP != null) {
        break label4139;
      }
      paramBoolean = this.nTt.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label3050:
      if ((this.mScene == 14) && (paramBoolean) && (this.ftP != null) && (!((av)localObject1).field_username.equals(this.ftP.field_roomowner))) {
        break label4156;
      }
      paramInt = this.mScene;
      if (this.ftP != null) {
        break label4150;
      }
      bool1 = true;
      label3104:
      ac.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.cK("contact_info_invite_source", true);
    }
    for (;;)
    {
      this.lZC.cK("contact_profile_story", true);
      com.tencent.mm.model.az.ayM();
      paramBoolean = com.tencent.mm.model.c.awB().aNo(paramai.field_username);
      bool1 = u.axw().equals(paramai.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().dUG())
      {
        ac.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!ai.aNa(paramai.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.lZC.aPN("contact_profile_story");
          paramf.onCreate(paramai.field_username);
          paramf.a(this);
          paramf.dUB();
          paramf.dUA();
        }
      }
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3310:
      this.lZC.cK("contact_profile_sns", true);
      break label1272;
      label3326:
      localObject1 = this.nTt.getText(2131757926).toString();
      break label1336;
      label3346:
      paramBoolean = paramai.aaK();
      bool1 = o.xMd.apG(paramai.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbC, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3511;
        }
        localObject3 = this.nTt;
        if (paramai.exL == 2)
        {
          i = 2131762036;
          label3422:
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        }
      }
      else if (bool1)
      {
        if (j != 0) {
          break label3564;
        }
        localObject3 = this.nTt;
        if (paramai.exL != 2) {
          break label3556;
        }
      }
      label3511:
      label3556:
      for (i = 2131762031;; i = 2131762033)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).vLz = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = 2131762038;
        break label3422;
        localObject3 = this.nTt;
        if (paramai.exL == 2) {}
        for (i = 2131762037;; i = 2131762039)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3564:
      localObject3 = this.nTt;
      if (paramai.exL == 2) {}
      for (i = 2131762032;; i = 2131762034)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3609:
      paramBoolean = false;
      break label1555;
      label3614:
      if ((((LabelPreference)localObject1).wbZ != null) && (!bs.isNullOrNil(((LabelPreference)localObject1).wbZ.field_contactLabels)))
      {
        paramInt = 1;
        break label1714;
      }
      paramInt = 0;
      break label1714;
      label3648:
      paramBoolean = false;
      break label1721;
      label3653:
      localObject1 = "false";
      break label1890;
      label3661:
      if ((bs.isNullOrNil((String)localObject2)) && (bs.isNullOrNil((String)localObject4))) {
        break label1917;
      }
      ac.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramai.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JC())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject4);
      }
      localObject4 = paramai.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        ac.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label3797:
      paramInt = 0;
      break label2184;
      label3803:
      if (!bs.isNullOrNil(((ProfileDescribePreference)localObject1).piT.eyg)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((bs.isNullOrNil(((ProfileDescribePreference)localObject1).piT.eyf)) && (paramInt == 0)) {
          break label3851;
        }
        paramInt = 1;
        break;
      }
      label3851:
      paramInt = 0;
      break label2184;
      label3857:
      paramBoolean = false;
      break label2191;
      label3862:
      paramf.aPO("contact_info_signature");
      break label2332;
      label3875:
      paramf.cK("contact_profile_setting_desc", true);
      break label2366;
      label3888:
      if (!ai.aNc(this.piT.field_username)) {
        break label2444;
      }
      paramf.cK("contact_profile_setting_desc", true);
      paramf.cK("contact_profile_set_des_category", true);
      break label2444;
      label3925:
      paramf.cK("contact_profile_hint", true);
      break label2559;
      label3939:
      paramInt = 0;
      break label2614;
      label3945:
      localObject1 = this.nTt.getString(2131757736);
      break label2641;
      label3960:
      if ((!paramai.aaH()) && (!dpA()) && (!dpz())) {
        break label2692;
      }
      ((MultiButtonPreference)localObject2).a(this.nTt.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26829);
          a.this.vHP.dpM();
          AppMethodBeat.o(26829);
        }
      });
      break label2692;
      label4007:
      paramf.cK("contact_profile_send", false);
      paramf.cK("contact_profile_voip", this.piT.aaH());
      break label2797;
      label4038:
      paramf.cK("contact_profile_add_contact", false);
      paramf.cK("contact_profile_setting_desc", false);
      paramf.cK("contact_profile_setting_permission", true);
      paramf.cK("contact_profile_phone", true);
      paramf.cK("contact_profile_info_more", true);
      break label2865;
      label4092:
      paramf.cK("contact_profile_say_hi", true);
      if (!com.tencent.mm.n.b.ln(paramai.field_type))
      {
        paramf.cK("contact_profile_info_more", true);
        break label2931;
      }
      paramf.cK("contact_profile_info_more", false);
      break label2931;
      label4139:
      paramBoolean = this.ftP.Wp();
      break label3050;
      label4150:
      bool1 = false;
      break label3104;
      label4156:
      this.vHT = this.nTt.getIntent().getStringExtra("inviteer");
      if (bs.isNullOrNil(this.vHT)) {
        this.vHT = this.ftP.aMV(((av)localObject1).field_username);
      }
      if (bs.isNullOrNil(this.vHT)) {
        this.vHT = com.tencent.mm.model.q.aB(((av)localObject1).field_username, this.fvZ);
      }
      if (bs.isNullOrNil(this.vHT))
      {
        ac.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.fvZ, ((av)localObject1).field_username });
        this.vHU.alive();
        this.vHR.add(((av)localObject1).field_username);
        ar.a.hnw.a(((av)localObject1).field_username, this.fvZ, new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(26823);
            ac.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fvZ, Boolean.valueOf(paramAnonymousBoolean) });
            a.this.vHU.dead();
            AppMethodBeat.o(26823);
          }
        });
      }
      else
      {
        this.nTt.getIntent().putExtra("inviteer", this.vHT);
        localObject2 = b(this.ftP, this.vHT);
        if (bs.isNullOrNil((String)localObject2))
        {
          this.vHR.add(((av)localObject1).field_username);
          ar.a.hnw.a(((av)localObject1).field_username, "", new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(26824);
              ac.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fvZ, Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.model.az.ayM();
                paramAnonymousString = com.tencent.mm.model.c.awB().aNt(paramAnonymousString).aaR();
                a.a(paramf, a.this.nTt, a.this.vHT, paramAnonymousString);
              }
              AppMethodBeat.o(26824);
            }
          });
        }
        else
        {
          a(paramf, this.nTt, this.vHT, (String)localObject2);
        }
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(26839);
    this.lZC.aPN("contact_profile_sns");
    if (o.xMf != null) {
      o.xMf.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.lZC.aPN("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.lZC.aPN("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.vHU.dead();
    if (this.vHP != null) {
      this.vHP.destroy();
    }
    localObject = this.vHR.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ar.a.hnw.yd(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void ez(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.lZC.cK("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    ac.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.lZC.cK("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.lZC, this.piT, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */