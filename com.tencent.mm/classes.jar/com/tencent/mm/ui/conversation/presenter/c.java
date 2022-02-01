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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dlz;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class c
  implements com.tencent.mm.ak.f, d
{
  private final a KVW;
  private String hSG;
  boolean isDeleteCancel;
  p tipDialog;
  BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(188196);
    this.isDeleteCancel = false;
    this.KVW = new a();
    this.ui = paramBaseConversationUI;
    this.hSG = paramString;
    AppMethodBeat.o(188196);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188199);
    com.tencent.mm.al.d locald = ag.aGy().Ea(this.hSG);
    long l1;
    long l2;
    if (locald != null)
    {
      l1 = locald.field_wwCorpId;
      if (locald == null) {
        break label182;
      }
      l2 = locald.field_wwUserVid;
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
    for (long l3 = 0L;; l3 = paramc.KA())
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      ae.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(188199);
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
    AppMethodBeat.i(188202);
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().arb(paramString);
    adh localadh = new adh();
    localadh.GuF = new cxn().aQV(bu.nullAsNil(paramString));
    localadh.xrk = ((ei)localObject).field_msgSvrId;
    bc.aCg();
    com.tencent.mm.model.c.azE().d(new k.a(8, localadh));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(2131755906);
    bl.a(paramString, new bl.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.isDeleteCancel = true;
      }
    }
    {
      public final boolean YT()
      {
        return c.this.isDeleteCancel;
      }
      
      public final void YU()
      {
        AppMethodBeat.i(188191);
        if (this.fPt != null) {
          this.fPt.dismiss();
        }
        AppMethodBeat.o(188191);
      }
    });
    AppMethodBeat.o(188202);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(188197);
    au localau = parama.conversation;
    if (localau == null)
    {
      AppMethodBeat.o(188197);
      return;
    }
    Object localObject;
    if (com.tencent.mm.al.g.vz(localau.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localau.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, parama.ahE(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(188197);
      return;
    }
    if (com.tencent.mm.al.g.Et(localau.field_username))
    {
      com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(localau.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.Kz())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localau.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.br.d.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localau.field_unReadCount);
        AppMethodBeat.o(188197);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localau.field_username, parama, true);
    a(com.tencent.mm.al.g.eX(localau.field_username), 1, localau.field_unReadCount);
    AppMethodBeat.o(188197);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(188198);
    a.a(this.KVW);
    a.a(this.KVW, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(188198);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(188201);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(188201);
      return;
    }
    asyncDelMsg(paramString);
    bc.aCg();
    com.tencent.mm.model.c.azL().aUY(paramString);
    paramString = ag.aGp().Ef(paramString);
    bc.aCg();
    com.tencent.mm.model.c.azK().aTS(paramString.field_enterpriseFather);
    AppMethodBeat.o(188201);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(188203);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(188203);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(188200);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(188200);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dDI();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dDH();
      if ((localObject == null) || (((dma)localObject).FZD == null) || (((dma)localObject).FZD.ret != 0))
      {
        if ((localObject != null) && (((dma)localObject).FZD != null))
        {
          ae.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dma)localObject).FZD.ret) });
          AppMethodBeat.o(188200);
          return;
        }
        ae.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(188200);
        return;
      }
      if (!paramString.lXh)
      {
        AppMethodBeat.o(188200);
        return;
      }
      paramn = com.tencent.mm.al.g.eX(paramString.FZx);
      paramn.field_brandFlag |= 0x1;
      localObject = new cac();
      ((cac)localObject).jgj = paramn.field_brandFlag;
      ((cac)localObject).nIJ = paramString.FZx;
      bc.aCg();
      com.tencent.mm.model.c.azE().d(new k.a(47, (com.tencent.mm.bw.a)localObject));
      ag.aGp().update(paramn, new String[0]);
      bc.aCg();
      com.tencent.mm.model.c.azL().aUY(paramn.field_username);
      bc.aCg();
      if (com.tencent.mm.model.c.azL().aVm(paramn.field_enterpriseFather) <= 0)
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().aUY(paramn.field_enterpriseFather);
        AppMethodBeat.o(188200);
        return;
      }
      bc.aCg();
      com.tencent.mm.model.c.azK().aTS(paramn.field_enterpriseFather);
    }
    AppMethodBeat.o(188200);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a KVZ;
    private String oen = "";
    private n.e ogY;
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(188193);
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(this.oen);
      if (localan == null)
      {
        ae.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.oen);
        AppMethodBeat.o(188193);
        return;
      }
      String str = localan.adG();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (bu.isNullOrNil(localan.field_nickname)) {
          paramView = c.this.getString(2131757293);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(k.c(c.this.ui, paramView));
      if (localan.adB()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131758443);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131761057);
        AppMethodBeat.o(188193);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131758450);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.c
 * JD-Core Version:    0.7.0.1
 */