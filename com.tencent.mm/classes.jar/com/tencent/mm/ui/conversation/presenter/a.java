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
import com.tencent.mm.am.ag;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.l.a;

public final class a
  implements d
{
  public b Kzp;
  public long Kzq;
  private final a Kzr;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(194769);
    this.Kzr = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.Kzp = paramb;
    AppMethodBeat.o(194769);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(194770);
    Object localObject = parama.KwJ;
    if (localObject == null)
    {
      AppMethodBeat.o(194770);
      return;
    }
    parama = ((com.tencent.mm.am.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.am.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(194770);
      return;
    }
    this.Kzq = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(194770);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, l.a parama)
  {
    AppMethodBeat.i(194771);
    if (parama.KwJ == null)
    {
      AppMethodBeat.o(194771);
      return false;
    }
    a locala = this.Kzr;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.KwJ;
    if (locala.nZK == null)
    {
      locala.nUI = new a.a.2(locala);
      locala.nZK = new com.tencent.mm.ui.widget.b.a(locala.Kzv.ui);
    }
    locala.Kzs = paramPoint;
    locala.Kzt = paramPoint.field_brandUserName;
    locala.Kzu = paramPoint.field_bizChatId;
    locala.nZK.a(paramView, paramInt, paramLong, locala, locala.nUI, i, j);
    AppMethodBeat.o(194771);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.am.a.a Kzs;
    String Kzt;
    long Kzu;
    private boolean isDeleteCancel = false;
    n.e nUI;
    com.tencent.mm.ui.widget.b.a nZK;
    private com.tencent.mm.ui.base.p tipDialog;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(194766);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.Kzs.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 0, 2131761052);
        ag.aGc();
        if (!com.tencent.mm.am.a.b.c(this.Kzs)) {
          break label103;
        }
        paramContextMenu.add(paramView.position, 3, 1, 2131761053);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 2, 2131761057);
        AppMethodBeat.o(194766);
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
    public abstract void Ep(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */