package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.no;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.base.h;

public final class p
  implements com.tencent.mm.bi.a
{
  Runnable KjS;
  i KsY;
  ConversationListView Kwg;
  c KxA;
  c Kxz;
  Activity dsa;
  MessageQueue.IdleHandler ogP;
  c pCp;
  
  public p()
  {
    AppMethodBeat.i(38735);
    this.pCp = null;
    this.Kxz = null;
    this.KxA = null;
    this.KjS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38734);
        Object localObject = p.this;
        LauncherUI localLauncherUI = (LauncherUI)((p)localObject).dsa;
        if ((localLauncherUI == null) || (localLauncherUI.IYQ.getMainTabUI().abZ == 0))
        {
          localObject = ((p)localObject).Kwg;
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
    if (this.KsY != null) {
      this.KsY.notifyDataSetChanged();
    }
    AppMethodBeat.o(38736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p
 * JD-Core Version:    0.7.0.1
 */