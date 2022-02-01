package com.tencent.mm.plugin.performance.diagnostic.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements com.tencent.mm.plugin.performance.a.c
{
  private static final String MJA;
  private static final String MJB;
  private static final String MJC;
  private static final String MJD;
  private static final String MJE;
  private static final String MJF;
  private static final String MJG;
  private static final String MJH;
  private static Map<String, d<Boolean>> MJI;
  private static Map<String, d<Void>> MJJ;
  private static MMHandler MJK;
  private static final String MJL;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.aRr("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    MJA = com.tencent.mm.plugin.performance.a.b.aRr("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    MJB = MJA + com.tencent.mm.plugin.performance.a.b.aRr("êá²¦²¦§·");
    MJC = MJA + com.tencent.mm.plugin.performance.a.b.aRr("åà«£³·®°¨");
    MJD = MJA + com.tencent.mm.plugin.performance.a.b.aRr("æí¤ª© µ¥¦§»");
    MJE = MJA + com.tencent.mm.plugin.performance.a.b.aRr("åàµ´¨£¤±°");
    MJF = MJA + com.tencent.mm.plugin.performance.a.b.aRr("çî­­©£° ¶«");
    MJG = com.tencent.mm.plugin.performance.a.b.aRr("·¨¤ª");
    MJH = com.tencent.mm.plugin.performance.a.b.aRr(" ¬º");
    MJI = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    MJJ = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    MJK = new MMHandler(com.tencent.mm.plugin.performance.a.b.aRr("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    MJL = MMApplicationContext.getContext().getPackageName();
    MJI.put(MJG, new d() {});
    MJI.put(MJH, new d() {});
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("¦¤µ¢í ²¨"), new d()
    {
      private static Void gyE()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.X(b.gyy());
          AppMethodBeat.o(124920);
          return null;
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 2.", new Object[0]);
          }
        }
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("©¥¶£ê¯¥§»"), new d()
    {
      private static Void gyE()
      {
        AppMethodBeat.i(124922);
        try
        {
          u localu = b.kS(com.tencent.mm.plugin.performance.a.b.aRr("©¥¶£ê¯¥§»"), ".zip");
          b.a(b.gyz(), localu, null, null);
          c.X(localu);
          AppMethodBeat.o(124922);
          return null;
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 3.", new Object[0]);
          }
        }
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("©¥¶£ê¶¥§»"), new d()
    {
      private static Void gyE()
      {
        AppMethodBeat.i(124924);
        try
        {
          u localu = b.kS(com.tencent.mm.plugin.performance.a.b.aRr("©¥¶£ê¶¥§»"), ".zip");
          b.a(b.gyA(), localu, null, null);
          c.X(localu);
          AppMethodBeat.o(124924);
          return null;
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 4.", new Object[0]);
          }
        }
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("§§´¥ì±¬"), new d()
    {
      private Void aM(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.MJD);
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          Log.e(c.TAG, "[-] Explained by src 5.");
          AppMethodBeat.o(124927);
          return null;
        }
        for (;;)
        {
          try
          {
            localObject1 = b.kS(com.tencent.mm.plugin.performance.a.b.aRr("§§´¥ì±¬"), ".zip");
            u localu = new u(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.aRs((String)localObject2);
            localObject2 = new u(localu.jKP(), (String)localObject2);
            if (!((u)localObject2).jKQ()) {
              continue;
            }
            b.a((u)localObject2, (u)localObject1, new w()
            {
              public final boolean accept(u paramAnonymous2u)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.MJP.matcher(paramAnonymous2u.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            }, null);
            c.X((u)localObject1);
          }
          finally
          {
            Object localObject1;
            int i;
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 6: %s", new Object[] { paramAnonymousMap });
            continue;
          }
          AppMethodBeat.o(124927);
          return null;
          i += 1;
        }
        localObject1 = new IOException("cannot find readable lib dir.");
        AppMethodBeat.o(124927);
        throw ((Throwable)localObject1);
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("­ ²°"), new d()
    {
      private static Void aM(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.aRu(c.c(paramAnonymousMap, c.MJE, ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.MJL;
            c.a.bD(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          finally
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.MJL + ":" + str;
        }
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("´­ ²°"), new d()
    {
      private static Void aM(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.aRu(c.c(paramAnonymousMap, c.MJE, ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.MJL;
            c.a.bE(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          finally
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.MJL + ":" + str;
        }
      }
    });
    MJJ.put(com.tencent.mm.plugin.performance.a.b.aRr("µ¾³ì±¬"), new d()
    {
      private static Void aM(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(300985);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.cIl());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          Log.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(300985);
          return null;
        }
        try
        {
          u localu = b.kS(com.tencent.mm.plugin.performance.a.b.aRr("µ¾³ì±¬"), ".zip");
          b.a(new u(paramAnonymousMap), localu, null, null);
          c.X(localu);
          AppMethodBeat.o(300985);
          return null;
        }
        finally
        {
          for (;;)
          {
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] faild op %s", new Object[] { paramAnonymousMap });
          }
        }
      }
    });
    AppMethodBeat.o(124950);
  }
  
  public c()
  {
    AppMethodBeat.i(124943);
    a.am(MMApplicationContext.getContext());
    AppMethodBeat.o(124943);
  }
  
  private static String b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124941);
    paramMap = (String)paramMap.get(paramString1);
    if (paramMap != null)
    {
      AppMethodBeat.o(124941);
      return paramMap;
    }
    AppMethodBeat.o(124941);
    return paramString2;
  }
  
  private static String getNetworkType()
  {
    AppMethodBeat.i(124942);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      str = MJG;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = MJH;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void aK(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(300994);
    final String str1 = (String)paramMap.get(MJB);
    if (Util.isNullOrNil(str1))
    {
      Log.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(300994);
      return;
    }
    if (!MJJ.containsKey(str1))
    {
      Log.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(300994);
      return;
    }
    String str2 = b(paramMap, MJC, MJG);
    if (!MJI.containsKey(str2))
    {
      Log.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(300994);
      return;
    }
    if (!((Boolean)((d)MJI.get(str2)).gl(paramMap)).booleanValue())
    {
      Log.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { getNetworkType(), str2 });
      AppMethodBeat.o(300994);
      return;
    }
    Log.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, getNetworkType() });
    MJK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(300972);
        ((d)c.gyC().get(str1)).gl(paramMap);
        AppMethodBeat.o(300972);
      }
    });
    AppMethodBeat.o(300994);
  }
  
  public final String gxZ()
  {
    return MJA;
  }
  
  public final void gya() {}
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String MJR;
    private static final String MJS;
    private static final String MJT;
    private static a MJU;
    private static final String mnL;
    
    static
    {
      AppMethodBeat.i(124940);
      MJR = WeChatPermissions.PERMISSION_MM_MESSAGE();
      mnL = "action" + c.gyD();
      MJS = com.tencent.mm.plugin.performance.a.b.aRr("µ´¨£¤±°");
      MJT = com.tencent.mm.plugin.performance.a.b.aRr("­­©£° ¶«");
      MJU = null;
      AppMethodBeat.o(124940);
    }
    
    static void am(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (MJU != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          MJU = new a();
          localIntentFilter = new IntentFilter(mnL);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(MJU, localIntentFilter, MJR, null);
            AppMethodBeat.o(124934);
            continue;
          }
          finally
          {
            Log.printErrStackTrace(c.TAG, paramContext, "[-] Fail to register receiver.", new Object[0]);
            Log.appenderFlush();
          }
          paramContext = finally;
        }
      }
    }
    
    static void bD(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(mnL);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(MJS, paramString);
      paramContext.sendBroadcast(localIntent, MJR);
      AppMethodBeat.o(124935);
    }
    
    static void bE(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(mnL);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(MJS, paramString);
      paramContext.sendBroadcast(localIntent, MJR);
      AppMethodBeat.o(124936);
    }
    
    private static void bF(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(mnL);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(MJT, paramString);
      paramContext.sendBroadcast(localIntent, MJR);
      AppMethodBeat.o(124937);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(124939);
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(this);
        label12:
        super.finalize();
        AppMethodBeat.o(124939);
        return;
      }
      finally
      {
        break label12;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(124938);
      Object localObject = paramIntent.getAction();
      if (!mnL.equals(localObject))
      {
        Log.e(c.TAG, "[-] Explained by src 12: %s", new Object[] { localObject });
        AppMethodBeat.o(124938);
        return;
      }
      int i = paramIntent.getIntExtra("op", 0);
      u localu;
      switch (i)
      {
      default: 
        Log.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(MJS);
        if (TextUtils.isEmpty(paramIntent))
        {
          Log.e(c.TAG, "[-] Explained by src 13.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(MMApplicationContext.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.aRt(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        finally
        {
          Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 14: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.W(new u("/proc/" + i + "/maps"));
        localu = b.kS(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aRr("­ ²°"), ".zip");
        b.f((u)localObject, localu);
        bF(paramContext, ah.v(localu.jKT()));
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(MJS);
        if (TextUtils.isEmpty(paramIntent))
        {
          Log.e(c.TAG, "[-] Explained by src 15.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(MMApplicationContext.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.aRt(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        finally
        {
          Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 16: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.W(new u("/proc/" + i + "/smaps"));
        localu = b.kS(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aRr("´­ ²°"), ".zip");
        b.f((u)localObject, localu);
        bF(paramContext, ah.v(localu.jKT()));
        AppMethodBeat.o(124938);
        return;
      }
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(MJT);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        Log.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.X(new u(paramContext));
        AppMethodBeat.o(124938);
        return;
      }
      finally
      {
        Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 18.", new Object[0]);
        AppMethodBeat.o(124938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */