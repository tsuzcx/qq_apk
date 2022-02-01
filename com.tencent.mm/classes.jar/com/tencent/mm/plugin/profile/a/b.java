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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.am;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, n.d, n.e
{
  private boolean isDeleteCancel;
  private int jij;
  public MMActivity oPS;
  public an pSY;
  private boolean xfh;
  
  public b(MMActivity paramMMActivity, an paraman)
  {
    AppMethodBeat.i(26882);
    this.oPS = paramMMActivity;
    this.pSY = paraman;
    this.jij = this.oPS.getIntent().getIntExtra("Contact_Scene", 9);
    this.xfh = this.oPS.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void Oq(String paramString)
  {
    AppMethodBeat.i(26894);
    this.pSY.acT();
    if (an.aUq(paramString))
    {
      this.pSY.setSource(0);
      ((r)com.tencent.mm.kernel.g.ab(r.class)).wr(paramString);
      bl.a(paramString, new bl.a()
      {
        public final boolean YT()
        {
          AppMethodBeat.i(186512);
          boolean bool = b.g(b.this);
          AppMethodBeat.o(186512);
          return bool;
        }
        
        public final void YU() {}
      });
      bc.aCg();
      com.tencent.mm.model.c.azF().c(paramString, this.pSY);
      bc.aCg();
      com.tencent.mm.model.c.azL().aUY(paramString);
      com.tencent.mm.bj.c.f(0L, paramString);
      com.tencent.mm.bj.c.f(0L, this.pSY.field_encryptUsername);
      switch (this.jij)
      {
      case 11: 
      case 12: 
      default: 
        if (this.jij == 9)
        {
          ae.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.pSY.getSource());
          switch (this.pSY.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.oPS.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label338;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iUz.p(paramString, this.oPS);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paramString);
        if ((locala != null) && (!bu.isNullOrNil(locala.jfU)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.Lj(), locala);
        }
        t.K(this.oPS, paramString);
        break;
        t.K(this.oPS, paramString);
        break;
        ae.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.K(this.oPS, paramString);
      }
      label338:
      this.oPS.setResult(-1, this.oPS.getIntent().putExtra("_delete_ok_", true));
      this.oPS.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).Oq(paramString);
    AppMethodBeat.o(26894);
  }
  
  public static void a(Activity paramActivity, an paraman)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paraman.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paraman = str;
    if (str == null) {
      paraman = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paraman);
    paraman = bu.bI(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = bu.bI(paramActivity.getIntent().getStringExtra("profileName"), bu.aSL(paraman));
    localIntent.putExtra("verify_gmail", paraman);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paraman = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paraman);
    paraman = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paraman.ahE(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paraman.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void avS(String paramString)
  {
    AppMethodBeat.i(186516);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(186516);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.jij);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.pSY.field_username);
    paramString.putExtra("Contact_Nick", this.pSY.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.pSY.field_conRemark);
    com.tencent.mm.plugin.profile.b.iUz.n(paramString, this.oPS);
    AppMethodBeat.o(186516);
  }
  
  private am dDA()
  {
    AppMethodBeat.i(186514);
    am localam1 = com.tencent.mm.contact.a.a.h(this.pSY);
    if (localam1 != null)
    {
      am localam2 = localam1.b(new com.tencent.mm.contact.a.b() {});
      MMActivity localMMActivity = this.oPS;
      this.oPS.getString(2131755906);
      localam2.E(localMMActivity, this.oPS.getString(2131755936));
    }
    AppMethodBeat.o(186514);
    return localam1;
  }
  
  private void dDB()
  {
    AppMethodBeat.i(26891);
    am localam = com.tencent.mm.contact.a.a.i(this.pSY);
    if (localam != null)
    {
      localam = localam.b(new com.tencent.mm.contact.a.b() {});
      MMActivity localMMActivity = this.oPS;
      this.oPS.getString(2131755906);
      localam.E(localMMActivity, this.oPS.getString(2131755936));
    }
    AppMethodBeat.o(26891);
  }
  
  private void dDE()
  {
    AppMethodBeat.i(186515);
    if (!com.tencent.mm.contact.c.lO(this.pSY.field_type))
    {
      avS(this.pSY.field_username);
      AppMethodBeat.o(186515);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.jij);
    localIntent.putExtra("Contact_User", this.pSY.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.oPS.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.pSY.eRu);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.pSY.adC())
    {
      localObject1 = null;
      localObject2 = this.oPS.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.oPS.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bu.isNullOrNil((String)localObject2)) || (!bu.isNullOrNil(str2))) {
        break label267;
      }
      if (!bu.isNullOrNil(this.pSY.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.pSY.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lj())) {
          localObject2 = bu.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aTc()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.iUz.m(localIntent, this.oPS);
      AppMethodBeat.o(186515);
      return;
      label267:
      if ((!bu.isNullOrNil((String)localObject2)) || (!bu.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lj())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(str2);
        }
      }
    }
  }
  
  private void dDF()
  {
    AppMethodBeat.i(186517);
    ae.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.pSY.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.oPS, new c.b()
    {
      public final void bMV()
      {
        AppMethodBeat.i(186503);
        com.tencent.mm.plugin.base.model.b.aa(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(186503);
      }
      
      public final void bMW()
      {
        AppMethodBeat.i(186504);
        com.tencent.mm.plugin.base.model.b.Z(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(186504);
      }
    });
    AppMethodBeat.o(186517);
  }
  
  public final void FN(int paramInt)
  {
    AppMethodBeat.i(186513);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(186513);
      return;
      if (this.pSY.adx())
      {
        x.y(this.pSY);
        h.cm(this.oPS, this.oPS.getString(2131757891));
      }
      for (;;)
      {
        bc.aCg();
        this.pSY = com.tencent.mm.model.c.azF().BH(this.pSY.field_username);
        com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.pSY.field_username });
        AppMethodBeat.o(186513);
        return;
        x.x(this.pSY);
        h.cm(this.oPS, this.oPS.getString(2131757665));
      }
      dDz();
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.pSY.field_username });
      AppMethodBeat.o(186513);
      return;
      dDD();
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.pSY.field_username });
      AppMethodBeat.o(186513);
      return;
      dDE();
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.pSY.field_username });
      AppMethodBeat.o(186513);
      return;
      pw(true);
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.pSY.field_username });
      AppMethodBeat.o(186513);
      return;
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).a(this);
      dDC();
      AppMethodBeat.o(186513);
      return;
      dDF();
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.pSY.field_username });
      AppMethodBeat.o(186513);
      return;
      dDG();
    }
  }
  
  public final void a(String paramString, int paramInt, che paramche)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      if (!paramString.equals(this.pSY.field_username))
      {
        ae.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", new Object[] { this.pSY.field_username, paramString });
        AppMethodBeat.o(26893);
        return;
      }
      switch (this.jij)
      {
      case 11: 
      case 12: 
      default: 
        if (this.jij == 9)
        {
          ae.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.pSY.getSource());
          switch (this.pSY.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.oPS.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label294;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iUz.p(paramString, this.oPS);
        AppMethodBeat.o(26893);
        return;
        paramche = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paramString);
        if ((paramche != null) && (!bu.isNullOrNil(paramche.jfU)))
        {
          paramche.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramche.Lj(), paramche);
        }
        t.K(this.oPS, paramString);
        break;
        t.K(this.oPS, paramString);
        break;
        ae.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.K(this.oPS, paramString);
      }
      label294:
      this.oPS.setResult(-1, this.oPS.getIntent().putExtra("_delete_ok_", true));
      this.oPS.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!bu.isNullOrNil(paramche.hFS))
    {
      h.c(this.oPS, paramche.hFS, paramche.Title, true);
      AppMethodBeat.o(26893);
      return;
    }
    h.c(this.oPS, this.oPS.getString(2131755708), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.oPS, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (x.Al(this.pSY.field_username))
    {
      localObject = this.oPS.getString(2131758022, new Object[] { this.pSY.adG() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.pSY.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      h.a(this.oPS, true, this.oPS.getString(2131757641), localView, this.oPS.getString(2131755707), this.oPS.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26877);
          b.e(b.this);
          if (b.c(b.this).getSource() == 18)
          {
            b.f(b.this);
            if (this.xfi.isChecked()) {
              b.this.dDG();
            }
          }
          AppMethodBeat.o(26877);
        }
      }, null, 2131099904);
      AppMethodBeat.o(26892);
      return;
      localObject = this.oPS.getString(2131758020, new Object[] { this.pSY.adG() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void dDD()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.pSY.field_username);
    localIntent.putExtra("Select_block_List", this.pSY.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.iUz.a(localIntent, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(186502);
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          String str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          String str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          com.tencent.mm.plugin.messenger.a.g.doC().q(str1, str2, bool);
          com.tencent.mm.plugin.messenger.a.g.doC().hW(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.n(b.d(b.this), b.d(b.this).getString(2131759420));
        }
        AppMethodBeat.o(186502);
      }
    }, this.oPS);
    AppMethodBeat.o(26895);
  }
  
  public final void dDG()
  {
    int i = 7;
    AppMethodBeat.i(186518);
    Intent localIntent = new Intent();
    switch (this.jij)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.pSY.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.br.d.b(this.oPS, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(186518);
      return;
      if (this.xfh) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Ho(this.pSY.field_username));
        break;
      }
      if (this.xfh) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Hp(this.pSY.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.M(7, this.pSY.field_username));
      continue;
      if (this.xfh) {}
      for (i = 6;; i = 5)
      {
        if (!this.xfh) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.M(i, this.pSY.field_username));
        break;
      }
      label402:
      if (!bu.isNullOrNil(this.pSY.JeD)) {}
      for (String str = this.pSY.JeD;; str = this.pSY.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Hq(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.M(45, this.pSY.field_username));
      i = 45;
    }
  }
  
  public final void dDz()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOK, 0);
    Object localObject2 = this.oPS;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.pSY.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.oPS.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.oPS;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void dkv()
  {
    AppMethodBeat.i(26883);
    this.oPS.addIconOptionMenu(0, 2131690603, this);
    AppMethodBeat.o(26883);
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!x.AQ(this.pSY.field_username))
    {
      if (an.aUq(this.pSY.field_username)) {
        paraml.aM(1, 2131757927, 2131689826);
      }
    }
    else
    {
      if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!x.AQ(this.pSY.field_username)))
      {
        i = 2131757812;
        if (this.pSY.eQV != 1) {
          break label481;
        }
        i = 2131757810;
        label89:
        paraml.aM(4, i, 2131689831);
      }
      if (!this.pSY.adx()) {
        break label499;
      }
      str = this.oPS.getResources().getString(2131757890);
      label123:
      if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!x.AQ(this.pSY.field_username))) {
        paraml.a(2, str, 2131689829);
      }
      if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (!this.oPS.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (an.aUq(this.pSY.field_username))
        {
          if (com.tencent.mm.n.g.acL().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!an.aUq(this.pSY.field_username)) || (!"3552365301".equals(this.pSY.field_openImAppid))) {}
        }
        else if ((x.AQ(this.pSY.field_username)) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.pSY.field_openImAppid)) {
          break label526;
        }
        paraml.aM(3, 2131757748, 2131689817);
      }
      label311:
      if (!this.pSY.adv()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.oPS.getString(2131757741);; str = this.oPS.getString(2131757736))
    {
      if (!x.AQ(this.pSY.field_username)) {
        paraml.a(5, str, 2131689795);
      }
      if ((!x.AQ(this.pSY.field_username)) && (com.tencent.mm.contact.c.lO(this.pSY.field_type))) {
        paraml.aM(9, 2131756596, 2131689799);
      }
      if (com.tencent.mm.contact.c.lO(this.pSY.field_type)) {
        paraml.aM(7, 2131757578, 2131689803);
      }
      if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!x.AQ(this.pSY.field_username))) {
        paraml.aM(6, 2131756457, 2131689802);
      }
      AppMethodBeat.o(26886);
      return;
      paraml.aM(1, 2131757731, 2131689826);
      break;
      label481:
      if (this.pSY.eQV != 2) {
        break label89;
      }
      i = 2131757811;
      break label89;
      label499:
      str = this.oPS.getResources().getString(2131757664);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paraml.aM(3, 2131761879, 2131689817);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    FN(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.pSY.ght <= 0)
    {
      bc.aCg();
      com.tencent.mm.model.c.azF().d(this.pSY, true);
    }
    paramMenuItem = new Intent(this.oPS.getIntent());
    paramMenuItem.putExtra("Contact_User", this.pSY.field_username);
    paramMenuItem.setClass(this.oPS, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.oPS.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(this.oPS.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.pSY.field_username });
    AppMethodBeat.o(26885);
    return true;
  }
  
  public final void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.pSY.adv())
    {
      dDB();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.oPS, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131302306);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (an.aUq(this.pSY.field_username))
    {
      i = 2131757738;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.pSY.getSource() != 18) {
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
      h.a(this.oPS, false, this.oPS.getString(2131757736), localView, this.oPS.getString(2131755835), this.oPS.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          paramAnonymousDialogInterface = b.a(b.this);
          if (paramAnonymousDialogInterface == null)
          {
            ae.e("MicroMsg.ProfileMenuManager", "dealSetBlack iContactCallbackFactory is null????");
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
      i = 2131757737;
      break;
      label229:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label246:
    dDA();
    AppMethodBeat.o(26889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */