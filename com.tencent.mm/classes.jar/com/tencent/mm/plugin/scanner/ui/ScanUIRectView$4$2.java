package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import java.util.ArrayList;
import java.util.List;

final class ScanUIRectView$4$2
  implements Runnable
{
  ScanUIRectView$4$2(ScanUIRectView.4 param4, long paramLong, List paramList1, List paramList2, List paramList3, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(314595);
    ArrayList localArrayList;
    int j;
    int i;
    Object localObject1;
    if ((ScanUIRectView.l(this.Pck.Pcg) == this.OPa) && (this.OPa != 0L))
    {
      this.Pck.Pcg.gSO();
      localArrayList = new ArrayList();
      if ((this.OSa != null) && (!this.OSa.isEmpty()))
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(this.OSa.size()) });
        j = 0;
        i = 0;
        if (j < this.OSa.size())
        {
          localObject1 = (a.a)this.OSa.get(j);
          localObject1 = new WxQBarResult(((a.a)localObject1).typeID, ((a.a)localObject1).typeName, ((a.a)localObject1).data, ((a.a)localObject1).rawData, ((a.a)localObject1).charset, ((a.a)localObject1).priorityLevel);
          Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
          if ((this.OSc != null) && (this.OSc.size() >= j + 1))
          {
            localObject2 = (WxQbarNative.QBarReportMsg)this.OSc.get(j);
            if (localObject2 != null) {
              ((WxQBarResult)localObject1).ahqQ = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
            }
          }
          if ((this.OSd == null) || (this.OSd.size() < j + 1)) {
            break label426;
          }
          Object localObject2 = (QbarNative.QBarPoint)this.OSd.get(j);
          if (localObject2 == null) {
            break label426;
          }
          ((WxQBarResult)localObject1).ahru = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
          i += 1;
        }
      }
    }
    label426:
    for (;;)
    {
      localArrayList.add(localObject1);
      j += 1;
      break;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelableArrayList("result_qbar_result_list", localArrayList);
      ((Bundle)localObject1).putInt("result_code_point_count", i);
      if (this.Pcl != null) {
        ((Bundle)localObject1).putAll(this.Pcl);
      }
      this.Pck.Pcg.dSg();
      if (ScanUIRectView.m(this.Pck.Pcg) != null) {
        ScanUIRectView.m(this.Pck.Pcg).e(ScanUIRectView.l(this.Pck.Pcg), (Bundle)localObject1);
      }
      AppMethodBeat.o(314595);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.4.2
 * JD-Core Version:    0.7.0.1
 */