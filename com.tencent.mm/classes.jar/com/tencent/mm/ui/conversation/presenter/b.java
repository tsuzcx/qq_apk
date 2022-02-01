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
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.al.p;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.bizchat.BizChatFavUI;

public final class b
  implements MenuItem.OnMenuItemClickListener, p, MMActivity.a
{
  private k PaM;
  private com.tencent.mm.al.d PaO;
  private final MMFragmentActivity Qjh;
  private com.tencent.mm.al.c.b Qji;
  private String iNV;
  private com.tencent.mm.ui.tools.m ppB;
  private String ppO;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public b(MMFragmentActivity paramMMFragmentActivity, String paramString)
  {
    AppMethodBeat.i(234306);
    this.Qji = new com.tencent.mm.al.c.b();
    this.Qjh = paramMMFragmentActivity;
    this.iNV = paramString;
    this.PaO = ag.bar().MO(paramString);
    if (this.PaO == null) {
      Log.w("EnterpriseConversationDropMenuPresenter", "init fatherAttr is null, username=%s", new Object[] { paramString });
    }
    ag.bah();
    this.ppO = f.MX(paramString);
    AppMethodBeat.o(234306);
  }
  
  private void Nq(long paramLong)
  {
    AppMethodBeat.i(234311);
    if ((this.Qjh instanceof BaseBizConversationUI))
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("key_biz_chat_id", paramLong);
      localBundle.putBoolean("finish_direct", false);
      localBundle.putBoolean("key_need_send_video", false);
      localBundle.putBoolean("key_is_biz_chat", true);
      ((BaseBizConversationUI)this.Qjh).startChatting(this.ppO, localBundle, true);
    }
    AppMethodBeat.o(234311);
  }
  
  private boolean gWn()
  {
    AppMethodBeat.i(234309);
    String str = ag.bal().fC(this.ppO);
    this.PaM = ag.bal().fB(str);
    if ((this.PaM == null) || (Util.isNullOrNil(this.PaM.field_addMemberUrl)))
    {
      AppMethodBeat.o(234309);
      return false;
    }
    AppMethodBeat.o(234309);
    return true;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(234308);
    String str = this.Qjh.getString(paramInt);
    AppMethodBeat.o(234308);
    return str;
  }
  
  public final void a(int paramInt, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(234312);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramq.getType() == 1355)
    {
      paramq = ((o)paramq).baD();
      paramq = ag.baj().NE(paramq.Lpw.LPp.KTl);
      if (paramq == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(2131764672), 0).show();
        AppMethodBeat.o(234312);
        return;
      }
      Nq(paramq.field_bizChatLocalId);
    }
    AppMethodBeat.o(234312);
  }
  
  public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(234310);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(234310);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(234310);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    bfs localbfs;
    if (paramIntent != null)
    {
      Log.i("EnterpriseConversationDropMenuPresenter", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localbfs = new bfs();
      com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
      if (this.PaM != null)
      {
        paramIntent = this.PaM.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.ppO;
        if (!com.tencent.mm.al.a.e.a(localc, (String)localObject, null, localbfs)) {
          break label252;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label194;
        }
        Nq(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this.Qjh, getString(2131764672), 0).show();
        AppMethodBeat.o(234310);
        return;
        paramIntent = null;
        break;
        label194:
        ag.baq();
        paramIntent = com.tencent.mm.al.a.h.a(this.ppO, localbfs, this);
        localObject = this.Qjh;
        getString(2131755998);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(234305);
            ag.baq();
            com.tencent.mm.al.a.h.d(paramIntent);
            AppMethodBeat.o(234305);
          }
        });
        paramInt1 = 1;
        continue;
        label252:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(234310);
      return;
      paramInt1 = 0;
    }
  }
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    AppMethodBeat.i(234307);
    paramMenuItem = g.fH(this.iNV);
    if (!Util.isNullOrNil(paramMenuItem)) {}
    for (final boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.Qji.fI(this.iNV);
      }
      if (this.ppB != null)
      {
        this.ppB.dismiss();
        this.ppB = null;
      }
      this.ppB = new com.tencent.mm.ui.tools.m(this.Qjh);
      this.ppB.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          int k = 0;
          AppMethodBeat.i(234302);
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
              paramAnonymousm.aS(1, 2131756830, 2131689481);
            }
            if (!g.fF(b.c(b.this)))
            {
              str = g.fG(b.c(b.this));
              if (!Util.isNullOrNil(str)) {
                break label189;
              }
              paramAnonymousm.aS(2, 2131756829, 2131691270);
            }
          }
          for (;;)
          {
            if (j != 0) {
              paramAnonymousm.a(4, b.d(b.this).getString(2131756828), ar.m(b.e(b.this), 2131689486, -1));
            }
            paramAnonymousm.a(3, b.d(b.this).getString(2131755153), ar.m(b.e(b.this), 2131689514, -1));
            AppMethodBeat.o(234302);
            return;
            i = 0;
            break;
            label189:
            paramAnonymousm.b(2, str, 2131691270);
          }
        }
      };
      this.ppB.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(234303);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(234303);
            return;
            b.f(b.this);
            AppMethodBeat.o(234303);
            return;
            if (bool)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("rawUrl", paramMenuItem);
              Log.i("EnterpriseConversationDropMenuPresenter", "KRawUrl :%s", new Object[] { paramMenuItem });
              paramAnonymousMenuItem.putExtra("useJs", true);
              paramAnonymousMenuItem.addFlags(67108864);
              com.tencent.mm.br.c.b(b.e(b.this), "webview", ".ui.tools.WebViewUI", paramAnonymousMenuItem, 0);
              AppMethodBeat.o(234303);
              return;
            }
            b.g(b.this).fI(b.c(b.this));
            b.g(b.this).z(b.h(b.this));
            AppMethodBeat.o(234303);
            return;
            if (!Util.isNullOrNil(b.i(b.this)))
            {
              Object localObject = new Intent(b.e(b.this), BizChatFavUI.class);
              ((Intent)localObject).putExtra("Contact_User", b.i(b.this));
              ((Intent)localObject).addFlags(67108864);
              paramAnonymousMenuItem = b.h(b.this);
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationDropMenuPresenter$2", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(234303);
              return;
            }
            Log.e("EnterpriseConversationDropMenuPresenter", "brandUserName null");
            AppMethodBeat.o(234303);
            return;
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Contact_User", b.c(b.this));
            com.tencent.mm.br.c.b(b.h(b.this), "profile", ".ui.ContactInfoUI", paramAnonymousMenuItem);
          }
        }
      };
      this.ppB.iv();
      AppMethodBeat.o(234307);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.b
 * JD-Core Version:    0.7.0.1
 */