package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a;
import com.tencent.mm.bj.b;
import com.tencent.mm.bj.g;
import com.tencent.mm.f.a.mx;
import com.tencent.mm.f.a.sh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

public final class q
  implements a
{
  j XAI;
  ConversationListView XCL;
  IListener XEl;
  IListener XEm;
  Runnable XpT;
  Activity fDf;
  MessageQueue.IdleHandler sJE;
  IListener uCp;
  
  public q()
  {
    AppMethodBeat.i(38735);
    this.uCp = null;
    this.XEl = null;
    this.XEm = null;
    this.XpT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = q.this;
        LauncherUI localLauncherUI = (LauncherUI)((q)localObject).fDf;
        if ((localLauncherUI == null) || (localLauncherUI.VXk.getMainTabUI().iU == 0))
        {
          localObject = ((q)localObject).XCL;
          if (((ConversationListView)localObject).getFirstVisiblePosition() > ((ConversationListView)localObject).getFirstHeaderVisible() + 16) {
            ((ConversationListView)localObject).setSelection(((ConversationListView)localObject).getFirstHeaderVisible() + 16);
          }
          ((ConversationListView)localObject).post(new ConversationListView.2((ConversationListView)localObject));
        }
        AppMethodBeat.o(38734);
      }
    };
    AppMethodBeat.o(38735);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(38736);
    if (this.XAI != null) {
      this.XAI.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
  
  public final void hFe()
  {
    AppMethodBeat.i(290848);
    if (g.meT != null) {
      g.meT.b(this);
    }
    p.hWK();
    LauncherUI localLauncherUI = (LauncherUI)this.fDf;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aO(this.XpT);
    }
    AppMethodBeat.o(290848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.q
 * JD-Core Version:    0.7.0.1
 */