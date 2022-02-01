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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
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
  public static final BoringLayout.Metrics Wpg;
  private static final float[] YeY;
  private static final InputFilter[] YeZ;
  private static final Spanned Yfa;
  private static final int[] Yfb;
  static long Yfc;
  private static final SparseIntArray Ygm;
  private static final RectF rH;
  private ColorStateList Hkc;
  private TextDirectionHeuristic Mg;
  private int Mh;
  private int Mi;
  private long Qh;
  boolean Wmc;
  private Spannable.Factory WoA;
  private TextUtils.TruncateAt WoB;
  private CharSequence WoC;
  public Layout WoF;
  private float WoG;
  private float WoH;
  private int WoI;
  private int WoJ;
  private int WoK;
  private int WoL;
  private int WoO;
  private boolean WoP;
  private BoringLayout WoQ;
  @ViewDebug.ExportedProperty(category="text")
  private int Woy;
  private Editable.Factory Woz;
  private boolean YfA;
  private boolean YfB;
  private int YfC;
  private boolean YfD;
  private boolean YfE;
  boolean YfF;
  private boolean YfG;
  private int YfH;
  private boolean YfI;
  private int YfJ;
  private int YfK;
  private int YfL;
  private int YfM;
  private int YfN;
  private int YfO;
  private BoringLayout.Metrics YfP;
  private BoringLayout.Metrics YfQ;
  private BoringLayout YfR;
  private InputFilter[] YfS;
  private UserHandle YfT;
  private volatile Locale YfU;
  private Path YfV;
  private Paint YfW;
  private boolean YfX;
  int YfY;
  private Drawable YfZ;
  private ColorStateList Yfd;
  private ColorStateList Yfe;
  private int Yff;
  private boolean Yfg;
  private float Yfh;
  private float Yfi;
  private float Yfj;
  private boolean Yfk;
  private boolean Yfl;
  private TextClassifier Yfm;
  private TextClassifier Yfn;
  private TextClassificationContext Yfo;
  private boolean Yfp;
  b Yfq;
  private int Yfr;
  public Spannable Yfs;
  private TextView.BufferType Yft;
  private CharSequence Yfu;
  private Layout Yfv;
  private com.tencent.mm.ui.widget.cedit.b.d Yfw;
  TransformationMethod Yfx;
  private boolean Yfy;
  private a Yfz;
  int Yga;
  private Drawable Ygb;
  int Ygc;
  private Drawable Ygd;
  int Yge;
  private Drawable Ygf;
  private int Ygg;
  private boolean Ygh;
  b Ygi;
  private int Ygj;
  private TextView Ygk;
  private TextWatcher Ygl;
  int Ygn;
  boolean Ygo;
  private a.e Ygp;
  private Set<String> Ygq;
  private Set<String> Ygr;
  private int lj;
  private ArrayList<TextWatcher> mListeners;
  private Scroller mScroller;
  private Rect mTempRect;
  @ViewDebug.ExportedProperty(category="text")
  public CharSequence mText;
  int rGp;
  private int rJ;
  private int raH;
  @ViewDebug.ExportedProperty(category="text")
  private int sK;
  private int uJ;
  private TextPaint wi;
  
  static
  {
    AppMethodBeat.i(202575);
    YeY = new float[2];
    rH = new RectF();
    YeZ = new InputFilter[0];
    Yfa = new SpannedString("");
    Yfb = new int[] { 16843597 };
    com.tencent.mm.ui.widget.cedit.util.d.ibY();
    Object localObject = new CustomTextView.2();
    Ygm = (SparseIntArray)localObject;
    int i = a.m.MMNewTextView_android_textColorHighlight;
    ((SparseIntArray)localObject).put(i, i);
    localObject = Ygm;
    i = a.m.MMNewTextView_android_textColor;
    ((SparseIntArray)localObject).put(i, i);
    localObject = Ygm;
    i = a.m.MMNewTextView_android_textColorHint;
    ((SparseIntArray)localObject).put(i, i);
    localObject = Ygm;
    i = a.m.MMNewTextView_android_textColorLink;
    ((SparseIntArray)localObject).put(i, i);
    localObject = Ygm;
    i = a.m.MMNewTextView_android_textSize;
    ((SparseIntArray)localObject).put(i, i);
    try
    {
      localObject = Ygm;
      i = a.m.MMNewTextView_android_textLocale;
      ((SparseIntArray)localObject).put(i, i);
      label147:
      localObject = Ygm;
      i = a.m.MMNewTextView_android_typeface;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_fontFamily;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_textStyle;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_textFontWeight;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_textAllCaps;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_shadowColor;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_shadowDx;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_shadowDy;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_shadowRadius;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_elegantTextHeight;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_fallbackLineSpacing;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_letterSpacing;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_fontFeatureSettings;
      ((SparseIntArray)localObject).put(i, i);
      localObject = Ygm;
      i = a.m.MMNewTextView_android_fontVariationSettings;
      ((SparseIntArray)localObject).put(i, i);
      Wpg = new BoringLayout.Metrics();
      AppMethodBeat.o(202575);
      return;
    }
    catch (Throwable localThrowable)
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
    AppMethodBeat.i(201296);
    this.Woz = Editable.Factory.getInstance();
    this.WoA = Spannable.Factory.getInstance();
    this.Yfr = -1;
    this.Yft = TextView.BufferType.NORMAL;
    this.YfB = false;
    this.YfC = -1;
    this.YfD = false;
    this.sK = 8388659;
    this.YfI = true;
    this.WoG = 1.0F;
    this.WoH = 0.0F;
    this.Mh = 0;
    this.Mi = 0;
    this.WoI = 2147483647;
    this.WoJ = 1;
    this.WoK = 0;
    this.WoL = 1;
    this.YfK = this.WoI;
    this.YfL = this.WoJ;
    this.uJ = 2147483647;
    this.YfM = 2;
    this.lj = 0;
    this.YfN = 2;
    this.WoO = -1;
    this.WoP = true;
    this.YfO = -1;
    this.YfS = YeZ;
    this.rGp = 1714664933;
    this.YfX = true;
    this.YfY = 16843618;
    this.Yga = 16843461;
    this.Ygc = 16843462;
    this.Yge = 16843463;
    this.Ygg = -1;
    this.Ygj = 0;
    this.rJ = 0;
    this.Ygl = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(217235);
        ((Editable)CustomTextView.this.getText()).insert(CustomTextView.this.getSelectionStart(), paramAnonymousEditable.toString());
        AppMethodBeat.o(217235);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Ygn = getContext().getResources().getColor(a.d.cursor_handle_color);
    this.Ygo = false;
    this.Ygq = new HashSet();
    this.Ygr = new HashSet();
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.o(201296);
  }
  
  private void C(Rect paramRect)
  {
    AppMethodBeat.i(202165);
    int i = ias();
    paramRect.left += i;
    paramRect.right = (i + paramRect.right);
    i = iat();
    paramRect.top += i;
    paramRect.bottom = (i + paramRect.bottom);
    AppMethodBeat.o(202165);
  }
  
  private Locale Ht(boolean paramBoolean)
  {
    AppMethodBeat.i(202327);
    AsyncTask.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193691);
        CustomTextView.a(CustomTextView.this);
        AppMethodBeat.o(193691);
      }
    });
    if ((this.YfU == null) && (!paramBoolean))
    {
      localLocale = Locale.getDefault();
      AppMethodBeat.o(202327);
      return localLocale;
    }
    Locale localLocale = this.YfU;
    AppMethodBeat.o(202327);
    return localLocale;
  }
  
  private void Ku()
  {
    AppMethodBeat.i(202124);
    if (((getLayoutParams().width != -2) || ((this.YfM == this.YfN) && (this.uJ == this.lj))) && ((this.Yfu == null) || (this.Yfv != null)) && (getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight() > 0))
    {
      int j = this.WoF.getHeight();
      int k = this.WoF.getWidth();
      if (this.Yfv == null) {}
      for (int i = 0;; i = this.Yfv.getWidth())
      {
        BoringLayout.Metrics localMetrics = Wpg;
        a(k, i, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        if (this.WoB == TextUtils.TruncateAt.MARQUEE) {
          break label231;
        }
        if ((getLayoutParams().height == -2) || (getLayoutParams().height == -1)) {
          break;
        }
        invalidate();
        AppMethodBeat.o(202124);
        return;
      }
      if ((this.WoF.getHeight() == j) && ((this.Yfv == null) || (this.Yfv.getHeight() == j)))
      {
        invalidate();
        AppMethodBeat.o(202124);
        return;
      }
      label231:
      requestLayout();
      invalidate();
      AppMethodBeat.o(202124);
      return;
    }
    hKs();
    requestLayout();
    invalidate();
    AppMethodBeat.o(202124);
  }
  
  private void T(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(202469);
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
            Selection.setSelection(this.Yfs, paramInt2);
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
      Yfc = 0L;
    }
    AppMethodBeat.o(202469);
  }
  
  /* Error */
  private int a(int paramInt, KeyEvent paramKeyEvent1, KeyEvent paramKeyEvent2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 625
    //   6: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokevirtual 628	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:isEnabled	()Z
    //   13: ifne +11 -> 24
    //   16: ldc_w 625
    //   19: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_2
    //   25: invokevirtual 633	android/view/KeyEvent:getRepeatCount	()I
    //   28: ifne +15 -> 43
    //   31: iload_1
    //   32: invokestatic 637	android/view/KeyEvent:isModifierKey	(I)Z
    //   35: ifne +8 -> 43
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 639	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfp	Z
    //   43: iload_1
    //   44: lookupswitch	default:+92->136, 4:+318->362, 23:+273->317, 61:+295->339, 66:+157->201, 112:+443->487, 124:+476->520, 160:+157->201, 277:+347->391, 278:+379->423, 279:+411->455
    //   137: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   140: ifnull +530 -> 670
    //   143: aload_0
    //   144: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   147: getfield 647	com/tencent/mm/ui/widget/cedit/edit/b:Yhx	Landroid/text/method/KeyListener;
    //   150: ifnull +520 -> 670
    //   153: aload_3
    //   154: ifnull +716 -> 870
    //   157: aload_0
    //   158: invokevirtual 650	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:ian	()V
    //   161: aload_0
    //   162: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   165: getfield 647	com/tencent/mm/ui/widget/cedit/edit/b:Yhx	Landroid/text/method/KeyListener;
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 593	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   173: checkcast 595	android/text/Editable
    //   176: aload_3
    //   177: invokeinterface 656 4 0
    //   182: istore 6
    //   184: iload 6
    //   186: ifeq +402 -> 588
    //   189: aload_0
    //   190: invokevirtual 659	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iao	()V
    //   193: ldc_w 625
    //   196: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: iconst_m1
    //   200: ireturn
    //   201: aload_2
    //   202: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   205: ifeq -69 -> 136
    //   208: aload_0
    //   209: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   212: ifnull +65 -> 277
    //   215: aload_0
    //   216: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   219: getfield 666	com/tencent/mm/ui/widget/cedit/edit/b:Yhs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   222: ifnull +55 -> 277
    //   225: aload_0
    //   226: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   229: getfield 666	com/tencent/mm/ui/widget/cedit/edit/b:Yhs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   232: getfield 672	com/tencent/mm/ui/widget/cedit/edit/b$g:Yja	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   235: ifnull +42 -> 277
    //   238: aload_0
    //   239: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   242: getfield 666	com/tencent/mm/ui/widget/cedit/edit/b:Yhs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   245: getfield 672	com/tencent/mm/ui/widget/cedit/edit/b$g:Yja	Lcom/tencent/mm/ui/widget/cedit/edit/CustomTextView$c;
    //   248: aload_0
    //   249: iconst_0
    //   250: invokeinterface 675 3 0
    //   255: ifeq +22 -> 277
    //   258: aload_0
    //   259: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   262: getfield 666	com/tencent/mm/ui/widget/cedit/edit/b:Yhs	Lcom/tencent/mm/ui/widget/cedit/edit/b$g;
    //   265: iconst_1
    //   266: putfield 678	com/tencent/mm/ui/widget/cedit/edit/b$g:Yjb	Z
    //   269: ldc_w 625
    //   272: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: iconst_m1
    //   276: ireturn
    //   277: aload_2
    //   278: invokevirtual 681	android/view/KeyEvent:getFlags	()I
    //   281: bipush 16
    //   283: iand
    //   284: ifne +10 -> 294
    //   287: aload_0
    //   288: invokespecial 684	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iam	()Z
    //   291: ifeq -155 -> 136
    //   294: aload_0
    //   295: invokevirtual 687	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:hasOnClickListeners	()Z
    //   298: ifeq +11 -> 309
    //   301: ldc_w 625
    //   304: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: ldc_w 625
    //   312: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: iconst_m1
    //   316: ireturn
    //   317: aload_2
    //   318: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   321: ifeq -185 -> 136
    //   324: aload_0
    //   325: invokespecial 684	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iam	()Z
    //   328: ifeq -192 -> 136
    //   331: ldc_w 625
    //   334: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: iconst_0
    //   338: ireturn
    //   339: aload_2
    //   340: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   343: ifne +11 -> 354
    //   346: aload_2
    //   347: iconst_1
    //   348: invokevirtual 690	android/view/KeyEvent:hasModifiers	(I)Z
    //   351: ifeq -215 -> 136
    //   354: ldc_w 625
    //   357: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_0
    //   361: ireturn
    //   362: aload_0
    //   363: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   366: ifnull -230 -> 136
    //   369: aload_0
    //   370: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   373: invokevirtual 693	com/tencent/mm/ui/widget/cedit/edit/b:ibk	()Z
    //   376: ifne -240 -> 136
    //   379: aload_0
    //   380: invokevirtual 696	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaB	()V
    //   383: ldc_w 625
    //   386: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   389: iconst_m1
    //   390: ireturn
    //   391: aload_2
    //   392: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   395: ifeq -259 -> 136
    //   398: aload_0
    //   399: invokevirtual 699	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaC	()Z
    //   402: ifeq -266 -> 136
    //   405: aload_0
    //   406: ldc_w 700
    //   409: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   412: ifeq -276 -> 136
    //   415: ldc_w 625
    //   418: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: iconst_m1
    //   422: ireturn
    //   423: aload_2
    //   424: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   427: ifeq -291 -> 136
    //   430: aload_0
    //   431: invokevirtual 706	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaD	()Z
    //   434: ifeq -298 -> 136
    //   437: aload_0
    //   438: ldc_w 707
    //   441: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   444: ifeq -308 -> 136
    //   447: ldc_w 625
    //   450: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: iconst_m1
    //   454: ireturn
    //   455: aload_2
    //   456: invokevirtual 662	android/view/KeyEvent:hasNoModifiers	()Z
    //   459: ifeq -323 -> 136
    //   462: aload_0
    //   463: invokevirtual 710	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaE	()Z
    //   466: ifeq -330 -> 136
    //   469: aload_0
    //   470: ldc_w 711
    //   473: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   476: ifeq -340 -> 136
    //   479: ldc_w 625
    //   482: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   485: iconst_m1
    //   486: ireturn
    //   487: aload_2
    //   488: iconst_1
    //   489: invokevirtual 690	android/view/KeyEvent:hasModifiers	(I)Z
    //   492: ifeq -356 -> 136
    //   495: aload_0
    //   496: invokevirtual 699	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaC	()Z
    //   499: ifeq -363 -> 136
    //   502: aload_0
    //   503: ldc_w 700
    //   506: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   509: ifeq -373 -> 136
    //   512: ldc_w 625
    //   515: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: iconst_m1
    //   519: ireturn
    //   520: aload_2
    //   521: sipush 4096
    //   524: invokevirtual 690	android/view/KeyEvent:hasModifiers	(I)Z
    //   527: ifeq +28 -> 555
    //   530: aload_0
    //   531: invokevirtual 706	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaD	()Z
    //   534: ifeq +21 -> 555
    //   537: aload_0
    //   538: ldc_w 707
    //   541: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   544: ifeq -408 -> 136
    //   547: ldc_w 625
    //   550: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   553: iconst_m1
    //   554: ireturn
    //   555: aload_2
    //   556: iconst_1
    //   557: invokevirtual 690	android/view/KeyEvent:hasModifiers	(I)Z
    //   560: ifeq -424 -> 136
    //   563: aload_0
    //   564: invokevirtual 710	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iaE	()Z
    //   567: ifeq -431 -> 136
    //   570: aload_0
    //   571: ldc_w 711
    //   574: invokevirtual 703	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:onTextContextMenuItem	(I)Z
    //   577: ifeq -441 -> 136
    //   580: ldc_w 625
    //   583: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: iconst_m1
    //   587: ireturn
    //   588: aload_0
    //   589: invokevirtual 659	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iao	()V
    //   592: iconst_0
    //   593: istore 4
    //   595: iload 4
    //   597: ifeq +73 -> 670
    //   600: aload_0
    //   601: invokevirtual 650	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:ian	()V
    //   604: aload_0
    //   605: getfield 641	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Ygi	Lcom/tencent/mm/ui/widget/cedit/edit/b;
    //   608: getfield 647	com/tencent/mm/ui/widget/cedit/edit/b:Yhx	Landroid/text/method/KeyListener;
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 593	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:mText	Ljava/lang/CharSequence;
    //   616: checkcast 595	android/text/Editable
    //   619: iload_1
    //   620: aload_2
    //   621: invokeinterface 715 5 0
    //   626: istore 6
    //   628: aload_0
    //   629: invokevirtual 659	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iao	()V
    //   632: iload 6
    //   634: ifeq +36 -> 670
    //   637: ldc_w 625
    //   640: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: iconst_1
    //   644: ireturn
    //   645: astore 7
    //   647: aload_0
    //   648: invokevirtual 659	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iao	()V
    //   651: iconst_1
    //   652: istore 4
    //   654: goto -59 -> 595
    //   657: astore_2
    //   658: aload_0
    //   659: invokevirtual 659	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:iao	()V
    //   662: ldc_w 625
    //   665: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   668: aload_2
    //   669: athrow
    //   670: aload_0
    //   671: getfield 717	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   674: ifnull +166 -> 840
    //   677: aload_0
    //   678: getfield 525	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:WoF	Landroid/text/Layout;
    //   681: ifnull +159 -> 840
    //   684: aload_3
    //   685: ifnull +88 -> 773
    //   688: aload_0
    //   689: getfield 717	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   692: aload_0
    //   693: aload_0
    //   694: getfield 585	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfs	Landroid/text/Spannable;
    //   697: aload_3
    //   698: invokeinterface 722 4 0
    //   703: istore 6
    //   705: iload 6
    //   707: ifeq +11 -> 718
    //   710: ldc_w 625
    //   713: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: iconst_m1
    //   717: ireturn
    //   718: iconst_0
    //   719: istore 4
    //   721: iload 4
    //   723: ifeq +56 -> 779
    //   726: aload_0
    //   727: getfield 717	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfw	Lcom/tencent/mm/ui/widget/cedit/b/d;
    //   730: aload_0
    //   731: aload_0
    //   732: getfield 585	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfs	Landroid/text/Spannable;
    //   735: iload_1
    //   736: aload_2
    //   737: invokeinterface 725 5 0
    //   742: ifeq +37 -> 779
    //   745: aload_2
    //   746: invokevirtual 633	android/view/KeyEvent:getRepeatCount	()I
    //   749: ifne +15 -> 764
    //   752: iload_1
    //   753: invokestatic 637	android/view/KeyEvent:isModifierKey	(I)Z
    //   756: ifne +8 -> 764
    //   759: aload_0
    //   760: iconst_1
    //   761: putfield 639	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfp	Z
    //   764: ldc_w 625
    //   767: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   770: iconst_2
    //   771: ireturn
    //   772: astore_3
    //   773: iconst_1
    //   774: istore 4
    //   776: goto -55 -> 721
    //   779: aload_2
    //   780: invokevirtual 728	android/view/KeyEvent:getSource	()I
    //   783: sipush 257
    //   786: if_icmpne +54 -> 840
    //   789: iload 5
    //   791: istore 4
    //   793: iload_1
    //   794: tableswitch	default:+30 -> 824, 19:+33->827, 20:+33->827, 21:+33->827, 22:+33->827
    //   825: istore 4
    //   827: iload 4
    //   829: ifeq +11 -> 840
    //   832: ldc_w 625
    //   835: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: iconst_m1
    //   839: ireturn
    //   840: aload_0
    //   841: getfield 639	com/tencent/mm/ui/widget/cedit/edit/CustomTextView:Yfp	Z
    //   844: ifeq +18 -> 862
    //   847: iload_1
    //   848: invokestatic 637	android/view/KeyEvent:isModifierKey	(I)Z
    //   851: ifne +11 -> 862
    //   854: ldc_w 625
    //   857: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   860: iconst_m1
    //   861: ireturn
    //   862: ldc_w 625
    //   865: invokestatic 305	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(201780);
    if (paramLayout == this.Yfv) {}
    for (int i = getCompoundPaddingTop() + getCompoundPaddingBottom();; i = getExtendedPaddingTop() + getExtendedPaddingBottom())
    {
      int j = getMeasuredHeight();
      AppMethodBeat.o(201780);
      return j - i;
    }
  }
  
  private int a(Layout paramLayout, boolean paramBoolean)
  {
    AppMethodBeat.i(202107);
    if (paramLayout == null)
    {
      AppMethodBeat.o(202107);
      return 0;
    }
    int i = paramLayout.getHeight();
    b localb = this.Yfq;
    int j = i;
    if (localb != null) {
      j = Math.max(Math.max(i, localb.Wpw), localb.Wpx);
    }
    i = paramLayout.getLineCount();
    int k = getCompoundPaddingTop();
    int m = getCompoundPaddingBottom() + k;
    k = j + m;
    if (this.WoJ != 1)
    {
      k = Math.min(k, this.WoI);
      j = i;
      i = k;
    }
    for (;;)
    {
      if (this.WoL == 1)
      {
        k = i;
        if (j < this.WoK) {
          k = getLineHeight();
        }
      }
      for (k = i + (this.WoK - j) * k;; k = Math.max(i, this.WoK))
      {
        i = Math.max(k, getSuggestedMinimumHeight());
        AppMethodBeat.o(202107);
        return i;
        if ((!paramBoolean) || (i <= this.WoI) || ((!(paramLayout instanceof DynamicLayout)) && (!(paramLayout instanceof BoringLayout)))) {
          break label256;
        }
        j = paramLayout.getLineTop(this.WoI);
        i = j;
        if (localb != null) {
          i = Math.max(Math.max(j, localb.Wpw), localb.Wpx);
        }
        j = this.WoI;
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
    AppMethodBeat.i(202076);
    CharSequence localCharSequence = null;
    if (iap())
    {
      localObject = this.mText;
      localCharSequence = this.WoC;
      TextPaint localTextPaint = this.wi;
      float f1 = this.WoG;
      float f2 = this.WoH;
      paramBoolean2 = this.WoP;
      if (getKeyListener() == null) {}
      for (paramMetrics = paramTruncateAt;; paramMetrics = null)
      {
        paramMetrics = new DynamicLayout((CharSequence)localObject, localCharSequence, localTextPaint, paramInt1, paramAlignment, f1, f2, paramBoolean2, paramMetrics, paramInt2);
        localObject = paramMetrics;
        if (paramMetrics == null)
        {
          paramMetrics = this.WoC;
          int i = this.WoC.length();
          localObject = this.wi;
          f1 = this.WoG;
          f2 = this.WoH;
          paramBoolean2 = this.WoP;
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
        AppMethodBeat.o(202076);
        return localObject;
      }
    }
    if (paramMetrics == Wpg)
    {
      paramMetrics = BoringLayout.isBoring(this.WoC, this.wi, this.YfP);
      localObject = paramMetrics;
      if (paramMetrics != null) {
        this.YfP = paramMetrics;
      }
    }
    for (Object localObject = paramMetrics;; localObject = paramMetrics)
    {
      paramMetrics = localCharSequence;
      if (localObject == null) {
        break;
      }
      if ((((BoringLayout.Metrics)localObject).width <= paramInt1) && ((paramTruncateAt == null) || (((BoringLayout.Metrics)localObject).width <= paramInt2))) {
        if ((paramBoolean2) && (this.WoQ != null)) {
          paramMetrics = this.WoQ.replaceOrMake(this.WoC, this.wi, paramInt1, paramAlignment, this.WoG, this.WoH, (BoringLayout.Metrics)localObject, this.WoP);
        }
      }
      for (;;)
      {
        if (paramBoolean2)
        {
          this.WoQ = ((BoringLayout)paramMetrics);
          break;
          paramMetrics = BoringLayout.make(this.WoC, this.wi, paramInt1, paramAlignment, this.WoG, this.WoH, (BoringLayout.Metrics)localObject, this.WoP);
          continue;
          paramMetrics = localCharSequence;
          if (!paramBoolean1) {
            break;
          }
          paramMetrics = localCharSequence;
          if (((BoringLayout.Metrics)localObject).width > paramInt1) {
            break;
          }
          if ((paramBoolean2) && (this.WoQ != null))
          {
            paramMetrics = this.WoQ.replaceOrMake(this.WoC, this.wi, paramInt1, paramAlignment, this.WoG, this.WoH, (BoringLayout.Metrics)localObject, this.WoP, paramTruncateAt, paramInt2);
            break;
          }
          paramMetrics = BoringLayout.make(this.WoC, this.wi, paramInt1, paramAlignment, this.WoG, this.WoH, (BoringLayout.Metrics)localObject, this.WoP, paramTruncateAt, paramInt2);
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
    AppMethodBeat.i(202062);
    this.YfK = this.WoI;
    this.YfL = this.WoJ;
    this.YfX = true;
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
      if ((this.Wmc) && (this.WoF != null) && ((localAlignment == Layout.Alignment.ALIGN_NORMAL) || (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)))
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
      for (int j = this.WoF.getParagraphDirection(0);; j = 0)
      {
        boolean bool1;
        TextUtils.TruncateAt localTruncateAt;
        boolean bool2;
        int k;
        if ((this.WoB != null) && (getKeyListener() == null))
        {
          bool1 = true;
          localTruncateAt = this.WoB;
          if (this.Mg == null) {
            this.Mg = getTextDirectionHeuristic();
          }
          if (localTruncateAt != this.WoB) {
            break label462;
          }
          bool2 = true;
          this.WoF = a(paramInt1, paramMetrics1, paramInt3, localAlignment, bool1, localTruncateAt, bool2);
          if (this.WoB == null) {
            break label468;
          }
          k = 1;
          this.Yfv = null;
          if (this.Yfu != null) {
            if (k == 0) {
              break label629;
            }
          }
        }
        for (;;)
        {
          if (paramMetrics2 == Wpg)
          {
            paramMetrics2 = BoringLayout.isBoring(this.Yfu, this.wi, this.YfQ);
            paramMetrics1 = paramMetrics2;
            if (paramMetrics2 != null) {
              this.YfQ = paramMetrics2;
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
              if (this.YfR != null)
              {
                this.Yfv = this.YfR.replaceOrMake(this.Yfu, this.wi, paramInt1, localAlignment, this.WoG, this.WoH, paramMetrics1, this.WoP);
                this.YfR = ((BoringLayout)this.Yfv);
              }
            }
            else if (this.Yfv == null)
            {
              paramMetrics2 = this.Yfu;
              i = this.Yfu.length();
              localTextPaint = this.wi;
              f1 = this.WoG;
              f2 = this.WoH;
              bool1 = this.WoP;
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
              this.Yfv = new StaticLayout(paramMetrics2, 0, i, localTextPaint, paramInt1, localAlignment, f1, f2, bool1, paramMetrics1, paramInt3);
              if ((paramBoolean) || ((paramInt2 != 0) && (j != this.WoF.getParagraphDirection(0)))) {
                iak();
              }
              if (this.Ygi != null) {
                this.Ygi.iaN();
              }
              AppMethodBeat.o(202062);
              return;
              paramInt2 = 0;
              break;
              bool1 = false;
              break label112;
              bool2 = false;
              break label145;
              k = 0;
              break label175;
              this.Yfv = BoringLayout.make(this.Yfu, this.wi, paramInt1, localAlignment, this.WoG, this.WoH, paramMetrics1, this.WoP);
              break label302;
              label508:
              if ((k == 0) || (paramMetrics1.width > paramInt1)) {
                break label313;
              }
              if (this.YfR != null)
              {
                this.Yfv = this.YfR.replaceOrMake(this.Yfu, this.wi, paramInt1, localAlignment, this.WoG, this.WoH, paramMetrics1, this.WoP, this.WoB, paramInt3);
                break label313;
              }
              this.Yfv = BoringLayout.make(this.Yfu, this.wi, paramInt1, localAlignment, this.WoG, this.WoH, paramMetrics1, this.WoP, this.WoB, paramInt3);
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
    AppMethodBeat.i(202216);
    if (!(this.mText instanceof Editable))
    {
      AppMethodBeat.o(202216);
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
    AppMethodBeat.o(202216);
  }
  
  private static void a(Context paramContext, TypedArray paramTypedArray, d paramd)
  {
    AppMethodBeat.i(201518);
    if (paramTypedArray == null)
    {
      AppMethodBeat.o(201518);
      return;
    }
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    int k;
    int m;
    if (i < j)
    {
      k = paramTypedArray.getIndex(i);
      m = Ygm.get(k, -1);
      if (m != -1)
      {
        if (m != a.m.MMNewTextView_android_textColorHighlight) {
          break label84;
        }
        paramd.YgN = paramTypedArray.getColor(k, paramd.YgN);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label84:
      if (m == a.m.MMNewTextView_android_textColor)
      {
        paramd.Hkc = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textColorHint)
      {
        paramd.YgO = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textColorLink)
      {
        paramd.YgP = paramTypedArray.getColorStateList(k);
        continue;
      }
      if (m == a.m.MMNewTextView_android_textSize)
      {
        paramd.pyF = paramTypedArray.getDimensionPixelSize(k, paramd.pyF);
        if (Build.VERSION.SDK_INT < 22) {
          continue;
        }
        paramd.YfC = paramTypedArray.peekValue(k).getComplexUnit();
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
        paramd.YgQ = ((LocaleList)localObject);
        continue;
      }
      if (m == a.m.MMNewTextView_android_typeface)
      {
        paramd.YgS = paramTypedArray.getInt(k, paramd.YgS);
        if ((paramd.YgS == -1) || (paramd.YgR)) {
          continue;
        }
        paramd.nUv = null;
        continue;
      }
      if ((m != a.m.MMNewTextView_android_fontFamily) || (!paramContext.isRestricted())) {}
      try
      {
        if (Build.VERSION.SDK_INT >= 26) {
          paramd.rC = paramTypedArray.getFont(k);
        }
        label324:
        if (paramd.rC == null) {
          paramd.nUv = paramTypedArray.getString(k);
        }
        paramd.YgR = true;
        continue;
        if (m == a.m.MMNewTextView_android_textStyle)
        {
          paramd.YgT = paramTypedArray.getInt(k, paramd.YgT);
          continue;
        }
        if (m == a.m.MMNewTextView_android_textFontWeight)
        {
          paramd.YgU = paramTypedArray.getInt(k, paramd.YgU);
          continue;
        }
        if (m == a.m.MMNewTextView_android_textAllCaps)
        {
          paramd.YgV = paramTypedArray.getBoolean(k, paramd.YgV);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowColor)
        {
          paramd.raH = paramTypedArray.getInt(k, paramd.raH);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowDx)
        {
          paramd.Yfi = paramTypedArray.getFloat(k, paramd.Yfi);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowDy)
        {
          paramd.Yfj = paramTypedArray.getFloat(k, paramd.Yfj);
          continue;
        }
        if (m == a.m.MMNewTextView_android_shadowRadius)
        {
          paramd.Yfh = paramTypedArray.getFloat(k, paramd.Yfh);
          continue;
        }
        if (m == a.m.MMNewTextView_android_elegantTextHeight)
        {
          paramd.YgW = true;
          paramd.YgX = paramTypedArray.getBoolean(k, paramd.YgX);
          continue;
        }
        if (m == a.m.MMNewTextView_android_fallbackLineSpacing)
        {
          paramd.YgY = true;
          paramd.YgZ = paramTypedArray.getBoolean(k, paramd.YgZ);
          continue;
        }
        if (m == a.m.MMNewTextView_android_letterSpacing)
        {
          paramd.Yha = true;
          paramd.Yhb = paramTypedArray.getFloat(k, paramd.Yhb);
          continue;
        }
        if (m == a.m.MMNewTextView_android_fontFeatureSettings)
        {
          paramd.Yhc = paramTypedArray.getString(k);
          continue;
        }
        if (m != a.m.MMNewTextView_android_fontVariationSettings) {
          continue;
        }
        paramd.Yhd = paramTypedArray.getString(k);
        continue;
        AppMethodBeat.o(201518);
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
  
  @SuppressLint({"Range"})
  private void a(Typeface paramTypeface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201374);
    if (paramInt2 >= 0) {
      Math.min(1000, paramInt2);
    }
    setTypeface(paramTypeface, paramInt1);
    AppMethodBeat.o(201374);
  }
  
  private void a(Typeface paramTypeface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201372);
    if ((paramTypeface == null) && (paramString != null))
    {
      a(Typeface.create(paramString, 0), paramInt2, paramInt3);
      AppMethodBeat.o(201372);
      return;
    }
    if (paramTypeface != null)
    {
      a(paramTypeface, paramInt2, paramInt3);
      AppMethodBeat.o(201372);
      return;
    }
    switch (paramInt1)
    {
    default: 
      a(null, paramInt2, paramInt3);
      AppMethodBeat.o(201372);
      return;
    case 1: 
      a(Typeface.SANS_SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(201372);
      return;
    case 2: 
      a(Typeface.SERIF, paramInt2, paramInt3);
      AppMethodBeat.o(201372);
      return;
    }
    a(Typeface.MONOSPACE, paramInt2, paramInt3);
    AppMethodBeat.o(201372);
  }
  
  private void a(Editable paramEditable, InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(201778);
    boolean bool;
    if (this.Ygi != null)
    {
      bool = this.Ygi.Yhx instanceof InputFilter;
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
          arrayOfInputFilter[(paramArrayOfInputFilter.length + 0)] = ((InputFilter)this.Ygi.Yhx);
        }
        paramEditable.setFilters(arrayOfInputFilter);
        AppMethodBeat.o(201778);
        return;
      }
      paramEditable.setFilters(paramArrayOfInputFilter);
      AppMethodBeat.o(201778);
      return;
    }
  }
  
  private void a(CursorAnchorInfo.Builder paramBuilder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202360);
    int k = this.WoF.getLineForOffset(paramInt1);
    int i2 = this.WoF.getLineForOffset(paramInt2 - 1);
    while (k <= i2)
    {
      int j = this.WoF.getLineStart(k);
      int i = this.WoF.getLineEnd(k);
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
      if (this.WoF.getParagraphDirection(k) == 1)
      {
        m = 1;
        float[] arrayOfFloat = new float[i3 - i1];
        this.WoF.getPaint().getTextWidths(this.WoC, i1, i3, arrayOfFloat);
        f4 = this.WoF.getLineTop(k);
        f5 = this.WoF.getLineBottom(k);
        n = i1;
        if (n >= i3) {
          break label404;
        }
        f3 = arrayOfFloat[(n - i1)];
        bool1 = this.WoF.isRtlCharAt(n);
        f1 = this.WoF.getPrimaryHorizontal(n);
        f2 = this.WoF.getSecondaryHorizontal(n);
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
        boolean bool2 = aF(f1, f3);
        boolean bool3 = aF(f2, f6);
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
    AppMethodBeat.o(202360);
  }
  
  private void a(InputMethodManager paramInputMethodManager)
  {
    AppMethodBeat.i(202514);
    if (paramInputMethodManager != null) {
      paramInputMethodManager.viewClicked(this);
    }
    AppMethodBeat.o(202514);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202212);
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
    AppMethodBeat.o(202212);
  }
  
  private boolean a(ClipData paramClipData)
  {
    AppMethodBeat.i(202471);
    ClipboardManager localClipboardManager = getClipboardManagerForUser();
    try
    {
      localClipboardManager.setPrimaryClip(paramClipData);
      Yfc = SystemClock.uptimeMillis();
      AppMethodBeat.o(202471);
      return true;
    }
    catch (Throwable paramClipData)
    {
      AppMethodBeat.o(202471);
    }
    return false;
  }
  
  private float aE(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202312);
    int i = getHorizontalFadingEdgeLength();
    if (i == 0)
    {
      AppMethodBeat.o(202312);
      return 0.0F;
    }
    paramFloat1 = Math.abs(paramFloat1 - paramFloat2);
    if (paramFloat1 > i)
    {
      AppMethodBeat.o(202312);
      return 1.0F;
    }
    paramFloat1 /= i;
    AppMethodBeat.o(202312);
    return paramFloat1;
  }
  
  private CharSequence aM(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(201727);
    if ((paramCharSequence instanceof Spanned))
    {
      if ((paramCharSequence instanceof Spannable)) {}
      SuggestionSpan[] arrayOfSuggestionSpan;
      for (Spannable localSpannable = (Spannable)paramCharSequence;; localSpannable = this.WoA.newSpannable(paramCharSequence))
      {
        arrayOfSuggestionSpan = (SuggestionSpan[])localSpannable.getSpans(0, paramCharSequence.length(), SuggestionSpan.class);
        if (arrayOfSuggestionSpan.length != 0) {
          break;
        }
        AppMethodBeat.o(201727);
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
    AppMethodBeat.o(201727);
    return paramCharSequence;
  }
  
  private void aZ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201790);
    if ((paramInt1 >= 0) || (paramInt2 >= 0) || (paramInt3 >= 0)) {
      mR(Math.min(Math.min(paramInt1, paramInt2), paramInt3), Math.max(Math.max(paramInt1, paramInt2), paramInt3));
    }
    AppMethodBeat.o(201790);
  }
  
  private static boolean axH(int paramInt)
  {
    return (0x2000F & paramInt) == 131073;
  }
  
  private static boolean axI(int paramInt)
  {
    paramInt &= 0xFFF;
    return (paramInt == 129) || (paramInt == 225) || (paramInt == 18);
  }
  
  private static boolean axJ(int paramInt)
  {
    return (paramInt & 0xFFF) == 145;
  }
  
  private boolean axK(int paramInt)
  {
    AppMethodBeat.i(202156);
    if (isLayoutRequested())
    {
      this.YfO = paramInt;
      AppMethodBeat.o(202156);
      return false;
    }
    if (iar()) {}
    for (Layout localLayout = this.Yfv; localLayout == null; localLayout = this.WoF)
    {
      AppMethodBeat.o(202156);
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
    switch (CustomTextView.5.bne[localLayout.getParagraphAlignment(i3).ordinal()])
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
      if (!this.YfG)
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
                  AppMethodBeat.o(202156);
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
                  long l2 = this.Qh;
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
                    this.Qh = AnimationUtils.currentAnimationTimeMillis();
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
  
  private static int b(Layout paramLayout)
  {
    int k = 0;
    AppMethodBeat.i(202081);
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
        AppMethodBeat.o(202081);
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
    AppMethodBeat.o(202081);
    return i;
  }
  
  private void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202220);
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
    if (this.Ygi != null) {
      this.Ygi.iaZ();
    }
    AppMethodBeat.o(202220);
  }
  
  private <T> T bF(Class<T> paramClass)
  {
    AppMethodBeat.i(202340);
    if ((this.YfT == null) && (Build.VERSION.SDK_INT >= 23))
    {
      paramClass = getContext().getSystemService(paramClass);
      AppMethodBeat.o(202340);
      return paramClass;
    }
    AppMethodBeat.o(202340);
    return null;
  }
  
  private void c(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(202162);
    C(paramRect);
    if (paramInt == 0) {
      paramRect.top -= getExtendedPaddingTop();
    }
    if (paramInt == this.WoF.getLineCount() - 1) {
      paramRect.bottom += getExtendedPaddingBottom();
    }
    AppMethodBeat.o(202162);
  }
  
  private void cR(float paramFloat)
  {
    AppMethodBeat.i(201547);
    if (paramFloat != this.wi.getTextSize())
    {
      this.wi.setTextSize(paramFloat);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201547);
  }
  
  private void cb(int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(201751);
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
        this.YfD = false;
        if (!paramBoolean) {
          break label386;
        }
        iaI();
        this.Ygi.Yhx = ((KeyListener)localObject1);
        AppMethodBeat.o(201751);
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
      if (!this.YfE) {
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
          AppMethodBeat.o(201751);
          return;
        }
      }
      localObject2 = null;
    }
  }
  
  private Locale getCustomLocaleForKeyListenerOrNull()
  {
    AppMethodBeat.i(201742);
    if (!this.YfE)
    {
      AppMethodBeat.o(201742);
      return null;
    }
    Object localObject = getImeHintLocales();
    if (localObject == null)
    {
      AppMethodBeat.o(201742);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = ((LocaleList)localObject).get(0);
      AppMethodBeat.o(201742);
      return localObject;
    }
    AppMethodBeat.o(201742);
    return null;
  }
  
  private int getDesiredHeight()
  {
    boolean bool = true;
    AppMethodBeat.i(202101);
    int i = a(this.WoF, true);
    Layout localLayout = this.Yfv;
    if (this.WoB != null) {}
    for (;;)
    {
      i = Math.max(i, a(localLayout, bool));
      AppMethodBeat.o(202101);
      return i;
      bool = false;
    }
  }
  
  private Layout.Alignment getLayoutAlignment()
  {
    AppMethodBeat.i(202044);
    Layout.Alignment localAlignment = null;
    switch (getTextAlignment())
    {
    default: 
      localAlignment = Layout.Alignment.ALIGN_NORMAL;
    }
    for (;;)
    {
      AppMethodBeat.o(202044);
      return localAlignment;
      switch (this.sK & 0x800007)
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
    AppMethodBeat.i(201874);
    Object localObject2 = null;
    Paint localPaint = this.YfW;
    int j = getSelectionStart();
    int k = getSelectionEnd();
    Object localObject1 = localObject2;
    if (this.Yfw != null) {
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
          if (this.Ygi != null)
          {
            localObject1 = this.Ygi;
            if (!((b)localObject1).iaM()) {
              break label222;
            }
            if (!((b)localObject1).YhA) {
              break label202;
            }
            localObject1 = localObject2;
            if (i != 0)
            {
              if (this.YfX)
              {
                if (this.YfV == null) {
                  this.YfV = new Path();
                }
                this.YfV.reset();
                this.WoF.getCursorPath(j, this.YfV, this.mText);
                this.Ygi.ibf();
                this.YfX = false;
              }
              localPaint.setColor(this.Woy);
              localPaint.setStyle(Paint.Style.STROKE);
            }
          }
        }
      }
    }
    for (localObject1 = this.YfV;; localObject1 = this.YfV)
    {
      AppMethodBeat.o(201874);
      return localObject1;
      label202:
      if ((SystemClock.uptimeMillis() - ((b)localObject1).Yhz) % 1000L < 500L) {
        break;
      }
      label222:
      i = 0;
      break;
      label227:
      if (this.YfX)
      {
        if (this.YfV == null) {
          this.YfV = new Path();
        }
        this.YfV.reset();
        this.WoF.getSelectionPath(j, k, this.YfV);
        this.YfX = false;
      }
      localPaint.setColor(this.rGp);
      localPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private static void h(Spannable paramSpannable)
  {
    int i = 0;
    AppMethodBeat.i(201693);
    SuggestionSpan[] arrayOfSuggestionSpan = (SuggestionSpan[])paramSpannable.getSpans(0, paramSpannable.length(), SuggestionSpan.class);
    while (i < arrayOfSuggestionSpan.length)
    {
      int j = arrayOfSuggestionSpan[i].getFlags();
      if (((j & 0x1) != 0) && ((j & 0x2) != 0)) {
        paramSpannable.removeSpan(arrayOfSuggestionSpan[i]);
      }
      i += 1;
    }
    AppMethodBeat.o(201693);
  }
  
  private void hKs()
  {
    AppMethodBeat.i(202030);
    if (((this.WoF instanceof BoringLayout)) && (this.WoQ == null)) {
      this.WoQ = ((BoringLayout)this.WoF);
    }
    if (((this.Yfv instanceof BoringLayout)) && (this.YfR == null)) {
      this.YfR = ((BoringLayout)this.Yfv);
    }
    this.YfQ = null;
    this.YfP = null;
    if (this.Ygi != null) {
      this.Ygi.iaN();
    }
    AppMethodBeat.o(202030);
  }
  
  private void hKt()
  {
    AppMethodBeat.i(202034);
    int j = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight();
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    if (this.YfG) {}
    for (j = 1048576;; j = i)
    {
      BoringLayout.Metrics localMetrics = Wpg;
      a(j, i, localMetrics, localMetrics, i, false);
      AppMethodBeat.o(202034);
      return;
    }
  }
  
  private boolean iaA()
  {
    if (this.Ygi == null) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (((this.Ygi.IhY & 0xF) != 1) || ((this.Ygi.IhY & 0x80000) > 0));
      i = this.Ygi.IhY & 0xFF0;
    } while ((i != 0) && (i != 48) && (i != 80) && (i != 64) && (i != 160));
    return true;
  }
  
  private void iaI()
  {
    AppMethodBeat.i(202521);
    if (this.Ygi == null) {
      this.Ygi = new b(this);
    }
    AppMethodBeat.o(202521);
  }
  
  private void iaJ()
  {
    AppMethodBeat.i(202525);
    if (!(this.mText instanceof Spannable)) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(202525);
  }
  
  private void iaf()
  {
    AppMethodBeat.i(201395);
    try
    {
      this.Ygi.IhY = this.Ygi.Yhx.getInputType();
      setInputTypeSingleLine(this.Wmc);
      AppMethodBeat.o(201395);
      return;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      for (;;)
      {
        this.Ygi.IhY = 1;
      }
    }
  }
  
  private void iag()
  {
    AppMethodBeat.i(201406);
    if ((this.Yfw != null) || ((this.Ygi != null) && (this.Ygi.Yhx != null)))
    {
      setFocusable(true);
      setClickable(true);
      setLongClickable(true);
      AppMethodBeat.o(201406);
      return;
    }
    setClickable(false);
    setLongClickable(false);
    AppMethodBeat.o(201406);
  }
  
  private void iah()
  {
    AppMethodBeat.i(201472);
    if (this.Yfq == null)
    {
      AppMethodBeat.o(201472);
      return;
    }
    if ((this.Yfq.Ygw) || (this.Yfq.jH))
    {
      ColorStateList localColorStateList = this.Yfq.jE;
      boolean bool = this.Yfq.Ygw;
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.Yfq.Ygu;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = arrayOfDrawable[i];
        if ((localDrawable != null) && (localDrawable != this.Yfq.Ygz))
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
    AppMethodBeat.o(201472);
  }
  
  private void iak()
  {
    AppMethodBeat.i(201798);
    if (!this.Yfk)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.Yfk = true;
    }
    AppMethodBeat.o(201798);
  }
  
  private boolean iam()
  {
    AppMethodBeat.i(201954);
    if (getKeyListener() == null)
    {
      AppMethodBeat.o(201954);
      return false;
    }
    if (this.Wmc)
    {
      AppMethodBeat.o(201954);
      return true;
    }
    if ((this.Ygi != null) && ((this.Ygi.IhY & 0xF) == 1))
    {
      int i = this.Ygi.IhY & 0xFF0;
      if ((i == 32) || (i == 48))
      {
        AppMethodBeat.o(201954);
        return true;
      }
    }
    AppMethodBeat.o(201954);
    return false;
  }
  
  private boolean iap()
  {
    AppMethodBeat.i(202064);
    if ((ial()) || (this.Yfs != null))
    {
      AppMethodBeat.o(202064);
      return true;
    }
    AppMethodBeat.o(202064);
    return false;
  }
  
  private void iaq()
  {
    int k = 1;
    AppMethodBeat.i(202110);
    int i = 0;
    int j = 0;
    if (this.WoF != null)
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
      AppMethodBeat.o(202110);
      return;
      label77:
      i = j;
      if (getLayoutParams().height == -1)
      {
        i = j;
        if (this.WoO >= 0)
        {
          i = j;
          if (getDesiredHeight() != this.WoO)
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
  
  private boolean iar()
  {
    AppMethodBeat.i(202130);
    if ((TextUtils.isEmpty(this.mText)) && (!TextUtils.isEmpty(this.Yfu)))
    {
      AppMethodBeat.o(202130);
      return true;
    }
    AppMethodBeat.o(202130);
    return false;
  }
  
  private void mR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201795);
    if (this.WoF == null)
    {
      invalidate();
      AppMethodBeat.o(201795);
      return;
    }
    int j = this.WoF.getLineForOffset(paramInt1);
    int k = this.WoF.getLineTop(j);
    int i = k;
    if (j > 0) {
      i = k - this.WoF.getLineDescent(j - 1);
    }
    if (paramInt1 == paramInt2)
    {
      paramInt1 = j;
      paramInt2 = this.WoF.getLineBottom(paramInt1);
      if ((this.Ygi == null) || (this.Ygi.YhO == null)) {
        break label210;
      }
      Rect localRect = this.Ygi.YhO.getBounds();
      paramInt1 = Math.min(i, localRect.top);
      paramInt2 = Math.max(paramInt2, localRect.bottom);
    }
    for (;;)
    {
      i = getCompoundPaddingLeft();
      j = getExtendedPaddingTop() + Hs(true);
      k = getWidth();
      int m = getCompoundPaddingRight();
      invalidate(i + getScrollX(), paramInt1 + j, k - m + getScrollY(), paramInt2 + j);
      AppMethodBeat.o(201795);
      return;
      paramInt1 = this.WoF.getLineForOffset(paramInt2);
      break;
      label210:
      paramInt1 = i;
    }
  }
  
  private void p(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(202191);
    this.Wmc = paramBoolean1;
    if (paramBoolean1)
    {
      setLines(1);
      setHorizontallyScrolling(true);
      if (paramBoolean2)
      {
        setTransformationMethod(SingleLineTransformationMethod.getInstance());
        AppMethodBeat.o(202191);
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
    AppMethodBeat.o(202191);
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    int j = 1;
    AppMethodBeat.i(201454);
    Object localObject2 = this.Yfq;
    if (localObject2 != null)
    {
      if (((b)localObject2).Ygx != null) {
        ((b)localObject2).Ygx.setCallback(null);
      }
      ((b)localObject2).Ygx = null;
      if (((b)localObject2).Ygy != null) {
        ((b)localObject2).Ygy.setCallback(null);
      }
      ((b)localObject2).Ygy = null;
      ((b)localObject2).YgG = 0;
      ((b)localObject2).YgE = 0;
      ((b)localObject2).YgH = 0;
      ((b)localObject2).YgF = 0;
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
        if (((b)localObject2).Wpy == 0)
        {
          i = j;
          if (!((b)localObject2).jH)
          {
            if (!((b)localObject2).Ygw) {
              break label221;
            }
            i = j;
          }
        }
        label160:
        if (i != 0) {
          break label227;
        }
        this.Yfq = null;
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      if (localObject1 != null)
      {
        ((b)localObject1).YgA = paramDrawable1;
        ((b)localObject1).YgB = paramDrawable3;
      }
      this.Yfr = -1;
      iah();
      invalidate();
      requestLayout();
      AppMethodBeat.o(201454);
      return;
      i = 0;
      break;
      label221:
      i = 0;
      break label160;
      label227:
      i = ((b)localObject2).Ygu.length - 1;
      while (i >= 0)
      {
        if (localObject2.Ygu[i] != null) {
          localObject2.Ygu[i].setCallback(null);
        }
        ((b)localObject2).Ygu[i] = null;
        i -= 1;
      }
      ((b)localObject2).Wpw = 0;
      ((b)localObject2).Wps = 0;
      ((b)localObject2).Wpx = 0;
      ((b)localObject2).Wpt = 0;
      ((b)localObject2).Wpu = 0;
      ((b)localObject2).Wpq = 0;
      label319:
      ((b)localObject2).Wpv = 0;
      ((b)localObject2).Wpr = 0;
    }
    label338:
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b(getContext());
      this.Yfq = ((b)localObject1);
    }
    this.Yfq.YgD = false;
    if ((localObject1.Ygu[0] != paramDrawable1) && (localObject1.Ygu[0] != null)) {
      localObject1.Ygu[0].setCallback(null);
    }
    ((b)localObject1).Ygu[0] = paramDrawable1;
    if ((localObject1.Ygu[1] != paramDrawable2) && (localObject1.Ygu[1] != null)) {
      localObject1.Ygu[1].setCallback(null);
    }
    ((b)localObject1).Ygu[1] = paramDrawable2;
    if ((localObject1.Ygu[2] != paramDrawable3) && (localObject1.Ygu[2] != null)) {
      localObject1.Ygu[2].setCallback(null);
    }
    ((b)localObject1).Ygu[2] = paramDrawable3;
    if ((localObject1.Ygu[3] != paramDrawable4) && (localObject1.Ygu[3] != null)) {
      localObject1.Ygu[3].setCallback(null);
    }
    ((b)localObject1).Ygu[3] = paramDrawable4;
    Rect localRect = ((b)localObject1).Wpl;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds(localRect);
      paramDrawable1.setCallback(this);
      ((b)localObject1).Wps = localRect.width();
      ((b)localObject1).Wpw = localRect.height();
      label591:
      if (paramDrawable3 == null) {
        break label743;
      }
      paramDrawable3.setState(arrayOfInt);
      paramDrawable3.copyBounds(localRect);
      paramDrawable3.setCallback(this);
      ((b)localObject1).Wpt = localRect.width();
      ((b)localObject1).Wpx = localRect.height();
      label633:
      if (paramDrawable2 == null) {
        break label758;
      }
      paramDrawable2.setState(arrayOfInt);
      paramDrawable2.copyBounds(localRect);
      paramDrawable2.setCallback(this);
      ((b)localObject1).Wpq = localRect.height();
      ((b)localObject1).Wpu = localRect.width();
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
      ((b)localObject1).Wpr = localRect.height();
      ((b)localObject1).Wpv = localRect.width();
      break;
      ((b)localObject1).Wpw = 0;
      ((b)localObject1).Wps = 0;
      break label591;
      label743:
      ((b)localObject1).Wpx = 0;
      ((b)localObject1).Wpt = 0;
      break label633;
      label758:
      ((b)localObject1).Wpu = 0;
      ((b)localObject1).Wpq = 0;
    }
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201720);
    this.Yfu = TextUtils.stringOrSpannedString(paramCharSequence);
    if (this.WoF != null) {
      Ku();
    }
    if (this.mText.length() == 0) {
      invalidate();
    }
    if (this.Ygi != null) {
      this.mText.length();
    }
    AppMethodBeat.o(201720);
  }
  
  private void setInputTypeSingleLine(boolean paramBoolean)
  {
    if ((this.Ygi != null) && ((this.Ygi.IhY & 0xF) == 1))
    {
      if (paramBoolean)
      {
        localb = this.Ygi;
        localb.IhY &= 0xFFFDFFFF;
      }
    }
    else {
      return;
    }
    b localb = this.Ygi;
    localb.IhY |= 0x20000;
  }
  
  private void setKeyListenerOnly(KeyListener paramKeyListener)
  {
    AppMethodBeat.i(201397);
    if ((this.Ygi == null) && (paramKeyListener == null))
    {
      AppMethodBeat.o(201397);
      return;
    }
    iaI();
    if (this.Ygi.Yhx != paramKeyListener)
    {
      this.Ygi.Yhx = paramKeyListener;
      if ((paramKeyListener != null) && (!(this.mText instanceof Editable))) {
        setText(this.mText);
      }
      a((Editable)this.mText, this.YfS);
    }
    AppMethodBeat.o(201397);
  }
  
  private void setTextInternal(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if ((paramCharSequence instanceof Spannable)) {}
    for (paramCharSequence = (Spannable)paramCharSequence;; paramCharSequence = null)
    {
      this.Yfs = paramCharSequence;
      return;
    }
  }
  
  private void setTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(201381);
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
        paramTypeface = this.wi;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.wi;
        if ((paramInt & 0x2) == 0) {
          break label106;
        }
      }
      label100:
      label106:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        AppMethodBeat.o(201381);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label37;
      }
    }
    this.wi.setFakeBoldText(false);
    this.wi.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
    AppMethodBeat.o(201381);
  }
  
  private void updateTextColors()
  {
    AppMethodBeat.i(201675);
    int[] arrayOfInt = getDrawableState();
    int i = this.Hkc.getColorForState(arrayOfInt, 0);
    if (i != this.Woy) {
      this.Woy = i;
    }
    for (int j = 1;; j = 0)
    {
      i = j;
      int k;
      if (this.Yfe != null)
      {
        k = this.Yfe.getColorForState(arrayOfInt, 0);
        i = j;
        if (k != this.wi.linkColor)
        {
          this.wi.linkColor = k;
          i = 1;
        }
      }
      j = i;
      if (this.Yfd != null)
      {
        k = this.Yfd.getColorForState(arrayOfInt, 0);
        j = i;
        if (k != this.Yff)
        {
          this.Yff = k;
          j = i;
          if (this.mText.length() == 0) {
            j = 1;
          }
        }
      }
      if (j != 0) {
        invalidate();
      }
      AppMethodBeat.o(201675);
      return;
    }
  }
  
  final int B(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(202482);
    paramFloat = cS(paramFloat);
    paramInt = getLayout().getOffsetForHorizontal(paramInt, paramFloat);
    AppMethodBeat.o(202482);
    return paramInt;
  }
  
  final int Hs(boolean paramBoolean)
  {
    AppMethodBeat.i(201782);
    int j = 0;
    int k = this.sK & 0x70;
    Layout localLayout2 = this.WoF;
    Layout localLayout1 = localLayout2;
    if (!paramBoolean)
    {
      localLayout1 = localLayout2;
      if (this.mText.length() == 0)
      {
        localLayout1 = localLayout2;
        if (this.Yfv != null) {
          localLayout1 = this.Yfv;
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
      AppMethodBeat.o(201782);
      return i;
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201366);
    Log.i("cmEdit.CMTextView", "init");
    setTextInternal("");
    Object localObject1 = getResources();
    this.wi = new TextPaint(1);
    this.wi.density = ((Resources)localObject1).getDisplayMetrics().density;
    this.YfW = new Paint(1);
    this.Yfw = getDefaultMovementMethod();
    this.Yfx = null;
    d locald = new d((byte)0);
    locald.Hkc = ColorStateList.valueOf(-16777216);
    locald.pyF = aw.fromDPToPix(getContext(), 18);
    this.Mh = 0;
    this.Mi = 0;
    this.YfJ = 0;
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
        this.YfH = localTypedArray.getInt(i5, 0);
        localObject2 = paramAttributeSet;
        paramAttributeSet = (AttributeSet)localObject1;
        localObject1 = localObject2;
      }
      else if (i5 == a.m.MMNewTextView_android_linksClickable)
      {
        this.YfI = localTypedArray.getBoolean(i5, true);
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
                  this.Yfg = localTypedArray.getBoolean(i5, false);
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
                  this.WoH = localTypedArray.getDimensionPixelSize(i5, (int)this.WoH);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_lineSpacingMultiplier)
                {
                  this.WoG = localTypedArray.getFloat(i5, this.WoG);
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
                  iaI();
                  this.Ygi.Yhh = localTypedArray.getBoolean(i5, true);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeOptions)
                {
                  iaI();
                  this.Ygi.iaL();
                  this.Ygi.Yhs.nlD = localTypedArray.getInt(i5, this.Ygi.Yhs.nlD);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeActionLabel)
                {
                  iaI();
                  this.Ygi.iaL();
                  this.Ygi.Yhs.YiY = localTypedArray.getText(i5);
                  localObject2 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_imeActionId)
                {
                  iaI();
                  this.Ygi.iaL();
                  this.Ygi.Yhs.YiZ = localTypedArray.getInt(i5, this.Ygi.Yhs.YiZ);
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
                  this.YfY = localTypedArray.getResourceId(i5, 16843618);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandleLeft)
                {
                  this.Yga = localTypedArray.getResourceId(i5, 16843461);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandleRight)
                {
                  this.Ygc = localTypedArray.getResourceId(i5, 16843462);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_textSelectHandle)
                {
                  this.Yge = localTypedArray.getResourceId(i5, 16843463);
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
                  this.Mh = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_hyphenationFrequency)
                {
                  this.Mi = localTypedArray.getInt(i5, 0);
                  localObject3 = paramAttributeSet;
                  paramAttributeSet = (AttributeSet)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (i5 == a.m.MMNewTextView_android_justificationMode)
                {
                  this.YfJ = localTypedArray.getInt(i5, 0);
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
                    this.YfE = bool7;
                    if (i6 < 28) {
                      break label3813;
                    }
                    bool7 = true;
                    this.YfF = bool7;
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
                    AppMethodBeat.o(201366);
                    label3795:
                    label3801:
                    throw paramContext;
                  }
                  try
                  {
                    iaI();
                    this.Ygi.Yhx = ((KeyListener)((Class)localObject4).newInstance());
                  }
                  catch (InstantiationException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(201366);
                    throw paramContext;
                  }
                  catch (IllegalAccessException paramContext)
                  {
                    paramContext = new RuntimeException(paramContext);
                    AppMethodBeat.o(201366);
                    throw paramContext;
                  }
                  try
                  {
                    localObject4 = this.Ygi;
                    if (paramInt2 == 0) {
                      break label3873;
                    }
                    ((b)localObject4).IhY = paramInt2;
                  }
                  catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
                  {
                    this.Ygi.IhY = 1;
                    break label2646;
                  }
                  if (this.Ygi != null)
                  {
                    localObject4 = this.Ygi;
                    if ((((b)localObject4).IhY & 0xF) != 1) {
                      break label4276;
                    }
                    if ((bool3) || (i3 != 0)) {
                      ((b)localObject4).IhY = (((b)localObject4).IhY & 0xFFFFF00F | 0x80);
                    }
                    if (i4 != 0) {
                      ((b)localObject4).IhY = (((b)localObject4).IhY & 0xFFFFF00F | 0xE0);
                    }
                  }
                  if (bool2)
                  {
                    iaI();
                    this.Ygi.YhD = true;
                    if (localObject3 == TextView.BufferType.NORMAL) {
                      localObject3 = TextView.BufferType.SPANNABLE;
                    }
                  }
                  for (;;)
                  {
                    if (localColorStateList != null)
                    {
                      if (this.Yfq == null) {
                        this.Yfq = new b(paramContext);
                      }
                      if (localColorStateList != null)
                      {
                        this.Yfq.jE = localColorStateList;
                        this.Yfq.Ygw = true;
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
                        localObject4 = this.Yfq;
                        paramContext = (Context)localObject4;
                        if (localObject4 == null)
                        {
                          paramContext = new b(getContext());
                          this.Yfq = paramContext;
                        }
                        this.Yfq.YgD = true;
                        localObject4 = paramContext.Wpl;
                        localObject6 = getDrawableState();
                        if (localDrawable1 == null) {
                          break label4319;
                        }
                        localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
                        localDrawable1.setState((int[])localObject6);
                        localDrawable1.copyBounds((Rect)localObject4);
                        localDrawable1.setCallback(this);
                        paramContext.Ygx = localDrawable1;
                        paramContext.YgE = ((Rect)localObject4).width();
                        paramContext.YgG = ((Rect)localObject4).height();
                        if (localDrawable2 == null) {
                          break label4332;
                        }
                        localDrawable2.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
                        localDrawable2.setState((int[])localObject6);
                        localDrawable2.copyBounds((Rect)localObject4);
                        localDrawable2.setCallback(this);
                        paramContext.Ygy = localDrawable2;
                        paramContext.YgF = ((Rect)localObject4).width();
                        paramContext.YgH = ((Rect)localObject4).height();
                        this.Yfr = -1;
                        iah();
                      }
                      setCompoundDrawablePadding(n);
                      setInputTypeSingleLine(bool1);
                      p(bool1, bool1, bool1);
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
                          if ((paramInt2 == 0) && ((this.Ygi == null) || ((this.Ygi.IhY & 0xFFF) != 129))) {
                            break label4381;
                          }
                          i = 1;
                          if (i != 0) {
                            locald.YgS = 3;
                          }
                          if (locald.Hkc != null) {
                            setTextColor(locald.Hkc);
                          }
                          if (locald.YgO != null) {
                            setHintTextColor(locald.YgO);
                          }
                          if (locald.YgP != null) {
                            setLinkTextColor(locald.YgP);
                          }
                          if (locald.YgN != 0) {
                            setHighlightColor(locald.YgN);
                          }
                          if (locald.pyF != -1)
                          {
                            this.YfC = locald.YfC;
                            cR(locald.pyF);
                          }
                          if (locald.YgQ != null) {
                            setTextLocales(locald.YgQ);
                          }
                          if ((locald.YgS != -1) && (!locald.YgR)) {
                            locald.nUv = null;
                          }
                          a(locald.rC, locald.nUv, locald.YgS, locald.YgT, locald.YgU);
                          if (locald.raH != 0)
                          {
                            float f1 = locald.Yfh;
                            float f2 = locald.Yfi;
                            float f3 = locald.Yfj;
                            i = locald.raH;
                            this.wi.setShadowLayer(f1, f2, f3, i);
                            this.Yfh = f1;
                            this.Yfi = f2;
                            this.Yfj = f3;
                            this.raH = i;
                            if (this.Ygi != null) {
                              this.Ygi.ibe();
                            }
                            invalidate();
                          }
                          if (locald.YgW) {
                            setElegantTextHeight(locald.YgX);
                          }
                          if (locald.YgY) {
                            setFallbackLineSpacing(locald.YgZ);
                          }
                          if (locald.Yha) {
                            setLetterSpacing(locald.Yhb);
                          }
                          if (locald.Yhc != null) {
                            setFontFeatureSettings(locald.Yhc);
                          }
                          if (locald.Yhd != null)
                          {
                            paramContext = locald.Yhd;
                            if (Build.VERSION.SDK_INT >= 26)
                            {
                              localObject4 = this.wi.getFontVariationSettings();
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
                      if (this.WoC == null) {
                        this.WoC = "";
                      }
                      if (localObject1 != null) {
                        setHint((CharSequence)localObject1);
                      }
                      setClickable(true);
                      setLongClickable(true);
                      if (this.Ygi != null) {
                        this.Ygi.iaN();
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
                      AppMethodBeat.o(201366);
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
                      paramInt2 = this.Ygi.Yhx.getInputType();
                      break label2639;
                      Object localObject5;
                      if (localCharSequence != null)
                      {
                        iaI();
                        this.Ygi.Yhx = DigitsKeyListener.getInstance(localCharSequence.toString());
                        localObject5 = this.Ygi;
                        if (paramInt2 != 0) {}
                        for (;;)
                        {
                          ((b)localObject5).IhY = paramInt2;
                          break;
                          paramInt2 = 1;
                        }
                      }
                      if (paramInt2 != 0)
                      {
                        cb(paramInt2, true);
                        if (!axH(paramInt2)) {}
                        for (bool1 = true;; bool1 = false) {
                          break;
                        }
                      }
                      if (bool5)
                      {
                        iaI();
                        this.Ygi.Yhx = DialerKeyListener.getInstance();
                        this.Ygi.IhY = 3;
                        break label2646;
                      }
                      if (i2 != 0)
                      {
                        iaI();
                        this.Ygi.Yhx = DigitsKeyListener.getInstance();
                        paramInt2 = this.Ygi.Yhx.getInputType();
                        this.Ygi.IhY = paramInt2;
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
                          iaI();
                          this.Ygi.Yhx = TextKeyListener.getInstance(bool6, (TextKeyListener.Capitalize)localObject5);
                          this.Ygi.IhY = paramInt2;
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
                        iaI();
                        this.Ygi.Yhx = TextKeyListener.getInstance();
                        this.Ygi.IhY = 1;
                        break label2646;
                      }
                      if (ial())
                      {
                        if (this.Ygi != null)
                        {
                          this.Ygi.Yhx = null;
                          this.Ygi.IhY = 0;
                        }
                        localObject3 = TextView.BufferType.SPANNABLE;
                        setMovementMethod(com.tencent.mm.ui.widget.cedit.b.a.ibX());
                        break label2646;
                      }
                      if (this.Ygi != null) {
                        this.Ygi.Yhx = null;
                      }
                      localObject3 = TextView.BufferType.NORMAL;
                      break label2646;
                      if (((((b)localObject5).IhY & 0xF) != 2) || (i5 == 0)) {
                        break label2722;
                      }
                      ((b)localObject5).IhY = (((b)localObject5).IhY & 0xFFFFF00F | 0x10);
                      break label2722;
                      paramInt2 = 0;
                      break label2911;
                      label4319:
                      paramContext.YgG = 0;
                      paramContext.YgE = 0;
                      break label3034;
                      label4332:
                      paramContext.YgH = 0;
                      paramContext.YgF = 0;
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
                      if ((!this.wi.setFontVariationSettings(paramContext)) || (this.WoF == null)) {
                        break label3634;
                      }
                      hKs();
                      requestLayout();
                      invalidate();
                      break label3634;
                      label4420:
                      setFilters(YeZ);
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
    AppMethodBeat.i(202254);
    b.h localh;
    int j;
    if (this.Ygi == null)
    {
      localh = null;
      if (paramObject != Selection.SELECTION_END) {
        break label503;
      }
      if ((paramInt1 >= 0) || (paramInt2 >= 0))
      {
        aZ(Selection.getSelectionStart(paramSpanned), paramInt1, paramInt2);
        iaq();
        iak();
        if (this.Ygi != null) {
          this.Ygi.ibx();
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
          aZ(Selection.getSelectionEnd(paramSpanned), paramInt1, paramInt2);
        }
        i = paramInt2;
        m = 1;
        k = i;
      }
      if (m != 0)
      {
        this.YfX = true;
        if ((this.Ygi != null) && (!isFocused())) {
          this.Ygi.Yhv = true;
        }
        if ((paramSpanned.getSpanFlags(paramObject) & 0x200) == 0)
        {
          if (k < 0) {
            Selection.getSelectionStart(paramSpanned);
          }
          if (j < 0) {
            Selection.getSelectionEnd(paramSpanned);
          }
          if (this.Ygi != null)
          {
            this.Ygi.ibg();
            if ((!iau()) && (this.Ygi.ibk()) && (hasTransientState())) {
              setHasTransientState(false);
            }
          }
          sendAccessibilityEvent(8192);
        }
      }
      if (((paramObject instanceof UpdateAppearance)) || ((paramObject instanceof ParagraphStyle)) || ((paramObject instanceof CharacterStyle)))
      {
        if ((localh != null) && (localh.Yhf != 0)) {
          break label472;
        }
        invalidate();
        this.YfX = true;
        iaq();
        label280:
        if (this.Ygi != null) {
          this.Ygi.ibe();
        }
      }
      if (MetaKeyKeyListener.isMetaTracker(paramSpanned, paramObject))
      {
        this.YfX = true;
        if ((localh != null) && (MetaKeyKeyListener.isSelectingMetaTracker(paramSpanned, paramObject))) {
          localh.Yjg = true;
        }
        if (Selection.getSelectionStart(paramSpanned) >= 0)
        {
          if ((localh != null) && (localh.Yhf != 0)) {
            break label481;
          }
          iaj();
        }
      }
      for (;;)
      {
        if (((paramObject instanceof ParcelableSpan)) && (localh != null) && (localh.Yjd != null))
        {
          if (localh.Yhf != 0)
          {
            if (paramInt1 >= 0)
            {
              if (localh.Yjh > paramInt1) {
                localh.Yjh = paramInt1;
              }
              if (localh.Yjh > paramInt3) {
                localh.Yjh = paramInt3;
              }
            }
            if (paramInt2 < 0) {
              break label496;
            }
            if (localh.Yjh > paramInt2) {
              localh.Yjh = paramInt2;
            }
            if (localh.Yjh <= paramInt4) {
              break label496;
            }
            localh.Yjh = paramInt4;
            AppMethodBeat.o(202254);
            return;
            localh = this.Ygi.Yht;
            break;
            label472:
            localh.mContentChanged = true;
            break label280;
            label481:
            localh.Yjf = true;
            continue;
          }
          localh.mContentChanged = true;
        }
      }
      label496:
      AppMethodBeat.o(202254);
      return;
      label503:
      j = -1;
    }
  }
  
  protected void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(201714);
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = (CharSequence)localObject;
    if (!iaA()) {
      paramCharSequence = aM((CharSequence)localObject);
    }
    if (!this.YfA) {
      this.wi.setTextScaleX(1.0F);
    }
    int j = this.YfS.length;
    int i = 0;
    localObject = paramCharSequence;
    while (i < j)
    {
      paramCharSequence = this.YfS[i].filter((CharSequence)localObject, 0, ((CharSequence)localObject).length(), Yfa, 0, 0);
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
        iaI();
        localObject = this.Woz.newEditable((CharSequence)localObject);
        a((Editable)localObject, this.YfS);
        InputMethodManager localInputMethodManager = getInputMethodManager();
        paramCharSequence = (CharSequence)localObject;
        if (localInputMethodManager != null)
        {
          localInputMethodManager.restartInput(this);
          paramCharSequence = (CharSequence)localObject;
        }
        label249:
        if (this.YfH == 0) {
          break label731;
        }
        if ((paramBufferType != TextView.BufferType.EDITABLE) && (!(paramCharSequence instanceof Spannable))) {
          break label500;
        }
        localObject = (Spannable)paramCharSequence;
        if (!Linkify.addLinks((Spannable)localObject, this.YfH)) {
          break label731;
        }
        if (paramBufferType != TextView.BufferType.EDITABLE) {
          break label513;
        }
        paramCharSequence = TextView.BufferType.EDITABLE;
        setTextInternal((CharSequence)localObject);
        if ((this.YfI) && (!iaz())) {
          setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.ibX());
        }
        paramBufferType = paramCharSequence;
        paramCharSequence = (CharSequence)localObject;
      }
      for (;;)
      {
        this.Yft = paramBufferType;
        setTextInternal(paramCharSequence);
        if (this.Yfx == null) {}
        int k;
        for (this.WoC = paramCharSequence;; this.WoC = this.Yfx.getTransformation(paramCharSequence, this))
        {
          if (this.WoC == null) {
            this.WoC = "";
          }
          k = paramCharSequence.length();
          if ((!(paramCharSequence instanceof Spannable)) || (this.Yfy)) {
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
            if (this.Yfw == null) {
              break label249;
            }
          }
          paramCharSequence = this.WoA.newSpannable((CharSequence)localObject);
          break label249;
          label500:
          localObject = this.WoA.newSpannable(paramCharSequence);
          break label276;
          paramCharSequence = TextView.BufferType.SPANNABLE;
          break label299;
        }
        if (this.Yfz == null) {
          this.Yfz = new a((byte)0);
        }
        paramBufferType.setSpan(this.Yfz, 0, k, 6553618);
        if (this.Ygi != null)
        {
          localObject = this.Ygi;
          j = paramBufferType.length();
          if (((b)localObject).Yhx != null) {
            paramBufferType.setSpan(((b)localObject).Yhx, 0, j, 18);
          }
        }
        if (this.Yfx != null) {
          paramBufferType.setSpan(this.Yfx, 0, k, 18);
        }
        if (this.Yfw != null)
        {
          this.Yfw.j((Spannable)paramCharSequence);
          if (this.Ygi != null) {
            this.Ygi.Yhv = false;
          }
        }
        if (this.WoF != null) {
          Ku();
        }
        b(paramCharSequence, 0, i, k);
        if (paramInt != 0) {
          e((Editable)paramCharSequence);
        }
        if (this.Ygi != null) {
          this.Ygi.iaN();
        }
        AppMethodBeat.o(201714);
        return;
      }
    }
  }
  
  public final boolean a(ExtractedTextRequest paramExtractedTextRequest, ExtractedText paramExtractedText)
  {
    AppMethodBeat.i(202001);
    iaI();
    boolean bool = this.Ygi.a(paramExtractedTextRequest, -1, -1, -1, paramExtractedText);
    AppMethodBeat.o(202001);
    return bool;
  }
  
  public final boolean aF(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202374);
    for (;;)
    {
      synchronized (YeY)
      {
        float[] arrayOfFloat2 = YeY;
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
            AppMethodBeat.o(202374);
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
          AppMethodBeat.o(202374);
          return true;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public final int aG(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202474);
    if (getLayout() == null)
    {
      AppMethodBeat.o(202474);
      return -1;
    }
    int i = B(cT(paramFloat2), paramFloat1);
    AppMethodBeat.o(202474);
    return i;
  }
  
  public void addExtraDataToAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(202356);
    if ((paramBundle != null) && (paramString.equals("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")))
    {
      int j = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
      int k = paramBundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
      if ((k <= 0) || (j < 0) || (j >= this.mText.length()))
      {
        Log.e("cmEdit.CMTextView", "Invalid arguments for accessibility character locations");
        AppMethodBeat.o(202356);
        return;
      }
      paramBundle = new RectF[k];
      Object localObject = new CursorAnchorInfo.Builder();
      a((CursorAnchorInfo.Builder)localObject, j, j + k, ias(), iat());
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
      AppMethodBeat.o(202356);
      return;
    }
    AppMethodBeat.o(202356);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(202205);
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    this.mListeners.add(paramTextWatcher);
    AppMethodBeat.o(202205);
  }
  
  public final void append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201671);
    int i = paramCharSequence.length();
    if (!(this.mText instanceof Editable)) {
      setText(this.mText, TextView.BufferType.EDITABLE);
    }
    ((Editable)this.mText).append(paramCharSequence, 0, i);
    if ((this.YfH != 0) && (Linkify.addLinks(this.Yfs, this.YfH)) && (this.YfI) && (!iaz())) {
      setMovementMethod(com.tencent.mm.ui.widget.cedit.b.c.ibX());
    }
    AppMethodBeat.o(201671);
  }
  
  public void autofill(AutofillValue paramAutofillValue)
  {
    AppMethodBeat.i(202348);
    if ((Build.VERSION.SDK_INT >= 26) && ((!paramAutofillValue.isText()) || (!iaw())))
    {
      Log.w("cmEdit.CMTextView", paramAutofillValue + " could not be autofilled into " + this);
      AppMethodBeat.o(202348);
      return;
    }
    CharSequence localCharSequence = null;
    if (Build.VERSION.SDK_INT >= 26) {
      localCharSequence = paramAutofillValue.getTextValue();
    }
    a(localCharSequence, this.Yft, true, 0);
    paramAutofillValue = getText();
    if ((paramAutofillValue instanceof Spannable)) {
      Selection.setSelection((Spannable)paramAutofillValue, paramAutofillValue.length());
    }
    AppMethodBeat.o(202348);
  }
  
  public final void axL(int paramInt)
  {
    AppMethodBeat.i(202438);
    if (this.Ygi != null) {
      this.Ygi.axL(paramInt);
    }
    AppMethodBeat.o(202438);
  }
  
  final boolean b(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(202284);
    boolean bool1;
    if (this.Ygg == -1)
    {
      this.Ygg = paramMotionEvent.getPointerId(0);
      this.Ygh = paramBoolean;
      bool1 = true;
    }
    for (;;)
    {
      if ((paramMotionEvent.getActionMasked() == 1) || (paramMotionEvent.getActionMasked() == 3)) {
        this.Ygg = -1;
      }
      AppMethodBeat.o(202284);
      return bool1;
      if (this.Ygg != paramMotionEvent.getPointerId(0))
      {
        bool1 = bool2;
        if (this.Ygh)
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
  
  final void c(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202233);
    Yfc = 0L;
    b.h localh;
    if (this.Ygi == null)
    {
      localh = null;
      if ((localh == null) || (localh.Yhf == 0)) {
        iav();
      }
      if (localh != null)
      {
        localh.mContentChanged = true;
        if (localh.Yjh >= 0) {
          break label113;
        }
        localh.Yjh = paramInt1;
      }
    }
    for (localh.Yji = (paramInt1 + paramInt2);; localh.Yji = Math.max(localh.Yji, paramInt1 + paramInt2 - localh.Yjj))
    {
      localh.Yjj += paramInt3 - paramInt2;
      b(paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(202233);
      return;
      localh = this.Ygi.Yht;
      break;
      label113:
      localh.Yjh = Math.min(localh.Yjh, paramInt1);
    }
  }
  
  final float cS(float paramFloat)
  {
    AppMethodBeat.i(202478);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingLeft());
    paramFloat = Math.min(getWidth() - getTotalPaddingRight() - 1, paramFloat);
    float f = getScrollX();
    AppMethodBeat.o(202478);
    return paramFloat + f;
  }
  
  final int cT(float paramFloat)
  {
    AppMethodBeat.i(202481);
    paramFloat = Math.max(0.0F, paramFloat - getTotalPaddingTop());
    paramFloat = Math.min(getHeight() - getTotalPaddingBottom() - 1, paramFloat);
    float f = getScrollY();
    int i = getLayout().getLineForVertical((int)(paramFloat + f));
    AppMethodBeat.o(202481);
    return i;
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(202306);
    super.cancelLongPress();
    if (this.Ygi != null) {
      this.Ygi.Xlf = true;
    }
    AppMethodBeat.o(202306);
  }
  
  public void clearComposingText()
  {
    AppMethodBeat.i(202278);
    if ((this.mText instanceof Spannable)) {
      BaseInputConnection.removeComposingSpans(this.Yfs);
    }
    AppMethodBeat.o(202278);
  }
  
  protected int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(202313);
    if (this.WoF != null)
    {
      if ((this.Wmc) && ((this.sK & 0x7) == 3))
      {
        i = (int)this.WoF.getLineWidth(0);
        AppMethodBeat.o(202313);
        return i;
      }
      i = this.WoF.getWidth();
      AppMethodBeat.o(202313);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    AppMethodBeat.o(202313);
    return i;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(202158);
    if ((this.mScroller != null) && (this.mScroller.computeScrollOffset())) {
      postInvalidate();
    }
    AppMethodBeat.o(202158);
  }
  
  protected int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(202316);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    AppMethodBeat.o(202316);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    AppMethodBeat.i(202314);
    if (this.WoF != null)
    {
      i = this.WoF.getHeight();
      AppMethodBeat.o(202314);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    AppMethodBeat.o(202314);
    return i;
  }
  
  protected boolean dC()
  {
    return true;
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201683);
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.Yfq != null)
    {
      Drawable[] arrayOfDrawable = this.Yfq.Ygu;
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
    AppMethodBeat.o(201683);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(201679);
    super.drawableStateChanged();
    if (((this.Hkc != null) && (this.Hkc.isStateful())) || ((this.Yfd != null) && (this.Yfd.isStateful())) || ((this.Yfe != null) && (this.Yfe.isStateful()))) {
      updateTextColors();
    }
    if (this.Yfq != null)
    {
      int[] arrayOfInt = getDrawableState();
      Drawable[] arrayOfDrawable = this.Yfq.Ygu;
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
    AppMethodBeat.o(201679);
  }
  
  final void e(Editable paramEditable)
  {
    AppMethodBeat.i(202224);
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
    AppMethodBeat.o(202224);
  }
  
  public void findViewsWithText(ArrayList<View> paramArrayList, CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(202318);
    super.findViewsWithText(paramArrayList, paramCharSequence, paramInt);
    if ((!paramArrayList.contains(this)) && ((paramInt & 0x1) != 0) && (!TextUtils.isEmpty(paramCharSequence)) && (!TextUtils.isEmpty(this.mText)))
    {
      paramCharSequence = paramCharSequence.toString().toLowerCase();
      if (this.mText.toString().toLowerCase().contains(paramCharSequence)) {
        paramArrayList.add(this);
      }
    }
    AppMethodBeat.o(202318);
  }
  
  public View focusSearch(int paramInt)
  {
    AppMethodBeat.i(201987);
    try
    {
      View localView = super.focusSearch(paramInt);
      AppMethodBeat.o(201987);
      return localView;
    }
    catch (Throwable localThrowable)
    {
      Log.e("cmEdit.CMTextView", "focusSearch err", new Object[] { localThrowable });
      AppMethodBeat.o(201987);
    }
    return null;
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(202345);
    String str = CustomTextView.class.getName();
    AppMethodBeat.o(202345);
    return str;
  }
  
  public int getAccessibilitySelectionEnd()
  {
    AppMethodBeat.i(202532);
    int i = getSelectionEnd();
    AppMethodBeat.o(202532);
    return i;
  }
  
  public int getAccessibilitySelectionStart()
  {
    AppMethodBeat.i(202530);
    int i = getSelectionStart();
    AppMethodBeat.o(202530);
    return i;
  }
  
  public TextView getAdaptText()
  {
    return this.Ygk;
  }
  
  public int getAutofillType()
  {
    AppMethodBeat.i(202350);
    if (iaw())
    {
      AppMethodBeat.o(202350);
      return 1;
    }
    AppMethodBeat.o(202350);
    return 0;
  }
  
  public AutofillValue getAutofillValue()
  {
    AppMethodBeat.i(202352);
    if (iaw())
    {
      Object localObject = com.tencent.mm.ui.widget.cedit.util.c.p(getText(), 100000);
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = AutofillValue.forText((CharSequence)localObject);
        AppMethodBeat.o(202352);
        return localObject;
      }
    }
    AppMethodBeat.o(202352);
    return null;
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(201918);
    if (this.WoF == null)
    {
      i = super.getBaseline();
      AppMethodBeat.o(201918);
      return i;
    }
    int i = getBaselineOffset();
    int j = this.WoF.getLineBaseline(0);
    AppMethodBeat.o(201918);
    return i + j;
  }
  
  int getBaselineOffset()
  {
    AppMethodBeat.i(201920);
    int i = 0;
    if ((this.sK & 0x70) != 48) {
      i = Hs(true);
    }
    int j = getExtendedPaddingTop();
    AppMethodBeat.o(201920);
    return i + j;
  }
  
  protected int getBottomPaddingOffset()
  {
    AppMethodBeat.i(201827);
    int i = (int)Math.max(0.0F, this.Yfj + this.Yfh);
    AppMethodBeat.o(201827);
    return i;
  }
  
  final ClipboardManager getClipboardManagerForUser()
  {
    AppMethodBeat.i(202335);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getContext().getPackageName();
      localClipboardManager = (ClipboardManager)bF(ClipboardManager.class);
      AppMethodBeat.o(202335);
      return localClipboardManager;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)getContext().getSystemService("clipboard");
    AppMethodBeat.o(202335);
    return localClipboardManager;
  }
  
  public int getCompoundDrawablePadding()
  {
    b localb = this.Yfq;
    if (localb != null) {
      return localb.Wpy;
    }
    return 0;
  }
  
  public BlendMode getCompoundDrawableTintBlendMode()
  {
    if (this.Yfq != null) {
      return this.Yfq.Ygv;
    }
    return null;
  }
  
  public ColorStateList getCompoundDrawableTintList()
  {
    if (this.Yfq != null) {
      return this.Yfq.jE;
    }
    return null;
  }
  
  public PorterDuff.Mode getCompoundDrawableTintMode()
  {
    return null;
  }
  
  public Drawable[] getCompoundDrawables()
  {
    AppMethodBeat.i(201456);
    Object localObject = this.Yfq;
    if (localObject != null)
    {
      localObject = (Drawable[])((b)localObject).Ygu.clone();
      AppMethodBeat.o(201456);
      return localObject;
    }
    AppMethodBeat.o(201456);
    return new Drawable[] { null, null, null, null };
  }
  
  public Drawable[] getCompoundDrawablesRelative()
  {
    b localb = this.Yfq;
    if (localb != null) {
      return new Drawable[] { localb.Ygx, localb.Ygu[1], localb.Ygy, localb.Ygu[3] };
    }
    return new Drawable[] { null, null, null, null };
  }
  
  public int getCompoundPaddingBottom()
  {
    AppMethodBeat.i(201412);
    b localb = this.Yfq;
    if ((localb == null) || (localb.Ygu[3] == null))
    {
      i = getPaddingBottom();
      AppMethodBeat.o(201412);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.Wpy;
    int k = localb.Wpr;
    AppMethodBeat.o(201412);
    return k + (i + j);
  }
  
  public int getCompoundPaddingEnd()
  {
    AppMethodBeat.i(201418);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingRight();
      AppMethodBeat.o(201418);
      return i;
    }
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(201418);
    return i;
  }
  
  public int getCompoundPaddingLeft()
  {
    AppMethodBeat.i(201413);
    b localb = this.Yfq;
    if ((localb == null) || (localb.Ygu[0] == null))
    {
      i = getPaddingLeft();
      AppMethodBeat.o(201413);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.Wpy;
    int k = localb.Wps;
    AppMethodBeat.o(201413);
    return k + (i + j);
  }
  
  public int getCompoundPaddingRight()
  {
    AppMethodBeat.i(201414);
    b localb = this.Yfq;
    if ((localb == null) || (localb.Ygu[2] == null))
    {
      i = getPaddingRight();
      AppMethodBeat.o(201414);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.Wpy;
    int k = localb.Wpt;
    AppMethodBeat.o(201414);
    return k + (i + j);
  }
  
  public int getCompoundPaddingStart()
  {
    AppMethodBeat.i(201416);
    switch (getLayoutDirection())
    {
    default: 
      i = getCompoundPaddingLeft();
      AppMethodBeat.o(201416);
      return i;
    }
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(201416);
    return i;
  }
  
  public int getCompoundPaddingTop()
  {
    AppMethodBeat.i(201411);
    b localb = this.Yfq;
    if ((localb == null) || (localb.Ygu[1] == null))
    {
      i = getPaddingTop();
      AppMethodBeat.o(201411);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.Wpy;
    int k = localb.Wpq;
    AppMethodBeat.o(201411);
    return k + (i + j);
  }
  
  public final int getCurrentHintTextColor()
  {
    if (this.Yfd != null) {
      return this.Yff;
    }
    return this.Woy;
  }
  
  public final int getCurrentTextColor()
  {
    return this.Woy;
  }
  
  public ActionMode.Callback getCustomInsertionActionModeCallback()
  {
    if (this.Ygi == null) {
      return null;
    }
    return this.Ygi.YhW;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    if (this.Ygi == null) {
      return null;
    }
    return this.Ygi.YhV;
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
    return this.Ygi;
  }
  
  @ViewDebug.ExportedProperty
  public TextUtils.TruncateAt getEllipsize()
  {
    return this.WoB;
  }
  
  public int getExtendedPaddingBottom()
  {
    AppMethodBeat.i(201430);
    if (this.WoJ != 1)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(201430);
      return i;
    }
    if (this.WoF == null) {
      hKt();
    }
    if (this.WoF.getLineCount() <= this.WoI)
    {
      i = getCompoundPaddingBottom();
      AppMethodBeat.o(201430);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.WoF.getLineTop(this.WoI);
    if (k >= j)
    {
      AppMethodBeat.o(201430);
      return i;
    }
    int m = this.sK & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(201430);
      return i + j - k;
    }
    if (m == 80)
    {
      AppMethodBeat.o(201430);
      return i;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(201430);
    return i + j;
  }
  
  public int getExtendedPaddingTop()
  {
    AppMethodBeat.i(201423);
    if (this.WoJ != 1)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(201423);
      return i;
    }
    if (this.WoF == null) {
      hKt();
    }
    if (this.WoF.getLineCount() <= this.WoI)
    {
      i = getCompoundPaddingTop();
      AppMethodBeat.o(201423);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.WoF.getLineTop(this.WoI);
    if (k >= j)
    {
      AppMethodBeat.o(201423);
      return i;
    }
    int m = this.sK & 0x70;
    if (m == 48)
    {
      AppMethodBeat.o(201423);
      return i;
    }
    if (m == 80)
    {
      AppMethodBeat.o(201423);
      return i + j - k;
    }
    j = (j - k) / 2;
    AppMethodBeat.o(201423);
    return i + j;
  }
  
  public InputFilter[] getFilters()
  {
    return this.YfS;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    AppMethodBeat.i(201485);
    int i = getPaddingTop();
    int j = getPaint().getFontMetricsInt().top;
    AppMethodBeat.o(201485);
    return i - j;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(201913);
    if (this.WoF == null)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(201913);
      return;
    }
    int i = getSelectionEnd();
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      AppMethodBeat.o(201913);
      return;
    }
    int j = getSelectionStart();
    if ((j < 0) || (j >= i))
    {
      j = this.WoF.getLineForOffset(i);
      paramRect.top = this.WoF.getLineTop(j);
      paramRect.bottom = this.WoF.getLineBottom(j);
      paramRect.left = ((int)this.WoF.getPrimaryHorizontal(i) - 2);
      paramRect.right = (paramRect.left + 4);
    }
    for (;;)
    {
      int k = getCompoundPaddingLeft();
      j = getExtendedPaddingTop();
      i = j;
      if ((this.sK & 0x70) != 48) {
        i = j + Hs(false);
      }
      paramRect.offset(k, i);
      paramRect.bottom = (getExtendedPaddingBottom() + paramRect.bottom);
      AppMethodBeat.o(201913);
      return;
      k = this.WoF.getLineForOffset(j);
      int m = this.WoF.getLineForOffset(i);
      paramRect.top = this.WoF.getLineTop(k);
      paramRect.bottom = this.WoF.getLineBottom(m);
      if (k == m)
      {
        paramRect.left = ((int)this.WoF.getPrimaryHorizontal(j));
        paramRect.right = ((int)this.WoF.getPrimaryHorizontal(i));
        continue;
      }
      if (this.YfX)
      {
        if (this.YfV == null) {
          this.YfV = new Path();
        }
        this.YfV.reset();
        this.WoF.getSelectionPath(j, i, this.YfV);
        this.YfX = false;
      }
      synchronized (rH)
      {
        this.YfV.computeBounds(rH, true);
        paramRect.left = ((int)rH.left - 1);
        paramRect.right = ((int)rH.right + 1);
      }
    }
  }
  
  public String getFontFeatureSettings()
  {
    AppMethodBeat.i(201567);
    String str = this.wi.getFontFeatureSettings();
    AppMethodBeat.o(201567);
    return str;
  }
  
  public String getFontVariationSettings()
  {
    AppMethodBeat.i(201568);
    if (Build.VERSION.SDK_INT >= 26)
    {
      String str = this.wi.getFontVariationSettings();
      AppMethodBeat.o(201568);
      return str;
    }
    AppMethodBeat.o(201568);
    return "";
  }
  
  public boolean getFreezesText()
  {
    return this.Yfg;
  }
  
  public int getGravity()
  {
    return this.sK;
  }
  
  public int getHighlightColor()
  {
    return this.rGp;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getHint()
  {
    return this.Yfu;
  }
  
  public final ColorStateList getHintTextColors()
  {
    return this.Yfd;
  }
  
  public int getHorizontalOffsetForDrawables()
  {
    return 0;
  }
  
  public boolean getHorizontallyScrolling()
  {
    return this.YfG;
  }
  
  public int getImeActionId()
  {
    if ((this.Ygi != null) && (this.Ygi.Yhs != null)) {
      return this.Ygi.Yhs.YiZ;
    }
    return 0;
  }
  
  public CharSequence getImeActionLabel()
  {
    if ((this.Ygi != null) && (this.Ygi.Yhs != null)) {
      return this.Ygi.Yhs.YiY;
    }
    return null;
  }
  
  public LocaleList getImeHintLocales()
  {
    if (this.Ygi == null) {}
    while (this.Ygi.Yhs == null) {
      return null;
    }
    return this.Ygi.Yhs.Yjc;
  }
  
  public int getImeOptions()
  {
    if ((this.Ygi != null) && (this.Ygi.Yhs != null)) {
      return this.Ygi.Yhs.nlD;
    }
    return 0;
  }
  
  public boolean getIncludeFontPadding()
  {
    return this.WoP;
  }
  
  public Bundle getInputExtras(boolean paramBoolean)
  {
    AppMethodBeat.i(201766);
    if ((this.Ygi == null) && (!paramBoolean))
    {
      AppMethodBeat.o(201766);
      return null;
    }
    iaI();
    if (this.Ygi.Yhs == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(201766);
        return null;
      }
      this.Ygi.iaL();
    }
    if (this.Ygi.Yhs.extras == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(201766);
        return null;
      }
      this.Ygi.Yhs.extras = new Bundle();
    }
    Bundle localBundle = this.Ygi.Yhs.extras;
    AppMethodBeat.o(201766);
    return localBundle;
  }
  
  InputMethodManager getInputMethodManager()
  {
    AppMethodBeat.i(202378);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localInputMethodManager = (InputMethodManager)getContext().getSystemService(InputMethodManager.class);
      AppMethodBeat.o(202378);
      return localInputMethodManager;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    AppMethodBeat.o(202378);
    return localInputMethodManager;
  }
  
  public int getInputType()
  {
    if (this.Ygi == null) {
      return 0;
    }
    return this.Ygi.IhY;
  }
  
  public CharSequence getIterableTextForAccessibility()
  {
    return this.mText;
  }
  
  public final KeyListener getKeyListener()
  {
    if (this.Ygi == null) {
      return null;
    }
    return this.Ygi.Yhx;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    AppMethodBeat.i(201486);
    int i = getPaddingBottom();
    int j = getPaint().getFontMetricsInt().bottom;
    AppMethodBeat.o(201486);
    return i + j;
  }
  
  public final Layout getLayout()
  {
    return this.WoF;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(202309);
    if (getLineCount() == 1)
    {
      f = getLayout().getLineLeft(0);
      if (f > getScrollX())
      {
        AppMethodBeat.o(202309);
        return 0.0F;
      }
      f = aE(getScrollX(), f);
      AppMethodBeat.o(202309);
      return f;
    }
    float f = super.getLeftFadingEdgeStrength();
    AppMethodBeat.o(202309);
    return f;
  }
  
  protected int getLeftPaddingOffset()
  {
    AppMethodBeat.i(201822);
    int i = getCompoundPaddingLeft();
    int j = getPaddingLeft();
    int k = (int)Math.min(0.0F, this.Yfi - this.Yfh);
    AppMethodBeat.o(201822);
    return i - j + k;
  }
  
  public float getLetterSpacing()
  {
    AppMethodBeat.i(201561);
    float f = this.wi.getLetterSpacing();
    AppMethodBeat.o(201561);
    return f;
  }
  
  public int getLineCount()
  {
    AppMethodBeat.i(201916);
    if (this.WoF != null)
    {
      int i = this.WoF.getLineCount();
      AppMethodBeat.o(201916);
      return i;
    }
    AppMethodBeat.o(201916);
    return 0;
  }
  
  public int getLineHeight()
  {
    AppMethodBeat.i(201388);
    int i = (int)(((this.wi.getFontMetricsInt(null) * this.WoG + this.WoH) * 16777216.0F) + 8388608L >> 24);
    AppMethodBeat.o(201388);
    return i;
  }
  
  public float getLineSpacingExtra()
  {
    return this.WoH;
  }
  
  public float getLineSpacingMultiplier()
  {
    return this.WoG;
  }
  
  public final ColorStateList getLinkTextColors()
  {
    return this.Yfe;
  }
  
  public final boolean getLinksClickable()
  {
    return this.YfI;
  }
  
  public int getMaxEms()
  {
    if (this.YfM == 1) {
      return this.uJ;
    }
    return -1;
  }
  
  public int getMaxHeight()
  {
    if (this.WoJ == 2) {
      return this.WoI;
    }
    return -1;
  }
  
  public int getMaxLines()
  {
    if (this.WoJ == 1) {
      return this.WoI;
    }
    return -1;
  }
  
  public int getMaxWidth()
  {
    if (this.YfM == 2) {
      return this.uJ;
    }
    return -1;
  }
  
  public a.e getMenuCallback()
  {
    return this.Ygp;
  }
  
  public int getMinEms()
  {
    if (this.YfN == 1) {
      return this.lj;
    }
    return -1;
  }
  
  public int getMinHeight()
  {
    if (this.WoL == 2) {
      return this.WoK;
    }
    return -1;
  }
  
  public int getMinLines()
  {
    if (this.WoL == 1) {
      return this.WoK;
    }
    return -1;
  }
  
  public int getMinWidth()
  {
    if (this.YfN == 2) {
      return this.lj;
    }
    return -1;
  }
  
  public final com.tencent.mm.ui.widget.cedit.b.d getMovementMethod()
  {
    return this.Yfw;
  }
  
  public TextPaint getPaint()
  {
    return this.wi;
  }
  
  public int getPaintFlags()
  {
    AppMethodBeat.i(201617);
    int i = this.wi.getFlags();
    AppMethodBeat.o(201617);
    return i;
  }
  
  public String getPrivateImeOptions()
  {
    if ((this.Ygi != null) && (this.Ygi.Yhs != null)) {
      return this.Ygi.Yhs.YiX;
    }
    return null;
  }
  
  public Set<String> getReuseBrands()
  {
    return this.Ygr;
  }
  
  public Set<String> getReuseItems()
  {
    return this.Ygq;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(202311);
    if (getLineCount() == 1)
    {
      f1 = getScrollX() + (getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
      float f2 = getLayout().getLineRight(0);
      if (f2 < f1)
      {
        AppMethodBeat.o(202311);
        return 0.0F;
      }
      f1 = aE(f1, f2);
      AppMethodBeat.o(202311);
      return f1;
    }
    float f1 = super.getRightFadingEdgeStrength();
    AppMethodBeat.o(202311);
    return f1;
  }
  
  protected int getRightPaddingOffset()
  {
    AppMethodBeat.i(201828);
    int i = -(getCompoundPaddingRight() - getPaddingRight());
    int j = (int)Math.max(0.0F, this.Yfi + this.Yfh);
    AppMethodBeat.o(201828);
    return i + j;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getScaledTextSize()
  {
    AppMethodBeat.i(201537);
    float f = this.wi.getTextSize() / this.wi.density;
    AppMethodBeat.o(201537);
    return f;
  }
  
  String getSelectedText()
  {
    AppMethodBeat.i(202182);
    if (!iau())
    {
      AppMethodBeat.o(202182);
      return null;
    }
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (i > j) {}
    for (Object localObject = this.mText.subSequence(j, i);; localObject = this.mText.subSequence(i, j))
    {
      localObject = String.valueOf(localObject);
      AppMethodBeat.o(202182);
      return localObject;
    }
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionEnd()
  {
    AppMethodBeat.i(202173);
    int i = Selection.getSelectionEnd(getText());
    AppMethodBeat.o(202173);
    return i;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public int getSelectionStart()
  {
    AppMethodBeat.i(202171);
    int i = Selection.getSelectionStart(getText());
    AppMethodBeat.o(202171);
    return i;
  }
  
  public int getShadowColor()
  {
    return this.raH;
  }
  
  public float getShadowDx()
  {
    return this.Yfi;
  }
  
  public float getShadowDy()
  {
    return this.Yfj;
  }
  
  public float getShadowRadius()
  {
    return this.Yfh;
  }
  
  public final boolean getShowSoftInputOnFocus()
  {
    return (this.Ygi == null) || (this.Ygi.YhG);
  }
  
  public Locale getSpellCheckerLocale()
  {
    AppMethodBeat.i(202342);
    Locale localLocale = Ht(true);
    AppMethodBeat.o(202342);
    return localLocale;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getText()
  {
    return this.mText;
  }
  
  TextClassificationContext getTextClassificationContext()
  {
    return this.Yfo;
  }
  
  final TextClassificationManager getTextClassificationManagerForUser()
  {
    AppMethodBeat.i(202337);
    if (Build.VERSION.SDK_INT >= 26)
    {
      getContext().getPackageName();
      TextClassificationManager localTextClassificationManager = (TextClassificationManager)bF(TextClassificationManager.class);
      AppMethodBeat.o(202337);
      return localTextClassificationManager;
    }
    AppMethodBeat.o(202337);
    return null;
  }
  
  TextClassifier getTextClassificationSession()
  {
    AppMethodBeat.i(202433);
    TextClassificationManager localTextClassificationManager;
    Object localObject;
    if ((Build.VERSION.SDK_INT >= 28) && ((this.Yfn == null) || (this.Yfn.isDestroyed())))
    {
      localTextClassificationManager = getTextClassificationManagerForUser();
      if (localTextClassificationManager == null) {
        break label128;
      }
      if (!iaw()) {
        break label107;
      }
      localObject = "edittext";
      this.Yfo = new TextClassificationContext.Builder(getContext().getPackageName(), (String)localObject).build();
      if (this.Yfm != null) {}
    }
    label128:
    for (this.Yfn = localTextClassificationManager.createTextClassificationSession(this.Yfo);; this.Yfn = TextClassifier.NO_OP)
    {
      localObject = this.Yfn;
      AppMethodBeat.o(202433);
      return localObject;
      label107:
      if (ial())
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
    AppMethodBeat.i(202430);
    if (this.Yfm == null)
    {
      localObject = getTextClassificationManagerForUser();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 26))
      {
        localObject = ((TextClassificationManager)localObject).getTextClassifier();
        AppMethodBeat.o(202430);
        return localObject;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = TextClassifier.NO_OP;
        AppMethodBeat.o(202430);
        return localObject;
      }
    }
    Object localObject = this.Yfm;
    AppMethodBeat.o(202430);
    return localObject;
  }
  
  public final ColorStateList getTextColors()
  {
    return this.Hkc;
  }
  
  public Drawable getTextCursorDrawable()
  {
    AppMethodBeat.i(201510);
    if ((this.YfZ == null) && (this.YfY != 0)) {
      this.YfZ = getContext().getDrawable(this.YfY);
    }
    Drawable localDrawable = this.YfZ;
    AppMethodBeat.o(201510);
    return localDrawable;
  }
  
  public TextDirectionHeuristic getTextDirectionHeuristic()
  {
    String str = null;
    AppMethodBeat.i(202511);
    if ((this.Yfx instanceof PasswordTransformationMethod))
    {
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(202511);
      return localObject;
    }
    if ((this.Ygi != null) && ((this.Ygi.IhY & 0xF) == 3)) {
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
        AppMethodBeat.o(202511);
        return localObject;
      }
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(202511);
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
          AppMethodBeat.o(202511);
          return localObject;
        }
      }
      label197:
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.ANYRTL_LTR;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.LTR;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.RTL;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.LOCALE;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      AppMethodBeat.o(202511);
      return localObject;
      localObject = TextDirectionHeuristics.FIRSTSTRONG_RTL;
      AppMethodBeat.o(202511);
      return localObject;
    }
  }
  
  public Locale getTextLocale()
  {
    AppMethodBeat.i(201519);
    Locale localLocale = this.wi.getTextLocale();
    AppMethodBeat.o(201519);
    return localLocale;
  }
  
  public LocaleList getTextLocales()
  {
    AppMethodBeat.i(201520);
    if (Build.VERSION.SDK_INT >= 24)
    {
      LocaleList localLocaleList = this.wi.getTextLocales();
      AppMethodBeat.o(201520);
      return localLocaleList;
    }
    AppMethodBeat.o(201520);
    return null;
  }
  
  public float getTextScaleX()
  {
    AppMethodBeat.i(201550);
    float f = this.wi.getTextScaleX();
    AppMethodBeat.o(201550);
    return f;
  }
  
  public Drawable getTextSelectHandle()
  {
    AppMethodBeat.i(201494);
    if ((this.Ygf == null) && (this.Yge != 0)) {
      this.Ygf = getContext().getDrawable(a.f.text_select_handle_middle_mtrl_alpha);
    }
    Drawable localDrawable = this.Ygf;
    AppMethodBeat.o(201494);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleLeft()
  {
    AppMethodBeat.i(201500);
    if ((this.Ygb == null) && (this.Yga != 0)) {
      this.Ygb = getContext().getDrawable(a.f.text_select_handle_left_mtrl_alpha);
    }
    Drawable localDrawable = this.Ygb;
    AppMethodBeat.o(201500);
    return localDrawable;
  }
  
  public Drawable getTextSelectHandleRight()
  {
    AppMethodBeat.i(201504);
    if ((this.Ygd == null) && (this.Ygc != 0)) {
      this.Ygd = getContext().getDrawable(a.f.text_select_handle_right_mtrl_alpha);
    }
    Drawable localDrawable = this.Ygd;
    AppMethodBeat.o(201504);
    return localDrawable;
  }
  
  public Locale getTextServicesLocale()
  {
    AppMethodBeat.i(202341);
    Locale localLocale = Ht(false);
    AppMethodBeat.o(202341);
    return localLocale;
  }
  
  final TextServicesManager getTextServicesManagerForUser()
  {
    AppMethodBeat.i(202330);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localTextServicesManager = (TextServicesManager)bF(TextServicesManager.class);
      AppMethodBeat.o(202330);
      return localTextServicesManager;
    }
    TextServicesManager localTextServicesManager = (TextServicesManager)getContext().getSystemService("textservices");
    AppMethodBeat.o(202330);
    return localTextServicesManager;
  }
  
  @ViewDebug.ExportedProperty(category="text")
  public float getTextSize()
  {
    AppMethodBeat.i(201534);
    float f = this.wi.getTextSize();
    AppMethodBeat.o(201534);
    return f;
  }
  
  public int getTextSizeUnit()
  {
    return this.YfC;
  }
  
  protected int getTopPaddingOffset()
  {
    AppMethodBeat.i(201826);
    int i = (int)Math.min(0.0F, this.Yfj - this.Yfh);
    AppMethodBeat.o(201826);
    return i;
  }
  
  public int getTotalPaddingBottom()
  {
    AppMethodBeat.i(201439);
    int k = getExtendedPaddingBottom();
    int j = 0;
    int m = this.sK & 0x70;
    Layout localLayout = this.WoF;
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
      AppMethodBeat.o(201439);
      return i + k;
    }
  }
  
  public int getTotalPaddingEnd()
  {
    AppMethodBeat.i(201435);
    int i = getCompoundPaddingEnd();
    AppMethodBeat.o(201435);
    return i;
  }
  
  public int getTotalPaddingLeft()
  {
    AppMethodBeat.i(201431);
    int i = getCompoundPaddingLeft();
    AppMethodBeat.o(201431);
    return i;
  }
  
  public int getTotalPaddingRight()
  {
    AppMethodBeat.i(201433);
    int i = getCompoundPaddingRight();
    AppMethodBeat.o(201433);
    return i;
  }
  
  public int getTotalPaddingStart()
  {
    AppMethodBeat.i(201434);
    int i = getCompoundPaddingStart();
    AppMethodBeat.o(201434);
    return i;
  }
  
  public int getTotalPaddingTop()
  {
    AppMethodBeat.i(201437);
    int i = getExtendedPaddingTop();
    int j = Hs(true);
    AppMethodBeat.o(201437);
    return i + j;
  }
  
  public final TransformationMethod getTransformationMethod()
  {
    return this.Yfx;
  }
  
  public CharSequence getTransformed()
  {
    return this.WoC;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(201555);
    Typeface localTypeface = this.wi.getTypeface();
    AppMethodBeat.o(201555);
    return localTypeface;
  }
  
  @ViewDebug.ExportedProperty(category="text", mapping={@android.view.ViewDebug.IntToString(from=0, to="NORMAL"), @android.view.ViewDebug.IntToString(from=1, to="BOLD"), @android.view.ViewDebug.IntToString(from=2, to="ITALIC"), @android.view.ViewDebug.IntToString(from=3, to="BOLD_ITALIC")})
  public int getTypefaceStyle()
  {
    AppMethodBeat.i(201538);
    Typeface localTypeface = this.wi.getTypeface();
    if (localTypeface != null)
    {
      int i = localTypeface.getStyle();
      AppMethodBeat.o(201538);
      return i;
    }
    AppMethodBeat.o(201538);
    return 0;
  }
  
  public URLSpan[] getUrls()
  {
    AppMethodBeat.i(201596);
    if ((this.mText instanceof Spanned))
    {
      URLSpan[] arrayOfURLSpan = (URLSpan[])((Spanned)this.mText).getSpans(0, this.mText.length(), URLSpan.class);
      AppMethodBeat.o(201596);
      return arrayOfURLSpan;
    }
    AppMethodBeat.o(201596);
    return new URLSpan[0];
  }
  
  public com.tencent.mm.ui.widget.cedit.c.b getWordIterator()
  {
    AppMethodBeat.i(202344);
    if (this.Ygi != null)
    {
      com.tencent.mm.ui.widget.cedit.c.b localb = this.Ygi.getWordIterator();
      AppMethodBeat.o(202344);
      return localb;
    }
    AppMethodBeat.o(202344);
    return null;
  }
  
  public boolean hasOverlappingRendering()
  {
    AppMethodBeat.i(201848);
    if (((getBackground() != null) && (getBackground().getCurrent() != null)) || (this.Yfs != null) || (iau()) || (isHorizontalFadingEdgeEnabled()) || (this.raH != 0))
    {
      AppMethodBeat.o(201848);
      return true;
    }
    AppMethodBeat.o(201848);
    return false;
  }
  
  public final void iaB()
  {
    AppMethodBeat.i(202436);
    if (this.Ygi != null) {
      this.Ygi.iaB();
    }
    AppMethodBeat.o(202436);
  }
  
  final boolean iaC()
  {
    AppMethodBeat.i(202441);
    if ((this.Yfx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(202441);
      return false;
    }
    if ((this.mText.length() > 0) && (iau()) && ((this.mText instanceof Editable)) && (this.Ygi != null) && (this.Ygi.Yhx != null))
    {
      AppMethodBeat.o(202441);
      return true;
    }
    AppMethodBeat.o(202441);
    return false;
  }
  
  final boolean iaD()
  {
    AppMethodBeat.i(202445);
    if ((this.Yfx instanceof PasswordTransformationMethod))
    {
      AppMethodBeat.o(202445);
      return false;
    }
    if ((this.mText.length() > 0) && (iau()) && (this.Ygi != null))
    {
      AppMethodBeat.o(202445);
      return true;
    }
    AppMethodBeat.o(202445);
    return false;
  }
  
  final boolean iaE()
  {
    AppMethodBeat.i(202450);
    if (((this.mText instanceof Editable)) && (this.Ygi != null) && (this.Ygi.Yhx != null) && (getSelectionStart() >= 0) && (getSelectionEnd() >= 0) && (getClipboardManagerForUser().hasPrimaryClip()))
    {
      AppMethodBeat.o(202450);
      return true;
    }
    AppMethodBeat.o(202450);
    return false;
  }
  
  final boolean iaF()
  {
    AppMethodBeat.i(202455);
    if ((iay()) && (!(this.Yfx instanceof PasswordTransformationMethod)) && ((getSelectionStart() != 0) || (getSelectionEnd() != this.mText.length())))
    {
      AppMethodBeat.o(202455);
      return true;
    }
    AppMethodBeat.o(202455);
    return false;
  }
  
  public final boolean iaG()
  {
    AppMethodBeat.i(202459);
    if (this.Ygi != null) {
      axL(500);
    }
    int i = this.mText.length();
    Selection.setSelection(this.Yfs, 0, i);
    if (i > 0)
    {
      AppMethodBeat.o(202459);
      return true;
    }
    AppMethodBeat.o(202459);
    return false;
  }
  
  final boolean iaH()
  {
    if (this.Ygi == null) {}
    b.h localh;
    do
    {
      return false;
      localh = this.Ygi.Yht;
      if (localh == null) {
        break;
      }
    } while (localh.Yhf <= 0);
    return true;
    return this.Ygi.YhF;
  }
  
  public final boolean iaK()
  {
    AppMethodBeat.i(202536);
    if ((getReuseItems().size() > 0) && (Build.BRAND != null) && (getReuseBrands().contains(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT >= 23))
    {
      AppMethodBeat.o(202536);
      return true;
    }
    AppMethodBeat.o(202536);
    return false;
  }
  
  final void iai()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(201787);
    if (this.YfX)
    {
      iaj();
      AppMethodBeat.o(201787);
      return;
    }
    int i = getCompoundPaddingLeft();
    int j = getExtendedPaddingTop();
    j = Hs(true) + j;
    if (this.Ygi.YhO == null) {}
    for (;;)
    {
      float f2;
      synchronized (rH)
      {
        f2 = (float)Math.ceil(this.wi.getStrokeWidth());
        if (f2 >= 1.0F) {
          break label246;
        }
        f1 /= 2.0F;
        this.YfV.computeBounds(rH, false);
        invalidate((int)Math.floor(i + rH.left - f1), (int)Math.floor(j + rH.top - f1), (int)Math.ceil(i + rH.right + f1), (int)Math.ceil(f1 + (j + rH.bottom)));
        AppMethodBeat.o(201787);
        return;
      }
      ??? = this.Ygi.YhO.getBounds();
      invalidate(((Rect)???).left + i, ((Rect)???).top + j, i + ((Rect)???).right, ((Rect)???).bottom + j);
      AppMethodBeat.o(201787);
      return;
      label246:
      f1 = f2;
    }
  }
  
  final void iaj()
  {
    AppMethodBeat.i(201789);
    int i = getSelectionEnd();
    aZ(i, i, i);
    AppMethodBeat.o(201789);
  }
  
  public final boolean ial()
  {
    if (this.Ygi == null) {
      return false;
    }
    return this.Ygi.YhE;
  }
  
  public final void ian()
  {
    AppMethodBeat.i(202022);
    if (this.Ygi != null) {
      this.Ygi.ian();
    }
    AppMethodBeat.o(202022);
  }
  
  public final void iao()
  {
    AppMethodBeat.i(202023);
    if (this.Ygi != null) {
      this.Ygi.iao();
    }
    AppMethodBeat.o(202023);
  }
  
  final int ias()
  {
    AppMethodBeat.i(202166);
    int i = getCompoundPaddingLeft();
    int j = getScrollX();
    AppMethodBeat.o(202166);
    return i - j;
  }
  
  final int iat()
  {
    AppMethodBeat.i(202170);
    int j = getExtendedPaddingTop() - getScrollY();
    int i = j;
    if ((this.sK & 0x70) != 48) {
      i = j + Hs(false);
    }
    AppMethodBeat.o(202170);
    return i;
  }
  
  public final boolean iau()
  {
    AppMethodBeat.i(202177);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((i >= 0) && (j > 0) && (i != j))
    {
      AppMethodBeat.o(202177);
      return true;
    }
    AppMethodBeat.o(202177);
    return false;
  }
  
  final void iav()
  {
    AppMethodBeat.i(202227);
    invalidate();
    int i = getSelectionStart();
    if ((i >= 0) || ((this.sK & 0x70) == 80)) {
      iak();
    }
    iaq();
    if (i >= 0)
    {
      this.YfX = true;
      if (this.Ygi != null) {
        this.Ygi.ibx();
      }
      axK(i);
    }
    AppMethodBeat.o(202227);
  }
  
  final boolean iaw()
  {
    AppMethodBeat.i(202304);
    if (((this.mText instanceof Editable)) && (onCheckIsTextEditor()) && (isEnabled()))
    {
      AppMethodBeat.o(202304);
      return true;
    }
    AppMethodBeat.o(202304);
    return false;
  }
  
  public final boolean iax()
  {
    return (this.Ygi != null) && (this.Ygi.Yhw);
  }
  
  final boolean iay()
  {
    AppMethodBeat.i(202325);
    if ((this.mText.length() != 0) && (this.Ygi != null) && (this.Ygi.Yhm))
    {
      AppMethodBeat.o(202325);
      return true;
    }
    AppMethodBeat.o(202325);
    return false;
  }
  
  final boolean iaz()
  {
    AppMethodBeat.i(202326);
    if ((this.Yfw == null) || (!this.Yfw.ibW()))
    {
      AppMethodBeat.o(202326);
      return false;
    }
    if ((iaw()) || ((ial()) && ((this.mText instanceof Spannable)) && (isEnabled())))
    {
      AppMethodBeat.o(202326);
      return true;
    }
    AppMethodBeat.o(202326);
    return false;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int m = 0;
    int i1 = 0;
    AppMethodBeat.i(201846);
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
      localb = this.Yfq;
      i = i1;
      j = m;
      k = n;
      if (localb != null)
      {
        if (paramDrawable != localb.Ygu[0]) {
          break label187;
        }
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + getPaddingLeft();
        j = m + (i + (i1 - i2 - j - i - localb.Wpw) / 2);
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
      AppMethodBeat.o(201846);
      return;
      label187:
      if (paramDrawable == localb.Ygu[2])
      {
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        k = n + (getRight() - getLeft() - getPaddingRight() - localb.Wpt);
        j = m + (i + (i1 - i2 - j - i - localb.Wpx) / 2);
        i = 1;
      }
      else if (paramDrawable == localb.Ygu[1])
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        k = n + (i + (getRight() - getLeft() - j - i - localb.Wpu) / 2);
        j = m + getPaddingTop();
        i = 1;
      }
      else
      {
        i = i1;
        j = m;
        k = n;
        if (paramDrawable == localb.Ygu[3])
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          k = n + (i + (getRight() - getLeft() - j - i - localb.Wpv) / 2);
          j = m + (getBottom() - getTop() - getPaddingBottom() - localb.Wpr);
          i = 1;
        }
      }
    }
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (this.Yfh != 0.0F) || (this.Yfq != null);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(201833);
    super.jumpDrawablesToCurrentState();
    if (this.Yfq != null)
    {
      Drawable[] arrayOfDrawable = this.Yfq.Ygu;
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
    AppMethodBeat.o(201833);
  }
  
  public int length()
  {
    AppMethodBeat.i(201384);
    int i = this.mText.length();
    AppMethodBeat.o(201384);
    return i;
  }
  
  final CharSequence mS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202400);
    CharSequence localCharSequence = aM(this.WoC.subSequence(paramInt1, paramInt2));
    AppMethodBeat.o(202400);
    return localCharSequence;
  }
  
  protected final void mT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202519);
    ((Editable)this.mText).delete(paramInt1, paramInt2);
    AppMethodBeat.o(202519);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(201815);
    super.onAttachedToWindow();
    if (this.Ygi != null)
    {
      b localb = this.Ygi;
      ViewTreeObserver localViewTreeObserver = localb.Yhe.getViewTreeObserver();
      if (localViewTreeObserver.isAlive())
      {
        if (localb.Yhi != null) {
          localViewTreeObserver.addOnTouchModeChangeListener(localb.Yhi);
        }
        if (localb.Yhj != null)
        {
          localb.Yhj.ibM();
          localViewTreeObserver.addOnTouchModeChangeListener(localb.Yhj);
        }
        localViewTreeObserver.addOnDrawListener(localb.Yhq);
      }
      if (localb.Yhe.iau()) {
        localb.ibg();
      }
      localb.iaQ();
    }
    if (this.Yfl)
    {
      getViewTreeObserver().addOnPreDrawListener(this);
      this.Yfl = false;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212770);
        CustomTextView localCustomTextView = CustomTextView.this;
        boolean bool = localCustomTextView.iaK();
        Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isNeedReuseMenuItems:".concat(String.valueOf(bool)));
        if (bool)
        {
          bool = localCustomTextView.isAttachedToWindow();
          Log.i("cmEdit.CMTextView", "checkInitAdaptEdt isWindowAttached:".concat(String.valueOf(bool)));
          if (bool)
          {
            Log.i("cmEdit.CMTextView", "checkInitAdaptEdt mIsInitAdapt:" + localCustomTextView.Ygo);
            if (!localCustomTextView.Ygo)
            {
              localCustomTextView.Ygo = true;
              try
              {
                AdaptEditText localAdaptEditText = new AdaptEditText(localCustomTextView.getContext());
                if ((localCustomTextView.getParent() instanceof ViewGroup))
                {
                  ((ViewGroup)localCustomTextView.getParent()).addView(localAdaptEditText);
                  localAdaptEditText.setVisibility(8);
                  localCustomTextView.setAdaptText(localAdaptEditText);
                }
                AppMethodBeat.o(212770);
                return;
              }
              catch (Throwable localThrowable)
              {
                Log.e("cmEdit.CMTextView", "initAdapt err:%s", new Object[] { Util.stackTraceToString(localThrowable) });
                com.tencent.mm.ui.widget.cedit.api.b.axG(7);
              }
            }
          }
        }
        AppMethodBeat.o(212770);
      }
    });
    AppMethodBeat.o(201815);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return (this.Ygi != null) && (this.Ygi.IhY != 0);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(201532);
    super.onConfigurationChanged(paramConfiguration);
    if (!this.YfB)
    {
      if (Build.VERSION.SDK_INT < 24) {
        break label62;
      }
      this.wi.setTextLocales(LocaleList.getDefault());
    }
    for (;;)
    {
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(201532);
      return;
      label62:
      this.wi.setTextLocale(Locale.getDefault());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(201861);
    int[] arrayOfInt1;
    int i;
    if (this.Wmc)
    {
      arrayOfInt1 = super.onCreateDrawableState(paramInt);
      if (ial())
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
          AppMethodBeat.o(201861);
          return arrayOfInt2;
          arrayOfInt1 = super.onCreateDrawableState(paramInt + 1);
          mergeDrawableStates(arrayOfInt1, Yfb);
          break;
        }
        paramInt += 1;
      }
    }
    label111:
    AppMethodBeat.o(201861);
    return arrayOfInt1;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(201998);
    if ((onCheckIsTextEditor()) && (isEnabled()))
    {
      Object localObject = this.Ygi;
      if (((b)localObject).Yht == null) {
        ((b)localObject).Yht = new b.h();
      }
      paramEditorInfo.inputType = getInputType();
      if (this.Ygi.Yhs != null)
      {
        paramEditorInfo.imeOptions = this.Ygi.Yhs.nlD;
        paramEditorInfo.privateImeOptions = this.Ygi.Yhs.YiX;
        paramEditorInfo.actionLabel = this.Ygi.Yhs.YiY;
        paramEditorInfo.actionId = this.Ygi.Yhs.YiZ;
        paramEditorInfo.extras = this.Ygi.Yhs.extras;
        if (Build.VERSION.SDK_INT >= 24) {
          paramEditorInfo.hintLocales = this.Ygi.Yhs.Yjc;
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
        if (!iam()) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        if (axH(paramEditorInfo.inputType)) {
          paramEditorInfo.imeOptions |= 0x40000000;
        }
        paramEditorInfo.hintText = this.Yfu;
        if (!(this.mText instanceof Editable)) {
          break label326;
        }
        localObject = new a(this);
        paramEditorInfo.initialSelStart = getSelectionStart();
        paramEditorInfo.initialSelEnd = getSelectionEnd();
        paramEditorInfo.initialCapsMode = ((InputConnection)localObject).getCursorCapsMode(getInputType());
        AppMethodBeat.o(201998);
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
    AppMethodBeat.o(201998);
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(201818);
    super.onDetachedFromWindow();
    if (this.Yfk)
    {
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.Yfl = true;
    }
    this.Yfr = -1;
    if (this.Ygi != null)
    {
      b localb = this.Ygi;
      localb.iaP();
      if (localb.Yhi != null) {
        localb.Yhi.cfy();
      }
      if (localb.Yhj != null) {
        localb.Yhj.cfy();
      }
      if (localb.YhN != null) {
        localb.Yhe.removeCallbacks(localb.YhN);
      }
      if (localb.Yia != null) {
        localb.Yhe.removeCallbacks(localb.Yia);
      }
      localb.Yhe.removeCallbacks(localb.Yif);
      ViewTreeObserver localViewTreeObserver = localb.Yhe.getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeOnDrawListener(localb.Yhq);
      }
      localb.iaO();
      localb.ibt();
    }
    AppMethodBeat.o(201818);
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    AppMethodBeat.i(202486);
    switch (paramDragEvent.getAction())
    {
    case 4: 
    default: 
      AppMethodBeat.o(202486);
      return true;
    case 1: 
      if ((this.Ygi != null) && (this.Ygi.Yhl))
      {
        AppMethodBeat.o(202486);
        return true;
      }
      AppMethodBeat.o(202486);
      return false;
    case 5: 
      requestFocus();
      AppMethodBeat.o(202486);
      return true;
    case 2: 
      if ((this.mText instanceof Spannable))
      {
        int i = aG(paramDragEvent.getX(), paramDragEvent.getY());
        Selection.setSelection(this.Yfs, i);
      }
      AppMethodBeat.o(202486);
      return true;
    }
    if (this.Ygi != null) {
      this.Ygi.a(paramDragEvent);
    }
    AppMethodBeat.o(202486);
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(201893);
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
    Object localObject1 = this.Yfq;
    if (localObject1 != null)
    {
      j = n - i1 - i3 - i2;
      i7 = i5 - i6 - i7 - k;
      if (localObject1.Ygu[0] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i + (getPaddingLeft() + i4), m + i2 + (j - ((b)localObject1).Wpw) / 2);
        localObject1.Ygu[0].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.Ygu[2] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + i5 - i6 - getPaddingRight() - ((b)localObject1).Wpt + 0, (j - ((b)localObject1).Wpx) / 2 + (m + i2));
        localObject1.Ygu[2].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.Ygu[1] != null)
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + k + (i7 - ((b)localObject1).Wpu) / 2, getPaddingTop() + m);
        localObject1.Ygu[1].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (localObject1.Ygu[3] != null)
      {
        paramCanvas.save();
        paramCanvas.translate((i7 - ((b)localObject1).Wpv) / 2 + (i4 + k), m + n - i1 - getPaddingBottom() - ((b)localObject1).Wpr);
        localObject1.Ygu[3].draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    i = this.Woy;
    if (this.WoF == null) {
      hKt();
    }
    Object localObject2 = this.WoF;
    int j = i;
    localObject1 = localObject2;
    if (this.Yfu != null)
    {
      j = i;
      localObject1 = localObject2;
      if (this.mText.length() == 0)
      {
        if (this.Yfd != null) {
          i = this.Yff;
        }
        localObject1 = this.Yfv;
        j = i;
      }
    }
    this.wi.setColor(j);
    this.wi.drawableState = getDrawableState();
    paramCanvas.save();
    i7 = getExtendedPaddingTop();
    i = getExtendedPaddingBottom();
    j = getBottom();
    int i8 = getTop();
    int i9 = this.WoF.getHeight();
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
      if (this.Yfh == 0.0F) {
        break label1252;
      }
      f3 += Math.min(0.0F, this.Yfi - this.Yfh);
      f2 = Math.max(0.0F, this.Yfi + this.Yfh) + f2;
      f1 += Math.min(0.0F, this.Yfj - this.Yfh);
      f4 = Math.max(0.0F, this.Yfj + this.Yfh) + f4;
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
      if ((this.sK & 0x70) != 48)
      {
        j = Hs(false);
        i = Hs(true);
      }
      paramCanvas.translate(k, i7 + j);
      j = i - j;
      Path localPath = getUpdatedHighlightPath();
      Object localObject3;
      label872:
      long l;
      if (this.Ygi != null)
      {
        b localb = this.Ygi;
        Paint localPaint = this.YfW;
        k = localb.Yhe.getSelectionStart();
        m = localb.Yhe.getSelectionEnd();
        localObject2 = localb.Yht;
        if ((localObject2 != null) && (((b.h)localObject2).Yhf == 0))
        {
          localObject3 = localb.getInputMethodManager();
          if ((localObject3 != null) && (((InputMethodManager)localObject3).isActive(localb.Yhe)) && ((((b.h)localObject2).mContentChanged) || (((b.h)localObject2).Yjg))) {
            localb.ibc();
          }
        }
        if (localb.Yhr != null)
        {
          localObject2 = localb.Yhr;
          localObject3 = b.c(((b.b)localObject2).Yip).getLayout();
          if (localObject3 == null)
          {
            i = 0;
            if (i == 0) {
              break label1215;
            }
            l = SystemClock.uptimeMillis() - ((b.b)localObject2).Yiq;
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
            paramCanvas.drawPath(((b.b)localObject2).auD, ((b.b)localObject2).mPaint);
            if (j != 0) {
              paramCanvas.translate(0.0F, -j);
            }
            ((b.b)localObject2).Hw(true);
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
              if (localb.YhO != null)
              {
                if (j == 0) {
                  break label1229;
                }
                i = 1;
                if (i != 0) {
                  paramCanvas.translate(0.0F, j);
                }
                if (localb.YhO != null) {
                  localb.YhO.draw(paramCanvas);
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
        AppMethodBeat.o(201893);
        return;
        f1 = i7 + m;
        break;
        n = b.c(((b.b)localObject2).Yip).getText().length();
        i = Math.min(n, ((b.b)localObject2).tH);
        n = Math.min(n, ((b.b)localObject2).tI);
        ((b.b)localObject2).auD.reset();
        ((Layout)localObject3).getSelectionPath(i, n, ((b.b)localObject2).auD);
        i = 1;
        break label872;
        label1142:
        f1 = (float)l / 400.0F;
        n = Color.alpha(b.c(((b.b)localObject2).Yip).rGp);
        i = b.c(((b.b)localObject2).Yip).rGp;
        n = (int)((1.0F - f1) * n);
        ((b.b)localObject2).mPaint.setColor((n << 24) + (i & 0xFFFFFF));
        i = 1;
        break label900;
        ((b.b)localObject2).stopAnimation();
        ((b.b)localObject2).Hw(false);
        break label952;
        i = 0;
        break label992;
        ((Layout)localObject1).draw(paramCanvas, localPath, this.YfW, j);
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(202262);
    if ((Build.VERSION.SDK_INT >= 24) && (isTemporarilyDetached()))
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      AppMethodBeat.o(202262);
      return;
    }
    if (this.Ygi != null) {
      this.Ygi.at(paramBoolean, paramInt);
    }
    if ((paramBoolean) && (this.Yfs != null)) {
      MetaKeyKeyListener.resetMetaState(this.Yfs);
    }
    if (this.Yfx != null) {
      this.Yfx.onFocusChanged(this, this.mText, paramBoolean, paramInt, paramRect);
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    AppMethodBeat.o(202262);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(202299);
    if ((this.Yfw != null) && ((this.mText instanceof Spannable)) && (this.WoF != null)) {
      try
      {
        bool = this.Yfw.a(this, paramMotionEvent);
        if (bool)
        {
          AppMethodBeat.o(202299);
          return true;
        }
      }
      catch (AbstractMethodError localAbstractMethodError) {}
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(202299);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201940);
    if (a(paramInt, paramKeyEvent, null) == 0)
    {
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(201940);
      return bool;
    }
    AppMethodBeat.o(201940);
    return true;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201945);
    KeyEvent localKeyEvent = KeyEvent.changeAction(paramKeyEvent, 0);
    int i = a(paramInt1, localKeyEvent, paramKeyEvent);
    if (i == 0)
    {
      boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(201945);
      return bool;
    }
    if (i == -1)
    {
      AppMethodBeat.o(201945);
      return true;
    }
    paramInt2 -= 1;
    paramKeyEvent = KeyEvent.changeAction(paramKeyEvent, 1);
    if (i == 1)
    {
      this.Ygi.Yhx.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.Ygi.Yhx.onKeyDown(this, (Editable)this.mText, paramInt1, localKeyEvent);
        this.Ygi.Yhx.onKeyUp(this, (Editable)this.mText, paramInt1, paramKeyEvent);
      }
    }
    if (i == 2) {
      for (;;)
      {
        paramInt2 -= 1;
        if (paramInt2 <= 0) {
          break;
        }
        this.Yfw.a(this, this.Yfs, paramInt1, localKeyEvent);
      }
    }
    AppMethodBeat.o(201945);
    return true;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(201938);
    if (paramInt == 4)
    {
      int i = j;
      if (this.Ygi != null)
      {
        if (!this.Ygi.ibk()) {
          break label49;
        }
        i = j;
      }
      while (i != 0)
      {
        AppMethodBeat.o(201938);
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
                iaB();
                i = 1;
              }
            }
          }
        }
      }
    }
    boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
    AppMethodBeat.o(201938);
    return bool;
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(202322);
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
        AppMethodBeat.o(202322);
        return bool;
        if (iay())
        {
          bool = onTextContextMenuItem(16908319);
          AppMethodBeat.o(202322);
          return bool;
          if (iaC())
          {
            bool = onTextContextMenuItem(16908320);
            AppMethodBeat.o(202322);
            return bool;
            if (iaD())
            {
              bool = onTextContextMenuItem(16908321);
              AppMethodBeat.o(202322);
              return bool;
              if (iaE())
              {
                bool = onTextContextMenuItem(16908322);
                AppMethodBeat.o(202322);
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
    } while (!iaE());
    boolean bool = onTextContextMenuItem(16908337);
    AppMethodBeat.o(202322);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201982);
    if (!isEnabled())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(201982);
      return bool;
    }
    if (!KeyEvent.isModifierKey(paramInt)) {
      this.Yfp = false;
    }
    switch (paramInt)
    {
    }
    while ((this.Ygi != null) && (this.Ygi.Yhx != null) && (this.Ygi.Yhx.onKeyUp(this, (Editable)this.mText, paramInt, paramKeyEvent)))
    {
      AppMethodBeat.o(201982);
      return true;
      Object localObject;
      if ((paramKeyEvent.hasNoModifiers()) && (!hasOnClickListeners()) && (this.Yfw != null) && ((this.mText instanceof Editable)) && (this.WoF != null) && (onCheckIsTextEditor()))
      {
        localObject = getInputMethodManager();
        a((InputMethodManager)localObject);
        if ((localObject != null) && (getShowSoftInputOnFocus())) {
          ((InputMethodManager)localObject).showSoftInput(this, 0);
        }
      }
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(201982);
      return bool;
      if (paramKeyEvent.hasNoModifiers())
      {
        if ((this.Ygi != null) && (this.Ygi.Yhs != null) && (this.Ygi.Yhs.Yja != null) && (this.Ygi.Yhs.Yjb))
        {
          this.Ygi.Yhs.Yjb = false;
          if (this.Ygi.Yhs.Yja.a(this, 0))
          {
            AppMethodBeat.o(201982);
            return true;
          }
        }
        if ((((paramKeyEvent.getFlags() & 0x10) != 0) || (iam())) && (!hasOnClickListeners()))
        {
          localObject = focusSearch(130);
          if (localObject != null)
          {
            if (!((View)localObject).requestFocus(130))
            {
              paramKeyEvent = new IllegalStateException("focus search returned a view that wasn't able to take focus!");
              AppMethodBeat.o(201982);
              throw paramKeyEvent;
            }
            super.onKeyUp(paramInt, paramKeyEvent);
            AppMethodBeat.o(201982);
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
        AppMethodBeat.o(201982);
        return bool;
      }
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(201982);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(202128);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.YfO >= 0)
    {
      paramInt1 = this.YfO;
      this.YfO = -1;
      axK(Math.min(paramInt1, this.mText.length()));
    }
    AppMethodBeat.o(202128);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202100);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    BoringLayout.Metrics localMetrics1 = Wpg;
    BoringLayout.Metrics localMetrics2 = Wpg;
    if (this.Mg == null) {
      this.Mg = getTextDirectionHeuristic();
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
      if (!this.YfG) {
        break label878;
      }
      paramInt2 = 1048576;
      if (this.Yfv == null)
      {
        k = paramInt2;
        label109:
        if (this.WoF == null) {
          break label814;
        }
        if ((this.WoF.getWidth() == paramInt2) && (k == paramInt2) && (this.WoF.getEllipsizedWidth() == paramInt1 - getCompoundPaddingLeft() - getCompoundPaddingRight())) {
          break label797;
        }
        k = 1;
        label157:
        if ((this.Yfu != null) || (this.WoB != null) || (paramInt2 <= this.WoF.getWidth()) || ((!(this.WoF instanceof BoringLayout)) && ((j == 0) || (i < 0) || (i > paramInt2)))) {
          break label803;
        }
        i = 1;
        label208:
        if ((this.WoJ == this.YfL) && (this.WoI == this.YfK)) {
          break label808;
        }
        j = 1;
        label233:
        if ((k != 0) || (j != 0))
        {
          if ((j != 0) || (i == 0)) {
            break label814;
          }
          this.WoF.increaseWidthTo(paramInt2);
        }
        label260:
        if (i1 != 1073741824) {
          break label839;
        }
        this.WoO = -1;
        paramInt2 = m;
        label276:
        j = paramInt2 - getCompoundPaddingTop() - getCompoundPaddingBottom();
        i = j;
        if (this.WoJ == 1)
        {
          i = j;
          if (this.WoF.getLineCount() > this.WoI) {
            i = Math.min(j, this.WoF.getLineTop(this.WoI));
          }
        }
        if ((this.Yfw == null) && (this.WoF.getWidth() <= n) && (this.WoF.getHeight() <= i)) {
          break label869;
        }
        iak();
        label368:
        setMeasuredDimension(paramInt1, paramInt2);
        AppMethodBeat.o(202100);
      }
    }
    else
    {
      if ((this.WoF == null) || (this.WoB != null)) {
        break label913;
      }
    }
    label773:
    label908:
    label913:
    for (paramInt2 = b(this.WoF);; paramInt2 = -1)
    {
      if (paramInt2 < 0)
      {
        localMetrics1 = BoringLayout.isBoring(this.WoC, this.wi, this.YfP);
        if (localMetrics1 == null) {
          break label908;
        }
        this.YfP = localMetrics1;
        paramInt1 = 0;
      }
      for (;;)
      {
        label437:
        if ((localMetrics1 == null) || (localMetrics1 == Wpg))
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            i = (int)Math.ceil(Layout.getDesiredWidth(this.WoC, 0, this.WoC.length(), this.wi));
          }
          j = i;
          paramInt2 = i;
          label488:
          localObject = this.Yfq;
          i = j;
          if (localObject != null) {
            i = Math.max(Math.max(j, ((b)localObject).Wpu), ((b)localObject).Wpv);
          }
          j = i;
          localObject = localMetrics2;
          if (this.Yfu != null)
          {
            k = -1;
            j = k;
            if (this.Yfv != null)
            {
              j = k;
              if (this.WoB == null) {
                j = b(this.Yfv);
              }
            }
            if (j >= 0) {
              break label901;
            }
            localMetrics2 = BoringLayout.isBoring(this.Yfu, this.wi, this.YfQ);
            localObject = localMetrics2;
            if (localMetrics2 != null) {
              this.YfQ = localMetrics2;
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
            if (localObject == Wpg) {
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
            if (this.YfM == 1)
            {
              i = Math.min(i, this.uJ * getLineHeight());
              if (this.YfN != 1) {
                break label773;
              }
            }
            for (i = Math.max(i, this.lj * getLineHeight());; i = Math.max(i, this.lj))
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
              i = Math.min(i, this.uJ);
              break label676;
            }
            k = this.Yfv.getWidth();
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
            this.WoO = i;
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
    AppMethodBeat.i(201808);
    if (this.WoF == null) {
      hKt();
    }
    int j;
    if (this.Yfw != null)
    {
      j = getSelectionEnd();
      i = j;
      if (this.Ygi != null)
      {
        i = j;
        if (this.Ygi.Yhj != null)
        {
          i = j;
          if (this.Ygi.Yhj.ibO()) {
            i = getSelectionStart();
          }
        }
      }
      j = i;
      if (i < 0)
      {
        j = i;
        if ((this.sK & 0x70) == 80) {
          j = this.mText.length();
        }
      }
      if (j >= 0) {
        axK(j);
      }
      if ((this.Ygi != null) && (this.Ygi.YhX))
      {
        this.Ygi.ibg();
        this.Ygi.YhX = false;
      }
      getViewTreeObserver().removeOnPreDrawListener(this);
      this.Yfk = false;
      this.Yfl = false;
      AppMethodBeat.o(201808);
      return true;
    }
    Layout localLayout;
    if (iar())
    {
      localLayout = this.Yfv;
      label181:
      if ((this.sK & 0x70) != 80) {
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
          if ((m < k) || ((this.sK & 0x70) != 80)) {
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
        localLayout = this.WoF;
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
    AppMethodBeat.i(201930);
    if ((this.Yfs != null) && (this.YfI))
    {
      int i = aG(paramMotionEvent.getX(paramInt), paramMotionEvent.getY(paramInt));
      if ((((ClickableSpan[])this.Yfs.getSpans(i, i, ClickableSpan.class)).length > 0) && (Build.VERSION.SDK_INT >= 24))
      {
        paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1002);
        AppMethodBeat.o(201930);
        return paramMotionEvent;
      }
    }
    if (((ial()) || (iaw())) && (Build.VERSION.SDK_INT >= 24))
    {
      paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1008);
      AppMethodBeat.o(201930);
      return paramMotionEvent;
    }
    paramMotionEvent = super.onResolvePointerIcon(paramMotionEvent, paramInt);
    AppMethodBeat.o(201930);
    return paramMotionEvent;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(201696);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(201696);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.LV != null) {
      setText(localSavedState.LV);
    }
    if ((localSavedState.YgJ >= 0) && (localSavedState.YgK >= 0) && (this.Yfs != null))
    {
      int i = this.mText.length();
      if ((localSavedState.YgJ <= i) && (localSavedState.YgK <= i)) {
        break label201;
      }
      paramParcelable = "";
      if (localSavedState.LV != null) {
        paramParcelable = "(restored) ";
      }
      Log.e("cmEdit.CMTextView", "Saved cursor position " + localSavedState.YgJ + "/" + localSavedState.YgK + " out of range for " + paramParcelable + "text " + this.mText);
    }
    for (;;)
    {
      if (localSavedState.YgM != null)
      {
        iaI();
        b.a(localSavedState.YgM);
      }
      AppMethodBeat.o(201696);
      return;
      label201:
      Selection.setSelection(this.Yfs, localSavedState.YgJ, localSavedState.YgK);
      if (localSavedState.YgL)
      {
        iaI();
        this.Ygi.Yhu = true;
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    AppMethodBeat.i(202494);
    super.onRtlPropertiesChanged(paramInt);
    TextDirectionHeuristic localTextDirectionHeuristic = getTextDirectionHeuristic();
    if (this.Mg != localTextDirectionHeuristic)
    {
      this.Mg = localTextDirectionHeuristic;
      if (this.WoF != null) {
        Ku();
      }
    }
    AppMethodBeat.o(202494);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(201689);
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
          if (this.Ygi != null) {
            h(localSpannableStringBuilder);
          }
        }
        label160:
        for (((SavedState)localObject).LV = localSpannableStringBuilder;; ((SavedState)localObject).LV = this.mText.toString())
        {
          if (k != 0)
          {
            ((SavedState)localObject).YgJ = j;
            ((SavedState)localObject).YgK = i;
          }
          if ((isFocused()) && (j >= 0) && (i >= 0)) {
            ((SavedState)localObject).YgL = true;
          }
          AppMethodBeat.o(201689);
          return localObject;
        }
      }
      AppMethodBeat.o(201689);
      return localObject;
      continue;
      i = -1;
      j = -1;
    }
  }
  
  public void onScreenStateChanged(int paramInt)
  {
    AppMethodBeat.i(201820);
    super.onScreenStateChanged(paramInt);
    b localb;
    if (this.Ygi != null)
    {
      localb = this.Ygi;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(201820);
      return;
      localb.iaQ();
      AppMethodBeat.o(201820);
      return;
      localb.iaP();
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(202415);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Ygi != null)
    {
      b localb = this.Ygi;
      if (localb.YhS != null) {
        localb.YhS.YjI = true;
      }
      if ((localb.Yhk != null) && (Build.VERSION.SDK_INT >= 23)) {
        localb.Yhk.invalidateContentRect();
      }
    }
    AppMethodBeat.o(202415);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(202398);
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
        AppMethodBeat.o(202398);
        return false;
      case 16908319: 
        boolean bool = iau();
        iaG();
        if ((this.Ygi != null) && (bool)) {
          this.Ygi.ibm().ibU();
        }
        AppMethodBeat.o(202398);
        return true;
      case 16908338: 
        AppMethodBeat.o(202398);
        return true;
      case 16908339: 
        AppMethodBeat.o(202398);
        return true;
      case 16908322: 
        T(j, i, true);
        AppMethodBeat.o(202398);
        return true;
      case 16908337: 
        T(j, i, false);
        AppMethodBeat.o(202398);
        return true;
      case 16908320: 
        if (a(ClipData.newPlainText(null, mS(j, i)))) {
          mT(j, i);
        }
        for (;;)
        {
          AppMethodBeat.o(202398);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908321: 
        paramInt = getSelectionStart();
        i = getSelectionEnd();
        if (a(ClipData.newPlainText(null, mS(Math.max(0, Math.min(paramInt, i)), Math.max(0, Math.max(paramInt, i)))))) {
          iaB();
        }
        for (;;)
        {
          AppMethodBeat.o(202398);
          return true;
          Toast.makeText(getContext(), "剪贴失败", 0).show();
        }
      case 16908340: 
        if (this.Ygi != null)
        {
          localObject1 = this.Ygi;
          ((b)localObject1).iaO();
          paramInt = (((b)localObject1).Yhe.getSelectionStart() + ((b)localObject1).Yhe.getSelectionEnd()) / 2;
          Selection.setSelection((Spannable)((b)localObject1).Yhe.getText(), paramInt);
        }
        AppMethodBeat.o(202398);
        return true;
      case 16908341: 
        localObject1 = getSelectedText();
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
        {
          Object localObject2 = new Intent("android.intent.action.SEND");
          ((Intent)localObject2).setType("text/plain");
          ((Intent)localObject2).removeExtra("android.intent.extra.TEXT");
          ((Intent)localObject2).putExtra("android.intent.extra.TEXT", (String)com.tencent.mm.ui.widget.cedit.util.c.p((CharSequence)localObject1, 100000));
          localObject1 = getContext();
          localObject2 = Intent.createChooser((Intent)localObject2, null);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/widget/cedit/edit/CustomTextView", "shareSelectedText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Selection.setSelection(this.Yfs, getSelectionEnd());
        }
        AppMethodBeat.o(202398);
        return true;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = (AutofillManager)getContext().getSystemService(AutofillManager.class);
        if (localObject1 != null) {
          ((AutofillManager)localObject1).requestAutofill(this);
        }
      }
      iaB();
      AppMethodBeat.o(202398);
      return true;
      j = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(202297);
    if (!b(paramMotionEvent, false))
    {
      AppMethodBeat.o(202297);
      return true;
    }
    int k = paramMotionEvent.getActionMasked();
    Object localObject1;
    int m;
    if (this.Ygi != null)
    {
      localObject1 = this.Ygi;
      if (paramMotionEvent.isFromSource(8194)) {
        if (((((b)localObject1).YhY ^ paramMotionEvent.getButtonState()) & 0x1) != 0)
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
        ((b)localObject1).YhY = paramMotionEvent.getButtonState();
        if (i == 0) {
          break label186;
        }
        if (paramMotionEvent.getActionMasked() == 1) {
          ((b)localObject1).Yhy = true;
        }
        if ((this.Ygi.Yhi == null) || (!this.Ygi.Yhi.ibz())) {
          break label806;
        }
        AppMethodBeat.o(202297);
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
      Object localObject2 = ViewConfiguration.get(((b)localObject1).Yhe.getContext());
      c localc = ((b)localObject1).YhZ;
      int i = paramMotionEvent.getActionMasked();
      if (i == 0)
      {
        bool1 = paramMotionEvent.isFromSource(8194);
        long l1 = paramMotionEvent.getEventTime();
        long l2 = localc.Ykj;
        long l3 = localc.Ykj;
        long l4 = localc.Ykg;
        if ((l1 - l2 <= ViewConfiguration.getDoubleTapTimeout()) && (l3 - l4 <= ViewConfiguration.getDoubleTapTimeout()) && ((localc.Ykl == 1) || ((localc.Ykl == 2) && (bool1)))) {
          if (localc.Ykl == 1)
          {
            localc.Ykl = 2;
            label317:
            localc.Ykm = c.a(localc.ryy, localc.ryz, paramMotionEvent.getX(), paramMotionEvent.getY(), ((ViewConfiguration)localObject2).getScaledDoubleTapSlop());
            label348:
            localc.ryy = paramMotionEvent.getX();
            localc.ryz = paramMotionEvent.getY();
            localc.Ykg = paramMotionEvent.getEventTime();
            localc.Ykn = false;
            localc.Yko = false;
            label387:
            ((b)localObject1).ax(paramMotionEvent);
            if (((b)localObject1).Yhl)
            {
              localObject2 = ((b)localObject1).ibu();
              if ((!((b.j)localObject2).Yip.Yhm) || (!((b.j)localObject2).Yip.ibv().ibz())) {
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
        if (((b)localObject1).Yhm) {
          ((b)localObject1).ibv().B(paramMotionEvent);
        }
        if (((b)localObject1).YhN != null)
        {
          ((b)localObject1).Yhe.removeCallbacks(((b)localObject1).YhN);
          ((b)localObject1).YhN = null;
        }
        if (paramMotionEvent.getActionMasked() != 0) {
          break;
        }
        ((b)localObject1).Yhw = false;
        ((b)localObject1).Xlf = false;
        break;
        localc.Ykl = 3;
        break label317;
        localc.Ykl = 1;
        localc.Ykm = false;
        break label348;
        if (i == 1)
        {
          localc.Ykh = paramMotionEvent.getX();
          localc.Yki = paramMotionEvent.getY();
          localc.Ykj = paramMotionEvent.getEventTime();
          localc.Ykn = false;
          localc.Yko = false;
          break label387;
        }
        if (i == 2)
        {
          if (localc.Ykn) {
            break label387;
          }
          float f1 = paramMotionEvent.getX() - localc.ryy;
          float f2 = paramMotionEvent.getY() - localc.ryz;
          i = ((ViewConfiguration)localObject2).getScaledTouchSlop();
          if (f1 * f1 + f2 * f2 > i * i)
          {
            bool1 = true;
            label666:
            localc.Ykn = bool1;
            if (!localc.Ykn) {
              break label387;
            }
            if (Math.abs(f1) > Math.abs(f2)) {
              break label712;
            }
          }
          label712:
          for (bool1 = true;; bool1 = false)
          {
            localc.Yko = bool1;
            break;
            bool1 = false;
            break label666;
          }
        }
        if (i != 3) {
          break label387;
        }
        localc.Ykg = 0L;
        localc.Ykj = 0L;
        localc.Ykl = 0;
        localc.Ykm = false;
        localc.Ykn = false;
        localc.Yko = false;
        break label387;
        if ((!paramMotionEvent.isFromSource(8194)) && (((b.j)localObject2).Yjs))
        {
          ((b.j)localObject2).aA(paramMotionEvent);
          continue;
          if (((b.j)localObject2).Yjs) {
            ((b.j)localObject2).ibH();
          }
        }
      }
      label806:
      if ((this.Ygi.Yhj != null) && (this.Ygi.Yhj.ibP()))
      {
        AppMethodBeat.o(202297);
        return true;
      }
    }
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    if ((this.Ygi != null) && (this.Ygi.Yhy) && (k == 1))
    {
      this.Ygi.Yhy = false;
      if (this.Ygi.Yig)
      {
        this.Ygi.ibh();
        this.Ygi.Yig = false;
      }
      AppMethodBeat.o(202297);
      return bool1;
    }
    if ((k == 1) && ((this.Ygi == null) || (!this.Ygi.Xlf)) && (isFocused()))
    {
      k = 1;
      if (((this.Yfw == null) && (!onCheckIsTextEditor())) || (!isEnabled()) || (!(this.mText instanceof Spannable)) || (this.WoF == null)) {
        break label1175;
      }
      if (this.Yfw == null) {
        break label1187;
      }
    }
    label1175:
    label1187:
    for (int j = this.Yfw.a(this, this.Yfs, paramMotionEvent) | false;; j = 0)
    {
      boolean bool2 = ial();
      if ((k != 0) && (this.YfI) && (this.YfH != 0) && (bool2))
      {
        localObject1 = (ClickableSpan[])this.Yfs.getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
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
          if (!iaw())
          {
            m = j;
            if (!bool2) {}
          }
          else
          {
            localObject1 = getInputMethodManager();
            a((InputMethodManager)localObject1);
            if ((iaw()) && (this.Ygi.YhG) && (localObject1 != null)) {
              ((InputMethodManager)localObject1).showSoftInput(this, 0);
            }
            this.Ygi.ay(paramMotionEvent);
            m = 1;
          }
        }
        if (m != 0)
        {
          AppMethodBeat.o(202297);
          return true;
          k = 0;
          break;
        }
        AppMethodBeat.o(202297);
        return bool1;
      }
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(202307);
    boolean bool = super.onTrackballEvent(paramMotionEvent);
    AppMethodBeat.o(202307);
    return bool;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(202272);
    super.onVisibilityChanged(paramView, paramInt);
    if ((this.Ygi != null) && (paramInt != 0))
    {
      this.Ygi.iaO();
      iaB();
    }
    AppMethodBeat.o(202272);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(202265);
    super.onWindowFocusChanged(paramBoolean);
    if (this.Ygi != null)
    {
      b localb = this.Ygi;
      if (paramBoolean)
      {
        if (localb.YhB != null)
        {
          localb.YhB.mCancelled = false;
          localb.ibx();
        }
        if ((localb.Yhe.iau()) && (!localb.ibq()))
        {
          localb.ibg();
          AppMethodBeat.o(202265);
        }
      }
      else
      {
        if (localb.YhB != null) {
          localb.YhB.cancel();
        }
        if (localb.Yhs != null) {
          localb.Yhs.Yjb = false;
        }
        localb.iaO();
        localb.ibt();
        localb.ibb();
        localb.iaY();
      }
    }
    AppMethodBeat.o(202265);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(202557);
    switch (paramInt)
    {
    default: 
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(202557);
      return bool1;
    case 2097152: 
      if ((!isEnabled()) || (this.Yft != TextView.BufferType.EDITABLE))
      {
        AppMethodBeat.o(202557);
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
            Selection.setSelection(this.Yfs, paramInt);
          }
        }
        AppMethodBeat.o(202557);
        return true;
      }
    case 16: 
      if (!isEnabled())
      {
        AppMethodBeat.o(202557);
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
      if (this.Yfw == null)
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
          if (this.WoF != null) {
            if (!iaw())
            {
              bool2 = bool1;
              if (!ial()) {}
            }
            else
            {
              bool2 = bool1;
              if (isFocused())
              {
                paramBundle = getInputMethodManager();
                a(paramBundle);
                bool2 = bool1;
                if (!ial())
                {
                  bool2 = bool1;
                  if (this.Ygi.YhG)
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
        AppMethodBeat.o(202557);
        return bool2;
      }
      if ((isFocused()) && (iaD()) && (onTextContextMenuItem(16908321)))
      {
        AppMethodBeat.o(202557);
        return true;
      }
      if ((isFocused()) && (iaE()) && (onTextContextMenuItem(16908322)))
      {
        AppMethodBeat.o(202557);
        return true;
      }
      AppMethodBeat.o(202557);
      return false;
      if ((isFocused()) && (iaC()) && (onTextContextMenuItem(16908320)))
      {
        AppMethodBeat.o(202557);
        return true;
      }
      AppMethodBeat.o(202557);
      return false;
      iaJ();
      CharSequence localCharSequence = getIterableTextForAccessibility();
      if (localCharSequence == null)
      {
        AppMethodBeat.o(202557);
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
            AppMethodBeat.o(202557);
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
            if (this.Ygi != null) {
              this.Ygi.ibm().ibT();
            }
            AppMethodBeat.o(202557);
            return true;
          }
        }
      }
      AppMethodBeat.o(202557);
      return false;
      iaJ();
      bool1 = super.performAccessibilityAction(paramInt, paramBundle);
      AppMethodBeat.o(202557);
      return bool1;
      if (!isLongClickable()) {
        break;
      }
      if ((isEnabled()) && (this.Yft == TextView.BufferType.EDITABLE)) {
        this.Ygi.YhM = true;
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
          this.Ygi.YhM = false;
          AppMethodBeat.o(202557);
        }
        bool1 = performLongClick();
      }
    }
  }
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(202408);
    if (this.Ygi != null) {
      this.Ygi.YhL = true;
    }
    int i;
    if (super.performLongClick()) {
      i = 1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.Ygi != null)
      {
        boolean bool3 = this.Ygi.Hu(bool1);
        bool2 = bool1 | bool3;
        Log.i("cmEdit.CMTextView", "editor performLongClick handled =".concat(String.valueOf(bool3)));
        this.Ygi.YhL = false;
      }
      if (bool2)
      {
        if (i == 0) {
          performHapticFeedback(0);
        }
        if (this.Ygi != null) {
          this.Ygi.Yhy = true;
        }
      }
      AppMethodBeat.o(202408);
      return bool2;
      i = 0;
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(202209);
    if (this.mListeners != null)
    {
      int i = this.mListeners.indexOf(paramTextWatcher);
      if (i >= 0) {
        this.mListeners.remove(i);
      }
    }
    AppMethodBeat.o(202209);
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(202376);
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      AppMethodBeat.o(202376);
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
    AppMethodBeat.o(202376);
  }
  
  public void setAdaptText(TextView paramTextView)
  {
    AppMethodBeat.i(201286);
    this.Ygk = paramTextView;
    this.Ygk.addTextChangedListener(this.Ygl);
    AppMethodBeat.o(201286);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    AppMethodBeat.i(202184);
    if (!paramBoolean) {
      setTransformationMethod(null);
    }
    AppMethodBeat.o(202184);
  }
  
  public final void setAutoLinkMask(int paramInt)
  {
    this.YfH = paramInt;
  }
  
  public void setBreakStrategy(int paramInt)
  {
    AppMethodBeat.i(201569);
    this.Mh = paramInt;
    if (this.WoF != null)
    {
      hKs();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(201569);
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    AppMethodBeat.i(201459);
    b localb2 = this.Yfq;
    b localb1;
    if (paramInt == 0) {
      if (localb2 != null) {
        localb1 = localb2;
      }
    }
    for (;;)
    {
      localb1.Wpy = paramInt;
      invalidate();
      requestLayout();
      AppMethodBeat.o(201459);
      return;
      localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(getContext());
        this.Yfq = localb1;
      }
    }
  }
  
  public void setCompoundDrawableTintBlendMode(BlendMode paramBlendMode)
  {
    AppMethodBeat.i(201464);
    if (this.Yfq == null) {
      this.Yfq = new b(getContext());
    }
    this.Yfq.Ygv = paramBlendMode;
    this.Yfq.jH = true;
    iah();
    AppMethodBeat.o(201464);
  }
  
  public void setCompoundDrawableTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201461);
    if (this.Yfq == null) {
      this.Yfq = new b(getContext());
    }
    this.Yfq.jE = paramColorStateList;
    this.Yfq.Ygw = true;
    iah();
    AppMethodBeat.o(201461);
  }
  
  public void setCompoundDrawableTintMode(PorterDuff.Mode paramMode) {}
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(202203);
    if ((paramBoolean) && (this.Ygi == null))
    {
      AppMethodBeat.o(202203);
      return;
    }
    iaI();
    if (this.Ygi.YhC != paramBoolean)
    {
      this.Ygi.YhC = paramBoolean;
      invalidate();
      this.Ygi.ibx();
      this.Ygi.iaN();
    }
    AppMethodBeat.o(202203);
  }
  
  public void setCustomInsertionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(202423);
    iaI();
    this.Ygi.YhW = paramCallback;
    AppMethodBeat.o(202423);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(202420);
    iaI();
    this.Ygi.YhV = paramCallback;
    AppMethodBeat.o(202420);
  }
  
  public final void setEditableFactory(Editable.Factory paramFactory)
  {
    AppMethodBeat.i(201701);
    this.Woz = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(201701);
  }
  
  public void setElegantTextHeight(boolean paramBoolean)
  {
    AppMethodBeat.i(201557);
    if (paramBoolean != this.wi.isElegantTextHeight())
    {
      this.wi.setElegantTextHeight(paramBoolean);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201557);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(202195);
    if (this.WoB != paramTruncateAt)
    {
      this.WoB = paramTruncateAt;
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(202195);
  }
  
  public void setEms(int paramInt)
  {
    AppMethodBeat.i(201659);
    this.lj = paramInt;
    this.uJ = paramInt;
    this.YfN = 1;
    this.YfM = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201659);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(201377);
    if (paramBoolean == isEnabled())
    {
      AppMethodBeat.o(201377);
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
    if (this.Ygi != null)
    {
      this.Ygi.iaN();
      this.Ygi.ibx();
    }
    AppMethodBeat.o(201377);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201773);
    iaI();
    AppMethodBeat.o(201773);
  }
  
  public void setExtractedText(ExtractedText paramExtractedText)
  {
    int m = 0;
    AppMethodBeat.i(202017);
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
      AppMethodBeat.o(202017);
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
    AppMethodBeat.i(202021);
    if (this.Ygi.Yht != null) {
      this.Ygi.Yht.Yjd = paramExtractedTextRequest;
    }
    this.Ygi.iaO();
    iaB();
    if (this.Ygi.Yhj != null) {
      this.Ygi.Yhj.ibM();
    }
    AppMethodBeat.o(202021);
  }
  
  public void setFallbackLineSpacing(boolean paramBoolean)
  {
    AppMethodBeat.i(201558);
    if (this.YfF != paramBoolean)
    {
      this.YfF = paramBoolean;
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201558);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    AppMethodBeat.i(201774);
    if (paramArrayOfInputFilter == null)
    {
      paramArrayOfInputFilter = new IllegalArgumentException();
      AppMethodBeat.o(201774);
      throw paramArrayOfInputFilter;
    }
    this.YfS = paramArrayOfInputFilter;
    if ((this.mText instanceof Editable)) {
      a((Editable)this.mText, paramArrayOfInputFilter);
    }
    AppMethodBeat.o(201774);
  }
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    AppMethodBeat.i(201483);
    com.tencent.mm.ui.widget.cedit.util.b.bv(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.top;; i = localFontMetricsInt.ascent)
    {
      if (paramInt > Math.abs(i))
      {
        i = -i;
        setPadding(getPaddingLeft(), paramInt - i, getPaddingRight(), getPaddingBottom());
      }
      AppMethodBeat.o(201483);
      return;
    }
  }
  
  public void setFontFeatureSettings(String paramString)
  {
    AppMethodBeat.i(201572);
    if (paramString != this.wi.getFontFeatureSettings())
    {
      this.wi.setFontFeatureSettings(paramString);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201572);
  }
  
  public void setFreezesText(boolean paramBoolean)
  {
    this.Yfg = paramBoolean;
  }
  
  public void setGravity(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(201614);
    if ((paramInt & 0x800007) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      if ((i & 0x800007) != (this.sK & 0x800007)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if (i != this.sK) {
          invalidate();
        }
        this.sK = i;
        if ((this.WoF != null) && (paramInt != 0))
        {
          i = this.WoF.getWidth();
          if (this.Yfv != null) {
            break label141;
          }
        }
        label141:
        for (paramInt = j;; paramInt = this.Yfv.getWidth())
        {
          BoringLayout.Metrics localMetrics = Wpg;
          a(i, paramInt, localMetrics, localMetrics, getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight(), true);
          AppMethodBeat.o(201614);
          return;
        }
      }
    }
  }
  
  public void setHandleColorRes(int paramInt)
  {
    this.Ygn = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    AppMethodBeat.i(201642);
    this.WoK = paramInt;
    this.WoI = paramInt;
    this.WoL = 2;
    this.WoJ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201642);
  }
  
  public void setHighlightColor(int paramInt)
  {
    AppMethodBeat.i(201579);
    if (this.rGp != paramInt)
    {
      this.rGp = paramInt;
      invalidate();
    }
    AppMethodBeat.o(201579);
  }
  
  public final void setHint(int paramInt)
  {
    AppMethodBeat.i(201721);
    setHint(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(201721);
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201718);
    setHintInternal(paramCharSequence);
    if (this.Ygi != null)
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
        this.Ygi.ibc();
      }
      AppMethodBeat.o(201718);
      return;
    }
  }
  
  public final void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(201598);
    this.Yfd = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(201598);
  }
  
  public final void setHintTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201600);
    this.Yfd = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(201600);
  }
  
  public void setHorizontallyScrolling(boolean paramBoolean)
  {
    AppMethodBeat.i(201621);
    if (this.YfG != paramBoolean)
    {
      this.YfG = paramBoolean;
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201621);
  }
  
  public void setImeHintLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(201770);
    iaI();
    this.Ygi.iaL();
    this.Ygi.Yhs.Yjc = paramLocaleList;
    KeyListener localKeyListener;
    if ((this.YfE) && (Build.VERSION.SDK_INT >= 24)) {
      if (paramLocaleList == null)
      {
        paramLocaleList = null;
        if ((this.YfD) || (this.Ygi == null)) {
          break label250;
        }
        localKeyListener = this.Ygi.Yhx;
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
      boolean bool = axI(this.Ygi.IhY);
      setKeyListenerOnly(paramLocaleList);
      iaf();
      if (bool)
      {
        int i = this.Ygi.IhY & 0xF;
        if (i == 1)
        {
          paramLocaleList = this.Ygi;
          paramLocaleList.IhY |= 0x80;
          AppMethodBeat.o(201770);
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
          AppMethodBeat.o(201770);
          return;
        }
        if (i == 2)
        {
          paramLocaleList = this.Ygi;
          paramLocaleList.IhY |= 0x10;
        }
      }
      label250:
      AppMethodBeat.o(201770);
      return;
      label257:
      paramLocaleList = localKeyListener;
    }
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(201753);
    iaI();
    this.Ygi.iaL();
    this.Ygi.Yhs.nlD = paramInt;
    AppMethodBeat.o(201753);
  }
  
  public void setIncludeFontPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(202083);
    if (this.WoP != paramBoolean)
    {
      this.WoP = paramBoolean;
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(202083);
  }
  
  public void setInputExtras(int paramInt)
  {
    AppMethodBeat.i(201763);
    iaI();
    XmlResourceParser localXmlResourceParser = getResources().getXml(paramInt);
    this.Ygi.iaL();
    this.Ygi.Yhs.extras = new Bundle();
    getResources().parseBundleExtras(localXmlResourceParser, this.Ygi.Yhs.extras);
    AppMethodBeat.o(201763);
  }
  
  public void setInputType(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(201736);
    boolean bool1 = axI(getInputType());
    boolean bool4 = axJ(getInputType());
    cb(paramInt, false);
    boolean bool3 = axI(paramInt);
    boolean bool5 = axJ(paramInt);
    if (bool3)
    {
      setTransformationMethod(PasswordTransformationMethod.getInstance());
      a(null, null, 3, 0, -1);
      i = 0;
      if (!axH(paramInt))
      {
        bool1 = true;
        label76:
        if ((this.Wmc != bool1) || (i != 0))
        {
          if (!bool3) {
            bool2 = true;
          }
          p(bool1, bool2, true);
        }
        if (!iaA()) {
          setTextInternal(aM(this.mText));
        }
        InputMethodManager localInputMethodManager = getInputMethodManager();
        if (localInputMethodManager != null) {
          localInputMethodManager.restartInput(this);
        }
        AppMethodBeat.o(201736);
      }
    }
    else if (bool5)
    {
      if (this.Yfx != PasswordTransformationMethod.getInstance()) {
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
        if (this.Yfx == PasswordTransformationMethod.getInstance())
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
    AppMethodBeat.i(201393);
    this.YfD = true;
    setKeyListenerOnly(paramKeyListener);
    iag();
    if (paramKeyListener != null)
    {
      iaI();
      iaf();
    }
    for (;;)
    {
      paramKeyListener = getInputMethodManager();
      if (paramKeyListener != null) {
        paramKeyListener.restartInput(this);
      }
      AppMethodBeat.o(201393);
      return;
      if (this.Ygi != null) {
        this.Ygi.IhY = 0;
      }
    }
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    AppMethodBeat.i(201484);
    com.tencent.mm.ui.widget.cedit.util.b.bv(paramInt);
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    if (getIncludeFontPadding()) {}
    for (int i = localFontMetricsInt.bottom;; i = localFontMetricsInt.descent)
    {
      if (paramInt > Math.abs(i)) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt - i);
      }
      AppMethodBeat.o(201484);
      return;
    }
  }
  
  public void setLetterSpacing(float paramFloat)
  {
    AppMethodBeat.i(201564);
    if (paramFloat != this.wi.getLetterSpacing())
    {
      this.wi.setLetterSpacing(paramFloat);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201564);
  }
  
  @SuppressLint({"RestrictedApi"})
  public void setLineHeight(int paramInt)
  {
    AppMethodBeat.i(201665);
    com.tencent.mm.ui.widget.cedit.util.b.bv(paramInt);
    int i = getPaint().getFontMetricsInt(null);
    if (paramInt != i)
    {
      float f = paramInt - i;
      if ((this.WoH != f) || (this.WoG != 1.0F))
      {
        this.WoH = f;
        this.WoG = 1.0F;
        if (this.WoF != null)
        {
          hKs();
          requestLayout();
          invalidate();
        }
      }
    }
    AppMethodBeat.o(201665);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(201640);
    this.WoK = paramInt;
    this.WoI = paramInt;
    this.WoL = 1;
    this.WoJ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201640);
  }
  
  public final void setLinkTextColor(int paramInt)
  {
    AppMethodBeat.i(201605);
    this.Yfe = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(201605);
  }
  
  public final void setLinkTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201606);
    this.Yfe = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(201606);
  }
  
  public final void setLinksClickable(boolean paramBoolean)
  {
    this.YfI = paramBoolean;
  }
  
  public void setMaxEms(int paramInt)
  {
    AppMethodBeat.i(201651);
    this.uJ = paramInt;
    this.YfM = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201651);
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(201636);
    this.WoI = paramInt;
    this.WoJ = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201636);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(201632);
    this.WoI = paramInt;
    this.WoJ = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201632);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(201655);
    this.uJ = paramInt;
    this.YfM = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201655);
  }
  
  public void setMenuCallback(a.e parame)
  {
    this.Ygp = parame;
  }
  
  public void setMinEms(int paramInt)
  {
    AppMethodBeat.i(201644);
    this.lj = paramInt;
    this.YfN = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201644);
  }
  
  public void setMinHeight(int paramInt)
  {
    AppMethodBeat.i(201627);
    this.WoK = paramInt;
    this.WoL = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201627);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(201624);
    this.WoK = paramInt;
    this.WoL = 1;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201624);
  }
  
  public void setMinWidth(int paramInt)
  {
    AppMethodBeat.i(201649);
    this.lj = paramInt;
    this.YfN = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201649);
  }
  
  public final void setMovementMethod(com.tencent.mm.ui.widget.cedit.b.d paramd)
  {
    AppMethodBeat.i(201402);
    if (this.Yfw != paramd)
    {
      this.Yfw = paramd;
      if ((paramd != null) && (this.Yfs == null)) {
        setText(this.mText);
      }
      iag();
      if (this.Ygi != null) {
        this.Ygi.iaN();
      }
    }
    AppMethodBeat.o(201402);
  }
  
  public void setOnEditorActionListener(c paramc)
  {
    AppMethodBeat.i(201757);
    iaI();
    this.Ygi.iaL();
    this.Ygi.Yhs.Yja = paramc;
    AppMethodBeat.o(201757);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201476);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      hKs();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(201476);
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201478);
    if ((paramInt1 != getPaddingStart()) || (paramInt3 != getPaddingEnd()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      hKs();
    }
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    AppMethodBeat.o(201478);
  }
  
  public void setPaintFlags(int paramInt)
  {
    AppMethodBeat.i(201619);
    if (this.wi.getFlags() != paramInt)
    {
      this.wi.setFlags(paramInt);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201619);
  }
  
  public void setPrivateImeOptions(String paramString)
  {
    AppMethodBeat.i(201758);
    iaI();
    this.Ygi.iaL();
    this.Ygi.Yhs.YiX = paramString;
    AppMethodBeat.o(201758);
  }
  
  public void setRawInputType(int paramInt)
  {
    AppMethodBeat.i(201739);
    if ((paramInt == 0) && (this.Ygi == null))
    {
      AppMethodBeat.o(201739);
      return;
    }
    iaI();
    this.Ygi.IhY = paramInt;
    AppMethodBeat.o(201739);
  }
  
  public void setReuseBrands(List<String> paramList)
  {
    AppMethodBeat.i(202538);
    if (paramList != null)
    {
      this.Ygr.clear();
      this.Ygr.addAll(paramList);
    }
    AppMethodBeat.o(202538);
  }
  
  public void setReuseItems(List<String> paramList)
  {
    AppMethodBeat.i(202534);
    if (paramList != null)
    {
      this.Ygq.clear();
      this.Ygq.addAll(paramList);
    }
    AppMethodBeat.o(202534);
  }
  
  public void setScroller(Scroller paramScroller)
  {
    this.mScroller = paramScroller;
  }
  
  public void setSelectAllOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(202198);
    iaI();
    this.Ygi.YhD = paramBoolean;
    if ((paramBoolean) && (!(this.mText instanceof Spannable))) {
      setText(this.mText, TextView.BufferType.SPANNABLE);
    }
    AppMethodBeat.o(202198);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(202280);
    isSelected();
    super.setSelected(paramBoolean);
    AppMethodBeat.o(202280);
  }
  
  public final void setShowSoftInputOnFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(201585);
    iaI();
    this.Ygi.YhG = paramBoolean;
    AppMethodBeat.o(201585);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(202187);
    setInputTypeSingleLine(paramBoolean);
    p(paramBoolean, true, true);
    AppMethodBeat.o(202187);
  }
  
  public final void setSpannableFactory(Spannable.Factory paramFactory)
  {
    AppMethodBeat.i(201703);
    this.WoA = paramFactory;
    setText(this.mText);
    AppMethodBeat.o(201703);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(201715);
    setText(getContext().getResources().getText(paramInt));
    AppMethodBeat.o(201715);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201707);
    setText(paramCharSequence, this.Yft);
    AppMethodBeat.o(201707);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(201710);
    a(paramCharSequence, paramBufferType, true, 0);
    AppMethodBeat.o(201710);
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    this.Yfm = paramTextClassifier;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(201574);
    this.Hkc = ColorStateList.valueOf(paramInt);
    updateTextColors();
    AppMethodBeat.o(201574);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(201576);
    if (paramColorStateList == null)
    {
      paramColorStateList = new NullPointerException();
      AppMethodBeat.o(201576);
      throw paramColorStateList;
    }
    this.Hkc = paramColorStateList;
    updateTextColors();
    AppMethodBeat.o(201576);
  }
  
  public void setTextCursorDrawable(int paramInt)
  {
    AppMethodBeat.i(201509);
    if (paramInt != 0) {}
    for (Drawable localDrawable = getContext().getDrawable(paramInt);; localDrawable = null)
    {
      setTextCursorDrawable(localDrawable);
      AppMethodBeat.o(201509);
      return;
    }
  }
  
  public void setTextCursorDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(201506);
    this.YfZ = paramDrawable;
    this.YfY = 0;
    if (this.Ygi != null) {
      this.Ygi.iby();
    }
    AppMethodBeat.o(201506);
  }
  
  public void setTextIsSelectable(boolean paramBoolean)
  {
    AppMethodBeat.i(201855);
    if ((!paramBoolean) && (this.Ygi == null))
    {
      AppMethodBeat.o(201855);
      return;
    }
    iaI();
    if (this.Ygi.YhE == paramBoolean)
    {
      AppMethodBeat.o(201855);
      return;
    }
    this.Ygi.YhE = paramBoolean;
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
      localObject = com.tencent.mm.ui.widget.cedit.b.a.ibX();
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
      this.Ygi.iaN();
      AppMethodBeat.o(201855);
      return;
      setFocusable(paramBoolean);
      break;
      localObject = null;
      break label91;
    }
  }
  
  public final void setTextKeepState(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(201709);
    TextView.BufferType localBufferType = this.Yft;
    int i = getSelectionStart();
    int j = getSelectionEnd();
    int k = paramCharSequence.length();
    setText(paramCharSequence, localBufferType);
    if (((i >= 0) || (j >= 0)) && (this.Yfs != null)) {
      Selection.setSelection(this.Yfs, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }
    AppMethodBeat.o(201709);
  }
  
  public void setTextLocale(Locale paramLocale)
  {
    AppMethodBeat.i(201523);
    this.YfB = true;
    this.wi.setTextLocale(paramLocale);
    if (this.WoF != null)
    {
      hKs();
      requestLayout();
      invalidate();
    }
    AppMethodBeat.o(201523);
  }
  
  public void setTextLocales(LocaleList paramLocaleList)
  {
    AppMethodBeat.i(201524);
    this.YfB = true;
    if (Build.VERSION.SDK_INT >= 24) {
      this.wi.setTextLocales(paramLocaleList);
    }
    for (;;)
    {
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
      AppMethodBeat.o(201524);
      return;
      if ((paramLocaleList != null) && (paramLocaleList.size() > 0)) {
        this.wi.setTextLocale(paramLocaleList.get(0));
      }
    }
  }
  
  public final void setTextOperationUser(UserHandle paramUserHandle)
  {
    AppMethodBeat.i(202328);
    if (Objects.equals(this.YfT, paramUserHandle))
    {
      AppMethodBeat.o(202328);
      return;
    }
    if (paramUserHandle != null) {
      Process.myUserHandle().equals(paramUserHandle);
    }
    this.YfT = paramUserHandle;
    this.YfU = null;
    AppMethodBeat.o(202328);
  }
  
  public void setTextScaleX(float paramFloat)
  {
    AppMethodBeat.i(201551);
    if (paramFloat != this.wi.getTextScaleX())
    {
      this.YfA = true;
      this.wi.setTextScaleX(paramFloat);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201551);
  }
  
  public void setTextSelectHandle(int paramInt)
  {
    AppMethodBeat.i(201492);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select handle should be a valid drawable resource id.");
      setTextSelectHandle(getContext().getDrawable(paramInt));
      AppMethodBeat.o(201492);
      return;
    }
  }
  
  public void setTextSelectHandle(Drawable paramDrawable)
  {
    AppMethodBeat.i(201490);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The text select handle should not be null.");
    this.Ygf = paramDrawable;
    this.Yge = 0;
    if (this.Ygi != null) {
      this.Ygi.Hv(true);
    }
    AppMethodBeat.o(201490);
  }
  
  public void setTextSelectHandleLeft(int paramInt)
  {
    AppMethodBeat.i(201498);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select left handle should be a valid drawable resource id.");
      setTextSelectHandleLeft(getContext().getDrawable(paramInt));
      AppMethodBeat.o(201498);
      return;
    }
  }
  
  public void setTextSelectHandleLeft(Drawable paramDrawable)
  {
    AppMethodBeat.i(201496);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The left text select handle should not be null.");
    this.Ygb = paramDrawable;
    this.Yga = 0;
    if (this.Ygi != null) {
      this.Ygi.Hv(true);
    }
    AppMethodBeat.o(201496);
  }
  
  public void setTextSelectHandleRight(int paramInt)
  {
    AppMethodBeat.i(201503);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.ui.widget.cedit.util.b.checkArgument(bool, "The text select right handle should be a valid drawable resource id.");
      setTextSelectHandleRight(getContext().getDrawable(paramInt));
      AppMethodBeat.o(201503);
      return;
    }
  }
  
  public void setTextSelectHandleRight(Drawable paramDrawable)
  {
    AppMethodBeat.i(201502);
    com.tencent.mm.ui.widget.cedit.util.b.checkNotNull(paramDrawable, "The right text select handle should not be null.");
    this.Ygd = paramDrawable;
    this.Ygc = 0;
    if (this.Ygi != null) {
      this.Ygi.Hv(true);
    }
    AppMethodBeat.o(201502);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(201539);
    setTextSize(2, paramFloat);
    AppMethodBeat.o(201539);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(201542);
    int i;
    if ((dC()) && (this.rJ != 0))
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
      this.YfC = paramInt;
      cR(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
      AppMethodBeat.o(201542);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setTransformationMethod(TransformationMethod paramTransformationMethod)
  {
    AppMethodBeat.i(201408);
    if (paramTransformationMethod == this.Yfx)
    {
      AppMethodBeat.o(201408);
      return;
    }
    if ((this.Yfx != null) && (this.Yfs != null)) {
      this.Yfs.removeSpan(this.Yfx);
    }
    this.Yfx = paramTransformationMethod;
    this.Yfy = false;
    setText(this.mText);
    this.Mg = getTextDirectionHeuristic();
    AppMethodBeat.o(201408);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(201553);
    if (this.wi.getTypeface() != paramTypeface)
    {
      this.wi.setTypeface(paramTypeface);
      if (this.WoF != null)
      {
        hKs();
        requestLayout();
        invalidate();
      }
    }
    AppMethodBeat.o(201553);
  }
  
  public void setWidth(int paramInt)
  {
    AppMethodBeat.i(201660);
    this.lj = paramInt;
    this.uJ = paramInt;
    this.YfN = 2;
    this.YfM = 2;
    requestLayout();
    invalidate();
    AppMethodBeat.o(201660);
  }
  
  public boolean showContextMenu()
  {
    AppMethodBeat.i(202301);
    if (this.Ygi != null) {
      this.Ygi.aI((0.0F / 0.0F), (0.0F / 0.0F));
    }
    boolean bool = super.showContextMenu();
    AppMethodBeat.o(202301);
    return bool;
  }
  
  public boolean showContextMenu(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(202302);
    if (this.Ygi != null) {
      this.Ygi.aI(paramFloat1, paramFloat2);
    }
    boolean bool = super.showContextMenu(paramFloat1, paramFloat2);
    AppMethodBeat.o(202302);
    return bool;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(201830);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.Yfq != null))
    {
      Drawable[] arrayOfDrawable = this.Yfq.Ygu;
      int j = arrayOfDrawable.length;
      int i = 0;
      while (i < j)
      {
        if (paramDrawable == arrayOfDrawable[i])
        {
          AppMethodBeat.o(201830);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(201830);
    return bool;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    CharSequence LV;
    int YgJ;
    int YgK;
    boolean YgL;
    ParcelableParcel YgM;
    CharSequence bHq;
    
    static
    {
      AppMethodBeat.i(190984);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(190984);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(190981);
      this.YgJ = -1;
      this.YgK = -1;
      this.YgJ = paramParcel.readInt();
      this.YgK = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.YgL = bool;
        this.LV = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        if (paramParcel.readInt() != 0) {
          this.bHq = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        }
        if (paramParcel.readInt() != 0) {
          this.YgM = ((ParcelableParcel)ParcelableParcel.CREATOR.createFromParcel(paramParcel));
        }
        AppMethodBeat.o(190981);
        return;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
      this.YgJ = -1;
      this.YgK = -1;
    }
    
    public String toString()
    {
      AppMethodBeat.i(190979);
      String str2 = "TextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " start=" + this.YgJ + " end=" + this.YgK;
      String str1 = str2;
      if (this.LV != null) {
        str1 = str2 + " text=" + this.LV;
      }
      str1 = str1 + "}";
      AppMethodBeat.o(190979);
      return str1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(190976);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.YgJ);
      paramParcel.writeInt(this.YgK);
      int i;
      if (this.YgL)
      {
        i = 1;
        paramParcel.writeInt(i);
        TextUtils.writeToParcel(this.LV, paramParcel, paramInt);
        if (this.bHq != null) {
          break label85;
        }
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        if (this.YgM != null) {
          break label102;
        }
        paramParcel.writeInt(0);
        AppMethodBeat.o(190976);
        return;
        i = 0;
        break;
        label85:
        paramParcel.writeInt(1);
        TextUtils.writeToParcel(this.bHq, paramParcel, paramInt);
      }
      label102:
      paramParcel.writeInt(1);
      this.YgM.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(190976);
    }
  }
  
  class a
    implements SpanWatcher, TextWatcher
  {
    private CharSequence Ygt;
    
    private a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(189282);
      CustomTextView.this.e(paramEditable);
      if (MetaKeyKeyListener.getMetaState(paramEditable, 2048) != 0) {
        com.tencent.mm.ui.widget.cedit.util.d.b(CustomTextView.this, paramEditable);
      }
      AppMethodBeat.o(189282);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(189276);
      if ((com.tencent.mm.ui.widget.cedit.util.d.ibZ()) && (CustomTextView.b(CustomTextView.this) != null)) {
        this.Ygt = CustomTextView.b(CustomTextView.this).toString();
      }
      CustomTextView.a(CustomTextView.this, paramCharSequence, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(189276);
    }
    
    public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189286);
      CustomTextView.this.a(paramSpannable, paramObject, -1, paramInt1, -1, paramInt2);
      AppMethodBeat.o(189286);
    }
    
    public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(189284);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, paramInt3, paramInt2, paramInt4);
      AppMethodBeat.o(189284);
    }
    
    public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189288);
      CustomTextView.this.a(paramSpannable, paramObject, paramInt1, -1, paramInt2, -1);
      AppMethodBeat.o(189288);
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(189278);
      CustomTextView.this.c(paramCharSequence, paramInt1, paramInt2, paramInt3);
      if ((com.tencent.mm.ui.widget.cedit.util.d.ibZ()) && ((CustomTextView.this.isFocused()) || ((CustomTextView.this.isSelected()) && (CustomTextView.this.isShown()))))
      {
        paramCharSequence = this.Ygt;
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16);
        localAccessibilityEvent.setFromIndex(paramInt1);
        localAccessibilityEvent.setRemovedCount(paramInt2);
        localAccessibilityEvent.setAddedCount(paramInt3);
        localAccessibilityEvent.setBeforeText(paramCharSequence);
        CustomTextView.this.sendAccessibilityEventUnchecked(localAccessibilityEvent);
        this.Ygt = null;
      }
      AppMethodBeat.o(189278);
    }
  }
  
  static final class b
  {
    final Rect Wpl;
    int Wpq;
    int Wpr;
    int Wps;
    int Wpt;
    int Wpu;
    int Wpv;
    int Wpw;
    int Wpx;
    int Wpy;
    Drawable YgA;
    Drawable YgB;
    boolean YgC;
    boolean YgD;
    int YgE;
    int YgF;
    int YgG;
    int YgH;
    int YgI;
    final Drawable[] Ygu;
    BlendMode Ygv;
    boolean Ygw;
    Drawable Ygx;
    Drawable Ygy;
    Drawable Ygz;
    ColorStateList jE;
    boolean jH;
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(188945);
      this.Wpl = new Rect();
      this.Ygu = new Drawable[4];
      this.YgI = -1;
      if (paramContext.getApplicationInfo().targetSdkVersion < 17) {}
      for (boolean bool = true;; bool = false)
      {
        this.YgC = bool;
        this.YgD = false;
        AppMethodBeat.o(188945);
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
    ColorStateList Hkc = null;
    int YfC = -1;
    float Yfh = 0.0F;
    float Yfi = 0.0F;
    float Yfj = 0.0F;
    int YgN = 1711528645;
    ColorStateList YgO = null;
    ColorStateList YgP = null;
    LocaleList YgQ = null;
    boolean YgR = false;
    int YgS = -1;
    int YgT = 0;
    int YgU = -1;
    boolean YgV = false;
    boolean YgW = false;
    boolean YgX = false;
    boolean YgY = false;
    boolean YgZ = false;
    boolean Yha = false;
    float Yhb = 0.0F;
    String Yhc = null;
    String Yhd = null;
    String nUv = null;
    int pyF = -1;
    Typeface rC = null;
    int raH = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(188213);
      String str = "TextAppearanceAttributes {\n    mTextColorHighlight:" + this.YgN + "\n    mTextColor:" + this.Hkc + "\n    mTextColorHint:" + this.YgO + "\n    mTextColorLink:" + this.YgP + "\n    mTextSize:" + this.pyF + "\n    mTextSizeUnit:" + this.YfC + "\n    mTextLocales:" + this.YgQ + "\n    mFontFamily:" + this.nUv + "\n    mFontTypeface:" + this.rC + "\n    mFontFamilyExplicit:" + this.YgR + "\n    mTypefaceIndex:" + this.YgS + "\n    mTextStyle:" + this.YgT + "\n    mFontWeight:" + this.YgU + "\n    mAllCaps:" + this.YgV + "\n    mShadowColor:" + this.raH + "\n    mShadowDx:" + this.Yfi + "\n    mShadowDy:" + this.Yfj + "\n    mShadowRadius:" + this.Yfh + "\n    mHasElegant:" + this.YgW + "\n    mElegant:" + this.YgX + "\n    mHasFallbackLineSpacing:" + this.YgY + "\n    mFallbackLineSpacing:" + this.YgZ + "\n    mHasLetterSpacing:" + this.Yha + "\n    mLetterSpacing:" + this.Yhb + "\n    mFontFeatureSettings:" + this.Yhc + "\n    mFontVariationSettings:" + this.Yhd + "\n}";
      AppMethodBeat.o(188213);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.edit.CustomTextView
 * JD-Core Version:    0.7.0.1
 */