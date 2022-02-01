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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cgk;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
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
  private int jfq;
  public MMActivity oJq;
  public am pMt;
  private boolean wPt;
  
  public b(MMActivity paramMMActivity, am paramam)
  {
    AppMethodBeat.i(26882);
    this.oJq = paramMMActivity;
    this.pMt = paramam;
    this.jfq = this.oJq.getIntent().getIntExtra("Contact_Scene", 9);
    this.wPt = this.oJq.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void NI(String paramString)
  {
    AppMethodBeat.i(26894);
    this.pMt.acI();
    if (am.aSQ(paramString))
    {
      this.pMt.setSource(0);
      ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).Iz(paramString);
      bj.a(paramString, new bj.a()
      {
        public final boolean YK()
        {
          AppMethodBeat.i(193241);
          boolean bool = b.f(b.this);
          AppMethodBeat.o(193241);
          return bool;
        }
        
        public final void YL() {}
      });
      ba.aBQ();
      com.tencent.mm.model.c.azp().c(paramString, this.pMt);
      ba.aBQ();
      com.tencent.mm.model.c.azv().aTx(paramString);
      com.tencent.mm.bk.c.f(0L, paramString);
      com.tencent.mm.bk.c.f(0L, this.pMt.field_encryptUsername);
      switch (this.jfq)
      {
      case 11: 
      case 12: 
      default: 
        if (this.jfq == 9)
        {
          ad.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.pMt.getSource());
          switch (this.pMt.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.oJq.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label338;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iRG.p(paramString, this.oJq);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramString);
        if ((locala != null) && (!bt.isNullOrNil(locala.jdb)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.Lb(), locala);
        }
        t.J(this.oJq, paramString);
        break;
        t.J(this.oJq, paramString);
        break;
        ad.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.J(this.oJq, paramString);
      }
      label338:
      this.oJq.setResult(-1, this.oJq.getIntent().putExtra("_delete_ok_", true));
      this.oJq.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).NI(paramString);
    AppMethodBeat.o(26894);
  }
  
  public static void a(Activity paramActivity, am paramam)
  {
    AppMethodBeat.i(26897);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramam.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramam = str;
    if (str == null) {
      paramam = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramam);
    paramam = bt.bI(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = bt.bI(paramActivity.getIntent().getStringExtra("profileName"), bt.aRo(paramam));
    localIntent.putExtra("verify_gmail", paramam);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramam = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramam);
    paramam = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramam.ahp(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramam.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void auD(String paramString)
  {
    AppMethodBeat.i(193247);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(193247);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.jfq);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.pMt.field_username);
    paramString.putExtra("Contact_Nick", this.pMt.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.pMt.field_conRemark);
    com.tencent.mm.plugin.profile.b.iRG.n(paramString, this.oJq);
    AppMethodBeat.o(193247);
  }
  
  private void dAj()
  {
    AppMethodBeat.i(26890);
    w.m(this.pMt);
    this.pMt.acJ();
    AppMethodBeat.o(26890);
  }
  
  private void dAk()
  {
    AppMethodBeat.i(26891);
    w.n(this.pMt);
    this.pMt.acK();
    AppMethodBeat.o(26891);
  }
  
  private void dAn()
  {
    AppMethodBeat.i(193246);
    if (!com.tencent.mm.o.b.lM(this.pMt.field_type))
    {
      auD(this.pMt.field_username);
      AppMethodBeat.o(193246);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.jfq);
    localIntent.putExtra("Contact_User", this.pMt.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.oJq.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.pMt.ePJ);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.pMt.adr())
    {
      localObject1 = null;
      localObject2 = this.oJq.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.oJq.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil(str2))) {
        break label267;
      }
      if (!bt.isNullOrNil(this.pMt.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.pMt.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lb())) {
          localObject2 = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSD()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.iRG.m(localIntent, this.oJq);
      AppMethodBeat.o(193246);
      return;
      label267:
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lb())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(str2);
        }
      }
    }
  }
  
  private void dAo()
  {
    AppMethodBeat.i(193248);
    ad.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.pMt.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.oJq, new c.b()
    {
      public final void bLX()
      {
        AppMethodBeat.i(193243);
        com.tencent.mm.plugin.base.model.b.Y(b.d(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(193243);
      }
      
      public final void bLY()
      {
        AppMethodBeat.i(193244);
        com.tencent.mm.plugin.base.model.b.X(b.d(b.this), b.b(b.this).field_username);
        AppMethodBeat.o(193244);
      }
    });
    AppMethodBeat.o(193248);
  }
  
  public final void Fq(int paramInt)
  {
    AppMethodBeat.i(193245);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193245);
      return;
      if (this.pMt.adm())
      {
        w.r(this.pMt);
        h.cl(this.oJq, this.oJq.getString(2131757891));
      }
      for (;;)
      {
        ba.aBQ();
        this.pMt = com.tencent.mm.model.c.azp().Bf(this.pMt.field_username);
        com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.pMt.field_username });
        AppMethodBeat.o(193245);
        return;
        w.q(this.pMt);
        h.cl(this.oJq, this.oJq.getString(2131757665));
      }
      dAi();
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.pMt.field_username });
      AppMethodBeat.o(193245);
      return;
      dAm();
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.pMt.field_username });
      AppMethodBeat.o(193245);
      return;
      dAn();
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.pMt.field_username });
      AppMethodBeat.o(193245);
      return;
      po(true);
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.pMt.field_username });
      AppMethodBeat.o(193245);
      return;
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).a(this);
      dAl();
      AppMethodBeat.o(193245);
      return;
      dAo();
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.pMt.field_username });
      AppMethodBeat.o(193245);
      return;
      dAp();
    }
  }
  
  public final void a(String paramString, int paramInt, cgk paramcgk)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      if (!paramString.equals(this.pMt.field_username))
      {
        ad.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", new Object[] { this.pMt.field_username, paramString });
        AppMethodBeat.o(26893);
        return;
      }
      switch (this.jfq)
      {
      case 11: 
      case 12: 
      default: 
        if (this.jfq == 9)
        {
          ad.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.pMt.getSource());
          switch (this.pMt.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.oJq.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label294;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.iRG.p(paramString, this.oJq);
        AppMethodBeat.o(26893);
        return;
        paramcgk = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramString);
        if ((paramcgk != null) && (!bt.isNullOrNil(paramcgk.jdb)))
        {
          paramcgk.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramcgk.Lb(), paramcgk);
        }
        t.J(this.oJq, paramString);
        break;
        t.J(this.oJq, paramString);
        break;
        ad.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.J(this.oJq, paramString);
      }
      label294:
      this.oJq.setResult(-1, this.oJq.getIntent().putExtra("_delete_ok_", true));
      this.oJq.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!bt.isNullOrNil(paramcgk.hDa))
    {
      h.c(this.oJq, paramcgk.hDa, paramcgk.Title, true);
      AppMethodBeat.o(26893);
      return;
    }
    h.c(this.oJq, this.oJq.getString(2131755708), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void dAi()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHe, 0);
    Object localObject2 = this.oJq;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.pMt.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.oJq.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.oJq;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void dAl()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.oJq, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (w.zB(this.pMt.field_username))
    {
      localObject = this.oJq.getString(2131758022, new Object[] { this.pMt.adv() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.pMt.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      h.a(this.oJq, true, this.oJq.getString(2131757641), localView, this.oJq.getString(2131755707), this.oJq.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(193238);
          b.e(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.wPu.isChecked()) {
              b.this.dAp();
            }
          }
          AppMethodBeat.o(193238);
        }
      }, null, 2131099904);
      AppMethodBeat.o(26892);
      return;
      localObject = this.oJq.getString(2131758020, new Object[] { this.pMt.adv() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void dAm()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.pMt.field_username);
    localIntent.putExtra("Select_block_List", this.pMt.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.iRG.a(localIntent, new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(193242);
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          String str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          String str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          com.tencent.mm.plugin.messenger.a.g.dlD().q(str1, str2, bool);
          com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.n(b.d(b.this), b.d(b.this).getString(2131759420));
        }
        AppMethodBeat.o(193242);
      }
    }, this.oJq);
    AppMethodBeat.o(26895);
  }
  
  public final void dAp()
  {
    int i = 7;
    AppMethodBeat.i(26896);
    Intent localIntent = new Intent();
    switch (this.jfq)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.pMt.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.bs.d.b(this.oJq, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(26896);
      return;
      if (this.wPt) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.GM(this.pMt.field_username));
        break;
      }
      if (this.wPt) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.GN(this.pMt.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.M(7, this.pMt.field_username));
      continue;
      if (this.wPt) {}
      for (i = 6;; i = 5)
      {
        if (!this.wPt) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.M(i, this.pMt.field_username));
        break;
      }
      label402:
      if (!bt.isNullOrNil(this.pMt.IJW)) {}
      for (String str = this.pMt.IJW;; str = this.pMt.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.GO(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bk.a.M(45, this.pMt.field_username));
      i = 45;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.h.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void dhw()
  {
    AppMethodBeat.i(26883);
    this.oJq.addIconOptionMenu(0, 2131690603, this);
    AppMethodBeat.o(26883);
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!w.Ag(this.pMt.field_username))
    {
      if (am.aSQ(this.pMt.field_username)) {
        paraml.aL(1, 2131757927, 2131689826);
      }
    }
    else
    {
      if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!w.Ag(this.pMt.field_username)))
      {
        i = 2131757812;
        if (this.pMt.ePk != 1) {
          break label481;
        }
        i = 2131757810;
        label89:
        paraml.aL(4, i, 2131689831);
      }
      if (!this.pMt.adm()) {
        break label499;
      }
      str = this.oJq.getResources().getString(2131757890);
      label123:
      if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!w.Ag(this.pMt.field_username))) {
        paraml.a(2, str, 2131689829);
      }
      if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) || (!this.oJq.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (am.aSQ(this.pMt.field_username))
        {
          if (com.tencent.mm.n.g.acA().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!am.aSQ(this.pMt.field_username)) || (!"3552365301".equals(this.pMt.field_openImAppid))) {}
        }
        else if ((w.Ag(this.pMt.field_username)) || (!com.tencent.mm.o.b.lM(this.pMt.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.pMt.field_openImAppid)) {
          break label526;
        }
        paraml.aL(3, 2131757748, 2131689817);
      }
      label311:
      if (!this.pMt.adk()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.oJq.getString(2131757741);; str = this.oJq.getString(2131757736))
    {
      if (!w.Ag(this.pMt.field_username)) {
        paraml.a(5, str, 2131689795);
      }
      if ((!w.Ag(this.pMt.field_username)) && (com.tencent.mm.o.b.lM(this.pMt.field_type))) {
        paraml.aL(9, 2131756596, 2131689799);
      }
      if (com.tencent.mm.o.b.lM(this.pMt.field_type)) {
        paraml.aL(7, 2131757578, 2131689803);
      }
      if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!w.Ag(this.pMt.field_username))) {
        paraml.aL(6, 2131756457, 2131689802);
      }
      AppMethodBeat.o(26886);
      return;
      paraml.aL(1, 2131757731, 2131689826);
      break;
      label481:
      if (this.pMt.ePk != 2) {
        break label89;
      }
      i = 2131757811;
      break label89;
      label499:
      str = this.oJq.getResources().getString(2131757664);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paraml.aL(3, 2131761879, 2131689817);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    Fq(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.pMt.gfj <= 0)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azp().d(this.pMt, true);
    }
    paramMenuItem = new Intent(this.oJq.getIntent());
    paramMenuItem.putExtra("Contact_User", this.pMt.field_username);
    paramMenuItem.setClass(this.oJq, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.oJq.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(this.oJq.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.pMt.field_username });
    AppMethodBeat.o(26885);
    return true;
  }
  
  public final void po(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.pMt.adk())
    {
      dAk();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.oJq, 2131494763, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131302306);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (am.aSQ(this.pMt.field_username))
    {
      i = 2131757738;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131302305);
      localTextView.setText(2131757739);
      if (this.pMt.getSource() != 18) {
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
      h.a(this.oJq, true, this.oJq.getString(2131757736), localView, this.oJq.getString(2131755835), this.oJq.getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26873);
          b.a(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.wPu.isChecked()) {
              b.this.dAp();
            }
          }
          AppMethodBeat.o(26873);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26874);
          if ((b.d(b.this) instanceof n.b)) {
            ((n.b)b.d(b.this)).a(0, null, b.b(b.this).field_username);
          }
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
    dAj();
    AppMethodBeat.o(26889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */