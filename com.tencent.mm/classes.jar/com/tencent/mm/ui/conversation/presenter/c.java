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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.j;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class c
  implements g, d
{
  private final a IIv;
  private String hxt;
  boolean isDeleteCancel;
  p tipDialog;
  BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(196943);
    this.isDeleteCancel = false;
    this.IIv = new a();
    this.ui = paramBaseConversationUI;
    this.hxt = paramString;
    AppMethodBeat.o(196943);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196946);
    com.tencent.mm.al.c localc = af.aDf().Az(this.hxt);
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
    for (long l3 = 0L;; l3 = paramc.IS())
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      ac.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(196946);
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
    AppMethodBeat.i(196949);
    com.tencent.mm.model.az.ayM();
    Object localObject = com.tencent.mm.model.c.awD().alj(paramString);
    aay localaay = new aay();
    localaay.EuE = new crm().aJV(bs.nullAsNil(paramString));
    localaay.vTQ = ((dy)localObject).field_msgSvrId;
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awA().c(new j.a(8, localaay));
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
      public final boolean Wr()
      {
        return c.this.isDeleteCancel;
      }
      
      public final void Ws()
      {
        AppMethodBeat.i(196938);
        if (this.fuk != null) {
          this.fuk.dismiss();
        }
        AppMethodBeat.o(196938);
      }
    });
    AppMethodBeat.o(196949);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(196944);
    ap localap = parama.conversation;
    if (localap == null)
    {
      AppMethodBeat.o(196944);
      return;
    }
    Object localObject;
    if (f.so(localap.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localap.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().ba(parama);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, parama.aeD(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(196944);
      return;
    }
    if (f.AS(localap.field_username))
    {
      com.tencent.mm.api.c localc = f.dX(localap.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.IR())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localap.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.br.d.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localap.field_unReadCount);
        AppMethodBeat.o(196944);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localap.field_username, parama, true);
    a(f.dX(localap.field_username), 1, localap.field_unReadCount);
    AppMethodBeat.o(196944);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(196945);
    a.a(this.IIv);
    a.a(this.IIv, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(196945);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(196948);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(196948);
      return;
    }
    asyncDelMsg(paramString);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awG().aNG(paramString);
    paramString = af.aCW().AE(paramString);
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.model.c.awF().aMJ(paramString.field_enterpriseFather);
    AppMethodBeat.o(196948);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(196950);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(196950);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(196947);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(196947);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dpO();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dpN();
      if ((localObject == null) || (((dfq)localObject).Eby == null) || (((dfq)localObject).Eby.ret != 0))
      {
        if ((localObject != null) && (((dfq)localObject).Eby != null))
        {
          ac.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dfq)localObject).Eby.ret) });
          AppMethodBeat.o(196947);
          return;
        }
        ac.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(196947);
        return;
      }
      if (!paramString.ltx)
      {
        AppMethodBeat.o(196947);
        return;
      }
      paramn = f.dX(paramString.Ebs);
      paramn.field_brandFlag |= 0x1;
      localObject = new but();
      ((but)localObject).iKh = paramn.field_brandFlag;
      ((but)localObject).ncR = paramString.Ebs;
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awA().c(new j.a(47, (com.tencent.mm.bw.a)localObject));
      af.aCW().update(paramn, new String[0]);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().aNG(paramn.field_username);
      com.tencent.mm.model.az.ayM();
      if (com.tencent.mm.model.c.awG().aNU(paramn.field_enterpriseFather) <= 0)
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().aNG(paramn.field_enterpriseFather);
        AppMethodBeat.o(196947);
        return;
      }
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awF().aMJ(paramn.field_enterpriseFather);
    }
    AppMethodBeat.o(196947);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a IIy;
    private n.d nAc;
    private String nxg = "";
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(196940);
      com.tencent.mm.model.az.ayM();
      ai localai = com.tencent.mm.model.c.awB().aNt(this.nxg);
      if (localai == null)
      {
        ac.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.nxg);
        AppMethodBeat.o(196940);
        return;
      }
      String str = localai.aaS();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (bs.isNullOrNil(localai.field_nickname)) {
          paramView = c.this.getString(2131757293);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(k.c(c.this.ui, paramView));
      if (localai.aaN()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131758443);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131761057);
        AppMethodBeat.o(196940);
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