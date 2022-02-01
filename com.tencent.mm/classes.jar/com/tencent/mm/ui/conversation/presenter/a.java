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
import com.tencent.mm.al.n;
import com.tencent.mm.am.af;
import com.tencent.mm.am.o;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class a
  implements d
{
  public b HhP;
  public long HhQ;
  private final a HhR;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(191804);
    this.HhR = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.HhP = paramb;
    AppMethodBeat.o(191804);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(191805);
    Object localObject = parama.Hfk;
    if (localObject == null)
    {
      AppMethodBeat.o(191805);
      return;
    }
    parama = ((com.tencent.mm.am.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.am.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(191805);
      return;
    }
    this.HhQ = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(191805);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(191806);
    if (parama.Hfk == null)
    {
      AppMethodBeat.o(191806);
      return false;
    }
    a locala = this.HhR;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.Hfk;
    if (locala.mVN == null)
    {
      locala.mRw = new a.a.2(locala);
      locala.mVN = new com.tencent.mm.ui.widget.b.a(locala.HhV.ui);
    }
    locala.HhS = paramPoint;
    locala.HhT = paramPoint.field_brandUserName;
    locala.HhU = paramPoint.field_bizChatId;
    locala.mVN.a(paramView, paramInt, paramLong, locala, locala.mRw, i, j);
    AppMethodBeat.o(191806);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.am.a.a HhS;
    String HhT;
    long HhU;
    private boolean isDeleteCancel = false;
    n.d mRw;
    com.tencent.mm.ui.widget.b.a mVN;
    private p tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(191801);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.HhS.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        af.awh();
        if (!com.tencent.mm.am.a.b.c(this.HhS)) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131761057);
        AppMethodBeat.o(191801);
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
    public abstract void wU(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */