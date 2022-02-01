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
  private static int a(Spannable paramSpannable, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252089);
    int i = KeyEvent.normalizeMetaState(MetaKeyKeyListener.getMetaState(paramSpannable, paramKeyEvent) & 0xFFFFF9FF);
    AppMethodBeat.o(252089);
    return i & 0xFFFFFF3E;
  }
  
  protected static boolean d(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(252151);
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
      AppMethodBeat.o(252151);
      return true;
    }
    AppMethodBeat.o(252151);
    return false;
  }
  
  private static int e(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252093);
    int i = paramCustomTextView.getLayout().getLineForVertical(paramCustomTextView.getScrollY());
    AppMethodBeat.o(252093);
    return i;
  }
  
  protected static boolean e(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(252161);
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
      AppMethodBeat.o(252161);
      return true;
    }
    AppMethodBeat.o(252161);
    return false;
  }
  
  private static int f(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252101);
    int i = paramCustomTextView.getLayout().getLineForVertical(paramCustomTextView.getScrollY() + h(paramCustomTextView));
    AppMethodBeat.o(252101);
    return i;
  }
  
  private static int g(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252108);
    int i = paramCustomTextView.getWidth();
    int j = paramCustomTextView.getTotalPaddingLeft();
    int k = paramCustomTextView.getTotalPaddingRight();
    AppMethodBeat.o(252108);
    return i - j - k;
  }
  
  private static int h(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252117);
    int i = paramCustomTextView.getHeight();
    int j = paramCustomTextView.getTotalPaddingTop();
    int k = paramCustomTextView.getTotalPaddingBottom();
    AppMethodBeat.o(252117);
    return i - j - k;
  }
  
  private static int i(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252125);
    int i = (int)Math.ceil(paramCustomTextView.getPaint().getFontSpacing());
    AppMethodBeat.o(252125);
    return i;
  }
  
  private static int j(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252132);
    Layout localLayout = paramCustomTextView.getLayout();
    int j = e(paramCustomTextView);
    int m = f(paramCustomTextView);
    if (j > m)
    {
      AppMethodBeat.o(252132);
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
      AppMethodBeat.o(252132);
      return i;
    }
  }
  
  private static int k(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252141);
    Layout localLayout = paramCustomTextView.getLayout();
    int j = e(paramCustomTextView);
    int m = f(paramCustomTextView);
    if (j > m)
    {
      AppMethodBeat.o(252141);
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
      AppMethodBeat.o(252141);
      return i;
    }
  }
  
  protected static boolean l(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252170);
    Layout localLayout = paramCustomTextView.getLayout();
    int i = localLayout.getLineForVertical(paramCustomTextView.getScrollY() - h(paramCustomTextView));
    if (i >= 0)
    {
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(i));
      AppMethodBeat.o(252170);
      return true;
    }
    AppMethodBeat.o(252170);
    return false;
  }
  
  protected static boolean m(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252179);
    Layout localLayout = paramCustomTextView.getLayout();
    int i = h(paramCustomTextView);
    int j = localLayout.getLineForVertical(paramCustomTextView.getScrollY() + i + i);
    if (j <= localLayout.getLineCount() - 1)
    {
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(j + 1) - i);
      AppMethodBeat.o(252179);
      return true;
    }
    AppMethodBeat.o(252179);
    return false;
  }
  
  protected static boolean n(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252189);
    Layout localLayout = paramCustomTextView.getLayout();
    if (e(paramCustomTextView) >= 0)
    {
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(0));
      AppMethodBeat.o(252189);
      return true;
    }
    AppMethodBeat.o(252189);
    return false;
  }
  
  protected static boolean o(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252197);
    Layout localLayout = paramCustomTextView.getLayout();
    int i = localLayout.getLineCount();
    if (f(paramCustomTextView) <= i - 1)
    {
      f.a(paramCustomTextView, localLayout, paramCustomTextView.getScrollX(), localLayout.getLineTop(i) - h(paramCustomTextView));
      AppMethodBeat.o(252197);
      return true;
    }
    AppMethodBeat.o(252197);
    return false;
  }
  
  public void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt) {}
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252265);
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
                    AppMethodBeat.o(252265);
                    return false;
                    if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                    {
                      bool = a(paramCustomTextView, paramSpannable);
                      AppMethodBeat.o(252265);
                      return bool;
                    }
                    if (KeyEvent.metaStateHasModifiers(paramInt2, 4096))
                    {
                      bool = jHg();
                      AppMethodBeat.o(252265);
                      return bool;
                    }
                  } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
                  bool = i(paramCustomTextView, paramSpannable);
                  AppMethodBeat.o(252265);
                  return bool;
                  if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                  {
                    bool = b(paramCustomTextView, paramSpannable);
                    AppMethodBeat.o(252265);
                    return bool;
                  }
                  if (KeyEvent.metaStateHasModifiers(paramInt2, 4096))
                  {
                    bool = jHh();
                    AppMethodBeat.o(252265);
                    return bool;
                  }
                } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
                bool = j(paramCustomTextView, paramSpannable);
                AppMethodBeat.o(252265);
                return bool;
                if (KeyEvent.metaStateHasNoModifiers(paramInt2))
                {
                  bool = c(paramCustomTextView, paramSpannable);
                  AppMethodBeat.o(252265);
                  return bool;
                }
              } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
              bool = g(paramCustomTextView, paramSpannable);
              AppMethodBeat.o(252265);
              return bool;
              if (KeyEvent.metaStateHasNoModifiers(paramInt2))
              {
                bool = d(paramCustomTextView, paramSpannable);
                AppMethodBeat.o(252265);
                return bool;
              }
            } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
            bool = h(paramCustomTextView, paramSpannable);
            AppMethodBeat.o(252265);
            return bool;
            if (KeyEvent.metaStateHasNoModifiers(paramInt2))
            {
              bool = e(paramCustomTextView, paramSpannable);
              AppMethodBeat.o(252265);
              return bool;
            }
          } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
          bool = g(paramCustomTextView, paramSpannable);
          AppMethodBeat.o(252265);
          return bool;
          if (KeyEvent.metaStateHasNoModifiers(paramInt2))
          {
            bool = f(paramCustomTextView, paramSpannable);
            AppMethodBeat.o(252265);
            return bool;
          }
        } while (!KeyEvent.metaStateHasModifiers(paramInt2, 2));
        bool = h(paramCustomTextView, paramSpannable);
        AppMethodBeat.o(252265);
        return bool;
        if (KeyEvent.metaStateHasNoModifiers(paramInt2))
        {
          bool = k(paramCustomTextView, paramSpannable);
          AppMethodBeat.o(252265);
          return bool;
        }
      } while (!KeyEvent.metaStateHasModifiers(paramInt2, 4096));
      bool = g(paramCustomTextView, paramSpannable);
      AppMethodBeat.o(252265);
      return bool;
      if (KeyEvent.metaStateHasNoModifiers(paramInt2))
      {
        bool = l(paramCustomTextView, paramSpannable);
        AppMethodBeat.o(252265);
        return bool;
      }
    } while (!KeyEvent.metaStateHasModifiers(paramInt2, 4096));
    boolean bool = h(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(252265);
    return bool;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252217);
    boolean bool = a(paramCustomTextView, paramSpannable, paramInt, a(paramSpannable, paramKeyEvent), paramKeyEvent);
    if (bool)
    {
      MetaKeyKeyListener.adjustMetaAfterKeypress(paramSpannable);
      com.tencent.mm.ui.widget.cedit.util.d.k(paramSpannable);
    }
    AppMethodBeat.o(252217);
    return bool;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252224);
    int j = a(paramSpannable, paramKeyEvent);
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
        com.tencent.mm.ui.widget.cedit.util.d.k(paramSpannable);
      }
      AppMethodBeat.o(252224);
      return bool;
    }
    AppMethodBeat.o(252224);
    return false;
  }
  
  public boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    AppMethodBeat.i(252255);
    if ((paramMotionEvent.getSource() & 0x2) != 0) {}
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(252255);
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
      AppMethodBeat.o(252255);
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
    AppMethodBeat.i(252338);
    int i = j(paramCustomTextView);
    int j = paramCustomTextView.getScrollX();
    if (j > i)
    {
      paramCustomTextView.scrollTo(Math.max(j - i(paramCustomTextView) * paramInt, i), paramCustomTextView.getScrollY());
      AppMethodBeat.o(252338);
      return true;
    }
    AppMethodBeat.o(252338);
    return false;
  }
  
  protected boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    return false;
  }
  
  protected final boolean c(CustomTextView paramCustomTextView, int paramInt)
  {
    AppMethodBeat.i(252346);
    int i = k(paramCustomTextView) - g(paramCustomTextView);
    int j = paramCustomTextView.getScrollX();
    if (j < i)
    {
      paramCustomTextView.scrollTo(Math.min(j + i(paramCustomTextView) * paramInt, i), paramCustomTextView.getScrollY());
      AppMethodBeat.o(252346);
      return true;
    }
    AppMethodBeat.o(252346);
    return false;
  }
  
  protected boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
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
  
  protected boolean jHg()
  {
    return false;
  }
  
  protected boolean jHh()
  {
    return false;
  }
  
  public boolean jHi()
  {
    return false;
  }
  
  public final boolean jHk()
  {
    return false;
  }
  
  public final boolean jHl()
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
  
  protected final boolean p(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252350);
    int i = j(paramCustomTextView);
    if (paramCustomTextView.getScrollX() > i)
    {
      paramCustomTextView.scrollTo(i, paramCustomTextView.getScrollY());
      AppMethodBeat.o(252350);
      return true;
    }
    AppMethodBeat.o(252350);
    return false;
  }
  
  protected final boolean q(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252355);
    int i = k(paramCustomTextView) - g(paramCustomTextView);
    if (paramCustomTextView.getScrollX() < i)
    {
      paramCustomTextView.scrollTo(i, paramCustomTextView.getScrollY());
      AppMethodBeat.o(252355);
      return true;
    }
    AppMethodBeat.o(252355);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.b
 * JD-Core Version:    0.7.0.1
 */