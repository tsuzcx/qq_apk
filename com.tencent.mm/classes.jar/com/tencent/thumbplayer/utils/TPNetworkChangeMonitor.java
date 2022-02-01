package com.tencent.thumbplayer.utils;

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
  private static int ahNa = 0;
  private static String ahNb = "unknown";
  private static int ahNc = 0;
  private static int ahNd = ahNa;
  private static String ahNe;
  private HandlerThread ahNf;
  private ArrayList<b> mListeners;
  
  private TPNetworkChangeMonitor()
  {
    AppMethodBeat.i(227052);
    this.mListeners = null;
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    AppMethodBeat.o(227052);
  }
  
  private static boolean b(NetworkInfo paramNetworkInfo)
  {
    AppMethodBeat.i(227100);
    if ((paramNetworkInfo != null) && ((paramNetworkInfo.isConnected()) || (paramNetworkInfo.isConnectedOrConnecting())))
    {
      AppMethodBeat.o(227100);
      return true;
    }
    AppMethodBeat.o(227100);
    return false;
  }
  
  public static int bFQ()
  {
    return ahNa;
  }
  
  private static int c(NetworkInfo paramNetworkInfo)
  {
    int j = 0;
    AppMethodBeat.i(227120);
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
      AppMethodBeat.o(227120);
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
  
  private static String d(NetworkInfo paramNetworkInfo)
  {
    Object localObject = null;
    AppMethodBeat.i(227129);
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
      AppMethodBeat.o(227129);
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
  
  private void d(Context paramContext, Handler paramHandler)
  {
    try
    {
      AppMethodBeat.i(227070);
      if (paramContext != null) {
        paramContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, paramHandler);
      }
      AppMethodBeat.o(227070);
      return;
    }
    finally {}
  }
  
  public static TPNetworkChangeMonitor kbq()
  {
    AppMethodBeat.i(227063);
    TPNetworkChangeMonitor localTPNetworkChangeMonitor = a.kbt();
    AppMethodBeat.o(227063);
    return localTPNetworkChangeMonitor;
  }
  
  private void kbr()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        AppMethodBeat.i(227092);
        if (ahNa != ahNd) {
          break label183;
        }
        if (TextUtils.equals(ahNb, ahNe)) {
          break label158;
        }
      }
      finally {}
      g.i("TPNetworkChangeMonitor", "notifyIfNetChanged, isNetChanged: " + bool + ",  mListeners:  " + this.mListeners);
      g.i("TPNetworkChangeMonitor", "onNetworkStatusChanged oldNetStatus: " + ahNd + ", netStatus: " + ahNa + ", mobileNetSubType" + ahNc);
      if (bool)
      {
        Iterator localIterator = this.mListeners.iterator();
        if (localIterator.hasNext())
        {
          ((b)localIterator.next()).pM(ahNd, ahNa);
          continue;
          label158:
          bool = false;
        }
        else
        {
          ahNd = ahNa;
          ahNe = ahNb;
        }
      }
      else
      {
        AppMethodBeat.o(227092);
        return;
        label183:
        bool = true;
      }
    }
  }
  
  private static void kbs()
  {
    AppMethodBeat.i(227107);
    g.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + ahNa + "[wifi: 2, mobile: 3], lastNetStatus=" + ahNd + ", mDetailNetworkType=" + ahNb + ", mobileNetSubType=" + ahNc + "[2G:2 3G:3 4G:4], currentDetailNetType=" + ahNb + ", lastDetailNetType=" + ahNe);
    AppMethodBeat.o(227107);
  }
  
  private void ou(Context paramContext)
  {
    AppMethodBeat.i(227083);
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
          if (!b(localNetworkInfo1)) {
            continue;
          }
          ahNa = 3;
          paramContext = localNetworkInfo1;
        }
        switch (ahNa)
        {
        case 1: 
          ahNb = d(paramContext);
          if (ahNd == 0)
          {
            ahNd = ahNa;
            ahNe = ahNb;
          }
          kbs();
          kbr();
          AppMethodBeat.o(227083);
          return;
          paramContext = null;
          continue;
          if (b(localNetworkInfo2))
          {
            ahNa = 2;
            paramContext = localNetworkInfo2;
            continue;
          }
          ahNa = 1;
          continue;
          if (b(paramContext))
          {
            if (!b(localNetworkInfo1)) {
              break label220;
            }
            i = 3;
            ahNa = i;
            continue;
          }
          ahNa = 1;
          continue;
          ahNc = 0;
          break;
        case 2: 
          ahNc = 1;
        }
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(227083);
        return;
      }
      continue;
      ahNc = c(paramContext);
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
      AppMethodBeat.i(227175);
      if ((this.mListeners != null) && (!this.mListeners.contains(paramb)))
      {
        this.mListeners.add(paramb);
        g.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(227175);
      return;
    }
    finally {}
  }
  
  public final void b(b paramb)
  {
    try
    {
      AppMethodBeat.i(227182);
      if (this.mListeners != null)
      {
        this.mListeners.remove(paramb);
        g.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + paramb + ", mListeners: " + this.mListeners.size());
      }
      AppMethodBeat.o(227182);
      return;
    }
    finally {}
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(227158);
      b.p(paramContext, "context can not be null!");
      if (this.ahNf == null)
      {
        this.ahNf = new HandlerThread("TP_NetInform");
        this.ahNf.start();
      }
      d(paramContext, new Handler(this.ahNf.getLooper()));
      ou(paramContext);
      AppMethodBeat.o(227158);
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(227168);
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
      ou(paramContext);
      AppMethodBeat.o(227168);
      return;
      i = 0;
      break;
    }
  }
  
  static final class a
  {
    private static TPNetworkChangeMonitor ahNg;
    
    static
    {
      AppMethodBeat.i(227044);
      ahNg = new TPNetworkChangeMonitor((byte)0);
      AppMethodBeat.o(227044);
    }
  }
  
  public static abstract interface b
  {
    public abstract void pM(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPNetworkChangeMonitor
 * JD-Core Version:    0.7.0.1
 */