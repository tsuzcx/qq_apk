package com.tencent.thumbplayer.g.a.a;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.b;
import com.tencent.thumbplayer.utils.g;

final class c$1
  extends PhoneStateListener
{
  c$1(c paramc) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    int i = 0;
    AppMethodBeat.i(189523);
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (c.e(this.Scs) == null)
    {
      AppMethodBeat.o(189523);
      return;
    }
    Object localObject = (TelephonyManager)c.e(this.Scs).getSystemService("phone");
    if (localObject == null)
    {
      g.e("TPReportManager", "getSystemService TELEPHONY_SERVICE err.");
      AppMethodBeat.o(189523);
      return;
    }
    label269:
    for (;;)
    {
      int j;
      try
      {
        String[] arrayOfString = paramSignalStrength.toString().split(" ");
        j = ((TelephonyManager)localObject).getNetworkType();
        if ((j != 13) || (arrayOfString.length <= 9)) {
          break label243;
        }
        if (!b.isNumeric(arrayOfString[9]))
        {
          c.a(this.Scs, i);
          AppMethodBeat.o(189523);
          return;
        }
        i = b.bqF(arrayOfString[9]);
        continue;
        localObject = ((TelephonyManager)localObject).getNetworkOperator();
        if ((localObject == null) || (((String)localObject).startsWith("46000")) || (((String)localObject).startsWith("46002")) || (((String)localObject).startsWith("46007"))) {
          break label238;
        }
        if (((String)localObject).equals("46001"))
        {
          i = paramSignalStrength.getCdmaDbm();
          continue;
        }
        if (!((String)localObject).equals("46003")) {
          break label238;
        }
        i = paramSignalStrength.getEvdoDbm();
      }
      catch (Throwable paramSignalStrength)
      {
        g.e("TPReportManager", paramSignalStrength);
        AppMethodBeat.o(189523);
        return;
      }
      i = paramSignalStrength.getGsmSignalStrength();
      i = i * 2 - 113;
      continue;
      label238:
      i = 0;
      break label269;
      label243:
      if ((j != 8) && (j != 10) && (j != 9)) {
        if (j == 3) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */