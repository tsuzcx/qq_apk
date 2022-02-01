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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class c
  implements com.tencent.mm.al.f, d
{
  private final a KzC;
  private String hPO;
  boolean isDeleteCancel;
  p tipDialog;
  BaseConversationUI ui;
  
  public c(BaseConversationUI paramBaseConversationUI, String paramString)
  {
    AppMethodBeat.i(194794);
    this.isDeleteCancel = false;
    this.KzC = new a();
    this.ui = paramBaseConversationUI;
    this.hPO = paramString;
    AppMethodBeat.o(194794);
  }
  
  private void a(com.tencent.mm.api.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194797);
    com.tencent.mm.am.d locald = ag.aGi().Dy(this.hPO);
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
    for (long l3 = 0L;; l3 = paramc.Ks())
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      ad.d("EnterpriseConversationPresenter", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      AppMethodBeat.o(194797);
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
    AppMethodBeat.i(194800);
    com.tencent.mm.model.ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().apW(paramString);
    acy localacy = new acy();
    localacy.GbY = new cwt().aPy(bt.nullAsNil(paramString));
    localacy.xbt = ((ei)localObject).field_msgSvrId;
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azo().c(new k.a(8, localacy));
    this.isDeleteCancel = false;
    localObject = this.ui;
    getString(2131755906);
    bj.a(paramString, new bj.a()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.isDeleteCancel = true;
      }
    }
    {
      public final boolean YK()
      {
        return c.this.isDeleteCancel;
      }
      
      public final void YL()
      {
        AppMethodBeat.i(194789);
        if (this.fNl != null) {
          this.fNl.dismiss();
        }
        AppMethodBeat.o(194789);
      }
    });
    AppMethodBeat.o(194800);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(194795);
    at localat = parama.conversation;
    if (localat == null)
    {
      AppMethodBeat.o(194795);
      return;
    }
    Object localObject;
    if (com.tencent.mm.am.g.vd(localat.field_username))
    {
      parama = new Intent(this.ui, BizChatConversationUI.class);
      parama.putExtra("Contact_User", localat.field_username);
      parama.putExtra("biz_chat_from_scene", 7);
      parama.addFlags(67108864);
      localObject = this.ui;
      parama = new com.tencent.mm.hellhoundlib.b.a().bc(parama);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, parama.ahp(), "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((BaseConversationUI)localObject).startActivity((Intent)parama.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/presenter/EnterpriseConversationPresenter", "onItemClick", "(Lcom/tencent/mm/ui/conversation/MergeBizChatConversationAdapter$BizChatConversationHolder;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(194795);
      return;
    }
    if (com.tencent.mm.am.g.DR(localat.field_username))
    {
      com.tencent.mm.api.c localc = com.tencent.mm.am.g.eS(localat.field_username);
      if (localc == null) {}
      for (parama = null;; parama = localc.Kr())
      {
        localObject = parama;
        if (parama == null) {
          localObject = "";
        }
        parama = new Intent();
        parama.putExtra("rawUrl", (String)localObject);
        parama.putExtra("useJs", true);
        parama.putExtra("srcUsername", localat.field_username);
        parama.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        parama.putExtra("geta8key_scene", 51);
        parama.addFlags(67108864);
        com.tencent.mm.bs.d.b(this.ui, "webview", ".ui.tools.WebViewUI", parama);
        a(localc, 2, localat.field_unReadCount);
        AppMethodBeat.o(194795);
        return;
      }
    }
    parama = new Bundle();
    parama.putBoolean("key_is_biz_chat", false);
    this.ui.startChatting(localat.field_username, parama, true);
    a(com.tencent.mm.am.g.eS(localat.field_username), 1, localat.field_unReadCount);
    AppMethodBeat.o(194795);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(194796);
    a.a(this.KzC);
    a.a(this.KzC, paramView, paramPoint.x, paramPoint.y, paramInt, paramLong, parama.conversation);
    AppMethodBeat.o(194796);
    return true;
  }
  
  public final void delConversationAndMsg(String paramString)
  {
    AppMethodBeat.i(194799);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("EnterpriseConversationPresenter", "Delete Conversation and messages fail because username is null or nil.");
      AppMethodBeat.o(194799);
      return;
    }
    asyncDelMsg(paramString);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azv().aTx(paramString);
    paramString = ag.aFZ().DD(paramString);
    com.tencent.mm.model.ba.aBQ();
    com.tencent.mm.model.c.azu().aSv(paramString.field_enterpriseFather);
    AppMethodBeat.o(194799);
  }
  
  final String getString(int paramInt)
  {
    AppMethodBeat.i(194801);
    String str = this.ui.getString(paramInt);
    AppMethodBeat.o(194801);
    return str;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(194798);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(194798);
      return;
    }
    if (paramn.getType() == 1394)
    {
      paramString = ((com.tencent.mm.plugin.profile.b.d)paramn).dAr();
      Object localObject = ((com.tencent.mm.plugin.profile.b.d)paramn).dAq();
      if ((localObject == null) || (((dld)localObject).FHh == null) || (((dld)localObject).FHh.ret != 0))
      {
        if ((localObject != null) && (((dld)localObject).FHh != null))
        {
          ad.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(((dld)localObject).FHh.ret) });
          AppMethodBeat.o(194798);
          return;
        }
        ad.w("EnterpriseConversationPresenter", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramn.getType()) });
        AppMethodBeat.o(194798);
        return;
      }
      if (!paramString.lSG)
      {
        AppMethodBeat.o(194798);
        return;
      }
      paramn = com.tencent.mm.am.g.eS(paramString.FHb);
      paramn.field_brandFlag |= 0x1;
      localObject = new bzi();
      ((bzi)localObject).jdq = paramn.field_brandFlag;
      ((bzi)localObject).nDo = paramString.FHb;
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azo().c(new k.a(47, (com.tencent.mm.bx.a)localObject));
      ag.aFZ().update(paramn, new String[0]);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().aTx(paramn.field_username);
      com.tencent.mm.model.ba.aBQ();
      if (com.tencent.mm.model.c.azv().aTL(paramn.field_enterpriseFather) <= 0)
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().aTx(paramn.field_enterpriseFather);
        AppMethodBeat.o(194798);
        return;
      }
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azu().aSv(paramn.field_enterpriseFather);
    }
    AppMethodBeat.o(194798);
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    private com.tencent.mm.ui.widget.b.a KzF;
    private String nYE = "";
    private n.e obh;
    
    a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(194791);
      com.tencent.mm.model.ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(this.nYE);
      if (localam == null)
      {
        ad.e("EnterpriseConversationPresenter", "onCreateContextMenu, contact is null, talker = " + this.nYE);
        AppMethodBeat.o(194791);
        return;
      }
      String str = localam.adv();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (bt.isNullOrNil(localam.field_nickname)) {
          paramView = c.this.getString(2131757293);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(k.c(c.this.ui, paramView));
      if (localam.adq()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, 2131758443);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, 2131761057);
        AppMethodBeat.o(194791);
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