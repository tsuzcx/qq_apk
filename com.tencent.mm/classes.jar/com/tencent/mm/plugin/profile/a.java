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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ay.a;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
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
import com.tencent.mm.plugin.sns.c.i;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
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
  com.tencent.mm.storage.w fql;
  String fss;
  com.tencent.mm.ui.base.preference.f lxI;
  private int mScene;
  MMActivity nqt;
  af oFt;
  private boolean readOnly;
  com.tencent.mm.plugin.profile.a.b uyW;
  private boolean uyX;
  final List<String> uyY;
  private com.tencent.mm.ui.widget.a.e uyZ;
  String uza;
  com.tencent.mm.sdk.b.c<ay> uzb;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.uyY = new LinkedList();
    this.uza = null;
    this.uzb = new com.tencent.mm.sdk.b.c() {};
    this.nqt = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    ad.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.aKk("contact_info_invite_source");
    paramf.cE("contact_info_invite_source", false);
    paramf = new SpannableString(k.c(paramActivity, paramActivity.getResources().getString(2131757692, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.XY(2);
    localKeyValuePreference.Gfe = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (dbP())
    {
      paramf.cE("contact_profile_setting_desc", true);
      paramf.cE("contact_profile_setting_permission", true);
      paramf.cE("contact_profile_phone", true);
      paramf.cE("contact_profile_info_more", true);
      paramf.cE("contact_profile_sns", af.aHH(paramaf.field_username));
      if ((u.aqL() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.q.t(this.nqt, "com.tencent.wework");
        com.tencent.mm.model.az.arV();
        Object localObject = (Integer)com.tencent.mm.model.c.afk().get(ae.a.FgI, Integer.valueOf(0));
        ad.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(u.aqL()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bt.iY(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.q.t(this.nqt, "com.tencent.wework")))) {
          break label325;
        }
        paramf.cE("contact_profile_accept_contact_by_wework", false);
        localObject = p.a(this.nqt, paramaf, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label434;
        }
      }
    }
    label434:
    for (paramaf = p.b(this.nqt, paramaf, this.mScene);; paramaf = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.akA(this.oFt.field_username)) {
        ((ButtonPreference)paramf.aKk("contact_profile_accept_contact_by_wework")).fU(this.nqt.getString(2131757689), this.nqt.getResources().getColor(2131100035));
      }
      if ((!bt.isNullOrNil(paramaf)) && (com.tencent.mm.plugin.profile.b.e.akz(paramaf) == 2) && (paramBoolean)) {
        paramf.cE("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label325:
      if (this.nqt.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramaf = (ButtonPreference)paramf.aKk("contact_profile_accept_contact");
        paramaf.fU(this.nqt.getString(2131755200), this.nqt.getResources().getColor(2131100249));
        paramaf.setEnabled(false);
      }
      paramf.cE("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.cE("contact_profile_accept_contact", true);
      paramf.cE("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(String paramString, af paramaf)
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
    paramString.putExtra("Contact_User", paramaf.field_username);
    paramString.putExtra("Contact_Nick", paramaf.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramaf.field_conRemark);
    b.hYt.n(paramString, this.nqt);
    AppMethodBeat.o(26849);
  }
  
  static String b(com.tencent.mm.storage.w paramw, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramw == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    com.tencent.mm.model.az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHY(paramString);
    Object localObject1 = localObject2;
    if (localaf != null)
    {
      localObject1 = localObject2;
      if ((int)localaf.fId > 0) {
        localObject1 = localaf.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = paramw.sh(paramString);
    }
    paramw = (com.tencent.mm.storage.w)localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      paramw = (com.tencent.mm.storage.w)localObject2;
      if (localaf != null) {
        paramw = localaf.ZW();
      }
    }
    AppMethodBeat.o(26854);
    return paramw;
  }
  
  private boolean dbM()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = com.tencent.mm.model.w.gMw;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.oFt.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = dbN();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean dbN()
  {
    AppMethodBeat.i(26843);
    boolean bool = com.tencent.mm.model.w.tg(this.oFt.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean dbO()
  {
    AppMethodBeat.i(26844);
    boolean bool = af.st(this.oFt.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean dbP()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.n.b.ls(this.oFt.field_type)) && (this.nqt.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean dbQ()
  {
    AppMethodBeat.i(26846);
    if (this.nqt.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean dbR()
  {
    AppMethodBeat.i(26847);
    if (this.nqt.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean dbS()
  {
    AppMethodBeat.i(26848);
    int i = this.nqt.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean dbT()
  {
    return this.oFt.field_deleteFlag == 1;
  }
  
  public final boolean SN(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      com.tencent.mm.model.az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        t.g(this.nqt, null);
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
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.nqt.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.oFt.field_username });
      if (this.nqt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.nqt.getIntent();
        paramString.putExtra("sns_source", this.nqt.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.oFt.signature);
        paramString.putExtra("sns_nickName", this.oFt.ZW());
        paramString.putExtra("sns_title", this.oFt.ZX());
        paramString.putExtra("sns_rpt_scene", c.aA(this.nqt.getIntent()));
        if ((o.wzL == null) || (i == 0)) {
          break label289;
        }
        paramString = o.wzL.f(paramString, this.oFt.field_username);
        if (paramString != null) {
          break label307;
        }
        this.nqt.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.lxI.aKk("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.k.f.wQY.wRk.dSu = paramString.eAu();
        break;
        i = 0;
        break label115;
        label289:
        paramString.putExtra("sns_userName", this.oFt.field_username);
        break label235;
        label307:
        com.tencent.mm.bs.d.b(this.nqt, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.nqt.finish();
        }
      }
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.oFt;
        if (localObject1 == null) {
          ad.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label641;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.nqt.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.oFt.field_username });
          break;
          if (!com.tencent.mm.n.b.ls(((com.tencent.mm.g.c.au)localObject1).field_type))
          {
            if (!bt.isNullOrNil(((com.tencent.mm.g.c.au)localObject1).field_encryptUsername)) {
              a(((com.tencent.mm.g.c.au)localObject1).field_encryptUsername, (af)localObject1);
            } else {
              a(((com.tencent.mm.g.c.au)localObject1).field_username, (af)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.lxI.aKk("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((com.tencent.mm.g.c.au)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.nqt.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).BVY);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((com.tencent.mm.g.c.au)localObject1).evO);
            b.hYt.m((Intent)localObject3, this.nqt);
          }
        }
      }
      else
      {
        label641:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
          localObject1 = this.nqt;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.oFt.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.nqt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.nqt;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.uyW != null) {
            this.uyW.dbX();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.oFt;
            if (bt.a(Boolean.valueOf(com.tencent.mm.model.w.sB(((com.tencent.mm.g.c.au)localObject1).field_username)), false))
            {
              localObject1 = ((com.tencent.mm.g.c.au)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.nqt.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.nqt.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.oFt.field_username });
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.nqt, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.nqt;
              paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.adn(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((com.tencent.mm.g.c.au)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.nqt.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((com.tencent.mm.g.c.au)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.nqt, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.nqt;
                paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.adn(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.oFt;
            localObject1 = new wv();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.nqt.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.oFt.field_username });
            if ((!paramString.field_username.equals(((wv)localObject1).dCl.talker)) && ((((wv)localObject1).dCl.dCn) || (((wv)localObject1).dCl.dCo)))
            {
              if (((wv)localObject1).dCl.dCm) {}
              for (i = 2131756778;; i = 2131756779)
              {
                Toast.makeText(this.nqt, i, 0).show();
                ad.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if (!com.tencent.mm.r.a.cc(this.nqt))
            {
              localObject1 = new vj();
              ((vj)localObject1).dAP.dAR = true;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = ((vj)localObject1).dAQ.dAT;
              if (!bt.isNullOrNil((String)localObject1))
              {
                ad.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.h.d(this.nqt, this.nqt.getString(2131764350), "", this.nqt.getString(2131755835), this.nqt.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(26821);
                    Object localObject = new vj();
                    ((vj)localObject).dAP.dAS = true;
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = new fg();
                    ((fg)localObject).dhF.username = com.tencent.mm.bj.d.hxy.aCm();
                    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                    a.this.a(paramString, a.this.nqt);
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
                a(paramString, this.nqt);
              }
            }
          }
          else
          {
            if (!paramString.equals("contact_profile_add_contact")) {
              break label2258;
            }
            localObject4 = this.nqt;
            localObject1 = this.oFt;
            i = this.mScene;
            if ((i != 17) || (!this.uyX)) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this.nqt, this.nqt.getString(2131762026), "", this.nqt.getString(2131766205), null);
          }
        }
      }
    }
    paramString = (String)localObject1;
    if ((int)((com.tencent.mm.n.b)localObject1).fId == 0)
    {
      com.tencent.mm.model.az.arV();
      paramString = (String)localObject1;
      if (com.tencent.mm.model.c.apM().ag((af)localObject1) != -1)
      {
        com.tencent.mm.model.az.arV();
        paramString = com.tencent.mm.model.c.apM().aHY(((com.tencent.mm.g.c.au)localObject1).field_username);
      }
    }
    Object localObject2 = this.nqt.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.nqt.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    localObject2 = bt.nullAsNil((String)localObject2);
    localObject1 = bt.nullAsNil((String)localObject1);
    if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
    {
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject2);
      if (localObject3 != null) {
        break label3117;
      }
      localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject1);
      localObject2 = localObject1;
    }
    label2212:
    label3117:
    for (localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.nqt, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(26833);
          if (paramAnonymousBoolean1)
          {
            a locala = a.this;
            paramAnonymousString2 = paramString;
            int i = i;
            if (bt.isNullOrNil(paramAnonymousString1))
            {
              ad.w("MicroMsg.NewContactWidgetNormal", "addContact respUsername is empty");
              com.tencent.mm.plugin.report.service.h.vKh.dB(931, 21);
            }
            if ((int)paramAnonymousString2.fId == 0)
            {
              if (!bt.isNullOrNil(paramAnonymousString1)) {
                paramAnonymousString2.setUsername(paramAnonymousString1);
              }
              com.tencent.mm.model.az.arV();
              com.tencent.mm.model.c.apM().ag(paramAnonymousString2);
              com.tencent.mm.model.az.arV();
              com.tencent.mm.model.c.apM().aHY(paramAnonymousString2.field_username);
            }
            if ((int)paramAnonymousString2.fId <= 0)
            {
              ad.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
              AppMethodBeat.o(26833);
              return;
            }
            com.tencent.mm.plugin.report.service.h localh;
            String str;
            if ((!com.tencent.mm.n.b.ls(paramAnonymousString2.field_type)) && (i == 15))
            {
              paramAnonymousString1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramAnonymousString2.field_username);
              if ((paramAnonymousString1 != null) && (!bt.isNullOrNil(paramAnonymousString2.evO)))
              {
                localh = com.tencent.mm.plugin.report.service.h.vKh;
                str = paramAnonymousString2.field_username;
                if (!bt.isNullOrNil(paramAnonymousString1.JS())) {
                  break label311;
                }
              }
            }
            label311:
            for (i = 0;; i = 1)
            {
              localh.f(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(com.tencent.mm.n.a.f(paramAnonymousString2)) });
              com.tencent.mm.model.w.u(paramAnonymousString2);
              locala.lxI.notifyDataSetChanged();
              com.tencent.mm.plugin.account.friend.a.au.ax(paramAnonymousString2.field_encryptUsername, 0);
              paramAnonymousString1 = new pp();
              paramAnonymousString1.dvq.username = paramAnonymousString2.field_encryptUsername;
              paramAnonymousString1.dvq.type = 1;
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString1);
              AppMethodBeat.o(26833);
              return;
            }
          }
          if (paramAnonymousBoolean2)
          {
            com.tencent.mm.bk.d.aCo().fM(paramAnonymousString1, 2);
            com.tencent.mm.plugin.account.friend.a.au.ax(paramString.field_encryptUsername, 1);
            paramAnonymousString1 = new pp();
            paramAnonymousString1.dvq.username = paramString.field_encryptUsername;
            paramAnonymousString1.dvq.type = 1;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString1);
            AppMethodBeat.o(26833);
            return;
          }
          ad.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
          AppMethodBeat.o(26833);
        }
      });
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      final long l = ((MMActivity)localObject4).getIntent().getLongExtra("key_msg_id", 0L);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).kA((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).BXs = new a.b()
      {
        public final boolean at(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(26834);
          String str = this.cNI.getIntent().getStringExtra("room_name");
          int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
          Object localObject = SayHiWithSnsPermissionUI.class;
          if (i == 1)
          {
            localObject = SayHiWithSnsPermissionUI2.class;
            localObject = new Intent(this.cNI, (Class)localObject);
            ((Intent)localObject).putExtra("Contact_User", paramString.field_username);
            ((Intent)localObject).putExtra("Contact_Nick", paramString.field_nickname);
            ((Intent)localObject).putExtra("Contact_RemarkName", paramString.field_conRemark);
            if ((i != 14) && (i != 8)) {
              break label342;
            }
            ((Intent)localObject).putExtra("Contact_RoomNickname", this.cNI.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          for (;;)
          {
            ((Intent)localObject).putExtra("Contact_Scene", i);
            ((Intent)localObject).putExtra("room_name", str);
            ((Intent)localObject).putExtra("source_from_user_name", this.uzi);
            ((Intent)localObject).putExtra("source_from_nick_name", str);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
            ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
            ((Intent)localObject).putExtra(e.c.FHR, paramAnonymousString);
            ((Intent)localObject).putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
            ((Intent)localObject).putExtra("key_msg_id", l);
            paramAnonymousString = this.cNI;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$8", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
              ((Intent)localObject).putExtra("key_msg_id", this.cNI.getIntent().getLongExtra("key_msg_id", 0L));
            }
          }
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.c.FHR);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aBJ((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, "", (LinkedList)localObject3);
      }
      for (;;)
      {
        if (!com.tencent.mm.plugin.messenger.e.a.rs(l)) {
          break label2256;
        }
        com.tencent.mm.plugin.messenger.e.a.K(l, 3);
        break;
        if (TextUtils.isEmpty(str))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aBJ(paramString.evP);
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).i(paramString.field_username, (LinkedList)localObject3);
        }
        else if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).rso))
        {
          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
        }
        else
        {
          com.tencent.mm.model.az.arV();
          localObject1 = com.tencent.mm.model.c.apM().aHY(paramString.field_username);
          if (localObject1 != null) {}
          for (localObject1 = bt.by(((com.tencent.mm.g.c.au)localObject1).evP, "");; localObject1 = "")
          {
            ad.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label2212;
            }
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).aBJ((String)localObject1);
            ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).d(paramString.field_username, str, (LinkedList)localObject3);
            break;
          }
          this.uyY.add(paramString.field_username);
          ar.a.gMW.a(paramString.field_username, str, new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(26835);
              com.tencent.mm.model.az.arV();
              paramAnonymousString = com.tencent.mm.model.c.apM().aHY(paramString.field_username);
              if (paramAnonymousString != null) {}
              for (paramAnonymousString = bt.by(paramAnonymousString.evP, "");; paramAnonymousString = "")
              {
                this.uzk.aBJ(paramAnonymousString);
                this.uzk.d(paramString.field_username, str, this.uzm);
                AppMethodBeat.o(26835);
                return;
              }
            }
          });
        }
      }
      label2256:
      break;
      label2258:
      if (paramString.equals("contact_profile_accept_contact"))
      {
        localObject1 = this.nqt;
        localObject2 = this.oFt;
        ((MMActivity)localObject1).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
        paramString = SayHiWithSnsPermissionUI.class;
        if (i == 1) {
          paramString = SayHiWithSnsPermissionUI2.class;
        }
        for (;;)
        {
          paramString = new Intent((Context)localObject1, paramString);
          paramString.putExtra("Contact_User", ((com.tencent.mm.g.c.au)localObject2).field_username);
          paramString.putExtra("room_name", this.fss);
          paramString.putExtra("Contact_Nick", ((com.tencent.mm.g.c.au)localObject2).field_nickname);
          paramString.putExtra("Contact_RemarkName", ((com.tencent.mm.g.c.au)localObject2).field_conRemark);
          if ((this.mScene == 14) || (this.mScene == 8)) {
            paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject1).getIntent().getStringExtra("Contact_RoomNickname"));
          }
          paramString.putExtra("Contact_Scene", this.mScene);
          paramString.putExtra("Verify_ticket", bt.nullAsNil(((Activity)localObject1).getIntent().getStringExtra("Verify_ticket")));
          paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
          paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
          paramString.putExtra("sayhi_with_sns_perm_set_label", true);
          paramString.putExtra("sayhi_with_sns_permission", ((af)localObject2).ZP());
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.adn(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          if (i == 2) {
            paramString = SayHiWithSnsPermissionUI3.class;
          }
        }
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.oFt;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.c.FHR, paramString.evP);
        b.hYt.a((Intent)localObject1, this.nqt);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.uyW == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.nqt, this.oFt);
        com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(c.aA(this.nqt.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.oFt.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.lxI.aKk("contact_info_invite_source")).getExtras().getString("inviter");
        if (bt.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.fql, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.fss);
        com.tencent.mm.model.az.arV();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.apM().aHY(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fss);
        b.hYt.c((Intent)localObject2, this.nqt);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.oFt;
        localObject3 = bt.nullAsNil(this.nqt.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = p.a(this.nqt, (af)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].gKF;
          paramString = p.b(this.nqt, (af)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((com.tencent.mm.g.c.au)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.afA().gcy.gVH, new com.tencent.mm.al.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(26830);
            paramAnonymousn.setHasCallbackToQueue(true);
            paramAnonymousString = (com.tencent.mm.plugin.profile.b.a)paramAnonymousn;
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              if (paramAnonymousString.uzx == null) {
                paramAnonymousString.uzx = ((axl)paramAnonymousString.rr.gUT.gUX);
              }
              String str = paramAnonymousString.uzx.Dwt;
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
              a.this.nqt.startActivityForResult(paramAnonymousString, 111);
              ad.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
              AppMethodBeat.o(26830);
              return;
            }
            ad.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
            if (paramAnonymousString.uzx == null) {
              paramAnonymousString.uzx = ((axl)paramAnonymousString.rr.gUT.gUX);
            }
            if ((paramAnonymousString.uzx.BaseResponse != null) && (paramAnonymousString.uzx.BaseResponse.ErrMsg != null)) {}
            for (paramAnonymousString = bt.nullAsNil(paramAnonymousString.uzx.BaseResponse.ErrMsg.Ehn);; paramAnonymousString = paramAnonymousString.errMsg)
            {
              paramAnonymousn = paramAnonymousString;
              if (bt.isNullOrNil(paramAnonymousString)) {
                paramAnonymousn = a.this.nqt.getString(2131761817);
              }
              com.tencent.mm.ui.base.h.c(a.this.nqt, paramAnonymousn, a.this.nqt.getString(2131764439), false);
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
      paramString = (AbsStoryPreference)this.lxI.aKk("contact_profile_story");
      if (paramString == null) {
        break;
      }
      paramString.dGb();
      break;
    }
  }
  
  final void a(final af paramaf, final Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.uyZ = new com.tencent.mm.ui.widget.a.e(this.nqt, 1, false);
    this.uyZ.HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(26831);
        paramAnonymousl.aI(2, 2131755762, 2131691164);
        paramAnonymousl.aI(1, 2131755764, 2131691165);
        AppMethodBeat.o(26831);
      }
    };
    this.uyZ.HrY = new n.d()
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
          paramAnonymousMenuItem = paramaf;
          Context localContext = paramContext;
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 82, "", "");
          ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), localContext });
          ww localww;
          if (bool)
          {
            localww = new ww();
            localww.dCp.djq = 5;
            localww.dCp.talker = paramAnonymousMenuItem.field_username;
            localww.dCp.context = localContext;
            localww.dCp.dCj = 4;
            com.tencent.mm.sdk.b.a.ESL.l(localww);
          }
          AppMethodBeat.o(26832);
          return;
          paramAnonymousMenuItem = paramaf;
          localContext = paramContext;
          bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.CAMERA", 19, "", "");
          ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), localContext });
          if (bool)
          {
            bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localContext, "android.permission.RECORD_AUDIO", 19, "", "");
            ad.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.eGN(), localContext });
            if (bool)
            {
              localww = new ww();
              localww.dCp.djq = 5;
              localww.dCp.talker = paramAnonymousMenuItem.field_username;
              localww.dCp.context = localContext;
              localww.dCp.dCj = 2;
              com.tencent.mm.sdk.b.a.ESL.l(localww);
            }
          }
        }
      }
    };
    this.uyZ.csG();
    AppMethodBeat.o(26850);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.lxI.aKk("contact_profile_sns");
    if ((paramString != null) && (o.wzH != null))
    {
      paramString.aCk(this.oFt.field_username);
      com.tencent.mm.plugin.sns.k.f.wQY.wRk.dSu = paramString.eAu();
      if (o.wzL != null) {
        o.wzL.a(this, 3);
      }
      this.lxI.notifyDataSetChanged();
      if (paramb.drJ())
      {
        ad.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (o.wzL != null) {
          o.wzL.anw(this.oFt.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.lxI = paramf;
    this.oFt = paramaf;
    this.mScene = paramInt;
    this.fss = this.nqt.getIntent().getStringExtra("room_name");
    com.tencent.mm.model.az.arV();
    this.fql = com.tencent.mm.model.c.apV().tH(this.fss);
    this.uyX = this.nqt.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.uyW == null)
    {
      this.uyW = new com.tencent.mm.plugin.profile.a.b(this.nqt, paramaf);
      this.uyW.cKF();
    }
    ad.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramaf.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2131951696);
    Object localObject2 = (NormalProfileHeaderPreference)paramf.aKk("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject2).lxI = paramf;
    ((NormalProfileHeaderPreference)localObject2).a(paramaf, paramInt, paramBoolean, this.uyW);
    Object localObject1 = (ButtonPreference)paramf.aKk("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).GdW = 2131298702;
    }
    Object localObject4 = this.nqt;
    Object localObject3 = this.oFt;
    int j;
    if ((af.aHH(((com.tencent.mm.g.c.au)localObject3).field_username)) && (((com.tencent.mm.g.c.au)localObject3).evR != 0))
    {
      j = paramf.indexOf("contact_info_category_1");
      Object localObject5 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((com.tencent.mm.g.c.au)localObject3).field_openImAppid, "openim_custom_info_header", com.tencent.mm.openim.a.b.a.hNA);
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject6 = new PreferenceTitleCategory((Context)localObject4);
        ((Preference)localObject6).setTitle((CharSequence)localObject5);
        paramf.a((Preference)localObject6, j);
        ((Preference)localObject6).GfO = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject5 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject5).Bj(((com.tencent.mm.g.c.au)localObject3).evS);
      localObject5 = ((com.tencent.mm.openim.a.c)localObject5).hND.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = (c.a)((Iterator)localObject5).next();
        Iterator localIterator = ((c.a)localObject6).hNE.iterator();
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
          local2.FNA = ((c.a)localObject6).title;
          local2.XY(2);
          local2.Gfe = false;
          local2.setSummary(k.c((Context)localObject4, localb.Bk(((com.tencent.mm.g.c.au)localObject3).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.Yb(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.GfO = new com.tencent.mm.plugin.profile.a.a.3(localb, (af)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.GfO = new com.tencent.mm.plugin.profile.a.a.4(localb, (af)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.GfO = new com.tencent.mm.plugin.profile.a.a.5(localb, (af)localObject3, (c.a)localObject6);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.GfO = new com.tencent.mm.plugin.profile.a.a.6(localb, (af)localObject3, (c.a)localObject6);
              i = j;
            }
          }
        }
      }
      i = j + 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject4), i);
      localObject5 = new KeyValuePreference((Context)localObject4);
      ((KeyValuePreference)localObject5).setTitle(2131757648);
      Object localObject6 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((com.tencent.mm.g.c.au)localObject3).field_openImAppid, "openim_intro_desc", com.tencent.mm.openim.a.b.a.hNA);
      ((KeyValuePreference)localObject5).setSummary(k.c((Context)localObject4, (CharSequence)localObject6));
      localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(((com.tencent.mm.g.c.au)localObject3).field_openImAppid, "openim_intro_url", com.tencent.mm.openim.a.b.a.hNB);
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((Preference)localObject5).GfO = new com.tencent.mm.plugin.profile.a.a.7((String)localObject4, (af)localObject3, (String)localObject6);
      }
      paramf.a((Preference)localObject5, i + 1);
    }
    if (dbN())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject2);
      paramf.b(new PreferenceSmallCategory(this.nqt));
      paramaf = new KeyValuePreference(this.nqt);
      paramaf.setTitle(2131757694);
      paramaf.setSummary(2131757916);
      paramaf.XY(2147483647);
      paramaf.Gfe = false;
      paramaf.Yb(8);
      paramf.b(paramaf);
      paramf.b(new PreferenceSmallCategory(this.nqt));
      paramf.b((Preference)localObject1);
      this.uyW.nCW.removeAllOptionMenu();
      AppMethodBeat.o(26837);
      return true;
    }
    localObject3 = this.oFt;
    int i = this.nqt.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.nqt.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = bt.by(this.nqt.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new cwh();
    ((cwh)localObject2).ijX = i;
    ((cwh)localObject2).ijZ = l;
    ((cwh)localObject2).ijY = ((String)localObject1);
    localObject1 = localObject2;
    if (o.wzH != null) {
      localObject1 = o.wzH.b(((com.tencent.mm.g.c.au)localObject3).field_username, (cwh)localObject2);
    }
    com.tencent.mm.model.az.arV();
    boolean bool1 = com.tencent.mm.model.c.apM().aHT(((com.tencent.mm.g.c.au)localObject3).field_username);
    boolean bool2 = u.aqG().equals(((com.tencent.mm.g.c.au)localObject3).field_username);
    if ((((cwh)localObject1).ijX & 0x1) > 0)
    {
      paramBoolean = true;
      ad.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((af.aHF(((com.tencent.mm.g.c.au)localObject3).field_username)) || (!paramBoolean)) && (!dbP()) && (!bool2)) {
        break label3310;
      }
      this.lxI.cE("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.lxI.aKk("contact_profile_sns");
      if (o.wzL != null)
      {
        o.wzL.a(3, ((com.tencent.mm.g.c.au)localObject3).field_username, this);
        i = this.nqt.getIntent().getIntExtra("Sns_from_Scene", 0);
        o.wzL.a(2, ((com.tencent.mm.g.c.au)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).aCk(((com.tencent.mm.g.c.au)localObject3).field_username);
      label1272:
      if (af.aHH(((com.tencent.mm.g.c.au)localObject3).field_username)) {
        this.lxI.cE("contact_profile_sns", true);
      }
      localObject2 = paramf.aKk("contact_profile_setting_desc");
      if (!af.aHH(this.oFt.field_username)) {
        break label3326;
      }
      localObject1 = this.nqt.getText(2131757927).toString();
      label1336:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (MultiSummaryPreference)paramf.aKk("contact_profile_setting_permission");
      ((MultiSummaryPreference)localObject1).title = this.nqt.getString(2131761879);
      if (!this.oFt.ZR()) {
        break label3346;
      }
      ((MultiSummaryPreference)localObject1).uCG = new String[] { this.nqt.getString(2131762042) };
      localObject1 = (KeyValuePreference)paramf.aKk("contact_profile_source");
      paramInt = this.nqt.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.nqt, this.oFt, paramInt, this.oFt.field_username, dbP());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).XY(2);
      ((KeyValuePreference)localObject1).Gfe = false;
      ((KeyValuePreference)localObject1).oqc = (com.tencent.mm.cd.a.ar(this.nqt, (int)this.nqt.getResources().getDimension(2131165517)) * com.tencent.mm.cd.a.dT(this.nqt));
      ((KeyValuePreference)localObject1).Yb(8);
      if ((!com.tencent.mm.n.b.ls(paramaf.field_type)) && (!bt.ai((CharSequence)localObject2)) && ((!dbQ()) || (dbP()))) {
        break label3609;
      }
      paramBoolean = true;
      label1555:
      paramf.cE("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.aKk("contact_profile_label");
      ((LabelPreference)localObject1).oFt = paramaf;
      if (!com.tencent.mm.n.b.ls(((LabelPreference)localObject1).oFt.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).oFt.field_encryptUsername;
        if (!bt.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.az.arV();
          ((LabelPreference)localObject1).uTk = com.tencent.mm.model.c.apN().agQ((String)localObject2);
        }
        if ((((LabelPreference)localObject1).uTk != null) && (((LabelPreference)localObject1).uTk.systemRowid < 0L))
        {
          com.tencent.mm.model.az.arV();
          ((LabelPreference)localObject1).uTk = com.tencent.mm.model.c.apN().agQ(((LabelPreference)localObject1).oFt.field_username);
        }
      }
      if ((!com.tencent.mm.n.b.ls(((LabelPreference)localObject1).oFt.field_type)) || (bt.isNullOrNil(((LabelPreference)localObject1).oFt.field_contactLabelIds))) {
        break label3614;
      }
      paramInt = 1;
      label1714:
      if (paramInt != 0) {
        break label3648;
      }
      paramBoolean = true;
      label1721:
      paramf.cE("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.aKk("contact_profile_phone");
      ((PhoneNumPreference)localObject3).lxI = paramf;
      localObject4 = this.nqt.getIntent();
      ((PhoneNumPreference)localObject3).oFt = paramaf;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      ad.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramaf.ZT() });
      if (!paramaf.ZT())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject4))) {
          break label3661;
        }
        if (!bt.isNullOrNil(paramaf.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramaf.field_username);
          localObject4 = paramaf.field_username;
          if (localObject2 != null) {
            break label3653;
          }
          localObject1 = "true";
          label1890:
          ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1917:
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JS())))
        {
          ((PhoneNumPreference)localObject3).BVY = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIA()).replace(" ", "");
          ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramaf.field_username, ((PhoneNumPreference)localObject3).BVY });
        }
        ((PhoneNumPreference)localObject3).eAs();
      }
      ((PhoneNumPreference)localObject3).BVZ = PhoneNumPreference.b(((PhoneNumPreference)localObject3).BVY, paramaf);
      ((PhoneNumPreference)localObject3).lxI.cE("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).eAs();
      ((PhoneNumPreference)localObject3).Yb(8);
      localObject1 = (ProfileDescribePreference)paramf.aKk("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).oFt = paramaf;
      if (!com.tencent.mm.n.b.ls(((ProfileDescribePreference)localObject1).oFt.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).oFt.field_encryptUsername;
        if (!bt.isNullOrNil((String)localObject2))
        {
          com.tencent.mm.model.az.arV();
          ((ProfileDescribePreference)localObject1).uTk = com.tencent.mm.model.c.apN().agQ((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).uTk != null) && (((ProfileDescribePreference)localObject1).uTk.systemRowid < 0L))
        {
          com.tencent.mm.model.az.arV();
          ((ProfileDescribePreference)localObject1).uTk = com.tencent.mm.model.c.apN().agQ(((ProfileDescribePreference)localObject1).oFt.field_username);
        }
      }
      if (com.tencent.mm.n.b.ls(((ProfileDescribePreference)localObject1).oFt.field_type)) {
        break label3803;
      }
      if ((((ProfileDescribePreference)localObject1).uTk == null) || (bt.isNullOrNil(((ProfileDescribePreference)localObject1).uTk.field_conDescription))) {
        break label3797;
      }
      paramInt = 1;
      label2184:
      if (paramInt != 0) {
        break label3857;
      }
      paramBoolean = true;
      label2191:
      paramf.cE("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.n.b.ls(paramaf.field_type)) || (bt.isNullOrNil(paramaf.signature))) {
        break label3862;
      }
      localObject1 = (KeyValuePreference)paramf.aKk("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).oqc = (com.tencent.mm.cd.a.ar(this.nqt, (int)this.nqt.getResources().getDimension(2131165517)) * com.tencent.mm.cd.a.dT(this.nqt));
        ((KeyValuePreference)localObject1).Gfe = false;
        ((KeyValuePreference)localObject1).setTitle(this.nqt.getString(2131757822));
        ((KeyValuePreference)localObject1).setSummary(k.c(this.nqt, paramaf.signature));
        ((KeyValuePreference)localObject1).vR(false);
        ((KeyValuePreference)localObject1).XY(5);
        ((KeyValuePreference)localObject1).Yb(8);
      }
      label2332:
      if ((paramf.aKm("contact_profile_desc") >= 0) || (paramf.aKm("contact_profile_label") >= 0)) {
        break label3875;
      }
      paramf.cE("contact_profile_setting_desc", false);
      label2366:
      if (!com.tencent.mm.n.b.ls(paramaf.field_type)) {
        paramf.cE("contact_profile_setting_desc", false);
      }
      paramf.cE("contact_profile_set_des_category", true);
      if ((!af.aHH(this.oFt.field_username)) || (!bt.isNullOrNil(this.oFt.field_conRemark))) {
        break label3888;
      }
      paramf.cE("contact_profile_setting_desc", false);
      paramf.cE("contact_profile_set_des_category", true);
      label2444:
      if ((this.oFt != null) && (af.aHH(this.oFt.field_username)) && ("3552365301".equals(this.oFt.field_openImAppid))) {
        paramf.cE("contact_profile_setting_permission", true);
      }
      paramf.aKk("contact_profile_info_more").setTitle(this.nqt.getText(2131757735).toString());
      ((TextPreference)paramf.aKk("contact_profile_hint")).al(this.nqt.getText(2131757740));
      if (!paramaf.ZM()) {
        break label3925;
      }
      paramf.cE("contact_profile_hint", false);
      label2559:
      localObject2 = (MultiButtonPreference)paramf.aKk("contact_profile_multi_button");
      if (!dbP())
      {
        if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) || (this.nqt.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2)) {
          break label3939;
        }
        paramInt = 1;
        label2614:
        if (paramInt == 0) {
          break label3960;
        }
      }
      if (!this.oFt.ZM()) {
        break label3945;
      }
      localObject1 = this.nqt.getString(2131757741);
      label2641:
      ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26820);
          a.this.uyW.nV(true);
          AppMethodBeat.o(26820);
        }
      });
      localObject1 = this.nqt.getString(2131756596);
      localObject3 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26828);
          a.this.uyW.dce();
          AppMethodBeat.o(26828);
        }
      };
      ((MultiButtonPreference)localObject2).uCB = ((String)localObject1);
      ((MultiButtonPreference)localObject2).uCE = ((View.OnClickListener)localObject3);
      label2692:
      if ((dbM()) || ((com.tencent.mm.n.b.ls(paramaf.field_type)) && (!paramaf.ZM())) || ((!dbP()) && (dbQ()))) {
        paramf.cE("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!dbP()) && (!dbT()) && (!dbO())) {
        break label4007;
      }
      paramf.cE("contact_profile_send", true);
      paramf.cE("contact_profile_voip", true);
      label2797:
      if ((!com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!dbP()) && (!dbT()) && (!dbS()) && (!dbR()) && (!u.aqG().equals(this.oFt.field_username))) {
        break label4038;
      }
      paramf.cE("contact_profile_add_contact", true);
      label2865:
      a(paramf, paramaf, false);
      if ((dbP()) || (com.tencent.mm.n.b.ls(paramaf.field_type)) || ((!dbO()) && (!dbS()) && (!dbR()))) {
        break label4092;
      }
      paramf.cE("contact_profile_info_more", true);
      paramf.cE("contact_profile_say_hi", false);
      label2931:
      if (u.se(this.oFt.field_username))
      {
        paramf.cE("contact_profile_multi_button", true);
        paramf.cE("contact_profile_info_more", bt.isNullOrNil(paramaf.signature));
        paramf.cE("contact_profile_setting_desc", true);
        paramf.cE("contact_profile_setting_permission", true);
        paramf.cE("contact_profile_voip", true);
        this.uyW.nCW.removeAllOptionMenu();
      }
      localObject1 = this.oFt;
      paramf.cE("contact_info_invite_source", true);
      if (this.fql != null) {
        break label4139;
      }
      paramBoolean = this.nqt.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label3050:
      if ((this.mScene == 14) && (paramBoolean) && (this.fql != null) && (!((com.tencent.mm.g.c.au)localObject1).field_username.equals(this.fql.field_roomowner))) {
        break label4156;
      }
      paramInt = this.mScene;
      if (this.fql != null) {
        break label4150;
      }
      bool1 = true;
      label3104:
      ad.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.cE("contact_info_invite_source", true);
    }
    for (;;)
    {
      this.lxI.cE("contact_profile_story", true);
      com.tencent.mm.model.az.arV();
      paramBoolean = com.tencent.mm.model.c.apM().aHT(paramaf.field_username);
      bool1 = u.aqG().equals(paramaf.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().dGf())
      {
        ad.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!af.aHF(paramaf.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.lxI.aKk("contact_profile_story");
          paramf.onCreate(paramaf.field_username);
          paramf.a(this);
          paramf.dGa();
          paramf.dFZ();
        }
      }
      AppMethodBeat.o(26837);
      return true;
      paramBoolean = false;
      break;
      label3310:
      this.lxI.cE("contact_profile_sns", true);
      break label1272;
      label3326:
      localObject1 = this.nqt.getText(2131757926).toString();
      break label1336;
      label3346:
      paramBoolean = paramaf.ZP();
      bool1 = o.wzJ.akH(paramaf.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxj, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label3511;
        }
        localObject3 = this.nqt;
        if (paramaf.evp == 2)
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
        localObject3 = this.nqt;
        if (paramaf.evp != 2) {
          break label3556;
        }
      }
      label3511:
      label3556:
      for (i = 2131762031;; i = 2131762033)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        ((MultiSummaryPreference)localObject1).uCG = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = 2131762038;
        break label3422;
        localObject3 = this.nqt;
        if (paramaf.evp == 2) {}
        for (i = 2131762037;; i = 2131762039)
        {
          ((List)localObject2).add(((MMActivity)localObject3).getString(i));
          break;
        }
      }
      label3564:
      localObject3 = this.nqt;
      if (paramaf.evp == 2) {}
      for (i = 2131762032;; i = 2131762034)
      {
        ((List)localObject2).add(((MMActivity)localObject3).getString(i));
        break;
      }
      label3609:
      paramBoolean = false;
      break label1555;
      label3614:
      if ((((LabelPreference)localObject1).uTk != null) && (!bt.isNullOrNil(((LabelPreference)localObject1).uTk.field_contactLabels)))
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
      if ((bt.isNullOrNil((String)localObject2)) && (bt.isNullOrNil((String)localObject4))) {
        break label1917;
      }
      ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramaf.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JS())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject4);
      }
      localObject4 = paramaf.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        ad.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label3797:
      paramInt = 0;
      break label2184;
      label3803:
      if (!bt.isNullOrNil(((ProfileDescribePreference)localObject1).oFt.evJ)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((bt.isNullOrNil(((ProfileDescribePreference)localObject1).oFt.evI)) && (paramInt == 0)) {
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
      paramf.aKl("contact_info_signature");
      break label2332;
      label3875:
      paramf.cE("contact_profile_setting_desc", true);
      break label2366;
      label3888:
      if (!af.aHH(this.oFt.field_username)) {
        break label2444;
      }
      paramf.cE("contact_profile_setting_desc", true);
      paramf.cE("contact_profile_set_des_category", true);
      break label2444;
      label3925:
      paramf.cE("contact_profile_hint", true);
      break label2559;
      label3939:
      paramInt = 0;
      break label2614;
      label3945:
      localObject1 = this.nqt.getString(2131757736);
      break label2641;
      label3960:
      if ((!paramaf.ZM()) && (!dbS()) && (!dbR())) {
        break label2692;
      }
      ((MultiButtonPreference)localObject2).a(this.nqt.getString(2131756596), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(26829);
          a.this.uyW.dce();
          AppMethodBeat.o(26829);
        }
      });
      break label2692;
      label4007:
      paramf.cE("contact_profile_send", false);
      paramf.cE("contact_profile_voip", this.oFt.ZM());
      break label2797;
      label4038:
      paramf.cE("contact_profile_add_contact", false);
      paramf.cE("contact_profile_setting_desc", false);
      paramf.cE("contact_profile_setting_permission", true);
      paramf.cE("contact_profile_phone", true);
      paramf.cE("contact_profile_info_more", true);
      break label2865;
      label4092:
      paramf.cE("contact_profile_say_hi", true);
      if (!com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        paramf.cE("contact_profile_info_more", true);
        break label2931;
      }
      paramf.cE("contact_profile_info_more", false);
      break label2931;
      label4139:
      paramBoolean = this.fql.Vq();
      break label3050;
      label4150:
      bool1 = false;
      break label3104;
      label4156:
      this.uza = this.nqt.getIntent().getStringExtra("inviteer");
      if (bt.isNullOrNil(this.uza)) {
        this.uza = this.fql.aHA(((com.tencent.mm.g.c.au)localObject1).field_username);
      }
      if (bt.isNullOrNil(this.uza)) {
        this.uza = com.tencent.mm.model.q.at(((com.tencent.mm.g.c.au)localObject1).field_username, this.fss);
      }
      if (bt.isNullOrNil(this.uza))
      {
        ad.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.fss, ((com.tencent.mm.g.c.au)localObject1).field_username });
        this.uzb.alive();
        this.uyY.add(((com.tencent.mm.g.c.au)localObject1).field_username);
        ar.a.gMW.a(((com.tencent.mm.g.c.au)localObject1).field_username, this.fss, new ar.b.a()
        {
          public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(26823);
            ad.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fss, Boolean.valueOf(paramAnonymousBoolean) });
            a.this.uzb.dead();
            AppMethodBeat.o(26823);
          }
        });
      }
      else
      {
        this.nqt.getIntent().putExtra("inviteer", this.uza);
        localObject2 = b(this.fql, this.uza);
        if (bt.isNullOrNil((String)localObject2))
        {
          this.uyY.add(((com.tencent.mm.g.c.au)localObject1).field_username);
          ar.a.gMW.a(((com.tencent.mm.g.c.au)localObject1).field_username, "", new ar.b.a()
          {
            public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(26824);
              ad.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.this.fss, Boolean.valueOf(paramAnonymousBoolean) });
              if (paramAnonymousBoolean)
              {
                com.tencent.mm.model.az.arV();
                paramAnonymousString = com.tencent.mm.model.c.apM().aHY(paramAnonymousString).ZW();
                a.a(paramf, a.this.nqt, a.this.uza, paramAnonymousString);
              }
              AppMethodBeat.o(26824);
            }
          });
        }
        else
        {
          a(paramf, this.nqt, this.uza, (String)localObject2);
        }
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final boolean bRu()
  {
    AppMethodBeat.i(26839);
    this.lxI.aKk("contact_profile_sns");
    if (o.wzL != null) {
      o.wzL.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.lxI.aKk("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.lxI.aKk("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.uzb.dead();
    if (this.uyW != null) {
      this.uyW.destroy();
    }
    localObject = this.uyY.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ar.a.gMW.tX(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void ev(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.lxI.cE("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    ad.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.lxI.cE("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.lxI, this.oFt, true);
    AppMethodBeat.o(26841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */