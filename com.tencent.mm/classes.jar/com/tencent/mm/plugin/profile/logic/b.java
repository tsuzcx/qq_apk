package com.tencent.mm.plugin.profile.logic;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.i.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.f;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, u.g, u.i
{
  private boolean MUD;
  private boolean isDeleteCancel;
  public int pUt;
  public MMActivity pVV;
  private com.tencent.mm.ui.widget.a.f ucS;
  public au xVS;
  
  public b(MMActivity paramMMActivity, au paramau)
  {
    AppMethodBeat.i(26882);
    this.pVV = paramMMActivity;
    this.xVS = paramau;
    this.pUt = this.pVV.getIntent().getIntExtra("Contact_Scene", 9);
    this.MUD = this.pVV.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void XN(String paramString)
  {
    AppMethodBeat.i(26894);
    this.xVS.aRL();
    if (au.bwO(paramString))
    {
      this.xVS.setSource(0);
      ((u)com.tencent.mm.kernel.h.ax(u.class)).Eg(paramString);
      br.a(paramString, new br.a()
      {
        public final boolean aMJ()
        {
          AppMethodBeat.i(306219);
          boolean bool = b.f(b.this);
          AppMethodBeat.o(306219);
          return bool;
        }
        
        public final void aMK() {}
      });
      ac.aY(paramString, 15);
      bh.bCz();
      com.tencent.mm.model.c.bzA().d(paramString, this.xVS);
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxK(paramString);
      com.tencent.mm.modelverify.c.h(0L, paramString);
      com.tencent.mm.modelverify.c.h(0L, this.xVS.field_encryptUsername);
      switch (this.pUt)
      {
      default: 
        if (this.pUt == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.xVS.getSource());
          switch (this.xVS.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.pVV.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label307;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.pFn.n(paramString, this.pVV);
        AppMethodBeat.o(26894);
        return;
        paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramString);
        if ((paramString == null) || (Util.isNullOrNil(paramString.pSe))) {
          break;
        }
        paramString.status = 1;
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramString.getMd5(), paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
      }
      label307:
      this.pVV.setResult(-1, this.pVV.getIntent().putExtra("_delete_ok_", true));
      this.pVV.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).XN(paramString);
    AppMethodBeat.o(26894);
  }
  
  public static void a(Activity paramActivity, au paramau)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramau.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramau = str;
    if (str == null) {
      paramau = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramau);
    paramau = Util.nullAs(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = Util.nullAs(paramActivity.getIntent().getStringExtra("profileName"), Util.subStringEmail(paramau));
    localIntent.putExtra("verify_gmail", paramau);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramau = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramau);
    paramau = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramau.aYi(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramau.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void aRR(String paramString)
  {
    AppMethodBeat.i(306257);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(306257);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.pUt);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.xVS.field_username);
    paramString.putExtra("Contact_Nick", this.xVS.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.xVS.field_conRemark);
    com.tencent.mm.plugin.profile.b.pFn.l(paramString, this.pVV);
    AppMethodBeat.o(306257);
  }
  
  private as gAY()
  {
    AppMethodBeat.i(306232);
    as localas = com.tencent.mm.contact.a.a.i(this.xVS);
    if (localas != null) {
      localas.b(new com.tencent.mm.contact.a.b() {}).m(this.pVV, this.pVV.getString(R.l.app_tip), this.pVV.getString(R.l.app_waiting));
    }
    AppMethodBeat.o(306232);
    return localas;
  }
  
  private void gAZ()
  {
    AppMethodBeat.i(26891);
    as localas = com.tencent.mm.contact.a.a.j(this.xVS);
    if (localas != null) {
      localas.b(new com.tencent.mm.contact.a.b() {}).m(this.pVV, this.pVV.getString(R.l.app_tip), this.pVV.getString(R.l.app_waiting));
    }
    AppMethodBeat.o(26891);
  }
  
  private void gBc()
  {
    AppMethodBeat.i(306254);
    if (!com.tencent.mm.contact.d.rs(this.xVS.field_type))
    {
      aRR(this.xVS.field_username);
      AppMethodBeat.o(306254);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.pUt);
    localIntent.putExtra("Contact_User", this.xVS.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.pVV.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("key_label_click_source", this.pVV.getIntent().getIntExtra("key_label_click_source", 0));
    localIntent.putExtra("contact_phone_number_list", this.xVS.kar);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.xVS.aSR())
    {
      localObject1 = null;
      localObject2 = this.pVV.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.pVV.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2))) {
        break label290;
      }
      if (!Util.isNullOrNil(this.xVS.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.xVS.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).getMd5())) {
          localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWN()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.pFn.k(localIntent, this.pVV);
      AppMethodBeat.o(306254);
      return;
      label290:
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject2).getMd5())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(str2);
        }
      }
    }
  }
  
  private void gBd()
  {
    AppMethodBeat.i(306264);
    Log.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.xVS.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.pVV, new c.b()
    {
      public final void cZQ()
      {
        AppMethodBeat.i(306262);
        com.tencent.mm.plugin.base.model.b.aj(b.b(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(306262);
      }
      
      public final void cZR()
      {
        AppMethodBeat.i(306272);
        com.tencent.mm.plugin.base.model.b.ai(b.b(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(306272);
      }
    });
    AppMethodBeat.o(306264);
  }
  
  public final void Ar(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.xVS.aSF())
    {
      gAZ();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 14, 2, this.xVS.field_username);
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.pVV, R.i.mm_alert_checkbox, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (au.bwO(this.xVS.field_username))
    {
      i = R.l.gBE;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
      localTextView.setText(R.l.gBF);
      if (this.xVS.getSource() != 18) {
        break label249;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label266;
      }
      k.a(this.pVV, false, this.pVV.getString(R.l.contact_info_movein_blacklist), localView, this.pVV.getString(R.l.app_ok), this.pVV.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          paramAnonymousDialogInterface = b.a(b.this);
          if (paramAnonymousDialogInterface == null) {
            Log.e("MicroMsg.ProfileMenuManager", "dealSetBlack iContactCallbackFactory is null????");
          }
          for (;;)
          {
            com.tencent.mm.plugin.profile.d.b(b.b(b.this).getIntent(), 14, 3, b.c(b.this).field_username);
            AppMethodBeat.o(26873);
            return;
            paramAnonymousDialogInterface.a(new com.tencent.mm.contact.a.b() {});
          }
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26874);
          b.d(b.this);
          AppMethodBeat.o(26874);
        }
      });
      AppMethodBeat.o(26889);
      return;
      i = R.l.gBD;
      break;
      label249:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label266:
    gAY();
    com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 14, 3, this.xVS.field_username);
    AppMethodBeat.o(26889);
  }
  
  public final void VB(int paramInt)
  {
    AppMethodBeat.i(306311);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(306311);
      return;
      if (this.xVS.aSK())
      {
        ab.F(this.xVS);
        k.cZ(this.pVV, this.pVV.getString(R.l.gDa));
      }
      for (;;)
      {
        bh.bCz();
        this.xVS = com.tencent.mm.model.c.bzA().JE(this.xVS.field_username);
        com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 10, 1, this.xVS.field_username);
        AppMethodBeat.o(306311);
        return;
        ab.E(this.xVS);
        k.cZ(this.pVV, this.pVV.getString(R.l.gBp));
      }
      gAX();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 11, 1, this.xVS.field_username);
      AppMethodBeat.o(306311);
      return;
      gBb();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 9, 1, this.xVS.field_username);
      AppMethodBeat.o(306311);
      return;
      gBc();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 8, 1, this.xVS.field_username);
      AppMethodBeat.o(306311);
      return;
      Ar(true);
      Intent localIntent = this.pVV.getIntent();
      if (this.xVS.aSF()) {}
      for (paramInt = 3;; paramInt = 2)
      {
        com.tencent.mm.plugin.profile.d.b(localIntent, 32, paramInt, this.xVS.field_username);
        AppMethodBeat.o(306311);
        return;
      }
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b(this);
      ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).a(this);
      gBa();
      AppMethodBeat.o(306311);
      return;
      gBd();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 15, 1, this.xVS.field_username);
      AppMethodBeat.o(306311);
      return;
      gBe();
      com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 25, 1, this.xVS.field_username);
      AppMethodBeat.o(306311);
      return;
      com.tencent.mm.openim.d.a.bm(this.xVS.field_username, 12);
      gBb();
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void gAX()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 0);
    Object localObject2 = this.pVV;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.xVS.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.pVV.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      ((Intent)localObject2).putExtra("INTENT_SOURCE_FROM_PROFILE_MENU", true);
      localObject1 = this.pVV;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void gBa()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.pVV, R.i.mm_alert_checkbox, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_info);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (ab.IQ(this.xVS.field_username))
    {
      localObject = this.pVV.getString(R.l.gEa, new Object[] { this.xVS.aSV() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(R.h.mm_alert_dialog_cb);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(R.h.mm_alert_dialog_cb_txt);
      localTextView.setText(R.l.gBF);
      if (this.xVS.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      k.a(this.pVV, true, this.pVV.getString(R.l.contact_info_delete_contact), localView, this.pVV.getString(R.l.app_delete), this.pVV.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26877);
          b.e(b.this);
          if (b.c(b.this).getSource() == 18)
          {
            b.this.pUt = 9;
            if (this.MUE.isChecked()) {
              b.this.gBe();
            }
          }
          AppMethodBeat.o(26877);
        }
      }, null, R.e.alert_btn_color_warn);
      AppMethodBeat.o(26892);
      return;
      localObject = this.pVV.getString(R.l.gDX, new Object[] { this.xVS.aSV() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void gBb()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.xVS.field_username);
    localIntent.putExtra("Select_block_List", this.xVS.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.pFn.a(localIntent, new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(306255);
        String str1;
        String str2;
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          if (au.bwQ(str1)) {
            break label108;
          }
          g.gaI().B(str1, str2, bool);
        }
        for (;;)
        {
          g.gaI().ke(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.u(b.b(b.this), b.b(b.this).getString(R.l.finish_sent));
          AppMethodBeat.o(306255);
          return;
          label108:
          if (((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).ca(str2, str1)) {
            com.tencent.mm.openim.d.a.ce(str1, str2);
          }
        }
      }
    }, this.pVV);
    AppMethodBeat.o(26895);
  }
  
  public final void gBe()
  {
    AppMethodBeat.i(306325);
    if (!com.tencent.mm.contact.d.rs(this.xVS.field_type)) {}
    for (int i = 45;; i = 35)
    {
      Intent localIntent = new Intent();
      switch (this.pUt)
      {
      default: 
        if (i == 990)
        {
          localIntent.putExtra("k_username", this.pVV.getIntent().getStringExtra("room_name"));
          localIntent.putExtra("k_realchatuser", this.xVS.field_username);
        }
        break;
      }
      for (;;)
      {
        localIntent.putExtra("showShare", false);
        localIntent.putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(i) }));
        com.tencent.mm.br.c.b(this.pVV, "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(306325);
        return;
        if (this.MUD) {}
        for (i = 2;; i = 1)
        {
          localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.PA(this.xVS.field_username));
          break;
        }
        if (this.MUD) {}
        for (i = 4;; i = 3)
        {
          localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.PB(this.xVS.field_username));
          break;
        }
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.W(7, this.xVS.field_username));
        i = 7;
        break;
        if (this.MUD) {}
        for (i = 6;; i = 5)
        {
          if (!this.MUD) {
            break label442;
          }
          localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.W(i, this.xVS.field_username));
          break;
        }
        label442:
        if (!Util.isNullOrNil(this.xVS.adie)) {}
        for (String str = this.xVS.adie;; str = this.xVS.field_username)
        {
          localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.PC(str));
          break;
        }
        if (!com.tencent.mm.contact.d.rs(this.xVS.field_type))
        {
          i = 45;
          break;
        }
        i = 35;
        break;
        i = 990;
        break;
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.modelverify.a.W(45, this.xVS.field_username));
        i = 45;
        break;
        localIntent.putExtra("k_username", this.xVS.field_username);
      }
    }
  }
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!au.bws(this.xVS.field_username))
    {
      if (au.bwO(this.xVS.field_username)) {
        params.bx(1, R.l.gDi, R.k.bottomsheet_icon_remarks);
      }
    }
    else
    {
      if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (!au.bws(this.xVS.field_username)))
      {
        i = R.l.gCa;
        if (this.xVS.sex != 1) {
          break label481;
        }
        i = R.l.gBY;
        label89:
        params.bx(4, i, R.k.bottomsheet_icon_transmit);
      }
      if (!this.xVS.aSK()) {
        break label499;
      }
      str = this.pVV.getResources().getString(R.l.gCZ);
      label123:
      if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (!au.bws(this.xVS.field_username))) {
        params.a(2, str, R.k.bottomsheet_icon_star);
      }
      if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) || (!this.pVV.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (au.bwO(this.xVS.field_username))
        {
          if (i.aRC().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!au.bwO(this.xVS.field_username)) || (!"3552365301".equals(this.xVS.field_openImAppid))) {}
        }
        else if ((au.bws(this.xVS.field_username)) || (!com.tencent.mm.contact.d.rs(this.xVS.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.xVS.field_openImAppid)) {
          break label526;
        }
        params.bx(3, R.l.contact_info_op_sns_permission_openim, R.k.bottomsheet_icon_moment);
      }
      label311:
      if (!this.xVS.aSF()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.pVV.getString(R.l.contact_info_moveout_blacklist);; str = this.pVV.getString(R.l.contact_info_movein_blacklist))
    {
      if (!au.bws(this.xVS.field_username)) {
        params.a(5, str, R.k.bottomsheet_icon_blacklist);
      }
      if ((!au.bws(this.xVS.field_username)) && (com.tencent.mm.contact.d.rs(this.xVS.field_type))) {
        params.bx(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
      }
      if (com.tencent.mm.contact.d.rs(this.xVS.field_type)) {
        params.bx(7, R.l.gAF, R.k.bottomsheet_icon_desktop);
      }
      if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (!au.bws(this.xVS.field_username))) {
        params.bx(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
      }
      AppMethodBeat.o(26886);
      return;
      params.bx(1, R.l.gBA, R.k.bottomsheet_icon_remarks);
      break;
      label481:
      if (this.xVS.sex != 2) {
        break label89;
      }
      i = R.l.gBZ;
      break label89;
      label499:
      str = this.pVV.getResources().getString(R.l.gBo);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      params.bx(3, R.l.gRp, R.k.bottomsheet_icon_moment);
      break label311;
    }
  }
  
  public final void onDeleteContact(String paramString, int paramInt, dzc paramdzc)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      if (!paramString.equals(this.xVS.field_username))
      {
        Log.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", new Object[] { this.xVS.field_username, paramString });
        AppMethodBeat.o(26893);
        return;
      }
      switch (this.pUt)
      {
      default: 
        if (this.pUt == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.xVS.getSource());
          switch (this.xVS.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.pVV.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label255;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.pFn.n(paramString, this.pVV);
        AppMethodBeat.o(26893);
        return;
        paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramString);
        if ((paramString == null) || (Util.isNullOrNil(paramString.pSe))) {
          break;
        }
        paramString.status = 1;
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramString.getMd5(), paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
      }
      label255:
      this.pVV.setResult(-1, this.pVV.getIntent().putExtra("_delete_ok_", true));
      this.pVV.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!Util.isNullOrNil(paramdzc.nUB))
    {
      k.c(this.pVV, paramdzc.nUB, paramdzc.hAP, true);
      AppMethodBeat.o(26893);
      return;
    }
    k.c(this.pVV, this.pVV.getString(R.l.app_delete_failed), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    VB(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.xVS.maN <= 0)
    {
      bh.bCz();
      com.tencent.mm.model.c.bzA().d(this.xVS, true);
    }
    if (au.bwQ(this.xVS.field_username))
    {
      com.tencent.mm.openim.d.a.bm(this.xVS.field_username, 11);
      this.ucS = new com.tencent.mm.ui.widget.a.f(this.pVV, 1, false);
      paramMenuItem = new a((byte)0);
      this.ucS.GAC = paramMenuItem;
      this.ucS.Vtg = paramMenuItem;
      this.ucS.dDn();
      AppMethodBeat.o(26885);
      return true;
    }
    paramMenuItem = new Intent(this.pVV.getIntent());
    paramMenuItem.putExtra("Contact_User", this.xVS.field_username);
    paramMenuItem.setClass(this.pVV, ProfileSettingUI.class);
    paramMenuItem.putExtra("last_page_source_type", this.pVV.getIntent().getIntExtra("last_page_source_type", 0));
    paramMenuItem.setFlags(32768);
    this.pVV.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.profile.d.b(this.pVV.getIntent(), 7, 1, this.xVS.field_username);
    AppMethodBeat.o(26885);
    return true;
  }
  
  final class a
    implements u.g, u.i
  {
    private a() {}
    
    public final void onCreateMMMenu(s params)
    {
      AppMethodBeat.i(306235);
      if (b.c(b.this) == null)
      {
        AppMethodBeat.o(306235);
        return;
      }
      if (!au.bwQ(b.c(b.this).field_username))
      {
        AppMethodBeat.o(306235);
        return;
      }
      params.oh(10, R.l.contact_info_share_to_friend);
      AppMethodBeat.o(306235);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(306239);
      if (b.c(b.this) == null)
      {
        AppMethodBeat.o(306239);
        return;
      }
      if (!au.bwQ(b.c(b.this).field_username))
      {
        AppMethodBeat.o(306239);
        return;
      }
      b.this.VB(paramMenuItem.getItemId());
      AppMethodBeat.o(306239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.logic.b
 * JD-Core Version:    0.7.0.1
 */