package com.tencent.mm.plugin.profile.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, q.f, q.g
{
  private boolean GWK;
  private boolean isDeleteCancel;
  private int mXL;
  public MMActivity tzD;
  public as uNk;
  
  public b(MMActivity paramMMActivity, as paramas)
  {
    AppMethodBeat.i(26882);
    this.tzD = paramMMActivity;
    this.uNk = paramas;
    this.mXL = this.tzD.getIntent().getIntExtra("Contact_Scene", 9);
    this.GWK = this.tzD.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  public static void a(Activity paramActivity, as paramas)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramas.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramas = str;
    if (str == null) {
      paramas = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramas);
    paramas = Util.nullAs(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = Util.nullAs(paramActivity.getIntent().getStringExtra("profileName"), Util.subStringEmail(paramas));
    localIntent.putExtra("verify_gmail", paramas);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramas = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramas);
    paramas = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramas.aFh(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramas.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void aUJ(String paramString)
  {
    AppMethodBeat.i(274996);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(274996);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mXL);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.uNk.field_username);
    paramString.putExtra("Contact_Nick", this.uNk.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.uNk.field_conRemark);
    com.tencent.mm.plugin.profile.b.mIG.l(paramString, this.tzD);
    AppMethodBeat.o(274996);
  }
  
  private void afm(String paramString)
  {
    AppMethodBeat.i(26894);
    this.uNk.axl();
    if (as.bvK(paramString))
    {
      this.uNk.setSource(0);
      ((u)com.tencent.mm.kernel.h.ae(u.class)).Lz(paramString);
      bq.a(paramString, new bq.a()
      {
        public final boolean asH()
        {
          AppMethodBeat.i(273146);
          boolean bool = b.g(b.this);
          AppMethodBeat.o(273146);
          return bool;
        }
        
        public final void asI() {}
      });
      bh.beI();
      com.tencent.mm.model.c.bbL().c(paramString, this.uNk);
      bh.beI();
      com.tencent.mm.model.c.bbR().bwv(paramString);
      com.tencent.mm.bl.c.g(0L, paramString);
      com.tencent.mm.bl.c.g(0L, this.uNk.field_encryptUsername);
      switch (this.mXL)
      {
      case 11: 
      case 12: 
      default: 
        if (this.mXL == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.uNk.getSource());
          switch (this.uNk.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.tzD.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label345;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.mIG.n(paramString, this.tzD);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramString);
        if ((locala != null) && (!Util.isNullOrNil(locala.mVx)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.b.getAddrUploadStg().a(locala.getMd5(), locala);
        }
        t.P(this.tzD, paramString);
        break;
        t.P(this.tzD, paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.P(this.tzD, paramString);
      }
      label345:
      this.tzD.setResult(-1, this.tzD.getIntent().putExtra("_delete_ok_", true));
      this.tzD.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).afm(paramString);
    AppMethodBeat.o(26894);
  }
  
  private ar fpK()
  {
    AppMethodBeat.i(274994);
    ar localar = com.tencent.mm.contact.a.a.h(this.uNk);
    if (localar != null) {
      localar.b(new b.5(this)).i(this.tzD, this.tzD.getString(R.l.app_tip), this.tzD.getString(R.l.app_waiting));
    }
    AppMethodBeat.o(274994);
    return localar;
  }
  
  private void fpL()
  {
    AppMethodBeat.i(26891);
    ar localar = com.tencent.mm.contact.a.a.i(this.uNk);
    if (localar != null) {
      localar.b(new b.6(this)).i(this.tzD, this.tzD.getString(R.l.app_tip), this.tzD.getString(R.l.app_waiting));
    }
    AppMethodBeat.o(26891);
  }
  
  private void fpO()
  {
    AppMethodBeat.i(274995);
    if (!com.tencent.mm.contact.d.rk(this.uNk.field_type))
    {
      aUJ(this.uNk.field_username);
      AppMethodBeat.o(274995);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.mXL);
    localIntent.putExtra("Contact_User", this.uNk.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.tzD.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.uNk.hDw);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.uNk.ayo())
    {
      localObject1 = null;
      localObject2 = this.tzD.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.tzD.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2))) {
        break label264;
      }
      if (!Util.isNullOrNil(this.uNk.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.uNk.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())) {
          localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxY()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.mIG.k(localIntent, this.tzD);
      AppMethodBeat.o(274995);
      return;
      label264:
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).getMd5())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(str2);
        }
      }
    }
  }
  
  private void fpP()
  {
    AppMethodBeat.i(274997);
    Log.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.uNk.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.tzD, new c.b()
    {
      public final void cxf()
      {
        AppMethodBeat.i(277863);
        com.tencent.mm.plugin.base.model.b.ai(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(277863);
      }
      
      public final void cxg()
      {
        AppMethodBeat.i(277864);
        com.tencent.mm.plugin.base.model.b.ah(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(277864);
      }
    });
    AppMethodBeat.o(274997);
  }
  
  public final void Si(int paramInt)
  {
    AppMethodBeat.i(274992);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(274992);
      return;
      if (this.uNk.ayh())
      {
        ab.E(this.uNk);
        com.tencent.mm.ui.base.h.cO(this.tzD, this.tzD.getString(R.l.eAk));
      }
      for (;;)
      {
        bh.beI();
        this.uNk = com.tencent.mm.model.c.bbL().RG(this.uNk.field_username);
        com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 10, 1, this.uNk.field_username);
        AppMethodBeat.o(274992);
        return;
        ab.D(this.uNk);
        com.tencent.mm.ui.base.h.cO(this.tzD, this.tzD.getString(R.l.eyx));
      }
      fpJ();
      com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 11, 1, this.uNk.field_username);
      AppMethodBeat.o(274992);
      return;
      fpN();
      com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 9, 1, this.uNk.field_username);
      AppMethodBeat.o(274992);
      return;
      fpO();
      com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 8, 1, this.uNk.field_username);
      AppMethodBeat.o(274992);
      return;
      vV(true);
      com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 14, 1, this.uNk.field_username);
      AppMethodBeat.o(274992);
      return;
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).a(this);
      fpM();
      AppMethodBeat.o(274992);
      return;
      fpP();
      com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 15, 1, this.uNk.field_username);
      AppMethodBeat.o(274992);
      return;
      fpQ();
    }
  }
  
  public final void a(String paramString, int paramInt, dgv paramdgv)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      if (!paramString.equals(this.uNk.field_username))
      {
        Log.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", new Object[] { this.uNk.field_username, paramString });
        AppMethodBeat.o(26893);
        return;
      }
      switch (this.mXL)
      {
      case 11: 
      case 12: 
      default: 
        if (this.mXL == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.uNk.getSource());
          switch (this.uNk.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.tzD.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label301;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.mIG.n(paramString, this.tzD);
        AppMethodBeat.o(26893);
        return;
        paramdgv = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramString);
        if ((paramdgv != null) && (!Util.isNullOrNil(paramdgv.mVx)))
        {
          paramdgv.status = 1;
          com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramdgv.getMd5(), paramdgv);
        }
        t.P(this.tzD, paramString);
        break;
        t.P(this.tzD, paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.P(this.tzD, paramString);
      }
      label301:
      this.tzD.setResult(-1, this.tzD.getIntent().putExtra("_delete_ok_", true));
      this.tzD.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!Util.isNullOrNil(paramdgv.lpy))
    {
      com.tencent.mm.ui.base.h.c(this.tzD, paramdgv.lpy, paramdgv.fwr, true);
      AppMethodBeat.o(26893);
      return;
    }
    com.tencent.mm.ui.base.h.c(this.tzD, this.tzD.getString(R.l.app_delete_failed), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.i.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void fpJ()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWD, 0);
    Object localObject2 = this.tzD;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.uNk.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.tzD.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.tzD;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void fpM()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.tzD, R.i.mm_alert_checkbox, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (ab.Qj(this.uNk.field_username))
    {
      localObject = this.tzD.getString(R.l.eAY, new Object[] { this.uNk.ays() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
      localTextView.setText(R.l.eyN);
      if (this.uNk.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.tzD, true, this.tzD.getString(R.l.contact_info_delete_contact), localView, this.tzD.getString(R.l.app_delete), this.tzD.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26877);
          b.e(b.this);
          if (b.c(b.this).getSource() == 18)
          {
            b.f(b.this);
            if (this.GWL.isChecked()) {
              b.this.fpQ();
            }
          }
          AppMethodBeat.o(26877);
        }
      }, null, R.e.alert_btn_color_warn);
      AppMethodBeat.o(26892);
      return;
      localObject = this.tzD.getString(R.l.eAW, new Object[] { this.uNk.ays() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void fpN()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.uNk.field_username);
    localIntent.putExtra("Select_block_List", this.uNk.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.mIG.a(localIntent, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(267976);
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          String str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          String str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          g.eRW().u(str1, str2, bool);
          g.eRW().iQ(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.r(b.d(b.this), b.d(b.this).getString(R.l.finish_sent));
        }
        AppMethodBeat.o(267976);
      }
    }, this.tzD);
    AppMethodBeat.o(26895);
  }
  
  public final void fpQ()
  {
    int i = 7;
    AppMethodBeat.i(274998);
    Intent localIntent = new Intent();
    switch (this.mXL)
    {
    default: 
      i = 35;
      if (i == 990)
      {
        localIntent.putExtra("k_username", this.tzD.getIntent().getStringExtra("room_name"));
        localIntent.putExtra("k_realchatuser", this.uNk.field_username);
      }
      break;
    }
    for (;;)
    {
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.by.c.b(this.tzD, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(274998);
      return;
      if (this.GWK) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.Xy(this.uNk.field_username));
        break;
      }
      if (this.GWK) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.Xz(this.uNk.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.R(7, this.uNk.field_username));
      break;
      if (this.GWK) {}
      for (i = 6;; i = 5)
      {
        if (!this.GWK) {
          break label429;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.R(i, this.uNk.field_username));
        break;
      }
      label429:
      if (!Util.isNullOrNil(this.uNk.VEr)) {}
      for (String str = this.uNk.VEr;; str = this.uNk.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.XA(str));
        break;
      }
      i = 35;
      break;
      i = 990;
      break;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bl.a.R(45, this.uNk.field_username));
      i = 45;
      break;
      localIntent.putExtra("k_username", this.uNk.field_username);
    }
  }
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!ab.QO(this.uNk.field_username))
    {
      if (as.bvK(this.uNk.field_username)) {
        paramo.aW(1, R.l.eAq, R.k.bottomsheet_icon_remarks);
      }
    }
    else
    {
      if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (!ab.QO(this.uNk.field_username)))
      {
        i = R.l.ezl;
        if (this.uNk.sex != 1) {
          break label481;
        }
        i = R.l.ezj;
        label89:
        paramo.aW(4, i, R.k.bottomsheet_icon_transmit);
      }
      if (!this.uNk.ayh()) {
        break label499;
      }
      str = this.tzD.getResources().getString(R.l.eAj);
      label123:
      if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (!ab.QO(this.uNk.field_username))) {
        paramo.b(2, str, R.k.bottomsheet_icon_star);
      }
      if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) || (!this.tzD.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (as.bvK(this.uNk.field_username))
        {
          if (com.tencent.mm.n.h.axc().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!as.bvK(this.uNk.field_username)) || (!"3552365301".equals(this.uNk.field_openImAppid))) {}
        }
        else if ((ab.QO(this.uNk.field_username)) || (!com.tencent.mm.contact.d.rk(this.uNk.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.uNk.field_openImAppid)) {
          break label526;
        }
        paramo.aW(3, R.l.contact_info_op_sns_permission_openim, R.k.bottomsheet_icon_moment);
      }
      label311:
      if (!this.uNk.ayc()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.tzD.getString(R.l.contact_info_moveout_blacklist);; str = this.tzD.getString(R.l.contact_info_movein_blacklist))
    {
      if (!ab.QO(this.uNk.field_username)) {
        paramo.b(5, str, R.k.bottomsheet_icon_blacklist);
      }
      if ((!ab.QO(this.uNk.field_username)) && (com.tencent.mm.contact.d.rk(this.uNk.field_type))) {
        paramo.aW(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
      }
      if (com.tencent.mm.contact.d.rk(this.uNk.field_type)) {
        paramo.aW(7, R.l.exQ, R.k.bottomsheet_icon_desktop);
      }
      if ((com.tencent.mm.contact.d.rk(this.uNk.field_type)) && (!ab.QO(this.uNk.field_username))) {
        paramo.aW(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
      }
      AppMethodBeat.o(26886);
      return;
      paramo.aW(1, R.l.eyI, R.k.bottomsheet_icon_remarks);
      break;
      label481:
      if (this.uNk.sex != 2) {
        break label89;
      }
      i = R.l.ezk;
      break label89;
      label499:
      str = this.tzD.getResources().getString(R.l.eyw);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paramo.aW(3, R.l.eOO, R.k.bottomsheet_icon_moment);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    Si(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.uNk.jxt <= 0)
    {
      bh.beI();
      com.tencent.mm.model.c.bbL().d(this.uNk, true);
    }
    paramMenuItem = new Intent(this.tzD.getIntent());
    paramMenuItem.putExtra("Contact_User", this.uNk.field_username);
    paramMenuItem.setClass(this.tzD, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.tzD.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.profile.d.a(this.tzD.getIntent(), 7, 1, this.uNk.field_username);
    AppMethodBeat.o(26885);
    return true;
  }
  
  public final void vV(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.uNk.ayc())
    {
      fpL();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.tzD, R.i.mm_alert_checkbox, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (as.bvK(this.uNk.field_username))
    {
      i = R.l.eyM;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
      localTextView.setText(R.l.eyN);
      if (this.uNk.getSource() != 18) {
        break label229;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label246;
      }
      com.tencent.mm.ui.base.h.a(this.tzD, false, this.tzD.getString(R.l.contact_info_movein_blacklist), localView, this.tzD.getString(R.l.app_ok), this.tzD.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          paramAnonymousDialogInterface = b.a(b.this);
          if (paramAnonymousDialogInterface == null)
          {
            Log.e("MicroMsg.ProfileMenuManager", "dealSetBlack iContactCallbackFactory is null????");
            AppMethodBeat.o(26873);
            return;
          }
          paramAnonymousDialogInterface.a(new com.tencent.mm.contact.a.b() {});
          AppMethodBeat.o(26873);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26874);
          b.b(b.this);
          AppMethodBeat.o(26874);
        }
      });
      AppMethodBeat.o(26889);
      return;
      i = R.l.eyL;
      break;
      label229:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label246:
    fpK();
    AppMethodBeat.o(26889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */