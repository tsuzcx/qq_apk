package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class bd
{
  static boolean dNG;
  private TelephonyManager Izs;
  private PhoneStateListener Izt;
  List<a> Izu;
  
  public bd()
  {
    AppMethodBeat.i(157774);
    this.Izu = new LinkedList();
    AppMethodBeat.o(157774);
  }
  
  public static boolean PC()
  {
    AppMethodBeat.i(157777);
    ae.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(dNG) });
    boolean bool = dNG;
    AppMethodBeat.o(157777);
    return bool;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157775);
    this.Izu.add(parama);
    AppMethodBeat.o(157775);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(200298);
    this.Izu.remove(parama);
    AppMethodBeat.o(200298);
  }
  
  public final void end()
  {
    AppMethodBeat.i(157779);
    ae.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.Izs != null)
    {
      this.Izs.listen(this.Izt, 0);
      this.Izt = null;
    }
    AppMethodBeat.o(157779);
  }
  
  public final void fpi()
  {
    AppMethodBeat.i(157776);
    this.Izu.clear();
    AppMethodBeat.o(157776);
  }
  
  public final void jg(Context paramContext)
  {
    AppMethodBeat.i(157778);
    ae.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.Izs == null) {
      this.Izs = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.Izt == null) {
      this.Izt = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(157773);
          ae.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (bd.this.Izu.size() > 0)
          {
            bd.a[] arrayOfa = new bd.a[bd.this.Izu.size()];
            arrayOfa = (bd.a[])bd.this.Izu.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].kM(paramAnonymousInt);
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
            bd.dNG = false;
            AppMethodBeat.o(157773);
            return;
            bd.dNG = true;
          }
        }
      };
    }
    this.Izs.listen(this.Izt, 32);
    AppMethodBeat.o(157778);
  }
  
  public static abstract interface a
  {
    public abstract void kM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bd
 * JD-Core Version:    0.7.0.1
 */