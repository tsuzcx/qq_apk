package com.tencent.mm.ui.widget.cedit.edit;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.ParcelableSpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DateTimeKeyListener;
import android.text.method.DialerKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TextKeyListener;
import android.text.method.TextKeyListener.Capitalize;
import android.text.method.TimeKeyListener;
import android.text.method.TransformationMethod;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ParagraphStyle;
import android.text.style.SuggestionSpan;
import android.text.style.URLSpan;
import android.text.style.UpdateAppearance;
import android.text.util.Linkify;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationContext.Builder;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textservice.TextServicesManager;
import android.widget.RemoteViews.RemoteView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.cedit.util.ParcelableParcel;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

@RemoteViews.RemoteView
public class CustomTextView
  extends View
  implements ViewTreeObserver.OnPreDrawListener
{
  public static final BoringLayout.Metrics OVU;
  private static final float[] QGi;
  private static final InputFilter[] QGj;
  private static final Spanned QGk;
  private static final int[] QGl;
  static long QGm;
  private static final SparseIntArray QHw;
  private static final RectF alw;
  private ColorStateList BpJ;
  @ViewDebug.ExportedProperty(category="text")
  private int Ku;
  boolean OSP;
  private int OVC;
  private boolean OVD;
  private BoringLayout OVE;
  @ViewDebug.ExportedProperty(category="text")
  private int OVm;
  private Editable.Factory OVn;
  private Spannable.Factory OVo;
  private TextUtils.TruncateAt OVp;
  private CharSequence OVq;
  public Layout OVt;
  private float OVu;
  private float OVv;
  private int OVw;
  private int OVx;
  private int OVy;
  private int OVz;
  private TextDirectionHeuristic Om;
  private int On;
  private int Oo;
  b QGA;
  private int QGB;
  public Spannable QGC;
  private TextView.BufferType QGD;
  private CharSequence QGE;
  private Layout QGF;
  private com.tencent.mm.ui.widget.cedit.b.d QGG;
  TransformationMethod QGH;
  private boolean QGI;
  private a QGJ;
  private boolean QGK;
  private boolean QGL;
  private int QGM;
  private boolean QGN;
  private boolean QGO;
  boolean QGP;
  private boolean QGQ;
  private int QGR;
  private boolean QGS;
  private int QGT;
  private int QGU;
  private int QGV;
  private int QGW;
  private int QGX;
  private int QGY;
  private BoringLayout.Metrics QGZ;
  private ColorStateList QGn;
  private ColorStateList QGo;
  private int QGp;
  private boolean QGq;
  private float QGr;
  private float QGs;
  private float QGt;
  private boolean QGu;
  private boolean QGv;
  private TextClassifier QGw;
  private TextClassifier QGx;
  private TextClassificationContext QGy;
  private boolean QGz;
  private Set<String> QHA;
  private Set<String> QHB;
  private BoringLayout.Metrics QHa;
  private BoringLayout QHb;
  private InputFilter[] QHc;
  private UserHandle QHd;
  private volatile Locale QHe;
  private Path QHf;
  private Paint QHg;
  private boolean QHh;
  int QHi;
  private Drawable QHj;
  int QHk;
  private Drawable QHl;
  int QHm;
  private Drawable QHn;
  int QHo;
  private Drawable QHp;
  private int QHq;
  private boolean QHr;
  b QHs;
  private int QHt;
  private TextView QHu;
  private TextWatcher QHv;
  int QHx;
  boolean QHy;
  private a.e QHz;
  private long UC;
  private int aly;
  private TextPaint ayn;
  private ArrayList<TextWatcher> mListeners;
  private int mMaxWidth;
  private int mMinWidth;
  private Scroller mScroller;
  private Rect mTempRect;
  @ViewDebug.ExportedProperty(category="text")
  public CharSequence mText;
  private int nYW;
  int oEF;
  
  static
  {
    AppMethodBeat.i(205863);
    QGi = new float[2];
    alw = new RectF();
    QGj = new InputFilter[0];
    QGk = new SpannedString("");
    QGl = new int[] { 16843597 };
    com.tencent.mm.ui.widget.cedit.util.d.haY();
    CustomTextView.2 local2 = new CustomTextView.2();
    QHw = local2;
    local2.put(5, 5);
    QHw.put(4, 4);
    QHw.put(6, 6);
    QHw.put(7, 7);
    QHw.put(1, 1);
    try
    {
      QHw.put(89, 89);
      label119:
      QHw.put(2, 2);
      QHw.put(68, 68);
      QHw.put(3, 3);
      QHw.put(88, 88);
      QHw.put(65, 65);
      QHw.put(34, 34);
      QHw.put(35, 35);
      QHw.put(36, 36);
      QHw.put(37, 37);
      QHw.put(69, 69);
      QHw.put(84, 84);
      QHw.put(70, 70);
      QHw.put(71, 71);
      QHw.put(83, 83);
      OVU = new BoringLayout.Metrics();
      AppMethodBeat.o(205863);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label119;
    }
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131821096);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(205572);
    this.OVn = Editable.Factory.getInstance();
    this.OVo = Spannable.Factory.getInstance();
    this.QGB = -1;
    this.QGD = TextView.BufferType.NORMAL;
    this.QGL = false;
    this.QGM = -1;
    this.QGN = false;
    this.Ku = 8388659;
    this.QGS = true;
    this.OVu = 1.0F;
    this.OVv = 0.0F;
    this.On = 0;
    this.Oo = 0;
    this.OVw = 2147483647;
    this.OVx = 1;
    this.OVy = 0;
    this.OVz = 1;
    this.QGU = this.OVw;
    this.QGV = this.OVx;
    this.mMaxWidth = 2147483647;
    this.QGW = 2;
    this.mMinWidth = 0;
    this.QGX = 2;
    this.OVC = -1;
    this.OVD = true;
    this.QGY = -1;
    this.QHc = QGj;
    this.oEF = 1714664933;
    this.QHh = true;
    this.QHi = 16843618;
    this.QHk = 16843461;
    this.QHm = 16843462;
    this.QHo = 16843463;
    this.QHq = -1;
    this.QHt = 0;
    this.aly = 0;
    this.QHv = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(205553);
        ((Editable)CustomTextView.this.getText()).insert(CustomTextView.this.getSelectionStart(), paramAnonymousEditable.toString());
        AppMethodBeat.o(205553);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.QHx = getContext().getResources().getColor(2131100228);
    this.QHy = false;
    this.QHA = new HashSet();
    this.QHB = new HashSet();
    b(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.o(205572);
  }
  
  private Locale CX(boolean paramBoolean)
  {
    AppMethodBeat.i(205809);
    AsyncTask.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205556);
        CustomTextView.a(CustomTextView.this);
        AppMethodBeat.o(205556);
      }
    });
    if ((this.QHe == null) && (!paramBoolean))
    {
      localLocale = Locale.getDefault();
      AppMethodBeat.o(205809);
      return localLocale;
    }
    Locale localLocale = this.QHe;
    AppMethodBeat.o(205809);
    return localLocale;
  }
  
  private void IR()
  {
    AppMethodBeat.i(205758);
    if (((getLayoutParams().width != -2) || ((this.QGW == this.QGX) && (this.mMaxWidth == this.mMinWidth))) && ((this.QGE == null) || (this.QGF != null)) && (getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0))
    {
      int j = this.OVt.getHeight();
      int k = this.OVt.getWidth();
      if (this.QGF == null) {}
      for (int i = 0;; i = this.QGF.getWidth())
      {
        BoringLayout.Metrics localMetrics = OVU;
        a(k, i, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        if (this.OVp == TextUtils.TruncateAt.MARQUEE) {
          break label231;
        }
        if ((getLayoutParams().height == -2) || (getLayoutParams().height == -1)) {
          break;
        }
        invalidate();
        AppMethodBeat.o(205758);
        return;
      }
      if ((this.OVt.getHeight() == j) && ((this.QGF == null) || (this.QGF.getHeight() == j)))
      {
        invalidate();
        AppMethodBeat.o(205758);
        return;
      }
      label231:
      requestLayout();
      invalidate();
      AppMethodBeat.o(205758);
      return;
    }
    gLr();
    requestLayout();
    invalidate();
    AppMethodBeat.o(205758);
  }
  
  private void M(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(205842);
    ClipData localClipData = getClipboardManagerForUser().getPrimaryClip();
    if (localClipData != null)
    {
      int i = 0;
      int j = 0;
      if (i < localClipData.getItemCount())
      {
        Object localObject;
        if (paramBoolean)
        {
          localObject = localClipData.getItemAt(i).coerceToStyledText(getContext());
          label56:
          k = j;
          if (localObject != null)
          {
            if (j != 0) {
              break label150;
            }
            Selection.setSelection(this.QGC, paramInt2);
            ((Editable)this.mText).replace(paramInt1, paramInt2, (CharSequence)localObject);
          }
        }
        for (int k = 1;; k = j)
        {
          i += 1;
          j = k;
          break;
          localObject = localClipData.getItemAt(i).coerceToText(getContext());
          if ((localObject instanceof Spanned))
          {
            localObject = ((CharSequence)localObject).toString();
            break label56;
          }
          break label56;
          label150:
          ((Editable)this.mText).insert(getSelectionEnd(), "\n");
          ((Editable)this.mText).insert(getSelectionEnd(), (CharSequence)localObject);
        }
      }
      QGm = 0L;
    }
    AppMethodBeat.o(205842);
  }
  
  /* Error */
  private int a(int paramInt, KeyEvent paramKeyEvent1, KeyEvent paramKeyEvent2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 534
    //   6: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 537	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:isEnabled	()Z
    //   13: ifne +11 -> 24
    //   16: ldc_w 534
    //   19: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_2
    //   25: invokevirtual 542	android/view/KeyEvent:getRepeatCount	()I
    //   28: ifne +15 -> 43
    //   31: iload_1
    //   32: invokestatic 546	android/view/KeyEvent:isModifierKey	(I)Z
    //   35: ifne +8 -> 43
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 548	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGz	Z
    //   43: iload_1
    //   44: lookupswitch	default:+92->136, 4:+318->362, 23:+273->317, 61:+295->339, 66:+157->201, 112:+443->487, 124:+476->520, 160:+157->201, 277:+347->391, 278:+379->423, 279:+411->455
    //   137: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   140: ifnull +530 -> 670
    //   143: aload_0
    //   144: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   147: getfield 556	com/tencent/mm/ui/widget/cedit/edit/b:QIH	Landroid/text/method/KeyListener;
    //   150: ifnull +520 -> 670
    //   153: aload_3
    //   154: ifnull +716 -> 870
    //   157: aload_0
    //   158: invokevirtual 559	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:beginBatchEdit	()V
    //   161: aload_0
    //   162: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   165: getfield 556	com/tencent/mm/ui/widget/cedit/edit/b:QIH	Landroid/text/method/KeyListener;
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 502	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   173: checkcast 504	android/text/Editable
    //   176: aload_3
    //   177: invokeinterface 565 4 0
    //   182: istore 6
    //   184: iload 6
    //   186: ifeq +402 -> 588
    //   189: aload_0
    //   190: invokevirtual 568	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   193: ldc_w 534
    //   196: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_m1
    //   200: ireturn
    //   201: aload_2
    //   202: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   205: ifeq -69 -> 136
    //   208: aload_0
    //   209: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   212: ifnull +65 -> 277
    //   215: aload_0
    //   216: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   219: getfield 575	com/tencent/mm/ui/widget/cedit/edit/b:QIC	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   222: ifnull +55 -> 277
    //   225: aload_0
    //   226: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   229: getfield 575	com/tencent/mm/ui/widget/cedit/edit/b:QIC	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   232: getfield 581	com/tencent/mm/ui/widget/cedit/edit/b$g:QKi	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   235: ifnull +42 -> 277
    //   238: aload_0
    //   239: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   242: getfield 575	com/tencent/mm/ui/widget/cedit/edit/b:QIC	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   245: getfield 581	com/tencent/mm/ui/widget/cedit/edit/b$g:QKi	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   248: aload_0
    //   249: iconst_0
    //   250: invokeinterface 584 3 0
    //   255: ifeq +22 -> 277
    //   258: aload_0
    //   259: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   262: getfield 575	com/tencent/mm/ui/widget/cedit/edit/b:QIC	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   265: iconst_1
    //   266: putfield 587	com/tencent/mm/ui/widget/cedit/edit/b$g:QKj	Z
    //   269: ldc_w 534
    //   272: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_2
    //   278: invokevirtual 590	android/view/KeyEvent:getFlags	()I
    //   281: bipush 16
    //   283: iand
    //   284: ifne +10 -> 294
    //   287: aload_0
    //   288: invokespecial 593	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZu	()Z
    //   291: ifeq -155 -> 136
    //   294: aload_0
    //   295: invokevirtual 596	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:hasOnClickListeners	()Z
    //   298: ifeq +11 -> 309
    //   301: ldc_w 534
    //   304: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: ldc_w 534
    //   312: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iconst_m1
    //   316: ireturn
    //   317: aload_2
    //   318: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   321: ifeq -185 -> 136
    //   324: aload_0
    //   325: invokespecial 593	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZu	()Z
    //   328: ifeq -192 -> 136
    //   331: ldc_w 534
    //   334: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: iconst_0
    //   338: ireturn
    //   339: aload_2
    //   340: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   343: ifne +11 -> 354
    //   346: aload_2
    //   347: iconst_1
    //   348: invokevirtual 599	android/view/KeyEvent:hasModifiers	(I)Z
    //   351: ifeq -215 -> 136
    //   354: ldc_w 534
    //   357: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_0
    //   361: ireturn
    //   362: aload_0
    //   363: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   366: ifnull -230 -> 136
    //   369: aload_0
    //   370: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   373: invokevirtual 602	com/tencent/mm/ui/widget/cedit/edit/b:ham	()Z
    //   376: ifne -240 -> 136
    //   379: aload_0
    //   380: invokevirtual 605	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZE	()V
    //   383: ldc_w 534
    //   386: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_m1
    //   390: ireturn
    //   391: aload_2
    //   392: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   395: ifeq -259 -> 136
    //   398: aload_0
    //   399: invokevirtual 608	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZF	()Z
    //   402: ifeq -266 -> 136
    //   405: aload_0
    //   406: ldc_w 609
    //   409: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   412: ifeq -276 -> 136
    //   415: ldc_w 534
    //   418: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: iconst_m1
    //   422: ireturn
    //   423: aload_2
    //   424: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   427: ifeq -291 -> 136
    //   430: aload_0
    //   431: invokevirtual 615	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZG	()Z
    //   434: ifeq -298 -> 136
    //   437: aload_0
    //   438: ldc_w 616
    //   441: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   444: ifeq -308 -> 136
    //   447: ldc_w 534
    //   450: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: iconst_m1
    //   454: ireturn
    //   455: aload_2
    //   456: invokevirtual 571	android/view/KeyEvent:hasNoModifiers	()Z
    //   459: ifeq -323 -> 136
    //   462: aload_0
    //   463: invokevirtual 619	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZH	()Z
    //   466: ifeq -330 -> 136
    //   469: aload_0
    //   470: ldc_w 620
    //   473: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   476: ifeq -340 -> 136
    //   479: ldc_w 534
    //   482: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: iconst_m1
    //   486: ireturn
    //   487: aload_2
    //   488: iconst_1
    //   489: invokevirtual 599	android/view/KeyEvent:hasModifiers	(I)Z
    //   492: ifeq -356 -> 136
    //   495: aload_0
    //   496: invokevirtual 608	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZF	()Z
    //   499: ifeq -363 -> 136
    //   502: aload_0
    //   503: ldc_w 609
    //   506: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   509: ifeq -373 -> 136
    //   512: ldc_w 534
    //   515: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: iconst_m1
    //   519: ireturn
    //   520: aload_2
    //   521: sipush 4096
    //   524: invokevirtual 599	android/view/KeyEvent:hasModifiers	(I)Z
    //   527: ifeq +28 -> 555
    //   530: aload_0
    //   531: invokevirtual 615	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZG	()Z
    //   534: ifeq +21 -> 555
    //   537: aload_0
    //   538: ldc_w 616
    //   541: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   544: ifeq -408 -> 136
    //   547: ldc_w 534
    //   550: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   553: iconst_m1
    //   554: ireturn
    //   555: aload_2
    //   556: iconst_1
    //   557: invokevirtual 599	android/view/KeyEvent:hasModifiers	(I)Z
    //   560: ifeq -424 -> 136
    //   563: aload_0
    //   564: invokevirtual 619	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:gZH	()Z
    //   567: ifeq -431 -> 136
    //   570: aload_0
    //   571: ldc_w 620
    //   574: invokevirtual 612	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   577: ifeq -441 -> 136
    //   580: ldc_w 534
    //   583: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: iconst_m1
    //   587: ireturn
    //   588: aload_0
    //   589: invokevirtual 568	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   592: iconst_0
    //   593: istore 4
    //   595: iload 4
    //   597: ifeq +73 -> 670
    //   600: aload_0
    //   601: invokevirtual 559	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:beginBatchEdit	()V
    //   604: aload_0
    //   605: getfield 550	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QHs	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   608: getfield 556	com/tencent/mm/ui/widget/cedit/edit/b:QIH	Landroid/text/method/KeyListener;
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 502	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   616: checkcast 504	android/text/Editable
    //   619: iload_1
    //   620: aload_2
    //   621: invokeinterface 624 5 0
    //   626: istore 6
    //   628: aload_0
    //   629: invokevirtual 568	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   632: iload 6
    //   634: ifeq +36 -> 670
    //   637: ldc_w 534
    //   640: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: iconst_1
    //   644: ireturn
    //   645: astore 7
    //   647: aload_0
    //   648: invokevirtual 568	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   651: iconst_1
    //   652: istore 4
    //   654: goto -59 -> 595
    //   657: astore_2
    //   658: aload_0
    //   659: invokevirtual 568	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   662: ldc_w 534
    //   665: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   668: aload_2
    //   669: athrow
    //   670: aload_0
    //   671: getfield 626	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGG	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   674: ifnull +166 -> 840
    //   677: aload_0
    //   678: getfield 434	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:OVt	Landroid/text/Layout;
    //   681: ifnull +159 -> 840
    //   684: aload_3
    //   685: ifnull +88 -> 773
    //   688: aload_0
    //   689: getfield 626	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGG	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 494	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGC	Landroid/text/Spannable;
    //   697: aload_3
    //   698: invokeinterface 631 4 0
    //   703: istore 6
    //   705: iload 6
    //   707: ifeq +11 -> 718
    //   710: ldc_w 534
    //   713: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: iconst_m1
    //   717: ireturn
    //   718: iconst_0
    //   719: istore 4
    //   721: iload 4
    //   723: ifeq +56 -> 779
    //   726: aload_0
    //   727: getfield 626	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGG	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   730: aload_0
    //   731: aload_0
    //   732: getfield 494	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGC	Landroid/text/Spannable;
    //   735: iload_1
    //   736: aload_2
    //   737: invokeinterface 634 5 0
    //   742: ifeq +37 -> 779
    //   745: aload_2
    //   746: invokevirtual 542	android/view/KeyEvent:getRepeatCount	()I
    //   749: ifne +15 -> 764
    //   752: iload_1
    //   753: invokestatic 546	android/view/KeyEvent:isModifierKey	(I)Z
    //   756: ifne +8 -> 764
    //   759: aload_0
    //   760: iconst_1
    //   761: putfield 548	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGz	Z
    //   764: ldc_w 534
    //   767: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_2
    //   771: ireturn
    //   772: astore_3
    //   773: iconst_1
    //   774: istore 4
    //   776: goto -55 -> 721
    //   779: aload_2
    //   780: invokevirtual 637	android/view/KeyEvent:getSource	()I
    //   783: sipush 257
    //   786: if_icmpne +54 -> 840
    //   789: iload 5
    //   791: istore 4
    //   793: iload_1
    //   794: tableswitch	default:+30 -> 824, 19:+33->827, 20:+33->827, 21:+33->827, 22:+33->827
    //   825: istore 4
    //   827: iload 4
    //   829: ifeq +11 -> 840
    //   832: ldc_w 534
    //   835: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: iconst_m1
    //   839: ireturn
    //   840: aload_0
    //   841: getfield 548	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:QGz	Z
    //   844: ifeq +18 -> 862
    //   847: iload_1
    //   848: invokestatic 546	android/view/KeyEvent:isModifierKey	(I)Z
    //   851: ifne +11 -> 862
    //   854: ldc_w 534
    //   857: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   860: iconst_m1
    //   861: ireturn
    //   862: ldc_w 534
    //   865: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: iconst_0
    //   869: ireturn
    //   870: iconst_1
    //   871: istore 4
    //   873: goto -278 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	CustomTextView
    //   0	876	1	paramInt	int
    //   0	876	2	paramKeyEvent1	KeyEvent
    //   0	876	3	paramKeyEvent2	KeyEvent
    //   593	279	4	i	int
    //   1	789	5	j	int
    //   182	524	6	bool	boolean
    //   645	1	7	localAbstractMethodError	AbstractMethodError
    // Exception table:
    //   from	to	target	type
    //   157	184	645	java/lang/AbstractMethodError
    //   157	184	657	finally
    //   688	705	772	java/lang/AbstractMethodError
  }
  
  private int a(Layout paramLayout)
  {
    AppMethodBeat.i(205705);
    if (paramLayout == this.QGF) {}
    for (int i = getCompoundPaddingTop() + getCompoundPaddingBottom();; i = getExtendedPaddingTop() + getExtendedPaddingBottom())
    {
      int j = getMeasuredHeight();
      AppMethodBeat.o(205705);
      return j - i;
    }
  }
  
  private int a(Layout paramLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(205756);
    if (paramLayout == null)
    {
      AppMethodBeat.o(205756);
      return 0;
    }
    int i = paramLayout.getHeight();
    b localb = this.QGA;
    int j = i;
    if (localb != null) {
      j = Math.max(Math.max(i, localb.OWk), localb.OWl);
    }
    i = paramLayout.getLineCount();
    int k = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + k;
    k = j + m;
    if (this.OVx != 1)
    {
      k = Math.min(k, this.OVw);
      j = i;
      i = k;
    }
    for (;;)
    {
      if (this.OVz == 1)
      {
        k = i;
        if (j < this.OVy) {
          k = getLineHeight();
        }
      }
      for (k = i + (this.OVy - j) * k;; k = Math.max(i, this.OVy))
      {
        i = Math.max(k, getSuggestedMinimumHeight());
        AppMethodBeat.o(205756);
        return i;
        if ((!paramBoolean) || (i <= this.OVw) || ((!(paramLayout instanceof DynamicLayout)) && (!(paramLayout instanceof BoringLayout)))) {
          break label256;
        }
        j = paramLayout.getLineTop(this.OVw);
        i = j;
        if (localb != null) {
          i = Math.max(Math.max(j, localb.OWk), localb.OWl);
        }
        j = this.OVw;
        i += m;
        break;
      }
      label256:
      j = i;
      i = k;
    }
  }
  
  private Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
  {
    AppMethodBeat.i(205751);
    CharSequence localCharSequence = null;
    if (gZv())
    {
      localObject = this.mText;
      localCharSequence = this.OVq;
      TextPaint localTextPaint = this.ayn;
      float f1 = this.OVu;
      float f2 = this.OVv;
      paramBoolean2 = this.OVD;
      if (getKeyListener() == null) {}
      for (paramMetrics = paramTruncateAt;; paramMetrics = null)
      {
        paramMetrics = new DynamicLayout((CharSequence)localObject, localCharSequence, localTextPaint, paramInt1, paramAlignment, f1, f2, paramBoolean2, paramMetrics, paramInt2);
        localObject = paramMetrics;
        if (paramMetrics == null)
        {
          paramMetrics = this.OVq;
          int i = this.OVq.length();
          localObject = this.ayn;
          f1 = this.OVu;
          f2 = this.OVv;
          paramBoolean2 = this.OVD;
          if (!paramBoolean1) {
            break;
          }
          label139:
          if (!paramBoolean1) {
            break label459;
          }
          label144:
          localObject = new StaticLayout(paramMetrics, 0, i, (TextPaint)localObject, paramInt1, paramAlignment, f1, f2, paramBoolean2, paramTruncateAt, paramInt2);
        }
        AppMethodBeat.o(205751);
        return localObject;
      }
    }
    if (paramMetrics == OVU)
    {
      paramMetrics = BoringLayout.isBoring(this.OVq, this.ayn, this.QGZ);
      localObject = paramMetrics;
      if (paramMetrics != null) {
        this.QGZ = paramMetrics;
      }
    }
    for (Object localObject = paramMetrics;; localObject = paramMetrics)
    {
      paramMetrics = localCharSequence;
      if (localObject == null) {
        break;
      }
      if ((((BoringLayout.Metrics)localObject).width <= paramInt1) && ((paramTruncateAt == null) || (((BoringLayout.Metrics)localObject).width <= paramInt2))) {
        if ((paramBoolean2) && (this.OVE != null)) {
          paramMetrics = this.OVE.replaceOrMake(this.OVq, this.ayn, paramInt1, paramAlignment, this.OVu, this.OVv, (BoringLayout.Metrics)localObject, this.OVD);
        }
      }
      for (;;)
      {
        if (paramBoolean2)
        {
          this.OVE = ((BoringLayout)paramMetrics);
          break;
          paramMetrics = BoringLayout.make(this.OVq, this.ayn, paramInt1, paramAlignment, this.OVu, this.OVv, (BoringLayout.Metrics)localObject, this.OVD);
          continue;
          paramMetrics = localCharSequence;
          if (!paramBoolean1) {
            break;
          }
          paramMetrics = localCharSequence;
          if (((BoringLayout.Metrics)localObject).width > paramInt1) {
            break;
          }
          if ((paramBoolean2) && (this.OVE != null))
          {
            paramMetrics = this.OVE.replaceOrMake(this.OVq, this.ayn, paramInt1, paramAlignment, this.OVu, this.OVv, (BoringLayout.Metrics)localObject, this.OVD, paramTruncateAt, paramInt2);
            break;
          }
          paramMetrics = BoringLayout.make(this.OVq, this.ayn, paramInt1, paramAlignment, this.OVu, this.OVv, (BoringLayout.Metrics)localObject, this.OVD, paramTruncateAt, paramInt2);
          break;
          paramTruncateAt = null;
          break label139;
          label459:
          paramInt2 = 0;
          break label144;
        }
      }
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, BoringLayout.Metrics paramMetrics1, BoringLayout.Metrics paramMetrics2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(205749);
    this.QGU = this.OVw;
    this.QGV = this.OVx;
    this.QHh = true;
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    label145:
    label175:
    label313:
    label462:
    label468:
    label612:
    label617:
    for (;;)
    {
      int i = paramInt2;
      if (paramInt2 < 0) {
        i = 0;
      }
      Layout.Alignment localAlignment = getLayoutAlignment();
      if ((this.OSP) && (this.OVt != null) && ((localAlignment == Layout.Alignment.ALIGN_NORMAL) || (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)))
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label635;
        }
      }
      label112:
      label369:
      label629:
      label635:
      for (int j = this.OVt.getParagraphDirection(0);; j = 0)
      {
        boolean bool1;
        TextUtils.TruncateAt localTruncateAt;
        boolean bool2;
        int k;
        if ((this.OVp != null) && (getKeyListener() == null))
        {
          bool1 = true;
          localTruncateAt = this.OVp;
          if (this.Om == null) {
            this.Om = getTextDirectionHeuristic();
          }
          if (localTruncateAt != this.OVp) {
            break label462;
          }
          bool2 = true;
          this.OVt = a(paramInt1, paramMetrics1, paramInt3, localAlignment, bool1, localTruncateAt, bool2);
          if (this.OVp == null) {
            break label468;
          }
          k = 1;
          this.QGF = null;
          if (this.QGE != null) {
            if (k == 0) {
              break label629;
            }
          }
        }
        for (;;)
        {
          if (paramMetrics2 == OVU)
          {
            paramMetrics2 = BoringLayout.isBoring(this.QGE, this.ayn, this.QHa);
            paramMetrics1 = paramMetrics2;
            if (paramMetrics2 != null) {
              this.QHa = paramMetrics2;
            }
          }
          for (paramMetrics1 = paramMetrics2;; paramMetrics1 = paramMetrics2)
          {
            TextPaint localTextPaint;
            float f1;
            float f2;
            if (paramMetrics1 != null)
            {
              if ((paramMetrics1.width > paramInt1) || ((k != 0) && (paramMetrics1.width > paramInt3))) {
                break label508;
              }
              if (this.QHb != null)
              {
                this.QGF = this.QHb.replaceOrMake(this.QGE, this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, paramMetrics1, this.OVD);
                this.QHb = ((BoringLayout)this.QGF);
              }
            }
            else if (this.QGF == null)
            {
              paramMetrics2 = this.QGE;
              i = this.QGE.length();
              localTextPaint = this.ayn;
              f1 = this.OVu;
              f2 = this.OVv;
              bool1 = this.OVD;
              if (k == 0) {
                break label612;
              }
              paramMetrics1 = localTruncateAt;
              if (k == 0) {
                break label617;
              }
            }
            for (;;)
            {
              this.QGF = new StaticLayout(paramMetrics2, 0, i, localTextPaint, paramInt1, localAlignment, f1, f2, bool1, paramMetrics1, paramInt3);
              if ((paramBoolean) || ((paramInt2 != 0) && (j != this.OVt.getParagraphDirection(0)))) {
                gZt();
              }
              if (this.QHs != null) {
                this.QHs.gZP();
              }
              AppMethodBeat.o(205749);
              return;
              paramInt2 = 0;
              break;
              bool1 = false;
              break label112;
              bool2 = false;
              break label145;
              k = 0;
              break label175;
              this.QGF = BoringLayout.make(this.QGE, this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, paramMetrics1, this.OVD);
              break label302;
              label508:
              if ((k == 0) || (paramMetrics1.width > paramInt1)) {
                break label313;
              }
              if (this.QHb != null)
              {
                this.QGF = this.QHb.replaceOrMake(this.QGE, this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, paramMetrics1, this.OVD, this.OVp, paramInt3);
                break label313;
              }
              this.QGF = BoringLayout.make(this.QGE, this.ayn, paramInt1, localAlignment, this.OVu, this.OVv, paramMetrics1, this.OVD, this.OVp, paramInt3);
              break label313;
              paramMetrics1 = null;
              break label369;
              paramInt3 = 0;
            }
          }
          paramInt1 = i;
        }
      }
    }
  }
  
  private <T> void a(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    AppMethodBeat.i(205780);
    if (!(this.mText instanceof Editable))
    {
      AppMethodBeat.o(205780);
      return;
    }
    Editable localEditable = (Editable)this.mText;
    paramClass = localEditable.getSpans(paramInt1, paramInt2, paramClass);
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      int k = localEditable.getSpanStart(paramClass[i]);
      if ((localEditable.getSpanEnd(paramClass[i]) == paramInt1) || (k == paramInt2)) {
        break;
      }
      localEditable.removeSpan(paramClass[i]);
      i += 1;
    }
    AppMethodBeat.o(205780);
  }
  
  private static void a(Context paramContext, TypedArray paramTypedArray, d paramd)
  {
    AppMethodBeat.i(205624);
    if (paramTypedArray == null)
    {
      AppMethodBeat.o(205624);
      return;
    }
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    int k;
    int m;
    if (i < j)
    {
      k = paramTypedArray.getIndex(i);
      m = QHw.get(k, -1);
      if (m != -1)
      {
        if (m != 5) {
          break label82;
        }
        paramd.QHX = paramTypedArray.getColor(k, paramd.QHX);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label82:
      if (m == 4)
      {
        paramd.BpJ = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == 6)
      {
        paramd.QHY = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == 7)
      {
        paramd.QHZ = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == 1)
      {
        paramd.mAk = paramTypedArray.getDimensionPixelSize(k, paramd.mAk);
        if (Build.VERSION.SDK_INT < 22) {
          continue;
        }
        paramd.QGM = paramTypedArray.peekValue(k).getComplexUnit();
        continue;
      }
      if (m == 89)
      {
        Object localObject = paramTypedArray.getString(k);
        if ((localObject == null) || (Build.VERSION.SDK_INT < 24)) {
          continue;
        }
        localObject = LocaleList.forLanguageTags((String)localObject);
        if (((LocaleList)localObject).isEmpty()) {
          continue;
        }
        paramd.QIa = ((LocaleList)localObject);
        continue;
      }
      if (m == 2)
      {
        paramd.QIc = paramTypedArray.getInt(k, paramd.QIc);
        if ((paramd.QIc == -1) || (paramd.QIb)) {
          continue;
        }
        paramd.lal = null;
        continue;
      }
      if ((m != 68) || (!paramContext.isRestricted())) {}
      try
      {
        if (Build.VERSION.SDK_INT >= 26) {
          paramd.alr = paramTypedArray.getFont(k);
        }
        label312:
        if (paramd.alr == null) {
          paramd.lal = paramTypedArray.getString(k);
        }
        paramd.QIb = true;
        continue;
        if (m == 3)
        {
          paramd.QId = paramTypedArray.getInt(k, paramd.QId);
          continue;
        }
        if (m == 88)
        {
          paramd.QIe = paramTypedArray.getInt(k, paramd.QIe);
          continue;
        }
        if (m == 65)
        {
          paramd.QIf = paramTypedArray.getBoolean(k, paramd.QIf);
          continue;
        }
        if (m == 34)
        {
          paramd.nYW = paramTypedArray.getInt(k, paramd.nYW);
          continue;
        }
        if (m == 35)
        {
          paramd.QGs = paramTypedArray.getFloat(k, paramd.QGs);
          continue;
        }
        if (m == 36)
        {
          paramd.QGt = paramTypedArray.getFloat(k, paramd.QGt);
          continue;
        }
        if (m == 37)
        {
          paramd.QGr = paramTypedArray.getFloat(k, paramd.QGr);
          continue;
        }
        if (m == 69)
        {
          paramd.QIg = true;
          paramd.QIh = paramTypedArray.getBoolean(k, paramd.QIh);
          continue;
        }
        if (m == 84)
        {
          paramd.QIi = true;
          paramd.QIj = paramTypedArray.getBoolean(k, paramd.QIj);
          continue;
        }
        if (m == 70)
        {
          paramd.QIk = true;
          paramd.QIl = paramTypedArray.getFloat(k, paramd.QIl);
          continue;
        }
        if (m == 71)
        {
          paramd.QIm = paramTypedArray.getString(k);
          continue;
        }
        if (m != 83) {
          continue;
        }
        paramd.QIn = paramTypedArray.getString(k);
        continue;
        AppMethodBeat.o(205624);
        return;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        break label312;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label312;
      }
    }
  }
  
  @SuppressLint({"Range"})
  private void a(Typeface paramTypeface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205575);
    if (paramInt2 >= 0) {
      Math.min(1000, paramInt2);
    }
    setTypeface(paramTypeface, paramInt1);
    AppMethodBeat.o(205575);
  }
  
  private void a(Typeface paramTypeface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205574);
    if ((paramTypeface == null) && (paramString != null))
    {
      a(Typeface.create(paramString, 0), paramInt2, paramInt3);
      AppMethodBeat.o(205574);
      return;
    }
    if (paramTypeface != null)
    {
      a(paramTypeface, paramInt2, paramInt3);
      AppMethodBeat.o(205574);
      return;
    }
    switch (paramInt1)
    {
    default: 
      a(null, paramInt2, paramInt3);
      AppMethodBeat.o(205574);
      return;
    case 1: 
      a(Typeface.SANS_SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(205574);
      return;
    case 2: 
      a(Typeface.SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(205574);
      return;
    }
    a(Typeface.MONOSPACE, paramInt2, paramInt3);
    AppMethodBeat.o(205574);
  }
  
  private void a(Editable paramEditable, InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(205704);
    boolean bool;
    if (this.QHs != null)
    {
      bool = this.QHs.QIH instanceof InputFilter;
      if (!bool) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      if (i > 0)
      {
        InputFilter[] arrayOfInputFilter = new InputFilter[paramArrayOfInputFilter.length + 1];
        System.arraycopy(paramArrayOfInputFilter, 0, arrayOfInputFilter, 0, paramArrayOfInputFilter.length);
        if (bool) {
          arrayOfInputFilter[(paramArrayOfInputFilter.length + 0)] = ((InputFilter)this.QHs.QIH);
        }
        paramEditable.setFilters(arrayOfInputFilter);
        AppMethodBeat.o(205704);
        return;
      }
      paramEditable.setFilters(paramArrayOfInputFilter);
      AppMethodBeat.o(205704);
      return;
    }
  }
  
  private void a(CursorAnchorInfo.Builder paramBuilder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205823);
    int k = this.OVt.getLineForOffset(paramInt1);
    int i2 = this.OVt.getLineForOffset(paramInt2 - 1);
    while (k <= i2)
    {
      int j = this.OVt.getLineStart(k);
      int i = this.OVt.getLineEnd(k);
      int i1 = Math.max(j, paramInt1);
      int i3 = Math.min(i, paramInt2);
      int m;
      float f4;
      float f5;
      int n;
      label147:
      float f3;
      boolean bool1;
      float f1;
      float f2;
      if (this.OVt.getParagraphDirection(k) == 1)
      {
        m = 1;
        float[] arrayOfFloat = new float[i3 - i1];
        this.OVt.getPaint().getTextWidths(this.OVq, i1, i3, arrayOfFloat);
        f4 = this.OVt.getLineTop(k);
        f5 = this.OVt.getLineBottom(k);
        n = i1;
        if (n >= i3) {
          break label404;
        }
        f3 = arrayOfFloat[(n - i1)];
        bool1 = this.OVt.isRtlCharAt(n);
        f1 = this.OVt.getPrimaryHorizontal(n);
        f2 = this.OVt.getSecondaryHorizontal(n);
        if (m == 0) {
          break label367;
        }
        if (!bool1) {
          break label345;
        }
        f1 = f2 - f3;
      }
      for (;;)
      {
        f1 += paramFloat1;
        f2 += paramFloat1;
        f3 = f4 + paramFloat2;
        float f6 = f5 + paramFloat2;
        boolean bool2 = ay(f1, f3);
        boolean bool3 = ay(f2, f6);
        j = 0;
        if ((bool2) || (bool3)) {
          j = 1;
        }
        if (bool2)
        {
          i = j;
          if (bool3) {}
        }
        else
        {
          i = j | 0x2;
        }
        j = i;
        if (bool1) {
          j = i | 0x4;
        }
        paramBuilder.addCharacterBounds(n, f1, f3, f2, f6, j);
        n += 1;
        break label147;
        m = 0;
        break;
        label345:
        f2 = f1;
        f3 = f1 + f3;
        f1 = f2;
        f2 = f3;
        continue;
        label367:
        if (!bool1)
        {
          f1 = f2;
          f2 += f3;
        }
        else
        {
          f3 = f1 - f3;
          f2 = f1;
          f1 = f3;
        }
      }
      label404:
      k += 1;
    }
    AppMethodBeat.o(205823);
  }
  
  private void a(InputMethodManager paramInputMethodManager)
  {
    AppMethodBeat.i(205851);
    if (paramInputMethodManager != null) {
      paramInputMethodManager.viewClicked(this);
    }
    AppMethodBeat.o(205851);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205779);
    Object localObject;
    if (this.mListeners != null)
    {
      localObject = this.mListeners;
      int j = ((ArrayList)localObject).size();
      int i = 0;
      while (i < j)
      {
        ((TextWatcher)((ArrayList)localObject).get(i)).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
    paramCharSequence = null;
    try
    {
      localObject = Class.forName("android.text.style.SpellCheckSpan");
      paramCharSequence = (CharSequence)localObject;
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    if (paramCharSequence != null) {
      a(paramInt1, paramInt1 + paramInt2, paramCharSequence);
    }
    a(paramInt1, paramInt1 + paramInt2, SuggestionSpan.class);
    AppMethodBeat.o(205779);
  }
  
  private boolean a(ClipData paramClipData)
  {
    AppMethodBeat.i(205843);
    ClipboardManager localClipboardManager = getClipboardManagerForUser();
    try
    {
      localClipboardManager.setPrimaryClip(paramClipData);
      QGm = SystemClock.uptimeMillis();
      AppMethodBeat.o(205843);
      return true;
    }
    catch (Throwable paramClipData)
    {
      AppMethodBeat.o(205843);
    }
    return false;
  }
  
  private void aV(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205709);
    if ((paramInt1 >= 0) || (paramInt2 >= 0) || (paramInt3 >= 0)) {
      lz(Math.min(Math.min(paramInt1, paramInt2), paramInt3), Math.max(Math.max(paramInt1, paramInt2), paramInt3));
    }
    AppMethodBeat.o(205709);
  }
  
  private static boolean aox(int paramInt)
  {
    return (0x2000F & paramInt) == 131073;
  }
  
  private static boolean aoy(int paramInt)
  {
    paramInt &= 0xFFF;
    return (paramInt == 129) || (paramInt == 225) || (paramInt == 18);
  }
  
  private static boolean aoz(int paramInt)
  {
    return (paramInt & 0xFFF) == 145;
  }
  
  private float ax(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205801);
    int i = getHorizontalFadingEdgeLength();
    if (i == 0)
    {
      AppMethodBeat.o(205801);
      return 0.0F;
    }
    paramFloat1 = Math.abs(paramFloat1 - paramFloat2);
    if (paramFloat1 > i)
    {
      AppMethodBeat.o(205801);
      return 1.0F;
    }
    paramFloat1 /= i;
    AppMethodBeat.o(205801);
    return paramFloat1;
  }
  
  private CharSequence ax(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(205691);
    if ((paramCharSequence instanceof Spanned))
    {
      if ((paramCharSequence instanceof Spannable)) {}
      SuggestionSpan[] arrayOfSuggestionSpan;
      for (Spannable localSpannable = (Spannable)paramCharSequence;; localSpannable = this.OVo.newSpannable(paramCharSequence))
      {
        arrayOfSuggestionSpan = (SuggestionSpan[])localSpannable.getSpans(0, paramCharSequence.length(), SuggestionSpan.class);
        if (arrayOfSuggestionSpan.length != 0) {
          break;
        }
        AppMethodBeat.o(205691);
        return paramCharSequence;
      }
      for (;;)
      {
        paramCharSequence = localSpannable;
        if (i >= arrayOfSuggestionSpan.length) {
          break;
        }
        localSpannable.removeSpan(arrayOfSuggestionSpan[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(205691);
    return paramCharSequence;
  }
  
  private static int b(Layout paramLayout)
  {
    int k = 0;
    AppMethodBeat.i(205752);
    int m = paramLayout.getLineCount();
    CharSequence localCharSequence = paramLayout.getText();
    float f2 = 0.0F;
    int i = 0;
    int j;
    float f1;
    for (;;)
    {
      j = k;
      f1 = f2;
      if (i >= m - 1) {
        break;
      }
      if (localCharSequence.charAt(paramLayout.getLineEnd(i) - 1) != '\n')
      {
        AppMethodBeat.o(205752);
        return -1;
      }
      i += 1;
    }
    while (j < m)
    {
      f1 = Math.max(f1, paramLayout.getLineWidth(j));
      j += 1;
    }
    i = (int)Math.ceil(f1);
    AppMethodBeat.o(205752);
    return i;
  }
  
  private void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205781);
    if (this.mListeners != null)
    {
      ArrayList localArrayList = this.mListeners;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((TextWatcher)localArrayList.get(i)).onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
    if (this.QHs != null) {
      this.QHs.hab();
    }
    AppMethodBeat.o(205781);
  }
  
  private void bO(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(205695);
    int i = paramInt & 0xF;
    Object localObject1 = null;
    boolean bool1;
    if (i == 1)
    {
      if ((0x8000 & paramInt) != 0)
      {
        bool1 = true;
        if ((paramInt & 0x1000) == 0) {
          break label95;
        }
        localObject1 = TextKeyListener.Capitalize.CHARACTERS;
      }
      for (;;)
      {
        localObject1 = TextKeyListener.getInstance(bool1, (TextKeyListener.Capitalize)localObject1);
        setRawInputType(paramInt);
        this.QGN = false;
        if (!paramBoolean) {
          break label386;
        }
        gZL();
        this.QHs.QIH = ((KeyListener)localObject1);
        AppMethodBeat.o(205695);
        return;
        bool1 = false;
        break;
        label95:
        if ((paramInt & 0x2000) != 0) {
          localObject1 = TextKeyListener.Capitalize.WORDS;
        } else if ((paramInt & 0x4000) != 0) {
          localObject1 = TextKeyListener.Capitalize.SENTENCES;
        } else {
          localObject1 = TextKeyListener.Capitalize.NONE;
        }
      }
    }
    Object localObject2;
    if (i == 2)
    {
      localObject2 = getCustomLocaleForKeyListenerOrNull();
      if (Build.VERSION.SDK_INT >= 26)
      {
        if ((paramInt & 0x1000) == 0) {
          break label233;
        }
        bool1 = true;
        label165:
        if ((paramInt & 0x2000) == 0) {
          break label239;
        }
      }
      for (;;)
      {
        localObject1 = DigitsKeyListener.getInstance((Locale)localObject2, bool1, bool2);
        i = paramInt;
        if (localObject2 != null)
        {
          int j = ((KeyListener)localObject1).getInputType();
          i = paramInt;
          if ((j & 0xF) != 2)
          {
            i = j;
            if ((paramInt & 0x10) != 0) {
              i = j | 0x80;
            }
          }
        }
        paramInt = i;
        break;
        label233:
        bool1 = false;
        break label165;
        label239:
        bool2 = false;
      }
    }
    if (i == 4)
    {
      localObject1 = getCustomLocaleForKeyListenerOrNull();
      switch (paramInt & 0xFF0)
      {
      default: 
        if (Build.VERSION.SDK_INT >= 26) {
          localObject2 = DateTimeKeyListener.getInstance((Locale)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (!this.QGO) {
        break;
      }
      paramInt = ((KeyListener)localObject2).getInputType();
      localObject1 = localObject2;
      break;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject2 = DateKeyListener.getInstance((Locale)localObject1);
        continue;
        if (Build.VERSION.SDK_INT >= 26)
        {
          localObject2 = TimeKeyListener.getInstance((Locale)localObject1);
          continue;
          if (i == 3)
          {
            localObject1 = DialerKeyListener.getInstance();
            break;
          }
          localObject1 = TextKeyListener.getInstance();
          break;
          label386:
          setKeyListenerOnly((KeyListener)localObject1);
          AppMethodBeat.o(205695);
          return;
        }
      }
      localObject2 = null;
    }
  }
  
  private <T> T bj(Class<T> paramClass)
  {
    AppMethodBeat.i(205814);
    if ((this.QHd == null) && (Build.VERSION.SDK_INT >= 23))
    {
      paramClass = getContext().getSystemService(paramClass);
      AppMethodBeat.o(205814);
      return paramClass;
    }
    AppMethodBeat.o(205814);
    return null;
  }
  
  private boolean bringPointIntoView(int paramInt)
  {
    AppMethodBeat.i(205761);
    if (isLayoutRequested())
    {
      this.QGY = paramInt;
      AppMethodBeat.o(205761);
      return false;
    }
    if (gZx()) {}
    for (Layout localLayout = this.QGF; localLayout == null; localLayout = this.OVt)
    {
      AppMethodBeat.o(205761);
      return false;
    }
    int i3 = localLayout.getLineForOffset(paramInt);
    int j;
    int i4;
    int i5;
    int i6;
    int i;
    int i8;
    int i7;
    int i9;
    int m;
    switch (5.bDD[localLayout.getParagraphAlignment(i3).ordinal()])
    {
    default: 
      j = 0;
      i4 = (int)localLayout.getPrimaryHorizontal(paramInt);
      i5 = localLayout.getLineTop(i3);
      i6 = localLayout.getLineTop(i3 + 1);
      i = (int)Math.floor(localLayout.getLineLeft(i3));
      paramInt = (int)Math.ceil(localLayout.getLineRight(i3));
      i8 = localLayout.getHeight();
      i7 = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight();
      i9 = getBottom() - getTop() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      m = paramInt;
      if (!this.QGQ)
      {
        m = paramInt;
        if (paramInt - i > i7)
        {
          m = paramInt;
          if (paramInt > i4) {
            m = Math.max(i4, i + i7);
          }
        }
      }
      paramInt = (i6 - i5) / 2;
      if (paramInt <= i9 / 4) {
        break;
      }
    }
    for (int k = i9 / 4;; k = paramInt)
    {
      int i1 = paramInt;
      if (paramInt > i7 / 4) {
        i1 = i7 / 4;
      }
      int i2 = getScrollX();
      int n = getScrollY();
      paramInt = n;
      if (i5 - n < k) {
        paramInt = i5 - k;
      }
      if (i6 - paramInt > i9 - k) {
        paramInt = i6 - (i9 - k);
      }
      for (;;)
      {
        k = paramInt;
        if (i8 - paramInt < i9) {
          k = i8 - i9;
        }
        if (0 - k > 0) {}
        for (n = 0;; n = k)
        {
          if (j != 0) {
            if (i4 - i2 < i1)
            {
              k = i4 - i1;
              label392:
              paramInt = k;
              if (i4 - k <= i7 - i1) {}
            }
          }
          for (paramInt = i4 - (i7 - i1);; paramInt = i2)
          {
            if (j < 0) {
              if (i - paramInt <= 0) {
                break label882;
              }
            }
            for (;;)
            {
              paramInt = i;
              if (m - i < i7) {
                paramInt = m - i7;
              }
              boolean bool1;
              if ((paramInt != getScrollX()) || (n != getScrollY())) {
                if (this.mScroller == null)
                {
                  scrollTo(paramInt, n);
                  bool1 = true;
                  label478:
                  boolean bool2 = bool1;
                  if (isFocused())
                  {
                    if (this.mTempRect == null) {
                      this.mTempRect = new Rect();
                    }
                    this.mTempRect.set(i4 - 2, i5, i4 + 2, i6);
                    c(this.mTempRect, i3);
                    this.mTempRect.offset(getScrollX(), getScrollY());
                    bool2 = bool1;
                    if (requestRectangleOnScreen(this.mTempRect)) {
                      bool2 = true;
                    }
                  }
                  AppMethodBeat.o(205761);
                  return bool2;
                  j = localLayout.getParagraphDirection(i3);
                  break;
                  j = -localLayout.getParagraphDirection(i3);
                  break;
                  if (j > 0) {
                    if (m - paramInt >= i7) {
                      break label877;
                    }
                  }
                }
              }
              label877:
              for (j = m - i7;; j = paramInt)
              {
                paramInt = j;
                if (i - j <= 0) {
                  break;
                }
                paramInt = i;
                break;
                if (m - i <= i7)
                {
                  paramInt = i - (i7 - (m - i)) / 2;
                  break;
                }
                if (i4 > m - i1)
                {
                  paramInt = m - i7;
                  break;
                }
                if (i4 < i + i1)
                {
                  paramInt = i;
                  break;
                }
                if (i > paramInt)
                {
                  paramInt = i;
                  break;
                }
                if (m < paramInt + i7)
                {
                  paramInt = m - i7;
                  break;
                }
                if (i4 - paramInt < i1) {}
                for (i = i4 - i1;; i = paramInt)
                {
                  paramInt = i;
                  if (i4 - i <= i7 - i1) {
                    break;
                  }
                  paramInt = i4 - (i7 - i1);
                  break;
                  long l1 = AnimationUtils.currentAnimationTimeMillis();
                  long l2 = this.UC;
                  paramInt -= getScrollX();
                  i = n - getScrollY();
                  if (l1 - l2 > 250L)
                  {
                    this.mScroller.startScroll(getScrollX(), getScrollY(), paramInt, i);
                    awakenScrollBars(this.mScroller.getDuration());
                    invalidate();
                  }
                  for (;;)
                  {
                    this.UC = AnimationUtils.currentAnimationTimeMillis();
                    break;
                    if (!this.mScroller.isFinished()) {
                      this.mScroller.abortAnimation();
                    }
                    scrollBy(paramInt, i);
                  }
                  bool1 = false;
                  break label478;
                }
              }
              label882:
              i = paramInt;
            }
            k = i2;
            break label392;
          }
        }
      }
    }
  }
  
  private void c(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(205763);
    s(paramRect);
    if (paramInt == 0) {
      paramRect.top -= getExtendedPaddingTop();
    }
    if (paramInt == this.OVt.getLineCount() - 1) {
      paramRect.bottom += getExtendedPaddingBottom();
    }
    AppMethodBeat.o(205763);
  }
  
  private void gLr()
  {
    AppMethodBeat.i(205746);
    if (((this.OVt instanceof BoringLayout)) && (this.OVE == null)) {
      this.OVE = ((BoringLayout)this.OVt);
    }
    if (((this.QGF instanceof BoringLayout)) && (this.QHb == null)) {
      this.QHb = ((BoringLayout)this.QGF);
    }
    this.QHa = null;
    this.QGZ = null;
    if (this.QHs != null) {
      this.QHs.gZP();
    }
    AppMethodBeat.o(205746);
  }
  
  private void gLs()
  {
    AppMethodBeat.i(205747);
    int j = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    if (this.QGQ) {}
    for (j = 1048576;; j = i)
    {
      BoringLayout.Metrics localMetrics = OVU;
      a(j, i, localMetrics, localMetrics, i, false);
      AppMethodBeat.o(205747);
      return;
    }
  }
  
  private void gZL()
  {
    AppMethodBeat.i(205853);
    if (this.QHs == null) {
      this.QHs = new b(this);
    }
    AppMethodBeat.o(205853);
  }
  
  private void gZM()
  {
    AppMethodBeat.i(205854);
    if (!(this.mText instanceof Spannable)) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(205854);
  }
  
  private void gZo()
  {
    AppMethodBeat.i(205581);
    try
    {
      this.QHs.Clf = this.QHs.QIH.getInputType();
      setInputTypeSingleLine(this.OSP);
      AppMethodBeat.o(205581);
      return;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      for (;;)
      {
        this.QHs.Clf = 1;
      }
    }
  }
  
  private void gZp()
  {
    AppMethodBeat.i(205584);
    if ((this.QGG != null) || ((this.QHs != null) && (this.QHs.QIH != null)))
    {
      setFocusable(true);
      setClickable(true);
      setLongClickable(true);
      AppMethodBeat.o(205584);
      return;
    }
    setClickable(false);
    setLongClickable(false);
    AppMethodBeat.o(205584);
  }
  
  private void gZq()
  {
    AppMethodBeat.i(205605);
    if (this.QGA == null)
    {
      AppMethodBeat.o(205605);
      return;
    }
    if ((this.QGA.QHG) || (this.QGA.acU))
    {
      ColorStateList localColorStateList = this.QGA.Kr;
      boolean bool = this.QGA.QHG;
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.QGA.QHE;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if ((localDrawable != null) && (localDrawable != this.QGA.QHJ))
        {
          localDrawable.mutate();
          if (bool) {
            localDrawable.setTintList(localColorStateList);
          }
          if (localDrawable.isStateful()) {
            localDrawable.setState(arrayOfInt);
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(205605);
  }
  
  private void gZt()
  {
    AppMethodBeat.i(205711);
    if (!this.QGu)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.QGu = true;
    }
    AppMethodBeat.o(205711);
  }
  
  private boolean gZu()
  {
    AppMethodBeat.i(205736);
    if (getKeyListener() == null)
    {
      AppMethodBeat.o(205736);
      return false;
    }
    if (this.OSP)
    {
      AppMethodBeat.o(205736);
      return true;
    }
    if ((this.QHs != null) && ((this.QHs.Clf & 0xF) == 1))
    {
      int i = this.QHs.Clf & 0xFF0;
      if ((i == 32) || (i == 48))
      {
        AppMethodBeat.o(205736);
        return true;
      }
    }
    AppMethodBeat.o(205736);
    return false;
  }
  
  private boolean gZv()
  {
    AppMethodBeat.i(205750);
    if ((isTextSelectable()) || (this.QGC != null))
    {
      AppMethodBeat.o(205750);
      return true;
    }
    AppMethodBeat.o(205750);
    return false;
  }
  
  private void gZw()
  {
    int k = 1;
    AppMethodBeat.i(205757);
    int i = 0;
    int j = 0;
    if (this.OVt != null)
    {
      if (getLayoutParams().width == -2)
      {
        invalidate();
        j = 1;
      }
      if (getLayoutParams().height != -2) {
        break label77;
      }
      if (getDesiredHeight() == getHeight()) {
        break label117;
      }
      i = k;
    }
    for (;;)
    {
      if (i != 0) {
        requestLayout();
      }
      AppMethodBeat.o(205757);
      return;
      label77:
      i = j;
      if (getLayoutParams().height == -1)
      {
        i = j;
        if (this.OVC >= 0)
        {
          i = j;
          if (getDesiredHeight() != this.OVC)
          {
            i = 1;
            continue;
            label117:
            i = j;
          }
        }
      }
    }
  }
  
  private boolean gZx()
  {
    AppMethodBeat.i(205760);
    if ((TextUtils.isEmpty(this.mText)) && (!TextUtils.isEmpty(this.QGE)))
    {
      AppMethodBeat.o(205760);
      return true;
    }
    AppMethodBeat.o(205760);
    return false;
  }
  
  private Locale getCustomLocaleForKeyListenerOrNull()
  {
    AppMethodBeat.i(205694);
    if (!this.QGO)
    {
      AppMethodBeat.o(205694);
      return null;
    }
    Object localObject = getImeHintLocales();
    if (localObject == null)
    {
      AppMethodBeat.o(205694);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = ((LocaleList)localObject).get(0);
      AppMethodBeat.o(205694);
      return localObject;
    }
    AppMethodBeat.o(205694);
    return null;
  }
  
  private int getDesiredHeight()
  {
    boolean bool = true;
    AppMethodBeat.i(205755);
    int i = a(this.OVt, true);
    Layout localLayout = this.QGF;
    if (this.OVp != null) {}
    for (;;)
    {
      i = Math.max(i, a(localLayout, bool));
      AppMethodBeat.o(205755);
      return i;
      bool = false;
    }
  }
  
  private Layout.Alignment getLayoutAlignment()
  {
    AppMethodBeat.i(205748);
    Layout.Alignment localAlignment = null;
    switch (getTextAlignment())
    {
    default: 
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
    }
    for (;;)
    {
      AppMethodBeat.o(205748);
      return localAlignment;
      switch (this.Ku & 0x800007)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        break;
      case 8388611: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        break;
      case 8388613: 
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      case 3: 
        Log.i("cmEdit.CMTextView", "getTextAlignment() Gravity.LEFT");
        break;
      case 5: 
        Log.i("cmEdit.CMTextView", "getTextAlignment() Gravity.RIGHT");
        break;
      case 1: 
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        continue;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        Log.i("cmEdit.CMTextView", "getTextAlignment() TEXT_ALIGNMENT_VIEW_START");
        continue;
        Log.i("cmEdit.CMTextView", "getTextAlignment() TEXT_ALIGNMENT_VIEW_END");
      }
    }
  }
  
  private Path getUpdatedHighlightPath()
  {
    int i = 1;
    AppMethodBeat.i(205726);
    Object localObject2 = null;
    Paint localPaint = this.QHg;
    int j = getSelectionStart();
    int k = getSelectionEnd();
    Object localObject1 = localObject2;
    if (this.QGG != null) {
      if (!isFocused())
      {
        localObject1 = localObject2;
        if (!isPressed()) {}
      }
      else
      {
        localObject1 = localObject2;
        if (j >= 0)
        {
          if (j != k) {
            break label227;
          }
          localObject1 = localObject2;
          if (this.QHs != null)
          {
            localObject1 = this.QHs;
            if (!((b)localObject1).isCursorVisible()) {
              break label222;
            }
            if (!((b)localObject1).QIK) {
              break label202;
            }
            localObject1 = localObject2;
            if (i != 0)
            {
              if (this.QHh)
              {
                if (this.QHf == null) {
                  this.QHf = new Path();
                }
                this.QHf.reset();
                this.OVt.getCursorPath(j, this.QHf, this.mText);
                this.QHs.hah();
                this.QHh = false;
              }
              localPaint.setColor(this.OVm);
              localPaint.setStyle(Paint.Style.STROKE);
            }
          }
        }
      }
    }
    for (localObject1 = this.QHf;; localObject1 = this.QHf)
    {
      AppMethodBeat.o(205726);
      return localObject1;
      label202:
      if ((SystemClock.uptimeMillis() - ((b)localObject1).QIJ) % 1000L < 500L) {
        break;
      }
      label222:
      i = 0;
      break;
      label227:
      if (this.QHh)
      {
        if (this.QHf == null) {
          this.QHf = new Path();
        }
        this.QHf.reset();
        this.OVt.getSelectionPath(j, k, this.QHf);
        this.QHh = false;
      }
      localPaint.setColor(this.oEF);
      localPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private static void h(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(205679);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])paramSpannable.getSpans(0, paramSpannable.length(), SuggestionSpan.class);
    while (i < arrayOfSuggestionSpan.length)
    {
      int j = arrayOfSuggestionSpan[i].getFlags();
      if (((j & 0x1) != 0) && ((j & 0x2) != 0)) {
        paramSpannable.removeSpan(arrayOfSuggestionSpan[i]);
      }
      i += 1;
    }
    AppMethodBeat.o(205679);
  }
  
  private boolean isSuggestionsEnabled()
  {
    if (this.QHs == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (((this.QHs.Clf & 0xF) != 1) || ((this.QHs.Clf & 0x80000) > 0));
      i = this.QHs.Clf & 0xFF0;
    } while ((i != 0) && (i != 48) && (i != 80) && (i != 64) && (i != 160));
    return true;
  }
  
  private void lz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205710);
    if (this.OVt == null)
    {
      invalidate();
      AppMethodBeat.o(205710);
      return;
    }
    int j = this.OVt.getLineForOffset(paramInt1);
    int k = this.OVt.getLineTop(j);
    int i = k;
    if (j > 0) {
      i = k - this.OVt.getLineDescent(j - 1);
    }
    if (paramInt1 == paramInt2)
    {
      paramInt1 = j;
      paramInt2 = this.OVt.getLineBottom(paramInt1);
      if ((this.QHs == null) || (this.QHs.QIY == null)) {
        break label210;
      }
      Rect localRect = this.QHs.QIY.getBounds();
      paramInt1 = Math.min(i, localRect.top);
      paramInt2 = Math.max(paramInt2, localRect.bottom);
    }
    for (;;)
    {
      i = getCompoundPaddingLeft();
      j = getExtendedPaddingTop() + CW(true);
      k = getWidth();
      int m = getCompoundPaddingRight();
      invalidate(i + getScrollX(), paramInt1 + j, k - m + getScrollY(), paramInt2 + j);
      AppMethodBeat.o(205710);
      return;
      paramInt1 = this.OVt.getLineForOffset(paramInt2);
      break;
      label210:
      paramInt1 = i;
    }
  }
  
  private void r(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(205773);
    this.OSP = paramBoolean1;
    if (paramBoolean1)
    {
      setLines(1);
      setHorizontallyScrolling(true);
      if (paramBoolean2)
      {
        setTransformationMethod(SingleLineTransformationMethod.getInstance());
        AppMethodBeat.o(205773);
      }
    }
    else
    {
      if (paramBoolean3) {
        setMaxLines(2147483647);
      }
      setHorizontallyScrolling(false);
      if (paramBoolean2) {
        setTransformationMethod(null);
      }
    }
    AppMethodBeat.o(205773);
  }
  
  private void s(Rect paramRect)
  {
    AppMethodBeat.i(205764);
    int i = gZy();
    paramRect.left += i;
    paramRect.right = (i + paramRect.right);
    i = gZz();
    paramRect.top += i;
    paramRect.bottom = (i + paramRect.bottom);
    AppMethodBeat.o(205764);
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int j = 1;
    AppMethodBeat.i(205600);
    Object localObject2 = this.QGA;
    if (localObject2 != null)
    {
      if (((b)localObject2).QHH != null) {
        ((b)localObject2).QHH.setCallback(null);
      }
      ((b)localObject2).QHH = null;
      if (((b)localObject2).QHI != null) {
        ((b)localObject2).QHI.setCallback(null);
      }
      ((b)localObject2).QHI = null;
      ((b)localObject2).QHQ = 0;
      ((b)localObject2).QHO = 0;
      ((b)localObject2).QHR = 0;
      ((b)localObject2).QHP = 0;
    }
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null) || (paramDrawable3 != null) || (paramDrawable4 != null))
    {
      i = 1;
      if (i != 0) {
        break label338;
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        i = j;
        if (((b)localObject2).OWm == 0)
        {
          i = j;
          if (!((b)localObject2).acU)
          {
            if (!((b)localObject2).QHG) {
              break label221;
            }
            i = j;
          }
        }
        label160:
        if (i != 0) {
          break label227;
        }
        this.QGA = null;
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      if (localObject1 != null)
      {
        ((b)localObject1).QHK = paramDrawable1;
        ((b)localObject1).QHL = paramDrawable3;
      }
      this.QGB = -1;
      gZq();
      invalidate();
      requestLayout();
      AppMethodBeat.o(205600);
      return;
      i = 0;
      break;
      label221:
      i = 0;
      break label160;
      label227:
      i = ((b)localObject2).QHE.length - 1;
      while (i >= 0)
      {
        if (localObject2.QHE[i] != null) {
          localObject2.QHE[i].setCallback(null);
        }
        ((b)localObject2).QHE[i] = null;
        i -= 1;
      }
      ((b)localObject2).OWk = 0;
      ((b)localObject2).OWg = 0;
      ((b)localObject2).OWl = 0;
      ((b)localObject2).OWh = 0;
      ((b)localObject2).OWi = 0;
      ((b)localObject2).OWe = 0;
      label319:
      ((b)localObject2).OWj = 0;
      ((b)localObject2).OWf = 0;
    }
    label338:
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b(getContext());
      this.QGA = ((b)localObject1);
    }
    this.QGA.QHN = false;
    if ((localObject1.QHE[0] != paramDrawable1) && (localObject1.QHE[0] != null)) {
      localObject1.QHE[0].setCallback(null);
    }
    ((b)localObject1).QHE[0] = paramDrawable1;
    if ((localObject1.QHE[1] != paramDrawable2) && (localObject1.QHE[1] != null)) {
      localObject1.QHE[1].setCallback(null);
    }
    ((b)localObject1).QHE[1] = paramDrawable2;
    if ((localObject1.QHE[2] != paramDrawable3) && (localObject1.QHE[2] != null)) {
      localObject1.QHE[2].setCallback(null);
    }
    ((b)localObject1).QHE[2] = paramDrawable3;
    if ((localObject1.QHE[3] != paramDrawable4) && (localObject1.QHE[3] != null)) {
      localObject1.QHE[3].setCallback(null);
    }
    ((b)localObject1).QHE[3] = paramDrawable4;
    Rect localRect = ((b)localObject1).OVZ;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds(localRect);
      paramDrawable1.setCallback(this);
      ((b)localObject1).OWg = localRect.width();
      ((b)localObject1).OWk = localRect.height();
      label591:
      if (paramDrawable3 == null) {
        break label743;
      }
      paramDrawable3.setState(arrayOfInt);
      paramDrawable3.copyBounds(localRect);
      paramDrawable3.setCallback(this);
      ((b)localObject1).OWh = localRect.width();
      ((b)localObject1).OWl = localRect.height();
      label633:
      if (paramDrawable2 == null) {
        break label758;
      }
      paramDrawable2.setState(arrayOfInt);
      paramDrawable2.copyBounds(localRect);
      paramDrawable2.setCallback(this);
      ((b)localObject1).OWe = localRect.height();
      ((b)localObject1).OWi = localRect.width();
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramDrawable4 == null) {
        break label319;
      }
      paramDrawable4.setState(arrayOfInt);
      paramDrawable4.copyBounds(localRect);
      paramDrawable4.setCallback(this);
      ((b)localObject1).OWf = localRect.height();
      ((b)localObject1).OWj = localRect.width();
      break;
      ((b)localObject1).OWk = 0;
      ((b)localObject1).OWg = 0;
      break label591;
      label743:
      ((b)localObject1).OWl = 0;
      ((b)localObject1).OWh = 0;
      break label633;
      label758:
      ((b)localObject1).OWi = 0;
      ((b)localObject1).OWe = 0;
    }
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205689);
    this.QGE = TextUtils.stringOrSpannedString(paramCharSequence);
    if (this.OVt != null) {
      IR();
    }
    if (this.mText.length() == 0) {
      invalidate();
    }
    if (this.QHs != null) {
      this.mText.length();
    }
    AppMethodBeat.o(205689);
  }
  
  private void setInputTypeSingleLine(boolean paramBoolean)
  {
    if ((this.QHs != null) && ((this.QHs.Clf & 0xF) == 1))
    {
      if (paramBoolean)
      {
        localb = this.QHs;
        localb.Clf &= 0xFFFDFFFF;
      }
    }
    else {
      return;
    }
    b localb = this.QHs;
    localb.Clf |= 0x20000;
  }
  
  private void setKeyListenerOnly(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(205582);
    if ((this.QHs == null) && (paramKeyListener == null))
    {
      AppMethodBeat.o(205582);
      return;
    }
    gZL();
    if (this.QHs.QIH != paramKeyListener)
    {
      this.QHs.QIH = paramKeyListener;
      if ((paramKeyListener != null) && (!(this.mText instanceof Editable))) {
        setText(this.mText);
      }
      a((Editable)this.mText, this.QHc);
    }
    AppMethodBeat.o(205582);
  }
  
  private void setRawTextSize$254d549(float paramFloat)
  {
    AppMethodBeat.i(205635);
    if (paramFloat != this.ayn.getTextSize())
    {
      this.ayn.setTextSize(paramFloat);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205635);
  }
  
  private void setTextInternal(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = null)
    {
      this.QGC = paramCharSequence;
      return;
    }
  }
  
  private void setTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(205577);
    if (paramInt > 0)
    {
      int i;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label100;
        }
        i = paramTypeface.getStyle();
        label37:
        paramInt = (i ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.ayn;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.ayn;
        if ((paramInt & 0x2) == 0) {
          break label106;
        }
      }
      label100:
      label106:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        AppMethodBeat.o(205577);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label37;
      }
    }
    this.ayn.setFakeBoldText(false);
    this.ayn.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
    AppMethodBeat.o(205577);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(205675);
    int[] arrayOfInt = getDrawableState();
    int i = this.BpJ.getColorForState(arrayOfInt, 0);
    if (i != this.OVm) {
      this.OVm = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.QGo != null)
      {
        k = this.QGo.getColorForState(arrayOfInt, 0);
        i = j;
        if (k != this.ayn.linkColor)
        {
          this.ayn.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.QGn != null)
      {
        k = this.QGn.getColorForState(arrayOfInt, 0);
        j = i;
        if (k != this.QGp)
        {
          this.QGp = k;
          j = i;
          if (this.mText.length() == 0) {
            j = 1;
          }
        }
      }
      if (j != 0) {
        invalidate();
      }
      AppMethodBeat.o(205675);
      return;
    }
  }
  
  final int B(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205847);
    paramFloat = cy(paramFloat);
    paramInt = getLayout().getOffsetForHorizontal(paramInt, paramFloat);
    AppMethodBeat.o(205847);
    return paramInt;
  }
  
  final int CW(boolean paramBoolean)
  {
    AppMethodBeat.i(205706);
    int j = 0;
    int k = this.Ku & 0x70;
    Layout localLayout2 = this.OVt;
    Layout localLayout1 = localLayout2;
    if (!paramBoolean)
    {
      localLayout1 = localLayout2;
      if (this.mText.length() == 0)
      {
        localLayout1 = localLayout2;
        if (this.QGF != null) {
          localLayout1 = this.QGF;
        }
      }
    }
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = a(localLayout1);
      n = localLayout1.getHeight();
      i = j;
      if (n < m) {
        if (k != 80) {
          break label118;
        }
      }
    }
    label118:
    for (i = m - n;; i = m - n >> 1)
    {
      AppMethodBeat.o(205706);
      return i;
    }
  }
  
  final void a(Spanned paramSpanned, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = -1;
    AppMethodBeat.i(205785);
    b.h localh;
    int j;
    if (this.QHs == null)
    {
      localh = null;
      if (paramObject != Selection.SELECTION_END) {
        break label503;
      }
      if ((paramInt1 >= 0) || (paramInt2 >= 0))
      {
        aV(Selection.getSelectionStart(paramSpanned), paramInt1, paramInt2);
        gZw();
        gZt();
        if (this.QHs != null) {
          this.QHs.haz();
        }
      }
      j = paramInt2;
    }
    for (int i = 1;; i = 0)
    {
      int m = i;
      if (paramObject == Selection.SELECTION_START)
      {
        if ((paramInt1 >= 0) || (paramInt2 >= 0)) {
          aV(Selection.getSelectionEnd(paramSpanned), paramInt1, paramInt2);
        }
        i = paramInt2;
        m = 1;
        k = i;
      }
      if (m != 0)
      {
        this.QHh = true;
        if ((this.QHs != null) && (!isFocused())) {
          this.QHs.QIF = true;
        }
        if ((paramSpanned.getSpanFlags(paramObject) & 0x200) == 0)
        {
          if (k < 0) {
            Selection.getSelectionStart(paramSpanned);
          }
          if (j < 0) {
            Selection.getSelectionEnd(paramSpanned);
          }
          if (this.QHs != null)
          {
            this.QHs.hai();
            if ((!hasSelection()) && (this.QHs.ham()) && (hasTransientState())) {
              setHasTransientState(false);
            }
          }
          sendAccessibilityEvent(8192);
        }
      }
      if (((paramObject instanceof UpdateAppearance)) || ((paramObject instanceof ParagraphStyle)) || ((paramObject instanceof CharacterStyle)))
      {
        if ((localh != null) && (localh.QIp != 0)) {
          break label472;
        }
        invalidate();
        this.QHh = true;
        gZw();
        label280:
        if (this.QHs != null) {
          this.QHs.hag();
        }
      }
      if (MetaKeyKeyListener.isMetaTracker(paramSpanned, paramObject))
      {
        this.QHh = true;
        if ((localh != null) && (MetaKeyKeyListener.isSelectingMetaTracker(paramSpanned, paramObject))) {
          localh.QKo = true;
        }
        if (Selection.getSelectionStart(paramSpanned) >= 0)
        {
          if ((localh != null) && (localh.QIp != 0)) {
            break label481;
          }
          gZs();
        }
      }
      for (;;)
      {
        if (((paramObject instanceof ParcelableSpan)) && (localh != null) && (localh.QKl != null))
        {
          if (localh.QIp != 0)
          {
            if (paramInt1 >= 0)
            {
              if (localh.QKp > paramInt1) {
                localh.QKp = paramInt1;
              }
              if (localh.QKp > paramInt3) {
                localh.QKp = paramInt3;
              }
            }
            if (paramInt2 < 0) {
              break label496;
            }
            if (localh.QKp > paramInt2) {
              localh.QKp = paramInt2;
            }
            if (localh.QKp <= paramInt4) {
              break label496;
            }
            localh.QKp = paramInt4;
            AppMethodBeat.o(205785);
            return;
            localh = this.QHs.QID;
            break;
            label472:
            localh.mContentChanged = true;
            break label280;
            label481:
            localh.QKn = true;
            continue;
          }
          localh.mContentChanged = true;
        }
      }
      label496:
      AppMethodBeat.o(205785);
      return;
      label503:
      j = -1;
    }
  }
  
  protected void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205686);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = (CharSequence)localObject;
    if (!isSuggestionsEnabled()) {
      paramCharSequence = ax((CharSequence)localObject);
    }
    if (!this.QGK) {
      this.ayn.setTextScaleX(1.0F);
    }
    int j = this.QHc.length;
    int i = 0;
    localObject = paramCharSequence;
    while (i < j)
    {
      paramCharSequence = this.QHc[i].filter((CharSequence)localObject, 0, ((CharSequence)localObject).length(), QGk, 0, 0);
      if (paramCharSequence != null) {
        localObject = paramCharSequence;
      }
      i += 1;
    }
    i = paramInt;
    if (paramBoolean)
    {
      if (this.mText != null)
      {
        i = this.mText.length();
        a(this.mText, 0, i, ((CharSequence)localObject).length());
      }
    }
    else {
      if ((this.mListeners == null) || (this.mListeners.size() == 0)) {
        break label734;
      }
    }
    label276:
    label299:
    label731:
    label734:
    for (paramInt = 1;; paramInt = 0)
    {
      j = Build.VERSION.SDK_INT;
      if ((paramBufferType == TextView.BufferType.EDITABLE) || (getKeyListener() != null) || (paramInt != 0))
      {
        gZL();
        localObject = this.OVn.newEditable((CharSequence)localObject);
        a((Editable)localObject, this.QHc);
        InputMethodManager localInputMethodManager = getInputMethodManager();
        paramCharSequence = (CharSequence)localObject;
        if (localInputMethodManager != null)
        {
          localInputMethodManager.restartInput(this);
          paramCharSequence = (CharSequence)localObject;
        }
        label249:
        if (this.QGR == 0) {
          break label731;
        }
        if ((paramBufferType != TextView.BufferType.EDITABLE) && (!(paramCharSequence instanceof Spannable))) {
          break label500;
        }
        localObject = (Spannable)paramCharSequence;
        if (!Linkify.addLinks((Spannable)localObject, this.QGR)) {
          break label731;
        }
        if (paramBufferType != TextView.BufferType.EDITABLE) {
          break label513;
        }
        paramCharSequence = TextView.BufferType.EDITABLE;
        setTextInternal((CharSequence)localObject);
        if ((this.QGS) && (!gZD())) {
          setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.haX());
        }
        paramBufferType = paramCharSequence;
        paramCharSequence = (CharSequence)localObject;
      }
      for (;;)
      {
        this.QGD = paramBufferType;
        setTextInternal(paramCharSequence);
        if (this.QGH == null) {}
        int k;
        for (this.OVq = paramCharSequence;; this.OVq = this.QGH.getTransformation(paramCharSequence, this))
        {
          if (this.OVq == null) {
            this.OVq = "";
          }
          k = paramCharSequence.length();
          if ((!(paramCharSequence instanceof Spannable)) || (this.QGI)) {
            break label676;
          }
          paramBufferType = (Spannable)paramCharSequence;
          localObject = (a[])paramBufferType.getSpans(0, paramBufferType.length(), a.class);
          int m = localObject.length;
          j = 0;
          while (j < m)
          {
            paramBufferType.removeSpan(localObject[j]);
            j += 1;
          }
          a("", 0, 0, ((CharSequence)localObject).length());
          i = paramInt;
          break;
          if (paramBufferType != TextView.BufferType.SPANNABLE)
          {
            paramCharSequence = (CharSequence)localObject;
            if (this.QGG == null) {
              break label249;
            }
          }
          paramCharSequence = this.OVo.newSpannable((CharSequence)localObject);
          break label249;
          label500:
          localObject = this.OVo.newSpannable(paramCharSequence);
          break label276;
          paramCharSequence = TextView.BufferType.SPANNABLE;
          break label299;
        }
        if (this.QGJ == null) {
          this.QGJ = new a((byte)0);
        }
        paramBufferType.setSpan(this.QGJ, 0, k, 6553618);
        if (this.QHs != null)
        {
          localObject = this.QHs;
          j = paramBufferType.length();
          if (((b)localObject).QIH != null) {
            paramBufferType.setSpan(((b)localObject).QIH, 0, j, 18);
          }
        }
        if (this.QGH != null) {
          paramBufferType.setSpan(this.QGH, 0, k, 18);
        }
        if (this.QGG != null)
        {
          this.QGG.j((Spannable)paramCharSequence);
          if (this.QHs != null) {
            this.QHs.QIF = false;
          }
        }
        if (this.OVt != null) {
          IR();
        }
        b(paramCharSequence, 0, i, k);
        if (paramInt != 0) {
          e((Editable)paramCharSequence);
        }
        if (this.QHs != null) {
          this.QHs.gZP();
        }
        AppMethodBeat.o(205686);
        return;
      }
    }
  }
  
  public void addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(205822);
    if ((paramBundle != null) && (paramString.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")))
    {
      int j = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
      int k = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
      if ((k <= 0) || (j < 0) || (j >= this.mText.length()))
      {
        Log.e("cmEdit.CMTextView", "Invalid arguments for accessibility character locations");
        AppMethodBeat.o(205822);
        return;
      }
      paramBundle = new RectF[k];
      Object localObject = new CursorAnchorInfo.Builder();
      a((CursorAnchorInfo.Builder)localObject, j, j + k, gZy(), gZz());
      localObject = ((CursorAnchorInfo.Builder)localObject).setMatrix(null).build();
      int i = 0;
      while (i < k)
      {
        if ((((CursorAnchorInfo)localObject).getCharacterBoundsFlags(j + i) & 0x1) == 1)
        {
          RectF localRectF = ((CursorAnchorInfo)localObject).getCharacterBounds(j + i);
          if (localRectF != null) {
            paramBundle[i] = localRectF;
          }
        }
        i += 1;
      }
      paramAccessibilityNodeInfo.getExtras().putParcelableArray(paramString, paramBundle);
      AppMethodBeat.o(205822);
      return;
    }
    AppMethodBeat.o(205822);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205777);
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTextWatcher);
    AppMethodBeat.o(205777);
  }
  
  public final void aoA(int paramInt)
  {
    AppMethodBeat.i(205836);
    if (this.QHs != null) {
      this.QHs.aoA(paramInt);
    }
    AppMethodBeat.o(205836);
  }
  
  public final void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205674);
    int i = paramCharSequence.length();
    if (!(this.mText instanceof Editable)) {
      setText(this.mText, TextView.BufferType.EDITABLE);
    }
    ((Editable)this.mText).append(paramCharSequence, 0, i);
    if ((this.QGR != 0) && (Linkify.addLinks(this.QGC, this.QGR)) && (this.QGS) && (!gZD())) {
      setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.haX());
    }
    AppMethodBeat.o(205674);
  }
  
  public void autofill(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(205819);
    if ((Build.VERSION.SDK_INT >= 26) && ((!paramAutofillValue.isText()) || (!gZB())))
    {
      Log.w("cmEdit.CMTextView", paramAutofillValue + " could not be autofilled into " + this);
      AppMethodBeat.o(205819);
      return;
    }
    CharSequence localCharSequence = null;
    if (Build.VERSION.SDK_INT >= 26) {
      localCharSequence = paramAutofillValue.getTextValue();
    }
    a(localCharSequence, this.QGD, true, 0);
    paramAutofillValue = getText();
    if ((paramAutofillValue instanceof Spannable)) {
      Selection.setSelection((Spannable)paramAutofillValue, paramAutofillValue.length());
    }
    AppMethodBeat.o(205819);
  }
  
  public final boolean ay(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205824);
    for (;;)
    {
      synchronized (QGi)
      {
        float[] arrayOfFloat2 = QGi;
        arrayOfFloat2[0] = paramFloat1;
        arrayOfFloat2[1] = paramFloat2;
        Object localObject1 = this;
        if (localObject1 != null)
        {
          if (localObject1 != this)
          {
            arrayOfFloat2[0] -= ((View)localObject1).getScrollX();
            arrayOfFloat2[1] -= ((View)localObject1).getScrollY();
          }
          if ((arrayOfFloat2[0] < 0.0F) || (arrayOfFloat2[1] < 0.0F) || (arrayOfFloat2[0] > ((View)localObject1).getWidth()) || (arrayOfFloat2[1] > ((View)localObject1).getHeight()))
          {
            AppMethodBeat.o(205824);
            return false;
          }
          if (!((View)localObject1).getMatrix().isIdentity()) {
            ((View)localObject1).getMatrix().mapPoints(arrayOfFloat2);
          }
          arrayOfFloat2[0] += ((View)localObject1).getLeft();
          arrayOfFloat2[1] += ((View)localObject1).getTop();
          localObject1 = ((View)localObject1).getParent();
          if ((localObject1 instanceof View)) {
            localObject1 = (View)localObject1;
          }
        }
        else
        {
          AppMethodBeat.o(205824);
          return true;
        }
      }
      Object localObject3 = null;
    }
  }
  
  protected void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205573);
    Log.i("cmEdit.CMTextView", "init");
    setTextInternal("");
    Object localObject1 = getResources();
    this.ayn = new TextPaint(1);
    this.ayn.density = ((Resources)localObject1).getDisplayMetrics().density;
    this.QHg = new Paint(1);
    this.QGG = getDefaultMovementMethod();
    this.QGH = null;
    d locald = new d((byte)0);
    locald.BpJ = ColorStateList.valueOf(-16777216);
    locald.mAk = at.fromDPToPix(getContext(), 18);
    this.On = 0;
    this.Oo = 0;
    this.QGT = 0;
    boolean bool4 = getDefaultEditable();
    Object localObject4 = null;
    int i2 = 0;
    CharSequence localCharSequence = null;
    boolean bool5 = false;
    boolean bool6 = false;
    int i1 = -1;
    boolean bool2 = false;
    Object localObject6 = null;
    Drawable localDrawable3 = null;
    Drawable localDrawable4 = null;
    Drawable localDrawable5 = null;
    Drawable localDrawable1 = null;
    Drawable localDrawable2 = null;
    ColorStateList localColorStateList = null;
    int n = 0;
    int i = -1;
    boolean bool1 = false;
    int m = -1;
    Object localObject2 = "";
    localObject1 = null;
    boolean bool3 = false;
    int i5 = 0;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MMNewTextView, paramInt1, paramInt2);
    int j = -1;
    int k = -1;
    paramInt1 = -1;
    a(paramContext, localTypedArray, locald);
    int i3;
    int i4;
    if (localTypedArray != null)
    {
      i3 = localTypedArray.getIndexCount();
      i4 = 0;
      paramAttributeSet = (AttributeSet)localObject2;
      paramInt2 = i5;
      label253:
      if (i4 >= i3) {
        break label2429;
      }
      i5 = localTypedArray.getIndex(i4);
      if (i5 != 44) {
        break label322;
      }
      bool4 = localTypedArray.getBoolean(i5, bool4);
      localObject2 = localObject1;
      localObject1 = paramAttributeSet;
      paramAttributeSet = (AttributeSet)localObject2;
    }
    label2474:
    label2484:
    label3128:
    for (;;)
    {
      i4 += 1;
      localObject2 = localObject1;
      localObject1 = paramAttributeSet;
      paramAttributeSet = (AttributeSet)localObject2;
      break label253;
      i3 = 0;
      break;
      label322:
      if (i5 == 41)
      {
        localObject4 = localTypedArray.getText(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 38)
      {
        i2 = localTypedArray.getInt(i5, i2);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 39)
      {
        localCharSequence = localTypedArray.getText(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 40)
      {
        bool5 = localTypedArray.getBoolean(i5, bool5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 43)
      {
        bool6 = localTypedArray.getBoolean(i5, bool6);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 42)
      {
        i1 = localTypedArray.getInt(i5, i1);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 31)
      {
        bool2 = localTypedArray.getBoolean(i5, bool2);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 10)
      {
        this.QGR = localTypedArray.getInt(i5, 0);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 11)
      {
        this.QGS = localTypedArray.getBoolean(i5, true);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 48)
      {
        localObject6 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 46)
      {
        localDrawable3 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 49)
      {
        localDrawable4 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 47)
      {
        localDrawable5 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 66)
      {
        localDrawable1 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 67)
      {
        localDrawable2 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == 72)
      {
        localColorStateList = localTypedArray.getColorStateList(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if (i5 != 73)
        {
          if (i5 == 50)
          {
            n = localTypedArray.getDimensionPixelSize(i5, n);
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 20)
          {
            setMaxLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 13)
          {
            setMaxHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 21)
          {
            setLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 22)
          {
            setHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 23)
          {
            setMinLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 15)
          {
            setMinHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 24)
          {
            setMaxEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 12)
          {
            setMaxWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 25)
          {
            setEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 26)
          {
            setWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 27)
          {
            setMinEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 14)
          {
            setMinWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 9)
          {
            setGravity(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 17)
          {
            localObject2 = localTypedArray.getText(i5);
            localObject1 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject2;
            continue;
          }
          if (i5 == 16)
          {
            localObject2 = localTypedArray.getText(i5);
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == 28)
          {
            if (localTypedArray.getBoolean(i5, false))
            {
              setHorizontallyScrolling(true);
              localObject2 = paramAttributeSet;
              paramAttributeSet = (AttributeSet)localObject1;
              localObject1 = localObject2;
            }
          }
          else
          {
            if (i5 == 30)
            {
              bool1 = localTypedArray.getBoolean(i5, bool1);
              localObject2 = paramAttributeSet;
              paramAttributeSet = (AttributeSet)localObject1;
              localObject1 = localObject2;
              continue;
            }
            if (i5 == 8)
            {
              i = localTypedArray.getInt(i5, i);
              localObject2 = paramAttributeSet;
              paramAttributeSet = (AttributeSet)localObject1;
              localObject1 = localObject2;
              continue;
            }
            if (i5 != 53) {
              if (i5 == 32)
              {
                if (!localTypedArray.getBoolean(i5, true))
                {
                  setIncludeFontPadding(false);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                }
              }
              else if (i5 == 19)
              {
                if (!localTypedArray.getBoolean(i5, true))
                {
                  setCursorVisible(false);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                }
              }
              else
              {
                if (i5 == 33)
                {
                  m = localTypedArray.getInt(i5, -1);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 18)
                {
                  setTextScaleX(localTypedArray.getFloat(i5, 1.0F));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 45)
                {
                  this.QGq = localTypedArray.getBoolean(i5, false);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 0)
                {
                  setEnabled(localTypedArray.getBoolean(i5, isEnabled()));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 29)
                {
                  bool3 = localTypedArray.getBoolean(i5, bool3);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 51)
                {
                  this.OVv = localTypedArray.getDimensionPixelSize(i5, (int)this.OVv);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 52)
                {
                  this.OVu = localTypedArray.getFloat(i5, this.OVu);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 54)
                {
                  paramInt2 = localTypedArray.getInt(i5, 0);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 76)
                {
                  gZL();
                  this.QHs.QIr = localTypedArray.getBoolean(i5, true);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 57)
                {
                  gZL();
                  this.QHs.gZO();
                  this.QHs.QIC.imeOptions = localTypedArray.getInt(i5, this.QHs.QIC.imeOptions);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 58)
                {
                  gZL();
                  this.QHs.gZO();
                  this.QHs.QIC.QKh = localTypedArray.getText(i5);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 59)
                {
                  gZL();
                  this.QHs.gZO();
                  this.QHs.QIC.imeActionId = localTypedArray.getInt(i5, this.QHs.QIC.imeActionId);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 55)
                {
                  setPrivateImeOptions(localTypedArray.getString(i5));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == 56)
                {
                  try
                  {
                    setInputExtras(localTypedArray.getResourceId(i5, 0));
                    localObject2 = paramAttributeSet;
                    paramAttributeSet = (AttributeSet)localObject1;
                    localObject1 = localObject2;
                  }
                  catch (XmlPullParserException localXmlPullParserException)
                  {
                    Log.w("cmEdit.CMTextView", "Failure reading input extras", new Object[] { localXmlPullParserException });
                    AttributeSet localAttributeSet = paramAttributeSet;
                    paramAttributeSet = (AttributeSet)localObject1;
                    localObject1 = localAttributeSet;
                  }
                  catch (IOException localIOException)
                  {
                    Log.w("cmEdit.CMTextView", "Failure reading input extras", new Object[] { localIOException });
                    localObject3 = paramAttributeSet;
                    paramAttributeSet = (AttributeSet)localObject1;
                    localObject1 = localObject3;
                  }
                  continue;
                }
                if (i5 == 64)
                {
                  this.QHi = localTypedArray.getResourceId(i5, 16843618);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 60)
                {
                  this.QHk = localTypedArray.getResourceId(i5, 16843461);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 61)
                {
                  this.QHm = localTypedArray.getResourceId(i5, 16843462);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 62)
                {
                  this.QHo = localTypedArray.getResourceId(i5, 16843463);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 63)
                {
                  setTextIsSelectable(localTypedArray.getBoolean(i5, false));
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 74)
                {
                  this.On = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 75)
                {
                  this.Oo = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 82)
                {
                  this.QGT = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 85)
                {
                  j = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 86)
                {
                  k = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == 87)
                {
                  paramInt1 = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                  label2429:
                  if (localTypedArray != null) {
                    localTypedArray.recycle();
                  }
                  localObject3 = TextView.BufferType.EDITABLE;
                  i5 = paramInt2 & 0xFFF;
                  boolean bool7;
                  if (i5 == 129)
                  {
                    i3 = 1;
                    if (i5 != 225) {
                      break label3731;
                    }
                    i4 = 1;
                    if (i5 != 18) {
                      break label3737;
                    }
                    i5 = 1;
                    int i6 = paramContext.getApplicationInfo().targetSdkVersion;
                    if (i6 < 26) {
                      break label3743;
                    }
                    bool7 = true;
                    label2503:
                    this.QGO = bool7;
                    if (i6 < 28) {
                      break label3749;
                    }
                    bool7 = true;
                    label2519:
                    this.QGP = bool7;
                    if (localObject4 == null) {
                      break label3839;
                    }
                  }
                  try
                  {
                    localObject4 = Class.forName(((CharSequence)localObject4).toString());
                  }
                  catch (ClassNotFoundException paramContext)
                  {
                    label2655:
                    label3183:
                    label3570:
                    paramContext = new RuntimeException(paramContext);
                    label3034:
                    AppMethodBeat.o(205573);
                    label3151:
                    throw paramContext;
                  }
                  try
                  {
                    gZL();
                    this.QHs.QIH = ((KeyListener)((Class)localObject4).newInstance());
                  }
                  catch (InstantiationException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(205573);
                    throw paramContext;
                  }
                  catch (IllegalAccessException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(205573);
                    throw paramContext;
                  }
                  try
                  {
                    localObject4 = this.QHs;
                    if (paramInt2 == 0) {
                      break label3809;
                    }
                    ((b)localObject4).Clf = paramInt2;
                  }
                  catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
                  {
                    this.QHs.Clf = 1;
                    break label2579;
                  }
                  if (this.QHs != null)
                  {
                    localObject4 = this.QHs;
                    if ((((b)localObject4).Clf & 0xF) != 1) {
                      break label4212;
                    }
                    if ((bool3) || (i3 != 0)) {
                      ((b)localObject4).Clf = (((b)localObject4).Clf & 0xFFFFF00F | 0x80);
                    }
                    if (i4 != 0) {
                      ((b)localObject4).Clf = (((b)localObject4).Clf & 0xFFFFF00F | 0xE0);
                    }
                  }
                  if (bool2)
                  {
                    gZL();
                    this.QHs.QIN = true;
                    if (localObject3 == TextView.BufferType.NORMAL) {
                      localObject3 = TextView.BufferType.SPANNABLE;
                    }
                  }
                  for (;;)
                  {
                    if (localColorStateList != null)
                    {
                      if (this.QGA == null) {
                        this.QGA = new b(paramContext);
                      }
                      if (localColorStateList != null)
                      {
                        this.QGA.Kr = localColorStateList;
                        this.QGA.QHG = true;
                      }
                    }
                    if (localObject6 != null) {
                      ((Drawable)localObject6).setBounds(0, 0, ((Drawable)localObject6).getIntrinsicWidth(), ((Drawable)localObject6).getIntrinsicHeight());
                    }
                    if (localDrawable4 != null) {
                      localDrawable4.setBounds(0, 0, localDrawable4.getIntrinsicWidth(), localDrawable4.getIntrinsicHeight());
                    }
                    if (localDrawable3 != null) {
                      localDrawable3.setBounds(0, 0, localDrawable3.getIntrinsicWidth(), localDrawable3.getIntrinsicHeight());
                    }
                    if (localDrawable5 != null) {
                      localDrawable5.setBounds(0, 0, localDrawable5.getIntrinsicWidth(), localDrawable5.getIntrinsicHeight());
                    }
                    setCompoundDrawables((Drawable)localObject6, localDrawable3, localDrawable4, localDrawable5);
                    if ((localDrawable1 != null) || (localDrawable2 != null))
                    {
                      paramInt2 = 1;
                      if (paramInt2 != 0)
                      {
                        localObject4 = this.QGA;
                        paramContext = (Context)localObject4;
                        if (localObject4 == null)
                        {
                          paramContext = new b(getContext());
                          this.QGA = paramContext;
                        }
                        this.QGA.QHN = true;
                        localObject4 = paramContext.OVZ;
                        localObject6 = getDrawableState();
                        if (localDrawable1 == null) {
                          break label4255;
                        }
                        localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
                        localDrawable1.setState((int[])localObject6);
                        localDrawable1.copyBounds((Rect)localObject4);
                        localDrawable1.setCallback(this);
                        paramContext.QHH = localDrawable1;
                        paramContext.QHO = ((Rect)localObject4).width();
                        paramContext.QHQ = ((Rect)localObject4).height();
                        if (localDrawable2 == null) {
                          break label4268;
                        }
                        localDrawable2.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
                        localDrawable2.setState((int[])localObject6);
                        localDrawable2.copyBounds((Rect)localObject4);
                        localDrawable2.setCallback(this);
                        paramContext.QHI = localDrawable2;
                        paramContext.QHP = ((Rect)localObject4).width();
                        paramContext.QHR = ((Rect)localObject4).height();
                        this.QGB = -1;
                        gZq();
                      }
                      setCompoundDrawablePadding(n);
                      setInputTypeSingleLine(bool1);
                      r(bool1, bool1, bool1);
                      paramInt2 = i;
                      if (bool1)
                      {
                        paramInt2 = i;
                        if (getKeyListener() == null)
                        {
                          paramInt2 = i;
                          if (i == -1) {
                            paramInt2 = 3;
                          }
                        }
                      }
                      switch (paramInt2)
                      {
                      default: 
                        if ((bool3) || (i3 != 0) || (i4 != 0) || (i5 != 0))
                        {
                          paramInt2 = 1;
                          if ((paramInt2 == 0) && ((this.QHs == null) || ((this.QHs.Clf & 0xFFF) != 129))) {
                            break label4317;
                          }
                          i = 1;
                          if (i != 0) {
                            locald.QIc = 3;
                          }
                          if (locald.BpJ != null) {
                            setTextColor(locald.BpJ);
                          }
                          if (locald.QHY != null) {
                            setHintTextColor(locald.QHY);
                          }
                          if (locald.QHZ != null) {
                            setLinkTextColor(locald.QHZ);
                          }
                          if (locald.QHX != 0) {
                            setHighlightColor(locald.QHX);
                          }
                          if (locald.mAk != -1)
                          {
                            this.QGM = locald.QGM;
                            setRawTextSize$254d549(locald.mAk);
                          }
                          if (locald.QIa != null) {
                            setTextLocales(locald.QIa);
                          }
                          if ((locald.QIc != -1) && (!locald.QIb)) {
                            locald.lal = null;
                          }
                          a(locald.alr, locald.lal, locald.QIc, locald.QId, locald.QIe);
                          if (locald.nYW != 0)
                          {
                            float f1 = locald.QGr;
                            float f2 = locald.QGs;
                            float f3 = locald.QGt;
                            i = locald.nYW;
                            this.ayn.setShadowLayer(f1, f2, f3, i);
                            this.QGr = f1;
                            this.QGs = f2;
                            this.QGt = f3;
                            this.nYW = i;
                            if (this.QHs != null) {
                              this.QHs.hag();
                            }
                            invalidate();
                          }
                          if (locald.QIg) {
                            setElegantTextHeight(locald.QIh);
                          }
                          if (locald.QIi) {
                            setFallbackLineSpacing(locald.QIj);
                          }
                          if (locald.QIk) {
                            setLetterSpacing(locald.QIl);
                          }
                          if (locald.QIm != null) {
                            setFontFeatureSettings(locald.QIm);
                          }
                          if (locald.QIn != null)
                          {
                            paramContext = locald.QIn;
                            if (Build.VERSION.SDK_INT >= 26)
                            {
                              localObject4 = this.ayn.getFontVariationSettings();
                              if ((paramContext != localObject4) && ((paramContext == null) || (!paramContext.equals(localObject4)))) {
                                break label4323;
                              }
                            }
                          }
                          if (paramInt2 != 0) {
                            setTransformationMethod(PasswordTransformationMethod.getInstance());
                          }
                          if (m < 0) {
                            break label4356;
                          }
                          setFilters(new InputFilter[] { new InputFilter.LengthFilter(m) });
                        }
                        break;
                      }
                    }
                    for (;;)
                    {
                      setText(paramAttributeSet, (TextView.BufferType)localObject3);
                      if (this.mText == null) {
                        this.mText = "";
                      }
                      if (this.OVq == null) {
                        this.OVq = "";
                      }
                      if (localObject1 != null) {
                        setHint((CharSequence)localObject1);
                      }
                      setClickable(true);
                      setLongClickable(true);
                      if (this.QHs != null) {
                        this.QHs.gZP();
                      }
                      if (getImportantForAccessibility() == 0) {
                        setImportantForAccessibility(1);
                      }
                      if (j >= 0) {
                        setFirstBaselineToTopHeight(j);
                      }
                      if (k >= 0) {
                        setLastBaselineToBottomHeight(k);
                      }
                      if (paramInt1 >= 0) {
                        setLineHeight(paramInt1);
                      }
                      AppMethodBeat.o(205573);
                      return;
                      i3 = 0;
                      break;
                      i4 = 0;
                      break label2474;
                      i5 = 0;
                      break label2484;
                      bool7 = false;
                      break label2503;
                      bool7 = false;
                      break label2519;
                      label3809:
                      paramInt2 = this.QHs.QIH.getInputType();
                      break label2572;
                      label3839:
                      Object localObject5;
                      if (localCharSequence != null)
                      {
                        gZL();
                        this.QHs.QIH = DigitsKeyListener.getInstance(localCharSequence.toString());
                        localObject5 = this.QHs;
                        if (paramInt2 != 0) {}
                        for (;;)
                        {
                          ((b)localObject5).Clf = paramInt2;
                          break;
                          paramInt2 = 1;
                        }
                      }
                      if (paramInt2 != 0)
                      {
                        bO(paramInt2, true);
                        if (!aox(paramInt2)) {}
                        for (bool1 = true;; bool1 = false) {
                          break;
                        }
                      }
                      if (bool5)
                      {
                        gZL();
                        this.QHs.QIH = DialerKeyListener.getInstance();
                        this.QHs.Clf = 3;
                        break label2579;
                      }
                      if (i2 != 0)
                      {
                        gZL();
                        this.QHs.QIH = DigitsKeyListener.getInstance();
                        paramInt2 = this.QHs.QIH.getInputType();
                        this.QHs.Clf = paramInt2;
                        break label2579;
                      }
                      if ((bool6) || (i1 != -1))
                      {
                        paramInt2 = 1;
                        switch (i1)
                        {
                        default: 
                          localObject5 = TextKeyListener.Capitalize.NONE;
                        }
                        for (;;)
                        {
                          gZL();
                          this.QHs.QIH = TextKeyListener.getInstance(bool6, (TextKeyListener.Capitalize)localObject5);
                          this.QHs.Clf = paramInt2;
                          break;
                          localObject5 = TextKeyListener.Capitalize.SENTENCES;
                          paramInt2 = 16385;
                          continue;
                          localObject5 = TextKeyListener.Capitalize.WORDS;
                          paramInt2 = 8193;
                          continue;
                          localObject5 = TextKeyListener.Capitalize.CHARACTERS;
                          paramInt2 = 4097;
                        }
                      }
                      if (bool4)
                      {
                        gZL();
                        this.QHs.QIH = TextKeyListener.getInstance();
                        this.QHs.Clf = 1;
                        break label2579;
                      }
                      if (isTextSelectable())
                      {
                        if (this.QHs != null)
                        {
                          this.QHs.QIH = null;
                          this.QHs.Clf = 0;
                        }
                        localObject3 = TextView.BufferType.SPANNABLE;
                        setMovementMethod(com.tencent.mm.ui.widget.cedit.b.a.haX());
                        break label2579;
                      }
                      if (this.QHs != null) {
                        this.QHs.QIH = null;
                      }
                      localObject3 = TextView.BufferType.NORMAL;
                      break label2579;
                      label4212:
                      if (((((b)localObject5).Clf & 0xF) != 2) || (i5 == 0)) {
                        break label2655;
                      }
                      ((b)localObject5).Clf = (((b)localObject5).Clf & 0xFFFFF00F | 0x10);
                      break label2655;
                      paramInt2 = 0;
                      break label2844;
                      paramContext.QHQ = 0;
                      paramContext.QHO = 0;
                      break label2967;
                      paramContext.QHR = 0;
                      paramContext.QHP = 0;
                      break label3034;
                      setEllipsize(TextUtils.TruncateAt.START);
                      break label3128;
                      setEllipsize(TextUtils.TruncateAt.MIDDLE);
                      break label3128;
                      setEllipsize(TextUtils.TruncateAt.END);
                      break label3128;
                      paramInt2 = 0;
                      break label3151;
                      label4317:
                      i = 0;
                      break label3183;
                      label4323:
                      if ((!this.ayn.setFontVariationSettings(paramContext)) || (this.OVt == null)) {
                        break label3570;
                      }
                      gLr();
                      requestLayout();
                      invalidate();
                      break label3570;
                      setFilters(QGj);
                    }
                  }
                }
              }
            }
          }
        }
        Object localObject3 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  public final void beginBatchEdit()
  {
    AppMethodBeat.i(205744);
    if (this.QHs != null) {
      this.QHs.beginBatchEdit();
    }
    AppMethodBeat.o(205744);
  }
  
  final void c(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205784);
    QGm = 0L;
    b.h localh;
    if (this.QHs == null)
    {
      localh = null;
      if ((localh == null) || (localh.QIp == 0)) {
        gZA();
      }
      if (localh != null)
      {
        localh.mContentChanged = true;
        if (localh.QKp >= 0) {
          break label113;
        }
        localh.QKp = paramInt1;
      }
    }
    for (localh.QKq = (paramInt1 + paramInt2);; localh.QKq = Math.max(localh.QKq, paramInt1 + paramInt2 - localh.QKr))
    {
      localh.QKr += paramInt3 - paramInt2;
      b(paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205784);
      return;
      localh = this.QHs.QID;
      break;
      label113:
      localh.QKp = Math.min(localh.QKp, paramInt1);
    }
  }
  
  final boolean c(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(205791);
    boolean bool1;
    if (this.QHq == -1)
    {
      this.QHq = paramMotionEvent.getPointerId(0);
      this.QHr = paramBoolean;
      bool1 = true;
    }
    for (;;)
    {
      if ((paramMotionEvent.getActionMasked() == 1) || (paramMotionEvent.getActionMasked() == 3)) {
        this.QHq = -1;
      }
      AppMethodBeat.o(205791);
      return bool1;
      if (this.QHq != paramMotionEvent.getPointerId(0))
      {
        bool1 = bool2;
        if (this.QHr)
        {
          bool1 = bool2;
          if (paramBoolean) {
            bool1 = true;
          }
        }
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(205797);
    super.cancelLongPress();
    if (this.QHs != null) {
      this.QHs.PPd = true;
    }
    AppMethodBeat.o(205797);
  }
  
  public void clearComposingText()
  {
    AppMethodBeat.i(205789);
    if ((this.mText instanceof Spannable)) {
      BaseInputConnection.removeComposingSpans(this.QGC);
    }
    AppMethodBeat.o(205789);
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(205802);
    if (this.OVt != null)
    {
      if ((this.OSP) && ((this.Ku & 0x7) == 3))
      {
        i = (int)this.OVt.getLineWidth(0);
        AppMethodBeat.o(205802);
        return i;
      }
      i = this.OVt.getWidth();
      AppMethodBeat.o(205802);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(205802);
    return i;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(205762);
    if ((this.mScroller != null) && (this.mScroller.computeScrollOffset())) {
      postInvalidate();
    }
    AppMethodBeat.o(205762);
  }
  
  protected int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(205804);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    AppMethodBeat.o(205804);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    AppMethodBeat.i(205803);
    if (this.OVt != null)
    {
      i = this.OVt.getHeight();
      AppMethodBeat.o(205803);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    AppMethodBeat.o(205803);
    return i;
  }
  
  final float cy(float paramFloat)
  {
    AppMethodBeat.i(205845);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    paramFloat = Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat);
    float f = getScrollX();
    AppMethodBeat.o(205845);
    return paramFloat + f;
  }
  
  final int cz(float paramFloat)
  {
    AppMethodBeat.i(205846);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    int i = getLayout().getLineForVertical((int)(paramFloat + f));
    AppMethodBeat.o(205846);
    return i;
  }
  
  public final boolean didTouchFocusSelect()
  {
    return (this.QHs != null) && (this.QHs.QIG);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205677);
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.QGA != null)
    {
      Drawable[] arrayOfDrawable = this.QGA.QHE;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if (localDrawable != null) {
          localDrawable.setHotspot(paramFloat1, paramFloat2);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(205677);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(205676);
    super.drawableStateChanged();
    if (((this.BpJ != null) && (this.BpJ.isStateful())) || ((this.QGn != null) && (this.QGn.isStateful())) || ((this.QGo != null) && (this.QGo.isStateful()))) {
      updateTextColors();
    }
    if (this.QGA != null)
    {
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.QGA.QHE;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
          invalidateDrawable(localDrawable);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(205676);
  }
  
  final void e(Editable paramEditable)
  {
    AppMethodBeat.i(205782);
    if (this.mListeners != null)
    {
      ArrayList localArrayList = this.mListeners;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((TextWatcher)localArrayList.get(i)).afterTextChanged(paramEditable);
        i += 1;
      }
    }
    AppMethodBeat.o(205782);
  }
  
  public final void endBatchEdit()
  {
    AppMethodBeat.i(205745);
    if (this.QHs != null) {
      this.QHs.endBatchEdit();
    }
    AppMethodBeat.o(205745);
  }
  
  public final boolean extractText(ExtractedTextRequest paramExtractedTextRequest, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(205741);
    gZL();
    boolean bool = this.QHs.a(paramExtractedTextRequest, -1, -1, -1, paramExtractedText);
    AppMethodBeat.o(205741);
    return bool;
  }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(205805);
    super.findViewsWithText(paramArrayList, paramCharSequence, paramInt);
    if ((!paramArrayList.contains(this)) && ((paramInt & 0x1) != 0) && (!TextUtils.isEmpty(paramCharSequence)) && (!TextUtils.isEmpty(this.mText)))
    {
      paramCharSequence = paramCharSequence.toString().toLowerCase();
      if (this.mText.toString().toLowerCase().contains(paramCharSequence)) {
        paramArrayList.add(this);
      }
    }
    AppMethodBeat.o(205805);
  }
  
  public View focusSearch(int paramInt)
  {
    AppMethodBeat.i(205739);
    try
    {
      View localView = super.focusSearch(paramInt);
      AppMethodBeat.o(205739);
      return localView;
    }
    catch (Throwable localThrowable)
    {
      Log.e("cmEdit.CMTextView", "focusSearch err", new Object[] { localThrowable });
      AppMethodBeat.o(205739);
    }
    return null;
  }
  
  final void gZA()
  {
    AppMethodBeat.i(205783);
    invalidate();
    int i = getSelectionStart();
    if ((i >= 0) || ((this.Ku & 0x70) == 80)) {
      gZt();
    }
    gZw();
    if (i >= 0)
    {
      this.QHh = true;
      if (this.QHs != null) {
        this.QHs.haz();
      }
      bringPointIntoView(i);
    }
    AppMethodBeat.o(205783);
  }
  
  final boolean gZB()
  {
    AppMethodBeat.i(205796);
    if (((this.mText instanceof Editable)) && (onCheckIsTextEditor()) && (isEnabled()))
    {
      AppMethodBeat.o(205796);
      return true;
    }
    AppMethodBeat.o(205796);
    return false;
  }
  
  final boolean gZC()
  {
    AppMethodBeat.i(205807);
    if ((this.mText.length() != 0) && (this.QHs != null) && (this.QHs.QIw))
    {
      AppMethodBeat.o(205807);
      return true;
    }
    AppMethodBeat.o(205807);
    return false;
  }
  
  final boolean gZD()
  {
    AppMethodBeat.i(205808);
    if ((this.QGG == null) || (!this.QGG.canSelectArbitrarily()))
    {
      AppMethodBeat.o(205808);
      return false;
    }
    if ((gZB()) || ((isTextSelectable()) && ((this.mText instanceof Spannable)) && (isEnabled())))
    {
      AppMethodBeat.o(205808);
      return true;
    }
    AppMethodBeat.o(205808);
    return false;
  }
  
  public final void gZE()
  {
    AppMethodBeat.i(205835);
    if (this.QHs != null) {
      this.QHs.gZE();
    }
    AppMethodBeat.o(205835);
  }
  
  final boolean gZF()
  {
    AppMethodBeat.i(205837);
    if ((this.QGH instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(205837);
      return false;
    }
    if ((this.mText.length() > 0) && (hasSelection()) && ((this.mText instanceof Editable)) && (this.QHs != null) && (this.QHs.QIH != null))
    {
      AppMethodBeat.o(205837);
      return true;
    }
    AppMethodBeat.o(205837);
    return false;
  }
  
  final boolean gZG()
  {
    AppMethodBeat.i(205838);
    if ((this.QGH instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(205838);
      return false;
    }
    if ((this.mText.length() > 0) && (hasSelection()) && (this.QHs != null))
    {
      AppMethodBeat.o(205838);
      return true;
    }
    AppMethodBeat.o(205838);
    return false;
  }
  
  final boolean gZH()
  {
    AppMethodBeat.i(205839);
    if (((this.mText instanceof Editable)) && (this.QHs != null) && (this.QHs.QIH != null) && (getSelectionStart() >= 0) && (getSelectionEnd() >= 0) && (getClipboardManagerForUser().hasPrimaryClip()))
    {
      AppMethodBeat.o(205839);
      return true;
    }
    AppMethodBeat.o(205839);
    return false;
  }
  
  final boolean gZI()
  {
    AppMethodBeat.i(205840);
    if ((gZC()) && (!(this.QGH instanceof PasswordTransformationMethod)) && ((getSelectionStart() != 0) || (getSelectionEnd() != this.mText.length())))
    {
      AppMethodBeat.o(205840);
      return true;
    }
    AppMethodBeat.o(205840);
    return false;
  }
  
  public final boolean gZJ()
  {
    AppMethodBeat.i(205841);
    if (this.QHs != null) {
      aoA(500);
    }
    int i = this.mText.length();
    Selection.setSelection(this.QGC, 0, i);
    if (i > 0)
    {
      AppMethodBeat.o(205841);
      return true;
    }
    AppMethodBeat.o(205841);
    return false;
  }
  
  final boolean gZK()
  {
    if (this.QHs == null) {}
    b.h localh;
    do
    {
      return false;
      localh = this.QHs.QID;
      if (localh == null) {
        break;
      }
    } while (localh.QIp <= 0);
    return true;
    return this.QHs.QIP;
  }
  
  public final boolean gZN()
  {
    AppMethodBeat.i(205858);
    if ((getReuseItems().size() > 0) && (Build.BRAND != null) && (getReuseBrands().contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23))
    {
      AppMethodBeat.o(205858);
      return true;
    }
    AppMethodBeat.o(205858);
    return false;
  }
  
  final void gZr()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(205707);
    if (this.QHh)
    {
      gZs();
      AppMethodBeat.o(205707);
      return;
    }
    int i = getCompoundPaddingLeft();
    int j = getExtendedPaddingTop();
    j = CW(true) + j;
    if (this.QHs.QIY == null) {}
    for (;;)
    {
      float f2;
      synchronized (alw)
      {
        f2 = (float)Math.ceil(this.ayn.getStrokeWidth());
        if (f2 >= 1.0F) {
          break label246;
        }
        f1 /= 2.0F;
        this.QHf.computeBounds(alw, false);
        invalidate((int)Math.floor(i + alw.left - f1), (int)Math.floor(j + alw.top - f1), (int)Math.ceil(i + alw.right + f1), (int)Math.ceil(f1 + (j + alw.bottom)));
        AppMethodBeat.o(205707);
        return;
      }
      ??? = this.QHs.QIY.getBounds();
      invalidate(((Rect)???).left + i, ((Rect)???).top + j, i + ((Rect)???).right, ((Rect)???).bottom + j);
      AppMethodBeat.o(205707);
      return;
      label246:
      f1 = f2;
    }
  }
  
  final void gZs()
  {
    AppMethodBeat.i(205708);
    int i = getSelectionEnd();
    aV(i, i, i);
    AppMethodBeat.o(205708);
  }
  
  final int gZy()
  {
    AppMethodBeat.i(205765);
    int i = getCompoundPaddingLeft();
    int j = getScrollX();
    AppMethodBeat.o(205765);
    return i - j;
  }
  
  final int gZz()
  {
    AppMethodBeat.i(205766);
    int j = getExtendedPaddingTop() - getScrollY();
    int i = j;
    if ((this.Ku & 0x70) != 48) {
      i = j + CW(false);
    }
    AppMethodBeat.o(205766);
    return i;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(205818);
    String str = CustomTextView.class.getName();
    AppMethodBeat.o(205818);
    return str;
  }
  
  public int getAccessibilitySelectionEnd()
  {
    AppMethodBeat.i(205856);
    int i = getSelectionEnd();
    AppMethodBeat.o(205856);
    return i;
  }
  
  public int getAccessibilitySelectionStart()
  {
    AppMethodBeat.i(205855);
    int i = getSelectionStart();
    AppMethodBeat.o(205855);
    return i;
  }
  
  public TextView getAdaptText()
  {
    return this.QHu;
  }
  
  public int getAutofillType()
  {
    AppMethodBeat.i(205820);
    if (gZB())
    {
      AppMethodBeat.o(205820);
      return 1;
    }
    AppMethodBeat.o(205820);
    return 0;
  }
  
  public AutofillValue getAutofillValue()
  {
    AppMethodBeat.i(205821);
    if (gZB())
    {
      Object localObject = com.tencent.mm.ui.widget.cedit.util.c.n(getText(), 100000);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = AutofillValue.forText((CharSequence)localObject);
        AppMethodBeat.o(205821);
        return localObject;
      }
    }
    AppMethodBeat.o(205821);
    return null;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(205730);
    if (this.OVt == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(205730);
      return i;
    }
    int i = getBaselineOffset();
    int j = this.OVt.getLineBaseline(0);
    AppMethodBeat.o(205730);
    return i + j;
  }
  
  int getBaselineOffset()
  {
    AppMethodBeat.i(205731);
    int i = 0;
    if ((this.Ku & 0x70) != 48) {
      i = CW(true);
    }
    int j = getExtendedPaddingTop();
    AppMethodBeat.o(205731);
    return i + j;
  }
  
  protected int getBottomPaddingOffset()
  {
    AppMethodBeat.i(205718);
    int i = (int)Math.max(0.0F, this.QGt + this.QGr);
    AppMethodBeat.o(205718);
    return i;
  }
  
  final ClipboardManager getClipboardManagerForUser()
  {
    AppMethodBeat.i(205812);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getContext().getPackageName();
      localClipboardManager = (ClipboardManager)bj(ClipboardManager.class);
      AppMethodBeat.o(205812);
      return localClipboardManager;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)getContext().getSystemService("clipboard");
    AppMethodBeat.o(205812);
    return localClipboardManager;
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.QGA;
    if (localb != null) {
      return localb.OWm;
    }
    return 0;
  }
  
  public BlendMode getCompoundDrawableTintBlendMode()
  {
    if (this.QGA != null) {
      return this.QGA.QHF;
    }
    return null;
  }
  
  public ColorStateList getCompoundDrawableTintList()
  {
    if (this.QGA != null) {
      return this.QGA.Kr;
    }
    return null;
  }
  
  public PorterDuff.Mode getCompoundDrawableTintMode()
  {
    return null;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    AppMethodBeat.i(205601);
    Object localObject = this.QGA;
    if (localObject != null)
    {
      localObject = (Drawable[])((b)localObject).QHE.clone();
      AppMethodBeat.o(205601);
      return localObject;
    }
    AppMethodBeat.o(205601);
    return new Drawable[] { null, null, null, null };
  }
  
  public Drawable[] getCompoundDrawablesRelative()
  {
    b localb = this.QGA;
    if (localb != null) {
      return new Drawable[] { localb.QHH, localb.QHE[1], localb.QHI, localb.QHE[3] };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(205587);
    b localb = this.QGA;
    if ((localb == null) || (localb.QHE[3] == null))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(205587);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.OWm;
    int k = localb.OWf;
    AppMethodBeat.o(205587);
    return k + (i + j);
  }
  
  public int getCompoundPaddingEnd()
  {
    AppMethodBeat.i(205591);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingRight();
      AppMethodBeat.o(205591);
      return i;
    }
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(205591);
    return i;
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(205588);
    b localb = this.QGA;
    if ((localb == null) || (localb.QHE[0] == null))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(205588);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.OWm;
    int k = localb.OWg;
    AppMethodBeat.o(205588);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(205589);
    b localb = this.QGA;
    if ((localb == null) || (localb.QHE[2] == null))
    {
      i = getPaddingRight();
      AppMethodBeat.o(205589);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.OWm;
    int k = localb.OWh;
    AppMethodBeat.o(205589);
    return k + (i + j);
  }
  
  public int getCompoundPaddingStart()
  {
    AppMethodBeat.i(205590);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingLeft();
      AppMethodBeat.o(205590);
      return i;
    }
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(205590);
    return i;
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(205586);
    b localb = this.QGA;
    if ((localb == null) || (localb.QHE[1] == null))
    {
      i = getPaddingTop();
      AppMethodBeat.o(205586);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.OWm;
    int k = localb.OWe;
    AppMethodBeat.o(205586);
    return k + (i + j);
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.QGn != null) {
      return this.QGp;
    }
    return this.OVm;
  }
  
  public final int getCurrentTextColor()
  {
    return this.OVm;
  }
  
  public ActionMode.Callback getCustomInsertionActionModeCallback()
  {
    if (this.QHs == null) {
      return null;
    }
    return this.QHs.QJg;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    if (this.QHs == null) {
      return null;
    }
    return this.QHs.QJf;
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected com.tencent.mm.ui.widget.cedit.b.d getDefaultMovementMethod()
  {
    return null;
  }
  
  public Editable getEditableText()
  {
    if ((this.mText instanceof Editable)) {
      return (Editable)this.mText;
    }
    return null;
  }
  
  public b getEditor()
  {
    return this.QHs;
  }
  
  @ViewDebug.ExportedProperty
  public TextUtils.TruncateAt getEllipsize()
  {
    return this.OVp;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(205593);
    if (this.OVx != 1)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(205593);
      return i;
    }
    if (this.OVt == null) {
      gLs();
    }
    if (this.OVt.getLineCount() <= this.OVw)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(205593);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.OVt.getLineTop(this.OVw);
    if (k >= j)
    {
      AppMethodBeat.o(205593);
      return i;
    }
    int m = this.Ku & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(205593);
      return i + j - k;
    }
    if (m == 80)
    {
      AppMethodBeat.o(205593);
      return i;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(205593);
    return i + j;
  }
  
  public int getExtendedPaddingTop()
  {
    AppMethodBeat.i(205592);
    if (this.OVx != 1)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(205592);
      return i;
    }
    if (this.OVt == null) {
      gLs();
    }
    if (this.OVt.getLineCount() <= this.OVw)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(205592);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.OVt.getLineTop(this.OVw);
    if (k >= j)
    {
      AppMethodBeat.o(205592);
      return i;
    }
    int m = this.Ku & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(205592);
      return i;
    }
    if (m == 80)
    {
      AppMethodBeat.o(205592);
      return i + j - k;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(205592);
    return i + j;
  }
  
  public InputFilter[] getFilters()
  {
    return this.QHc;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    AppMethodBeat.i(205610);
    int i = getPaddingTop();
    int j = getPaint().getFontMetricsInt().top;
    AppMethodBeat.o(205610);
    return i - j;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(205728);
    if (this.OVt == null)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(205728);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(205728);
      return;
    }
    int j = getSelectionStart();
    if ((j < 0) || (j >= i))
    {
      j = this.OVt.getLineForOffset(i);
      paramRect.top = this.OVt.getLineTop(j);
      paramRect.bottom = this.OVt.getLineBottom(j);
      paramRect.left = ((int)this.OVt.getPrimaryHorizontal(i) - 2);
      paramRect.right = (paramRect.left + 4);
    }
    for (;;)
    {
      int k = getCompoundPaddingLeft();
      j = getExtendedPaddingTop();
      i = j;
      if ((this.Ku & 0x70) != 48) {
        i = j + CW(false);
      }
      paramRect.offset(k, i);
      paramRect.bottom = (getExtendedPaddingBottom() + paramRect.bottom);
      AppMethodBeat.o(205728);
      return;
      k = this.OVt.getLineForOffset(j);
      int m = this.OVt.getLineForOffset(i);
      paramRect.top = this.OVt.getLineTop(k);
      paramRect.bottom = this.OVt.getLineBottom(m);
      if (k == m)
      {
        paramRect.left = ((int)this.OVt.getPrimaryHorizontal(j));
        paramRect.right = ((int)this.OVt.getPrimaryHorizontal(i));
        continue;
      }
      if (this.QHh)
      {
        if (this.QHf == null) {
          this.QHf = new Path();
        }
        this.QHf.reset();
        this.OVt.getSelectionPath(j, i, this.QHf);
        this.QHh = false;
      }
      synchronized (alw)
      {
        this.QHf.computeBounds(alw, true);
        paramRect.left = ((int)alw.left - 1);
        paramRect.right = ((int)alw.right + 1);
      }
    }
  }
  
  public String getFontFeatureSettings()
  {
    AppMethodBeat.i(205644);
    String str = this.ayn.getFontFeatureSettings();
    AppMethodBeat.o(205644);
    return str;
  }
  
  public String getFontVariationSettings()
  {
    AppMethodBeat.i(205645);
    if (Build.VERSION.SDK_INT >= 26)
    {
      String str = this.ayn.getFontVariationSettings();
      AppMethodBeat.o(205645);
      return str;
    }
    AppMethodBeat.o(205645);
    return "";
  }
  
  public boolean getFreezesText()
  {
    return this.QGq;
  }
  
  public int getGravity()
  {
    return this.Ku;
  }
  
  public int getHighlightColor()
  {
    return this.oEF;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getHint()
  {
    return this.QGE;
  }
  
  public final ColorStateList getHintTextColors()
  {
    return this.QGn;
  }
  
  public int getHorizontalOffsetForDrawables()
  {
    return 0;
  }
  
  public boolean getHorizontallyScrolling()
  {
    return this.QGQ;
  }
  
  public int getImeActionId()
  {
    if ((this.QHs != null) && (this.QHs.QIC != null)) {
      return this.QHs.QIC.imeActionId;
    }
    return 0;
  }
  
  public CharSequence getImeActionLabel()
  {
    if ((this.QHs != null) && (this.QHs.QIC != null)) {
      return this.QHs.QIC.QKh;
    }
    return null;
  }
  
  public LocaleList getImeHintLocales()
  {
    if (this.QHs == null) {}
    while (this.QHs.QIC == null) {
      return null;
    }
    return this.QHs.QIC.QKk;
  }
  
  public int getImeOptions()
  {
    if ((this.QHs != null) && (this.QHs.QIC != null)) {
      return this.QHs.QIC.imeOptions;
    }
    return 0;
  }
  
  public boolean getIncludeFontPadding()
  {
    return this.OVD;
  }
  
  public Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(205700);
    if ((this.QHs == null) && (!paramBoolean))
    {
      AppMethodBeat.o(205700);
      return null;
    }
    gZL();
    if (this.QHs.QIC == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(205700);
        return null;
      }
      this.QHs.gZO();
    }
    if (this.QHs.QIC.extras == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(205700);
        return null;
      }
      this.QHs.QIC.extras = new Bundle();
    }
    Bundle localBundle = this.QHs.QIC.extras;
    AppMethodBeat.o(205700);
    return localBundle;
  }
  
  InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(205826);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(205826);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    AppMethodBeat.o(205826);
    return localInputMethodManager;
  }
  
  public int getInputType()
  {
    if (this.QHs == null) {
      return 0;
    }
    return this.QHs.Clf;
  }
  
  public CharSequence getIterableTextForAccessibility()
  {
    return this.mText;
  }
  
  public final KeyListener getKeyListener()
  {
    if (this.QHs == null) {
      return null;
    }
    return this.QHs.QIH;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    AppMethodBeat.i(205611);
    int i = getPaddingBottom();
    int j = getPaint().getFontMetricsInt().bottom;
    AppMethodBeat.o(205611);
    return i + j;
  }
  
  public final Layout getLayout()
  {
    return this.OVt;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(205799);
    if (getLineCount() == 1)
    {
      f = getLayout().getLineLeft(0);
      if (f > getScrollX())
      {
        AppMethodBeat.o(205799);
        return 0.0F;
      }
      f = ax(getScrollX(), f);
      AppMethodBeat.o(205799);
      return f;
    }
    float f = super.getLeftFadingEdgeStrength();
    AppMethodBeat.o(205799);
    return f;
  }
  
  protected int getLeftPaddingOffset()
  {
    AppMethodBeat.i(205716);
    int i = getCompoundPaddingLeft();
    int j = getPaddingLeft();
    int k = (int)Math.min(0.0F, this.QGs - this.QGr);
    AppMethodBeat.o(205716);
    return i - j + k;
  }
  
  public float getLetterSpacing()
  {
    AppMethodBeat.i(205642);
    float f = this.ayn.getLetterSpacing();
    AppMethodBeat.o(205642);
    return f;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(205729);
    if (this.OVt != null)
    {
      int i = this.OVt.getLineCount();
      AppMethodBeat.o(205729);
      return i;
    }
    AppMethodBeat.o(205729);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(205579);
    int i = (int)(((this.ayn.getFontMetricsInt(null) * this.OVu + this.OVv) * 16777216.0F) + 8388608L >> 24);
    AppMethodBeat.o(205579);
    return i;
  }
  
  public float getLineSpacingExtra()
  {
    return this.OVv;
  }
  
  public float getLineSpacingMultiplier()
  {
    return this.OVu;
  }
  
  public final ColorStateList getLinkTextColors()
  {
    return this.QGo;
  }
  
  public final boolean getLinksClickable()
  {
    return this.QGS;
  }
  
  public int getMaxEms()
  {
    if (this.QGW == 1) {
      return this.mMaxWidth;
    }
    return -1;
  }
  
  public int getMaxHeight()
  {
    if (this.OVx == 2) {
      return this.OVw;
    }
    return -1;
  }
  
  public int getMaxLines()
  {
    if (this.OVx == 1) {
      return this.OVw;
    }
    return -1;
  }
  
  public int getMaxWidth()
  {
    if (this.QGW == 2) {
      return this.mMaxWidth;
    }
    return -1;
  }
  
  public a.e getMenuCallback()
  {
    return this.QHz;
  }
  
  public int getMinEms()
  {
    if (this.QGX == 1) {
      return this.mMinWidth;
    }
    return -1;
  }
  
  public int getMinHeight()
  {
    if (this.OVz == 2) {
      return this.OVy;
    }
    return -1;
  }
  
  public int getMinLines()
  {
    if (this.OVz == 1) {
      return this.OVy;
    }
    return -1;
  }
  
  public int getMinWidth()
  {
    if (this.QGX == 2) {
      return this.mMinWidth;
    }
    return -1;
  }
  
  public final com.tencent.mm.ui.widget.cedit.b.d getMovementMethod()
  {
    return this.QGG;
  }
  
  public final int getOffsetForPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205844);
    if (getLayout() == null)
    {
      AppMethodBeat.o(205844);
      return -1;
    }
    int i = B(cz(paramFloat2), paramFloat1);
    AppMethodBeat.o(205844);
    return i;
  }
  
  public TextPaint getPaint()
  {
    return this.ayn;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(205658);
    int i = this.ayn.getFlags();
    AppMethodBeat.o(205658);
    return i;
  }
  
  public String getPrivateImeOptions()
  {
    if ((this.QHs != null) && (this.QHs.QIC != null)) {
      return this.QHs.QIC.privateImeOptions;
    }
    return null;
  }
  
  public Set<String> getReuseBrands()
  {
    return this.QHB;
  }
  
  public Set<String> getReuseItems()
  {
    return this.QHA;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(205800);
    if (getLineCount() == 1)
    {
      f1 = getScrollX() + (getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      float f2 = getLayout().getLineRight(0);
      if (f2 < f1)
      {
        AppMethodBeat.o(205800);
        return 0.0F;
      }
      f1 = ax(f1, f2);
      AppMethodBeat.o(205800);
      return f1;
    }
    float f1 = super.getRightFadingEdgeStrength();
    AppMethodBeat.o(205800);
    return f1;
  }
  
  protected int getRightPaddingOffset()
  {
    AppMethodBeat.i(205719);
    int i = -(getCompoundPaddingRight() - getPaddingRight());
    int j = (int)Math.max(0.0F, this.QGs + this.QGr);
    AppMethodBeat.o(205719);
    return i + j;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getScaledTextSize()
  {
    AppMethodBeat.i(205631);
    float f = this.ayn.getTextSize() / this.ayn.density;
    AppMethodBeat.o(205631);
    return f;
  }
  
  String getSelectedText()
  {
    AppMethodBeat.i(205770);
    if (!hasSelection())
    {
      AppMethodBeat.o(205770);
      return null;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (i > j) {}
    for (Object localObject = this.mText.subSequence(j, i);; localObject = this.mText.subSequence(i, j))
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(205770);
      return localObject;
    }
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionEnd()
  {
    AppMethodBeat.i(205768);
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(205768);
    return i;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionStart()
  {
    AppMethodBeat.i(205767);
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(205767);
    return i;
  }
  
  public int getShadowColor()
  {
    return this.nYW;
  }
  
  public float getShadowDx()
  {
    return this.QGs;
  }
  
  public float getShadowDy()
  {
    return this.QGt;
  }
  
  public float getShadowRadius()
  {
    return this.QGr;
  }
  
  public final boolean getShowSoftInputOnFocus()
  {
    return (this.QHs == null) || (this.QHs.QIQ);
  }
  
  public Locale getSpellCheckerLocale()
  {
    AppMethodBeat.i(205816);
    Locale localLocale = CX(true);
    AppMethodBeat.o(205816);
    return localLocale;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  TextClassificationContext getTextClassificationContext()
  {
    return this.QGy;
  }
  
  final TextClassificationManager getTextClassificationManagerForUser()
  {
    AppMethodBeat.i(205813);
    if (Build.VERSION.SDK_INT >= 26)
    {
      getContext().getPackageName();
      TextClassificationManager localTextClassificationManager = (TextClassificationManager)bj(TextClassificationManager.class);
      AppMethodBeat.o(205813);
      return localTextClassificationManager;
    }
    AppMethodBeat.o(205813);
    return null;
  }
  
  TextClassifier getTextClassificationSession()
  {
    AppMethodBeat.i(205834);
    TextClassificationManager localTextClassificationManager;
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 28) && ((this.QGx == null) || (this.QGx.isDestroyed())))
    {
      localTextClassificationManager = getTextClassificationManagerForUser();
      if (localTextClassificationManager == null) {
        break label128;
      }
      if (!gZB()) {
        break label107;
      }
      localObject = "edittext";
      this.QGy = new TextClassificationContext.Builder(getContext().getPackageName(), (String)localObject).build();
      if (this.QGw != null) {}
    }
    label128:
    for (this.QGx = localTextClassificationManager.createTextClassificationSession(this.QGy);; this.QGx = TextClassifier.NO_OP)
    {
      localObject = this.QGx;
      AppMethodBeat.o(205834);
      return localObject;
      label107:
      if (isTextSelectable())
      {
        localObject = "textview";
        break;
      }
      localObject = "nosel-textview";
      break;
    }
  }
  
  public TextClassifier getTextClassifier()
  {
    AppMethodBeat.i(205833);
    if (this.QGw == null)
    {
      localObject = getTextClassificationManagerForUser();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 26))
      {
        localObject = ((TextClassificationManager)localObject).getTextClassifier();
        AppMethodBeat.o(205833);
        return localObject;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = TextClassifier.NO_OP;
        AppMethodBeat.o(205833);
        return localObject;
      }
    }
    Object localObject = this.QGw;
    AppMethodBeat.o(205833);
    return localObject;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.BpJ;
  }
  
  public Drawable getTextCursorDrawable()
  {
    AppMethodBeat.i(205623);
    if ((this.QHj == null) && (this.QHi != 0)) {
      this.QHj = getContext().getDrawable(this.QHi);
    }
    Drawable localDrawable = this.QHj;
    AppMethodBeat.o(205623);
    return localDrawable;
  }
  
  public TextDirectionHeuristic getTextDirectionHeuristic()
  {
    String str = null;
    AppMethodBeat.i(205850);
    if ((this.QGH instanceof PasswordTransformationMethod))
    {
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(205850);
      return localObject;
    }
    if ((this.QHs != null) && ((this.QHs.Clf & 0xF) == 3)) {
      if (Build.VERSION.SDK_INT < 24) {
        break label281;
      }
    }
    label281:
    for (Object localObject = DecimalFormatSymbols.getInstance(getTextLocale());; localObject = null)
    {
      if (Build.VERSION.SDK_INT >= 28) {
        str = localObject.getDigitStrings()[0];
      }
      int i = Character.getDirectionality(str.codePointAt(0));
      if ((i == 1) || (i == 2))
      {
        localObject = TextDirectionHeuristics.RTL;
        AppMethodBeat.o(205850);
        return localObject;
      }
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(205850);
      return localObject;
      if (getLayoutDirection() == 1) {}
      for (i = 1;; i = 0) {
        switch (getTextDirection())
        {
        default: 
          if (i == 0) {
            break label197;
          }
          localObject = TextDirectionHeuristics.FIRSTSTRONG_RTL;
          AppMethodBeat.o(205850);
          return localObject;
        }
      }
      label197:
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.ANYRTL_LTR;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.RTL;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.LOCALE;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(205850);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      AppMethodBeat.o(205850);
      return localObject;
    }
  }
  
  public Locale getTextLocale()
  {
    AppMethodBeat.i(205625);
    Locale localLocale = this.ayn.getTextLocale();
    AppMethodBeat.o(205625);
    return localLocale;
  }
  
  public LocaleList getTextLocales()
  {
    AppMethodBeat.i(205626);
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = this.ayn.getTextLocales();
      AppMethodBeat.o(205626);
      return localLocaleList;
    }
    AppMethodBeat.o(205626);
    return null;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(205636);
    float f = this.ayn.getTextScaleX();
    AppMethodBeat.o(205636);
    return f;
  }
  
  public Drawable getTextSelectHandle()
  {
    AppMethodBeat.i(205614);
    if ((this.QHp == null) && (this.QHo != 0)) {
      this.QHp = getContext().getDrawable(2131235259);
    }
    Drawable localDrawable = this.QHp;
    AppMethodBeat.o(205614);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleLeft()
  {
    AppMethodBeat.i(205617);
    if ((this.QHl == null) && (this.QHk != 0)) {
      this.QHl = getContext().getDrawable(2131235258);
    }
    Drawable localDrawable = this.QHl;
    AppMethodBeat.o(205617);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleRight()
  {
    AppMethodBeat.i(205620);
    if ((this.QHn == null) && (this.QHm != 0)) {
      this.QHn = getContext().getDrawable(2131235260);
    }
    Drawable localDrawable = this.QHn;
    AppMethodBeat.o(205620);
    return localDrawable;
  }
  
  public Locale getTextServicesLocale()
  {
    AppMethodBeat.i(205815);
    Locale localLocale = CX(false);
    AppMethodBeat.o(205815);
    return localLocale;
  }
  
  final TextServicesManager getTextServicesManagerForUser()
  {
    AppMethodBeat.i(205811);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localTextServicesManager = (TextServicesManager)bj(TextServicesManager.class);
      AppMethodBeat.o(205811);
      return localTextServicesManager;
    }
    TextServicesManager localTextServicesManager = (TextServicesManager)getContext().getSystemService("textservices");
    AppMethodBeat.o(205811);
    return localTextServicesManager;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getTextSize()
  {
    AppMethodBeat.i(205630);
    float f = this.ayn.getTextSize();
    AppMethodBeat.o(205630);
    return f;
  }
  
  public int getTextSizeUnit()
  {
    return this.QGM;
  }
  
  protected int getTopPaddingOffset()
  {
    AppMethodBeat.i(205717);
    int i = (int)Math.min(0.0F, this.QGt - this.QGr);
    AppMethodBeat.o(205717);
    return i;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(205599);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.Ku & 0x70;
    Layout localLayout = this.OVt;
    int i = j;
    int n;
    int i1;
    if (m != 80)
    {
      n = a(localLayout);
      i1 = localLayout.getHeight();
      i = j;
      if (i1 < n) {
        if (m != 48) {
          break label84;
        }
      }
    }
    label84:
    for (i = n - i1;; i = n - i1 >> 1)
    {
      AppMethodBeat.o(205599);
      return i + k;
    }
  }
  
  public int getTotalPaddingEnd()
  {
    AppMethodBeat.i(205597);
    int i = getCompoundPaddingEnd();
    AppMethodBeat.o(205597);
    return i;
  }
  
  public int getTotalPaddingLeft()
  {
    AppMethodBeat.i(205594);
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(205594);
    return i;
  }
  
  public int getTotalPaddingRight()
  {
    AppMethodBeat.i(205595);
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(205595);
    return i;
  }
  
  public int getTotalPaddingStart()
  {
    AppMethodBeat.i(205596);
    int i = getCompoundPaddingStart();
    AppMethodBeat.o(205596);
    return i;
  }
  
  public int getTotalPaddingTop()
  {
    AppMethodBeat.i(205598);
    int i = getExtendedPaddingTop();
    int j = CW(true);
    AppMethodBeat.o(205598);
    return i + j;
  }
  
  public final TransformationMethod getTransformationMethod()
  {
    return this.QGH;
  }
  
  public CharSequence getTransformed()
  {
    return this.OVq;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(205639);
    Typeface localTypeface = this.ayn.getTypeface();
    AppMethodBeat.o(205639);
    return localTypeface;
  }
  
  @ViewDebug.ExportedProperty(category="text", mapping={@android.view.ViewDebug.IntToString(from=0, to="NORMAL"), @android.view.ViewDebug.IntToString(from=1, to="BOLD"), @android.view.ViewDebug.IntToString(from=2, to="ITALIC"), @android.view.ViewDebug.IntToString(from=3, to="BOLD_ITALIC")})
  public int getTypefaceStyle()
  {
    AppMethodBeat.i(205632);
    Typeface localTypeface = this.ayn.getTypeface();
    if (localTypeface != null)
    {
      int i = localTypeface.getStyle();
      AppMethodBeat.o(205632);
      return i;
    }
    AppMethodBeat.o(205632);
    return 0;
  }
  
  public URLSpan[] getUrls()
  {
    AppMethodBeat.i(205652);
    if ((this.mText instanceof Spanned))
    {
      URLSpan[] arrayOfURLSpan = (URLSpan[])((Spanned)this.mText).getSpans(0, this.mText.length(), URLSpan.class);
      AppMethodBeat.o(205652);
      return arrayOfURLSpan;
    }
    AppMethodBeat.o(205652);
    return new URLSpan[0];
  }
  
  public com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(205817);
    if (this.QHs != null)
    {
      com.tencent.mm.ui.widget.cedit.c.b localb = this.QHs.getWordIterator();
      AppMethodBeat.o(205817);
      return localb;
    }
    AppMethodBeat.o(205817);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(205723);
    if (((getBackground() != null) && (getBackground().getCurrent() != null)) || (this.QGC != null) || (hasSelection()) || (isHorizontalFadingEdgeEnabled()) || (this.nYW != 0))
    {
      AppMethodBeat.o(205723);
      return true;
    }
    AppMethodBeat.o(205723);
    return false;
  }
  
  public final boolean hasSelection()
  {
    AppMethodBeat.i(205769);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((i >= 0) && (j > 0) && (i != j))
    {
      AppMethodBeat.o(205769);
      return true;
    }
    AppMethodBeat.o(205769);
    return false;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int m = 0;
    int i1 = 0;
    AppMethodBeat.i(205722);
    Rect localRect;
    int n;
    b localb;
    int i;
    int j;
    int k;
    int i2;
    if (verifyDrawable(paramDrawable))
    {
      localRect = paramDrawable.getBounds();
      n = getScrollX();
      m = getScrollY();
      localb = this.QGA;
      i = i1;
      j = m;
      k = n;
      if (localb != null)
      {
        if (paramDrawable != localb.QHE[0]) {
          break label187;
        }
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + getPaddingLeft();
        j = m + (i + (i1 - i2 - j - i - localb.OWk) / 2);
        i = 1;
      }
    }
    for (;;)
    {
      m = i;
      if (i != 0)
      {
        invalidate(localRect.left + k, localRect.top + j, k + localRect.right, j + localRect.bottom);
        m = i;
      }
      if (m == 0) {
        super.invalidateDrawable(paramDrawable);
      }
      AppMethodBeat.o(205722);
      return;
      label187:
      if (paramDrawable == localb.QHE[2])
      {
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + (getRight() - getLeft() - getPaddingRight() - localb.OWh);
        j = m + (i + (i1 - i2 - j - i - localb.OWl) / 2);
        i = 1;
      }
      else if (paramDrawable == localb.QHE[1])
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        k = n + (i + (getRight() - getLeft() - j - i - localb.OWi) / 2);
        j = m + getPaddingTop();
        i = 1;
      }
      else
      {
        i = i1;
        j = m;
        k = n;
        if (paramDrawable == localb.QHE[3])
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          k = n + (i + (getRight() - getLeft() - j - i - localb.OWj) / 2);
          j = m + (getBottom() - getTop() - getPaddingBottom() - localb.OWf);
          i = 1;
        }
      }
    }
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.QGr != 0.0F) || (this.QGA != null);
  }
  
  public final boolean isTextSelectable()
  {
    if (this.QHs == null) {
      return false;
    }
    return this.QHs.QIO;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(205721);
    super.jumpDrawablesToCurrentState();
    if (this.QGA != null)
    {
      Drawable[] arrayOfDrawable = this.QGA.QHE;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if (localDrawable != null) {
          localDrawable.jumpToCurrentState();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(205721);
  }
  
  protected boolean jw()
  {
    return true;
  }
  
  final CharSequence lA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205828);
    CharSequence localCharSequence = ax(this.OVq.subSequence(paramInt1, paramInt2));
    AppMethodBeat.o(205828);
    return localCharSequence;
  }
  
  protected final void lB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205852);
    ((Editable)this.mText).delete(paramInt1, paramInt2);
    AppMethodBeat.o(205852);
  }
  
  public int length()
  {
    AppMethodBeat.i(205578);
    int i = this.mText.length();
    AppMethodBeat.o(205578);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(205713);
    super.onAttachedToWindow();
    if (this.QHs != null)
    {
      b localb = this.QHs;
      ViewTreeObserver localViewTreeObserver = localb.QIo.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (localb.QIs != null) {
          localViewTreeObserver.addOnTouchModeChangeListener(localb.QIs);
        }
        if (localb.QIt != null)
        {
          localb.QIt.haN();
          localViewTreeObserver.addOnTouchModeChangeListener(localb.QIt);
        }
        localViewTreeObserver.addOnDrawListener(localb.QIA);
      }
      if (localb.QIo.hasSelection()) {
        localb.hai();
      }
      localb.gZS();
    }
    if (this.QGv)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.QGv = false;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205555);
        CustomTextView localCustomTextView = CustomTextView.this;
        boolean bool = localCustomTextView.gZN();
        Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isNeedReuseMenuItems:".concat(String.valueOf(bool)));
        if (bool)
        {
          bool = localCustomTextView.isAttachedToWindow();
          Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isWindowAttached:".concat(String.valueOf(bool)));
          if (bool)
          {
            Log.i("cmEdit.CMTextView", "checkInitAdaptEdt mIsInitAdapt:" + localCustomTextView.QHy);
            if (!localCustomTextView.QHy)
            {
              localCustomTextView.QHy = true;
              try
              {
                AdaptEditText localAdaptEditText = new AdaptEditText(localCustomTextView.getContext());
                if ((localCustomTextView.getParent() instanceof ViewGroup))
                {
                  ((ViewGroup)localCustomTextView.getParent()).addView(localAdaptEditText);
                  localAdaptEditText.setVisibility(8);
                  localCustomTextView.setAdaptText(localAdaptEditText);
                }
                AppMethodBeat.o(205555);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.e("cmEdit.CMTextView", "initAdapt err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
                com.tencent.mm.ui.widget.cedit.api.b.aow(7);
              }
            }
          }
        }
        AppMethodBeat.o(205555);
      }
    });
    AppMethodBeat.o(205713);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return (this.QHs != null) && (this.QHs.Clf != 0);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(205629);
    super.onConfigurationChanged(paramConfiguration);
    if (!this.QGL)
    {
      if (Build.VERSION.SDK_INT < 24) {
        break label62;
      }
      this.ayn.setTextLocales(LocaleList.getDefault());
    }
    for (;;)
    {
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(205629);
      return;
      label62:
      this.ayn.setTextLocale(Locale.getDefault());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(205725);
    int[] arrayOfInt1;
    int i;
    if (this.OSP)
    {
      arrayOfInt1 = super.onCreateDrawableState(paramInt);
      if (isTextSelectable())
      {
        i = arrayOfInt1.length;
        paramInt = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt >= i) {
          break label111;
        }
        if (arrayOfInt1[paramInt] == 16842919)
        {
          int[] arrayOfInt2 = new int[i - 1];
          System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, paramInt);
          System.arraycopy(arrayOfInt1, paramInt + 1, arrayOfInt2, paramInt, i - paramInt - 1);
          AppMethodBeat.o(205725);
          return arrayOfInt2;
          arrayOfInt1 = super.onCreateDrawableState(paramInt + 1);
          mergeDrawableStates(arrayOfInt1, QGl);
          break;
        }
        paramInt += 1;
      }
    }
    label111:
    AppMethodBeat.o(205725);
    return arrayOfInt1;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(205740);
    if ((onCheckIsTextEditor()) && (isEnabled()))
    {
      Object localObject = this.QHs;
      if (((b)localObject).QID == null) {
        ((b)localObject).QID = new b.h();
      }
      paramEditorInfo.inputType = getInputType();
      if (this.QHs.QIC != null)
      {
        paramEditorInfo.imeOptions = this.QHs.QIC.imeOptions;
        paramEditorInfo.privateImeOptions = this.QHs.QIC.privateImeOptions;
        paramEditorInfo.actionLabel = this.QHs.QIC.QKh;
        paramEditorInfo.actionId = this.QHs.QIC.imeActionId;
        paramEditorInfo.extras = this.QHs.QIC.extras;
        if (Build.VERSION.SDK_INT >= 24) {
          paramEditorInfo.hintLocales = this.QHs.QIC.QKk;
        }
        if ((paramEditorInfo.imeOptions & 0xFF) == 0) {
          if ((paramEditorInfo.imeOptions & 0x8000000) == 0) {
            break label312;
          }
        }
      }
      label312:
      for (paramEditorInfo.imeOptions |= 0x5;; paramEditorInfo.imeOptions |= 0x6)
      {
        if (!gZu()) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        if (aox(paramEditorInfo.inputType)) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        paramEditorInfo.hintText = this.QGE;
        if (!(this.mText instanceof Editable)) {
          break label326;
        }
        localObject = new a(this);
        paramEditorInfo.initialSelStart = getSelectionStart();
        paramEditorInfo.initialSelEnd = getSelectionEnd();
        paramEditorInfo.initialCapsMode = ((InputConnection)localObject).getCursorCapsMode(getInputType());
        AppMethodBeat.o(205740);
        return localObject;
        paramEditorInfo.imeOptions = 0;
        if (Build.VERSION.SDK_INT < 24) {
          break;
        }
        paramEditorInfo.hintLocales = null;
        break;
      }
    }
    label326:
    AppMethodBeat.o(205740);
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(205714);
    super.onDetachedFromWindow();
    if (this.QGu)
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.QGv = true;
    }
    this.QGB = -1;
    if (this.QHs != null)
    {
      b localb = this.QHs;
      localb.gZR();
      if (localb.QIs != null) {
        localb.QIs.onDetached();
      }
      if (localb.QIt != null) {
        localb.QIt.onDetached();
      }
      if (localb.QIX != null) {
        localb.QIo.removeCallbacks(localb.QIX);
      }
      if (localb.QJk != null) {
        localb.QIo.removeCallbacks(localb.QJk);
      }
      localb.QIo.removeCallbacks(localb.QJp);
      ViewTreeObserver localViewTreeObserver = localb.QIo.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnDrawListener(localb.QIA);
      }
      localb.gZQ();
      localb.hav();
    }
    AppMethodBeat.o(205714);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    AppMethodBeat.i(205848);
    switch (paramDragEvent.getAction())
    {
    case 4: 
    default: 
      AppMethodBeat.o(205848);
      return true;
    case 1: 
      if ((this.QHs != null) && (this.QHs.QIv))
      {
        AppMethodBeat.o(205848);
        return true;
      }
      AppMethodBeat.o(205848);
      return false;
    case 5: 
      requestFocus();
      AppMethodBeat.o(205848);
      return true;
    case 2: 
      if ((this.mText instanceof Spannable))
      {
        int i = getOffsetForPosition(paramDragEvent.getX(), paramDragEvent.getY());
        Selection.setSelection(this.QGC, i);
      }
      AppMethodBeat.o(205848);
      return true;
    }
    if (this.QHs != null) {
      this.QHs.a(paramDragEvent);
    }
    AppMethodBeat.o(205848);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(205727);
    super.onDraw(paramCanvas);
    int k = getCompoundPaddingLeft();
    int i2 = getCompoundPaddingTop();
    int i7 = getCompoundPaddingRight();
    int i3 = getCompoundPaddingBottom();
    int i4 = getScrollX();
    int m = getScrollY();
    int i5 = getRight();
    int i6 = getLeft();
    int n = getBottom();
    int i1 = getTop();
    int i = getHorizontalOffsetForDrawables();
    Object localObject1 = this.QGA;
    if (localObject1 != null)
    {
      j = n - i1 - i3 - i2;
      i7 = i5 - i6 - i7 - k;
      if (localObject1.QHE[0] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i + (getPaddingLeft() + i4), m + i2 + (j - ((b)localObject1).OWk) / 2);
        localObject1.QHE[0].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.QHE[2] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + i5 - i6 - getPaddingRight() - ((b)localObject1).OWh + 0, (j - ((b)localObject1).OWl) / 2 + (m + i2));
        localObject1.QHE[2].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.QHE[1] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + k + (i7 - ((b)localObject1).OWi) / 2, getPaddingTop() + m);
        localObject1.QHE[1].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.QHE[3] != null)
      {
        paramCanvas.save();
        paramCanvas.translate((i7 - ((b)localObject1).OWj) / 2 + (i4 + k), m + n - i1 - getPaddingBottom() - ((b)localObject1).OWf);
        localObject1.QHE[3].draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    i = this.OVm;
    if (this.OVt == null) {
      gLs();
    }
    Object localObject2 = this.OVt;
    int j = i;
    localObject1 = localObject2;
    if (this.QGE != null)
    {
      j = i;
      localObject1 = localObject2;
      if (this.mText.length() == 0)
      {
        if (this.QGn != null) {
          i = this.QGp;
        }
        localObject1 = this.QGF;
        j = i;
      }
    }
    this.ayn.setColor(j);
    this.ayn.drawableState = getDrawableState();
    paramCanvas.save();
    i7 = getExtendedPaddingTop();
    i = getExtendedPaddingBottom();
    j = getBottom();
    int i8 = getTop();
    int i9 = this.OVt.getHeight();
    float f3 = k + i4;
    float f1;
    float f2;
    float f4;
    if (m == 0)
    {
      f1 = 0.0F;
      f2 = i5 - i6 - getCompoundPaddingRight() + i4;
      if (m == i9 - (j - i8 - i3 - i2)) {
        i = 0;
      }
      f4 = n - i1 + m - i;
      if (this.QGr == 0.0F) {
        break label1252;
      }
      f3 += Math.min(0.0F, this.QGs - this.QGr);
      f2 = Math.max(0.0F, this.QGs + this.QGr) + f2;
      f1 += Math.min(0.0F, this.QGt - this.QGr);
      f4 = Math.max(0.0F, this.QGt + this.QGr) + f4;
    }
    label900:
    label952:
    label992:
    label1252:
    for (;;)
    {
      paramCanvas.clipRect(f3, f1, f2, f4);
      j = 0;
      i = 0;
      if ((this.Ku & 0x70) != 48)
      {
        j = CW(false);
        i = CW(true);
      }
      paramCanvas.translate(k, i7 + j);
      j = i - j;
      Path localPath = getUpdatedHighlightPath();
      Object localObject3;
      label872:
      long l;
      if (this.QHs != null)
      {
        b localb = this.QHs;
        Paint localPaint = this.QHg;
        k = localb.QIo.getSelectionStart();
        m = localb.QIo.getSelectionEnd();
        localObject2 = localb.QID;
        if ((localObject2 != null) && (((b.h)localObject2).QIp == 0))
        {
          localObject3 = localb.getInputMethodManager();
          if ((localObject3 != null) && (((InputMethodManager)localObject3).isActive(localb.QIo)) && ((((b.h)localObject2).mContentChanged) || (((b.h)localObject2).QKo))) {
            localb.hae();
          }
        }
        if (localb.QIB != null)
        {
          localObject2 = localb.QIB;
          localObject3 = ((b.b)localObject2).QJz.QIo.getLayout();
          if (localObject3 == null)
          {
            i = 0;
            if (i == 0) {
              break label1215;
            }
            l = SystemClock.uptimeMillis() - ((b.b)localObject2).QJA;
            if (l <= 400L) {
              break label1142;
            }
            i = 0;
            if (i == 0) {
              break label1215;
            }
            if (j != 0) {
              paramCanvas.translate(0.0F, j);
            }
            paramCanvas.drawPath(((b.b)localObject2).xT, ((b.b)localObject2).mPaint);
            if (j != 0) {
              paramCanvas.translate(0.0F, -j);
            }
            ((b.b)localObject2).Da(true);
          }
        }
        else
        {
          localObject2 = localPath;
          if (localPath != null)
          {
            localObject2 = localPath;
            if (k == m)
            {
              localObject2 = localPath;
              if (localb.QIY != null)
              {
                if (j == 0) {
                  break label1229;
                }
                i = 1;
                if (i != 0) {
                  paramCanvas.translate(0.0F, j);
                }
                if (localb.QIY != null) {
                  localb.QIY.draw(paramCanvas);
                }
                if (i != 0) {
                  paramCanvas.translate(0.0F, -j);
                }
                localObject2 = null;
              }
            }
          }
          ((Layout)localObject1).draw(paramCanvas, (Path)localObject2, localPaint, j);
        }
      }
      for (;;)
      {
        paramCanvas.restore();
        AppMethodBeat.o(205727);
        return;
        f1 = i7 + m;
        break;
        n = ((b.b)localObject2).QJz.QIo.getText().length();
        i = Math.min(n, ((b.b)localObject2).avh);
        n = Math.min(n, ((b.b)localObject2).Pc);
        ((b.b)localObject2).xT.reset();
        ((Layout)localObject3).getSelectionPath(i, n, ((b.b)localObject2).xT);
        i = 1;
        break label872;
        label1142:
        f1 = (float)l / 400.0F;
        n = Color.alpha(((b.b)localObject2).QJz.QIo.oEF);
        i = ((b.b)localObject2).QJz.QIo.oEF;
        n = (int)((1.0F - f1) * n);
        ((b.b)localObject2).mPaint.setColor((n << 24) + (i & 0xFFFFFF));
        i = 1;
        break label900;
        ((b.b)localObject2).stopAnimation();
        ((b.b)localObject2).Da(false);
        break label952;
        i = 0;
        break label992;
        ((Layout)localObject1).draw(paramCanvas, localPath, this.QHg, j);
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(205786);
    if ((Build.VERSION.SDK_INT >= 24) && (isTemporarilyDetached()))
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      AppMethodBeat.o(205786);
      return;
    }
    if (this.QHs != null) {
      this.QHs.af(paramBoolean, paramInt);
    }
    if ((paramBoolean) && (this.QGC != null)) {
      MetaKeyKeyListener.resetMetaState(this.QGC);
    }
    if (this.QGH != null) {
      this.QGH.onFocusChanged(this, this.mText, paramBoolean, paramInt, paramRect);
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    AppMethodBeat.o(205786);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205793);
    if ((this.QGG != null) && ((this.mText instanceof Spannable)) && (this.OVt != null)) {
      try
      {
        bool = this.QGG.a(this, paramMotionEvent);
        if (bool)
        {
          AppMethodBeat.o(205793);
          return true;
        }
      }
      catch (AbstractMethodError localAbstractMethodError) {}
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(205793);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205734);
    if (a(paramInt, paramKeyEvent, null) == 0)
    {
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(205734);
      return bool;
    }
    AppMethodBeat.o(205734);
    return true;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205735);
    KeyEvent localKeyEvent = KeyEvent.changeAction(paramKeyEvent, 0);
    int i = a(paramInt1, localKeyEvent, paramKeyEvent);
    if (i == 0)
    {
      boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(205735);
      return bool;
    }
    if (i == -1)
    {
      AppMethodBeat.o(205735);
      return true;
    }
    paramInt2 -= 1;
    paramKeyEvent = KeyEvent.changeAction(paramKeyEvent, 1);
    if (i == 1)
    {
      this.QHs.QIH.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.QHs.QIH.onKeyDown(this, (Editable)this.mText, paramInt1, localKeyEvent);
        this.QHs.QIH.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      }
    }
    if (i == 2) {
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.QGG.a(this, this.QGC, paramInt1, localKeyEvent);
      }
    }
    AppMethodBeat.o(205735);
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(205733);
    if (paramInt == 4)
    {
      int i = j;
      if (this.QHs != null)
      {
        if (!this.QHs.ham()) {
          break label49;
        }
        i = j;
      }
      while (i != 0)
      {
        AppMethodBeat.o(205733);
        return true;
        label49:
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          i = 1;
        }
        else
        {
          i = j;
          if (paramKeyEvent.getAction() == 1)
          {
            localDispatcherState = getKeyDispatcherState();
            if (localDispatcherState != null) {
              localDispatcherState.handleUpEvent(paramKeyEvent);
            }
            i = j;
            if (paramKeyEvent.isTracking())
            {
              i = j;
              if (!paramKeyEvent.isCanceled())
              {
                gZE();
                i = 1;
              }
            }
          }
        }
      }
    }
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(205733);
    return bool;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205806);
    if (paramKeyEvent.hasModifiers(4096)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      for (;;)
      {
        bool = super.onKeyShortcut(paramInt, paramKeyEvent);
        AppMethodBeat.o(205806);
        return bool;
        if (gZC())
        {
          bool = onTextContextMenuItem(16908319);
          AppMethodBeat.o(205806);
          return bool;
          if (gZF())
          {
            bool = onTextContextMenuItem(16908320);
            AppMethodBeat.o(205806);
            return bool;
            if (gZG())
            {
              bool = onTextContextMenuItem(16908321);
              AppMethodBeat.o(205806);
              return bool;
              if (gZH())
              {
                bool = onTextContextMenuItem(16908322);
                AppMethodBeat.o(205806);
                return bool;
                if (paramKeyEvent.hasModifiers(4097)) {
                  switch (paramInt)
                  {
                  }
                }
              }
            }
          }
        }
      }
    } while (!gZH());
    boolean bool = onTextContextMenuItem(16908337);
    AppMethodBeat.o(205806);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205738);
    if (!isEnabled())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(205738);
      return bool;
    }
    if (!KeyEvent.isModifierKey(paramInt)) {
      this.QGz = false;
    }
    switch (paramInt)
    {
    }
    while ((this.QHs != null) && (this.QHs.QIH != null) && (this.QHs.QIH.onKeyUp(this, (Editable)this.mText, paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(205738);
      return true;
      Object localObject;
      if ((paramKeyEvent.hasNoModifiers()) && (!hasOnClickListeners()) && (this.QGG != null) && ((this.mText instanceof Editable)) && (this.OVt != null) && (onCheckIsTextEditor()))
      {
        localObject = getInputMethodManager();
        a((InputMethodManager)localObject);
        if ((localObject != null) && (getShowSoftInputOnFocus())) {
          ((InputMethodManager)localObject).showSoftInput(this, 0);
        }
      }
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(205738);
      return bool;
      if (paramKeyEvent.hasNoModifiers())
      {
        if ((this.QHs != null) && (this.QHs.QIC != null) && (this.QHs.QIC.QKi != null) && (this.QHs.QIC.QKj))
        {
          this.QHs.QIC.QKj = false;
          if (this.QHs.QIC.QKi.a(this, 0))
          {
            AppMethodBeat.o(205738);
            return true;
          }
        }
        if ((((paramKeyEvent.getFlags() & 0x10) != 0) || (gZu())) && (!hasOnClickListeners()))
        {
          localObject = focusSearch(130);
          if (localObject != null)
          {
            if (!((View)localObject).requestFocus(130))
            {
              paramKeyEvent = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(205738);
              throw paramKeyEvent;
            }
            super.onKeyUp(paramInt, paramKeyEvent);
            AppMethodBeat.o(205738);
            return true;
          }
          if ((paramKeyEvent.getFlags() & 0x10) != 0)
          {
            localObject = getInputMethodManager();
            if ((localObject != null) && (((InputMethodManager)localObject).isActive(this))) {
              ((InputMethodManager)localObject).hideSoftInputFromWindow(getWindowToken(), 0);
            }
          }
        }
        bool = super.onKeyUp(paramInt, paramKeyEvent);
        AppMethodBeat.o(205738);
        return bool;
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(205738);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205759);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.QGY >= 0)
    {
      paramInt1 = this.QGY;
      this.QGY = -1;
      bringPointIntoView(Math.min(paramInt1, this.mText.length()));
    }
    AppMethodBeat.o(205759);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205754);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    BoringLayout.Metrics localMetrics1 = OVU;
    BoringLayout.Metrics localMetrics2 = OVU;
    if (this.Om == null) {
      this.Om = getTextDirectionHeuristic();
    }
    int i = -1;
    int j;
    Object localObject;
    label99:
    int k;
    if (i2 == 1073741824)
    {
      paramInt1 = n;
      j = 0;
      localObject = localMetrics2;
      n = paramInt1 - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if (!this.QGQ) {
        break label878;
      }
      paramInt2 = 1048576;
      if (this.QGF == null)
      {
        k = paramInt2;
        label109:
        if (this.OVt == null) {
          break label814;
        }
        if ((this.OVt.getWidth() == paramInt2) && (k == paramInt2) && (this.OVt.getEllipsizedWidth() == paramInt1 - getCompoundPaddingLeft() - getCompoundPaddingRight())) {
          break label797;
        }
        k = 1;
        label157:
        if ((this.QGE != null) || (this.OVp != null) || (paramInt2 <= this.OVt.getWidth()) || ((!(this.OVt instanceof BoringLayout)) && ((j == 0) || (i < 0) || (i > paramInt2)))) {
          break label803;
        }
        i = 1;
        label208:
        if ((this.OVx == this.QGV) && (this.OVw == this.QGU)) {
          break label808;
        }
        j = 1;
        label233:
        if ((k != 0) || (j != 0))
        {
          if ((j != 0) || (i == 0)) {
            break label814;
          }
          this.OVt.increaseWidthTo(paramInt2);
        }
        label260:
        if (i1 != 1073741824) {
          break label839;
        }
        this.OVC = -1;
        paramInt2 = m;
        label276:
        j = paramInt2 - getCompoundPaddingTop() - getCompoundPaddingBottom();
        i = j;
        if (this.OVx == 1)
        {
          i = j;
          if (this.OVt.getLineCount() > this.OVw) {
            i = Math.min(j, this.OVt.getLineTop(this.OVw));
          }
        }
        if ((this.QGG == null) && (this.OVt.getWidth() <= n) && (this.OVt.getHeight() <= i)) {
          break label869;
        }
        gZt();
        label368:
        setMeasuredDimension(paramInt1, paramInt2);
        AppMethodBeat.o(205754);
      }
    }
    else
    {
      if ((this.OVt == null) || (this.OVp != null)) {
        break label913;
      }
    }
    label773:
    label908:
    label913:
    for (paramInt2 = b(this.OVt);; paramInt2 = -1)
    {
      if (paramInt2 < 0)
      {
        localMetrics1 = BoringLayout.isBoring(this.OVq, this.ayn, this.QGZ);
        if (localMetrics1 == null) {
          break label908;
        }
        this.QGZ = localMetrics1;
        paramInt1 = 0;
      }
      for (;;)
      {
        label437:
        if ((localMetrics1 == null) || (localMetrics1 == OVU))
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            i = (int)Math.ceil(Layout.getDesiredWidth(this.OVq, 0, this.OVq.length(), this.ayn));
          }
          j = i;
          paramInt2 = i;
          label488:
          localObject = this.QGA;
          i = j;
          if (localObject != null) {
            i = Math.max(Math.max(j, ((b)localObject).OWi), ((b)localObject).OWj);
          }
          j = i;
          localObject = localMetrics2;
          if (this.QGE != null)
          {
            k = -1;
            j = k;
            if (this.QGF != null)
            {
              j = k;
              if (this.OVp == null) {
                j = b(this.QGF);
              }
            }
            if (j >= 0) {
              break label901;
            }
            localMetrics2 = BoringLayout.isBoring(this.QGE, this.ayn, this.QHa);
            localObject = localMetrics2;
            if (localMetrics2 != null) {
              this.QHa = localMetrics2;
            }
          }
        }
        label797:
        label803:
        for (localObject = localMetrics2;; localObject = localMetrics2)
        {
          k = j;
          if (localObject != null)
          {
            if (localObject == OVU) {
              k = j;
            }
          }
          else {
            label631:
            if (k <= i) {
              break label895;
            }
          }
          label676:
          label808:
          label814:
          label839:
          label869:
          label878:
          label884:
          label895:
          for (j = k;; j = i)
          {
            i = getCompoundPaddingLeft() + getCompoundPaddingRight() + j;
            if (this.QGW == 1)
            {
              i = Math.min(i, this.mMaxWidth * getLineHeight());
              if (this.QGX != 1) {
                break label773;
              }
            }
            for (i = Math.max(i, this.mMinWidth * getLineHeight());; i = Math.max(i, this.mMinWidth))
            {
              k = Math.max(i, getSuggestedMinimumWidth());
              if (i2 != -2147483648) {
                break label884;
              }
              k = Math.min(n, k);
              i = paramInt2;
              j = paramInt1;
              paramInt1 = k;
              break;
              paramInt1 = 1;
              break label437;
              j = localMetrics1.width;
              break label488;
              k = ((BoringLayout.Metrics)localObject).width;
              break label631;
              i = Math.min(i, this.mMaxWidth);
              break label676;
            }
            k = this.QGF.getWidth();
            break label109;
            k = 0;
            break label157;
            i = 0;
            break label208;
            j = 0;
            break label233;
            a(paramInt2, paramInt2, localMetrics1, (BoringLayout.Metrics)localObject, paramInt1 - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
            break label260;
            i = getDesiredHeight();
            this.OVC = i;
            paramInt2 = i;
            if (i1 != -2147483648) {
              break label276;
            }
            paramInt2 = Math.min(i, m);
            break label276;
            scrollTo(0, 0);
            break label368;
            paramInt2 = n;
            break label99;
            i = paramInt2;
            j = paramInt1;
            paramInt1 = k;
            break;
          }
        }
        paramInt1 = 0;
      }
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(205712);
    if (this.OVt == null) {
      gLs();
    }
    int j;
    if (this.QGG != null)
    {
      j = getSelectionEnd();
      i = j;
      if (this.QHs != null)
      {
        i = j;
        if (this.QHs.QIt != null)
        {
          i = j;
          if (this.QHs.QIt.haP()) {
            i = getSelectionStart();
          }
        }
      }
      j = i;
      if (i < 0)
      {
        j = i;
        if ((this.Ku & 0x70) == 80) {
          j = this.mText.length();
        }
      }
      if (j >= 0) {
        bringPointIntoView(j);
      }
      if ((this.QHs != null) && (this.QHs.QJh))
      {
        this.QHs.hai();
        this.QHs.QJh = false;
      }
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.QGu = false;
      this.QGv = false;
      AppMethodBeat.o(205712);
      return true;
    }
    Layout localLayout;
    if (gZx())
    {
      localLayout = this.QGF;
      label181:
      if ((this.Ku & 0x70) != 80) {
        break label424;
      }
    }
    label419:
    label422:
    label424:
    for (int i = localLayout.getLineCount() - 1;; i = 0)
    {
      Layout.Alignment localAlignment1 = localLayout.getParagraphAlignment(i);
      int n = localLayout.getParagraphDirection(i);
      int i1 = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight();
      int k = getBottom() - getTop() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      int m = localLayout.getHeight();
      if (localAlignment1 != Layout.Alignment.ALIGN_NORMAL) {
        Layout.Alignment localAlignment2 = Layout.Alignment.ALIGN_OPPOSITE;
      }
      if (localAlignment1 == Layout.Alignment.ALIGN_CENTER)
      {
        j = (int)Math.floor(localLayout.getLineLeft(i));
        i = (int)Math.ceil(localLayout.getLineRight(i));
        if (i - j < i1)
        {
          i = (i + j) / 2 - i1 / 2;
          label329:
          if ((m < k) || ((this.Ku & 0x70) != 80)) {
            break label419;
          }
        }
      }
      for (j = m - k;; j = 0)
      {
        if ((i == getScrollX()) && (j == getScrollY())) {
          break label422;
        }
        scrollTo(i, j);
        break;
        localLayout = this.OVt;
        break label181;
        if (n < 0)
        {
          i -= i1;
          break label329;
        }
        i = j;
        break label329;
        i = (int)Math.floor(localLayout.getLineLeft(i));
        break label329;
      }
      break;
    }
  }
  
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(205732);
    if ((this.QGC != null) && (this.QGS))
    {
      int i = getOffsetForPosition(paramMotionEvent.getX(paramInt), paramMotionEvent.getY(paramInt));
      if ((((ClickableSpan[])this.QGC.getSpans(i, i, ClickableSpan.class)).length > 0) && (Build.VERSION.SDK_INT >= 24))
      {
        paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1002);
        AppMethodBeat.o(205732);
        return paramMotionEvent;
      }
    }
    if (((isTextSelectable()) || (gZB())) && (Build.VERSION.SDK_INT >= 24))
    {
      paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1008);
      AppMethodBeat.o(205732);
      return paramMotionEvent;
    }
    paramMotionEvent = super.onResolvePointerIcon(paramMotionEvent, paramInt);
    AppMethodBeat.o(205732);
    return paramMotionEvent;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(205680);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(205680);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.text != null) {
      setText(localSavedState.text);
    }
    if ((localSavedState.QHT >= 0) && (localSavedState.QHU >= 0) && (this.QGC != null))
    {
      int i = this.mText.length();
      if ((localSavedState.QHT <= i) && (localSavedState.QHU <= i)) {
        break label205;
      }
      paramParcelable = "";
      if (localSavedState.text != null) {
        paramParcelable = "(restored) ";
      }
      Log.e("cmEdit.CMTextView", "Saved cursor position " + localSavedState.QHT + "/" + localSavedState.QHU + " out of range for " + paramParcelable + "text " + this.mText);
    }
    for (;;)
    {
      if (localSavedState.QHW != null)
      {
        gZL();
        localSavedState.QHW.aBu.setDataPosition(0);
      }
      AppMethodBeat.o(205680);
      return;
      label205:
      Selection.setSelection(this.QGC, localSavedState.QHT, localSavedState.QHU);
      if (localSavedState.QHV)
      {
        gZL();
        this.QHs.QIE = true;
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(205849);
    super.onRtlPropertiesChanged(paramInt);
    TextDirectionHeuristic localTextDirectionHeuristic = getTextDirectionHeuristic();
    if (this.Om != localTextDirectionHeuristic)
    {
      this.Om = localTextDirectionHeuristic;
      if (this.OVt != null) {
        IR();
      }
    }
    AppMethodBeat.o(205849);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(205678);
    Object localObject = super.onSaveInstanceState();
    boolean bool = getFreezesText();
    int k = 0;
    int j;
    int i;
    if (this.mText != null)
    {
      j = getSelectionStart();
      i = getSelectionEnd();
      if ((j >= 0) || (i >= 0)) {
        k = 1;
      }
    }
    for (;;)
    {
      if ((bool) || (k != 0))
      {
        localObject = new SavedState((Parcelable)localObject);
        SpannableStringBuilder localSpannableStringBuilder;
        if (bool)
        {
          if (!(this.mText instanceof Spanned)) {
            break label160;
          }
          localSpannableStringBuilder = new SpannableStringBuilder(this.mText);
          if (this.QHs != null) {
            h(localSpannableStringBuilder);
          }
        }
        label160:
        for (((SavedState)localObject).text = localSpannableStringBuilder;; ((SavedState)localObject).text = this.mText.toString())
        {
          if (k != 0)
          {
            ((SavedState)localObject).QHT = j;
            ((SavedState)localObject).QHU = i;
          }
          if ((isFocused()) && (j >= 0) && (i >= 0)) {
            ((SavedState)localObject).QHV = true;
          }
          AppMethodBeat.o(205678);
          return localObject;
        }
      }
      AppMethodBeat.o(205678);
      return localObject;
      continue;
      i = -1;
      j = -1;
    }
  }
  
  public void onScreenStateChanged(int paramInt)
  {
    AppMethodBeat.i(205715);
    super.onScreenStateChanged(paramInt);
    b localb;
    if (this.QHs != null)
    {
      localb = this.QHs;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(205715);
      return;
      localb.gZS();
      AppMethodBeat.o(205715);
      return;
      localb.gZR();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205830);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.QHs != null)
    {
      b localb = this.QHs;
      if (localb.QJc != null) {
        localb.QJc.QKQ = true;
      }
      if ((localb.QIu != null) && (Build.VERSION.SDK_INT >= 23)) {
        localb.QIu.invalidateContentRect();
      }
    }
    AppMethodBeat.o(205830);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(205827);
    int i = this.mText.length();
    int j;
    if (isFocused())
    {
      i = getSelectionStart();
      int k = getSelectionEnd();
      j = Math.max(0, Math.min(i, k));
      i = Math.max(0, Math.max(i, k));
    }
    for (;;)
    {
      Object localObject1;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(205827);
        return false;
      case 16908319: 
        boolean bool = hasSelection();
        gZJ();
        if ((this.QHs != null) && (bool)) {
          this.QHs.hao().haV();
        }
        AppMethodBeat.o(205827);
        return true;
      case 16908338: 
        AppMethodBeat.o(205827);
        return true;
      case 16908339: 
        AppMethodBeat.o(205827);
        return true;
      case 16908322: 
        M(j, i, true);
        AppMethodBeat.o(205827);
        return true;
      case 16908337: 
        M(j, i, false);
        AppMethodBeat.o(205827);
        return true;
      case 16908320: 
        if (a(ClipData.newPlainText(null, lA(j, i)))) {
          lB(j, i);
        }
        for (;;)
        {
          AppMethodBeat.o(205827);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908321: 
        paramInt = getSelectionStart();
        i = getSelectionEnd();
        if (a(ClipData.newPlainText(null, lA(Math.max(0, Math.min(paramInt, i)), Math.max(0, Math.max(paramInt, i)))))) {
          gZE();
        }
        for (;;)
        {
          AppMethodBeat.o(205827);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908340: 
        if (this.QHs != null)
        {
          localObject1 = this.QHs;
          ((b)localObject1).gZQ();
          paramInt = (((b)localObject1).QIo.getSelectionStart() + ((b)localObject1).QIo.getSelectionEnd()) / 2;
          Selection.setSelection((Spannable)((b)localObject1).QIo.getText(), paramInt);
        }
        AppMethodBeat.o(205827);
        return true;
      case 16908341: 
        localObject1 = getSelectedText();
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
        {
          Object localObject2 = new Intent("android.intent.action.SEND");
          ((Intent)localObject2).setType("text/plain");
          ((Intent)localObject2).removeExtra("android.intent.extra.TEXT");
          ((Intent)localObject2).putExtra("android.intent.extra.TEXT", (String)com.tencent.mm.ui.widget.cedit.util.c.n((CharSequence)localObject1, 100000));
          localObject1 = getContext();
          localObject2 = Intent.createChooser((Intent)localObject2, null);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Selection.setSelection(this.QGC, getSelectionEnd());
        }
        AppMethodBeat.o(205827);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = (AutofillManager)getContext().getSystemService(AutofillManager.class);
        if (localObject1 != null) {
          ((AutofillManager)localObject1).requestAutofill(this);
        }
      }
      gZE();
      AppMethodBeat.o(205827);
      return true;
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205792);
    if (!c(paramMotionEvent, false))
    {
      AppMethodBeat.o(205792);
      return true;
    }
    int k = paramMotionEvent.getActionMasked();
    Object localObject1;
    int m;
    if (this.QHs != null)
    {
      localObject1 = this.QHs;
      if (paramMotionEvent.isFromSource(8194)) {
        if (((((b)localObject1).QJi ^ paramMotionEvent.getButtonState()) & 0x1) != 0)
        {
          i = 1;
          m = paramMotionEvent.getActionMasked();
          if (((m != 0) && (m != 1)) || (i != 0)) {
            break label160;
          }
          i = 1;
        }
      }
      for (;;)
      {
        ((b)localObject1).QJi = paramMotionEvent.getButtonState();
        if (i == 0) {
          break label186;
        }
        if (paramMotionEvent.getActionMasked() == 1) {
          ((b)localObject1).QII = true;
        }
        if ((this.QHs.QIs == null) || (!this.QHs.QIs.haB())) {
          break label806;
        }
        AppMethodBeat.o(205792);
        return true;
        i = 0;
        break;
        label160:
        if ((m == 2) && (!paramMotionEvent.isButtonPressed(1))) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label186:
      Object localObject2 = ViewConfiguration.get(((b)localObject1).QIo.getContext());
      c localc = ((b)localObject1).QJj;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0)
      {
        bool1 = paramMotionEvent.isFromSource(8194);
        long l1 = paramMotionEvent.getEventTime();
        long l2 = localc.QLr;
        long l3 = localc.QLr;
        long l4 = localc.QLo;
        if ((l1 - l2 <= ViewConfiguration.getDoubleTapTimeout()) && (l3 - l4 <= ViewConfiguration.getDoubleTapTimeout()) && ((localc.QLt == 1) || ((localc.QLt == 2) && (bool1)))) {
          if (localc.QLt == 1)
          {
            localc.QLt = 2;
            label317:
            localc.QLu = c.a(localc.ovM, localc.ovN, paramMotionEvent.getX(), paramMotionEvent.getY(), ((ViewConfiguration)localObject2).getScaledDoubleTapSlop());
            label348:
            localc.ovM = paramMotionEvent.getX();
            localc.ovN = paramMotionEvent.getY();
            localc.QLo = paramMotionEvent.getEventTime();
            localc.QLv = false;
            localc.QLw = false;
            label387:
            ((b)localObject1).ap(paramMotionEvent);
            if (((b)localObject1).QIv)
            {
              localObject2 = ((b)localObject1).haw();
              if ((!((b.j)localObject2).QJz.QIw) || (!((b.j)localObject2).QJz.hax().haB())) {
                switch (paramMotionEvent.getActionMasked())
                {
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (((b)localObject1).QIw) {
          ((b)localObject1).hax().onTouchEvent(paramMotionEvent);
        }
        if (((b)localObject1).QIX != null)
        {
          ((b)localObject1).QIo.removeCallbacks(((b)localObject1).QIX);
          ((b)localObject1).QIX = null;
        }
        if (paramMotionEvent.getActionMasked() != 0) {
          break;
        }
        ((b)localObject1).QIG = false;
        ((b)localObject1).PPd = false;
        break;
        localc.QLt = 3;
        break label317;
        localc.QLt = 1;
        localc.QLu = false;
        break label348;
        if (i == 1)
        {
          localc.QLp = paramMotionEvent.getX();
          localc.QLq = paramMotionEvent.getY();
          localc.QLr = paramMotionEvent.getEventTime();
          localc.QLv = false;
          localc.QLw = false;
          break label387;
        }
        if (i == 2)
        {
          if (localc.QLv) {
            break label387;
          }
          float f1 = paramMotionEvent.getX() - localc.ovM;
          float f2 = paramMotionEvent.getY() - localc.ovN;
          i = ((ViewConfiguration)localObject2).getScaledTouchSlop();
          if (f1 * f1 + f2 * f2 > i * i)
          {
            bool1 = true;
            label666:
            localc.QLv = bool1;
            if (!localc.QLv) {
              break label387;
            }
            if (Math.abs(f1) > Math.abs(f2)) {
              break label712;
            }
          }
          label712:
          for (bool1 = true;; bool1 = false)
          {
            localc.QLw = bool1;
            break;
            bool1 = false;
            break label666;
          }
        }
        if (i != 3) {
          break label387;
        }
        localc.QLo = 0L;
        localc.QLr = 0L;
        localc.QLt = 0;
        localc.QLu = false;
        localc.QLv = false;
        localc.QLw = false;
        break label387;
        if ((!paramMotionEvent.isFromSource(8194)) && (((b.j)localObject2).QKA))
        {
          ((b.j)localObject2).as(paramMotionEvent);
          continue;
          if (((b.j)localObject2).QKA) {
            ((b.j)localObject2).haI();
          }
        }
      }
      label806:
      if ((this.QHs.QIt != null) && (this.QHs.QIt.haQ()))
      {
        AppMethodBeat.o(205792);
        return true;
      }
    }
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    if ((this.QHs != null) && (this.QHs.QII) && (k == 1))
    {
      this.QHs.QII = false;
      if (this.QHs.QJq)
      {
        this.QHs.haj();
        this.QHs.QJq = false;
      }
      AppMethodBeat.o(205792);
      return bool1;
    }
    if ((k == 1) && ((this.QHs == null) || (!this.QHs.PPd)) && (isFocused()))
    {
      k = 1;
      if (((this.QGG == null) && (!onCheckIsTextEditor())) || (!isEnabled()) || (!(this.mText instanceof Spannable)) || (this.OVt == null)) {
        break label1175;
      }
      if (this.QGG == null) {
        break label1187;
      }
    }
    label1175:
    label1187:
    for (int j = this.QGG.a(this, this.QGC, paramMotionEvent) | false;; j = 0)
    {
      boolean bool2 = isTextSelectable();
      if ((k != 0) && (this.QGS) && (this.QGR != 0) && (bool2))
      {
        localObject1 = (ClickableSpan[])this.QGC.getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
        if (localObject1.length > 0)
        {
          localObject1[0].onClick(this);
          j = 1;
        }
      }
      for (;;)
      {
        m = j;
        if (k != 0) {
          if (!gZB())
          {
            m = j;
            if (!bool2) {}
          }
          else
          {
            localObject1 = getInputMethodManager();
            a((InputMethodManager)localObject1);
            if ((gZB()) && (this.QHs.QIQ) && (localObject1 != null)) {
              ((InputMethodManager)localObject1).showSoftInput(this, 0);
            }
            this.QHs.aq(paramMotionEvent);
            m = 1;
          }
        }
        if (m != 0)
        {
          AppMethodBeat.o(205792);
          return true;
          k = 0;
          break;
        }
        AppMethodBeat.o(205792);
        return bool1;
      }
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205798);
    boolean bool = super.onTrackballEvent(paramMotionEvent);
    AppMethodBeat.o(205798);
    return bool;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(205788);
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.QHs != null) && (paramInt != 0))
    {
      this.QHs.gZQ();
      gZE();
    }
    AppMethodBeat.o(205788);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(205787);
    super.onWindowFocusChanged(paramBoolean);
    if (this.QHs != null)
    {
      b localb = this.QHs;
      if (paramBoolean)
      {
        if (localb.QIL != null)
        {
          localb.QIL.mCancelled = false;
          localb.haz();
        }
        if ((localb.QIo.hasSelection()) && (!localb.has()))
        {
          localb.hai();
          AppMethodBeat.o(205787);
        }
      }
      else
      {
        if (localb.QIL != null) {
          localb.QIL.cancel();
        }
        if (localb.QIC != null) {
          localb.QIC.QKj = false;
        }
        localb.gZQ();
        localb.hav();
        localb.had();
        localb.haa();
      }
    }
    AppMethodBeat.o(205787);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(205860);
    switch (paramInt)
    {
    default: 
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(205860);
      return bool1;
    case 2097152: 
      if ((!isEnabled()) || (this.QGD != TextView.BufferType.EDITABLE))
      {
        AppMethodBeat.o(205860);
        return false;
      }
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");; paramBundle = null)
      {
        setText(paramBundle);
        if (this.mText != null)
        {
          paramInt = this.mText.length();
          if (paramInt > 0) {
            Selection.setSelection(this.QGC, paramInt);
          }
        }
        AppMethodBeat.o(205860);
        return true;
      }
    case 16: 
      if (!isEnabled())
      {
        AppMethodBeat.o(205860);
        return false;
      }
      if ((isClickable()) || (isLongClickable()))
      {
        if ((isFocusable()) && (!isFocused())) {
          requestFocus();
        }
        performClick();
      }
      break;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (this.QGG == null)
      {
        bool2 = bool1;
        if (!onCheckIsTextEditor()) {}
      }
      else
      {
        if ((this.mText == null) || (!(this.mText instanceof Spannable))) {
          break label397;
        }
      }
      label397:
      for (paramInt = i;; paramInt = 0)
      {
        bool2 = bool1;
        if (paramInt != 0)
        {
          bool2 = bool1;
          if (this.OVt != null) {
            if (!gZB())
            {
              bool2 = bool1;
              if (!isTextSelectable()) {}
            }
            else
            {
              bool2 = bool1;
              if (isFocused())
              {
                paramBundle = getInputMethodManager();
                a(paramBundle);
                bool2 = bool1;
                if (!isTextSelectable())
                {
                  bool2 = bool1;
                  if (this.QHs.QIQ)
                  {
                    bool2 = bool1;
                    if (paramBundle != null) {
                      bool2 = bool1 | paramBundle.showSoftInput(this, 0);
                    }
                  }
                }
              }
            }
          }
        }
        AppMethodBeat.o(205860);
        return bool2;
      }
      if ((isFocused()) && (gZG()) && (onTextContextMenuItem(16908321)))
      {
        AppMethodBeat.o(205860);
        return true;
      }
      if ((isFocused()) && (gZH()) && (onTextContextMenuItem(16908322)))
      {
        AppMethodBeat.o(205860);
        return true;
      }
      AppMethodBeat.o(205860);
      return false;
      if ((isFocused()) && (gZF()) && (onTextContextMenuItem(16908320)))
      {
        AppMethodBeat.o(205860);
        return true;
      }
      AppMethodBeat.o(205860);
      return false;
      gZM();
      CharSequence localCharSequence = getIterableTextForAccessibility();
      if (localCharSequence == null)
      {
        AppMethodBeat.o(205860);
        return false;
      }
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT", -1);
        if (paramBundle == null) {
          break label610;
        }
        i = paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT", -1);
      }
      for (;;)
      {
        if ((getSelectionStart() != paramInt) || (getSelectionEnd() != i))
        {
          if ((paramInt == i) && (i == -1))
          {
            Selection.removeSelection((Spannable)localCharSequence);
            AppMethodBeat.o(205860);
            return true;
            paramInt = -1;
            break;
            label610:
            i = -1;
            continue;
          }
          if ((paramInt >= 0) && (paramInt <= i) && (i <= localCharSequence.length()))
          {
            Selection.setSelection((Spannable)localCharSequence, paramInt, i);
            if (this.QHs != null) {
              this.QHs.hao().haU();
            }
            AppMethodBeat.o(205860);
            return true;
          }
        }
      }
      AppMethodBeat.o(205860);
      return false;
      gZM();
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(205860);
      return bool1;
      if (!isLongClickable()) {
        break;
      }
      if ((isEnabled()) && (this.QGD == TextView.BufferType.EDITABLE)) {
        this.QHs.QIW = true;
      }
      for (;;)
      {
        try
        {
          bool1 = performLongClick();
          return bool1;
        }
        finally
        {
          this.QHs.QIW = false;
          AppMethodBeat.o(205860);
        }
        bool1 = performLongClick();
      }
    }
  }
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(205829);
    if (this.QHs != null) {
      this.QHs.QIV = true;
    }
    int i;
    if (super.performLongClick()) {
      i = 1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.QHs != null)
      {
        boolean bool3 = this.QHs.CY(bool1);
        bool2 = bool1 | bool3;
        Log.i("cmEdit.CMTextView", "editor performLongClick handled =".concat(String.valueOf(bool3)));
        this.QHs.QIV = false;
      }
      if (bool2)
      {
        if (i == 0) {
          performHapticFeedback(0);
        }
        if (this.QHs != null) {
          this.QHs.QII = true;
        }
      }
      AppMethodBeat.o(205829);
      return bool2;
      i = 0;
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(205778);
    if (this.mListeners != null)
    {
      int i = this.mListeners.indexOf(paramTextWatcher);
      if (i >= 0) {
        this.mListeners.remove(i);
      }
    }
    AppMethodBeat.o(205778);
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(205825);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      AppMethodBeat.o(205825);
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
    AppMethodBeat.o(205825);
  }
  
  public void setAdaptText(TextView paramTextView)
  {
    AppMethodBeat.i(205571);
    this.QHu = paramTextView;
    this.QHu.addTextChangedListener(this.QHv);
    AppMethodBeat.o(205571);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(205771);
    if (!paramBoolean) {
      setTransformationMethod(null);
    }
    AppMethodBeat.o(205771);
  }
  
  public final void setAutoLinkMask(int paramInt)
  {
    this.QGR = paramInt;
  }
  
  public void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(205646);
    this.On = paramInt;
    if (this.OVt != null)
    {
      gLr();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(205646);
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(205602);
    b localb2 = this.QGA;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.OWm = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(205602);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(getContext());
        this.QGA = localb1;
      }
    }
  }
  
  public void setCompoundDrawableTintBlendMode(BlendMode paramBlendMode)
  {
    AppMethodBeat.i(205604);
    if (this.QGA == null) {
      this.QGA = new b(getContext());
    }
    this.QGA.QHF = paramBlendMode;
    this.QGA.acU = true;
    gZq();
    AppMethodBeat.o(205604);
  }
  
  public void setCompoundDrawableTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(205603);
    if (this.QGA == null) {
      this.QGA = new b(getContext());
    }
    this.QGA.Kr = paramColorStateList;
    this.QGA.QHG = true;
    gZq();
    AppMethodBeat.o(205603);
  }
  
  public void setCompoundDrawableTintMode(PorterDuff.Mode paramMode) {}
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(205776);
    if ((paramBoolean) && (this.QHs == null))
    {
      AppMethodBeat.o(205776);
      return;
    }
    gZL();
    if (this.QHs.QIM != paramBoolean)
    {
      this.QHs.QIM = paramBoolean;
      invalidate();
      this.QHs.haz();
      this.QHs.gZP();
    }
    AppMethodBeat.o(205776);
  }
  
  public void setCustomInsertionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(205832);
    gZL();
    this.QHs.QJg = paramCallback;
    AppMethodBeat.o(205832);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(205831);
    gZL();
    this.QHs.QJf = paramCallback;
    AppMethodBeat.o(205831);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(205681);
    this.OVn = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(205681);
  }
  
  public void setElegantTextHeight(boolean paramBoolean)
  {
    AppMethodBeat.i(205640);
    if (paramBoolean != this.ayn.isElegantTextHeight())
    {
      this.ayn.setElegantTextHeight(paramBoolean);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205640);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(205774);
    if (this.OVp != paramTruncateAt)
    {
      this.OVp = paramTruncateAt;
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205774);
  }
  
  public void setEms(int paramInt)
  {
    AppMethodBeat.i(205671);
    this.mMinWidth = paramInt;
    this.mMaxWidth = paramInt;
    this.QGX = 1;
    this.QGW = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205671);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(205576);
    if (paramBoolean == isEnabled())
    {
      AppMethodBeat.o(205576);
      return;
    }
    InputMethodManager localInputMethodManager;
    if (!paramBoolean)
    {
      localInputMethodManager = getInputMethodManager();
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive(this))) {
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      }
    }
    super.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      localInputMethodManager = getInputMethodManager();
      if (localInputMethodManager != null) {
        localInputMethodManager.restartInput(this);
      }
    }
    if (this.QHs != null)
    {
      this.QHs.gZP();
      this.QHs.haz();
    }
    AppMethodBeat.o(205576);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205702);
    gZL();
    AppMethodBeat.o(205702);
  }
  
  public void setExtractedText(ExtractedText paramExtractedText)
  {
    int m = 0;
    AppMethodBeat.i(205742);
    Object localObject = getEditableText();
    int j;
    int k;
    if (paramExtractedText.text != null)
    {
      if (localObject == null) {
        setText(paramExtractedText.text, TextView.BufferType.EDITABLE);
      }
    }
    else
    {
      localObject = (Spannable)getText();
      j = ((Spannable)localObject).length();
      k = paramExtractedText.selectionStart;
      if (k >= 0) {
        break label297;
      }
      i = 0;
      label68:
      k = paramExtractedText.selectionEnd;
      if (k >= 0) {
        break label311;
      }
      j = m;
      label82:
      Selection.setSelection((Spannable)localObject, i, j);
      if ((paramExtractedText.flags & 0x2) == 0) {
        break label320;
      }
      com.tencent.mm.ui.widget.cedit.util.d.a(this, (Spannable)localObject);
      label104:
      if (Build.VERSION.SDK_INT >= 28) {
        setHintInternal(paramExtractedText.hint);
      }
      AppMethodBeat.o(205742);
      return;
    }
    int i = ((Editable)localObject).length();
    if (paramExtractedText.partialStartOffset >= 0)
    {
      k = ((Editable)localObject).length();
      j = paramExtractedText.partialStartOffset;
      i = j;
      if (j > k) {
        i = k;
      }
      j = paramExtractedText.partialEndOffset;
      if (j > k)
      {
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      Object[] arrayOfObject = ((Spannable)localObject).getSpans(j, i, ParcelableSpan.class);
      k = arrayOfObject.length;
      while (k > 0)
      {
        k -= 1;
        ((Spannable)localObject).removeSpan(arrayOfObject[k]);
      }
      if (TextUtils.equals(((Editable)localObject).subSequence(j, i), paramExtractedText.text))
      {
        if (!(paramExtractedText.text instanceof Spanned)) {
          break;
        }
        TextUtils.copySpansFrom((Spanned)paramExtractedText.text, 0, i - j, Object.class, (Spannable)localObject, j);
        break;
      }
      ((Editable)localObject).replace(j, i, paramExtractedText.text);
      break;
      label297:
      i = k;
      if (k <= j) {
        break label68;
      }
      i = j;
      break label68;
      label311:
      if (k > j)
      {
        break label82;
        label320:
        com.tencent.mm.ui.widget.cedit.util.d.b(this, (Spannable)localObject);
        break label104;
      }
      j = k;
      break label82;
      k = i;
      i = j;
      j = k;
      continue;
      j = 0;
    }
  }
  
  public void setExtracting(ExtractedTextRequest paramExtractedTextRequest)
  {
    AppMethodBeat.i(205743);
    if (this.QHs.QID != null) {
      this.QHs.QID.QKl = paramExtractedTextRequest;
    }
    this.QHs.gZQ();
    gZE();
    if (this.QHs.QIt != null) {
      this.QHs.QIt.haN();
    }
    AppMethodBeat.o(205743);
  }
  
  public void setFallbackLineSpacing(boolean paramBoolean)
  {
    AppMethodBeat.i(205641);
    if (this.QGP != paramBoolean)
    {
      this.QGP = paramBoolean;
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205641);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(205703);
    if (paramArrayOfInputFilter == null)
    {
      paramArrayOfInputFilter = new IllegalArgumentException();
      AppMethodBeat.o(205703);
      throw paramArrayOfInputFilter;
    }
    this.QHc = paramArrayOfInputFilter;
    if ((this.mText instanceof Editable)) {
      a((Editable)this.mText, paramArrayOfInputFilter);
    }
    AppMethodBeat.o(205703);
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    AppMethodBeat.i(205608);
    com.tencent.mm.ui.widget.cedit.util.b.aL(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.top;; i = localFontMetricsInt.ascent)
    {
      if (paramInt > Math.abs(i))
      {
        i = -i;
        setPadding(getPaddingLeft(), paramInt - i, getPaddingRight(), getPaddingBottom());
      }
      AppMethodBeat.o(205608);
      return;
    }
  }
  
  public void setFontFeatureSettings(String paramString)
  {
    AppMethodBeat.i(205647);
    if (paramString != this.ayn.getFontFeatureSettings())
    {
      this.ayn.setFontFeatureSettings(paramString);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205647);
  }
  
  public void setFreezesText(boolean paramBoolean)
  {
    this.QGq = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(205657);
    if ((paramInt & 0x800007) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      if ((i & 0x800007) != (this.Ku & 0x800007)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (i != this.Ku) {
          invalidate();
        }
        this.Ku = i;
        if ((this.OVt != null) && (paramInt != 0))
        {
          i = this.OVt.getWidth();
          if (this.QGF != null) {
            break label141;
          }
        }
        label141:
        for (paramInt = j;; paramInt = this.QGF.getWidth())
        {
          BoringLayout.Metrics localMetrics = OVU;
          a(i, paramInt, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), true);
          AppMethodBeat.o(205657);
          return;
        }
      }
    }
  }
  
  public void setHandleColorRes(int paramInt)
  {
    this.QHx = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(205666);
    this.OVy = paramInt;
    this.OVw = paramInt;
    this.OVz = 2;
    this.OVx = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205666);
  }
  
  public void setHighlightColor(int paramInt)
  {
    AppMethodBeat.i(205650);
    if (this.oEF != paramInt)
    {
      this.oEF = paramInt;
      invalidate();
    }
    AppMethodBeat.o(205650);
  }
  
  public final void setHint(int paramInt)
  {
    AppMethodBeat.i(205690);
    setHint(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(205690);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205688);
    setHintInternal(paramCharSequence);
    if (this.QHs != null)
    {
      paramCharSequence = getInputMethodManager();
      if ((paramCharSequence == null) || (!paramCharSequence.isActive(this))) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.QHs.hae();
      }
      AppMethodBeat.o(205688);
      return;
    }
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(205653);
    this.QGn = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(205653);
  }
  
  public final void setHintTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(205654);
    this.QGn = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(205654);
  }
  
  public void setHorizontallyScrolling(boolean paramBoolean)
  {
    AppMethodBeat.i(205660);
    if (this.QGQ != paramBoolean)
    {
      this.QGQ = paramBoolean;
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205660);
  }
  
  public void setImeHintLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(205701);
    gZL();
    this.QHs.gZO();
    this.QHs.QIC.QKk = paramLocaleList;
    KeyListener localKeyListener;
    if ((this.QGO) && (Build.VERSION.SDK_INT >= 24)) {
      if (paramLocaleList == null)
      {
        paramLocaleList = null;
        if ((this.QGN) || (this.QHs == null)) {
          break label250;
        }
        localKeyListener = this.QHs.QIH;
        if ((localKeyListener instanceof DigitsKeyListener)) {
          break label257;
        }
        if (!(localKeyListener instanceof DateKeyListener)) {
          break label174;
        }
        if (Build.VERSION.SDK_INT < 26) {
          break label257;
        }
        paramLocaleList = DateKeyListener.getInstance(paramLocaleList);
      }
    }
    for (;;)
    {
      boolean bool = aoy(this.QHs.Clf);
      setKeyListenerOnly(paramLocaleList);
      gZo();
      if (bool)
      {
        int i = this.QHs.Clf & 0xF;
        if (i == 1)
        {
          paramLocaleList = this.QHs;
          paramLocaleList.Clf |= 0x80;
          AppMethodBeat.o(205701);
          return;
          paramLocaleList = paramLocaleList.get(0);
          break;
          label174:
          if ((localKeyListener instanceof TimeKeyListener))
          {
            if (Build.VERSION.SDK_INT < 26) {
              break label257;
            }
            paramLocaleList = TimeKeyListener.getInstance(paramLocaleList);
            continue;
          }
          if ((localKeyListener instanceof DateTimeKeyListener))
          {
            if (Build.VERSION.SDK_INT < 26) {
              break label257;
            }
            paramLocaleList = DateTimeKeyListener.getInstance(paramLocaleList);
            continue;
          }
          AppMethodBeat.o(205701);
          return;
        }
        if (i == 2)
        {
          paramLocaleList = this.QHs;
          paramLocaleList.Clf |= 0x10;
        }
      }
      label250:
      AppMethodBeat.o(205701);
      return;
      label257:
      paramLocaleList = localKeyListener;
    }
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(205696);
    gZL();
    this.QHs.gZO();
    this.QHs.QIC.imeOptions = paramInt;
    AppMethodBeat.o(205696);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(205753);
    if (this.OVD != paramBoolean)
    {
      this.OVD = paramBoolean;
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205753);
  }
  
  public void setInputExtras(int paramInt)
  {
    AppMethodBeat.i(205699);
    gZL();
    XmlResourceParser localXmlResourceParser = getResources().getXml(paramInt);
    this.QHs.gZO();
    this.QHs.QIC.extras = new Bundle();
    getResources().parseBundleExtras(localXmlResourceParser, this.QHs.QIC.extras);
    AppMethodBeat.o(205699);
  }
  
  public void setInputType(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(205692);
    boolean bool1 = aoy(getInputType());
    boolean bool4 = aoz(getInputType());
    bO(paramInt, false);
    boolean bool3 = aoy(paramInt);
    boolean bool5 = aoz(paramInt);
    if (bool3)
    {
      setTransformationMethod(PasswordTransformationMethod.getInstance());
      a(null, null, 3, 0, -1);
      i = 0;
      if (!aox(paramInt))
      {
        bool1 = true;
        label76:
        if ((this.OSP != bool1) || (i != 0))
        {
          if (!bool3) {
            bool2 = true;
          }
          r(bool1, bool2, true);
        }
        if (!isSuggestionsEnabled()) {
          setTextInternal(ax(this.mText));
        }
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.restartInput(this);
        }
        AppMethodBeat.o(205692);
      }
    }
    else if (bool5)
    {
      if (this.QGH != PasswordTransformationMethod.getInstance()) {
        break label219;
      }
    }
    label219:
    for (int i = 1;; i = 0)
    {
      a(null, null, 3, 0, -1);
      break;
      if ((bool1) || (bool4))
      {
        a(null, null, -1, 0, -1);
        if (this.QGH == PasswordTransformationMethod.getInstance())
        {
          i = 1;
          break;
          bool1 = false;
          break label76;
        }
      }
      i = 0;
      break;
    }
  }
  
  public void setKeyListener(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(205580);
    this.QGN = true;
    setKeyListenerOnly(paramKeyListener);
    gZp();
    if (paramKeyListener != null)
    {
      gZL();
      gZo();
    }
    for (;;)
    {
      paramKeyListener = getInputMethodManager();
      if (paramKeyListener != null) {
        paramKeyListener.restartInput(this);
      }
      AppMethodBeat.o(205580);
      return;
      if (this.QHs != null) {
        this.QHs.Clf = 0;
      }
    }
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    AppMethodBeat.i(205609);
    com.tencent.mm.ui.widget.cedit.util.b.aL(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt - i);
      }
      AppMethodBeat.o(205609);
      return;
    }
  }
  
  public void setLetterSpacing(float paramFloat)
  {
    AppMethodBeat.i(205643);
    if (paramFloat != this.ayn.getLetterSpacing())
    {
      this.ayn.setLetterSpacing(paramFloat);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205643);
  }
  
  @SuppressLint({"RestrictedApi"})
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(205673);
    com.tencent.mm.ui.widget.cedit.util.b.aL(paramInt);
    int i = getPaint().getFontMetricsInt(null);
    if (paramInt != i)
    {
      float f = paramInt - i;
      if ((this.OVv != f) || (this.OVu != 1.0F))
      {
        this.OVv = f;
        this.OVu = 1.0F;
        if (this.OVt != null)
        {
          gLr();
          requestLayout();
          invalidate();
        }
      }
    }
    AppMethodBeat.o(205673);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(205665);
    this.OVy = paramInt;
    this.OVw = paramInt;
    this.OVz = 1;
    this.OVx = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205665);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(205655);
    this.QGo = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(205655);
  }
  
  public final void setLinkTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(205656);
    this.QGo = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(205656);
  }
  
  public final void setLinksClickable(boolean paramBoolean)
  {
    this.QGS = paramBoolean;
  }
  
  public void setMaxEms(int paramInt)
  {
    AppMethodBeat.i(205669);
    this.mMaxWidth = paramInt;
    this.QGW = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205669);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(205664);
    this.OVw = paramInt;
    this.OVx = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205664);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(205663);
    this.OVw = paramInt;
    this.OVx = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205663);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(205670);
    this.mMaxWidth = paramInt;
    this.QGW = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205670);
  }
  
  public void setMenuCallback(a.e parame)
  {
    this.QHz = parame;
  }
  
  public void setMinEms(int paramInt)
  {
    AppMethodBeat.i(205667);
    this.mMinWidth = paramInt;
    this.QGX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205667);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(205662);
    this.OVy = paramInt;
    this.OVz = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205662);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(205661);
    this.OVy = paramInt;
    this.OVz = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205661);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(205668);
    this.mMinWidth = paramInt;
    this.QGX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205668);
  }
  
  public final void setMovementMethod(com.tencent.mm.ui.widget.cedit.b.d paramd)
  {
    AppMethodBeat.i(205583);
    if (this.QGG != paramd)
    {
      this.QGG = paramd;
      if ((paramd != null) && (this.QGC == null)) {
        setText(this.mText);
      }
      gZp();
      if (this.QHs != null) {
        this.QHs.gZP();
      }
    }
    AppMethodBeat.o(205583);
  }
  
  public void setOnEditorActionListener(c paramc)
  {
    AppMethodBeat.i(205697);
    gZL();
    this.QHs.gZO();
    this.QHs.QIC.QKi = paramc;
    AppMethodBeat.o(205697);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205606);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      gLr();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(205606);
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205607);
    if ((paramInt1 != getPaddingStart()) || (paramInt3 != getPaddingEnd()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      gLr();
    }
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(205607);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(205659);
    if (this.ayn.getFlags() != paramInt)
    {
      this.ayn.setFlags(paramInt);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205659);
  }
  
  public void setPrivateImeOptions(String paramString)
  {
    AppMethodBeat.i(205698);
    gZL();
    this.QHs.gZO();
    this.QHs.QIC.privateImeOptions = paramString;
    AppMethodBeat.o(205698);
  }
  
  public void setRawInputType(int paramInt)
  {
    AppMethodBeat.i(205693);
    if ((paramInt == 0) && (this.QHs == null))
    {
      AppMethodBeat.o(205693);
      return;
    }
    gZL();
    this.QHs.Clf = paramInt;
    AppMethodBeat.o(205693);
  }
  
  public void setReuseBrands(List<String> paramList)
  {
    AppMethodBeat.i(205859);
    if (paramList != null)
    {
      this.QHB.clear();
      this.QHB.addAll(paramList);
    }
    AppMethodBeat.o(205859);
  }
  
  public void setReuseItems(List<String> paramList)
  {
    AppMethodBeat.i(205857);
    if (paramList != null)
    {
      this.QHA.clear();
      this.QHA.addAll(paramList);
    }
    AppMethodBeat.o(205857);
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  public void setSelectAllOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(205775);
    gZL();
    this.QHs.QIN = paramBoolean;
    if ((paramBoolean) && (!(this.mText instanceof Spannable))) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(205775);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(205790);
    isSelected();
    super.setSelected(paramBoolean);
    AppMethodBeat.o(205790);
  }
  
  public final void setShowSoftInputOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(205651);
    gZL();
    this.QHs.QIQ = paramBoolean;
    AppMethodBeat.o(205651);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(205772);
    setInputTypeSingleLine(paramBoolean);
    r(paramBoolean, true, true);
    AppMethodBeat.o(205772);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(205682);
    this.OVo = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(205682);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(205687);
    setText(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(205687);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205683);
    setText(paramCharSequence, this.QGD);
    AppMethodBeat.o(205683);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(205685);
    a(paramCharSequence, paramBufferType, true, 0);
    AppMethodBeat.o(205685);
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    this.QGw = paramTextClassifier;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(205648);
    this.BpJ = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(205648);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(205649);
    if (paramColorStateList == null)
    {
      paramColorStateList = new NullPointerException();
      AppMethodBeat.o(205649);
      throw paramColorStateList;
    }
    this.BpJ = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(205649);
  }
  
  public void setTextCursorDrawable(int paramInt)
  {
    AppMethodBeat.i(205622);
    if (paramInt != 0) {}
    for (Drawable localDrawable = getContext().getDrawable(paramInt);; localDrawable = null)
    {
      setTextCursorDrawable(localDrawable);
      AppMethodBeat.o(205622);
      return;
    }
  }
  
  public void setTextCursorDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(205621);
    this.QHj = paramDrawable;
    this.QHi = 0;
    if (this.QHs != null) {
      this.QHs.haA();
    }
    AppMethodBeat.o(205621);
  }
  
  public void setTextIsSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(205724);
    if ((!paramBoolean) && (this.QHs == null))
    {
      AppMethodBeat.o(205724);
      return;
    }
    gZL();
    if (this.QHs.QIO == paramBoolean)
    {
      AppMethodBeat.o(205724);
      return;
    }
    this.QHs.QIO = paramBoolean;
    setFocusableInTouchMode(paramBoolean);
    label91:
    CharSequence localCharSequence;
    if (Build.VERSION.SDK_INT >= 26)
    {
      setFocusable(16);
      setClickable(paramBoolean);
      setLongClickable(paramBoolean);
      if (!paramBoolean) {
        break label137;
      }
      localObject = com.tencent.mm.ui.widget.cedit.b.a.haX();
      setMovementMethod((com.tencent.mm.ui.widget.cedit.b.d)localObject);
      localCharSequence = this.mText;
      if (!paramBoolean) {
        break label142;
      }
    }
    label137:
    label142:
    for (Object localObject = TextView.BufferType.SPANNABLE;; localObject = TextView.BufferType.NORMAL)
    {
      setText(localCharSequence, (TextView.BufferType)localObject);
      this.QHs.gZP();
      AppMethodBeat.o(205724);
      return;
      setFocusable(paramBoolean);
      break;
      localObject = null;
      break label91;
    }
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205684);
    TextView.BufferType localBufferType = this.QGD;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    setText(paramCharSequence, localBufferType);
    if (((i >= 0) || (j >= 0)) && (this.QGC != null)) {
      Selection.setSelection(this.QGC, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
    AppMethodBeat.o(205684);
  }
  
  public void setTextLocale(Locale paramLocale)
  {
    AppMethodBeat.i(205627);
    this.QGL = true;
    this.ayn.setTextLocale(paramLocale);
    if (this.OVt != null)
    {
      gLr();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(205627);
  }
  
  public void setTextLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(205628);
    this.QGL = true;
    if (Build.VERSION.SDK_INT >= 24) {
      this.ayn.setTextLocales(paramLocaleList);
    }
    for (;;)
    {
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(205628);
      return;
      if ((paramLocaleList != null) && (paramLocaleList.size() > 0)) {
        this.ayn.setTextLocale(paramLocaleList.get(0));
      }
    }
  }
  
  public final void setTextOperationUser(UserHandle paramUserHandle)
  {
    AppMethodBeat.i(205810);
    if (Objects.equals(this.QHd, paramUserHandle))
    {
      AppMethodBeat.o(205810);
      return;
    }
    if (paramUserHandle != null) {
      Process.myUserHandle().equals(paramUserHandle);
    }
    this.QHd = paramUserHandle;
    this.QHe = null;
    AppMethodBeat.o(205810);
  }
  
  public void setTextScaleX(float paramFloat)
  {
    AppMethodBeat.i(205637);
    if (paramFloat != this.ayn.getTextScaleX())
    {
      this.QGK = true;
      this.ayn.setTextScaleX(paramFloat);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205637);
  }
  
  public void setTextSelectHandle(int paramInt)
  {
    AppMethodBeat.i(205613);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select handle should be a valid drawable resource id.");
      setTextSelectHandle(getContext().getDrawable(paramInt));
      AppMethodBeat.o(205613);
      return;
    }
  }
  
  public void setTextSelectHandle(Drawable paramDrawable)
  {
    AppMethodBeat.i(205612);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The text select handle should not be null.");
    this.QHp = paramDrawable;
    this.QHo = 0;
    if (this.QHs != null) {
      this.QHs.CZ(true);
    }
    AppMethodBeat.o(205612);
  }
  
  public void setTextSelectHandleLeft(int paramInt)
  {
    AppMethodBeat.i(205616);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select left handle should be a valid drawable resource id.");
      setTextSelectHandleLeft(getContext().getDrawable(paramInt));
      AppMethodBeat.o(205616);
      return;
    }
  }
  
  public void setTextSelectHandleLeft(Drawable paramDrawable)
  {
    AppMethodBeat.i(205615);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The left text select handle should not be null.");
    this.QHl = paramDrawable;
    this.QHk = 0;
    if (this.QHs != null) {
      this.QHs.CZ(true);
    }
    AppMethodBeat.o(205615);
  }
  
  public void setTextSelectHandleRight(int paramInt)
  {
    AppMethodBeat.i(205619);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select right handle should be a valid drawable resource id.");
      setTextSelectHandleRight(getContext().getDrawable(paramInt));
      AppMethodBeat.o(205619);
      return;
    }
  }
  
  public void setTextSelectHandleRight(Drawable paramDrawable)
  {
    AppMethodBeat.i(205618);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The right text select handle should not be null.");
    this.QHn = paramDrawable;
    this.QHm = 0;
    if (this.QHs != null) {
      this.QHs.CZ(true);
    }
    AppMethodBeat.o(205618);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(205633);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(205633);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205634);
    int i;
    if ((jw()) && (this.aly != 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = getContext();
        if (localObject != null) {
          break label73;
        }
      }
    }
    label73:
    for (Object localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      this.QGM = paramInt;
      setRawTextSize$254d549(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(205634);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setTransformationMethod(TransformationMethod paramTransformationMethod)
  {
    AppMethodBeat.i(205585);
    if (paramTransformationMethod == this.QGH)
    {
      AppMethodBeat.o(205585);
      return;
    }
    if ((this.QGH != null) && (this.QGC != null)) {
      this.QGC.removeSpan(this.QGH);
    }
    this.QGH = paramTransformationMethod;
    this.QGI = false;
    setText(this.mText);
    this.Om = getTextDirectionHeuristic();
    AppMethodBeat.o(205585);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(205638);
    if (this.ayn.getTypeface() != paramTypeface)
    {
      this.ayn.setTypeface(paramTypeface);
      if (this.OVt != null)
      {
        gLr();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(205638);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(205672);
    this.mMinWidth = paramInt;
    this.mMaxWidth = paramInt;
    this.QGX = 2;
    this.QGW = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(205672);
  }
  
  public boolean showContextMenu()
  {
    AppMethodBeat.i(205794);
    if (this.QHs != null) {
      this.QHs.aA((0.0F / 0.0F), (0.0F / 0.0F));
    }
    boolean bool = super.showContextMenu();
    AppMethodBeat.o(205794);
    return bool;
  }
  
  public boolean showContextMenu(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205795);
    if (this.QHs != null) {
      this.QHs.aA(paramFloat1, paramFloat2);
    }
    boolean bool = super.showContextMenu(paramFloat1, paramFloat2);
    AppMethodBeat.o(205795);
    return bool;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(205720);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.QGA != null))
    {
      Drawable[] arrayOfDrawable = this.QGA.QHE;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        if (paramDrawable == arrayOfDrawable[i])
        {
          AppMethodBeat.o(205720);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(205720);
    return bool;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int QHT;
    int QHU;
    boolean QHV;
    ParcelableParcel QHW;
    CharSequence text;
    CharSequence wz;
    
    static
    {
      AppMethodBeat.i(205569);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(205569);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(205568);
      this.QHT = -1;
      this.QHU = -1;
      this.QHT = paramParcel.readInt();
      this.QHU = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.QHV = bool;
        this.text = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        if (paramParcel.readInt() != 0) {
          this.wz = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        }
        if (paramParcel.readInt() != 0) {
          this.QHW = ((ParcelableParcel)ParcelableParcel.CREATOR.createFromParcel(paramParcel));
        }
        AppMethodBeat.o(205568);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
      this.QHT = -1;
      this.QHU = -1;
    }
    
    public String toString()
    {
      AppMethodBeat.i(205567);
      String str2 = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.QHT + " end=" + this.QHU;
      String str1 = str2;
      if (this.text != null) {
        str1 = str2 + " text=" + this.text;
      }
      str1 = str1 + "}";
      AppMethodBeat.o(205567);
      return str1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(205566);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.QHT);
      paramParcel.writeInt(this.QHU);
      int i;
      if (this.QHV)
      {
        i = 1;
        paramParcel.writeInt(i);
        TextUtils.writeToParcel(this.text, paramParcel, paramInt);
        if (this.wz != null) {
          break label85;
        }
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        if (this.QHW != null) {
          break label102;
        }
        paramParcel.writeInt(0);
        AppMethodBeat.o(205566);
        return;
        i = 0;
        break;
        label85:
        paramParcel.writeInt(1);
        TextUtils.writeToParcel(this.wz, paramParcel, paramInt);
      }
      label102:
      paramParcel.writeInt(1);
      this.QHW.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(205566);
    }
  }
  
  class a
    implements SpanWatcher, TextWatcher
  {
    private CharSequence QHD;
    
    private a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(205560);
      CustomTextView.this.e(paramEditable);
      if (MetaKeyKeyListener.getMetaState(paramEditable, 2048) != 0) {
        com.tencent.mm.ui.widget.cedit.util.d.b(CustomTextView.this, paramEditable);
      }
      AppMethodBeat.o(205560);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205558);
      if ((com.tencent.mm.ui.widget.cedit.util.d.haZ()) && (CustomTextView.b(CustomTextView.this) != null)) {
        this.QHD = CustomTextView.b(CustomTextView.this).toString();
      }
      CustomTextView.a(CustomTextView.this, paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(205558);
    }
    
    public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205562);
      CustomTextView.this.a(paramSpannable, paramObject, -1, paramInt1, -1, paramInt2);
      AppMethodBeat.o(205562);
    }
    
    public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(205561);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, paramInt3, paramInt2, paramInt4);
      AppMethodBeat.o(205561);
    }
    
    public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205563);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, -1, paramInt2, -1);
      AppMethodBeat.o(205563);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205559);
      CustomTextView.this.c(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if ((com.tencent.mm.ui.widget.cedit.util.d.haZ()) && ((CustomTextView.this.isFocused()) || ((CustomTextView.this.isSelected()) && (CustomTextView.this.isShown()))))
      {
        paramCharSequence = this.QHD;
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
        localAccessibilityEvent.setFromIndex(paramInt1);
        localAccessibilityEvent.setRemovedCount(paramInt2);
        localAccessibilityEvent.setAddedCount(paramInt3);
        localAccessibilityEvent.setBeforeText(paramCharSequence);
        CustomTextView.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        this.QHD = null;
      }
      AppMethodBeat.o(205559);
    }
  }
  
  static final class b
  {
    ColorStateList Kr;
    final Rect OVZ;
    int OWe;
    int OWf;
    int OWg;
    int OWh;
    int OWi;
    int OWj;
    int OWk;
    int OWl;
    int OWm;
    final Drawable[] QHE;
    BlendMode QHF;
    boolean QHG;
    Drawable QHH;
    Drawable QHI;
    Drawable QHJ;
    Drawable QHK;
    Drawable QHL;
    boolean QHM;
    boolean QHN;
    int QHO;
    int QHP;
    int QHQ;
    int QHR;
    int QHS;
    boolean acU;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(205564);
      this.OVZ = new Rect();
      this.QHE = new Drawable[4];
      this.QHS = -1;
      if (paramContext.getApplicationInfo().targetSdkVersion < 17) {}
      for (boolean bool = true;; bool = false)
      {
        this.QHM = bool;
        this.QHN = false;
        AppMethodBeat.o(205564);
        return;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(CustomTextView paramCustomTextView, int paramInt);
  }
  
  static final class d
  {
    ColorStateList BpJ = null;
    int QGM = -1;
    float QGr = 0.0F;
    float QGs = 0.0F;
    float QGt = 0.0F;
    int QHX = 1711528645;
    ColorStateList QHY = null;
    ColorStateList QHZ = null;
    LocaleList QIa = null;
    boolean QIb = false;
    int QIc = -1;
    int QId = 0;
    int QIe = -1;
    boolean QIf = false;
    boolean QIg = false;
    boolean QIh = false;
    boolean QIi = false;
    boolean QIj = false;
    boolean QIk = false;
    float QIl = 0.0F;
    String QIm = null;
    String QIn = null;
    Typeface alr = null;
    String lal = null;
    int mAk = -1;
    int nYW = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(205570);
      String str = "TextAppearanceAttributes {\n    mTextColorHighlight:" + this.QHX + "\n    mTextColor:" + this.BpJ + "\n    mTextColorHint:" + this.QHY + "\n    mTextColorLink:" + this.QHZ + "\n    mTextSize:" + this.mAk + "\n    mTextSizeUnit:" + this.QGM + "\n    mTextLocales:" + this.QIa + "\n    mFontFamily:" + this.lal + "\n    mFontTypeface:" + this.alr + "\n    mFontFamilyExplicit:" + this.QIb + "\n    mTypefaceIndex:" + this.QIc + "\n    mTextStyle:" + this.QId + "\n    mFontWeight:" + this.QIe + "\n    mAllCaps:" + this.QIf + "\n    mShadowColor:" + this.nYW + "\n    mShadowDx:" + this.QGs + "\n    mShadowDy:" + this.QGt + "\n    mShadowRadius:" + this.QGr + "\n    mHasElegant:" + this.QIg + "\n    mElegant:" + this.QIh + "\n    mHasFallbackLineSpacing:" + this.QIi + "\n    mFallbackLineSpacing:" + this.QIj + "\n    mHasLetterSpacing:" + this.QIk + "\n    mLetterSpacing:" + this.QIl + "\n    mFontFeatureSettings:" + this.QIm + "\n    mFontVariationSettings:" + this.QIn + "\n}";
      AppMethodBeat.o(205570);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomTextView
 * JD-Core Version:    0.7.0.1
 */