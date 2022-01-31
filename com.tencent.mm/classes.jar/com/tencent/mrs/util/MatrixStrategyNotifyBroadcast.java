package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.g.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsCallback;
import com.tencent.mm.sdk.platformtools.w;

public class MatrixStrategyNotifyBroadcast
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      c.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
    }
    do
    {
      return;
      paramContext = w.n(paramIntent, "strategy");
      c.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s", new Object[] { MatrixReport.with().getProcessName(), paramContext });
    } while (TextUtils.isEmpty(paramContext));
    MatrixReport.getMrsCallback().onStrategyNotify(paramContext, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.util.MatrixStrategyNotifyBroadcast
 * JD-Core Version:    0.7.0.1
 */