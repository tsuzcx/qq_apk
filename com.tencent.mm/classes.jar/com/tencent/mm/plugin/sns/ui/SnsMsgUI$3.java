package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.y;

final class SnsMsgUI$3
  implements AbsListView.OnScrollListener
{
  SnsMsgUI$3(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!SnsMsgUI.g(this.paq)) {}
    do
    {
      return;
      y.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 2)
      {
        WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.l(this.paq));
        SnsMsgUI localSnsMsgUI = this.paq;
        boolean bool = WXHardCoderJNI.hcSNSMsgScrollEnable;
        int i = WXHardCoderJNI.hcSNSMsgScrollDelay;
        int j = WXHardCoderJNI.hcSNSMsgScrollCPU;
        int k = WXHardCoderJNI.hcSNSMsgScrollIO;
        if (!WXHardCoderJNI.hcSNSMsgScrollThr) {
          break;
        }
        paramInt = Process.myTid();
        SnsMsgUI.b(localSnsMsgUI, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI"));
        y.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsMsgUI.l(this.paq)) });
      }
    } while (paramAbsListView.getLastVisiblePosition() != paramAbsListView.getCount() - 1);
    if (af.bDK().aAo() > 0) {
      af.bDK().aAp();
    }
    for (;;)
    {
      SnsMsgUI.e(this.paq).a(null, null);
      return;
      paramInt = 0;
      break;
      SnsMsgUI.e(this.paq).aCd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.3
 * JD-Core Version:    0.7.0.1
 */