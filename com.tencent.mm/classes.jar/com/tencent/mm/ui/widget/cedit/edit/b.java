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
import androidx.core.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.cedit.util.ParcelableParcel;
import java.text.BreakIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class b
{
  int IhY;
  boolean Xlf;
  boolean YhA;
  a YhB;
  boolean YhC;
  boolean YhD;
  boolean YhE;
  boolean YhF;
  boolean YhG;
  private boolean YhH;
  boolean YhI;
  private boolean YhJ;
  private d YhK;
  boolean YhL;
  boolean YhM;
  Runnable YhN;
  Drawable YhO;
  Drawable YhP;
  Drawable YhQ;
  Drawable YhR;
  l YhS;
  private float YhT;
  private float YhU;
  ActionMode.Callback YhV;
  ActionMode.Callback YhW;
  boolean YhX;
  int YhY;
  final c YhZ;
  final CustomTextView Yhe;
  boolean Yhh;
  j Yhi;
  n Yhj;
  ActionMode Yhk;
  boolean Yhl;
  boolean Yhm;
  private final boolean Yhn;
  private k Yho;
  private final Runnable Yhp;
  final ViewTreeObserver.OnDrawListener Yhq;
  b Yhr;
  g Yhs;
  h Yht;
  boolean Yhu;
  boolean Yhv;
  boolean Yhw;
  KeyListener Yhx;
  boolean Yhy;
  long Yhz;
  Runnable Yia;
  private com.tencent.mm.ui.widget.cedit.c.b Yib;
  private com.tencent.mm.ui.widget.cedit.c.b Yic;
  private boolean Yid;
  private final c Yie;
  final Runnable Yif;
  boolean Yig;
  private boolean Yih;
  private final boolean Yii;
  private int Yij;
  private float Yik;
  private int Yil;
  private int Yim;
  private com.tencent.mm.ui.widget.cedit.a.a Yin;
  private boolean Yio;
  private Rect mTempRect;
  
  b(CustomTextView paramCustomTextView)
  {
    AppMethodBeat.i(187874);
    this.Yhh = true;
    this.Yhp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(217372);
        b.k localk = b.a(b.this);
        if (Build.VERSION.SDK_INT >= 28) {
          localk.Yjw.update();
        }
        AppMethodBeat.o(217372);
      }
    };
    this.Yhq = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(190707);
        if (b.a(b.this) != null) {
          b.c(b.this).post(b.b(b.this));
        }
        AppMethodBeat.o(190707);
      }
    };
    this.IhY = 0;
    this.YhC = true;
    this.YhG = true;
    this.YhO = null;
    this.YhZ = new c();
    this.Yie = new c((byte)0);
    this.Yif = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203705);
        if (b.d(b.this)) {
          b.e(b.this);
        }
        if ((b.f(b.this) != null) && (Build.VERSION.SDK_INT >= 23))
        {
          b.f(b.this).hide(0L);
          Log.i("cmEdit.Editor", "mTextActionMode.hide(0)");
        }
        AppMethodBeat.o(203705);
      }
    };
    this.Yig = false;
    this.Yik = 1.0F;
    this.Yio = false;
    this.Yhe = paramCustomTextView;
    this.Yhe.setFilters(this.Yhe.getFilters());
    this.Yhn = false;
    this.Yih = false;
    this.Yii = false;
    this.Yil = ((int)TypedValue.applyDimension(1, 45.0F, this.Yhe.getContext().getResources().getDisplayMetrics()));
    this.Yim = ((int)TypedValue.applyDimension(1, 12.0F, this.Yhe.getContext().getResources().getDisplayMetrics()));
    AppMethodBeat.o(187874);
  }
  
  private int a(Drawable paramDrawable, float paramFloat)
  {
    AppMethodBeat.i(187979);
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
      j = this.Yhe.getScrollX();
      f = paramFloat - j;
      k = this.Yhe.getWidth() - this.Yhe.getCompoundPaddingLeft() - this.Yhe.getCompoundPaddingRight();
      if (f < k - 1.0F) {
        break label145;
      }
      i = k + j - (i - this.mTempRect.right);
    }
    for (;;)
    {
      AppMethodBeat.o(187979);
      return i;
      this.mTempRect.setEmpty();
      break;
      label145:
      if ((Math.abs(f) <= 1.0F) || ((TextUtils.isEmpty(this.Yhe.getText())) && (1048576 - j <= k + 1.0F) && (paramFloat <= 1.0F))) {
        i = j - this.mTempRect.left;
      } else {
        i = (int)paramFloat - this.mTempRect.left;
      }
    }
  }
  
  private static Drawable a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(187991);
    if (!(paramDrawable instanceof BitmapDrawable))
    {
      AppMethodBeat.o(187991);
      return paramDrawable;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(187991);
      return paramDrawable;
    }
    paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    float f1 = i / paramDrawable.getWidth();
    paramInt = aw.fromDPToPix(paramContext, paramInt);
    float f2 = paramInt;
    paramDrawable = Bitmap.createScaledBitmap(paramDrawable, (int)(i / j * f2 / f1), (int)(paramInt / f1), true);
    paramContext = new BitmapDrawable(paramContext.getResources(), paramDrawable);
    AppMethodBeat.o(187991);
    return paramContext;
  }
  
  private void a(h paramh)
  {
    AppMethodBeat.i(187917);
    if ((paramh.mContentChanged) || (paramh.Yjg))
    {
      this.Yhe.iav();
      ibc();
      ibd();
      if (!ibk()) {
        if (!this.Yhe.iau()) {
          break label110;
        }
      }
    }
    label110:
    for (paramh = ibv();; paramh = ibu())
    {
      if ((paramh != null) && (!paramh.isActive()) && (!paramh.ibz())) {
        paramh.show();
      }
      AppMethodBeat.o(187917);
      return;
      if (!paramh.Yjf) {
        break;
      }
      this.Yhe.iaj();
      break;
    }
  }
  
  static void a(ParcelableParcel paramParcelableParcel)
  {
    AppMethodBeat.i(187875);
    paramParcelableParcel.ave.setDataPosition(0);
    AppMethodBeat.o(187875);
  }
  
  private boolean aH(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(187898);
    Layout localLayout = this.Yhe.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(187898);
      return false;
    }
    int i = this.Yhe.cT(paramFloat2);
    paramFloat1 = this.Yhe.cS(paramFloat1);
    if (paramFloat1 < localLayout.getLineLeft(i))
    {
      AppMethodBeat.o(187898);
      return false;
    }
    if (paramFloat1 > localLayout.getLineRight(i))
    {
      AppMethodBeat.o(187898);
      return false;
    }
    AppMethodBeat.o(187898);
    return true;
  }
  
  private int cc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187893);
    Layout localLayout = this.Yhe.getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(187893);
      return paramInt;
    }
    if (paramBoolean == localLayout.isRtlCharAt(paramInt))
    {
      paramInt = localLayout.getOffsetToLeftOf(paramInt);
      AppMethodBeat.o(187893);
      return paramInt;
    }
    paramInt = localLayout.getOffsetToRightOf(paramInt);
    AppMethodBeat.o(187893);
    return paramInt;
  }
  
  private void fLs()
  {
    AppMethodBeat.i(187938);
    if (this.Yin != null) {
      this.Yin.dismiss();
    }
    AppMethodBeat.o(187938);
  }
  
  private void h(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(187978);
    iby();
    int i = a(this.YhO, paramFloat);
    int j = this.YhO.getIntrinsicWidth();
    this.YhO.setBounds(i, paramInt1 - this.mTempRect.top, j + i, this.mTempRect.bottom + paramInt2);
    AppMethodBeat.o(187978);
  }
  
  private boolean iaR()
  {
    AppMethodBeat.i(187886);
    if ((this.Yhe.Yfx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(187886);
      return true;
    }
    int j = this.Yhe.getInputType();
    int i = j & 0xF;
    j &= 0xFF0;
    if ((i == 2) || (i == 3) || (i == 4) || (j == 16) || (j == 32) || (j == 208) || (j == 176))
    {
      AppMethodBeat.o(187886);
      return true;
    }
    AppMethodBeat.o(187886);
    return false;
  }
  
  private boolean iaS()
  {
    AppMethodBeat.i(187888);
    if (!this.Yhe.iay())
    {
      AppMethodBeat.o(187888);
      return false;
    }
    if (iaR())
    {
      boolean bool = this.Yhe.iaG();
      AppMethodBeat.o(187888);
      return bool;
    }
    long l = iaX();
    int k = (int)(l >>> 32);
    int j = (int)(l & 0xFFFFFFFF);
    if ((k < 0) || (k > this.Yhe.getText().length()))
    {
      AppMethodBeat.o(187888);
      return false;
    }
    if ((j < 0) || (j > this.Yhe.getText().length()))
    {
      AppMethodBeat.o(187888);
      return false;
    }
    Object localObject = (URLSpan[])((Spanned)this.Yhe.getText()).getSpans(k, j, URLSpan.class);
    int i;
    if (localObject.length > 0)
    {
      localObject = localObject[0];
      i = ((Spanned)this.Yhe.getText()).getSpanStart(localObject);
      j = ((Spanned)this.Yhe.getText()).getSpanEnd(localObject);
    }
    for (;;)
    {
      Selection.setSelection((Spannable)this.Yhe.getText(), i, j);
      if (j > i)
      {
        AppMethodBeat.o(187888);
        return true;
        localObject = getWordIterator();
        ((com.tencent.mm.ui.widget.cedit.c.b)localObject).i(this.Yhe.getText(), k, j);
        i = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).ce(k, false);
        j = ((com.tencent.mm.ui.widget.cedit.c.b)localObject).cf(j, false);
        if ((i == -1) || (j == -1) || (i == j))
        {
          if (k < this.Yhe.getText().length())
          {
            i = cc(k, true);
            l = com.tencent.mm.ui.widget.cedit.util.c.mV(cc(i, false), i);
          }
          for (;;)
          {
            i = (int)(l >>> 32);
            j = (int)(l & 0xFFFFFFFF);
            break;
            if (k - 1 >= 0)
            {
              i = cc(k, false);
              l = com.tencent.mm.ui.widget.cedit.util.c.mV(i, cc(i, true));
            }
            else
            {
              l = com.tencent.mm.ui.widget.cedit.util.c.mV(k, k);
            }
          }
        }
      }
      else
      {
        AppMethodBeat.o(187888);
        return false;
      }
    }
  }
  
  private com.tencent.mm.ui.widget.cedit.c.b iaT()
  {
    AppMethodBeat.i(187891);
    if (this.Yic == null)
    {
      this.Yic = new com.tencent.mm.ui.widget.cedit.c.b(this.Yhe.getTextServicesLocale());
      this.Yid = true;
    }
    if (this.Yid)
    {
      localObject = this.Yhe.getText();
      this.Yic.i((CharSequence)localObject, 0, ((CharSequence)localObject).length());
      this.Yid = false;
    }
    Object localObject = this.Yic;
    AppMethodBeat.o(187891);
    return localObject;
  }
  
  private l iaU()
  {
    AppMethodBeat.i(187894);
    if (this.YhS == null) {
      this.YhS = new l((byte)0);
    }
    l locall = this.YhS;
    AppMethodBeat.o(187894);
    return locall;
  }
  
  private void iaV()
  {
    AppMethodBeat.i(187899);
    ibm();
    int i = this.Yhe.getSelectionStart();
    int j = this.Yhe.getSelectionEnd();
    ClipData.newPlainText(null, this.Yhe.mS(i, j));
    new e(this.Yhe, i, j);
    iaB();
    if (this.Yhm) {
      ibv().ibM();
    }
    AppMethodBeat.o(187899);
  }
  
  private void iaW()
  {
    AppMethodBeat.i(187901);
    if (!ibk())
    {
      iaB();
      AppMethodBeat.o(187901);
      return;
    }
    ibh();
    AppMethodBeat.o(187901);
  }
  
  private long iaX()
  {
    AppMethodBeat.i(187902);
    n localn = ibv();
    long l = com.tencent.mm.ui.widget.cedit.util.c.mV(localn.YjT, localn.YjU);
    AppMethodBeat.o(187902);
    return l;
  }
  
  private void iba()
  {
    AppMethodBeat.i(187910);
    int i = ViewConfiguration.getDoubleTapTimeout();
    this.Yhe.postDelayed(this.Yif, i);
    ibm().ibU();
    AppMethodBeat.o(187910);
  }
  
  private void ibd()
  {
    AppMethodBeat.i(187925);
    InputMethodManager localInputMethodManager;
    int k;
    int m;
    int i;
    int j;
    if ((this.Yht != null) && (this.Yht.Yhf <= 0))
    {
      localInputMethodManager = getInputMethodManager();
      if (localInputMethodManager != null)
      {
        k = this.Yhe.getSelectionStart();
        m = this.Yhe.getSelectionEnd();
        if (!(this.Yhe.getText() instanceof Spannable)) {
          break label109;
        }
        Spannable localSpannable = (Spannable)this.Yhe.getText();
        i = a.getComposingSpanStart(localSpannable);
        j = a.getComposingSpanEnd(localSpannable);
      }
    }
    for (;;)
    {
      localInputMethodManager.updateSelection(this.Yhe, k, m, i, j);
      AppMethodBeat.o(187925);
      return;
      label109:
      j = -1;
      i = -1;
    }
  }
  
  private void ibi()
  {
    AppMethodBeat.i(187934);
    if (this.Yin == null) {
      this.Yin = new com.tencent.mm.ui.widget.cedit.a.a(this.Yhe);
    }
    this.Yin.show();
    this.Yio = true;
    AppMethodBeat.o(187934);
  }
  
  private void ibj()
  {
    AppMethodBeat.i(187937);
    com.tencent.mm.ui.widget.cedit.a.a locala;
    if (this.Yin != null) {
      locala = this.Yin;
    }
    try
    {
      Log.i("cmEdit.OperateWindow", "destroy OpWindow@%s", new Object[] { Integer.valueOf(locala.hashCode()) });
      locala.dismiss();
      locala.usB.setContentView(null);
      locala.Ykt = true;
      label58:
      this.Yio = false;
      AppMethodBeat.o(187937);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
  
  private void ibl()
  {
    AppMethodBeat.i(187944);
    if (this.Yhk != null) {
      this.Yhk.invalidate();
    }
    AppMethodBeat.o(187944);
  }
  
  private boolean ibn()
  {
    AppMethodBeat.i(187950);
    if (this.Yia != null) {
      this.Yhe.removeCallbacks(this.Yia);
    }
    if (ibq())
    {
      AppMethodBeat.o(187950);
      return false;
    }
    if (!ibo())
    {
      AppMethodBeat.o(187950);
      return false;
    }
    if ((!this.Yhe.iau()) && (!iaS()))
    {
      AppMethodBeat.o(187950);
      return false;
    }
    ibt();
    ibv().axN(2);
    AppMethodBeat.o(187950);
    return true;
  }
  
  private boolean ibo()
  {
    AppMethodBeat.i(187955);
    if ((!this.Yhe.iay()) || (!this.Yhe.requestFocus()))
    {
      Log.w("cmEdit.CMTextView", "TextView does not support text selection. Selection cancelled.");
      AppMethodBeat.o(187955);
      return false;
    }
    AppMethodBeat.o(187955);
    return true;
  }
  
  private boolean ibr()
  {
    AppMethodBeat.i(187963);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])((Spannable)this.Yhe.getText()).getSpans(this.Yhe.getSelectionStart(), this.Yhe.getSelectionEnd(), SuggestionSpan.class);
    int i = 0;
    while (i < arrayOfSuggestionSpan.length)
    {
      if ((arrayOfSuggestionSpan[i].getFlags() & 0x1) != 0)
      {
        AppMethodBeat.o(187963);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(187963);
    return false;
  }
  
  private void ibs()
  {
    AppMethodBeat.i(187971);
    ibm();
    this.Yhk = null;
    ibj();
    if (!this.YhH) {
      Selection.setSelection((Spannable)this.Yhe.getText(), this.Yhe.getSelectionEnd());
    }
    if (this.Yhj != null) {
      this.Yhj.hide();
    }
    this.YhJ = false;
    AppMethodBeat.o(187971);
  }
  
  private boolean ibw()
  {
    AppMethodBeat.i(187980);
    if ((!iaM()) || (!this.Yhe.isFocused()))
    {
      AppMethodBeat.o(187980);
      return false;
    }
    int i = this.Yhe.getSelectionStart();
    if (i < 0)
    {
      AppMethodBeat.o(187980);
      return false;
    }
    int j = this.Yhe.getSelectionEnd();
    if (j < 0)
    {
      AppMethodBeat.o(187980);
      return false;
    }
    if (i == j)
    {
      AppMethodBeat.o(187980);
      return true;
    }
    AppMethodBeat.o(187980);
    return false;
  }
  
  private long mU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187889);
    Layout localLayout = this.Yhe.getLayout();
    if (localLayout == null)
    {
      l = com.tencent.mm.ui.widget.cedit.util.c.mV(-1, -1);
      AppMethodBeat.o(187889);
      return l;
    }
    CharSequence localCharSequence = this.Yhe.getText();
    paramInt1 = localLayout.getLineForOffset(paramInt1);
    while ((paramInt1 > 0) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt1 - 1) - 1) != '\n')) {
      paramInt1 -= 1;
    }
    paramInt2 = localLayout.getLineForOffset(paramInt2);
    while ((paramInt2 < localLayout.getLineCount() - 1) && (localCharSequence.charAt(localLayout.getLineEnd(paramInt2) - 1) != '\n')) {
      paramInt2 += 1;
    }
    long l = com.tencent.mm.ui.widget.cedit.util.c.mV(localLayout.getLineStart(paramInt1), localLayout.getLineEnd(paramInt2));
    AppMethodBeat.o(187889);
    return l;
  }
  
  public final boolean Hu(boolean paramBoolean)
  {
    AppMethodBeat.i(187900);
    if (this.YhM)
    {
      if (!paramBoolean) {
        iaW();
      }
      AppMethodBeat.o(187900);
      return true;
    }
    int i;
    if ((!paramBoolean) && (!aH(this.YhZ.ryy, this.YhZ.ryz)) && (!this.YhZ.Ykk) && (this.Yhl))
    {
      i = this.Yhe.aG(this.YhZ.ryy, this.YhZ.ryz);
      Selection.setSelection((Spannable)this.Yhe.getText(), i);
      ibu().show();
      this.Yig = true;
    }
    for (boolean bool = true;; bool = paramBoolean)
    {
      paramBoolean = bool;
      int j;
      if (!bool)
      {
        paramBoolean = bool;
        if (!ibk())
        {
          i = this.Yhe.getSelectionStart();
          j = this.Yhe.getSelectionEnd();
          if (i == j) {
            break label247;
          }
          if (i <= j) {
            break label264;
          }
          Selection.setSelection((Spannable)this.Yhe.getText(), j, i);
        }
      }
      for (;;)
      {
        n localn = ibv();
        int k = localn.YjT;
        int m = localn.YjU;
        if ((k >= j) && (m < i))
        {
          i = 1;
          if (i == 0) {
            break label252;
          }
          iaV();
        }
        for (;;)
        {
          paramBoolean = true;
          bool = paramBoolean;
          if (!paramBoolean) {
            bool = ibn();
          }
          AppMethodBeat.o(187900);
          return bool;
          label247:
          i = 0;
          break;
          label252:
          iaB();
          ibn();
        }
        label264:
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  final void Hv(boolean paramBoolean)
  {
    AppMethodBeat.i(187992);
    if ((this.YhR == null) || (paramBoolean))
    {
      this.YhR = this.Yhe.getTextSelectHandle();
      if (this.YhR != null)
      {
        this.YhR = a(this.Yhe.getContext(), this.YhR, 23);
        this.YhR.setTint(this.Yhe.Ygn);
      }
      if (this.Yhl) {
        j.a(ibu());
      }
    }
    if ((this.YhP == null) || (this.YhQ == null) || (paramBoolean))
    {
      this.YhP = this.Yhe.getTextSelectHandleLeft();
      this.YhP = a(this.Yhe.getContext(), this.YhP, 21);
      this.YhP.setTint(this.Yhe.Ygn);
      this.YhQ = this.Yhe.getTextSelectHandleRight();
      this.YhQ = a(this.Yhe.getContext(), this.YhQ, 21);
      this.YhQ.setTint(this.Yhe.Ygn);
      if (this.Yhm) {
        n.d(ibv());
      }
    }
    AppMethodBeat.o(187992);
  }
  
  public final int a(Layout paramLayout, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(187987);
    int i = this.Yhe.cT(paramFloat);
    if ((paramLayout == null) || (paramInt > paramLayout.getLineCount()) || (paramLayout.getLineCount() <= 0) || (paramInt < 0))
    {
      AppMethodBeat.o(187987);
      return i;
    }
    if (Math.abs(i - paramInt) >= 2)
    {
      AppMethodBeat.o(187987);
      return i;
    }
    int j = paramLayout.getLineBottom(paramInt) - paramLayout.getLineTop(paramInt);
    int k = (int)(0.5F * (paramLayout.getLineBottom(i) - paramLayout.getLineTop(i)));
    j = Math.max(0, Math.max(this.Yim, Math.min(this.Yil, k + j)) - j);
    float f = this.Yhe.iat();
    if ((i > paramInt) && (paramFloat >= paramLayout.getLineBottom(paramInt) + j + f))
    {
      AppMethodBeat.o(187987);
      return i;
    }
    if ((i < paramInt) && (paramFloat <= paramLayout.getLineTop(paramInt) - j + f))
    {
      AppMethodBeat.o(187987);
      return i;
    }
    AppMethodBeat.o(187987);
    return paramInt;
  }
  
  final void a(DragEvent paramDragEvent)
  {
    int i = 1;
    AppMethodBeat.i(187983);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    this.Yhe.ian();
    try
    {
      int n = this.Yhe.aG(paramDragEvent.getX(), paramDragEvent.getY());
      Object localObject = paramDragEvent.getLocalState();
      paramDragEvent = null;
      if ((localObject instanceof e)) {
        paramDragEvent = (e)localObject;
      }
      if ((paramDragEvent != null) && (paramDragEvent.Yiu == this.Yhe)) {}
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
      int i1 = this.Yhe.getText().length();
      Selection.setSelection((Spannable)this.Yhe.getText(), n);
      ((Editable)this.Yhe.mText).replace(n, n, localSpannableStringBuilder);
      if (i != 0)
      {
        int m = paramDragEvent.start;
        int k = paramDragEvent.end;
        j = k;
        i = m;
        if (n <= m)
        {
          j = this.Yhe.getText().length() - i1;
          i = m + j;
          j = k + j;
        }
        this.Yhe.mT(i, j);
        j = Math.max(0, i - 1);
        i = Math.min(this.Yhe.getText().length(), i + 1);
        if (i > j + 1)
        {
          paramDragEvent = this.Yhe.mS(j, i);
          if ((Character.isSpaceChar(paramDragEvent.charAt(0))) && (Character.isSpaceChar(paramDragEvent.charAt(1)))) {
            this.Yhe.mT(j, j + 1);
          }
        }
      }
      return;
    }
    finally
    {
      this.Yhe.iao();
      AppMethodBeat.o(187983);
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(187895);
    iaU().a(paramp, false);
    AppMethodBeat.o(187895);
  }
  
  final boolean a(ExtractedTextRequest paramExtractedTextRequest, int paramInt1, int paramInt2, int paramInt3, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(187919);
    if ((paramExtractedTextRequest == null) || (paramExtractedText == null))
    {
      AppMethodBeat.o(187919);
      return false;
    }
    CharSequence localCharSequence = this.Yhe.getText();
    if (localCharSequence == null)
    {
      AppMethodBeat.o(187919);
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
          if (this.Yhe.Wmc) {
            paramExtractedText.flags |= 0x1;
          }
          paramExtractedText.startOffset = 0;
          paramExtractedText.selectionStart = this.Yhe.getSelectionStart();
          paramExtractedText.selectionEnd = this.Yhe.getSelectionEnd();
          if (Build.VERSION.SDK_INT >= 28) {
            paramExtractedText.hint = this.Yhe.getHint();
          }
          AppMethodBeat.o(187919);
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
  
  final void aI(float paramFloat1, float paramFloat2)
  {
    this.YhT = paramFloat1;
    this.YhU = paramFloat2;
  }
  
  final void at(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(187904);
    this.Yhz = SystemClock.uptimeMillis();
    ibb();
    if (paramBoolean)
    {
      int k = this.Yhe.getSelectionStart();
      int m = this.Yhe.getSelectionEnd();
      if ((this.YhD) && (k == 0) && (m == this.Yhe.getText().length()))
      {
        i = 1;
        if ((!this.Yhu) || (!this.Yhe.iau()) || (i != 0)) {
          break label306;
        }
        paramBoolean = true;
        label96:
        this.YhX = paramBoolean;
        if ((!this.Yhu) || (k < 0) || (m < 0))
        {
          if (this.Yhj == null) {
            break label311;
          }
          int j = this.Yhj.YjT;
          if (j < 0) {
            break label311;
          }
          i = j;
          if (j <= this.Yhe.getText().length()) {}
        }
      }
      label306:
      label311:
      for (int i = this.Yhe.getText().length();; i = -1)
      {
        if (i >= 0) {
          Selection.setSelection((Spannable)this.Yhe.getText(), i);
        }
        com.tencent.mm.ui.widget.cedit.b.d locald = this.Yhe.getMovementMethod();
        if (locald != null) {
          locald.a(this.Yhe, (Spannable)this.Yhe.getText(), paramInt);
        }
        if ((this.Yhv) && (k >= 0) && (m >= 0)) {
          Selection.setSelection((Spannable)this.Yhe.getText(), k, m);
        }
        if (this.YhD) {
          this.Yhe.iaG();
        }
        this.Yhw = true;
        this.Yhu = false;
        this.Yhv = false;
        ibx();
        AppMethodBeat.o(187904);
        return;
        i = 0;
        break;
        paramBoolean = false;
        break label96;
      }
    }
    iaO();
    paramBoolean = bool;
    if (Build.VERSION.SDK_INT >= 24) {
      paramBoolean = this.Yhe.isTemporarilyDetached();
    }
    if (paramBoolean) {
      ibt();
    }
    for (;;)
    {
      if (this.Yhj != null) {
        this.Yhj.ibM();
      }
      iaY();
      AppMethodBeat.o(187904);
      return;
      iaB();
    }
  }
  
  final void ax(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187907);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187907);
      return;
      axL(-1);
      AppMethodBeat.o(187907);
      return;
      iba();
    }
  }
  
  final void axL(int paramInt)
  {
    AppMethodBeat.i(187908);
    this.Yhe.removeCallbacks(this.Yif);
    fLs();
    if ((this.Yhk != null) && (Build.VERSION.SDK_INT >= 23)) {
      this.Yhk.hide(paramInt);
    }
    AppMethodBeat.o(187908);
  }
  
  final void ay(MotionEvent paramMotionEvent)
  {
    int j = 1;
    AppMethodBeat.i(187964);
    ibm();
    this.Yhe.aG(paramMotionEvent.getX(), paramMotionEvent.getY());
    CharSequence localCharSequence;
    int k;
    if ((this.YhD) && (this.Yhe.iax()))
    {
      i = 1;
      iaO();
      iaB();
      localCharSequence = this.Yhe.getText();
      if ((i != 0) || (localCharSequence.length() <= 0)) {
        break label201;
      }
      k = this.Yhe.aG(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.YhJ) {
        break label164;
      }
    }
    label164:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        Selection.setSelection((Spannable)localCharSequence, k);
      }
      if (ibq()) {
        break label201;
      }
      if (!ibr()) {
        break label169;
      }
      if (this.Yia == null) {
        break label201;
      }
      this.Yhe.removeCallbacks(this.Yia);
      AppMethodBeat.o(187964);
      return;
      i = 0;
      break;
    }
    label169:
    if (this.Yhl)
    {
      if (i != 0)
      {
        ibu().show();
        AppMethodBeat.o(187964);
        return;
      }
      ibu().hide();
    }
    label201:
    AppMethodBeat.o(187964);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(187896);
    iaU().c(paramp);
    AppMethodBeat.o(187896);
  }
  
  final InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(187912);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)this.Yhe.getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(187912);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.Yhe.getContext().getSystemService("input_method");
    AppMethodBeat.o(187912);
    return localInputMethodManager;
  }
  
  public final com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(187890);
    if (this.Yib == null) {
      this.Yib = new com.tencent.mm.ui.widget.cedit.c.b(this.Yhe.getTextServicesLocale());
    }
    com.tencent.mm.ui.widget.cedit.c.b localb = this.Yib;
    AppMethodBeat.o(187890);
    return localb;
  }
  
  protected final void iaB()
  {
    AppMethodBeat.i(187969);
    if (this.Yhk != null) {
      this.Yhk.finish();
    }
    this.Yhe.removeCallbacks(this.Yif);
    if (this.Yio) {
      ibs();
    }
    AppMethodBeat.o(187969);
  }
  
  final void iaL()
  {
    AppMethodBeat.i(187876);
    if (this.Yhs == null) {
      this.Yhs = new g();
    }
    AppMethodBeat.o(187876);
  }
  
  final boolean iaM()
  {
    AppMethodBeat.i(187878);
    if ((this.YhC) && (this.Yhe.iaw()))
    {
      AppMethodBeat.o(187878);
      return true;
    }
    AppMethodBeat.o(187878);
    return false;
  }
  
  final void iaN()
  {
    boolean bool2 = true;
    AppMethodBeat.i(187879);
    Object localObject = this.Yhe.getRootView().getLayoutParams();
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
      if ((i != 0) && (this.Yhe.getLayout() != null))
      {
        i = 1;
        label75:
        if ((i == 0) || (!iaM())) {
          break label191;
        }
        bool1 = true;
        label88:
        this.Yhl = bool1;
        if ((i == 0) || (!this.Yhe.iaz())) {
          break label196;
        }
      }
      label191:
      label196:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.Yhm = bool1;
        if (!this.Yhl)
        {
          iaO();
          if (this.Yhi != null)
          {
            this.Yhi.cfy();
            this.Yhi = null;
          }
        }
        if (!this.Yhm)
        {
          iaB();
          if (this.Yhj != null)
          {
            this.Yhj.cfy();
            this.Yhj = null;
          }
        }
        AppMethodBeat.o(187879);
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
  
  final void iaO()
  {
    AppMethodBeat.i(187881);
    if (this.Yhi != null) {
      this.Yhi.hide();
    }
    AppMethodBeat.o(187881);
  }
  
  final void iaP()
  {
    AppMethodBeat.i(187883);
    if (this.YhB != null) {
      this.YhB.cancel();
    }
    AppMethodBeat.o(187883);
  }
  
  final void iaQ()
  {
    AppMethodBeat.i(187884);
    if (this.YhB != null)
    {
      this.YhB.mCancelled = false;
      ibx();
    }
    AppMethodBeat.o(187884);
  }
  
  final void iaY()
  {
    AppMethodBeat.i(187905);
    if ((!this.Yhe.iaz()) && (this.Yhe.iau())) {
      Selection.setSelection((Spannable)this.Yhe.getText(), this.Yhe.length(), this.Yhe.length());
    }
    AppMethodBeat.o(187905);
  }
  
  final void iaZ()
  {
    AppMethodBeat.i(187906);
    ibm();
    this.Yid = true;
    iaO();
    if (this.Yhj != null) {
      this.Yhj.ibM();
    }
    iaB();
    AppMethodBeat.o(187906);
  }
  
  public final void ian()
  {
    AppMethodBeat.i(187913);
    this.YhF = true;
    h localh = this.Yht;
    if (localh != null)
    {
      int i = localh.Yhf + 1;
      localh.Yhf = i;
      if (i == 1)
      {
        localh.Yjf = false;
        localh.Yjj = 0;
        if (localh.mContentChanged)
        {
          localh.Yjh = 0;
          localh.Yji = this.Yhe.getText().length();
          AppMethodBeat.o(187913);
          return;
        }
        localh.Yjh = -1;
        localh.Yji = -1;
        localh.mContentChanged = false;
      }
    }
    AppMethodBeat.o(187913);
  }
  
  public final void iao()
  {
    AppMethodBeat.i(187914);
    this.YhF = false;
    h localh = this.Yht;
    if (localh != null)
    {
      int i = localh.Yhf - 1;
      localh.Yhf = i;
      if (i == 0) {
        a(localh);
      }
    }
    AppMethodBeat.o(187914);
  }
  
  final void ibb()
  {
    AppMethodBeat.i(187915);
    h localh = this.Yht;
    if ((localh != null) && (localh.Yhf != 0))
    {
      localh.Yhf = 0;
      a(localh);
    }
    AppMethodBeat.o(187915);
  }
  
  final boolean ibc()
  {
    AppMethodBeat.i(187921);
    h localh = this.Yht;
    if (localh == null)
    {
      AppMethodBeat.o(187921);
      return false;
    }
    boolean bool = localh.mContentChanged;
    if ((!bool) && (!localh.Yjg))
    {
      AppMethodBeat.o(187921);
      return false;
    }
    localh.mContentChanged = false;
    localh.Yjg = false;
    ExtractedTextRequest localExtractedTextRequest = localh.Yjd;
    if (localExtractedTextRequest == null)
    {
      AppMethodBeat.o(187921);
      return false;
    }
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(187921);
      return false;
    }
    if ((localh.Yjh < 0) && (!bool)) {
      localh.Yjh = -2;
    }
    if (a(localExtractedTextRequest, localh.Yjh, localh.Yji, localh.Yjj, localh.Yje))
    {
      localInputMethodManager.updateExtractedText(this.Yhe, localExtractedTextRequest.token, localh.Yje);
      localh.Yjh = -1;
      localh.Yji = -1;
      localh.Yjj = 0;
      localh.mContentChanged = false;
      AppMethodBeat.o(187921);
      return true;
    }
    AppMethodBeat.o(187921);
    return false;
  }
  
  final void ibe()
  {
    AppMethodBeat.i(187926);
    if (this.Yhj != null) {
      this.Yhj.ibQ();
    }
    if (this.Yhi != null) {
      this.Yhi.ibJ();
    }
    if (!ibk()) {
      ibl();
    }
    AppMethodBeat.o(187926);
  }
  
  final void ibf()
  {
    AppMethodBeat.i(187928);
    iby();
    if (this.YhO == null)
    {
      AppMethodBeat.o(187928);
      return;
    }
    Layout localLayout = this.Yhe.getLayout();
    int i = this.Yhe.getSelectionStart();
    int j = localLayout.getLineForOffset(i);
    h(localLayout.getLineTop(j), localLayout.getLineBottom(j), localLayout.getPrimaryHorizontal(i));
    AppMethodBeat.o(187928);
  }
  
  final void ibg()
  {
    AppMethodBeat.i(187930);
    if (ibq())
    {
      this.YhI = false;
      AppMethodBeat.o(187930);
      return;
    }
    boolean bool = this.Yhe.iau();
    n localn = ibv();
    j localj = ibu();
    if (((localn != null) && (localn.ibz())) || ((localj != null) && (localj.ibz())))
    {
      this.YhI = false;
      AppMethodBeat.o(187930);
      return;
    }
    if (bool)
    {
      iaO();
      if (ibk()) {
        if (this.YhI) {
          ibm().ibT();
        }
      }
    }
    for (;;)
    {
      this.YhI = false;
      AppMethodBeat.o(187930);
      return;
      if ((localn == null) || (!localn.isActive()))
      {
        ibt();
        ibm().ibT();
      }
      else
      {
        if ((Build.VERSION.SDK_INT >= 23) && (this.Yhk != null)) {
          this.Yhk.invalidateContentRect();
        }
        iba();
        continue;
        if ((localj == null) || (!localj.isActive())) {
          iaB();
        } else if ((this.Yhk != null) && (Build.VERSION.SDK_INT >= 23)) {
          this.Yhk.invalidateContentRect();
        }
      }
    }
  }
  
  final void ibh()
  {
    AppMethodBeat.i(187931);
    if (this.Yia != null) {
      this.Yhe.removeCallbacks(this.Yia);
    }
    if (ibq())
    {
      AppMethodBeat.o(187931);
      return;
    }
    iaB();
    if (Build.VERSION.SDK_INT >= 23) {
      new o(1);
    }
    ibi();
    if ((!ibk()) && (ibu() != null)) {
      ibu().show();
    }
    AppMethodBeat.o(187931);
  }
  
  public final boolean ibk()
  {
    return (this.Yhk == null) && (!this.Yio);
  }
  
  final d ibm()
  {
    AppMethodBeat.i(187948);
    if (this.YhK == null) {
      this.YhK = new d(this);
    }
    d locald = this.YhK;
    AppMethodBeat.o(187948);
    return locald;
  }
  
  final boolean ibp()
  {
    AppMethodBeat.i(187958);
    if (ibq())
    {
      AppMethodBeat.o(187958);
      return false;
    }
    if (this.Yhk != null)
    {
      ibl();
      AppMethodBeat.o(187958);
      return false;
    }
    if ((!ibo()) || (!this.Yhe.iau()))
    {
      AppMethodBeat.o(187958);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      new o(0);
    }
    ibi();
    if (!this.Yhe.iaw()) {
      this.Yhe.ial();
    }
    if (!ibk()) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.Yhe.iaw()) && (!this.Yhe.ial()) && (this.YhG))
      {
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.showSoftInput(this.Yhe, 0, null);
        }
      }
      AppMethodBeat.o(187958);
      return true;
    }
  }
  
  final boolean ibq()
  {
    AppMethodBeat.i(187960);
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if ((localInputMethodManager != null) && (localInputMethodManager.isFullscreenMode()))
    {
      AppMethodBeat.o(187960);
      return true;
    }
    AppMethodBeat.o(187960);
    return false;
  }
  
  final void ibt()
  {
    AppMethodBeat.i(187972);
    if (!ibk()) {
      this.YhI = true;
    }
    this.YhH = true;
    iaB();
    this.YhH = false;
    AppMethodBeat.o(187972);
  }
  
  public final j ibu()
  {
    AppMethodBeat.i(187973);
    if (!this.Yhl)
    {
      AppMethodBeat.o(187973);
      return null;
    }
    if (this.Yhi == null)
    {
      this.Yhi = new j();
      this.Yhe.getViewTreeObserver().addOnTouchModeChangeListener(this.Yhi);
    }
    j localj = this.Yhi;
    AppMethodBeat.o(187973);
    return localj;
  }
  
  public final n ibv()
  {
    AppMethodBeat.i(187975);
    if (!this.Yhm)
    {
      AppMethodBeat.o(187975);
      return null;
    }
    if (this.Yhj == null)
    {
      this.Yhj = new n();
      this.Yhe.getViewTreeObserver().addOnTouchModeChangeListener(this.Yhj);
    }
    n localn = this.Yhj;
    AppMethodBeat.o(187975);
    return localn;
  }
  
  final void ibx()
  {
    AppMethodBeat.i(187982);
    if (ibw())
    {
      this.Yhz = SystemClock.uptimeMillis();
      if (this.YhB == null) {
        this.YhB = new a((byte)0);
      }
      this.Yhe.removeCallbacks(this.YhB);
      this.Yhe.postDelayed(this.YhB, 500L);
      AppMethodBeat.o(187982);
      return;
    }
    if (this.YhB != null) {
      this.Yhe.removeCallbacks(this.YhB);
    }
    AppMethodBeat.o(187982);
  }
  
  final void iby()
  {
    AppMethodBeat.i(187988);
    if (this.YhO == null) {
      this.YhO = this.Yhe.getTextCursorDrawable();
    }
    AppMethodBeat.o(187988);
  }
  
  final class a
    implements Runnable
  {
    boolean mCancelled;
    
    private a() {}
    
    final void cancel()
    {
      AppMethodBeat.i(204777);
      if (!this.mCancelled)
      {
        b.c(b.this).removeCallbacks(this);
        this.mCancelled = true;
      }
      AppMethodBeat.o(204777);
    }
    
    public final void run()
    {
      AppMethodBeat.i(204776);
      if (this.mCancelled)
      {
        AppMethodBeat.o(204776);
        return;
      }
      b.c(b.this).removeCallbacks(this);
      if (b.g(b.this))
      {
        if (b.c(b.this).getLayout() != null) {
          b.c(b.this).iai();
        }
        b.c(b.this).postDelayed(this, 500L);
      }
      AppMethodBeat.o(204776);
    }
  }
  
  final class b
  {
    long Yiq;
    private RectF ajW;
    final Path auD;
    final Paint mPaint;
    int tH;
    int tI;
    
    public b()
    {
      AppMethodBeat.i(189049);
      this.auD = new Path();
      this.mPaint = new Paint(1);
      this.mPaint.setStyle(Paint.Style.FILL);
      AppMethodBeat.o(189049);
    }
    
    final void Hw(boolean paramBoolean)
    {
      AppMethodBeat.i(189050);
      if (b.c(b.this).getLayout() == null)
      {
        AppMethodBeat.o(189050);
        return;
      }
      if (this.ajW == null) {
        this.ajW = new RectF();
      }
      this.auD.computeBounds(this.ajW, false);
      int i = b.c(b.this).getCompoundPaddingLeft();
      int j = b.c(b.this).getExtendedPaddingTop() + b.c(b.this).Hs(true);
      if (paramBoolean)
      {
        b.c(b.this).postInvalidateOnAnimation((int)this.ajW.left + i, (int)this.ajW.top + j, i + (int)this.ajW.right, j + (int)this.ajW.bottom);
        AppMethodBeat.o(189050);
        return;
      }
      b.c(b.this).postInvalidate((int)this.ajW.left, (int)this.ajW.top, (int)this.ajW.right, (int)this.ajW.bottom);
      AppMethodBeat.o(189050);
    }
    
    final void stopAnimation()
    {
      AppMethodBeat.i(189052);
      b.E(b.this);
      AppMethodBeat.o(189052);
    }
  }
  
  final class c
    implements b.p
  {
    final CursorAnchorInfo.Builder Yir;
    final int[] Yis;
    final Matrix Yit;
    
    private c()
    {
      AppMethodBeat.i(196630);
      this.Yir = new CursorAnchorInfo.Builder();
      this.Yis = new int[2];
      this.Yit = new Matrix();
      AppMethodBeat.o(196630);
    }
    
    public final void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(196632);
      Object localObject = b.this.Yht;
      if ((localObject == null) || (((b.h)localObject).Yhf > 0))
      {
        AppMethodBeat.o(196632);
        return;
      }
      localObject = b.l(b.this);
      if (localObject == null)
      {
        AppMethodBeat.o(196632);
        return;
      }
      if (!((InputMethodManager)localObject).isActive(b.c(b.this)))
      {
        AppMethodBeat.o(196632);
        return;
      }
      AppMethodBeat.o(196632);
    }
  }
  
  static abstract interface d
    extends ViewTreeObserver.OnTouchModeChangeListener
  {
    public abstract boolean ibz();
    
    public abstract boolean isActive();
    
    public abstract void show();
  }
  
  static final class e
  {
    public CustomTextView Yiu;
    public int end;
    public int start;
    
    public e(CustomTextView paramCustomTextView, int paramInt1, int paramInt2)
    {
      this.Yiu = paramCustomTextView;
      this.start = paramInt1;
      this.end = paramInt2;
    }
  }
  
  public abstract class f
    extends View
    implements b.p
  {
    private int DIY;
    protected int FPB = -1;
    private int YiA;
    private int YiB;
    private float YiC;
    private float YiD;
    protected int YiE;
    protected int YiF;
    private float YiG;
    private final float YiH;
    private int YiI;
    private int YiJ;
    private int YiK;
    private int YiL;
    private boolean YiM = true;
    protected int YiN = -1;
    protected int YiO = -1;
    private float YiP = -1.0F;
    private float YiQ;
    private float YiR;
    private final int YiS;
    private final long[] YiT = new long[5];
    private final int[] YiU = new int[5];
    private int YiV = 0;
    private int YiW = 0;
    protected Drawable Yiv;
    protected Drawable Yiw;
    private final PopupWindow Yix;
    private int Yiy;
    private int Yiz;
    private int lgJ = aw.fromDPToPix(getContext(), 18);
    protected Drawable mDrawable;
    boolean rmR;
    
    private f(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt)
    {
      super();
      setId(paramInt);
      this.Yix = new PopupWindow(b.c(b.this).getContext(), null, a.l.OperateItemAnim);
      this.Yix.setSplitTouchEnabled(true);
      this.Yix.setClippingEnabled(false);
      g.a(this.Yix, 1002);
      this.Yix.setWidth(-2);
      this.Yix.setHeight(-2);
      this.Yix.setContentView(this);
      b(paramDrawable1, paramDrawable2);
      this.DIY = b.c(b.this).getContext().getResources().getDimensionPixelSize(a.e.text_handle_min_size);
      paramInt = getPreferredHeight();
      this.YiG = (-0.3F * paramInt);
      this.YiH = (paramInt * 0.7F);
      this.YiS = ((int)(this.YiH - this.YiG));
    }
    
    private boolean a(f paramf, Rect paramRect)
    {
      paramf = paramf.Yix;
      int i = this.YiA;
      int j = this.YiB;
      int k = this.YiA;
      int m = paramf.getContentView().getWidth();
      int n = this.YiB;
      return Rect.intersects(new Rect(i, j, k + m, paramf.getContentView().getHeight() + n), paramRect);
    }
    
    private void axM(int paramInt)
    {
      this.YiV = ((this.YiV + 1) % 5);
      this.YiU[this.YiV] = paramInt;
      this.YiT[this.YiV] = SystemClock.uptimeMillis();
      this.YiW += 1;
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
      switch (this.YiF)
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
      b.n localn = b.this.ibv();
      if ((localn == null) || (!localn.isActive())) {
        return null;
      }
      if (b.n.a(localn) != this) {
        return b.n.a(localn);
      }
      return b.n.c(localn);
    }
    
    private boolean ibB()
    {
      if (this.rmR) {
        return true;
      }
      if (b.c(b.this).iaH()) {
        return false;
      }
      return b.c(b.this).aF(this.Yiy + this.YiE + getHorizontalOffset(), this.Yiz);
    }
    
    private boolean ibC()
    {
      if (b.a(b.this).Yjx) {
        return true;
      }
      if ((b.c(b.this).getRotation() != 0.0F) || (b.c(b.this).getRotationX() != 0.0F) || (b.c(b.this).getRotationY() != 0.0F)) {
        return false;
      }
      this.YiQ = b.c(b.this).getScaleX();
      this.YiR = b.c(b.this).getScaleY();
      for (ViewParent localViewParent = b.c(b.this).getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
        if ((localViewParent instanceof View))
        {
          View localView = (View)localViewParent;
          if ((localView.getRotation() != 0.0F) || (localView.getRotationX() != 0.0F) || (localView.getRotationY() != 0.0F)) {
            return false;
          }
          this.YiQ *= localView.getScaleX();
          float f = this.YiR;
          this.YiR = (localView.getScaleY() * f);
        }
      }
      return true;
    }
    
    private void setVisible(boolean paramBoolean)
    {
      View localView = this.Yix.getContentView();
      if (paramBoolean) {}
      for (int i = 0;; i = 4)
      {
        localView.setVisibility(i);
        return;
      }
    }
    
    protected void Hx(boolean paramBoolean)
    {
      if ((!paramBoolean) && (this.rmR)) {}
      Layout localLayout;
      do
      {
        return;
        localLayout = b.c(b.this).getLayout();
      } while (localLayout == null);
      int i = getCurrentCursorOffset();
      paramBoolean = b(localLayout, i);
      Drawable localDrawable2 = this.mDrawable;
      if (paramBoolean) {}
      for (Drawable localDrawable1 = this.Yiw;; localDrawable1 = this.Yiv)
      {
        this.mDrawable = localDrawable1;
        this.YiE = c(this.mDrawable, paramBoolean);
        this.YiF = Hy(paramBoolean);
        if ((localDrawable2 == this.mDrawable) || (!isShowing())) {
          break;
        }
        this.Yiy = (d(localLayout, i) - this.YiE - getHorizontalOffset() + getCursorOffset());
        this.Yiy += b.c(b.this).ias();
        this.YiM = true;
        h(this.YiI, this.YiJ, false, false);
        postInvalidate();
        return;
      }
    }
    
    protected abstract int Hy(boolean paramBoolean);
    
    protected abstract void JU(int paramInt);
    
    protected final void az(MotionEvent paramMotionEvent)
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
          if (!ibC()) {
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
            b.c(b.this).iai();
            b.r(b.this);
            paramMotionEvent = b.a(b.this);
            f1 = ((PointF)localObject1).x;
            f2 = ((PointF)localObject1).y;
            if ((!paramMotionEvent.Yjx) || (f2 == paramMotionEvent.uLU)) {
              break label1184;
            }
            i = 1;
            if (i == 0) {
              break label1209;
            }
            if (!paramMotionEvent.eYu.isRunning()) {
              break label1190;
            }
            paramMotionEvent.eYu.cancel();
            paramMotionEvent.Yjy = paramMotionEvent.YjA;
            paramMotionEvent.Yjz = paramMotionEvent.YjB;
            paramMotionEvent.eYu.start();
            paramMotionEvent.uLT = f1;
            paramMotionEvent.uLU = f2;
            paramMotionEvent.Yjx = true;
            paramMotionEvent = null;
            if (Build.VERSION.SDK_INT < 29) {
              break label1239;
            }
            paramMotionEvent = b.a(b.this).Yjw.getPosition();
          }
        } while ((paramMotionEvent == null) || (Build.VERSION.SDK_INT < 28));
        paramMotionEvent = new Rect(paramMotionEvent.x, paramMotionEvent.y, paramMotionEvent.x + b.a(b.this).Yjw.getWidth(), paramMotionEvent.y + b.a(b.this).Yjw.getHeight());
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
          f1 = Math.round(b.a(b.this).Yjw.getHeight() / b.a(b.this).Yjw.getZoom());
        }
        localObject2 = b.c(b.this).getPaint().getFontMetrics();
        if ((((Paint.FontMetrics)localObject2).descent - ((Paint.FontMetrics)localObject2).ascent) * this.YiR > f1)
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
          this.YiP = paramMotionEvent.getRawX();
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
          f4 = this.YiQ * f1;
          f2 = this.YiQ * f2;
          f1 = 0.0F;
          if (Build.VERSION.SDK_INT >= 28) {
            f1 = Math.round(b.a(b.this).Yjw.getWidth() / b.a(b.this).Yjw.getZoom());
          }
          if ((f3 >= f4 - f1 / 2.0F) && (f3 <= f1 / 2.0F + f2)) {
            break label1048;
          }
          i = 0;
          break;
          if (paramMotionEvent.getActionMasked() != 1) {
            break label603;
          }
          this.YiP = -1.0F;
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
        if (this.YiQ == 1.0F) {}
        for (f1 = f3;; f1 = (paramMotionEvent.getRawX() - this.YiP) * this.YiQ + this.YiP - localObject2[0])
        {
          ((PointF)localObject1).x = Math.max(f4, Math.min(f2, f1));
          ((PointF)localObject1).y = (((b.c(b.this).getLayout().getLineTop(i1) + b.a(b.c(b.this).getLayout(), i1)) / 2.0F + b.c(b.this).getTotalPaddingTop() - b.c(b.this).getScrollY()) * this.YiR);
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
        paramMotionEvent.Yjy = paramMotionEvent.uLT;
        paramMotionEvent.Yjz = paramMotionEvent.uLU;
        break label259;
        label1209:
        if ((paramMotionEvent.eYu.isRunning()) || (Build.VERSION.SDK_INT < 28)) {
          break label266;
        }
        paramMotionEvent.Yjw.show(f1, f2);
        break label266;
        label1239:
        if (Build.VERSION.SDK_INT != 28) {
          break label305;
        }
        paramMotionEvent = (Point)new com.tencent.mm.ui.widget.cedit.util.a(b.a(b.this).Yjw, "getWindowCoords", new Class[0]).invoke(new Object[0]);
        break label305;
        label1285:
        bool = false;
        break label381;
      }
      label1297:
      ibD();
    }
    
    protected int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      return b.c(b.this).B(paramInt, paramFloat);
    }
    
    final void b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.Yiv = paramDrawable1;
      this.Yiw = paramDrawable2;
      Hx(true);
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
    
    public void cfy() {}
    
    int d(Layout paramLayout, int paramInt)
    {
      return (int)(c(paramLayout, paramInt) - 0.5F);
    }
    
    protected void dismiss()
    {
      this.rmR = false;
      this.Yix.dismiss();
      cfy();
    }
    
    protected abstract void g(float paramFloat1, float paramFloat2, boolean paramBoolean);
    
    public abstract int getCurrentCursorOffset();
    
    protected int getCursorOffset()
    {
      return 0;
    }
    
    final int getIdealFingerToCursorOffset()
    {
      return this.YiS;
    }
    
    public float getIdealVerticalOffset()
    {
      return this.YiH;
    }
    
    protected abstract int getMagnifierHandleTrigger();
    
    protected final int getPreferredHeight()
    {
      return Math.max(getDrawWidth(), this.DIY);
    }
    
    protected final int getPreferredWidth()
    {
      return Math.max(getDrawWidth(), this.DIY);
    }
    
    public final void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      p(getCurrentCursorOffset(), paramBoolean2, false);
      if ((paramBoolean1) || (this.YiM))
      {
        if (this.rmR)
        {
          if ((paramInt1 != this.YiI) || (paramInt2 != this.YiJ))
          {
            this.YiC += paramInt1 - this.YiI;
            this.YiD += paramInt2 - this.YiJ;
            this.YiI = paramInt1;
            this.YiJ = paramInt2;
          }
          ibE();
        }
        if (!ibB()) {
          break label166;
        }
        paramInt1 = this.Yiy + paramInt1;
        paramInt2 = this.Yiz + paramInt2;
        this.YiA = paramInt1;
        this.YiB = paramInt2;
        if (!isShowing()) {
          break label146;
        }
        this.Yix.update(paramInt1, paramInt2, -1, -1);
      }
      for (;;)
      {
        this.YiM = false;
        return;
        label146:
        this.Yix.showAtLocation(b.c(b.this), 0, paramInt1, paramInt2);
        continue;
        label166:
        if (isShowing()) {
          dismiss();
        }
      }
    }
    
    public final void hide()
    {
      dismiss();
      b.m(b.this).c(this);
    }
    
    public final boolean ibA()
    {
      return this.YiW > 1;
    }
    
    protected final void ibD()
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
    
    void ibE() {}
    
    public void invalidate()
    {
      super.invalidate();
      if (isShowing()) {
        p(getCurrentCursorOffset(), true, false);
      }
    }
    
    public boolean isShowing()
    {
      return this.Yix.isShowing();
    }
    
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
        this.YiW = 0;
        axM(i);
        b.l locall = b.m(b.this);
        this.YiI = locall.Yiy;
        this.YiJ = locall.Yiz;
        this.YiK = locall.YjF;
        this.YiL = locall.YjG;
        f1 = paramMotionEvent.getRawX();
        f2 = this.YiK;
        f3 = this.YiI;
        f4 = paramMotionEvent.getRawY();
        f5 = this.YiL;
        f6 = this.YiJ;
        this.YiC = (f1 - f2 + f3 - this.Yiy);
        this.YiD = (f4 - f5 + f6 - this.Yiz);
        this.rmR = true;
        this.YiO = -1;
        return true;
      case 2: 
        f2 = paramMotionEvent.getRawX();
        f3 = this.YiK;
        f4 = this.YiI;
        f1 = paramMotionEvent.getRawY();
        f5 = this.YiL;
        f5 = this.YiJ + (f1 - f5);
        f1 = this.YiD - this.YiJ;
        f6 = f5 - this.Yiz - this.YiJ;
        if (f1 < this.YiH) {}
        for (f1 = Math.max(Math.min(f6, this.YiH), f1);; f1 = Math.min(Math.max(f6, this.YiH), f1))
        {
          this.YiD = (f1 + this.YiJ);
          g(f4 + (f2 - f3) - this.YiC + this.YiE + getHorizontalOffset(), f5 - this.YiD + this.YiG, paramMotionEvent.isFromSource(4098));
          return true;
        }
      case 1: 
        boolean bool = paramMotionEvent.isFromSource(4098);
        long l = SystemClock.uptimeMillis();
        i = this.YiV;
        int k = Math.min(this.YiW, 5);
        int j = 0;
        while ((j < k) && (l - this.YiT[i] < 150L))
        {
          j += 1;
          i = (this.YiV - j + 5) % 5;
        }
        if ((j > 0) && (j < k) && (l - this.YiT[i] > 350L)) {
          p(this.YiU[i], false, bool);
        }
        break;
      }
      this.rmR = false;
      Hx(false);
      return true;
    }
    
    protected void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (b.c(b.this).getLayout() == null) {
        b.this.iaN();
      }
      for (;;)
      {
        return;
        Layout localLayout = b.c(b.this).getLayout();
        if (paramInt != this.FPB) {}
        for (int i = 1; (i != 0) || (paramBoolean1); i = 0)
        {
          if (i != 0)
          {
            JU(paramInt);
            if ((paramBoolean2) && (b.n(b.this))) {
              b.c(b.this).performHapticFeedback(9);
            }
            axM(paramInt);
          }
          i = localLayout.getLineForOffset(paramInt);
          this.YiN = i;
          this.Yiy = (d(localLayout, paramInt) - this.YiE - getHorizontalOffset() + getCursorOffset());
          this.Yiz = b.a(localLayout, i);
          this.Yiy += b.c(b.this).ias();
          this.Yiz += b.c(b.this).iat();
          this.FPB = paramInt;
          this.YiM = true;
          return;
        }
      }
    }
    
    public void setTargetWidth(int paramInt)
    {
      this.lgJ = paramInt;
    }
    
    public void show()
    {
      if (isShowing()) {
        return;
      }
      b.m(b.this).a(this, true);
      this.FPB = -1;
      p(getCurrentCursorOffset(), false, false);
    }
  }
  
  static final class g
  {
    String YiX;
    CharSequence YiY;
    int YiZ;
    CustomTextView.c Yja;
    boolean Yjb;
    LocaleList Yjc;
    Bundle extras;
    int nlD = 0;
  }
  
  static final class h
  {
    int Yhf;
    ExtractedTextRequest Yjd;
    final ExtractedText Yje;
    boolean Yjf;
    boolean Yjg;
    int Yjh;
    int Yji;
    int Yjj;
    boolean mContentChanged;
    
    h()
    {
      AppMethodBeat.i(197276);
      this.Yje = new ExtractedText();
      AppMethodBeat.o(197276);
    }
  }
  
  final class i
    extends b.f
  {
    private boolean WEG;
    private float Yjk;
    private float Yjl;
    private Runnable Yjm;
    private boolean Yjn;
    private final int Yjo;
    private final int Yjp;
    
    i(Drawable paramDrawable)
    {
      super(paramDrawable, paramDrawable, a.g.insertion_handle, (byte)0);
      AppMethodBeat.i(194399);
      this.WEG = false;
      this.Yjn = false;
      this.Yjp = 0;
      this.Yjo = 255;
      AppMethodBeat.o(194399);
    }
    
    private void ibF()
    {
      AppMethodBeat.i(194400);
      if (this.Yjm == null) {
        this.Yjm = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(209974);
            b.i.this.hide();
            AppMethodBeat.o(209974);
          }
        };
      }
      for (;;)
      {
        b.c(b.this).postDelayed(this.Yjm, 4000L);
        AppMethodBeat.o(194400);
        return;
        ibG();
      }
    }
    
    private void ibG()
    {
      AppMethodBeat.i(194401);
      if (this.Yjm != null) {
        b.c(b.this).removeCallbacks(this.Yjm);
      }
      AppMethodBeat.o(194401);
    }
    
    protected final void Hx(boolean paramBoolean)
    {
      AppMethodBeat.i(194414);
      super.Hx(paramBoolean);
      this.mDrawable.setAlpha(this.Yjo);
      AppMethodBeat.o(194414);
    }
    
    protected final int Hy(boolean paramBoolean)
    {
      return 1;
    }
    
    public final void JU(int paramInt)
    {
      AppMethodBeat.i(194417);
      Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt);
      AppMethodBeat.o(194417);
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(194402);
      int i = paramDrawable.getIntrinsicWidth() / 2;
      AppMethodBeat.o(194402);
      return i;
    }
    
    public final void cfy()
    {
      AppMethodBeat.i(194423);
      super.cfy();
      ibG();
      AppMethodBeat.o(194423);
    }
    
    final int d(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(194405);
      if (b.this.YhO != null)
      {
        float f = c(paramLayout, paramInt);
        paramInt = b.a(b.this, b.this.YhO, f);
        int i = b.t(b.this).left;
        AppMethodBeat.o(194405);
        return paramInt + i;
      }
      paramInt = super.d(paramLayout, paramInt);
      AppMethodBeat.o(194405);
      return paramInt;
    }
    
    public final void dismiss()
    {
      AppMethodBeat.i(194413);
      if (this.WEG)
      {
        this.Yjn = true;
        this.mDrawable.setAlpha(0);
        AppMethodBeat.o(194413);
        return;
      }
      super.dismiss();
      this.Yjn = false;
      AppMethodBeat.o(194413);
    }
    
    protected final void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      int i = -1;
      AppMethodBeat.i(194419);
      Layout localLayout = b.c(b.this).getLayout();
      if (localLayout != null)
      {
        if (this.YiO == -1) {
          this.YiO = b.c(b.this).cT(paramFloat2);
        }
        int j = b.this.a(localLayout, this.YiO, paramFloat2);
        i = b(localLayout, j, paramFloat1);
        this.YiO = j;
      }
      p(i, false, paramBoolean);
      if (b.f(b.this) != null) {
        b.v(b.this);
      }
      AppMethodBeat.o(194419);
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(194415);
      int i = b.c(b.this).getSelectionStart();
      AppMethodBeat.o(194415);
      return i;
    }
    
    protected final int getCursorOffset()
    {
      AppMethodBeat.i(194403);
      int j = super.getCursorOffset();
      int i = j;
      if (b.this.YhO != null)
      {
        b.this.YhO.getPadding(b.t(b.this));
        i = j + (b.this.YhO.getIntrinsicWidth() - b.t(b.this).left - b.t(b.this).right) / 2;
      }
      AppMethodBeat.o(194403);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      return 0;
    }
    
    final void ibE()
    {
      AppMethodBeat.i(194420);
      super.ibE();
      ibG();
      AppMethodBeat.o(194420);
    }
    
    public final boolean isShowing()
    {
      AppMethodBeat.i(194411);
      if (this.Yjn)
      {
        AppMethodBeat.o(194411);
        return false;
      }
      boolean bool = super.isShowing();
      AppMethodBeat.o(194411);
      return bool;
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(194406);
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(194406);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(194409);
      if (!b.c(b.this).b(paramMotionEvent, true))
      {
        AppMethodBeat.o(194409);
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
          AppMethodBeat.o(194409);
          return bool;
          this.Yjk = paramMotionEvent.getRawX();
          this.Yjl = paramMotionEvent.getRawY();
          az(paramMotionEvent);
          continue;
          az(paramMotionEvent);
        }
      case 1: 
        if (!ibA())
        {
          ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.c(b.this).getContext());
          if (c.a(this.Yjk, this.Yjl, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), localViewConfiguration.getScaledTouchSlop())) {
            b.u(b.this);
          }
        }
        break;
      }
      for (;;)
      {
        ibF();
        ibD();
        break;
        if ((b.f(b.this) != null) && (Build.VERSION.SDK_INT >= 23)) {
          b.f(b.this).invalidateContentRect();
        }
      }
    }
    
    public final void show()
    {
      AppMethodBeat.i(194412);
      super.show();
      this.Yjn = false;
      this.mDrawable.setAlpha(this.Yjo);
      AppMethodBeat.o(194412);
    }
  }
  
  public final class j
    implements b.d
  {
    private b.i Yjr;
    boolean Yjs;
    private boolean Yjt;
    private int Yju;
    
    public j() {}
    
    final void aA(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(193581);
      Layout localLayout = b.c(b.this).getLayout();
      int i;
      if (this.Yju == -1) {
        i = b.this.a(localLayout, this.Yju, paramMotionEvent.getY());
      }
      for (;;)
      {
        this.Yju = i;
        i = b.c(b.this).B(this.Yju, paramMotionEvent.getX());
        int j = b.c(b.this).getSelectionStart();
        int k = b.c(b.this).getSelectionEnd();
        if ((i != j) || (i != k))
        {
          Selection.setSelection((Spannable)b.c(b.this).getText(), i);
          b.this.ibf();
          if (b.n(b.this)) {
            b.c(b.this).performHapticFeedback(9);
          }
        }
        ibI().az(paramMotionEvent);
        AppMethodBeat.o(193581);
        return;
        int[] arrayOfInt = new int[2];
        b.c(b.this).getLocationOnScreen(arrayOfInt);
        if (b.x(b.this).Ykk) {}
        for (float f1 = paramMotionEvent.getRawY() - arrayOfInt[1];; f1 = paramMotionEvent.getY())
        {
          float f2 = ibI().getIdealFingerToCursorOffset();
          i = b.this.a(localLayout, this.Yju, f1 - f2);
          if (!this.Yjt) {
            break label256;
          }
          break;
        }
        label256:
        if (i < this.Yju) {
          i = Math.min(this.Yju, b.this.a(localLayout, this.Yju, f1));
        } else {
          this.Yjt = true;
        }
      }
    }
    
    public final void cfy()
    {
      AppMethodBeat.i(193591);
      b.c(b.this).getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.Yjr != null) {
        this.Yjr.cfy();
      }
      AppMethodBeat.o(193591);
    }
    
    public final void hide()
    {
      AppMethodBeat.i(193588);
      if (this.Yjr != null) {
        this.Yjr.hide();
      }
      AppMethodBeat.o(193588);
    }
    
    final void ibH()
    {
      AppMethodBeat.i(193585);
      this.Yjs = false;
      this.Yjt = false;
      this.Yju = -1;
      ibI().ibD();
      b.i.a(ibI());
      b.c(b.this).getParent().requestDisallowInterceptTouchEvent(false);
      AppMethodBeat.o(193585);
    }
    
    public final b.i ibI()
    {
      AppMethodBeat.i(193590);
      if (this.Yjr == null)
      {
        b.this.Hv(false);
        this.Yjr = new b.i(b.this, b.this.YhR);
      }
      b.i locali = this.Yjr;
      AppMethodBeat.o(193590);
      return locali;
    }
    
    public final void ibJ()
    {
      AppMethodBeat.i(193597);
      if (this.Yjr != null) {
        this.Yjr.invalidate();
      }
      AppMethodBeat.o(193597);
    }
    
    public final boolean ibz()
    {
      return (this.Yjs) || ((this.Yjr != null) && (this.Yjr.rmR));
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(193596);
      if ((this.Yjr != null) && (this.Yjr.isShowing()))
      {
        AppMethodBeat.o(193596);
        return true;
      }
      AppMethodBeat.o(193596);
      return false;
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(193589);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(193589);
    }
    
    public final void show()
    {
      AppMethodBeat.i(193586);
      ibI().show();
      long l1 = SystemClock.uptimeMillis();
      long l2 = CustomTextView.Yfc;
      if ((b.y(b.this) != null) && ((this.Yjs) || (b.x(b.this).ibS()) || (b.z(b.this)))) {
        b.c(b.this).removeCallbacks(b.y(b.this));
      }
      if ((!this.Yjs) && (!b.x(b.this).ibS()) && (!b.z(b.this)) && (l1 - l2 < 15000L) && (b.this.ibk()))
      {
        if (b.y(b.this) == null) {
          b.a(b.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188428);
              b.this.ibh();
              AppMethodBeat.o(188428);
            }
          });
        }
        b.c(b.this).postDelayed(b.y(b.this), ViewConfiguration.getDoubleTapTimeout() + 1);
      }
      if (!this.Yjs) {
        b.i.a(ibI());
      }
      if (b.this.Yhj != null) {
        b.this.Yhj.hide();
      }
      AppMethodBeat.o(193586);
    }
  }
  
  static final class k
  {
    float YjA;
    float YjB;
    final Magnifier Yjw;
    boolean Yjx;
    float Yjy;
    float Yjz;
    final ValueAnimator eYu;
    float uLT;
    float uLU;
    
    private k(Magnifier paramMagnifier)
    {
      AppMethodBeat.i(214393);
      this.Yjw = paramMagnifier;
      this.eYu = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.eYu.setDuration(100L);
      this.eYu.setInterpolator(new LinearInterpolator());
      this.eYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(202793);
          b.k.this.YjA = (b.k.this.Yjy + (b.k.this.uLT - b.k.this.Yjy) * paramAnonymousValueAnimator.getAnimatedFraction());
          b.k.this.YjB = (b.k.this.Yjz + (b.k.this.uLU - b.k.this.Yjz) * paramAnonymousValueAnimator.getAnimatedFraction());
          if (Build.VERSION.SDK_INT >= 28) {
            b.k.this.Yjw.show(b.k.this.YjA, b.k.this.YjB);
          }
          AppMethodBeat.o(202793);
        }
      });
      AppMethodBeat.o(214393);
    }
    
    final void dismiss()
    {
      AppMethodBeat.i(214394);
      if (Build.VERSION.SDK_INT >= 28) {
        this.Yjw.dismiss();
      }
      this.eYu.cancel();
      this.Yjx = false;
      AppMethodBeat.o(214394);
    }
  }
  
  final class l
    implements ViewTreeObserver.OnPreDrawListener
  {
    private boolean YiM;
    int Yiy;
    int Yiz;
    private b.p[] YjD;
    private boolean[] YjE;
    int YjF;
    int YjG;
    private int YjH;
    boolean YjI;
    final int[] YjJ;
    
    private l()
    {
      AppMethodBeat.i(193270);
      this.YjD = new b.p[7];
      this.YjE = new boolean[7];
      this.YiM = true;
      this.YjJ = new int[2];
      AppMethodBeat.o(193270);
    }
    
    private void updatePosition()
    {
      AppMethodBeat.i(193304);
      b.c(b.this).getLocationInWindow(this.YjJ);
      if ((this.YjJ[0] != this.Yiy) || (this.YjJ[1] != this.Yiz)) {}
      for (boolean bool = true;; bool = false)
      {
        this.YiM = bool;
        this.Yiy = this.YjJ[0];
        this.Yiz = this.YjJ[1];
        b.c(b.this).getLocationOnScreen(this.YjJ);
        this.YjF = this.YjJ[0];
        this.YjG = this.YjJ[1];
        AppMethodBeat.o(193304);
        return;
      }
    }
    
    public final void a(b.p paramp, boolean paramBoolean)
    {
      AppMethodBeat.i(193283);
      if (this.YjH == 0)
      {
        updatePosition();
        b.c(b.this).getViewTreeObserver().addOnPreDrawListener(this);
      }
      int j = -1;
      int i = 0;
      while (i < 7)
      {
        b.p localp = this.YjD[i];
        if (localp == paramp)
        {
          AppMethodBeat.o(193283);
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
      this.YjD[j] = paramp;
      this.YjE[j] = paramBoolean;
      this.YjH += 1;
      AppMethodBeat.o(193283);
    }
    
    public final void c(b.p paramp)
    {
      AppMethodBeat.i(193290);
      int i = 0;
      for (;;)
      {
        if (i < 7)
        {
          if (this.YjD[i] == paramp)
          {
            this.YjD[i] = null;
            this.YjH -= 1;
          }
        }
        else
        {
          if (this.YjH == 0) {
            b.c(b.this).getViewTreeObserver().removeOnPreDrawListener(this);
          }
          AppMethodBeat.o(193290);
          return;
        }
        i += 1;
      }
    }
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(193296);
      updatePosition();
      int i = 0;
      while (i < 7)
      {
        if ((this.YiM) || (this.YjI) || (this.YjE[i] != 0))
        {
          b.p localp = this.YjD[i];
          if (localp != null) {
            localp.h(this.Yiy, this.Yiz, this.YiM, this.YjI);
          }
        }
        i += 1;
      }
      this.YjI = false;
      AppMethodBeat.o(193296);
      return true;
    }
  }
  
  public final class m
    extends b.f
  {
    private final int YjK;
    private boolean YjL;
    private float YjM;
    private float YjN;
    private boolean YjO;
    private final float YjP;
    private final int[] YjQ;
    
    public m(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
    {
      super(paramDrawable1, paramDrawable2, paramInt1, (byte)0);
      AppMethodBeat.i(200445);
      this.YjL = false;
      this.YjO = false;
      this.YjQ = new int[2];
      this.YjK = paramInt2;
      this.YjP = (ViewConfiguration.get(b.c(b.this).getContext()).getScaledTouchSlop() * 4);
      AppMethodBeat.o(200445);
    }
    
    private static float a(Layout paramLayout, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(200491);
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
        AppMethodBeat.o(200491);
        return f;
        i = Math.max(paramInt - 1, 0);
        break;
      }
      label75:
      float f = paramLayout.getSecondaryHorizontal(paramInt);
      AppMethodBeat.o(200491);
      return f;
    }
    
    private void cd(int paramInt, boolean paramBoolean)
    {
      boolean bool2 = true;
      AppMethodBeat.i(200485);
      int i;
      int j;
      float f1;
      if (ibK())
      {
        i = b.c(b.this).getSelectionEnd();
        if ((!ibK()) || (paramInt < i))
        {
          j = paramInt;
          if (ibK()) {
            break label245;
          }
          j = paramInt;
          if (paramInt > i) {
            break label245;
          }
        }
        this.YjM = 0.0F;
        localObject = b.c(b.this).getLayout();
        if ((localObject == null) || (paramInt == i)) {
          break label217;
        }
        f1 = c((Layout)localObject, paramInt);
        if (ibK()) {
          break label211;
        }
      }
      label211:
      for (boolean bool1 = true;; bool1 = false)
      {
        float f2 = a((Layout)localObject, i, bool1);
        float f3 = c((Layout)localObject, this.FPB);
        if (((f3 >= f2) || (f1 >= f2)) && ((f3 <= f2) || (f1 <= f2))) {
          break label217;
        }
        paramInt = getCurrentCursorOffset();
        if (!ibK()) {
          Math.max(paramInt - 1, 0);
        }
        ibK();
        p(0, false, paramBoolean);
        AppMethodBeat.o(200485);
        return;
        i = b.c(b.this).getSelectionStart();
        break;
      }
      label217:
      Object localObject = b.this;
      if (!ibK()) {}
      for (bool1 = bool2;; bool1 = false)
      {
        j = b.a((b)localObject, i, bool1);
        label245:
        p(j, false, paramBoolean);
        AppMethodBeat.o(200485);
        return;
      }
    }
    
    private boolean ibK()
    {
      return this.YjK == 0;
    }
    
    protected final int Hy(boolean paramBoolean)
    {
      AppMethodBeat.i(200450);
      if (paramBoolean == ibK())
      {
        AppMethodBeat.o(200450);
        return 3;
      }
      AppMethodBeat.o(200450);
      return 5;
    }
    
    protected final void JU(int paramInt)
    {
      AppMethodBeat.i(200458);
      if (ibK()) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt, b.c(b.this).getSelectionEnd());
      }
      for (;;)
      {
        Hx(false);
        if (b.f(b.this) != null) {
          b.v(b.this);
        }
        AppMethodBeat.o(200458);
        return;
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionStart(), paramInt);
      }
    }
    
    protected final int b(Layout paramLayout, int paramInt, float paramFloat)
    {
      AppMethodBeat.i(200494);
      paramInt = paramLayout.getOffsetForHorizontal(paramInt, b.c(b.this).cS(paramFloat));
      AppMethodBeat.o(200494);
      return paramInt;
    }
    
    protected final boolean b(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(200488);
      if (ibK()) {}
      for (;;)
      {
        boolean bool = paramLayout.isRtlCharAt(paramInt);
        AppMethodBeat.o(200488);
        return bool;
        paramInt = Math.max(paramInt - 1, 0);
      }
    }
    
    public final float c(Layout paramLayout, int paramInt)
    {
      AppMethodBeat.i(200489);
      float f = a(paramLayout, paramInt, ibK());
      AppMethodBeat.o(200489);
      return f;
    }
    
    protected final int c(Drawable paramDrawable, boolean paramBoolean)
    {
      AppMethodBeat.i(200448);
      if (paramBoolean == ibK())
      {
        i = paramDrawable.getIntrinsicWidth() / 4;
        AppMethodBeat.o(200448);
        return i;
      }
      int i = paramDrawable.getIntrinsicWidth() * 3 / 4;
      AppMethodBeat.o(200448);
      return i;
    }
    
    protected final void g(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      AppMethodBeat.i(200469);
      Layout localLayout = b.c(b.this).getLayout();
      if (localLayout == null)
      {
        cd(b.c(b.this).aG(paramFloat1, paramFloat2), paramBoolean);
        AppMethodBeat.o(200469);
        return;
      }
      if (this.YiO == -1) {
        this.YiO = b.c(b.this).cT(paramFloat2);
      }
      int i;
      int i1;
      int j;
      if (ibK())
      {
        i = b.c(b.this).getSelectionEnd();
        i1 = b.this.a(localLayout, this.YiO, paramFloat2);
        j = b(localLayout, i1, paramFloat1);
        if (((!ibK()) || (j < i)) && ((ibK()) || (j > i))) {
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
        if (this.YjN == -1.0F) {
          this.YjN = paramFloat1;
        }
        int i2 = getCurrentCursorOffset();
        boolean bool1 = b(localLayout, i2);
        boolean bool2 = b(localLayout, j);
        if (((bool1) && (!bool2)) || ((!bool1) && (bool2)))
        {
          this.YjO = true;
          this.YjM = 0.0F;
          cd(j, paramBoolean);
          AppMethodBeat.o(200469);
          return;
          i = b.c(b.this).getSelectionStart();
          break;
        }
        if (this.YjO)
        {
          cd(j, paramBoolean);
          this.YjM = 0.0F;
          this.YjO = false;
          AppMethodBeat.o(200469);
          return;
        }
        paramFloat2 = paramFloat1 - this.YjN;
        int n;
        if (ibK()) {
          if (i1 < this.YiO)
          {
            i = 1;
            if (bool2 != ibK()) {
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
            b.c(b.this).getLocationOnScreen(this.YjQ);
            if (bool2 != ibK()) {
              break label641;
            }
            if (paramFloat1 <= this.YjQ[0] + b.c(b.this).getWidth() - b.c(b.this).getPaddingRight() - this.YjP) {
              break label635;
            }
            i = 1;
            label442:
            if (i == 0) {
              break label701;
            }
            if ((!ibK()) || (b.c(b.this).getScrollX() == 0))
            {
              if (ibK()) {
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
            if (((n == 0) || (((!ibK()) || (j >= i2)) && ((ibK()) || (j <= i2)))) && (n != 0)) {
              break label701;
            }
            this.YjM = 0.0F;
            if (bool2 != ibK()) {
              break label687;
            }
          }
        }
        label681:
        label687:
        for (i = localLayout.getOffsetToRightOf(this.FPB);; i = localLayout.getOffsetToLeftOf(this.FPB))
        {
          cd(i, paramBoolean);
          AppMethodBeat.o(200469);
          return;
          i = 0;
          break;
          if (i1 > this.YiO)
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
          if (paramFloat1 < this.YjQ[0] + b.c(b.this).getPaddingLeft() + this.YjP)
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
          if (ibK())
          {
            i = m;
            if (this.YjL)
            {
              if (!ibK()) {
                break label944;
              }
              if (i1 >= this.YiN) {
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
              if (!ibK()) {
                break label959;
              }
              n = localLayout.getLineStart(i1);
            }
            if (!ibK()) {
              break label971;
            }
            n = k - (k - n) / 2;
            if (!ibK()) {
              break label986;
            }
            i = m;
            if (j > n)
            {
              if (i1 >= this.YiN) {
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
          if (((ibK()) && (i < j)) || ((!ibK()) && (i > j)))
          {
            paramFloat2 = c(localLayout, i);
            this.YjM = (b.c(b.this).cS(paramFloat1) - paramFloat2);
            k = 1;
            j = i;
            i = k;
          }
          for (;;)
          {
            if (i != 0)
            {
              this.YiO = i1;
              cd(j, paramBoolean);
            }
            this.YjN = paramFloat1;
            AppMethodBeat.o(200469);
            return;
            i = k;
            break;
            label944:
            if (i1 > this.YiN) {
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
            if ((!ibK()) && ((j >= n) || (i1 > this.YiN)))
            {
              i = k;
              break label843;
            }
            i = this.FPB;
            break label843;
            this.YjM = 0.0F;
            break label897;
            n = b(localLayout, i1, paramFloat1 - this.YjM);
            if (ibK()) {
              if ((n > this.FPB) || (i1 > this.YiN))
              {
                i = 1;
                label1077:
                if (i == 0) {
                  break label1220;
                }
                if (i1 == this.YiN) {
                  break label1213;
                }
                if (!ibK()) {
                  break label1198;
                }
                label1098:
                if (((!ibK()) || (m >= j)) && ((ibK()) || (m <= j))) {
                  break label1205;
                }
                paramFloat2 = c(localLayout, m);
                this.YjM = (b.c(b.this).cS(paramFloat1) - paramFloat2);
              }
            }
            for (;;)
            {
              i = 1;
              j = m;
              break;
              i = 0;
              break label1077;
              if ((n < this.FPB) || (i1 < this.YiN))
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
              this.YjM = 0.0F;
              continue;
              label1213:
              m = n;
            }
            label1220:
            if (((ibK()) && (n < this.FPB)) || ((!ibK()) && (n > this.FPB))) {
              this.YjM = (b.c(b.this).cS(paramFloat1) - c(localLayout, this.FPB));
            }
            i = 0;
          }
          i = j;
        }
      }
    }
    
    public final int getCurrentCursorOffset()
    {
      AppMethodBeat.i(200453);
      if (ibK())
      {
        i = b.c(b.this).getSelectionStart();
        AppMethodBeat.o(200453);
        return i;
      }
      int i = b.c(b.this).getSelectionEnd();
      AppMethodBeat.o(200453);
      return i;
    }
    
    protected final int getMagnifierHandleTrigger()
    {
      AppMethodBeat.i(200495);
      if (ibK())
      {
        AppMethodBeat.o(200495);
        return 1;
      }
      AppMethodBeat.o(200495);
      return 2;
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(200475);
      if (!b.c(b.this).b(paramMotionEvent, true))
      {
        AppMethodBeat.o(200475);
        return true;
      }
      boolean bool = super.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(200475);
        return bool;
        this.YjM = 0.0F;
        this.YjN = -1.0F;
        az(paramMotionEvent);
        continue;
        az(paramMotionEvent);
        continue;
        ibD();
      }
    }
    
    protected final void p(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(200472);
      super.p(paramInt, paramBoolean1, paramBoolean2);
      if (paramInt != -1)
      {
        com.tencent.mm.ui.widget.cedit.c.b localb = b.w(b.this);
        localb.axV(paramInt);
        if (localb.YkK.isBoundary(paramInt)) {}
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        this.YjL = paramBoolean1;
        AppMethodBeat.o(200472);
        return;
      }
    }
  }
  
  public final class n
    implements b.d
  {
    private b.m YjR;
    private b.m YjS;
    int YjT;
    int YjU;
    private boolean YjV;
    private int YjW;
    private boolean YjX;
    private int YjY;
    private boolean YjZ;
    private int Yka;
    
    n()
    {
      AppMethodBeat.i(215069);
      this.YjW = -1;
      this.YjY = -1;
      this.YjZ = false;
      this.Yka = 0;
      ibM();
      AppMethodBeat.o(215069);
    }
    
    private void U(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(215083);
      if ((paramBoolean) && (b.n(b.this)) && ((b.c(b.this).getSelectionStart() != paramInt1) || (b.c(b.this).getSelectionEnd() != paramInt2))) {}
      for (int i = 1;; i = 0)
      {
        Selection.setSelection((Spannable)b.c(b.this).getText(), paramInt1, paramInt2);
        if (i != 0) {
          b.c(b.this).performHapticFeedback(9);
        }
        AppMethodBeat.o(215083);
        return;
      }
    }
    
    private void aB(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(215077);
      if (b.c(b.this).getLayout() != null) {
        switch (this.Yka)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(215077);
        return;
        aC(paramMotionEvent);
        AppMethodBeat.o(215077);
        return;
        aD(paramMotionEvent);
        AppMethodBeat.o(215077);
        return;
        aE(paramMotionEvent);
      }
    }
    
    private void aC(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(215078);
      int i = b.c(b.this).aG(paramMotionEvent.getX(), paramMotionEvent.getY());
      U(this.YjW, i, paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(215078);
    }
    
    private void aD(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(215079);
      if (this.YjX)
      {
        AppMethodBeat.o(215079);
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
        j = b.c(b.this).cT(f2);
        i = b.c(b.this).B(j, f3);
        if (this.YjW < i)
        {
          i = b.a(b.this, i);
          k = b.b(b.this, this.YjW);
          label120:
          this.YjY = j;
          U(k, i, paramMotionEvent.isFromSource(4098));
          AppMethodBeat.o(215079);
        }
      }
      else
      {
        if (!this.YjZ) {
          break label304;
        }
        i = localViewConfiguration.getScaledTouchSlop();
        if (this.YjR != null) {
          f1 = this.YjR.getIdealVerticalOffset();
        }
      }
      label176:
      for (float f1 = f2 - f1;; f1 = f2)
      {
        i = b.this.a(b.c(b.this).getLayout(), this.YjY, f1);
        j = i;
        if (this.YjZ) {
          break;
        }
        j = i;
        if (i == this.YjY) {
          break;
        }
        this.YjZ = true;
        AppMethodBeat.o(215079);
        return;
        f1 = i;
        break label176;
        int n = b.b(b.this, i);
        int m = b.a(b.this, this.YjW);
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
    
    private void aE(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(215081);
      int j = b.c(b.this).aG(paramMotionEvent.getX(), paramMotionEvent.getY());
      int i = Math.min(j, this.YjW);
      j = Math.max(j, this.YjW);
      long l = b.a(b.this, i, j);
      U((int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramMotionEvent.isFromSource(4098));
      AppMethodBeat.o(215081);
    }
    
    private void ibL()
    {
      AppMethodBeat.i(215072);
      if (this.YjR == null) {
        this.YjR = new b.m(b.this, b.this.YhP, b.this.YhQ, a.g.selection_start_handle, 0);
      }
      if (this.YjS == null) {
        this.YjS = new b.m(b.this, b.this.YhQ, b.this.YhP, a.g.selection_end_handle, 1);
      }
      this.YjR.show();
      this.YjS.show();
      b.this.iaO();
      AppMethodBeat.o(215072);
    }
    
    private void ibN()
    {
      AppMethodBeat.i(215086);
      this.YjW = -1;
      this.Yka = 0;
      this.YjZ = false;
      int i = b.c(b.this).getSelectionStart();
      int j = b.c(b.this).getSelectionEnd();
      if ((i < 0) || (j < 0))
      {
        Selection.removeSelection((Spannable)b.c(b.this).getText());
        AppMethodBeat.o(215086);
        return;
      }
      if (i > j) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), j, i);
      }
      AppMethodBeat.o(215086);
    }
    
    public final void B(MotionEvent paramMotionEvent)
    {
      int i = 0;
      int j = 0;
      AppMethodBeat.i(215075);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      boolean bool2 = paramMotionEvent.isFromSource(8194);
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(215075);
        return;
        if (b.A(b.this))
        {
          hide();
          AppMethodBeat.o(215075);
          return;
        }
        i = b.c(b.this).aG(f1, f2);
        this.YjU = i;
        this.YjT = i;
        if (this.YjV)
        {
          paramMotionEvent = b.x(b.this);
          if ((!paramMotionEvent.ibS()) || (!paramMotionEvent.Ykm)) {
            break label249;
          }
          i = 1;
          if ((i != 0) && ((bool2) || (b.a(b.this, f1, f2)) || (b.x(b.this).Ykk)))
          {
            if (b.x(b.this).Ykl != 2) {
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
          b.this.Yhy = true;
          this.YjV = true;
          this.YjX = true;
          AppMethodBeat.o(215075);
          return;
          label249:
          i = 0;
          break;
          label255:
          i = 0;
          break label212;
          label261:
          i = j;
          if (b.x(b.this).Ykl == 3) {
            i = 1;
          }
          if (i != 0)
          {
            if (b.y(b.this) != null) {
              b.c(b.this).removeCallbacks(b.y(b.this));
            }
            b.this.iaB();
            if (b.D(b.this)) {
              axN(3);
            }
          }
        }
        if (b.c(b.this).getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct"))
        {
          j = paramMotionEvent.getPointerCount();
          while (i < j)
          {
            int k = b.c(b.this).aG(paramMotionEvent.getX(i), paramMotionEvent.getY(i));
            if (k < this.YjT) {
              this.YjT = k;
            }
            if (k > this.YjU) {
              this.YjU = k;
            }
            i += 1;
          }
          AppMethodBeat.o(215075);
          return;
          if (this.YjV)
          {
            ViewConfiguration.get(b.c(b.this).getContext());
            i = aw.fromDPToPix(b.c(b.this).getContext(), 8);
            this.YjV = c.a(b.x(b.this).ryy, b.x(b.this).ryz, f1, f2, i);
          }
          if (this.YjX) {
            if (b.x(b.this).Ykn) {
              break label640;
            }
          }
          label640:
          for (boolean bool1 = true;; bool1 = false)
          {
            this.YjX = bool1;
            if ((!bool2) || (ibP())) {
              break label680;
            }
            i = b.c(b.this).aG(f1, f2);
            if ((!b.c(b.this).iau()) || ((this.YjX) && (this.YjW == i)) || (i < b.c(b.this).getSelectionStart()) || (i > b.c(b.this).getSelectionEnd())) {
              break;
            }
            b.C(b.this);
            AppMethodBeat.o(215075);
            return;
          }
          if (this.YjW != i)
          {
            b.this.iaB();
            axN(1);
            b.this.Yhy = true;
            this.YjX = false;
          }
          label680:
          if ((this.YjR == null) || (!this.YjR.isShowing()))
          {
            aB(paramMotionEvent);
            AppMethodBeat.o(215075);
            return;
            if (ibP())
            {
              aB(paramMotionEvent);
              b.c(b.this).getParent().requestDisallowInterceptTouchEvent(false);
              ibN();
              if (b.c(b.this).iau())
              {
                b.this.ibm().ibT();
                b.c(b.this).invalidate();
              }
            }
          }
        }
      }
    }
    
    public final void axN(int paramInt)
    {
      AppMethodBeat.i(215074);
      show();
      this.Yka = paramInt;
      this.YjW = b.c(b.this).aG(b.x(b.this).ryy, b.x(b.this).ryz);
      this.YjY = b.c(b.this).cT(b.x(b.this).ryz);
      hide();
      b.c(b.this).getParent().requestDisallowInterceptTouchEvent(true);
      b.c(b.this).cancelLongPress();
      AppMethodBeat.o(215074);
    }
    
    public final void cfy()
    {
      AppMethodBeat.i(215090);
      b.c(b.this).getViewTreeObserver().removeOnTouchModeChangeListener(this);
      if (this.YjR != null) {
        this.YjR.cfy();
      }
      if (this.YjS != null) {
        this.YjS.cfy();
      }
      AppMethodBeat.o(215090);
    }
    
    public final void hide()
    {
      AppMethodBeat.i(215073);
      if (this.YjR != null) {
        this.YjR.hide();
      }
      if (this.YjS != null) {
        this.YjS.hide();
      }
      AppMethodBeat.o(215073);
    }
    
    public final void ibM()
    {
      AppMethodBeat.i(215084);
      this.YjU = -1;
      this.YjT = -1;
      ibN();
      AppMethodBeat.o(215084);
    }
    
    public final boolean ibO()
    {
      return (this.YjR != null) && (this.YjR.rmR);
    }
    
    public final boolean ibP()
    {
      return this.Yka != 0;
    }
    
    public final void ibQ()
    {
      AppMethodBeat.i(215092);
      if (this.YjR != null) {
        this.YjR.invalidate();
      }
      if (this.YjS != null) {
        this.YjS.invalidate();
      }
      AppMethodBeat.o(215092);
    }
    
    public final boolean ibz()
    {
      AppMethodBeat.i(215088);
      if ((ibP()) || (ibO()) || ((this.YjS != null) && (this.YjS.rmR)))
      {
        AppMethodBeat.o(215088);
        return true;
      }
      AppMethodBeat.o(215088);
      return false;
    }
    
    public final boolean isActive()
    {
      AppMethodBeat.i(215091);
      if ((this.YjR != null) && (this.YjR.isShowing()))
      {
        AppMethodBeat.o(215091);
        return true;
      }
      AppMethodBeat.o(215091);
      return false;
    }
    
    public final void onTouchModeChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(215089);
      if (!paramBoolean) {
        hide();
      }
      AppMethodBeat.o(215089);
    }
    
    public final void show()
    {
      AppMethodBeat.i(215071);
      if (b.c(b.this).iaH())
      {
        AppMethodBeat.o(215071);
        return;
      }
      b.this.Hv(false);
      ibL();
      AppMethodBeat.o(215071);
    }
  }
  
  @SuppressLint({"NewApi"})
  final class o
    extends ActionMode.Callback2
  {
    private final Path Ykb;
    private final RectF Ykc;
    private final boolean Ykd;
    private final int Yke;
    private final Map<MenuItem, View.OnClickListener> Ykf;
    
    o(int paramInt)
    {
      AppMethodBeat.i(188377);
      this.Ykb = new Path();
      this.Ykc = new RectF();
      this.Ykf = new HashMap();
      if ((paramInt == 0) || ((b.this.YhE) && (paramInt == 2))) {}
      for (boolean bool = true;; bool = false)
      {
        this.Ykd = bool;
        if (!this.Ykd) {
          break;
        }
        localObject = b.this.ibv();
        if (b.n.a((b.n)localObject) == null)
        {
          b.this.Hv(false);
          b.n.b((b.n)localObject);
          ((b.n)localObject).hide();
        }
        this.Yke = Math.max(b.this.YhP.getMinimumHeight(), b.this.YhQ.getMinimumHeight());
        AppMethodBeat.o(188377);
        return;
      }
      Object localObject = b.this.ibu();
      if (localObject != null)
      {
        ((b.j)localObject).ibI();
        this.Yke = b.this.YhR.getMinimumHeight();
        AppMethodBeat.o(188377);
        return;
      }
      this.Yke = 0;
      AppMethodBeat.o(188377);
    }
    
    private void g(Menu paramMenu)
    {
      AppMethodBeat.i(188390);
      boolean bool = b.c(b.this).iaF();
      if (paramMenu.findItem(16908319) != null) {}
      for (int i = 1; (bool) && (i == 0); i = 0)
      {
        paramMenu.add(0, 16908319, 8, 17039373).setShowAsAction(1);
        AppMethodBeat.o(188390);
        return;
      }
      if ((!bool) && (i != 0)) {
        paramMenu.removeItem(16908319);
      }
      AppMethodBeat.o(188390);
    }
    
    private ActionMode.Callback ibR()
    {
      if (this.Ykd) {
        return b.this.YhV;
      }
      return b.this.YhW;
    }
    
    public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(188391);
      b.h(b.this);
      paramMenuItem.getItemId();
      paramMenuItem.getTitle().toString();
      ActionMode.Callback localCallback = ibR();
      if ((localCallback != null) && (localCallback.onActionItemClicked(paramActionMode, paramMenuItem)))
      {
        AppMethodBeat.o(188391);
        return true;
      }
      if (paramMenuItem.getGroupId() == 16908353)
      {
        if (paramMenuItem.getGroupId() == 16908353) {}
        for (bool = true;; bool = false)
        {
          com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool);
          b.h(b.this);
          AppMethodBeat.o(188391);
          return true;
        }
      }
      boolean bool = b.c(b.this).onTextContextMenuItem(paramMenuItem.getItemId());
      AppMethodBeat.o(188391);
      return bool;
    }
    
    public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(188381);
      this.Ykf.clear();
      paramActionMode.setTitle(null);
      paramActionMode.setSubtitle(null);
      paramActionMode.setTitleOptionalHint(true);
      if (b.c(b.this).iaC()) {
        paramMenu.add(0, 16908320, 4, 17039363).setAlphabeticShortcut('x').setShowAsAction(2);
      }
      if (b.c(b.this).iaD()) {
        paramMenu.add(0, 16908321, 5, 17039361).setAlphabeticShortcut('c').setShowAsAction(2);
      }
      if (b.c(b.this).iaE()) {
        paramMenu.add(0, 16908322, 6, 17039371).setAlphabeticShortcut('v').setShowAsAction(2);
      }
      g(paramMenu);
      ActionMode.Callback localCallback = ibR();
      if ((localCallback != null) && (!localCallback.onCreateActionMode(paramActionMode, paramMenu)))
      {
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionEnd());
        AppMethodBeat.o(188381);
        return false;
      }
      if ((this.Ykd) && (!b.c(b.this).hasTransientState())) {
        b.c(b.this).setHasTransientState(true);
      }
      AppMethodBeat.o(188381);
      return true;
    }
    
    public final void onDestroyActionMode(ActionMode paramActionMode)
    {
      AppMethodBeat.i(188393);
      b.h(b.this);
      b.i(b.this);
      ActionMode.Callback localCallback = ibR();
      if (localCallback != null) {
        localCallback.onDestroyActionMode(paramActionMode);
      }
      if (!b.j(b.this)) {
        Selection.setSelection((Spannable)b.c(b.this).getText(), b.c(b.this).getSelectionEnd());
      }
      if (b.this.Yhj != null) {
        b.this.Yhj.hide();
      }
      this.Ykf.clear();
      b.k(b.this);
      AppMethodBeat.o(188393);
    }
    
    public final void onGetContentRect(ActionMode paramActionMode, View paramView, Rect paramRect)
    {
      AppMethodBeat.i(188396);
      Log.i("cmEdit.Editor", "onGetContentRect mode:" + paramActionMode + ",view:" + paramView + ",outRect:" + paramRect);
      if ((!paramView.equals(b.c(b.this))) || (b.c(b.this).getLayout() == null))
      {
        super.onGetContentRect(paramActionMode, paramView, paramRect);
        AppMethodBeat.o(188396);
        return;
      }
      if (b.c(b.this).getSelectionStart() != b.c(b.this).getSelectionEnd())
      {
        this.Ykb.reset();
        b.c(b.this).getLayout().getSelectionPath(b.c(b.this).getSelectionStart(), b.c(b.this).getSelectionEnd(), this.Ykb);
        this.Ykb.computeBounds(this.Ykc, true);
        paramActionMode = this.Ykc;
        paramActionMode.bottom += this.Yke;
      }
      for (;;)
      {
        int m = b.c(b.this).ias();
        int i = b.c(b.this).iat();
        int j = (int)Math.floor(this.Ykc.left + m);
        int k = (int)Math.floor(this.Ykc.top + i);
        float f = this.Ykc.right;
        m = (int)Math.ceil(m + f);
        f = this.Ykc.bottom;
        paramRect.set(j, k, m, (int)Math.ceil(i + f));
        AppMethodBeat.o(188396);
        return;
        paramActionMode = b.c(b.this).getLayout();
        i = paramActionMode.getLineForOffset(b.c(b.this).getSelectionStart());
        f = b.a(b.this, null, paramActionMode.getPrimaryHorizontal(b.c(b.this).getSelectionStart()));
        this.Ykc.set(f, paramActionMode.getLineTop(i), f, paramActionMode.getLineBottom(i) + this.Yke);
      }
    }
    
    public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      AppMethodBeat.i(188386);
      g(paramMenu);
      ActionMode.Callback localCallback = ibR();
      if (localCallback != null)
      {
        boolean bool = localCallback.onPrepareActionMode(paramActionMode, paramMenu);
        AppMethodBeat.o(188386);
        return bool;
      }
      AppMethodBeat.o(188386);
      return true;
    }
  }
  
  public static abstract interface p
  {
    public abstract void h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.b
 * JD-Core Version:    0.7.0.1
 */