package com.tencent.mm.pluginsdk.ui.span;

import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  public static boolean a(View paramView, Spanned paramSpanned)
  {
    AppMethodBeat.i(152267);
    if ((paramView != null) && (paramSpanned != null) && (((paramView instanceof TextView)) || ((paramView instanceof StaticTextView))))
    {
      int j = gp(paramView);
      if ((j == 1) && (paramSpanned.length() > 500))
      {
        Log.e("MicroMsg.InvalidTextCheck", "error black dot");
        AppMethodBeat.o(152267);
        return true;
      }
      int i = 1;
      while (i < j)
      {
        if (aD(paramView, i) - aD(paramView, i - 1) > 500)
        {
          Log.e("MicroMsg.InvalidTextCheck", "error black dot");
          AppMethodBeat.o(152267);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(152267);
    return false;
  }
  
  private static int aD(View paramView, int paramInt)
  {
    AppMethodBeat.i(152266);
    if ((paramView instanceof TextView))
    {
      if (((TextView)paramView).getLayout() == null)
      {
        AppMethodBeat.o(152266);
        return 0;
      }
      paramInt = ((TextView)paramView).getLayout().getLineEnd(paramInt);
      AppMethodBeat.o(152266);
      return paramInt;
    }
    if ((paramView instanceof StaticTextView))
    {
      if (((StaticTextView)paramView).getTvLayout() == null)
      {
        AppMethodBeat.o(152266);
        return 0;
      }
      paramInt = ((StaticTextView)paramView).getTvLayout().getLineEnd(paramInt);
      AppMethodBeat.o(152266);
      return paramInt;
    }
    AppMethodBeat.o(152266);
    return 0;
  }
  
  private static int gp(View paramView)
  {
    AppMethodBeat.i(152265);
    int i = 0;
    if ((paramView instanceof TextView)) {
      i = ((TextView)paramView).getLineCount();
    }
    for (;;)
    {
      AppMethodBeat.o(152265);
      return i;
      if ((paramView instanceof StaticTextView)) {
        i = ((StaticTextView)paramView).getLineCount();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.g
 * JD-Core Version:    0.7.0.1
 */