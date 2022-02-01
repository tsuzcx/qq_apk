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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b
  implements MenuItem.OnMenuItemClickListener, com.tencent.mm.al.p, MMActivity.a
{
  private k JPI;
  private com.tencent.mm.al.d JPK;
  private final MMFragmentActivity KVR;
  private com.tencent.mm.al.c.b KVS;
  private String hSG;
  private m oeD;
  private String oeQ;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(188179);
    this.KVS = new com.tencent.mm.al.c.b();
    this.KVR = paramMMFragmentActivity;
    this.hSG = paramString;
    this.JPK = ag.aGy().Ea(paramString);
    if (this.JPK == null) {
      ae.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    ag.aGp();
    this.oeQ = f.Ej(paramString);
    AppMethodBeat.o(188179);
  }
  
  private void Em(long paramLong)
  {
    AppMethodBeat.i(188184);
    if ((this.KVR instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.KVR).startChatting(this.oeQ, localBundle, true);
    }
    AppMethodBeat.o(188184);
  }
  
  private boolean fNT()
  {
    AppMethodBeat.i(188182);
    String str = ag.aGt().eQ(this.oeQ);
    this.JPI = ag.aGt().eP(str);
    if ((this.JPI == null) || (bu.isNullOrNil(this.JPI.field_addMemberUrl)))
    {
      AppMethodBeat.o(188182);
      return false;
    }
    AppMethodBeat.o(188182);
    return true;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(188181);
    String str = this.KVR.getString(paramInt);
    AppMethodBeat.o(188181);
    return str;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(188185);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((o)paramn).aGK();
      paramn = ag.aGr().EQ(paramn.GtU.GLl.FZq);
      if (paramn == null)
      {
        Toast.makeText(ak.getContext(), getString(2131762592), 0).show();
        AppMethodBeat.o(188185);
        return;
      }
      Em(paramn.field_bizChatLocalId);
    }
    AppMethodBeat.o(188185);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(188183);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(188183);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(188183);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    auj localauj;
    if (paramIntent != null)
    {
      ae.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localauj = new auj();
      c localc = new c();
      if (this.JPI != null)
      {
        paramIntent = this.JPI.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.oeQ;
        if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localauj)) {
          break label252;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        Em(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.KVR, getString(2131762592), 0).show();
        AppMethodBeat.o(188183);
        return;
        paramIntent = null;
        break;
        label194:
        ag.aGx();
        paramIntent = com.tencent.mm.al.a.h.a(this.oeQ, localauj, this);
        localObject = this.KVR;
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(188178);
            ag.aGx();
            com.tencent.mm.al.a.h.d(paramIntent);
            AppMethodBeat.o(188178);
          }
        });
        paramInt1 = 1;
        continue;
        label252:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(188183);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(188180);
    paramMenuItem = g.eV(this.hSG);
    if (!bu.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.KVS.eW(this.hSG);
      }
      if (this.oeD != null)
      {
        this.oeD.dismiss();
        this.oeD = null;
      }
      this.oeD = new m(this.KVR);
      this.oeD.LfS = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          int k = 0;
          AppMethodBeat.i(188175);
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
              paramAnonymousl.aM(1, 2131756674, 2131689479);
            }
            if (!g.eT(b.c(b.this)))
            {
              str = g.eU(b.c(b.this));
              if (!bu.isNullOrNil(str)) {
                break label189;
              }
              paramAnonymousl.aM(2, 2131760267, 2131690972);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymousl.a(4, b.d(b.this).getString(2131756673), ao.k(b.e(b.this), 2131689484, -1));
            }
            paramAnonymousl.a(3, b.d(b.this).getString(2131755135), ao.k(b.e(b.this), 2131689512, -1));
            AppMethodBeat.o(188175);
            return;
            i = 0;
            break;
            label189:
            paramAnonymousl.a(2, str, 2131690972);
          }
        }
      };
      this.oeD.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(188176);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(188176);
            return;
            b.f(b.this);
            AppMethodBeat.o(188176);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              ae.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.br.d.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(188176);
              return;
            }
            b.g(b.this).eW(b.c(b.this));
            b.g(b.this).z(b.h(b.this));
            AppMethodBeat.o(188176);
            return;
            if (!bu.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(188176);
              return;
            }
            ae.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(188176);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.br.d.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.oeD.il();
      AppMethodBeat.o(188180);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */