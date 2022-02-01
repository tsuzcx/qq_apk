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
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class c
  implements com.tencent.mm.ak.i, d
{
  private final a Qjm;
  private String iNV;
  boolean isDeleteCancel;
  com.tencent.mm.ui.base.q tipDialog;
  BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(234323);
    this.isDeleteCancel = false;
    this.Qjm = new a();
    this.ui = paramBaseConversationUI;
    this.iNV = paramString;
    AppMethodBeat.o(234323);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234326);
    com.tencent.mm.al.d locald = ag.bar().MO(this.iNV);
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
    for (long l3 = 0L;; l3 = paramc.UK())
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      Log.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(234326);
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
    AppMethodBeat.i(234329);
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().aEw(paramString);
    afk localafk = new afk();
    localafk.Lqk = new dqi().bhy(Util.nullAsNil(paramString));
    localafk.Brn = ((eo)localObject).field_msgSvrId;
    bg.aVF();
    com.tencent.mm.model.c.aSM().d(new k.a(8, localafk));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(2131755998);
    bp.a(paramString, new bp.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.isDeleteCancel = true;
      }
    }
    {
      public final boolean amG()
      {
        return c.this.isDeleteCancel;
      }
      
      public final void amH()
      {
        AppMethodBeat.i(234318);
        if (this.guD != null) {
          this.guD.dismiss();
        }
        AppMethodBeat.o(234318);
      }
    });
    AppMethodBeat.o(234329);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(234324);
    az localaz = parama.conversation;
    if (localaz == null)
    {
      AppMethodBeat.o(234324);
      return;
    }
    Object localObject;
    if (g.DQ(localaz.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localaz.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().bl(parama);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, parama.axQ(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(234324);
      return;
    }
    if (g.Nh(localaz.field_username))
    {
      com.tencent.mm.api.c localc = g.fJ(localaz.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.UJ())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localaz.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.br.c.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localaz.field_unReadCount);
        AppMethodBeat.o(234324);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localaz.field_username, parama, true);
    a(g.fJ(localaz.field_username), 1, localaz.field_unReadCount);
    AppMethodBeat.o(234324);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(234325);
    a.a(this.Qjm);
    a.a(this.Qjm, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(234325);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(234328);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(234328);
      return;
    }
    asyncDelMsg(paramString);
    bg.aVF();
    com.tencent.mm.model.c.aST().bjW(paramString);
    paramString = ag.bah().MT(paramString);
    bg.aVF();
    com.tencent.mm.model.c.aSS().biO(paramString.field_enterpriseFather);
    AppMethodBeat.o(234328);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(234330);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(234330);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(234327);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(234327);
      return;
    }
    if (paramq.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).eDZ();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramq).eDY();
      if ((localObject == null) || (((efn)localObject).KTz == null) || (((efn)localObject).KTz.ret != 0))
      {
        if ((localObject != null) && (((efn)localObject).KTz != null))
        {
          Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((efn)localObject).KTz.ret) });
          AppMethodBeat.o(234327);
          return;
        }
        Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
        AppMethodBeat.o(234327);
        return;
      }
      if (!paramString.neT)
      {
        AppMethodBeat.o(234327);
        return;
      }
      paramq = g.fJ(paramString.KTt);
      paramq.field_brandFlag |= 0x1;
      localObject = new cpe();
      ((cpe)localObject).kem = paramq.field_brandFlag;
      ((cpe)localObject).UserName = paramString.KTt;
      bg.aVF();
      com.tencent.mm.model.c.aSM().d(new k.a(47, (com.tencent.mm.bw.a)localObject));
      ag.bah().update(paramq, new String[0]);
      bg.aVF();
      com.tencent.mm.model.c.aST().bjW(paramq.field_username);
      bg.aVF();
      if (com.tencent.mm.model.c.aST().bkk(paramq.field_enterpriseFather) <= 0)
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(paramq.field_enterpriseFather);
        AppMethodBeat.o(234327);
        return;
      }
      bg.aVF();
      com.tencent.mm.model.c.aSS().biO(paramq.field_enterpriseFather);
    }
    AppMethodBeat.o(234327);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a Qjp;
    private String ppl = "";
    private o.g pso;
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(234320);
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(this.ppl);
      if (localas == null)
      {
        Log.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.ppl);
        AppMethodBeat.o(234320);
        return;
      }
      String str = localas.arJ();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (Util.isNullOrNil(localas.field_nickname)) {
          paramView = c.this.getString(2131757507);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(l.c(c.this.ui, paramView));
      if (localas.arE()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131762839);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131758741);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131762843);
        AppMethodBeat.o(234320);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131758748);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.c
 * JD-Core Version:    0.7.0.1
 */