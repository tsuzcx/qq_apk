package com.tencent.mm.ui.widget.cedit.edit;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.SystemClock;
import android.support.v4.widget.n;
import android.text.Editable;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ActionMode.Callback2;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.text.BreakIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  int Clf;
  boolean PPd;
  final ViewTreeObserver.OnDrawListener QIA;
  b QIB;
  g QIC;
  h QID;
  boolean QIE;
  boolean QIF;
  boolean QIG;
  KeyListener QIH;
  boolean QII;
  long QIJ;
  boolean QIK;
  a QIL;
  boolean QIM;
  boolean QIN;
  boolean QIO;
  boolean QIP;
  boolean QIQ;
  boolean QIR;
  boolean QIS;
  boolean QIT;
  private d QIU;
  boolean QIV;
  boolean QIW;
  Runnable QIX;
  Drawable QIY;
  Drawable QIZ;
  final CustomTextView QIo;
  boolean QIr;
  j QIs;
  n QIt;
  ActionMode QIu;
  boolean QIv;
  boolean QIw;
  final boolean QIx;
  k QIy;
  final Runnable QIz;
  Drawable QJa;
  Drawable QJb;
  l QJc;
  private float QJd;
  private float QJe;
  ActionMode.Callback QJf;
  ActionMode.Callback QJg;
  boolean QJh;
  int QJi;
  final c QJj;
  Runnable QJk;
  private com.tencent.mm.ui.widget.cedit.c.b QJl;
  private com.tencent.mm.ui.widget.cedit.c.b QJm;
  private boolean QJn;
  private final c QJo;
  final Runnable QJp;
  boolean QJq;
  private boolean QJr;
  final boolean QJs;
  int QJt;
  private float QJu;
  private int QJv;
  private int QJw;
  private com.tencent.mm.ui.widget.cedit.a.a QJx;
  boolean QJy;
  Rect mTempRect;
  
  b(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(205965);
    this.QIr = true;
    this.QIz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205876);
        b.k localk = b.this.QIy;
        if (Build.VERSION.SDK_INT >= 28) {
          localk.QKE.update();
        }
        AppMethodBeat.o(205876);
      }
    };
    this.QIA = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(205877);
        if (b.this.QIy != null) {
          b.this.QIo.post(b.this.QIz);
        }
        AppMethodBeat.o(205877);
      }
    };
    this.Clf = 0;
    this.QIM = true;
    this.QIQ = true;
    this.QIY = null;
    this.QJj = new c();
    this.QJo = new c((byte)0);
    this.QJp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205878);
        if (b.this.QJy) {
          b.this.hak();
        }
        if ((b.this.QIu != null) && (Build.VERSION.SDK_INT >= 23))
        {
          b.this.QIu.hide(0L);
          Log.i("cmEdit.Editor", "mTextActionMode.hide(0)");
        }
        AppMethodBeat.o(205878);
      }
    };
    this.QJq = false;
    this.QJu = 1.0F;
    this.QJy = false;
    this.QIo = paramCustomTextView;
    this.QIo.setFilters(this.QIo.getFilters());
    this.QIx = false;
    this.QJr = false;
    this.QJs = false;
    this.QJv = ((int)TypedValue.applyDimension(1, 45.0F, this.QIo.getContext().getResources().getDisplayMetrics()));
    this.QJw = ((int)TypedValue.applyDimension(1, 12.0F, this.QIo.getContext().getResources().getDisplayMetrics()));
    AppMethodBeat.o(205965);
  }
  
  private static Drawable a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(206027);
    if (!(paramDrawable instanceof BitmapDrawable))
    {
      AppMethodBeat.o(206027);
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(206027);
      return paramDrawable;
    }
    paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    float f1 = i / paramDrawable.getWidth();
    paramInt = at.fromDPToPix(paramContext, paramInt);
    float f2 = paramInt;
    paramDrawable = Bitmap.createScaledBitmap(paramDrawable, (int)(i / j * f2 / f1), (int)(paramInt / f1), true);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramDrawable);
    AppMethodBeat.o(206027);
    return paramContext;
  }
  
  private void a(h paramh)
  {
    AppMethodBeat.i(205996);
    if ((paramh.mContentChanged) || (paramh.QKo))
    {
      this.QIo.gZA();
      hae();
      haf();
      if (!ham()) {
        if (!this.QIo.hasSelection()) {
          break label110;
        }
      }
    }
    label110:
    for (paramh = hax();; paramh = haw())
    {
      if ((paramh != null) && (!paramh.isActive()) && (!paramh.haB())) {
        paramh.show();
      }
      AppMethodBeat.o(205996);
      return;
      if (!paramh.QKn) {
        break;
      }
      this.QIo.gZs();
      break;
    }
  }
  
  private void eXP()
  {
    AppMethodBeat.i(206006);
    if (this.QJx != null) {
      this.QJx.dismiss();
    }
    AppMethodBeat.o(206006);
  }
  
  private void g(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(206020);
    haA();
    int i = a(this.QIY, paramFloat);
    int j = this.QIY.getIntrinsicWidth();
    this.QIY.setBounds(i, paramInt1 - this.mTempRect.top, j + i, this.mTempRect.bottom + paramInt2);
    AppMethodBeat.o(206020);
  }
  
  private boolean gZU()
  {
    AppMethodBeat.i(205973);
    if (!this.QIo.gZC())
    {
      AppMethodBeat.o(205973);
      return false;
    }
    if (gZT())
    {
      boolean bool = this.QIo.gZJ();
      AppMethodBeat.o(205973);
      return bool;
    }
    long l = gZZ();
    int k = (int)(l >>> 32);
    int j = (int)(l & 0xFFFFFFFF);
    if ((k < 0) || (k > this.QIo.getText().length()))
    {
      AppMethodBeat.o(205973);
      return false;
    }
    if ((j < 0) || (j > this.QIo.getText().length()))
    {
      AppMethodBeat.o(205973);
      return false;
    }
    Object localObject = (URLSpan[])((Spanned)this.QIo.getText()).getSpans(k, j, URLSpan.class);
    int i;
    if (localObject.length > 0)
    {
      localObject = localObject[0];
      i = ((Spanned)this.QIo.getText()).getSpanStart(localObject);
      j = ((Spanned)this.QIo.getText()).getSpanEnd(localObject);
    }
    for (;;)
    {
      Selection.setSelection((Spannable)this.QIo.getText(), i, j);
      if (j > i)
      {
        AppMethodBeat.o(205973);
        return true;
        localObject = getWordIterator();
        ((com.tencent.mm.ui.widget.cedit.c.b)localObject).i(this.QIo.getText(), k, j);
        i = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).bR(k, false);
        j = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).bS(j, false);
        if ((i == -1) || (j == -1) || (i == j))
        {
          if (k < this.QIo.getText().length())
          {
            i = bP(k, true);
            l = com.tencent.mm.ui.widget.cedit.util.c.lD(bP(i, false), i);
          }
          for (;;)
          {
            i = (int)(l >>> 32);
            j = (int)(l & 0xFFFFFFFF);
            break;
            if (k - 1 >= 0)
            {
              i = bP(k, false);
              l = com.tencent.mm.ui.widget.cedit.util.c.lD(i, bP(i, true));
            }
            else
            {
              l = com.tencent.mm.ui.widget.cedit.util.c.lD(k, k);
            }
          }
        }
      }
      else
      {
        AppMethodBeat.o(205973);
        return false;
      }
    }
  }
  
  private void gZX()
  {
    AppMethodBeat.i(205982);
    hao();
    int i = this.QIo.getSelectionStart();
    int j = this.QIo.getSelectionEnd();
    ClipData.newPlainText(null, this.QIo.lA(i, j));
    new e(this.QIo, i, j);
    gZE();
    if (this.QIw) {
      hax().haN();
    }
    AppMethodBeat.o(205982);
  }
  
  private void gZY()
  {
    AppMethodBeat.i(205984);
    if (!ham())
    {
      gZE();
      AppMethodBeat.o(205984);
      return;
    }
    haj();
    AppMethodBeat.o(205984);
  }
  
  private void hac()
  {
    AppMethodBeat.i(205991);
    int i = ViewConfiguration.getDoubleTapTimeout();
    this.QIo.postDelayed(this.QJp, i);
    hao().haV();
    AppMethodBeat.o(205991);
  }
  
  private void haf()
  {
    AppMethodBeat.i(205999);
    InputMethodManager localInputMethodManager;
    int k;
    int m;
    int i;
    int j;
    if ((this.QID != null) && (this.QID.QIp <= 0))
    {
      localInputMethodManager = getInputMethodManager();
      if (localInputMethodManager != null)
      {
        k = this.QIo.getSelectionStart();
        m = this.QIo.getSelectionEnd();
        if (!(this.QIo.getText() instanceof Spannable)) {
          break label109;
        }
        Spannable localSpannable = (Spannable)this.QIo.getText();
        i = a.getComposingSpanStart(localSpannable);
        j = a.getComposingSpanEnd(localSpannable);
      }
    }
    for (;;)
    {
      localInputMethodManager.updateSelection(this.QIo, k, m, i, j);
      AppMethodBeat.o(205999);
      return;
      label109:
      j = -1;
      i = -1;
    }
  }
  
  private void hal()
  {
    AppMethodBeat.i(206005);
    com.tencent.mm.ui.widget.cedit.a.a locala;
    if (this.QJx != null) {
      locala = this.QJx;
    }
    try
    {
      Log.i("cmEdit.OperateWindow", "destroy OpWindow@%s", new Object[] { Integer.valueOf(locala.hashCode()) });
      locala.dismiss();
      locala.qQv.setContentView(null);
      locala.QLB = true;
      label58:
      this.QJy = false;
      AppMethodBeat.o(206005);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
  
  private boolean hap()
  {
    AppMethodBeat.i(206009);
    if (this.QJk != null) {
      this.QIo.removeCallbacks(this.QJk);
    }
    if (has())
    {
      AppMethodBeat.o(206009);
      return false;
    }
    if (!haq())
    {
      AppMethodBeat.o(206009);
      return false;
    }
    if ((!this.QIo.hasSelection()) && (!gZU()))
    {
      AppMethodBeat.o(206009);
      return false;
    }
    hav();
    hax().aoC(2);
    AppMethodBeat.o(206009);
    return true;
  }
  
  private boolean haq()
  {
    AppMethodBeat.i(206010);
    if ((!this.QIo.gZC()) || (!this.QIo.requestFocus()))
    {
      Log.w("cmEdit.CMTextView", "TextView does not support text selection. Selection cancelled.");
      AppMethodBeat.o(206010);
      return false;
    }
    AppMethodBeat.o(206010);
    return true;
  }
  
  private void hau()
  {
    AppMethodBeat.i(206016);
    hao();
    this.QIu = null;
    hal();
    if (!this.QIR) {
      Selection.setSelection((Spannable)this.QIo.getText(), this.QIo.getSelectionEnd());
    }
    if (this.QIt != null) {
      this.QIt.hide();
    }
    this.QIT = false;
    AppMethodBeat.o(206016);
  }
  
  public final boolean CY(boolean paramBoolean)
  {
    AppMethodBeat.i(205983);
    if (this.QIW)
    {
      if (!paramBoolean) {
        gZY();
      }
      AppMethodBeat.o(205983);
      return true;
    }
    int i;
    if ((!paramBoolean) && (!az(this.QJj.ovM, this.QJj.ovN)) && (!this.QJj.QLs) && (this.QIv))
    {
      i = this.QIo.getOffsetForPosition(this.QJj.ovM, this.QJj.ovN);
      Selection.setSelection((Spannable)this.QIo.getText(), i);
      haw().show();
      this.QJq = true;
    }
    for (boolean bool = true;; bool = paramBoolean)
    {
      paramBoolean = bool;
      int j;
      if (!bool)
      {
        paramBoolean = bool;
        if (!ham())
        {
          i = this.QIo.getSelectionStart();
          j = this.QIo.getSelectionEnd();
          if (i == j) {
            break label247;
          }
          if (i <= j) {
            break label264;
          }
          Selection.setSelection((Spannable)this.QIo.getText(), j, i);
        }
      }
      for (;;)
      {
        n localn = hax();
        int k = localn.QLb;
        int m = localn.QLc;
        if ((k >= j) && (m < i))
        {
          i = 1;
          if (i == 0) {
            break label252;
          }
          gZX();
        }
        for (;;)
        {
          paramBoolean = true;
          bool = paramBoolean;
          if (!paramBoolean) {
            bool = hap();
          }
          AppMethodBeat.o(205983);
          return bool;
          label247:
          i = 0;
          break;
          label252:
          gZE();
          hap();
        }
        label264:
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  final void CZ(boolean paramBoolean)
  {
    AppMethodBeat.i(206028);
    if ((this.QJb == null) || (paramBoolean))
    {
      this.QJb = this.QIo.getTextSelectHandle();
      if (this.QJb != null)
      {
        this.QJb = a(this.QIo.getContext(), this.QJb, 23);
        this.QJb.setTint(this.QIo.QHx);
      }
      if (this.QIv) {
        j.a(haw());
      }
    }
    if ((this.QIZ == null) || (this.QJa == null) || (paramBoolean))
    {
      this.QIZ = this.QIo.getTextSelectHandleLeft();
      this.QIZ = a(this.QIo.getContext(), this.QIZ, 21);
      this.QIZ.setTint(this.QIo.QHx);
      this.QJa = this.QIo.getTextSelectHandleRight();
      this.QJa = a(this.QIo.getContext(), this.QJa, 21);
      this.QJa.setTint(this.QIo.QHx);
      if (this.QIw) {
        n.d(hax());
      }
    }
    AppMethodBeat.o(206028);
  }
  
  final int a(Drawable paramDrawable, float paramFloat)
  {
    AppMethodBeat.i(206021);
    paramFloat = Math.max(0.5F, paramFloat - 0.5F);
    if (this.mTempRect == null) {
      this.mTempRect = new Rect();
    }
    int i = 0;
    int j;
    float f;
    int k;
    if (paramDrawable != null)
    {
      paramDrawable.getPadding(this.mTempRect);
      i = paramDrawable.getIntrinsicWidth();
      j = this.QIo.getScrollX();
      f = paramFloat - j;
      k = this.QIo.getWidth() - this.QIo.getCompoundPaddingLeft() - this.QIo.getCompoundPaddingRight();
      if (f < k - 1.0F) {
        break label145;
      }
      i = k + j - (i - this.mTempRect.right);
    }
    for (;;)
    {
      AppMethodBeat.o(206021);
      return i;
      this.mTempRect.setEmpty();
      break;
      label145:
      if ((Math.abs(f) <= 1.0F) || ((TextUtils.isEmpty(this.QIo.getText())) && (1048576 - j <= k + 1.0F) && (paramFloat <= 1.0F))) {
        i = j - this.mTempRect.left;
      } else {
        i = (int)paramFloat - this.mTempRect.left;
      }
    }
  }
  
  public final int a(Layout paramLayout, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(206025);
    int i = this.QIo.cz(paramFloat);
    if ((paramLayout == null) || (paramInt > paramLayout.getLineCount()) || (paramLayout.getLineCount() <= 0) || (paramInt < 0))
    {
      AppMethodBeat.o(206025);
      return i;
    }
    if (Math.abs(i - paramInt) >= 2)
    {
      AppMethodBeat.o(206025);
      return i;
    }
    int j = paramLayout.getLineBottom(paramInt) - paramLayout.getLineTop(paramInt);
    int k = (int)(0.5F * (paramLayout.getLineBottom(i) - paramLayout.getLineTop(i)));
    j = Math.max(0, Math.max(this.QJw, Math.min(this.QJv, k + j)) - j);
    float f = this.QIo.gZz();
    if ((i > paramInt) && (paramFloat >= paramLayout.getLineBottom(paramInt) + j + f))
    {
      AppMethodBeat.o(206025);
      return i;
    }
    if ((i < paramInt) && (paramFloat <= paramLayout.getLineTop(paramInt) - j + f))
    {
      AppMethodBeat.o(206025);
      return i;
    }
    AppMethodBeat.o(206025);
    return paramInt;
  }
  
  final void a(DragEvent paramDragEvent)
  {
    int i = 1;
    AppMethodBeat.i(206024);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    this.QIo.beginBatchEdit();
    try
    {
      int n = this.QIo.getOffsetForPosition(paramDragEvent.getX(), paramDragEvent.getY());
      Object localObject = paramDragEvent.getLocalState();
      paramDragEvent = null;
      if ((localObject instanceof e)) {
        paramDragEvent = (e)localObject;
      }
      if ((paramDragEvent != null) && (paramDragEvent.QJE == this.QIo)) {}
      int j;
      while ((i != 0) && (n >= paramDragEvent.start))
      {
        j = paramDragEvent.end;
        if (n >= j) {
          break;
        }
        return;
        i = 0;
      }
      int i1 = this.QIo.getText().length();
      Selection.setSelection((Spannable)this.QIo.getText(), n);
      ((Editable)this.QIo.mText).replace(n, n, localSpannableStringBuilder);
      if (i != 0)
      {
        int m = paramDragEvent.start;
        int k = paramDragEvent.end;
        j = k;
        i = m;
        if (n <= m)
        {
          j = this.QIo.getText().length() - i1;
          i = m + j;
          j = k + j;
        }
        this.QIo.lB(i, j);
        j = Math.max(0, i - 1);
        i = Math.min(this.QIo.getText().length(), i + 1);
        if (i > j + 1)
        {
          paramDragEvent = this.QIo.lA(j, i);
          if ((Character.isSpaceChar(paramDragEvent.charAt(0))) && (Character.isSpaceChar(paramDragEvent.charAt(1)))) {
            this.QIo.lB(j, j + 1);
          }
        }
      }
      return;
    }
    finally
    {
      this.QIo.endBatchEdit();
      AppMethodBeat.o(206024);
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(205979);
    gZW().a(paramp, false);
    AppMethodBeat.o(205979);
  }
  
  final boolean a(ExtractedTextRequest paramExtractedTextRequest, int paramInt1, int paramInt2, int paramInt3, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(205997);
    if ((paramExtractedTextRequest == null) || (paramExtractedText == null))
    {
      AppMethodBeat.o(205997);
      return false;
    }
    CharSequence localCharSequence = this.QIo.getText();
    if (localCharSequence == null)
    {
      AppMethodBeat.o(205997);
      return false;
    }
    int i;
    label106:
    Spanned localSpanned;
    Object[] arrayOfObject;
    int m;
    label254:
    int k;
    int j;
    if (paramInt1 != -2)
    {
      i = localCharSequence.length();
      if (paramInt1 < 0)
      {
        paramExtractedText.partialEndOffset = -1;
        paramExtractedText.partialStartOffset = -1;
        paramInt2 = i;
        paramInt3 = 0;
        if ((paramExtractedTextRequest.flags & 0x1) != 0)
        {
          paramExtractedText.text = localCharSequence.subSequence(paramInt3, paramInt2);
          paramExtractedText.flags = 0;
          if (MetaKeyKeyListener.getMetaState(localCharSequence, 2048) != 0) {
            paramExtractedText.flags |= 0x2;
          }
          if (this.QIo.OSP) {
            paramExtractedText.flags |= 0x1;
          }
          paramExtractedText.startOffset = 0;
          paramExtractedText.selectionStart = this.QIo.getSelectionStart();
          paramExtractedText.selectionEnd = this.QIo.getSelectionEnd();
          if (Build.VERSION.SDK_INT >= 28) {
            paramExtractedText.hint = this.QIo.getHint();
          }
          AppMethodBeat.o(205997);
          return true;
        }
      }
      else
      {
        paramInt2 += paramInt3;
        if ((localCharSequence instanceof Spanned))
        {
          localSpanned = (Spanned)localCharSequence;
          arrayOfObject = localSpanned.getSpans(paramInt1, paramInt2, ParcelableSpan.class);
          m = arrayOfObject.length;
          k = paramInt1;
          j = paramInt2;
          if (m <= 0) {
            break label333;
          }
          m -= 1;
          j = localSpanned.getSpanStart(arrayOfObject[m]);
          if (j >= paramInt1) {
            break label450;
          }
          paramInt1 = j;
        }
      }
    }
    label444:
    label450:
    for (;;)
    {
      k = localSpanned.getSpanEnd(arrayOfObject[m]);
      j = paramInt2;
      if (k > paramInt2) {
        j = k;
      }
      paramInt2 = j;
      break label254;
      j = paramInt2;
      k = paramInt1;
      label333:
      paramExtractedText.partialStartOffset = k;
      paramExtractedText.partialEndOffset = (j - paramInt3);
      if (k > i) {
        paramInt1 = i;
      }
      for (;;)
      {
        if (j > i)
        {
          paramInt2 = i;
          paramInt3 = paramInt1;
          break;
          if (k >= 0) {
            break label444;
          }
          paramInt1 = 0;
          continue;
        }
        paramInt3 = paramInt1;
        paramInt2 = j;
        if (j >= 0) {
          break;
        }
        paramInt2 = 0;
        paramInt3 = paramInt1;
        break;
        paramExtractedText.text = TextUtils.substring(localCharSequence, paramInt3, paramInt2);
        break label106;
        paramExtractedText.partialStartOffset = 0;
        paramExtractedText.partialEndOffset = 0;
        paramExtractedText.text = "";
        break label106;
        paramInt1 = k;
      }
    }
  }
  
  final void aA(float paramFloat1, float paramFloat2)
  {
    this.QJd = paramFloat1;
    this.QJe = paramFloat2;
  }
  
  final void af(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(205986);
    this.QIJ = SystemClock.uptimeMillis();
    had();
    if (paramBoolean)
    {
      int k = this.QIo.getSelectionStart();
      int m = this.QIo.getSelectionEnd();
      if ((this.QIN) && (k == 0) && (m == this.QIo.getText().length()))
      {
        i = 1;
        if ((!this.QIE) || (!this.QIo.hasSelection()) || (i != 0)) {
          break label306;
        }
        paramBoolean = true;
        label96:
        this.QJh = paramBoolean;
        if ((!this.QIE) || (k < 0) || (m < 0))
        {
          if (this.QIt == null) {
            break label311;
          }
          int j = this.QIt.QLb;
          if (j < 0) {
            break label311;
          }
          i = j;
          if (j <= this.QIo.getText().length()) {}
        }
      }
      label306:
      label311:
      for (int i = this.QIo.getText().length();; i = -1)
      {
        if (i >= 0) {
          Selection.setSelection((Spannable)this.QIo.getText(), i);
        }
        com.tencent.mm.ui.widget.cedit.b.d locald = this.QIo.getMovementMethod();
        if (locald != null) {
          locald.a(this.QIo, (Spannable)this.QIo.getText(), paramInt);
        }
        if ((this.QIF) && (k >= 0) && (m >= 0)) {
          Selection.setSelection((Spannable)this.QIo.getText(), k, m);
        }
        if (this.QIN) {
          this.QIo.gZJ();
        }
        this.QIG = true;
        this.QIE = false;
        this.QIF = false;
        haz();
        AppMethodBeat.o(205986);
        return;
        i = 0;
        break;
        paramBoolean = false;
        break label96;
      }
    }
    gZQ();
    paramBoolean = bool;
    if (Build.VERSION.SDK_INT >= 24) {
      paramBoolean = this.QIo.isTemporarilyDetached();
    }
    if (paramBoolean) {
      hav();
    }
    for (;;)
    {
      if (this.QIt != null) {
        this.QIt.haN();
      }
      haa();
      AppMethodBeat.o(205986);
      return;
      gZE();
    }
  }
  
  final void aoA(int paramInt)
  {
    AppMethodBeat.i(205990);
    this.QIo.removeCallbacks(this.QJp);
    eXP();
    if ((this.QIu != null) && (Build.VERSION.SDK_INT >= 23)) {
      this.QIu.hide(paramInt);
    }
    AppMethodBeat.o(205990);
  }
  
  final void ap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205989);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205989);
      return;
      aoA(-1);
      AppMethodBeat.o(205989);
      return;
      hac();
    }
  }
  
  final void aq(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(206014);
    hao();
    this.QIo.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
    CharSequence localCharSequence;
    int k;
    if ((this.QIN) && (this.QIo.didTouchFocusSelect()))
    {
      i = 1;
      gZQ();
      gZE();
      localCharSequence = this.QIo.getText();
      if ((i != 0) || (localCharSequence.length() <= 0)) {
        break label201;
      }
      k = this.QIo.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.QIT) {
        break label164;
      }
    }
    label164:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        Selection.setSelection((Spannable)localCharSequence, k);
      }
      if (has()) {
        break label201;
      }
      if (!hat()) {
        break label169;
      }
      if (this.QJk == null) {
        break label201;
      }
      this.QIo.removeCallbacks(this.QJk);
      AppMethodBeat.o(206014);
      return;
      i = 0;
      break;
    }
    label169:
    if (this.QIv)
    {
      if (i != 0)
      {
        haw().show();
        AppMethodBeat.o(206014);
        return;
      }
      haw().hide();
    }
    label201:
    AppMethodBeat.o(206014);
  }
  
  final boolean az(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205981);
    Layout localLayout = this.QIo.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(205981);
      return false;
    }
    int i = this.QIo.cz(paramFloat2);
    paramFloat1 = this.QIo.cy(paramFloat1);
    if (paramFloat1 < localLayout.getLineLeft(i))
    {
      AppMethodBeat.o(205981);
      return false;
    }
    if (paramFloat1 > localLayout.getLineRight(i))
    {
      AppMethodBeat.o(205981);
      return false;
    }
    AppMethodBeat.o(205981);
    return true;
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(205980);
    gZW().c(paramp);
    AppMethodBeat.o(205980);
  }
  
  final int bP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205977);
    Layout localLayout = this.QIo.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(205977);
      return paramInt;
    }
    if (paramBoolean == localLayout.isRtlCharAt(paramInt))
    {
      paramInt = localLayout.getOffsetToLeftOf(paramInt);
      AppMethodBeat.o(205977);
      return paramInt;
    }
    paramInt = localLayout.getOffsetToRightOf(paramInt);
    AppMethodBeat.o(205977);
    return paramInt;
  }
  
  public final void beginBatchEdit()
  {
    AppMethodBeat.i(205993);
    this.QIP = true;
    h localh = this.QID;
    if (localh != null)
    {
      int i = localh.QIp + 1;
      localh.QIp = i;
      if (i == 1)
      {
        localh.QKn = false;
        localh.QKr = 0;
        if (localh.mContentChanged)
        {
          localh.QKp = 0;
          localh.QKq = this.QIo.getText().length();
          AppMethodBeat.o(205993);
          return;
        }
        localh.QKp = -1;
        localh.QKq = -1;
        localh.mContentChanged = false;
      }
    }
    AppMethodBeat.o(205993);
  }
  
  public final void endBatchEdit()
  {
    AppMethodBeat.i(205994);
    this.QIP = false;
    h localh = this.QID;
    if (localh != null)
    {
      int i = localh.QIp - 1;
      localh.QIp = i;
      if (i == 0) {
        a(localh);
      }
    }
    AppMethodBeat.o(205994);
  }
  
  protected final void gZE()
  {
    AppMethodBeat.i(206015);
    if (this.QIu != null) {
      this.QIu.finish();
    }
    this.QIo.removeCallbacks(this.QJp);
    if (this.QJy) {
      hau();
    }
    AppMethodBeat.o(206015);
  }
  
  final void gZO()
  {
    AppMethodBeat.i(205966);
    if (this.QIC == null) {
      this.QIC = new g();
    }
    AppMethodBeat.o(205966);
  }
  
  final void gZP()
  {
    boolean bool2 = true;
    AppMethodBeat.i(205968);
    Object localObject = this.QIo.getRootView().getLayoutParams();
    int i;
    if ((localObject instanceof WindowManager.LayoutParams))
    {
      localObject = (WindowManager.LayoutParams)localObject;
      if ((((WindowManager.LayoutParams)localObject).type < 1000) || (((WindowManager.LayoutParams)localObject).type > 1999)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.QIo.getLayout() != null))
      {
        i = 1;
        label75:
        if ((i == 0) || (!isCursorVisible())) {
          break label191;
        }
        bool1 = true;
        label88:
        this.QIv = bool1;
        if ((i == 0) || (!this.QIo.gZD())) {
          break label196;
        }
      }
      label191:
      label196:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.QIw = bool1;
        if (!this.QIv)
        {
          gZQ();
          if (this.QIs != null)
          {
            this.QIs.onDetached();
            this.QIs = null;
          }
        }
        if (!this.QIw)
        {
          gZE();
          if (this.QIt != null)
          {
            this.QIt.onDetached();
            this.QIt = null;
          }
        }
        AppMethodBeat.o(205968);
        return;
        i = 0;
        break;
        i = 0;
        break label75;
        bool1 = false;
        break label88;
      }
      i = 0;
    }
  }
  
  final void gZQ()
  {
    AppMethodBeat.i(205969);
    if (this.QIs != null) {
      this.QIs.hide();
    }
    AppMethodBeat.o(205969);
  }
  
  final void gZR()
  {
    AppMethodBeat.i(205970);
    if (this.QIL != null) {
      this.QIL.cancel();
    }
    AppMethodBeat.o(205970);
  }
  
  final void gZS()
  {
    AppMethodBeat.i(205971);
    if (this.QIL != null)
    {
      this.QIL.mCancelled = false;
      haz();
    }
    AppMethodBeat.o(205971);
  }
  
  final boolean gZT()
  {
    AppMethodBeat.i(205972);
    if ((this.QIo.QGH instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(205972);
      return true;
    }
    int j = this.QIo.getInputType();
    int i = j & 0xF;
    j &= 0xFF0;
    if ((i == 2) || (i == 3) || (i == 4) || (j == 16) || (j == 32) || (j == 208) || (j == 176))
    {
      AppMethodBeat.o(205972);
      return true;
    }
    AppMethodBeat.o(205972);
    return false;
  }
  
  final com.tencent.mm.ui.widget.cedit.c.b gZV()
  {
    AppMethodBeat.i(205976);
    if (this.QJm == null)
    {
      this.QJm = new com.tencent.mm.ui.widget.cedit.c.b(this.QIo.getTextServicesLocale());
      this.QJn = true;
    }
    if (this.QJn)
    {
      localObject = this.QIo.getText();
      this.QJm.i((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      this.QJn = false;
    }
    Object localObject = this.QJm;
    AppMethodBeat.o(205976);
    return localObject;
  }
  
  final l gZW()
  {
    AppMethodBeat.i(205978);
    if (this.QJc == null) {
      this.QJc = new l((byte)0);
    }
    l locall = this.QJc;
    AppMethodBeat.o(205978);
    return locall;
  }
  
  final long gZZ()
  {
    AppMethodBeat.i(205985);
    n localn = hax();
    long l = com.tencent.mm.ui.widget.cedit.util.c.lD(localn.QLb, localn.QLc);
    AppMethodBeat.o(205985);
    return l;
  }
  
  final InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(205992);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)this.QIo.getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(205992);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.QIo.getContext().getSystemService("input_method");
    AppMethodBeat.o(205992);
    return localInputMethodManager;
  }
  
  public final com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(205975);
    if (this.QJl == null) {
      this.QJl = new com.tencent.mm.ui.widget.cedit.c.b(this.QIo.getTextServicesLocale());
    }
    com.tencent.mm.ui.widget.cedit.c.b localb = this.QJl;
    AppMethodBeat.o(205975);
    return localb;
  }
  
  final void haA()
  {
    AppMethodBeat.i(206026);
    if (this.QIY == null) {
      this.QIY = this.QIo.getTextCursorDrawable();
    }
    AppMethodBeat.o(206026);
  }
  
  final void haa()
  {
    AppMethodBeat.i(205987);
    if ((!this.QIo.gZD()) && (this.QIo.hasSelection())) {
      Selection.setSelection((Spannable)this.QIo.getText(), this.QIo.length(), this.QIo.length());
    }
    AppMethodBeat.o(205987);
  }
  
  final void hab()
  {
    AppMethodBeat.i(205988);
    hao();
    this.QJn = true;
    gZQ();
    if (this.QIt != null) {
      this.QIt.haN();
    }
    gZE();
    AppMethodBeat.o(205988);
  }
  
  final void had()
  {
    AppMethodBeat.i(205995);
    h localh = this.QID;
    if ((localh != null) && (localh.QIp != 0))
    {
      localh.QIp = 0;
      a(localh);
    }
    AppMethodBeat.o(205995);
  }
  
  final boolean hae()
  {
    AppMethodBeat.i(205998);
    h localh = this.QID;
    if (localh == null)
    {
      AppMethodBeat.o(205998);
      return false;
    }
    boolean bool = localh.mContentChanged;
    if ((!bool) && (!localh.QKo))
    {
      AppMethodBeat.o(205998);
      return false;
    }
    localh.mContentChanged = false;
    localh.QKo = false;
    ExtractedTextRequest localExtractedTextRequest = localh.QKl;
    if (localExtractedTextRequest == null)
    {
      AppMethodBeat.o(205998);
      return false;
    }
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(205998);
      return false;
    }
    if ((localh.QKp < 0) && (!bool)) {
      localh.QKp = -2;
    }
    if (a(localExtractedTextRequest, localh.QKp, localh.QKq, localh.QKr, localh.QKm))
    {
      localInputMethodManager.updateExtractedText(this.QIo, localExtractedTextRequest.token, localh.QKm);
      localh.QKp = -1;
      localh.QKq = -1;
      localh.QKr = 0;
      localh.mContentChanged = false;
      AppMethodBeat.o(205998);
      return true;
    }
    AppMethodBeat.o(205998);
    return false;
  }
  
  final void hag()
  {
    AppMethodBeat.i(206000);
    if (this.QIt != null) {
      this.QIt.haR();
    }
    if (this.QIs != null) {
      this.QIs.haK();
    }
    if (!ham()) {
      han();
    }
    AppMethodBeat.o(206000);
  }
  
  final void hah()
  {
    AppMethodBeat.i(206001);
    haA();
    if (this.QIY == null)
    {
      AppMethodBeat.o(206001);
      return;
    }
    Layout localLayout = this.QIo.getLayout();
    int i = this.QIo.getSelectionStart();
    int j = localLayout.getLineForOffset(i);
    g(localLayout.getLineTop(j), localLayout.getLineBottom(j), localLayout.getPrimaryHorizontal(i));
    AppMethodBeat.o(206001);
  }
  
  final void hai()
  {
    AppMethodBeat.i(206002);
    if (has())
    {
      this.QIS = false;
      AppMethodBeat.o(206002);
      return;
    }
    boolean bool = this.QIo.hasSelection();
    n localn = hax();
    j localj = haw();
    if (((localn != null) && (localn.haB())) || ((localj != null) && (localj.haB())))
    {
      this.QIS = false;
      AppMethodBeat.o(206002);
      return;
    }
    if (bool)
    {
      gZQ();
      if (ham()) {
        if (this.QIS) {
          hao().haU();
        }
      }
    }
    for (;;)
    {
      this.QIS = false;
      AppMethodBeat.o(206002);
      return;
      if ((localn == null) || (!localn.isActive()))
      {
        hav();
        hao().haU();
      }
      else
      {
        if ((Build.VERSION.SDK_INT >= 23) && (this.QIu != null)) {
          this.QIu.invalidateContentRect();
        }
        hac();
        continue;
        if ((localj == null) || (!localj.isActive())) {
          gZE();
        } else if ((this.QIu != null) && (Build.VERSION.SDK_INT >= 23)) {
          this.QIu.invalidateContentRect();
        }
      }
    }
  }
  
  final void haj()
  {
    AppMethodBeat.i(206003);
    if (this.QJk != null) {
      this.QIo.removeCallbacks(this.QJk);
    }
    if (has())
    {
      AppMethodBeat.o(206003);
      return;
    }
    gZE();
    if (Build.VERSION.SDK_INT >= 23) {
      new o(1);
    }
    hak();
    if ((!ham()) && (haw() != null)) {
      haw().show();
    }
    AppMethodBeat.o(206003);
  }
  
  final void hak()
  {
    AppMethodBeat.i(206004);
    if (this.QJx == null) {
      this.QJx = new com.tencent.mm.ui.widget.cedit.a.a(this.QIo);
    }
    this.QJx.show();
    this.QJy = true;
    AppMethodBeat.o(206004);
  }
  
  public final boolean ham()
  {
    return (this.QIu == null) && (!this.QJy);
  }
  
  final void han()
  {
    AppMethodBeat.i(206007);
    if (this.QIu != null) {
      this.QIu.invalidate();
    }
    AppMethodBeat.o(206007);
  }
  
  final d hao()
  {
    AppMethodBeat.i(206008);
    if (this.QIU == null) {
      this.QIU = new d(this);
    }
    d locald = this.QIU;
    AppMethodBeat.o(206008);
    return locald;
  }
  
  final boolean har()
  {
    AppMethodBeat.i(206011);
    if (has())
    {
      AppMethodBeat.o(206011);
      return false;
    }
    if (this.QIu != null)
    {
      han();
      AppMethodBeat.o(206011);
      return false;
    }
    if ((!haq()) || (!this.QIo.hasSelection()))
    {
      AppMethodBeat.o(206011);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      new o(0);
    }
    hak();
    this.QIo.gZB();
    if (!ham()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.QIo.gZB()) && (!this.QIo.isTextSelectable()) && (this.QIQ))
      {
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.showSoftInput(this.QIo, 0, null);
        }
      }
      AppMethodBeat.o(206011);
      return true;
    }
  }
  
  final boolean has()
  {
    AppMethodBeat.i(206012);
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if ((localInputMethodManager != null) && (localInputMethodManager.isFullscreenMode()))
    {
      AppMethodBeat.o(206012);
      return true;
    }
    AppMethodBeat.o(206012);
    return false;
  }
  
  final boolean hat()
  {
    AppMethodBeat.i(206013);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])((Spannable)this.QIo.getText()).getSpans(this.QIo.getSelectionStart(), this.QIo.getSelectionEnd(), SuggestionSpan.class);
    int i = 0;
    while (i < arrayOfSuggestionSpan.length)
    {
      if ((arrayOfSuggestionSpan[i].getFlags() & 0x1) != 0)
      {
        AppMethodBeat.o(206013);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(206013);
    return false;
  }
  
  final void hav()
  {
    AppMethodBeat.i(206017);
    if (!ham()) {
      this.QIS = true;
    }
    this.QIR = true;
    gZE();
    this.QIR = false;
    AppMethodBeat.o(206017);
  }
  
  public final j haw()
  {
    AppMethodBeat.i(206018);
    if (!this.QIv)
    {
      AppMethodBeat.o(206018);
      return null;
    }
    if (this.QIs == null)
    {
      this.QIs = new j();
      this.QIo.getViewTreeObserver().addOnTouchModeChangeListener(this.QIs);
    }
    j localj = this.QIs;
    AppMethodBeat.o(206018);
    return localj;
  }
  
  public final n hax()
  {
    AppMethodBeat.i(206019);
    if (!this.QIw)
    {
      AppMethodBeat.o(206019);
      return null;
    }
    if (this.QIt == null)
    {
      this.QIt = new n();
      this.QIo.getViewTreeObserver().addOnTouchModeChangeListener(this.QIt);
    }
    n localn = this.QIt;
    AppMethodBeat.o(206019);
    return localn;
  }
  
  final boolean hay()
  {
    AppMethodBeat.i(206022);
    if ((!isCursorVisible()) || (!this.QIo.isFocused()))
    {
      AppMethodBeat.o(206022);
      return false;
    }
    int i = this.QIo.getSelectionStart();
    if (i < 0)
    {
      AppMethodBeat.o(206022);
      return false;
    }
    int j = this.QIo.getSelectionEnd();
    if (j < 0)
    {
      AppMethodBeat.o(206022);
      return false;
    }
    if (i == j)
    {
      AppMethodBeat.o(206022);
      return true;
    }
    AppMethodBeat.o(206022);
    return false;
  }
  
  final void haz()
  {
    AppMethodBeat.i(206023);
    if (hay())
    {
      this.QIJ = SystemClock.uptimeMillis();
      if (this.QIL == null) {
        this.QIL = new a((byte)0);
      }
      this.QIo.removeCallbacks(this.QIL);
      this.QIo.postDelayed(this.QIL, 500L);
      AppMethodBeat.o(206023);
      return;
    }
    if (this.QIL != null) {
      this.QIo.removeCallbacks(this.QIL);
    }
    AppMethodBeat.o(206023);
  }
  
  final boolean isCursorVisible()
  {
    AppMethodBeat.i(205967);
    if ((this.QIM) && (this.QIo.gZB()))
    {
      AppMethodBeat.o(205967);
      return true;
    }
    AppMethodBeat.o(205967);
    return false;
  }
  
  final long lC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205974);
    Layout localLayout = this.QIo.getLayout();
    if (localLayout == null)
    {
      l = com.tencent.mm.ui.widget.cedit.util.c.lD(-1, -1);
      AppMethodBeat.o(205974);
      return l;
    }
    CharSequence localCharSequence = this.QIo.getText();
    paramInt1 = localLayout.getLineForOffset(paramInt1);
    while ((paramInt1 > 0) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt1 - 1) - 1) != '\n')) {
      paramInt1 -= 1;
    }
    paramInt2 = localLayout.getLineForOffset(paramInt2);
    while ((paramInt2 < localLayout.getLineCount() - 1) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt2) - 1) != '\n')) {
      paramInt2 += 1;
    }
    long l = com.tencent.mm.ui.widget.cedit.util.c.lD(localLayout.getLineStart(paramInt1), localLayout.getLineEnd(paramInt2));
    AppMethodBeat.o(205974);
    return l;
  }
  
  final class a
    implements Runnable
  {
    boolean mCancelled;
    
    private a() {}
    
    final void cancel()
    {
      AppMethodBeat.i(205880);
      if (!this.mCancelled)
      {
        b.this.QIo.removeCallbacks(this);
        this.mCancelled = true;
      }
      AppMethodBeat.o(205880);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205879);
      if (this.mCancelled)
      {
        AppMethodBeat.o(205879);
        return;
      }
      b.this.QIo.removeCallbacks(this);
      if (b.this.hay())
      {
        if (b.this.QIo.getLayout() != null) {
          b.this.QIo.gZr();
        }
        b.this.QIo.postDelayed(this, 500L);
      }
      AppMethodBeat.o(205879);
    }
  }
  
  final class b
  {
    int Pc;
    long QJA;
    private RectF asb;
    int avh;
    final Paint mPaint;
    final Path xT;
    
    public b()
    {
      AppMethodBeat.i(205881);
      this.xT = new Path();
      this.mPaint = new Paint(1);
      this.mPaint.setStyle(Paint.Style.FILL);
      AppMethodBeat.o(205881);
    }
    
    final void Da(boolean paramBoolean)
    {
      AppMethodBeat.i(205882);
      if (b.this.QIo.getLayout() == null)
      {
        AppMethodBeat.o(205882);
        return;
      }
      if (this.asb == null) {
        this.asb = new RectF();
      }
      this.xT.computeBounds(this.asb, false);
      int i = b.this.QIo.getCompoundPaddingLeft();
      int j = b.this.QIo.getExtendedPaddingTop() + b.this.QIo.CW(true);
      if (paramBoolean)
      {
        b.this.QIo.postInvalidateOnAnimation((int)this.asb.left + i, (int)this.asb.top + j, i + (int)this.asb.right, j + (int)this.asb.bottom);
        AppMethodBeat.o(205882);
        return;
      }
      b.this.QIo.postInvalidate((int)this.asb.left, (int)this.asb.top, (int)this.asb.right, (int)this.asb.bottom);
      AppMethodBeat.o(205882);
    }
    
    final void stopAnimation()
    {
      b.this.QIB = null;
    }
  }
  
  final class c
    implements b.p
  {
    final CursorAnchorInfo.Builder QJB;
    final int[] QJC;
    final Matrix QJD;
    
    private c()
    {
      AppMethodBeat.i(205883);
      this.QJB = new CursorAnchorInfo.Builder();
      this.QJC = new int[2];
      this.QJD = new Matrix();
      AppMethodBeat.o(205883);
    }
    
    public final void i(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(205884);
      Object localObject = b.this.QID;
      if ((localObject == null) || (((b.h)localObject).QIp > 0))
      {
        AppMethodBeat.o(205884);
        return;
      }
      localObject = b.this.getInputMethodManager();
      if (localObject == null)
      {
        AppMethodBeat.o(205884);
        return;
      }
      if (!((InputMethodManager)localObject).isActive(b.this.QIo))
      {
        AppMethodBeat.o(205884);
        return;
      }
      AppMethodBeat.o(205884);
    }
  }
  
  static abstract interface d
    extends ViewTreeObserver.OnTouchModeChangeListener
  {
    public abstract boolean haB();
    
    public abstract boolean isActive();
    
    public abstract void show();
  }
  
  static final class e
  {
    public CustomTextView QJE;
    public int end;
    public int start;
    
    public e(CustomTextView paramCustomTextView, int paramInt1, int paramInt2)
    {
      this.QJE = paramCustomTextView;
      this.start = paramInt1;
      this.end = paramInt2;
    }
  }
  
  public abstract class f
    extends View
    implements b.p
  {
    protected int AiE = -1;
    private int DAQ;
    protected Drawable QJF;
    protected Drawable QJG;
    private final PopupWindow QJH;
    private int QJI;
    private int QJJ;
    private int QJK;
    private int QJL;
    private float QJM;
    private float QJN;
    protected int QJO;
    protected int QJP;
    private float QJQ;
    private final float QJR;
    private int QJS;
    private int QJT;
    private int QJU;
    private int QJV;
    private boolean QJW = true;
    protected int QJX = -1;
    protected int QJY = -1;
    private float QJZ = -1.0F;
    private float QKa;
    private float QKb;
    private final int QKc;
    private final long[] QKd = new long[5];
    private final int[] QKe = new int[5];
    private int QKf = 0;
    int QKg = 0;
    private int irF = at.fromDPToPix(getContext(), 18);
    protected Drawable mDrawable;
    boolean okz;
    
    private f(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt)
    {
      super();
      setId(paramInt);
      this.QJH = new PopupWindow(b.this.QIo.getContext(), null, 2131821236);
      this.QJH.setSplitTouchEnabled(true);
      this.QJH.setClippingEnabled(false);
      n.a(this.QJH, 1002);
      this.QJH.setWidth(-2);
      this.QJH.setHeight(-2);
      this.QJH.setContentView(this);
      b(paramDrawable1, paramDrawable2);
      this.DAQ = b.this.QIo.getContext().getResources().getDimensionPixelSize(2131167042);
      paramInt = getPreferredHeight();
      this.QJQ = (-0.3F * paramInt);
      this.QJR = (paramInt * 0.7F);
      this.QKc = ((int)(this.QJR - this.QJQ));
    }
    
    private boolean a(f paramf, Rect paramRect)
    {
      paramf = paramf.QJH;
      int i = this.QJK;
      int j = this.QJL;
      int k = this.QJK;
      int m = paramf.getContentView().getWidth();
      int n = this.QJL;
      return Rect.intersects(new Rect(i, j, k + m, paramf.getContentView().getHeight() + n), paramRect);
    }
    
    private void aoB(int paramInt)
    {
      this.QKf = ((this.QKf + 1) % 5);
      this.QKe[this.QKf] = paramInt;
      this.QKd[this.QKf] = SystemClock.uptimeMillis();
      this.QKg += 1;
    }
    
    private int getDrawHeight()
    {
      return this.mDrawable.getIntrinsicHeight();
    }
    
    private int getDrawWidth()
    {
      return this.mDrawable.getIntrinsicWidth();
    }
    
    private int getHorizontalOffset()
    {
      int i = getPreferredWidth();
      int j = getDrawWidth();
      switch (this.QJP)
      {
      case 4: 
      default: 
        return (i - j) / 2;
      case 3: 
        return 0;
      }
      return i - j;
    }
    
    private f getOtherSelectionHandle()
    {
      b.n localn = b.this.hax();
      if ((localn == null) || (!localn.isActive())) {
        return null;
      }
      if (b.n.a(localn) != this) {
        return b.n.a(localn);
      }
      return b.n.c(localn);
    }
    
    private boolean haC()
    {
      if (this.okz) {
        return true;
      }
      if (b.this.QIo.gZK()) {
        return false;
      }
      return b.this.QIo.ay(this.QJI + this.QJO + getHorizontalOffset(), this.QJJ);
    }
    
    private boolean haD()
    {
      if (b.this.QIy.QKF) {
        return true;
      }
      if ((b.this.QIo.getRotation() != 0.0F) || (b.this.QIo.getRotationX() != 0.0F) || (b.this.QIo.getRotationY() != 0.0F)) {
        return false;
      }
      this.QKa = b.this.QIo.getScaleX();
      this.QKb = b.this.QIo.getScaleY();
      for (ViewParent localViewParent = b.this.QIo.getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof View))
        {
          View localView = (View)localViewParent;
          if ((localView.getRotation() != 0.0F) || (localView.getRotationX() != 0.0F) || (localView.getRotationY() != 0.0F)) {
            return false;
          }
          this.QKa *= localView.getScaleX();
          float f = this.QKb;
          this.QKb = (localView.getScaleY() * f);
        }
      }
      return true;
    }
    
    private void setVisible(boolean paramBoolean)
    {
      View localView = this.QJH.getContentView();
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        return;
      }
    }
    
    protected void Db(boolean paramBoolean)
    {
      if ((!paramBoolean) && (this.okz)) {}
      Layout localLayout;
      do
      {
        return;
        localLayout = b.this.QIo.getLayout();
      } while (localLayout == null);
      int i = getCurrentCursorOffset();
      paramBoolean = a(localLayout, i);
      Drawable localDrawable2 = this.mDrawable;
      if (paramBoolean) {}
      for (Drawable localDrawable1 = this.QJG;; localDrawable1 = this.QJF)
      {
        this.mDrawable = localDrawable1;
        this.QJO = c(this.mDrawable, paramBoolean);
        this.QJP = Dc(paramBoolean);
        if ((localDrawable2 == this.mDrawable) || (!isShowing())) {
          break;
        }
        this.QJI = (c(localLayout, i) - this.QJO - getHorizontalOffset() + getCursorOffset());
        this.QJI += b.this.QIo.gZy();
        this.QJW = true;
        i(this.QJS, this.QJT, false, false);
        postInvalidate();
        return;
      }
    }
    
    protected abstract int Dc(boolean paramBoolean);
    
    protected abstract void Gn(int paramInt);
    
    protected boolean a(Layout paramLayout, int paramInt)
    {
      return paramLayout.isRtlCharAt(paramInt);
    }
    
    protected final void ar(MotionEvent paramMotionEvent)
    {
      Object localObject1 = b.this;
      if ((((b)localObject1).QIy == null) && (Build.VERSION.SDK_INT >= 28)) {
        ((b)localObject1).QIy = new b.k(new Magnifier(((b)localObject1).QIo), (byte)0);
      }
      if (((b)localObject1).QIy == null) {}
      Object localObject2;
      int i;
      int n;
      int j;
      label178:
      label195:
      float f1;
      float f2;
      label264:
      label302:
      label309:
      label348:
      do
      {
        do
        {
          return;
          localObject1 = new PointF();
          if (!haD()) {
            break label1221;
          }
          if (!b.this.QJs) {
            break label468;
          }
          localObject2 = b.this.QIo.getLayout();
          i = ((Layout)localObject2).getLineForOffset(getCurrentCursorOffset());
          if (((Layout)localObject2).getLineBottom(i) - ((Layout)localObject2).getLineTop(i) < b.this.QJt) {
            break;
          }
          i = 1;
          if (i != 0) {
            break label1221;
          }
          n = getMagnifierHandleTrigger();
          switch (n)
          {
          default: 
            j = -1;
            i = 0;
            if (j != -1) {
              break label631;
            }
            i = 0;
            if (i == 0) {
              break label1221;
            }
            i = 1;
            if (i == 0) {
              break label1340;
            }
            b.this.QIK = true;
            b.this.QIo.gZr();
            b.this.gZR();
            paramMotionEvent = b.this.QIy;
            f1 = ((PointF)localObject1).x;
            f2 = ((PointF)localObject1).y;
            if ((!paramMotionEvent.QKF) || (f2 == paramMotionEvent.riL)) {
              break label1227;
            }
            i = 1;
            if (i == 0) {
              break label1252;
            }
            if (!paramMotionEvent.dgN.isRunning()) {
              break label1233;
            }
            paramMotionEvent.dgN.cancel();
            paramMotionEvent.QKG = paramMotionEvent.QKI;
            paramMotionEvent.QKH = paramMotionEvent.QKJ;
            paramMotionEvent.dgN.start();
            paramMotionEvent.riK = f1;
            paramMotionEvent.riL = f2;
            paramMotionEvent.QKF = true;
            paramMotionEvent = null;
            if (Build.VERSION.SDK_INT < 29) {
              break label1282;
            }
            paramMotionEvent = b.this.QIy.QKE.getPosition();
          }
        } while ((paramMotionEvent == null) || (Build.VERSION.SDK_INT < 28));
        paramMotionEvent = new Rect(paramMotionEvent.x, paramMotionEvent.y, paramMotionEvent.x + b.this.QIy.QKE.getWidth(), paramMotionEvent.y + b.this.QIy.QKE.getHeight());
        if (a(this, paramMotionEvent)) {
          break label1328;
        }
        bool = true;
        setVisible(bool);
        localObject1 = getOtherSelectionHandle();
      } while (localObject1 == null);
      label424:
      if (!a((f)localObject1, paramMotionEvent)) {}
      for (boolean bool = true;; bool = false)
      {
        ((f)localObject1).setVisible(bool);
        return;
        i = 0;
        break;
        label468:
        f1 = 0.0F;
        if (Build.VERSION.SDK_INT >= 28) {
          f1 = Math.round(b.this.QIy.QKE.getHeight() / b.this.QIy.QKE.getZoom());
        }
        localObject2 = b.this.QIo.getPaint().getFontMetrics();
        if ((((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent) * this.QKb > f1)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        j = b.this.QIo.getSelectionStart();
        i = -1;
        break label178;
        j = b.this.QIo.getSelectionStart();
        i = b.this.QIo.getSelectionEnd();
        break label178;
        j = b.this.QIo.getSelectionEnd();
        i = b.this.QIo.getSelectionStart();
        break label178;
        label631:
        int i1;
        label646:
        int k;
        label688:
        int m;
        label703:
        label742:
        label752:
        float f3;
        if (paramMotionEvent.getActionMasked() == 0)
        {
          this.QJZ = paramMotionEvent.getRawX();
          localObject2 = b.this.QIo.getLayout();
          i1 = ((Layout)localObject2).getLineForOffset(j);
          if ((i == -1) || (i1 != ((Layout)localObject2).getLineForOffset(i))) {
            break label1013;
          }
          k = 1;
          if (k == 0) {
            break label1031;
          }
          if (j >= i) {
            break label1019;
          }
          m = 1;
          if (b(b.this.QIo.getLayout(), j) >= b(b.this.QIo.getLayout(), i)) {
            break label1025;
          }
          j = 1;
          if (m == j) {
            break label1031;
          }
          j = 1;
          localObject2 = new int[2];
          b.this.QIo.getLocationOnScreen((int[])localObject2);
          f3 = paramMotionEvent.getRawX() - localObject2[0];
          f1 = b.this.QIo.getTotalPaddingLeft() - b.this.QIo.getScrollX();
          f2 = b.this.QIo.getTotalPaddingLeft() - b.this.QIo.getScrollX();
          if (k == 0) {
            break label1043;
          }
          if (n != 2) {
            break label1037;
          }
          m = 1;
          label841:
          if ((m ^ j) == 0) {
            break label1043;
          }
          f1 = b(b.this.QIo.getLayout(), i) + f1;
          label868:
          if (k == 0) {
            break label1070;
          }
          if (n != 1) {
            break label1064;
          }
          k = 1;
          label882:
          if ((j ^ k) == 0) {
            break label1070;
          }
        }
        float f4;
        label1025:
        label1031:
        label1037:
        label1043:
        label1064:
        label1070:
        for (f2 = b(b.this.QIo.getLayout(), i) + f2;; f2 = b.this.QIo.getLayout().getLineRight(i1) + f2)
        {
          f4 = this.QKa * f1;
          f2 = this.QKa * f2;
          f1 = 0.0F;
          if (Build.VERSION.SDK_INT >= 28) {
            f1 = Math.round(b.this.QIy.QKE.getWidth() / b.this.QIy.QKE.getZoom());
          }
          if ((f3 >= f4 - f1 / 2.0F) && (f3 <= f1 / 2.0F + f2)) {
            break label1091;
          }
          i = 0;
          break;
          if (paramMotionEvent.getActionMasked() != 1) {
            break label646;
          }
          this.QJZ = -1.0F;
          break label646;
          label1013:
          k = 0;
          break label688;
          label1019:
          m = 0;
          break label703;
          j = 0;
          break label742;
          j = 0;
          break label752;
          m = 0;
          break label841;
          f1 = b.this.QIo.getLayout().getLineLeft(i1) + f1;
          break label868;
          k = 0;
          break label882;
        }
        label1091:
        if (this.QKa == 1.0F) {}
        for (f1 = f3;; f1 = (paramMotionEvent.getRawX() - this.QJZ) * this.QKa + this.QJZ - localObject2[0])
        {
          ((PointF)localObject1).x = Math.max(f4, Math.min(f2, f1));
          ((PointF)localObject1).y = (((b.this.QIo.getLayout().getLineTop(i1) + b.this.QIo.getLayout().getLineBottom(i1)) / 2.0F + b.this.QIo.getTotalPaddingTop() - b.this.QIo.getScrollY()) * this.QKb);
          i = 1;
          break;
        }
        label1221:
        i = 0;
        break label195;
        label1227:
        i = 0;
        break label264;
        label1233:
        paramMotionEvent.QKG = paramMotionEvent.riK;
        paramMotionEvent.QKH = paramMotionEvent.riL;
        break label302;
        label1252:
        if ((paramMotionEvent.dgN.isRunning()) || (Build.VERSION.SDK_INT < 28)) {
          break label309;
        }
        paramMotionEvent.QKE.show(f1, f2);
        break label309;
        label1282:
        if (Build.VERSION.SDK_INT != 28) {
          break label348;
        }
        paramMotionEvent = (Point)new com.tencent.mm.ui.widget.cedit.util.a(b.this.QIy.QKE, "getWindowCoords", new Class[0]).invoke(new Object[0]);
        break label348;
        label1328:
        bool = false;
        break label424;
      }
      label1340:
      haE();
    }
    
    public float b(Layout paramLayout, int paramInt)
    {
      return paramLayout.getPrimaryHorizontal(paramInt);
    }
    
    protected int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      return b.this.QIo.B(paramInt, paramFloat);
    }
    
    final void b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.QJF = paramDrawable1;
      this.QJG = paramDrawable2;
      Db(true);
    }
    
    protected abstract int c(Drawable paramDrawable, boolean paramBoolean);
    
    int c(Layout paramLayout, int paramInt)
    {
      return (int)(b(paramLayout, paramInt) - 0.5F);
    }
    
    protected void dismiss()
    {
      this.okz = false;
      this.QJH.dismiss();
      onDetached();
    }
    
    protected abstract void g(float paramFloat1, float paramFloat2, boolean paramBoolean);
    
    public abstract int getCurrentCursorOffset();
    
    protected int getCursorOffset()
    {
      return 0;
    }
    
    final int getIdealFingerToCursorOffset()
    {
      return this.QKc;
    }
    
    public float getIdealVerticalOffset()
    {
      return this.QJR;
    }
    
    protected abstract int getMagnifierHandleTrigger();
    
    protected final int getPreferredHeight()
    {
      return Math.max(getDrawWidth(), this.DAQ);
    }
    
    protected final int getPreferredWidth()
    {
      return Math.max(getDrawWidth(), this.DAQ);
    }
    
    protected final void haE()
    {
      if (b.this.QIy != null)
      {
        b.this.QIy.dismiss();
        b.this.QIK = false;
        b.this.gZS();
        setVisible(true);
        f localf = getOtherSelectionHandle();
        if (localf != null) {
          localf.setVisible(true);
        }
      }
    }
    
    void haF() {}
    
    public final void hide()
    {
      dismiss();
      b.this.gZW().c(this);
    }
    
    public final void i(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      m(getCurrentCursorOffset(), paramBoolean2, false);
      if ((paramBoolean1) || (this.QJW))
      {
        if (this.okz)
        {
          if ((paramInt1 != this.QJS) || (paramInt2 != this.QJT))
          {
            this.QJM += paramInt1 - this.QJS;
            this.QJN += paramInt2 - this.QJT;
            this.QJS = paramInt1;
            this.QJT = paramInt2;
          }
          haF();
        }
        if (!haC()) {
          break label166;
        }
        paramInt1 = this.QJI + paramInt1;
        paramInt2 = this.QJJ + paramInt2;
        this.QJK = paramInt1;
        this.QJL = paramInt2;
        if (!isShowing()) {
          break label146;
        }
        this.QJH.update(paramInt1, paramInt2, -1, -1);
      }
      for (;;)
      {
        this.QJW = false;
        return;
        label146:
        this.QJH.showAtLocation(b.this.QIo, 0, paramInt1, paramInt2);
        continue;
        label166:
        if (isShowing()) {
          dismiss();
        }
      }
    }
    
    public void invalidate()
    {
      super.invalidate();
      if (isShowing()) {
        m(getCurrentCursorOffset(), true, false);
      }
    }
    
    public boolean isShowing()
    {
      return this.QJH.isShowing();
    }
    
    protected void m(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (b.this.QIo.getLayout() == null) {
        b.this.gZP();
      }
      for (;;)
      {
        return;
        Layout localLayout = b.this.QIo.getLayout();
        if (paramInt != this.AiE) {}
        for (int i = 1; (i != 0) || (paramBoolean1); i = 0)
        {
          if (i != 0)
          {
            Gn(paramInt);
            if ((paramBoolean2) && (b.this.QIx)) {
              b.this.QIo.performHapticFeedback(9);
            }
            aoB(paramInt);
          }
          i = localLayout.getLineForOffset(paramInt);
          this.QJX = i;
          this.QJI = (c(localLayout, paramInt) - this.QJO - getHorizontalOffset() + getCursorOffset());
          this.QJJ = localLayout.getLineBottom(i);
          this.QJI += b.this.QIo.gZy();
          this.QJJ += b.this.QIo.gZz();
          this.AiE = paramInt;
          this.QJW = true;
          return;
        }
      }
    }
    
    public void onDetached() {}
    
    protected void onDraw(Canvas paramCanvas)
    {
      int i = getDrawWidth();
      int j = getDrawHeight();
      int k = getHorizontalOffset();
      this.mDrawable.setBounds(k, 0, i + k, j);
      this.mDrawable.draw(paramCanvas);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      setMeasuredDimension(getPreferredWidth(), getPreferredHeight());
    }
    
    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (Build.VERSION.SDK_INT >= 29) {
        setSystemGestureExclusionRects(Collections.singletonList(new Rect(0, 0, paramInt1, paramInt2)));
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      b.this.ap(paramMotionEvent);
      int i;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        return true;
      case 0: 
        i = getCurrentCursorOffset();
        this.QKg = 0;
        aoB(i);
        b.l locall = b.this.gZW();
        this.QJS = locall.QJI;
        this.QJT = locall.QJJ;
        this.QJU = locall.QKN;
        this.QJV = locall.QKO;
        f1 = paramMotionEvent.getRawX();
        f2 = this.QJU;
        f3 = this.QJS;
        f4 = paramMotionEvent.getRawY();
        f5 = this.QJV;
        f6 = this.QJT;
        this.QJM = (f1 - f2 + f3 - this.QJI);
        this.QJN = (f4 - f5 + f6 - this.QJJ);
        this.okz = true;
        this.QJY = -1;
        return true;
      case 2: 
        f2 = paramMotionEvent.getRawX();
        f3 = this.QJU;
        f4 = this.QJS;
        f1 = paramMotionEvent.getRawY();
        f5 = this.QJV;
        f5 = this.QJT + (f1 - f5);
        f1 = this.QJN - this.QJT;
        f6 = f5 - this.QJJ - this.QJT;
        if (f1 < this.QJR) {}
        for (f1 = Math.max(Math.min(f6, this.QJR), f1);; f1 = Math.min(Math.max(f6, this.QJR), f1))
        {
          this.QJN = (f1 + this.QJT);
          g(f4 + (f2 - f3) - this.QJM + this.QJO + getHorizontalOffset(), f5 - this.QJN + this.QJQ, paramMotionEvent.isFromSource(4098));
          return true;
        }
      case 1: 
        boolean bool = paramMotionEvent.isFromSource(4098);
        long l = SystemClock.uptimeMillis();
        i = this.QKf;
        int k = Math.min(this.QKg, 5);
        int j = 0;
        while ((j < k) && (l - this.QKd[i] < 150L))
        {
          j += 1;
          i = (this.QKf - j + 5) % 5;
        }
        if ((j > 0) && (j < k) && (l - this.QKd[i] > 350L)) {
          m(this.QKe[i], false, bool);
        }
        break;
      }
      this.okz = false;
      Db(false);
      return true;
    }
    
    public void setTargetWidth(int paramInt)
    {
      this.irF = paramInt;
    }
    
    public void show()
    {
      if (isShowing()) {
        return;
      }
      b.this.gZW().a(this, true);
      this.AiE = -1;
      m(getCurrentCursorOffset(), false, false);
    }
  }
  
  static final class g
  {
    CharSequence QKh;
    CustomTextView.c QKi;
    boolean QKj;
    LocaleList QKk;
    Bundle extras;
    int imeActionId;
    int imeOptions = 0;
    String privateImeOptions;
  }
  
  static final class h
  {
    int QIp;
    ExtractedTextRequest QKl;
    final ExtractedText QKm;
    boolean QKn;
    boolean QKo;
    int QKp;
    int QKq;
    int QKr;
    boolean mContentChanged;
    
    h()
    {
      AppMethodBeat.i(205885);
      this.QKm = new ExtractedText();
      AppMethodBeat.o(205885);
    }
  }
  
  final class i
    extends b.f
  {
    private boolean PkW;
    private float QKs;
    private float QKt;
    private Runnable QKu;
    private boolean QKv;
    private final int QKw;
    private final int QKx;
    
    i(Drawable paramDrawable)
    {
      super(paramDrawable, paramDrawable, 2131302686, (byte)0);
      AppMethodBeat.i(205887);
      this.PkW = false;
      this.QKv = false;
      this.QKx = 0;
      this.QKw = 255;
      AppMethodBeat.o(205887);
    }
    
    private void haG()
    {
      AppMethodBeat.i(205888);
      if (this.QKu == null) {
        this.QKu = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205886);
            b.i.this.hide();
            AppMethodBeat.o(205886);
          }
        };
      }
      for (;;)
      {
        b.this.QIo.postDelayed(this.QKu, 4000L);
        AppMethodBeat.o(205888);
        return;
        haH();
      }
    }
    
    private void haH()
    {
      AppMethodBeat.i(205889);
      if (this.QKu != null) {
        b.this.QIo.removeCallbacks(this.QKu);
      }
      AppMethodBeat.o(205889);
    }
    
    protected final void Db(boolean paramBoolean)
    {
      AppMethodBeat.i(205898);
      super.Db(paramBoolean);
      this.mDrawable.setAlpha(this.QKw);
      AppMethodBeat.o(205898);
    }
    
    protected final int Dc(boolean paramBoolean)
    {
      return 1;
    }
    
    public final void Gn(int paramInt)
    {
      AppMethodBeat.i(205900);
      Selection.setSelection((Spannable)b.this.QIo.getText(), paramInt);
      AppMethodBeat.o(205900);
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(205890);
      int i = paramDrawable.getIntrinsicWidth() / 2;
      AppMethodBeat.o(205890);
      return i;
    }
    
    final int c(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(205892);
      if (b.this.QIY != null)
      {
        float f = b(paramLayout, paramInt);
        paramInt = b.this.a(b.this.QIY, f);
        int i = b.this.mTempRect.left;
        AppMethodBeat.o(205892);
        return paramInt + i;
      }
      paramInt = super.c(paramLayout, paramInt);
      AppMethodBeat.o(205892);
      return paramInt;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(205897);
      if (this.PkW)
      {
        this.QKv = true;
        this.mDrawable.setAlpha(0);
        AppMethodBeat.o(205897);
        return;
      }
      super.dismiss();
      this.QKv = false;
      AppMethodBeat.o(205897);
    }
    
    protected final void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      int i = -1;
      AppMethodBeat.i(205901);
      Layout localLayout = b.this.QIo.getLayout();
      if (localLayout != null)
      {
        if (this.QJY == -1) {
          this.QJY = b.this.QIo.cz(paramFloat2);
        }
        int j = b.this.a(localLayout, this.QJY, paramFloat2);
        i = b(localLayout, j, paramFloat1);
        this.QJY = j;
      }
      m(i, false, paramBoolean);
      if (b.this.QIu != null) {
        b.this.han();
      }
      AppMethodBeat.o(205901);
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(205899);
      int i = b.this.QIo.getSelectionStart();
      AppMethodBeat.o(205899);
      return i;
    }
    
    protected final int getCursorOffset()
    {
      AppMethodBeat.i(205891);
      int j = super.getCursorOffset();
      int i = j;
      if (b.this.QIY != null)
      {
        b.this.QIY.getPadding(b.this.mTempRect);
        i = j + (b.this.QIY.getIntrinsicWidth() - b.this.mTempRect.left - b.this.mTempRect.right) / 2;
      }
      AppMethodBeat.o(205891);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      return 0;
    }
    
    final void haF()
    {
      AppMethodBeat.i(205902);
      super.haF();
      haH();
      AppMethodBeat.o(205902);
    }
    
    public final boolean isShowing()
    {
      AppMethodBeat.i(205895);
      if (this.QKv)
      {
        AppMethodBeat.o(205895);
        return false;
      }
      boolean bool = super.isShowing();
      AppMethodBeat.o(205895);
      return bool;
    }
    
    public final void onDetached()
    {
      AppMethodBeat.i(205903);
      super.onDetached();
      haH();
      AppMethodBeat.o(205903);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205893);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(205893);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = 1;
      AppMethodBeat.i(205894);
      if (!b.this.QIo.c(paramMotionEvent, true))
      {
        AppMethodBeat.o(205894);
        return true;
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
      case 0: 
      case 2: 
        for (;;)
        {
          AppMethodBeat.o(205894);
          return bool;
          this.QKs = paramMotionEvent.getRawX();
          this.QKt = paramMotionEvent.getRawY();
          ar(paramMotionEvent);
          continue;
          ar(paramMotionEvent);
        }
      case 1: 
        if (this.QKg > 1)
        {
          label115:
          if (i != 0) {
            break label184;
          }
          ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.this.QIo.getContext());
          if (c.a(this.QKs, this.QKt, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), localViewConfiguration.getScaledTouchSlop())) {
            b.a(b.this);
          }
        }
        break;
      }
      for (;;)
      {
        haG();
        haE();
        break;
        i = 0;
        break label115;
        label184:
        if ((b.this.QIu != null) && (Build.VERSION.SDK_INT >= 23)) {
          b.this.QIu.invalidateContentRect();
        }
      }
    }
    
    public final void show()
    {
      AppMethodBeat.i(205896);
      super.show();
      this.QKv = false;
      this.mDrawable.setAlpha(this.QKw);
      AppMethodBeat.o(205896);
    }
  }
  
  public final class j
    implements b.d
  {
    boolean QKA;
    private boolean QKB;
    private int QKC;
    private b.i QKz;
    
    public j() {}
    
    final void as(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205906);
      Layout localLayout = b.this.QIo.getLayout();
      int i;
      if (this.QKC == -1) {
        i = b.this.a(localLayout, this.QKC, paramMotionEvent.getY());
      }
      for (;;)
      {
        this.QKC = i;
        i = b.this.QIo.B(this.QKC, paramMotionEvent.getX());
        int j = b.this.QIo.getSelectionStart();
        int k = b.this.QIo.getSelectionEnd();
        if ((i != j) || (i != k))
        {
          Selection.setSelection((Spannable)b.this.QIo.getText(), i);
          b.this.hah();
          if (b.this.QIx) {
            b.this.QIo.performHapticFeedback(9);
          }
        }
        haJ().ar(paramMotionEvent);
        AppMethodBeat.o(205906);
        return;
        int[] arrayOfInt = new int[2];
        b.this.QIo.getLocationOnScreen(arrayOfInt);
        if (b.this.QJj.QLs) {}
        for (float f1 = paramMotionEvent.getRawY() - arrayOfInt[1];; f1 = paramMotionEvent.getY())
        {
          float f2 = haJ().getIdealFingerToCursorOffset();
          i = b.this.a(localLayout, this.QKC, f1 - f2);
          if (!this.QKB) {
            break label256;
          }
          break;
        }
        label256:
        if (i < this.QKC) {
          i = Math.min(this.QKC, b.this.a(localLayout, this.QKC, f1));
        } else {
          this.QKB = true;
        }
      }
    }
    
    public final boolean haB()
    {
      return (this.QKA) || ((this.QKz != null) && (this.QKz.okz));
    }
    
    final void haI()
    {
      AppMethodBeat.i(205907);
      this.QKA = false;
      this.QKB = false;
      this.QKC = -1;
      haJ().haE();
      b.i.a(haJ());
      b.this.QIo.getParent().requestDisallowInterceptTouchEvent(false);
      AppMethodBeat.o(205907);
    }
    
    public final b.i haJ()
    {
      AppMethodBeat.i(205911);
      if (this.QKz == null)
      {
        b.this.CZ(false);
        this.QKz = new b.i(b.this, b.this.QJb);
      }
      b.i locali = this.QKz;
      AppMethodBeat.o(205911);
      return locali;
    }
    
    public final void haK()
    {
      AppMethodBeat.i(205914);
      if (this.QKz != null) {
        this.QKz.invalidate();
      }
      AppMethodBeat.o(205914);
    }
    
    public final void hide()
    {
      AppMethodBeat.i(205909);
      if (this.QKz != null) {
        this.QKz.hide();
      }
      AppMethodBeat.o(205909);
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(205913);
      if ((this.QKz != null) && (this.QKz.isShowing()))
      {
        AppMethodBeat.o(205913);
        return true;
      }
      AppMethodBeat.o(205913);
      return false;
    }
    
    public final void onDetached()
    {
      AppMethodBeat.i(205912);
      b.this.QIo.getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.QKz != null) {
        this.QKz.onDetached();
      }
      AppMethodBeat.o(205912);
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(205910);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(205910);
    }
    
    public final void show()
    {
      AppMethodBeat.i(205908);
      haJ().show();
      long l1 = SystemClock.uptimeMillis();
      long l2 = CustomTextView.QGm;
      if ((b.this.QJk != null) && ((this.QKA) || (b.this.QJj.haT()) || (b.this.hat()))) {
        b.this.QIo.removeCallbacks(b.this.QJk);
      }
      if ((!this.QKA) && (!b.this.QJj.haT()) && (!b.this.hat()) && (l1 - l2 < 15000L) && (b.this.ham()))
      {
        if (b.this.QJk == null) {
          b.this.QJk = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(205905);
              b.this.haj();
              AppMethodBeat.o(205905);
            }
          };
        }
        b.this.QIo.postDelayed(b.this.QJk, ViewConfiguration.getDoubleTapTimeout() + 1);
      }
      if (!this.QKA) {
        b.i.a(haJ());
      }
      if (b.this.QIt != null) {
        b.this.QIt.hide();
      }
      AppMethodBeat.o(205908);
    }
  }
  
  static final class k
  {
    final Magnifier QKE;
    boolean QKF;
    float QKG;
    float QKH;
    float QKI;
    float QKJ;
    final ValueAnimator dgN;
    float riK;
    float riL;
    
    private k(Magnifier paramMagnifier)
    {
      AppMethodBeat.i(205917);
      this.QKE = paramMagnifier;
      this.dgN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.dgN.setDuration(100L);
      this.dgN.setInterpolator(new LinearInterpolator());
      this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(205916);
          b.k.this.QKI = (b.k.this.QKG + (b.k.this.riK - b.k.this.QKG) * paramAnonymousValueAnimator.getAnimatedFraction());
          b.k.this.QKJ = (b.k.this.QKH + (b.k.this.riL - b.k.this.QKH) * paramAnonymousValueAnimator.getAnimatedFraction());
          if (Build.VERSION.SDK_INT >= 28) {
            b.k.this.QKE.show(b.k.this.QKI, b.k.this.QKJ);
          }
          AppMethodBeat.o(205916);
        }
      });
      AppMethodBeat.o(205917);
    }
    
    final void dismiss()
    {
      AppMethodBeat.i(205918);
      if (Build.VERSION.SDK_INT >= 28) {
        this.QKE.dismiss();
      }
      this.dgN.cancel();
      this.QKF = false;
      AppMethodBeat.o(205918);
    }
  }
  
  final class l
    implements ViewTreeObserver.OnPreDrawListener
  {
    int QJI;
    int QJJ;
    private boolean QJW;
    private b.p[] QKL;
    private boolean[] QKM;
    int QKN;
    int QKO;
    private int QKP;
    boolean QKQ;
    final int[] QKR;
    
    private l()
    {
      AppMethodBeat.i(205919);
      this.QKL = new b.p[7];
      this.QKM = new boolean[7];
      this.QJW = true;
      this.QKR = new int[2];
      AppMethodBeat.o(205919);
    }
    
    private void updatePosition()
    {
      AppMethodBeat.i(205923);
      b.this.QIo.getLocationInWindow(this.QKR);
      if ((this.QKR[0] != this.QJI) || (this.QKR[1] != this.QJJ)) {}
      for (boolean bool = true;; bool = false)
      {
        this.QJW = bool;
        this.QJI = this.QKR[0];
        this.QJJ = this.QKR[1];
        b.this.QIo.getLocationOnScreen(this.QKR);
        this.QKN = this.QKR[0];
        this.QKO = this.QKR[1];
        AppMethodBeat.o(205923);
        return;
      }
    }
    
    public final void a(b.p paramp, boolean paramBoolean)
    {
      AppMethodBeat.i(205920);
      if (this.QKP == 0)
      {
        updatePosition();
        b.this.QIo.getViewTreeObserver().addOnPreDrawListener(this);
      }
      int j = -1;
      int i = 0;
      while (i < 7)
      {
        b.p localp = this.QKL[i];
        if (localp == paramp)
        {
          AppMethodBeat.o(205920);
          return;
        }
        int k = j;
        if (j < 0)
        {
          k = j;
          if (localp == null) {
            k = i;
          }
        }
        i += 1;
        j = k;
      }
      this.QKL[j] = paramp;
      this.QKM[j] = paramBoolean;
      this.QKP += 1;
      AppMethodBeat.o(205920);
    }
    
    public final void c(b.p paramp)
    {
      AppMethodBeat.i(205921);
      int i = 0;
      for (;;)
      {
        if (i < 7)
        {
          if (this.QKL[i] == paramp)
          {
            this.QKL[i] = null;
            this.QKP -= 1;
          }
        }
        else
        {
          if (this.QKP == 0) {
            b.this.QIo.getViewTreeObserver().removeOnPreDrawListener(this);
          }
          AppMethodBeat.o(205921);
          return;
        }
        i += 1;
      }
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(205922);
      updatePosition();
      int i = 0;
      while (i < 7)
      {
        if ((this.QJW) || (this.QKQ) || (this.QKM[i] != 0))
        {
          b.p localp = this.QKL[i];
          if (localp != null) {
            localp.i(this.QJI, this.QJJ, this.QJW, this.QKQ);
          }
        }
        i += 1;
      }
      this.QKQ = false;
      AppMethodBeat.o(205922);
      return true;
    }
  }
  
  public final class m
    extends b.f
  {
    private final int QKS;
    private boolean QKT;
    private float QKU;
    private float QKV;
    private boolean QKW;
    private final float QKX;
    private final int[] QKY;
    
    public m(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
    {
      super(paramDrawable1, paramDrawable2, paramInt1, (byte)0);
      AppMethodBeat.i(205924);
      this.QKT = false;
      this.QKW = false;
      this.QKY = new int[2];
      this.QKS = paramInt2;
      this.QKX = (ViewConfiguration.get(b.this.QIo.getContext()).getScaledTouchSlop() * 4);
      AppMethodBeat.o(205924);
    }
    
    private static float a(Layout paramLayout, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(205935);
      int j = paramLayout.getLineForOffset(paramInt);
      int i;
      boolean bool;
      if (paramBoolean)
      {
        i = paramInt;
        bool = paramLayout.isRtlCharAt(i);
        if (paramLayout.getParagraphDirection(j) != -1) {
          break label70;
        }
      }
      label70:
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (bool != paramBoolean) {
          break label75;
        }
        f = paramLayout.getPrimaryHorizontal(paramInt);
        AppMethodBeat.o(205935);
        return f;
        i = Math.max(paramInt - 1, 0);
        break;
      }
      label75:
      float f = paramLayout.getSecondaryHorizontal(paramInt);
      AppMethodBeat.o(205935);
      return f;
    }
    
    private void bQ(int paramInt, boolean paramBoolean)
    {
      boolean bool2 = true;
      AppMethodBeat.i(205932);
      int i;
      int j;
      float f1;
      if (haL())
      {
        i = b.this.QIo.getSelectionEnd();
        if ((!haL()) || (paramInt < i))
        {
          j = paramInt;
          if (haL()) {
            break label240;
          }
          j = paramInt;
          if (paramInt > i) {
            break label240;
          }
        }
        this.QKU = 0.0F;
        localObject = b.this.QIo.getLayout();
        if ((localObject == null) || (paramInt == i)) {
          break label212;
        }
        f1 = b((Layout)localObject, paramInt);
        if (haL()) {
          break label206;
        }
      }
      label206:
      for (boolean bool1 = true;; bool1 = false)
      {
        float f2 = a((Layout)localObject, i, bool1);
        float f3 = b((Layout)localObject, this.AiE);
        if (((f3 >= f2) || (f1 >= f2)) && ((f3 <= f2) || (f1 <= f2))) {
          break label212;
        }
        paramInt = getCurrentCursorOffset();
        if (!haL()) {
          Math.max(paramInt - 1, 0);
        }
        m(0, false, paramBoolean);
        AppMethodBeat.o(205932);
        return;
        i = b.this.QIo.getSelectionStart();
        break;
      }
      label212:
      Object localObject = b.this;
      if (!haL()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        j = ((b)localObject).bP(i, bool1);
        label240:
        m(j, false, paramBoolean);
        AppMethodBeat.o(205932);
        return;
      }
    }
    
    private boolean haL()
    {
      return this.QKS == 0;
    }
    
    protected final int Dc(boolean paramBoolean)
    {
      AppMethodBeat.i(205926);
      if (paramBoolean == haL())
      {
        AppMethodBeat.o(205926);
        return 3;
      }
      AppMethodBeat.o(205926);
      return 5;
    }
    
    protected final void Gn(int paramInt)
    {
      AppMethodBeat.i(205928);
      if (haL()) {
        Selection.setSelection((Spannable)b.this.QIo.getText(), paramInt, b.this.QIo.getSelectionEnd());
      }
      for (;;)
      {
        Db(false);
        if (b.this.QIu != null) {
          b.this.han();
        }
        AppMethodBeat.o(205928);
        return;
        Selection.setSelection((Spannable)b.this.QIo.getText(), b.this.QIo.getSelectionStart(), paramInt);
      }
    }
    
    protected final boolean a(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(205933);
      if (haL()) {}
      for (;;)
      {
        boolean bool = paramLayout.isRtlCharAt(paramInt);
        AppMethodBeat.o(205933);
        return bool;
        paramInt = Math.max(paramInt - 1, 0);
      }
    }
    
    public final float b(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(205934);
      float f = a(paramLayout, paramInt, haL());
      AppMethodBeat.o(205934);
      return f;
    }
    
    protected final int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(205936);
      paramInt = paramLayout.getOffsetForHorizontal(paramInt, b.this.QIo.cy(paramFloat));
      AppMethodBeat.o(205936);
      return paramInt;
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(205925);
      if (paramBoolean == haL())
      {
        i = paramDrawable.getIntrinsicWidth() / 4;
        AppMethodBeat.o(205925);
        return i;
      }
      int i = paramDrawable.getIntrinsicWidth() * 3 / 4;
      AppMethodBeat.o(205925);
      return i;
    }
    
    protected final void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      AppMethodBeat.i(205929);
      Layout localLayout = b.this.QIo.getLayout();
      if (localLayout == null)
      {
        bQ(b.this.QIo.getOffsetForPosition(paramFloat1, paramFloat2), paramBoolean);
        AppMethodBeat.o(205929);
        return;
      }
      if (this.QJY == -1) {
        this.QJY = b.this.QIo.cz(paramFloat2);
      }
      int i;
      int i1;
      int j;
      if (haL())
      {
        i = b.this.QIo.getSelectionEnd();
        i1 = b.this.a(localLayout, this.QJY, paramFloat2);
        j = b(localLayout, i1, paramFloat1);
        if (((!haL()) || (j < i)) && ((haL()) || (j > i))) {
          break label1291;
        }
        i1 = localLayout.getLineForOffset(i);
        j = b(localLayout, i1, paramFloat1);
      }
      label641:
      label897:
      label1284:
      label1291:
      for (;;)
      {
        int k = b.a(b.this, j);
        int m = b.b(b.this, j);
        if (this.QKV == -1.0F) {
          this.QKV = paramFloat1;
        }
        int i2 = getCurrentCursorOffset();
        boolean bool1 = a(localLayout, i2);
        boolean bool2 = a(localLayout, j);
        if (((bool1) && (!bool2)) || ((!bool1) && (bool2)))
        {
          this.QKW = true;
          this.QKU = 0.0F;
          bQ(j, paramBoolean);
          AppMethodBeat.o(205929);
          return;
          i = b.this.QIo.getSelectionStart();
          break;
        }
        if (this.QKW)
        {
          bQ(j, paramBoolean);
          this.QKU = 0.0F;
          this.QKW = false;
          AppMethodBeat.o(205929);
          return;
        }
        paramFloat2 = paramFloat1 - this.QKV;
        int n;
        if (haL()) {
          if (i1 < this.QJY)
          {
            i = 1;
            if (bool2 != haL()) {
              break label610;
            }
            if (paramFloat2 <= 0.0F) {
              break label604;
            }
            n = 1;
            label357:
            n = i | n;
            if (!b.this.QIo.getHorizontallyScrolling()) {
              break label701;
            }
            b.this.QIo.getLocationOnScreen(this.QKY);
            if (bool2 != haL()) {
              break label641;
            }
            if (paramFloat1 <= this.QKY[0] + b.this.QIo.getWidth() - b.this.QIo.getPaddingRight() - this.QKX) {
              break label635;
            }
            i = 1;
            label442:
            if (i == 0) {
              break label701;
            }
            if ((!haL()) || (b.this.QIo.getScrollX() == 0))
            {
              if (haL()) {
                break label701;
              }
              CustomTextView localCustomTextView = b.this.QIo;
              if (!bool2) {
                break label681;
              }
              i = -1;
              label491:
              if (!localCustomTextView.canScrollHorizontally(i)) {
                break label701;
              }
            }
            if (((n == 0) || (((!haL()) || (j >= i2)) && ((haL()) || (j <= i2)))) && (n != 0)) {
              break label701;
            }
            this.QKU = 0.0F;
            if (bool2 != haL()) {
              break label687;
            }
          }
        }
        label681:
        label687:
        for (i = localLayout.getOffsetToRightOf(this.AiE);; i = localLayout.getOffsetToLeftOf(this.AiE))
        {
          bQ(i, paramBoolean);
          AppMethodBeat.o(205929);
          return;
          i = 0;
          break;
          if (i1 > this.QJY)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label604:
          n = 0;
          break label357;
          label610:
          if (paramFloat2 < 0.0F) {}
          for (n = 1;; n = 0)
          {
            n = i | n;
            break;
          }
          label635:
          i = 0;
          break label442;
          if (paramFloat1 < this.QKY[0] + b.this.QIo.getPaddingLeft() + this.QKX)
          {
            i = 1;
            break label442;
          }
          i = 0;
          break label442;
          i = 1;
          break label491;
        }
        label701:
        if (n != 0) {
          if (haL())
          {
            i = m;
            if (this.QKT)
            {
              if (!haL()) {
                break label944;
              }
              if (i1 >= this.QJX) {
                break label953;
              }
            }
            label740:
            if (bool2 != a(localLayout, i)) {
              break label953;
            }
            n = 1;
            label756:
            if (n == 0) {
              break label1284;
            }
            n = i;
            if (localLayout.getLineForOffset(i) != i1)
            {
              if (!haL()) {
                break label959;
              }
              n = localLayout.getLineStart(i1);
            }
            if (!haL()) {
              break label971;
            }
            n = k - (k - n) / 2;
            if (!haL()) {
              break label986;
            }
            i = m;
            if (j > n)
            {
              if (i1 >= this.QJX) {
                break label986;
              }
              i = m;
            }
          }
        }
        for (;;)
        {
          label793:
          label812:
          label843:
          if (((haL()) && (i < j)) || ((!haL()) && (i > j)))
          {
            paramFloat2 = b(localLayout, i);
            this.QKU = (b.this.QIo.cy(paramFloat1) - paramFloat2);
            k = 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            if (i != 0)
            {
              this.QJY = i1;
              bQ(j, paramBoolean);
            }
            this.QKV = paramFloat1;
            AppMethodBeat.o(205929);
            return;
            i = k;
            break;
            label944:
            if (i1 > this.QJX) {
              break label740;
            }
            label953:
            n = 0;
            break label756;
            label959:
            n = localLayout.getLineEnd(i1);
            break label793;
            label971:
            n = (n - m) / 2 + m;
            break label812;
            label986:
            if ((!haL()) && ((j >= n) || (i1 > this.QJX)))
            {
              i = k;
              break label843;
            }
            i = this.AiE;
            break label843;
            this.QKU = 0.0F;
            break label897;
            n = b(localLayout, i1, paramFloat1 - this.QKU);
            if (haL()) {
              if ((n > this.AiE) || (i1 > this.QJX))
              {
                i = 1;
                label1077:
                if (i == 0) {
                  break label1220;
                }
                if (i1 == this.QJX) {
                  break label1213;
                }
                if (!haL()) {
                  break label1198;
                }
                label1098:
                if (((!haL()) || (m >= j)) && ((haL()) || (m <= j))) {
                  break label1205;
                }
                paramFloat2 = b(localLayout, m);
                this.QKU = (b.this.QIo.cy(paramFloat1) - paramFloat2);
              }
            }
            for (;;)
            {
              i = 1;
              j = m;
              break;
              i = 0;
              break label1077;
              if ((n < this.AiE) || (i1 < this.QJX))
              {
                i = 1;
                break label1077;
              }
              i = 0;
              break label1077;
              label1198:
              m = k;
              break label1098;
              label1205:
              this.QKU = 0.0F;
              continue;
              label1213:
              m = n;
            }
            label1220:
            if (((haL()) && (n < this.AiE)) || ((!haL()) && (n > this.AiE))) {
              this.QKU = (b.this.QIo.cy(paramFloat1) - b(localLayout, this.AiE));
            }
            i = 0;
          }
          i = j;
        }
      }
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(205927);
      if (haL())
      {
        i = b.this.QIo.getSelectionStart();
        AppMethodBeat.o(205927);
        return i;
      }
      int i = b.this.QIo.getSelectionEnd();
      AppMethodBeat.o(205927);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      AppMethodBeat.i(205937);
      if (haL())
      {
        AppMethodBeat.o(205937);
        return 1;
      }
      AppMethodBeat.o(205937);
      return 2;
    }
    
    protected final void m(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(205930);
      super.m(paramInt, paramBoolean1, paramBoolean2);
      if (paramInt != -1)
      {
        com.tencent.mm.ui.widget.cedit.c.b localb = b.this.gZV();
        localb.aoK(paramInt);
        if (localb.QLS.isBoundary(paramInt)) {}
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        this.QKT = paramBoolean1;
        AppMethodBeat.o(205930);
        return;
      }
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205931);
      if (!b.this.QIo.c(paramMotionEvent, true))
      {
        AppMethodBeat.o(205931);
        return true;
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205931);
        return bool;
        this.QKU = 0.0F;
        this.QKV = -1.0F;
        ar(paramMotionEvent);
        continue;
        ar(paramMotionEvent);
        continue;
        haE();
      }
    }
  }
  
  public final class n
    implements b.d
  {
    private b.m QKZ;
    private b.m QLa;
    int QLb;
    int QLc;
    private boolean QLd;
    private int QLe;
    private boolean QLf;
    private int QLg;
    private boolean QLh;
    private int QLi;
    
    n()
    {
      AppMethodBeat.i(205938);
      this.QLe = -1;
      this.QLg = -1;
      this.QLh = false;
      this.QLi = 0;
      haN();
      AppMethodBeat.o(205938);
    }
    
    private void N(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(205948);
      if ((paramBoolean) && (b.this.QIx) && ((b.this.QIo.getSelectionStart() != paramInt1) || (b.this.QIo.getSelectionEnd() != paramInt2))) {}
      for (int i = 1;; i = 0)
      {
        Selection.setSelection((Spannable)b.this.QIo.getText(), paramInt1, paramInt2);
        if (i != 0) {
          b.this.QIo.performHapticFeedback(9);
        }
        AppMethodBeat.o(205948);
        return;
      }
    }
    
    private void at(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205944);
      if (b.this.QIo.getLayout() != null) {
        switch (this.QLi)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(205944);
        return;
        au(paramMotionEvent);
        AppMethodBeat.o(205944);
        return;
        av(paramMotionEvent);
        AppMethodBeat.o(205944);
        return;
        aw(paramMotionEvent);
      }
    }
    
    private void au(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205945);
      int i = b.this.QIo.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      N(this.QLe, i, paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(205945);
    }
    
    private void av(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205946);
      if (this.QLf)
      {
        AppMethodBeat.o(205946);
        return;
      }
      boolean bool = paramMotionEvent.isFromSource(8194);
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.this.QIo.getContext());
      float f3 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int j;
      int i;
      int k;
      if (bool)
      {
        j = b.this.QIo.cz(f2);
        i = b.this.QIo.B(j, f3);
        if (this.QLe < i)
        {
          i = b.a(b.this, i);
          k = b.b(b.this, this.QLe);
          label120:
          this.QLg = j;
          N(k, i, paramMotionEvent.isFromSource(4098));
          AppMethodBeat.o(205946);
        }
      }
      else
      {
        if (!this.QLh) {
          break label304;
        }
        i = localViewConfiguration.getScaledTouchSlop();
        if (this.QKZ != null) {
          f1 = this.QKZ.getIdealVerticalOffset();
        }
      }
      label176:
      for (float f1 = f2 - f1;; f1 = f2)
      {
        i = b.this.a(b.this.QIo.getLayout(), this.QLg, f1);
        j = i;
        if (this.QLh) {
          break;
        }
        j = i;
        if (i == this.QLg) {
          break;
        }
        this.QLh = true;
        AppMethodBeat.o(205946);
        return;
        f1 = i;
        break label176;
        int n = b.b(b.this, i);
        int m = b.a(b.this, this.QLe);
        k = m;
        i = n;
        if (m != n) {
          break label120;
        }
        i = b.this.bP(n, false);
        k = m;
        break label120;
      }
    }
    
    private void aw(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205947);
      int j = b.this.QIo.getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      int i = Math.min(j, this.QLe);
      j = Math.max(j, this.QLe);
      long l = b.this.lC(i, j);
      N((int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(205947);
    }
    
    private void haM()
    {
      AppMethodBeat.i(205940);
      if (this.QKZ == null) {
        this.QKZ = new b.m(b.this, b.this.QIZ, b.this.QJa, 2131307572, 0);
      }
      if (this.QLa == null) {
        this.QLa = new b.m(b.this, b.this.QJa, b.this.QIZ, 2131307571, 1);
      }
      this.QKZ.show();
      this.QLa.show();
      b.this.gZQ();
      AppMethodBeat.o(205940);
    }
    
    private void haO()
    {
      AppMethodBeat.i(205950);
      this.QLe = -1;
      this.QLi = 0;
      this.QLh = false;
      int i = b.this.QIo.getSelectionStart();
      int j = b.this.QIo.getSelectionEnd();
      if ((i < 0) || (j < 0))
      {
        Selection.removeSelection((Spannable)b.this.QIo.getText());
        AppMethodBeat.o(205950);
        return;
      }
      if (i > j) {
        Selection.setSelection((Spannable)b.this.QIo.getText(), j, i);
      }
      AppMethodBeat.o(205950);
    }
    
    public final void aoC(int paramInt)
    {
      AppMethodBeat.i(205942);
      show();
      this.QLi = paramInt;
      this.QLe = b.this.QIo.getOffsetForPosition(b.this.QJj.ovM, b.this.QJj.ovN);
      this.QLg = b.this.QIo.cz(b.this.QJj.ovN);
      hide();
      b.this.QIo.getParent().requestDisallowInterceptTouchEvent(true);
      b.this.QIo.cancelLongPress();
      AppMethodBeat.o(205942);
    }
    
    public final boolean haB()
    {
      AppMethodBeat.i(205951);
      if ((haQ()) || (haP()) || ((this.QLa != null) && (this.QLa.okz)))
      {
        AppMethodBeat.o(205951);
        return true;
      }
      AppMethodBeat.o(205951);
      return false;
    }
    
    public final void haN()
    {
      AppMethodBeat.i(205949);
      this.QLc = -1;
      this.QLb = -1;
      haO();
      AppMethodBeat.o(205949);
    }
    
    public final boolean haP()
    {
      return (this.QKZ != null) && (this.QKZ.okz);
    }
    
    public final boolean haQ()
    {
      return this.QLi != 0;
    }
    
    public final void haR()
    {
      AppMethodBeat.i(205955);
      if (this.QKZ != null) {
        this.QKZ.invalidate();
      }
      if (this.QLa != null) {
        this.QLa.invalidate();
      }
      AppMethodBeat.o(205955);
    }
    
    public final void hide()
    {
      AppMethodBeat.i(205941);
      if (this.QKZ != null) {
        this.QKZ.hide();
      }
      if (this.QLa != null) {
        this.QLa.hide();
      }
      AppMethodBeat.o(205941);
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(205954);
      if ((this.QKZ != null) && (this.QKZ.isShowing()))
      {
        AppMethodBeat.o(205954);
        return true;
      }
      AppMethodBeat.o(205954);
      return false;
    }
    
    public final void onDetached()
    {
      AppMethodBeat.i(205953);
      b.this.QIo.getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.QKZ != null) {
        this.QKZ.onDetached();
      }
      if (this.QLa != null) {
        this.QLa.onDetached();
      }
      AppMethodBeat.o(205953);
    }
    
    public final void onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = 0;
      boolean bool2 = false;
      AppMethodBeat.i(205943);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      boolean bool3 = paramMotionEvent.isFromSource(8194);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205943);
        return;
        if (b.this.has())
        {
          hide();
          AppMethodBeat.o(205943);
          return;
        }
        i = b.this.QIo.getOffsetForPosition(f1, f2);
        this.QLc = i;
        this.QLb = i;
        if (this.QLd)
        {
          paramMotionEvent = b.this.QJj;
          if ((!paramMotionEvent.haT()) || (!paramMotionEvent.QLu)) {
            break label252;
          }
          i = 1;
          if ((i != 0) && ((bool3) || (b.this.az(f1, f2)) || (b.this.QJj.QLs)))
          {
            if (b.this.QJj.QLt != 2) {
              break label258;
            }
            i = 1;
            label214:
            if (i == 0) {
              break label264;
            }
            b.b(b.this);
          }
        }
        label252:
        boolean bool1;
        label258:
        label264:
        label281:
        label373:
        label375:
        int j;
        label449:
        for (;;)
        {
          b.this.QII = true;
          this.QLd = true;
          this.QLf = true;
          AppMethodBeat.o(205943);
          return;
          i = 0;
          break;
          i = 0;
          break label214;
          if (b.this.QJj.QLt == 3)
          {
            i = 1;
            if (i == 0) {
              break label373;
            }
            if (b.this.QJk != null) {
              b.this.QIo.removeCallbacks(b.this.QJk);
            }
            b.this.gZE();
            paramMotionEvent = b.this;
            bool1 = bool2;
            if (paramMotionEvent.QIo.gZC())
            {
              if (!paramMotionEvent.gZT()) {
                break label375;
              }
              bool1 = paramMotionEvent.QIo.gZJ();
            }
          }
          for (;;)
          {
            if (!bool1) {
              break label449;
            }
            aoC(3);
            break;
            i = 0;
            break label281;
            break;
            long l = paramMotionEvent.gZZ();
            l = paramMotionEvent.lC((int)(l >>> 32), (int)(l & 0xFFFFFFFF));
            i = (int)(l >>> 32);
            j = (int)(l & 0xFFFFFFFF);
            bool1 = bool2;
            if (i < j)
            {
              Selection.setSelection((Spannable)paramMotionEvent.QIo.getText(), i, j);
              bool1 = true;
            }
          }
        }
        if (b.this.QIo.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct"))
        {
          j = paramMotionEvent.getPointerCount();
          while (i < j)
          {
            int k = b.this.QIo.getOffsetForPosition(paramMotionEvent.getX(i), paramMotionEvent.getY(i));
            if (k < this.QLb) {
              this.QLb = k;
            }
            if (k > this.QLc) {
              this.QLc = k;
            }
            i += 1;
          }
          AppMethodBeat.o(205943);
          return;
          if (this.QLd)
          {
            ViewConfiguration.get(b.this.QIo.getContext());
            i = at.fromDPToPix(b.this.QIo.getContext(), 8);
            this.QLd = c.a(b.this.QJj.ovM, b.this.QJj.ovN, f1, f2, i);
          }
          if (this.QLf) {
            if (b.this.QJj.QLv) {
              break label753;
            }
          }
          label753:
          for (bool1 = true;; bool1 = false)
          {
            this.QLf = bool1;
            if ((!bool3) || (haQ())) {
              break label793;
            }
            i = b.this.QIo.getOffsetForPosition(f1, f2);
            if ((!b.this.QIo.hasSelection()) || ((this.QLf) && (this.QLe == i)) || (i < b.this.QIo.getSelectionStart()) || (i > b.this.QIo.getSelectionEnd())) {
              break;
            }
            b.c(b.this);
            AppMethodBeat.o(205943);
            return;
          }
          if (this.QLe != i)
          {
            b.this.gZE();
            aoC(1);
            b.this.QII = true;
            this.QLf = false;
          }
          label793:
          if ((this.QKZ == null) || (!this.QKZ.isShowing()))
          {
            at(paramMotionEvent);
            AppMethodBeat.o(205943);
            return;
            if (haQ())
            {
              at(paramMotionEvent);
              b.this.QIo.getParent().requestDisallowInterceptTouchEvent(false);
              haO();
              if (b.this.QIo.hasSelection())
              {
                b.this.hao().haU();
                b.this.QIo.invalidate();
              }
            }
          }
        }
      }
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(205952);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(205952);
    }
    
    public final void show()
    {
      AppMethodBeat.i(205939);
      if (b.this.QIo.gZK())
      {
        AppMethodBeat.o(205939);
        return;
      }
      b.this.CZ(false);
      haM();
      AppMethodBeat.o(205939);
    }
  }
  
  @SuppressLint({"NewApi"})
  final class o
    extends ActionMode.Callback2
  {
    private final Path QLj;
    private final RectF QLk;
    private final boolean QLl;
    private final int QLm;
    private final Map<MenuItem, View.OnClickListener> QLn;
    
    o(int paramInt)
    {
      AppMethodBeat.i(205958);
      this.QLj = new Path();
      this.QLk = new RectF();
      this.QLn = new HashMap();
      if ((paramInt == 0) || ((b.this.QIO) && (paramInt == 2))) {}
      for (boolean bool = true;; bool = false)
      {
        this.QLl = bool;
        if (!this.QLl) {
          break;
        }
        localObject = b.this.hax();
        if (b.n.a((b.n)localObject) == null)
        {
          b.this.CZ(false);
          b.n.b((b.n)localObject);
          ((b.n)localObject).hide();
        }
        this.QLm = Math.max(b.this.QIZ.getMinimumHeight(), b.this.QJa.getMinimumHeight());
        AppMethodBeat.o(205958);
        return;
      }
      Object localObject = b.this.haw();
      if (localObject != null)
      {
        ((b.j)localObject).haJ();
        this.QLm = b.this.QJb.getMinimumHeight();
        AppMethodBeat.o(205958);
        return;
      }
      this.QLm = 0;
      AppMethodBeat.o(205958);
    }
    
    private void f(Menu paramMenu)
    {
      AppMethodBeat.i(205961);
      boolean bool = b.this.QIo.gZI();
      if (paramMenu.findItem(16908319) != null) {}
      for (int i = 1; (bool) && (i == 0); i = 0)
      {
        paramMenu.add(0, 16908319, 8, 17039373).setShowAsAction(1);
        AppMethodBeat.o(205961);
        return;
      }
      if ((!bool) && (i != 0)) {
        paramMenu.removeItem(16908319);
      }
      AppMethodBeat.o(205961);
    }
    
    private ActionMode.Callback haS()
    {
      if (this.QLl) {
        return b.this.QJf;
      }
      return b.this.QJg;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205962);
      b.this.hao();
      paramMenuItem.getItemId();
      paramMenuItem.getTitle().toString();
      ActionMode.Callback localCallback = haS();
      if ((localCallback != null) && (localCallback.onActionItemClicked(paramActionMode, paramMenuItem)))
      {
        AppMethodBeat.o(205962);
        return true;
      }
      if (paramMenuItem.getGroupId() == 16908353)
      {
        if (paramMenuItem.getGroupId() == 16908353) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool);
          b.this.hao();
          AppMethodBeat.o(205962);
          return true;
        }
      }
      boolean bool = b.this.QIo.onTextContextMenuItem(paramMenuItem.getItemId());
      AppMethodBeat.o(205962);
      return bool;
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(205959);
      this.QLn.clear();
      paramActionMode.setTitle(null);
      paramActionMode.setSubtitle(null);
      paramActionMode.setTitleOptionalHint(true);
      if (b.this.QIo.gZF()) {
        paramMenu.add(0, 16908320, 4, 17039363).setAlphabeticShortcut('x').setShowAsAction(2);
      }
      if (b.this.QIo.gZG()) {
        paramMenu.add(0, 16908321, 5, 17039361).setAlphabeticShortcut('c').setShowAsAction(2);
      }
      if (b.this.QIo.gZH()) {
        paramMenu.add(0, 16908322, 6, 17039371).setAlphabeticShortcut('v').setShowAsAction(2);
      }
      f(paramMenu);
      ActionMode.Callback localCallback = haS();
      if ((localCallback != null) && (!localCallback.onCreateActionMode(paramActionMode, paramMenu)))
      {
        Selection.setSelection((Spannable)b.this.QIo.getText(), b.this.QIo.getSelectionEnd());
        AppMethodBeat.o(205959);
        return false;
      }
      if ((this.QLl) && (!b.this.QIo.hasTransientState())) {
        b.this.QIo.setHasTransientState(true);
      }
      AppMethodBeat.o(205959);
      return true;
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      AppMethodBeat.i(205963);
      b.this.hao();
      b.this.QIu = null;
      ActionMode.Callback localCallback = haS();
      if (localCallback != null) {
        localCallback.onDestroyActionMode(paramActionMode);
      }
      if (!b.this.QIR) {
        Selection.setSelection((Spannable)b.this.QIo.getText(), b.this.QIo.getSelectionEnd());
      }
      if (b.this.QIt != null) {
        b.this.QIt.hide();
      }
      this.QLn.clear();
      b.this.QIT = false;
      AppMethodBeat.o(205963);
    }
    
    public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect)
    {
      AppMethodBeat.i(205964);
      Log.i("cmEdit.Editor", "onGetContentRect mode:" + paramActionMode + ",view:" + paramView + ",outRect:" + paramRect);
      if ((!paramView.equals(b.this.QIo)) || (b.this.QIo.getLayout() == null))
      {
        super.onGetContentRect(paramActionMode, paramView, paramRect);
        AppMethodBeat.o(205964);
        return;
      }
      if (b.this.QIo.getSelectionStart() != b.this.QIo.getSelectionEnd())
      {
        this.QLj.reset();
        b.this.QIo.getLayout().getSelectionPath(b.this.QIo.getSelectionStart(), b.this.QIo.getSelectionEnd(), this.QLj);
        this.QLj.computeBounds(this.QLk, true);
        paramActionMode = this.QLk;
        paramActionMode.bottom += this.QLm;
      }
      for (;;)
      {
        int m = b.this.QIo.gZy();
        int i = b.this.QIo.gZz();
        int j = (int)Math.floor(this.QLk.left + m);
        int k = (int)Math.floor(this.QLk.top + i);
        float f = this.QLk.right;
        m = (int)Math.ceil(m + f);
        f = this.QLk.bottom;
        paramRect.set(j, k, m, (int)Math.ceil(i + f));
        AppMethodBeat.o(205964);
        return;
        paramActionMode = b.this.QIo.getLayout();
        i = paramActionMode.getLineForOffset(b.this.QIo.getSelectionStart());
        f = b.this.a(null, paramActionMode.getPrimaryHorizontal(b.this.QIo.getSelectionStart()));
        this.QLk.set(f, paramActionMode.getLineTop(i), f, paramActionMode.getLineBottom(i) + this.QLm);
      }
    }
    
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(205960);
      f(paramMenu);
      ActionMode.Callback localCallback = haS();
      if (localCallback != null)
      {
        boolean bool = localCallback.onPrepareActionMode(paramActionMode, paramMenu);
        AppMethodBeat.o(205960);
        return bool;
      }
      AppMethodBeat.o(205960);
      return true;
    }
  }
  
  public static abstract interface p
  {
    public abstract void i(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.b
 * JD-Core Version:    0.7.0.1
 */