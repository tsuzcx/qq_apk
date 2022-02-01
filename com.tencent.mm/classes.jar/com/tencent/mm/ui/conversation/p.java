package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

public final class p
  implements com.tencent.mm.bh.a
{
  i IBS;
  ConversationListView IFc;
  c IGt;
  c IGu;
  Runnable Itm;
  Activity dgE;
  MessageQueue.IdleHandler nEp;
  c oYF;
  
  public p()
  {
    AppMethodBeat.i(38735);
    this.oYF = null;
    this.IGt = null;
    this.IGu = null;
    this.Itm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = p.this;
        LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dgE;
        if ((localLauncherUI == null) || (localLauncherUI.Hlj.getMainTabUI().aaj == 0))
        {
          localObject = ((p)localObject).IFc;
          if (((ConversationListView)localObject).getFirstVisiblePosition() > ((ConversationListView)localObject).getFirstHeaderVisible() + 16) {
            ((ConversationListView)localObject).setSelection(((ConversationListView)localObject).getFirstHeaderVisible() + 16);
          }
          ((ConversationListView)localObject).post(new ConversationListView.3((ConversationListView)localObject));
        }
        AppMethodBeat.o(38734);
      }
    };
    AppMethodBeat.o(38735);
  }
  
  public final void h(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(38736);
    if (this.IBS != null) {
      this.IBS.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p
 * JD-Core Version:    0.7.0.1
 */