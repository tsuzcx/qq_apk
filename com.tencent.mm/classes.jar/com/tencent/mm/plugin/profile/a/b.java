package com.tencent.mm.plugin.profile.a;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.profile.ui.ContactMoreInfoUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class b
  implements MenuItem.OnMenuItemClickListener, n.c, n.d
{
  private int gyR;
  private com.tencent.mm.ui.widget.b.d iOd;
  private boolean isDeleteCancel;
  public MMActivity kxD;
  private ad lpe;
  private boolean pxJ;
  
  public b(MMActivity paramMMActivity, ad paramad)
  {
    AppMethodBeat.i(23264);
    this.kxD = paramMMActivity;
    this.lpe = paramad;
    this.gyR = this.kxD.getIntent().getIntExtra("Contact_Scene", 9);
    this.pxJ = this.kxD.getIntent().getBooleanExtra("Contact_FMessageCard", false);
    AppMethodBeat.o(23264);
  }
  
  private void Au(String paramString)
  {
    AppMethodBeat.i(23274);
    int i = this.kxD.getIntent().getIntExtra("Kdel_from", -1);
    this.lpe.Ny();
    this.lpe.setSource(0);
    if (ad.arf(paramString))
    {
      ((com.tencent.mm.openim.a.a)g.E(com.tencent.mm.openim.a.a.class)).wg(paramString);
      bf.a(paramString, new b.6(this));
      aw.aaz();
      com.tencent.mm.model.c.YA().b(paramString, this.lpe);
      aw.aaz();
      com.tencent.mm.model.c.YF().arF(paramString);
      com.tencent.mm.bi.c.e(0L, paramString);
      com.tencent.mm.bi.c.e(0L, this.lpe.field_encryptUsername);
      switch (this.gyR)
      {
      case 11: 
      case 12: 
      default: 
        label152:
        if (this.gyR == 9)
        {
          ab.i("MicroMsg.ProfileMenuManager", "add scene unkown, check the contact getsource: " + this.lpe.getSource());
          switch (this.lpe.getSource())
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label365;
      }
      paramString = new Intent();
      paramString.addFlags(67108864);
      com.tencent.mm.plugin.profile.b.gmO.p(paramString, this.kxD);
      AppMethodBeat.o(23274);
      return;
      aw.aaz();
      com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.c(paramString));
      break;
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramString);
      if ((locala != null) && (!bo.isNullOrNil(locala.gwO)))
      {
        locala.status = 1;
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(locala.Al(), locala);
      }
      w.J(this.kxD, paramString);
      break label152;
      w.J(this.kxD, paramString);
      break label152;
      ab.i("MicroMsg.ProfileMenuManager", "delete the system contact info added by wechat");
      w.J(this.kxD, paramString);
    }
    label365:
    this.kxD.setResult(-1, this.kxD.getIntent().putExtra("_delete_ok_", true));
    this.kxD.finish();
    AppMethodBeat.o(23274);
  }
  
  public static void a(Activity paramActivity, ad paramad)
  {
    AppMethodBeat.i(23277);
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, ContactMoreInfoUI.class);
    localIntent.putExtra("Is_RoomOwner", paramActivity.getIntent().getBooleanExtra("Is_RoomOwner", false));
    localIntent.putExtra("Contact_User", paramad.field_username);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    paramad = str;
    if (str == null) {
      paramad = paramActivity.getIntent().getStringExtra("Contact_ChatRoomId");
    }
    localIntent.putExtra("Contact_ChatRoomId", paramad);
    paramad = bo.bf(paramActivity.getIntent().getStringExtra("verify_gmail"), "");
    str = bo.bf(paramActivity.getIntent().getStringExtra("profileName"), bo.aqf(paramad));
    localIntent.putExtra("verify_gmail", paramad);
    localIntent.putExtra("profileName", str);
    long l = paramActivity.getIntent().getLongExtra("Contact_Uin", 0L);
    paramad = paramActivity.getIntent().getStringExtra("Contact_QQNick");
    localIntent.putExtra("Contact_Uin", l);
    localIntent.putExtra("Contact_QQNick", paramad);
    paramActivity.startActivity(localIntent);
    AppMethodBeat.o(23277);
  }
  
  private void cbJ()
  {
    AppMethodBeat.i(23271);
    t.i(this.lpe);
    this.lpe.Nz();
    AppMethodBeat.o(23271);
  }
  
  private void cbK()
  {
    AppMethodBeat.i(23272);
    t.j(this.lpe);
    this.lpe.NA();
    AppMethodBeat.o(23272);
  }
  
  public final void bMz()
  {
    AppMethodBeat.i(23265);
    this.kxD.addIconOptionMenu(0, 2130839668, this);
    AppMethodBeat.o(23265);
  }
  
  public final void cbI()
  {
    AppMethodBeat.i(23269);
    Intent localIntent = new Intent(this.kxD, PermissionSettingUI.class);
    localIntent.putExtra("sns_permission_userName", this.lpe.field_username);
    localIntent.putExtra("CONTACT_INFO_UI_SOURCE", this.kxD.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
    localIntent.putExtra("sns_permission_anim", true);
    localIntent.putExtra("sns_permission_block_scene", 1);
    this.kxD.startActivity(localIntent);
    AppMethodBeat.o(23269);
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(23273);
    View localView = View.inflate(this.kxD, 2130970141, null);
    localView.setPadding(0, 0, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131826140);
    localTextView.setPadding(0, 0, 0, 0);
    Object localObject;
    if (t.nR(this.lpe.field_username))
    {
      localObject = this.kxD.getString(2131298937, new Object[] { this.lpe.Of() });
      localTextView.setText((CharSequence)localObject);
      localObject = (CheckBox)localView.findViewById(2131826141);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131826142);
      localTextView.setText(2131298678);
      if (this.lpe.getSource() != 18) {
        break label232;
      }
      ((CheckBox)localObject).setVisibility(0);
      localTextView.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(this.kxD, true, this.kxD.getString(2131298582), localView, this.kxD.getString(2131296901), this.kxD.getString(2131296888), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(23258);
          b.d(b.this);
          if (b.b(b.this).getSource() == 18)
          {
            b.c(b.this);
            if (this.pxK.isChecked()) {
              b.this.cbN();
            }
          }
          AppMethodBeat.o(23258);
        }
      }, null, 2131689667);
      AppMethodBeat.o(23273);
      return;
      localObject = this.kxD.getString(2131298935, new Object[] { this.lpe.Of() });
      break;
      label232:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public final void cbM()
  {
    AppMethodBeat.i(23275);
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Talker_Name", this.lpe.field_username);
    localIntent.putExtra("Select_block_List", this.lpe.field_username);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("Select_Send_Card", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    com.tencent.mm.plugin.profile.b.gmO.a(localIntent, new b.7(this), this.kxD);
    AppMethodBeat.o(23275);
  }
  
  public final void cbN()
  {
    int i = 7;
    AppMethodBeat.i(23276);
    Intent localIntent = new Intent();
    switch (this.gyR)
    {
    default: 
      i = 35;
    }
    for (;;)
    {
      localIntent.putExtra("k_username", this.lpe.field_username);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
      com.tencent.mm.bq.d.b(this.kxD, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(23276);
      return;
      if (this.pxJ) {}
      for (i = 2;; i = 1)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.uQ(this.lpe.field_username));
        break;
      }
      if (this.pxJ) {}
      for (i = 4;; i = 3)
      {
        localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.uR(this.lpe.field_username));
        break;
      }
      localIntent.putStringArrayListExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.C(7, this.lpe.field_username));
      continue;
      if (this.pxJ) {}
      for (i = 6;; i = 5)
      {
        if (!this.pxJ) {
          break label402;
        }
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.C(i, this.lpe.field_username));
        break;
      }
      label402:
      if (!bo.isNullOrNil(this.lpe.yMc)) {}
      for (String str = this.lpe.yMc;; str = this.lpe.field_username)
      {
        localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.uS(str));
        break;
      }
      i = 35;
      continue;
      localIntent.putExtra("k_outside_expose_proof_item_list", com.tencent.mm.bi.a.C(45, this.lpe.field_username));
      i = 45;
    }
  }
  
  public final void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(23270);
    if (this.lpe.NW())
    {
      cbK();
      AppMethodBeat.o(23270);
      return;
    }
    View localView = View.inflate(this.kxD, 2130970141, null);
    localView.setPadding(0, 0, 0, 0);
    Object localObject = (TextView)localView.findViewById(2131826140);
    ((TextView)localObject).setPadding(0, 0, 0, 0);
    int i;
    TextView localTextView;
    if (ad.arf(this.lpe.field_username))
    {
      i = 2131298677;
      ((TextView)localObject).setText(i);
      localObject = (CheckBox)localView.findViewById(2131826141);
      ((CheckBox)localObject).setChecked(false);
      localTextView = (TextView)localView.findViewById(2131826142);
      localTextView.setText(2131298678);
      if (this.lpe.getSource() != 18) {
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
      com.tencent.mm.ui.base.h.a(this.kxD, true, this.kxD.getString(2131298675), localView, this.kxD.getString(2131297018), this.kxD.getString(2131296888), new b.1(this, (CheckBox)localObject), null);
      AppMethodBeat.o(23270);
      return;
      i = 2131298676;
      break;
      label222:
      ((CheckBox)localObject).setVisibility(8);
      localTextView.setVisibility(8);
    }
    label239:
    cbJ();
    AppMethodBeat.o(23270);
  }
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(23267);
    int i;
    if (!t.ow(this.lpe.field_username))
    {
      if (ad.arf(this.lpe.field_username)) {
        paraml.aw(1, 2131298849, 2131231033);
      }
    }
    else
    {
      if ((com.tencent.mm.n.a.je(this.lpe.field_type)) && (!t.ow(this.lpe.field_username)))
      {
        i = 2131298749;
        if (this.lpe.dqC != 1) {
          break label416;
        }
        i = 2131298747;
        label89:
        paraml.aw(4, i, 2131231038);
      }
      if (!this.lpe.NY()) {
        break label434;
      }
      str = this.kxD.getResources().getString(2131298822);
      label123:
      if ((com.tencent.mm.n.a.je(this.lpe.field_type)) && (!t.ow(this.lpe.field_username))) {
        paraml.a(2, str, 2131231036);
      }
      if ((com.tencent.mm.n.a.je(this.lpe.field_type)) || (!this.kxD.getIntent().getBooleanExtra("User_Verify", false))) {
        break label451;
      }
      i = 1;
      label191:
      if ((i != 0) || ((!ad.arf(this.lpe.field_username)) && (!t.ow(this.lpe.field_username)) && (com.tencent.mm.n.a.je(this.lpe.field_type)))) {
        paraml.aw(3, 2131298685, 2131231024);
      }
      if (!this.lpe.NW()) {
        break label456;
      }
    }
    label416:
    label434:
    label451:
    label456:
    for (String str = this.kxD.getString(2131298680);; str = this.kxD.getString(2131298675))
    {
      if (!t.ow(this.lpe.field_username)) {
        paraml.a(5, str, 2131231002);
      }
      if ((!t.ow(this.lpe.field_username)) && (com.tencent.mm.n.a.je(this.lpe.field_type))) {
        paraml.aw(9, 2131297684, 2131231006);
      }
      if (com.tencent.mm.n.a.je(this.lpe.field_type)) {
        paraml.aw(7, 2131298519, 2131231010);
      }
      if ((com.tencent.mm.n.a.je(this.lpe.field_type)) && (!t.ow(this.lpe.field_username))) {
        paraml.aw(6, 2131297565, 2131231009);
      }
      AppMethodBeat.o(23267);
      return;
      paraml.aw(1, 2131298670, 2131231033);
      break;
      if (this.lpe.dqC != 2) {
        break label89;
      }
      i = 2131298748;
      break label89;
      str = this.kxD.getResources().getString(2131298604);
      break label123;
      i = 0;
      break label191;
    }
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(23268);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23268);
      return;
      if (this.lpe.NY())
      {
        t.n(this.lpe);
        com.tencent.mm.ui.base.h.bO(this.kxD, this.kxD.getString(2131298823));
      }
      for (;;)
      {
        aw.aaz();
        this.lpe = com.tencent.mm.model.c.YA().arw(this.lpe.field_username);
        com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(10), Integer.valueOf(1), this.lpe.field_username });
        AppMethodBeat.o(23268);
        return;
        t.m(this.lpe);
        com.tencent.mm.ui.base.h.bO(this.kxD, this.kxD.getString(2131298605));
      }
      cbI();
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(11), Integer.valueOf(1), this.lpe.field_username });
      AppMethodBeat.o(23268);
      return;
      cbM();
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(9), Integer.valueOf(1), this.lpe.field_username });
      AppMethodBeat.o(23268);
      return;
      if (!com.tencent.mm.n.a.je(this.lpe.field_type))
      {
        if (bo.isNullOrNil(this.lpe.field_username)) {
          ab.w("MicroMsg.ProfileMenuManager", "mod stranger remark, username is null");
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(8), Integer.valueOf(1), this.lpe.field_username });
          AppMethodBeat.o(23268);
          return;
          paramMenuItem = new Intent();
          paramMenuItem.putExtra("Contact_Scene", this.gyR);
          paramMenuItem.putExtra("Contact_mode_name_type", 0);
          paramMenuItem.putExtra("Contact_ModStrangerRemark", true);
          paramMenuItem.putExtra("Contact_User", this.lpe.field_username);
          paramMenuItem.putExtra("Contact_Nick", this.lpe.field_nickname);
          paramMenuItem.putExtra("Contact_RemarkName", this.lpe.field_conRemark);
          com.tencent.mm.plugin.profile.b.gmO.n(paramMenuItem, this.kxD);
        }
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_Scene", this.gyR);
      localIntent.putExtra("Contact_User", this.lpe.field_username);
      localIntent.putExtra("Contact_RoomNickname", this.kxD.getIntent().getStringExtra("Contact_RoomNickname"));
      localIntent.putExtra("contact_phone_number_list", this.lpe.dqZ);
      String str1 = "";
      Object localObject = str1;
      String str2;
      if (!this.lpe.Ob())
      {
        paramMenuItem = null;
        localObject = this.kxD.getIntent().getStringExtra("Contact_Mobile_MD5");
        str2 = this.kxD.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if ((!bo.isNullOrNil((String)localObject)) || (!bo.isNullOrNil(str2))) {
          break label771;
        }
        if (!bo.isNullOrNil(this.lpe.field_username)) {
          paramMenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.lpe.field_username);
        }
      }
      for (;;)
      {
        localObject = str1;
        if (paramMenuItem != null)
        {
          localObject = str1;
          if (!bo.isNullOrNil(paramMenuItem.Al())) {
            localObject = bo.nullAsNil(paramMenuItem.aqf()).replace(" ", "");
          }
        }
        localIntent.putExtra("contact_phone_number_by_md5", (String)localObject);
        com.tencent.mm.plugin.profile.b.gmO.m(localIntent, this.kxD);
        break;
        label771:
        if ((!bo.isNullOrNil((String)localObject)) || (!bo.isNullOrNil(str2)))
        {
          localObject = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject);
          if (localObject != null)
          {
            paramMenuItem = (MenuItem)localObject;
            if (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject).Al())) {}
          }
          else
          {
            paramMenuItem = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(str2);
          }
        }
      }
      ka(true);
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(14), Integer.valueOf(1), this.lpe.field_username });
      AppMethodBeat.o(23268);
      return;
      cbL();
      AppMethodBeat.o(23268);
      return;
      ab.d("MicroMsg.ProfileMenuManager", "dealAddShortcut, username = " + this.lpe.field_username);
      com.tencent.mm.plugin.base.model.c.a(this.kxD, new b.8(this));
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(15), Integer.valueOf(1), this.lpe.field_username });
      AppMethodBeat.o(23268);
      return;
      cbN();
    }
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(23266);
    this.iOd = new com.tencent.mm.ui.widget.b.d(this.kxD, 1, false);
    this.iOd.sap = this;
    this.iOd.sao = this;
    this.iOd.crd();
    com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(this.kxD.getIntent())), Integer.valueOf(7), Integer.valueOf(1), this.lpe.field_username });
    AppMethodBeat.o(23266);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */