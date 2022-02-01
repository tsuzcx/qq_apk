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
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.af;
import com.tencent.mm.al.f;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b
  implements MenuItem.OnMenuItemClickListener, com.tencent.mm.al.o, MMActivity.a
{
  private k HHb;
  private com.tencent.mm.al.c HHd;
  private final MMFragmentActivity IIq;
  private com.tencent.mm.al.c.b IIr;
  private String hxt;
  private String nxJ;
  private m nxw;
  private p tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(196926);
    this.IIr = new com.tencent.mm.al.c.b();
    this.IIq = paramMMFragmentActivity;
    this.hxt = paramString;
    this.HHd = af.aDf().Az(paramString);
    if (this.HHd == null) {
      ac.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    af.aCW();
    this.nxJ = com.tencent.mm.al.e.AI(paramString);
    AppMethodBeat.o(196926);
  }
  
  private void AX(long paramLong)
  {
    AppMethodBeat.i(196931);
    if ((this.IIq instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.IIq).startChatting(this.nxJ, localBundle, true);
    }
    AppMethodBeat.o(196931);
  }
  
  private boolean fsO()
  {
    AppMethodBeat.i(196929);
    String str = af.aDa().dQ(this.nxJ);
    this.HHb = af.aDa().dP(str);
    if ((this.HHb == null) || (bs.isNullOrNil(this.HHb.field_addMemberUrl)))
    {
      AppMethodBeat.o(196929);
      return false;
    }
    AppMethodBeat.o(196929);
    return true;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(196928);
    String str = this.IIq.getString(paramInt);
    AppMethodBeat.o(196928);
    return str;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(196932);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((com.tencent.mm.al.a.o)paramn).aDr();
      paramn = af.aCY().Bp(paramn.EtV.EIW.Ebl);
      if (paramn == null)
      {
        Toast.makeText(ai.getContext(), getString(2131762592), 0).show();
        AppMethodBeat.o(196932);
        return;
      }
      AX(paramn.field_bizChatLocalId);
    }
    AppMethodBeat.o(196932);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(196930);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(196930);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(196930);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    apz localapz;
    if (paramIntent != null)
    {
      ac.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localapz = new apz();
      com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
      if (this.HHb != null)
      {
        paramIntent = this.HHb.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.nxJ;
        if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localapz)) {
          break label252;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        AX(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.IIq, getString(2131762592), 0).show();
        AppMethodBeat.o(196930);
        return;
        paramIntent = null;
        break;
        label194:
        af.aDe();
        paramIntent = com.tencent.mm.al.a.h.a(this.nxJ, localapz, this);
        localObject = this.IIq;
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(196925);
            af.aDe();
            com.tencent.mm.al.a.h.d(paramIntent);
            AppMethodBeat.o(196925);
          }
        });
        paramInt1 = 1;
        continue;
        label252:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(196930);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(196927);
    paramMenuItem = f.dV(this.hxt);
    if (!bs.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.IIr.dW(this.hxt);
      }
      if (this.nxw != null)
      {
        this.nxw.dismiss();
        this.nxw = null;
      }
      this.nxw = new m(this.IIq);
      this.nxw.ISu = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          int k = 0;
          AppMethodBeat.i(196922);
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
              paramAnonymousl.aJ(1, 2131756674, 2131689479);
            }
            if (!f.dT(b.c(b.this)))
            {
              str = f.dU(b.c(b.this));
              if (!bs.isNullOrNil(str)) {
                break label189;
              }
              paramAnonymousl.aJ(2, 2131760267, 2131690972);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymousl.a(4, b.d(b.this).getString(2131756673), am.k(b.e(b.this), 2131689484, -1));
            }
            paramAnonymousl.a(3, b.d(b.this).getString(2131755135), am.k(b.e(b.this), 2131689512, -1));
            AppMethodBeat.o(196922);
            return;
            i = 0;
            break;
            label189:
            paramAnonymousl.a(2, str, 2131690972);
          }
        }
      };
      this.nxw.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(196923);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(196923);
            return;
            b.f(b.this);
            AppMethodBeat.o(196923);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              ac.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.br.d.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(196923);
              return;
            }
            b.g(b.this).dW(b.c(b.this));
            b.g(b.this).z(b.h(b.this));
            AppMethodBeat.o(196923);
            return;
            if (!bs.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(196923);
              return;
            }
            ac.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(196923);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.br.d.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.nxw.hU();
      AppMethodBeat.o(196927);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */