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
import com.tencent.mm.am.s;
import com.tencent.mm.an.af;
import com.tencent.mm.an.e;
import com.tencent.mm.an.f;
import com.tencent.mm.an.g;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.doz;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fkn;
import com.tencent.mm.protocal.protobuf.fko;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.o.a;

public final class c
  implements com.tencent.mm.am.h, d
{
  private final a afuD;
  private boolean isDeleteCancel;
  private String ovT;
  private w tipDialog;
  private BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(256946);
    this.isDeleteCancel = false;
    this.afuD = new a();
    this.ui = paramBaseConversationUI;
    this.ovT = paramString;
    AppMethodBeat.o(256946);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256956);
    com.tencent.mm.an.d locald = af.bHq().Mi(this.ovT);
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
    for (long l3 = 0L;; l3 = paramc.aAU())
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      Log.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(256956);
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
    AppMethodBeat.i(256966);
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().aLF(paramString);
    aig localaig = new aig();
    localaig.ZqL = new etl().btH(Util.nullAsNil(paramString));
    localaig.Njv = ((fi)localObject).field_msgSvrId;
    bh.bCz();
    com.tencent.mm.model.c.bzz().d(new k.a(8, localaig));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(R.l.app_tip);
    br.a(paramString, new br.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(256912);
        c.a(c.this);
        AppMethodBeat.o(256912);
      }
    }
    {
      public final boolean aMJ()
      {
        AppMethodBeat.i(256881);
        boolean bool = c.b(c.this);
        AppMethodBeat.o(256881);
        return bool;
      }
      
      public final void aMK()
      {
        AppMethodBeat.i(256887);
        if (this.lAK != null) {
          this.lAK.dismiss();
        }
        AppMethodBeat.o(256887);
      }
    });
    ac.aY(paramString, 15);
    AppMethodBeat.o(256966);
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(256971);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(256971);
    return str;
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(257008);
    bb localbb = parama.conversation;
    if (localbb == null)
    {
      AppMethodBeat.o(257008);
      return;
    }
    Object localObject;
    if (g.Dn(localbb.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localbb.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, parama.aYi(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(257008);
      return;
    }
    if (g.MC(localbb.field_username))
    {
      com.tencent.mm.api.c localc = g.hU(localbb.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.aAT())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localbb.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.br.c.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localbb.field_unReadCount);
        AppMethodBeat.o(257008);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localbb.field_username, parama, true);
    a(g.hU(localbb.field_username), 1, localbb.field_unReadCount);
    AppMethodBeat.o(257008);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, o.a parama)
  {
    AppMethodBeat.i(257010);
    a.a(this.afuD);
    a.a(this.afuD, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(257010);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(257018);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(257018);
      return;
    }
    asyncDelMsg(paramString);
    bh.bCz();
    com.tencent.mm.model.c.bzG().bxK(paramString);
    paramString = af.bHf().Mn(paramString);
    bh.bCz();
    com.tencent.mm.model.c.bzF().bvq(paramString.field_enterpriseFather);
    AppMethodBeat.o(257018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(257016);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(257016);
      return;
    }
    if (paramp.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.a.d)paramp).gBg();
      Object localObject = ((com.tencent.mm.plugin.profile.a.d)paramp).gBf();
      if ((localObject == null) || (((fko)localObject).YRW == null) || (((fko)localObject).YRW.ret != 0))
      {
        if ((localObject != null) && (((fko)localObject).YRW != null))
        {
          Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(((fko)localObject).YRW.ret) });
          AppMethodBeat.o(257016);
          return;
        }
        Log.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramp.getType()) });
        AppMethodBeat.o(257016);
        return;
      }
      if (!paramString.disable)
      {
        AppMethodBeat.o(257016);
        return;
      }
      paramp = g.hU(paramString.YRQ);
      paramp.field_brandFlag |= 0x1;
      localObject = new doz();
      ((doz)localObject).pSt = paramp.field_brandFlag;
      ((doz)localObject).UserName = paramString.YRQ;
      bh.bCz();
      com.tencent.mm.model.c.bzz().d(new k.a(47, (com.tencent.mm.bx.a)localObject));
      af.bHf().update(paramp, new String[0]);
      bh.bCz();
      com.tencent.mm.model.c.bzG().bxK(paramp.field_username);
      bh.bCz();
      if (com.tencent.mm.model.c.bzG().byb(paramp.field_enterpriseFather) <= 0)
      {
        bh.bCz();
        com.tencent.mm.model.c.bzG().bxK(paramp.field_enterpriseFather);
        AppMethodBeat.o(257016);
        return;
      }
      bh.bCz();
      com.tencent.mm.model.c.bzF().bvq(paramp.field_enterpriseFather);
    }
    AppMethodBeat.o(257016);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a afuG;
    private String vDR = "";
    private u.i vGU;
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(256975);
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(this.vDR);
      if (localau == null)
      {
        Log.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.vDR);
        AppMethodBeat.o(256975);
        return;
      }
      String str = localau.aSV();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (Util.isNullOrNil(localau.field_nickname)) {
          paramView = c.a(c.this, R.l.gzv);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(c.c(c.this), paramView));
      if (localau.aSQ()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.gNg);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, R.l.enterprise_longclick_disable_sub);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, R.l.main_delete);
        AppMethodBeat.o(256975);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.enterprise_sub_placetop);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.c
 * JD-Core Version:    0.7.0.1
 */