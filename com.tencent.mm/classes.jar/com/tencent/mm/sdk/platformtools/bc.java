package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class bc
{
  static boolean dMq;
  private TelephonyManager Ifh;
  private PhoneStateListener Ifi;
  List<a> Ifj;
  
  public bc()
  {
    AppMethodBeat.i(157774);
    this.Ifj = new LinkedList();
    AppMethodBeat.o(157774);
  }
  
  public static boolean PD()
  {
    AppMethodBeat.i(157777);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(dMq) });
    boolean bool = dMq;
    AppMethodBeat.o(157777);
    return bool;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157775);
    this.Ifj.add(parama);
    AppMethodBeat.o(157775);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(194951);
    this.Ifj.remove(parama);
    AppMethodBeat.o(194951);
  }
  
  public final void end()
  {
    AppMethodBeat.i(157779);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.Ifh != null)
    {
      this.Ifh.listen(this.Ifi, 0);
      this.Ifi = null;
    }
    AppMethodBeat.o(157779);
  }
  
  public final void fln()
  {
    AppMethodBeat.i(157776);
    this.Ifj.clear();
    AppMethodBeat.o(157776);
  }
  
  public final void jb(Context paramContext)
  {
    AppMethodBeat.i(157778);
    ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.Ifh == null) {
      this.Ifh = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.Ifi == null) {
      this.Ifi = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(157773);
          ad.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (bc.this.Ifj.size() > 0)
          {
            bc.a[] arrayOfa = new bc.a[bc.this.Ifj.size()];
            arrayOfa = (bc.a[])bc.this.Ifj.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].kK(paramAnonymousInt);
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
            bc.dMq = false;
            AppMethodBeat.o(157773);
            return;
            bc.dMq = true;
          }
        }
      };
    }
    this.Ifh.listen(this.Ifi, 32);
    AppMethodBeat.o(157778);
  }
  
  public static abstract interface a
  {
    public abstract void kK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc
 * JD-Core Version:    0.7.0.1
 */