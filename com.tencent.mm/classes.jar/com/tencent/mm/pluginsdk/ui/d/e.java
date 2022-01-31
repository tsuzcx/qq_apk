package com.tencent.mm.pluginsdk.ui.d;

import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private static int R(View paramView, int paramInt)
  {
    if ((paramView instanceof TextView))
    {
      if (((TextView)paramView).getLayout() == null) {
        return 0;
      }
      return ((TextView)paramView).getLayout().getLineEnd(paramInt);
    }
    if ((paramView instanceof StaticTextView))
    {
      if (((StaticTextView)paramView).getTvLayout() == null) {
        return 0;
      }
      return ((StaticTextView)paramView).getTvLayout().getLineEnd(paramInt);
    }
    return 0;
  }
  
  public static boolean a(View paramView, Spanned paramSpanned)
  {
    int i;
    if ((paramView != null) && (paramSpanned != null) && (((paramView instanceof TextView)) || ((paramView instanceof StaticTextView)))) {
      if ((paramView instanceof TextView)) {
        i = ((TextView)paramView).getLineCount();
      }
    }
    for (;;)
    {
      if ((i == 1) && (paramSpanned.length() > 500))
      {
        y.e("MicroMsg.InvalidTextCheck", "error black dot");
        return true;
        if ((paramView instanceof StaticTextView)) {
          i = ((StaticTextView)paramView).getLineCount();
        }
      }
      else
      {
        int j = 1;
        while (j < i)
        {
          if (R(paramView, j) - R(paramView, j - 1) > 500)
          {
            y.e("MicroMsg.InvalidTextCheck", "error black dot");
            return true;
          }
          j += 1;
        }
        return false;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.e
 * JD-Core Version:    0.7.0.1
 */