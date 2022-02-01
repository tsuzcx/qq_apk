package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneEventEmitter;
import com.tencent.tbs.one.TBSOneEventEmitter.UnloadedBehavior;
import com.tencent.tbs.one.TBSOneEventReceiver;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a;
import com.tencent.tbs.one.impl.common.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class b
  implements TBSOneEventEmitter
{
  private WeakReference<h> a;
  
  public b(h paramh)
  {
    AppMethodBeat.i(174141);
    this.a = new WeakReference(paramh);
    AppMethodBeat.o(174141);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(174139);
    f.b("Failed to emit event %s, reason: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(174139);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, Throwable paramThrowable)
  {
    AppMethodBeat.i(174140);
    f.b("Failed to emit event %s to %s#%s, reason: %s", new Object[] { paramString3, paramString1, paramString2, paramString4, paramThrowable });
    AppMethodBeat.o(174140);
  }
  
  private static void b(TBSOneComponent paramTBSOneComponent, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(174144);
    if (paramTBSOneComponent.getEntryClassLoader() == null) {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "no entry class loader found", null);
    }
    try
    {
      Class localClass = paramTBSOneComponent.getEntryClassLoader().loadClass(paramString1);
      if (TBSOneEventReceiver.class.isAssignableFrom(localClass))
      {
        ((TBSOneEventReceiver)localClass.getConstructor(new Class[0]).newInstance(new Object[0])).onReceive(paramString2, paramMap);
        AppMethodBeat.o(174144);
        return;
      }
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't assign receiver class to com.tencent.tbs.one.TBSOneEventReceiver", null);
      AppMethodBeat.o(174144);
      return;
    }
    catch (ClassNotFoundException paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't load event receiver class", paramMap);
      AppMethodBeat.o(174144);
      return;
    }
    catch (NoSuchMethodException paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't find constructor method for event receiver class", paramMap);
      AppMethodBeat.o(174144);
      return;
    }
    catch (Exception paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't construct event receiver object", paramMap);
      AppMethodBeat.o(174144);
    }
  }
  
  public final void emit(TBSOneEventEmitter.UnloadedBehavior paramUnloadedBehavior, final String paramString1, final String paramString2, final String paramString3, final Map<String, Object> paramMap)
  {
    AppMethodBeat.i(174142);
    final h localh = (h)this.a.get();
    if (localh == null)
    {
      a(paramString1, paramString2, paramString3, "TBSOneManager is not alive", null);
      AppMethodBeat.o(174142);
      return;
    }
    a locala = localh.e(paramString1);
    if (locala == null)
    {
      if (paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.IGNORE)
      {
        a(paramString1, paramString2, paramString3, "component is not loaded yet", null);
        AppMethodBeat.o(174142);
        return;
      }
      if ((paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.LOAD) && (localh.b(paramString1)))
      {
        a(paramString1, paramString2, paramString3, "component is not installed yet", null);
        AppMethodBeat.o(174142);
        return;
      }
      m.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(173959);
          localh.a(paramString1, null, new TBSOneCallback() {});
          AppMethodBeat.o(173959);
        }
      });
      AppMethodBeat.o(174142);
      return;
    }
    b(locala, paramString2, paramString3, paramMap);
    AppMethodBeat.o(174142);
  }
  
  public final void emit(String paramString, Map<String, Object> paramMap)
  {
    AppMethodBeat.i(174143);
    h localh = (h)this.a.get();
    if (localh == null)
    {
      a(paramString, "TBSOneManager is not alive");
      AppMethodBeat.o(174143);
      return;
    }
    Object localObject = (List)localh.k.get(paramString);
    if (localObject == null)
    {
      a(paramString, "no event receiver found");
      AppMethodBeat.o(174143);
      return;
    }
    localObject = ((List)localObject).listIterator();
    while (((ListIterator)localObject).hasNext())
    {
      g localg = (g)((ListIterator)localObject).next();
      b(localh.e(localg.a), localg.b, paramString, paramMap);
    }
    AppMethodBeat.o(174143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.b
 * JD-Core Version:    0.7.0.1
 */