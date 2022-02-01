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
import com.tencent.mm.al.af;
import com.tencent.mm.al.o;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class a
  implements d
{
  public b IIi;
  public long IIj;
  private final a IIk;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(196918);
    this.IIk = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.IIi = paramb;
    AppMethodBeat.o(196918);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(196919);
    Object localObject = parama.IFD;
    if (localObject == null)
    {
      AppMethodBeat.o(196919);
      return;
    }
    parama = ((com.tencent.mm.al.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.al.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(196919);
      return;
    }
    this.IIj = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(196919);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(196920);
    if (parama.IFD == null)
    {
      AppMethodBeat.o(196920);
      return false;
    }
    a locala = this.IIk;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.IFD;
    if (locala.nym == null)
    {
      locala.ntM = new a.a.2(locala);
      locala.nym = new com.tencent.mm.ui.widget.b.a(locala.IIo.ui);
    }
    locala.IIl = paramPoint;
    locala.IIm = paramPoint.field_brandUserName;
    locala.IIn = paramPoint.field_bizChatId;
    locala.nym.a(paramView, paramInt, paramLong, locala, locala.ntM, i, j);
    AppMethodBeat.o(196920);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.al.a.a IIl;
    String IIm;
    long IIn;
    private boolean isDeleteCancel = false;
    n.d ntM;
    com.tencent.mm.ui.widget.b.a nym;
    private p tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(196915);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.IIl.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        af.aCZ();
        if (!com.tencent.mm.al.a.b.c(this.IIl)) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131761057);
        AppMethodBeat.o(196915);
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
    public abstract void Bx(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */