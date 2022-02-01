package com.tencent.mm.ui.widget.cedit.edit;

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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
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
  public static final BoringLayout.Metrics adWu;
  private static final float[] afWY;
  private static final InputFilter[] afWZ;
  private static final Spanned afXa;
  private static final int[] afXb;
  static long afXc;
  private static final SparseIntArray afYm;
  private static final RectF sG;
  private ColorStateList NhP;
  boolean adTq;
  @ViewDebug.ExportedProperty(category="text")
  private int adVN;
  private Editable.Factory adVO;
  private Spannable.Factory adVP;
  private TextUtils.TruncateAt adVQ;
  private CharSequence adVR;
  private float adVU;
  private float adVV;
  private int adVW;
  private int adVX;
  private int adVY;
  private int adVZ;
  private int adWc;
  private boolean adWd;
  private BoringLayout adWe;
  private boolean afXA;
  private boolean afXB;
  private int afXC;
  private boolean afXD;
  private boolean afXE;
  boolean afXF;
  private boolean afXG;
  private int afXH;
  private boolean afXI;
  private int afXJ;
  private int afXK;
  private int afXL;
  private int afXM;
  private int afXN;
  private int afXO;
  private BoringLayout.Metrics afXP;
  private BoringLayout.Metrics afXQ;
  private BoringLayout afXR;
  private InputFilter[] afXS;
  private UserHandle afXT;
  private volatile Locale afXU;
  private Path afXV;
  private Paint afXW;
  private boolean afXX;
  int afXY;
  private Drawable afXZ;
  private ColorStateList afXd;
  private ColorStateList afXe;
  private int afXf;
  private boolean afXg;
  private float afXh;
  private float afXi;
  private float afXj;
  private boolean afXk;
  private boolean afXl;
  private TextClassifier afXm;
  private TextClassifier afXn;
  private TextClassificationContext afXo;
  private boolean afXp;
  b afXq;
  private int afXr;
  public Spannable afXs;
  private TextView.BufferType afXt;
  private CharSequence afXu;
  private Layout afXv;
  private com.tencent.mm.ui.widget.cedit.b.d afXw;
  TransformationMethod afXx;
  private boolean afXy;
  private a afXz;
  int afYa;
  private Drawable afYb;
  int afYc;
  private Drawable afYd;
  int afYe;
  private Drawable afYf;
  private int afYg;
  private boolean afYh;
  b afYi;
  private int afYj;
  private TextView afYk;
  private TextWatcher afYl;
  int afYn;
  boolean afYo;
  private a.e afYp;
  private Set<String> afYq;
  private Set<String> afYr;
  private TextDirectionHeuristic bsl;
  private int bsm;
  private int bsn;
  private long bwy;
  public Layout mLayout;
  private ArrayList<TextWatcher> mListeners;
  private Scroller mScroller;
  private Rect mTempRect;
  @ViewDebug.ExportedProperty(category="text")
  public CharSequence mText;
  private int mf;
  private int sI;
  @ViewDebug.ExportedProperty(category="text")
  private int tJ;
  int uRB;
  private int ugx;
  private int vF;
  private TextPaint xe;
  
  static
  {
    AppMethodBeat.i(252709);
    afWY = new float[2];
    sG = new RectF();
    afWZ = new InputFilter[0];
    afXa = new SpannedString("");
    afXb = new int[] { 16843597 };
    com.tencent.mm.ui.widget.cedit.util.d.jHm();
    Object localObject1 = new CustomTextView.2();
    afYm = (SparseIntArray)localObject1;
    int i = a.m.MMNewTextView_android_textColorHighlight;
    ((SparseIntArray)localObject1).put(i, i);
    localObject1 = afYm;
    i = a.m.MMNewTextView_android_textColor;
    ((SparseIntArray)localObject1).put(i, i);
    localObject1 = afYm;
    i = a.m.MMNewTextView_android_textColorHint;
    ((SparseIntArray)localObject1).put(i, i);
    localObject1 = afYm;
    i = a.m.MMNewTextView_android_textColorLink;
    ((SparseIntArray)localObject1).put(i, i);
    localObject1 = afYm;
    i = a.m.MMNewTextView_android_textSize;
    ((SparseIntArray)localObject1).put(i, i);
    try
    {
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_textLocale;
      ((SparseIntArray)localObject1).put(i, i);
      label147:
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_typeface;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_fontFamily;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_textStyle;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_textFontWeight;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_textAllCaps;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_shadowColor;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_shadowDx;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_shadowDy;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_shadowRadius;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_elegantTextHeight;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_fallbackLineSpacing;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_letterSpacing;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_fontFeatureSettings;
      ((SparseIntArray)localObject1).put(i, i);
      localObject1 = afYm;
      i = a.m.MMNewTextView_android_fontVariationSettings;
      ((SparseIntArray)localObject1).put(i, i);
      adWu = new BoringLayout.Metrics();
      AppMethodBeat.o(252709);
      return;
    }
    finally
    {
      break label147;
    }
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.l.MMNewTextViewStyle);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public CustomTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(252345);
    this.adVO = Editable.Factory.getInstance();
    this.adVP = Spannable.Factory.getInstance();
    this.afXr = -1;
    this.afXt = TextView.BufferType.NORMAL;
    this.afXB = false;
    this.afXC = -1;
    this.afXD = false;
    this.tJ = 8388659;
    this.afXI = true;
    this.adVU = 1.0F;
    this.adVV = 0.0F;
    this.bsm = 0;
    this.bsn = 0;
    this.adVW = 2147483647;
    this.adVX = 1;
    this.adVY = 0;
    this.adVZ = 1;
    this.afXK = this.adVW;
    this.afXL = this.adVX;
    this.vF = 2147483647;
    this.afXM = 2;
    this.mf = 0;
    this.afXN = 2;
    this.adWc = -1;
    this.adWd = true;
    this.afXO = -1;
    this.afXS = afWZ;
    this.uRB = 1714664933;
    this.afXX = true;
    this.afXY = 16843618;
    this.afYa = 16843461;
    this.afYc = 16843462;
    this.afYe = 16843463;
    this.afYg = -1;
    this.afYj = 0;
    this.sI = 0;
    this.afYl = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(252279);
        ((Editable)CustomTextView.this.getText()).insert(CustomTextView.this.getSelectionStart(), paramAnonymousEditable.toString());
        AppMethodBeat.o(252279);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.afYn = getContext().getResources().getColor(a.d.cursor_handle_color);
    this.afYo = false;
    this.afYq = new HashSet();
    this.afYr = new HashSet();
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.o(252345);
  }
  
  private void K(Rect paramRect)
  {
    AppMethodBeat.i(252645);
    int i = jFz();
    paramRect.left += i;
    paramRect.right = (i + paramRect.right);
    i = jFA();
    paramRect.top += i;
    paramRect.bottom = (i + paramRect.bottom);
    AppMethodBeat.o(252645);
  }
  
  private Locale Np(boolean paramBoolean)
  {
    AppMethodBeat.i(252669);
    AsyncTask.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252266);
        CustomTextView.a(CustomTextView.this);
        AppMethodBeat.o(252266);
      }
    });
    if ((this.afXU == null) && (!paramBoolean))
    {
      localLocale = Locale.getDefault();
      AppMethodBeat.o(252669);
      return localLocale;
    }
    Locale localLocale = this.afXU;
    AppMethodBeat.o(252669);
    return localLocale;
  }
  
  private void Y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(252690);
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
            Selection.setSelection(this.afXs, paramInt2);
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
      afXc = 0L;
    }
    AppMethodBeat.o(252690);
  }
  
  /* Error */
  private int a(int paramInt, KeyEvent paramKeyEvent1, KeyEvent paramKeyEvent2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 564
    //   6: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 567	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:isEnabled	()Z
    //   13: ifne +11 -> 24
    //   16: ldc_w 564
    //   19: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_2
    //   25: invokevirtual 572	android/view/KeyEvent:getRepeatCount	()I
    //   28: ifne +15 -> 43
    //   31: iload_1
    //   32: invokestatic 576	android/view/KeyEvent:isModifierKey	(I)Z
    //   35: ifne +8 -> 43
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 578	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXp	Z
    //   43: iload_1
    //   44: lookupswitch	default:+92->136, 4:+318->362, 23:+273->317, 61:+295->339, 66:+157->201, 112:+443->487, 124:+476->520, 160:+157->201, 277:+347->391, 278:+379->423, 279:+411->455
    //   137: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   140: ifnull +530 -> 670
    //   143: aload_0
    //   144: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   147: getfield 586	com/tencent/mm/ui/widget/cedit/edit/b:afZx	Landroid/text/method/KeyListener;
    //   150: ifnull +520 -> 670
    //   153: aload_3
    //   154: ifnull +716 -> 870
    //   157: aload_0
    //   158: invokevirtual 589	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:beginBatchEdit	()V
    //   161: aload_0
    //   162: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   165: getfield 586	com/tencent/mm/ui/widget/cedit/edit/b:afZx	Landroid/text/method/KeyListener;
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 532	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   173: checkcast 534	android/text/Editable
    //   176: aload_3
    //   177: invokeinterface 595 4 0
    //   182: istore 6
    //   184: iload 6
    //   186: ifeq +402 -> 588
    //   189: aload_0
    //   190: invokevirtual 598	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   193: ldc_w 564
    //   196: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_m1
    //   200: ireturn
    //   201: aload_2
    //   202: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   205: ifeq -69 -> 136
    //   208: aload_0
    //   209: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   212: ifnull +65 -> 277
    //   215: aload_0
    //   216: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   219: getfield 605	com/tencent/mm/ui/widget/cedit/edit/b:afZs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   222: ifnull +55 -> 277
    //   225: aload_0
    //   226: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   229: getfield 605	com/tencent/mm/ui/widget/cedit/edit/b:afZs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   232: getfield 611	com/tencent/mm/ui/widget/cedit/edit/b$g:agba	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   235: ifnull +42 -> 277
    //   238: aload_0
    //   239: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   242: getfield 605	com/tencent/mm/ui/widget/cedit/edit/b:afZs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   245: getfield 611	com/tencent/mm/ui/widget/cedit/edit/b$g:agba	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   248: aload_0
    //   249: iconst_0
    //   250: invokeinterface 614 3 0
    //   255: ifeq +22 -> 277
    //   258: aload_0
    //   259: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   262: getfield 605	com/tencent/mm/ui/widget/cedit/edit/b:afZs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   265: iconst_1
    //   266: putfield 617	com/tencent/mm/ui/widget/cedit/edit/b$g:agbb	Z
    //   269: ldc_w 564
    //   272: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_2
    //   278: invokevirtual 620	android/view/KeyEvent:getFlags	()I
    //   281: bipush 16
    //   283: iand
    //   284: ifne +10 -> 294
    //   287: aload_0
    //   288: invokespecial 623	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFv	()Z
    //   291: ifeq -155 -> 136
    //   294: aload_0
    //   295: invokevirtual 626	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:hasOnClickListeners	()Z
    //   298: ifeq +11 -> 309
    //   301: ldc_w 564
    //   304: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: ldc_w 564
    //   312: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iconst_m1
    //   316: ireturn
    //   317: aload_2
    //   318: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   321: ifeq -185 -> 136
    //   324: aload_0
    //   325: invokespecial 623	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFv	()Z
    //   328: ifeq -192 -> 136
    //   331: ldc_w 564
    //   334: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: iconst_0
    //   338: ireturn
    //   339: aload_2
    //   340: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   343: ifne +11 -> 354
    //   346: aload_2
    //   347: iconst_1
    //   348: invokevirtual 629	android/view/KeyEvent:hasModifiers	(I)Z
    //   351: ifeq -215 -> 136
    //   354: ldc_w 564
    //   357: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_0
    //   361: ireturn
    //   362: aload_0
    //   363: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   366: ifnull -230 -> 136
    //   369: aload_0
    //   370: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   373: invokevirtual 632	com/tencent/mm/ui/widget/cedit/edit/b:jGu	()Z
    //   376: ifne -240 -> 136
    //   379: aload_0
    //   380: invokevirtual 635	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFJ	()V
    //   383: ldc_w 564
    //   386: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_m1
    //   390: ireturn
    //   391: aload_2
    //   392: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   395: ifeq -259 -> 136
    //   398: aload_0
    //   399: invokevirtual 638	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFK	()Z
    //   402: ifeq -266 -> 136
    //   405: aload_0
    //   406: ldc_w 639
    //   409: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   412: ifeq -276 -> 136
    //   415: ldc_w 564
    //   418: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: iconst_m1
    //   422: ireturn
    //   423: aload_2
    //   424: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   427: ifeq -291 -> 136
    //   430: aload_0
    //   431: invokevirtual 645	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFL	()Z
    //   434: ifeq -298 -> 136
    //   437: aload_0
    //   438: ldc_w 646
    //   441: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   444: ifeq -308 -> 136
    //   447: ldc_w 564
    //   450: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: iconst_m1
    //   454: ireturn
    //   455: aload_2
    //   456: invokevirtual 601	android/view/KeyEvent:hasNoModifiers	()Z
    //   459: ifeq -323 -> 136
    //   462: aload_0
    //   463: invokevirtual 649	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFM	()Z
    //   466: ifeq -330 -> 136
    //   469: aload_0
    //   470: ldc_w 650
    //   473: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   476: ifeq -340 -> 136
    //   479: ldc_w 564
    //   482: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: iconst_m1
    //   486: ireturn
    //   487: aload_2
    //   488: iconst_1
    //   489: invokevirtual 629	android/view/KeyEvent:hasModifiers	(I)Z
    //   492: ifeq -356 -> 136
    //   495: aload_0
    //   496: invokevirtual 638	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFK	()Z
    //   499: ifeq -363 -> 136
    //   502: aload_0
    //   503: ldc_w 639
    //   506: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   509: ifeq -373 -> 136
    //   512: ldc_w 564
    //   515: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: iconst_m1
    //   519: ireturn
    //   520: aload_2
    //   521: sipush 4096
    //   524: invokevirtual 629	android/view/KeyEvent:hasModifiers	(I)Z
    //   527: ifeq +28 -> 555
    //   530: aload_0
    //   531: invokevirtual 645	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFL	()Z
    //   534: ifeq +21 -> 555
    //   537: aload_0
    //   538: ldc_w 646
    //   541: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   544: ifeq -408 -> 136
    //   547: ldc_w 564
    //   550: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   553: iconst_m1
    //   554: ireturn
    //   555: aload_2
    //   556: iconst_1
    //   557: invokevirtual 629	android/view/KeyEvent:hasModifiers	(I)Z
    //   560: ifeq -424 -> 136
    //   563: aload_0
    //   564: invokevirtual 649	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:jFM	()Z
    //   567: ifeq -431 -> 136
    //   570: aload_0
    //   571: ldc_w 650
    //   574: invokevirtual 642	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   577: ifeq -441 -> 136
    //   580: ldc_w 564
    //   583: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: iconst_m1
    //   587: ireturn
    //   588: aload_0
    //   589: invokevirtual 598	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   592: iconst_0
    //   593: istore 4
    //   595: iload 4
    //   597: ifeq +73 -> 670
    //   600: aload_0
    //   601: invokevirtual 589	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:beginBatchEdit	()V
    //   604: aload_0
    //   605: getfield 580	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afYi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   608: getfield 586	com/tencent/mm/ui/widget/cedit/edit/b:afZx	Landroid/text/method/KeyListener;
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 532	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   616: checkcast 534	android/text/Editable
    //   619: iload_1
    //   620: aload_2
    //   621: invokeinterface 654 5 0
    //   626: istore 6
    //   628: aload_0
    //   629: invokevirtual 598	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   632: iload 6
    //   634: ifeq +36 -> 670
    //   637: ldc_w 564
    //   640: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: iconst_1
    //   644: ireturn
    //   645: astore 7
    //   647: aload_0
    //   648: invokevirtual 598	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   651: iconst_1
    //   652: istore 4
    //   654: goto -59 -> 595
    //   657: astore_2
    //   658: aload_0
    //   659: invokevirtual 598	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:endBatchEdit	()V
    //   662: ldc_w 564
    //   665: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   668: aload_2
    //   669: athrow
    //   670: aload_0
    //   671: getfield 656	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   674: ifnull +166 -> 840
    //   677: aload_0
    //   678: getfield 658	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mLayout	Landroid/text/Layout;
    //   681: ifnull +159 -> 840
    //   684: aload_3
    //   685: ifnull +88 -> 773
    //   688: aload_0
    //   689: getfield 656	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 524	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXs	Landroid/text/Spannable;
    //   697: aload_3
    //   698: invokeinterface 663 4 0
    //   703: istore 6
    //   705: iload 6
    //   707: ifeq +11 -> 718
    //   710: ldc_w 564
    //   713: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: iconst_m1
    //   717: ireturn
    //   718: iconst_0
    //   719: istore 4
    //   721: iload 4
    //   723: ifeq +56 -> 779
    //   726: aload_0
    //   727: getfield 656	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   730: aload_0
    //   731: aload_0
    //   732: getfield 524	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXs	Landroid/text/Spannable;
    //   735: iload_1
    //   736: aload_2
    //   737: invokeinterface 666 5 0
    //   742: ifeq +37 -> 779
    //   745: aload_2
    //   746: invokevirtual 572	android/view/KeyEvent:getRepeatCount	()I
    //   749: ifne +15 -> 764
    //   752: iload_1
    //   753: invokestatic 576	android/view/KeyEvent:isModifierKey	(I)Z
    //   756: ifne +8 -> 764
    //   759: aload_0
    //   760: iconst_1
    //   761: putfield 578	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXp	Z
    //   764: ldc_w 564
    //   767: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_2
    //   771: ireturn
    //   772: astore_3
    //   773: iconst_1
    //   774: istore 4
    //   776: goto -55 -> 721
    //   779: aload_2
    //   780: invokevirtual 669	android/view/KeyEvent:getSource	()I
    //   783: sipush 257
    //   786: if_icmpne +54 -> 840
    //   789: iload 5
    //   791: istore 4
    //   793: iload_1
    //   794: tableswitch	default:+30 -> 824, 19:+33->827, 20:+33->827, 21:+33->827, 22:+33->827
    //   825: istore 4
    //   827: iload 4
    //   829: ifeq +11 -> 840
    //   832: ldc_w 564
    //   835: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: iconst_m1
    //   839: ireturn
    //   840: aload_0
    //   841: getfield 578	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:afXp	Z
    //   844: ifeq +18 -> 862
    //   847: iload_1
    //   848: invokestatic 576	android/view/KeyEvent:isModifierKey	(I)Z
    //   851: ifne +11 -> 862
    //   854: ldc_w 564
    //   857: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   860: iconst_m1
    //   861: ireturn
    //   862: ldc_w 564
    //   865: invokestatic 303	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(252513);
    if (paramLayout == this.afXv) {}
    for (int i = getCompoundPaddingTop() + getCompoundPaddingBottom();; i = getExtendedPaddingTop() + getExtendedPaddingBottom())
    {
      int j = getMeasuredHeight();
      AppMethodBeat.o(252513);
      return j - i;
    }
  }
  
  private int a(Layout paramLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(252604);
    if (paramLayout == null)
    {
      AppMethodBeat.o(252604);
      return 0;
    }
    int i = paramLayout.getHeight();
    b localb = this.afXq;
    int j = i;
    if (localb != null) {
      j = Math.max(Math.max(i, localb.adWK), localb.adWL);
    }
    i = paramLayout.getLineCount();
    int k = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + k;
    k = j + m;
    if (this.adVX != 1)
    {
      k = Math.min(k, this.adVW);
      j = i;
      i = k;
    }
    for (;;)
    {
      if (this.adVZ == 1)
      {
        k = i;
        if (j < this.adVY) {
          k = getLineHeight();
        }
      }
      for (k = i + (this.adVY - j) * k;; k = Math.max(i, this.adVY))
      {
        i = Math.max(k, getSuggestedMinimumHeight());
        AppMethodBeat.o(252604);
        return i;
        if ((!paramBoolean) || (i <= this.adVW) || ((!(paramLayout instanceof DynamicLayout)) && (!(paramLayout instanceof BoringLayout)))) {
          break label256;
        }
        j = paramLayout.getLineTop(this.adVW);
        i = j;
        if (localb != null) {
          i = Math.max(Math.max(j, localb.adWK), localb.adWL);
        }
        j = this.adVW;
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
    AppMethodBeat.i(252586);
    CharSequence localCharSequence = null;
    if (jFw())
    {
      localObject = this.mText;
      localCharSequence = this.adVR;
      TextPaint localTextPaint = this.xe;
      float f1 = this.adVU;
      float f2 = this.adVV;
      paramBoolean2 = this.adWd;
      if (getKeyListener() == null) {}
      for (paramMetrics = paramTruncateAt;; paramMetrics = null)
      {
        paramMetrics = new DynamicLayout((CharSequence)localObject, localCharSequence, localTextPaint, paramInt1, paramAlignment, f1, f2, paramBoolean2, paramMetrics, paramInt2);
        localObject = paramMetrics;
        if (paramMetrics == null)
        {
          paramMetrics = this.adVR;
          int i = this.adVR.length();
          localObject = this.xe;
          f1 = this.adVU;
          f2 = this.adVV;
          paramBoolean2 = this.adWd;
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
        AppMethodBeat.o(252586);
        return localObject;
      }
    }
    if (paramMetrics == adWu)
    {
      paramMetrics = BoringLayout.isBoring(this.adVR, this.xe, this.afXP);
      localObject = paramMetrics;
      if (paramMetrics != null) {
        this.afXP = paramMetrics;
      }
    }
    for (Object localObject = paramMetrics;; localObject = paramMetrics)
    {
      paramMetrics = localCharSequence;
      if (localObject == null) {
        break;
      }
      if ((((BoringLayout.Metrics)localObject).width <= paramInt1) && ((paramTruncateAt == null) || (((BoringLayout.Metrics)localObject).width <= paramInt2))) {
        if ((paramBoolean2) && (this.adWe != null)) {
          paramMetrics = this.adWe.replaceOrMake(this.adVR, this.xe, paramInt1, paramAlignment, this.adVU, this.adVV, (BoringLayout.Metrics)localObject, this.adWd);
        }
      }
      for (;;)
      {
        if (paramBoolean2)
        {
          this.adWe = ((BoringLayout)paramMetrics);
          break;
          paramMetrics = BoringLayout.make(this.adVR, this.xe, paramInt1, paramAlignment, this.adVU, this.adVV, (BoringLayout.Metrics)localObject, this.adWd);
          continue;
          paramMetrics = localCharSequence;
          if (!paramBoolean1) {
            break;
          }
          paramMetrics = localCharSequence;
          if (((BoringLayout.Metrics)localObject).width > paramInt1) {
            break;
          }
          if ((paramBoolean2) && (this.adWe != null))
          {
            paramMetrics = this.adWe.replaceOrMake(this.adVR, this.xe, paramInt1, paramAlignment, this.adVU, this.adVV, (BoringLayout.Metrics)localObject, this.adWd, paramTruncateAt, paramInt2);
            break;
          }
          paramMetrics = BoringLayout.make(this.adVR, this.xe, paramInt1, paramAlignment, this.adVU, this.adVV, (BoringLayout.Metrics)localObject, this.adWd, paramTruncateAt, paramInt2);
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
    AppMethodBeat.i(252577);
    this.afXK = this.adVW;
    this.afXL = this.adVX;
    this.afXX = true;
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
      if ((this.adTq) && (this.mLayout != null) && ((localAlignment == Layout.Alignment.ALIGN_NORMAL) || (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)))
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
      for (int j = this.mLayout.getParagraphDirection(0);; j = 0)
      {
        boolean bool1;
        TextUtils.TruncateAt localTruncateAt;
        boolean bool2;
        int k;
        if ((this.adVQ != null) && (getKeyListener() == null))
        {
          bool1 = true;
          localTruncateAt = this.adVQ;
          if (this.bsl == null) {
            this.bsl = getTextDirectionHeuristic();
          }
          if (localTruncateAt != this.adVQ) {
            break label462;
          }
          bool2 = true;
          this.mLayout = a(paramInt1, paramMetrics1, paramInt3, localAlignment, bool1, localTruncateAt, bool2);
          if (this.adVQ == null) {
            break label468;
          }
          k = 1;
          this.afXv = null;
          if (this.afXu != null) {
            if (k == 0) {
              break label629;
            }
          }
        }
        for (;;)
        {
          if (paramMetrics2 == adWu)
          {
            paramMetrics2 = BoringLayout.isBoring(this.afXu, this.xe, this.afXQ);
            paramMetrics1 = paramMetrics2;
            if (paramMetrics2 != null) {
              this.afXQ = paramMetrics2;
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
              if (this.afXR != null)
              {
                this.afXv = this.afXR.replaceOrMake(this.afXu, this.xe, paramInt1, localAlignment, this.adVU, this.adVV, paramMetrics1, this.adWd);
                this.afXR = ((BoringLayout)this.afXv);
              }
            }
            else if (this.afXv == null)
            {
              paramMetrics2 = this.afXu;
              i = this.afXu.length();
              localTextPaint = this.xe;
              f1 = this.adVU;
              f2 = this.adVV;
              bool1 = this.adWd;
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
              this.afXv = new StaticLayout(paramMetrics2, 0, i, localTextPaint, paramInt1, localAlignment, f1, f2, bool1, paramMetrics1, paramInt3);
              if ((paramBoolean) || ((paramInt2 != 0) && (j != this.mLayout.getParagraphDirection(0)))) {
                jFt();
              }
              if (this.afYi != null) {
                this.afYi.jFX();
              }
              AppMethodBeat.o(252577);
              return;
              paramInt2 = 0;
              break;
              bool1 = false;
              break label112;
              bool2 = false;
              break label145;
              k = 0;
              break label175;
              this.afXv = BoringLayout.make(this.afXu, this.xe, paramInt1, localAlignment, this.adVU, this.adVV, paramMetrics1, this.adWd);
              break label302;
              label508:
              if ((k == 0) || (paramMetrics1.width > paramInt1)) {
                break label313;
              }
              if (this.afXR != null)
              {
                this.afXv = this.afXR.replaceOrMake(this.afXu, this.xe, paramInt1, localAlignment, this.adVU, this.adVV, paramMetrics1, this.adWd, this.adVQ, paramInt3);
                break label313;
              }
              this.afXv = BoringLayout.make(this.afXu, this.xe, paramInt1, localAlignment, this.adVU, this.adVV, paramMetrics1, this.adWd, this.adVQ, paramInt3);
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
    AppMethodBeat.i(252661);
    if (!(this.mText instanceof Editable))
    {
      AppMethodBeat.o(252661);
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
    AppMethodBeat.o(252661);
  }
  
  private static void a(Context paramContext, TypedArray paramTypedArray, d paramd)
  {
    AppMethodBeat.i(252448);
    if (paramTypedArray == null)
    {
      AppMethodBeat.o(252448);
      return;
    }
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    int k;
    int m;
    if (i < j)
    {
      k = paramTypedArray.getIndex(i);
      m = afYm.get(k, -1);
      if (m != -1)
      {
        if (m != a.m.MMNewTextView_android_textColorHighlight) {
          break label84;
        }
        paramd.afYN = paramTypedArray.getColor(k, paramd.afYN);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label84:
      if (m == a.m.MMNewTextView_android_textColor)
      {
        paramd.NhP = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textColorHint)
      {
        paramd.afYO = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textColorLink)
      {
        paramd.afYP = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textSize)
      {
        paramd.sDK = paramTypedArray.getDimensionPixelSize(k, paramd.sDK);
        if (Build.VERSION.SDK_INT < 22) {
          continue;
        }
        paramd.afXC = paramTypedArray.peekValue(k).getComplexUnit();
        continue;
      }
      if (m == a.m.MMNewTextView_android_textLocale)
      {
        Object localObject = paramTypedArray.getString(k);
        if ((localObject == null) || (Build.VERSION.SDK_INT < 24)) {
          continue;
        }
        localObject = LocaleList.forLanguageTags((String)localObject);
        if (((LocaleList)localObject).isEmpty()) {
          continue;
        }
        paramd.afYQ = ((LocaleList)localObject);
        continue;
      }
      if (m == a.m.MMNewTextView_android_typeface)
      {
        paramd.afYS = paramTypedArray.getInt(k, paramd.afYS);
        if ((paramd.afYS == -1) || (paramd.afYR)) {
          continue;
        }
        paramd.qUf = null;
        continue;
      }
      if ((m != a.m.MMNewTextView_android_fontFamily) || (!paramContext.isRestricted())) {}
      try
      {
        if (Build.VERSION.SDK_INT >= 26) {
          paramd.sB = paramTypedArray.getFont(k);
        }
        label324:
        if (paramd.sB == null) {
          paramd.qUf = paramTypedArray.getString(k);
        }
        paramd.afYR = true;
        continue;
        if (m == a.m.MMNewTextView_android_textStyle)
        {
          paramd.afYT = paramTypedArray.getInt(k, paramd.afYT);
          continue;
        }
        if (m == a.m.MMNewTextView_android_textFontWeight)
        {
          paramd.afYU = paramTypedArray.getInt(k, paramd.afYU);
          continue;
        }
        if (m == a.m.MMNewTextView_android_textAllCaps)
        {
          paramd.afYV = paramTypedArray.getBoolean(k, paramd.afYV);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowColor)
        {
          paramd.ugx = paramTypedArray.getInt(k, paramd.ugx);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowDx)
        {
          paramd.afXi = paramTypedArray.getFloat(k, paramd.afXi);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowDy)
        {
          paramd.afXj = paramTypedArray.getFloat(k, paramd.afXj);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowRadius)
        {
          paramd.afXh = paramTypedArray.getFloat(k, paramd.afXh);
          continue;
        }
        if (m == a.m.MMNewTextView_android_elegantTextHeight)
        {
          paramd.afYW = true;
          paramd.afYX = paramTypedArray.getBoolean(k, paramd.afYX);
          continue;
        }
        if (m == a.m.MMNewTextView_android_fallbackLineSpacing)
        {
          paramd.afYY = true;
          paramd.afYZ = paramTypedArray.getBoolean(k, paramd.afYZ);
          continue;
        }
        if (m == a.m.MMNewTextView_android_letterSpacing)
        {
          paramd.afZa = true;
          paramd.afZb = paramTypedArray.getFloat(k, paramd.afZb);
          continue;
        }
        if (m == a.m.MMNewTextView_android_fontFeatureSettings)
        {
          paramd.afZc = paramTypedArray.getString(k);
          continue;
        }
        if (m != a.m.MMNewTextView_android_fontVariationSettings) {
          continue;
        }
        paramd.afZd = paramTypedArray.getString(k);
        continue;
        AppMethodBeat.o(252448);
        return;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        break label324;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        break label324;
      }
    }
  }
  
  private void a(Typeface paramTypeface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252365);
    if (paramInt2 >= 0) {
      Math.min(1000, paramInt2);
    }
    setTypeface(paramTypeface, paramInt1);
    AppMethodBeat.o(252365);
  }
  
  private void a(Typeface paramTypeface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252356);
    if ((paramTypeface == null) && (paramString != null))
    {
      a(Typeface.create(paramString, 0), paramInt2, paramInt3);
      AppMethodBeat.o(252356);
      return;
    }
    if (paramTypeface != null)
    {
      a(paramTypeface, paramInt2, paramInt3);
      AppMethodBeat.o(252356);
      return;
    }
    switch (paramInt1)
    {
    default: 
      a(null, paramInt2, paramInt3);
      AppMethodBeat.o(252356);
      return;
    case 1: 
      a(Typeface.SANS_SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(252356);
      return;
    case 2: 
      a(Typeface.SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(252356);
      return;
    }
    a(Typeface.MONOSPACE, paramInt2, paramInt3);
    AppMethodBeat.o(252356);
  }
  
  private void a(Editable paramEditable, InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(252510);
    boolean bool;
    if (this.afYi != null)
    {
      bool = this.afYi.afZx instanceof InputFilter;
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
          arrayOfInputFilter[(paramArrayOfInputFilter.length + 0)] = ((InputFilter)this.afYi.afZx);
        }
        paramEditable.setFilters(arrayOfInputFilter);
        AppMethodBeat.o(252510);
        return;
      }
      paramEditable.setFilters(paramArrayOfInputFilter);
      AppMethodBeat.o(252510);
      return;
    }
  }
  
  private void a(CursorAnchorInfo.Builder paramBuilder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252684);
    int k = this.mLayout.getLineForOffset(paramInt1);
    int i2 = this.mLayout.getLineForOffset(paramInt2 - 1);
    while (k <= i2)
    {
      int j = this.mLayout.getLineStart(k);
      int i = this.mLayout.getLineEnd(k);
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
      if (this.mLayout.getParagraphDirection(k) == 1)
      {
        m = 1;
        float[] arrayOfFloat = new float[i3 - i1];
        this.mLayout.getPaint().getTextWidths(this.adVR, i1, i3, arrayOfFloat);
        f4 = this.mLayout.getLineTop(k);
        f5 = this.mLayout.getLineBottom(k);
        n = i1;
        if (n >= i3) {
          break label404;
        }
        f3 = arrayOfFloat[(n - i1)];
        bool1 = this.mLayout.isRtlCharAt(n);
        f1 = this.mLayout.getPrimaryHorizontal(n);
        f2 = this.mLayout.getSecondaryHorizontal(n);
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
        boolean bool2 = bj(f1, f3);
        boolean bool3 = bj(f2, f6);
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
    AppMethodBeat.o(252684);
  }
  
  private void a(InputMethodManager paramInputMethodManager)
  {
    AppMethodBeat.i(252693);
    if (paramInputMethodManager != null) {
      paramInputMethodManager.viewClicked(this);
    }
    AppMethodBeat.o(252693);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252658);
    Object localObject1;
    if (this.mListeners != null)
    {
      localObject1 = this.mListeners;
      int j = ((ArrayList)localObject1).size();
      int i = 0;
      while (i < j)
      {
        ((TextWatcher)((ArrayList)localObject1).get(i)).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        i += 1;
      }
    }
    paramCharSequence = null;
    try
    {
      localObject1 = Class.forName("android.text.style.SpellCheckSpan");
      paramCharSequence = (CharSequence)localObject1;
    }
    finally
    {
      label78:
      break label78;
    }
    if (paramCharSequence != null) {
      a(paramInt1, paramInt1 + paramInt2, paramCharSequence);
    }
    a(paramInt1, paramInt1 + paramInt2, SuggestionSpan.class);
    AppMethodBeat.o(252658);
  }
  
  private boolean a(ClipData paramClipData)
  {
    AppMethodBeat.i(252691);
    ClipboardManager localClipboardManager = getClipboardManagerForUser();
    try
    {
      localClipboardManager.setPrimaryClip(paramClipData);
      afXc = SystemClock.uptimeMillis();
      return true;
    }
    finally
    {
      AppMethodBeat.o(252691);
    }
    return false;
  }
  
  private static boolean aEq(int paramInt)
  {
    return (0x2000F & paramInt) == 131073;
  }
  
  private static boolean aEr(int paramInt)
  {
    paramInt &= 0xFFF;
    return (paramInt == 129) || (paramInt == 225) || (paramInt == 18);
  }
  
  private static boolean aEs(int paramInt)
  {
    return (paramInt & 0xFFF) == 145;
  }
  
  private boolean aEt(int paramInt)
  {
    AppMethodBeat.i(252636);
    if (isLayoutRequested())
    {
      this.afXO = paramInt;
      AppMethodBeat.o(252636);
      return false;
    }
    if (jFy()) {}
    for (Layout localLayout = this.afXv; localLayout == null; localLayout = this.mLayout)
    {
      AppMethodBeat.o(252636);
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
    switch (CustomTextView.5.dgZ[localLayout.getParagraphAlignment(i3).ordinal()])
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
      if (!this.afXG)
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
                  AppMethodBeat.o(252636);
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
                  long l2 = this.bwy;
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
                    this.bwy = AnimationUtils.currentAnimationTimeMillis();
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
  
  private void akv()
  {
    AppMethodBeat.i(252620);
    if (((getLayoutParams().width != -2) || ((this.afXM == this.afXN) && (this.vF == this.mf))) && ((this.afXu == null) || (this.afXv != null)) && (getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0))
    {
      int j = this.mLayout.getHeight();
      int k = this.mLayout.getWidth();
      if (this.afXv == null) {}
      for (int i = 0;; i = this.afXv.getWidth())
      {
        BoringLayout.Metrics localMetrics = adWu;
        a(k, i, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        if (this.adVQ == TextUtils.TruncateAt.MARQUEE) {
          break label231;
        }
        if ((getLayoutParams().height == -2) || (getLayoutParams().height == -1)) {
          break;
        }
        invalidate();
        AppMethodBeat.o(252620);
        return;
      }
      if ((this.mLayout.getHeight() == j) && ((this.afXv == null) || (this.afXv.getHeight() == j)))
      {
        invalidate();
        AppMethodBeat.o(252620);
        return;
      }
      label231:
      requestLayout();
      invalidate();
      AppMethodBeat.o(252620);
      return;
    }
    jmX();
    requestLayout();
    invalidate();
    AppMethodBeat.o(252620);
  }
  
  private static int b(Layout paramLayout)
  {
    int k = 0;
    AppMethodBeat.i(252590);
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
        AppMethodBeat.o(252590);
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
    AppMethodBeat.o(252590);
    return i;
  }
  
  private void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252664);
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
    if (this.afYi != null) {
      this.afYi.jGj();
    }
    AppMethodBeat.o(252664);
  }
  
  private void bA(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252516);
    if ((paramInt1 >= 0) || (paramInt2 >= 0) || (paramInt3 >= 0)) {
      oK(Math.min(Math.min(paramInt1, paramInt2), paramInt3), Math.max(Math.max(paramInt1, paramInt2), paramInt3));
    }
    AppMethodBeat.o(252516);
  }
  
  private CharSequence ba(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(252483);
    if ((paramCharSequence instanceof Spanned))
    {
      if ((paramCharSequence instanceof Spannable)) {}
      SuggestionSpan[] arrayOfSuggestionSpan;
      for (Spannable localSpannable = (Spannable)paramCharSequence;; localSpannable = this.adVP.newSpannable(paramCharSequence))
      {
        arrayOfSuggestionSpan = (SuggestionSpan[])localSpannable.getSpans(0, paramCharSequence.length(), SuggestionSpan.class);
        if (arrayOfSuggestionSpan.length != 0) {
          break;
        }
        AppMethodBeat.o(252483);
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
    AppMethodBeat.o(252483);
    return paramCharSequence;
  }
  
  private float bi(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252666);
    int i = getHorizontalFadingEdgeLength();
    if (i == 0)
    {
      AppMethodBeat.o(252666);
      return 0.0F;
    }
    paramFloat1 = Math.abs(paramFloat1 - paramFloat2);
    if (paramFloat1 > i)
    {
      AppMethodBeat.o(252666);
      return 1.0F;
    }
    paramFloat1 /= i;
    AppMethodBeat.o(252666);
    return paramFloat1;
  }
  
  private void c(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(252640);
    K(paramRect);
    if (paramInt == 0) {
      paramRect.top -= getExtendedPaddingTop();
    }
    if (paramInt == this.mLayout.getLineCount() - 1) {
      paramRect.bottom += getExtendedPaddingBottom();
    }
    AppMethodBeat.o(252640);
  }
  
  private void cS(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(252501);
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
        this.afXD = false;
        if (!paramBoolean) {
          break label386;
        }
        jFQ();
        this.afYi.afZx = ((KeyListener)localObject1);
        AppMethodBeat.o(252501);
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
      if (!this.afXE) {
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
          AppMethodBeat.o(252501);
          return;
        }
      }
      localObject2 = null;
    }
  }
  
  private <T> T cs(Class<T> paramClass)
  {
    AppMethodBeat.i(252672);
    if ((this.afXT == null) && (Build.VERSION.SDK_INT >= 23))
    {
      paramClass = getContext().getSystemService(paramClass);
      AppMethodBeat.o(252672);
      return paramClass;
    }
    AppMethodBeat.o(252672);
    return null;
  }
  
  private void ee(float paramFloat)
  {
    AppMethodBeat.i(252452);
    if (paramFloat != this.xe.getTextSize())
    {
      this.xe.setTextSize(paramFloat);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252452);
  }
  
  private Locale getCustomLocaleForKeyListenerOrNull()
  {
    AppMethodBeat.i(252494);
    if (!this.afXE)
    {
      AppMethodBeat.o(252494);
      return null;
    }
    Object localObject = getImeHintLocales();
    if (localObject == null)
    {
      AppMethodBeat.o(252494);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = ((LocaleList)localObject).get(0);
      AppMethodBeat.o(252494);
      return localObject;
    }
    AppMethodBeat.o(252494);
    return null;
  }
  
  private int getDesiredHeight()
  {
    boolean bool = true;
    AppMethodBeat.i(252596);
    int i = a(this.mLayout, true);
    Layout localLayout = this.afXv;
    if (this.adVQ != null) {}
    for (;;)
    {
      i = Math.max(i, a(localLayout, bool));
      AppMethodBeat.o(252596);
      return i;
      bool = false;
    }
  }
  
  private Layout.Alignment getLayoutAlignment()
  {
    AppMethodBeat.i(252566);
    Layout.Alignment localAlignment = null;
    switch (getTextAlignment())
    {
    default: 
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
    }
    for (;;)
    {
      AppMethodBeat.o(252566);
      return localAlignment;
      switch (this.tJ & 0x800007)
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
    AppMethodBeat.i(252538);
    Object localObject2 = null;
    Paint localPaint = this.afXW;
    int j = getSelectionStart();
    int k = getSelectionEnd();
    Object localObject1 = localObject2;
    if (this.afXw != null) {
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
          if (this.afYi != null)
          {
            localObject1 = this.afYi;
            if (!((b)localObject1).jFW()) {
              break label222;
            }
            if (!((b)localObject1).afZA) {
              break label202;
            }
            localObject1 = localObject2;
            if (i != 0)
            {
              if (this.afXX)
              {
                if (this.afXV == null) {
                  this.afXV = new Path();
                }
                this.afXV.reset();
                this.mLayout.getCursorPath(j, this.afXV, this.mText);
                this.afYi.jGp();
                this.afXX = false;
              }
              localPaint.setColor(this.adVN);
              localPaint.setStyle(Paint.Style.STROKE);
            }
          }
        }
      }
    }
    for (localObject1 = this.afXV;; localObject1 = this.afXV)
    {
      AppMethodBeat.o(252538);
      return localObject1;
      label202:
      if ((SystemClock.uptimeMillis() - ((b)localObject1).afZz) % 1000L < 500L) {
        break;
      }
      label222:
      i = 0;
      break;
      label227:
      if (this.afXX)
      {
        if (this.afXV == null) {
          this.afXV = new Path();
        }
        this.afXV.reset();
        this.mLayout.getSelectionPath(j, k, this.afXV);
        this.afXX = false;
      }
      localPaint.setColor(this.uRB);
      localPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private static void h(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(252467);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])paramSpannable.getSpans(0, paramSpannable.length(), SuggestionSpan.class);
    while (i < arrayOfSuggestionSpan.length)
    {
      int j = arrayOfSuggestionSpan[i].getFlags();
      if (((j & 0x1) != 0) && ((j & 0x2) != 0)) {
        paramSpannable.removeSpan(arrayOfSuggestionSpan[i]);
      }
      i += 1;
    }
    AppMethodBeat.o(252467);
  }
  
  public static boolean jFH()
  {
    return false;
  }
  
  private boolean jFI()
  {
    if (this.afYi == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (((this.afYi.OeF & 0xF) != 1) || ((this.afYi.OeF & 0x80000) > 0));
      i = this.afYi.OeF & 0xFF0;
    } while ((i != 0) && (i != 48) && (i != 80) && (i != 64) && (i != 160));
    return true;
  }
  
  private void jFQ()
  {
    AppMethodBeat.i(252694);
    if (this.afYi == null) {
      this.afYi = new b(this);
    }
    AppMethodBeat.o(252694);
  }
  
  private void jFR()
  {
    AppMethodBeat.i(252698);
    if (!(this.mText instanceof Spannable)) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(252698);
  }
  
  private void jFo()
  {
    AppMethodBeat.i(252398);
    try
    {
      this.afYi.OeF = this.afYi.afZx.getInputType();
      setInputTypeSingleLine(this.adTq);
      AppMethodBeat.o(252398);
      return;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      for (;;)
      {
        this.afYi.OeF = 1;
      }
    }
  }
  
  private void jFp()
  {
    AppMethodBeat.i(252412);
    if ((this.afXw != null) || ((this.afYi != null) && (this.afYi.afZx != null)))
    {
      setFocusable(true);
      setClickable(true);
      setLongClickable(true);
      AppMethodBeat.o(252412);
      return;
    }
    setClickable(false);
    setLongClickable(false);
    AppMethodBeat.o(252412);
  }
  
  private void jFq()
  {
    AppMethodBeat.i(252433);
    if (this.afXq == null)
    {
      AppMethodBeat.o(252433);
      return;
    }
    if ((this.afXq.afYw) || (this.afXq.kC))
    {
      ColorStateList localColorStateList = this.afXq.kz;
      boolean bool = this.afXq.afYw;
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.afXq.afYu;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if ((localDrawable != null) && (localDrawable != this.afXq.afYz))
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
    AppMethodBeat.o(252433);
  }
  
  private void jFt()
  {
    AppMethodBeat.i(252529);
    if (!this.afXk)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.afXk = true;
    }
    AppMethodBeat.o(252529);
  }
  
  private boolean jFv()
  {
    AppMethodBeat.i(252543);
    if (getKeyListener() == null)
    {
      AppMethodBeat.o(252543);
      return false;
    }
    if (this.adTq)
    {
      AppMethodBeat.o(252543);
      return true;
    }
    if ((this.afYi != null) && ((this.afYi.OeF & 0xF) == 1))
    {
      int i = this.afYi.OeF & 0xFF0;
      if ((i == 32) || (i == 48))
      {
        AppMethodBeat.o(252543);
        return true;
      }
    }
    AppMethodBeat.o(252543);
    return false;
  }
  
  private boolean jFw()
  {
    AppMethodBeat.i(252580);
    if ((jFu()) || (this.afXs != null))
    {
      AppMethodBeat.o(252580);
      return true;
    }
    AppMethodBeat.o(252580);
    return false;
  }
  
  private void jFx()
  {
    int k = 1;
    AppMethodBeat.i(252610);
    int i = 0;
    int j = 0;
    if (this.mLayout != null)
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
      AppMethodBeat.o(252610);
      return;
      label77:
      i = j;
      if (getLayoutParams().height == -1)
      {
        i = j;
        if (this.adWc >= 0)
        {
          i = j;
          if (getDesiredHeight() != this.adWc)
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
  
  private boolean jFy()
  {
    AppMethodBeat.i(252625);
    if ((TextUtils.isEmpty(this.mText)) && (!TextUtils.isEmpty(this.afXu)))
    {
      AppMethodBeat.o(252625);
      return true;
    }
    AppMethodBeat.o(252625);
    return false;
  }
  
  private void jmX()
  {
    AppMethodBeat.i(252558);
    if (((this.mLayout instanceof BoringLayout)) && (this.adWe == null)) {
      this.adWe = ((BoringLayout)this.mLayout);
    }
    if (((this.afXv instanceof BoringLayout)) && (this.afXR == null)) {
      this.afXR = ((BoringLayout)this.afXv);
    }
    this.afXQ = null;
    this.afXP = null;
    if (this.afYi != null) {
      this.afYi.jFX();
    }
    AppMethodBeat.o(252558);
  }
  
  private void jmY()
  {
    AppMethodBeat.i(252562);
    int j = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    if (this.afXG) {}
    for (j = 1048576;; j = i)
    {
      BoringLayout.Metrics localMetrics = adWu;
      a(j, i, localMetrics, localMetrics, i, false);
      AppMethodBeat.o(252562);
      return;
    }
  }
  
  private void oK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252523);
    if (this.mLayout == null)
    {
      invalidate();
      AppMethodBeat.o(252523);
      return;
    }
    int j = this.mLayout.getLineForOffset(paramInt1);
    int k = this.mLayout.getLineTop(j);
    int i = k;
    if (j > 0) {
      i = k - this.mLayout.getLineDescent(j - 1);
    }
    if (paramInt1 == paramInt2)
    {
      paramInt1 = j;
      paramInt2 = this.mLayout.getLineBottom(paramInt1);
      if ((this.afYi == null) || (this.afYi.afZO == null)) {
        break label210;
      }
      Rect localRect = this.afYi.afZO.getBounds();
      paramInt1 = Math.min(i, localRect.top);
      paramInt2 = Math.max(paramInt2, localRect.bottom);
    }
    for (;;)
    {
      i = getCompoundPaddingLeft();
      j = getExtendedPaddingTop() + No(true);
      k = getWidth();
      int m = getCompoundPaddingRight();
      invalidate(i + getScrollX(), paramInt1 + j, k - m + getScrollY(), paramInt2 + j);
      AppMethodBeat.o(252523);
      return;
      paramInt1 = this.mLayout.getLineForOffset(paramInt2);
      break;
      label210:
      paramInt1 = i;
    }
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int j = 1;
    AppMethodBeat.i(252427);
    Object localObject2 = this.afXq;
    if (localObject2 != null)
    {
      if (((b)localObject2).afYx != null) {
        ((b)localObject2).afYx.setCallback(null);
      }
      ((b)localObject2).afYx = null;
      if (((b)localObject2).afYy != null) {
        ((b)localObject2).afYy.setCallback(null);
      }
      ((b)localObject2).afYy = null;
      ((b)localObject2).afYG = 0;
      ((b)localObject2).afYE = 0;
      ((b)localObject2).afYH = 0;
      ((b)localObject2).afYF = 0;
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
        if (((b)localObject2).adWM == 0)
        {
          i = j;
          if (!((b)localObject2).kC)
          {
            if (!((b)localObject2).afYw) {
              break label221;
            }
            i = j;
          }
        }
        label160:
        if (i != 0) {
          break label227;
        }
        this.afXq = null;
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      if (localObject1 != null)
      {
        ((b)localObject1).afYA = paramDrawable1;
        ((b)localObject1).afYB = paramDrawable3;
      }
      this.afXr = -1;
      jFq();
      invalidate();
      requestLayout();
      AppMethodBeat.o(252427);
      return;
      i = 0;
      break;
      label221:
      i = 0;
      break label160;
      label227:
      i = ((b)localObject2).afYu.length - 1;
      while (i >= 0)
      {
        if (localObject2.afYu[i] != null) {
          localObject2.afYu[i].setCallback(null);
        }
        ((b)localObject2).afYu[i] = null;
        i -= 1;
      }
      ((b)localObject2).adWK = 0;
      ((b)localObject2).adWG = 0;
      ((b)localObject2).adWL = 0;
      ((b)localObject2).adWH = 0;
      ((b)localObject2).adWI = 0;
      ((b)localObject2).adWE = 0;
      label319:
      ((b)localObject2).adWJ = 0;
      ((b)localObject2).adWF = 0;
    }
    label338:
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b(getContext());
      this.afXq = ((b)localObject1);
    }
    this.afXq.afYD = false;
    if ((localObject1.afYu[0] != paramDrawable1) && (localObject1.afYu[0] != null)) {
      localObject1.afYu[0].setCallback(null);
    }
    ((b)localObject1).afYu[0] = paramDrawable1;
    if ((localObject1.afYu[1] != paramDrawable2) && (localObject1.afYu[1] != null)) {
      localObject1.afYu[1].setCallback(null);
    }
    ((b)localObject1).afYu[1] = paramDrawable2;
    if ((localObject1.afYu[2] != paramDrawable3) && (localObject1.afYu[2] != null)) {
      localObject1.afYu[2].setCallback(null);
    }
    ((b)localObject1).afYu[2] = paramDrawable3;
    if ((localObject1.afYu[3] != paramDrawable4) && (localObject1.afYu[3] != null)) {
      localObject1.afYu[3].setCallback(null);
    }
    ((b)localObject1).afYu[3] = paramDrawable4;
    Rect localRect = ((b)localObject1).adWz;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds(localRect);
      paramDrawable1.setCallback(this);
      ((b)localObject1).adWG = localRect.width();
      ((b)localObject1).adWK = localRect.height();
      label591:
      if (paramDrawable3 == null) {
        break label743;
      }
      paramDrawable3.setState(arrayOfInt);
      paramDrawable3.copyBounds(localRect);
      paramDrawable3.setCallback(this);
      ((b)localObject1).adWH = localRect.width();
      ((b)localObject1).adWL = localRect.height();
      label633:
      if (paramDrawable2 == null) {
        break label758;
      }
      paramDrawable2.setState(arrayOfInt);
      paramDrawable2.copyBounds(localRect);
      paramDrawable2.setCallback(this);
      ((b)localObject1).adWE = localRect.height();
      ((b)localObject1).adWI = localRect.width();
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
      ((b)localObject1).adWF = localRect.height();
      ((b)localObject1).adWJ = localRect.width();
      break;
      ((b)localObject1).adWK = 0;
      ((b)localObject1).adWG = 0;
      break label591;
      label743:
      ((b)localObject1).adWL = 0;
      ((b)localObject1).adWH = 0;
      break label633;
      label758:
      ((b)localObject1).adWI = 0;
      ((b)localObject1).adWE = 0;
    }
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252473);
    this.afXu = TextUtils.stringOrSpannedString(paramCharSequence);
    if (this.mLayout != null) {
      akv();
    }
    if (this.mText.length() == 0) {
      invalidate();
    }
    if (this.afYi != null) {
      this.mText.length();
    }
    AppMethodBeat.o(252473);
  }
  
  private void setInputTypeSingleLine(boolean paramBoolean)
  {
    if ((this.afYi != null) && ((this.afYi.OeF & 0xF) == 1))
    {
      if (paramBoolean)
      {
        localb = this.afYi;
        localb.OeF &= 0xFFFDFFFF;
      }
    }
    else {
      return;
    }
    b localb = this.afYi;
    localb.OeF |= 0x20000;
  }
  
  private void setKeyListenerOnly(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(252406);
    if ((this.afYi == null) && (paramKeyListener == null))
    {
      AppMethodBeat.o(252406);
      return;
    }
    jFQ();
    if (this.afYi.afZx != paramKeyListener)
    {
      this.afYi.afZx = paramKeyListener;
      if ((paramKeyListener != null) && (!(this.mText instanceof Editable))) {
        setText(this.mText);
      }
      a((Editable)this.mText, this.afXS);
    }
    AppMethodBeat.o(252406);
  }
  
  private void setTextInternal(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = null)
    {
      this.afXs = paramCharSequence;
      return;
    }
  }
  
  private void setTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(252387);
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
        paramTypeface = this.xe;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.xe;
        if ((paramInt & 0x2) == 0) {
          break label106;
        }
      }
      label100:
      label106:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        AppMethodBeat.o(252387);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label37;
      }
    }
    this.xe.setFakeBoldText(false);
    this.xe.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
    AppMethodBeat.o(252387);
  }
  
  private void t(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(252651);
    this.adTq = paramBoolean1;
    if (paramBoolean1)
    {
      setLines(1);
      setHorizontallyScrolling(true);
      if (paramBoolean2)
      {
        setTransformationMethod(SingleLineTransformationMethod.getInstance());
        AppMethodBeat.o(252651);
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
    AppMethodBeat.o(252651);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(252460);
    int[] arrayOfInt = getDrawableState();
    int i = this.NhP.getColorForState(arrayOfInt, 0);
    if (i != this.adVN) {
      this.adVN = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.afXe != null)
      {
        k = this.afXe.getColorForState(arrayOfInt, 0);
        i = j;
        if (k != this.xe.linkColor)
        {
          this.xe.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.afXd != null)
      {
        k = this.afXd.getColorForState(arrayOfInt, 0);
        j = i;
        if (k != this.afXf)
        {
          this.afXf = k;
          j = i;
          if (this.mText.length() == 0) {
            j = 1;
          }
        }
      }
      if (j != 0) {
        invalidate();
      }
      AppMethodBeat.o(252460);
      return;
    }
  }
  
  final int E(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(253748);
    paramFloat = ef(paramFloat);
    paramInt = getLayout().getOffsetForHorizontal(paramInt, paramFloat);
    AppMethodBeat.o(253748);
    return paramInt;
  }
  
  final int No(boolean paramBoolean)
  {
    AppMethodBeat.i(253227);
    int j = 0;
    int k = this.tJ & 0x70;
    Layout localLayout2 = this.mLayout;
    Layout localLayout1 = localLayout2;
    if (!paramBoolean)
    {
      localLayout1 = localLayout2;
      if (this.mText.length() == 0)
      {
        localLayout1 = localLayout2;
        if (this.afXv != null) {
          localLayout1 = this.afXv;
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
      AppMethodBeat.o(253227);
      return i;
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252733);
    Log.i("cmEdit.CMTextView", "init");
    setTextInternal("");
    Object localObject1 = getResources();
    this.xe = new TextPaint(1);
    this.xe.density = ((Resources)localObject1).getDisplayMetrics().density;
    this.afXW = new Paint(1);
    this.afXw = getDefaultMovementMethod();
    this.afXx = null;
    d locald = new d((byte)0);
    locald.NhP = ColorStateList.valueOf(-16777216);
    locald.sDK = bd.fromDPToPix(getContext(), 18);
    this.bsm = 0;
    this.bsn = 0;
    this.afXJ = 0;
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
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MMNewTextView, paramInt1, paramInt2);
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
        break label2496;
      }
      i5 = localTypedArray.getIndex(i4);
      if (i5 != a.m.MMNewTextView_android_editable) {
        break label323;
      }
      bool4 = localTypedArray.getBoolean(i5, bool4);
      localObject2 = localObject1;
      localObject1 = paramAttributeSet;
      paramAttributeSet = (AttributeSet)localObject2;
    }
    label2496:
    for (;;)
    {
      i4 += 1;
      localObject2 = localObject1;
      localObject1 = paramAttributeSet;
      paramAttributeSet = (AttributeSet)localObject2;
      break label253;
      i3 = 0;
      break;
      label323:
      if (i5 == a.m.MMNewTextView_android_inputMethod)
      {
        localObject4 = localTypedArray.getText(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_numeric)
      {
        i2 = localTypedArray.getInt(i5, i2);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_digits)
      {
        localCharSequence = localTypedArray.getText(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_phoneNumber)
      {
        bool5 = localTypedArray.getBoolean(i5, bool5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_autoText)
      {
        bool6 = localTypedArray.getBoolean(i5, bool6);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_capitalize)
      {
        i1 = localTypedArray.getInt(i5, i1);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_selectAllOnFocus)
      {
        bool2 = localTypedArray.getBoolean(i5, bool2);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_autoLink)
      {
        this.afXH = localTypedArray.getInt(i5, 0);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_linksClickable)
      {
        this.afXI = localTypedArray.getBoolean(i5, true);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableLeft)
      {
        localObject6 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableTop)
      {
        localDrawable3 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableRight)
      {
        localDrawable4 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableBottom)
      {
        localDrawable5 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableStart)
      {
        localDrawable1 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableEnd)
      {
        localDrawable2 = localTypedArray.getDrawable(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_drawableTint)
      {
        localColorStateList = localTypedArray.getColorStateList(i5);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if (i5 != a.m.MMNewTextView_android_drawableTintMode)
        {
          if (i5 == a.m.MMNewTextView_android_drawablePadding)
          {
            n = localTypedArray.getDimensionPixelSize(i5, n);
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_maxLines)
          {
            setMaxLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_maxHeight)
          {
            setMaxHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_lines)
          {
            setLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_height)
          {
            setHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_minLines)
          {
            setMinLines(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_minHeight)
          {
            setMinHeight(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_maxEms)
          {
            setMaxEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_maxWidth)
          {
            setMaxWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_ems)
          {
            setEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_width)
          {
            setWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_minEms)
          {
            setMinEms(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_minWidth)
          {
            setMinWidth(localTypedArray.getDimensionPixelSize(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_gravity)
          {
            setGravity(localTypedArray.getInt(i5, -1));
            localObject2 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_hint)
          {
            localObject2 = localTypedArray.getText(i5);
            localObject1 = paramAttributeSet;
            paramAttributeSet = (AttributeSet)localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_text)
          {
            localObject2 = localTypedArray.getText(i5);
            paramAttributeSet = (AttributeSet)localObject1;
            localObject1 = localObject2;
            continue;
          }
          if (i5 == a.m.MMNewTextView_android_scrollHorizontally)
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
            if (i5 == a.m.MMNewTextView_android_singleLine)
            {
              bool1 = localTypedArray.getBoolean(i5, bool1);
              localObject2 = paramAttributeSet;
              paramAttributeSet = (AttributeSet)localObject1;
              localObject1 = localObject2;
              continue;
            }
            if (i5 == a.m.MMNewTextView_android_ellipsize)
            {
              i = localTypedArray.getInt(i5, i);
              localObject2 = paramAttributeSet;
              paramAttributeSet = (AttributeSet)localObject1;
              localObject1 = localObject2;
              continue;
            }
            if (i5 != a.m.MMNewTextView_android_marqueeRepeatLimit) {
              if (i5 == a.m.MMNewTextView_android_includeFontPadding)
              {
                if (!localTypedArray.getBoolean(i5, true))
                {
                  setIncludeFontPadding(false);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                }
              }
              else if (i5 == a.m.MMNewTextView_android_cursorVisible)
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
                if (i5 == a.m.MMNewTextView_android_maxLength)
                {
                  m = localTypedArray.getInt(i5, -1);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textScaleX)
                {
                  setTextScaleX(localTypedArray.getFloat(i5, 1.0F));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_freezesText)
                {
                  this.afXg = localTypedArray.getBoolean(i5, false);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_enabled)
                {
                  setEnabled(localTypedArray.getBoolean(i5, isEnabled()));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_password)
                {
                  bool3 = localTypedArray.getBoolean(i5, bool3);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_lineSpacingExtra)
                {
                  this.adVV = localTypedArray.getDimensionPixelSize(i5, (int)this.adVV);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_lineSpacingMultiplier)
                {
                  this.adVU = localTypedArray.getFloat(i5, this.adVU);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_inputType)
                {
                  paramInt2 = localTypedArray.getInt(i5, 0);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_allowUndo)
                {
                  jFQ();
                  this.afYi.afZh = localTypedArray.getBoolean(i5, true);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeOptions)
                {
                  jFQ();
                  this.afYi.jFV();
                  this.afYi.afZs.qiM = localTypedArray.getInt(i5, this.afYi.afZs.qiM);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeActionLabel)
                {
                  jFQ();
                  this.afYi.jFV();
                  this.afYi.afZs.agaY = localTypedArray.getText(i5);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeActionId)
                {
                  jFQ();
                  this.afYi.jFV();
                  this.afYi.afZs.agaZ = localTypedArray.getInt(i5, this.afYi.afZs.agaZ);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_privateImeOptions)
                {
                  setPrivateImeOptions(localTypedArray.getString(i5));
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_editorExtras)
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
                if (i5 == a.m.MMNewTextView_android_textCursorDrawable)
                {
                  this.afXY = localTypedArray.getResourceId(i5, 16843618);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandleLeft)
                {
                  this.afYa = localTypedArray.getResourceId(i5, 16843461);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandleRight)
                {
                  this.afYc = localTypedArray.getResourceId(i5, 16843462);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandle)
                {
                  this.afYe = localTypedArray.getResourceId(i5, 16843463);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textIsSelectable)
                {
                  setTextIsSelectable(localTypedArray.getBoolean(i5, false));
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_breakStrategy)
                {
                  this.bsm = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_hyphenationFrequency)
                {
                  this.bsn = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_justificationMode)
                {
                  this.afXJ = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_firstBaselineToTopHeight)
                {
                  j = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_lastBaselineToBottomHeight)
                {
                  k = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_lineHeight)
                {
                  paramInt1 = localTypedArray.getDimensionPixelSize(i5, -1);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                  if (localTypedArray != null) {
                    localTypedArray.recycle();
                  }
                  localObject3 = TextView.BufferType.EDITABLE;
                  i5 = paramInt2 & 0xFFF;
                  label2541:
                  label2551:
                  boolean bool7;
                  if (i5 == 129)
                  {
                    i3 = 1;
                    if (i5 != 225) {
                      break label3795;
                    }
                    i4 = 1;
                    if (i5 != 18) {
                      break label3801;
                    }
                    i5 = 1;
                    int i6 = paramContext.getApplicationInfo().targetSdkVersion;
                    if (i6 < 26) {
                      break label3807;
                    }
                    bool7 = true;
                    this.afXE = bool7;
                    if (i6 < 28) {
                      break label3813;
                    }
                    bool7 = true;
                    this.afXF = bool7;
                    if (localObject4 == null) {
                      break label3903;
                    }
                  }
                  try
                  {
                    localObject4 = Class.forName(((CharSequence)localObject4).toString());
                  }
                  catch (ClassNotFoundException paramContext)
                  {
                    label2639:
                    label2646:
                    label2911:
                    label3192:
                    paramContext = new RuntimeException(paramContext);
                    label3034:
                    label3807:
                    label3813:
                    AppMethodBeat.o(252733);
                    label3795:
                    label3801:
                    throw paramContext;
                  }
                  try
                  {
                    jFQ();
                    this.afYi.afZx = ((KeyListener)((Class)localObject4).newInstance());
                  }
                  catch (InstantiationException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(252733);
                    throw paramContext;
                  }
                  catch (IllegalAccessException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(252733);
                    throw paramContext;
                  }
                  try
                  {
                    localObject4 = this.afYi;
                    if (paramInt2 == 0) {
                      break label3873;
                    }
                    ((b)localObject4).OeF = paramInt2;
                  }
                  catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
                  {
                    this.afYi.OeF = 1;
                    break label2646;
                  }
                  if (this.afYi != null)
                  {
                    localObject4 = this.afYi;
                    if ((((b)localObject4).OeF & 0xF) != 1) {
                      break label4276;
                    }
                    if ((bool3) || (i3 != 0)) {
                      ((b)localObject4).OeF = (((b)localObject4).OeF & 0xFFFFF00F | 0x80);
                    }
                    if (i4 != 0) {
                      ((b)localObject4).OeF = (((b)localObject4).OeF & 0xFFFFF00F | 0xE0);
                    }
                  }
                  if (bool2)
                  {
                    jFQ();
                    this.afYi.afZD = true;
                    if (localObject3 == TextView.BufferType.NORMAL) {
                      localObject3 = TextView.BufferType.SPANNABLE;
                    }
                  }
                  for (;;)
                  {
                    if (localColorStateList != null)
                    {
                      if (this.afXq == null) {
                        this.afXq = new b(paramContext);
                      }
                      if (localColorStateList != null)
                      {
                        this.afXq.kz = localColorStateList;
                        this.afXq.afYw = true;
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
                        localObject4 = this.afXq;
                        paramContext = (Context)localObject4;
                        if (localObject4 == null)
                        {
                          paramContext = new b(getContext());
                          this.afXq = paramContext;
                        }
                        this.afXq.afYD = true;
                        localObject4 = paramContext.adWz;
                        localObject6 = getDrawableState();
                        if (localDrawable1 == null) {
                          break label4319;
                        }
                        localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
                        localDrawable1.setState((int[])localObject6);
                        localDrawable1.copyBounds((Rect)localObject4);
                        localDrawable1.setCallback(this);
                        paramContext.afYx = localDrawable1;
                        paramContext.afYE = ((Rect)localObject4).width();
                        paramContext.afYG = ((Rect)localObject4).height();
                        if (localDrawable2 == null) {
                          break label4332;
                        }
                        localDrawable2.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
                        localDrawable2.setState((int[])localObject6);
                        localDrawable2.copyBounds((Rect)localObject4);
                        localDrawable2.setCallback(this);
                        paramContext.afYy = localDrawable2;
                        paramContext.afYF = ((Rect)localObject4).width();
                        paramContext.afYH = ((Rect)localObject4).height();
                        this.afXr = -1;
                        jFq();
                      }
                      setCompoundDrawablePadding(n);
                      setInputTypeSingleLine(bool1);
                      t(bool1, bool1, bool1);
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
                          if ((paramInt2 == 0) && ((this.afYi == null) || ((this.afYi.OeF & 0xFFF) != 129))) {
                            break label4381;
                          }
                          i = 1;
                          if (i != 0) {
                            locald.afYS = 3;
                          }
                          if (locald.NhP != null) {
                            setTextColor(locald.NhP);
                          }
                          if (locald.afYO != null) {
                            setHintTextColor(locald.afYO);
                          }
                          if (locald.afYP != null) {
                            setLinkTextColor(locald.afYP);
                          }
                          if (locald.afYN != 0) {
                            setHighlightColor(locald.afYN);
                          }
                          if (locald.sDK != -1)
                          {
                            this.afXC = locald.afXC;
                            ee(locald.sDK);
                          }
                          if (locald.afYQ != null) {
                            setTextLocales(locald.afYQ);
                          }
                          if ((locald.afYS != -1) && (!locald.afYR)) {
                            locald.qUf = null;
                          }
                          a(locald.sB, locald.qUf, locald.afYS, locald.afYT, locald.afYU);
                          if (locald.ugx != 0)
                          {
                            float f1 = locald.afXh;
                            float f2 = locald.afXi;
                            float f3 = locald.afXj;
                            i = locald.ugx;
                            this.xe.setShadowLayer(f1, f2, f3, i);
                            this.afXh = f1;
                            this.afXi = f2;
                            this.afXj = f3;
                            this.ugx = i;
                            if (this.afYi != null) {
                              this.afYi.jGo();
                            }
                            invalidate();
                          }
                          if (locald.afYW) {
                            setElegantTextHeight(locald.afYX);
                          }
                          if (locald.afYY) {
                            setFallbackLineSpacing(locald.afYZ);
                          }
                          if (locald.afZa) {
                            setLetterSpacing(locald.afZb);
                          }
                          if (locald.afZc != null) {
                            setFontFeatureSettings(locald.afZc);
                          }
                          if (locald.afZd != null)
                          {
                            paramContext = locald.afZd;
                            if (Build.VERSION.SDK_INT >= 26)
                            {
                              localObject4 = this.xe.getFontVariationSettings();
                              if ((paramContext != localObject4) && ((paramContext == null) || (!paramContext.equals(localObject4)))) {
                                break label4387;
                              }
                            }
                          }
                          if (paramInt2 != 0) {
                            setTransformationMethod(PasswordTransformationMethod.getInstance());
                          }
                          if (m < 0) {
                            break label4420;
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
                      if (this.adVR == null) {
                        this.adVR = "";
                      }
                      if (localObject1 != null) {
                        setHint((CharSequence)localObject1);
                      }
                      setClickable(true);
                      setLongClickable(true);
                      if (this.afYi != null) {
                        this.afYi.jFX();
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
                      AppMethodBeat.o(252733);
                      return;
                      i3 = 0;
                      break;
                      i4 = 0;
                      break label2541;
                      i5 = 0;
                      break label2551;
                      bool7 = false;
                      break label2570;
                      bool7 = false;
                      break label2586;
                      paramInt2 = this.afYi.afZx.getInputType();
                      break label2639;
                      Object localObject5;
                      if (localCharSequence != null)
                      {
                        jFQ();
                        this.afYi.afZx = DigitsKeyListener.getInstance(localCharSequence.toString());
                        localObject5 = this.afYi;
                        if (paramInt2 != 0) {}
                        for (;;)
                        {
                          ((b)localObject5).OeF = paramInt2;
                          break;
                          paramInt2 = 1;
                        }
                      }
                      if (paramInt2 != 0)
                      {
                        cS(paramInt2, true);
                        if (!aEq(paramInt2)) {}
                        for (bool1 = true;; bool1 = false) {
                          break;
                        }
                      }
                      if (bool5)
                      {
                        jFQ();
                        this.afYi.afZx = DialerKeyListener.getInstance();
                        this.afYi.OeF = 3;
                        break label2646;
                      }
                      if (i2 != 0)
                      {
                        jFQ();
                        this.afYi.afZx = DigitsKeyListener.getInstance();
                        paramInt2 = this.afYi.afZx.getInputType();
                        this.afYi.OeF = paramInt2;
                        break label2646;
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
                          jFQ();
                          this.afYi.afZx = TextKeyListener.getInstance(bool6, (TextKeyListener.Capitalize)localObject5);
                          this.afYi.OeF = paramInt2;
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
                        jFQ();
                        this.afYi.afZx = TextKeyListener.getInstance();
                        this.afYi.OeF = 1;
                        break label2646;
                      }
                      if (jFu())
                      {
                        if (this.afYi != null)
                        {
                          this.afYi.afZx = null;
                          this.afYi.OeF = 0;
                        }
                        localObject3 = TextView.BufferType.SPANNABLE;
                        setMovementMethod(com.tencent.mm.ui.widget.cedit.b.a.jHj());
                        break label2646;
                      }
                      if (this.afYi != null) {
                        this.afYi.afZx = null;
                      }
                      localObject3 = TextView.BufferType.NORMAL;
                      break label2646;
                      if (((((b)localObject5).OeF & 0xF) != 2) || (i5 == 0)) {
                        break label2722;
                      }
                      ((b)localObject5).OeF = (((b)localObject5).OeF & 0xFFFFF00F | 0x10);
                      break label2722;
                      paramInt2 = 0;
                      break label2911;
                      label4319:
                      paramContext.afYG = 0;
                      paramContext.afYE = 0;
                      break label3034;
                      label4332:
                      paramContext.afYH = 0;
                      paramContext.afYF = 0;
                      break label3101;
                      setEllipsize(TextUtils.TruncateAt.START);
                      break label3192;
                      setEllipsize(TextUtils.TruncateAt.MIDDLE);
                      break label3192;
                      setEllipsize(TextUtils.TruncateAt.END);
                      break label3192;
                      paramInt2 = 0;
                      break label3215;
                      i = 0;
                      break label3247;
                      if ((!this.xe.setFontVariationSettings(paramContext)) || (this.mLayout == null)) {
                        break label3634;
                      }
                      jmX();
                      requestLayout();
                      invalidate();
                      break label3634;
                      label4420:
                      setFilters(afWZ);
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
  
  final void a(Spanned paramSpanned, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = -1;
    AppMethodBeat.i(253559);
    b.h localh;
    int j;
    if (this.afYi == null)
    {
      localh = null;
      if (paramObject != Selection.SELECTION_END) {
        break label503;
      }
      if ((paramInt1 >= 0) || (paramInt2 >= 0))
      {
        bA(Selection.getSelectionStart(paramSpanned), paramInt1, paramInt2);
        jFx();
        jFt();
        if (this.afYi != null) {
          this.afYi.jGH();
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
          bA(Selection.getSelectionEnd(paramSpanned), paramInt1, paramInt2);
        }
        i = paramInt2;
        m = 1;
        k = i;
      }
      if (m != 0)
      {
        this.afXX = true;
        if ((this.afYi != null) && (!isFocused())) {
          this.afYi.afZv = true;
        }
        if ((paramSpanned.getSpanFlags(paramObject) & 0x200) == 0)
        {
          if (k < 0) {
            Selection.getSelectionStart(paramSpanned);
          }
          if (j < 0) {
            Selection.getSelectionEnd(paramSpanned);
          }
          if (this.afYi != null)
          {
            this.afYi.jGq();
            if ((!jFB()) && (this.afYi.jGu()) && (hasTransientState())) {
              setHasTransientState(false);
            }
          }
          sendAccessibilityEvent(8192);
        }
      }
      if (((paramObject instanceof UpdateAppearance)) || ((paramObject instanceof ParagraphStyle)) || ((paramObject instanceof CharacterStyle)))
      {
        if ((localh != null) && (localh.afZf != 0)) {
          break label472;
        }
        invalidate();
        this.afXX = true;
        jFx();
        label280:
        if (this.afYi != null) {
          this.afYi.jGo();
        }
      }
      if (MetaKeyKeyListener.isMetaTracker(paramSpanned, paramObject))
      {
        this.afXX = true;
        if ((localh != null) && (MetaKeyKeyListener.isSelectingMetaTracker(paramSpanned, paramObject))) {
          localh.agbf = true;
        }
        if (Selection.getSelectionStart(paramSpanned) >= 0)
        {
          if ((localh != null) && (localh.afZf != 0)) {
            break label481;
          }
          jFs();
        }
      }
      for (;;)
      {
        if (((paramObject instanceof ParcelableSpan)) && (localh != null) && (localh.agbd != null))
        {
          if (localh.afZf != 0)
          {
            if (paramInt1 >= 0)
            {
              if (localh.agbg > paramInt1) {
                localh.agbg = paramInt1;
              }
              if (localh.agbg > paramInt3) {
                localh.agbg = paramInt3;
              }
            }
            if (paramInt2 < 0) {
              break label496;
            }
            if (localh.agbg > paramInt2) {
              localh.agbg = paramInt2;
            }
            if (localh.agbg <= paramInt4) {
              break label496;
            }
            localh.agbg = paramInt4;
            AppMethodBeat.o(253559);
            return;
            localh = this.afYi.afZt;
            break;
            label472:
            localh.mContentChanged = true;
            break label280;
            label481:
            localh.agbe = true;
            continue;
          }
          localh.mContentChanged = true;
        }
      }
      label496:
      AppMethodBeat.o(253559);
      return;
      label503:
      j = -1;
    }
  }
  
  protected void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253121);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = (CharSequence)localObject;
    if (!jFI()) {
      paramCharSequence = ba((CharSequence)localObject);
    }
    if (!this.afXA) {
      this.xe.setTextScaleX(1.0F);
    }
    int j = this.afXS.length;
    int i = 0;
    localObject = paramCharSequence;
    while (i < j)
    {
      paramCharSequence = this.afXS[i].filter((CharSequence)localObject, 0, ((CharSequence)localObject).length(), afXa, 0, 0);
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
        jFQ();
        localObject = this.adVO.newEditable((CharSequence)localObject);
        a((Editable)localObject, this.afXS);
        InputMethodManager localInputMethodManager = getInputMethodManager();
        paramCharSequence = (CharSequence)localObject;
        if (localInputMethodManager != null)
        {
          localInputMethodManager.restartInput(this);
          paramCharSequence = (CharSequence)localObject;
        }
        label249:
        if (this.afXH == 0) {
          break label731;
        }
        if ((paramBufferType != TextView.BufferType.EDITABLE) && (!(paramCharSequence instanceof Spannable))) {
          break label500;
        }
        localObject = (Spannable)paramCharSequence;
        if (!Linkify.addLinks((Spannable)localObject, this.afXH)) {
          break label731;
        }
        if (paramBufferType != TextView.BufferType.EDITABLE) {
          break label513;
        }
        paramCharSequence = TextView.BufferType.EDITABLE;
        setTextInternal((CharSequence)localObject);
        if ((this.afXI) && (!jFG())) {
          setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.jHj());
        }
        paramBufferType = paramCharSequence;
        paramCharSequence = (CharSequence)localObject;
      }
      for (;;)
      {
        this.afXt = paramBufferType;
        setTextInternal(paramCharSequence);
        if (this.afXx == null) {}
        int k;
        for (this.adVR = paramCharSequence;; this.adVR = this.afXx.getTransformation(paramCharSequence, this))
        {
          if (this.adVR == null) {
            this.adVR = "";
          }
          k = paramCharSequence.length();
          if ((!(paramCharSequence instanceof Spannable)) || (this.afXy)) {
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
            if (this.afXw == null) {
              break label249;
            }
          }
          paramCharSequence = this.adVP.newSpannable((CharSequence)localObject);
          break label249;
          label500:
          localObject = this.adVP.newSpannable(paramCharSequence);
          break label276;
          paramCharSequence = TextView.BufferType.SPANNABLE;
          break label299;
        }
        if (this.afXz == null) {
          this.afXz = new a((byte)0);
        }
        paramBufferType.setSpan(this.afXz, 0, k, 6553618);
        if (this.afYi != null)
        {
          localObject = this.afYi;
          j = paramBufferType.length();
          if (((b)localObject).afZx != null) {
            paramBufferType.setSpan(((b)localObject).afZx, 0, j, 18);
          }
        }
        if (this.afXx != null) {
          paramBufferType.setSpan(this.afXx, 0, k, 18);
        }
        if (this.afXw != null)
        {
          this.afXw.j((Spannable)paramCharSequence);
          if (this.afYi != null) {
            this.afYi.afZv = false;
          }
        }
        if (this.mLayout != null) {
          akv();
        }
        b(paramCharSequence, 0, i, k);
        if (paramInt != 0) {
          f((Editable)paramCharSequence);
        }
        if (this.afYi != null) {
          this.afYi.jFX();
        }
        AppMethodBeat.o(253121);
        return;
      }
    }
  }
  
  public final boolean a(ExtractedTextRequest paramExtractedTextRequest, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(253432);
    jFQ();
    boolean bool = this.afYi.a(paramExtractedTextRequest, -1, -1, -1, paramExtractedText);
    AppMethodBeat.o(253432);
    return bool;
  }
  
  public final void aEu(int paramInt)
  {
    AppMethodBeat.i(253730);
    if (this.afYi != null) {
      this.afYi.aEu(paramInt);
    }
    AppMethodBeat.o(253730);
  }
  
  public void addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(253699);
    if ((paramBundle != null) && (paramString.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")))
    {
      int j = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
      int k = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
      if ((k <= 0) || (j < 0) || (j >= this.mText.length()))
      {
        Log.e("cmEdit.CMTextView", "Invalid arguments for accessibility character locations");
        AppMethodBeat.o(253699);
        return;
      }
      paramBundle = new RectF[k];
      Object localObject = new CursorAnchorInfo.Builder();
      a((CursorAnchorInfo.Builder)localObject, j, j + k, jFz(), jFA());
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
      AppMethodBeat.o(253699);
      return;
    }
    AppMethodBeat.o(253699);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(253539);
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTextWatcher);
    AppMethodBeat.o(253539);
  }
  
  public final void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253079);
    int i = paramCharSequence.length();
    if (!(this.mText instanceof Editable)) {
      setText(this.mText, TextView.BufferType.EDITABLE);
    }
    ((Editable)this.mText).append(paramCharSequence, 0, i);
    if ((this.afXH != 0) && (Linkify.addLinks(this.afXs, this.afXH)) && (this.afXI) && (!jFG())) {
      setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.jHj());
    }
    AppMethodBeat.o(253079);
  }
  
  public void autofill(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(253696);
    if ((Build.VERSION.SDK_INT >= 26) && ((!paramAutofillValue.isText()) || (!jFD())))
    {
      Log.w("cmEdit.CMTextView", paramAutofillValue + " could not be autofilled into " + this);
      AppMethodBeat.o(253696);
      return;
    }
    CharSequence localCharSequence = null;
    if (Build.VERSION.SDK_INT >= 26) {
      localCharSequence = paramAutofillValue.getTextValue();
    }
    a(localCharSequence, this.afXt, true, 0);
    paramAutofillValue = getText();
    if ((paramAutofillValue instanceof Spannable)) {
      Selection.setSelection((Spannable)paramAutofillValue, paramAutofillValue.length());
    }
    AppMethodBeat.o(253696);
  }
  
  final boolean b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(253599);
    boolean bool1;
    if (this.afYg == -1)
    {
      this.afYg = paramMotionEvent.getPointerId(0);
      this.afYh = paramBoolean;
      bool1 = true;
    }
    for (;;)
    {
      if ((paramMotionEvent.getActionMasked() == 1) || (paramMotionEvent.getActionMasked() == 3)) {
        this.afYg = -1;
      }
      AppMethodBeat.o(253599);
      return bool1;
      if (this.afYg != paramMotionEvent.getPointerId(0))
      {
        bool1 = bool2;
        if (this.afYh)
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
  
  public final void beginBatchEdit()
  {
    AppMethodBeat.i(253455);
    if (this.afYi != null) {
      this.afYi.beginBatchEdit();
    }
    AppMethodBeat.o(253455);
  }
  
  public final boolean bj(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253700);
    for (;;)
    {
      synchronized (afWY)
      {
        float[] arrayOfFloat2 = afWY;
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
            AppMethodBeat.o(253700);
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
          AppMethodBeat.o(253700);
          return true;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public final int bk(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253742);
    if (getLayout() == null)
    {
      AppMethodBeat.o(253742);
      return -1;
    }
    int i = E(eg(paramFloat2), paramFloat1);
    AppMethodBeat.o(253742);
    return i;
  }
  
  final void c(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(253555);
    afXc = 0L;
    b.h localh;
    if (this.afYi == null)
    {
      localh = null;
      if ((localh == null) || (localh.afZf == 0)) {
        jFC();
      }
      if (localh != null)
      {
        localh.mContentChanged = true;
        if (localh.agbg >= 0) {
          break label113;
        }
        localh.agbg = paramInt1;
      }
    }
    for (localh.agbh = (paramInt1 + paramInt2);; localh.agbh = Math.max(localh.agbh, paramInt1 + paramInt2 - localh.agbi))
    {
      localh.agbi += paramInt3 - paramInt2;
      b(paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(253555);
      return;
      localh = this.afYi.afZt;
      break;
      label113:
      localh.agbg = Math.min(localh.agbg, paramInt1);
    }
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(253632);
    super.cancelLongPress();
    if (this.afYi != null) {
      this.afYi.aeVV = true;
    }
    AppMethodBeat.o(253632);
  }
  
  public void clearComposingText()
  {
    AppMethodBeat.i(253583);
    if ((this.mText instanceof Spannable)) {
      BaseInputConnection.removeComposingSpans(this.afXs);
    }
    AppMethodBeat.o(253583);
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(253653);
    if (this.mLayout != null)
    {
      if ((this.adTq) && ((this.tJ & 0x7) == 3))
      {
        i = (int)this.mLayout.getLineWidth(0);
        AppMethodBeat.o(253653);
        return i;
      }
      i = this.mLayout.getWidth();
      AppMethodBeat.o(253653);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(253653);
    return i;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(253493);
    if ((this.mScroller != null) && (this.mScroller.computeScrollOffset())) {
      postInvalidate();
    }
    AppMethodBeat.o(253493);
  }
  
  protected int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(253657);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    AppMethodBeat.o(253657);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    AppMethodBeat.i(253656);
    if (this.mLayout != null)
    {
      i = this.mLayout.getHeight();
      AppMethodBeat.o(253656);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    AppMethodBeat.o(253656);
    return i;
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253083);
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.afXq != null)
    {
      Drawable[] arrayOfDrawable = this.afXq.afYu;
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
    AppMethodBeat.o(253083);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(253081);
    super.drawableStateChanged();
    if (((this.NhP != null) && (this.NhP.isStateful())) || ((this.afXd != null) && (this.afXd.isStateful())) || ((this.afXe != null) && (this.afXe.isStateful()))) {
      updateTextColors();
    }
    if (this.afXq != null)
    {
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.afXq.afYu;
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
    AppMethodBeat.o(253081);
  }
  
  protected boolean eB()
  {
    return true;
  }
  
  final float ef(float paramFloat)
  {
    AppMethodBeat.i(253743);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    paramFloat = Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat);
    float f = getScrollX();
    AppMethodBeat.o(253743);
    return paramFloat + f;
  }
  
  final int eg(float paramFloat)
  {
    AppMethodBeat.i(253745);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    int i = getLayout().getLineForVertical((int)(paramFloat + f));
    AppMethodBeat.o(253745);
    return i;
  }
  
  public final void endBatchEdit()
  {
    AppMethodBeat.i(253460);
    if (this.afYi != null) {
      this.afYi.endBatchEdit();
    }
    AppMethodBeat.o(253460);
  }
  
  final void f(Editable paramEditable)
  {
    AppMethodBeat.i(253547);
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
    AppMethodBeat.o(253547);
  }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(253661);
    super.findViewsWithText(paramArrayList, paramCharSequence, paramInt);
    if ((!paramArrayList.contains(this)) && ((paramInt & 0x1) != 0) && (!TextUtils.isEmpty(paramCharSequence)) && (!TextUtils.isEmpty(this.mText)))
    {
      paramCharSequence = paramCharSequence.toString().toLowerCase();
      if (this.mText.toString().toLowerCase().contains(paramCharSequence)) {
        paramArrayList.add(this);
      }
    }
    AppMethodBeat.o(253661);
  }
  
  public View focusSearch(int paramInt)
  {
    AppMethodBeat.i(253413);
    try
    {
      View localView = super.focusSearch(paramInt);
      AppMethodBeat.o(253413);
      return localView;
    }
    finally
    {
      Log.e("cmEdit.CMTextView", "focusSearch err", new Object[] { localObject });
      AppMethodBeat.o(253413);
    }
    return null;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(253693);
    String str = CustomTextView.class.getName();
    AppMethodBeat.o(253693);
    return str;
  }
  
  public int getAccessibilitySelectionEnd()
  {
    AppMethodBeat.i(253771);
    int i = getSelectionEnd();
    AppMethodBeat.o(253771);
    return i;
  }
  
  public int getAccessibilitySelectionStart()
  {
    AppMethodBeat.i(253769);
    int i = getSelectionStart();
    AppMethodBeat.o(253769);
    return i;
  }
  
  public TextView getAdaptText()
  {
    return this.afYk;
  }
  
  public int getAutofillType()
  {
    AppMethodBeat.i(253697);
    if (jFD())
    {
      AppMethodBeat.o(253697);
      return 1;
    }
    AppMethodBeat.o(253697);
    return 0;
  }
  
  public AutofillValue getAutofillValue()
  {
    AppMethodBeat.i(253698);
    if (jFD())
    {
      Object localObject = com.tencent.mm.ui.widget.cedit.util.c.m(getText(), 100000);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = AutofillValue.forText((CharSequence)localObject);
        AppMethodBeat.o(253698);
        return localObject;
      }
    }
    AppMethodBeat.o(253698);
    return null;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(253345);
    if (this.mLayout == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(253345);
      return i;
    }
    int i = getBaselineOffset();
    int j = this.mLayout.getLineBaseline(0);
    AppMethodBeat.o(253345);
    return i + j;
  }
  
  int getBaselineOffset()
  {
    AppMethodBeat.i(253354);
    int i = 0;
    if ((this.tJ & 0x70) != 48) {
      i = No(true);
    }
    int j = getExtendedPaddingTop();
    AppMethodBeat.o(253354);
    return i + j;
  }
  
  protected int getBottomPaddingOffset()
  {
    AppMethodBeat.i(253280);
    int i = (int)Math.max(0.0F, this.afXj + this.afXh);
    AppMethodBeat.o(253280);
    return i;
  }
  
  final ClipboardManager getClipboardManagerForUser()
  {
    AppMethodBeat.i(253682);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getContext().getPackageName();
      localClipboardManager = (ClipboardManager)cs(ClipboardManager.class);
      AppMethodBeat.o(253682);
      return localClipboardManager;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)getContext().getSystemService("clipboard");
    AppMethodBeat.o(253682);
    return localClipboardManager;
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.afXq;
    if (localb != null) {
      return localb.adWM;
    }
    return 0;
  }
  
  public BlendMode getCompoundDrawableTintBlendMode()
  {
    if (this.afXq != null) {
      return this.afXq.afYv;
    }
    return null;
  }
  
  public ColorStateList getCompoundDrawableTintList()
  {
    if (this.afXq != null) {
      return this.afXq.kz;
    }
    return null;
  }
  
  public PorterDuff.Mode getCompoundDrawableTintMode()
  {
    return null;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    AppMethodBeat.i(252827);
    Object localObject = this.afXq;
    if (localObject != null)
    {
      localObject = (Drawable[])((b)localObject).afYu.clone();
      AppMethodBeat.o(252827);
      return localObject;
    }
    AppMethodBeat.o(252827);
    return new Drawable[] { null, null, null, null };
  }
  
  public Drawable[] getCompoundDrawablesRelative()
  {
    b localb = this.afXq;
    if (localb != null) {
      return new Drawable[] { localb.afYx, localb.afYu[1], localb.afYy, localb.afYu[3] };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(252781);
    b localb = this.afXq;
    if ((localb == null) || (localb.afYu[3] == null))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(252781);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.adWM;
    int k = localb.adWF;
    AppMethodBeat.o(252781);
    return k + (i + j);
  }
  
  public int getCompoundPaddingEnd()
  {
    AppMethodBeat.i(252796);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingRight();
      AppMethodBeat.o(252796);
      return i;
    }
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(252796);
    return i;
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(252785);
    b localb = this.afXq;
    if ((localb == null) || (localb.afYu[0] == null))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(252785);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.adWM;
    int k = localb.adWG;
    AppMethodBeat.o(252785);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(252790);
    b localb = this.afXq;
    if ((localb == null) || (localb.afYu[2] == null))
    {
      i = getPaddingRight();
      AppMethodBeat.o(252790);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.adWM;
    int k = localb.adWH;
    AppMethodBeat.o(252790);
    return k + (i + j);
  }
  
  public int getCompoundPaddingStart()
  {
    AppMethodBeat.i(252793);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingLeft();
      AppMethodBeat.o(252793);
      return i;
    }
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(252793);
    return i;
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(252777);
    b localb = this.afXq;
    if ((localb == null) || (localb.afYu[1] == null))
    {
      i = getPaddingTop();
      AppMethodBeat.o(252777);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.adWM;
    int k = localb.adWE;
    AppMethodBeat.o(252777);
    return k + (i + j);
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.afXd != null) {
      return this.afXf;
    }
    return this.adVN;
  }
  
  public final int getCurrentTextColor()
  {
    return this.adVN;
  }
  
  public ActionMode.Callback getCustomInsertionActionModeCallback()
  {
    if (this.afYi == null) {
      return null;
    }
    return this.afYi.afZW;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    if (this.afYi == null) {
      return null;
    }
    return this.afYi.afZV;
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
    return this.afYi;
  }
  
  @ViewDebug.ExportedProperty
  public TextUtils.TruncateAt getEllipsize()
  {
    return this.adVQ;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(252803);
    if (this.adVX != 1)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(252803);
      return i;
    }
    if (this.mLayout == null) {
      jmY();
    }
    if (this.mLayout.getLineCount() <= this.adVW)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(252803);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.mLayout.getLineTop(this.adVW);
    if (k >= j)
    {
      AppMethodBeat.o(252803);
      return i;
    }
    int m = this.tJ & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(252803);
      return i + j - k;
    }
    if (m == 80)
    {
      AppMethodBeat.o(252803);
      return i;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(252803);
    return i + j;
  }
  
  public int getExtendedPaddingTop()
  {
    AppMethodBeat.i(252801);
    if (this.adVX != 1)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(252801);
      return i;
    }
    if (this.mLayout == null) {
      jmY();
    }
    if (this.mLayout.getLineCount() <= this.adVW)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(252801);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.mLayout.getLineTop(this.adVW);
    if (k >= j)
    {
      AppMethodBeat.o(252801);
      return i;
    }
    int m = this.tJ & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(252801);
      return i;
    }
    if (m == 80)
    {
      AppMethodBeat.o(252801);
      return i + j - k;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(252801);
    return i + j;
  }
  
  public InputFilter[] getFilters()
  {
    return this.afXS;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    AppMethodBeat.i(252857);
    int i = getPaddingTop();
    int j = getPaint().getFontMetricsInt().top;
    AppMethodBeat.o(252857);
    return i - j;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(253335);
    if (this.mLayout == null)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(253335);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(253335);
      return;
    }
    int j = getSelectionStart();
    if ((j < 0) || (j >= i))
    {
      j = this.mLayout.getLineForOffset(i);
      paramRect.top = this.mLayout.getLineTop(j);
      paramRect.bottom = this.mLayout.getLineBottom(j);
      paramRect.left = ((int)this.mLayout.getPrimaryHorizontal(i) - 2);
      paramRect.right = (paramRect.left + 4);
    }
    for (;;)
    {
      int k = getCompoundPaddingLeft();
      j = getExtendedPaddingTop();
      i = j;
      if ((this.tJ & 0x70) != 48) {
        i = j + No(false);
      }
      paramRect.offset(k, i);
      paramRect.bottom = (getExtendedPaddingBottom() + paramRect.bottom);
      AppMethodBeat.o(253335);
      return;
      k = this.mLayout.getLineForOffset(j);
      int m = this.mLayout.getLineForOffset(i);
      paramRect.top = this.mLayout.getLineTop(k);
      paramRect.bottom = this.mLayout.getLineBottom(m);
      if (k == m)
      {
        paramRect.left = ((int)this.mLayout.getPrimaryHorizontal(j));
        paramRect.right = ((int)this.mLayout.getPrimaryHorizontal(i));
        continue;
      }
      if (this.afXX)
      {
        if (this.afXV == null) {
          this.afXV = new Path();
        }
        this.afXV.reset();
        this.mLayout.getSelectionPath(j, i, this.afXV);
        this.afXX = false;
      }
      synchronized (sG)
      {
        this.afXV.computeBounds(sG, true);
        paramRect.left = ((int)sG.left - 1);
        paramRect.right = ((int)sG.right + 1);
      }
    }
  }
  
  public String getFontFeatureSettings()
  {
    AppMethodBeat.i(252984);
    String str = this.xe.getFontFeatureSettings();
    AppMethodBeat.o(252984);
    return str;
  }
  
  public String getFontVariationSettings()
  {
    AppMethodBeat.i(252985);
    if (Build.VERSION.SDK_INT >= 26)
    {
      String str = this.xe.getFontVariationSettings();
      AppMethodBeat.o(252985);
      return str;
    }
    AppMethodBeat.o(252985);
    return "";
  }
  
  public boolean getFreezesText()
  {
    return this.afXg;
  }
  
  public int getGravity()
  {
    return this.tJ;
  }
  
  public int getHighlightColor()
  {
    return this.uRB;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getHint()
  {
    return this.afXu;
  }
  
  public final ColorStateList getHintTextColors()
  {
    return this.afXd;
  }
  
  public int getHorizontalOffsetForDrawables()
  {
    return 0;
  }
  
  public boolean getHorizontallyScrolling()
  {
    return this.afXG;
  }
  
  public int getImeActionId()
  {
    if ((this.afYi != null) && (this.afYi.afZs != null)) {
      return this.afYi.afZs.agaZ;
    }
    return 0;
  }
  
  public CharSequence getImeActionLabel()
  {
    if ((this.afYi != null) && (this.afYi.afZs != null)) {
      return this.afYi.afZs.agaY;
    }
    return null;
  }
  
  public LocaleList getImeHintLocales()
  {
    if (this.afYi == null) {}
    while (this.afYi.afZs == null) {
      return null;
    }
    return this.afYi.afZs.agbc;
  }
  
  public int getImeOptions()
  {
    if ((this.afYi != null) && (this.afYi.afZs != null)) {
      return this.afYi.afZs.qiM;
    }
    return 0;
  }
  
  public boolean getIncludeFontPadding()
  {
    return this.adWd;
  }
  
  public Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(253199);
    if ((this.afYi == null) && (!paramBoolean))
    {
      AppMethodBeat.o(253199);
      return null;
    }
    jFQ();
    if (this.afYi.afZs == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(253199);
        return null;
      }
      this.afYi.jFV();
    }
    if (this.afYi.afZs.extras == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(253199);
        return null;
      }
      this.afYi.afZs.extras = new Bundle();
    }
    Bundle localBundle = this.afYi.afZs.extras;
    AppMethodBeat.o(253199);
    return localBundle;
  }
  
  InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(253704);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(253704);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    AppMethodBeat.o(253704);
    return localInputMethodManager;
  }
  
  public int getInputType()
  {
    if (this.afYi == null) {
      return 0;
    }
    return this.afYi.OeF;
  }
  
  public CharSequence getIterableTextForAccessibility()
  {
    return this.mText;
  }
  
  public final KeyListener getKeyListener()
  {
    if (this.afYi == null) {
      return null;
    }
    return this.afYi.afZx;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    AppMethodBeat.i(252858);
    int i = getPaddingBottom();
    int j = getPaint().getFontMetricsInt().bottom;
    AppMethodBeat.o(252858);
    return i + j;
  }
  
  public final Layout getLayout()
  {
    return this.mLayout;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(253646);
    if (getLineCount() == 1)
    {
      f = getLayout().getLineLeft(0);
      if (f > getScrollX())
      {
        AppMethodBeat.o(253646);
        return 0.0F;
      }
      f = bi(getScrollX(), f);
      AppMethodBeat.o(253646);
      return f;
    }
    float f = super.getLeftFadingEdgeStrength();
    AppMethodBeat.o(253646);
    return f;
  }
  
  protected int getLeftPaddingOffset()
  {
    AppMethodBeat.i(253272);
    int i = getCompoundPaddingLeft();
    int j = getPaddingLeft();
    int k = (int)Math.min(0.0F, this.afXi - this.afXh);
    AppMethodBeat.o(253272);
    return i - j + k;
  }
  
  public float getLetterSpacing()
  {
    AppMethodBeat.i(252979);
    float f = this.xe.getLetterSpacing();
    AppMethodBeat.o(252979);
    return f;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(253340);
    if (this.mLayout != null)
    {
      int i = this.mLayout.getLineCount();
      AppMethodBeat.o(253340);
      return i;
    }
    AppMethodBeat.o(253340);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(252757);
    int i = (int)(((this.xe.getFontMetricsInt(null) * this.adVU + this.adVV) * 16777216.0F) + 8388608L >> 24);
    AppMethodBeat.o(252757);
    return i;
  }
  
  public float getLineSpacingExtra()
  {
    return this.adVV;
  }
  
  public float getLineSpacingMultiplier()
  {
    return this.adVU;
  }
  
  public final ColorStateList getLinkTextColors()
  {
    return this.afXe;
  }
  
  public final boolean getLinksClickable()
  {
    return this.afXI;
  }
  
  public int getMaxEms()
  {
    if (this.afXM == 1) {
      return this.vF;
    }
    return -1;
  }
  
  public int getMaxHeight()
  {
    if (this.adVX == 2) {
      return this.adVW;
    }
    return -1;
  }
  
  public int getMaxLines()
  {
    if (this.adVX == 1) {
      return this.adVW;
    }
    return -1;
  }
  
  public int getMaxWidth()
  {
    if (this.afXM == 2) {
      return this.vF;
    }
    return -1;
  }
  
  public a.e getMenuCallback()
  {
    return this.afYp;
  }
  
  public int getMinEms()
  {
    if (this.afXN == 1) {
      return this.mf;
    }
    return -1;
  }
  
  public int getMinHeight()
  {
    if (this.adVZ == 2) {
      return this.adVY;
    }
    return -1;
  }
  
  public int getMinLines()
  {
    if (this.adVZ == 1) {
      return this.adVY;
    }
    return -1;
  }
  
  public int getMinWidth()
  {
    if (this.afXN == 2) {
      return this.mf;
    }
    return -1;
  }
  
  public final com.tencent.mm.ui.widget.cedit.b.d getMovementMethod()
  {
    return this.afXw;
  }
  
  public TextPaint getPaint()
  {
    return this.xe;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(253028);
    int i = this.xe.getFlags();
    AppMethodBeat.o(253028);
    return i;
  }
  
  public String getPrivateImeOptions()
  {
    if ((this.afYi != null) && (this.afYi.afZs != null)) {
      return this.afYi.afZs.agaX;
    }
    return null;
  }
  
  public Set<String> getReuseBrands()
  {
    return this.afYr;
  }
  
  public Set<String> getReuseItems()
  {
    return this.afYq;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(253648);
    if (getLineCount() == 1)
    {
      f1 = getScrollX() + (getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      float f2 = getLayout().getLineRight(0);
      if (f2 < f1)
      {
        AppMethodBeat.o(253648);
        return 0.0F;
      }
      f1 = bi(f1, f2);
      AppMethodBeat.o(253648);
      return f1;
    }
    float f1 = super.getRightFadingEdgeStrength();
    AppMethodBeat.o(253648);
    return f1;
  }
  
  protected int getRightPaddingOffset()
  {
    AppMethodBeat.i(253282);
    int i = -(getCompoundPaddingRight() - getPaddingRight());
    int j = (int)Math.max(0.0F, this.afXi + this.afXh);
    AppMethodBeat.o(253282);
    return i + j;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getScaledTextSize()
  {
    AppMethodBeat.i(252931);
    float f = this.xe.getTextSize() / this.xe.density;
    AppMethodBeat.o(252931);
    return f;
  }
  
  String getSelectedText()
  {
    AppMethodBeat.i(253520);
    if (!jFB())
    {
      AppMethodBeat.o(253520);
      return null;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (i > j) {}
    for (Object localObject = this.mText.subSequence(j, i);; localObject = this.mText.subSequence(i, j))
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(253520);
      return localObject;
    }
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionEnd()
  {
    AppMethodBeat.i(253513);
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(253513);
    return i;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionStart()
  {
    AppMethodBeat.i(253507);
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(253507);
    return i;
  }
  
  public int getShadowColor()
  {
    return this.ugx;
  }
  
  public float getShadowDx()
  {
    return this.afXi;
  }
  
  public float getShadowDy()
  {
    return this.afXj;
  }
  
  public float getShadowRadius()
  {
    return this.afXh;
  }
  
  public final boolean getShowSoftInputOnFocus()
  {
    return (this.afYi == null) || (this.afYi.afZG);
  }
  
  public Locale getSpellCheckerLocale()
  {
    AppMethodBeat.i(253689);
    Locale localLocale = Np(true);
    AppMethodBeat.o(253689);
    return localLocale;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  TextClassificationContext getTextClassificationContext()
  {
    return this.afXo;
  }
  
  final TextClassificationManager getTextClassificationManagerForUser()
  {
    AppMethodBeat.i(253685);
    if (Build.VERSION.SDK_INT >= 26)
    {
      getContext().getPackageName();
      TextClassificationManager localTextClassificationManager = (TextClassificationManager)cs(TextClassificationManager.class);
      AppMethodBeat.o(253685);
      return localTextClassificationManager;
    }
    AppMethodBeat.o(253685);
    return null;
  }
  
  TextClassifier getTextClassificationSession()
  {
    AppMethodBeat.i(253725);
    TextClassificationManager localTextClassificationManager;
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 28) && ((this.afXn == null) || (this.afXn.isDestroyed())))
    {
      localTextClassificationManager = getTextClassificationManagerForUser();
      if (localTextClassificationManager == null) {
        break label128;
      }
      if (!jFD()) {
        break label107;
      }
      localObject = "edittext";
      this.afXo = new TextClassificationContext.Builder(getContext().getPackageName(), (String)localObject).build();
      if (this.afXm != null) {}
    }
    label128:
    for (this.afXn = localTextClassificationManager.createTextClassificationSession(this.afXo);; this.afXn = TextClassifier.NO_OP)
    {
      localObject = this.afXn;
      AppMethodBeat.o(253725);
      return localObject;
      label107:
      if (jFu())
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
    AppMethodBeat.i(253722);
    if (this.afXm == null)
    {
      localObject = getTextClassificationManagerForUser();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 26))
      {
        localObject = ((TextClassificationManager)localObject).getTextClassifier();
        AppMethodBeat.o(253722);
        return localObject;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = TextClassifier.NO_OP;
        AppMethodBeat.o(253722);
        return localObject;
      }
    }
    Object localObject = this.afXm;
    AppMethodBeat.o(253722);
    return localObject;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.NhP;
  }
  
  public Drawable getTextCursorDrawable()
  {
    AppMethodBeat.i(252906);
    if ((this.afXZ == null) && (this.afXY != 0)) {
      this.afXZ = getContext().getDrawable(this.afXY);
    }
    Drawable localDrawable = this.afXZ;
    AppMethodBeat.o(252906);
    return localDrawable;
  }
  
  public TextDirectionHeuristic getTextDirectionHeuristic()
  {
    String str = null;
    AppMethodBeat.i(253762);
    if ((this.afXx instanceof PasswordTransformationMethod))
    {
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(253762);
      return localObject;
    }
    if ((this.afYi != null) && ((this.afYi.OeF & 0xF) == 3)) {
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
        AppMethodBeat.o(253762);
        return localObject;
      }
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(253762);
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
          AppMethodBeat.o(253762);
          return localObject;
        }
      }
      label197:
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.ANYRTL_LTR;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.RTL;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.LOCALE;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(253762);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      AppMethodBeat.o(253762);
      return localObject;
    }
  }
  
  public Locale getTextLocale()
  {
    AppMethodBeat.i(252910);
    Locale localLocale = this.xe.getTextLocale();
    AppMethodBeat.o(252910);
    return localLocale;
  }
  
  public LocaleList getTextLocales()
  {
    AppMethodBeat.i(252914);
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = this.xe.getTextLocales();
      AppMethodBeat.o(252914);
      return localLocaleList;
    }
    AppMethodBeat.o(252914);
    return null;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(252964);
    float f = this.xe.getTextScaleX();
    AppMethodBeat.o(252964);
    return f;
  }
  
  public Drawable getTextSelectHandle()
  {
    AppMethodBeat.i(252867);
    if ((this.afYf == null) && (this.afYe != 0)) {
      this.afYf = getContext().getDrawable(a.f.text_select_handle_middle_mtrl_alpha);
    }
    Drawable localDrawable = this.afYf;
    AppMethodBeat.o(252867);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleLeft()
  {
    AppMethodBeat.i(252875);
    if ((this.afYb == null) && (this.afYa != 0)) {
      this.afYb = getContext().getDrawable(a.f.text_select_handle_left_mtrl_alpha);
    }
    Drawable localDrawable = this.afYb;
    AppMethodBeat.o(252875);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleRight()
  {
    AppMethodBeat.i(252888);
    if ((this.afYd == null) && (this.afYc != 0)) {
      this.afYd = getContext().getDrawable(a.f.text_select_handle_right_mtrl_alpha);
    }
    Drawable localDrawable = this.afYd;
    AppMethodBeat.o(252888);
    return localDrawable;
  }
  
  public Locale getTextServicesLocale()
  {
    AppMethodBeat.i(253686);
    Locale localLocale = Np(false);
    AppMethodBeat.o(253686);
    return localLocale;
  }
  
  final TextServicesManager getTextServicesManagerForUser()
  {
    AppMethodBeat.i(253679);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localTextServicesManager = (TextServicesManager)cs(TextServicesManager.class);
      AppMethodBeat.o(253679);
      return localTextServicesManager;
    }
    TextServicesManager localTextServicesManager = (TextServicesManager)getContext().getSystemService("textservices");
    AppMethodBeat.o(253679);
    return localTextServicesManager;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getTextSize()
  {
    AppMethodBeat.i(252927);
    float f = this.xe.getTextSize();
    AppMethodBeat.o(252927);
    return f;
  }
  
  public int getTextSizeUnit()
  {
    return this.afXC;
  }
  
  protected int getTopPaddingOffset()
  {
    AppMethodBeat.i(253276);
    int i = (int)Math.min(0.0F, this.afXj - this.afXh);
    AppMethodBeat.o(253276);
    return i;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(252824);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.tJ & 0x70;
    Layout localLayout = this.mLayout;
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
      AppMethodBeat.o(252824);
      return i + k;
    }
  }
  
  public int getTotalPaddingEnd()
  {
    AppMethodBeat.i(252818);
    int i = getCompoundPaddingEnd();
    AppMethodBeat.o(252818);
    return i;
  }
  
  public int getTotalPaddingLeft()
  {
    AppMethodBeat.i(252806);
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(252806);
    return i;
  }
  
  public int getTotalPaddingRight()
  {
    AppMethodBeat.i(252809);
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(252809);
    return i;
  }
  
  public int getTotalPaddingStart()
  {
    AppMethodBeat.i(252812);
    int i = getCompoundPaddingStart();
    AppMethodBeat.o(252812);
    return i;
  }
  
  public int getTotalPaddingTop()
  {
    AppMethodBeat.i(252820);
    int i = getExtendedPaddingTop();
    int j = No(true);
    AppMethodBeat.o(252820);
    return i + j;
  }
  
  public final TransformationMethod getTransformationMethod()
  {
    return this.afXx;
  }
  
  public CharSequence getTransformed()
  {
    return this.adVR;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(252971);
    Typeface localTypeface = this.xe.getTypeface();
    AppMethodBeat.o(252971);
    return localTypeface;
  }
  
  @ViewDebug.ExportedProperty(category="text", mapping={@android.view.ViewDebug.IntToString(from=0, to="NORMAL"), @android.view.ViewDebug.IntToString(from=1, to="BOLD"), @android.view.ViewDebug.IntToString(from=2, to="ITALIC"), @android.view.ViewDebug.IntToString(from=3, to="BOLD_ITALIC")})
  public int getTypefaceStyle()
  {
    AppMethodBeat.i(252951);
    Typeface localTypeface = this.xe.getTypeface();
    if (localTypeface != null)
    {
      int i = localTypeface.getStyle();
      AppMethodBeat.o(252951);
      return i;
    }
    AppMethodBeat.o(252951);
    return 0;
  }
  
  public URLSpan[] getUrls()
  {
    AppMethodBeat.i(253017);
    if ((this.mText instanceof Spanned))
    {
      URLSpan[] arrayOfURLSpan = (URLSpan[])((Spanned)this.mText).getSpans(0, this.mText.length(), URLSpan.class);
      AppMethodBeat.o(253017);
      return arrayOfURLSpan;
    }
    AppMethodBeat.o(253017);
    return new URLSpan[0];
  }
  
  public com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(253692);
    if (this.afYi != null)
    {
      com.tencent.mm.ui.widget.cedit.c.b localb = this.afYi.getWordIterator();
      AppMethodBeat.o(253692);
      return localb;
    }
    AppMethodBeat.o(253692);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(253292);
    if (((getBackground() != null) && (getBackground().getCurrent() != null)) || (this.afXs != null) || (jFB()) || (isHorizontalFadingEdgeEnabled()) || (this.ugx != 0))
    {
      AppMethodBeat.o(253292);
      return true;
    }
    AppMethodBeat.o(253292);
    return false;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int m = 0;
    int i1 = 0;
    AppMethodBeat.i(253288);
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
      localb = this.afXq;
      i = i1;
      j = m;
      k = n;
      if (localb != null)
      {
        if (paramDrawable != localb.afYu[0]) {
          break label187;
        }
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + getPaddingLeft();
        j = m + (i + (i1 - i2 - j - i - localb.adWK) / 2);
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
      AppMethodBeat.o(253288);
      return;
      label187:
      if (paramDrawable == localb.afYu[2])
      {
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + (getRight() - getLeft() - getPaddingRight() - localb.adWH);
        j = m + (i + (i1 - i2 - j - i - localb.adWL) / 2);
        i = 1;
      }
      else if (paramDrawable == localb.afYu[1])
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        k = n + (i + (getRight() - getLeft() - j - i - localb.adWI) / 2);
        j = m + getPaddingTop();
        i = 1;
      }
      else
      {
        i = i1;
        j = m;
        k = n;
        if (paramDrawable == localb.afYu[3])
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          k = n + (i + (getRight() - getLeft() - j - i - localb.adWJ) / 2);
          j = m + (getBottom() - getTop() - getPaddingBottom() - localb.adWF);
          i = 1;
        }
      }
    }
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.afXh != 0.0F) || (this.afXq != null);
  }
  
  final int jFA()
  {
    AppMethodBeat.i(253502);
    int j = getExtendedPaddingTop() - getScrollY();
    int i = j;
    if ((this.tJ & 0x70) != 48) {
      i = j + No(false);
    }
    AppMethodBeat.o(253502);
    return i;
  }
  
  public final boolean jFB()
  {
    AppMethodBeat.i(253517);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((i >= 0) && (j > 0) && (i != j))
    {
      AppMethodBeat.o(253517);
      return true;
    }
    AppMethodBeat.o(253517);
    return false;
  }
  
  final void jFC()
  {
    AppMethodBeat.i(253551);
    invalidate();
    int i = getSelectionStart();
    if ((i >= 0) || ((this.tJ & 0x70) == 80)) {
      jFt();
    }
    jFx();
    if (i >= 0)
    {
      this.afXX = true;
      if (this.afYi != null) {
        this.afYi.jGH();
      }
      aEt(i);
    }
    AppMethodBeat.o(253551);
  }
  
  final boolean jFD()
  {
    AppMethodBeat.i(253628);
    if (((this.mText instanceof Editable)) && (onCheckIsTextEditor()) && (isEnabled()))
    {
      AppMethodBeat.o(253628);
      return true;
    }
    AppMethodBeat.o(253628);
    return false;
  }
  
  public final boolean jFE()
  {
    return (this.afYi != null) && (this.afYi.afZw);
  }
  
  final boolean jFF()
  {
    AppMethodBeat.i(253670);
    if ((this.mText.length() != 0) && (this.afYi != null) && (this.afYi.afZm))
    {
      AppMethodBeat.o(253670);
      return true;
    }
    AppMethodBeat.o(253670);
    return false;
  }
  
  final boolean jFG()
  {
    AppMethodBeat.i(253672);
    if ((this.afXw == null) || (!this.afXw.jHi()))
    {
      AppMethodBeat.o(253672);
      return false;
    }
    if ((jFD()) || ((jFu()) && ((this.mText instanceof Spannable)) && (isEnabled())))
    {
      AppMethodBeat.o(253672);
      return true;
    }
    AppMethodBeat.o(253672);
    return false;
  }
  
  public final void jFJ()
  {
    AppMethodBeat.i(253729);
    if (this.afYi != null) {
      this.afYi.jFJ();
    }
    AppMethodBeat.o(253729);
  }
  
  final boolean jFK()
  {
    AppMethodBeat.i(253732);
    if ((this.afXx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(253732);
      return false;
    }
    if ((this.mText.length() > 0) && (jFB()) && ((this.mText instanceof Editable)) && (this.afYi != null) && (this.afYi.afZx != null))
    {
      AppMethodBeat.o(253732);
      return true;
    }
    AppMethodBeat.o(253732);
    return false;
  }
  
  final boolean jFL()
  {
    AppMethodBeat.i(253734);
    if ((this.afXx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(253734);
      return false;
    }
    if ((this.mText.length() > 0) && (jFB()) && (this.afYi != null))
    {
      AppMethodBeat.o(253734);
      return true;
    }
    AppMethodBeat.o(253734);
    return false;
  }
  
  final boolean jFM()
  {
    AppMethodBeat.i(253737);
    if (((this.mText instanceof Editable)) && (this.afYi != null) && (this.afYi.afZx != null) && (getSelectionStart() >= 0) && (getSelectionEnd() >= 0) && (getClipboardManagerForUser().hasPrimaryClip()))
    {
      AppMethodBeat.o(253737);
      return true;
    }
    AppMethodBeat.o(253737);
    return false;
  }
  
  final boolean jFN()
  {
    AppMethodBeat.i(253738);
    if ((jFF()) && (!(this.afXx instanceof PasswordTransformationMethod)) && ((getSelectionStart() != 0) || (getSelectionEnd() != this.mText.length())))
    {
      AppMethodBeat.o(253738);
      return true;
    }
    AppMethodBeat.o(253738);
    return false;
  }
  
  public final boolean jFO()
  {
    AppMethodBeat.i(253741);
    if (this.afYi != null) {
      aEu(500);
    }
    int i = this.mText.length();
    Selection.setSelection(this.afXs, 0, i);
    if (i > 0)
    {
      AppMethodBeat.o(253741);
      return true;
    }
    AppMethodBeat.o(253741);
    return false;
  }
  
  final boolean jFP()
  {
    if (this.afYi == null) {}
    b.h localh;
    do
    {
      return false;
      localh = this.afYi.afZt;
      if (localh == null) {
        break;
      }
    } while (localh.afZf <= 0);
    return true;
    return this.afYi.afZF;
  }
  
  public final boolean jFS()
  {
    AppMethodBeat.i(253784);
    if ((getReuseItems().size() > 0) && (Build.BRAND != null) && (getReuseBrands().contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23))
    {
      AppMethodBeat.o(253784);
      return true;
    }
    AppMethodBeat.o(253784);
    return false;
  }
  
  final void jFr()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(253234);
    if (this.afXX)
    {
      jFs();
      AppMethodBeat.o(253234);
      return;
    }
    int i = getCompoundPaddingLeft();
    int j = getExtendedPaddingTop();
    j = No(true) + j;
    if (this.afYi.afZO == null) {}
    for (;;)
    {
      float f2;
      synchronized (sG)
      {
        f2 = (float)Math.ceil(this.xe.getStrokeWidth());
        if (f2 >= 1.0F) {
          break label246;
        }
        f1 /= 2.0F;
        this.afXV.computeBounds(sG, false);
        invalidate((int)Math.floor(i + sG.left - f1), (int)Math.floor(j + sG.top - f1), (int)Math.ceil(i + sG.right + f1), (int)Math.ceil(f1 + (j + sG.bottom)));
        AppMethodBeat.o(253234);
        return;
      }
      ??? = this.afYi.afZO.getBounds();
      invalidate(((Rect)???).left + i, ((Rect)???).top + j, i + ((Rect)???).right, ((Rect)???).bottom + j);
      AppMethodBeat.o(253234);
      return;
      label246:
      f1 = f2;
    }
  }
  
  final void jFs()
  {
    AppMethodBeat.i(253237);
    int i = getSelectionEnd();
    bA(i, i, i);
    AppMethodBeat.o(253237);
  }
  
  public final boolean jFu()
  {
    if (this.afYi == null) {
      return false;
    }
    return this.afYi.afZE;
  }
  
  final int jFz()
  {
    AppMethodBeat.i(253497);
    int i = getCompoundPaddingLeft();
    int j = getScrollX();
    AppMethodBeat.o(253497);
    return i - j;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(253285);
    super.jumpDrawablesToCurrentState();
    if (this.afXq != null)
    {
      Drawable[] arrayOfDrawable = this.afXq.afYu;
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
    AppMethodBeat.o(253285);
  }
  
  public int length()
  {
    AppMethodBeat.i(252748);
    int i = this.mText.length();
    AppMethodBeat.o(252748);
    return i;
  }
  
  final CharSequence oL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253711);
    CharSequence localCharSequence = ba(this.adVR.subSequence(paramInt1, paramInt2));
    AppMethodBeat.o(253711);
    return localCharSequence;
  }
  
  protected final void oM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253766);
    ((Editable)this.mText).delete(paramInt1, paramInt2);
    AppMethodBeat.o(253766);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(253252);
    super.onAttachedToWindow();
    if (this.afYi != null)
    {
      b localb = this.afYi;
      ViewTreeObserver localViewTreeObserver = localb.afZe.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (localb.afZi != null) {
          localViewTreeObserver.addOnTouchModeChangeListener(localb.afZi);
        }
        if (localb.afZj != null)
        {
          localb.afZj.jGW();
          localViewTreeObserver.addOnTouchModeChangeListener(localb.afZj);
        }
        localViewTreeObserver.addOnDrawListener(localb.afZq);
      }
      if (localb.afZe.jFB()) {
        localb.jGq();
      }
      localb.jGa();
    }
    if (this.afXl)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.afXl = false;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252260);
        CustomTextView localCustomTextView = CustomTextView.this;
        boolean bool = localCustomTextView.jFS();
        Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isNeedReuseMenuItems:".concat(String.valueOf(bool)));
        if (bool)
        {
          bool = localCustomTextView.isAttachedToWindow();
          Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isWindowAttached:".concat(String.valueOf(bool)));
          if (bool)
          {
            Log.i("cmEdit.CMTextView", "checkInitAdaptEdt mIsInitAdapt:" + localCustomTextView.afYo);
            if (!localCustomTextView.afYo)
            {
              localCustomTextView.afYo = true;
              try
              {
                AdaptEditText localAdaptEditText = new AdaptEditText(localCustomTextView.getContext());
                if ((localCustomTextView.getParent() instanceof ViewGroup))
                {
                  ((ViewGroup)localCustomTextView.getParent()).addView(localAdaptEditText);
                  localAdaptEditText.setVisibility(8);
                  localCustomTextView.setAdaptText(localAdaptEditText);
                }
                AppMethodBeat.o(252260);
                return;
              }
              finally
              {
                Log.e("cmEdit.CMTextView", "initAdapt err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
                com.tencent.mm.ui.widget.cedit.api.b.aEp(7);
              }
            }
          }
        }
        AppMethodBeat.o(252260);
      }
    });
    AppMethodBeat.o(253252);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return (this.afYi != null) && (this.afYi.OeF != 0);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(252924);
    super.onConfigurationChanged(paramConfiguration);
    if (!this.afXB)
    {
      if (Build.VERSION.SDK_INT < 24) {
        break label62;
      }
      this.xe.setTextLocales(LocaleList.getDefault());
    }
    for (;;)
    {
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(252924);
      return;
      label62:
      this.xe.setTextLocale(Locale.getDefault());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(253302);
    int[] arrayOfInt1;
    int i;
    if (this.adTq)
    {
      arrayOfInt1 = super.onCreateDrawableState(paramInt);
      if (jFu())
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
          AppMethodBeat.o(253302);
          return arrayOfInt2;
          arrayOfInt1 = super.onCreateDrawableState(paramInt + 1);
          mergeDrawableStates(arrayOfInt1, afXb);
          break;
        }
        paramInt += 1;
      }
    }
    label111:
    AppMethodBeat.o(253302);
    return arrayOfInt1;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(253424);
    if ((onCheckIsTextEditor()) && (isEnabled()))
    {
      Object localObject = this.afYi;
      if (((b)localObject).afZt == null) {
        ((b)localObject).afZt = new b.h();
      }
      paramEditorInfo.inputType = getInputType();
      if (this.afYi.afZs != null)
      {
        paramEditorInfo.imeOptions = this.afYi.afZs.qiM;
        paramEditorInfo.privateImeOptions = this.afYi.afZs.agaX;
        paramEditorInfo.actionLabel = this.afYi.afZs.agaY;
        paramEditorInfo.actionId = this.afYi.afZs.agaZ;
        paramEditorInfo.extras = this.afYi.afZs.extras;
        if (Build.VERSION.SDK_INT >= 24) {
          paramEditorInfo.hintLocales = this.afYi.afZs.agbc;
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
        if (!jFv()) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        if (aEq(paramEditorInfo.inputType)) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        paramEditorInfo.hintText = this.afXu;
        if (!(this.mText instanceof Editable)) {
          break label326;
        }
        localObject = new a(this);
        paramEditorInfo.initialSelStart = getSelectionStart();
        paramEditorInfo.initialSelEnd = getSelectionEnd();
        paramEditorInfo.initialCapsMode = ((InputConnection)localObject).getCursorCapsMode(getInputType());
        AppMethodBeat.o(253424);
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
    AppMethodBeat.o(253424);
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(253262);
    super.onDetachedFromWindow();
    if (this.afXk)
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.afXl = true;
    }
    this.afXr = -1;
    if (this.afYi != null)
    {
      b localb = this.afYi;
      localb.jFZ();
      if (localb.afZi != null) {
        localb.afZi.iQ();
      }
      if (localb.afZj != null) {
        localb.afZj.iQ();
      }
      if (localb.afZN != null) {
        localb.afZe.removeCallbacks(localb.afZN);
      }
      if (localb.agaa != null) {
        localb.afZe.removeCallbacks(localb.agaa);
      }
      localb.afZe.removeCallbacks(localb.agaf);
      ViewTreeObserver localViewTreeObserver = localb.afZe.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnDrawListener(localb.afZq);
      }
      localb.jFY();
      localb.jGD();
    }
    AppMethodBeat.o(253262);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    AppMethodBeat.i(253752);
    switch (paramDragEvent.getAction())
    {
    case 4: 
    default: 
      AppMethodBeat.o(253752);
      return true;
    case 1: 
      if ((this.afYi != null) && (this.afYi.afZl))
      {
        AppMethodBeat.o(253752);
        return true;
      }
      AppMethodBeat.o(253752);
      return false;
    case 5: 
      requestFocus();
      AppMethodBeat.o(253752);
      return true;
    case 2: 
      if ((this.mText instanceof Spannable))
      {
        int i = bk(paramDragEvent.getX(), paramDragEvent.getY());
        Selection.setSelection(this.afXs, i);
      }
      AppMethodBeat.o(253752);
      return true;
    }
    if (this.afYi != null) {
      this.afYi.a(paramDragEvent);
    }
    AppMethodBeat.o(253752);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(253328);
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
    Object localObject1 = this.afXq;
    if (localObject1 != null)
    {
      j = n - i1 - i3 - i2;
      i7 = i5 - i6 - i7 - k;
      if (localObject1.afYu[0] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i + (getPaddingLeft() + i4), m + i2 + (j - ((b)localObject1).adWK) / 2);
        localObject1.afYu[0].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.afYu[2] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + i5 - i6 - getPaddingRight() - ((b)localObject1).adWH + 0, (j - ((b)localObject1).adWL) / 2 + (m + i2));
        localObject1.afYu[2].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.afYu[1] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + k + (i7 - ((b)localObject1).adWI) / 2, getPaddingTop() + m);
        localObject1.afYu[1].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.afYu[3] != null)
      {
        paramCanvas.save();
        paramCanvas.translate((i7 - ((b)localObject1).adWJ) / 2 + (i4 + k), m + n - i1 - getPaddingBottom() - ((b)localObject1).adWF);
        localObject1.afYu[3].draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    i = this.adVN;
    if (this.mLayout == null) {
      jmY();
    }
    Object localObject2 = this.mLayout;
    int j = i;
    localObject1 = localObject2;
    if (this.afXu != null)
    {
      j = i;
      localObject1 = localObject2;
      if (this.mText.length() == 0)
      {
        if (this.afXd != null) {
          i = this.afXf;
        }
        localObject1 = this.afXv;
        j = i;
      }
    }
    this.xe.setColor(j);
    this.xe.drawableState = getDrawableState();
    paramCanvas.save();
    i7 = getExtendedPaddingTop();
    i = getExtendedPaddingBottom();
    j = getBottom();
    int i8 = getTop();
    int i9 = this.mLayout.getHeight();
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
      if (this.afXh == 0.0F) {
        break label1252;
      }
      f3 += Math.min(0.0F, this.afXi - this.afXh);
      f2 = Math.max(0.0F, this.afXi + this.afXh) + f2;
      f1 += Math.min(0.0F, this.afXj - this.afXh);
      f4 = Math.max(0.0F, this.afXj + this.afXh) + f4;
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
      if ((this.tJ & 0x70) != 48)
      {
        j = No(false);
        i = No(true);
      }
      paramCanvas.translate(k, i7 + j);
      j = i - j;
      Path localPath = getUpdatedHighlightPath();
      Object localObject3;
      label872:
      long l;
      if (this.afYi != null)
      {
        b localb = this.afYi;
        Paint localPaint = this.afXW;
        k = localb.afZe.getSelectionStart();
        m = localb.afZe.getSelectionEnd();
        localObject2 = localb.afZt;
        if ((localObject2 != null) && (((b.h)localObject2).afZf == 0))
        {
          localObject3 = localb.getInputMethodManager();
          if ((localObject3 != null) && (((InputMethodManager)localObject3).isActive(localb.afZe)) && ((((b.h)localObject2).mContentChanged) || (((b.h)localObject2).agbf))) {
            localb.jGm();
          }
        }
        if (localb.afZr != null)
        {
          localObject2 = localb.afZr;
          localObject3 = b.c(((b.b)localObject2).agap).getLayout();
          if (localObject3 == null)
          {
            i = 0;
            if (i == 0) {
              break label1215;
            }
            l = SystemClock.uptimeMillis() - ((b.b)localObject2).agaq;
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
            paramCanvas.drawPath(((b.b)localObject2).cja, ((b.b)localObject2).mPaint);
            if (j != 0) {
              paramCanvas.translate(0.0F, -j);
            }
            ((b.b)localObject2).Ns(true);
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
              if (localb.afZO != null)
              {
                if (j == 0) {
                  break label1229;
                }
                i = 1;
                if (i != 0) {
                  paramCanvas.translate(0.0F, j);
                }
                if (localb.afZO != null) {
                  localb.afZO.draw(paramCanvas);
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
        AppMethodBeat.o(253328);
        return;
        f1 = i7 + m;
        break;
        n = b.c(((b.b)localObject2).agap).getText().length();
        i = Math.min(n, ((b.b)localObject2).uG);
        n = Math.min(n, ((b.b)localObject2).uH);
        ((b.b)localObject2).cja.reset();
        ((Layout)localObject3).getSelectionPath(i, n, ((b.b)localObject2).cja);
        i = 1;
        break label872;
        label1142:
        f1 = (float)l / 400.0F;
        n = Color.alpha(b.c(((b.b)localObject2).agap).uRB);
        i = b.c(((b.b)localObject2).agap).uRB;
        n = (int)((1.0F - f1) * n);
        ((b.b)localObject2).mPaint.setColor((n << 24) + (i & 0xFFFFFF));
        i = 1;
        break label900;
        ((b.b)localObject2).stopAnimation();
        ((b.b)localObject2).Ns(false);
        break label952;
        i = 0;
        break label992;
        ((Layout)localObject1).draw(paramCanvas, localPath, this.afXW, j);
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(253565);
    if ((Build.VERSION.SDK_INT >= 24) && (isTemporarilyDetached()))
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      AppMethodBeat.o(253565);
      return;
    }
    if (this.afYi != null) {
      this.afYi.aw(paramBoolean, paramInt);
    }
    if ((paramBoolean) && (this.afXs != null)) {
      MetaKeyKeyListener.resetMetaState(this.afXs);
    }
    if (this.afXx != null) {
      this.afXx.onFocusChanged(this, this.mText, paramBoolean, paramInt, paramRect);
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    AppMethodBeat.o(253565);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253619);
    if ((this.afXw != null) && ((this.mText instanceof Spannable)) && (this.mLayout != null)) {
      try
      {
        bool = this.afXw.a(this, paramMotionEvent);
        if (bool)
        {
          AppMethodBeat.o(253619);
          return true;
        }
      }
      catch (AbstractMethodError localAbstractMethodError) {}
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(253619);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253376);
    if (a(paramInt, paramKeyEvent, null) == 0)
    {
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(253376);
      return bool;
    }
    AppMethodBeat.o(253376);
    return true;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253388);
    KeyEvent localKeyEvent = KeyEvent.changeAction(paramKeyEvent, 0);
    int i = a(paramInt1, localKeyEvent, paramKeyEvent);
    if (i == 0)
    {
      boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(253388);
      return bool;
    }
    if (i == -1)
    {
      AppMethodBeat.o(253388);
      return true;
    }
    paramInt2 -= 1;
    paramKeyEvent = KeyEvent.changeAction(paramKeyEvent, 1);
    if (i == 1)
    {
      this.afYi.afZx.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.afYi.afZx.onKeyDown(this, (Editable)this.mText, paramInt1, localKeyEvent);
        this.afYi.afZx.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      }
    }
    if (i == 2) {
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.afXw.a(this, this.afXs, paramInt1, localKeyEvent);
      }
    }
    AppMethodBeat.o(253388);
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(253369);
    if (paramInt == 4)
    {
      int i = j;
      if (this.afYi != null)
      {
        if (!this.afYi.jGu()) {
          break label49;
        }
        i = j;
      }
      while (i != 0)
      {
        AppMethodBeat.o(253369);
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
                jFJ();
                i = 1;
              }
            }
          }
        }
      }
    }
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(253369);
    return bool;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(253665);
    if (paramKeyEvent.hasModifiers(4096)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onKeyShortcut(paramInt, paramKeyEvent);
      AppMethodBeat.o(253665);
      return bool;
      if (jFF())
      {
        bool = onTextContextMenuItem(16908319);
        AppMethodBeat.o(253665);
        return bool;
        if ((this.afYi != null) && (b.jFT())) {}
        while (i != 0)
        {
          bool = onTextContextMenuItem(16908338);
          AppMethodBeat.o(253665);
          return bool;
          i = 0;
        }
        if (jFK())
        {
          bool = onTextContextMenuItem(16908320);
          AppMethodBeat.o(253665);
          return bool;
          if (jFL())
          {
            bool = onTextContextMenuItem(16908321);
            AppMethodBeat.o(253665);
            return bool;
            if (jFM())
            {
              bool = onTextContextMenuItem(16908322);
              AppMethodBeat.o(253665);
              return bool;
              if (paramKeyEvent.hasModifiers(4097)) {
                switch (paramInt)
                {
                default: 
                  break;
                case 50: 
                  if (jFM())
                  {
                    bool = onTextContextMenuItem(16908337);
                    AppMethodBeat.o(253665);
                    return bool;
                  }
                  break;
                case 54: 
                  if ((this.afYi != null) && (b.jFU())) {}
                  for (i = j; i != 0; i = 0)
                  {
                    bool = onTextContextMenuItem(16908339);
                    AppMethodBeat.o(253665);
                    return bool;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253402);
    if (!isEnabled())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(253402);
      return bool;
    }
    if (!KeyEvent.isModifierKey(paramInt)) {
      this.afXp = false;
    }
    switch (paramInt)
    {
    }
    while ((this.afYi != null) && (this.afYi.afZx != null) && (this.afYi.afZx.onKeyUp(this, (Editable)this.mText, paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(253402);
      return true;
      Object localObject;
      if ((paramKeyEvent.hasNoModifiers()) && (!hasOnClickListeners()) && (this.afXw != null) && ((this.mText instanceof Editable)) && (this.mLayout != null) && (onCheckIsTextEditor()))
      {
        localObject = getInputMethodManager();
        a((InputMethodManager)localObject);
        if ((localObject != null) && (getShowSoftInputOnFocus())) {
          ((InputMethodManager)localObject).showSoftInput(this, 0);
        }
      }
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(253402);
      return bool;
      if (paramKeyEvent.hasNoModifiers())
      {
        if ((this.afYi != null) && (this.afYi.afZs != null) && (this.afYi.afZs.agba != null) && (this.afYi.afZs.agbb))
        {
          this.afYi.afZs.agbb = false;
          if (this.afYi.afZs.agba.a(this, 0))
          {
            AppMethodBeat.o(253402);
            return true;
          }
        }
        if ((((paramKeyEvent.getFlags() & 0x10) != 0) || (jFv())) && (!hasOnClickListeners()))
        {
          localObject = focusSearch(130);
          if (localObject != null)
          {
            if (!((View)localObject).requestFocus(130))
            {
              paramKeyEvent = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(253402);
              throw paramKeyEvent;
            }
            super.onKeyUp(paramInt, paramKeyEvent);
            AppMethodBeat.o(253402);
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
        AppMethodBeat.o(253402);
        return bool;
      }
    }
    if ((this.afXw != null) && (this.mLayout != null) && (this.afXw.jHk()))
    {
      AppMethodBeat.o(253402);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(253402);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(253487);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.afXO >= 0)
    {
      paramInt1 = this.afXO;
      this.afXO = -1;
      aEt(Math.min(paramInt1, this.mText.length()));
    }
    AppMethodBeat.o(253487);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253482);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    BoringLayout.Metrics localMetrics1 = adWu;
    BoringLayout.Metrics localMetrics2 = adWu;
    if (this.bsl == null) {
      this.bsl = getTextDirectionHeuristic();
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
      if (!this.afXG) {
        break label878;
      }
      paramInt2 = 1048576;
      if (this.afXv == null)
      {
        k = paramInt2;
        label109:
        if (this.mLayout == null) {
          break label814;
        }
        if ((this.mLayout.getWidth() == paramInt2) && (k == paramInt2) && (this.mLayout.getEllipsizedWidth() == paramInt1 - getCompoundPaddingLeft() - getCompoundPaddingRight())) {
          break label797;
        }
        k = 1;
        label157:
        if ((this.afXu != null) || (this.adVQ != null) || (paramInt2 <= this.mLayout.getWidth()) || ((!(this.mLayout instanceof BoringLayout)) && ((j == 0) || (i < 0) || (i > paramInt2)))) {
          break label803;
        }
        i = 1;
        label208:
        if ((this.adVX == this.afXL) && (this.adVW == this.afXK)) {
          break label808;
        }
        j = 1;
        label233:
        if ((k != 0) || (j != 0))
        {
          if ((j != 0) || (i == 0)) {
            break label814;
          }
          this.mLayout.increaseWidthTo(paramInt2);
        }
        label260:
        if (i1 != 1073741824) {
          break label839;
        }
        this.adWc = -1;
        paramInt2 = m;
        label276:
        j = paramInt2 - getCompoundPaddingTop() - getCompoundPaddingBottom();
        i = j;
        if (this.adVX == 1)
        {
          i = j;
          if (this.mLayout.getLineCount() > this.adVW) {
            i = Math.min(j, this.mLayout.getLineTop(this.adVW));
          }
        }
        if ((this.afXw == null) && (this.mLayout.getWidth() <= n) && (this.mLayout.getHeight() <= i)) {
          break label869;
        }
        jFt();
        label368:
        setMeasuredDimension(paramInt1, paramInt2);
        AppMethodBeat.o(253482);
      }
    }
    else
    {
      if ((this.mLayout == null) || (this.adVQ != null)) {
        break label913;
      }
    }
    label773:
    label908:
    label913:
    for (paramInt2 = b(this.mLayout);; paramInt2 = -1)
    {
      if (paramInt2 < 0)
      {
        localMetrics1 = BoringLayout.isBoring(this.adVR, this.xe, this.afXP);
        if (localMetrics1 == null) {
          break label908;
        }
        this.afXP = localMetrics1;
        paramInt1 = 0;
      }
      for (;;)
      {
        label437:
        if ((localMetrics1 == null) || (localMetrics1 == adWu))
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            i = (int)Math.ceil(Layout.getDesiredWidth(this.adVR, 0, this.adVR.length(), this.xe));
          }
          j = i;
          paramInt2 = i;
          label488:
          localObject = this.afXq;
          i = j;
          if (localObject != null) {
            i = Math.max(Math.max(j, ((b)localObject).adWI), ((b)localObject).adWJ);
          }
          j = i;
          localObject = localMetrics2;
          if (this.afXu != null)
          {
            k = -1;
            j = k;
            if (this.afXv != null)
            {
              j = k;
              if (this.adVQ == null) {
                j = b(this.afXv);
              }
            }
            if (j >= 0) {
              break label901;
            }
            localMetrics2 = BoringLayout.isBoring(this.afXu, this.xe, this.afXQ);
            localObject = localMetrics2;
            if (localMetrics2 != null) {
              this.afXQ = localMetrics2;
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
            if (localObject == adWu) {
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
            if (this.afXM == 1)
            {
              i = Math.min(i, this.vF * getLineHeight());
              if (this.afXN != 1) {
                break label773;
              }
            }
            for (i = Math.max(i, this.mf * getLineHeight());; i = Math.max(i, this.mf))
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
              i = Math.min(i, this.vF);
              break label676;
            }
            k = this.afXv.getWidth();
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
            this.adWc = i;
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
    AppMethodBeat.i(253248);
    if (this.mLayout == null) {
      jmY();
    }
    int j;
    if (this.afXw != null)
    {
      j = getSelectionEnd();
      i = j;
      if (this.afYi != null)
      {
        i = j;
        if (this.afYi.afZj != null)
        {
          i = j;
          if (this.afYi.afZj.jGY()) {
            i = getSelectionStart();
          }
        }
      }
      j = i;
      if (i < 0)
      {
        j = i;
        if ((this.tJ & 0x70) == 80) {
          j = this.mText.length();
        }
      }
      if (j >= 0) {
        aEt(j);
      }
      if ((this.afYi != null) && (this.afYi.afZX))
      {
        this.afYi.jGq();
        this.afYi.afZX = false;
      }
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.afXk = false;
      this.afXl = false;
      AppMethodBeat.o(253248);
      return true;
    }
    Layout localLayout;
    if (jFy())
    {
      localLayout = this.afXv;
      label181:
      if ((this.tJ & 0x70) != 80) {
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
          if ((m < k) || ((this.tJ & 0x70) != 80)) {
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
        localLayout = this.mLayout;
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
    AppMethodBeat.i(253361);
    if ((this.afXs != null) && (this.afXI))
    {
      int i = bk(paramMotionEvent.getX(paramInt), paramMotionEvent.getY(paramInt));
      if ((((ClickableSpan[])this.afXs.getSpans(i, i, ClickableSpan.class)).length > 0) && (Build.VERSION.SDK_INT >= 24))
      {
        paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1002);
        AppMethodBeat.o(253361);
        return paramMotionEvent;
      }
    }
    if (((jFu()) || (jFD())) && (Build.VERSION.SDK_INT >= 24))
    {
      paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1008);
      AppMethodBeat.o(253361);
      return paramMotionEvent;
    }
    paramMotionEvent = super.onResolvePointerIcon(paramMotionEvent, paramInt);
    AppMethodBeat.o(253361);
    return paramMotionEvent;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(253089);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(253089);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.bba != null) {
      setText(localSavedState.bba);
    }
    if ((localSavedState.afYJ >= 0) && (localSavedState.afYK >= 0) && (this.afXs != null))
    {
      int i = this.mText.length();
      if ((localSavedState.afYJ <= i) && (localSavedState.afYK <= i)) {
        break label201;
      }
      paramParcelable = "";
      if (localSavedState.bba != null) {
        paramParcelable = "(restored) ";
      }
      Log.e("cmEdit.CMTextView", "Saved cursor position " + localSavedState.afYJ + "/" + localSavedState.afYK + " out of range for " + paramParcelable + "text " + this.mText);
    }
    for (;;)
    {
      if (localSavedState.afYM != null)
      {
        jFQ();
        b.a(localSavedState.afYM);
      }
      AppMethodBeat.o(253089);
      return;
      label201:
      Selection.setSelection(this.afXs, localSavedState.afYJ, localSavedState.afYK);
      if (localSavedState.afYL)
      {
        jFQ();
        this.afYi.afZu = true;
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(253757);
    super.onRtlPropertiesChanged(paramInt);
    TextDirectionHeuristic localTextDirectionHeuristic = getTextDirectionHeuristic();
    if (this.bsl != localTextDirectionHeuristic)
    {
      this.bsl = localTextDirectionHeuristic;
      if (this.mLayout != null) {
        akv();
      }
    }
    AppMethodBeat.o(253757);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(253087);
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
          if (this.afYi != null) {
            h(localSpannableStringBuilder);
          }
        }
        label160:
        for (((SavedState)localObject).bba = localSpannableStringBuilder;; ((SavedState)localObject).bba = this.mText.toString())
        {
          if (k != 0)
          {
            ((SavedState)localObject).afYJ = j;
            ((SavedState)localObject).afYK = i;
          }
          if ((isFocused()) && (j >= 0) && (i >= 0)) {
            ((SavedState)localObject).afYL = true;
          }
          AppMethodBeat.o(253087);
          return localObject;
        }
      }
      AppMethodBeat.o(253087);
      return localObject;
      continue;
      i = -1;
      j = -1;
    }
  }
  
  public void onScreenStateChanged(int paramInt)
  {
    AppMethodBeat.i(253266);
    super.onScreenStateChanged(paramInt);
    b localb;
    if (this.afYi != null)
    {
      localb = this.afYi;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(253266);
      return;
      localb.jGa();
      AppMethodBeat.o(253266);
      return;
      localb.jFZ();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(253716);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.afYi != null)
    {
      b localb = this.afYi;
      if (localb.afZS != null) {
        localb.afZS.agbH = true;
      }
      if ((localb.afZk != null) && (Build.VERSION.SDK_INT >= 23)) {
        localb.afZk.invalidateContentRect();
      }
    }
    AppMethodBeat.o(253716);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(253710);
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
        AppMethodBeat.o(253710);
        return false;
      case 16908319: 
        boolean bool = jFB();
        jFO();
        if ((this.afYi != null) && (bool)) {
          this.afYi.jGw().jHe();
        }
        AppMethodBeat.o(253710);
        return true;
      case 16908338: 
        AppMethodBeat.o(253710);
        return true;
      case 16908339: 
        AppMethodBeat.o(253710);
        return true;
      case 16908322: 
        Y(j, i, true);
        AppMethodBeat.o(253710);
        return true;
      case 16908337: 
        Y(j, i, false);
        AppMethodBeat.o(253710);
        return true;
      case 16908320: 
        if (a(ClipData.newPlainText(null, oL(j, i)))) {
          oM(j, i);
        }
        for (;;)
        {
          AppMethodBeat.o(253710);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908321: 
        paramInt = getSelectionStart();
        i = getSelectionEnd();
        if (a(ClipData.newPlainText(null, oL(Math.max(0, Math.min(paramInt, i)), Math.max(0, Math.max(paramInt, i)))))) {
          jFJ();
        }
        for (;;)
        {
          AppMethodBeat.o(253710);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908340: 
        if (this.afYi != null)
        {
          localObject1 = this.afYi;
          ((b)localObject1).jFY();
          paramInt = (((b)localObject1).afZe.getSelectionStart() + ((b)localObject1).afZe.getSelectionEnd()) / 2;
          Selection.setSelection((Spannable)((b)localObject1).afZe.getText(), paramInt);
        }
        AppMethodBeat.o(253710);
        return true;
      case 16908341: 
        localObject1 = getSelectedText();
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
        {
          Object localObject2 = new Intent("android.intent.action.SEND");
          ((Intent)localObject2).setType("text/plain");
          ((Intent)localObject2).removeExtra("android.intent.extra.TEXT");
          ((Intent)localObject2).putExtra("android.intent.extra.TEXT", (String)com.tencent.mm.ui.widget.cedit.util.c.m((CharSequence)localObject1, 100000));
          localObject1 = getContext();
          localObject2 = Intent.createChooser((Intent)localObject2, null);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Selection.setSelection(this.afXs, getSelectionEnd());
        }
        AppMethodBeat.o(253710);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = (AutofillManager)getContext().getSystemService(AutofillManager.class);
        if (localObject1 != null) {
          ((AutofillManager)localObject1).requestAutofill(this);
        }
      }
      jFJ();
      AppMethodBeat.o(253710);
      return true;
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253613);
    if (!b(paramMotionEvent, false))
    {
      AppMethodBeat.o(253613);
      return true;
    }
    int k = paramMotionEvent.getActionMasked();
    Object localObject1;
    int m;
    if (this.afYi != null)
    {
      localObject1 = this.afYi;
      if (paramMotionEvent.isFromSource(8194)) {
        if (((((b)localObject1).afZY ^ paramMotionEvent.getButtonState()) & 0x1) != 0)
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
        ((b)localObject1).afZY = paramMotionEvent.getButtonState();
        if (i == 0) {
          break label186;
        }
        if (paramMotionEvent.getActionMasked() == 1) {
          ((b)localObject1).afZy = true;
        }
        if ((this.afYi.afZi == null) || (!this.afYi.afZi.jGJ())) {
          break label806;
        }
        AppMethodBeat.o(253613);
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
      Object localObject2 = ViewConfiguration.get(((b)localObject1).afZe.getContext());
      c localc = ((b)localObject1).afZZ;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0)
      {
        bool1 = paramMotionEvent.isFromSource(8194);
        long l1 = paramMotionEvent.getEventTime();
        long l2 = localc.agci;
        long l3 = localc.agci;
        long l4 = localc.agcf;
        if ((l1 - l2 <= ViewConfiguration.getDoubleTapTimeout()) && (l3 - l4 <= ViewConfiguration.getDoubleTapTimeout()) && ((localc.agck == 1) || ((localc.agck == 2) && (bool1)))) {
          if (localc.agck == 1)
          {
            localc.agck = 2;
            label317:
            localc.agcl = c.b(localc.uJC, localc.uJD, paramMotionEvent.getX(), paramMotionEvent.getY(), ((ViewConfiguration)localObject2).getScaledDoubleTapSlop());
            label348:
            localc.uJC = paramMotionEvent.getX();
            localc.uJD = paramMotionEvent.getY();
            localc.agcf = paramMotionEvent.getEventTime();
            localc.agcm = false;
            localc.agcn = false;
            label387:
            ((b)localObject1).aA(paramMotionEvent);
            if (((b)localObject1).afZl)
            {
              localObject2 = ((b)localObject1).jGE();
              if ((!((b.j)localObject2).agap.afZm) || (!((b.j)localObject2).agap.jGF().jGJ())) {
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
        if (((b)localObject1).afZm) {
          ((b)localObject1).jGF().B(paramMotionEvent);
        }
        if (((b)localObject1).afZN != null)
        {
          ((b)localObject1).afZe.removeCallbacks(((b)localObject1).afZN);
          ((b)localObject1).afZN = null;
        }
        if (paramMotionEvent.getActionMasked() != 0) {
          break;
        }
        ((b)localObject1).afZw = false;
        ((b)localObject1).aeVV = false;
        break;
        localc.agck = 3;
        break label317;
        localc.agck = 1;
        localc.agcl = false;
        break label348;
        if (i == 1)
        {
          localc.agcg = paramMotionEvent.getX();
          localc.agch = paramMotionEvent.getY();
          localc.agci = paramMotionEvent.getEventTime();
          localc.agcm = false;
          localc.agcn = false;
          break label387;
        }
        if (i == 2)
        {
          if (localc.agcm) {
            break label387;
          }
          float f1 = paramMotionEvent.getX() - localc.uJC;
          float f2 = paramMotionEvent.getY() - localc.uJD;
          i = ((ViewConfiguration)localObject2).getScaledTouchSlop();
          if (f1 * f1 + f2 * f2 > i * i)
          {
            bool1 = true;
            label666:
            localc.agcm = bool1;
            if (!localc.agcm) {
              break label387;
            }
            if (Math.abs(f1) > Math.abs(f2)) {
              break label712;
            }
          }
          label712:
          for (bool1 = true;; bool1 = false)
          {
            localc.agcn = bool1;
            break;
            bool1 = false;
            break label666;
          }
        }
        if (i != 3) {
          break label387;
        }
        localc.agcf = 0L;
        localc.agci = 0L;
        localc.agck = 0;
        localc.agcl = false;
        localc.agcm = false;
        localc.agcn = false;
        break label387;
        if ((!paramMotionEvent.isFromSource(8194)) && (((b.j)localObject2).agbr))
        {
          ((b.j)localObject2).aD(paramMotionEvent);
          continue;
          if (((b.j)localObject2).agbr) {
            ((b.j)localObject2).jGR();
          }
        }
      }
      label806:
      if ((this.afYi.afZj != null) && (this.afYi.afZj.jGZ()))
      {
        AppMethodBeat.o(253613);
        return true;
      }
    }
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    if ((this.afYi != null) && (this.afYi.afZy) && (k == 1))
    {
      this.afYi.afZy = false;
      if (this.afYi.agag)
      {
        this.afYi.jGr();
        this.afYi.agag = false;
      }
      AppMethodBeat.o(253613);
      return bool1;
    }
    if ((k == 1) && ((this.afYi == null) || (!this.afYi.aeVV)) && (isFocused()))
    {
      k = 1;
      if (((this.afXw == null) && (!onCheckIsTextEditor())) || (!isEnabled()) || (!(this.mText instanceof Spannable)) || (this.mLayout == null)) {
        break label1175;
      }
      if (this.afXw == null) {
        break label1187;
      }
    }
    label1175:
    label1187:
    for (int j = this.afXw.a(this, this.afXs, paramMotionEvent) | false;; j = 0)
    {
      boolean bool2 = jFu();
      if ((k != 0) && (this.afXI) && (this.afXH != 0) && (bool2))
      {
        localObject1 = (ClickableSpan[])this.afXs.getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
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
          if (!jFD())
          {
            m = j;
            if (!bool2) {}
          }
          else
          {
            localObject1 = getInputMethodManager();
            a((InputMethodManager)localObject1);
            if ((jFD()) && (this.afYi.afZG) && (localObject1 != null)) {
              ((InputMethodManager)localObject1).showSoftInput(this, 0);
            }
            this.afYi.aB(paramMotionEvent);
            m = 1;
          }
        }
        if (m != 0)
        {
          AppMethodBeat.o(253613);
          return true;
          k = 0;
          break;
        }
        AppMethodBeat.o(253613);
        return bool1;
      }
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253638);
    if ((this.afXw != null) && (this.afXs != null) && (this.mLayout != null) && (this.afXw.jHl()))
    {
      AppMethodBeat.o(253638);
      return true;
    }
    boolean bool = super.onTrackballEvent(paramMotionEvent);
    AppMethodBeat.o(253638);
    return bool;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(253576);
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.afYi != null) && (paramInt != 0))
    {
      this.afYi.jFY();
      jFJ();
    }
    AppMethodBeat.o(253576);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(253571);
    super.onWindowFocusChanged(paramBoolean);
    if (this.afYi != null)
    {
      b localb = this.afYi;
      if (paramBoolean)
      {
        if (localb.afZB != null)
        {
          localb.afZB.mCancelled = false;
          localb.jGH();
        }
        if ((localb.afZe.jFB()) && (!localb.jGA()))
        {
          localb.jGq();
          AppMethodBeat.o(253571);
        }
      }
      else
      {
        if (localb.afZB != null) {
          localb.afZB.cancel();
        }
        if (localb.afZs != null) {
          localb.afZs.agbb = false;
        }
        localb.jFY();
        localb.jGD();
        localb.jGl();
        localb.jGi();
      }
    }
    AppMethodBeat.o(253571);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(253798);
    switch (paramInt)
    {
    default: 
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(253798);
      return bool1;
    case 2097152: 
      if ((!isEnabled()) || (this.afXt != TextView.BufferType.EDITABLE))
      {
        AppMethodBeat.o(253798);
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
            Selection.setSelection(this.afXs, paramInt);
          }
        }
        AppMethodBeat.o(253798);
        return true;
      }
    case 16: 
      if (!isEnabled())
      {
        AppMethodBeat.o(253798);
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
      if (this.afXw == null)
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
          if (this.mLayout != null) {
            if (!jFD())
            {
              bool2 = bool1;
              if (!jFu()) {}
            }
            else
            {
              bool2 = bool1;
              if (isFocused())
              {
                paramBundle = getInputMethodManager();
                a(paramBundle);
                bool2 = bool1;
                if (!jFu())
                {
                  bool2 = bool1;
                  if (this.afYi.afZG)
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
        AppMethodBeat.o(253798);
        return bool2;
      }
      if ((isFocused()) && (jFL()) && (onTextContextMenuItem(16908321)))
      {
        AppMethodBeat.o(253798);
        return true;
      }
      if ((isFocused()) && (jFM()) && (onTextContextMenuItem(16908322)))
      {
        AppMethodBeat.o(253798);
        return true;
      }
      AppMethodBeat.o(253798);
      return false;
      if ((isFocused()) && (jFK()) && (onTextContextMenuItem(16908320)))
      {
        AppMethodBeat.o(253798);
        return true;
      }
      AppMethodBeat.o(253798);
      return false;
      jFR();
      CharSequence localCharSequence = getIterableTextForAccessibility();
      if (localCharSequence == null)
      {
        AppMethodBeat.o(253798);
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
            AppMethodBeat.o(253798);
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
            if (this.afYi != null) {
              this.afYi.jGw().jHd();
            }
            AppMethodBeat.o(253798);
            return true;
          }
        }
      }
      AppMethodBeat.o(253798);
      return false;
      jFR();
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(253798);
      return bool1;
      if (!isLongClickable()) {
        break;
      }
      if ((isEnabled()) && (this.afXt == TextView.BufferType.EDITABLE)) {
        this.afYi.afZM = true;
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
          this.afYi.afZM = false;
          AppMethodBeat.o(253798);
        }
        bool1 = performLongClick();
      }
    }
  }
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(253714);
    if (this.afYi != null) {
      this.afYi.afZL = true;
    }
    int i;
    if (super.performLongClick()) {
      i = 1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.afYi != null)
      {
        boolean bool3 = this.afYi.Nq(bool1);
        bool2 = bool1 | bool3;
        Log.i("cmEdit.CMTextView", "editor performLongClick handled =".concat(String.valueOf(bool3)));
        this.afYi.afZL = false;
      }
      if (bool2)
      {
        if (i == 0) {
          performHapticFeedback(0);
        }
        if (this.afYi != null) {
          this.afYi.afZy = true;
        }
      }
      AppMethodBeat.o(253714);
      return bool2;
      i = 0;
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(253544);
    if (this.mListeners != null)
    {
      int i = this.mListeners.indexOf(paramTextWatcher);
      if (i >= 0) {
        this.mListeners.remove(i);
      }
    }
    AppMethodBeat.o(253544);
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(253702);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      AppMethodBeat.o(253702);
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
    AppMethodBeat.o(253702);
  }
  
  public void setAdaptText(TextView paramTextView)
  {
    AppMethodBeat.i(252712);
    this.afYk = paramTextView;
    this.afYk.addTextChangedListener(this.afYl);
    AppMethodBeat.o(252712);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(253524);
    if (!paramBoolean) {
      setTransformationMethod(null);
    }
    AppMethodBeat.o(253524);
  }
  
  public final void setAutoLinkMask(int paramInt)
  {
    this.afXH = paramInt;
  }
  
  public void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(252990);
    this.bsm = paramInt;
    if (this.mLayout != null)
    {
      jmX();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(252990);
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(252831);
    b localb2 = this.afXq;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.adWM = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(252831);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(getContext());
        this.afXq = localb1;
      }
    }
  }
  
  public void setCompoundDrawableTintBlendMode(BlendMode paramBlendMode)
  {
    AppMethodBeat.i(252843);
    if (this.afXq == null) {
      this.afXq = new b(getContext());
    }
    this.afXq.afYv = paramBlendMode;
    this.afXq.kC = true;
    jFq();
    AppMethodBeat.o(252843);
  }
  
  public void setCompoundDrawableTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(252837);
    if (this.afXq == null) {
      this.afXq = new b(getContext());
    }
    this.afXq.kz = paramColorStateList;
    this.afXq.afYw = true;
    jFq();
    AppMethodBeat.o(252837);
  }
  
  public void setCompoundDrawableTintMode(PorterDuff.Mode paramMode) {}
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(253532);
    if ((paramBoolean) && (this.afYi == null))
    {
      AppMethodBeat.o(253532);
      return;
    }
    jFQ();
    if (this.afYi.afZC != paramBoolean)
    {
      this.afYi.afZC = paramBoolean;
      invalidate();
      this.afYi.jGH();
      this.afYi.jFX();
    }
    AppMethodBeat.o(253532);
  }
  
  public void setCustomInsertionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(253719);
    jFQ();
    this.afYi.afZW = paramCallback;
    AppMethodBeat.o(253719);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(253717);
    jFQ();
    this.afYi.afZV = paramCallback;
    AppMethodBeat.o(253717);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(253092);
    this.adVO = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(253092);
  }
  
  public void setElegantTextHeight(boolean paramBoolean)
  {
    AppMethodBeat.i(252974);
    if (paramBoolean != this.xe.isElegantTextHeight())
    {
      this.xe.setElegantTextHeight(paramBoolean);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252974);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(253527);
    if (this.adVQ != paramTruncateAt)
    {
      this.adVQ = paramTruncateAt;
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(253527);
  }
  
  public void setEms(int paramInt)
  {
    AppMethodBeat.i(253071);
    this.mf = paramInt;
    this.vF = paramInt;
    this.afXN = 1;
    this.afXM = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253071);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(252736);
    if (paramBoolean == isEnabled())
    {
      AppMethodBeat.o(252736);
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
    if (this.afYi != null)
    {
      this.afYi.jFX();
      this.afYi.jGH();
    }
    AppMethodBeat.o(252736);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253216);
    jFQ();
    AppMethodBeat.o(253216);
  }
  
  public void setExtractedText(ExtractedText paramExtractedText)
  {
    int m = 0;
    AppMethodBeat.i(253444);
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
      AppMethodBeat.o(253444);
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
    AppMethodBeat.i(253448);
    if (this.afYi.afZt != null) {
      this.afYi.afZt.agbd = paramExtractedTextRequest;
    }
    this.afYi.jFY();
    jFJ();
    if (this.afYi.afZj != null) {
      this.afYi.afZj.jGW();
    }
    AppMethodBeat.o(253448);
  }
  
  public void setFallbackLineSpacing(boolean paramBoolean)
  {
    AppMethodBeat.i(252976);
    if (this.afXF != paramBoolean)
    {
      this.afXF = paramBoolean;
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252976);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(253219);
    if (paramArrayOfInputFilter == null)
    {
      paramArrayOfInputFilter = new IllegalArgumentException();
      AppMethodBeat.o(253219);
      throw paramArrayOfInputFilter;
    }
    this.afXS = paramArrayOfInputFilter;
    if ((this.mText instanceof Editable)) {
      a((Editable)this.mText, paramArrayOfInputFilter);
    }
    AppMethodBeat.o(253219);
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    AppMethodBeat.i(252854);
    com.tencent.mm.ui.widget.cedit.util.b.el(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.top;; i = localFontMetricsInt.ascent)
    {
      if (paramInt > Math.abs(i))
      {
        i = -i;
        setPadding(getPaddingLeft(), paramInt - i, getPaddingRight(), getPaddingBottom());
      }
      AppMethodBeat.o(252854);
      return;
    }
  }
  
  public void setFontFeatureSettings(String paramString)
  {
    AppMethodBeat.i(252991);
    if (paramString != this.xe.getFontFeatureSettings())
    {
      this.xe.setFontFeatureSettings(paramString);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252991);
  }
  
  public void setFreezesText(boolean paramBoolean)
  {
    this.afXg = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(253026);
    if ((paramInt & 0x800007) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      if ((i & 0x800007) != (this.tJ & 0x800007)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (i != this.tJ) {
          invalidate();
        }
        this.tJ = i;
        if ((this.mLayout != null) && (paramInt != 0))
        {
          i = this.mLayout.getWidth();
          if (this.afXv != null) {
            break label141;
          }
        }
        label141:
        for (paramInt = j;; paramInt = this.afXv.getWidth())
        {
          BoringLayout.Metrics localMetrics = adWu;
          a(i, paramInt, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), true);
          AppMethodBeat.o(253026);
          return;
        }
      }
    }
  }
  
  public void setHandleColorRes(int paramInt)
  {
    this.afYn = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(253047);
    this.adVY = paramInt;
    this.adVW = paramInt;
    this.adVZ = 2;
    this.adVX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253047);
  }
  
  public void setHighlightColor(int paramInt)
  {
    AppMethodBeat.i(253000);
    if (this.uRB != paramInt)
    {
      this.uRB = paramInt;
      invalidate();
    }
    AppMethodBeat.o(253000);
  }
  
  public final void setHint(int paramInt)
  {
    AppMethodBeat.i(253135);
    setHint(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(253135);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253131);
    setHintInternal(paramCharSequence);
    if (this.afYi != null)
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
        this.afYi.jGm();
      }
      AppMethodBeat.o(253131);
      return;
    }
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(253018);
    this.afXd = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(253018);
  }
  
  public final void setHintTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(253020);
    this.afXd = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(253020);
  }
  
  public void setHorizontallyScrolling(boolean paramBoolean)
  {
    AppMethodBeat.i(253030);
    if (this.afXG != paramBoolean)
    {
      this.afXG = paramBoolean;
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(253030);
  }
  
  public void setImeHintLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(253208);
    jFQ();
    this.afYi.jFV();
    this.afYi.afZs.agbc = paramLocaleList;
    KeyListener localKeyListener;
    if ((this.afXE) && (Build.VERSION.SDK_INT >= 24)) {
      if (paramLocaleList == null)
      {
        paramLocaleList = null;
        if ((this.afXD) || (this.afYi == null)) {
          break label250;
        }
        localKeyListener = this.afYi.afZx;
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
      boolean bool = aEr(this.afYi.OeF);
      setKeyListenerOnly(paramLocaleList);
      jFo();
      if (bool)
      {
        int i = this.afYi.OeF & 0xF;
        if (i == 1)
        {
          paramLocaleList = this.afYi;
          paramLocaleList.OeF |= 0x80;
          AppMethodBeat.o(253208);
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
          AppMethodBeat.o(253208);
          return;
        }
        if (i == 2)
        {
          paramLocaleList = this.afYi;
          paramLocaleList.OeF |= 0x10;
        }
      }
      label250:
      AppMethodBeat.o(253208);
      return;
      label257:
      paramLocaleList = localKeyListener;
    }
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(253160);
    jFQ();
    this.afYi.jFV();
    this.afYi.afZs.qiM = paramInt;
    AppMethodBeat.o(253160);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(253465);
    if (this.adWd != paramBoolean)
    {
      this.adWd = paramBoolean;
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(253465);
  }
  
  public void setInputExtras(int paramInt)
  {
    AppMethodBeat.i(253191);
    jFQ();
    XmlResourceParser localXmlResourceParser = getResources().getXml(paramInt);
    this.afYi.jFV();
    this.afYi.afZs.extras = new Bundle();
    getResources().parseBundleExtras(localXmlResourceParser, this.afYi.afZs.extras);
    AppMethodBeat.o(253191);
  }
  
  public void setInputType(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(253144);
    boolean bool1 = aEr(getInputType());
    boolean bool4 = aEs(getInputType());
    cS(paramInt, false);
    boolean bool3 = aEr(paramInt);
    boolean bool5 = aEs(paramInt);
    if (bool3)
    {
      setTransformationMethod(PasswordTransformationMethod.getInstance());
      a(null, null, 3, 0, -1);
      i = 0;
      if (!aEq(paramInt))
      {
        bool1 = true;
        label76:
        if ((this.adTq != bool1) || (i != 0))
        {
          if (!bool3) {
            bool2 = true;
          }
          t(bool1, bool2, true);
        }
        if (!jFI()) {
          setTextInternal(ba(this.mText));
        }
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.restartInput(this);
        }
        AppMethodBeat.o(253144);
      }
    }
    else if (bool5)
    {
      if (this.afXx != PasswordTransformationMethod.getInstance()) {
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
        if (this.afXx == PasswordTransformationMethod.getInstance())
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
    AppMethodBeat.i(252761);
    this.afXD = true;
    setKeyListenerOnly(paramKeyListener);
    jFp();
    if (paramKeyListener != null)
    {
      jFQ();
      jFo();
    }
    for (;;)
    {
      paramKeyListener = getInputMethodManager();
      if (paramKeyListener != null) {
        paramKeyListener.restartInput(this);
      }
      AppMethodBeat.o(252761);
      return;
      if (this.afYi != null) {
        this.afYi.OeF = 0;
      }
    }
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    AppMethodBeat.i(252855);
    com.tencent.mm.ui.widget.cedit.util.b.el(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt - i);
      }
      AppMethodBeat.o(252855);
      return;
    }
  }
  
  public void setLetterSpacing(float paramFloat)
  {
    AppMethodBeat.i(252982);
    if (paramFloat != this.xe.getLetterSpacing())
    {
      this.xe.setLetterSpacing(paramFloat);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252982);
  }
  
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(253076);
    com.tencent.mm.ui.widget.cedit.util.b.el(paramInt);
    int i = getPaint().getFontMetricsInt(null);
    if (paramInt != i)
    {
      float f = paramInt - i;
      if ((this.adVV != f) || (this.adVU != 1.0F))
      {
        this.adVV = f;
        this.adVU = 1.0F;
        if (this.mLayout != null)
        {
          jmX();
          requestLayout();
          invalidate();
        }
      }
    }
    AppMethodBeat.o(253076);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(253043);
    this.adVY = paramInt;
    this.adVW = paramInt;
    this.adVZ = 1;
    this.adVX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253043);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(253022);
    this.afXe = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(253022);
  }
  
  public final void setLinkTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(253023);
    this.afXe = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(253023);
  }
  
  public final void setLinksClickable(boolean paramBoolean)
  {
    this.afXI = paramBoolean;
  }
  
  public void setMaxEms(int paramInt)
  {
    AppMethodBeat.i(253058);
    this.vF = paramInt;
    this.afXM = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253058);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(253039);
    this.adVW = paramInt;
    this.adVX = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253039);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(253036);
    this.adVW = paramInt;
    this.adVX = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253036);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(253063);
    this.vF = paramInt;
    this.afXM = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253063);
  }
  
  public void setMenuCallback(a.e parame)
  {
    this.afYp = parame;
  }
  
  public void setMinEms(int paramInt)
  {
    AppMethodBeat.i(253049);
    this.mf = paramInt;
    this.afXN = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253049);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(253035);
    this.adVY = paramInt;
    this.adVZ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253035);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(253034);
    this.adVY = paramInt;
    this.adVZ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253034);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(253053);
    this.mf = paramInt;
    this.afXN = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253053);
  }
  
  public final void setMovementMethod(com.tencent.mm.ui.widget.cedit.b.d paramd)
  {
    AppMethodBeat.i(252768);
    if (this.afXw != paramd)
    {
      this.afXw = paramd;
      if ((paramd != null) && (this.afXs == null)) {
        setText(this.mText);
      }
      jFp();
      if (this.afYi != null) {
        this.afYi.jFX();
      }
    }
    AppMethodBeat.o(252768);
  }
  
  public void setOnEditorActionListener(c paramc)
  {
    AppMethodBeat.i(253177);
    jFQ();
    this.afYi.jFV();
    this.afYi.afZs.agba = paramc;
    AppMethodBeat.o(253177);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252852);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      jmX();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(252852);
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252853);
    if ((paramInt1 != getPaddingStart()) || (paramInt3 != getPaddingEnd()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      jmX();
    }
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(252853);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(253029);
    if (this.xe.getFlags() != paramInt)
    {
      this.xe.setFlags(paramInt);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(253029);
  }
  
  public void setPrivateImeOptions(String paramString)
  {
    AppMethodBeat.i(253180);
    jFQ();
    this.afYi.jFV();
    this.afYi.afZs.agaX = paramString;
    AppMethodBeat.o(253180);
  }
  
  public void setRawInputType(int paramInt)
  {
    AppMethodBeat.i(253147);
    if ((paramInt == 0) && (this.afYi == null))
    {
      AppMethodBeat.o(253147);
      return;
    }
    jFQ();
    this.afYi.OeF = paramInt;
    AppMethodBeat.o(253147);
  }
  
  public void setReuseBrands(List<String> paramList)
  {
    AppMethodBeat.i(253787);
    if (paramList != null)
    {
      this.afYr.clear();
      this.afYr.addAll(paramList);
    }
    AppMethodBeat.o(253787);
  }
  
  public void setReuseItems(List<String> paramList)
  {
    AppMethodBeat.i(253780);
    if (paramList != null)
    {
      this.afYq.clear();
      this.afYq.addAll(paramList);
    }
    AppMethodBeat.o(253780);
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  public void setSelectAllOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(253530);
    jFQ();
    this.afYi.afZD = paramBoolean;
    if ((paramBoolean) && (!(this.mText instanceof Spannable))) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(253530);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(253595);
    isSelected();
    super.setSelected(paramBoolean);
    AppMethodBeat.o(253595);
  }
  
  public final void setShowSoftInputOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(253004);
    jFQ();
    this.afYi.afZG = paramBoolean;
    AppMethodBeat.o(253004);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(253526);
    setInputTypeSingleLine(paramBoolean);
    t(paramBoolean, true, true);
    AppMethodBeat.o(253526);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(253095);
    this.adVP = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(253095);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(253125);
    setText(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(253125);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253098);
    setText(paramCharSequence, this.afXt);
    AppMethodBeat.o(253098);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(253108);
    a(paramCharSequence, paramBufferType, true, 0);
    AppMethodBeat.o(253108);
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    this.afXm = paramTextClassifier;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(252994);
    this.NhP = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(252994);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(252998);
    if (paramColorStateList == null)
    {
      paramColorStateList = new NullPointerException();
      AppMethodBeat.o(252998);
      throw paramColorStateList;
    }
    this.NhP = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(252998);
  }
  
  public void setTextCursorDrawable(int paramInt)
  {
    AppMethodBeat.i(252900);
    if (paramInt != 0) {}
    for (Drawable localDrawable = getContext().getDrawable(paramInt);; localDrawable = null)
    {
      setTextCursorDrawable(localDrawable);
      AppMethodBeat.o(252900);
      return;
    }
  }
  
  public void setTextCursorDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(252894);
    this.afXZ = paramDrawable;
    this.afXY = 0;
    if (this.afYi != null) {
      this.afYi.jGI();
    }
    AppMethodBeat.o(252894);
  }
  
  public void setTextIsSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(253295);
    if ((!paramBoolean) && (this.afYi == null))
    {
      AppMethodBeat.o(253295);
      return;
    }
    jFQ();
    if (this.afYi.afZE == paramBoolean)
    {
      AppMethodBeat.o(253295);
      return;
    }
    this.afYi.afZE = paramBoolean;
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
      localObject = com.tencent.mm.ui.widget.cedit.b.a.jHj();
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
      this.afYi.jFX();
      AppMethodBeat.o(253295);
      return;
      setFocusable(paramBoolean);
      break;
      localObject = null;
      break label91;
    }
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253104);
    TextView.BufferType localBufferType = this.afXt;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    setText(paramCharSequence, localBufferType);
    if (((i >= 0) || (j >= 0)) && (this.afXs != null)) {
      Selection.setSelection(this.afXs, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
    AppMethodBeat.o(253104);
  }
  
  public void setTextLocale(Locale paramLocale)
  {
    AppMethodBeat.i(252918);
    this.afXB = true;
    this.xe.setTextLocale(paramLocale);
    if (this.mLayout != null)
    {
      jmX();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(252918);
  }
  
  public void setTextLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(252922);
    this.afXB = true;
    if (Build.VERSION.SDK_INT >= 24) {
      this.xe.setTextLocales(paramLocaleList);
    }
    for (;;)
    {
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(252922);
      return;
      if ((paramLocaleList != null) && (paramLocaleList.size() > 0)) {
        this.xe.setTextLocale(paramLocaleList.get(0));
      }
    }
  }
  
  public final void setTextOperationUser(UserHandle paramUserHandle)
  {
    AppMethodBeat.i(253675);
    if (Objects.equals(this.afXT, paramUserHandle))
    {
      AppMethodBeat.o(253675);
      return;
    }
    if (paramUserHandle != null) {
      Process.myUserHandle().equals(paramUserHandle);
    }
    this.afXT = paramUserHandle;
    this.afXU = null;
    AppMethodBeat.o(253675);
  }
  
  public void setTextScaleX(float paramFloat)
  {
    AppMethodBeat.i(252967);
    if (paramFloat != this.xe.getTextScaleX())
    {
      this.afXA = true;
      this.xe.setTextScaleX(paramFloat);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252967);
  }
  
  public void setTextSelectHandle(int paramInt)
  {
    AppMethodBeat.i(252865);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select handle should be a valid drawable resource id.");
      setTextSelectHandle(getContext().getDrawable(paramInt));
      AppMethodBeat.o(252865);
      return;
    }
  }
  
  public void setTextSelectHandle(Drawable paramDrawable)
  {
    AppMethodBeat.i(252861);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The text select handle should not be null.");
    this.afYf = paramDrawable;
    this.afYe = 0;
    if (this.afYi != null) {
      this.afYi.Nr(true);
    }
    AppMethodBeat.o(252861);
  }
  
  public void setTextSelectHandleLeft(int paramInt)
  {
    AppMethodBeat.i(252873);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select left handle should be a valid drawable resource id.");
      setTextSelectHandleLeft(getContext().getDrawable(paramInt));
      AppMethodBeat.o(252873);
      return;
    }
  }
  
  public void setTextSelectHandleLeft(Drawable paramDrawable)
  {
    AppMethodBeat.i(252872);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The left text select handle should not be null.");
    this.afYb = paramDrawable;
    this.afYa = 0;
    if (this.afYi != null) {
      this.afYi.Nr(true);
    }
    AppMethodBeat.o(252872);
  }
  
  public void setTextSelectHandleRight(int paramInt)
  {
    AppMethodBeat.i(252883);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select right handle should be a valid drawable resource id.");
      setTextSelectHandleRight(getContext().getDrawable(paramInt));
      AppMethodBeat.o(252883);
      return;
    }
  }
  
  public void setTextSelectHandleRight(Drawable paramDrawable)
  {
    AppMethodBeat.i(252879);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The right text select handle should not be null.");
    this.afYd = paramDrawable;
    this.afYc = 0;
    if (this.afYi != null) {
      this.afYi.Nr(true);
    }
    AppMethodBeat.o(252879);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(252954);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(252954);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(252960);
    int i;
    if ((eB()) && (this.sI != 0))
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
      this.afXC = paramInt;
      ee(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(252960);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setTransformationMethod(TransformationMethod paramTransformationMethod)
  {
    AppMethodBeat.i(252775);
    if (paramTransformationMethod == this.afXx)
    {
      AppMethodBeat.o(252775);
      return;
    }
    if ((this.afXx != null) && (this.afXs != null)) {
      this.afXs.removeSpan(this.afXx);
    }
    this.afXx = paramTransformationMethod;
    this.afXy = false;
    setText(this.mText);
    this.bsl = getTextDirectionHeuristic();
    AppMethodBeat.o(252775);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(252968);
    if (this.xe.getTypeface() != paramTypeface)
    {
      this.xe.setTypeface(paramTypeface);
      if (this.mLayout != null)
      {
        jmX();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(252968);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(253073);
    this.mf = paramInt;
    this.vF = paramInt;
    this.afXN = 2;
    this.afXM = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(253073);
  }
  
  public boolean showContextMenu()
  {
    AppMethodBeat.i(253623);
    if (this.afYi != null) {
      this.afYi.bm((0.0F / 0.0F), (0.0F / 0.0F));
    }
    boolean bool = super.showContextMenu();
    AppMethodBeat.o(253623);
    return bool;
  }
  
  public boolean showContextMenu(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253625);
    if (this.afYi != null) {
      this.afYi.bm(paramFloat1, paramFloat2);
    }
    boolean bool = super.showContextMenu(paramFloat1, paramFloat2);
    AppMethodBeat.o(253625);
    return bool;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(253283);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.afXq != null))
    {
      Drawable[] arrayOfDrawable = this.afXq.afYu;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        if (paramDrawable == arrayOfDrawable[i])
        {
          AppMethodBeat.o(253283);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(253283);
    return bool;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int afYJ;
    int afYK;
    boolean afYL;
    ParcelableParcel afYM;
    CharSequence bba;
    CharSequence dAp;
    
    static
    {
      AppMethodBeat.i(252270);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(252270);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(252259);
      this.afYJ = -1;
      this.afYK = -1;
      this.afYJ = paramParcel.readInt();
      this.afYK = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.afYL = bool;
        this.bba = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        if (paramParcel.readInt() != 0) {
          this.dAp = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        }
        if (paramParcel.readInt() != 0) {
          this.afYM = ((ParcelableParcel)ParcelableParcel.CREATOR.createFromParcel(paramParcel));
        }
        AppMethodBeat.o(252259);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
      this.afYJ = -1;
      this.afYK = -1;
    }
    
    public String toString()
    {
      AppMethodBeat.i(252284);
      String str2 = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.afYJ + " end=" + this.afYK;
      String str1 = str2;
      if (this.bba != null) {
        str1 = str2 + " text=" + this.bba;
      }
      str1 = str1 + "}";
      AppMethodBeat.o(252284);
      return str1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(252277);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.afYJ);
      paramParcel.writeInt(this.afYK);
      int i;
      if (this.afYL)
      {
        i = 1;
        paramParcel.writeInt(i);
        TextUtils.writeToParcel(this.bba, paramParcel, paramInt);
        if (this.dAp != null) {
          break label85;
        }
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        if (this.afYM != null) {
          break label102;
        }
        paramParcel.writeInt(0);
        AppMethodBeat.o(252277);
        return;
        i = 0;
        break;
        label85:
        paramParcel.writeInt(1);
        TextUtils.writeToParcel(this.dAp, paramParcel, paramInt);
      }
      label102:
      paramParcel.writeInt(1);
      this.afYM.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(252277);
    }
  }
  
  class a
    implements SpanWatcher, TextWatcher
  {
    private CharSequence afYt;
    
    private a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(252359);
      CustomTextView.this.f(paramEditable);
      if (MetaKeyKeyListener.getMetaState(paramEditable, 2048) != 0) {
        com.tencent.mm.ui.widget.cedit.util.d.b(CustomTextView.this, paramEditable);
      }
      AppMethodBeat.o(252359);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252347);
      if ((com.tencent.mm.ui.widget.cedit.util.d.jHn()) && (CustomTextView.b(CustomTextView.this) != null)) {
        this.afYt = CustomTextView.b(CustomTextView.this).toString();
      }
      CustomTextView.a(CustomTextView.this, paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(252347);
    }
    
    public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252381);
      CustomTextView.this.a(paramSpannable, paramObject, -1, paramInt1, -1, paramInt2);
      AppMethodBeat.o(252381);
    }
    
    public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(252370);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, paramInt3, paramInt2, paramInt4);
      AppMethodBeat.o(252370);
    }
    
    public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252393);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, -1, paramInt2, -1);
      AppMethodBeat.o(252393);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(252351);
      CustomTextView.this.c(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if ((com.tencent.mm.ui.widget.cedit.util.d.jHn()) && ((CustomTextView.this.isFocused()) || ((CustomTextView.this.isSelected()) && (CustomTextView.this.isShown()))))
      {
        paramCharSequence = this.afYt;
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
        localAccessibilityEvent.setFromIndex(paramInt1);
        localAccessibilityEvent.setRemovedCount(paramInt2);
        localAccessibilityEvent.setAddedCount(paramInt3);
        localAccessibilityEvent.setBeforeText(paramCharSequence);
        CustomTextView.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        this.afYt = null;
      }
      AppMethodBeat.o(252351);
    }
  }
  
  static final class b
  {
    int adWE;
    int adWF;
    int adWG;
    int adWH;
    int adWI;
    int adWJ;
    int adWK;
    int adWL;
    int adWM;
    final Rect adWz;
    Drawable afYA;
    Drawable afYB;
    boolean afYC;
    boolean afYD;
    int afYE;
    int afYF;
    int afYG;
    int afYH;
    int afYI;
    final Drawable[] afYu;
    BlendMode afYv;
    boolean afYw;
    Drawable afYx;
    Drawable afYy;
    Drawable afYz;
    boolean kC;
    ColorStateList kz;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(252322);
      this.adWz = new Rect();
      this.afYu = new Drawable[4];
      this.afYI = -1;
      if (paramContext.getApplicationInfo().targetSdkVersion < 17) {}
      for (boolean bool = true;; bool = false)
      {
        this.afYC = bool;
        this.afYD = false;
        AppMethodBeat.o(252322);
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
    ColorStateList NhP = null;
    int afXC = -1;
    float afXh = 0.0F;
    float afXi = 0.0F;
    float afXj = 0.0F;
    int afYN = 1711528645;
    ColorStateList afYO = null;
    ColorStateList afYP = null;
    LocaleList afYQ = null;
    boolean afYR = false;
    int afYS = -1;
    int afYT = 0;
    int afYU = -1;
    boolean afYV = false;
    boolean afYW = false;
    boolean afYX = false;
    boolean afYY = false;
    boolean afYZ = false;
    boolean afZa = false;
    float afZb = 0.0F;
    String afZc = null;
    String afZd = null;
    String qUf = null;
    Typeface sB = null;
    int sDK = -1;
    int ugx = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(252256);
      String str = "TextAppearanceAttributes {\n    mTextColorHighlight:" + this.afYN + "\n    mTextColor:" + this.NhP + "\n    mTextColorHint:" + this.afYO + "\n    mTextColorLink:" + this.afYP + "\n    mTextSize:" + this.sDK + "\n    mTextSizeUnit:" + this.afXC + "\n    mTextLocales:" + this.afYQ + "\n    mFontFamily:" + this.qUf + "\n    mFontTypeface:" + this.sB + "\n    mFontFamilyExplicit:" + this.afYR + "\n    mTypefaceIndex:" + this.afYS + "\n    mTextStyle:" + this.afYT + "\n    mFontWeight:" + this.afYU + "\n    mAllCaps:" + this.afYV + "\n    mShadowColor:" + this.ugx + "\n    mShadowDx:" + this.afXi + "\n    mShadowDy:" + this.afXj + "\n    mShadowRadius:" + this.afXh + "\n    mHasElegant:" + this.afYW + "\n    mElegant:" + this.afYX + "\n    mHasFallbackLineSpacing:" + this.afYY + "\n    mFallbackLineSpacing:" + this.afYZ + "\n    mHasLetterSpacing:" + this.afZa + "\n    mLetterSpacing:" + this.afZb + "\n    mFontFeatureSettings:" + this.afZc + "\n    mFontVariationSettings:" + this.afZd + "\n}";
      AppMethodBeat.o(252256);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomTextView
 * JD-Core Version:    0.7.0.1
 */