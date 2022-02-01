package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.rn;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.h;

public final class p
  implements com.tencent.mm.bh.a
{
  Runnable KGm;
  i KPs;
  ConversationListView KSA;
  c KTT;
  c KTU;
  Activity dtg;
  MessageQueue.IdleHandler omO;
  c pIT;
  
  public p()
  {
    AppMethodBeat.i(38735);
    this.pIT = null;
    this.KTT = null;
    this.KTU = null;
    this.KGm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = p.this;
        LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dtg;
        if ((localLauncherUI == null) || (localLauncherUI.Jty.getMainTabUI().abZ == 0))
        {
          localObject = ((p)localObject).KSA;
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
    if (this.KPs != null) {
      this.KPs.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p
 * JD-Core Version:    0.7.0.1
 */