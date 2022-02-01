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
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.m.a;
import com.tencent.mm.ui.h;

public final class a
  implements d
{
  public b XGe;
  public long XGf;
  private final a XGg;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(291879);
    this.XGg = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.XGe = paramb;
    AppMethodBeat.o(291879);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(291880);
    Object localObject = parama.XDp;
    if (localObject == null)
    {
      AppMethodBeat.o(291880);
      return;
    }
    parama = ((com.tencent.mm.ao.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.ao.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(291880);
      return;
    }
    this.XGf = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(291880);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, m.a parama)
  {
    AppMethodBeat.i(291881);
    if (parama.XDp == null)
    {
      AppMethodBeat.o(291881);
      return false;
    }
    a locala = this.XGg;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.XDp;
    if (locala.szq == null)
    {
      locala.snt = new a.a.2(locala);
      locala.szq = new com.tencent.mm.ui.widget.b.a(locala.XGk.ui);
    }
    locala.XGh = paramPoint;
    locala.XGi = paramPoint.field_brandUserName;
    locala.XGj = paramPoint.field_bizChatId;
    locala.szq.a(paramView, paramInt, paramLong, locala, locala.snt, i, j);
    AppMethodBeat.o(291881);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.ao.a.a XGh;
    String XGi;
    long XGj;
    private boolean isDeleteCancel = false;
    q.g snt;
    com.tencent.mm.ui.widget.b.a szq;
    private s tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(291328);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.XGh.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 1, R.l.eLl);
        af.bjy();
        if (!com.tencent.mm.ao.a.b.c(this.XGh)) {
          break label107;
        }
        paramContextMenu.add(paramView.position, 3, 2, R.l.eLm);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 3, R.l.main_delete);
        AppMethodBeat.o(291328);
        return;
        paramContextMenu.add(paramView.position, 2, 1, R.l.eLj);
        break;
        label107:
        paramContextMenu.add(paramView.position, 3, 2, R.l.eLk);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Wj(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */