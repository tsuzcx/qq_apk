package com.tencent.mm.xwebutil;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.c;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.ag;
import com.tencent.xweb.util.IXWebLogClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.xwalk.core.WebViewExtensionListener;

public final class b
{
  public static IXWebLogClient ZaP;
  public static ag ZaQ;
  public static WebViewExtensionListener ZaR;
  public static ISharedPreferenceProvider ZaS;
  
  static
  {
    AppMethodBeat.i(152920);
    ZaP = new IXWebLogClient()
    {
      final String TAG = "IXWebLogClient";
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152908);
        Log.d(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152908);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152906);
        Log.e(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152906);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152905);
        Log.i(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152905);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152909);
        Log.v(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152909);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152907);
        Log.w(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(152907);
      }
    };
    ZaQ = new ag()
    {
      final String TAG = "XWebIdkey";
      
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7)
      {
        AppMethodBeat.i(152913);
        Log.v("XWebIdkey", "callback: kvStat:15003, 20210601," + paramAnonymousInt1 + ",0," + paramAnonymousString + "," + paramAnonymousInt3 + ",-1," + paramAnonymousInt4 + "," + paramAnonymousInt5 + "," + paramAnonymousInt6);
        com.tencent.mm.plugin.report.service.h.IzE.a(15003, new Object[] { Integer.valueOf(20210601), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())), Integer.valueOf(paramAnonymousInt3), Integer.valueOf(-1), Integer.valueOf(paramAnonymousInt4), Integer.valueOf(paramAnonymousInt5), Integer.valueOf(paramAnonymousInt6), Integer.valueOf(paramAnonymousInt7) });
        AppMethodBeat.o(152913);
      }
      
      public final void bh(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(152911);
        Log.v("XWebIdkey", "callback: idkeyForPair:577, " + paramAnonymousInt1 + ", 1, 577, " + paramAnonymousInt2 + ", " + paramAnonymousInt3);
        com.tencent.mm.plugin.report.service.h.IzE.a(577, 577, paramAnonymousInt1, paramAnonymousInt2, 1, paramAnonymousInt3, true);
        AppMethodBeat.o(152911);
      }
      
      public final void kvStat(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(152912);
        Log.v("XWebIdkey", "callback: kvStat:" + paramAnonymousInt + ", " + paramAnonymousString);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(paramAnonymousInt, paramAnonymousString);
        AppMethodBeat.o(152912);
      }
      
      public final void p(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(152910);
        Log.v("XWebIdkey", "callback: idkeyStat:" + paramAnonymousLong1 + ", " + paramAnonymousLong2 + ", " + paramAnonymousLong3);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, true);
        AppMethodBeat.o(152910);
      }
    };
    ZaR = new WebViewExtensionListener()
    {
      public final int getHostByName(String paramAnonymousString, List<String> paramAnonymousList)
      {
        AppMethodBeat.i(152915);
        Object localObject = MainProcessIPCService.PROCESS_NAME;
        if (!com.tencent.mm.ipcinvoker.e.aFo().Ml((String)localObject))
        {
          AppMethodBeat.o(152915);
          return 0;
        }
        paramAnonymousString = (Bundle)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramAnonymousString), b.a.class);
        if ((paramAnonymousList != null) && (paramAnonymousString != null))
        {
          paramAnonymousList.clear();
          localObject = paramAnonymousString.getStringArrayList("ipList");
          int i = paramAnonymousString.getInt("result");
          paramAnonymousList.addAll((Collection)localObject);
          AppMethodBeat.o(152915);
          return i;
        }
        AppMethodBeat.o(152915);
        return 0;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(152914);
        if ("AddFilterResources".equals(paramAnonymousString)) {
          com.tencent.mm.svg.a.e.a((Resources)paramAnonymousVarArgs[0], (Map)paramAnonymousVarArgs[1]);
        }
        AppMethodBeat.o(152914);
        return null;
      }
    };
    ZaS = new ISharedPreferenceProvider()
    {
      public final SharedPreferences F(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(152916);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = MultiProcessMMKV.getMMKVWithTransportByName(paramAnonymousString);
          if (paramAnonymousString == null)
          {
            AppMethodBeat.o(152916);
            return null;
          }
        }
        else
        {
          if (paramAnonymousInt == 4) {}
          for (paramAnonymousInt = 2;; paramAnonymousInt = 1)
          {
            paramAnonymousString = MultiProcessMMKV.getMMKV(paramAnonymousString, paramAnonymousInt);
            break;
          }
        }
        paramAnonymousString = new XWebMMkvWrapper(paramAnonymousString);
        AppMethodBeat.o(152916);
        return paramAnonymousString;
      }
    };
    AppMethodBeat.o(152920);
  }
  
  public static String getModuleName()
  {
    AppMethodBeat.i(152919);
    String str = MMApplicationContext.getProcessName();
    if (str == null)
    {
      AppMethodBeat.o(152919);
      return "";
    }
    if (str.contains(":"))
    {
      str = str.substring(str.lastIndexOf(":") + 1).toLowerCase();
      if (str.startsWith("appbrand"))
      {
        AppMethodBeat.o(152919);
        return "appbrand";
      }
      AppMethodBeat.o(152919);
      return str;
    }
    if (str.contains("."))
    {
      str = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
      AppMethodBeat.o(152919);
      return str;
    }
    AppMethodBeat.o(152919);
    return str;
  }
  
  static final class a
    implements m<IPCString, Bundle>
  {
    private static Bundle f(IPCString paramIPCString)
    {
      AppMethodBeat.i(152917);
      Bundle localBundle = new Bundle();
      for (;;)
      {
        try
        {
          ArrayList localArrayList = new ArrayList();
          if (!Util.isNullOrNil(paramIPCString.value))
          {
            i = com.tencent.mm.kernel.h.aHF().kcd.lCD.getHostByName(paramIPCString.value, localArrayList);
            localBundle.putStringArrayList("ipList", localArrayList);
            localBundle.putInt("result", i);
            AppMethodBeat.o(152917);
            return localBundle;
          }
        }
        catch (Exception paramIPCString)
        {
          Log.printErrStackTrace("GetHostByNameTask", paramIPCString, "GetHostByNameTask", new Object[0]);
          AppMethodBeat.o(152917);
          return localBundle;
        }
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xwebutil.b
 * JD-Core Version:    0.7.0.1
 */