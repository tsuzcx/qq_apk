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
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService
  extends Service
{
  private static ServiceConnection gdJ;
  private static Map<Integer, WeakReference<WepkgMainProcessTask>> gdL = new ConcurrentHashMap();
  private static Handler gdM = new WepkgMainProcessService.3(Looper.getMainLooper());
  private static Messenger gdN = new Messenger(gdM);
  private static a rOU;
  private static final LinkedList<Message> rOV = new LinkedList();
  private final Messenger gdG = new Messenger(this.mHandler);
  private final Handler mHandler = new WepkgMainProcessService.1(this, d.DS().mnU.getLooper());
  private final a.a rOT = new WepkgMainProcessService.2(this);
  
  public static void a(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    gdL.put(Integer.valueOf(paramWepkgMainProcessTask.hashCode()), new WeakReference(paramWepkgMainProcessTask));
    Message localMessage = Message.obtain();
    localMessage.what = paramWepkgMainProcessTask.hashCode();
    localMessage.replyTo = gdN;
    localMessage.setData(c(paramWepkgMainProcessTask));
    n(localMessage);
  }
  
  private static void a(WepkgMainProcessTask paramWepkgMainProcessTask1, WepkgMainProcessTask paramWepkgMainProcessTask2)
  {
    Parcel localParcel = Parcel.obtain();
    paramWepkgMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramWepkgMainProcessTask2.e(localParcel);
    localParcel.recycle();
  }
  
  private static void aht()
  {
    if (gdJ == null) {
      gdJ = new WepkgMainProcessService.4();
    }
    y.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
    Context localContext = ae.getContext();
    localContext.bindService(new Intent(localContext, WepkgMainProcessService.class), gdJ, 1);
  }
  
  private static WepkgMainProcessTask ai(Bundle paramBundle)
  {
    paramBundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
    return (WepkgMainProcessTask)paramBundle.getParcelable("task_object");
  }
  
  public static boolean b(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    Bundle localBundle = c(paramWepkgMainProcessTask);
    if (q(localBundle))
    {
      a(ai(localBundle), paramWepkgMainProcessTask);
      paramWepkgMainProcessTask.Zv();
      return true;
    }
    return false;
  }
  
  static Bundle c(WepkgMainProcessTask paramWepkgMainProcessTask)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("task_object", paramWepkgMainProcessTask);
    return localBundle;
  }
  
  public static boolean isLive()
  {
    return rOU != null;
  }
  
  private static void n(Message paramMessage)
  {
    paramMessage.replyTo = gdN;
    if (rOU == null)
    {
      aht();
      synchronized (rOV)
      {
        rOV.add(paramMessage);
        return;
      }
    }
    try
    {
      rOU.m(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      y.e("MicroMsg.Wepkg.WepkgMainProcessService", paramMessage.getMessage());
    }
  }
  
  private static boolean q(Bundle paramBundle)
  {
    try
    {
      rOU.t(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.Wepkg.WepkgMainProcessService", paramBundle.getMessage());
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.rOT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService
 * JD-Core Version:    0.7.0.1
 */