package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsMsgUI$3
  implements AbsListView.OnScrollListener
{
  SnsMsgUI$3(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(39067);
    if (!SnsMsgUI.g(this.rSU))
    {
      AppMethodBeat.o(39067);
      return;
    }
    ab.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 2)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.l(this.rSU));
      SnsMsgUI localSnsMsgUI = this.rSU;
      boolean bool = WXHardCoderJNI.hcSNSMsgScrollEnable;
      int i = WXHardCoderJNI.hcSNSMsgScrollDelay;
      int j = WXHardCoderJNI.hcSNSMsgScrollCPU;
      int k = WXHardCoderJNI.hcSNSMsgScrollIO;
      if (WXHardCoderJNI.hcSNSMsgScrollThr)
      {
        paramInt = Process.myTid();
        SnsMsgUI.b(localSnsMsgUI, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI"));
        ab.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsMsgUI.l(this.rSU)) });
      }
    }
    else
    {
      if (paramAbsListView.getLastVisiblePosition() != paramAbsListView.getCount() - 1) {
        break label211;
      }
      if (ag.cpk().bbZ() <= 0) {
        break label197;
      }
      ag.cpk().bca();
    }
    for (;;)
    {
      SnsMsgUI.e(this.rSU).a(null, null);
      AppMethodBeat.o(39067);
      return;
      paramInt = 0;
      break;
      label197:
      SnsMsgUI.e(this.rSU).ben();
    }
    label211:
    AppMethodBeat.o(39067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.3
 * JD-Core Version:    0.7.0.1
 */