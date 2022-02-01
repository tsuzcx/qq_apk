package com.tencent.mm.sdk.f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;

public final class a
{
  public static void gx(Context paramContext)
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
    int j = 0;
    Object localObject1;
    if (j < 3) {
      localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[j];
    }
    label160:
    label216:
    label223:
    label230:
    label239:
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        Field localField = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        localField.setAccessible(true);
        localObject1 = localField.get(localInputMethodManager);
        if ((localObject1 == null) || (!(localObject1 instanceof View))) {
          break label223;
        }
        localObject1 = (View)localObject1;
        if (((View)localObject1).getContext() != paramContext)
        {
          localObject1 = ((View)localObject1).getContext();
          if (paramContext == localObject1)
          {
            i = 1;
            break label216;
          }
        }
        else
        {
          localField.set(localInputMethodManager, null);
          break label223;
        }
        if ((localObject1 instanceof ContextWrapper))
        {
          localObject2 = ((ContextWrapper)localObject1).getBaseContext();
          break label230;
          if ((localObject2 instanceof ContextWrapper))
          {
            localObject1 = ((ContextWrapper)localObject2).getBaseContext();
            localObject2 = localObject1;
            if (localObject1 != null) {
              break label230;
            }
          }
          i = 0;
        }
        else
        {
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("Luggage.AndroidContextUtil", localThrowable, "fixInputMethodManagerLeak", new Object[0]);
        break label223;
      }
      AppMethodBeat.o(153459);
      return;
      for (;;)
      {
        if (i != 0) {
          break label239;
        }
        j += 1;
        break;
        if (paramContext != localObject2) {
          break label160;
        }
        i = 1;
      }
    }
  }
  
  public static Activity jq(Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */