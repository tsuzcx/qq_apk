package com.tencent.mm.plugin.voip.model;

import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class v$6
  extends PhoneStateListener
{
  v$6(v paramv, TelephonyManager paramTelephonyManager) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(293337);
    super.onSignalStrengthsChanged(paramSignalStrength);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293336);
        ArrayList localArrayList = new ArrayList();
        for (;;)
        {
          try
          {
            Object localObject = (List)a.a(v.6.this.UCJ, "com/tencent/mm/plugin/voip/model/VoipServiceEx$6$1", "run", "()V", "android/telephony/TelephonyManager", "getAllCellInfo", "()Ljava/util/List;");
            Log.d("MicroMsg.Voip.VoipServiceEx", "cellInfoList size:%d", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (localObject == null) {
              continue;
            }
            localObject = ((List)localObject).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            localCellInfo = (CellInfo)((Iterator)localObject).next();
            Log.d("MicroMsg.Voip.VoipServiceEx", "cellinfo: %s", new Object[] { localCellInfo.toString() });
            if (!localCellInfo.isRegistered()) {
              continue;
            }
            if (!(localCellInfo instanceof CellInfoGsm)) {
              continue;
            }
            i = ((CellInfoGsm)localCellInfo).getCellSignalStrength().getDbm();
          }
          catch (Exception localException)
          {
            CellInfo localCellInfo;
            g.Logi("MicroMsg.Voip.VoipServiceEx", "get cell dbm info exception");
            Log.d("MicroMsg.Voip.VoipServiceEx", "dbms size: %d", new Object[] { Integer.valueOf(localArrayList.size()) });
            Collections.sort(localArrayList);
            if (localArrayList.size() <= 0) {
              continue;
            }
            v.aqx(((Integer)localArrayList.get(localArrayList.size() - 1)).intValue());
            AppMethodBeat.o(293336);
            return;
            if (!(localCellInfo instanceof CellInfoCdma)) {
              continue;
            }
            i = ((CellInfoCdma)localCellInfo).getCellSignalStrength().getDbm();
            continue;
            if (!(localCellInfo instanceof CellInfoWcdma)) {
              continue;
            }
            i = ((CellInfoWcdma)localCellInfo).getCellSignalStrength().getDbm();
            continue;
            if (!(localCellInfo instanceof CellInfoLte)) {
              continue;
            }
            i = ((CellInfoLte)localCellInfo).getCellSignalStrength().getDbm();
            continue;
            if ((Build.VERSION.SDK_INT < 29) || (!(localCellInfo instanceof CellInfoNr))) {
              break label342;
            }
            i = ((CellSignalStrengthNr)((CellInfoNr)localCellInfo).getCellSignalStrength()).getDbm();
            continue;
            v.aqx(1);
            AppMethodBeat.o(293336);
            return;
          }
          localArrayList.add(Integer.valueOf(i));
          continue;
          label342:
          int i = 1;
        }
      }
    }, "getAllCellInfo-thread");
    AppMethodBeat.o(293337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v.6
 * JD-Core Version:    0.7.0.1
 */