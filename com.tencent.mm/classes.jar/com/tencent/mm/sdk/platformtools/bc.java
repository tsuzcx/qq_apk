package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class bc
{
  static boolean dCr;
  private TelephonyManager EWg;
  private PhoneStateListener EWh;
  List<a> EWi;
  
  public bc()
  {
    AppMethodBeat.i(157774);
    this.EWi = new LinkedList();
    AppMethodBeat.o(157774);
  }
  
  public static boolean NY()
  {
    AppMethodBeat.i(157777);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(dCr) });
    boolean bool = dCr;
    AppMethodBeat.o(157777);
    return bool;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157775);
    this.EWi.add(parama);
    AppMethodBeat.o(157775);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(194741);
    this.EWi.remove(parama);
    AppMethodBeat.o(194741);
  }
  
  public final void eGl()
  {
    AppMethodBeat.i(157776);
    this.EWi.clear();
    AppMethodBeat.o(157776);
  }
  
  public final void end()
  {
    AppMethodBeat.i(157779);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.EWg != null)
    {
      this.EWg.listen(this.EWh, 0);
      this.EWh = null;
    }
    AppMethodBeat.o(157779);
  }
  
  public final void iG(Context paramContext)
  {
    AppMethodBeat.i(157778);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.EWg == null) {
      this.EWg = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.EWh == null) {
      this.EWh = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(157773);
          ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (bc.this.EWi.size() > 0)
          {
            bc.a[] arrayOfa = new bc.a[bc.this.EWi.size()];
            arrayOfa = (bc.a[])bc.this.EWi.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].kq(paramAnonymousInt);
              i += 1;
            }
          }
          super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(157773);
            return;
            bc.dCr = false;
            AppMethodBeat.o(157773);
            return;
            bc.dCr = true;
          }
        }
      };
    }
    this.EWg.listen(this.EWh, 32);
    AppMethodBeat.o(157778);
  }
  
  public static abstract interface a
  {
    public abstract void kq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc
 * JD-Core Version:    0.7.0.1
 */