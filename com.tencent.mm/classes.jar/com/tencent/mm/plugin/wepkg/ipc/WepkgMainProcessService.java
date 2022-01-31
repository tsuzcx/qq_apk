package com.tencent.mm.plugin.wepkg.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService
  extends Service
{
  private static ServiceConnection hvG;
  private static Map<Integer, WeakReference<WepkgMainProcessTask>> hvI;
  private static Handler hvJ;
  private static Messenger hvK;
  private static a vFJ;
  private static final LinkedList<Message> vFK;
  private final Messenger hvD;
  private final Handler mHandler;
  private final a.a vFI;
  
  static
  {
    AppMethodBeat.i(63500);
    vFK = new LinkedList();
    hvI = new ConcurrentHashMap();
    hvJ = new WepkgMainProcessService.3(Looper.getMainLooper());
    hvK = new Messenger(hvJ);
    AppMethodBeat.o(63500);
  }
  
  public WepkgMainProcessService()
  {
    AppMethodBeat.i(63486);
    this.mHandler = new WepkgMainProcessService.1(this, d.aNS().oNc.getLooper());
    this.hvD = new Messenger(this.mHandler);
    this.vFI = new WepkgMainProcessService.2(this);
    AppMethodBeat.o(63486);
  }
  
  public static void a(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    AppMethodBeat.i(63487);
    hvI.put(Integer.valueOf(paramWepkgMainProcessTask.hashCode()), new WeakReference(paramWepkgMainProcessTask));
    Message localMessage = Message.obtain();
    localMessage.what = paramWepkgMainProcessTask.hashCode();
    localMessage.replyTo = hvK;
    localMessage.setData(c(paramWepkgMainProcessTask));
    t(localMessage);
    AppMethodBeat.o(63487);
  }
  
  private static void a(WepkgMainProcessTask paramWepkgMainProcessTask1, WepkgMainProcessTask paramWepkgMainProcessTask2)
  {
    AppMethodBeat.i(63494);
    Parcel localParcel = Parcel.obtain();
    paramWepkgMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramWepkgMainProcessTask2.f(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(63494);
  }
  
  private static WepkgMainProcessTask aA(Bundle paramBundle)
  {
    AppMethodBeat.i(63493);
    paramBundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
    paramBundle = (WepkgMainProcessTask)paramBundle.getParcelable("task_object");
    AppMethodBeat.o(63493);
    return paramBundle;
  }
  
  private static void aBa()
  {
    AppMethodBeat.i(63491);
    if (hvG == null) {
      hvG = new WepkgMainProcessService.4();
    }
    ab.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
    Context localContext = ah.getContext();
    Intent localIntent = new Intent(localContext, WepkgMainProcessService.class);
    try
    {
      localContext.bindService(localIntent, hvG, 1);
      AppMethodBeat.o(63491);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Wepkg.WepkgMainProcessService", "tryBind() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(63491);
    }
  }
  
  public static boolean b(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    AppMethodBeat.i(63488);
    Bundle localBundle = c(paramWepkgMainProcessTask);
    if (y(localBundle))
    {
      a(aA(localBundle), paramWepkgMainProcessTask);
      paramWepkgMainProcessTask.atb();
      AppMethodBeat.o(63488);
      return true;
    }
    AppMethodBeat.o(63488);
    return false;
  }
  
  static Bundle c(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    AppMethodBeat.i(63492);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("task_object", paramWepkgMainProcessTask);
    AppMethodBeat.o(63492);
    return localBundle;
  }
  
  public static boolean isLive()
  {
    return vFJ != null;
  }
  
  private static void t(Message paramMessage)
  {
    AppMethodBeat.i(63490);
    paramMessage.replyTo = hvK;
    if (vFJ == null)
    {
      aBa();
      synchronized (vFK)
      {
        vFK.add(paramMessage);
        AppMethodBeat.o(63490);
        return;
      }
    }
    try
    {
      vFJ.s(paramMessage);
      AppMethodBeat.o(63490);
      return;
    }
    catch (Exception paramMessage)
    {
      ab.e("MicroMsg.Wepkg.WepkgMainProcessService", paramMessage.getMessage());
      AppMethodBeat.o(63490);
    }
  }
  
  private static boolean y(Bundle paramBundle)
  {
    AppMethodBeat.i(63489);
    boolean bool = true;
    if (vFJ == null)
    {
      aBa();
      AppMethodBeat.o(63489);
      return false;
    }
    try
    {
      vFJ.C(paramBundle);
      AppMethodBeat.o(63489);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.Wepkg.WepkgMainProcessService", paramBundle.getMessage());
        bool = false;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.vFI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService
 * JD-Core Version:    0.7.0.1
 */