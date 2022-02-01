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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static final String vAA;
  private static final String vAB;
  private static final String vAC;
  private static final String vAD;
  private static Map<String, d<Boolean>> vAE;
  private static Map<String, d<Void>> vAF;
  private static ao vAG;
  private static final String vAw;
  private static final String vAx;
  private static final String vAy;
  private static final String vAz;
  
  static
  {
    AppMethodBeat.i(124950);
    TAG = com.tencent.mm.plugin.performance.a.b.apj("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");
    vAw = com.tencent.mm.plugin.performance.a.b.apj("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    vAx = vAw + com.tencent.mm.plugin.performance.a.b.apj("êá²¦²¦§·");
    vAy = vAw + com.tencent.mm.plugin.performance.a.b.apj("åà«£³·®°¨");
    vAz = vAw + com.tencent.mm.plugin.performance.a.b.apj("æí¤ª© µ¥¦§»");
    vAA = vAw + com.tencent.mm.plugin.performance.a.b.apj("åàµ´¨£¤±°");
    vAB = vAw + com.tencent.mm.plugin.performance.a.b.apj("çî­­©£° ¶«");
    vAC = com.tencent.mm.plugin.performance.a.b.apj("·¨¤ª");
    vAD = com.tencent.mm.plugin.performance.a.b.apj(" ¬º");
    vAE = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    vAF = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    vAG = new ao(com.tencent.mm.plugin.performance.a.b.apj("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    PACKAGE_NAME = ai.getContext().getPackageName();
    vAE.put(vAC, new d() {});
    vAE.put(vAD, new d() {});
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("¦¤µ¢í ²¨"), new d()
    {
      private static Void dof()
      {
        AppMethodBeat.i(124920);
        try
        {
          c.P(b.O(new e(ai.getContext().getApplicationInfo().sourceDir)));
          AppMethodBeat.o(124920);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 2.", new Object[0]);
          }
        }
      }
    });
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("©¥¶£ê¯¥§»"), new d()
    {
      private static Void dof()
      {
        AppMethodBeat.i(124922);
        for (;;)
        {
          try
          {
            localObject1 = c.ii(com.tencent.mm.plugin.performance.a.b.apj("©¥¶£ê¯¥§»"), ".zip");
            e locale = new e(ai.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.apk((String)localObject2) + "/base.odex";
            localObject2 = new e(locale.fxU(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, null);
            c.P((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ac.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 3.", new Object[0]);
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
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("©¥¶£ê¶¥§»"), new d()
    {
      private static Void dof()
      {
        AppMethodBeat.i(124924);
        for (;;)
        {
          try
          {
            localObject1 = c.ii(com.tencent.mm.plugin.performance.a.b.apj("©¥¶£ê¶¥§»"), ".zip");
            e locale = new e(ai.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "oat/" + b.apk((String)localObject2) + "/base.vdex";
            localObject2 = new e(locale.fxU(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, null);
            c.P((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ac.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 4.", new Object[0]);
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
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("§§´¥ì±¬"), new d()
    {
      private Void ar(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124927);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.aXZ());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ac.e(c.TAG, "[-] Explained by src 5.");
          AppMethodBeat.o(124927);
          return null;
        }
        for (;;)
        {
          try
          {
            localObject1 = c.ii(com.tencent.mm.plugin.performance.a.b.apj("§§´¥ì±¬"), ".zip");
            e locale = new e(ai.getContext().getApplicationInfo().sourceDir);
            String[] arrayOfString = Build.SUPPORTED_ABIS;
            int j = arrayOfString.length;
            i = 0;
            if (i >= j) {
              continue;
            }
            Object localObject2 = arrayOfString[i];
            localObject2 = "lib/" + b.apk((String)localObject2);
            localObject2 = new e(locale.fxU(), (String)localObject2);
            if (!((e)localObject2).canRead()) {
              continue;
            }
            b.a((e)localObject2, (e)localObject1, new g()
            {
              public final boolean accept(e paramAnonymous2e)
              {
                AppMethodBeat.i(176899);
                boolean bool = this.vAK.matcher(paramAnonymous2e.getName()).matches();
                AppMethodBeat.o(176899);
                return bool;
              }
            });
            c.P((e)localObject1);
          }
          catch (Throwable localThrowable)
          {
            Object localObject1;
            int i;
            ac.printErrStackTrace(c.TAG, localThrowable, "[-] Explained by src 6: %s", new Object[] { paramAnonymousMap });
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
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("­ ²°"), new d()
    {
      private static Void ar(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124929);
        str = c.apm(c.c(paramAnonymousMap, c.dcS(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bYj();
            c.a.aU(ai.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ac.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 7: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124929);
          return null;
          paramAnonymousMap = c.bYj() + ":" + str;
        }
      }
    });
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("´­ ²°"), new d()
    {
      private static Void ar(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(124931);
        str = c.apm(c.c(paramAnonymousMap, c.dcS(), ""));
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              continue;
            }
            paramAnonymousMap = c.bYj();
            c.a.aV(ai.getContext(), paramAnonymousMap);
          }
          catch (Throwable paramAnonymousMap)
          {
            ac.printErrStackTrace(c.TAG, paramAnonymousMap, "[-] Explained by src 8: %s", new Object[] { str });
            continue;
          }
          AppMethodBeat.o(124931);
          return null;
          paramAnonymousMap = c.bYj() + ":" + str;
        }
      }
    });
    vAF.put(com.tencent.mm.plugin.performance.a.b.apj("µ¾³ì±¬"), new d()
    {
      private static Void ar(Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(206476);
        paramAnonymousMap = (String)paramAnonymousMap.get(c.dod());
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          ac.e(c.TAG, "filePath NULL");
          AppMethodBeat.o(206476);
          return null;
        }
        try
        {
          e locale = c.ii(com.tencent.mm.plugin.performance.a.b.apj("µ¾³ì±¬"), ".zip");
          b.a(new e(paramAnonymousMap), locale, null);
          c.P(locale);
          AppMethodBeat.o(206476);
          return null;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.printErrStackTrace(c.TAG, localThrowable, "[-] faild op %s", new Object[] { paramAnonymousMap });
          }
        }
      }
    });
    AppMethodBeat.o(124950);
  }
  
  public c()
  {
    AppMethodBeat.i(124943);
    a.J(ai.getContext());
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
  
  private static String doc()
  {
    AppMethodBeat.i(124942);
    if (ax.isWifi(ai.getContext()))
    {
      str = vAC;
      AppMethodBeat.o(124942);
      return str;
    }
    String str = vAD;
    AppMethodBeat.o(124942);
    return str;
  }
  
  public final void aq(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(124944);
    final String str1 = (String)paramMap.get(vAx);
    if (bs.isNullOrNil(str1))
    {
      ac.e(TAG, "[-] Target is null or empty!");
      AppMethodBeat.o(124944);
      return;
    }
    if (!vAF.containsKey(str1))
    {
      ac.e(TAG, "[-] Target is absent.");
      AppMethodBeat.o(124944);
      return;
    }
    String str2 = b(paramMap, vAy, vAC);
    if (!vAE.containsKey(str2))
    {
      ac.e(TAG, "[-] Explained by src 9: %s", new Object[] { str2 });
      AppMethodBeat.o(124944);
      return;
    }
    if (!((Boolean)((d)vAE.get(str2)).dB(paramMap)).booleanValue())
    {
      ac.w(TAG, "[!] Explained by src 10: %s, %s", new Object[] { doc(), str2 });
      AppMethodBeat.o(124944);
      return;
    }
    ac.i(TAG, "[+] Explained by src 11: %s, %s, %s", new Object[] { str1, str2, doc() });
    vAG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206475);
        ((d)c.doe().get(str1)).dB(paramMap);
        AppMethodBeat.o(206475);
      }
    });
    AppMethodBeat.o(124944);
  }
  
  public final String dob()
  {
    return vAw;
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private static final String ACTION;
    private static final String vAM;
    private static final String vAN;
    private static a vAO;
    
    static
    {
      AppMethodBeat.i(124940);
      ACTION = "action" + c.dkS();
      vAM = com.tencent.mm.plugin.performance.a.b.apj("µ´¨£¤±°");
      vAN = com.tencent.mm.plugin.performance.a.b.apj("­­©£° ¶«");
      vAO = null;
      AppMethodBeat.o(124940);
    }
    
    static void J(Context paramContext)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(124934);
          if (vAO != null)
          {
            AppMethodBeat.o(124934);
            return;
          }
          vAO = new a();
          localIntentFilter = new IntentFilter(ACTION);
        }
        finally
        {
          try
          {
            IntentFilter localIntentFilter;
            paramContext.registerReceiver(vAO, localIntentFilter, "com.tencent.mm.permission.MM_MESSAGE", null);
            AppMethodBeat.o(124934);
          }
          catch (Throwable paramContext)
          {
            ac.printErrStackTrace(c.TAG, paramContext, "[-] Fail to register receiver.", new Object[0]);
            ac.eUQ();
            AppMethodBeat.o(124934);
          }
          paramContext = finally;
        }
      }
    }
    
    static void aU(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124935);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 1);
      localIntent.putExtra(vAM, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124935);
    }
    
    static void aV(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124936);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 2);
      localIntent.putExtra(vAM, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124936);
    }
    
    private static void aW(Context paramContext, String paramString)
    {
      AppMethodBeat.i(124937);
      Intent localIntent = new Intent(ACTION);
      localIntent.putExtra("op", 3);
      localIntent.putExtra(vAN, paramString);
      paramContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(124937);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(124939);
      try
      {
        ai.getContext().unregisterReceiver(this);
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
        ac.e(c.TAG, "[-] Explained by src 12: %s", new Object[] { localObject });
        AppMethodBeat.o(124938);
        return;
      }
      int i = paramIntent.getIntExtra("op", 0);
      e locale;
      switch (i)
      {
      default: 
        ac.e(c.TAG, "[-] Unknown op: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(124938);
        return;
      case 1: 
        paramIntent = paramIntent.getStringExtra(vAM);
        if (TextUtils.isEmpty(paramIntent))
        {
          ac.e(c.TAG, "[-] Explained by src 13.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(ai.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.apl(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ac.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 14: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.O(new e("/proc/" + i + "/maps"));
        locale = c.ii(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.apj("­ ²°"), ".zip");
        b.a((e)localObject, locale, null);
        aW(paramContext, q.B(locale.fxV()));
        AppMethodBeat.o(124938);
        return;
      case 2: 
        paramIntent = paramIntent.getStringExtra(vAM);
        if (TextUtils.isEmpty(paramIntent))
        {
          ac.e(c.TAG, "[-] Explained by src 15.");
          AppMethodBeat.o(124938);
          return;
        }
        if (!paramIntent.equals(ai.getProcessName()))
        {
          AppMethodBeat.o(124938);
          return;
        }
        try
        {
          i = b.apl(paramIntent);
          if (i == 0)
          {
            paramContext = new IOException("cannot find process: ".concat(String.valueOf(paramIntent)));
            AppMethodBeat.o(124938);
            throw paramContext;
          }
        }
        catch (Throwable paramContext)
        {
          ac.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 16: %s", new Object[] { paramIntent });
          AppMethodBeat.o(124938);
          return;
        }
        localObject = b.O(new e("/proc/" + i + "/smaps"));
        locale = c.ii(paramIntent.replace(':', '-') + "-" + com.tencent.mm.plugin.performance.a.b.apj("´­ ²°"), ".zip");
        b.a((e)localObject, locale, null);
        aW(paramContext, q.B(locale.fxV()));
        AppMethodBeat.o(124938);
        return;
      }
      if (!ai.cin())
      {
        AppMethodBeat.o(124938);
        return;
      }
      paramContext = paramIntent.getStringExtra(vAN);
      if ((paramContext == null) || (paramContext.isEmpty()))
      {
        ac.e(c.TAG, "[-] Explained by src 17: %s", new Object[] { paramContext });
        AppMethodBeat.o(124938);
        return;
      }
      try
      {
        c.P(new e(paramContext));
        AppMethodBeat.o(124938);
        return;
      }
      catch (Throwable paramContext)
      {
        ac.printErrStackTrace(c.TAG, paramContext, "[-] Explained by src 18.", new Object[0]);
        AppMethodBeat.o(124938);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.c
 * JD-Core Version:    0.7.0.1
 */