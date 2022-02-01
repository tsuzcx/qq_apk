package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class bb
{
  static boolean dAd;
  private TelephonyManager Gts;
  private PhoneStateListener Gtt;
  List<a> Gtu;
  
  public bb()
  {
    AppMethodBeat.i(157774);
    this.Gtu = new LinkedList();
    AppMethodBeat.o(157774);
  }
  
  public static boolean NU()
  {
    AppMethodBeat.i(157777);
    ac.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(dAd) });
    boolean bool = dAd;
    AppMethodBeat.o(157777);
    return bool;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(157775);
    this.Gtu.add(parama);
    AppMethodBeat.o(157775);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(199891);
    this.Gtu.remove(parama);
    AppMethodBeat.o(199891);
  }
  
  public final void eVG()
  {
    AppMethodBeat.i(157776);
    this.Gtu.clear();
    AppMethodBeat.o(157776);
  }
  
  public final void end()
  {
    AppMethodBeat.i(157779);
    ac.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.Gts != null)
    {
      this.Gts.listen(this.Gtt, 0);
      this.Gtt = null;
    }
    AppMethodBeat.o(157779);
  }
  
  public final void iR(Context paramContext)
  {
    AppMethodBeat.i(157778);
    ac.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.Gts == null) {
      this.Gts = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.Gtt == null) {
      this.Gtt = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(157773);
          ac.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (bb.this.Gtu.size() > 0)
          {
            bb.a[] arrayOfa = new bb.a[bb.this.Gtu.size()];
            arrayOfa = (bb.a[])bb.this.Gtu.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].kn(paramAnonymousInt);
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
            bb.dAd = false;
            AppMethodBeat.o(157773);
            return;
            bb.dAd = true;
          }
        }
      };
    }
    this.Gts.listen(this.Gtt, 32);
    AppMethodBeat.o(157778);
  }
  
  public static abstract interface a
  {
    public abstract void kn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb
 * JD-Core Version:    0.7.0.1
 */