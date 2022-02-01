package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.LinkedList;
import java.util.List;

public class PhoneStatusWatcher
{
  private static final String TAG = "MicroMsg.PhoneStatusWatcher";
  private static boolean calling;
  private byte _hellAccFlag_;
  private List<PhoneCallListener> phoneCallListeners;
  private PhoneStateListener phoneStateListener;
  private TelephonyManager tm;
  
  public PhoneStatusWatcher()
  {
    AppMethodBeat.i(157774);
    this.phoneCallListeners = new LinkedList();
    AppMethodBeat.o(157774);
  }
  
  public static boolean isCalling()
  {
    AppMethodBeat.i(157777);
    Log.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", new Object[] { Boolean.valueOf(calling) });
    boolean bool = calling;
    AppMethodBeat.o(157777);
    return bool;
  }
  
  public void addPhoneCallListener(PhoneCallListener paramPhoneCallListener)
  {
    AppMethodBeat.i(157775);
    this.phoneCallListeners.add(paramPhoneCallListener);
    AppMethodBeat.o(157775);
  }
  
  public void begin(Context paramContext)
  {
    AppMethodBeat.i(157778);
    Log.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
    if (this.tm == null) {
      this.tm = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
    if (this.phoneStateListener == null) {
      this.phoneStateListener = new PhoneStateListener()
      {
        public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(157773);
          Log.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          if (PhoneStatusWatcher.this.phoneCallListeners.size() > 0)
          {
            PhoneStatusWatcher.PhoneCallListener[] arrayOfPhoneCallListener = new PhoneStatusWatcher.PhoneCallListener[PhoneStatusWatcher.this.phoneCallListeners.size()];
            arrayOfPhoneCallListener = (PhoneStatusWatcher.PhoneCallListener[])PhoneStatusWatcher.this.phoneCallListeners.toArray(arrayOfPhoneCallListener);
            int j = arrayOfPhoneCallListener.length;
            int i = 0;
            while (i < j)
            {
              arrayOfPhoneCallListener[i].onPhoneCall(paramAnonymousInt);
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
            PhoneStatusWatcher.access$102(false);
            AppMethodBeat.o(157773);
            return;
            PhoneStatusWatcher.access$102(true);
          }
        }
      };
    }
    paramContext = this.tm;
    Object localObject = this.phoneStateListener;
    localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "begin", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "begin", "(Landroid/content/Context;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(157778);
  }
  
  public void clearPhoneCallListener()
  {
    AppMethodBeat.i(157776);
    this.phoneCallListeners.clear();
    AppMethodBeat.o(157776);
  }
  
  public void end()
  {
    AppMethodBeat.i(157779);
    Log.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
    if (this.tm != null)
    {
      TelephonyManager localTelephonyManager = this.tm;
      Object localObject = this.phoneStateListener;
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "end", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/sdk/platformtools/PhoneStatusWatcher", "end", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.phoneStateListener = null;
    }
    AppMethodBeat.o(157779);
  }
  
  public void removePhoneCallListener(PhoneCallListener paramPhoneCallListener)
  {
    AppMethodBeat.i(230367);
    this.phoneCallListeners.remove(paramPhoneCallListener);
    AppMethodBeat.o(230367);
  }
  
  public static abstract interface PhoneCallListener
  {
    public abstract void onPhoneCall(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneStatusWatcher
 * JD-Core Version:    0.7.0.1
 */