package com.tencent.mm.ui.chatting.f;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView;
import com.tencent.mm.pluginsdk.ui.tools.ScrollControlListView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.component.api.z;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements f<cc>
{
  private MMChattingListView aeHO;
  public a aeHP;
  private a hlc;
  
  public b(a parama, MMChattingListView paramMMChattingListView)
  {
    this.aeHO = paramMMChattingListView;
    this.hlc = parama;
  }
  
  public final void a(d.d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(36420);
    this.hlc.aezV = false;
    boolean bool1;
    if (paramd.aeHY == d.a.aeHU)
    {
      i = 1;
      if (i != 0)
      {
        localObject = this.hlc;
        ScrollControlListView.a locala = ScrollControlListView.Yub;
        localObject = ((a)localObject).aezP.getListView();
        if ((localObject instanceof ScrollControlListView)) {
          ((ScrollControlListView)localObject).setHasControlMoveDown(true);
        }
      }
      boolean bool3 = this.hlc.juJ();
      if ((!bool3) || (paramd.aeHY == d.a.aeHQ) || (paramd.aeHY == d.a.aeHR)) {
        break label348;
      }
      bool1 = true;
      label108:
      Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s, lastGap:%s, isAtBottom:%s, %s", new Object[] { paramd.toString(), Boolean.valueOf(bool3), Boolean.valueOf(bool1), this.aeHP });
      if (paramd.aeHY != d.a.aeHS)
      {
        localObject = this.aeHO;
        MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).adSL, 4);
        MMPullDownView.o((ViewGroup)((MMPullDownView)localObject).UfQ, 4);
      }
      ((z)this.hlc.cm(z.class)).startTimer();
      if (this.aeHP != null) {
        this.aeHP.a(this.aeHO, paramd);
      }
      Object localObject = (x)this.hlc.cm(x.class);
      if (((localObject != null) && (((x)localObject).jsd() != null) && (((x)localObject).jsd().HDO)) || (bool1))
      {
        Log.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
        if (paramd.aeHX == null) {
          break label353;
        }
      }
    }
    label348:
    label353:
    for (int i = paramd.aeHX.getInt("SCENE", 0);; i = 0)
    {
      bool1 = bool2;
      if (paramd.aeHY != d.a.aeHT)
      {
        bool1 = bool2;
        if (i != 3) {
          bool1 = true;
        }
      }
      this.hlc.jpQ();
      this.hlc.r(true, true, bool1);
      AppMethodBeat.o(36420);
      return;
      i = 0;
      break;
      bool1 = false;
      break label108;
    }
  }
  
  public final boolean b(d.a parama)
  {
    AppMethodBeat.i(254222);
    if (!this.hlc.ffv)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
      AppMethodBeat.o(254222);
      return false;
    }
    if (!this.hlc.aezU)
    {
      Log.e("MicroMsg.ChattingLoader.ChattingViewCallback", "current ChattingUI lose focus! action=%s", new Object[] { parama });
      a locala = this.hlc;
      Log.i("MicroMsg.ChattingContext", "trace setNeedUpdateUI, needUpdateUI %s, trace %s", new Object[] { Boolean.TRUE, Util.getStack() });
      locala.aezV = true;
      locala.aezY.add(parama);
      AppMethodBeat.o(254222);
      return false;
    }
    AppMethodBeat.o(254222);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(MMChattingListView paramMMChattingListView, d.d<cc> paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.b
 * JD-Core Version:    0.7.0.1
 */