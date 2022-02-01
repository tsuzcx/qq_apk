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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.n.f;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.base.model.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.ProfileSettingUI;
import com.tencent.mm.pluginsdk.h.a.a;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;

public final class b
  implements MenuItem.OnMenuItemClickListener, a.a, o.f, o.g
{
  private boolean BcL;
  private boolean isDeleteCancel;
  private int kgm;
  public MMActivity qdG;
  public as rjX;
  
  public b(MMActivity paramMMActivity, as paramas)
  {
    AppMethodBeat.i(26882);
    this.qdG = paramMMActivity;
    this.rjX = paramas;
    this.kgm = this.qdG.getIntent().getIntExtra("Contact_Scene", 9);
    this.BcL = this.qdG.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(26882);
  }
  
  private void XA(String paramString)
  {
    AppMethodBeat.i(26894);
    this.rjX.aqR();
    if (as.bjp(paramString))
    {
      this.rjX.setSource(0);
      ((r)com.tencent.mm.kernel.g.af(r.class)).EG(paramString);
      bp.a(paramString, new bp.a()
      {
        public final boolean amG()
        {
          AppMethodBeat.i(231816);
          boolean bool = b.g(b.this);
          AppMethodBeat.o(231816);
          return bool;
        }
        
        public final void amH() {}
      });
      bg.aVF();
      com.tencent.mm.model.c.aSN().c(paramString, this.rjX);
      bg.aVF();
      com.tencent.mm.model.c.aST().bjW(paramString);
      com.tencent.mm.bj.c.f(0L, paramString);
      com.tencent.mm.bj.c.f(0L, this.rjX.field_encryptUsername);
      switch (this.kgm)
      {
      case 11: 
      case 12: 
      default: 
        if (this.kgm == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.rjX.getSource());
          switch (this.rjX.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.qdG.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label338;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.jRt.o(paramString, this.qdG);
        AppMethodBeat.o(26894);
        return;
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramString);
        if ((locala != null) && (!Util.isNullOrNil(locala.kdX)))
        {
          locala.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.getMd5(), locala);
        }
        t.R(this.qdG, paramString);
        break;
        t.R(this.qdG, paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.R(this.qdG, paramString);
      }
      label338:
      this.qdG.setResult(-1, this.qdG.getIntent().putExtra("_delete_ok_", true));
      this.qdG.finish();
      AppMethodBeat.o(26894);
      return;
    }
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).XA(paramString);
    AppMethodBeat.o(26894);
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
    paramas = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramas.axQ(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramas.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "goToMoreInfoUI", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(26897);
  }
  
  private void aKk(String paramString)
  {
    AppMethodBeat.i(231820);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
      AppMethodBeat.o(231820);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.kgm);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.rjX.field_username);
    paramString.putExtra("Contact_Nick", this.rjX.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.rjX.field_conRemark);
    com.tencent.mm.plugin.profile.b.jRt.m(paramString, this.qdG);
    AppMethodBeat.o(231820);
  }
  
  private aq eDR()
  {
    AppMethodBeat.i(231818);
    aq localaq = com.tencent.mm.contact.a.a.h(this.rjX);
    if (localaq != null) {
      localaq.b(new com.tencent.mm.contact.a.b() {}).i(this.qdG, this.qdG.getString(2131755998), this.qdG.getString(2131756029));
    }
    AppMethodBeat.o(231818);
    return localaq;
  }
  
  private void eDS()
  {
    AppMethodBeat.i(26891);
    aq localaq = com.tencent.mm.contact.a.a.i(this.rjX);
    if (localaq != null) {
      localaq.b(new com.tencent.mm.contact.a.b() {}).i(this.qdG, this.qdG.getString(2131755998), this.qdG.getString(2131756029));
    }
    AppMethodBeat.o(26891);
  }
  
  private void eDV()
  {
    AppMethodBeat.i(231819);
    if (!com.tencent.mm.contact.c.oR(this.rjX.field_type))
    {
      aKk(this.rjX.field_username);
      AppMethodBeat.o(231819);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_Scene", this.kgm);
    localIntent.putExtra("Contact_User", this.rjX.field_username);
    localIntent.putExtra("Contact_RoomNickname", this.qdG.getIntent().getStringExtra("Contact_RoomNickname"));
    localIntent.putExtra("contact_phone_number_list", this.rjX.fuX);
    String str1 = "";
    Object localObject2 = str1;
    Object localObject1;
    String str2;
    if (!this.rjX.arF())
    {
      localObject1 = null;
      localObject2 = this.qdG.getIntent().getStringExtra("Contact_Mobile_MD5");
      str2 = this.qdG.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2))) {
        break label267;
      }
      if (!Util.isNullOrNil(this.rjX.field_username)) {
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.rjX.field_username);
      }
    }
    for (;;)
    {
      localObject2 = str1;
      if (localObject1 != null)
      {
        localObject2 = str1;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())) {
          localObject2 = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnP()).replace(" ", "");
        }
      }
      localIntent.putExtra("contact_phone_number_by_md5", (String)localObject2);
      com.tencent.mm.plugin.profile.b.jRt.l(localIntent, this.qdG);
      AppMethodBeat.o(231819);
      return;
      label267:
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil(str2)))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject2);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).getMd5())) {}
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(str2);
        }
      }
    }
  }
  
  private void eDW()
  {
    AppMethodBeat.i(231821);
    Log.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.rjX.field_username);
    com.tencent.mm.plugin.base.model.c.a(this.qdG, new c.b()
    {
      public final void cjO()
      {
        AppMethodBeat.i(231807);
        com.tencent.mm.plugin.base.model.b.ai(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(231807);
      }
      
      public final void cjP()
      {
        AppMethodBeat.i(231808);
        com.tencent.mm.plugin.base.model.b.ah(b.d(b.this), b.c(b.this).field_username);
        AppMethodBeat.o(231808);
      }
    });
    AppMethodBeat.o(231821);
  }
  
  public final void Lc(int paramInt)
  {
    AppMethodBeat.i(231817);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(231817);
      return;
      if (this.rjX.arA())
      {
        ab.y(this.rjX);
        com.tencent.mm.ui.base.h.cD(this.qdG, this.qdG.getString(2131758131));
      }
      for (;;)
      {
        bg.aVF();
        this.rjX = com.tencent.mm.model.c.aSN().Kn(this.rjX.field_username);
        com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.rjX.field_username });
        AppMethodBeat.o(231817);
        return;
        ab.x(this.rjX);
        com.tencent.mm.ui.base.h.cD(this.qdG, this.qdG.getString(2131757893));
      }
      eDQ();
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.rjX.field_username });
      AppMethodBeat.o(231817);
      return;
      eDU();
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.rjX.field_username });
      AppMethodBeat.o(231817);
      return;
      eDV();
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.rjX.field_username });
      AppMethodBeat.o(231817);
      return;
      sE(true);
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.rjX.field_username });
      AppMethodBeat.o(231817);
      return;
      ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).a(this);
      eDT();
      AppMethodBeat.o(231817);
      return;
      eDW();
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.rjX.field_username });
      AppMethodBeat.o(231817);
      return;
      eDX();
    }
  }
  
  public final void a(String paramString, int paramInt, cxl paramcxl)
  {
    AppMethodBeat.i(26893);
    if (paramInt == 0)
    {
      if (!paramString.equals(this.rjX.field_username))
      {
        Log.w("MicroMsg.ProfileMenuManager", "not current contact %s,%s", new Object[] { this.rjX.field_username, paramString });
        AppMethodBeat.o(26893);
        return;
      }
      switch (this.kgm)
      {
      case 11: 
      case 12: 
      default: 
        if (this.kgm == 9)
        {
          Log.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.rjX.getSource());
          switch (this.rjX.getSource())
          {
          }
        }
        break;
      }
      for (;;)
      {
        if (this.qdG.getIntent().getIntExtra("Kdel_from", -1) != 0) {
          break label294;
        }
        paramString = new Intent();
        paramString.addFlags(67108864);
        com.tencent.mm.plugin.profile.b.jRt.o(paramString, this.qdG);
        AppMethodBeat.o(26893);
        return;
        paramcxl = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramString);
        if ((paramcxl != null) && (!Util.isNullOrNil(paramcxl.kdX)))
        {
          paramcxl.status = 1;
          com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramcxl.getMd5(), paramcxl);
        }
        t.R(this.qdG, paramString);
        break;
        t.R(this.qdG, paramString);
        break;
        Log.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
        t.R(this.qdG, paramString);
      }
      label294:
      this.qdG.setResult(-1, this.qdG.getIntent().putExtra("_delete_ok_", true));
      this.qdG.finish();
      AppMethodBeat.o(26893);
      return;
    }
    if (!Util.isNullOrNil(paramcxl.iAc))
    {
      com.tencent.mm.ui.base.h.c(this.qdG, paramcxl.iAc, paramcxl.Title, true);
      AppMethodBeat.o(26893);
      return;
    }
    com.tencent.mm.ui.base.h.c(this.qdG, this.qdG.getString(2131755779), "", true);
    AppMethodBeat.o(26893);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(26884);
    ((com.tencent.mm.pluginsdk.h.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.h.a.class)).b(this);
    AppMethodBeat.o(26884);
  }
  
  public final void eDQ()
  {
    AppMethodBeat.i(26888);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slQ, 0);
    Object localObject2 = this.qdG;
    if (i == 0) {}
    for (Object localObject1 = PermissionSettingUI.class;; localObject1 = PermissionSettingUI2.class)
    {
      localObject2 = new Intent((Context)localObject2, (Class)localObject1);
      ((Intent)localObject2).putExtra("sns_permission_userName", this.rjX.field_username);
      ((Intent)localObject2).putExtra("CONTACT_INFO_UI_SOURCE", this.qdG.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
      ((Intent)localObject2).putExtra("sns_permission_anim", true);
      ((Intent)localObject2).putExtra("sns_permission_block_scene", 1);
      localObject1 = this.qdG;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/logic/ProfileMenuManager", "dealSnsPermission", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(26888);
      return;
    }
  }
  
  public final void eDT()
  {
    AppMethodBeat.i(26892);
    View localView = View.inflate(this.qdG, 2131495497, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131304700);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (ab.IQ(this.rjX.field_username))
    {
      localObject = this.qdG.getString(2131758274, new Object[] { this.rjX.arJ() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131304698);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131304699);
      localTextView.setText(2131757976);
      if (this.rjX.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.qdG, true, this.qdG.getString(2131757869), localView, this.qdG.getString(2131755778), this.qdG.getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(26877);
          b.e(b.this);
          if (b.c(b.this).getSource() == 18)
          {
            b.f(b.this);
            if (this.BcM.isChecked()) {
              b.this.eDX();
            }
          }
          AppMethodBeat.o(26877);
        }
      }, null, 2131099922);
      AppMethodBeat.o(26892);
      return;
      localObject = this.qdG.getString(2131758272, new Object[] { this.rjX.arJ() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void eDU()
  {
    AppMethodBeat.i(26895);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.rjX.field_username);
    localIntent.putExtra("Select_block_List", this.rjX.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.jRt.a(localIntent, new MMActivity.a()
    {
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(231806);
        if ((paramAnonymousInt2 == -1) && (paramAnonymousIntent != null))
        {
          String str1 = paramAnonymousIntent.getStringExtra("be_send_card_name");
          String str2 = paramAnonymousIntent.getStringExtra("received_card_name");
          boolean bool = paramAnonymousIntent.getBooleanExtra("Is_Chatroom", false);
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
          com.tencent.mm.plugin.messenger.a.g.eir().s(str1, str2, bool);
          com.tencent.mm.plugin.messenger.a.g.eir().iF(paramAnonymousIntent, str2);
          com.tencent.mm.ui.widget.snackbar.b.r(b.d(b.this), b.d(b.this).getString(2131760708));
        }
        AppMethodBeat.o(231806);
      }
    }, this.qdG);
    AppMethodBeat.o(26895);
  }
  
  public final void eDX()
  {
    int i = 7;
    AppMethodBeat.i(231822);
    Intent localIntent = new Intent();
    switch (this.kgm)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.rjX.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.br.c.b(this.qdG, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(231822);
      return;
      if (this.BcL) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qb(this.rjX.field_username));
        break;
      }
      if (this.BcL) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qc(this.rjX.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(7, this.rjX.field_username));
      continue;
      if (this.BcL) {}
      for (i = 6;; i = 5)
      {
        if (!this.BcL) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(i, this.rjX.field_username));
        break;
      }
      label402:
      if (!Util.isNullOrNil(this.rjX.Ooy)) {}
      for (String str = this.rjX.Ooy;; str = this.rjX.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.Qd(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bj.a.P(45, this.rjX.field_username));
      i = 45;
    }
  }
  
  public final void eeh()
  {
    AppMethodBeat.i(26883);
    this.qdG.addIconOptionMenu(0, 2131690843, this);
    AppMethodBeat.o(26883);
  }
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(26886);
    int i;
    if (!ab.Jv(this.rjX.field_username))
    {
      if (as.bjp(this.rjX.field_username)) {
        paramm.aS(1, 2131758167, 2131689839);
      }
    }
    else
    {
      if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!ab.Jv(this.rjX.field_username)))
      {
        i = 2131758052;
        if (this.rjX.fuA != 1) {
          break label481;
        }
        i = 2131758050;
        label89:
        paramm.aS(4, i, 2131689844);
      }
      if (!this.rjX.arA()) {
        break label499;
      }
      str = this.qdG.getResources().getString(2131758130);
      label123:
      if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!ab.Jv(this.rjX.field_username))) {
        paramm.b(2, str, 2131689842);
      }
      if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (!this.qdG.getIntent().getBooleanExtra("User_Verify", false))) {
        break label516;
      }
      i = 1;
      label191:
      if (i == 0)
      {
        if (as.bjp(this.rjX.field_username))
        {
          if (com.tencent.mm.n.h.aqJ().getInt("SnsWxWorkPermissionEntrance", 0) != 1) {
            break label521;
          }
          i = 1;
          label224:
          if ((i == 0) || (!as.bjp(this.rjX.field_username)) || (!"3552365301".equals(this.rjX.field_openImAppid))) {}
        }
        else if ((ab.Jv(this.rjX.field_username)) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type))) {}
      }
      else
      {
        if (!"3552365301".equals(this.rjX.field_openImAppid)) {
          break label526;
        }
        paramm.aS(3, 2131757985, 2131689830);
      }
      label311:
      if (!this.rjX.ary()) {
        break label541;
      }
    }
    label516:
    label521:
    label526:
    label541:
    for (String str = this.qdG.getString(2131757978);; str = this.qdG.getString(2131757973))
    {
      if (!ab.Jv(this.rjX.field_username)) {
        paramm.b(5, str, 2131689807);
      }
      if ((!ab.Jv(this.rjX.field_username)) && (com.tencent.mm.contact.c.oR(this.rjX.field_type))) {
        paramm.aS(9, 2131756736, 2131689811);
      }
      if (com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
        paramm.aS(7, 2131757805, 2131689815);
      }
      if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!ab.Jv(this.rjX.field_username))) {
        paramm.aS(6, 2131756593, 2131689814);
      }
      AppMethodBeat.o(26886);
      return;
      paramm.aS(1, 2131757968, 2131689839);
      break;
      label481:
      if (this.rjX.fuA != 2) {
        break label89;
      }
      i = 2131758051;
      break label89;
      label499:
      str = this.qdG.getResources().getString(2131757892);
      break label123;
      i = 0;
      break label191;
      i = 0;
      break label224;
      paramm.aS(3, 2131763884, 2131689830);
      break label311;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26887);
    Lc(paramMenuItem.getItemId());
    AppMethodBeat.o(26887);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(26885);
    if ((int)this.rjX.gMZ <= 0)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSN().d(this.rjX, true);
    }
    paramMenuItem = new Intent(this.qdG.getIntent());
    paramMenuItem.putExtra("Contact_User", this.rjX.field_username);
    paramMenuItem.setClass(this.qdG, ProfileSettingUI.class);
    paramMenuItem.setFlags(32768);
    this.qdG.startActivityForResult(paramMenuItem, 32767);
    com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(this.qdG.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.rjX.field_username });
    AppMethodBeat.o(26885);
    return true;
  }
  
  public final void sE(boolean paramBoolean)
  {
    AppMethodBeat.i(26889);
    if (this.rjX.ary())
    {
      eDS();
      AppMethodBeat.o(26889);
      return;
    }
    View localView = View.inflate(this.qdG, 2131495497, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131304700);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (as.bjp(this.rjX.field_username))
    {
      i = 2131757975;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131304698);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131304699);
      localTextView.setText(2131757976);
      if (this.rjX.getSource() != 18) {
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
      com.tencent.mm.ui.base.h.a(this.qdG, false, this.qdG.getString(2131757973), localView, this.qdG.getString(2131755921), this.qdG.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      i = 2131757974;
      break;
      label229:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label246:
    eDR();
    AppMethodBeat.o(26889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */