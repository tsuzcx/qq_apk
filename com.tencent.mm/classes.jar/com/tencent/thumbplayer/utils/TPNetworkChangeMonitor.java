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
  private static int ZHX = 0;
  private static String ZHY = "unknown";
  private static int ZHZ = 0;
  private static int ZIa = ZHX;
  private static String ZIb;
  private HandlerThread ZIc;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(222254);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(222254);
  }
  
  private void a(Context paramContext, Handler paramHandler)
  {
    try
    {
      AppMethodBeat.i(222260);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, paramHandler);
      }
      AppMethodBeat.o(222260);
      return;
    }
    finally {}
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(222279);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(222279);
      return true;
    }
    AppMethodBeat.o(222279);
    return false;
  }
  
  private static int b(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(222286);
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
      AppMethodBeat.o(222286);
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  public static int bih()
  {
    return ZHX;
  }
  
  private static String c(NetworkInfo paramNetworkInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(222288);
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
      AppMethodBeat.o(222288);
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
  
  public static TPNetworkChangeMonitor irQ()
  {
    AppMethodBeat.i(222255);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.irT();
    AppMethodBeat.o(222255);
    return localTPNetworkChangeMonitor;
  }
  
  private void irR()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(222276);
        if (ZHX != ZIa) {
          break label183;
        }
        if (TextUtils.equals(ZHY, ZIb)) {
          break label158;
        }
      }
      finally {}
      g.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      g.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + ZIa + ", netStatus: " + ZHX + ", mobileNetSubType" + ZHZ);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).nP(ZIa, ZHX);
          continue;
          label158:
          bool = false;
        }
        else
        {
          ZIa = ZHX;
          ZIb = ZHY;
        }
      }
      else
      {
        AppMethodBeat.o(222276);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void irS()
  {
    AppMethodBeat.i(222282);
    g.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + ZHX + "[wifi: 2, mobile: 3], lastNetStatus=" + ZIa + ", mDetailNetworkType=" + ZHY + ", mobileNetSubType=" + ZHZ + "[2G:2 3G:3 4G:4], currentDetailNetType=" + ZHY + ", lastDetailNetType=" + ZIb);
    AppMethodBeat.o(222282);
  }
  
  @SuppressLint({"MissingPermission"})
  private void mh(Context paramContext)
  {
    AppMethodBeat.i(222269);
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
          ZHX = 3;
          paramContext = localNetworkInfo1;
        }
        switch (ZHX)
        {
        case 1: 
          ZHY = c(paramContext);
          if (ZIa == 0)
          {
            ZIa = ZHX;
            ZIb = ZHY;
          }
          irS();
          irR();
          AppMethodBeat.o(222269);
          return;
          paramContext = null;
          continue;
          if (a(localNetworkInfo2))
          {
            ZHX = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          ZHX = 1;
          continue;
          if (a(paramContext))
          {
            if (!a(localNetworkInfo1)) {
              break label220;
            }
            i = 3;
            ZHX = i;
            continue;
          }
          ZHX = 1;
          continue;
          ZHZ = 0;
          break;
        case 2: 
          ZHZ = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(222269);
        return;
      }
      continue;
      ZHZ = b(paramContext);
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
      AppMethodBeat.i(222284);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        g.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(222284);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(222285);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        g.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(222285);
      return;
    }
    finally {}
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(222258);
      b.h(paramContext, "context can not be null!");
      if (this.ZIc == null)
      {
        this.ZIc = new HandlerThread("TP_NetInform");
        this.ZIc.start();
      }
      a(paramContext, new Handler(this.ZIc.getLooper()));
      mh(paramContext);
      AppMethodBeat.o(222258);
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(222263);
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
      mh(paramContext);
      AppMethodBeat.o(222263);
      return;
      i = 0;
      break;
    }
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor ZId;
    
    static
    {
      AppMethodBeat.i(222248);
      ZId = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(222248);
    }
  }
  
  public static abstract interface b
  {
    public abstract void nP(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */