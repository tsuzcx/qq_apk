package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class at
{
  static boolean ccL;
  private TelephonyManager uho;
  private PhoneStateListener uhp;
  List<a> uhq = new LinkedList();
  
  public static boolean uc()
  {
    y.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(ccL) });
    return ccL;
  }
  
  public final void a(a parama)
  {
    this.uhq.add(parama);
  }
  
  public final void crw()
  {
    this.uhq.clear();
  }
  
  public final void end()
  {
    y.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.uho != null)
    {
      this.uho.listen(this.uhp, 0);
      this.uhp = null;
    }
  }
  
  public final void fN(Context paramContext)
  {
    y.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.uho == null) {
      this.uho = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.uhp == null) {
      this.uhp = new PhoneStateListener()
      {
        public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          y.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (at.this.uhq.size() > 0)
          {
            at.a[] arrayOfa = new at.a[at.this.uhq.size()];
            arrayOfa = (at.a[])at.this.uhq.toArray(arrayOfa);
            int j = arrayOfa.length;
            int i = 0;
            while (i < j)
            {
              arrayOfa[i].fQ(paramAnonymousInt);
              i += 1;
            }
          }
          super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            at.ccL = false;
            return;
          }
          at.ccL = true;
        }
      };
    }
    this.uho.listen(this.uhp, 32);
  }
  
  public static abstract interface a
  {
    public abstract void fQ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.at
 * JD-Core Version:    0.7.0.1
 */