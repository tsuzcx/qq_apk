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
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int YpC = a.g.tag_key_data;
  private static final int YpD = a.g.tag_key_position;
  private ColorStateList Hkc;
  private boolean WrK;
  private int YpA;
  private boolean YpB;
  private ArrayList<Object> YpE;
  private ArrayList<Integer> YpF;
  private ArrayList<Integer> YpG;
  private b YpH;
  private c YpI;
  private d YpJ;
  private Drawable Ypn;
  private int Ypo;
  private int Ypp;
  private int Ypq;
  private int Ypr;
  private int Yps;
  private int Ypt;
  private int Ypu;
  private int Ypv;
  private int Ypw;
  private LabelsView.e Ypx;
  private int Ypy;
  private int Ypz;
  private float jAg;
  private Context mContext;
  private int sTC;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.Ypo = -2;
    this.Ypp = -2;
    this.Ypq = 17;
    this.WrK = false;
    this.YpA = 1;
    this.YpE = new ArrayList();
    this.YpF = new ArrayList();
    this.YpG = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    icT();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.Ypo = -2;
    this.Ypp = -2;
    this.Ypq = 17;
    this.WrK = false;
    this.YpA = 1;
    this.YpE = new ArrayList();
    this.YpF = new ArrayList();
    this.YpG = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    icT();
    AppMethodBeat.o(143564);
  }
  
  private boolean M(TextView paramTextView)
  {
    AppMethodBeat.i(143578);
    if (this.YpJ != null)
    {
      d locald = this.YpJ;
      paramTextView.getTag(YpC);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(YpD)).intValue();
      if (locald.icY())
      {
        AppMethodBeat.o(143578);
        return true;
      }
    }
    AppMethodBeat.o(143578);
    return false;
  }
  
  private <T> void a(T paramT, int paramInt, LabelsView.a<T> parama)
  {
    AppMethodBeat.i(143574);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setPadding(this.Ypr, this.Yps, this.Ypt, this.Ypu);
    localTextView.setTextSize(0, this.jAg);
    localTextView.setGravity(this.Ypq);
    localTextView.setTextColor(this.Hkc);
    localTextView.setBackgroundDrawable(this.Ypn.getConstantState().newDrawable());
    localTextView.setTag(YpC, paramT);
    localTextView.setTag(YpD, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(localTextView, this.Ypo, this.Ypp);
    localTextView.setText(parama.a(localTextView, paramInt, paramT));
    AppMethodBeat.o(143574);
  }
  
  private int cV(float paramFloat)
  {
    AppMethodBeat.i(143601);
    int i = (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
    AppMethodBeat.o(143601);
    return i;
  }
  
  private void d(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(143577);
    if (paramTextView.isSelected() != paramBoolean)
    {
      paramTextView.setSelected(paramBoolean);
      if (!paramBoolean) {
        break label77;
      }
      this.YpF.add((Integer)paramTextView.getTag(YpD));
    }
    for (;;)
    {
      if (this.YpI != null)
      {
        paramTextView.getTag(YpC);
        ((Integer)paramTextView.getTag(YpD)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label77:
      this.YpF.remove((Integer)paramTextView.getTag(YpD));
    }
  }
  
  private void f(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(143565);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.labels_view);
      this.Ypx = LabelsView.e.ayx(paramContext.getInt(a.m.labels_view_selectType, 1));
      this.Ypy = paramContext.getInteger(a.m.labels_view_maxSelect, 0);
      this.Ypz = paramContext.getInteger(a.m.labels_view_minSelect, 0);
      this.sTC = paramContext.getInteger(a.m.labels_view_maxLines, 0);
      this.YpB = paramContext.getBoolean(a.m.labels_view_isIndicator, false);
      this.Ypq = paramContext.getInt(a.m.labels_view_labelGravity, this.Ypq);
      this.Ypo = paramContext.getLayoutDimension(a.m.labels_view_labelTextWidth, this.Ypo);
      this.Ypp = paramContext.getLayoutDimension(a.m.labels_view_labelTextHeight, this.Ypp);
      if (!paramContext.hasValue(a.m.labels_view_labelTextColor)) {
        break label297;
      }
      this.Hkc = paramContext.getColorStateList(a.m.labels_view_labelTextColor);
      this.jAg = paramContext.getDimension(a.m.labels_view_labelTextSize, icX());
      if (!paramContext.hasValue(a.m.labels_view_labelTextPadding)) {
        break label310;
      }
      int i = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPadding, 0);
      this.Ypu = i;
      this.Ypt = i;
      this.Yps = i;
      this.Ypr = i;
      label203:
      this.Ypw = paramContext.getDimensionPixelOffset(a.m.labels_view_lineMargin, cV(5.0F));
      this.Ypv = paramContext.getDimensionPixelOffset(a.m.labels_view_wordMargin, cV(5.0F));
      if (!paramContext.hasValue(a.m.labels_view_labelBackground)) {
        break label407;
      }
      i = paramContext.getResourceId(a.m.labels_view_labelBackground, 0);
      if (i == 0) {
        break label385;
      }
      this.Ypn = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.WrK = paramContext.getBoolean(a.m.labels_view_singleLine, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label297:
      this.Hkc = ColorStateList.valueOf(-16777216);
      break;
      label310:
      this.Ypr = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingLeft, cV(10.0F));
      this.Yps = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingTop, cV(5.0F));
      this.Ypt = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingRight, cV(10.0F));
      this.Ypu = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingBottom, cV(5.0F));
      break label203;
      label385:
      this.Ypn = new ColorDrawable(paramContext.getColor(a.m.labels_view_labelBackground, 0));
      continue;
      label407:
      this.Ypn = getResources().getDrawable(a.f.default_label_bg);
    }
  }
  
  private void icT()
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
  
  private void icU()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.YpH != null) || (this.Ypx != LabelsView.e.YpL)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void icW()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      d((TextView)getChildAt(i), false);
      i += 1;
    }
    this.YpF.clear();
    AppMethodBeat.o(143580);
  }
  
  private int icX()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int mX(int paramInt1, int paramInt2)
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
  
  public final <T> void a(List<T> paramList, LabelsView.a<T> parama)
  {
    AppMethodBeat.i(143573);
    icW();
    removeAllViews();
    this.YpE.clear();
    if (paramList != null)
    {
      this.YpE.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      icU();
    }
    if (this.Ypx == LabelsView.e.YpN) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.YpG;
  }
  
  public int getLabelGravity()
  {
    return this.Ypq;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.Hkc;
  }
  
  public float getLabelTextSize()
  {
    return this.jAg;
  }
  
  public <T> List<T> getLabels()
  {
    return this.YpE;
  }
  
  public int getLineCount()
  {
    return this.YpA;
  }
  
  public int getLineMargin()
  {
    return this.Ypw;
  }
  
  public int getMaxLines()
  {
    return this.sTC;
  }
  
  public int getMaxSelect()
  {
    return this.Ypy;
  }
  
  public int getMinSelect()
  {
    return this.Ypz;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.YpF.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.YpF.get(i)).intValue()).getTag(YpC);
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
    return this.YpF;
  }
  
  public LabelsView.e getSelectType()
  {
    return this.Ypx;
  }
  
  public int getTextPaddingBottom()
  {
    return this.Ypu;
  }
  
  public int getTextPaddingLeft()
  {
    return this.Ypr;
  }
  
  public int getTextPaddingRight()
  {
    return this.Ypt;
  }
  
  public int getTextPaddingTop()
  {
    return this.Yps;
  }
  
  public int getWordMargin()
  {
    return this.Ypv;
  }
  
  public final void icV()
  {
    AppMethodBeat.i(143579);
    if (this.Ypx != LabelsView.e.YpN)
    {
      if ((this.Ypx == LabelsView.e.YpO) && (!this.YpG.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.YpG.contains(Integer.valueOf(i)))
          {
            d((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.YpF.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      icW();
    }
    AppMethodBeat.o(143579);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.YpB) && (this.Ypx != LabelsView.e.YpL))
      {
        if (!paramView.isSelected()) {
          break label245;
        }
        if ((this.Ypx != LabelsView.e.YpO) || (!this.YpG.contains((Integer)paramView.getTag(YpD)))) {
          break label230;
        }
        i = 1;
        if ((i == 0) && ((this.Ypx != LabelsView.e.YpO) || (this.YpF.size() > this.Ypz))) {
          break label235;
        }
        i = 1;
        label137:
        if ((i == 0) && (this.Ypx != LabelsView.e.YpN)) {
          break label240;
        }
        i = 1;
        label153:
        if ((i == 0) && (!M(paramView))) {
          d(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.YpH != null) {
        this.YpH.n(paramView.getTag(YpC), ((Integer)paramView.getTag(YpD)).intValue());
      }
      a.a(this, "com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143576);
      return;
      label230:
      i = 0;
      break;
      label235:
      i = 0;
      break label137;
      label240:
      i = 0;
      break label153;
      label245:
      if ((this.Ypx == LabelsView.e.YpM) || (this.Ypx == LabelsView.e.YpN))
      {
        if (!M(paramView))
        {
          icW();
          d(paramView, true);
        }
      }
      else if ((this.Ypx == LabelsView.e.YpO) && ((this.Ypy <= 0) || (this.Ypy > this.YpF.size())) && (!M(paramView))) {
        d(paramView, true);
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
      if (!this.WrK)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.sTC > 0) && (n > this.sTC)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.Ypw + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.Ypv;
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
    if (this.WrK)
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
          i = m + this.Ypv;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(mX(paramInt1, i + getPaddingLeft() + getPaddingRight()), mX(paramInt2, getPaddingTop() + k + getPaddingBottom()));
      AppMethodBeat.o(143567);
      return;
    }
    int i11 = getChildCount();
    int i12 = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int i2 = 1;
    int i4 = 0;
    int n = 0;
    int k = 0;
    int m = 0;
    int i1 = 0;
    int i3 = i2;
    int i7 = n;
    int i8 = k;
    int i9 = m;
    int i10 = i1;
    if (i4 < i11)
    {
      localView = getChildAt(i4);
      measureChild(localView, paramInt1, paramInt2);
      i3 = i2;
      int i6 = n;
      j = k;
      int i5 = m;
      i = i1;
      if (localView.getMeasuredWidth() + m > i12)
      {
        i2 += 1;
        if (this.sTC > 0)
        {
          i3 = i2;
          i7 = n;
          i8 = k;
          i9 = m;
          i10 = i1;
          if (i2 > this.sTC) {}
        }
        else
        {
          i = i1 + this.Ypw + n;
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
        if (i4 != i11 - 1)
        {
          if (this.Ypv + i5 <= i12) {
            break label469;
          }
          i2 = i3 + 1;
          if (this.sTC > 0)
          {
            i3 = i2;
            i7 = i6;
            i8 = j;
            i9 = i5;
            i10 = i;
            if (i2 > this.sTC) {
              break label496;
            }
          }
          i1 = i + this.Ypw + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label469:
          m = i5 + this.Ypv;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label496:
    this.YpA = i3;
    setMeasuredDimension(mX(paramInt1, Math.max(i8, i9) + getPaddingLeft() + getPaddingRight()), mX(paramInt2, i10 + i7 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.jAg));
      this.Ypo = paramParcelable.getInt("key_label_width_state", this.Ypo);
      this.Ypp = paramParcelable.getInt("key_label_height_state", this.Ypp);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.Ypq));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.Ypr != k) || (this.Yps != m) || (this.Ypt != n) || (this.Ypu != i1))
        {
          this.Ypr = k;
          this.Yps = m;
          this.Ypt = n;
          this.Ypu = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.Ypv));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.Ypw));
      setSelectType(LabelsView.e.ayx(paramParcelable.getInt("key_select_type_state", this.Ypx.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.Ypy));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.Ypz));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.sTC));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.YpB));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.WrK));
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
    if (this.Hkc != null) {
      localBundle.putParcelable("key_text_color_state", this.Hkc);
    }
    localBundle.putFloat("key_text_size_state", this.jAg);
    localBundle.putInt("key_label_width_state", this.Ypo);
    localBundle.putInt("key_label_height_state", this.Ypp);
    localBundle.putInt("key_label_gravity_state", this.Ypq);
    localBundle.putIntArray("key_padding_state", new int[] { this.Ypr, this.Yps, this.Ypt, this.Ypu });
    localBundle.putInt("key_word_margin_state", this.Ypv);
    localBundle.putInt("key_line_margin_state", this.Ypw);
    localBundle.putInt("key_select_type_state", this.Ypx.value);
    localBundle.putInt("key_max_select_state", this.Ypy);
    localBundle.putInt("key_min_select_state", this.Ypz);
    localBundle.putInt("key_max_lines_state", this.sTC);
    localBundle.putBoolean("key_indicator_state", this.YpB);
    if (!this.YpF.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.YpF);
    }
    if (!this.YpG.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.YpG);
    }
    localBundle.putBoolean("key_single_line_state", this.WrK);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.Ypx == LabelsView.e.YpO) && (paramList != null))
    {
      this.YpG.clear();
      this.YpG.addAll(paramList);
      icW();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.Ypx == LabelsView.e.YpO) && (paramVarArgs != null))
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
    this.YpB = paramBoolean;
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
    this.Ypn = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.Ypn.getConstantState().newDrawable());
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
    if (this.Ypq != paramInt)
    {
      this.Ypq = paramInt;
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
    this.Hkc = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.Hkc);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.jAg != paramFloat)
    {
      this.jAg = paramFloat;
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
    a(paramList, new LabelsView.1(this));
    AppMethodBeat.o(143572);
  }
  
  public void setLineMargin(int paramInt)
  {
    AppMethodBeat.i(143593);
    if (this.Ypw != paramInt)
    {
      this.Ypw = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.sTC != paramInt)
    {
      this.sTC = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.Ypy != paramInt)
    {
      this.Ypy = paramInt;
      if (this.Ypx == LabelsView.e.YpO) {
        icW();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.Ypz = paramInt;
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    AppMethodBeat.i(143599);
    this.YpH = paramb;
    icU();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.YpI = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.YpJ = paramd;
  }
  
  public void setSelectType(LabelsView.e parame)
  {
    AppMethodBeat.i(143595);
    if (this.Ypx != parame)
    {
      this.Ypx = parame;
      icW();
      if (this.Ypx == LabelsView.e.YpN) {
        setSelects(new int[] { 0 });
      }
      if (this.Ypx != LabelsView.e.YpO) {
        this.YpG.clear();
      }
      icU();
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
    if (this.Ypx != LabelsView.e.YpL)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.Ypx == LabelsView.e.YpM) || (this.Ypx == LabelsView.e.YpN)) {}
      for (int i = 1;; i = this.Ypy)
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
              d(localTextView, true);
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
          d(paramVarArgs, false);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143582);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(143598);
    if (this.WrK != paramBoolean)
    {
      this.WrK = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.Ypv != paramInt)
    {
      this.Ypv = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface b
  {
    public abstract void n(Object paramObject, int paramInt);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean icY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */