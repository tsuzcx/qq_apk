package com.tencent.mm.ui.widget.happybubble;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int KYK = 2131305625;
  private static final int KYL = 2131305627;
  private boolean JsK;
  private int KYA;
  private int KYB;
  private int KYC;
  private int KYD;
  private int KYE;
  private int KYF;
  private e KYG;
  private int KYH;
  private int KYI;
  private boolean KYJ;
  private ArrayList<Object> KYM;
  private ArrayList<Integer> KYN;
  private ArrayList<Integer> KYO;
  private b KYP;
  private c KYQ;
  private d KYR;
  private Drawable KYw;
  private int KYx;
  private int KYy;
  private int KYz;
  private Context mContext;
  private int osu;
  private float pxm;
  private ColorStateList wZG;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.KYx = -2;
    this.KYy = -2;
    this.KYz = 17;
    this.JsK = false;
    this.KYM = new ArrayList();
    this.KYN = new ArrayList();
    this.KYO = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fMt();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.KYx = -2;
    this.KYy = -2;
    this.KYz = 17;
    this.JsK = false;
    this.KYM = new ArrayList();
    this.KYN = new ArrayList();
    this.KYO = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fMt();
    AppMethodBeat.o(143564);
  }
  
  private <T> void a(T paramT, int paramInt, a<T> parama)
  {
    AppMethodBeat.i(143574);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setPadding(this.KYA, this.KYB, this.KYC, this.KYD);
    localTextView.setTextSize(0, this.pxm);
    localTextView.setGravity(this.KYz);
    localTextView.setTextColor(this.wZG);
    localTextView.setBackgroundDrawable(this.KYw.getConstantState().newDrawable());
    localTextView.setTag(KYK, paramT);
    localTextView.setTag(KYL, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(localTextView, this.KYx, this.KYy);
    localTextView.setText(parama.cR(paramT));
    AppMethodBeat.o(143574);
  }
  
  private void b(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(143577);
    if (paramTextView.isSelected() != paramBoolean)
    {
      paramTextView.setSelected(paramBoolean);
      if (!paramBoolean) {
        break label75;
      }
      this.KYN.add((Integer)paramTextView.getTag(KYL));
    }
    for (;;)
    {
      if (this.KYQ != null)
      {
        paramTextView.getTag(KYK);
        ((Integer)paramTextView.getTag(KYL)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label75:
      this.KYN.remove((Integer)paramTextView.getTag(KYL));
    }
  }
  
  private int bZ(float paramFloat)
  {
    AppMethodBeat.i(143601);
    int i = (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
    AppMethodBeat.o(143601);
    return i;
  }
  
  private void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(143565);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.labels_view);
      this.KYG = e.afv(paramContext.getInt(16, 1));
      this.KYH = paramContext.getInteger(14, 0);
      this.KYI = paramContext.getInteger(15, 0);
      this.osu = paramContext.getInteger(13, 0);
      this.KYJ = paramContext.getBoolean(0, false);
      this.KYz = paramContext.getInt(2, this.KYz);
      this.KYx = paramContext.getLayoutDimension(11, this.KYx);
      this.KYy = paramContext.getLayoutDimension(4, this.KYy);
      if (!paramContext.hasValue(3)) {
        break label268;
      }
      this.wZG = paramContext.getColorStateList(3);
      this.pxm = paramContext.getDimension(10, fMx());
      if (!paramContext.hasValue(5)) {
        break label281;
      }
      int i = paramContext.getDimensionPixelOffset(5, 0);
      this.KYD = i;
      this.KYC = i;
      this.KYB = i;
      this.KYA = i;
      label182:
      this.KYF = paramContext.getDimensionPixelOffset(12, bZ(5.0F));
      this.KYE = paramContext.getDimensionPixelOffset(18, bZ(5.0F));
      if (!paramContext.hasValue(1)) {
        break label372;
      }
      i = paramContext.getResourceId(1, 0);
      if (i == 0) {
        break label352;
      }
      this.KYw = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.JsK = paramContext.getBoolean(17, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label268:
      this.wZG = ColorStateList.valueOf(-16777216);
      break;
      label281:
      this.KYA = paramContext.getDimensionPixelOffset(7, bZ(10.0F));
      this.KYB = paramContext.getDimensionPixelOffset(9, bZ(5.0F));
      this.KYC = paramContext.getDimensionPixelOffset(8, bZ(10.0F));
      this.KYD = paramContext.getDimensionPixelOffset(6, bZ(5.0F));
      break label182;
      label352:
      this.KYw = new ColorDrawable(paramContext.getColor(1, 0));
      continue;
      label372:
      this.KYw = getResources().getDrawable(2131231881);
    }
  }
  
  private void fMt()
  {
    AppMethodBeat.i(143566);
    if (isInEditMode())
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("Label 1");
      localArrayList.add("Label 2");
      localArrayList.add("Label 3");
      localArrayList.add("Label 4");
      localArrayList.add("Label 5");
      localArrayList.add("Label 6");
      localArrayList.add("Label 7");
      setLabels(localArrayList);
    }
    AppMethodBeat.o(143566);
  }
  
  private void fMu()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.KYP != null) || (this.KYG != e.KYT)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void fMw()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      b((TextView)getChildAt(i), false);
      i += 1;
    }
    this.KYN.clear();
    AppMethodBeat.o(143580);
  }
  
  private int fMx()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int kf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143568);
    int k = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i;
    if (k == 1073741824) {
      i = j;
    }
    for (;;)
    {
      paramInt1 = resolveSizeAndState(Math.max(i, getSuggestedMinimumWidth()), paramInt1, 0);
      AppMethodBeat.o(143568);
      return paramInt1;
      i = paramInt2;
      if (k == -2147483648) {
        i = Math.min(paramInt2, j);
      }
    }
  }
  
  private boolean x(TextView paramTextView)
  {
    AppMethodBeat.i(143578);
    if (this.KYR != null)
    {
      d locald = this.KYR;
      paramTextView.getTag(KYK);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(KYL)).intValue();
      if (locald.fMy())
      {
        AppMethodBeat.o(143578);
        return true;
      }
    }
    AppMethodBeat.o(143578);
    return false;
  }
  
  public final <T> void a(List<T> paramList, a<T> parama)
  {
    AppMethodBeat.i(143573);
    fMw();
    removeAllViews();
    this.KYM.clear();
    if (paramList != null)
    {
      this.KYM.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      fMu();
    }
    if (this.KYG == e.KYV) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public final void fMv()
  {
    AppMethodBeat.i(143579);
    if (this.KYG != e.KYV)
    {
      if ((this.KYG == e.KYW) && (!this.KYO.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.KYO.contains(Integer.valueOf(i)))
          {
            b((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.KYN.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      fMw();
    }
    AppMethodBeat.o(143579);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.KYO;
  }
  
  public int getLabelGravity()
  {
    return this.KYz;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.wZG;
  }
  
  public float getLabelTextSize()
  {
    return this.pxm;
  }
  
  public <T> List<T> getLabels()
  {
    return this.KYM;
  }
  
  public int getLineMargin()
  {
    return this.KYF;
  }
  
  public int getMaxLines()
  {
    return this.osu;
  }
  
  public int getMaxSelect()
  {
    return this.KYH;
  }
  
  public int getMinSelect()
  {
    return this.KYI;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.KYN.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.KYN.get(i)).intValue()).getTag(KYK);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(143585);
    return localArrayList;
  }
  
  public List<Integer> getSelectLabels()
  {
    return this.KYN;
  }
  
  public e getSelectType()
  {
    return this.KYG;
  }
  
  public int getTextPaddingBottom()
  {
    return this.KYD;
  }
  
  public int getTextPaddingLeft()
  {
    return this.KYA;
  }
  
  public int getTextPaddingRight()
  {
    return this.KYC;
  }
  
  public int getTextPaddingTop()
  {
    return this.KYB;
  }
  
  public int getWordMargin()
  {
    return this.KYE;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.KYJ) && (this.KYG != e.KYT))
      {
        if (!paramView.isSelected()) {
          break label249;
        }
        if ((this.KYG != e.KYW) || (!this.KYO.contains((Integer)paramView.getTag(KYL)))) {
          break label234;
        }
        i = 1;
        if ((i == 0) && ((this.KYG != e.KYW) || (this.KYN.size() > this.KYI))) {
          break label239;
        }
        i = 1;
        label137:
        if ((i == 0) && (this.KYG != e.KYV)) {
          break label244;
        }
        i = 1;
        label153:
        if ((i == 0) && (!x(paramView))) {
          b(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.KYP != null)
      {
        localObject = this.KYP;
        paramView.getTag(KYK);
        ((Integer)paramView.getTag(KYL)).intValue();
        ((b)localObject).bOw();
      }
      a.a(this, "com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143576);
      return;
      label234:
      i = 0;
      break;
      label239:
      i = 0;
      break label137;
      label244:
      i = 0;
      break label153;
      label249:
      if ((this.KYG == e.KYU) || (this.KYG == e.KYV))
      {
        if (!x(paramView))
        {
          fMw();
          b(paramView, true);
        }
      }
      else if ((this.KYG == e.KYW) && ((this.KYH <= 0) || (this.KYH > this.KYN.size())) && (!x(paramView))) {
        b(paramView, true);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143569);
    paramInt4 = getPaddingLeft();
    int j = getPaddingTop();
    paramInt2 = 0;
    int m = 1;
    int i3 = getChildCount();
    int i = 0;
    while (i < i3)
    {
      View localView = getChildAt(i);
      int n = m;
      int i2 = paramInt2;
      int k = j;
      int i1 = paramInt4;
      if (!this.JsK)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.osu > 0) && (n > this.osu)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.KYF + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.KYE;
      paramInt2 = Math.max(i2, localView.getMeasuredHeight());
      i += 1;
      m = n;
      j = k;
    }
    AppMethodBeat.o(143569);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143567);
    int j;
    int i;
    View localView;
    if (this.JsK)
    {
      n = getChildCount();
      j = 0;
      k = 0;
      i = 0;
      while (j < n)
      {
        localView = getChildAt(j);
        measureChild(localView, paramInt1, paramInt2);
        m = i + localView.getMeasuredWidth();
        i = m;
        if (j != n - 1) {
          i = m + this.KYE;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(kf(paramInt1, i + getPaddingLeft() + getPaddingRight()), kf(paramInt2, getPaddingTop() + k + getPaddingBottom()));
      AppMethodBeat.o(143567);
      return;
    }
    int i10 = getChildCount();
    int i11 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i2 = 1;
    int i4 = 0;
    int n = 0;
    int k = 0;
    int m = 0;
    int i1 = 0;
    int i3 = n;
    int i7 = k;
    int i8 = m;
    int i9 = i1;
    if (i4 < i10)
    {
      localView = getChildAt(i4);
      measureChild(localView, paramInt1, paramInt2);
      i3 = i2;
      int i6 = n;
      j = k;
      int i5 = m;
      i = i1;
      if (localView.getMeasuredWidth() + m > i11)
      {
        i2 += 1;
        if (this.osu > 0)
        {
          i3 = n;
          i7 = k;
          i8 = m;
          i9 = i1;
          if (i2 > this.osu) {}
        }
        else
        {
          i = i1 + this.KYF + n;
          j = Math.max(k, m);
          i6 = 0;
          i5 = 0;
          i3 = i2;
        }
      }
      else
      {
        i5 += localView.getMeasuredWidth();
        i6 = Math.max(i6, localView.getMeasuredHeight());
        i2 = i3;
        n = i6;
        k = j;
        m = i5;
        i1 = i;
        if (i4 != i10 - 1)
        {
          if (this.KYE + i5 <= i11) {
            break label457;
          }
          i2 = i3 + 1;
          if (this.osu > 0)
          {
            i3 = i6;
            i7 = j;
            i8 = i5;
            i9 = i;
            if (i2 > this.osu) {
              break label484;
            }
          }
          i1 = i + this.KYF + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label457:
          m = i5 + this.KYE;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label484:
    setMeasuredDimension(kf(paramInt1, Math.max(i7, i8) + getPaddingLeft() + getPaddingRight()), kf(paramInt2, i9 + i3 + getPaddingTop() + getPaddingBottom()));
    AppMethodBeat.o(143567);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    int j = 0;
    AppMethodBeat.i(143571);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getParcelable("key_super_state"));
      Object localObject = (ColorStateList)paramParcelable.getParcelable("key_text_color_state");
      if (localObject != null) {
        setLabelTextColor((ColorStateList)localObject);
      }
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.pxm));
      this.KYx = paramParcelable.getInt("key_label_width_state", this.KYx);
      this.KYy = paramParcelable.getInt("key_label_height_state", this.KYy);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.KYz));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.KYA != k) || (this.KYB != m) || (this.KYC != n) || (this.KYD != i1))
        {
          this.KYA = k;
          this.KYB = m;
          this.KYC = n;
          this.KYD = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.KYE));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.KYF));
      setSelectType(e.afv(paramParcelable.getInt("key_select_type_state", this.KYG.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.KYH));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.KYI));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.osu));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.KYJ));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.JsK));
      localObject = paramParcelable.getIntegerArrayList("key_select_compulsory_state");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        setCompulsorys((List)localObject);
      }
      paramParcelable = paramParcelable.getIntegerArrayList("key_select_labels_state");
      if ((paramParcelable != null) && (!paramParcelable.isEmpty()))
      {
        k = paramParcelable.size();
        localObject = new int[k];
        i = j;
        while (i < k)
        {
          localObject[i] = ((Integer)paramParcelable.get(i)).intValue();
          i += 1;
        }
        setSelects((int[])localObject);
      }
      AppMethodBeat.o(143571);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(143571);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(143570);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_super_state", super.onSaveInstanceState());
    if (this.wZG != null) {
      localBundle.putParcelable("key_text_color_state", this.wZG);
    }
    localBundle.putFloat("key_text_size_state", this.pxm);
    localBundle.putInt("key_label_width_state", this.KYx);
    localBundle.putInt("key_label_height_state", this.KYy);
    localBundle.putInt("key_label_gravity_state", this.KYz);
    localBundle.putIntArray("key_padding_state", new int[] { this.KYA, this.KYB, this.KYC, this.KYD });
    localBundle.putInt("key_word_margin_state", this.KYE);
    localBundle.putInt("key_line_margin_state", this.KYF);
    localBundle.putInt("key_select_type_state", this.KYG.value);
    localBundle.putInt("key_max_select_state", this.KYH);
    localBundle.putInt("key_min_select_state", this.KYI);
    localBundle.putInt("key_max_lines_state", this.osu);
    localBundle.putBoolean("key_indicator_state", this.KYJ);
    if (!this.KYN.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.KYN);
    }
    if (!this.KYO.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.KYO);
    }
    localBundle.putBoolean("key_single_line_state", this.JsK);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.KYG == e.KYW) && (paramList != null))
    {
      this.KYO.clear();
      this.KYO.addAll(paramList);
      fMw();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.KYG == e.KYW) && (paramVarArgs != null))
    {
      ArrayList localArrayList = new ArrayList(paramVarArgs.length);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramVarArgs[i]));
        i += 1;
      }
      setCompulsorys(localArrayList);
    }
    AppMethodBeat.o(143584);
  }
  
  public void setIndicator(boolean paramBoolean)
  {
    this.KYJ = paramBoolean;
  }
  
  public void setLabelBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(143587);
    setLabelBackgroundDrawable(new ColorDrawable(paramInt));
    AppMethodBeat.o(143587);
  }
  
  public void setLabelBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(143588);
    this.KYw = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.KYw.getConstantState().newDrawable());
      i += 1;
    }
    AppMethodBeat.o(143588);
  }
  
  public void setLabelBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(143586);
    setLabelBackgroundDrawable(getResources().getDrawable(paramInt));
    AppMethodBeat.o(143586);
  }
  
  public void setLabelGravity(int paramInt)
  {
    AppMethodBeat.i(143592);
    if (this.KYz != paramInt)
    {
      this.KYz = paramInt;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        ((TextView)getChildAt(i)).setGravity(paramInt);
        i += 1;
      }
    }
    AppMethodBeat.o(143592);
  }
  
  public void setLabelTextColor(int paramInt)
  {
    AppMethodBeat.i(143590);
    setLabelTextColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(143590);
  }
  
  public void setLabelTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(143591);
    this.wZG = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.wZG);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.pxm != paramFloat)
    {
      this.pxm = paramFloat;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        ((TextView)getChildAt(i)).setTextSize(0, paramFloat);
        i += 1;
      }
    }
    AppMethodBeat.o(143589);
  }
  
  public void setLabels(List<String> paramList)
  {
    AppMethodBeat.i(143572);
    a(paramList, new a() {});
    AppMethodBeat.o(143572);
  }
  
  public void setLineMargin(int paramInt)
  {
    AppMethodBeat.i(143593);
    if (this.KYF != paramInt)
    {
      this.KYF = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.osu != paramInt)
    {
      this.osu = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.KYH != paramInt)
    {
      this.KYH = paramInt;
      if (this.KYG == e.KYW) {
        fMw();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.KYI = paramInt;
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    AppMethodBeat.i(143599);
    this.KYP = paramb;
    fMu();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.KYQ = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.KYR = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.KYG != parame)
    {
      this.KYG = parame;
      fMw();
      if (this.KYG == e.KYV) {
        setSelects(new int[] { 0 });
      }
      if (this.KYG != e.KYW) {
        this.KYO.clear();
      }
      fMu();
    }
    AppMethodBeat.o(143595);
  }
  
  public void setSelects(List<Integer> paramList)
  {
    AppMethodBeat.i(143581);
    if (paramList != null)
    {
      int j = paramList.size();
      int[] arrayOfInt = new int[j];
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
        i += 1;
      }
      setSelects(arrayOfInt);
    }
    AppMethodBeat.o(143581);
  }
  
  public void setSelects(int... paramVarArgs)
  {
    AppMethodBeat.i(143582);
    if (this.KYG != e.KYT)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.KYG == e.KYU) || (this.KYG == e.KYV)) {}
      for (int i = 1;; i = this.KYH)
      {
        int m = paramVarArgs.length;
        int j = 0;
        while (j < m)
        {
          int n = paramVarArgs[j];
          if (n < k)
          {
            TextView localTextView = (TextView)getChildAt(n);
            if (!localArrayList.contains(localTextView))
            {
              b(localTextView, true);
              localArrayList.add(localTextView);
            }
            if ((i > 0) && (localArrayList.size() == i)) {
              break;
            }
          }
          j += 1;
        }
      }
      i = 0;
      while (i < k)
      {
        paramVarArgs = (TextView)getChildAt(i);
        if (!localArrayList.contains(paramVarArgs)) {
          b(paramVarArgs, false);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143582);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(143598);
    if (this.JsK != paramBoolean)
    {
      this.JsK = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.KYE != paramInt)
    {
      this.KYE = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface a<T>
  {
    public abstract CharSequence cR(T paramT);
  }
  
  public static abstract interface b
  {
    public abstract void bOw();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean fMy();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      KYT = new e("NONE", 0, 1);
      KYU = new e("SINGLE", 1, 2);
      KYV = new e("SINGLE_IRREVOCABLY", 2, 3);
      KYW = new e("MULTI", 3, 4);
      KYX = new e[] { KYT, KYU, KYV, KYW };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e afv(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return KYT;
      case 1: 
        return KYT;
      case 2: 
        return KYU;
      case 3: 
        return KYV;
      }
      return KYW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */