package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ke;
import com.tencent.mm.autogen.a.qq;
import com.tencent.mm.autogen.a.uz;
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.b;
import com.tencent.mm.bc.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

public final class u
  implements a
{
  Runnable afbw;
  k afnq;
  ConversationListView afpp;
  IListener afsi;
  IListener afsj;
  MessageQueue.IdleHandler fgm;
  Activity hHU;
  IListener xKL;
  
  public u()
  {
    AppMethodBeat.i(38735);
    this.xKL = null;
    this.afsi = null;
    this.afsj = null;
    this.afbw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = u.this;
        LauncherUI localLauncherUI = (LauncherUI)((u)localObject).hHU;
        if ((localLauncherUI == null) || (localLauncherUI.adBG.getMainTabUI().jP == 0))
        {
          localObject = ((u)localObject).afpp;
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
  
  public final void jhq()
  {
    AppMethodBeat.i(256797);
    if (g.oXL != null) {
      g.oXL.b(this);
    }
    t.jBc();
    LauncherUI localLauncherUI = (LauncherUI)this.hHU;
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aW(this.afbw);
    }
    AppMethodBeat.o(256797);
  }
  
  public final void m(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(38736);
    if (this.afnq != null) {
      this.afnq.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.u
 * JD-Core Version:    0.7.0.1
 */