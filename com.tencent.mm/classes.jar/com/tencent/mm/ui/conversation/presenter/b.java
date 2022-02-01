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
import com.tencent.mm.al.n;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.o;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.am.g;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b
  implements MenuItem.OnMenuItemClickListener, com.tencent.mm.am.p, MMActivity.a
{
  private k JuS;
  private com.tencent.mm.am.d JuU;
  private final MMFragmentActivity Kzx;
  private com.tencent.mm.am.c.b Kzy;
  private String hPO;
  private m nYU;
  private String nZh;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(194777);
    this.Kzy = new com.tencent.mm.am.c.b();
    this.Kzx = paramMMFragmentActivity;
    this.hPO = paramString;
    this.JuU = ag.aGi().Dy(paramString);
    if (this.JuU == null) {
      ad.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    ag.aFZ();
    this.nZh = f.DH(paramString);
    AppMethodBeat.o(194777);
  }
  
  private void DN(long paramLong)
  {
    AppMethodBeat.i(194782);
    if ((this.Kzx instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.Kzx).startChatting(this.nZh, localBundle, true);
    }
    AppMethodBeat.o(194782);
  }
  
  private boolean fJC()
  {
    AppMethodBeat.i(194780);
    String str = ag.aGd().eL(this.nZh);
    this.JuS = ag.aGd().eK(str);
    if ((this.JuS == null) || (bt.isNullOrNil(this.JuS.field_addMemberUrl)))
    {
      AppMethodBeat.o(194780);
      return false;
    }
    AppMethodBeat.o(194780);
    return true;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(194779);
    String str = this.Kzx.getString(paramInt);
    AppMethodBeat.o(194779);
    return str;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(194783);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((o)paramn).aGu();
      paramn = ag.aGb().Eo(paramn.Gbn.GrN.FGU);
      if (paramn == null)
      {
        Toast.makeText(aj.getContext(), getString(2131762592), 0).show();
        AppMethodBeat.o(194783);
        return;
      }
      DN(paramn.field_bizChatLocalId);
    }
    AppMethodBeat.o(194783);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(194781);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(194781);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(194781);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    att localatt;
    if (paramIntent != null)
    {
      ad.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localatt = new att();
      c localc = new c();
      if (this.JuS != null)
      {
        paramIntent = this.JuS.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.nZh;
        if (!com.tencent.mm.am.a.e.a(localc, (String)localObject, null, localatt)) {
          break label252;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        DN(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.Kzx, getString(2131762592), 0).show();
        AppMethodBeat.o(194781);
        return;
        paramIntent = null;
        break;
        label194:
        ag.aGh();
        paramIntent = com.tencent.mm.am.a.h.a(this.nZh, localatt, this);
        localObject = this.Kzx;
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(194776);
            ag.aGh();
            com.tencent.mm.am.a.h.d(paramIntent);
            AppMethodBeat.o(194776);
          }
        });
        paramInt1 = 1;
        continue;
        label252:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(194781);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(194778);
    paramMenuItem = g.eQ(this.hPO);
    if (!bt.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.Kzy.eR(this.hPO);
      }
      if (this.nYU != null)
      {
        this.nYU.dismiss();
        this.nYU = null;
      }
      this.nYU = new m(this.Kzx);
      this.nYU.KJy = new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          int k = 0;
          AppMethodBeat.i(194773);
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
              paramAnonymousl.aL(1, 2131756674, 2131689479);
            }
            if (!g.eO(b.c(b.this)))
            {
              str = g.eP(b.c(b.this));
              if (!bt.isNullOrNil(str)) {
                break label189;
              }
              paramAnonymousl.aL(2, 2131760267, 2131690972);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymousl.a(4, b.d(b.this).getString(2131756673), ao.k(b.e(b.this), 2131689484, -1));
            }
            paramAnonymousl.a(3, b.d(b.this).getString(2131755135), ao.k(b.e(b.this), 2131689512, -1));
            AppMethodBeat.o(194773);
            return;
            i = 0;
            break;
            label189:
            paramAnonymousl.a(2, str, 2131690972);
          }
        }
      };
      this.nYU.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(194774);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(194774);
            return;
            b.f(b.this);
            AppMethodBeat.o(194774);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              ad.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.bs.d.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(194774);
              return;
            }
            b.g(b.this).eR(b.c(b.this));
            b.g(b.this).z(b.h(b.this));
            AppMethodBeat.o(194774);
            return;
            if (!bt.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(194774);
              return;
            }
            ad.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(194774);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.bs.d.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.nYU.il();
      AppMethodBeat.o(194778);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */