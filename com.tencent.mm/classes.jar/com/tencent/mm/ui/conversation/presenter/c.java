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
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.m.a;

public final class c
  implements com.tencent.mm.an.i, d
{
  private final a XGs;
  private boolean isDeleteCancel;
  private String lEm;
  private s tipDialog;
  private BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(223309);
    this.isDeleteCancel = false;
    this.XGs = new a();
    this.ui = paramBaseConversationUI;
    this.lEm = paramString;
    AppMethodBeat.o(223309);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223337);
    com.tencent.mm.ao.d locald = af.bjF().Uj(this.lEm);
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
    for (long l3 = 0L;; l3 = paramc.Zc())
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      Log.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(223337);
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
    AppMethodBeat.i(223355);
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().aOG(paramString);
    aft localaft = new aft();
    localaft.SrH = new eaf().btQ(Util.nullAsNil(paramString));
    localaft.HlH = ((et)localObject).field_msgSvrId;
    bh.beI();
    com.tencent.mm.model.c.bbK().d(new k.a(8, localaft));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(R.l.app_tip);
    bq.a(paramString, new bq.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(232971);
        c.a(c.this);
        AppMethodBeat.o(232971);
      }
    }
    {
      public final boolean asH()
      {
        AppMethodBeat.i(208722);
        boolean bool = c.b(c.this);
        AppMethodBeat.o(208722);
        return bool;
      }
      
      public final void asI()
      {
        AppMethodBeat.i(208725);
        if (this.iYO != null) {
          this.iYO.dismiss();
        }
        AppMethodBeat.o(208725);
      }
    });
    AppMethodBeat.o(223355);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(223357);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(223357);
    return str;
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(223317);
    az localaz = parama.conversation;
    if (localaz == null)
    {
      AppMethodBeat.o(223317);
      return;
    }
    Object localObject;
    if (g.KI(localaz.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localaz.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().bm(parama);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, parama.aFh(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(223317);
      return;
    }
    if (g.UD(localaz.field_username))
    {
      com.tencent.mm.api.c localc = g.gu(localaz.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.Zb())
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
        com.tencent.mm.by.c.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localaz.field_unReadCount);
        AppMethodBeat.o(223317);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localaz.field_username, parama, true);
    a(g.gu(localaz.field_username), 1, localaz.field_unReadCount);
    AppMethodBeat.o(223317);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, m.a parama)
  {
    AppMethodBeat.i(223323);
    a.a(this.XGs);
    a.a(this.XGs, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(223323);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(223350);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(223350);
      return;
    }
    asyncDelMsg(paramString);
    bh.beI();
    com.tencent.mm.model.c.bbR().bwv(paramString);
    paramString = af.bjv().Uo(paramString);
    bh.beI();
    com.tencent.mm.model.c.bbQ().bvi(paramString.field_enterpriseFather);
    AppMethodBeat.o(223350);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(223348);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(223348);
      return;
    }
    if (paramq.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramq).fpS();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramq).fpR();
      if ((localObject == null) || (((epp)localObject).RUv == null) || (((epp)localObject).RUv.ret != 0))
      {
        if ((localObject != null) && (((epp)localObject).RUv != null))
        {
          Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(((epp)localObject).RUv.ret) });
          AppMethodBeat.o(223348);
          return;
        }
        Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramq.getType()) });
        AppMethodBeat.o(223348);
        return;
      }
      if (!paramString.qfB)
      {
        AppMethodBeat.o(223348);
        return;
      }
      paramq = g.gu(paramString.RUp);
      paramq.field_brandFlag |= 0x1;
      localObject = new cxu();
      ((cxu)localObject).mVM = paramq.field_brandFlag;
      ((cxu)localObject).UserName = paramString.RUp;
      bh.beI();
      com.tencent.mm.model.c.bbK().d(new k.a(47, (com.tencent.mm.cd.a)localObject));
      af.bjv().update(paramq, new String[0]);
      bh.beI();
      com.tencent.mm.model.c.bbR().bwv(paramq.field_username);
      bh.beI();
      if (com.tencent.mm.model.c.bbR().bwI(paramq.field_enterpriseFather) <= 0)
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().bwv(paramq.field_enterpriseFather);
        AppMethodBeat.o(223348);
        return;
      }
      bh.beI();
      com.tencent.mm.model.c.bbQ().bvi(paramq.field_enterpriseFather);
    }
    AppMethodBeat.o(223348);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a XGv;
    private q.g sBv;
    private String syk = "";
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(280190);
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(this.syk);
      if (localas == null)
      {
        Log.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.syk);
        AppMethodBeat.o(280190);
        return;
      }
      String str = localas.ays();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (Util.isNullOrNil(localas.field_nickname)) {
          paramView = c.a(c.this, R.l.ewS);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(l.c(c.c(c.this), paramView));
      if (localas.ayn()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.eLm);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, R.l.eCv);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, R.l.main_delete);
        AppMethodBeat.o(280190);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.eCx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.c
 * JD-Core Version:    0.7.0.1
 */