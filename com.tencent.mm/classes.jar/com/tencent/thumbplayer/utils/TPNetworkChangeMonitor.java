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
  private static int Mcp = 0;
  private static String Mcq = "unknown";
  private static int Mcr = 0;
  private static int Mcs = Mcp;
  private static String Mct;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(192167);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(192167);
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(192173);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(192173);
      return true;
    }
    AppMethodBeat.o(192173);
    return false;
  }
  
  public static int aEN()
  {
    return Mcp;
  }
  
  private static int b(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(192177);
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
      AppMethodBeat.o(192177);
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
    AppMethodBeat.i(192178);
    String str;
    if (paramNetworkInfo != null)
    {
      str = paramNetworkInfo.getTypeName();
      d.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: ".concat(String.valueOf(str)));
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
      AppMethodBeat.o(192178);
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
  
  public static TPNetworkChangeMonitor fXH()
  {
    AppMethodBeat.i(192168);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.fXK();
    AppMethodBeat.o(192168);
    return localTPNetworkChangeMonitor;
  }
  
  private void fXI()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(192172);
        if (Mcp != Mcs) {
          break label183;
        }
        if (TextUtils.equals(Mcq, Mct)) {
          break label158;
        }
      }
      finally {}
      d.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      d.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + Mcs + ", netStatus: " + Mcp + ", mobileNetSubType" + Mcr);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).kT(Mcs, Mcp);
          continue;
          label158:
          bool = false;
        }
        else
        {
          Mcs = Mcp;
          Mct = Mcq;
        }
      }
      else
      {
        AppMethodBeat.o(192172);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void fXJ()
  {
    AppMethodBeat.i(192174);
    d.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + Mcp + "[wifi: 2, mobile: 3], lastNetStatus=" + Mcs + ", mDetailNetworkType=" + Mcq + ", mobileNetSubType=" + Mcr + "[2G:2 3G:3 4G:4], currentDetailNetType=" + Mcq + ", lastDetailNetType=" + Mct);
    AppMethodBeat.o(192174);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(192175);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        d.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(192175);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(192176);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        d.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(192176);
      return;
    }
    finally {}
  }
  
  public final void cK(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(192169);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      }
      AppMethodBeat.o(192169);
      return;
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public final void lj(Context paramContext)
  {
    AppMethodBeat.i(192171);
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
          Mcp = 3;
          paramContext = localNetworkInfo1;
        }
        switch (Mcp)
        {
        case 1: 
          Mcq = c(paramContext);
          if (Mcs == 0)
          {
            Mcs = Mcp;
            Mct = Mcq;
          }
          fXJ();
          fXI();
          AppMethodBeat.o(192171);
          return;
          paramContext = null;
          continue;
          if (a(localNetworkInfo2))
          {
            Mcp = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          Mcp = 1;
          continue;
          if (a(paramContext))
          {
            if (!a(localNetworkInfo1)) {
              break label222;
            }
            i = 3;
            Mcp = i;
            continue;
          }
          Mcp = 1;
          continue;
          Mcr = 0;
          break;
        case 2: 
          Mcr = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(192171);
        return;
      }
      continue;
      Mcr = b(paramContext);
      continue;
      continue;
      label222:
      int i = 2;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(192170);
    d.d("TPNetworkChangeMonitor", "onReceive broadcast action and update net status ...");
    lj(paramContext);
    AppMethodBeat.o(192170);
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor Mcu;
    
    static
    {
      AppMethodBeat.i(192166);
      Mcu = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(192166);
    }
  }
  
  public static abstract interface b
  {
    public abstract void kT(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */