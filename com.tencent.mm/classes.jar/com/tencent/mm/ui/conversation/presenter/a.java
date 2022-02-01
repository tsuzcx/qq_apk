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
import com.tencent.mm.an.af;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.o.a;
import com.tencent.mm.ui.h;

public final class a
  implements d
{
  public b afup;
  public long afuq;
  private final a afur;
  BaseConversationUI ui;
  
  public a(BaseConversationUI paramBaseConversationUI, b paramb)
  {
    AppMethodBeat.i(256940);
    this.afur = new a((byte)0);
    this.ui = paramBaseConversationUI;
    this.afup = paramb;
    AppMethodBeat.o(256940);
  }
  
  public final void a(o.a parama)
  {
    AppMethodBeat.i(256954);
    Object localObject = parama.afqS;
    if (localObject == null)
    {
      AppMethodBeat.o(256954);
      return;
    }
    parama = ((com.tencent.mm.an.a.a)localObject).field_brandUserName;
    long l = ((com.tencent.mm.an.a.a)localObject).field_bizChatId;
    if (parama == null)
    {
      AppMethodBeat.o(256954);
      return;
    }
    this.afuq = l;
    localObject = new Bundle();
    ((Bundle)localObject).putLong("key_biz_chat_id", l);
    ((Bundle)localObject).putBoolean("key_need_send_video", false);
    ((Bundle)localObject).putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(parama, (Bundle)localObject, true);
    AppMethodBeat.o(256954);
  }
  
  public final boolean a(View paramView, Point paramPoint, int paramInt, long paramLong, o.a parama)
  {
    AppMethodBeat.i(256965);
    if (parama.afqS == null)
    {
      AppMethodBeat.o(256965);
      return false;
    }
    a locala = this.afur;
    int i = paramPoint.x;
    int j = paramPoint.y;
    paramPoint = parama.afqS;
    if (locala.vEV == null)
    {
      locala.vzr = new a.a.2(locala);
      locala.vEV = new com.tencent.mm.ui.widget.b.a(locala.afuv.ui);
    }
    locala.afus = paramPoint;
    locala.afut = paramPoint.field_brandUserName;
    locala.afuu = paramPoint.field_bizChatId;
    locala.vEV.a(paramView, paramInt, paramLong, locala, locala.vzr, i, j);
    AppMethodBeat.o(256965);
    return true;
  }
  
  final class a
    implements View.OnCreateContextMenuListener
  {
    com.tencent.mm.an.a.a afus;
    String afut;
    long afuu;
    private boolean isDeleteCancel = false;
    private w tipDialog;
    com.tencent.mm.ui.widget.b.a vEV;
    u.i vzr;
    
    private a() {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(256986);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      if (this.afus.field_unReadCount <= 0)
      {
        paramContextMenu.add(paramView.position, 1, 1, R.l.gNf);
        af.bHi();
        if (!com.tencent.mm.an.a.b.c(this.afus)) {
          break label107;
        }
        paramContextMenu.add(paramView.position, 3, 2, R.l.gNg);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 0, 3, R.l.main_delete);
        AppMethodBeat.o(256986);
        return;
        paramContextMenu.add(paramView.position, 2, 1, R.l.gNd);
        break;
        label107:
        paramContextMenu.add(paramView.position, 3, 2, R.l.gNe);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void Av(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.presenter.a
 * JD-Core Version:    0.7.0.1
 */