package com.tencent.mm.ui.conversation.presenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.am.e;
import com.tencent.mm.am.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.j;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class c
  implements g, d
{
  private final a Hic;
  private String gWU;
  boolean isDeleteCancel;
  p tipDialog;
  BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(191829);
    this.isDeleteCancel = false;
    this.Hic = new a();
    this.ui = paramBaseConversationUI;
    this.gWU = paramString;
    AppMethodBeat.o(191829);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191832);
    com.tencent.mm.am.c localc = com.tencent.mm.am.af.awn().wt(this.gWU);
    long l1;
    long l2;
    if (localc != null)
    {
      l1 = localc.field_wwCorpId;
      if (localc == null) {
        break label182;
      }
      l2 = localc.field_wwUserVid;
      label41:
      if (paramInt2 <= 0) {
        break label188;
      }
      paramInt2 = 1;
      label47:
      if (paramc != null) {
        break label193;
      }
    }
    label182:
    label188:
    label193:
    for (long l3 = 0L;; l3 = paramc.Jj())
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      ad.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(191832);
      return;
      l1 = 0L;
      break;
      l2 = 0L;
      break label41;
      paramInt2 = 2;
      break label47;
    }
  }
  
  private void asyncDelMsg(String paramString)
  {
    AppMethodBeat.i(191835);
    az.arV();
    Object localObject = com.tencent.mm.model.c.apO().agp(paramString);
    zz localzz = new zz();
    localzz.Dby = new cmf().aEE(bt.nullAsNil(paramString));
    localzz.uKZ = ((du)localObject).field_msgSvrId;
    az.arV();
    com.tencent.mm.model.c.apL().c(new j.a(8, localzz));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(2131755906);
    bi.a(paramString, new bi.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.isDeleteCancel = true;
      }
    }
    {
      public final boolean Vt()
      {
        return c.this.isDeleteCancel;
      }
      
      public final void Vu()
      {
        AppMethodBeat.i(191824);
        if (this.fqF != null) {
          this.fqF.dismiss();
        }
        AppMethodBeat.o(191824);
      }
    });
    AppMethodBeat.o(191835);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(191830);
    am localam = parama.conversation;
    if (localam == null)
    {
      AppMethodBeat.o(191830);
      return;
    }
    Object localObject;
    if (f.pc(localam.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localam.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().bd(parama);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, parama.adn(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(191830);
      return;
    }
    if (f.wM(localam.field_username))
    {
      com.tencent.mm.api.c localc = f.ei(localam.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.Ji())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localam.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.bs.d.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localam.field_unReadCount);
        AppMethodBeat.o(191830);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localam.field_username, parama, true);
    a(f.ei(localam.field_username), 1, localam.field_unReadCount);
    AppMethodBeat.o(191830);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(191831);
    a.a(this.Hic);
    a.a(this.Hic, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(191831);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(191834);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(191834);
      return;
    }
    asyncDelMsg(paramString);
    az.arV();
    com.tencent.mm.model.c.apR().aIl(paramString);
    paramString = com.tencent.mm.am.af.awe().wy(paramString);
    az.arV();
    com.tencent.mm.model.c.apQ().aHp(paramString.field_enterpriseFather);
    AppMethodBeat.o(191834);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(191836);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(191836);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(191833);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(191833);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dcg();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dcf();
      if ((localObject == null) || (((dae)localObject).CIW == null) || (((dae)localObject).CIW.ret != 0))
      {
        if ((localObject != null) && (((dae)localObject).CIW != null))
        {
          ad.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dae)localObject).CIW.ret) });
          AppMethodBeat.o(191833);
          return;
        }
        ad.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(191833);
        return;
      }
      if (!paramString.kRX)
      {
        AppMethodBeat.o(191833);
        return;
      }
      paramn = f.ei(paramString.CIQ);
      paramn.field_brandFlag |= 0x1;
      localObject = new bqc();
      ((bqc)localObject).ika = paramn.field_brandFlag;
      ((bqc)localObject).mAQ = paramString.CIQ;
      az.arV();
      com.tencent.mm.model.c.apL().c(new j.a(47, (com.tencent.mm.bx.a)localObject));
      com.tencent.mm.am.af.awe().update(paramn, new String[0]);
      az.arV();
      com.tencent.mm.model.c.apR().aIl(paramn.field_username);
      az.arV();
      if (com.tencent.mm.model.c.apR().aIy(paramn.field_enterpriseFather) <= 0)
      {
        az.arV();
        com.tencent.mm.model.c.apR().aIl(paramn.field_enterpriseFather);
        AppMethodBeat.o(191833);
        return;
      }
      az.arV();
      com.tencent.mm.model.c.apQ().aHp(paramn.field_enterpriseFather);
    }
    AppMethodBeat.o(191833);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a Hif;
    private String mUH = "";
    private n.d mXD;
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(191826);
      az.arV();
      com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(this.mUH);
      if (localaf == null)
      {
        ad.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.mUH);
        AppMethodBeat.o(191826);
        return;
      }
      String str = localaf.ZX();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (bt.isNullOrNil(localaf.field_nickname)) {
          paramView = c.this.getString(2131757293);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(k.c(c.this.ui, paramView));
      if (localaf.ZS()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131758443);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131761057);
        AppMethodBeat.o(191826);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131758450);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.c
 * JD-Core Version:    0.7.0.1
 */