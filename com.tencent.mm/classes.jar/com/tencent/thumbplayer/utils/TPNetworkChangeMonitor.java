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
  private static int Mzk = 0;
  private static String Mzl = "unknown";
  private static int Mzm = 0;
  private static int Mzn = Mzk;
  private static String Mzo;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(194845);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(194845);
  }
  
  private static boolean a(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(194851);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(194851);
      return true;
    }
    AppMethodBeat.o(194851);
    return false;
  }
  
  public static int aFd()
  {
    return Mzk;
  }
  
  private static int b(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(194855);
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
      AppMethodBeat.o(194855);
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
    AppMethodBeat.i(194856);
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
      AppMethodBeat.o(194856);
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
  
  public static TPNetworkChangeMonitor gcg()
  {
    AppMethodBeat.i(194846);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.gcj();
    AppMethodBeat.o(194846);
    return localTPNetworkChangeMonitor;
  }
  
  private void gch()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(194850);
        if (Mzk != Mzn) {
          break label183;
        }
        if (TextUtils.equals(Mzl, Mzo)) {
          break label158;
        }
      }
      finally {}
      d.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      d.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + Mzn + ", netStatus: " + Mzk + ", mobileNetSubType" + Mzm);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).la(Mzn, Mzk);
          continue;
          label158:
          bool = false;
        }
        else
        {
          Mzn = Mzk;
          Mzo = Mzl;
        }
      }
      else
      {
        AppMethodBeat.o(194850);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void gci()
  {
    AppMethodBeat.i(194852);
    d.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + Mzk + "[wifi: 2, mobile: 3], lastNetStatus=" + Mzn + ", mDetailNetworkType=" + Mzl + ", mobileNetSubType=" + Mzm + "[2G:2 3G:3 4G:4], currentDetailNetType=" + Mzl + ", lastDetailNetType=" + Mzo);
    AppMethodBeat.o(194852);
  }
  
  public final void a(b paramb)
  {
    try
    {
      AppMethodBeat.i(194853);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        d.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(194853);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(194854);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        d.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(194854);
      return;
    }
    finally {}
  }
  
  public final void cM(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(194847);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      }
      AppMethodBeat.o(194847);
      return;
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public final void lp(Context paramContext)
  {
    AppMethodBeat.i(194849);
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
          Mzk = 3;
          paramContext = localNetworkInfo1;
        }
        switch (Mzk)
        {
        case 1: 
          Mzl = c(paramContext);
          if (Mzn == 0)
          {
            Mzn = Mzk;
            Mzo = Mzl;
          }
          gci();
          gch();
          AppMethodBeat.o(194849);
          return;
          paramContext = null;
          continue;
          if (a(localNetworkInfo2))
          {
            Mzk = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          Mzk = 1;
          continue;
          if (a(paramContext))
          {
            if (!a(localNetworkInfo1)) {
              break label222;
            }
            i = 3;
            Mzk = i;
            continue;
          }
          Mzk = 1;
          continue;
          Mzm = 0;
          break;
        case 2: 
          Mzm = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(194849);
        return;
      }
      continue;
      Mzm = b(paramContext);
      continue;
      continue;
      label222:
      int i = 2;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(194848);
    d.d("TPNetworkChangeMonitor", "onReceive broadcast action and update net status ...");
    lp(paramContext);
    AppMethodBeat.o(194848);
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor Mzp;
    
    static
    {
      AppMethodBeat.i(194844);
      Mzp = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(194844);
    }
  }
  
  public static abstract interface b
  {
    public abstract void la(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */