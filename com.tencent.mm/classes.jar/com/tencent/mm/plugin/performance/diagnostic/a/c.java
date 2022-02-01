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
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements com.tencent.mm.plugin.performance.a.c
{
  private static final String GME;
  private static final String GMF;
  private static final String GMG;
  private static final String GMH;
  private static final String GMI;
  private static final String GMJ;
  private static final String GMK;
  private static final String GML;
  private static Map<String, d<Boolean>> GMM;
  private static Map<String, d<Void>> GMN;
  private static MMHandler GMO;
  private static final String PACKAGE_NAME;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.aUn("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    GME = com.tencent.mm.plugin.performance.a.b.aUn("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    GMF = GME + com.tencent.mm.plugin.performance.a.b.aUn("êá²¦²¦§·");
    GMG = GME + com.tencent.mm.plugin.performance.a.b.aUn("åà«£³·®°¨");
    GMH = GME + com.tencent.mm.plugin.performance.a.b.aUn("æí¤ª© µ¥¦§»");
    GMI = GME + com.tencent.mm.plugin.performance.a.b.aUn("åàµ´¨£¤±°");
    GMJ = GME + com.tencent.mm.plugin.performance.a.b.aUn("çî­­©£° ¶«");
    GMK = com.tencent.mm.plugin.performance.a.b.aUn("·¨¤ª");
    GML = com.tencent.mm.plugin.performance.a.b.aUn(" ¬º");
    GMM = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    GMN = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    GMO = new MMHandler(com.tencent.mm.plugin.performance.a.b.aUn("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    PACKAGE_NAME = MMApplicationContext.getContext().getPackageName();
    GMM.put(GMK, new d() {});
    GMM.put(GML, new d() {});
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("¦¤µ¢í ²¨"), new d()
    {
      private static Void fnL()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.W(b.V(new q(MMApplicationContext.getContext().getApplicationInfo().sourceDir)));
          AppMethodBeat.o(124920);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 2.", new Object[0]);
          }
        }
      }
    });
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("©¥¶£ê¯¥§»"), new d()
    {
      private static Void fnL()
      {
        AppMethodBeat.i(124922);
        for (;;)
        {
          try
          {
            localObject1 = c.jy(com.tencent.mm.plugin.performance.a.b.aUn("©¥¶£ê¯¥§»"), ".zip");
            q localq = new q(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.aUo((String)localObject2) + "/base.odex";
            localObject2 = new q(localq.ifB(), (String)localObject2);
            if (!((q)localObject2).ifC()) {
              continue;
            }
            b.a((q)localObject2, (q)localObject1, null);
            c.W((q)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 3.", new Object[0]);
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
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("©¥¶£ê¶¥§»"), new d()
    {
      private static Void fnL()
      {
        AppMethodBeat.i(124924);
        for (;;)
        {
          try
          {
            localObject1 = c.jy(com.tencent.mm.plugin.performance.a.b.aUn("©¥¶£ê¶¥§»"), ".zip");
            q localq = new q(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.aUo((String)localObject2) + "/base.vdex";
            localObject2 = new q(localq.ifB(), (String)localObject2);
            if (!((q)localObject2).ifC()) {
              continue;
            }
            b.a((q)localObject2, (q)localObject1, null);
            c.W((q)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            Log.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 4.", new Object[0]);
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
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("§§´¥ì±¬"), new d()
    {
      private Void aw(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.GMH);
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
            localObject1 = c.jy(com.tencent.mm.plugin.performance.a.b.aUn("§§´¥ì±¬"), ".zip");
            q localq = new q(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.aUo((String)localObject2);
            localObject2 = new q(localq.ifB(), (String)localObject2);
            if (!((q)localObject2).ifC()) {
              continue;
            }
            b.a((q)localObject2, (q)localObject1, new s()
            {
              public final boolean accept(q paramAnonymous2q)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.GMS.matcher(paramAnonymous2q.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            });
            c.W((q)localObject1);
          }
          catch (Throwable localThrowable)
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
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("­ ²°"), new d()
    {
      private static Void aw(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.aUq(c.c(paramAnonymousMap, c.bzf(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.chp();
            c.a.bB(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.chp() + ":" + str;
        }
      }
    });
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("´­ ²°"), new d()
    {
      private static Void aw(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.aUq(c.c(paramAnonymousMap, c.bzf(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.chp();
            c.a.bC(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.chp() + ":" + str;
        }
      }
    });
    GMN.put(com.tencent.mm.plugin.performance.a.b.aUn("µ¾³ì±¬"), new d()
    {
      private static Void aw(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(202069);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.eNy());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          Log.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(202069);
          return null;
        }
        try
        {
          q localq = c.jy(com.tencent.mm.plugin.performance.a.b.aUn("µ¾³ì±¬"), ".zip");
          b.a(new q(paramAnonymousMap), localq, null);
          c.W(localq);
          AppMethodBeat.o(202069);
          return null;
        }
        catch (Throwable localThrowable)
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
    a.W(MMApplicationContext.getContext());
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
  
  private static String chm()
  {
    AppMethodBeat.i(124942);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      str = GMK;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = GML;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void au(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(200821);
    final String str1 = (String)paramMap.get(GMF);
    if (Util.isNullOrNil(str1))
    {
      Log.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(200821);
      return;
    }
    if (!GMN.containsKey(str1))
    {
      Log.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(200821);
      return;
    }
    String str2 = b(paramMap, GMG, GMK);
    if (!GMM.containsKey(str2))
    {
      Log.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(200821);
      return;
    }
    if (!((Boolean)((d)GMM.get(str2)).dR(paramMap)).booleanValue())
    {
      Log.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { chm(), str2 });
      AppMethodBeat.o(200821);
      return;
    }
    Log.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, chm() });
    GMO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201213);
        ((d)c.fnK().get(str1)).dR(paramMap);
        AppMethodBeat.o(201213);
      }
    });
    AppMethodBeat.o(200821);
  }
  
  public final String fnm()
  {
    return GME;
  }
  
  public final void fnn() {}
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String ACTION;
    private static final String GMV;
    private static final String GMW;
    private static final String GMX;
    private static a GMY;
    
    static
    {
      AppMethodBeat.i(124940);
      GMV = WeChatPermissions.PERMISSION_MM_MESSAGE();
      ACTION = "action" + c.fjL();
      GMW = com.tencent.mm.plugin.performance.a.b.aUn("µ´¨£¤±°");
      GMX = com.tencent.mm.plugin.performance.a.b.aUn("­­©£° ¶«");
      GMY = null;
      AppMethodBeat.o(124940);
    }
    
    static void W(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (GMY != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          GMY = new a();
          localIntentFilter = new IntentFilter(ACTION);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(GMY, localIntentFilter, GMV, null);
            AppMethodBeat.o(124934);
          }
          catch (Throwable paramContext)
          {
            Log.printErrStackTrace(c.TAG, paramContext, "[-] Fail to register receiver.", new Object[0]);
            Log.appenderFlush();
            AppMethodBeat.o(124934);
          }
          paramContext = finally;
        }
      }
    }
    
    static void bB(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(GMW, paramString);
      paramContext.sendBroadcast(localIntent, GMV);
      AppMethodBeat.o(124935);
    }
    
    static void bC(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(GMW, paramString);
      paramContext.sendBroadcast(localIntent, GMV);
      AppMethodBeat.o(124936);
    }
    
    private static void bD(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(GMX, paramString);
      paramContext.sendBroadcast(localIntent, GMV);
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
        Log.e(c.TAG, "[-] Explained by src 12: %s", new Object[] { localObject });
        AppMethodBeat.o(124938);
        return;
      }
      int i = paramIntent.getIntExtra("op", 0);
      q localq;
      switch (i)
      {
      default: 
        Log.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(GMW);
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
          i = b.aUp(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 14: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.V(new q("/proc/" + i + "/maps"));
        localq = c.jy(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aUn("­ ²°"), ".zip");
        b.a((q)localObject, localq, null);
        bD(paramContext, localq.bOF());
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(GMW);
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
          i = b.aUp(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 16: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.V(new q("/proc/" + i + "/smaps"));
        localq = c.jy(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aUn("´­ ²°"), ".zip");
        b.a((q)localObject, localq, null);
        bD(paramContext, localq.bOF());
        AppMethodBeat.o(124938);
        return;
      }
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(GMX);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        Log.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.W(new q(paramContext));
        AppMethodBeat.o(124938);
        return;
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 18.", new Object[0]);
        AppMethodBeat.o(124938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */