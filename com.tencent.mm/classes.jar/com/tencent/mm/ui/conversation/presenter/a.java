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
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;
import com.tencent.mm.ui.g;

public final class a
  implements d
{
  public b QiY;
  public long QiZ;
  private final a Qja;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(234298);
    this.Qja = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.QiY = paramb;
    AppMethodBeat.o(234298);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(234299);
    Object localObject = parama.Qgk;
    if (localObject == null)
    {
      AppMethodBeat.o(234299);
      return;
    }
    parama = ((com.tencent.mm.al.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.al.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(234299);
      return;
    }
    this.QiZ = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(234299);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(234300);
    if (parama.Qgk == null)
    {
      AppMethodBeat.o(234300);
      return false;
    }
    a locala = this.Qja;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.Qgk;
    if (locala.pqr == null)
    {
      locala.plk = new a.a.2(locala);
      locala.pqr = new com.tencent.mm.ui.widget.b.a(locala.Qje.ui);
    }
    locala.Qjb = paramPoint;
    locala.Qjc = paramPoint.field_brandUserName;
    locala.Qjd = paramPoint.field_bizChatId;
    locala.pqr.a(paramView, paramInt, paramLong, locala, locala.plk, i, j);
    AppMethodBeat.o(234300);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.al.a.a Qjb;
    String Qjc;
    long Qjd;
    private boolean isDeleteCancel = false;
    o.g plk;
    com.tencent.mm.ui.widget.b.a pqr;
    private com.tencent.mm.ui.base.q tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(234295);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.Qjb.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 1, 2131762838);
        ag.bak();
        if (!com.tencent.mm.al.a.b.c(this.Qjb)) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 3, 2, 2131762839);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 3, 2131762843);
        AppMethodBeat.o(234295);
        return;
        paramContextMenu.add(paramView.position, 2, 1, 2131762836);
        break;
        label103:
        paramContextMenu.add(paramView.position, 3, 2, 2131762837);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void NW(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */