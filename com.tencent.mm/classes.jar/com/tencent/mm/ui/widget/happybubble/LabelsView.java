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
  private static final int aghP = a.g.tag_key_data;
  private static final int aghQ = a.g.tag_key_position;
  private ColorStateList NhP;
  private boolean adZa;
  private Drawable aghA;
  private int aghB;
  private int aghC;
  private int aghD;
  private int aghE;
  private int aghF;
  private int aghG;
  private int aghH;
  private int aghI;
  private int aghJ;
  private e aghK;
  private int aghL;
  private int aghM;
  private int aghN;
  private boolean aghO;
  private ArrayList<Object> aghR;
  private ArrayList<Integer> aghS;
  private ArrayList<Integer> aghT;
  private LabelsView.b aghU;
  private c aghV;
  private d aghW;
  private Context mContext;
  private int vYT;
  private float xBL;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.aghB = -2;
    this.aghC = -2;
    this.aghD = 17;
    this.adZa = false;
    this.aghN = 1;
    this.aghR = new ArrayList();
    this.aghS = new ArrayList();
    this.aghT = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    jIf();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.aghB = -2;
    this.aghC = -2;
    this.aghD = 17;
    this.adZa = false;
    this.aghN = 1;
    this.aghR = new ArrayList();
    this.aghS = new ArrayList();
    this.aghT = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    jIf();
    AppMethodBeat.o(143564);
  }
  
  private boolean P(TextView paramTextView)
  {
    AppMethodBeat.i(143578);
    if (this.aghW != null)
    {
      d locald = this.aghW;
      paramTextView.getTag(aghP);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(aghQ)).intValue();
      if (locald.jIl())
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
    localTextView.setPadding(this.aghE, this.aghF, this.aghG, this.aghH);
    localTextView.setTextSize(0, this.xBL);
    localTextView.setGravity(this.aghD);
    localTextView.setTextColor(this.NhP);
    localTextView.setBackgroundDrawable(this.aghA.getConstantState().newDrawable());
    localTextView.setTag(aghP, paramT);
    localTextView.setTag(aghQ, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(localTextView, this.aghB, this.aghC);
    localTextView.setText(parama.getLabelText(localTextView, paramInt, paramT));
    AppMethodBeat.o(143574);
  }
  
  private int ej(float paramFloat)
  {
    AppMethodBeat.i(143601);
    int i = (int)TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
    AppMethodBeat.o(143601);
    return i;
  }
  
  private void f(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(143565);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.labels_view);
      this.aghK = e.aFh(paramContext.getInt(a.m.labels_view_selectType, 1));
      this.aghL = paramContext.getInteger(a.m.labels_view_maxSelect, 0);
      this.aghM = paramContext.getInteger(a.m.labels_view_minSelect, 0);
      this.vYT = paramContext.getInteger(a.m.labels_view_maxLines, 0);
      this.aghO = paramContext.getBoolean(a.m.labels_view_isIndicator, false);
      this.aghD = paramContext.getInt(a.m.labels_view_labelGravity, this.aghD);
      this.aghB = paramContext.getLayoutDimension(a.m.labels_view_labelTextWidth, this.aghB);
      this.aghC = paramContext.getLayoutDimension(a.m.labels_view_labelTextHeight, this.aghC);
      if (!paramContext.hasValue(a.m.labels_view_labelTextColor)) {
        break label297;
      }
      this.NhP = paramContext.getColorStateList(a.m.labels_view_labelTextColor);
      this.xBL = paramContext.getDimension(a.m.labels_view_labelTextSize, jIk());
      if (!paramContext.hasValue(a.m.labels_view_labelTextPadding)) {
        break label310;
      }
      int i = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPadding, 0);
      this.aghH = i;
      this.aghG = i;
      this.aghF = i;
      this.aghE = i;
      label203:
      this.aghJ = paramContext.getDimensionPixelOffset(a.m.labels_view_lineMargin, ej(5.0F));
      this.aghI = paramContext.getDimensionPixelOffset(a.m.labels_view_wordMargin, ej(5.0F));
      if (!paramContext.hasValue(a.m.labels_view_labelBackground)) {
        break label407;
      }
      i = paramContext.getResourceId(a.m.labels_view_labelBackground, 0);
      if (i == 0) {
        break label385;
      }
      this.aghA = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.adZa = paramContext.getBoolean(a.m.labels_view_singleLine, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label297:
      this.NhP = ColorStateList.valueOf(-16777216);
      break;
      label310:
      this.aghE = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingLeft, ej(10.0F));
      this.aghF = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingTop, ej(5.0F));
      this.aghG = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingRight, ej(10.0F));
      this.aghH = paramContext.getDimensionPixelOffset(a.m.labels_view_labelTextPaddingBottom, ej(5.0F));
      break label203;
      label385:
      this.aghA = new ColorDrawable(paramContext.getColor(a.m.labels_view_labelBackground, 0));
      continue;
      label407:
      this.aghA = getResources().getDrawable(a.f.default_label_bg);
    }
  }
  
  private void g(TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(143577);
    if (paramTextView.isSelected() != paramBoolean)
    {
      paramTextView.setSelected(paramBoolean);
      if (!paramBoolean) {
        break label77;
      }
      this.aghS.add((Integer)paramTextView.getTag(aghQ));
    }
    for (;;)
    {
      if (this.aghV != null)
      {
        paramTextView.getTag(aghP);
        ((Integer)paramTextView.getTag(aghQ)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label77:
      this.aghS.remove((Integer)paramTextView.getTag(aghQ));
    }
  }
  
  private void jIf()
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
  
  private void jIg()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.aghU != null) || (this.aghK != e.aghY)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void jIi()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      g((TextView)getChildAt(i), false);
      i += 1;
    }
    this.aghS.clear();
    AppMethodBeat.o(143580);
  }
  
  private void jIj()
  {
    AppMethodBeat.i(251747);
    int j = getChildCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      if (!this.aghT.contains(Integer.valueOf(i)))
      {
        g((TextView)getChildAt(i), false);
        localArrayList.add(Integer.valueOf(i));
      }
      i += 1;
    }
    this.aghS.removeAll(localArrayList);
    AppMethodBeat.o(251747);
  }
  
  private int jIk()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int oQ(int paramInt1, int paramInt2)
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
    jIi();
    removeAllViews();
    this.aghR.clear();
    if (paramList != null)
    {
      this.aghR.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      jIg();
    }
    if (this.aghK == e.agia) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.aghT;
  }
  
  public int getLabelGravity()
  {
    return this.aghD;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.NhP;
  }
  
  public float getLabelTextSize()
  {
    return this.xBL;
  }
  
  public <T> List<T> getLabels()
  {
    return this.aghR;
  }
  
  public int getLineCount()
  {
    return this.aghN;
  }
  
  public int getLineMargin()
  {
    return this.aghJ;
  }
  
  public int getMaxLines()
  {
    return this.vYT;
  }
  
  public int getMaxSelect()
  {
    return this.aghL;
  }
  
  public int getMinSelect()
  {
    return this.aghM;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.aghS.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.aghS.get(i)).intValue()).getTag(aghP);
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
    return this.aghS;
  }
  
  public e getSelectType()
  {
    return this.aghK;
  }
  
  public int getTextPaddingBottom()
  {
    return this.aghH;
  }
  
  public int getTextPaddingLeft()
  {
    return this.aghE;
  }
  
  public int getTextPaddingRight()
  {
    return this.aghG;
  }
  
  public int getTextPaddingTop()
  {
    return this.aghF;
  }
  
  public int getWordMargin()
  {
    return this.aghI;
  }
  
  public final void jIh()
  {
    AppMethodBeat.i(143579);
    if (this.aghK != e.agia)
    {
      if ((this.aghK == e.agib) && (!this.aghT.isEmpty()))
      {
        jIj();
        AppMethodBeat.o(143579);
        return;
      }
      jIi();
    }
    AppMethodBeat.o(143579);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.aghO) && (this.aghK != e.aghY))
      {
        if (!paramView.isSelected()) {
          break label246;
        }
        if ((this.aghK != e.agib) || (!this.aghT.contains((Integer)paramView.getTag(aghQ)))) {
          break label231;
        }
        i = 1;
        if ((i == 0) && ((this.aghK != e.agib) || (this.aghS.size() > this.aghM))) {
          break label236;
        }
        i = 1;
        label137:
        if ((i == 0) && (this.aghK != e.agia)) {
          break label241;
        }
        i = 1;
        label153:
        if ((i == 0) && (!P(paramView))) {
          g(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.aghU != null) {
        this.aghU.onLabelClick(paramView, paramView.getTag(aghP), ((Integer)paramView.getTag(aghQ)).intValue());
      }
      a.a(this, "com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143576);
      return;
      label231:
      i = 0;
      break;
      label236:
      i = 0;
      break label137;
      label241:
      i = 0;
      break label153;
      label246:
      if ((this.aghK == e.aghZ) || (this.aghK == e.agia))
      {
        if (!P(paramView))
        {
          jIi();
          g(paramView, true);
        }
      }
      else if ((this.aghK == e.agib) && ((this.aghL <= 0) || (this.aghL > this.aghS.size())) && (!P(paramView))) {
        g(paramView, true);
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
      if (!this.adZa)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.vYT > 0) && (n > this.vYT)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.aghJ + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.aghI;
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
    if (this.adZa)
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
          i = m + this.aghI;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(oQ(paramInt1, i + getPaddingLeft() + getPaddingRight()), oQ(paramInt2, getPaddingTop() + k + getPaddingBottom()));
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
        if (this.vYT > 0)
        {
          i3 = i2;
          i7 = n;
          i8 = k;
          i9 = m;
          i10 = i1;
          if (i2 > this.vYT) {}
        }
        else
        {
          i = i1 + this.aghJ + n;
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
          if (this.aghI + i5 <= i12) {
            break label469;
          }
          i2 = i3 + 1;
          if (this.vYT > 0)
          {
            i3 = i2;
            i7 = i6;
            i8 = j;
            i9 = i5;
            i10 = i;
            if (i2 > this.vYT) {
              break label496;
            }
          }
          i1 = i + this.aghJ + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label469:
          m = i5 + this.aghI;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label496:
    this.aghN = i3;
    setMeasuredDimension(oQ(paramInt1, Math.max(i8, i9) + getPaddingLeft() + getPaddingRight()), oQ(paramInt2, i10 + i7 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.xBL));
      this.aghB = paramParcelable.getInt("key_label_width_state", this.aghB);
      this.aghC = paramParcelable.getInt("key_label_height_state", this.aghC);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.aghD));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.aghE != k) || (this.aghF != m) || (this.aghG != n) || (this.aghH != i1))
        {
          this.aghE = k;
          this.aghF = m;
          this.aghG = n;
          this.aghH = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.aghI));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.aghJ));
      setSelectType(e.aFh(paramParcelable.getInt("key_select_type_state", this.aghK.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.aghL));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.aghM));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.vYT));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.aghO));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.adZa));
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
    if (this.NhP != null) {
      localBundle.putParcelable("key_text_color_state", this.NhP);
    }
    localBundle.putFloat("key_text_size_state", this.xBL);
    localBundle.putInt("key_label_width_state", this.aghB);
    localBundle.putInt("key_label_height_state", this.aghC);
    localBundle.putInt("key_label_gravity_state", this.aghD);
    localBundle.putIntArray("key_padding_state", new int[] { this.aghE, this.aghF, this.aghG, this.aghH });
    localBundle.putInt("key_word_margin_state", this.aghI);
    localBundle.putInt("key_line_margin_state", this.aghJ);
    localBundle.putInt("key_select_type_state", this.aghK.value);
    localBundle.putInt("key_max_select_state", this.aghL);
    localBundle.putInt("key_min_select_state", this.aghM);
    localBundle.putInt("key_max_lines_state", this.vYT);
    localBundle.putBoolean("key_indicator_state", this.aghO);
    if (!this.aghS.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.aghS);
    }
    if (!this.aghT.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.aghT);
    }
    localBundle.putBoolean("key_single_line_state", this.adZa);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.aghK == e.agib) && (paramList != null))
    {
      this.aghT.clear();
      this.aghT.addAll(paramList);
      jIi();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.aghK == e.agib) && (paramVarArgs != null))
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
    this.aghO = paramBoolean;
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
    this.aghA = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.aghA.getConstantState().newDrawable());
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
    if (this.aghD != paramInt)
    {
      this.aghD = paramInt;
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
    this.NhP = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.NhP);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.xBL != paramFloat)
    {
      this.xBL = paramFloat;
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
    if (this.aghJ != paramInt)
    {
      this.aghJ = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.vYT != paramInt)
    {
      this.vYT = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.aghL != paramInt)
    {
      this.aghL = paramInt;
      if (this.aghK == e.agib) {
        jIi();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.aghM = paramInt;
  }
  
  public void setOnLabelClickListener(LabelsView.b paramb)
  {
    AppMethodBeat.i(143599);
    this.aghU = paramb;
    jIg();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.aghV = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.aghW = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.aghK != parame)
    {
      this.aghK = parame;
      jIi();
      if (this.aghK == e.agia) {
        setSelects(new int[] { 0 });
      }
      if (this.aghK != e.agib) {
        this.aghT.clear();
      }
      jIg();
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
    if (this.aghK != e.aghY)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.aghK == e.aghZ) || (this.aghK == e.agia)) {}
      for (int i = 1;; i = this.aghL)
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
              g(localTextView, true);
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
          g(paramVarArgs, false);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(143582);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(143598);
    if (this.adZa != paramBoolean)
    {
      this.adZa = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.aghI != paramInt)
    {
      this.aghI = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean jIl();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      aghY = new e("NONE", 0, 1);
      aghZ = new e("SINGLE", 1, 2);
      agia = new e("SINGLE_IRREVOCABLY", 2, 3);
      agib = new e("MULTI", 3, 4);
      agic = new e[] { aghY, aghZ, agia, agib };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e aFh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return aghY;
      case 1: 
        return aghY;
      case 2: 
        return aghZ;
      case 3: 
        return agia;
      }
      return agib;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */