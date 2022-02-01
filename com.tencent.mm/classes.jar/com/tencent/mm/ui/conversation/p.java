package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.a;
import com.tencent.mm.bh.b;
import com.tencent.mm.bh.g;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.rh;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.h;

public final class p
  implements a
{
  Runnable PTi;
  i Qct;
  ConversationListView QfG;
  IListener Qhb;
  IListener Qhc;
  Activity dKq;
  MessageQueue.IdleHandler pzA;
  IListener qZo;
  
  public p()
  {
    AppMethodBeat.i(38735);
    this.qZo = null;
    this.Qhb = null;
    this.Qhc = null;
    this.PTi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = p.this;
        LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dKq;
        if ((localLauncherUI == null) || (localLauncherUI.ODR.getMainTabUI().acm == 0))
        {
          localObject = ((p)localObject).QfG;
          if (((ConversationListView)localObject).getFirstVisiblePosition() > ((ConversationListView)localObject).getFirstHeaderVisible() + 16) {
            ((ConversationListView)localObject).setSelection(((ConversationListView)localObject).getFirstHeaderVisible() + 16);
          }
          ((ConversationListView)localObject).post(new ConversationListView.4((ConversationListView)localObject));
        }
        AppMethodBeat.o(38734);
      }
    };
    AppMethodBeat.o(38735);
  }
  
  public final void gGx()
  {
    AppMethodBeat.i(234255);
    if (g.jpy != null) {
      g.jpy.b(this);
    }
    o.gWh();
    LauncherUI localLauncherUI = (LauncherUI)this.dKq;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aI(this.PTi);
    }
    AppMethodBeat.o(234255);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(38736);
    if (this.Qct != null) {
      this.Qct.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p
 * JD-Core Version:    0.7.0.1
 */