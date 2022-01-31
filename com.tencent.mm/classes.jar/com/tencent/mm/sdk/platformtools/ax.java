package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class ax
{
  static boolean cLu;
  private TelephonyManager yps;
  private PhoneStateListener ypt;
  List<a> ypu;
  
  public ax()
  {
    AppMethodBeat.i(52215);
    this.ypu = new LinkedList();
    AppMethodBeat.o(52215);
  }
  
  public static boolean Ep()
  {
    AppMethodBeat.i(52218);
    ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(cLu) });
    boolean bool = cLu;
    AppMethodBeat.o(52218);
    return bool;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(52216);
    this.ypu.add(parama);
    AppMethodBeat.o(52216);
  }
  
  public final void dtv()
  {
    AppMethodBeat.i(52217);
    this.ypu.clear();
    AppMethodBeat.o(52217);
  }
  
  public final void end()
  {
    AppMethodBeat.i(52220);
    ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.yps != null)
    {
      this.yps.listen(this.ypt, 0);
      this.ypt = null;
    }
    AppMethodBeat.o(52220);
  }
  
  public final void hd(Context paramContext)
  {
    AppMethodBeat.i(52219);
    ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.yps == null) {
      this.yps = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.ypt == null) {
      this.ypt = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(52214);
          ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (ax.this.ypu.size() > 0)
          {
            ax.a[] arrayOfa = new ax.a[ax.this.ypu.size()];
            arrayOfa = (ax.a[])ax.this.ypu.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].ie(paramAnonymousInt);
              i += 1;
            }
          }
          super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(52214);
            return;
            ax.cLu = false;
            AppMethodBeat.o(52214);
            return;
            ax.cLu = true;
          }
        }
      };
    }
    this.yps.listen(this.ypt, 32);
    AppMethodBeat.o(52219);
  }
  
  public static abstract interface a
  {
    public abstract void ie(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ax
 * JD-Core Version:    0.7.0.1
 */