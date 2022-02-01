package com.tencent.mm.ui.widget.cedit.b;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public final class a
  extends b
  implements d
{
  private static final Object QLK;
  private static a QLL;
  
  static
  {
    AppMethodBeat.i(206073);
    QLK = new Object();
    AppMethodBeat.o(206073);
  }
  
  private static int a(Spannable paramSpannable, Layout paramLayout)
  {
    AppMethodBeat.i(206054);
    int i = paramLayout.getLineTop(paramLayout.getLineForOffset(Selection.getSelectionEnd(paramSpannable)));
    AppMethodBeat.o(206054);
    return i;
  }
  
  private static int d(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(206055);
    Rect localRect = new Rect();
    if (paramCustomTextView.getGlobalVisibleRect(localRect))
    {
      int i = localRect.height();
      AppMethodBeat.o(206055);
      return i;
    }
    AppMethodBeat.o(206055);
    return 0;
  }
  
  public static d haX()
  {
    AppMethodBeat.i(206072);
    if (QLL == null) {
      QLL = new a();
    }
    a locala = QLL;
    AppMethodBeat.o(206072);
    return locala;
  }
  
  private static boolean i(Spannable paramSpannable)
  {
    AppMethodBeat.i(206053);
    if ((MetaKeyKeyListener.getMetaState(paramSpannable, 1) == 1) || (MetaKeyKeyListener.getMetaState(paramSpannable, 2048) != 0))
    {
      AppMethodBeat.o(206053);
      return true;
    }
    AppMethodBeat.o(206053);
    return false;
  }
  
  public final void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(206071);
    if (((paramInt & 0x82) == 0) || (paramCustomTextView.getLayout() == null)) {
      Selection.setSelection(paramSpannable, paramSpannable.length());
    }
    AppMethodBeat.o(206071);
  }
  
  protected final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206057);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendLeft(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206057);
      return bool;
    }
    boolean bool = Selection.moveLeft(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206057);
    return bool;
  }
  
  protected final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206056);
    switch (paramInt1)
    {
    }
    do
    {
      bool = super.a(paramCustomTextView, paramSpannable, paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(206056);
      return bool;
    } while ((!KeyEvent.metaStateHasNoModifiers(paramInt2)) || (paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0) || (MetaKeyKeyListener.getMetaState(paramSpannable, 2048, paramKeyEvent) == 0));
    boolean bool = paramCustomTextView.showContextMenu();
    AppMethodBeat.o(206056);
    return bool;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int j = -1;
    AppMethodBeat.i(206069);
    int k = paramMotionEvent.getAction();
    int i;
    if (k == 1)
    {
      f.a[] arrayOfa = (f.a[])paramSpannable.getSpans(0, paramSpannable.length(), f.a.class);
      if (arrayOfa.length > 0)
      {
        i = arrayOfa[0].ovp;
        arrayOfa = (f.a[])paramSpannable.getSpans(0, paramSpannable.length(), f.a.class);
        if (arrayOfa.length > 0) {
          j = arrayOfa[0].ovq;
        }
      }
    }
    for (;;)
    {
      boolean bool1 = i(paramSpannable);
      boolean bool2 = f.a(paramCustomTextView, paramSpannable, paramMotionEvent);
      if (paramCustomTextView.didTouchFocusSelect())
      {
        AppMethodBeat.o(206069);
        return bool2;
        i = -1;
        break;
      }
      if (k == 0) {
        if (i(paramSpannable))
        {
          if ((!paramCustomTextView.isFocused()) && (!paramCustomTextView.requestFocus()))
          {
            AppMethodBeat.o(206069);
            return bool2;
          }
          i = paramCustomTextView.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
          paramSpannable.setSpan(QLK, i, i, 34);
          paramCustomTextView.getParent().requestDisallowInterceptTouchEvent(true);
        }
      }
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(206069);
            return bool2;
          } while (!paramCustomTextView.isFocused());
          if (k != 2) {
            break;
          }
        } while ((!i(paramSpannable)) || (!bool2));
        i = paramSpannable.getSpanStart(QLK);
        paramCustomTextView.cancelLongPress();
        j = paramCustomTextView.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
        Selection.setSelection(paramSpannable, Math.min(i, j), Math.max(i, j));
        AppMethodBeat.o(206069);
        return true;
      } while (k != 1);
      int m;
      int n;
      int i1;
      int i2;
      if (((j >= 0) && (j != paramCustomTextView.getScrollY())) || ((i >= 0) && (i != paramCustomTextView.getScrollX()))) {
        if ((paramCustomTextView.mText instanceof Spannable))
        {
          m = paramCustomTextView.getSelectionStart();
          if (m == paramCustomTextView.getSelectionEnd())
          {
            j = paramCustomTextView.OVt.getLineForOffset(m);
            n = paramCustomTextView.OVt.getLineTop(j);
            i1 = paramCustomTextView.OVt.getLineTop(j + 1);
            i2 = paramCustomTextView.getBottom() - paramCustomTextView.getTop() - paramCustomTextView.getExtendedPaddingTop() - paramCustomTextView.getExtendedPaddingBottom();
            k = (i1 - n) / 2;
            i = k;
            if (k > i2 / 4) {
              i = i2 / 4;
            }
            k = paramCustomTextView.getScrollY();
            if (n >= k + i) {
              break label582;
            }
            i = paramCustomTextView.OVt.getLineForVertical(i + k + (i1 - n));
          }
        }
      }
      for (;;)
      {
        k = paramCustomTextView.getRight();
        n = paramCustomTextView.getLeft();
        i1 = paramCustomTextView.getCompoundPaddingLeft();
        i2 = paramCustomTextView.getCompoundPaddingRight();
        int i3 = paramCustomTextView.getScrollX();
        j = paramCustomTextView.OVt.getOffsetForHorizontal(i, i3);
        k = paramCustomTextView.OVt.getOffsetForHorizontal(i, k - n - i1 - i2 + i3);
        if (j < k)
        {
          i = j;
          label545:
          if (j <= k) {
            break label628;
          }
          label552:
          if (m >= i) {
            break label635;
          }
        }
        for (;;)
        {
          if (i != m) {
            Selection.setSelection(paramCustomTextView.QGC, i);
          }
          AppMethodBeat.o(206069);
          return true;
          label582:
          if (i1 <= i2 + k - i) {
            break label728;
          }
          i = paramCustomTextView.OVt.getLineForVertical(i2 + k - i - (i1 - n));
          break;
          i = k;
          break label545;
          label628:
          j = k;
          break label552;
          label635:
          if (m > j)
          {
            i = j;
            continue;
            if (bool1)
            {
              i = paramSpannable.getSpanStart(QLK);
              j = paramCustomTextView.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
              Selection.setSelection(paramSpannable, Math.min(i, j), Math.max(i, j));
              paramSpannable.removeSpan(QLK);
            }
            MetaKeyKeyListener.adjustMetaAfterKeypress(paramSpannable);
            com.tencent.mm.ui.widget.cedit.util.d.resetLockedMeta(paramSpannable);
            AppMethodBeat.o(206069);
            return true;
          }
          else
          {
            i = m;
          }
        }
        label728:
        i = j;
      }
      j = -1;
      i = -1;
    }
  }
  
  protected final boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206058);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendRight(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206058);
      return bool;
    }
    boolean bool = Selection.moveRight(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206058);
    return bool;
  }
  
  protected final boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206059);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendUp(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206059);
      return bool;
    }
    boolean bool = Selection.moveUp(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206059);
    return bool;
  }
  
  public final boolean canSelectArbitrarily()
  {
    return true;
  }
  
  protected final boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206060);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendDown(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206060);
      return bool;
    }
    boolean bool = Selection.moveDown(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206060);
    return bool;
  }
  
  protected final boolean e(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206061);
    Layout localLayout = paramCustomTextView.getLayout();
    boolean bool3 = i(paramSpannable);
    int i = a(paramSpannable, localLayout);
    int j = d(paramCustomTextView);
    boolean bool1 = false;
    int k = Selection.getSelectionEnd(paramSpannable);
    if (bool3) {
      Selection.extendUp(paramSpannable, localLayout);
    }
    for (;;)
    {
      if (Selection.getSelectionEnd(paramSpannable) != k)
      {
        boolean bool2 = true;
        bool1 = true;
        if (a(paramSpannable, localLayout) > i - j) {
          break;
        }
        bool1 = bool2;
      }
      AppMethodBeat.o(206061);
      return bool1;
      Selection.moveUp(paramSpannable, localLayout);
    }
  }
  
  protected final boolean f(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206062);
    Layout localLayout = paramCustomTextView.getLayout();
    boolean bool3 = i(paramSpannable);
    int i = a(paramSpannable, localLayout);
    int j = d(paramCustomTextView);
    boolean bool1 = false;
    int k = Selection.getSelectionEnd(paramSpannable);
    if (bool3) {
      Selection.extendDown(paramSpannable, localLayout);
    }
    for (;;)
    {
      if (Selection.getSelectionEnd(paramSpannable) != k)
      {
        boolean bool2 = true;
        bool1 = true;
        if (a(paramSpannable, localLayout) < j + i) {
          break;
        }
        bool1 = bool2;
      }
      AppMethodBeat.o(206062);
      return bool1;
      Selection.moveDown(paramSpannable, localLayout);
    }
  }
  
  protected final boolean g(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206063);
    if (i(paramSpannable)) {
      Selection.extendSelection(paramSpannable, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(206063);
      return true;
      Selection.setSelection(paramSpannable, 0);
    }
  }
  
  protected final boolean h(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206064);
    if (i(paramSpannable)) {
      Selection.extendSelection(paramSpannable, paramSpannable.length());
    }
    for (;;)
    {
      AppMethodBeat.o(206064);
      return true;
      Selection.setSelection(paramSpannable, paramSpannable.length());
    }
  }
  
  protected final boolean i(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206065);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendToLeftEdge(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206065);
      return bool;
    }
    boolean bool = Selection.moveToLeftEdge(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206065);
    return bool;
  }
  
  public final void j(Spannable paramSpannable)
  {
    AppMethodBeat.i(206070);
    Selection.setSelection(paramSpannable, 0);
    AppMethodBeat.o(206070);
  }
  
  protected final boolean j(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206066);
    paramCustomTextView = paramCustomTextView.getLayout();
    if (i(paramSpannable))
    {
      bool = Selection.extendToRightEdge(paramSpannable, paramCustomTextView);
      AppMethodBeat.o(206066);
      return bool;
    }
    boolean bool = Selection.moveToRightEdge(paramSpannable, paramCustomTextView);
    AppMethodBeat.o(206066);
    return bool;
  }
  
  protected final boolean k(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206067);
    boolean bool = i(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(206067);
    return bool;
  }
  
  protected final boolean l(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206068);
    boolean bool = j(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(206068);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.a
 * JD-Core Version:    0.7.0.1
 */