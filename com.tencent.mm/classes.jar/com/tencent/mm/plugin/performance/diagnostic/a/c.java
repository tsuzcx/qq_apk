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
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  implements com.tencent.mm.plugin.performance.a.c
{
  private static final String ATk;
  private static final String ATl;
  private static final String ATm;
  private static final String ATn;
  private static final String ATo;
  private static final String ATp;
  private static final String ATq;
  private static final String ATr;
  private static Map<String, d<Boolean>> ATs;
  private static Map<String, d<Void>> ATt;
  private static MMHandler ATu;
  private static final String PACKAGE_NAME;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.aJR("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    ATk = com.tencent.mm.plugin.performance.a.b.aJR("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    ATl = ATk + com.tencent.mm.plugin.performance.a.b.aJR("êá²¦²¦§·");
    ATm = ATk + com.tencent.mm.plugin.performance.a.b.aJR("åà«£³·®°¨");
    ATn = ATk + com.tencent.mm.plugin.performance.a.b.aJR("æí¤ª© µ¥¦§»");
    ATo = ATk + com.tencent.mm.plugin.performance.a.b.aJR("åàµ´¨£¤±°");
    ATp = ATk + com.tencent.mm.plugin.performance.a.b.aJR("çî­­©£° ¶«");
    ATq = com.tencent.mm.plugin.performance.a.b.aJR("·¨¤ª");
    ATr = com.tencent.mm.plugin.performance.a.b.aJR(" ¬º");
    ATs = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    ATt = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    ATu = new MMHandler(com.tencent.mm.plugin.performance.a.b.aJR("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    PACKAGE_NAME = MMApplicationContext.getContext().getPackageName();
    ATs.put(ATq, new d() {});
    ATs.put(ATr, new d() {});
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("¦¤µ¢í ²¨"), new d()
    {
      private static Void eBY()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.W(b.V(new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir)));
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
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¯¥§»"), new d()
    {
      private static Void eBY()
      {
        AppMethodBeat.i(124922);
        for (;;)
        {
          try
          {
            localObject1 = c.jn(com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¯¥§»"), ".zip");
            o localo = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.aJS((String)localObject2) + "/base.odex";
            localObject2 = new o(localo.heq(), (String)localObject2);
            if (!((o)localObject2).canRead()) {
              continue;
            }
            b.a((o)localObject2, (o)localObject1, null);
            c.W((o)localObject1);
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
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¶¥§»"), new d()
    {
      private static Void eBY()
      {
        AppMethodBeat.i(124924);
        for (;;)
        {
          try
          {
            localObject1 = c.jn(com.tencent.mm.plugin.performance.a.b.aJR("©¥¶£ê¶¥§»"), ".zip");
            o localo = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.aJS((String)localObject2) + "/base.vdex";
            localObject2 = new o(localo.heq(), (String)localObject2);
            if (!((o)localObject2).canRead()) {
              continue;
            }
            b.a((o)localObject2, (o)localObject1, null);
            c.W((o)localObject1);
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
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("§§´¥ì±¬"), new d()
    {
      private Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.ATn);
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
            localObject1 = c.jn(com.tencent.mm.plugin.performance.a.b.aJR("§§´¥ì±¬"), ".zip");
            o localo = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.aJS((String)localObject2);
            localObject2 = new o(localo.heq(), (String)localObject2);
            if (!((o)localObject2).canRead()) {
              continue;
            }
            b.a((o)localObject2, (o)localObject1, new q()
            {
              public final boolean accept(o paramAnonymous2o)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.ATy.matcher(paramAnonymous2o.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            });
            c.W((o)localObject1);
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
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("­ ²°"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.aJU(c.c(paramAnonymousMap, c.boU(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bUk();
            c.a.bo(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.bUk() + ":" + str;
        }
      }
    });
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("´­ ²°"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.aJU(c.c(paramAnonymousMap, c.boU(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bUk();
            c.a.bp(MMApplicationContext.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            Log.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.bUk() + ":" + str;
        }
      }
    });
    ATt.put(com.tencent.mm.plugin.performance.a.b.aJR("µ¾³ì±¬"), new d()
    {
      private static Void aC(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(201044);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.eed());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          Log.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(201044);
          return null;
        }
        try
        {
          o localo = c.jn(com.tencent.mm.plugin.performance.a.b.aJR("µ¾³ì±¬"), ".zip");
          b.a(new o(paramAnonymousMap), localo, null);
          c.W(localo);
          AppMethodBeat.o(201044);
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
    a.K(MMApplicationContext.getContext());
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
  
  private static String bUg()
  {
    AppMethodBeat.i(124942);
    if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      str = ATq;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = ATr;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void aA(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(201046);
    final String str1 = (String)paramMap.get(ATl);
    if (Util.isNullOrNil(str1))
    {
      Log.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(201046);
      return;
    }
    if (!ATt.containsKey(str1))
    {
      Log.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(201046);
      return;
    }
    String str2 = b(paramMap, ATm, ATq);
    if (!ATs.containsKey(str2))
    {
      Log.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(201046);
      return;
    }
    if (!((Boolean)((d)ATs.get(str2)).dO(paramMap)).booleanValue())
    {
      Log.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { bUg(), str2 });
      AppMethodBeat.o(201046);
      return;
    }
    Log.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, bUg() });
    ATu.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(201043);
        ((d)c.eBX().get(str1)).dO(paramMap);
        AppMethodBeat.o(201043);
      }
    });
    AppMethodBeat.o(201046);
  }
  
  public final String eBC()
  {
    return ATk;
  }
  
  public final void eBD() {}
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String ACTION;
    private static final String ATA;
    private static final String ATB;
    private static final String ATC;
    private static a ATD;
    
    static
    {
      AppMethodBeat.i(124940);
      ATA = WeChatPermissions.PERMISSION_MM_MESSAGE();
      ACTION = "action" + c.eyg();
      ATB = com.tencent.mm.plugin.performance.a.b.aJR("µ´¨£¤±°");
      ATC = com.tencent.mm.plugin.performance.a.b.aJR("­­©£° ¶«");
      ATD = null;
      AppMethodBeat.o(124940);
    }
    
    static void K(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (ATD != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          ATD = new a();
          localIntentFilter = new IntentFilter(ACTION);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(ATD, localIntentFilter, ATA, null);
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
    
    static void bo(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(ATB, paramString);
      paramContext.sendBroadcast(localIntent, ATA);
      AppMethodBeat.o(124935);
    }
    
    static void bp(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(ATB, paramString);
      paramContext.sendBroadcast(localIntent, ATA);
      AppMethodBeat.o(124936);
    }
    
    private static void bq(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(ATC, paramString);
      paramContext.sendBroadcast(localIntent, ATA);
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
      o localo;
      switch (i)
      {
      default: 
        Log.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(ATB);
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
          i = b.aJT(paramIntent);
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
        localObject = b.V(new o("/proc/" + i + "/maps"));
        localo = c.jn(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aJR("­ ²°"), ".zip");
        b.a((o)localObject, localo, null);
        bq(paramContext, aa.z(localo.her()));
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(ATB);
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
          i = b.aJT(paramIntent);
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
        localObject = b.V(new o("/proc/" + i + "/smaps"));
        localo = c.jn(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.aJR("´­ ²°"), ".zip");
        b.a((o)localObject, localo, null);
        bq(paramContext, aa.z(localo.her()));
        AppMethodBeat.o(124938);
        return;
      }
      if (!MMApplicationContext.isMainProcess())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(ATC);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        Log.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.W(new o(paramContext));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */