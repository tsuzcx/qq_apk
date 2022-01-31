package com.tencent.mrs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Printer;
import android.view.Choreographer;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.b.a;
import com.tencent.matrix.g.c.a;
import com.tencent.matrix.mrs.core.IReportCallback;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixReport.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mrs.b.b.1;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.sqlitelint.ISQLiteExecutionDelegate;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options.Builder;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static com.tencent.mrs.b.b Bad;
  private static b Bae = new b();
  
  private static boolean awp(String paramString)
  {
    boolean bool1;
    boolean bool2;
    SharedPreferences localSharedPreferences;
    if ((isDebug()) || (MatrixReport.with().isNeedReport(paramString)))
    {
      bool1 = true;
      bool2 = bool1;
      if (isDebug())
      {
        localSharedPreferences = ah.getContext().getSharedPreferences(ah.getContext().getPackageName() + "_preferences", 0);
        if (!paramString.equalsIgnoreCase("Trace_StartUp")) {
          break label117;
        }
        if (!localSharedPreferences.contains("startup_preference")) {
          break label95;
        }
        bool2 = localSharedPreferences.getBoolean("startup_preference", bool1);
      }
    }
    label95:
    label117:
    do
    {
      return bool2;
      bool1 = false;
      break;
      localSharedPreferences.edit().putBoolean("startup_preference", bool1).commit();
      return bool1;
      if (paramString.equalsIgnoreCase("Trace_EvilMethod"))
      {
        if (localSharedPreferences.contains("jank_preference")) {
          return localSharedPreferences.getBoolean("jank_preference", bool1);
        }
        localSharedPreferences.edit().putBoolean("jank_preference", bool1).commit();
        return bool1;
      }
      bool2 = bool1;
    } while (!paramString.equalsIgnoreCase("Trace_FPS"));
    if (localSharedPreferences.contains("fps_preference")) {
      return localSharedPreferences.getBoolean("fps_preference", bool1);
    }
    localSharedPreferences.edit().putBoolean("fps_preference", bool1).commit();
    return bool1;
  }
  
  private static SQLiteLintConfig dTl()
  {
    try
    {
      SQLiteLintConfig localSQLiteLintConfig = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
      return localSQLiteLintConfig;
    }
    catch (Throwable localThrowable) {}
    return new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
  }
  
  public static void dTm()
  {
    if (!MatrixReport.isInstalled())
    {
      com.tencent.matrix.g.c.e("Matrix.Manager", "setUin, matrix report is not installed, just return", new Object[0]);
      return;
    }
    com.tencent.matrix.g.c.i("Matrix.Manager", "matrix report set the uin", new Object[0]);
    Object localObject = MatrixReport.with();
    g.RJ();
    ((MatrixReport)localObject).setUin(com.tencent.mm.kernel.a.getUin());
    localObject = Bad;
    com.tencent.mm.sdk.g.d.ysm.execute(new b.1((com.tencent.mrs.b.b)localObject));
    MatrixReportBroadcast.dTn();
  }
  
  private static boolean isDebug()
  {
    return (com.tencent.mm.protocal.d.whL) || (bp.dud());
  }
  
  public static void k(Application paramApplication)
  {
    boolean bool4 = true;
    com.tencent.matrix.b.a(new c.a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void printErrStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.v(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        ab.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
      }
    });
    com.tencent.mrs.b.c localc = new com.tencent.mrs.b.c();
    com.tencent.matrix.g.c.i("Matrix.Manager", "Process:" + ah.getProcessName() + ", IS_RC_VERSION:" + com.tencent.mm.protocal.d.whI + ", isMonkeyEnv:" + bp.dsd(), new Object[0]);
    com.tencent.matrix.g.c.i("Matrix.Manager", "BuildInfo.ENABLE_MATRIX:" + com.tencent.mm.sdk.platformtools.f.ENABLE_MATRIX + ", ENABLE_MATRIX_TRACE:" + com.tencent.mm.sdk.platformtools.f.ENABLE_MATRIX_TRACE + ", BuildInfo.ENABLE_FPS_ANALYSE:" + com.tencent.mm.sdk.platformtools.f.ENABLE_FPS_ANALYSE, new Object[0]);
    boolean bool2;
    if (com.tencent.mm.sdk.platformtools.f.ENABLE_MATRIX)
    {
      bool1 = true;
      if ((!bool1) || (!com.tencent.mm.sdk.platformtools.f.ENABLE_MATRIX_TRACE)) {
        break label206;
      }
      bool2 = true;
      label140:
      if ((!bool1) || (!com.tencent.mm.sdk.platformtools.f.ENABLE_FPS_ANALYSE)) {
        break label211;
      }
    }
    label206:
    label211:
    for (boolean bool3 = true;; bool3 = false)
    {
      com.tencent.matrix.g.c.i("Matrix.Manager", "matrixEnable:" + bool1 + ", traceEnable:" + bool2 + ", fpsEnable:" + bool3, new Object[0]);
      if (bool1) {
        break label216;
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label140;
    }
    label216:
    com.tencent.matrix.g.b.isDebug = true;
    if ((ah.dsT()) && ((isDebug()) || (com.tencent.mm.protocal.d.whK))) {
      com.tencent.matrix.trace.core.a.bRi = new d();
    }
    com.tencent.matrix.g.c.i("Matrix.Manager", "try to init matrix report", new Object[0]);
    Object localObject1 = new MatrixReport.Builder(ah.getContext()).clientVersion(com.tencent.mm.protocal.d.whH).isDebug(bp.dsd()).revision(com.tencent.mm.sdk.platformtools.f.REV).processName(ah.getProcessName()).isReportProcess(ah.brt());
    long l;
    label312:
    Object localObject2;
    if (com.tencent.mm.protocal.d.whL)
    {
      l = 1L;
      localObject2 = ((MatrixReport.Builder)localObject1).publishType(l).build();
      MatrixReport.init((MatrixReport)localObject2, Bae);
      localObject1 = new b.a(paramApplication);
      if ((localObject2 != null) && (ah.dsT()))
      {
        localObject2 = new com.tencent.matrix.trace.a.a.a();
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bNO = localc;
        bool1 = awp("Trace_FPS");
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQT = bool1;
        bool1 = awp("Trace_EvilMethod");
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQU = bool1;
        bool1 = awp("Trace_StartUp");
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQV = bool1;
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQW = true;
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQY = "com.tencent.mm.app.WeChatSplashActivity;";
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.isDebug = true;
        ((com.tencent.matrix.trace.a.a.a)localObject2).bRa.bQX = false;
        ((b.a)localObject1).a(new com.tencent.matrix.trace.b(((com.tencent.matrix.trace.a.a.a)localObject2).bRa));
        localObject2 = ah.getContext().getSharedPreferences(ah.getContext().getPackageName() + "_preferences", 0);
        if (((SharedPreferences)localObject2).contains("fps_decorator_preference")) {
          if ((!((SharedPreferences)localObject2).getBoolean("fps_decorator_preference", false)) || (!isDebug())) {
            break label917;
          }
        }
      }
    }
    label917:
    for (boolean bool1 = bool4;; bool1 = false)
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          com.tencent.matrix.trace.view.a locala = com.tencent.matrix.trace.view.a.aB(ah.getContext());
          if (com.tencent.matrix.a.bLP.bLR) {
            locala.show();
          }
          if (this.Baf)
          {
            locala.bTw = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymous2View)
              {
                paramAnonymous2View = new Intent();
                paramAnonymous2View.setClassName(ah.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
                paramAnonymous2View.addFlags(67108864);
                paramAnonymous2View.addFlags(268435456);
                ah.getContext().startActivity(paramAnonymous2View);
              }
            };
            return;
          }
          locala.bTy = false;
        }
      });
      localObject2 = new com.tencent.matrix.resource.b.a.a();
      ((com.tencent.matrix.resource.b.a.a)localObject2).bNO = localc;
      ((com.tencent.matrix.resource.b.a.a)localObject2).bOX = bp.dsd();
      ((b.a)localObject1).a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(((com.tencent.matrix.resource.b.a.a)localObject2).bNO, ((com.tencent.matrix.resource.b.a.a)localObject2).bOX, ((com.tencent.matrix.resource.b.a.a)localObject2).bOY, (byte)0)));
      com.tencent.matrix.resource.b.a(paramApplication);
      localObject2 = new com.tencent.matrix.iocanary.a.a.a();
      ((com.tencent.matrix.iocanary.a.a.a)localObject2).bMc = localc;
      ((b.a)localObject1).a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(((com.tencent.matrix.iocanary.a.a.a)localObject2).bMc, (byte)0)));
      ((b.a)localObject1).a(new SQLiteLintPlugin(dTl()));
      if (ah.brt())
      {
        localObject2 = new com.tencent.matrix.c.a.a.a();
        ((com.tencent.matrix.c.a.a.a)localObject2).bNO = localc;
        ((b.a)localObject1).a(new com.tencent.matrix.c.a(new com.tencent.matrix.c.a.a(((com.tencent.matrix.c.a.a.a)localObject2).bNO, (byte)0)));
      }
      Bad = new com.tencent.mrs.b.b(paramApplication);
      ((b.a)localObject1).pluginListener = Bad;
      if (((b.a)localObject1).pluginListener == null) {
        ((b.a)localObject1).pluginListener = new com.tencent.matrix.d.a(((b.a)localObject1).application);
      }
      com.tencent.matrix.b.a(new com.tencent.matrix.b(((b.a)localObject1).application, ((b.a)localObject1).pluginListener, ((b.a)localObject1).bLY, (byte)0));
      MatrixReport.setAnrReportListener(new com.tencent.matrix.trace.a());
      paramApplication = com.tencent.matrix.b.yD().bLY.iterator();
      while (paramApplication.hasNext()) {
        ((com.tencent.matrix.d.b)paramApplication.next()).start();
      }
      break;
      if (com.tencent.mm.protocal.d.whK)
      {
        l = 2L;
        break label312;
      }
      if (com.tencent.mm.protocal.d.whI)
      {
        l = 3L;
        break label312;
      }
      if (com.tencent.mm.protocal.d.whJ)
      {
        l = 4L;
        break label312;
      }
      com.tencent.matrix.g.c.e("Matrix.Manager", "Error ClientVersion, ver:" + com.tencent.mm.protocal.d.whH, new Object[0]);
      l = -1L;
      break label312;
    }
  }
  
  public static void onDestroy()
  {
    if (!MatrixReport.isInstalled())
    {
      com.tencent.matrix.g.c.e("Matrix.Manager", "onDestroy, matrix report is not installed, just return", new Object[0]);
      return;
    }
    MatrixReport.with().onDestroy();
  }
  
  static final class a
    implements ISQLiteExecutionDelegate
  {
    private final SQLiteDatabase mDb;
    
    a(SQLiteDatabase paramSQLiteDatabase)
    {
      this.mDb = paramSQLiteDatabase;
    }
    
    public final void execSQL(String paramString)
    {
      if (!this.mDb.isOpen())
      {
        ab.w("Matrix.Manager", "rawQuery db close", new Object[0]);
        return;
      }
      this.mDb.execSQL(paramString);
    }
    
    public final Cursor rawQuery(String paramString, String... paramVarArgs)
    {
      if (!this.mDb.isOpen())
      {
        ab.w("Matrix.Manager", "rawQuery db close", new Object[0]);
        return null;
      }
      return this.mDb.rawQuery(paramString, paramVarArgs);
    }
  }
  
  static final class b
    implements IReportCallback
  {
    public final void onStatusChanged(Map<String, Boolean> paramMap)
    {
      Iterator localIterator1 = paramMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        String str1 = (String)localIterator1.next();
        boolean bool = ((Boolean)paramMap.get(str1)).booleanValue();
        Iterator localIterator2 = com.tencent.matrix.b.yD().bLY.iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = (com.tencent.matrix.d.b)localIterator2.next();
          if (localObject == null)
          {
            ab.e("Matrix.Manager", "plugin is null");
          }
          else if ((((com.tencent.matrix.d.b)localObject).getTag().equals("Trace")) && (str1.startsWith("Trace")))
          {
            localObject = (com.tencent.matrix.trace.b)localObject;
            if (localObject == null)
            {
              ab.e("Matrix.Manager", "change plugin to tracePlugin fail");
            }
            else
            {
              int i = -1;
              switch (str1.hashCode())
              {
              default: 
                switch (i)
                {
                default: 
                  label184:
                  localObject = null;
                }
                break;
              }
              while (localObject != null)
              {
                if (bool) {
                  break label337;
                }
                ab.i("Matrix.Manager", "%s#onCloseTrace", new Object[] { str1 });
                ((com.tencent.matrix.trace.f.f)localObject).zB();
                if (!(localObject instanceof com.tencent.matrix.trace.f.b)) {
                  break;
                }
                com.tencent.matrix.trace.b.zr().onStop();
                break;
                if (!str1.equals("Trace_StartUp")) {
                  break label184;
                }
                i = 0;
                break label184;
                if (!str1.equals("Trace_EvilMethod")) {
                  break label184;
                }
                i = 1;
                break label184;
                if (!str1.equals("Trace_FPS")) {
                  break label184;
                }
                i = 2;
                break label184;
                localObject = ((com.tencent.matrix.trace.b)localObject).bQP;
                continue;
                localObject = ((com.tencent.matrix.trace.b)localObject).bQO;
                continue;
                localObject = ((com.tencent.matrix.trace.b)localObject).bQQ;
              }
              label337:
              ab.i("Matrix.Manager", "%s#onStartTrace", new Object[] { str1 });
              if ((localObject instanceof com.tencent.matrix.trace.f.b)) {
                com.tencent.matrix.trace.b.zr().onStart();
              }
              ((com.tencent.matrix.trace.f.f)localObject).zA();
            }
          }
          else
          {
            String str2 = ((com.tencent.matrix.d.b)localObject).getTag();
            if (str2.equals(str1)) {
              if ((((com.tencent.matrix.d.b)localObject).isPluginStarted()) && (!bool))
              {
                ab.i("Matrix.Manager", "%sPlugin#onStop", new Object[] { str2 });
                ((com.tencent.matrix.d.b)localObject).stop();
              }
              else if ((((com.tencent.matrix.d.b)localObject).isPluginStopped()) && (bool))
              {
                ab.i("Matrix.Manager", "%sPlugin#onStart", new Object[] { str2 });
                ((com.tencent.matrix.d.b)localObject).start();
              }
            }
          }
        }
      }
    }
  }
  
  public static final class c
  {
    private static Map<String, Boolean> Bah = new HashMap();
    private static SQLiteLintPlugin Bai;
    
    public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong)
    {
      if (!com.tencent.matrix.b.isInstalled()) {}
      do
      {
        do
        {
          return;
          if (Bai != null) {
            break;
          }
          localObject1 = (SQLiteLintPlugin)com.tencent.matrix.b.yD().z(SQLiteLintPlugin.class);
          Bai = (SQLiteLintPlugin)localObject1;
        } while (localObject1 == null);
      } while (!Bai.isPluginStarted());
      ab.v("Matrix.Manager", "onSQLExecuted  String sql:%s,  timeCost:%d", new Object[] { paramString, Long.valueOf(paramLong) });
      Object localObject1 = paramSQLiteDatabase.getPath();
      Object localObject2;
      if (!Bah.containsKey(localObject1))
      {
        paramSQLiteDatabase = new SQLiteLint.InstallEnv((String)localObject1, new a.a(paramSQLiteDatabase));
        localObject2 = new SQLiteLint.Options.Builder();
        ((SQLiteLint.Options.Builder)localObject2).setReportBehaviour(true);
        ((SQLiteLint.Options.Builder)localObject2).setAlertBehaviour(false);
        paramSQLiteDatabase = new SQLiteLintConfig.ConcernDb(paramSQLiteDatabase, ((SQLiteLint.Options.Builder)localObject2).build());
        paramSQLiteDatabase.enableAvoidAutoIncrementChecker();
        paramSQLiteDatabase.enableAvoidSelectAllChecker();
        paramSQLiteDatabase.enableExplainQueryPlanChecker();
        paramSQLiteDatabase.enableRedundantIndexChecker();
        paramSQLiteDatabase.enableWithoutRowIdBetterChecker();
        paramSQLiteDatabase.enablePreparedStatementBetterChecker();
        localObject2 = paramSQLiteDatabase.getInstallEnv().getConcernedDbPath();
        if (!((String)localObject2).endsWith("EnMicroMsg.db")) {
          break label230;
        }
        paramSQLiteDatabase.setWhiteListXml(2131165233);
      }
      for (;;)
      {
        Bai.addConcernedDB(paramSQLiteDatabase);
        Bah.put(localObject1, Boolean.TRUE);
        Bai.notifySqlExecution((String)localObject1, paramString, (int)paramLong);
        return;
        label230:
        if (((String)localObject2).endsWith("AppBrandComm.db")) {
          paramSQLiteDatabase.setWhiteListXml(2131165192);
        } else if (((String)localObject2).endsWith("SnsMicroMsg.db")) {
          paramSQLiteDatabase.setWhiteListXml(2131165301);
        }
      }
    }
  }
  
  static final class d
    implements Printer
  {
    int Baj = 0;
    private Object[] bRu;
    long fnj = 0L;
    int limit = 1000;
    
    private static boolean b(Object paramObject, StringBuilder paramStringBuilder)
    {
      long l2 = SystemClock.uptimeMillis();
      boolean bool2 = false;
      if (paramObject != null)
      {
        Object localObject1 = e(paramObject, "action");
        Object localObject2 = e(paramObject, "dueTime");
        long l1 = 1L + l2;
        if (localObject2 != null) {
          l1 = ((Long)localObject2).longValue();
        }
        boolean bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (l1 <= l2)
          {
            bool2 = true;
            localObject2 = localObject1.getClass().getName();
            if ((localObject1 instanceof AnimationDrawable))
            {
              paramStringBuilder.append(((AnimationDrawable)localObject1).getCurrent().getCallback());
              bool1 = true;
            }
          }
        }
        for (;;)
        {
          paramObject = e(paramObject, "next");
          bool2 = bool1;
          break;
          bool1 = bool2;
          if (((String)localObject2).contains("InvalidateOnAnimationRunnable"))
          {
            bool1 = bool2;
            if ((localObject1 instanceof Runnable))
            {
              paramStringBuilder.append(e(localObject1, "mViews"));
              bool1 = bool2;
            }
          }
        }
      }
      return bool2;
    }
    
    private static <T> T e(Object paramObject, String paramString)
    {
      Class localClass = paramObject.getClass();
      while (localClass != null) {
        try
        {
          Object localObject = localClass.getDeclaredField(paramString);
          ((Field)localObject).setAccessible(true);
          localObject = ((Field)localObject).get(paramObject);
          return localObject;
        }
        catch (Exception localException)
        {
          localClass = localClass.getSuperclass();
        }
      }
      return null;
    }
    
    private static List e(StringBuilder paramStringBuilder)
    {
      LinkedList localLinkedList = new LinkedList();
      for (;;)
      {
        Object localObject1;
        ArrayList localArrayList;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        try
        {
          localObject1 = Class.forName("android.animation.AnimationHandler").getDeclaredMethod("getInstance", null);
          ((Method)localObject1).setAccessible(true);
          localArrayList = (ArrayList)e(((Method)localObject1).invoke(null, new Object[0]), "mAnimationCallbacks");
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            paramStringBuilder.append("\n\tAnimationHandler-> [");
            Iterator localIterator = localArrayList.iterator();
            int i = 3;
            if (localIterator.hasNext())
            {
              localObject2 = localIterator.next();
              if ((localObject2 instanceof ValueAnimator))
              {
                localObject1 = (List)e(localObject2, "mUpdateListeners");
                if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
                {
                  localObject3 = e(((List)localObject1).get(0), "this$0");
                  localObject4 = (View)e(localObject3, "mView");
                  if (localObject4 == null) {
                    break label633;
                  }
                  localObject1 = ((View)localObject4).toString();
                  paramStringBuilder.append("class:").append(localObject3.getClass().getName()).append(" Context:").append(((View)localObject4).getContext()).append(" mView:").append((String)localObject1).append(",");
                  localLinkedList.add(localObject2);
                  if (i <= 0) {
                    break label607;
                  }
                  i -= 1;
                  continue;
                  label224:
                  paramStringBuilder.append(localObject1);
                  continue;
                  localObject1 = localObject3.getClass().getName();
                }
              }
            }
          }
        }
        catch (Exception paramStringBuilder)
        {
          com.tencent.matrix.g.c.e("Matrix.Manager", paramStringBuilder.toString(), new Object[0]);
          return null;
        }
        label607:
        label633:
        do
        {
          break label224;
          if ((localObject2 instanceof ObjectAnimator))
          {
            localObject1 = ((ObjectAnimator)localObject2).getTarget();
            if ((localObject1 instanceof Drawable))
            {
              localObject1 = ((Drawable)localObject2).getCallback();
              if ((localObject1 != null) && ((localObject1 instanceof View)))
              {
                localObject3 = (View)localObject1;
                localObject4 = ((View)localObject3).toString();
                paramStringBuilder.append("class:").append(localObject1.getClass().getName()).append(" Context:").append(((View)localObject3).getContext()).append(" mView:").append(((String)localObject4).substring(((String)localObject4).indexOf("/") + 1)).append(",");
                break;
              }
              if (localObject1 != null)
              {
                paramStringBuilder.append("class:").append(localObject1.getClass().getName());
                break;
              }
              paramStringBuilder.append("class:@null");
              break;
            }
            paramStringBuilder.append(localObject1);
            break;
          }
          paramStringBuilder.append(localObject2);
          break;
          if (localObject2.getClass().getSimpleName().startsWith("android.view.ViewRootImpl"))
          {
            paramStringBuilder.append(e(localObject2, "mViews"));
            break;
          }
          if ((localObject2 instanceof Drawable))
          {
            localObject1 = ((Drawable)localObject2).getCallback();
            if ((localObject1 != null) && ((localObject1 instanceof View)))
            {
              localObject3 = (View)localObject1;
              localObject4 = ((View)localObject3).toString();
              paramStringBuilder.append("class:").append(localObject1.getClass().getName()).append(" Context:").append(((View)localObject3).getContext()).append(" mView:").append(((String)localObject4).substring(((String)localObject4).indexOf("/") + 1)).append(",");
              break;
            }
            if (localObject1 != null)
            {
              paramStringBuilder.append("class:").append(localObject1.getClass().getName());
              break;
            }
            paramStringBuilder.append("class:@null");
            break;
          }
          paramStringBuilder.append(localObject2);
          break;
          if (localArrayList.size() > 6) {
            paramStringBuilder.append("...");
          }
          paramStringBuilder.append("]");
          return localLinkedList;
        } while (localObject3 != null);
      }
    }
    
    public final void println(String paramString)
    {
      if (0L == this.fnj) {
        this.fnj = SystemClock.uptimeMillis();
      }
      StringBuilder localStringBuilder;
      if ((!AppForegroundDelegate.bXk.bLR) && (paramString.charAt(0) == '>'))
      {
        localStringBuilder = new StringBuilder(paramString);
        if (!paramString.contains("FrameHandler")) {
          break label300;
        }
        paramString = localStringBuilder.append(" callbacks:");
        if (this.bRu == null) {
          this.bRu = ((Object[])e(Choreographer.getInstance(), "mCallbackQueues"));
        }
        paramString.append("\n");
        Object localObject = e(this.bRu[0], "mHead");
        paramString.append("CALLBACK_INPUT->");
        b(localObject, paramString);
        paramString.append("\n");
        localObject = e(this.bRu[1], "mHead");
        paramString.append("CALLBACK_ANIMATION->");
        if (b(localObject, paramString))
        {
          localObject = e(paramString);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            this.limit -= 1;
          }
        }
        paramString.append("\n");
        localObject = e(this.bRu[2], "mHead");
        paramString.append("CALLBACK_TRAVERSAL->");
        b(localObject, paramString);
      }
      for (;;)
      {
        com.tencent.matrix.g.c.i("Matrix.Manager", localStringBuilder.toString(), new Object[0]);
        if (!AppForegroundDelegate.bXk.bLR) {
          return;
        }
        long l = SystemClock.uptimeMillis() - this.fnj;
        if ((l < 30000L) || (this.Baj < l / 17L / 3L)) {
          break;
        }
        throw new RuntimeException("后台耗电异常2");
        label300:
        this.Baj += 1;
      }
      if (this.limit <= 0) {
        throw new RuntimeException("后台耗电异常1");
      }
      this.limit = 1000;
      this.Baj = 0;
      this.fnj = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a
 * JD-Core Version:    0.7.0.1
 */