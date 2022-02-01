package com.tencent.mm.sdk.system;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class AndroidContextUtil
{
  private static final String TAG = "Luggage.AndroidContextUtil";
  
  public static Activity castActivityOrNull(Context paramContext)
  {
    AppMethodBeat.i(153458);
    for (;;)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(153458);
        return null;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = (Activity)paramContext;
        AppMethodBeat.o(153458);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == paramContext) {
        break;
      }
      paramContext = localContext;
    }
    AppMethodBeat.o(153458);
    return null;
  }
  
  public static void fixInputMethodManagerLeak(Context paramContext)
  {
    AppMethodBeat.i(153459);
    if (paramContext == null)
    {
      AppMethodBeat.o(153459);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(153459);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= 3) {
        break label161;
      }
      Object localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
      try
      {
        localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        ((Field)localObject1).setAccessible(true);
        Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject2 != null) && ((localObject2 instanceof View)))
        {
          localObject2 = (View)localObject2;
          if ((((View)localObject2).getContext() == paramContext) || (isContextReferencedByOtherContext(paramContext, ((View)localObject2).getContext()))) {
            ((Field)localObject1).set(localInputMethodManager, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.w("Luggage.AndroidContextUtil", "fixInputMethodManagerLeak %s", new Object[] { localThrowable.getMessage() });
        }
      }
      i += 1;
    }
    label161:
    AppMethodBeat.o(153459);
  }
  
  private static boolean isContextReferencedByOtherContext(Context paramContext1, Context paramContext2)
  {
    AppMethodBeat.i(210042);
    if (paramContext1 == paramContext2)
    {
      AppMethodBeat.o(210042);
      return true;
    }
    if ((paramContext2 instanceof ContextWrapper))
    {
      paramContext2 = ((ContextWrapper)paramContext2).getBaseContext();
      Context localContext;
      do
      {
        if (paramContext1 == paramContext2)
        {
          AppMethodBeat.o(210042);
          return true;
        }
        if (!(paramContext2 instanceof ContextWrapper)) {
          break;
        }
        localContext = ((ContextWrapper)paramContext2).getBaseContext();
        paramContext2 = localContext;
      } while (localContext != null);
      AppMethodBeat.o(210042);
      return false;
    }
    AppMethodBeat.o(210042);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.system.AndroidContextUtil
 * JD-Core Version:    0.7.0.1
 */