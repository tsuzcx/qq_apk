package com.tencent.mm.ui.conversation.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.h;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.a.o;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b
  implements MenuItem.OnMenuItemClickListener, com.tencent.mm.an.p, MMActivity.a
{
  private com.tencent.mm.an.a.k aebr;
  private com.tencent.mm.an.d aebt;
  private final MMFragmentActivity afuy;
  private com.tencent.mm.an.c.b afuz;
  private String ovT;
  private w tipDialog;
  private m vEh;
  private String vEu;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(256950);
    this.afuz = new com.tencent.mm.an.c.b();
    this.afuy = paramMMFragmentActivity;
    this.ovT = paramString;
    this.aebt = af.bHq().Mi(paramString);
    if (this.aebt == null) {
      Log.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    af.bHf();
    this.vEu = f.Ms(paramString);
    AppMethodBeat.o(256950);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(256955);
    String str = this.afuy.getString(paramInt);
    AppMethodBeat.o(256955);
    return str;
  }
  
  private boolean jBh()
  {
    AppMethodBeat.i(256963);
    String str = af.bHj().hN(this.vEu);
    this.aebr = af.bHj().hM(str);
    if ((this.aebr == null) || (Util.isNullOrNil(this.aebr.field_addMemberUrl)))
    {
      AppMethodBeat.o(256963);
      return false;
    }
    AppMethodBeat.o(256963);
    return true;
  }
  
  private void zG(long paramLong)
  {
    AppMethodBeat.i(256970);
    if ((this.afuy instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.afuy).startChatting(this.vEu, localBundle, true);
    }
    AppMethodBeat.o(256970);
  }
  
  public final void a(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(257019);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramp.getType() == 1355)
    {
      paramp = ((o)paramp).bHE();
      paramp = af.bHh().MZ(paramp.ZpT.aajx.YRJ);
      if (paramp == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.gTv), 0).show();
        AppMethodBeat.o(257019);
        return;
      }
      zG(paramp.field_bizChatLocalId);
    }
    AppMethodBeat.o(257019);
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(257017);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(257017);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(257017);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    cam localcam;
    if (paramIntent != null)
    {
      Log.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localcam = new cam();
      com.tencent.mm.an.a.c localc = new com.tencent.mm.an.a.c();
      if (this.aebr != null)
      {
        paramIntent = this.aebr.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.vEu;
        if (!com.tencent.mm.an.a.e.a(localc, (String)localObject, null, localcam)) {
          break label254;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        zG(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.afuy, getString(R.l.gTv), 0).show();
        AppMethodBeat.o(257017);
        return;
        paramIntent = null;
        break;
        label194:
        af.bHp();
        paramIntent = h.a(this.vEu, localcam, this);
        localObject = this.afuy;
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(256927);
            af.bHp();
            h.d(paramIntent);
            AppMethodBeat.o(256927);
          }
        });
        paramInt1 = 1;
        continue;
        label254:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(257017);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(257012);
    paramMenuItem = g.hS(this.ovT);
    if (!Util.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.afuz.hT(this.ovT);
      }
      if (this.vEh != null)
      {
        this.vEh.dismiss();
        this.vEh = null;
      }
      this.vEh = new m(this.afuy);
      this.vEh.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          int k = 0;
          AppMethodBeat.i(256949);
          int i;
          int j;
          String str;
          if ((b.a(b.this) != null) && (b.a(b.this).field_hide_create_chat))
          {
            i = 1;
            j = k;
            if (i == 0)
            {
              j = k;
              if (b.b(b.this)) {
                j = 1;
              }
            }
            if (j != 0) {
              paramAnonymouss.bx(1, R.l.bizchat_new_chat, R.k.actionbar_create_biz_chat_icon);
            }
            if (!g.hQ(b.c(b.this)))
            {
              str = g.hR(b.c(b.this));
              if (!Util.isNullOrNil(str)) {
                break label197;
              }
              paramAnonymouss.bx(2, R.l.bizchat_invite_chat, R.k.ofm_add_icon);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymouss.a(4, b.d(b.this).getString(R.l.bizchat_fav), bb.m(b.e(b.this), R.k.actionbar_facefriend_icon, -1));
            }
            paramAnonymouss.a(3, b.d(b.this).getString(R.l.actionbar_title_setting), bb.m(b.e(b.this), R.k.actionbar_setting_white_icon, -1));
            AppMethodBeat.o(256949);
            return;
            i = 0;
            break;
            label197:
            paramAnonymouss.a(2, str, R.k.ofm_add_icon);
          }
        }
      };
      this.vEh.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(256939);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(256939);
            return;
            b.f(b.this);
            AppMethodBeat.o(256939);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              Log.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.br.c.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(256939);
              return;
            }
            b.g(b.this).hT(b.c(b.this));
            b.g(b.this).B(b.h(b.this));
            AppMethodBeat.o(256939);
            return;
            if (!Util.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(256939);
              return;
            }
            Log.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(256939);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.br.c.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.vEh.du();
      AppMethodBeat.o(257012);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */