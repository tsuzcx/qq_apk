package com.tencent.thumbplayer.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class TPNetworkChangeMonitor
  extends BroadcastReceiver
{
  private static int Kmq = 0;
  private static String Kmr = "unknown";
  private static int Kms = 0;
  private static int Kmt = Kmq;
  private static String Kmu;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(188242);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(188242);
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(188248);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(188248);
      return true;
    }
    AppMethodBeat.o(188248);
    return false;
  }
  
  public static int aBK()
  {
    return Kmq;
  }
  
  private static int b(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(188252);
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
      AppMethodBeat.o(188252);
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
    AppMethodBeat.i(188253);
    String str;
    if (paramNetworkInfo != null)
    {
      str = paramNetworkInfo.getTypeName();
      f.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: ".concat(String.valueOf(str)));
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
      AppMethodBeat.o(188253);
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
  
  public static TPNetworkChangeMonitor fGv()
  {
    AppMethodBeat.i(188243);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.fGy();
    AppMethodBeat.o(188243);
    return localTPNetworkChangeMonitor;
  }
  
  private void fGw()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(188247);
        if (Kmq != Kmt) {
          break label183;
        }
        if (TextUtils.equals(Kmr, Kmu)) {
          break label158;
        }
      }
      finally {}
      f.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      f.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + Kmt + ", netStatus: " + Kmq + ", mobileNetSubType" + Kms);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).kE(Kmt, Kmq);
          continue;
          label158:
          bool = false;
        }
        else
        {
          Kmt = Kmq;
          Kmu = Kmr;
        }
      }
      else
      {
        AppMethodBeat.o(188247);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void fGx()
  {
    AppMethodBeat.i(188249);
    f.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + Kmq + "[wifi: 2, mobile: 3], lastNetStatus=" + Kmt + ", mDetailNetworkType=" + Kmr + ", mobileNetSubType=" + Kms + "[2G:2 3G:3 4G:4], currentDetailNetType=" + Kmr + ", lastDetailNetType=" + Kmu);
    AppMethodBeat.o(188249);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(188250);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        f.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(188250);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(188251);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        f.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(188251);
      return;
    }
    finally {}
  }
  
  public final void cN(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(188244);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      }
      AppMethodBeat.o(188244);
      return;
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public final void kW(Context paramContext)
  {
    AppMethodBeat.i(188246);
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
          Kmq = 3;
          paramContext = localNetworkInfo1;
        }
        switch (Kmq)
        {
        case 1: 
          Kmr = c(paramContext);
          if (Kmt == 0)
          {
            Kmt = Kmq;
            Kmu = Kmr;
          }
          fGx();
          fGw();
          AppMethodBeat.o(188246);
          return;
          paramContext = null;
          continue;
          if (a(localNetworkInfo2))
          {
            Kmq = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          Kmq = 1;
          continue;
          if (a(paramContext))
          {
            if (!a(localNetworkInfo1)) {
              break label222;
            }
            i = 3;
            Kmq = i;
            continue;
          }
          Kmq = 1;
          continue;
          Kms = 0;
          break;
        case 2: 
          Kms = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(188246);
        return;
      }
      continue;
      Kms = b(paramContext);
      continue;
      continue;
      label222:
      int i = 2;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(188245);
    f.d("TPNetworkChangeMonitor", "onReceive broadcast action and update net status ...");
    kW(paramContext);
    AppMethodBeat.o(188245);
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor Kmv;
    
    static
    {
      AppMethodBeat.i(188241);
      Kmv = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(188241);
    }
  }
  
  public static abstract interface b
  {
    public abstract void kE(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */