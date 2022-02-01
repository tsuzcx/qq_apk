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
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.af;
import com.tencent.mm.am.f;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.m;

public final class b
  implements MenuItem.OnMenuItemClickListener, com.tencent.mm.am.o, MMActivity.a
{
  private k Ghm;
  private com.tencent.mm.am.c Gho;
  private final MMFragmentActivity HhX;
  private com.tencent.mm.am.c.b HhY;
  private String gWU;
  private m mUW;
  private String mVj;
  private p tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(191812);
    this.HhY = new com.tencent.mm.am.c.b();
    this.HhX = paramMMFragmentActivity;
    this.gWU = paramString;
    this.Gho = af.awn().wt(paramString);
    af.awe();
    this.mVj = com.tencent.mm.am.e.wC(paramString);
    AppMethodBeat.o(191812);
  }
  
  private boolean fcT()
  {
    AppMethodBeat.i(191815);
    String str = af.awi().eb(this.mVj);
    this.Ghm = af.awi().ea(str);
    if ((this.Ghm == null) || (bt.isNullOrNil(this.Ghm.field_addMemberUrl)))
    {
      AppMethodBeat.o(191815);
      return false;
    }
    AppMethodBeat.o(191815);
    return true;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(191814);
    String str = this.HhX.getString(paramInt);
    AppMethodBeat.o(191814);
    return str;
  }
  
  private void wu(long paramLong)
  {
    AppMethodBeat.i(191817);
    if ((this.HhX instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.HhX).startChatting(this.mVj, localBundle, true);
    }
    AppMethodBeat.o(191817);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(191818);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((com.tencent.mm.am.a.o)paramn).awz();
      paramn = af.awg().xj(paramn.DaY.DnW.CIJ);
      if (paramn == null)
      {
        Toast.makeText(aj.getContext(), getString(2131762592), 0).show();
        AppMethodBeat.o(191818);
        return;
      }
      wu(paramn.field_bizChatLocalId);
    }
    AppMethodBeat.o(191818);
  }
  
  public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(191816);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(191816);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(191816);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    amv localamv;
    if (paramIntent != null)
    {
      ad.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localamv = new amv();
      com.tencent.mm.am.a.c localc = new com.tencent.mm.am.a.c();
      if (this.Ghm != null)
      {
        paramIntent = this.Ghm.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.mVj;
        if (!com.tencent.mm.am.a.e.a(localc, (String)localObject, null, localamv)) {
          break label252;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        wu(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.HhX, getString(2131762592), 0).show();
        AppMethodBeat.o(191816);
        return;
        paramIntent = null;
        break;
        label194:
        af.awm();
        paramIntent = com.tencent.mm.am.a.h.a(this.mVj, localamv, this);
        localObject = this.HhX;
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(191811);
            af.awm();
            com.tencent.mm.am.a.h.d(paramIntent);
            AppMethodBeat.o(191811);
          }
        });
        paramInt1 = 1;
        continue;
        label252:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(191816);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(191813);
    paramMenuItem = f.eg(this.gWU);
    if (!bt.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.HhY.eh(this.gWU);
      }
      if (this.mUW != null)
      {
        this.mUW.dismiss();
        this.mUW = null;
      }
      this.mUW = new m(this.HhX);
      this.mUW.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(191808);
          int i;
          String str;
          if ((!b.a(b.this).field_hide_create_chat) && (b.b(b.this)))
          {
            i = 1;
            if (i != 0) {
              paramAnonymousl.aI(1, 2131756674, 2131689479);
            }
            if (!f.ee(b.c(b.this)))
            {
              str = f.ef(b.c(b.this));
              if (!bt.isNullOrNil(str)) {
                break label162;
              }
              paramAnonymousl.aI(2, 2131760267, 2131690972);
            }
          }
          for (;;)
          {
            if (i != 0) {
              paramAnonymousl.a(4, b.d(b.this).getString(2131756673), am.i(b.e(b.this), 2131689484, -1));
            }
            paramAnonymousl.a(3, b.d(b.this).getString(2131755135), am.i(b.e(b.this), 2131689512, -1));
            AppMethodBeat.o(191808);
            return;
            i = 0;
            break;
            label162:
            paramAnonymousl.a(2, str, 2131690972);
          }
        }
      };
      this.mUW.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(191809);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(191809);
            return;
            b.f(b.this);
            AppMethodBeat.o(191809);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              ad.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.bs.d.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(191809);
              return;
            }
            b.g(b.this).eh(b.c(b.this));
            b.g(b.this).z(b.h(b.this));
            AppMethodBeat.o(191809);
            return;
            if (!bt.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(191809);
              return;
            }
            ad.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(191809);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.bs.d.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.mUW.hM();
      AppMethodBeat.o(191813);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */