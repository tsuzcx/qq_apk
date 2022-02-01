package com.tencent.mm.plugin.normsg.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.performance.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class a
  implements b.g
{
  public static final a<String> Mus;
  private long MuA;
  private long Mut;
  private long Muu;
  private long Muv;
  private long Muw;
  private long Mux;
  private int Muy;
  private boolean Muz;
  
  static
  {
    AppMethodBeat.i(149041);
    a locala = new a((byte)0);
    Mus = locala;
    locala.add("");
    Mus.add(":tools");
    Mus.add(":toolsmp");
    Mus.add(":appbrand0");
    Mus.add(":appbrand1");
    Mus.add(":appbrand2");
    Mus.add(":appbrand3");
    Mus.add(":appbrand4");
    AppMethodBeat.o(149041);
  }
  
  private a()
  {
    AppMethodBeat.i(149024);
    this.Mut = 0L;
    this.Muu = 0L;
    this.Muv = 0L;
    this.Muw = 0L;
    this.Mux = 0L;
    this.Muy = 0;
    this.Muz = false;
    this.MuA = 0L;
    gtX();
    AppMethodBeat.o(149024);
  }
  
  private void P(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(149034);
      long l = System.currentTimeMillis();
      if (l - this.Muu > 86400000L)
      {
        h.OAn.e("Normsg_AED", "action: " + paramInt + ", pkg: " + paramString1 + ", view: " + paramString2, null);
        this.Muu = l;
        dIo();
      }
      if ((g.isMIUI()) && (c.gub())) {
        gtY();
      }
      AppMethodBeat.o(149034);
      return;
    }
    finally {}
  }
  
  private static String aeW(int paramInt)
  {
    AppMethodBeat.i(149037);
    Object localObject1 = (ActivityManager)MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      AppMethodBeat.o(149037);
      return "";
    }
    Object localObject3;
    try
    {
      Object localObject2 = ((ActivityManager)localObject1).getRunningAppProcesses();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          if (localRunningAppProcessInfo.pid == paramInt)
          {
            localObject2 = localRunningAppProcessInfo.processName;
            AppMethodBeat.o(149037);
            return localObject2;
          }
        }
      }
    }
    finally
    {
      Log.printErrStackTrace("MircoMsg.AEDHLP", localThrowable2, "[tomys] failure on step1.", new Object[0]);
      try
      {
        localObject1 = ((ActivityManager)localObject1).getRunningServices(16384);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (ActivityManager.RunningServiceInfo)((Iterator)localObject1).next();
            if (((ActivityManager.RunningServiceInfo)localObject3).pid == paramInt)
            {
              localObject1 = ((ActivityManager.RunningServiceInfo)localObject3).process;
              AppMethodBeat.o(149037);
              return localObject1;
            }
          }
        }
      }
      finally
      {
        Log.printErrStackTrace("MircoMsg.AEDHLP", localThrowable1, "[tomys] failure on step2.", new Object[0]);
      }
    }
    try
    {
      localBufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, d.aQf("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[] { Integer.valueOf(paramInt) })));
    }
    finally
    {
      localBufferedReader = null;
    }
    try
    {
      localObject3 = localBufferedReader.readLine();
      if (localObject3 != null)
      {
        localObject3 = ((String)localObject3).trim();
        Util.qualityClose(localBufferedReader);
        AppMethodBeat.o(149037);
        return localObject3;
      }
      Util.qualityClose(localBufferedReader);
    }
    finally
    {
      try
      {
        Log.printErrStackTrace("MircoMsg.AEDHLP", localThrowable3, "[tomys] failure on step3.", new Object[0]);
        Util.qualityClose(localBufferedReader);
      }
      finally
      {
        Util.qualityClose(localBufferedReader);
        AppMethodBeat.o(149037);
      }
    }
    AppMethodBeat.o(149037);
    return "";
  }
  
  /* Error */
  private void dIo()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 281
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 283	java/io/File
    //   11: dup
    //   12: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   15: invokevirtual 287	android/content/Context:getCacheDir	()Ljava/io/File;
    //   18: ldc_w 289
    //   21: invokestatic 238	com/tencent/mm/plugin/normsg/d/d:aQf	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 292	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_1
    //   28: new 294	java/io/DataOutputStream
    //   31: dup
    //   32: new 296	java/io/BufferedOutputStream
    //   35: dup
    //   36: new 298	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 301	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 304	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: invokespecial 305	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_1
    //   51: aload_1
    //   52: ldc_w 306
    //   55: invokevirtual 309	java/io/DataOutputStream:writeInt	(I)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 73	com/tencent/mm/plugin/normsg/d/a:Mut	J
    //   63: invokevirtual 313	java/io/DataOutputStream:writeLong	(J)V
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 75	com/tencent/mm/plugin/normsg/d/a:Muu	J
    //   71: invokevirtual 313	java/io/DataOutputStream:writeLong	(J)V
    //   74: aload_1
    //   75: aload_0
    //   76: getfield 77	com/tencent/mm/plugin/normsg/d/a:Muv	J
    //   79: invokevirtual 313	java/io/DataOutputStream:writeLong	(J)V
    //   82: aload_1
    //   83: aload_0
    //   84: getfield 79	com/tencent/mm/plugin/normsg/d/a:Muw	J
    //   87: invokevirtual 313	java/io/DataOutputStream:writeLong	(J)V
    //   90: aload_1
    //   91: aload_0
    //   92: getfield 81	com/tencent/mm/plugin/normsg/d/a:Mux	J
    //   95: invokevirtual 313	java/io/DataOutputStream:writeLong	(J)V
    //   98: aload_1
    //   99: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   102: ldc_w 281
    //   105: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: ldc 200
    //   116: aload_2
    //   117: ldc_w 315
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_1
    //   128: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   131: ldc_w 281
    //   134: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: goto -29 -> 108
    //   140: astore_1
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: astore_2
    //   146: aload_1
    //   147: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   150: ldc_w 281
    //   153: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_2
    //   157: athrow
    //   158: astore_2
    //   159: goto -45 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	a
    //   27	101	1	localObject1	Object
    //   140	7	1	localCloseable	Closeable
    //   111	6	2	localThrowable	Throwable
    //   145	12	2	localObject2	Object
    //   158	1	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	51	111	finally
    //   2	28	140	finally
    //   98	108	140	finally
    //   127	137	140	finally
    //   146	158	140	finally
    //   114	127	145	finally
    //   51	98	158	finally
  }
  
  private void gr(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(149033);
      long l = System.currentTimeMillis();
      if (l - this.Mut > 86400000L)
      {
        h.OAn.e("Normsg_AED", "findview, pkg: " + paramString + ", res_count: " + paramInt, null);
        this.Mut = l;
        dIo();
      }
      if ((g.isMIUI()) && (c.gub())) {
        gtY();
      }
      AppMethodBeat.o(149033);
      return;
    }
    finally {}
  }
  
  public static a gtU()
  {
    return b.MuB;
  }
  
  private void gtW()
  {
    try
    {
      AppMethodBeat.i(149029);
      long l = System.currentTimeMillis();
      if (l - this.Muw >= 259200000L)
      {
        this.Mux = 0L;
        this.Muw = l;
        dIo();
      }
      AppMethodBeat.o(149029);
      return;
    }
    finally {}
  }
  
  private void gtX()
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        AppMethodBeat.i(149030);
        localObject1 = new File(MMApplicationContext.getContext().getCacheDir(), d.aQf("ãçÜºÈ­Üòù"));
      }
      finally {}
      for (;;)
      {
        try
        {
          localObject1 = new DataInputStream(new BufferedInputStream(new FileInputStream((File)localObject1)));
          try
          {
            if (((DataInputStream)localObject1).readInt() != -606158847L)
            {
              IllegalStateException localIllegalStateException = new IllegalStateException("bad magic.");
              AppMethodBeat.o(149030);
              throw localIllegalStateException;
            }
          }
          finally {}
        }
        finally
        {
          Object localObject2 = null;
        }
        try
        {
          Log.printErrStackTrace("MircoMsg.AEDHLP", localThrowable, "[tomys] failure to load rec.", new Object[0]);
          this.Mut = 0L;
          this.Muu = 0L;
          this.Muv = 0L;
          this.Muw = System.currentTimeMillis();
          this.Mux = 0L;
          dIo();
          Util.qualityClose((Closeable)localObject1);
          AppMethodBeat.o(149030);
          return;
        }
        finally
        {
          Util.qualityClose(localCloseable);
          AppMethodBeat.o(149030);
        }
      }
      this.Mut = ((DataInputStream)localObject1).readLong();
      this.Muu = ((DataInputStream)localObject1).readLong();
      this.Muv = ((DataInputStream)localObject1).readLong();
      this.Muw = ((DataInputStream)localObject1).readLong();
      long l = ((DataInputStream)localObject1).readLong();
      if ((l > 0L) && (this.Mux <= 0L)) {
        this.Mux = l;
      }
      Util.qualityClose((Closeable)localObject1);
      AppMethodBeat.o(149030);
    }
  }
  
  /* Error */
  private void gtY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 361
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 85	com/tencent/mm/plugin/normsg/d/a:Muz	Z
    //   12: ifne +48 -> 60
    //   15: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   18: lstore_1
    //   19: lload_1
    //   20: aload_0
    //   21: getfield 87	com/tencent/mm/plugin/normsg/d/a:MuA	J
    //   24: lsub
    //   25: ldc2_w 362
    //   28: lcmp
    //   29: ifge +12 -> 41
    //   32: ldc_w 361
    //   35: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: lload_1
    //   43: putfield 87	com/tencent/mm/plugin/normsg/d/a:MuA	J
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 85	com/tencent/mm/plugin/normsg/d/a:Muz	Z
    //   51: getstatic 369	com/tencent/mm/plugin/secinforeport/a/d:Pmb	Lcom/tencent/mm/plugin/secinforeport/a/d;
    //   54: ldc_w 370
    //   57: invokevirtual 373	com/tencent/mm/plugin/secinforeport/a/d:aiM	(I)V
    //   60: ldc_w 361
    //   63: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -28 -> 38
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   18	25	1	l	long
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	69	finally
    //   41	60	69	finally
    //   60	66	69	finally
  }
  
  public static String iu(String paramString)
  {
    AppMethodBeat.i(149038);
    int i = paramString.indexOf(':');
    if (i != -1)
    {
      paramString = paramString.substring(i);
      AppMethodBeat.o(149038);
      return paramString;
    }
    AppMethodBeat.o(149038);
    return "";
  }
  
  private void s(int paramInt, View paramView)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(149032);
        if (paramView == null)
        {
          AppMethodBeat.o(149032);
          return;
        }
        if (paramInt != 16)
        {
          AppMethodBeat.o(149032);
          continue;
        }
      }
      finally {}
      try
      {
        if (this.Muy == 0)
        {
          AppMethodBeat.o(149032);
          continue;
        }
        if (((paramView instanceof Button)) && (paramView.getId() == this.Muy))
        {
          this.Mux += 1L;
          dIo();
        }
        AppMethodBeat.o(149032);
      }
      finally
      {
        AppMethodBeat.o(149032);
      }
    }
  }
  
  /* Error */
  public final void A(Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 395
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: ldc_w 395
    //   15: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 100	java/lang/System:currentTimeMillis	()J
    //   24: lstore_2
    //   25: lload_2
    //   26: aload_0
    //   27: getfield 77	com/tencent/mm/plugin/normsg/d/a:Muv	J
    //   30: lsub
    //   31: ldc2_w 101
    //   34: lcmp
    //   35: ifle +74 -> 109
    //   38: new 397	java/io/StringWriter
    //   41: dup
    //   42: invokespecial 398	java/io/StringWriter:<init>	()V
    //   45: astore 5
    //   47: new 400	java/io/PrintWriter
    //   50: dup
    //   51: aload 5
    //   53: invokespecial 403	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   56: astore 4
    //   58: aload_1
    //   59: aload 4
    //   61: invokevirtual 409	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   64: aload 4
    //   66: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   69: getstatic 108	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   72: ldc_w 411
    //   75: new 112	java/lang/StringBuilder
    //   78: dup
    //   79: ldc_w 413
    //   82: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 414	java/io/StringWriter:toString	()Ljava/lang/String;
    //   90: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: aconst_null
    //   97: invokevirtual 136	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   100: aload_0
    //   101: lload_2
    //   102: putfield 77	com/tencent/mm/plugin/normsg/d/a:Muv	J
    //   105: aload_0
    //   106: invokespecial 139	com/tencent/mm/plugin/normsg/d/a:dIo	()V
    //   109: ldc_w 395
    //   112: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: goto -97 -> 18
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 266	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   130: goto -61 -> 69
    //   133: astore_1
    //   134: aload 4
    //   136: astore_1
    //   137: goto -11 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	a
    //   0	140	1	paramThrowable	Throwable
    //   24	78	2	l	long
    //   56	79	4	localPrintWriter	java.io.PrintWriter
    //   45	41	5	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   2	8	118	finally
    //   12	18	118	finally
    //   21	47	118	finally
    //   64	69	118	finally
    //   69	109	118	finally
    //   109	115	118	finally
    //   126	130	118	finally
    //   47	58	123	finally
    //   58	64	133	finally
  }
  
  public final void a(int paramInt, View paramView, List<AccessibilityNodeInfo> paramList)
  {
    int i = 0;
    AppMethodBeat.i(149025);
    String str;
    if (paramView != null)
    {
      paramView = paramView.toString();
      str = aeW(paramInt);
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label145;
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MircoMsg.AEDHLP", "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b", new Object[] { Integer.valueOf(paramInt), str, paramView, Boolean.valueOf(bool) });
      paramInt = i;
      if (paramList != null) {
        paramInt = paramList.size();
      }
      gr(str, paramInt);
      if ((c.gtZ()) && (str != null) && (str.contains(d.aQf(">\020r\033c\001xV"))) && (paramList != null)) {
        paramList.clear();
      }
      AppMethodBeat.o(149025);
      return;
      paramView = "";
      break;
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(149026);
    if (paramView != null) {}
    for (String str1 = paramView.toString();; str1 = "")
    {
      String str2 = aeW(paramInt2);
      Log.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[] { Integer.valueOf(paramInt2), str2, str1, Integer.valueOf(paramInt1) });
      s(paramInt1, paramView);
      P(paramInt1, str2, str1);
      if ((!c.gtZ()) || (str2 == null) || (!str2.contains(d.aQf(">\020r\033c\001xV")))) {
        break;
      }
      AppMethodBeat.o(149026);
      return false;
    }
    AppMethodBeat.o(149026);
    return true;
  }
  
  public final void aeR(int paramInt)
  {
    try
    {
      this.Muy = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long gtV()
  {
    try
    {
      AppMethodBeat.i(149028);
      long l = this.Mux;
      gtW();
      AppMethodBeat.o(149028);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(149027);
    Log.printErrStackTrace("MircoMsg.AEDHLP", paramThrowable, "[tomys] unexpected error happens.", new Object[0]);
    A(paramThrowable);
    AppMethodBeat.o(149027);
  }
  
  public static final class a<T>
    extends HashSet<T>
  {
    public final boolean add(T paramT)
    {
      AppMethodBeat.i(149014);
      if (contains(paramT))
      {
        paramT = new UnsupportedOperationException();
        AppMethodBeat.o(149014);
        throw paramT;
      }
      boolean bool = super.add(paramT);
      AppMethodBeat.o(149014);
      return bool;
    }
    
    public final boolean addAll(Collection paramCollection)
    {
      AppMethodBeat.i(149015);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(149015);
      throw paramCollection;
    }
    
    public final void clear()
    {
      AppMethodBeat.i(149016);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(149016);
      throw localUnsupportedOperationException;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(149017);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(149017);
      throw paramObject;
    }
    
    public final boolean removeAll(Collection<?> paramCollection)
    {
      AppMethodBeat.i(149018);
      paramCollection = new UnsupportedOperationException();
      AppMethodBeat.o(149018);
      throw paramCollection;
    }
  }
  
  static final class b
  {
    static final a MuB;
    
    static
    {
      AppMethodBeat.i(149019);
      MuB = new a((byte)0);
      AppMethodBeat.o(149019);
    }
  }
  
  public static final class c
  {
    static boolean gtZ()
    {
      AppMethodBeat.i(149021);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(b.aRr("¸¸¼µ±·»²¿¾§¼ ¹¦©©¤« ¡"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cX(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149021);
          return true;
        }
        AppMethodBeat.o(149021);
      }
      return false;
    }
    
    /* Error */
    public static int gua()
    {
      // Byte code:
      //   0: ldc 69
      //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 23	java/lang/StringBuilder
      //   8: dup
      //   9: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   12: astore_3
      //   13: aload_3
      //   14: ldc 71
      //   16: invokestatic 32	com/tencent/mm/plugin/performance/a/b:aRr	(Ljava/lang/String;)Ljava/lang/String;
      //   19: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   22: pop
      //   23: ldc 2
      //   25: invokevirtual 51	java/lang/Object:hashCode	()I
      //   28: bipush 31
      //   30: iushr
      //   31: iconst_1
      //   32: ior
      //   33: istore_0
      //   34: aload_3
      //   35: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   38: astore_2
      //   39: iload_0
      //   40: ifeq +68 -> 108
      //   43: ldc 2
      //   45: invokevirtual 51	java/lang/Object:hashCode	()I
      //   48: istore_1
      //   49: iload_1
      //   50: bipush 31
      //   52: iushr
      //   53: iconst_1
      //   54: ior
      //   55: iconst_1
      //   56: ixor
      //   57: istore_0
      //   58: aload_3
      //   59: iconst_0
      //   60: aload_3
      //   61: invokevirtual 44	java/lang/StringBuilder:length	()I
      //   64: invokevirtual 48	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   67: pop
      //   68: aload_3
      //   69: iload_0
      //   70: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   73: pop
      //   74: aload_2
      //   75: aload_3
      //   76: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   79: invokestatic 58	com/tencent/mm/plugin/normsg/d/a:cX	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   82: iload_0
      //   83: invokestatic 77	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   86: istore_0
      //   87: ldc 69
      //   89: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_0
      //   93: ireturn
      //   94: astore_2
      //   95: aload_3
      //   96: iload_0
      //   97: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: ldc 69
      //   103: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: aload_2
      //   107: athrow
      //   108: ldc 69
      //   110: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   113: iload_0
      //   114: ireturn
      //   115: astore_2
      //   116: ldc 2
      //   118: invokevirtual 51	java/lang/Object:hashCode	()I
      //   121: bipush 31
      //   123: iushr
      //   124: iconst_1
      //   125: ior
      //   126: istore_0
      //   127: aload_3
      //   128: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: astore_2
      //   132: iload_0
      //   133: ifeq +68 -> 201
      //   136: ldc 2
      //   138: invokevirtual 51	java/lang/Object:hashCode	()I
      //   141: istore_1
      //   142: iload_1
      //   143: bipush 31
      //   145: iushr
      //   146: iconst_1
      //   147: ior
      //   148: iconst_1
      //   149: ixor
      //   150: istore_0
      //   151: aload_3
      //   152: iconst_0
      //   153: aload_3
      //   154: invokevirtual 44	java/lang/StringBuilder:length	()I
      //   157: invokevirtual 48	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   160: pop
      //   161: aload_3
      //   162: iload_0
      //   163: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   166: pop
      //   167: aload_2
      //   168: aload_3
      //   169: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: invokestatic 58	com/tencent/mm/plugin/normsg/d/a:cX	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   175: iload_0
      //   176: invokestatic 77	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
      //   179: istore_0
      //   180: ldc 69
      //   182: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   185: iload_0
      //   186: ireturn
      //   187: astore_2
      //   188: aload_3
      //   189: iload_0
      //   190: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   193: pop
      //   194: ldc 69
      //   196: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   199: aload_2
      //   200: athrow
      //   201: ldc 69
      //   203: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   206: iload_0
      //   207: ireturn
      //   208: astore_2
      //   209: goto -21 -> 188
      //   212: astore_2
      //   213: goto -118 -> 95
      // Local variable table:
      //   start	length	slot	name	signature
      //   33	174	0	i	int
      //   48	98	1	j	int
      //   38	37	2	str1	String
      //   94	13	2	localObject1	Object
      //   115	1	2	localObject2	Object
      //   131	37	2	str2	String
      //   187	13	2	localObject3	Object
      //   208	1	2	localObject4	Object
      //   212	1	2	localObject5	Object
      //   12	177	3	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   43	49	94	finally
      //   13	23	115	finally
      //   136	142	187	finally
      //   151	161	208	finally
      //   58	68	212	finally
    }
    
    static boolean gub()
    {
      AppMethodBeat.i(149023);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(b.aRr("µ»¹²´´¤¯¼» ¹­¶µ°µº®"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cX(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149023);
          return true;
        }
        AppMethodBeat.o(149023);
      }
      return false;
    }
    
    public static boolean isEnabled()
    {
      AppMethodBeat.i(149020);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        localStringBuilder.append(b.aRr("´¼¸±µ«§®»º£¸¬µ¯±§­"));
        String str1;
        return false;
      }
      finally
      {
        String str2 = localStringBuilder.toString();
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append((c.class.hashCode() >>> 31 | 0x1) ^ 0x1);
        if (!localStringBuilder.toString().equals(a.cX(str2, localStringBuilder.toString())))
        {
          AppMethodBeat.o(149020);
          return true;
        }
        AppMethodBeat.o(149020);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.a
 * JD-Core Version:    0.7.0.1
 */