package com.tencent.thumbplayer.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class TPNetworkChangeMonitor
  extends BroadcastReceiver
{
  private static int Sfm = 0;
  private static String Sfn = "unknown";
  private static int Sfo = 0;
  private static int Sfp = Sfm;
  private static String Sfq;
  private HandlerThread Sfr;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(189646);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(189646);
  }
  
  private void a(Context paramContext, Handler paramHandler)
  {
    try
    {
      AppMethodBeat.i(189649);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, paramHandler);
      }
      AppMethodBeat.o(189649);
      return;
    }
    finally {}
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(189653);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(189653);
      return true;
    }
    AppMethodBeat.o(189653);
    return false;
  }
  
  public static int aYS()
  {
    return Sfm;
  }
  
  private static int b(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(189657);
    int i = j;
    if (paramNetworkInfo != null)
    {
      i = j;
      switch (paramNetworkInfo.getSubtype())
      {
      default: 
        i = 3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(189657);
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  private static String c(NetworkInfo paramNetworkInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(189658);
    String str;
    if (paramNetworkInfo != null)
    {
      str = paramNetworkInfo.getTypeName();
      g.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: ".concat(String.valueOf(str)));
      if (str == null) {
        break label288;
      }
      if (str.toLowerCase(Locale.getDefault()).equals("wifi")) {
        break label282;
      }
      str = paramNetworkInfo.getExtraInfo();
      paramNetworkInfo = localObject;
      if (str != null) {
        paramNetworkInfo = str.toLowerCase(Locale.getDefault());
      }
      if (paramNetworkInfo == null) {
        break label288;
      }
      if (!paramNetworkInfo.startsWith("cmwap")) {
        break label96;
      }
      paramNetworkInfo = "cmwap";
    }
    label282:
    label288:
    for (;;)
    {
      AppMethodBeat.o(189658);
      return paramNetworkInfo;
      str = null;
      break;
      label96:
      if ((paramNetworkInfo.startsWith("cmnet")) || (paramNetworkInfo.startsWith("epc.tmobile.com")))
      {
        paramNetworkInfo = "cmnet";
      }
      else if (paramNetworkInfo.startsWith("uniwap"))
      {
        paramNetworkInfo = "uniwap";
      }
      else if (paramNetworkInfo.startsWith("uninet"))
      {
        paramNetworkInfo = "uninet";
      }
      else if (paramNetworkInfo.startsWith("wap"))
      {
        paramNetworkInfo = "wap";
      }
      else if (paramNetworkInfo.startsWith("net"))
      {
        paramNetworkInfo = "net";
      }
      else if (paramNetworkInfo.startsWith("ctwap"))
      {
        paramNetworkInfo = "ctwap";
      }
      else if (paramNetworkInfo.startsWith("ctnet"))
      {
        paramNetworkInfo = "ctnet";
      }
      else if (paramNetworkInfo.startsWith("3gwap"))
      {
        paramNetworkInfo = "3gwap";
      }
      else if (paramNetworkInfo.startsWith("3gnet"))
      {
        paramNetworkInfo = "3gnet";
      }
      else if (paramNetworkInfo.startsWith("#777"))
      {
        paramNetworkInfo = Proxy.getDefaultHost();
        if ((paramNetworkInfo != null) && (paramNetworkInfo.length() > 0)) {
          paramNetworkInfo = "ctwap";
        } else {
          paramNetworkInfo = "ctnet";
        }
      }
      else
      {
        paramNetworkInfo = "unknown";
        continue;
        paramNetworkInfo = "wifi";
        continue;
        paramNetworkInfo = "unknown";
      }
    }
  }
  
  public static TPNetworkChangeMonitor hop()
  {
    AppMethodBeat.i(189647);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.hos();
    AppMethodBeat.o(189647);
    return localTPNetworkChangeMonitor;
  }
  
  private void hoq()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(189652);
        if (Sfm != Sfp) {
          break label183;
        }
        if (TextUtils.equals(Sfn, Sfq)) {
          break label158;
        }
      }
      finally {}
      g.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      g.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + Sfp + ", netStatus: " + Sfm + ", mobileNetSubType" + Sfo);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).my(Sfp, Sfm);
          continue;
          label158:
          bool = false;
        }
        else
        {
          Sfp = Sfm;
          Sfq = Sfn;
        }
      }
      else
      {
        AppMethodBeat.o(189652);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void hor()
  {
    AppMethodBeat.i(189654);
    g.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + Sfm + "[wifi: 2, mobile: 3], lastNetStatus=" + Sfp + ", mDetailNetworkType=" + Sfn + ", mobileNetSubType=" + Sfo + "[2G:2 3G:3 4G:4], currentDetailNetType=" + Sfn + ", lastDetailNetType=" + Sfq);
    AppMethodBeat.o(189654);
  }
  
  @SuppressLint({"MissingPermission"})
  private void lj(Context paramContext)
  {
    AppMethodBeat.i(189651);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        NetworkInfo localNetworkInfo1;
        NetworkInfo localNetworkInfo2;
        if (paramContext != null)
        {
          localNetworkInfo1 = paramContext.getNetworkInfo(0);
          localNetworkInfo2 = paramContext.getNetworkInfo(1);
          paramContext = paramContext.getActiveNetworkInfo();
          if (paramContext != null) {
            continue;
          }
          if (!a(localNetworkInfo1)) {
            continue;
          }
          Sfm = 3;
          paramContext = localNetworkInfo1;
        }
        switch (Sfm)
        {
        case 1: 
          Sfn = c(paramContext);
          if (Sfp == 0)
          {
            Sfp = Sfm;
            Sfq = Sfn;
          }
          hor();
          hoq();
          AppMethodBeat.o(189651);
          return;
          paramContext = null;
          continue;
          if (a(localNetworkInfo2))
          {
            Sfm = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          Sfm = 1;
          continue;
          if (a(paramContext))
          {
            if (!a(localNetworkInfo1)) {
              break label220;
            }
            i = 3;
            Sfm = i;
            continue;
          }
          Sfm = 1;
          continue;
          Sfo = 0;
          break;
        case 2: 
          Sfo = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(189651);
        return;
      }
      continue;
      Sfo = b(paramContext);
      continue;
      continue;
      label220:
      int i = 2;
    }
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(189655);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        g.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(189655);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(189656);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        g.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(189656);
      return;
    }
    finally {}
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(189648);
      b.e(paramContext, "context can not be null!");
      if (this.Sfr == null)
      {
        this.Sfr = new HandlerThread("TP_NetInform");
        this.Sfr.start();
      }
      a(paramContext, new Handler(this.Sfr.getLooper()));
      lj(paramContext);
      AppMethodBeat.o(189648);
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(189650);
    StringBuilder localStringBuilder = new StringBuilder("onReceive broadcast action and update net status,onReceive broadcast in ");
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (paramIntent = "main";; paramIntent = "work")
    {
      g.d("TPNetworkChangeMonitor", paramIntent + " thread.");
      lj(paramContext);
      AppMethodBeat.o(189650);
      return;
      i = 0;
      break;
    }
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor Sfs;
    
    static
    {
      AppMethodBeat.i(189645);
      Sfs = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(189645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void my(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */