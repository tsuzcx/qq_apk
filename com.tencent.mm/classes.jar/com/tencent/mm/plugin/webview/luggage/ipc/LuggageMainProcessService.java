package com.tencent.mm.plugin.webview.luggage.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LuggageMainProcessService
  extends Service
{
  private static ServiceConnection gdJ;
  private static final LinkedList<Parcel> gdK = new LinkedList();
  private static Map<String, WeakReference<MainProcessTask>> gdL = new ConcurrentHashMap();
  private static Handler gdM = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = LuggageMainProcessService.e(paramAnonymousMessage.getData(), false);
      MainProcessTask localMainProcessTask = LuggageMainProcessService.RM(paramAnonymousMessage.gep);
      if (localMainProcessTask == null)
      {
        y.e("MicroMsg.LuggageMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.gep });
        return;
      }
      LuggageMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
      localMainProcessTask.Zv();
    }
  };
  private static Messenger gdN = new Messenger(gdM);
  private static final Set<Object> gdO = Collections.newSetFromMap(new ConcurrentHashMap());
  private static a rdl;
  private final HashMap<String, IBinder.DeathRecipient> gdF = new HashMap();
  private final Messenger gdG;
  private final Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread(getClass().getSimpleName());
  private final a.a rdk;
  
  public LuggageMainProcessService()
  {
    this.mHandlerThread.start();
    this.mHandler = new LuggageMainProcessService.1(this, this.mHandlerThread.getLooper());
    this.gdG = new Messenger(this.mHandler);
    this.rdk = new LuggageMainProcessService.2(this);
  }
  
  static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", gdN);
    }
    localBundle.putString("task_id", paramMainProcessTask.gep);
    return localBundle;
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    gdL.put(paramMainProcessTask.gep, new WeakReference(paramMainProcessTask));
    r(a(paramMainProcessTask, true));
  }
  
  private static void a(MainProcessTask paramMainProcessTask1, MainProcessTask paramMainProcessTask2)
  {
    Parcel localParcel = Parcel.obtain();
    paramMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask2.e(localParcel);
    localParcel.recycle();
  }
  
  public static void aht()
  {
    if (gdJ == null) {
      gdJ = new LuggageMainProcessService.4();
    }
    y.i("MicroMsg.LuggageMainProcessService", "tryBindService");
    Context localContext = ae.getContext();
    localContext.bindService(new Intent(localContext, LuggageMainProcessService.class), gdJ, 1);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    boolean bool = false;
    Bundle localBundle = a(paramMainProcessTask, false);
    if (q(localBundle))
    {
      a(d(localBundle, false), paramMainProcessTask);
      paramMainProcessTask.Zv();
      bool = true;
    }
    return bool;
  }
  
  private static MainProcessTask d(Bundle paramBundle, boolean paramBoolean)
  {
    paramBundle.setClassLoader(MainProcessTask.class.getClassLoader());
    MainProcessTask localMainProcessTask = (MainProcessTask)paramBundle.getParcelable("task_object");
    if (paramBoolean) {
      localMainProcessTask.geD = ((Messenger)paramBundle.getParcelable("task_client"));
    }
    localMainProcessTask.gep = paramBundle.getString("task_id");
    return localMainProcessTask;
  }
  
  private static boolean q(Bundle paramBundle)
  {
    try
    {
      rdl.t(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.LuggageMainProcessService", paramBundle.getMessage());
    }
    return false;
  }
  
  private static void r(Bundle paramBundle)
  {
    if (rdl == null)
    {
      aht();
      synchronized (gdK)
      {
        LinkedList localLinkedList2 = gdK;
        Parcel localParcel = Parcel.obtain();
        paramBundle.writeToParcel(localParcel, 0);
        localLinkedList2.add(localParcel);
        return;
      }
    }
    try
    {
      rdl.s(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.LuggageMainProcessService", paramBundle.getMessage());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.rdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService
 * JD-Core Version:    0.7.0.1
 */