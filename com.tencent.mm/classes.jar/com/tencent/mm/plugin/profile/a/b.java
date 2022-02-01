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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
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
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, n.c, n.d
{
  private int ima;
  private boolean isDeleteCancel;
  public MMActivity nCW;
  public af oFt;
  private boolean uzt;
  
  public b(MMActivity paramMMActivity, af paramaf)
  {
    AppMethodBeat.i(26882);
    this.nCW = paramMMActivity;
    this.oFt = paramaf;
    this.ima = this.nCW.getIntent().getIntExtra("Contact_Scene", 9);
    this.uzt = this.nCW.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void Gl(String paramString)
  {
    AppMethodBeat.i(26894);
    this.oFt.Zl();
    if (af.aHH(paramString))
    {
      this.oFt.setSource(0);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Be(paramString);
      bi.a(paramString, new bi.a()
      {
        public final boolean Vt()
        {
          AppMethodBeat.i(26878);
          boolean bool = b.f(b.this);
          AppMethodBeat.o(26878);
          return bool;
        }
        
        public final void Vu() {}
      });
      az.arV();
      com.tencent.mm.model.c.apM().c(paramString, this.oFt);
      az.arV();
      com.tencent.mm.model.c.apR().aIl(paramString);
      com.tencent.mm.bk.c.f(0L, paramString);
      com.tencent.mm.bk.c.f(0L, this.oFt.field_encryptUsername);
      switch (this.ima)
      {
      case 11: 
      case 12: 
      default: 
        if (this.ima == 9)
        {
          ad.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.oFt.getSource());
          switch (this.oFt.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.nCW.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label338;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.hYt.p(paramString, this.nCW);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramString);
        if ((locala != null) && (!bt.isNullOrNil(locala.ijL)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.JS(), locala);
        }
        t.J(this.nCW, paramString);
        break;
        t.J(this.nCW, paramString);
        break;
        ad.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.J(this.nCW, paramString);
      }
      label338:
      this.nCW.setResult(-1, this.nCW.getIntent().putExtra("_delete_ok_", true));
      this.nCW.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).Gl(paramString);
    AppMethodBeat.o(26894);
  }
  
  public static void a(Activity paramActivity, af paramaf)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramaf.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramaf = str;
    if (str == null) {
      paramaf = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramaf);
    paramaf = bt.by(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = bt.by(paramActivity.getIntent().getStringExtra("profileName"), bt.aGr(paramaf));
    localIntent.putExtra("verify_gmail", paramaf);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramaf = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramaf);
    paramaf = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramaf.adn(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramaf.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void aky(String paramString)
  {
    AppMethodBeat.i(191189);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(191189);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.ima);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.oFt.field_username);
    paramString.putExtra("Contact_Nick", this.oFt.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.oFt.field_conRemark);
    com.tencent.mm.plugin.profile.b.hYt.n(paramString, this.nCW);
    AppMethodBeat.o(191189);
  }
  
  private void dbY()
  {
    AppMethodBeat.i(26890);
    w.m(this.oFt);
    this.oFt.Zm();
    AppMethodBeat.o(26890);
  }
  
  private void dbZ()
  {
    AppMethodBeat.i(26891);
    w.n(this.oFt);
    this.oFt.Zn();
    AppMethodBeat.o(26891);
  }
  
  private void dcc()
  {
    AppMethodBeat.i(191188);
    if (!com.tencent.mm.n.b.ls(this.oFt.field_type))
    {
      aky(this.oFt.field_username);
      AppMethodBeat.o(191188);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.ima);
    localIntent.putExtra("Contact_User", this.oFt.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.nCW.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.oFt.evO);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.oFt.ZT())
    {
      localObject1 = null;
      localObject2 = this.nCW.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.nCW.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil(str2))) {
        break label267;
      }
      if (!bt.isNullOrNil(this.oFt.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.oFt.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JS())) {
          localObject2 = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIA()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.hYt.m(localIntent, this.nCW);
      AppMethodBeat.o(191188);
      return;
      label267:
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JS())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(str2);
        }
      }
    }
  }
  
  private void dcd()
  {
    AppMethodBeat.i(191190);
    ad.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.oFt.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.nCW, new c.b()
    {
      public final void bAQ()
      {
        AppMethodBeat.i(26880);
        com.tencent.mm.plugin.base.model.b.Y(b.e(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(26880);
      }
      
      public final void bAR()
      {
        AppMethodBeat.i(26881);
        com.tencent.mm.plugin.base.model.b.X(b.e(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(26881);
      }
    });
    AppMethodBeat.o(191190);
  }
  
  public final void Je(int paramInt)
  {
    AppMethodBeat.i(191187);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191187);
      return;
      if (this.oFt.ZO())
      {
        w.r(this.oFt);
        com.tencent.mm.ui.base.h.cf(this.nCW, this.nCW.getString(2131757891));
      }
      for (;;)
      {
        az.arV();
        this.oFt = com.tencent.mm.model.c.apM().aHY(this.oFt.field_username);
        com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.oFt.field_username });
        AppMethodBeat.o(191187);
        return;
        w.q(this.oFt);
        com.tencent.mm.ui.base.h.cf(this.nCW, this.nCW.getString(2131757665));
      }
      dbX();
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.oFt.field_username });
      AppMethodBeat.o(191187);
      return;
      dcb();
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.oFt.field_username });
      AppMethodBeat.o(191187);
      return;
      dcc();
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.oFt.field_username });
      AppMethodBeat.o(191187);
      return;
      nV(true);
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.oFt.field_username });
      AppMethodBeat.o(191187);
      return;
      ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).a(this);
      dca();
      AppMethodBeat.o(191187);
      return;
      dcd();
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.oFt.field_username });
      AppMethodBeat.o(191187);
      return;
      dce();
    }
  }
  
  public final void a(String paramString, int paramInt, bwz parambwz)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      switch (this.ima)
      {
      case 11: 
      case 12: 
      default: 
        if (this.ima == 9)
        {
          ad.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.oFt.getSource());
          switch (this.oFt.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.nCW.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label246;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.hYt.p(paramString, this.nCW);
        AppMethodBeat.o(26893);
        return;
        parambwz = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramString);
        if ((parambwz != null) && (!bt.isNullOrNil(parambwz.ijL)))
        {
          parambwz.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambwz.JS(), parambwz);
        }
        t.J(this.nCW, paramString);
        break;
        t.J(this.nCW, paramString);
        break;
        ad.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.J(this.nCW, paramString);
      }
      label246:
      this.nCW.setResult(-1, this.nCW.getIntent().putExtra("_delete_ok_", true));
      this.nCW.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!bt.isNullOrNil(parambwz.gKr))
    {
      com.tencent.mm.ui.base.h.c(this.nCW, parambwz.gKr, parambwz.Title, true);
      AppMethodBeat.o(26893);
      return;
    }
    com.tencent.mm.ui.base.h.c(this.nCW, this.nCW.getString(2131755708), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void cKF()
  {
    AppMethodBeat.i(26883);
    this.nCW.addIconOptionMenu(0, 2131690603, this);
    AppMethodBeat.o(26883);
  }
  
  public final void dbX()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxj, 0);
    Object localObject2 = this.nCW;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.oFt.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.nCW.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.nCW;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void dca()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.nCW, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (w.sB(this.oFt.field_username))
    {
      localObject = this.nCW.getString(2131758022, new Object[] { this.oFt.ZX() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.oFt.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.nCW, true, this.nCW.getString(2131757641), localView, this.nCW.getString(2131755707), this.nCW.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26874);
          b.d(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.uzu.isChecked()) {
              b.this.dce();
            }
          }
          AppMethodBeat.o(26874);
        }
      }, null, 2131099904);
      AppMethodBeat.o(26892);
      return;
      localObject = this.nCW.getString(2131758020, new Object[] { this.oFt.ZX() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.oFt.field_username);
    localIntent.putExtra("Select_block_List", this.oFt.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.hYt.a(localIntent, new MMActivity.a()
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
          j.cOB().q(str1, str2, bool);
          j.cOB().hm(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.n(b.e(b.this), b.e(b.this).getString(2131759420));
        }
        AppMethodBeat.o(26879);
      }
    }, this.nCW);
    AppMethodBeat.o(26895);
  }
  
  public final void dce()
  {
    int i = 7;
    AppMethodBeat.i(26896);
    Intent localIntent = new Intent();
    switch (this.ima)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.oFt.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      d.b(this.nCW, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(26896);
      return;
      if (this.uzt) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.zC(this.oFt.field_username));
        break;
      }
      if (this.uzt) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.zD(this.oFt.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.K(7, this.oFt.field_username));
      continue;
      if (this.uzt) {}
      for (i = 6;; i = 5)
      {
        if (!this.uzt) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.K(i, this.oFt.field_username));
        break;
      }
      label402:
      if (!bt.isNullOrNil(this.oFt.FxJ)) {}
      for (String str = this.oFt.FxJ;; str = this.oFt.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.zE(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.K(45, this.oFt.field_username));
      i = 45;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.f.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.f.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void nV(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.oFt.ZM())
    {
      dbZ();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.nCW, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131302306);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (af.aHH(this.oFt.field_username))
    {
      i = 2131757738;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.oFt.getSource() != 18) {
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
      com.tencent.mm.ui.base.h.a(this.nCW, true, this.nCW.getString(2131757736), localView, this.nCW.getString(2131755835), this.nCW.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          b.a(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.uzu.isChecked()) {
              b.this.dce();
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
    dbY();
    AppMethodBeat.o(26889);
  }
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!w.tg(this.oFt.field_username))
    {
      if (af.aHH(this.oFt.field_username)) {
        paraml.aI(1, 2131757927, 2131689826);
      }
    }
    else
    {
      if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!w.tg(this.oFt.field_username)))
      {
        i = 2131757812;
        if (this.oFt.evp != 1) {
          break label481;
        }
        i = 2131757810;
        label89:
        paraml.aI(4, i, 2131689831);
      }
      if (!this.oFt.ZO()) {
        break label499;
      }
      str = this.nCW.getResources().getString(2131757890);
      label123:
      if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!w.tg(this.oFt.field_username))) {
        paraml.a(2, str, 2131689829);
      }
      if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) || (!this.nCW.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (af.aHH(this.oFt.field_username))
        {
          if (com.tencent.mm.m.g.Zd().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!af.aHH(this.oFt.field_username)) || (!"3552365301".equals(this.oFt.field_openImAppid))) {}
        }
        else if ((w.tg(this.oFt.field_username)) || (!com.tencent.mm.n.b.ls(this.oFt.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.oFt.field_openImAppid)) {
          break label526;
        }
        paraml.aI(3, 2131757748, 2131689817);
      }
      label311:
      if (!this.oFt.ZM()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.nCW.getString(2131757741);; str = this.nCW.getString(2131757736))
    {
      if (!w.tg(this.oFt.field_username)) {
        paraml.a(5, str, 2131689795);
      }
      if ((!w.tg(this.oFt.field_username)) && (com.tencent.mm.n.b.ls(this.oFt.field_type))) {
        paraml.aI(9, 2131756596, 2131689799);
      }
      if (com.tencent.mm.n.b.ls(this.oFt.field_type)) {
        paraml.aI(7, 2131757578, 2131689803);
      }
      if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!w.tg(this.oFt.field_username))) {
        paraml.aI(6, 2131756457, 2131689802);
      }
      AppMethodBeat.o(26886);
      return;
      paraml.aI(1, 2131757731, 2131689826);
      break;
      label481:
      if (this.oFt.evp != 2) {
        break label89;
      }
      i = 2131757811;
      break label89;
      label499:
      str = this.nCW.getResources().getString(2131757664);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paraml.aI(3, 2131761879, 2131689817);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    Je(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.oFt.fId <= 0)
    {
      az.arV();
      com.tencent.mm.model.c.apM().c(this.oFt, true);
    }
    paramMenuItem = new Intent(this.nCW.getIntent());
    paramMenuItem.putExtra("Contact_User", this.oFt.field_username);
    paramMenuItem.setClass(this.nCW, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.nCW.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(this.nCW.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.oFt.field_username });
    AppMethodBeat.o(26885);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */