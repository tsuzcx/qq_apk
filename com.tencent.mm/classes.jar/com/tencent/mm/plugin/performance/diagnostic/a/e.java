package com.tencent.mm.plugin.performance.diagnostic.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.t.a;
import com.tencent.mm.plugin.performance.a.b;
import com.tencent.mm.plugin.performance.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class e
  implements c
{
  private static final String MJV;
  private static final String MJW;
  private static final String MJX;
  private static final String MJY;
  private static final String MJZ;
  private static final List<f<b>> MKa;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(300983);
    TAG = b.aRr("³¸¦º¤·ÿ¶»¾£§¨®­©£¯¦« ");
    MJV = b.aRr("ý¹½¢ ©­¢¨ µé¦¨®¦");
    MJW = MJV + b.aRr("é° ¶«");
    MJX = MJV + b.aRr("ê·²¿® ¯¦");
    MJY = MJV + b.aRr("ê·²¿® ¯¦");
    MJZ = b.aRr("î±£¨");
    ArrayList localArrayList = new ArrayList(16);
    MKa = localArrayList;
    localArrayList.add(new f() {});
    MKa.add(new f() {});
    MKa.add(new f() {});
    MKa.add(new f() {});
    MKa.add(new f() {});
    MKa.add(new f() {});
    AppMethodBeat.o(300983);
  }
  
  private static String aRv(String paramString)
  {
    AppMethodBeat.i(300931);
    paramString = paramString.replaceAll("\\$", "\\\\$").replaceAll("\\{", "\\\\{").replaceAll("\\}", "\\\\}").replaceAll("\\.", "\\\\.").replaceAll("\\?", "\\\\?").replaceAll("\\*", "\\\\*");
    paramString = "(?<![$\\\\])\\$\\{" + paramString + "\\}";
    AppMethodBeat.o(300931);
    return paramString;
  }
  
  private static boolean gyF()
  {
    AppMethodBeat.i(300937);
    d locald = h.ahAA.f(new e.2());
    try
    {
      boolean bool = ((Boolean)locald.get(1500L, TimeUnit.MILLISECONDS)).booleanValue();
      AppMethodBeat.o(300937);
      return bool;
    }
    finally
    {
      Log.printErrStackTrace(TAG, localThrowable, "Explained by code.", new Object[0]);
      locald.cancel(true);
      AppMethodBeat.o(300937);
    }
    return false;
  }
  
  public final void aK(Map<String, String> paramMap)
  {
    Object localObject4 = null;
    int k = 0;
    AppMethodBeat.i(300996);
    String str = (String)paramMap.get(MJW);
    int i;
    if (TextUtils.isEmpty(str)) {
      i = k;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      if (i != 0) {}
      try
      {
        localObject1 = new String(Base64.decode(str, 2), StandardCharsets.UTF_8);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          Log.e(TAG, "Explained by site 1.");
          AppMethodBeat.o(300996);
          return;
          localObject1 = str.toCharArray();
          i = k;
          if ((localObject1.length & 0x3) != 0) {
            continue;
          }
          int m = localObject1.length;
          j = 0;
          for (;;)
          {
            if (j >= m) {
              break label197;
            }
            int n = localObject1[j];
            if (((n < 65) || (n > 90)) && ((n < 97) || (n > 122)) && ((n < 48) || (n > 57)) && (n != 61) && (n != 47))
            {
              i = k;
              if (n != 43) {
                break;
              }
            }
            j += 1;
          }
          label197:
          i = 1;
          continue;
        }
        localObject4 = (String)paramMap.get(MJX);
        int j = Util.safeParseInt((String)paramMap.get(MJY));
        i = j;
        if (j != 1)
        {
          i = j;
          if (j != 2) {
            i = 1;
          }
        }
        if ((!gyF()) && (i == 1))
        {
          Log.w(TAG, "Explained by site 2.");
          AppMethodBeat.o(300996);
          return;
        }
        paramMap = new b((String)localObject4, (String)localObject1, i);
        localObject1 = MKa.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (f)((Iterator)localObject1).next();
          if (((f)localObject4).gn(paramMap))
          {
            h.ahAA.bm(new f.1((f)localObject4, paramMap));
            AppMethodBeat.o(300996);
            return;
          }
        }
        Log.e(TAG, "Explained by site 3.");
        AppMethodBeat.o(300996);
        return;
      }
      finally
      {
        for (;;)
        {
          Object localObject3 = localObject4;
        }
      }
    }
  }
  
  public final String gxZ()
  {
    return MJV;
  }
  
  public final void gya()
  {
    AppMethodBeat.i(300989);
    a locala = new a((byte)0);
    Context localContext = MMApplicationContext.getContext();
    try
    {
      localContext.registerReceiver(locala, new IntentFilter(a.MKd), WeChatPermissions.PERMISSION_MM_MESSAGE(), null);
      h.ahAA.bn(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300919);
          e.gyH();
          AppMethodBeat.o(300919);
        }
      });
      AppMethodBeat.o(300989);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, localThrowable, "Explained by code.", new Object[0]);
      }
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    static final String MKd;
    private static final String MKe;
    private static final String MKf;
    private static final String MKg;
    private static final String MKh;
    private static final String MKi;
    private static final String MKj;
    private static final String MKk;
    
    static
    {
      AppMethodBeat.i(300943);
      MKd = b.aRr("¯¬¼ ¥¥·£¶µ¤±·");
      MKe = b.aRr("¤´ ¢¯§");
      MKf = b.aRr("¯ ª½¹¦¤¥¡´­ ²°");
      MKg = b.aRr("­¿©¸»¥¨¡¶µ¬¨±·");
      MKh = b.aRr("®£«¼º§«¤¢¦¨®¦");
      MKi = b.aRr("©»­¶±¾® ¯¦");
      MKj = b.aRr("¥·¡° ¶«");
      MKk = b.aRr("·¥·¶¶ ¯©¼¬¸§ª«·¬¤¶¦");
      AppMethodBeat.o(300943);
    }
    
    static void a(Context paramContext, String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(300923);
      Intent localIntent = new Intent(MKd);
      localIntent.putExtra(MKe, MKf);
      localIntent.putExtra(MKi, paramString);
      localIntent.putExtra(MKg, paramArrayOfString);
      paramContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(300923);
    }
    
    public final void onReceive(final Context paramContext, final Intent paramIntent)
    {
      AppMethodBeat.i(300949);
      if (!MKd.equals(paramIntent.getAction()))
      {
        Log.e(e.TAG, "Explained by site 1.");
        AppMethodBeat.o(300949);
        return;
      }
      paramContext = paramIntent.getStringExtra(MKe);
      h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(300977);
          if (e.a.MKf.equals(paramContext))
          {
            e.a.bk(paramIntent);
            AppMethodBeat.o(300977);
            return;
          }
          if (e.a.MKh.equals(paramContext))
          {
            if (!MMApplicationContext.isMainProcess())
            {
              AppMethodBeat.o(300977);
              return;
            }
            e.a.bl(paramIntent);
          }
          AppMethodBeat.o(300977);
        }
      });
      AppMethodBeat.o(300949);
    }
  }
  
  static final class b
  {
    final String MKn;
    final int MKo;
    final String path;
    
    b(String paramString1, String paramString2, int paramInt)
    {
      this.MKn = paramString1;
      this.path = paramString2;
      this.MKo = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.a.e
 * JD-Core Version:    0.7.0.1
 */