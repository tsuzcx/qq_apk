package com.tencent.mm.pluginguard;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.br.c.c;
import com.tencent.mm.br.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginguard/ActivityHookInstrumentation;", "Landroid/app/Instrumentation;", "mOriginalInstrumentation", "(Landroid/app/Instrumentation;)V", "curTime", "", "getCurTime", "()J", "setCurTime", "(J)V", "getMOriginalInstrumentation", "()Landroid/app/Instrumentation;", "setMOriginalInstrumentation", "pendingActivityNames", "", "", "copyAllFields", "", "emergencyRepair", "t", "", "execStartActivity", "Landroid/app/Instrumentation$ActivityResult;", "who", "Landroid/content/Context;", "contextThread", "Landroid/os/IBinder;", "token", "target", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "options", "Landroid/os/Bundle;", "newActivity", "clazz", "Ljava/lang/Class;", "context", "application", "Landroid/app/Application;", "info", "Landroid/content/pm/ActivityInfo;", "title", "", "parent", "id", "lastNonConfigurationInstance", "", "cl", "Ljava/lang/ClassLoader;", "className", "Companion", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ActivityHookInstrumentation
  extends Instrumentation
{
  public static final a XMU;
  private Instrumentation XMV;
  private final Set<String> XMW;
  
  static
  {
    AppMethodBeat.i(231875);
    XMU = new a((byte)0);
    AppMethodBeat.o(231875);
  }
  
  public ActivityHookInstrumentation(Instrumentation paramInstrumentation)
  {
    AppMethodBeat.i(231867);
    this.XMV = paramInstrumentation;
    this.XMW = ((Set)new LinkedHashSet());
    iGj();
    AppMethodBeat.o(231867);
  }
  
  private final void iGj()
  {
    AppMethodBeat.i(231872);
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    int k = arrayOfField.length - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(this.XMV);
      arrayOfField[i].set(this, localObject);
      if (j > k)
      {
        AppMethodBeat.o(231872);
        return;
      }
      i = j;
    }
  }
  
  public final Instrumentation.ActivityResult execStartActivity(Context paramContext, IBinder paramIBinder1, IBinder paramIBinder2, Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(231887);
    for (;;)
    {
      try
      {
        localObject1 = c.iPb();
        s.s(localObject1, "it");
        localObject2 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label548;
        }
        c.c localc = (c.c)((Iterator)localObject2).next();
        if (paramIntent == null)
        {
          localObject1 = "";
          if (localc.aR(paramContext, (String)localObject1))
          {
            i = 1;
            if (i != 0) {
              break label542;
            }
            localObject1 = c.iPc();
            s.s(localObject1, "it");
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label554;
            }
            if (!((c.d)((Iterator)localObject1).next()).intercept(paramContext, paramActivity, paramIntent, paramInt, paramBundle)) {
              continue;
            }
            i = 1;
            break label537;
            label148:
            if (i == 0) {
              continue;
            }
            paramContext = b.XMX;
            b.xW(0L);
            AppMethodBeat.o(231887);
            return null;
          }
        }
        else
        {
          localObject1 = paramIntent.getComponent();
          if (localObject1 == null)
          {
            localObject1 = "";
            continue;
          }
          str = ((ComponentName)localObject1).getClassName();
          localObject1 = str;
          if (str != null) {
            continue;
          }
          localObject1 = "";
          continue;
        }
        continue;
        localObject2 = this.XMW;
        if (paramIntent != null) {
          continue;
        }
        localObject1 = "";
      }
      finally
      {
        Object localObject2;
        if (!(paramContext instanceof InvocationTargetException)) {
          continue;
        }
        Log.printErrStackTrace("MicroMsg.ActivityHookInstrumentation", ((InvocationTargetException)paramContext).getTargetException(), "Guard ignore throwable", new Object[0]);
        paramContext = ((InvocationTargetException)paramContext).getTargetException();
        s.s(paramContext, "t.targetException");
        AppMethodBeat.o(231887);
        throw paramContext;
        Object localObject1 = paramIntent.getComponent();
        if (localObject1 != null) {
          continue;
        }
        localObject1 = "";
        continue;
        String str = ((ComponentName)localObject1).getClassName();
        localObject1 = str;
        if (str != null) {
          continue;
        }
        localObject1 = "";
        continue;
        paramContext = paramIntent.getComponent();
        if (paramContext != null) {
          continue;
        }
        paramContext = null;
        continue;
        paramContext = paramContext.getClassName();
        continue;
        Log.printErrStackTrace("MicroMsg.ActivityHookInstrumentation", paramContext, "emergencyRepair!!", new Object[0]);
        MultiProcessMMKV.getMMKV("activity_hook").encode("has_error", 2L);
        paramIBinder1 = b.XMX;
        b.avw(2);
        paramIBinder1 = b.XMX;
        b.xW(2L);
        AppMethodBeat.o(231887);
      }
      ((Set)localObject2).add(localObject1);
      paramIBinder1 = (Instrumentation.ActivityResult)Instrumentation.class.getDeclaredMethod("execStartActivity", new Class[] { Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class }).invoke(this.XMV, new Object[] { paramContext, paramIBinder1, paramIBinder2, paramActivity, paramIntent, Integer.valueOf(paramInt), paramBundle });
      paramContext = b.XMX;
      b.xW(0L);
      if (paramIntent == null)
      {
        paramContext = null;
        Log.i("MicroMsg.ActivityHookInstrumentation", s.X("success start ", paramContext));
        AppMethodBeat.o(231887);
        return paramIBinder1;
      }
      for (;;)
      {
        label537:
        if (i == 0) {
          break label560;
        }
        label542:
        i = 1;
        break label148;
        label548:
        i = 0;
        break;
        label554:
        i = 0;
      }
      label560:
      int i = 0;
    }
  }
  
  public final Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    AppMethodBeat.i(231889);
    paramClass = this.XMV.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
    s.s(paramClass, "mOriginalInstrumentation…urationInstance\n        )");
    AppMethodBeat.o(231889);
    return paramClass;
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(231891);
    Object localObject;
    if (p.a((Iterable)this.XMW, paramString))
    {
      localObject = (Collection)this.XMW;
      if (localObject == null)
      {
        paramClassLoader = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(231891);
        throw paramClassLoader;
      }
      an.hA(localObject).remove(paramString);
      Log.i("MicroMsg.ActivityHookInstrumentation", "(%s)newActivity run after execStartActivity", new Object[] { paramString });
    }
    for (;;)
    {
      paramClassLoader = this.XMV.newActivity(paramClassLoader, paramString, paramIntent);
      s.s(paramClassLoader, "mOriginalInstrumentation…ty(cl, className, intent)");
      AppMethodBeat.o(231891);
      return paramClassLoader;
      localObject = b.XMX;
      b.avw(3);
      Log.e("MicroMsg.ActivityHookInstrumentation", "may newActivity without execStartActivity? pending:%s classname:%s", new Object[] { this.XMW.toString(), paramString });
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginguard/ActivityHookInstrumentation$Companion;", "", "()V", "TAG", "", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginguard.ActivityHookInstrumentation
 * JD-Core Version:    0.7.0.1
 */