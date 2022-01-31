package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.e.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements h.a, com.tencent.mm.plugin.story.api.d, com.tencent.mm.pluginsdk.b.a
{
  u efi;
  String egF;
  com.tencent.mm.ui.base.preference.f iLA;
  MMActivity jpX;
  ad lpe;
  private int mScene;
  com.tencent.mm.plugin.profile.a.b pxo;
  private com.tencent.mm.ui.widget.b.d pxp;
  String pxq;
  com.tencent.mm.sdk.b.c<au> pxr;
  private boolean readOnly;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(23220);
    this.readOnly = false;
    this.pxq = null;
    this.pxr = new a.6(this);
    this.jpX = paramMMActivity;
    AppMethodBeat.o(23220);
  }
  
  static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23237);
    ab.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.atx("contact_info_invite_source");
    paramf.cl("contact_info_invite_source", false);
    paramf = new SpannableString(j.b(paramActivity, paramActivity.getResources().getString(2131298631, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(2131689778)), 0, paramString2.length(), 33);
    localKeyValuePreference.OT(2);
    localKeyValuePreference.zrr = false;
    localKeyValuePreference.setSummary(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(23237);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(23222);
    boolean bool1;
    if (cbA())
    {
      paramf.cl("contact_profile_setting_desc", true);
      paramf.cl("contact_profile_phone", true);
      paramf.cl("contact_profile_info_more", true);
      paramf.cl("contact_profile_sns", ad.arf(paramad.field_username));
      if ((r.Zs() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = com.tencent.mm.pluginsdk.model.app.p.u(this.jpX, "com.tencent.wework");
        aw.aaz();
        Object localObject = (Integer)com.tencent.mm.model.c.Ru().get(ac.a.yyn, Integer.valueOf(0));
        ab.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(r.Zs()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bo.hl(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!com.tencent.mm.pluginsdk.model.app.p.u(this.jpX, "com.tencent.wework")) || (ad.arf(this.lpe.field_username)))) {
          break label321;
        }
        paramf.cl("contact_profile_accept_contact_by_wework", false);
        localObject = com.tencent.mm.plugin.profile.ui.p.a(this.jpX, paramad, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label427;
        }
      }
    }
    label427:
    for (paramad = com.tencent.mm.plugin.profile.ui.p.b(this.jpX, paramad, this.mScene);; paramad = "")
    {
      if (com.tencent.mm.plugin.profile.b.e.WZ(this.lpe.field_username)) {
        ((ButtonPreference)paramf.atx("contact_profile_accept_contact_by_wework")).eM(this.jpX.getString(2131298628), this.jpX.getResources().getColor(2131689778));
      }
      if ((!bo.isNullOrNil(paramad)) && (com.tencent.mm.plugin.profile.b.e.WY(paramad) == 2) && (paramBoolean)) {
        paramf.cl("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(23222);
      return;
      bool1 = false;
      break;
      label321:
      if (this.jpX.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramad = (ButtonPreference)paramf.atx("contact_profile_accept_contact");
        paramad.eM(this.jpX.getString(2131296468), this.jpX.getResources().getColor(2131689963));
        paramad.setEnabled(false);
      }
      paramf.cl("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(23222);
      return;
      paramf.cl("contact_profile_accept_contact", true);
      paramf.cl("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(23222);
      return;
    }
  }
  
  private void a(String paramString, ad paramad)
  {
    AppMethodBeat.i(23233);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(23233);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramad.field_username);
    paramString.putExtra("Contact_Nick", paramad.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramad.field_conRemark);
    b.gmO.n(paramString, this.jpX);
    AppMethodBeat.o(23233);
  }
  
  static String b(u paramu, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(23238);
    if (paramu == null)
    {
      AppMethodBeat.o(23238);
      return null;
    }
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(paramString);
    Object localObject1 = localObject2;
    if (localad != null)
    {
      localObject1 = localObject2;
      if ((int)localad.euF > 0) {
        localObject1 = localad.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1)) {
      localObject2 = paramu.nE(paramString);
    }
    paramu = (u)localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      paramu = (u)localObject2;
      if (localad != null) {
        paramu = localad.Oe();
      }
    }
    AppMethodBeat.o(23238);
    return paramu;
  }
  
  private boolean cbA()
  {
    AppMethodBeat.i(23229);
    if ((!com.tencent.mm.n.a.je(this.lpe.field_type)) && (this.jpX.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(23229);
      return true;
    }
    AppMethodBeat.o(23229);
    return false;
  }
  
  private boolean cbB()
  {
    AppMethodBeat.i(23230);
    if (this.jpX.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(23230);
      return true;
    }
    AppMethodBeat.o(23230);
    return false;
  }
  
  private boolean cbC()
  {
    AppMethodBeat.i(23231);
    if (this.jpX.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(23231);
      return true;
    }
    AppMethodBeat.o(23231);
    return false;
  }
  
  private boolean cbD()
  {
    AppMethodBeat.i(23232);
    int i = this.jpX.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(23232);
      return true;
    }
    AppMethodBeat.o(23232);
    return false;
  }
  
  private boolean cbE()
  {
    return this.lpe.field_deleteFlag == 1;
  }
  
  private boolean cbx()
  {
    AppMethodBeat.i(23226);
    String[] arrayOfString = com.tencent.mm.model.t.fll;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.lpe.field_username))
      {
        AppMethodBeat.o(23226);
        return true;
      }
      i += 1;
    }
    boolean bool = cby();
    AppMethodBeat.o(23226);
    return bool;
  }
  
  private boolean cby()
  {
    AppMethodBeat.i(23227);
    boolean bool = com.tencent.mm.model.t.ow(this.lpe.field_username);
    AppMethodBeat.o(23227);
    return bool;
  }
  
  private boolean cbz()
  {
    AppMethodBeat.i(23228);
    boolean bool = ad.nM(this.lpe.field_username);
    AppMethodBeat.o(23228);
    return bool;
  }
  
  public final boolean Ke(final String paramString)
  {
    AppMethodBeat.i(23224);
    if (paramString.equals("contact_profile_sns"))
    {
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        com.tencent.mm.ui.base.t.ii(this.jpX);
      }
    }
    final int i;
    label114:
    label253:
    Object localObject2;
    label235:
    Object localObject3;
    for (;;)
    {
      AppMethodBeat.o(23224);
      return true;
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.jpX.getIntent())), Integer.valueOf(3), Integer.valueOf(1), this.lpe.field_username });
      if (this.jpX.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        paramString = this.jpX.getIntent();
        paramString.putExtra("sns_source", this.jpX.getIntent().getIntExtra("Sns_from_Scene", 0));
        paramString.putExtra("sns_signature", this.lpe.signature);
        paramString.putExtra("sns_nickName", this.lpe.Oe());
        paramString.putExtra("sns_title", this.lpe.Of());
        if ((com.tencent.mm.plugin.sns.b.n.raV == null) || (i == 0)) {
          break label235;
        }
        paramString = com.tencent.mm.plugin.sns.b.n.raV.e(paramString, this.lpe.field_username);
      }
      for (;;)
      {
        if (paramString != null) {
          break label253;
        }
        this.jpX.finish();
        break;
        i = 0;
        break label114;
        paramString.putExtra("sns_userName", this.lpe.field_username);
      }
      com.tencent.mm.bq.d.b(this.jpX, "sns", ".ui.SnsUserUI", paramString);
      if ((paramString.getFlags() & 0x4000000) != 0)
      {
        this.jpX.finish();
        continue;
        if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
        {
          localObject1 = this.lpe;
          if (localObject1 == null) {
            ab.e("MicroMsg.NewContactWidgetNormal", "contact is null");
          }
          for (;;)
          {
            if (!paramString.equals("contact_profile_setting_desc")) {
              break label577;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.jpX.getIntent())), Integer.valueOf(2), Integer.valueOf(1), this.lpe.field_username });
            break;
            if (!com.tencent.mm.n.a.je(((aq)localObject1).field_type))
            {
              if (!bo.isNullOrNil(((aq)localObject1).field_encryptUsername)) {
                a(((aq)localObject1).field_encryptUsername, (ad)localObject1);
              } else {
                a(((aq)localObject1).field_username, (ad)localObject1);
              }
            }
            else
            {
              localObject2 = (PhoneNumPreference)this.iLA.atx("contact_profile_phone");
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
              ((Intent)localObject3).putExtra("Contact_User", ((aq)localObject1).field_username);
              ((Intent)localObject3).putExtra("Contact_RoomNickname", this.jpX.getIntent().getStringExtra("Contact_RoomNickname"));
              ((Intent)localObject3).putExtra("view_mode", true);
              ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).vRr);
              ((Intent)localObject3).putExtra("contact_phone_number_list", ((aq)localObject1).dqZ);
              b.gmO.m((Intent)localObject3, this.jpX);
            }
          }
        }
        else
        {
          label577:
          if (paramString.equals("contact_profile_power"))
          {
            if (this.pxo != null) {
              this.pxo.cbI();
            }
          }
          else
          {
            if (paramString.equals("contact_profile_send"))
            {
              paramString = this.lpe;
              if (bo.a(Boolean.valueOf(com.tencent.mm.model.t.nR(paramString.field_username)), false))
              {
                paramString = paramString.field_username;
                localObject1 = new Intent();
                ((Intent)localObject1).addFlags(67108864);
                if (this.readOnly)
                {
                  ((Intent)localObject1).putExtra("Chat_User", paramString);
                  ((Intent)localObject1).putExtra("Chat_Mode", 1);
                  this.jpX.setResult(-1, (Intent)localObject1);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.jpX.getIntent())), Integer.valueOf(4), Integer.valueOf(1), this.lpe.field_username });
                break;
                ((Intent)localObject1).putExtra("Chat_User", paramString);
                ((Intent)localObject1).putExtra("Chat_Mode", 1);
                ((Intent)localObject1).setClassName(this.jpX, "com.tencent.mm.ui.chatting.ChattingUI");
                this.jpX.startActivity((Intent)localObject1);
                continue;
                localObject1 = new Intent();
                ((Intent)localObject1).addFlags(67108864);
                if (this.readOnly)
                {
                  ((Intent)localObject1).putExtra("Chat_User", paramString.field_username);
                  ((Intent)localObject1).putExtra("Chat_Mode", 1);
                  this.jpX.setResult(-1, (Intent)localObject1);
                }
                else
                {
                  ((Intent)localObject1).putExtra("Chat_User", paramString.field_username);
                  ((Intent)localObject1).putExtra("Chat_Mode", 1);
                  ((Intent)localObject1).setClassName(this.jpX, "com.tencent.mm.ui.chatting.ChattingUI");
                  this.jpX.startActivity((Intent)localObject1);
                }
              }
            }
            if (!paramString.equals("contact_profile_voip")) {
              break;
            }
            paramString = this.lpe;
            localObject1 = new uw();
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.jpX.getIntent())), Integer.valueOf(5), Integer.valueOf(1), this.lpe.field_username });
            if ((!paramString.field_username.equals(((uw)localObject1).cLo.talker)) && ((((uw)localObject1).cLo.cLq) || (((uw)localObject1).cLo.cLr)))
            {
              if (((uw)localObject1).cLo.cLp) {}
              for (i = 2131297846;; i = 2131297847)
              {
                Toast.makeText(this.jpX, i, 0).show();
                ab.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if (!com.tencent.mm.r.a.bM(this.jpX))
            {
              localObject1 = new tl();
              ((tl)localObject1).cJT.cJV = true;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
              localObject1 = ((tl)localObject1).cJU.cJX;
              if (!bo.isNullOrNil((String)localObject1))
              {
                ab.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.h.d(this.jpX, this.jpX.getString(2131304232), "", this.jpX.getString(2131297018), this.jpX.getString(2131296888), new DialogInterface.OnClickListener()new a.3
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(23204);
                    Object localObject = new tl();
                    ((tl)localObject).cJT.cJW = true;
                    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
                    localObject = new fa();
                    ((fa)localObject).csJ.username = com.tencent.mm.bh.d.fUP.alg();
                    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
                    a.this.a(paramString, a.this.jpX);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(23204);
                  }
                }, new a.3(this));
              }
              else
              {
                a(paramString, this.jpX);
              }
            }
          }
        }
      }
    }
    Object localObject4;
    if (paramString.equals("contact_profile_add_contact"))
    {
      localObject4 = this.jpX;
      localObject1 = this.lpe;
      i = this.mScene;
      paramString = (String)localObject1;
      if ((int)((com.tencent.mm.n.a)localObject1).euF == 0)
      {
        aw.aaz();
        paramString = (String)localObject1;
        if (com.tencent.mm.model.c.YA().Z((ad)localObject1) != -1)
        {
          aw.aaz();
          paramString = com.tencent.mm.model.c.YA().arw(((aq)localObject1).field_username);
        }
      }
      localObject2 = this.jpX.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject1 = this.jpX.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      localObject2 = bo.nullAsNil((String)localObject2);
      localObject1 = bo.nullAsNil((String)localObject1);
      if ((!((String)localObject2).equals("")) || (!((String)localObject1).equals("")))
      {
        localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject2);
        if (localObject3 != null) {
          break label2445;
        }
        localObject3 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject1);
        localObject2 = localObject1;
      }
    }
    label1674:
    label2445:
    for (Object localObject1 = localObject3;; localObject1 = localObject3)
    {
      if (localObject1 != null) {
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a((String)localObject2, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
      }
      localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.jpX, new a.12(this, paramString, i));
      localObject3 = new LinkedList();
      ((LinkedList)localObject3).add(Integer.valueOf(i));
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_user_name");
      final String str = ((MMActivity)localObject4).getIntent().getStringExtra("source_from_nick_name");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).hU((String)localObject1, str);
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).vSN = new a.b()
      {
        public final boolean wU(String paramAnonymousString)
        {
          AppMethodBeat.i(23218);
          String str = this.cae.getIntent().getStringExtra("room_name");
          Intent localIntent = new Intent(this.cae, SayHiWithSnsPermissionUI.class);
          localIntent.putExtra("Contact_User", paramString.field_username);
          localIntent.putExtra("Contact_Nick", paramString.field_nickname);
          localIntent.putExtra("Contact_RemarkName", paramString.field_conRemark);
          if ((i == 14) || (i == 8)) {
            localIntent.putExtra("Contact_RoomNickname", this.cae.getIntent().getStringExtra("Contact_RoomNickname"));
          }
          localIntent.putExtra("Contact_Scene", i);
          localIntent.putExtra("room_name", str);
          localIntent.putExtra("source_from_user_name", this.pxy);
          localIntent.putExtra("source_from_nick_name", str);
          localIntent.putExtra("sayhi_with_sns_perm_send_verify", true);
          localIntent.putExtra("sayhi_with_sns_perm_add_remark", true);
          localIntent.putExtra("sayhi_with_sns_perm_set_label", false);
          localIntent.putExtra(e.b.yUZ, paramAnonymousString);
          this.cae.startActivity(localIntent);
          AppMethodBeat.o(23218);
          return true;
        }
      };
      str = ((MMActivity)localObject4).getIntent().getStringExtra("room_name");
      localObject1 = ((MMActivity)localObject4).getIntent().getStringExtra(e.b.yUZ);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).amg((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).c(paramString.field_username, "", (LinkedList)localObject3);
        break;
      }
      if (TextUtils.isEmpty(str))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).amg(paramString.dra);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).e(paramString.field_username, (LinkedList)localObject3);
        break;
      }
      if (!TextUtils.isEmpty(((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).mVw))
      {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).c(paramString.field_username, str, (LinkedList)localObject3);
        break;
      }
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YA().arw(paramString.field_username);
      if (localObject1 != null) {}
      for (localObject1 = bo.bf(((aq)localObject1).dra, "");; localObject1 = "")
      {
        ab.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramString.field_username, str, localObject1 });
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1674;
        }
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).amg((String)localObject1);
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).c(paramString.field_username, str, (LinkedList)localObject3);
        break;
      }
      ao.a.flI.a(paramString.field_username, str, new a.14(this, paramString, (com.tencent.mm.pluginsdk.ui.applet.a)localObject2, str, (LinkedList)localObject3));
      break;
      if (paramString.equals("contact_profile_accept_contact"))
      {
        paramString = this.jpX;
        localObject1 = this.lpe;
        ((MMActivity)paramString).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        localObject2 = new Intent(paramString, SayHiWithSnsPermissionUI.class);
        ((Intent)localObject2).putExtra("Contact_User", ((aq)localObject1).field_username);
        ((Intent)localObject2).putExtra("room_name", this.egF);
        ((Intent)localObject2).putExtra("Contact_Nick", ((aq)localObject1).field_nickname);
        ((Intent)localObject2).putExtra("Contact_RemarkName", ((aq)localObject1).field_conRemark);
        if ((this.mScene == 14) || (this.mScene == 8)) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", ((MMActivity)paramString).getIntent().getStringExtra("Contact_RoomNickname"));
        }
        ((Intent)localObject2).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject2).putExtra("Verify_ticket", bo.nullAsNil(((Activity)paramString).getIntent().getStringExtra("Verify_ticket")));
        ((Intent)localObject2).putExtra("sayhi_with_sns_perm_send_verify", false);
        ((Intent)localObject2).putExtra("sayhi_with_sns_perm_add_remark", true);
        ((Intent)localObject2).putExtra("sayhi_with_sns_perm_set_label", true);
        ((Intent)localObject2).putExtra("sayhi_with_sns_permission", ((ad)localObject1).NZ());
        paramString.startActivity((Intent)localObject2);
        break;
      }
      if (paramString.equals("contact_profile_say_hi"))
      {
        paramString = this.lpe;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
        ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
        ((Intent)localObject1).putExtra(e.b.yUZ, paramString.dra);
        b.gmO.a((Intent)localObject1, this.jpX);
        break;
      }
      if (paramString.equals("contact_profile_info_more"))
      {
        if (this.pxo == null) {
          break;
        }
        com.tencent.mm.plugin.profile.a.b.a(this.jpX, this.lpe);
        com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(this.jpX.getIntent())), Integer.valueOf(6), Integer.valueOf(1), this.lpe.field_username });
        break;
      }
      if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.iLA.atx("contact_info_invite_source")).getExtras().getString("inviter");
        if (bo.isNullOrNil(paramString)) {
          break;
        }
        localObject1 = b(this.efi, paramString);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Contact_User", paramString);
        ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
        ((Intent)localObject2).putExtra("Contact_RoomMember", true);
        ((Intent)localObject2).putExtra("room_name", this.egF);
        aw.aaz();
        ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.YA().arw(paramString).field_nickname);
        ((Intent)localObject2).putExtra("Contact_Scene", 14);
        ((Intent)localObject2).putExtra("Is_RoomOwner", true);
        ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.egF);
        b.gmO.c((Intent)localObject2, this.jpX);
        break;
      }
      if (paramString.equals("contact_profile_accept_contact_by_wework"))
      {
        localObject2 = this.lpe;
        localObject3 = bo.nullAsNil(this.jpX.getIntent().getStringExtra("Verify_ticket"));
        localObject4 = com.tencent.mm.plugin.profile.ui.p.a(this.jpX, (ad)localObject2, this.mScene);
        localObject1 = "";
        paramString = "";
        if (localObject4.length > 0)
        {
          localObject1 = localObject4[(localObject4.length - 1)].fjL;
          paramString = com.tencent.mm.plugin.profile.ui.p.b(this.jpX, (ad)localObject2, this.mScene);
        }
        new com.tencent.mm.plugin.profile.b.a(((aq)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.g.RK().eHt.ftA, new a.9(this));
        break;
      }
      if (!paramString.equals("contact_profile_story")) {
        break;
      }
      paramString = (AbsStoryPreference)this.iLA.atx("contact_profile_story");
      if (paramString == null) {
        break;
      }
      paramString.czm();
      break;
    }
  }
  
  final void a(ad paramad, Context paramContext)
  {
    AppMethodBeat.i(23234);
    this.pxp = new com.tencent.mm.ui.widget.b.d(this.jpX, 1, false);
    this.pxp.sao = new a.10(this);
    this.pxp.sap = new a.11(this, paramad, paramContext);
    this.pxp.crd();
    AppMethodBeat.o(23234);
  }
  
  public final void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong, String paramString2) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong, String paramString2)
  {
    AppMethodBeat.i(23235);
    paramString1 = (com.tencent.mm.ui.base.preference.g)this.iLA.atx("contact_profile_sns");
    if ((paramString1 != null) && (com.tencent.mm.plugin.sns.b.n.raR != null))
    {
      paramString1.amx(this.lpe.field_username);
      if (com.tencent.mm.plugin.sns.b.n.raV != null) {
        com.tencent.mm.plugin.sns.b.n.raV.a(this, 3);
      }
      this.iLA.notifyDataSetChanged();
      if (paramBoolean3)
      {
        ab.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (com.tencent.mm.plugin.sns.b.n.raV != null) {
          com.tencent.mm.plugin.sns.b.n.raV.Zw(this.lpe.field_username);
        }
      }
    }
    AppMethodBeat.o(23235);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(23221);
    this.readOnly = this.readOnly;
    this.iLA = paramf;
    this.lpe = paramad;
    this.mScene = paramInt;
    this.egF = this.jpX.getIntent().getStringExtra("room_name");
    aw.aaz();
    this.efi = com.tencent.mm.model.c.YJ().oU(this.egF);
    if (this.pxo == null)
    {
      this.pxo = new com.tencent.mm.plugin.profile.a.b(this.jpX, paramad);
      this.pxo.bMz();
    }
    ab.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramad.field_username });
    paramf.removeAll();
    paramf.addPreferencesFromResource(2131165253);
    Object localObject2 = (NormalProfileHeaderPreference)paramf.atx("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject2).iLA = paramf;
    ((NormalProfileHeaderPreference)localObject2).a(paramad, paramInt, paramBoolean, this.pxo);
    Object localObject1 = (ButtonPreference)paramf.atx("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).zqv = 2131823211;
    }
    Object localObject4 = this.jpX;
    Object localObject3 = this.lpe;
    if ((ad.arf(((aq)localObject3).field_username)) && (((aq)localObject3).drd != 0))
    {
      int j = paramf.indexOf("contact_info_category_1");
      Object localObject5 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(((aq)localObject3).field_openImAppid, "openim_custom_info_header", b.a.gfD);
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject6 = new PreferenceTitleCategory((Context)localObject4);
        ((Preference)localObject6).setTitle((CharSequence)localObject5);
        paramf.a((Preference)localObject6, j);
        ((Preference)localObject6).zsc = new com.tencent.mm.plugin.profile.a.a.1();
      }
      localObject5 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject5).wl(((aq)localObject3).dre);
      localObject5 = ((com.tencent.mm.openim.a.c)localObject5).gfG.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = (c.a)((Iterator)localObject5).next();
        Iterator localIterator = ((c.a)localObject6).gfH.iterator();
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
          local2.zaD = ((c.a)localObject6).title;
          local2.setSummary(j.b((Context)localObject4, localb.wm(((aq)localObject3).field_openImAppid)));
          paramf.a(local2, j);
          if ((localb.action == 0) || (localb.action == 1))
          {
            local2.setEnabled(true);
            local2.OW(8);
            i = j;
          }
          else if (localb.action == 2)
          {
            local2.zsc = new com.tencent.mm.plugin.profile.a.a.3(localb, (ad)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 3)
          {
            local2.zsc = new com.tencent.mm.plugin.profile.a.a.4(localb, (ad)localObject3, (c.a)localObject6, (Context)localObject4);
            i = j;
          }
          else if (localb.action == 4)
          {
            local2.zsc = new com.tencent.mm.plugin.profile.a.a.5(localb, (ad)localObject3, (c.a)localObject6);
            i = j;
          }
          else
          {
            i = j;
            if (localb.action == 5)
            {
              local2.zsc = new com.tencent.mm.plugin.profile.a.a.6(localb, (ad)localObject3, (c.a)localObject6);
              i = j;
            }
          }
        }
      }
      i = j + 1;
      paramf.a(new PreferenceSmallCategory((Context)localObject4), i);
      localObject5 = new KeyValuePreference((Context)localObject4);
      ((KeyValuePreference)localObject5).setTitle(2131298589);
      Object localObject6 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(((aq)localObject3).field_openImAppid, "openim_intro_desc", b.a.gfD);
      ((KeyValuePreference)localObject5).setSummary(j.b((Context)localObject4, (CharSequence)localObject6));
      localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).c(((aq)localObject3).field_openImAppid, "openim_intro_url", b.a.gfE);
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((Preference)localObject5).zsc = new com.tencent.mm.plugin.profile.a.a.7((String)localObject4, (ad)localObject3, (String)localObject6);
      }
      paramf.a((Preference)localObject5, i + 1);
    }
    if (cby())
    {
      paramf.removeAll();
      paramf.b((Preference)localObject2);
      paramf.b(new PreferenceSmallCategory(this.jpX));
      paramad = new KeyValuePreference(this.jpX);
      paramad.setTitle(2131298633);
      paramad.setSummary(2131298838);
      paramad.OT(2147483647);
      paramad.zrr = false;
      paramad.OW(8);
      paramf.b(paramad);
      paramf.b(new PreferenceSmallCategory(this.jpX));
      paramf.b((Preference)localObject1);
      this.pxo.kxD.removeAllOptionMenu();
      AppMethodBeat.o(23221);
      return true;
    }
    localObject3 = this.lpe;
    int i = this.jpX.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.jpX.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = bo.bf(this.jpX.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new cfj();
    ((cfj)localObject2).gxa = i;
    ((cfj)localObject2).gxc = l;
    ((cfj)localObject2).gxb = ((String)localObject1);
    localObject1 = localObject2;
    if (com.tencent.mm.plugin.sns.b.n.raR != null) {
      localObject1 = com.tencent.mm.plugin.sns.b.n.raR.b(((aq)localObject3).field_username, (cfj)localObject2);
    }
    aw.aaz();
    boolean bool1 = com.tencent.mm.model.c.YA().arr(((aq)localObject3).field_username);
    boolean bool2 = r.Zn().equals(((aq)localObject3).field_username);
    if ((((cfj)localObject1).gxa & 0x1) > 0)
    {
      paramBoolean = true;
      ab.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean) });
      if (((ad.ard(((aq)localObject3).field_username)) || (!paramBoolean)) && (!cbA()) && (!bool2)) {
        break label3142;
      }
      this.iLA.cl("contact_profile_sns", false);
      localObject1 = (com.tencent.mm.ui.base.preference.g)this.iLA.atx("contact_profile_sns");
      if (com.tencent.mm.plugin.sns.b.n.raV != null)
      {
        com.tencent.mm.plugin.sns.b.n.raV.a(3, ((aq)localObject3).field_username, this);
        i = this.jpX.getIntent().getIntExtra("Sns_from_Scene", 0);
        com.tencent.mm.plugin.sns.b.n.raV.a(2, ((aq)localObject3).field_username, bool2, i);
      }
      ((com.tencent.mm.ui.base.preference.g)localObject1).amx(((aq)localObject3).field_username);
      label1241:
      if (ad.arf(((aq)localObject3).field_username)) {
        this.iLA.cl("contact_profile_sns", true);
      }
      localObject2 = paramf.atx("contact_profile_setting_desc");
      if (!ad.arf(this.lpe.field_username)) {
        break label3157;
      }
      localObject1 = this.jpX.getText(2131298849).toString();
      label1304:
      ((Preference)localObject2).setTitle((CharSequence)localObject1);
      localObject1 = (KeyValuePreference)paramf.atx("contact_profile_source");
      paramInt = this.jpX.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
      localObject2 = NormalProfileHeaderPreference.a(this.jpX, this.lpe, paramInt, this.lpe.field_username, cbA());
      ((KeyValuePreference)localObject1).setSummary((CharSequence)localObject2);
      ((KeyValuePreference)localObject1).OT(2);
      ((KeyValuePreference)localObject1).zrr = false;
      ((KeyValuePreference)localObject1).nEC = (com.tencent.mm.cb.a.ar(this.jpX, (int)this.jpX.getResources().getDimension(2131427809)) * com.tencent.mm.cb.a.dr(this.jpX));
      ((KeyValuePreference)localObject1).OW(8);
      if ((!com.tencent.mm.n.a.je(paramad.field_type)) && (!bo.aa((CharSequence)localObject2)) && ((!cbB()) || (cbA()))) {
        break label3177;
      }
      paramBoolean = true;
      label1463:
      paramf.cl("contact_profile_source", paramBoolean);
      localObject1 = (LabelPreference)paramf.atx("contact_profile_label");
      ((LabelPreference)localObject1).lpe = paramad;
      if (!com.tencent.mm.n.a.je(((LabelPreference)localObject1).lpe.field_type))
      {
        localObject2 = ((LabelPreference)localObject1).lpe.field_encryptUsername;
        if (!bo.isNullOrNil((String)localObject2))
        {
          aw.aaz();
          ((LabelPreference)localObject1).pRo = com.tencent.mm.model.c.YB().TM((String)localObject2);
        }
        if ((((LabelPreference)localObject1).pRo != null) && (((LabelPreference)localObject1).pRo.systemRowid < 0L))
        {
          aw.aaz();
          ((LabelPreference)localObject1).pRo = com.tencent.mm.model.c.YB().TM(((LabelPreference)localObject1).lpe.field_username);
        }
      }
      if ((!com.tencent.mm.n.a.je(((LabelPreference)localObject1).lpe.field_type)) || (bo.isNullOrNil(((LabelPreference)localObject1).lpe.field_contactLabelIds))) {
        break label3182;
      }
      paramInt = 1;
      label1621:
      if (paramInt != 0) {
        break label3216;
      }
      paramBoolean = true;
      label1628:
      paramf.cl("contact_profile_label", paramBoolean);
      localObject3 = (PhoneNumPreference)paramf.atx("contact_profile_phone");
      ((PhoneNumPreference)localObject3).iLA = paramf;
      localObject4 = this.jpX.getIntent();
      ((PhoneNumPreference)localObject3).lpe = paramad;
      ((PhoneNumPreference)localObject3).intent = ((Intent)localObject4);
      ab.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramad.Ob() });
      if (!paramad.Ob())
      {
        localObject1 = null;
        localObject2 = ((Intent)localObject4).getStringExtra("Contact_Mobile_MD5");
        localObject4 = ((Intent)localObject4).getStringExtra("Contact_full_Mobile_MD5");
        if ((!bo.isNullOrNil((String)localObject2)) || (!bo.isNullOrNil((String)localObject4))) {
          break label3229;
        }
        if (!bo.isNullOrNil(paramad.field_username))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramad.field_username);
          localObject4 = paramad.field_username;
          if (localObject2 != null) {
            break label3221;
          }
          localObject1 = "true";
          label1796:
          ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject1 });
          localObject1 = localObject2;
        }
        label1823:
        if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Al())))
        {
          ((PhoneNumPreference)localObject3).vRr = bo.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aqf()).replace(" ", "");
          ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramad.field_username, ((PhoneNumPreference)localObject3).vRr });
        }
        ((PhoneNumPreference)localObject3).dpl();
      }
      ((PhoneNumPreference)localObject3).vRs = PhoneNumPreference.hX(((PhoneNumPreference)localObject3).vRr, paramad.dqZ);
      ((PhoneNumPreference)localObject3).iLA.cl("contact_profile_phone", true);
      ((PhoneNumPreference)localObject3).dpl();
      ((PhoneNumPreference)localObject3).OW(8);
      localObject1 = (ProfileDescribePreference)paramf.atx("contact_profile_desc");
      ((ProfileDescribePreference)localObject1).lpe = paramad;
      if (!com.tencent.mm.n.a.je(((ProfileDescribePreference)localObject1).lpe.field_type))
      {
        localObject2 = ((ProfileDescribePreference)localObject1).lpe.field_encryptUsername;
        if (!bo.isNullOrNil((String)localObject2))
        {
          aw.aaz();
          ((ProfileDescribePreference)localObject1).pRo = com.tencent.mm.model.c.YB().TM((String)localObject2);
        }
        if ((((ProfileDescribePreference)localObject1).pRo != null) && (((ProfileDescribePreference)localObject1).pRo.systemRowid < 0L))
        {
          aw.aaz();
          ((ProfileDescribePreference)localObject1).pRo = com.tencent.mm.model.c.YB().TM(((ProfileDescribePreference)localObject1).lpe.field_username);
        }
      }
      if (com.tencent.mm.n.a.je(((ProfileDescribePreference)localObject1).lpe.field_type)) {
        break label3371;
      }
      if ((((ProfileDescribePreference)localObject1).pRo == null) || (bo.isNullOrNil(((ProfileDescribePreference)localObject1).pRo.field_conDescription))) {
        break label3365;
      }
      paramInt = 1;
      label2092:
      if (paramInt != 0) {
        break label3425;
      }
      paramBoolean = true;
      label2099:
      paramf.cl("contact_profile_desc", paramBoolean);
      if ((com.tencent.mm.n.a.je(paramad.field_type)) || (bo.isNullOrNil(paramad.signature))) {
        break label3430;
      }
      localObject1 = (KeyValuePreference)paramf.atx("contact_info_signature");
      if (localObject1 != null)
      {
        ((KeyValuePreference)localObject1).nEC = (com.tencent.mm.cb.a.ar(this.jpX, (int)this.jpX.getResources().getDimension(2131427809)) * com.tencent.mm.cb.a.dr(this.jpX));
        ((KeyValuePreference)localObject1).zrr = false;
        ((KeyValuePreference)localObject1).setTitle(this.jpX.getString(2131298759));
        ((KeyValuePreference)localObject1).setSummary(j.b(this.jpX, paramad.signature));
        ((KeyValuePreference)localObject1).qJ(false);
        ((KeyValuePreference)localObject1).OT(5);
        ((KeyValuePreference)localObject1).OW(8);
      }
      label2239:
      if ((paramf.atz("contact_profile_desc") >= 0) || (paramf.atz("contact_profile_label") >= 0)) {
        break label3443;
      }
      paramf.cl("contact_profile_setting_desc", false);
      label2272:
      if (!com.tencent.mm.n.a.je(paramad.field_type)) {
        paramf.cl("contact_profile_setting_desc", false);
      }
      paramf.cl("contact_profile_set_des_category", true);
      if ((!ad.arf(this.lpe.field_username)) || (!bo.isNullOrNil(this.lpe.field_conRemark))) {
        break label3455;
      }
      paramf.cl("contact_profile_setting_desc", false);
      paramf.cl("contact_profile_set_des_category", true);
      label2346:
      paramf.atx("contact_profile_info_more").setTitle(this.jpX.getText(2131298674).toString());
      ((TextPreference)paramf.atx("contact_profile_hint")).ac(this.jpX.getText(2131298679));
      if (!paramad.NW()) {
        break label3490;
      }
      paramf.cl("contact_profile_hint", false);
      label2414:
      localObject2 = (MultiButtonPreference)paramf.atx("contact_profile_multi_button");
      if (!cbA())
      {
        if ((com.tencent.mm.n.a.je(this.lpe.field_type)) || (this.jpX.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 2)) {
          break label3503;
        }
        paramInt = 1;
        label2469:
        if (paramInt == 0) {
          break label3524;
        }
      }
      if (!this.lpe.NW()) {
        break label3509;
      }
      localObject1 = this.jpX.getString(2131298680);
      label2496:
      ((MultiButtonPreference)localObject2).a((String)localObject1, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(23203);
          a.this.pxo.ka(true);
          AppMethodBeat.o(23203);
        }
      });
      localObject1 = this.jpX.getString(2131297684);
      localObject3 = new a.7(this);
      ((MultiButtonPreference)localObject2).pAT = ((String)localObject1);
      ((MultiButtonPreference)localObject2).pAW = ((View.OnClickListener)localObject3);
      label2547:
      if ((cbx()) || ((com.tencent.mm.n.a.je(paramad.field_type)) && (!paramad.NW())) || ((!cbA()) && (cbB()))) {
        paramf.cl("contact_profile_multi_button", true);
      }
      if ((com.tencent.mm.n.a.je(this.lpe.field_type)) && (!cbA()) && (!cbE()) && (!cbz())) {
        break label3571;
      }
      paramf.cl("contact_profile_send", true);
      paramf.cl("contact_profile_voip", true);
      label2649:
      if ((!com.tencent.mm.n.a.je(this.lpe.field_type)) && (!cbA()) && (!cbE()) && (!cbD()) && (!cbC()) && (!r.Zn().equals(this.lpe.field_username))) {
        break label3600;
      }
      paramf.cl("contact_profile_add_contact", true);
      label2716:
      a(paramf, paramad, false);
      if ((cbA()) || (com.tencent.mm.n.a.je(paramad.field_type)) || ((!cbz()) && (!cbD()) && (!cbC()))) {
        break label3640;
      }
      paramf.cl("contact_profile_info_more", true);
      paramf.cl("contact_profile_say_hi", false);
      label2780:
      if (r.nB(this.lpe.field_username))
      {
        paramf.cl("contact_profile_multi_button", true);
        paramf.cl("contact_profile_info_more", bo.isNullOrNil(paramad.signature));
        paramf.cl("contact_profile_setting_desc", true);
        paramf.cl("contact_profile_voip", true);
        this.pxo.kxD.removeAllOptionMenu();
      }
      localObject1 = this.lpe;
      paramf.cl("contact_info_invite_source", true);
      if (this.efi != null) {
        break label3684;
      }
      paramBoolean = this.jpX.getIntent().getBooleanExtra("Is_RoomOwner", false);
      label2884:
      if ((this.mScene == 14) && (paramBoolean) && (this.efi != null) && (!((aq)localObject1).field_username.equals(this.efi.field_roomowner))) {
        break label3701;
      }
      paramInt = this.mScene;
      if (this.efi != null) {
        break label3695;
      }
      bool1 = true;
      label2938:
      ab.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
      paramf.cl("contact_info_invite_source", true);
    }
    for (;;)
    {
      this.iLA.cl("contact_profile_story", true);
      aw.aaz();
      paramBoolean = com.tencent.mm.model.c.YA().arr(paramad.field_username);
      bool1 = r.Zn().equals(paramad.field_username);
      if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().czq())
      {
        ab.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        if (((!ad.ard(paramad.field_username)) && (paramBoolean)) || (bool1))
        {
          paramf = (AbsStoryPreference)this.iLA.atx("contact_profile_story");
          paramf.onCreate(paramad.field_username);
          paramf.a(this);
          paramf.czl();
          paramf.czk();
        }
      }
      AppMethodBeat.o(23221);
      return true;
      paramBoolean = false;
      break;
      label3142:
      this.iLA.cl("contact_profile_sns", true);
      break label1241;
      label3157:
      localObject1 = this.jpX.getText(2131298848).toString();
      break label1304;
      label3177:
      paramBoolean = false;
      break label1463;
      label3182:
      if ((((LabelPreference)localObject1).pRo != null) && (!bo.isNullOrNil(((LabelPreference)localObject1).pRo.field_contactLabels)))
      {
        paramInt = 1;
        break label1621;
      }
      paramInt = 0;
      break label1621;
      label3216:
      paramBoolean = false;
      break label1628;
      label3221:
      localObject1 = "false";
      break label1796;
      label3229:
      if ((bo.isNullOrNil((String)localObject2)) && (bo.isNullOrNil((String)localObject4))) {
        break label1823;
      }
      ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramad.field_username, localObject2, localObject4 });
      localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Al())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject4);
      }
      localObject4 = paramad.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        ab.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject4, localObject2 });
        break;
      }
      label3365:
      paramInt = 0;
      break label2092;
      label3371:
      if (!bo.isNullOrNil(((ProfileDescribePreference)localObject1).lpe.dqU)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((bo.isNullOrNil(((ProfileDescribePreference)localObject1).lpe.dqT)) && (paramInt == 0)) {
          break label3419;
        }
        paramInt = 1;
        break;
      }
      label3419:
      paramInt = 0;
      break label2092;
      label3425:
      paramBoolean = false;
      break label2099;
      label3430:
      paramf.aty("contact_info_signature");
      break label2239;
      label3443:
      paramf.cl("contact_profile_setting_desc", true);
      break label2272;
      label3455:
      if (!ad.arf(this.lpe.field_username)) {
        break label2346;
      }
      paramf.cl("contact_profile_setting_desc", true);
      paramf.cl("contact_profile_set_des_category", true);
      break label2346;
      label3490:
      paramf.cl("contact_profile_hint", true);
      break label2414;
      label3503:
      paramInt = 0;
      break label2469;
      label3509:
      localObject1 = this.jpX.getString(2131298675);
      break label2496;
      label3524:
      if ((!paramad.NW()) && (!cbD()) && (!cbC())) {
        break label2547;
      }
      ((MultiButtonPreference)localObject2).a(this.jpX.getString(2131297684), new a.8(this));
      break label2547;
      label3571:
      paramf.cl("contact_profile_send", false);
      paramf.cl("contact_profile_voip", this.lpe.NW());
      break label2649;
      label3600:
      paramf.cl("contact_profile_add_contact", false);
      paramf.cl("contact_profile_setting_desc", false);
      paramf.cl("contact_profile_phone", true);
      paramf.cl("contact_profile_info_more", true);
      break label2716;
      label3640:
      paramf.cl("contact_profile_say_hi", true);
      if (!com.tencent.mm.n.a.je(paramad.field_type))
      {
        paramf.cl("contact_profile_info_more", true);
        break label2780;
      }
      paramf.cl("contact_profile_info_more", false);
      break label2780;
      label3684:
      paramBoolean = this.efi.JP();
      break label2884;
      label3695:
      bool1 = false;
      break label2938;
      label3701:
      this.pxq = this.jpX.getIntent().getStringExtra("inviteer");
      if (bo.isNullOrNil(this.pxq)) {
        this.pxq = this.efi.aqX(((aq)localObject1).field_username);
      }
      if (bo.isNullOrNil(this.pxq)) {
        this.pxq = com.tencent.mm.model.n.ad(((aq)localObject1).field_username, this.egF);
      }
      if (bo.isNullOrNil(this.pxq))
      {
        ab.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.egF, ((aq)localObject1).field_username });
        this.pxr.alive();
        ao.a.flI.a(((aq)localObject1).field_username, this.egF, new a.4(this));
      }
      else
      {
        this.jpX.getIntent().putExtra("inviteer", this.pxq);
        localObject2 = b(this.efi, this.pxq);
        if (bo.isNullOrNil((String)localObject2)) {
          ao.a.flI.a(((aq)localObject1).field_username, "", new a.5(this, paramf));
        } else {
          a(paramf, this.jpX, this.pxq, (String)localObject2);
        }
      }
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23223);
    this.iLA.atx("contact_profile_sns");
    if (com.tencent.mm.plugin.sns.b.n.raV != null) {
      com.tencent.mm.plugin.sns.b.n.raV.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.iLA.atx("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.iLA.atx("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.pxr.dead();
    AppMethodBeat.o(23223);
    return false;
  }
  
  public final void cy(List paramList)
  {
    AppMethodBeat.i(23236);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.iLA.cl("contact_profile_story", true);
      AppMethodBeat.o(23236);
      return;
    }
    ab.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.iLA.cl("contact_profile_story", false);
    AppMethodBeat.o(23236);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(23225);
    a(this.iLA, this.lpe, true);
    AppMethodBeat.o(23225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */