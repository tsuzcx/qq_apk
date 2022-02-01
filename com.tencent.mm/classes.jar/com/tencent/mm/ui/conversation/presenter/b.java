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
import com.tencent.mm.an.q;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.p;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bizchat.BizChatFavUI;
import com.tencent.mm.ui.tools.n;

public final class b
  implements MenuItem.OnMenuItemClickListener, p, MMActivity.a
{
  private k WtZ;
  private com.tencent.mm.ao.d Wub;
  private final MMFragmentActivity XGn;
  private com.tencent.mm.ao.c.b XGo;
  private String lEm;
  private n syA;
  private String syN;
  private s tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(196709);
    this.XGo = new com.tencent.mm.ao.c.b();
    this.XGn = paramMMFragmentActivity;
    this.lEm = paramString;
    this.Wub = af.bjF().Uj(paramString);
    if (this.Wub == null) {
      Log.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    af.bjv();
    this.syN = f.Ut(paramString);
    AppMethodBeat.o(196709);
  }
  
  private void Vy(long paramLong)
  {
    AppMethodBeat.i(196732);
    if ((this.XGn instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.XGn).startChatting(this.syN, localBundle, true);
    }
    AppMethodBeat.o(196732);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(196718);
    String str = this.XGn.getString(paramInt);
    AppMethodBeat.o(196718);
    return str;
  }
  
  private boolean hWP()
  {
    AppMethodBeat.i(196721);
    String str = af.bjz().gn(this.syN);
    this.WtZ = af.bjz().gm(str);
    if ((this.WtZ == null) || (Util.isNullOrNil(this.WtZ.field_addMemberUrl)))
    {
      AppMethodBeat.o(196721);
      return false;
    }
    AppMethodBeat.o(196721);
    return true;
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(196735);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramq.getType() == 1355)
    {
      paramq = ((com.tencent.mm.ao.a.o)paramq).bjS();
      paramq = af.bjx().Va(paramq.SqS.SXD.RUi);
      if (paramq == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.eQP), 0).show();
        AppMethodBeat.o(196735);
        return;
      }
      Vy(paramq.field_bizChatLocalId);
    }
    AppMethodBeat.o(196735);
  }
  
  public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(196729);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(196729);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(196729);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    bms localbms;
    if (paramIntent != null)
    {
      Log.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localbms = new bms();
      com.tencent.mm.ao.a.c localc = new com.tencent.mm.ao.a.c();
      if (this.WtZ != null)
      {
        paramIntent = this.WtZ.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.syN;
        if (!com.tencent.mm.ao.a.e.a(localc, (String)localObject, null, localbms)) {
          break label254;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        Vy(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.XGn, getString(R.l.eQP), 0).show();
        AppMethodBeat.o(196729);
        return;
        paramIntent = null;
        break;
        label194:
        af.bjE();
        paramIntent = com.tencent.mm.ao.a.h.a(this.syN, localbms, this);
        localObject = this.XGn;
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(289581);
            af.bjE();
            com.tencent.mm.ao.a.h.d(paramIntent);
            AppMethodBeat.o(289581);
          }
        });
        paramInt1 = 1;
        continue;
        label254:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(196729);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(196716);
    paramMenuItem = g.gs(this.lEm);
    if (!Util.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.XGo.gt(this.lEm);
      }
      if (this.syA != null)
      {
        this.syA.dismiss();
        this.syA = null;
      }
      this.syA = new n(this.XGn);
      this.syA.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          int k = 0;
          AppMethodBeat.i(272726);
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
              paramAnonymouso.aW(1, R.l.esZ, R.k.actionbar_create_biz_chat_icon);
            }
            if (!g.gq(b.c(b.this)))
            {
              str = g.gr(b.c(b.this));
              if (!Util.isNullOrNil(str)) {
                break label197;
              }
              paramAnonymouso.aW(2, R.l.esY, R.k.ofm_add_icon);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymouso.a(4, b.d(b.this).getString(R.l.esX), au.o(b.e(b.this), R.k.actionbar_facefriend_icon, -1));
            }
            paramAnonymouso.a(3, b.d(b.this).getString(R.l.actionbar_title_setting), au.o(b.e(b.this), R.k.actionbar_setting_white_icon, -1));
            AppMethodBeat.o(272726);
            return;
            i = 0;
            break;
            label197:
            paramAnonymouso.b(2, str, R.k.ofm_add_icon);
          }
        }
      };
      this.syA.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(215588);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(215588);
            return;
            b.f(b.this);
            AppMethodBeat.o(215588);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              Log.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.by.c.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(215588);
              return;
            }
            b.g(b.this).gt(b.c(b.this));
            b.g(b.this).y(b.h(b.this));
            AppMethodBeat.o(215588);
            return;
            if (!Util.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(215588);
              return;
            }
            Log.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(215588);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.by.c.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.syA.cB();
      AppMethodBeat.o(196716);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */