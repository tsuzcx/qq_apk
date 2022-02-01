package com.tencent.mm.ui.conversation.presenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class a
  implements d
{
  public b KVJ;
  public long KVK;
  private final a KVL;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(188171);
    this.KVL = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.KVJ = paramb;
    AppMethodBeat.o(188171);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(188172);
    Object localObject = parama.KTd;
    if (localObject == null)
    {
      AppMethodBeat.o(188172);
      return;
    }
    parama = ((com.tencent.mm.al.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.al.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(188172);
      return;
    }
    this.KVK = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(188172);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(188173);
    if (parama.KTd == null)
    {
      AppMethodBeat.o(188173);
      return false;
    }
    a locala = this.KVL;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.KTd;
    if (locala.ofu == null)
    {
      locala.oao = new a.a.2(locala);
      locala.ofu = new com.tencent.mm.ui.widget.b.a(locala.KVP.ui);
    }
    locala.KVM = paramPoint;
    locala.KVN = paramPoint.field_brandUserName;
    locala.KVO = paramPoint.field_bizChatId;
    locala.ofu.a(paramView, paramInt, paramLong, locala, locala.oao, i, j);
    AppMethodBeat.o(188173);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.al.a.a KVM;
    String KVN;
    long KVO;
    private boolean isDeleteCancel = false;
    n.e oao;
    com.tencent.mm.ui.widget.b.a ofu;
    private com.tencent.mm.ui.base.p tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(188168);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.KVM.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        ag.aGs();
        if (!com.tencent.mm.al.a.b.c(this.KVM)) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131761057);
        AppMethodBeat.o(188168);
        return;
        paramContextMenu.add(paramView.position, 2, 0, 2131761050);
        break;
        label103:
        paramContextMenu.add(paramView.position, 3, 1, 2131761051);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void ER(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */