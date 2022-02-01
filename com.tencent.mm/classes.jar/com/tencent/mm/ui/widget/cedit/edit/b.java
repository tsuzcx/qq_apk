package com.tencent.mm.ui.widget.cedit.edit;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.os.Parcel;
import android.os.SystemClock;
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
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.cedit.util.ParcelableParcel;
import java.text.BreakIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b
{
  int OeF;
  boolean aeVV;
  boolean afZA;
  a afZB;
  boolean afZC;
  boolean afZD;
  boolean afZE;
  boolean afZF;
  boolean afZG;
  private boolean afZH;
  boolean afZI;
  private boolean afZJ;
  d afZK;
  boolean afZL;
  boolean afZM;
  Runnable afZN;
  Drawable afZO;
  Drawable afZP;
  Drawable afZQ;
  Drawable afZR;
  l afZS;
  private float afZT;
  private float afZU;
  ActionMode.Callback afZV;
  ActionMode.Callback afZW;
  boolean afZX;
  int afZY;
  final c afZZ;
  final CustomTextView afZe;
  boolean afZh;
  j afZi;
  n afZj;
  ActionMode afZk;
  boolean afZl;
  boolean afZm;
  private final boolean afZn;
  private k afZo;
  private final Runnable afZp;
  final ViewTreeObserver.OnDrawListener afZq;
  b afZr;
  g afZs;
  h afZt;
  boolean afZu;
  boolean afZv;
  boolean afZw;
  KeyListener afZx;
  boolean afZy;
  long afZz;
  Runnable agaa;
  private com.tencent.mm.ui.widget.cedit.c.b agab;
  private com.tencent.mm.ui.widget.cedit.c.b agac;
  private boolean agad;
  private final c agae;
  final Runnable agaf;
  boolean agag;
  private boolean agah;
  private final boolean agai;
  private int agaj;
  private float agak;
  private int agal;
  private int agam;
  private com.tencent.mm.ui.widget.cedit.a.a agan;
  private boolean agao;
  private Rect mTempRect;
  
  b(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(252439);
    this.afZh = true;
    this.afZp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252367);
        b.k localk = b.a(b.this);
        if (Build.VERSION.SDK_INT >= 28) {
          localk.agbv.update();
        }
        AppMethodBeat.o(252367);
      }
    };
    this.afZq = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(252395);
        if (b.a(b.this) != null) {
          b.c(b.this).post(b.b(b.this));
        }
        AppMethodBeat.o(252395);
      }
    };
    this.OeF = 0;
    this.afZC = true;
    this.afZG = true;
    this.afZO = null;
    this.afZZ = new c();
    this.agae = new c((byte)0);
    this.agaf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252390);
        if (b.d(b.this)) {
          b.e(b.this);
        }
        if ((b.f(b.this) != null) && (Build.VERSION.SDK_INT >= 23))
        {
          b.f(b.this).hide(0L);
          Log.i("cmEdit.Editor", "mTextActionMode.hide(0)");
        }
        AppMethodBeat.o(252390);
      }
    };
    this.agag = false;
    this.agak = 1.0F;
    this.agao = false;
    this.afZe = paramCustomTextView;
    this.afZe.setFilters(this.afZe.getFilters());
    this.afZn = false;
    this.agah = false;
    this.agai = false;
    this.agal = ((int)TypedValue.applyDimension(1, 45.0F, this.afZe.getContext().getResources().getDisplayMetrics()));
    this.agam = ((int)TypedValue.applyDimension(1, 12.0F, this.afZe.getContext().getResources().getDisplayMetrics()));
    AppMethodBeat.o(252439);
  }
  
  private int a(Drawable paramDrawable, float paramFloat)
  {
    AppMethodBeat.i(252565);
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
      j = this.afZe.getScrollX();
      f = paramFloat - j;
      k = this.afZe.getWidth() - this.afZe.getCompoundPaddingLeft() - this.afZe.getCompoundPaddingRight();
      if (f < k - 1.0F) {
        break label145;
      }
      i = k + j - (i - this.mTempRect.right);
    }
    for (;;)
    {
      AppMethodBeat.o(252565);
      return i;
      this.mTempRect.setEmpty();
      break;
      label145:
      if ((Math.abs(f) <= 1.0F) || ((TextUtils.isEmpty(this.afZe.getText())) && (1048576 - j <= k + 1.0F) && (paramFloat <= 1.0F))) {
        i = j - this.mTempRect.left;
      } else {
        i = (int)paramFloat - this.mTempRect.left;
      }
    }
  }
  
  private static Drawable a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(252576);
    if (!(paramDrawable instanceof BitmapDrawable))
    {
      AppMethodBeat.o(252576);
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(252576);
      return paramDrawable;
    }
    paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    float f1 = i / paramDrawable.getWidth();
    paramInt = bd.fromDPToPix(paramContext, paramInt);
    float f2 = paramInt;
    paramDrawable = Bitmap.createScaledBitmap(paramDrawable, (int)(i / j * f2 / f1), (int)(paramInt / f1), true);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramDrawable);
    AppMethodBeat.o(252576);
    return paramContext;
  }
  
  private void a(h paramh)
  {
    AppMethodBeat.i(252515);
    if ((paramh.mContentChanged) || (paramh.agbf))
    {
      this.afZe.jFC();
      jGm();
      jGn();
      if (!jGu()) {
        if (!this.afZe.jFB()) {
          break label110;
        }
      }
    }
    label110:
    for (paramh = jGF();; paramh = jGE())
    {
      if ((paramh != null) && (!paramh.isActive()) && (!paramh.jGJ())) {
        paramh.show();
      }
      AppMethodBeat.o(252515);
      return;
      if (!paramh.agbe) {
        break;
      }
      this.afZe.jFs();
      break;
    }
  }
  
  static void a(ParcelableParcel paramParcelableParcel)
  {
    AppMethodBeat.i(252445);
    paramParcelableParcel.cjB.setDataPosition(0);
    AppMethodBeat.o(252445);
  }
  
  private boolean bl(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252493);
    Layout localLayout = this.afZe.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(252493);
      return false;
    }
    int i = this.afZe.eg(paramFloat2);
    paramFloat1 = this.afZe.ef(paramFloat1);
    if (paramFloat1 < localLayout.getLineLeft(i))
    {
      AppMethodBeat.o(252493);
      return false;
    }
    if (paramFloat1 > localLayout.getLineRight(i))
    {
      AppMethodBeat.o(252493);
      return false;
    }
    AppMethodBeat.o(252493);
    return true;
  }
  
  private int cT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252487);
    Layout localLayout = this.afZe.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(252487);
      return paramInt;
    }
    if (paramBoolean == localLayout.isRtlCharAt(paramInt))
    {
      paramInt = localLayout.getOffsetToLeftOf(paramInt);
      AppMethodBeat.o(252487);
      return paramInt;
    }
    paramInt = localLayout.getOffsetToRightOf(paramInt);
    AppMethodBeat.o(252487);
    return paramInt;
  }
  
  private void hbK()
  {
    AppMethodBeat.i(252537);
    if (this.agan != null) {
      this.agan.dismiss();
    }
    AppMethodBeat.o(252537);
  }
  
  private void i(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(252561);
    jGI();
    int i = a(this.afZO, paramFloat);
    int j = this.afZO.getIntrinsicWidth();
    this.afZO.setBounds(i, paramInt1 - this.mTempRect.top, j + i, this.mTempRect.bottom + paramInt2);
    AppMethodBeat.o(252561);
  }
  
  static boolean jFT()
  {
    return false;
  }
  
  static boolean jFU()
  {
    return false;
  }
  
  private boolean jGB()
  {
    AppMethodBeat.i(252553);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])((Spannable)this.afZe.getText()).getSpans(this.afZe.getSelectionStart(), this.afZe.getSelectionEnd(), SuggestionSpan.class);
    int i = 0;
    while (i < arrayOfSuggestionSpan.length)
    {
      if ((arrayOfSuggestionSpan[i].getFlags() & 0x1) != 0)
      {
        AppMethodBeat.o(252553);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(252553);
    return false;
  }
  
  private void jGC()
  {
    AppMethodBeat.i(252557);
    jGw();
    this.afZk = null;
    jGt();
    if (!this.afZH) {
      Selection.setSelection((Spannable)this.afZe.getText(), this.afZe.getSelectionEnd());
    }
    if (this.afZj != null) {
      this.afZj.hide();
    }
    this.afZJ = false;
    AppMethodBeat.o(252557);
  }
  
  private boolean jGG()
  {
    AppMethodBeat.i(252571);
    if ((!jFW()) || (!this.afZe.isFocused()))
    {
      AppMethodBeat.o(252571);
      return false;
    }
    int i = this.afZe.getSelectionStart();
    if (i < 0)
    {
      AppMethodBeat.o(252571);
      return false;
    }
    int j = this.afZe.getSelectionEnd();
    if (j < 0)
    {
      AppMethodBeat.o(252571);
      return false;
    }
    if (i == j)
    {
      AppMethodBeat.o(252571);
      return true;
    }
    AppMethodBeat.o(252571);
    return false;
  }
  
  private boolean jGb()
  {
    AppMethodBeat.i(252459);
    if ((this.afZe.afXx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(252459);
      return true;
    }
    int j = this.afZe.getInputType();
    int i = j & 0xF;
    j &= 0xFF0;
    if ((i == 2) || (i == 3) || (i == 4) || (j == 16) || (j == 32) || (j == 208) || (j == 176))
    {
      AppMethodBeat.o(252459);
      return true;
    }
    AppMethodBeat.o(252459);
    return false;
  }
  
  private boolean jGc()
  {
    AppMethodBeat.i(252471);
    if (!this.afZe.jFF())
    {
      AppMethodBeat.o(252471);
      return false;
    }
    if (jGb())
    {
      boolean bool = this.afZe.jFO();
      AppMethodBeat.o(252471);
      return bool;
    }
    long l = jGh();
    int k = (int)(l >>> 32);
    int j = (int)(l & 0xFFFFFFFF);
    if ((k < 0) || (k > this.afZe.getText().length()))
    {
      AppMethodBeat.o(252471);
      return false;
    }
    if ((j < 0) || (j > this.afZe.getText().length()))
    {
      AppMethodBeat.o(252471);
      return false;
    }
    Object localObject = (URLSpan[])((Spanned)this.afZe.getText()).getSpans(k, j, URLSpan.class);
    int i;
    if (localObject.length > 0)
    {
      localObject = localObject[0];
      i = ((Spanned)this.afZe.getText()).getSpanStart(localObject);
      j = ((Spanned)this.afZe.getText()).getSpanEnd(localObject);
    }
    for (;;)
    {
      Selection.setSelection((Spannable)this.afZe.getText(), i, j);
      if (j > i)
      {
        AppMethodBeat.o(252471);
        return true;
        localObject = getWordIterator();
        ((com.tencent.mm.ui.widget.cedit.c.b)localObject).g(this.afZe.getText(), k, j);
        i = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).cV(k, false);
        j = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).cW(j, false);
        if ((i == -1) || (j == -1) || (i == j))
        {
          if (k < this.afZe.getText().length())
          {
            i = cT(k, true);
            l = com.tencent.mm.ui.widget.cedit.util.c.oO(cT(i, false), i);
          }
          for (;;)
          {
            i = (int)(l >>> 32);
            j = (int)(l & 0xFFFFFFFF);
            break;
            if (k - 1 >= 0)
            {
              i = cT(k, false);
              l = com.tencent.mm.ui.widget.cedit.util.c.oO(i, cT(i, true));
            }
            else
            {
              l = com.tencent.mm.ui.widget.cedit.util.c.oO(k, k);
            }
          }
        }
      }
      else
      {
        AppMethodBeat.o(252471);
        return false;
      }
    }
  }
  
  private com.tencent.mm.ui.widget.cedit.c.b jGd()
  {
    AppMethodBeat.i(252482);
    if (this.agac == null)
    {
      this.agac = new com.tencent.mm.ui.widget.cedit.c.b(this.afZe.getTextServicesLocale());
      this.agad = true;
    }
    if (this.agad)
    {
      localObject = this.afZe.getText();
      this.agac.g((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      this.agad = false;
    }
    Object localObject = this.agac;
    AppMethodBeat.o(252482);
    return localObject;
  }
  
  private l jGe()
  {
    AppMethodBeat.i(252489);
    if (this.afZS == null) {
      this.afZS = new l((byte)0);
    }
    l locall = this.afZS;
    AppMethodBeat.o(252489);
    return locall;
  }
  
  private void jGf()
  {
    AppMethodBeat.i(252497);
    jGw();
    if (CustomTextView.jFH())
    {
      AppMethodBeat.o(252497);
      return;
    }
    int i = this.afZe.getSelectionStart();
    int j = this.afZe.getSelectionEnd();
    ClipData.newPlainText(null, this.afZe.oL(i, j));
    new e(this.afZe, i, j);
    jFJ();
    if (this.afZm) {
      jGF().jGW();
    }
    AppMethodBeat.o(252497);
  }
  
  private void jGg()
  {
    AppMethodBeat.i(252499);
    if (!jGu())
    {
      jFJ();
      AppMethodBeat.o(252499);
      return;
    }
    jGr();
    AppMethodBeat.o(252499);
  }
  
  private long jGh()
  {
    AppMethodBeat.i(252506);
    n localn = jGF();
    long l = com.tencent.mm.ui.widget.cedit.util.c.oO(localn.agbS, localn.agbT);
    AppMethodBeat.o(252506);
    return l;
  }
  
  private void jGk()
  {
    AppMethodBeat.i(252511);
    int i = ViewConfiguration.getDoubleTapTimeout();
    this.afZe.postDelayed(this.agaf, i);
    jGw().jHe();
    AppMethodBeat.o(252511);
  }
  
  private void jGn()
  {
    AppMethodBeat.i(252521);
    InputMethodManager localInputMethodManager;
    int k;
    int m;
    int i;
    int j;
    if ((this.afZt != null) && (this.afZt.afZf <= 0))
    {
      localInputMethodManager = getInputMethodManager();
      if (localInputMethodManager != null)
      {
        k = this.afZe.getSelectionStart();
        m = this.afZe.getSelectionEnd();
        if (!(this.afZe.getText() instanceof Spannable)) {
          break label109;
        }
        Spannable localSpannable = (Spannable)this.afZe.getText();
        i = a.getComposingSpanStart(localSpannable);
        j = a.getComposingSpanEnd(localSpannable);
      }
    }
    for (;;)
    {
      localInputMethodManager.updateSelection(this.afZe, k, m, i, j);
      AppMethodBeat.o(252521);
      return;
      label109:
      j = -1;
      i = -1;
    }
  }
  
  private void jGs()
  {
    AppMethodBeat.i(252526);
    if (this.agan == null) {
      this.agan = new com.tencent.mm.ui.widget.cedit.a.a(this.afZe);
    }
    this.agan.show();
    this.agao = true;
    AppMethodBeat.o(252526);
  }
  
  private void jGt()
  {
    AppMethodBeat.i(252533);
    com.tencent.mm.ui.widget.cedit.a.a locala;
    if (this.agan != null) {
      locala = this.agan;
    }
    try
    {
      Log.i("cmEdit.OperateWindow", "destroy OpWindow@%s", new Object[] { Integer.valueOf(locala.hashCode()) });
      locala.dismiss();
      locala.xyX.setContentView(null);
      locala.agcs = true;
      label58:
      this.agao = false;
      AppMethodBeat.o(252533);
      return;
    }
    finally
    {
      break label58;
    }
  }
  
  private void jGv()
  {
    AppMethodBeat.i(252541);
    if (this.afZk != null) {
      this.afZk.invalidate();
    }
    AppMethodBeat.o(252541);
  }
  
  private boolean jGx()
  {
    AppMethodBeat.i(252545);
    if (this.agaa != null) {
      this.afZe.removeCallbacks(this.agaa);
    }
    if (jGA())
    {
      AppMethodBeat.o(252545);
      return false;
    }
    if (!jGy())
    {
      AppMethodBeat.o(252545);
      return false;
    }
    if ((!this.afZe.jFB()) && (!jGc()))
    {
      AppMethodBeat.o(252545);
      return false;
    }
    jGD();
    jGF().aEw(2);
    AppMethodBeat.o(252545);
    return true;
  }
  
  private boolean jGy()
  {
    AppMethodBeat.i(252548);
    if ((!this.afZe.jFF()) || (!this.afZe.requestFocus()))
    {
      Log.w("cmEdit.CMTextView", "TextView does not support text selection. Selection cancelled.");
      AppMethodBeat.o(252548);
      return false;
    }
    AppMethodBeat.o(252548);
    return true;
  }
  
  private long oN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252479);
    Layout localLayout = this.afZe.getLayout();
    if (localLayout == null)
    {
      l = com.tencent.mm.ui.widget.cedit.util.c.oO(-1, -1);
      AppMethodBeat.o(252479);
      return l;
    }
    CharSequence localCharSequence = this.afZe.getText();
    paramInt1 = localLayout.getLineForOffset(paramInt1);
    while ((paramInt1 > 0) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt1 - 1) - 1) != '\n')) {
      paramInt1 -= 1;
    }
    paramInt2 = localLayout.getLineForOffset(paramInt2);
    while ((paramInt2 < localLayout.getLineCount() - 1) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt2) - 1) != '\n')) {
      paramInt2 += 1;
    }
    long l = com.tencent.mm.ui.widget.cedit.util.c.oO(localLayout.getLineStart(paramInt1), localLayout.getLineEnd(paramInt2));
    AppMethodBeat.o(252479);
    return l;
  }
  
  public final boolean Nq(boolean paramBoolean)
  {
    AppMethodBeat.i(252734);
    if (this.afZM)
    {
      if (!paramBoolean) {
        jGg();
      }
      AppMethodBeat.o(252734);
      return true;
    }
    int i;
    if ((!paramBoolean) && (!bl(this.afZZ.uJC, this.afZZ.uJD)) && (!this.afZZ.agcj) && (this.afZl))
    {
      i = this.afZe.bk(this.afZZ.uJC, this.afZZ.uJD);
      Selection.setSelection((Spannable)this.afZe.getText(), i);
      jGE().show();
      this.agag = true;
    }
    for (boolean bool = true;; bool = paramBoolean)
    {
      paramBoolean = bool;
      int j;
      if (!bool)
      {
        paramBoolean = bool;
        if (!jGu())
        {
          i = this.afZe.getSelectionStart();
          j = this.afZe.getSelectionEnd();
          if (i == j) {
            break label247;
          }
          if (i <= j) {
            break label264;
          }
          Selection.setSelection((Spannable)this.afZe.getText(), j, i);
        }
      }
      for (;;)
      {
        n localn = jGF();
        int k = localn.agbS;
        int m = localn.agbT;
        if ((k >= j) && (m < i))
        {
          i = 1;
          if (i == 0) {
            break label252;
          }
          jGf();
        }
        for (;;)
        {
          paramBoolean = true;
          bool = paramBoolean;
          if (!paramBoolean) {
            bool = jGx();
          }
          AppMethodBeat.o(252734);
          return bool;
          label247:
          i = 0;
          break;
          label252:
          jFJ();
          jGx();
        }
        label264:
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  final void Nr(boolean paramBoolean)
  {
    AppMethodBeat.i(252840);
    if ((this.afZR == null) || (paramBoolean))
    {
      this.afZR = this.afZe.getTextSelectHandle();
      if (this.afZR != null)
      {
        this.afZR = a(this.afZe.getContext(), this.afZR, 23);
        this.afZR.setTint(this.afZe.afYn);
      }
      if (this.afZl) {
        j.a(jGE());
      }
    }
    if ((this.afZP == null) || (this.afZQ == null) || (paramBoolean))
    {
      this.afZP = this.afZe.getTextSelectHandleLeft();
      this.afZP = a(this.afZe.getContext(), this.afZP, 21);
      this.afZP.setTint(this.afZe.afYn);
      this.afZQ = this.afZe.getTextSelectHandleRight();
      this.afZQ = a(this.afZe.getContext(), this.afZQ, 21);
      this.afZQ.setTint(this.afZe.afYn);
      if (this.afZm) {
        n.d(jGF());
      }
    }
    AppMethodBeat.o(252840);
  }
  
  public final int a(Layout paramLayout, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(252833);
    int i = this.afZe.eg(paramFloat);
    if ((paramLayout == null) || (paramInt > paramLayout.getLineCount()) || (paramLayout.getLineCount() <= 0) || (paramInt < 0))
    {
      AppMethodBeat.o(252833);
      return i;
    }
    if (Math.abs(i - paramInt) >= 2)
    {
      AppMethodBeat.o(252833);
      return i;
    }
    int j = paramLayout.getLineBottom(paramInt) - paramLayout.getLineTop(paramInt);
    int k = (int)(0.5F * (paramLayout.getLineBottom(i) - paramLayout.getLineTop(i)));
    j = Math.max(0, Math.max(this.agam, Math.min(this.agal, k + j)) - j);
    float f = this.afZe.jFA();
    if ((i > paramInt) && (paramFloat >= paramLayout.getLineBottom(paramInt) + j + f))
    {
      AppMethodBeat.o(252833);
      return i;
    }
    if ((i < paramInt) && (paramFloat <= paramLayout.getLineTop(paramInt) - j + f))
    {
      AppMethodBeat.o(252833);
      return i;
    }
    AppMethodBeat.o(252833);
    return paramInt;
  }
  
  final void a(DragEvent paramDragEvent)
  {
    int i = 1;
    AppMethodBeat.i(252829);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    this.afZe.beginBatchEdit();
    try
    {
      int n = this.afZe.bk(paramDragEvent.getX(), paramDragEvent.getY());
      Object localObject = paramDragEvent.getLocalState();
      paramDragEvent = null;
      if ((localObject instanceof e)) {
        paramDragEvent = (e)localObject;
      }
      if ((paramDragEvent != null) && (paramDragEvent.agau == this.afZe)) {}
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
      int i1 = this.afZe.getText().length();
      Selection.setSelection((Spannable)this.afZe.getText(), n);
      ((Editable)this.afZe.mText).replace(n, n, localSpannableStringBuilder);
      if (i != 0)
      {
        int m = paramDragEvent.start;
        int k = paramDragEvent.end;
        j = k;
        i = m;
        if (n <= m)
        {
          j = this.afZe.getText().length() - i1;
          i = m + j;
          j = k + j;
        }
        this.afZe.oM(i, j);
        j = Math.max(0, i - 1);
        i = Math.min(this.afZe.getText().length(), i + 1);
        if (i > j + 1)
        {
          paramDragEvent = this.afZe.oL(j, i);
          if ((Character.isSpaceChar(paramDragEvent.charAt(0))) && (Character.isSpaceChar(paramDragEvent.charAt(1)))) {
            this.afZe.oM(j, j + 1);
          }
        }
      }
      return;
    }
    finally
    {
      this.afZe.endBatchEdit();
      AppMethodBeat.o(252829);
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(252729);
    jGe().a(paramp, false);
    AppMethodBeat.o(252729);
  }
  
  final boolean a(ExtractedTextRequest paramExtractedTextRequest, int paramInt1, int paramInt2, int paramInt3, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(252765);
    if ((paramExtractedTextRequest == null) || (paramExtractedText == null))
    {
      AppMethodBeat.o(252765);
      return false;
    }
    CharSequence localCharSequence = this.afZe.getText();
    if (localCharSequence == null)
    {
      AppMethodBeat.o(252765);
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
          if (this.afZe.adTq) {
            paramExtractedText.flags |= 0x1;
          }
          paramExtractedText.startOffset = 0;
          paramExtractedText.selectionStart = this.afZe.getSelectionStart();
          paramExtractedText.selectionEnd = this.afZe.getSelectionEnd();
          if (Build.VERSION.SDK_INT >= 28) {
            paramExtractedText.hint = this.afZe.getHint();
          }
          AppMethodBeat.o(252765);
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
  
  final void aA(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252747);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(252747);
      return;
      aEu(-1);
      AppMethodBeat.o(252747);
      return;
      jGk();
    }
  }
  
  final void aB(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(252804);
    jGw();
    this.afZe.bk(paramMotionEvent.getX(), paramMotionEvent.getY());
    CharSequence localCharSequence;
    int k;
    if ((this.afZD) && (this.afZe.jFE()))
    {
      i = 1;
      jFY();
      jFJ();
      localCharSequence = this.afZe.getText();
      if ((i != 0) || (localCharSequence.length() <= 0)) {
        break label201;
      }
      k = this.afZe.bk(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.afZJ) {
        break label164;
      }
    }
    label164:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        Selection.setSelection((Spannable)localCharSequence, k);
      }
      if (jGA()) {
        break label201;
      }
      if (!jGB()) {
        break label169;
      }
      if (this.agaa == null) {
        break label201;
      }
      this.afZe.removeCallbacks(this.agaa);
      AppMethodBeat.o(252804);
      return;
      i = 0;
      break;
    }
    label169:
    if (this.afZl)
    {
      if (i != 0)
      {
        jGE().show();
        AppMethodBeat.o(252804);
        return;
      }
      jGE().hide();
    }
    label201:
    AppMethodBeat.o(252804);
  }
  
  final void aEu(int paramInt)
  {
    AppMethodBeat.i(252751);
    this.afZe.removeCallbacks(this.agaf);
    hbK();
    if ((this.afZk != null) && (Build.VERSION.SDK_INT >= 23)) {
      this.afZk.hide(paramInt);
    }
    AppMethodBeat.o(252751);
  }
  
  final void aw(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(252738);
    this.afZz = SystemClock.uptimeMillis();
    jGl();
    if (paramBoolean)
    {
      int k = this.afZe.getSelectionStart();
      int m = this.afZe.getSelectionEnd();
      if ((this.afZD) && (k == 0) && (m == this.afZe.getText().length()))
      {
        i = 1;
        if ((!this.afZu) || (!this.afZe.jFB()) || (i != 0)) {
          break label312;
        }
        paramBoolean = true;
        label96:
        this.afZX = paramBoolean;
        if ((!this.afZu) || (k < 0) || (m < 0))
        {
          if (this.afZj == null) {
            break label317;
          }
          int j = this.afZj.agbS;
          if (j < 0) {
            break label317;
          }
          i = j;
          if (j <= this.afZe.getText().length()) {}
        }
      }
      label312:
      label317:
      for (int i = this.afZe.getText().length();; i = -1)
      {
        if (i >= 0) {
          Selection.setSelection((Spannable)this.afZe.getText(), i);
        }
        com.tencent.mm.ui.widget.cedit.b.d locald = this.afZe.getMovementMethod();
        if (locald != null) {
          locald.a(this.afZe, (Spannable)this.afZe.getText(), paramInt);
        }
        if (((CustomTextView.jFH()) || (this.afZv)) && (k >= 0) && (m >= 0)) {
          Selection.setSelection((Spannable)this.afZe.getText(), k, m);
        }
        if (this.afZD) {
          this.afZe.jFO();
        }
        this.afZw = true;
        this.afZu = false;
        this.afZv = false;
        jGH();
        AppMethodBeat.o(252738);
        return;
        i = 0;
        break;
        paramBoolean = false;
        break label96;
      }
    }
    if (CustomTextView.jFH())
    {
      jFY();
      jGD();
    }
    for (;;)
    {
      if (this.afZj != null) {
        this.afZj.jGW();
      }
      jGi();
      AppMethodBeat.o(252738);
      return;
      jFY();
      paramBoolean = bool;
      if (Build.VERSION.SDK_INT >= 24) {
        paramBoolean = this.afZe.isTemporarilyDetached();
      }
      if (paramBoolean) {
        jGD();
      } else {
        jFJ();
      }
    }
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(252730);
    jGe().c(paramp);
    AppMethodBeat.o(252730);
  }
  
  public final void beginBatchEdit()
  {
    AppMethodBeat.i(252758);
    this.afZF = true;
    h localh = this.afZt;
    if (localh != null)
    {
      int i = localh.afZf + 1;
      localh.afZf = i;
      if (i == 1)
      {
        localh.agbe = false;
        localh.agbi = 0;
        if (localh.mContentChanged)
        {
          localh.agbg = 0;
          localh.agbh = this.afZe.getText().length();
          AppMethodBeat.o(252758);
          return;
        }
        localh.agbg = -1;
        localh.agbh = -1;
        localh.mContentChanged = false;
      }
    }
    AppMethodBeat.o(252758);
  }
  
  final void bm(float paramFloat1, float paramFloat2)
  {
    this.afZT = paramFloat1;
    this.afZU = paramFloat2;
  }
  
  public final void endBatchEdit()
  {
    AppMethodBeat.i(252759);
    this.afZF = false;
    h localh = this.afZt;
    if (localh != null)
    {
      int i = localh.afZf - 1;
      localh.afZf = i;
      if (i == 0) {
        a(localh);
      }
    }
    AppMethodBeat.o(252759);
  }
  
  final InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(252756);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)this.afZe.getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(252756);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.afZe.getContext().getSystemService("input_method");
    AppMethodBeat.o(252756);
    return localInputMethodManager;
  }
  
  public final com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(252728);
    if (this.agab == null) {
      this.agab = new com.tencent.mm.ui.widget.cedit.c.b(this.afZe.getTextServicesLocale());
    }
    com.tencent.mm.ui.widget.cedit.c.b localb = this.agab;
    AppMethodBeat.o(252728);
    return localb;
  }
  
  protected final void jFJ()
  {
    AppMethodBeat.i(252808);
    if (this.afZk != null) {
      this.afZk.finish();
    }
    this.afZe.removeCallbacks(this.agaf);
    if (this.agao) {
      jGC();
    }
    AppMethodBeat.o(252808);
  }
  
  final void jFV()
  {
    AppMethodBeat.i(252714);
    if (this.afZs == null) {
      this.afZs = new g();
    }
    AppMethodBeat.o(252714);
  }
  
  final boolean jFW()
  {
    AppMethodBeat.i(252717);
    if ((this.afZC) && (this.afZe.jFD()))
    {
      AppMethodBeat.o(252717);
      return true;
    }
    AppMethodBeat.o(252717);
    return false;
  }
  
  final void jFX()
  {
    boolean bool2 = true;
    AppMethodBeat.i(252720);
    Object localObject = this.afZe.getRootView().getLayoutParams();
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
      if ((i != 0) && (this.afZe.getLayout() != null))
      {
        i = 1;
        label75:
        if ((i == 0) || (!jFW())) {
          break label191;
        }
        bool1 = true;
        label88:
        this.afZl = bool1;
        if ((i == 0) || (!this.afZe.jFG())) {
          break label196;
        }
      }
      label191:
      label196:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.afZm = bool1;
        if (!this.afZl)
        {
          jFY();
          if (this.afZi != null)
          {
            this.afZi.iQ();
            this.afZi = null;
          }
        }
        if (!this.afZm)
        {
          jFJ();
          if (this.afZj != null)
          {
            this.afZj.iQ();
            this.afZj = null;
          }
        }
        AppMethodBeat.o(252720);
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
  
  final void jFY()
  {
    AppMethodBeat.i(252722);
    if (this.afZi != null) {
      this.afZi.hide();
    }
    AppMethodBeat.o(252722);
  }
  
  final void jFZ()
  {
    AppMethodBeat.i(252724);
    if (this.afZB != null) {
      this.afZB.cancel();
    }
    AppMethodBeat.o(252724);
  }
  
  final boolean jGA()
  {
    AppMethodBeat.i(252800);
    if (!CustomTextView.jFH())
    {
      InputMethodManager localInputMethodManager = getInputMethodManager();
      if ((localInputMethodManager != null) && (localInputMethodManager.isFullscreenMode()))
      {
        AppMethodBeat.o(252800);
        return true;
      }
      AppMethodBeat.o(252800);
      return false;
    }
    AppMethodBeat.o(252800);
    return false;
  }
  
  final void jGD()
  {
    AppMethodBeat.i(252810);
    if (!jGu()) {
      this.afZI = true;
    }
    this.afZH = true;
    jFJ();
    this.afZH = false;
    AppMethodBeat.o(252810);
  }
  
  public final j jGE()
  {
    AppMethodBeat.i(252816);
    if (!this.afZl)
    {
      AppMethodBeat.o(252816);
      return null;
    }
    if (this.afZi == null)
    {
      this.afZi = new j();
      this.afZe.getViewTreeObserver().addOnTouchModeChangeListener(this.afZi);
    }
    j localj = this.afZi;
    AppMethodBeat.o(252816);
    return localj;
  }
  
  public final n jGF()
  {
    AppMethodBeat.i(252819);
    if (!this.afZm)
    {
      AppMethodBeat.o(252819);
      return null;
    }
    if (this.afZj == null)
    {
      this.afZj = new n();
      this.afZe.getViewTreeObserver().addOnTouchModeChangeListener(this.afZj);
    }
    n localn = this.afZj;
    AppMethodBeat.o(252819);
    return localn;
  }
  
  final void jGH()
  {
    AppMethodBeat.i(252823);
    if (jGG())
    {
      this.afZz = SystemClock.uptimeMillis();
      if (this.afZB == null) {
        this.afZB = new a((byte)0);
      }
      this.afZe.removeCallbacks(this.afZB);
      this.afZe.postDelayed(this.afZB, 500L);
      AppMethodBeat.o(252823);
      return;
    }
    if (this.afZB != null) {
      this.afZe.removeCallbacks(this.afZB);
    }
    AppMethodBeat.o(252823);
  }
  
  final void jGI()
  {
    AppMethodBeat.i(252835);
    if (this.afZO == null) {
      this.afZO = this.afZe.getTextCursorDrawable();
    }
    AppMethodBeat.o(252835);
  }
  
  final void jGa()
  {
    AppMethodBeat.i(252726);
    if (this.afZB != null)
    {
      this.afZB.mCancelled = false;
      jGH();
    }
    AppMethodBeat.o(252726);
  }
  
  final void jGi()
  {
    AppMethodBeat.i(252743);
    if ((!this.afZe.jFG()) && (this.afZe.jFB())) {
      Selection.setSelection((Spannable)this.afZe.getText(), this.afZe.length(), this.afZe.length());
    }
    AppMethodBeat.o(252743);
  }
  
  final void jGj()
  {
    AppMethodBeat.i(252745);
    jGw();
    this.agad = true;
    jFY();
    if (this.afZj != null) {
      this.afZj.jGW();
    }
    jFJ();
    AppMethodBeat.o(252745);
  }
  
  final void jGl()
  {
    AppMethodBeat.i(252760);
    h localh = this.afZt;
    if ((localh != null) && (localh.afZf != 0))
    {
      localh.afZf = 0;
      a(localh);
    }
    AppMethodBeat.o(252760);
  }
  
  final boolean jGm()
  {
    AppMethodBeat.i(252771);
    h localh = this.afZt;
    if (localh == null)
    {
      AppMethodBeat.o(252771);
      return false;
    }
    boolean bool = localh.mContentChanged;
    if ((!bool) && (!localh.agbf))
    {
      AppMethodBeat.o(252771);
      return false;
    }
    localh.mContentChanged = false;
    localh.agbf = false;
    ExtractedTextRequest localExtractedTextRequest = localh.agbd;
    if (localExtractedTextRequest == null)
    {
      AppMethodBeat.o(252771);
      return false;
    }
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(252771);
      return false;
    }
    if ((localh.agbg < 0) && (!bool)) {
      localh.agbg = -2;
    }
    if (a(localExtractedTextRequest, localh.agbg, localh.agbh, localh.agbi, localh.mExtractedText))
    {
      localInputMethodManager.updateExtractedText(this.afZe, localExtractedTextRequest.token, localh.mExtractedText);
      localh.agbg = -1;
      localh.agbh = -1;
      localh.agbi = 0;
      localh.mContentChanged = false;
      AppMethodBeat.o(252771);
      return true;
    }
    AppMethodBeat.o(252771);
    return false;
  }
  
  final void jGo()
  {
    AppMethodBeat.i(252774);
    if (this.afZj != null) {
      this.afZj.jHa();
    }
    if (this.afZi != null) {
      this.afZi.jGT();
    }
    if (!jGu()) {
      jGv();
    }
    AppMethodBeat.o(252774);
  }
  
  final void jGp()
  {
    AppMethodBeat.i(252776);
    jGI();
    if (this.afZO == null)
    {
      AppMethodBeat.o(252776);
      return;
    }
    Layout localLayout = this.afZe.getLayout();
    int i = this.afZe.getSelectionStart();
    int j = localLayout.getLineForOffset(i);
    i(localLayout.getLineTop(j), localLayout.getLineBottom(j), localLayout.getPrimaryHorizontal(i));
    AppMethodBeat.o(252776);
  }
  
  final void jGq()
  {
    AppMethodBeat.i(252780);
    if (jGA())
    {
      this.afZI = false;
      AppMethodBeat.o(252780);
      return;
    }
    boolean bool = this.afZe.jFB();
    n localn = jGF();
    j localj = jGE();
    if (((localn != null) && (localn.jGJ())) || ((localj != null) && (localj.jGJ())))
    {
      this.afZI = false;
      AppMethodBeat.o(252780);
      return;
    }
    if (bool)
    {
      jFY();
      if (jGu()) {
        if (this.afZI) {
          jGw().jHd();
        }
      }
    }
    for (;;)
    {
      this.afZI = false;
      AppMethodBeat.o(252780);
      return;
      if ((localn == null) || (!localn.isActive()))
      {
        jGD();
        jGw().jHd();
      }
      else
      {
        if ((Build.VERSION.SDK_INT >= 23) && (this.afZk != null)) {
          this.afZk.invalidateContentRect();
        }
        jGk();
        continue;
        if ((localj == null) || (!localj.isActive())) {
          jFJ();
        } else if ((this.afZk != null) && (Build.VERSION.SDK_INT >= 23)) {
          this.afZk.invalidateContentRect();
        }
      }
    }
  }
  
  final void jGr()
  {
    AppMethodBeat.i(252786);
    if (this.agaa != null) {
      this.afZe.removeCallbacks(this.agaa);
    }
    if (jGA())
    {
      AppMethodBeat.o(252786);
      return;
    }
    jFJ();
    if (Build.VERSION.SDK_INT >= 23) {
      new o(1);
    }
    jGs();
    if ((!jGu()) && (jGE() != null)) {
      jGE().show();
    }
    AppMethodBeat.o(252786);
  }
  
  public final boolean jGu()
  {
    return (this.afZk == null) && (!this.agao);
  }
  
  final d jGw()
  {
    AppMethodBeat.i(252791);
    if (this.afZK == null) {
      this.afZK = new d(this);
    }
    d locald = this.afZK;
    AppMethodBeat.o(252791);
    return locald;
  }
  
  final boolean jGz()
  {
    AppMethodBeat.i(252797);
    if (jGA())
    {
      AppMethodBeat.o(252797);
      return false;
    }
    if (this.afZk != null)
    {
      jGv();
      AppMethodBeat.o(252797);
      return false;
    }
    if ((!jGy()) || (!this.afZe.jFB()))
    {
      AppMethodBeat.o(252797);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      new o(0);
    }
    jGs();
    if (!this.afZe.jFD()) {
      this.afZe.jFu();
    }
    if (!jGu()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.afZe.jFD()) && (!this.afZe.jFu()) && (this.afZG))
      {
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.showSoftInput(this.afZe, 0, null);
        }
      }
      AppMethodBeat.o(252797);
      return true;
    }
  }
  
  final class a
    implements Runnable
  {
    boolean mCancelled;
    
    private a() {}
    
    final void cancel()
    {
      AppMethodBeat.i(252332);
      if (!this.mCancelled)
      {
        b.c(b.this).removeCallbacks(this);
        this.mCancelled = true;
      }
      AppMethodBeat.o(252332);
    }
    
    public final void run()
    {
      AppMethodBeat.i(252329);
      if (this.mCancelled)
      {
        AppMethodBeat.o(252329);
        return;
      }
      b.c(b.this).removeCallbacks(this);
      if (b.g(b.this))
      {
        if (b.c(b.this).getLayout() != null) {
          b.c(b.this).jFr();
        }
        b.c(b.this).postDelayed(this, 500L);
      }
      AppMethodBeat.o(252329);
    }
  }
  
  final class b
  {
    long agaq;
    private RectF bYz;
    final Path cja;
    final Paint mPaint;
    int uG;
    int uH;
    
    public b()
    {
      AppMethodBeat.i(252287);
      this.cja = new Path();
      this.mPaint = new Paint(1);
      this.mPaint.setStyle(Paint.Style.FILL);
      AppMethodBeat.o(252287);
    }
    
    final void Ns(boolean paramBoolean)
    {
      AppMethodBeat.i(252297);
      if (b.c(b.this).getLayout() == null)
      {
        AppMethodBeat.o(252297);
        return;
      }
      if (this.bYz == null) {
        this.bYz = new RectF();
      }
      this.cja.computeBounds(this.bYz, false);
      int i = b.c(b.this).getCompoundPaddingLeft();
      int j = b.c(b.this).getExtendedPaddingTop() + b.c(b.this).No(true);
      if (paramBoolean)
      {
        b.c(b.this).postInvalidateOnAnimation((int)this.bYz.left + i, (int)this.bYz.top + j, i + (int)this.bYz.right, j + (int)this.bYz.bottom);
        AppMethodBeat.o(252297);
        return;
      }
      b.c(b.this).postInvalidate((int)this.bYz.left, (int)this.bYz.top, (int)this.bYz.right, (int)this.bYz.bottom);
      AppMethodBeat.o(252297);
    }
    
    final void stopAnimation()
    {
      AppMethodBeat.i(252304);
      b.E(b.this);
      AppMethodBeat.o(252304);
    }
  }
  
  final class c
    implements b.p
  {
    final CursorAnchorInfo.Builder agar;
    final int[] agas;
    final Matrix agat;
    
    private c()
    {
      AppMethodBeat.i(252294);
      this.agar = new CursorAnchorInfo.Builder();
      this.agas = new int[2];
      this.agat = new Matrix();
      AppMethodBeat.o(252294);
    }
    
    public final void j(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(252309);
      Object localObject = b.this.afZt;
      if ((localObject == null) || (((b.h)localObject).afZf > 0))
      {
        AppMethodBeat.o(252309);
        return;
      }
      localObject = b.l(b.this);
      if (localObject == null)
      {
        AppMethodBeat.o(252309);
        return;
      }
      if (!((InputMethodManager)localObject).isActive(b.c(b.this)))
      {
        AppMethodBeat.o(252309);
        return;
      }
      AppMethodBeat.o(252309);
    }
  }
  
  static abstract interface d
    extends ViewTreeObserver.OnTouchModeChangeListener
  {
    public abstract boolean isActive();
    
    public abstract boolean jGJ();
    
    public abstract void show();
  }
  
  static final class e
  {
    public CustomTextView agau;
    public int end;
    public int start;
    
    public e(CustomTextView paramCustomTextView, int paramInt1, int paramInt2)
    {
      this.agau = paramCustomTextView;
      this.start = paramInt1;
      this.end = paramInt2;
    }
  }
  
  public abstract class f
    extends View
    implements b.p
  {
    private int JAb;
    protected int LKx = -1;
    private int agaA;
    private int agaB;
    private float agaC;
    private float agaD;
    protected int agaE;
    protected int agaF;
    private float agaG;
    private final float agaH;
    private int agaI;
    private int agaJ;
    private int agaK;
    private int agaL;
    private boolean agaM = true;
    protected int agaN = -1;
    protected int agaO = -1;
    private float agaP = -1.0F;
    private float agaQ;
    private float agaR;
    private final int agaS;
    private final long[] agaT = new long[5];
    private final int[] agaU = new int[5];
    private int agaV = 0;
    private int agaW = 0;
    protected Drawable agav;
    protected Drawable agaw;
    private final PopupWindow agax;
    private int agay;
    private int agaz;
    protected Drawable kD;
    private int nLt = bd.fromDPToPix(getContext(), 18);
    boolean uwK;
    
    private f(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt)
    {
      super();
      setId(paramInt);
      this.agax = new PopupWindow(b.c(b.this).getContext(), null, a.l.OperateItemAnim);
      this.agax.setSplitTouchEnabled(true);
      this.agax.setClippingEnabled(false);
      h.a(this.agax, 1002);
      this.agax.setWidth(-2);
      this.agax.setHeight(-2);
      this.agax.setContentView(this);
      b(paramDrawable1, paramDrawable2);
      this.JAb = b.c(b.this).getContext().getResources().getDimensionPixelSize(a.e.text_handle_min_size);
      paramInt = getPreferredHeight();
      this.agaG = (-0.3F * paramInt);
      this.agaH = (paramInt * 0.7F);
      this.agaS = ((int)(this.agaH - this.agaG));
    }
    
    private boolean a(f paramf, Rect paramRect)
    {
      paramf = paramf.agax;
      int i = this.agaA;
      int j = this.agaB;
      int k = this.agaA;
      int m = paramf.getContentView().getWidth();
      int n = this.agaB;
      return Rect.intersects(new Rect(i, j, k + m, paramf.getContentView().getHeight() + n), paramRect);
    }
    
    private void aEv(int paramInt)
    {
      this.agaV = ((this.agaV + 1) % 5);
      this.agaU[this.agaV] = paramInt;
      this.agaT[this.agaV] = SystemClock.uptimeMillis();
      this.agaW += 1;
    }
    
    private int getDrawHeight()
    {
      return this.kD.getIntrinsicHeight();
    }
    
    private int getDrawWidth()
    {
      return this.kD.getIntrinsicWidth();
    }
    
    private int getHorizontalOffset()
    {
      int i = getPreferredWidth();
      int j = getDrawWidth();
      switch (this.agaF)
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
      b.n localn = b.this.jGF();
      if ((localn == null) || (!localn.isActive())) {
        return null;
      }
      if (b.n.a(localn) != this) {
        return b.n.a(localn);
      }
      return b.n.c(localn);
    }
    
    private boolean jGL()
    {
      if (this.uwK) {
        return true;
      }
      if (b.c(b.this).jFP()) {
        return false;
      }
      return b.c(b.this).bj(this.agay + this.agaE + getHorizontalOffset(), this.agaz);
    }
    
    private boolean jGM()
    {
      if (b.a(b.this).agbw) {
        return true;
      }
      if ((b.c(b.this).getRotation() != 0.0F) || (b.c(b.this).getRotationX() != 0.0F) || (b.c(b.this).getRotationY() != 0.0F)) {
        return false;
      }
      this.agaQ = b.c(b.this).getScaleX();
      this.agaR = b.c(b.this).getScaleY();
      for (ViewParent localViewParent = b.c(b.this).getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof View))
        {
          View localView = (View)localViewParent;
          if ((localView.getRotation() != 0.0F) || (localView.getRotationX() != 0.0F) || (localView.getRotationY() != 0.0F)) {
            return false;
          }
          this.agaQ *= localView.getScaleX();
          float f = this.agaR;
          this.agaR = (localView.getScaleY() * f);
        }
      }
      return true;
    }
    
    private void setVisible(boolean paramBoolean)
    {
      View localView = this.agax.getContentView();
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        return;
      }
    }
    
    protected abstract void KS(int paramInt);
    
    protected void Nt(boolean paramBoolean)
    {
      if ((!paramBoolean) && (this.uwK)) {}
      Layout localLayout;
      do
      {
        return;
        localLayout = b.c(b.this).getLayout();
      } while (localLayout == null);
      int i = getCurrentCursorOffset();
      paramBoolean = b(localLayout, i);
      Drawable localDrawable2 = this.kD;
      if (paramBoolean) {}
      for (Drawable localDrawable1 = this.agaw;; localDrawable1 = this.agav)
      {
        this.kD = localDrawable1;
        this.agaE = c(this.kD, paramBoolean);
        this.agaF = Nu(paramBoolean);
        if ((localDrawable2 == this.kD) || (!isShowing())) {
          break;
        }
        this.agay = (d(localLayout, i) - this.agaE - getHorizontalOffset() + getCursorOffset());
        this.agay += b.c(b.this).jFz();
        this.agaM = true;
        j(this.agaI, this.agaJ, false, false);
        postInvalidate();
        return;
      }
    }
    
    protected abstract int Nu(boolean paramBoolean);
    
    protected final void aC(MotionEvent paramMotionEvent)
    {
      if (b.q(b.this) == null) {}
      Object localObject1;
      Object localObject2;
      int i;
      int n;
      int j;
      label134:
      label151:
      float f1;
      float f2;
      label221:
      label381:
      do
      {
        do
        {
          return;
          localObject1 = new PointF();
          if (!jGM()) {
            break label1178;
          }
          if (!b.o(b.this)) {
            break label425;
          }
          localObject2 = b.c(b.this).getLayout();
          i = ((Layout)localObject2).getLineForOffset(getCurrentCursorOffset());
          if (b.a((Layout)localObject2, i) - ((Layout)localObject2).getLineTop(i) < b.p(b.this)) {
            break;
          }
          i = 1;
          if (i != 0) {
            break label1178;
          }
          n = getMagnifierHandleTrigger();
          switch (n)
          {
          default: 
            j = -1;
            i = 0;
            if (j != -1) {
              break label588;
            }
            i = 0;
            if (i == 0) {
              break label1178;
            }
            i = 1;
            if (i == 0) {
              break label1297;
            }
            b.a(b.this, true);
            b.c(b.this).jFr();
            b.r(b.this);
            paramMotionEvent = b.a(b.this);
            f1 = ((PointF)localObject1).x;
            f2 = ((PointF)localObject1).y;
            if ((!paramMotionEvent.agbw) || (f2 == paramMotionEvent.xUv)) {
              break label1184;
            }
            i = 1;
            if (i == 0) {
              break label1209;
            }
            if (!paramMotionEvent.hbU.isRunning()) {
              break label1190;
            }
            paramMotionEvent.hbU.cancel();
            paramMotionEvent.agbx = paramMotionEvent.agbz;
            paramMotionEvent.agby = paramMotionEvent.agbA;
            paramMotionEvent.hbU.start();
            paramMotionEvent.xUu = f1;
            paramMotionEvent.xUv = f2;
            paramMotionEvent.agbw = true;
            paramMotionEvent = null;
            if (Build.VERSION.SDK_INT < 29) {
              break label1239;
            }
            paramMotionEvent = b.a(b.this).agbv.getPosition();
          }
        } while ((paramMotionEvent == null) || (Build.VERSION.SDK_INT < 28));
        paramMotionEvent = new Rect(paramMotionEvent.x, paramMotionEvent.y, paramMotionEvent.x + b.a(b.this).agbv.getWidth(), paramMotionEvent.y + b.a(b.this).agbv.getHeight());
        if (a(this, paramMotionEvent)) {
          break label1285;
        }
        bool = true;
        setVisible(bool);
        localObject1 = getOtherSelectionHandle();
      } while (localObject1 == null);
      label259:
      label266:
      label305:
      if (!a((f)localObject1, paramMotionEvent)) {}
      for (boolean bool = true;; bool = false)
      {
        ((f)localObject1).setVisible(bool);
        return;
        i = 0;
        break;
        label425:
        f1 = 0.0F;
        if (Build.VERSION.SDK_INT >= 28) {
          f1 = Math.round(b.a(b.this).agbv.getHeight() / b.a(b.this).agbv.getZoom());
        }
        localObject2 = b.c(b.this).getPaint().getFontMetrics();
        if ((((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent) * this.agaR > f1)
        {
          i = 1;
          break;
        }
        i = 0;
        break;
        j = b.c(b.this).getSelectionStart();
        i = -1;
        break label134;
        j = b.c(b.this).getSelectionStart();
        i = b.c(b.this).getSelectionEnd();
        break label134;
        j = b.c(b.this).getSelectionEnd();
        i = b.c(b.this).getSelectionStart();
        break label134;
        label588:
        label603:
        int i1;
        int k;
        label645:
        int m;
        label660:
        label699:
        label709:
        float f3;
        if (paramMotionEvent.getActionMasked() == 0)
        {
          this.agaP = paramMotionEvent.getRawX();
          localObject2 = b.c(b.this).getLayout();
          i1 = ((Layout)localObject2).getLineForOffset(j);
          if ((i == -1) || (i1 != ((Layout)localObject2).getLineForOffset(i))) {
            break label970;
          }
          k = 1;
          if (k == 0) {
            break label988;
          }
          if (j >= i) {
            break label976;
          }
          m = 1;
          if (c(b.c(b.this).getLayout(), j) >= c(b.c(b.this).getLayout(), i)) {
            break label982;
          }
          j = 1;
          if (m == j) {
            break label988;
          }
          j = 1;
          localObject2 = new int[2];
          b.c(b.this).getLocationOnScreen((int[])localObject2);
          f3 = paramMotionEvent.getRawX() - localObject2[0];
          f1 = b.c(b.this).getTotalPaddingLeft() - b.c(b.this).getScrollX();
          f2 = b.c(b.this).getTotalPaddingLeft() - b.c(b.this).getScrollX();
          if (k == 0) {
            break label1000;
          }
          if (n != 2) {
            break label994;
          }
          m = 1;
          label798:
          if ((m ^ j) == 0) {
            break label1000;
          }
          f1 = c(b.c(b.this).getLayout(), i) + f1;
          label825:
          if (k == 0) {
            break label1027;
          }
          if (n != 1) {
            break label1021;
          }
          k = 1;
          label839:
          if ((j ^ k) == 0) {
            break label1027;
          }
        }
        float f4;
        label1027:
        for (f2 = c(b.c(b.this).getLayout(), i) + f2;; f2 = b.c(b.this).getLayout().getLineRight(i1) + f2)
        {
          f4 = this.agaQ * f1;
          f2 = this.agaQ * f2;
          f1 = 0.0F;
          if (Build.VERSION.SDK_INT >= 28) {
            f1 = Math.round(b.a(b.this).agbv.getWidth() / b.a(b.this).agbv.getZoom());
          }
          if ((f3 >= f4 - f1 / 2.0F) && (f3 <= f1 / 2.0F + f2)) {
            break label1048;
          }
          i = 0;
          break;
          if (paramMotionEvent.getActionMasked() != 1) {
            break label603;
          }
          this.agaP = -1.0F;
          break label603;
          label970:
          k = 0;
          break label645;
          label976:
          m = 0;
          break label660;
          label982:
          j = 0;
          break label699;
          label988:
          j = 0;
          break label709;
          label994:
          m = 0;
          break label798;
          label1000:
          f1 = b.c(b.this).getLayout().getLineLeft(i1) + f1;
          break label825;
          label1021:
          k = 0;
          break label839;
        }
        label1048:
        if (this.agaQ == 1.0F) {}
        for (f1 = f3;; f1 = (paramMotionEvent.getRawX() - this.agaP) * this.agaQ + this.agaP - localObject2[0])
        {
          ((PointF)localObject1).x = Math.max(f4, Math.min(f2, f1));
          ((PointF)localObject1).y = (((b.c(b.this).getLayout().getLineTop(i1) + b.a(b.c(b.this).getLayout(), i1)) / 2.0F + b.c(b.this).getTotalPaddingTop() - b.c(b.this).getScrollY()) * this.agaR);
          i = 1;
          break;
        }
        label1178:
        i = 0;
        break label151;
        label1184:
        i = 0;
        break label221;
        label1190:
        paramMotionEvent.agbx = paramMotionEvent.xUu;
        paramMotionEvent.agby = paramMotionEvent.xUv;
        break label259;
        label1209:
        if ((paramMotionEvent.hbU.isRunning()) || (Build.VERSION.SDK_INT < 28)) {
          break label266;
        }
        paramMotionEvent.agbv.show(f1, f2);
        break label266;
        label1239:
        if (Build.VERSION.SDK_INT != 28) {
          break label305;
        }
        paramMotionEvent = (Point)new com.tencent.mm.ui.widget.cedit.util.a(b.a(b.this).agbv, "getWindowCoords", new Class[0]).invoke(new Object[0]);
        break label305;
        label1285:
        bool = false;
        break label381;
      }
      label1297:
      jGN();
    }
    
    protected int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      return b.c(b.this).E(paramInt, paramFloat);
    }
    
    final void b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.agav = paramDrawable1;
      this.agaw = paramDrawable2;
      Nt(true);
    }
    
    protected boolean b(Layout paramLayout, int paramInt)
    {
      return paramLayout.isRtlCharAt(paramInt);
    }
    
    public float c(Layout paramLayout, int paramInt)
    {
      return paramLayout.getPrimaryHorizontal(paramInt);
    }
    
    protected abstract int c(Drawable paramDrawable, boolean paramBoolean);
    
    int d(Layout paramLayout, int paramInt)
    {
      return (int)(c(paramLayout, paramInt) - 0.5F);
    }
    
    protected void dismiss()
    {
      this.uwK = false;
      this.agax.dismiss();
      iQ();
    }
    
    public abstract int getCurrentCursorOffset();
    
    protected int getCursorOffset()
    {
      return 0;
    }
    
    final int getIdealFingerToCursorOffset()
    {
      return this.agaS;
    }
    
    public float getIdealVerticalOffset()
    {
      return this.agaH;
    }
    
    protected abstract int getMagnifierHandleTrigger();
    
    protected final int getPreferredHeight()
    {
      return Math.max(getDrawWidth(), this.JAb);
    }
    
    protected final int getPreferredWidth()
    {
      return Math.max(getDrawWidth(), this.JAb);
    }
    
    public final void hide()
    {
      dismiss();
      b.m(b.this).c(this);
    }
    
    public void iQ() {}
    
    public void invalidate()
    {
      super.invalidate();
      if (isShowing()) {
        v(getCurrentCursorOffset(), true, false);
      }
    }
    
    public boolean isShowing()
    {
      return this.agax.isShowing();
    }
    
    protected abstract void j(float paramFloat1, float paramFloat2, boolean paramBoolean);
    
    public final void j(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      v(getCurrentCursorOffset(), paramBoolean2, false);
      if ((paramBoolean1) || (this.agaM))
      {
        if (this.uwK)
        {
          if ((paramInt1 != this.agaI) || (paramInt2 != this.agaJ))
          {
            this.agaC += paramInt1 - this.agaI;
            this.agaD += paramInt2 - this.agaJ;
            this.agaI = paramInt1;
            this.agaJ = paramInt2;
          }
          jGO();
        }
        if (!jGL()) {
          break label166;
        }
        paramInt1 = this.agay + paramInt1;
        paramInt2 = this.agaz + paramInt2;
        this.agaA = paramInt1;
        this.agaB = paramInt2;
        if (!isShowing()) {
          break label146;
        }
        this.agax.update(paramInt1, paramInt2, -1, -1);
      }
      for (;;)
      {
        this.agaM = false;
        return;
        label146:
        this.agax.showAtLocation(b.c(b.this), 0, paramInt1, paramInt2);
        continue;
        label166:
        if (isShowing()) {
          dismiss();
        }
      }
    }
    
    public final boolean jGK()
    {
      return this.agaW > 1;
    }
    
    protected final void jGN()
    {
      if (b.a(b.this) != null)
      {
        b.a(b.this).dismiss();
        b.a(b.this, false);
        b.s(b.this);
        setVisible(true);
        f localf = getOtherSelectionHandle();
        if (localf != null) {
          localf.setVisible(true);
        }
      }
    }
    
    void jGO() {}
    
    protected void onDraw(Canvas paramCanvas)
    {
      int i = getDrawWidth();
      int j = getDrawHeight();
      int k = getHorizontalOffset();
      this.kD.setBounds(k, 0, i + k, j);
      this.kD.draw(paramCanvas);
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
      b.a(b.this, paramMotionEvent);
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
        this.agaW = 0;
        aEv(i);
        b.l locall = b.m(b.this);
        this.agaI = locall.agay;
        this.agaJ = locall.agaz;
        this.agaK = locall.agbE;
        this.agaL = locall.agbF;
        f1 = paramMotionEvent.getRawX();
        f2 = this.agaK;
        f3 = this.agaI;
        f4 = paramMotionEvent.getRawY();
        f5 = this.agaL;
        f6 = this.agaJ;
        this.agaC = (f1 - f2 + f3 - this.agay);
        this.agaD = (f4 - f5 + f6 - this.agaz);
        this.uwK = true;
        this.agaO = -1;
        return true;
      case 2: 
        f2 = paramMotionEvent.getRawX();
        f3 = this.agaK;
        f4 = this.agaI;
        f1 = paramMotionEvent.getRawY();
        f5 = this.agaL;
        f5 = this.agaJ + (f1 - f5);
        f1 = this.agaD - this.agaJ;
        f6 = f5 - this.agaz - this.agaJ;
        if (f1 < this.agaH) {}
        for (f1 = Math.max(Math.min(f6, this.agaH), f1);; f1 = Math.min(Math.max(f6, this.agaH), f1))
        {
          this.agaD = (f1 + this.agaJ);
          j(f4 + (f2 - f3) - this.agaC + this.agaE + getHorizontalOffset(), f5 - this.agaD + this.agaG, paramMotionEvent.isFromSource(4098));
          return true;
        }
      case 1: 
        boolean bool = paramMotionEvent.isFromSource(4098);
        long l = SystemClock.uptimeMillis();
        i = this.agaV;
        int k = Math.min(this.agaW, 5);
        int j = 0;
        while ((j < k) && (l - this.agaT[i] < 150L))
        {
          j += 1;
          i = (this.agaV - j + 5) % 5;
        }
        if ((j > 0) && (j < k) && (l - this.agaT[i] > 350L)) {
          v(this.agaU[i], false, bool);
        }
        break;
      }
      this.uwK = false;
      Nt(false);
      return true;
    }
    
    public void setTargetWidth(int paramInt)
    {
      this.nLt = paramInt;
    }
    
    public void show()
    {
      if (isShowing()) {
        return;
      }
      b.m(b.this).a(this, true);
      this.LKx = -1;
      v(getCurrentCursorOffset(), false, false);
    }
    
    protected void v(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (b.c(b.this).getLayout() == null) {
        b.this.jFX();
      }
      for (;;)
      {
        return;
        Layout localLayout = b.c(b.this).getLayout();
        if (paramInt != this.LKx) {}
        for (int i = 1; (i != 0) || (paramBoolean1); i = 0)
        {
          if (i != 0)
          {
            KS(paramInt);
            if ((paramBoolean2) && (b.n(b.this))) {
              b.c(b.this).performHapticFeedback(9);
            }
            aEv(paramInt);
          }
          i = localLayout.getLineForOffset(paramInt);
          this.agaN = i;
          this.agay = (d(localLayout, paramInt) - this.agaE - getHorizontalOffset() + getCursorOffset());
          this.agaz = b.a(localLayout, i);
          this.agay += b.c(b.this).jFz();
          this.agaz += b.c(b.this).jFA();
          this.LKx = paramInt;
          this.agaM = true;
          return;
        }
      }
    }
  }
  
  static final class g
  {
    String agaX;
    CharSequence agaY;
    int agaZ;
    CustomTextView.c agba;
    boolean agbb;
    LocaleList agbc;
    Bundle extras;
    int qiM = 0;
  }
  
  static final class h
  {
    int afZf;
    ExtractedTextRequest agbd;
    boolean agbe;
    boolean agbf;
    int agbg;
    int agbh;
    int agbi;
    boolean mContentChanged;
    final ExtractedText mExtractedText;
    
    h()
    {
      AppMethodBeat.i(252312);
      this.mExtractedText = new ExtractedText();
      AppMethodBeat.o(252312);
    }
  }
  
  final class i
    extends b.f
  {
    private boolean aemg;
    private float agbj;
    private float agbk;
    private Runnable agbl;
    private boolean agbm;
    private final int agbn;
    private final int agbo;
    
    i(Drawable paramDrawable)
    {
      super(paramDrawable, paramDrawable, a.g.insertion_handle, (byte)0);
      AppMethodBeat.i(252323);
      this.aemg = false;
      this.agbm = false;
      this.agbo = 0;
      this.agbn = 255;
      AppMethodBeat.o(252323);
    }
    
    private void jGP()
    {
      AppMethodBeat.i(252330);
      if (this.agbl == null) {
        this.agbl = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(252235);
            b.i.this.hide();
            AppMethodBeat.o(252235);
          }
        };
      }
      for (;;)
      {
        b.c(b.this).postDelayed(this.agbl, 4000L);
        AppMethodBeat.o(252330);
        return;
        jGQ();
      }
    }
    
    private void jGQ()
    {
      AppMethodBeat.i(252333);
      if (this.agbl != null) {
        b.c(b.this).removeCallbacks(this.agbl);
      }
      AppMethodBeat.o(252333);
    }
    
    public final void KS(int paramInt)
    {
      AppMethodBeat.i(252423);
      Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt);
      AppMethodBeat.o(252423);
    }
    
    protected final void Nt(boolean paramBoolean)
    {
      AppMethodBeat.i(252413);
      super.Nt(paramBoolean);
      this.kD.setAlpha(this.agbn);
      AppMethodBeat.o(252413);
    }
    
    protected final int Nu(boolean paramBoolean)
    {
      return 1;
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(252344);
      int i = paramDrawable.getIntrinsicWidth() / 2;
      AppMethodBeat.o(252344);
      return i;
    }
    
    final int d(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(252364);
      if (b.this.afZO != null)
      {
        float f = c(paramLayout, paramInt);
        paramInt = b.a(b.this, b.this.afZO, f);
        int i = b.t(b.this).left;
        AppMethodBeat.o(252364);
        return paramInt + i;
      }
      paramInt = super.d(paramLayout, paramInt);
      AppMethodBeat.o(252364);
      return paramInt;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(252407);
      if (this.aemg)
      {
        this.agbm = true;
        this.kD.setAlpha(0);
        AppMethodBeat.o(252407);
        return;
      }
      super.dismiss();
      this.agbm = false;
      AppMethodBeat.o(252407);
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(252418);
      int i = b.c(b.this).getSelectionStart();
      AppMethodBeat.o(252418);
      return i;
    }
    
    protected final int getCursorOffset()
    {
      AppMethodBeat.i(252354);
      int j = super.getCursorOffset();
      int i = j;
      if (b.this.afZO != null)
      {
        b.this.afZO.getPadding(b.t(b.this));
        i = j + (b.this.afZO.getIntrinsicWidth() - b.t(b.this).left - b.t(b.this).right) / 2;
      }
      AppMethodBeat.o(252354);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      return 0;
    }
    
    public final void iQ()
    {
      AppMethodBeat.i(252438);
      super.iQ();
      jGQ();
      AppMethodBeat.o(252438);
    }
    
    public final boolean isShowing()
    {
      AppMethodBeat.i(252391);
      if (this.agbm)
      {
        AppMethodBeat.o(252391);
        return false;
      }
      boolean bool = super.isShowing();
      AppMethodBeat.o(252391);
      return bool;
    }
    
    protected final void j(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      int i = -1;
      AppMethodBeat.i(252428);
      Layout localLayout = b.c(b.this).getLayout();
      if (localLayout != null)
      {
        if (this.agaO == -1) {
          this.agaO = b.c(b.this).eg(paramFloat2);
        }
        int j = b.this.a(localLayout, this.agaO, paramFloat2);
        i = b(localLayout, j, paramFloat1);
        this.agaO = j;
      }
      v(i, false, paramBoolean);
      if (b.f(b.this) != null) {
        b.v(b.this);
      }
      AppMethodBeat.o(252428);
    }
    
    final void jGO()
    {
      AppMethodBeat.i(252434);
      super.jGO();
      jGQ();
      AppMethodBeat.o(252434);
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252373);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(252373);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252384);
      if (!b.c(b.this).b(paramMotionEvent, true))
      {
        AppMethodBeat.o(252384);
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
          AppMethodBeat.o(252384);
          return bool;
          this.agbj = paramMotionEvent.getRawX();
          this.agbk = paramMotionEvent.getRawY();
          aC(paramMotionEvent);
          continue;
          aC(paramMotionEvent);
        }
      case 1: 
        if (!jGK())
        {
          ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.c(b.this).getContext());
          if (c.b(this.agbj, this.agbk, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), localViewConfiguration.getScaledTouchSlop())) {
            b.u(b.this);
          }
        }
        break;
      }
      for (;;)
      {
        jGP();
        jGN();
        break;
        if ((b.f(b.this) != null) && (Build.VERSION.SDK_INT >= 23)) {
          b.f(b.this).invalidateContentRect();
        }
      }
    }
    
    public final void show()
    {
      AppMethodBeat.i(252400);
      super.show();
      this.agbm = false;
      this.kD.setAlpha(this.agbn);
      AppMethodBeat.o(252400);
    }
  }
  
  public final class j
    implements b.d
  {
    private b.i agbq;
    boolean agbr;
    private boolean agbs;
    private int agbt;
    
    public j() {}
    
    final void aD(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252274);
      Layout localLayout = b.c(b.this).getLayout();
      int i;
      if (this.agbt == -1) {
        i = b.this.a(localLayout, this.agbt, paramMotionEvent.getY());
      }
      for (;;)
      {
        this.agbt = i;
        i = b.c(b.this).E(this.agbt, paramMotionEvent.getX());
        int j = b.c(b.this).getSelectionStart();
        int k = b.c(b.this).getSelectionEnd();
        if ((i != j) || (i != k))
        {
          Selection.setSelection((Spannable)b.c(b.this).getText(), i);
          b.this.jGp();
          if (b.n(b.this)) {
            b.c(b.this).performHapticFeedback(9);
          }
        }
        jGS().aC(paramMotionEvent);
        AppMethodBeat.o(252274);
        return;
        int[] arrayOfInt = new int[2];
        b.c(b.this).getLocationOnScreen(arrayOfInt);
        if (b.x(b.this).agcj) {}
        for (float f1 = paramMotionEvent.getRawY() - arrayOfInt[1];; f1 = paramMotionEvent.getY())
        {
          float f2 = jGS().getIdealFingerToCursorOffset();
          i = b.this.a(localLayout, this.agbt, f1 - f2);
          if (!this.agbs) {
            break label256;
          }
          break;
        }
        label256:
        if (i < this.agbt) {
          i = Math.min(this.agbt, b.this.a(localLayout, this.agbt, f1));
        } else {
          this.agbs = true;
        }
      }
    }
    
    public final void hide()
    {
      AppMethodBeat.i(252293);
      if (this.agbq != null) {
        this.agbq.hide();
      }
      AppMethodBeat.o(252293);
    }
    
    public final void iQ()
    {
      AppMethodBeat.i(252311);
      b.c(b.this).getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.agbq != null) {
        this.agbq.iQ();
      }
      AppMethodBeat.o(252311);
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(252321);
      if ((this.agbq != null) && (this.agbq.isShowing()))
      {
        AppMethodBeat.o(252321);
        return true;
      }
      AppMethodBeat.o(252321);
      return false;
    }
    
    public final boolean jGJ()
    {
      return (this.agbr) || ((this.agbq != null) && (this.agbq.uwK));
    }
    
    final void jGR()
    {
      AppMethodBeat.i(252281);
      this.agbr = false;
      this.agbs = false;
      this.agbt = -1;
      jGS().jGN();
      b.i.a(jGS());
      b.c(b.this).getParent().requestDisallowInterceptTouchEvent(false);
      AppMethodBeat.o(252281);
    }
    
    public final b.i jGS()
    {
      AppMethodBeat.i(252306);
      if (this.agbq == null)
      {
        b.this.Nr(false);
        this.agbq = new b.i(b.this, b.this.afZR);
      }
      b.i locali = this.agbq;
      AppMethodBeat.o(252306);
      return locali;
    }
    
    public final void jGT()
    {
      AppMethodBeat.i(252327);
      if (this.agbq != null) {
        this.agbq.invalidate();
      }
      AppMethodBeat.o(252327);
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(252299);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(252299);
    }
    
    public final void show()
    {
      AppMethodBeat.i(252288);
      jGS().show();
      long l1 = SystemClock.uptimeMillis();
      long l2 = CustomTextView.afXc;
      if ((b.y(b.this) != null) && ((this.agbr) || (b.x(b.this).jHc()) || (b.z(b.this)))) {
        b.c(b.this).removeCallbacks(b.y(b.this));
      }
      if ((!this.agbr) && (!b.x(b.this).jHc()) && (!b.z(b.this)) && (l1 - l2 < 15000L) && (b.this.jGu()))
      {
        if (b.y(b.this) == null) {
          b.a(b.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(252342);
              b.this.jGr();
              AppMethodBeat.o(252342);
            }
          });
        }
        b.c(b.this).postDelayed(b.y(b.this), ViewConfiguration.getDoubleTapTimeout() + 1);
      }
      if (!this.agbr) {
        b.i.a(jGS());
      }
      if (b.this.afZj != null) {
        b.this.afZj.hide();
      }
      AppMethodBeat.o(252288);
    }
  }
  
  static final class k
  {
    float agbA;
    final Magnifier agbv;
    boolean agbw;
    float agbx;
    float agby;
    float agbz;
    final ValueAnimator hbU;
    float xUu;
    float xUv;
    
    private k(Magnifier paramMagnifier)
    {
      AppMethodBeat.i(252257);
      this.agbv = paramMagnifier;
      this.hbU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.hbU.setDuration(100L);
      this.hbU.setInterpolator(new LinearInterpolator());
      this.hbU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(252247);
          b.k.this.agbz = (b.k.this.agbx + (b.k.this.xUu - b.k.this.agbx) * paramAnonymousValueAnimator.getAnimatedFraction());
          b.k.this.agbA = (b.k.this.agby + (b.k.this.xUv - b.k.this.agby) * paramAnonymousValueAnimator.getAnimatedFraction());
          if (Build.VERSION.SDK_INT >= 28) {
            b.k.this.agbv.show(b.k.this.agbz, b.k.this.agbA);
          }
          AppMethodBeat.o(252247);
        }
      });
      AppMethodBeat.o(252257);
    }
    
    final void dismiss()
    {
      AppMethodBeat.i(252268);
      if (Build.VERSION.SDK_INT >= 28) {
        this.agbv.dismiss();
      }
      this.hbU.cancel();
      this.agbw = false;
      AppMethodBeat.o(252268);
    }
  }
  
  final class l
    implements ViewTreeObserver.OnPreDrawListener
  {
    private boolean agaM;
    int agay;
    int agaz;
    private b.p[] agbC;
    private boolean[] agbD;
    int agbE;
    int agbF;
    private int agbG;
    boolean agbH;
    final int[] agbI;
    
    private l()
    {
      AppMethodBeat.i(252269);
      this.agbC = new b.p[7];
      this.agbD = new boolean[7];
      this.agaM = true;
      this.agbI = new int[2];
      AppMethodBeat.o(252269);
    }
    
    private void updatePosition()
    {
      AppMethodBeat.i(252276);
      b.c(b.this).getLocationInWindow(this.agbI);
      if ((this.agbI[0] != this.agay) || (this.agbI[1] != this.agaz)) {}
      for (boolean bool = true;; bool = false)
      {
        this.agaM = bool;
        this.agay = this.agbI[0];
        this.agaz = this.agbI[1];
        b.c(b.this).getLocationOnScreen(this.agbI);
        this.agbE = this.agbI[0];
        this.agbF = this.agbI[1];
        AppMethodBeat.o(252276);
        return;
      }
    }
    
    public final void a(b.p paramp, boolean paramBoolean)
    {
      AppMethodBeat.i(252289);
      if (this.agbG == 0)
      {
        updatePosition();
        b.c(b.this).getViewTreeObserver().addOnPreDrawListener(this);
      }
      int j = -1;
      int i = 0;
      while (i < 7)
      {
        b.p localp = this.agbC[i];
        if (localp == paramp)
        {
          AppMethodBeat.o(252289);
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
      this.agbC[j] = paramp;
      this.agbD[j] = paramBoolean;
      this.agbG += 1;
      AppMethodBeat.o(252289);
    }
    
    public final void c(b.p paramp)
    {
      AppMethodBeat.i(252296);
      int i = 0;
      for (;;)
      {
        if (i < 7)
        {
          if (this.agbC[i] == paramp)
          {
            this.agbC[i] = null;
            this.agbG -= 1;
          }
        }
        else
        {
          if (this.agbG == 0) {
            b.c(b.this).getViewTreeObserver().removeOnPreDrawListener(this);
          }
          AppMethodBeat.o(252296);
          return;
        }
        i += 1;
      }
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(252303);
      updatePosition();
      int i = 0;
      while (i < 7)
      {
        if ((this.agaM) || (this.agbH) || (this.agbD[i] != 0))
        {
          b.p localp = this.agbC[i];
          if (localp != null) {
            localp.j(this.agay, this.agaz, this.agaM, this.agbH);
          }
        }
        i += 1;
      }
      this.agbH = false;
      AppMethodBeat.o(252303);
      return true;
    }
  }
  
  public final class m
    extends b.f
  {
    private final int agbJ;
    private boolean agbK;
    private float agbL;
    private float agbM;
    private boolean agbN;
    private final float agbO;
    private final int[] agbP;
    
    public m(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
    {
      super(paramDrawable1, paramDrawable2, paramInt1, (byte)0);
      AppMethodBeat.i(252278);
      this.agbK = false;
      this.agbN = false;
      this.agbP = new int[2];
      this.agbJ = paramInt2;
      this.agbO = (ViewConfiguration.get(b.c(b.this).getContext()).getScaledTouchSlop() * 4);
      AppMethodBeat.o(252278);
    }
    
    private static float a(Layout paramLayout, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(252301);
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
        AppMethodBeat.o(252301);
        return f;
        i = Math.max(paramInt - 1, 0);
        break;
      }
      label75:
      float f = paramLayout.getSecondaryHorizontal(paramInt);
      AppMethodBeat.o(252301);
      return f;
    }
    
    private void cU(int paramInt, boolean paramBoolean)
    {
      boolean bool2 = true;
      AppMethodBeat.i(252295);
      int i;
      int j;
      float f1;
      if (jGU())
      {
        i = b.c(b.this).getSelectionEnd();
        if ((!jGU()) || (paramInt < i))
        {
          j = paramInt;
          if (jGU()) {
            break label245;
          }
          j = paramInt;
          if (paramInt > i) {
            break label245;
          }
        }
        this.agbL = 0.0F;
        localObject = b.c(b.this).getLayout();
        if ((localObject == null) || (paramInt == i)) {
          break label217;
        }
        f1 = c((Layout)localObject, paramInt);
        if (jGU()) {
          break label211;
        }
      }
      label211:
      for (boolean bool1 = true;; bool1 = false)
      {
        float f2 = a((Layout)localObject, i, bool1);
        float f3 = c((Layout)localObject, this.LKx);
        if (((f3 >= f2) || (f1 >= f2)) && ((f3 <= f2) || (f1 <= f2))) {
          break label217;
        }
        paramInt = getCurrentCursorOffset();
        if (!jGU()) {
          Math.max(paramInt - 1, 0);
        }
        jGU();
        v(0, false, paramBoolean);
        AppMethodBeat.o(252295);
        return;
        i = b.c(b.this).getSelectionStart();
        break;
      }
      label217:
      Object localObject = b.this;
      if (!jGU()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        j = b.a((b)localObject, i, bool1);
        label245:
        v(j, false, paramBoolean);
        AppMethodBeat.o(252295);
        return;
      }
    }
    
    private boolean jGU()
    {
      return this.agbJ == 0;
    }
    
    protected final void KS(int paramInt)
    {
      AppMethodBeat.i(252325);
      if (jGU()) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt, b.c(b.this).getSelectionEnd());
      }
      for (;;)
      {
        Nt(false);
        if (b.f(b.this) != null) {
          b.v(b.this);
        }
        AppMethodBeat.o(252325);
        return;
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionStart(), paramInt);
      }
    }
    
    protected final int Nu(boolean paramBoolean)
    {
      AppMethodBeat.i(252314);
      if (paramBoolean == jGU())
      {
        AppMethodBeat.o(252314);
        return 3;
      }
      AppMethodBeat.o(252314);
      return 5;
    }
    
    protected final int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(252378);
      paramInt = paramLayout.getOffsetForHorizontal(paramInt, b.c(b.this).ef(paramFloat));
      AppMethodBeat.o(252378);
      return paramInt;
    }
    
    protected final boolean b(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(252362);
      if (jGU()) {}
      for (;;)
      {
        boolean bool = paramLayout.isRtlCharAt(paramInt);
        AppMethodBeat.o(252362);
        return bool;
        paramInt = Math.max(paramInt - 1, 0);
      }
    }
    
    public final float c(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(252372);
      float f = a(paramLayout, paramInt, jGU());
      AppMethodBeat.o(252372);
      return f;
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(252308);
      if (paramBoolean == jGU())
      {
        i = paramDrawable.getIntrinsicWidth() / 4;
        AppMethodBeat.o(252308);
        return i;
      }
      int i = paramDrawable.getIntrinsicWidth() * 3 / 4;
      AppMethodBeat.o(252308);
      return i;
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(252319);
      if (jGU())
      {
        i = b.c(b.this).getSelectionStart();
        AppMethodBeat.o(252319);
        return i;
      }
      int i = b.c(b.this).getSelectionEnd();
      AppMethodBeat.o(252319);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      AppMethodBeat.i(252385);
      if (jGU())
      {
        AppMethodBeat.o(252385);
        return 1;
      }
      AppMethodBeat.o(252385);
      return 2;
    }
    
    protected final void j(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      AppMethodBeat.i(252340);
      Layout localLayout = b.c(b.this).getLayout();
      if (localLayout == null)
      {
        cU(b.c(b.this).bk(paramFloat1, paramFloat2), paramBoolean);
        AppMethodBeat.o(252340);
        return;
      }
      if (this.agaO == -1) {
        this.agaO = b.c(b.this).eg(paramFloat2);
      }
      int i;
      int i1;
      int j;
      if (jGU())
      {
        i = b.c(b.this).getSelectionEnd();
        i1 = b.this.a(localLayout, this.agaO, paramFloat2);
        j = b(localLayout, i1, paramFloat1);
        if (((!jGU()) || (j < i)) && ((jGU()) || (j > i))) {
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
        if (this.agbM == -1.0F) {
          this.agbM = paramFloat1;
        }
        int i2 = getCurrentCursorOffset();
        boolean bool1 = b(localLayout, i2);
        boolean bool2 = b(localLayout, j);
        if (((bool1) && (!bool2)) || ((!bool1) && (bool2)))
        {
          this.agbN = true;
          this.agbL = 0.0F;
          cU(j, paramBoolean);
          AppMethodBeat.o(252340);
          return;
          i = b.c(b.this).getSelectionStart();
          break;
        }
        if (this.agbN)
        {
          cU(j, paramBoolean);
          this.agbL = 0.0F;
          this.agbN = false;
          AppMethodBeat.o(252340);
          return;
        }
        paramFloat2 = paramFloat1 - this.agbM;
        int n;
        if (jGU()) {
          if (i1 < this.agaO)
          {
            i = 1;
            if (bool2 != jGU()) {
              break label610;
            }
            if (paramFloat2 <= 0.0F) {
              break label604;
            }
            n = 1;
            label357:
            n = i | n;
            if (!b.c(b.this).getHorizontallyScrolling()) {
              break label701;
            }
            b.c(b.this).getLocationOnScreen(this.agbP);
            if (bool2 != jGU()) {
              break label641;
            }
            if (paramFloat1 <= this.agbP[0] + b.c(b.this).getWidth() - b.c(b.this).getPaddingRight() - this.agbO) {
              break label635;
            }
            i = 1;
            label442:
            if (i == 0) {
              break label701;
            }
            if ((!jGU()) || (b.c(b.this).getScrollX() == 0))
            {
              if (jGU()) {
                break label701;
              }
              CustomTextView localCustomTextView = b.c(b.this);
              if (!bool2) {
                break label681;
              }
              i = -1;
              label491:
              if (!localCustomTextView.canScrollHorizontally(i)) {
                break label701;
              }
            }
            if (((n == 0) || (((!jGU()) || (j >= i2)) && ((jGU()) || (j <= i2)))) && (n != 0)) {
              break label701;
            }
            this.agbL = 0.0F;
            if (bool2 != jGU()) {
              break label687;
            }
          }
        }
        label681:
        label687:
        for (i = localLayout.getOffsetToRightOf(this.LKx);; i = localLayout.getOffsetToLeftOf(this.LKx))
        {
          cU(i, paramBoolean);
          AppMethodBeat.o(252340);
          return;
          i = 0;
          break;
          if (i1 > this.agaO)
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
          if (paramFloat1 < this.agbP[0] + b.c(b.this).getPaddingLeft() + this.agbO)
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
          if (jGU())
          {
            i = m;
            if (this.agbK)
            {
              if (!jGU()) {
                break label944;
              }
              if (i1 >= this.agaN) {
                break label953;
              }
            }
            label740:
            if (bool2 != b(localLayout, i)) {
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
              if (!jGU()) {
                break label959;
              }
              n = localLayout.getLineStart(i1);
            }
            if (!jGU()) {
              break label971;
            }
            n = k - (k - n) / 2;
            if (!jGU()) {
              break label986;
            }
            i = m;
            if (j > n)
            {
              if (i1 >= this.agaN) {
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
          if (((jGU()) && (i < j)) || ((!jGU()) && (i > j)))
          {
            paramFloat2 = c(localLayout, i);
            this.agbL = (b.c(b.this).ef(paramFloat1) - paramFloat2);
            k = 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            if (i != 0)
            {
              this.agaO = i1;
              cU(j, paramBoolean);
            }
            this.agbM = paramFloat1;
            AppMethodBeat.o(252340);
            return;
            i = k;
            break;
            label944:
            if (i1 > this.agaN) {
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
            if ((!jGU()) && ((j >= n) || (i1 > this.agaN)))
            {
              i = k;
              break label843;
            }
            i = this.LKx;
            break label843;
            this.agbL = 0.0F;
            break label897;
            n = b(localLayout, i1, paramFloat1 - this.agbL);
            if (jGU()) {
              if ((n > this.LKx) || (i1 > this.agaN))
              {
                i = 1;
                label1077:
                if (i == 0) {
                  break label1220;
                }
                if (i1 == this.agaN) {
                  break label1213;
                }
                if (!jGU()) {
                  break label1198;
                }
                label1098:
                if (((!jGU()) || (m >= j)) && ((jGU()) || (m <= j))) {
                  break label1205;
                }
                paramFloat2 = c(localLayout, m);
                this.agbL = (b.c(b.this).ef(paramFloat1) - paramFloat2);
              }
            }
            for (;;)
            {
              i = 1;
              j = m;
              break;
              i = 0;
              break label1077;
              if ((n < this.LKx) || (i1 < this.agaN))
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
              this.agbL = 0.0F;
              continue;
              label1213:
              m = n;
            }
            label1220:
            if (((jGU()) && (n < this.LKx)) || ((!jGU()) && (n > this.LKx))) {
              this.agbL = (b.c(b.this).ef(paramFloat1) - c(localLayout, this.LKx));
            }
            i = 0;
          }
          i = j;
        }
      }
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252353);
      if (!b.c(b.this).b(paramMotionEvent, true))
      {
        AppMethodBeat.o(252353);
        return true;
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(252353);
        return bool;
        this.agbL = 0.0F;
        this.agbM = -1.0F;
        aC(paramMotionEvent);
        continue;
        aC(paramMotionEvent);
        continue;
        jGN();
      }
    }
    
    protected final void v(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(252349);
      super.v(paramInt, paramBoolean1, paramBoolean2);
      if (paramInt != -1)
      {
        com.tencent.mm.ui.widget.cedit.c.b localb = b.w(b.this);
        localb.aEE(paramInt);
        if (localb.agcI.isBoundary(paramInt)) {}
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        this.agbK = paramBoolean1;
        AppMethodBeat.o(252349);
        return;
      }
    }
  }
  
  public final class n
    implements b.d
  {
    private b.m agbQ;
    private b.m agbR;
    int agbS;
    int agbT;
    private boolean agbU;
    private int agbV;
    private boolean agbW;
    private int agbX;
    private boolean agbY;
    private int agbZ;
    
    n()
    {
      AppMethodBeat.i(252283);
      this.agbV = -1;
      this.agbX = -1;
      this.agbY = false;
      this.agbZ = 0;
      jGW();
      AppMethodBeat.o(252283);
    }
    
    private void Z(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(252328);
      if ((paramBoolean) && (b.n(b.this)) && ((b.c(b.this).getSelectionStart() != paramInt1) || (b.c(b.this).getSelectionEnd() != paramInt2))) {}
      for (int i = 1;; i = 0)
      {
        Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt1, paramInt2);
        if (i != 0) {
          b.c(b.this).performHapticFeedback(9);
        }
        AppMethodBeat.o(252328);
        return;
      }
    }
    
    private void aE(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252298);
      if (b.c(b.this).getLayout() != null) {
        switch (this.agbZ)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(252298);
        return;
        aF(paramMotionEvent);
        AppMethodBeat.o(252298);
        return;
        aG(paramMotionEvent);
        AppMethodBeat.o(252298);
        return;
        aH(paramMotionEvent);
      }
    }
    
    private void aF(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252307);
      int i = b.c(b.this).bk(paramMotionEvent.getX(), paramMotionEvent.getY());
      Z(this.agbV, i, paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(252307);
    }
    
    private void aG(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252316);
      if (this.agbW)
      {
        AppMethodBeat.o(252316);
        return;
      }
      boolean bool = paramMotionEvent.isFromSource(8194);
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.c(b.this).getContext());
      float f3 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int j;
      int i;
      int k;
      if (bool)
      {
        j = b.c(b.this).eg(f2);
        i = b.c(b.this).E(j, f3);
        if (this.agbV < i)
        {
          i = b.a(b.this, i);
          k = b.b(b.this, this.agbV);
          label120:
          this.agbX = j;
          Z(k, i, paramMotionEvent.isFromSource(4098));
          AppMethodBeat.o(252316);
        }
      }
      else
      {
        if (!this.agbY) {
          break label304;
        }
        i = localViewConfiguration.getScaledTouchSlop();
        if (this.agbQ != null) {
          f1 = this.agbQ.getIdealVerticalOffset();
        }
      }
      label176:
      for (float f1 = f2 - f1;; f1 = f2)
      {
        i = b.this.a(b.c(b.this).getLayout(), this.agbX, f1);
        j = i;
        if (this.agbY) {
          break;
        }
        j = i;
        if (i == this.agbX) {
          break;
        }
        this.agbY = true;
        AppMethodBeat.o(252316);
        return;
        f1 = i;
        break label176;
        int n = b.b(b.this, i);
        int m = b.a(b.this, this.agbV);
        k = m;
        i = n;
        if (m != n) {
          break label120;
        }
        i = b.a(b.this, n, false);
        k = m;
        break label120;
      }
    }
    
    private void aH(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252320);
      int j = b.c(b.this).bk(paramMotionEvent.getX(), paramMotionEvent.getY());
      int i = Math.min(j, this.agbV);
      j = Math.max(j, this.agbV);
      long l = b.a(b.this, i, j);
      Z((int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(252320);
    }
    
    private void jGV()
    {
      AppMethodBeat.i(252290);
      if (this.agbQ == null) {
        this.agbQ = new b.m(b.this, b.this.afZP, b.this.afZQ, a.g.selection_start_handle, 0);
      }
      if (this.agbR == null) {
        this.agbR = new b.m(b.this, b.this.afZQ, b.this.afZP, a.g.selection_end_handle, 1);
      }
      this.agbQ.show();
      this.agbR.show();
      b.this.jFY();
      AppMethodBeat.o(252290);
    }
    
    private void jGX()
    {
      AppMethodBeat.i(252334);
      this.agbV = -1;
      this.agbZ = 0;
      this.agbY = false;
      int i = b.c(b.this).getSelectionStart();
      int j = b.c(b.this).getSelectionEnd();
      if ((i < 0) || (j < 0))
      {
        Selection.removeSelection((Spannable)b.c(b.this).getText());
        AppMethodBeat.o(252334);
        return;
      }
      if (i > j) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), j, i);
      }
      AppMethodBeat.o(252334);
    }
    
    public final void B(MotionEvent paramMotionEvent)
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(252403);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      boolean bool2 = paramMotionEvent.isFromSource(8194);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(252403);
        return;
        if (b.A(b.this))
        {
          hide();
          AppMethodBeat.o(252403);
          return;
        }
        i = b.c(b.this).bk(f1, f2);
        this.agbT = i;
        this.agbS = i;
        if (this.agbU)
        {
          paramMotionEvent = b.x(b.this);
          if ((!paramMotionEvent.jHc()) || (!paramMotionEvent.agcl)) {
            break label249;
          }
          i = 1;
          if ((i != 0) && ((bool2) || (b.a(b.this, f1, f2)) || (b.x(b.this).agcj)))
          {
            if (b.x(b.this).agck != 2) {
              break label255;
            }
            i = 1;
            label212:
            if (i == 0) {
              break label261;
            }
            b.B(b.this);
          }
        }
        for (;;)
        {
          b.this.afZy = true;
          this.agbU = true;
          this.agbW = true;
          AppMethodBeat.o(252403);
          return;
          label249:
          i = 0;
          break;
          label255:
          i = 0;
          break label212;
          label261:
          i = j;
          if (b.x(b.this).agck == 3) {
            i = 1;
          }
          if (i != 0)
          {
            if (b.y(b.this) != null) {
              b.c(b.this).removeCallbacks(b.y(b.this));
            }
            b.this.jFJ();
            if (b.D(b.this)) {
              aEw(3);
            }
          }
        }
        if (b.c(b.this).getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct"))
        {
          j = paramMotionEvent.getPointerCount();
          while (i < j)
          {
            int k = b.c(b.this).bk(paramMotionEvent.getX(i), paramMotionEvent.getY(i));
            if (k < this.agbS) {
              this.agbS = k;
            }
            if (k > this.agbT) {
              this.agbT = k;
            }
            i += 1;
          }
          AppMethodBeat.o(252403);
          return;
          if (this.agbU)
          {
            ViewConfiguration.get(b.c(b.this).getContext());
            i = bd.fromDPToPix(b.c(b.this).getContext(), 8);
            this.agbU = c.b(b.x(b.this).uJC, b.x(b.this).uJD, f1, f2, i);
          }
          if (this.agbW) {
            if (b.x(b.this).agcm) {
              break label640;
            }
          }
          label640:
          for (boolean bool1 = true;; bool1 = false)
          {
            this.agbW = bool1;
            if ((!bool2) || (jGZ())) {
              break label680;
            }
            i = b.c(b.this).bk(f1, f2);
            if ((!b.c(b.this).jFB()) || ((this.agbW) && (this.agbV == i)) || (i < b.c(b.this).getSelectionStart()) || (i > b.c(b.this).getSelectionEnd())) {
              break;
            }
            b.C(b.this);
            AppMethodBeat.o(252403);
            return;
          }
          if (this.agbV != i)
          {
            b.this.jFJ();
            aEw(1);
            b.this.afZy = true;
            this.agbW = false;
          }
          label680:
          if ((this.agbQ == null) || (!this.agbQ.isShowing()))
          {
            aE(paramMotionEvent);
            AppMethodBeat.o(252403);
            return;
            if (jGZ())
            {
              aE(paramMotionEvent);
              b.c(b.this).getParent().requestDisallowInterceptTouchEvent(false);
              jGX();
              if (b.c(b.this).jFB())
              {
                b.this.jGw().jHd();
                b.c(b.this).invalidate();
              }
            }
          }
        }
      }
    }
    
    public final void aEw(int paramInt)
    {
      AppMethodBeat.i(252380);
      show();
      this.agbZ = paramInt;
      this.agbV = b.c(b.this).bk(b.x(b.this).uJC, b.x(b.this).uJD);
      this.agbX = b.c(b.this).eg(b.x(b.this).uJD);
      hide();
      b.c(b.this).getParent().requestDisallowInterceptTouchEvent(true);
      b.c(b.this).cancelLongPress();
      AppMethodBeat.o(252380);
    }
    
    public final void hide()
    {
      AppMethodBeat.i(252371);
      if (this.agbQ != null) {
        this.agbQ.hide();
      }
      if (this.agbR != null) {
        this.agbR.hide();
      }
      AppMethodBeat.o(252371);
    }
    
    public final void iQ()
    {
      AppMethodBeat.i(252436);
      b.c(b.this).getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.agbQ != null) {
        this.agbQ.iQ();
      }
      if (this.agbR != null) {
        this.agbR.iQ();
      }
      AppMethodBeat.o(252436);
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(252441);
      if ((this.agbQ != null) && (this.agbQ.isShowing()))
      {
        AppMethodBeat.o(252441);
        return true;
      }
      AppMethodBeat.o(252441);
      return false;
    }
    
    public final boolean jGJ()
    {
      AppMethodBeat.i(252422);
      if ((jGZ()) || (jGY()) || ((this.agbR != null) && (this.agbR.uwK)))
      {
        AppMethodBeat.o(252422);
        return true;
      }
      AppMethodBeat.o(252422);
      return false;
    }
    
    public final void jGW()
    {
      AppMethodBeat.i(252410);
      this.agbT = -1;
      this.agbS = -1;
      jGX();
      AppMethodBeat.o(252410);
    }
    
    public final boolean jGY()
    {
      return (this.agbQ != null) && (this.agbQ.uwK);
    }
    
    public final boolean jGZ()
    {
      return this.agbZ != 0;
    }
    
    public final void jHa()
    {
      AppMethodBeat.i(252446);
      if (this.agbQ != null) {
        this.agbQ.invalidate();
      }
      if (this.agbR != null) {
        this.agbR.invalidate();
      }
      AppMethodBeat.o(252446);
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(252430);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(252430);
    }
    
    public final void show()
    {
      AppMethodBeat.i(252360);
      if (b.c(b.this).jFP())
      {
        AppMethodBeat.o(252360);
        return;
      }
      b.this.Nr(false);
      jGV();
      AppMethodBeat.o(252360);
    }
  }
  
  final class o
    extends ActionMode.Callback2
  {
    private final Path agca;
    private final RectF agcb;
    private final boolean agcc;
    private final int agcd;
    private final Map<MenuItem, View.OnClickListener> agce;
    
    o(int paramInt)
    {
      AppMethodBeat.i(252291);
      this.agca = new Path();
      this.agcb = new RectF();
      this.agce = new HashMap();
      if ((paramInt == 0) || ((b.this.afZE) && (paramInt == 2))) {}
      for (boolean bool = true;; bool = false)
      {
        this.agcc = bool;
        if (!this.agcc) {
          break;
        }
        localObject = b.this.jGF();
        if (b.n.a((b.n)localObject) == null)
        {
          b.this.Nr(false);
          b.n.b((b.n)localObject);
          ((b.n)localObject).hide();
        }
        this.agcd = Math.max(b.this.afZP.getMinimumHeight(), b.this.afZQ.getMinimumHeight());
        AppMethodBeat.o(252291);
        return;
      }
      Object localObject = b.this.jGE();
      if (localObject != null)
      {
        ((b.j)localObject).jGS();
        this.agcd = b.this.afZR.getMinimumHeight();
        AppMethodBeat.o(252291);
        return;
      }
      this.agcd = 0;
      AppMethodBeat.o(252291);
    }
    
    private void g(Menu paramMenu)
    {
      AppMethodBeat.i(252305);
      boolean bool = b.c(b.this).jFN();
      if (paramMenu.findItem(16908319) != null) {}
      for (int i = 1; (bool) && (i == 0); i = 0)
      {
        paramMenu.add(0, 16908319, 8, 17039373).setShowAsAction(1);
        AppMethodBeat.o(252305);
        return;
      }
      if ((!bool) && (i != 0)) {
        paramMenu.removeItem(16908319);
      }
      AppMethodBeat.o(252305);
    }
    
    private ActionMode.Callback jHb()
    {
      if (this.agcc) {
        return b.this.afZV;
      }
      return b.this.afZW;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252326);
      b.h(b.this);
      paramMenuItem.getItemId();
      paramMenuItem.getTitle().toString();
      ActionMode.Callback localCallback = jHb();
      if ((localCallback != null) && (localCallback.onActionItemClicked(paramActionMode, paramMenuItem)))
      {
        AppMethodBeat.o(252326);
        return true;
      }
      if (paramMenuItem.getGroupId() == 16908353)
      {
        if (paramMenuItem.getGroupId() == 16908353) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool);
          b.h(b.this);
          AppMethodBeat.o(252326);
          return true;
        }
      }
      boolean bool = b.c(b.this).onTextContextMenuItem(paramMenuItem.getItemId());
      AppMethodBeat.o(252326);
      return bool;
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(252313);
      this.agce.clear();
      paramActionMode.setTitle(null);
      paramActionMode.setSubtitle(null);
      paramActionMode.setTitleOptionalHint(true);
      if (b.c(b.this).jFK()) {
        paramMenu.add(0, 16908320, 4, 17039363).setAlphabeticShortcut('x').setShowAsAction(2);
      }
      if (b.c(b.this).jFL()) {
        paramMenu.add(0, 16908321, 5, 17039361).setAlphabeticShortcut('c').setShowAsAction(2);
      }
      if (b.c(b.this).jFM()) {
        paramMenu.add(0, 16908322, 6, 17039371).setAlphabeticShortcut('v').setShowAsAction(2);
      }
      g(paramMenu);
      ActionMode.Callback localCallback = jHb();
      if ((localCallback != null) && (!localCallback.onCreateActionMode(paramActionMode, paramMenu)))
      {
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionEnd());
        AppMethodBeat.o(252313);
        return false;
      }
      if ((this.agcc) && (!b.c(b.this).hasTransientState())) {
        b.c(b.this).setHasTransientState(true);
      }
      AppMethodBeat.o(252313);
      return true;
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      AppMethodBeat.i(252331);
      b.h(b.this);
      b.i(b.this);
      ActionMode.Callback localCallback = jHb();
      if (localCallback != null) {
        localCallback.onDestroyActionMode(paramActionMode);
      }
      if (!b.j(b.this)) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionEnd());
      }
      if (b.this.afZj != null) {
        b.this.afZj.hide();
      }
      this.agce.clear();
      b.k(b.this);
      AppMethodBeat.o(252331);
    }
    
    public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect)
    {
      AppMethodBeat.i(252337);
      Log.i("cmEdit.Editor", "onGetContentRect mode:" + paramActionMode + ",view:" + paramView + ",outRect:" + paramRect);
      if ((!paramView.equals(b.c(b.this))) || (b.c(b.this).getLayout() == null))
      {
        super.onGetContentRect(paramActionMode, paramView, paramRect);
        AppMethodBeat.o(252337);
        return;
      }
      if (b.c(b.this).getSelectionStart() != b.c(b.this).getSelectionEnd())
      {
        this.agca.reset();
        b.c(b.this).getLayout().getSelectionPath(b.c(b.this).getSelectionStart(), b.c(b.this).getSelectionEnd(), this.agca);
        this.agca.computeBounds(this.agcb, true);
        paramActionMode = this.agcb;
        paramActionMode.bottom += this.agcd;
      }
      for (;;)
      {
        int m = b.c(b.this).jFz();
        int i = b.c(b.this).jFA();
        int j = (int)Math.floor(this.agcb.left + m);
        int k = (int)Math.floor(this.agcb.top + i);
        float f = this.agcb.right;
        m = (int)Math.ceil(m + f);
        f = this.agcb.bottom;
        paramRect.set(j, k, m, (int)Math.ceil(i + f));
        AppMethodBeat.o(252337);
        return;
        paramActionMode = b.c(b.this).getLayout();
        i = paramActionMode.getLineForOffset(b.c(b.this).getSelectionStart());
        f = b.a(b.this, null, paramActionMode.getPrimaryHorizontal(b.c(b.this).getSelectionStart()));
        this.agcb.set(f, paramActionMode.getLineTop(i), f, paramActionMode.getLineBottom(i) + this.agcd);
      }
    }
    
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(252318);
      g(paramMenu);
      ActionMode.Callback localCallback = jHb();
      if (localCallback != null)
      {
        boolean bool = localCallback.onPrepareActionMode(paramActionMode, paramMenu);
        AppMethodBeat.o(252318);
        return bool;
      }
      AppMethodBeat.o(252318);
      return true;
    }
  }
  
  public static abstract interface p
  {
    public abstract void j(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.b
 * JD-Core Version:    0.7.0.1
 */