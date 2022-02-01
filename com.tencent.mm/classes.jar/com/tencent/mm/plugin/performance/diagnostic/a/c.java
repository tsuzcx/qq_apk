package com.tencent.mm.plugin.performance.diagnostic.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends a
{
  private static final String PACKAGE_NAME;
  private static final String TAG;
  private static final String wWC;
  private static final String wWD;
  private static final String wWE;
  private static final String wWF;
  private static final String wWG;
  private static final String wWH;
  private static final String wWI;
  private static final String wWJ;
  private static Map<String, d<Boolean>> wWK;
  private static Map<String, d<Void>> wWL;
  private static aq wWM;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.avD("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    wWC = com.tencent.mm.plugin.performance.a.b.avD("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    wWD = wWC + com.tencent.mm.plugin.performance.a.b.avD("êá²¦²¦§·");
    wWE = wWC + com.tencent.mm.plugin.performance.a.b.avD("åà«£³·®°¨");
    wWF = wWC + com.tencent.mm.plugin.performance.a.b.avD("æí¤ª© µ¥¦§»");
    wWG = wWC + com.tencent.mm.plugin.performance.a.b.avD("åàµ´¨£¤±°");
    wWH = wWC + com.tencent.mm.plugin.performance.a.b.avD("çî­­©£° ¶«");
    wWI = com.tencent.mm.plugin.performance.a.b.avD("·¨¤ª");
    wWJ = com.tencent.mm.plugin.performance.a.b.avD(" ¬º");
    wWK = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    wWL = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    wWM = new aq(com.tencent.mm.plugin.performance.a.b.avD("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    PACKAGE_NAME = ak.getContext().getPackageName();
    wWK.put(wWI, new d() {});
    wWK.put(wWJ, new d() {});
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("¦¤µ¢í ²¨"), new d()
    {
      private static Void dBR()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.Q(b.P(new k(ak.getContext().getApplicationInfo().sourceDir)));
          AppMethodBeat.o(124920);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 2.", new Object[0]);
          }
        }
      }
    });
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("©¥¶£ê¯¥§»"), new d()
    {
      private static Void dBR()
      {
        AppMethodBeat.i(124922);
        for (;;)
        {
          try
          {
            localObject1 = c.iC(com.tencent.mm.plugin.performance.a.b.avD("©¥¶£ê¯¥§»"), ".zip");
            k localk = new k(ak.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.avE((String)localObject2) + "/base.odex";
            localObject2 = new k(localk.fTg(), (String)localObject2);
            if (!((k)localObject2).canRead()) {
              continue;
            }
            b.a((k)localObject2, (k)localObject1, null);
            c.Q((k)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ae.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 3.", new Object[0]);
            continue;
          }
          AppMethodBeat.o(124922);
          return null;
          i += 1;
        }
        localObject1 = new IOException("cannot find readable base odex path.");
        AppMethodBeat.o(124922);
        throw ((Throwable)localObject1);
      }
    });
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("©¥¶£ê¶¥§»"), new d()
    {
      private static Void dBR()
      {
        AppMethodBeat.i(124924);
        for (;;)
        {
          try
          {
            localObject1 = c.iC(com.tencent.mm.plugin.performance.a.b.avD("©¥¶£ê¶¥§»"), ".zip");
            k localk = new k(ak.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.avE((String)localObject2) + "/base.vdex";
            localObject2 = new k(localk.fTg(), (String)localObject2);
            if (!((k)localObject2).canRead()) {
              continue;
            }
            b.a((k)localObject2, (k)localObject1, null);
            c.Q((k)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ae.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 4.", new Object[0]);
            continue;
          }
          AppMethodBeat.o(124924);
          return null;
          i += 1;
        }
        localObject1 = new IOException("cannot find readable base vdex path.");
        AppMethodBeat.o(124924);
        throw ((Throwable)localObject1);
      }
    });
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("§§´¥ì±¬"), new d()
    {
      private Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.bbZ());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ae.e(c.TAG, "[-] Explained by src 5.");
          AppMethodBeat.o(124927);
          return null;
        }
        for (;;)
        {
          try
          {
            localObject1 = c.iC(com.tencent.mm.plugin.performance.a.b.avD("§§´¥ì±¬"), ".zip");
            k localk = new k(ak.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.avE((String)localObject2);
            localObject2 = new k(localk.fTg(), (String)localObject2);
            if (!((k)localObject2).canRead()) {
              continue;
            }
            b.a((k)localObject2, (k)localObject1, new m()
            {
              public final boolean accept(k paramAnonymous2k)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.wWQ.matcher(paramAnonymous2k.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            });
            c.Q((k)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ae.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 6: %s", new Object[] { paramAnonymousMap });
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
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("­ ²°"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.avG(c.c(paramAnonymousMap, c.dcX(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.cec();
            c.a.aZ(ak.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ae.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.cec() + ":" + str;
        }
      }
    });
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("´­ ²°"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.avG(c.c(paramAnonymousMap, c.dcX(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.cec();
            c.a.ba(ak.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ae.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.cec() + ":" + str;
        }
      }
    });
    wWL.put(com.tencent.mm.plugin.performance.a.b.avD("µ¾³ì±¬"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(215413);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.dBP());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ae.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(215413);
          return null;
        }
        try
        {
          k localk = c.iC(com.tencent.mm.plugin.performance.a.b.avD("µ¾³ì±¬"), ".zip");
          b.a(new k(paramAnonymousMap), localk, null);
          c.Q(localk);
          AppMethodBeat.o(215413);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.printErrStackTrace(c.TAG, localThrowable, "[-] faild op %s", new Object[] { paramAnonymousMap });
          }
        }
      }
    });
    AppMethodBeat.o(124950);
  }
  
  public c()
  {
    AppMethodBeat.i(124943);
    a.K(ak.getContext());
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
  
  private static String bxT()
  {
    AppMethodBeat.i(124942);
    if (az.isWifi(ak.getContext()))
    {
      str = wWI;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = wWJ;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void aB(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(124944);
    final String str1 = (String)paramMap.get(wWD);
    if (bu.isNullOrNil(str1))
    {
      ae.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(124944);
      return;
    }
    if (!wWL.containsKey(str1))
    {
      ae.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(124944);
      return;
    }
    String str2 = b(paramMap, wWE, wWI);
    if (!wWK.containsKey(str2))
    {
      ae.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(124944);
      return;
    }
    if (!((Boolean)((d)wWK.get(str2)).dF(paramMap)).booleanValue())
    {
      ae.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { bxT(), str2 });
      AppMethodBeat.o(124944);
      return;
    }
    ae.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, bxT() });
    wWM.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(215412);
        ((d)c.dBQ().get(str1)).dF(paramMap);
        AppMethodBeat.o(215412);
      }
    });
    AppMethodBeat.o(124944);
  }
  
  public final String dBO()
  {
    return wWC;
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String ACTION;
    private static final String wWS;
    private static final String wWT;
    private static a wWU;
    
    static
    {
      AppMethodBeat.i(124940);
      ACTION = "action" + c.dyy();
      wWS = com.tencent.mm.plugin.performance.a.b.avD("µ´¨£¤±°");
      wWT = com.tencent.mm.plugin.performance.a.b.avD("­­©£° ¶«");
      wWU = null;
      AppMethodBeat.o(124940);
    }
    
    static void K(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (wWU != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          wWU = new a();
          localIntentFilter = new IntentFilter(ACTION);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(wWU, localIntentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
            AppMethodBeat.o(124934);
          }
          catch (Throwable paramContext)
          {
            ae.printErrStackTrace(c.TAG, paramContext, "[-] Fail to register receiver.", new Object[0]);
            ae.foo();
            AppMethodBeat.o(124934);
          }
          paramContext = finally;
        }
      }
    }
    
    static void aZ(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(wWS, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124935);
    }
    
    static void ba(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(wWS, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124936);
    }
    
    private static void bb(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(wWT, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124937);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(124939);
      try
      {
        ak.getContext().unregisterReceiver(this);
        label12:
        super.finalize();
        AppMethodBeat.o(124939);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label12;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(124938);
      Object localObject = paramIntent.getAction();
      if (!ACTION.equals(localObject))
      {
        ae.e(c.TAG, "[-] Explained by src 12: %s", new Object[] { localObject });
        AppMethodBeat.o(124938);
        return;
      }
      int i = paramIntent.getIntExtra("op", 0);
      k localk;
      switch (i)
      {
      default: 
        ae.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(wWS);
        if (TextUtils.isEmpty(paramIntent))
        {
          ae.e(c.TAG, "[-] Explained by src 13.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(ak.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.avF(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ae.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 14: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.P(new k("/proc/" + i + "/maps"));
        localk = c.iC(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.avD("­ ²°"), ".zip");
        b.a((k)localObject, localk, null);
        bb(paramContext, w.B(localk.fTh()));
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(wWS);
        if (TextUtils.isEmpty(paramIntent))
        {
          ae.e(c.TAG, "[-] Explained by src 15.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(ak.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.avF(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ae.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 16: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.P(new k("/proc/" + i + "/smaps"));
        localk = c.iC(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.avD("´­ ²°"), ".zip");
        b.a((k)localObject, localk, null);
        bb(paramContext, w.B(localk.fTh()));
        AppMethodBeat.o(124938);
        return;
      }
      if (!ak.coh())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(wWT);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        ae.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.Q(new k(paramContext));
        AppMethodBeat.o(124938);
        return;
      }
      catch (Throwable paramContext)
      {
        ae.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 18.", new Object[0]);
        AppMethodBeat.o(124938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */