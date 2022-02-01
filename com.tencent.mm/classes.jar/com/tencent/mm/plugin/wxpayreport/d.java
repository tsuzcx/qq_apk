package com.tencent.mm.plugin.wxpayreport;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"findViewByKeyTagInternal", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "key", "", "tag", "", "depth", "findViewByKeyTag", "plugin-wxpay-report_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final View a(ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    AppMethodBeat.i(261074);
    s.u(paramViewGroup, "<this>");
    s.u(paramString, "tag");
    paramViewGroup = a(paramViewGroup, paramInt, paramString, 0);
    AppMethodBeat.o(261074);
    return paramViewGroup;
  }
  
  private static final View a(ViewGroup paramViewGroup, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(261083);
    if (paramInt2 > 200)
    {
      Log.w("ViewTookit", "over max recurrence");
      AppMethodBeat.o(261083);
      return null;
    }
    int k = paramViewGroup.getChildCount();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      if (localView != null)
      {
        if (s.p(localView.getTag(paramInt1), paramString))
        {
          AppMethodBeat.o(261083);
          return localView;
        }
        if ((localView instanceof ViewGroup))
        {
          localView = a((ViewGroup)localView, paramInt1, paramString, paramInt2 + 1);
          if (localView != null)
          {
            AppMethodBeat.o(261083);
            return localView;
          }
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(261083);
        return null;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.d
 * JD-Core Version:    0.7.0.1
 */