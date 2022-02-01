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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.q;
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
  private static final String urC;
  private static final String urD;
  private static final String urE;
  private static final String urF;
  private static final String urG;
  private static final String urH;
  private static final String urI;
  private static final String urJ;
  private static Map<String, d<Boolean>> urK;
  private static Map<String, d<Void>> urL;
  private static ap urM;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.akk("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    urC = com.tencent.mm.plugin.performance.a.b.akk("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    urD = urC + com.tencent.mm.plugin.performance.a.b.akk("êá²¦²¦§·");
    urE = urC + com.tencent.mm.plugin.performance.a.b.akk("åà«£³·®°¨");
    urF = urC + com.tencent.mm.plugin.performance.a.b.akk("æí¤ª© µ¥¦§»");
    urG = urC + com.tencent.mm.plugin.performance.a.b.akk("åàµ´¨£¤±°");
    urH = urC + com.tencent.mm.plugin.performance.a.b.akk("î­­©£° ¶«");
    urI = com.tencent.mm.plugin.performance.a.b.akk("·¨¤ª");
    urJ = com.tencent.mm.plugin.performance.a.b.akk(" ¬º");
    urK = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    urL = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    urM = new ap(com.tencent.mm.plugin.performance.a.b.akk("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    PACKAGE_NAME = aj.getContext().getPackageName();
    urK.put(urI, new d() {});
    urK.put(urJ, new d() {});
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("¦¤µ¢í ²¨"), new d()
    {
      private static Void dax()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.Q(b.P(new e(aj.getContext().getApplicationInfo().sourceDir)));
          AppMethodBeat.o(124920);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 2.", new Object[0]);
          }
        }
      }
    });
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¯¥§»"), new d()
    {
      private static Void dax()
      {
        AppMethodBeat.i(124922);
        for (;;)
        {
          try
          {
            localObject1 = c.hP(com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¯¥§»"), ".zip");
            e locale = new e(aj.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.akl((String)localObject2) + "/base.odex";
            localObject2 = new e(locale.fhT(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, null);
            c.Q((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ad.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 3.", new Object[0]);
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
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¶¥§»"), new d()
    {
      private static Void dax()
      {
        AppMethodBeat.i(124924);
        for (;;)
        {
          try
          {
            localObject1 = c.hP(com.tencent.mm.plugin.performance.a.b.akk("©¥¶£ê¶¥§»"), ".zip");
            e locale = new e(aj.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.akl((String)localObject2) + "/base.vdex";
            localObject2 = new e(locale.fhT(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, null);
            c.Q((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ad.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 4.", new Object[0]);
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
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("§§´¥ì±¬"), new d()
    {
      private Void ap(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.aRe());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ad.e(c.TAG, "[-] Explained by src 5.");
          AppMethodBeat.o(124927);
          return null;
        }
        for (;;)
        {
          try
          {
            localObject1 = c.hP(com.tencent.mm.plugin.performance.a.b.akk("§§´¥ì±¬"), ".zip");
            e locale = new e(aj.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.akl((String)localObject2);
            localObject2 = new e(locale.fhT(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, new g()
            {
              public final boolean accept(e paramAnonymous2e)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.urQ.matcher(paramAnonymous2e.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            });
            c.Q((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ad.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 6: %s", new Object[] { paramAnonymousMap });
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
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("­ ²°"), new d()
    {
      private static Void ap(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.akn(c.c(paramAnonymousMap, c.cPj(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bQU();
            c.a.aT(aj.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ad.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.bQU() + ":" + str;
        }
      }
    });
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("´­ ²°"), new d()
    {
      private static Void ap(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.akn(c.c(paramAnonymousMap, c.cPj(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bQU();
            c.a.aU(aj.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ad.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.bQU() + ":" + str;
        }
      }
    });
    urL.put(com.tencent.mm.plugin.performance.a.b.akk("µ¾³ì±¬"), new d()
    {
      private static Void ap(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(193441);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.dav());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ad.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(193441);
          return null;
        }
        try
        {
          e locale = c.hP(com.tencent.mm.plugin.performance.a.b.akk("µ¾³ì±¬"), ".zip");
          b.a(new e(paramAnonymousMap), locale, null);
          c.Q(locale);
          AppMethodBeat.o(193441);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.printErrStackTrace(c.TAG, localThrowable, "[-] faild op %s", new Object[] { paramAnonymousMap });
          }
        }
      }
    });
    AppMethodBeat.o(124950);
  }
  
  public c()
  {
    AppMethodBeat.i(124943);
    a.J(aj.getContext());
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
  
  private static String dau()
  {
    AppMethodBeat.i(124942);
    if (ay.isWifi(aj.getContext()))
    {
      str = urI;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = urJ;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void ao(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(124944);
    final String str1 = (String)paramMap.get(urD);
    if (bt.isNullOrNil(str1))
    {
      ad.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(124944);
      return;
    }
    if (!urL.containsKey(str1))
    {
      ad.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(124944);
      return;
    }
    String str2 = b(paramMap, urE, urI);
    if (!urK.containsKey(str2))
    {
      ad.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(124944);
      return;
    }
    if (!((Boolean)((d)urK.get(str2)).dA(paramMap)).booleanValue())
    {
      ad.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { dau(), str2 });
      AppMethodBeat.o(124944);
      return;
    }
    ad.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, dau() });
    urM.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193440);
        ((d)c.daw().get(str1)).dA(paramMap);
        AppMethodBeat.o(193440);
      }
    });
    AppMethodBeat.o(124944);
  }
  
  public final String dat()
  {
    return urC;
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String ACTION;
    private static final String urS;
    private static final String urT;
    private static a urU;
    
    static
    {
      AppMethodBeat.i(124940);
      ACTION = "action" + c.cXk();
      urS = com.tencent.mm.plugin.performance.a.b.akk("µ´¨£¤±°");
      urT = com.tencent.mm.plugin.performance.a.b.akk("­­©£° ¶«");
      urU = null;
      AppMethodBeat.o(124940);
    }
    
    static void J(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (urU != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          urU = new a();
          localIntentFilter = new IntentFilter(ACTION);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(urU, localIntentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
            AppMethodBeat.o(124934);
          }
          catch (Throwable paramContext)
          {
            ad.printErrStackTrace(c.TAG, paramContext, "[-] Fail to register receiver.", new Object[0]);
            ad.eFw();
            AppMethodBeat.o(124934);
          }
          paramContext = finally;
        }
      }
    }
    
    static void aT(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(urS, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124935);
    }
    
    static void aU(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(urS, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124936);
    }
    
    private static void aV(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(urT, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124937);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(124939);
      try
      {
        aj.getContext().unregisterReceiver(this);
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
        ad.e(c.TAG, "[-] Explained by src 12: %s", new Object[] { localObject });
        AppMethodBeat.o(124938);
        return;
      }
      int i = paramIntent.getIntExtra("op", 0);
      e locale;
      switch (i)
      {
      default: 
        ad.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(urS);
        if (TextUtils.isEmpty(paramIntent))
        {
          ad.e(c.TAG, "[-] Explained by src 13.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(aj.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.akm(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ad.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 14: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.P(new e("/proc/" + i + "/maps"));
        locale = c.hP(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.akk("­ ²°"), ".zip");
        b.a((e)localObject, locale, null);
        aV(paramContext, q.B(locale.fhU()));
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(urS);
        if (TextUtils.isEmpty(paramIntent))
        {
          ad.e(c.TAG, "[-] Explained by src 15.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(aj.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.akm(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ad.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 16: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.P(new e("/proc/" + i + "/smaps"));
        locale = c.hP(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.akk("´­ ²°"), ".zip");
        b.a((e)localObject, locale, null);
        aV(paramContext, q.B(locale.fhU()));
        AppMethodBeat.o(124938);
        return;
      }
      if (!aj.cbe())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(urT);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        ad.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.Q(new e(paramContext));
        AppMethodBeat.o(124938);
        return;
      }
      catch (Throwable paramContext)
      {
        ad.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 18.", new Object[0]);
        AppMethodBeat.o(124938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */