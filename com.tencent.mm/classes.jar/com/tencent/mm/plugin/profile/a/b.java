package com.tencent.mm.plugin.profile.a;

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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, n.c, n.d
{
  private int iMg;
  private boolean isDeleteCancel;
  public MMActivity ofX;
  public ai piT;
  private boolean vIm;
  
  public b(MMActivity paramMMActivity, ai paramai)
  {
    AppMethodBeat.i(26882);
    this.ofX = paramMMActivity;
    this.piT = paramai;
    this.iMg = this.ofX.getIntent().getIntExtra("Contact_Scene", 9);
    this.vIm = this.ofX.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void Kp(String paramString)
  {
    AppMethodBeat.i(26894);
    this.piT.aag();
    if (ai.aNc(paramString))
    {
      this.piT.setSource(0);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Fj(paramString);
      bi.a(paramString, new bi.a()
      {
        public final boolean Wr()
        {
          AppMethodBeat.i(26878);
          boolean bool = b.f(b.this);
          AppMethodBeat.o(26878);
          return bool;
        }
        
        public final void Ws() {}
      });
      az.ayM();
      com.tencent.mm.model.c.awB().c(paramString, this.piT);
      az.ayM();
      com.tencent.mm.model.c.awG().aNG(paramString);
      com.tencent.mm.bj.c.f(0L, paramString);
      com.tencent.mm.bj.c.f(0L, this.piT.field_encryptUsername);
      switch (this.iMg)
      {
      case 11: 
      case 12: 
      default: 
        if (this.iMg == 9)
        {
          ac.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.piT.getSource());
          switch (this.piT.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.ofX.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label338;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iyx.p(paramString, this.ofX);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramString);
        if ((locala != null) && (!bs.isNullOrNil(locala.iJS)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.JC(), locala);
        }
        t.K(this.ofX, paramString);
        break;
        t.K(this.ofX, paramString);
        break;
        ac.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.K(this.ofX, paramString);
      }
      label338:
      this.ofX.setResult(-1, this.ofX.getIntent().putExtra("_delete_ok_", true));
      this.ofX.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).Kp(paramString);
    AppMethodBeat.o(26894);
  }
  
  public static void a(Activity paramActivity, ai paramai)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramai.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramai = str;
    if (str == null) {
      paramai = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramai);
    paramai = bs.bG(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = bs.bG(paramActivity.getIntent().getStringExtra("profileName"), bs.aLI(paramai));
    localIntent.putExtra("verify_gmail", paramai);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramai = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramai);
    paramai = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramai.aeD(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramai.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void apx(String paramString)
  {
    AppMethodBeat.i(196009);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(196009);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.iMg);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.piT.field_username);
    paramString.putExtra("Contact_Nick", this.piT.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.piT.field_conRemark);
    com.tencent.mm.plugin.profile.b.iyx.n(paramString, this.ofX);
    AppMethodBeat.o(196009);
  }
  
  private void dpG()
  {
    AppMethodBeat.i(26890);
    w.m(this.piT);
    this.piT.aah();
    AppMethodBeat.o(26890);
  }
  
  private void dpH()
  {
    AppMethodBeat.i(26891);
    w.n(this.piT);
    this.piT.aai();
    AppMethodBeat.o(26891);
  }
  
  private void dpK()
  {
    AppMethodBeat.i(196008);
    if (!com.tencent.mm.n.b.ln(this.piT.field_type))
    {
      apx(this.piT.field_username);
      AppMethodBeat.o(196008);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.iMg);
    localIntent.putExtra("Contact_User", this.piT.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.ofX.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.piT.eyl);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.piT.aaO())
    {
      localObject1 = null;
      localObject2 = this.ofX.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.ofX.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bs.isNullOrNil((String)localObject2)) || (!bs.isNullOrNil(str2))) {
        break label267;
      }
      if (!bs.isNullOrNil(this.piT.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.piT.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JC())) {
          localObject2 = bs.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPr()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.iyx.m(localIntent, this.ofX);
      AppMethodBeat.o(196008);
      return;
      label267:
      if ((!bs.isNullOrNil((String)localObject2)) || (!bs.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JC())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(str2);
        }
      }
    }
  }
  
  private void dpL()
  {
    AppMethodBeat.i(196010);
    ac.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.piT.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.ofX, new c.b()
    {
      public final void bHM()
      {
        AppMethodBeat.i(26880);
        com.tencent.mm.plugin.base.model.b.Z(b.e(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(26880);
      }
      
      public final void bHN()
      {
        AppMethodBeat.i(26881);
        com.tencent.mm.plugin.base.model.b.Y(b.e(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(26881);
      }
    });
    AppMethodBeat.o(196010);
  }
  
  public final void Ld(int paramInt)
  {
    AppMethodBeat.i(196007);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196007);
      return;
      if (this.piT.aaJ())
      {
        w.r(this.piT);
        com.tencent.mm.ui.base.h.cg(this.ofX, this.ofX.getString(2131757891));
      }
      for (;;)
      {
        az.ayM();
        this.piT = com.tencent.mm.model.c.awB().aNt(this.piT.field_username);
        com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.piT.field_username });
        AppMethodBeat.o(196007);
        return;
        w.q(this.piT);
        com.tencent.mm.ui.base.h.cg(this.ofX, this.ofX.getString(2131757665));
      }
      dpF();
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.piT.field_username });
      AppMethodBeat.o(196007);
      return;
      dpJ();
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.piT.field_username });
      AppMethodBeat.o(196007);
      return;
      dpK();
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.piT.field_username });
      AppMethodBeat.o(196007);
      return;
      oP(true);
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.piT.field_username });
      AppMethodBeat.o(196007);
      return;
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).a(this);
      dpI();
      AppMethodBeat.o(196007);
      return;
      dpL();
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.piT.field_username });
      AppMethodBeat.o(196007);
      return;
      dpM();
    }
  }
  
  public final void a(String paramString, int paramInt, cbt paramcbt)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      switch (this.iMg)
      {
      case 11: 
      case 12: 
      default: 
        if (this.iMg == 9)
        {
          ac.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.piT.getSource());
          switch (this.piT.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.ofX.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label246;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iyx.p(paramString, this.ofX);
        AppMethodBeat.o(26893);
        return;
        paramcbt = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramString);
        if ((paramcbt != null) && (!bs.isNullOrNil(paramcbt.iJS)))
        {
          paramcbt.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramcbt.JC(), paramcbt);
        }
        t.K(this.ofX, paramString);
        break;
        t.K(this.ofX, paramString);
        break;
        ac.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.K(this.ofX, paramString);
      }
      label246:
      this.ofX.setResult(-1, this.ofX.getIntent().putExtra("_delete_ok_", true));
      this.ofX.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!bs.isNullOrNil(paramcbt.hkR))
    {
      com.tencent.mm.ui.base.h.c(this.ofX, paramcbt.hkR, paramcbt.Title, true);
      AppMethodBeat.o(26893);
      return;
    }
    com.tencent.mm.ui.base.h.c(this.ofX, this.ofX.getString(2131755708), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void cYk()
  {
    AppMethodBeat.i(26883);
    this.ofX.addIconOptionMenu(0, 2131690603, this);
    AppMethodBeat.o(26883);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void dpF()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbC, 0);
    Object localObject2 = this.ofX;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.piT.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.ofX.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.ofX;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void dpI()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.ofX, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (w.wE(this.piT.field_username))
    {
      localObject = this.ofX.getString(2131758022, new Object[] { this.piT.aaS() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.piT.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.ofX, true, this.ofX.getString(2131757641), localView, this.ofX.getString(2131755707), this.ofX.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26874);
          b.d(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.vIn.isChecked()) {
              b.this.dpM();
            }
          }
          AppMethodBeat.o(26874);
        }
      }, null, 2131099904);
      AppMethodBeat.o(26892);
      return;
      localObject = this.ofX.getString(2131758020, new Object[] { this.piT.aaS() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void dpJ()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.piT.field_username);
    localIntent.putExtra("Select_block_List", this.piT.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.iyx.a(localIntent, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(26879);
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          String str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          String str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          j.dck().q(str1, str2, bool);
          j.dck().hF(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.n(b.e(b.this), b.e(b.this).getString(2131759420));
        }
        AppMethodBeat.o(26879);
      }
    }, this.ofX);
    AppMethodBeat.o(26895);
  }
  
  public final void dpM()
  {
    int i = 7;
    AppMethodBeat.i(26896);
    Intent localIntent = new Intent();
    switch (this.iMg)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.piT.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      d.b(this.ofX, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(26896);
      return;
      if (this.vIm) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.DH(this.piT.field_username));
        break;
      }
      if (this.vIm) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.DI(this.piT.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.L(7, this.piT.field_username));
      continue;
      if (this.vIm) {}
      for (i = 6;; i = 5)
      {
        if (!this.vIm) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.L(i, this.piT.field_username));
        break;
      }
      label402:
      if (!bs.isNullOrNil(this.piT.GWJ)) {}
      for (String str = this.piT.GWJ;; str = this.piT.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.DJ(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.L(45, this.piT.field_username));
      i = 45;
    }
  }
  
  public final void oP(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.piT.aaH())
    {
      dpH();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.ofX, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131302306);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (ai.aNc(this.piT.field_username))
    {
      i = 2131757738;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.piT.getSource() != 18) {
        break label222;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label239;
      }
      com.tencent.mm.ui.base.h.a(this.ofX, true, this.ofX.getString(2131757736), localView, this.ofX.getString(2131755835), this.ofX.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          b.a(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.vIn.isChecked()) {
              b.this.dpM();
            }
          }
          AppMethodBeat.o(26873);
        }
      }, null);
      AppMethodBeat.o(26889);
      return;
      i = 2131757737;
      break;
      label222:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label239:
    dpG();
    AppMethodBeat.o(26889);
  }
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!w.xj(this.piT.field_username))
    {
      if (ai.aNc(this.piT.field_username)) {
        paraml.aJ(1, 2131757927, 2131689826);
      }
    }
    else
    {
      if ((com.tencent.mm.n.b.ln(this.piT.field_type)) && (!w.xj(this.piT.field_username)))
      {
        i = 2131757812;
        if (this.piT.exL != 1) {
          break label481;
        }
        i = 2131757810;
        label89:
        paraml.aJ(4, i, 2131689831);
      }
      if (!this.piT.aaJ()) {
        break label499;
      }
      str = this.ofX.getResources().getString(2131757890);
      label123:
      if ((com.tencent.mm.n.b.ln(this.piT.field_type)) && (!w.xj(this.piT.field_username))) {
        paraml.a(2, str, 2131689829);
      }
      if ((com.tencent.mm.n.b.ln(this.piT.field_type)) || (!this.ofX.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (ai.aNc(this.piT.field_username))
        {
          if (com.tencent.mm.m.g.ZY().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!ai.aNc(this.piT.field_username)) || (!"3552365301".equals(this.piT.field_openImAppid))) {}
        }
        else if ((w.xj(this.piT.field_username)) || (!com.tencent.mm.n.b.ln(this.piT.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.piT.field_openImAppid)) {
          break label526;
        }
        paraml.aJ(3, 2131757748, 2131689817);
      }
      label311:
      if (!this.piT.aaH()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.ofX.getString(2131757741);; str = this.ofX.getString(2131757736))
    {
      if (!w.xj(this.piT.field_username)) {
        paraml.a(5, str, 2131689795);
      }
      if ((!w.xj(this.piT.field_username)) && (com.tencent.mm.n.b.ln(this.piT.field_type))) {
        paraml.aJ(9, 2131756596, 2131689799);
      }
      if (com.tencent.mm.n.b.ln(this.piT.field_type)) {
        paraml.aJ(7, 2131757578, 2131689803);
      }
      if ((com.tencent.mm.n.b.ln(this.piT.field_type)) && (!w.xj(this.piT.field_username))) {
        paraml.aJ(6, 2131756457, 2131689802);
      }
      AppMethodBeat.o(26886);
      return;
      paraml.aJ(1, 2131757731, 2131689826);
      break;
      label481:
      if (this.piT.exL != 2) {
        break label89;
      }
      i = 2131757811;
      break label89;
      label499:
      str = this.ofX.getResources().getString(2131757664);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paraml.aJ(3, 2131761879, 2131689817);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    Ld(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.piT.fLJ <= 0)
    {
      az.ayM();
      com.tencent.mm.model.c.awB().c(this.piT, true);
    }
    paramMenuItem = new Intent(this.ofX.getIntent());
    paramMenuItem.putExtra("Contact_User", this.piT.field_username);
    paramMenuItem.setClass(this.ofX, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.ofX.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(this.ofX.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.piT.field_username });
    AppMethodBeat.o(26885);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */