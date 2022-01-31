package com.tencent.mm.pluginsdk.ui.d;

import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  public static boolean a(View paramView, Spanned paramSpanned)
  {
    AppMethodBeat.i(79811);
    if ((paramView != null) && (paramSpanned != null) && (((paramView instanceof TextView)) || ((paramView instanceof StaticTextView))))
    {
      int j = eF(paramView);
      if ((j == 1) && (paramSpanned.length() > 500))
      {
        ab.e("MicroMsg.InvalidTextCheck", "error black dot");
        AppMethodBeat.o(79811);
        return true;
      }
      int i = 1;
      while (i < j)
      {
        if (ak(paramView, i) - ak(paramView, i - 1) > 500)
        {
          ab.e("MicroMsg.InvalidTextCheck", "error black dot");
          AppMethodBeat.o(79811);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(79811);
    return false;
  }
  
  private static int ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(79810);
    if ((paramView instanceof TextView))
    {
      if (((TextView)paramView).getLayout() == null)
      {
        AppMethodBeat.o(79810);
        return 0;
      }
      paramInt = ((TextView)paramView).getLayout().getLineEnd(paramInt);
      AppMethodBeat.o(79810);
      return paramInt;
    }
    if ((paramView instanceof StaticTextView))
    {
      if (((StaticTextView)paramView).getTvLayout() == null)
      {
        AppMethodBeat.o(79810);
        return 0;
      }
      paramInt = ((StaticTextView)paramView).getTvLayout().getLineEnd(paramInt);
      AppMethodBeat.o(79810);
      return paramInt;
    }
    AppMethodBeat.o(79810);
    return 0;
  }
  
  private static int eF(View paramView)
  {
    AppMethodBeat.i(79809);
    int i = 0;
    if ((paramView instanceof TextView)) {
      i = ((TextView)paramView).getLineCount();
    }
    for (;;)
    {
      AppMethodBeat.o(79809);
      return i;
      if ((paramView instanceof StaticTextView)) {
        i = ((StaticTextView)paramView).getLineCount();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.e
 * JD-Core Version:    0.7.0.1
 */