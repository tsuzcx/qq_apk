package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public class b
  implements d
{
  protected static boolean d(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(206088);
    Layout localLayout = paramCustomTextView.getLayout();
    int k = paramCustomTextView.getScrollY();
    int j = localLayout.getLineForVertical(k);
    int i = j;
    if (localLayout.getLineTop(j) == k) {
      i = j - 1;
    }
    if (i >= 0)
    {
      paramInt = Math.max(i - paramInt + 1, 0);
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(paramInt));
      AppMethodBeat.o(206088);
      return true;
    }
    AppMethodBeat.o(206088);
    return false;
  }
  
  static int e(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206079);
    int i = paramCustomTextView.getLayout().getLineForVertical(paramCustomTextView.getScrollY());
    AppMethodBeat.o(206079);
    return i;
  }
  
  protected static boolean e(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(206089);
    Layout localLayout = paramCustomTextView.getLayout();
    int k = h(paramCustomTextView);
    int m = paramCustomTextView.getScrollY() + k;
    int j = localLayout.getLineForVertical(m);
    int i = j;
    if (localLayout.getLineTop(j + 1) < m + 1) {
      i = j + 1;
    }
    j = localLayout.getLineCount() - 1;
    if (i <= j)
    {
      paramInt = Math.min(i + paramInt - 1, j);
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(paramInt + 1) - k);
      AppMethodBeat.o(206089);
      return true;
    }
    AppMethodBeat.o(206089);
    return false;
  }
  
  static int f(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206080);
    int i = paramCustomTextView.getLayout().getLineForVertical(paramCustomTextView.getScrollY() + h(paramCustomTextView));
    AppMethodBeat.o(206080);
    return i;
  }
  
  static int g(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206081);
    int i = paramCustomTextView.getWidth();
    int j = paramCustomTextView.getTotalPaddingLeft();
    int k = paramCustomTextView.getTotalPaddingRight();
    AppMethodBeat.o(206081);
    return i - j - k;
  }
  
  private static int getMovementMetaState(Spannable paramSpannable, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206077);
    int i = KeyEvent.normalizeMetaState(MetaKeyKeyListener.getMetaState(paramSpannable, paramKeyEvent) & 0xFFFFF9FF);
    AppMethodBeat.o(206077);
    return i & 0xFFFFFF3E;
  }
  
  static int h(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206082);
    int i = paramCustomTextView.getHeight();
    int j = paramCustomTextView.getTotalPaddingTop();
    int k = paramCustomTextView.getTotalPaddingBottom();
    AppMethodBeat.o(206082);
    return i - j - k;
  }
  
  private static int i(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206083);
    int i = (int)Math.ceil(paramCustomTextView.getPaint().getFontSpacing());
    AppMethodBeat.o(206083);
    return i;
  }
  
  static int j(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206084);
    Layout localLayout = paramCustomTextView.getLayout();
    int j = e(paramCustomTextView);
    int m = f(paramCustomTextView);
    if (j > m)
    {
      AppMethodBeat.o(206084);
      return 0;
    }
    int i = 2147483647;
    if (j <= m)
    {
      int k = (int)Math.floor(localLayout.getLineLeft(j));
      if (k >= i) {
        break label77;
      }
      i = k;
    }
    label77:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(206084);
      return i;
    }
  }
  
  static int k(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206085);
    Layout localLayout = paramCustomTextView.getLayout();
    int j = e(paramCustomTextView);
    int m = f(paramCustomTextView);
    if (j > m)
    {
      AppMethodBeat.o(206085);
      return 0;
    }
    int i = -2147483648;
    if (j <= m)
    {
      int k = (int)Math.ceil(localLayout.getLineRight(j));
      if (k <= i) {
        break label77;
      }
      i = k;
    }
    label77:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(206085);
      return i;
    }
  }
  
  public void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt) {}
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206078);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    AppMethodBeat.o(206078);
                    return false;
                    if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                    {
                      bool = a(paramCustomTextView, paramSpannable);
                      AppMethodBeat.o(206078);
                      return bool;
                    }
                    if (KeyEvent.metaStateHasModifiers(paramInt2, 4096))
                    {
                      AppMethodBeat.o(206078);
                      return false;
                    }
                  } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
                  bool = i(paramCustomTextView, paramSpannable);
                  AppMethodBeat.o(206078);
                  return bool;
                  if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                  {
                    bool = b(paramCustomTextView, paramSpannable);
                    AppMethodBeat.o(206078);
                    return bool;
                  }
                  if (KeyEvent.metaStateHasModifiers(paramInt2, 4096))
                  {
                    AppMethodBeat.o(206078);
                    return false;
                  }
                } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
                bool = j(paramCustomTextView, paramSpannable);
                AppMethodBeat.o(206078);
                return bool;
                if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                {
                  bool = c(paramCustomTextView, paramSpannable);
                  AppMethodBeat.o(206078);
                  return bool;
                }
              } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
              bool = g(paramCustomTextView, paramSpannable);
              AppMethodBeat.o(206078);
              return bool;
              if (KeyEvent.metaStateHasNoModifiers(paramInt2))
              {
                bool = d(paramCustomTextView, paramSpannable);
                AppMethodBeat.o(206078);
                return bool;
              }
            } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
            bool = h(paramCustomTextView, paramSpannable);
            AppMethodBeat.o(206078);
            return bool;
            if (KeyEvent.metaStateHasNoModifiers(paramInt2))
            {
              bool = e(paramCustomTextView, paramSpannable);
              AppMethodBeat.o(206078);
              return bool;
            }
          } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
          bool = g(paramCustomTextView, paramSpannable);
          AppMethodBeat.o(206078);
          return bool;
          if (KeyEvent.metaStateHasNoModifiers(paramInt2))
          {
            bool = f(paramCustomTextView, paramSpannable);
            AppMethodBeat.o(206078);
            return bool;
          }
        } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
        bool = h(paramCustomTextView, paramSpannable);
        AppMethodBeat.o(206078);
        return bool;
        if (KeyEvent.metaStateHasNoModifiers(paramInt2))
        {
          bool = k(paramCustomTextView, paramSpannable);
          AppMethodBeat.o(206078);
          return bool;
        }
      } while (!KeyEvent.metaStateHasModifiers(paramInt2, 4096));
      bool = g(paramCustomTextView, paramSpannable);
      AppMethodBeat.o(206078);
      return bool;
      if (KeyEvent.metaStateHasNoModifiers(paramInt2))
      {
        bool = l(paramCustomTextView, paramSpannable);
        AppMethodBeat.o(206078);
        return bool;
      }
    } while (!KeyEvent.metaStateHasModifiers(paramInt2, 4096));
    boolean bool = h(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(206078);
    return bool;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206074);
    boolean bool = a(paramCustomTextView, paramSpannable, paramInt, getMovementMetaState(paramSpannable, paramKeyEvent), paramKeyEvent);
    if (bool)
    {
      MetaKeyKeyListener.adjustMetaAfterKeypress(paramSpannable);
      com.tencent.mm.ui.widget.cedit.util.d.resetLockedMeta(paramSpannable);
    }
    AppMethodBeat.o(206074);
    return bool;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206075);
    int j = getMovementMetaState(paramSpannable, paramKeyEvent);
    int k = paramKeyEvent.getKeyCode();
    if ((k != 0) && (paramKeyEvent.getAction() == 2))
    {
      int m = paramKeyEvent.getRepeatCount();
      int i = 0;
      boolean bool = false;
      while ((i < m) && (a(paramCustomTextView, paramSpannable, k, j, paramKeyEvent)))
      {
        bool = true;
        i += 1;
      }
      if (bool)
      {
        MetaKeyKeyListener.adjustMetaAfterKeypress(paramSpannable);
        com.tencent.mm.ui.widget.cedit.util.d.resetLockedMeta(paramSpannable);
      }
      AppMethodBeat.o(206075);
      return bool;
    }
    AppMethodBeat.o(206075);
    return false;
  }
  
  public boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(206076);
    if ((paramMotionEvent.getSource() & 0x2) != 0) {}
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(206076);
      return false;
    }
    float f2;
    float f1;
    label90:
    boolean bool2;
    if ((paramMotionEvent.getMetaState() & 0x1) != 0)
    {
      f2 = paramMotionEvent.getAxisValue(9);
      f1 = 0.0F;
      if (f2 >= 0.0F) {
        break label139;
      }
      bool1 = b(paramCustomTextView, (int)Math.ceil(-f2)) | false;
      if (f1 >= 0.0F) {
        break label165;
      }
      bool2 = bool1 | d(paramCustomTextView, (int)Math.ceil(-f1));
    }
    for (;;)
    {
      AppMethodBeat.o(206076);
      return bool2;
      f1 = -paramMotionEvent.getAxisValue(9);
      f2 = paramMotionEvent.getAxisValue(10);
      break;
      label139:
      if (f2 <= 0.0F) {
        break label90;
      }
      bool1 = c(paramCustomTextView, (int)Math.ceil(f2)) | false;
      break label90;
      label165:
      bool2 = bool1;
      if (f1 > 0.0F) {
        bool2 = bool1 | e(paramCustomTextView, (int)Math.ceil(f1));
      }
    }
  }
  
  protected final boolean b(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(206086);
    int i = j(paramCustomTextView);
    int j = paramCustomTextView.getScrollX();
    if (j > i)
    {
      paramCustomTextView.scrollTo(Math.max(j - i(paramCustomTextView) * paramInt, i), paramCustomTextView.getScrollY());
      AppMethodBeat.o(206086);
      return true;
    }
    AppMethodBeat.o(206086);
    return false;
  }
  
  protected boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected final boolean c(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(206087);
    int i = k(paramCustomTextView) - g(paramCustomTextView);
    int j = paramCustomTextView.getScrollX();
    if (j < i)
    {
      paramCustomTextView.scrollTo(Math.min(j + i(paramCustomTextView) * paramInt, i), paramCustomTextView.getScrollY());
      AppMethodBeat.o(206087);
      return true;
    }
    AppMethodBeat.o(206087);
    return false;
  }
  
  protected boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  public boolean canSelectArbitrarily()
  {
    return false;
  }
  
  protected boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean e(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean f(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean g(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean h(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean i(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  public void j(Spannable paramSpannable) {}
  
  protected boolean j(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean k(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean l(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.b
 * JD-Core Version:    0.7.0.1
 */