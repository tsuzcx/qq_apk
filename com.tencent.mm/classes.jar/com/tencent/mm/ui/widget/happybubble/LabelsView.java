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
import com.tencent.mm.ae.a.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int QQR = 2131308866;
  private static final int QQS = 2131308868;
  private ColorStateList BpJ;
  private boolean OYB;
  private Drawable QQC;
  private int QQD;
  private int QQE;
  private int QQF;
  private int QQG;
  private int QQH;
  private int QQI;
  private int QQJ;
  private int QQK;
  private int QQL;
  private e QQM;
  private int QQN;
  private int QQO;
  private int QQP;
  private boolean QQQ;
  private ArrayList<Object> QQT;
  private ArrayList<Integer> QQU;
  private ArrayList<Integer> QQV;
  private LabelsView.b QQW;
  private c QQX;
  private d QQY;
  private float gPN;
  private Context mContext;
  private int pME;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.QQD = -2;
    this.QQE = -2;
    this.QQF = 17;
    this.OYB = false;
    this.QQP = 1;
    this.QQT = new ArrayList();
    this.QQU = new ArrayList();
    this.QQV = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    hbM();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.QQD = -2;
    this.QQE = -2;
    this.QQF = 17;
    this.OYB = false;
    this.QQP = 1;
    this.QQT = new ArrayList();
    this.QQU = new ArrayList();
    this.QQV = new ArrayList();
    this.mContext = paramContext;
    f(paramContext, paramAttributeSet);
    hbM();
    AppMethodBeat.o(143564);
  }
  
  private boolean F(TextView paramTextView)
  {
    AppMethodBeat.i(143578);
    if (this.QQY != null)
    {
      d locald = this.QQY;
      paramTextView.getTag(QQR);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(QQS)).intValue();
      if (locald.hbR())
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
    localTextView.setPadding(this.QQG, this.QQH, this.QQI, this.QQJ);
    localTextView.setTextSize(0, this.gPN);
    localTextView.setGravity(this.QQF);
    localTextView.setTextColor(this.BpJ);
    localTextView.setBackgroundDrawable(this.QQC.getConstantState().newDrawable());
    localTextView.setTag(QQR, paramT);
    localTextView.setTag(QQS, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(localTextView, this.QQD, this.QQE);
    localTextView.setText(parama.a(localTextView, paramInt, paramT));
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
      this.QQU.add((Integer)paramTextView.getTag(QQS));
    }
    for (;;)
    {
      if (this.QQX != null)
      {
        paramTextView.getTag(QQR);
        ((Integer)paramTextView.getTag(QQS)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label75:
      this.QQU.remove((Integer)paramTextView.getTag(QQS));
    }
  }
  
  private int cB(float paramFloat)
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.labels_view);
      this.QQM = e.aph(paramContext.getInt(16, 1));
      this.QQN = paramContext.getInteger(14, 0);
      this.QQO = paramContext.getInteger(15, 0);
      this.pME = paramContext.getInteger(13, 0);
      this.QQQ = paramContext.getBoolean(0, false);
      this.QQF = paramContext.getInt(2, this.QQF);
      this.QQD = paramContext.getLayoutDimension(11, this.QQD);
      this.QQE = paramContext.getLayoutDimension(4, this.QQE);
      if (!paramContext.hasValue(3)) {
        break label270;
      }
      this.BpJ = paramContext.getColorStateList(3);
      this.gPN = paramContext.getDimension(10, hbQ());
      if (!paramContext.hasValue(5)) {
        break label283;
      }
      int i = paramContext.getDimensionPixelOffset(5, 0);
      this.QQJ = i;
      this.QQI = i;
      this.QQH = i;
      this.QQG = i;
      label183:
      this.QQL = paramContext.getDimensionPixelOffset(12, cB(5.0F));
      this.QQK = paramContext.getDimensionPixelOffset(18, cB(5.0F));
      if (!paramContext.hasValue(1)) {
        break label374;
      }
      i = paramContext.getResourceId(1, 0);
      if (i == 0) {
        break label354;
      }
      this.QQC = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.OYB = paramContext.getBoolean(17, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label270:
      this.BpJ = ColorStateList.valueOf(-16777216);
      break;
      label283:
      this.QQG = paramContext.getDimensionPixelOffset(7, cB(10.0F));
      this.QQH = paramContext.getDimensionPixelOffset(9, cB(5.0F));
      this.QQI = paramContext.getDimensionPixelOffset(8, cB(10.0F));
      this.QQJ = paramContext.getDimensionPixelOffset(6, cB(5.0F));
      break label183;
      label354:
      this.QQC = new ColorDrawable(paramContext.getColor(1, 0));
      continue;
      label374:
      this.QQC = getResources().getDrawable(2131231963);
    }
  }
  
  private void hbM()
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
  
  private void hbN()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.QQW != null) || (this.QQM != e.QRa)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void hbP()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      b((TextView)getChildAt(i), false);
      i += 1;
    }
    this.QQU.clear();
    AppMethodBeat.o(143580);
  }
  
  private int hbQ()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int lH(int paramInt1, int paramInt2)
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
    hbP();
    removeAllViews();
    this.QQT.clear();
    if (paramList != null)
    {
      this.QQT.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      hbN();
    }
    if (this.QQM == e.QRc) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.QQV;
  }
  
  public int getLabelGravity()
  {
    return this.QQF;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.BpJ;
  }
  
  public float getLabelTextSize()
  {
    return this.gPN;
  }
  
  public <T> List<T> getLabels()
  {
    return this.QQT;
  }
  
  public int getLineCount()
  {
    return this.QQP;
  }
  
  public int getLineMargin()
  {
    return this.QQL;
  }
  
  public int getMaxLines()
  {
    return this.pME;
  }
  
  public int getMaxSelect()
  {
    return this.QQN;
  }
  
  public int getMinSelect()
  {
    return this.QQO;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.QQU.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.QQU.get(i)).intValue()).getTag(QQR);
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
    return this.QQU;
  }
  
  public e getSelectType()
  {
    return this.QQM;
  }
  
  public int getTextPaddingBottom()
  {
    return this.QQJ;
  }
  
  public int getTextPaddingLeft()
  {
    return this.QQG;
  }
  
  public int getTextPaddingRight()
  {
    return this.QQI;
  }
  
  public int getTextPaddingTop()
  {
    return this.QQH;
  }
  
  public int getWordMargin()
  {
    return this.QQK;
  }
  
  public final void hbO()
  {
    AppMethodBeat.i(143579);
    if (this.QQM != e.QRc)
    {
      if ((this.QQM == e.QRd) && (!this.QQV.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.QQV.contains(Integer.valueOf(i)))
          {
            b((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.QQU.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      hbP();
    }
    AppMethodBeat.o(143579);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.QQQ) && (this.QQM != e.QRa))
      {
        if (!paramView.isSelected()) {
          break label245;
        }
        if ((this.QQM != e.QRd) || (!this.QQV.contains((Integer)paramView.getTag(QQS)))) {
          break label230;
        }
        i = 1;
        if ((i == 0) && ((this.QQM != e.QRd) || (this.QQU.size() > this.QQO))) {
          break label235;
        }
        i = 1;
        label137:
        if ((i == 0) && (this.QQM != e.QRc)) {
          break label240;
        }
        i = 1;
        label153:
        if ((i == 0) && (!F(paramView))) {
          b(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.QQW != null) {
        this.QQW.j(paramView.getTag(QQR), ((Integer)paramView.getTag(QQS)).intValue());
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
      if ((this.QQM == e.QRb) || (this.QQM == e.QRc))
      {
        if (!F(paramView))
        {
          hbP();
          b(paramView, true);
        }
      }
      else if ((this.QQM == e.QRd) && ((this.QQN <= 0) || (this.QQN > this.QQU.size())) && (!F(paramView))) {
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
      if (!this.OYB)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.pME > 0) && (n > this.pME)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.QQL + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.QQK;
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
    if (this.OYB)
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
          i = m + this.QQK;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(lH(paramInt1, i + getPaddingLeft() + getPaddingRight()), lH(paramInt2, getPaddingTop() + k + getPaddingBottom()));
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
        if (this.pME > 0)
        {
          i3 = i2;
          i7 = n;
          i8 = k;
          i9 = m;
          i10 = i1;
          if (i2 > this.pME) {}
        }
        else
        {
          i = i1 + this.QQL + n;
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
          if (this.QQK + i5 <= i12) {
            break label469;
          }
          i2 = i3 + 1;
          if (this.pME > 0)
          {
            i3 = i2;
            i7 = i6;
            i8 = j;
            i9 = i5;
            i10 = i;
            if (i2 > this.pME) {
              break label496;
            }
          }
          i1 = i + this.QQL + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label469:
          m = i5 + this.QQK;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label496:
    this.QQP = i3;
    setMeasuredDimension(lH(paramInt1, Math.max(i8, i9) + getPaddingLeft() + getPaddingRight()), lH(paramInt2, i10 + i7 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.gPN));
      this.QQD = paramParcelable.getInt("key_label_width_state", this.QQD);
      this.QQE = paramParcelable.getInt("key_label_height_state", this.QQE);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.QQF));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.QQG != k) || (this.QQH != m) || (this.QQI != n) || (this.QQJ != i1))
        {
          this.QQG = k;
          this.QQH = m;
          this.QQI = n;
          this.QQJ = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.QQK));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.QQL));
      setSelectType(e.aph(paramParcelable.getInt("key_select_type_state", this.QQM.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.QQN));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.QQO));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.pME));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.QQQ));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.OYB));
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
    if (this.BpJ != null) {
      localBundle.putParcelable("key_text_color_state", this.BpJ);
    }
    localBundle.putFloat("key_text_size_state", this.gPN);
    localBundle.putInt("key_label_width_state", this.QQD);
    localBundle.putInt("key_label_height_state", this.QQE);
    localBundle.putInt("key_label_gravity_state", this.QQF);
    localBundle.putIntArray("key_padding_state", new int[] { this.QQG, this.QQH, this.QQI, this.QQJ });
    localBundle.putInt("key_word_margin_state", this.QQK);
    localBundle.putInt("key_line_margin_state", this.QQL);
    localBundle.putInt("key_select_type_state", this.QQM.value);
    localBundle.putInt("key_max_select_state", this.QQN);
    localBundle.putInt("key_min_select_state", this.QQO);
    localBundle.putInt("key_max_lines_state", this.pME);
    localBundle.putBoolean("key_indicator_state", this.QQQ);
    if (!this.QQU.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.QQU);
    }
    if (!this.QQV.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.QQV);
    }
    localBundle.putBoolean("key_single_line_state", this.OYB);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.QQM == e.QRd) && (paramList != null))
    {
      this.QQV.clear();
      this.QQV.addAll(paramList);
      hbP();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.QQM == e.QRd) && (paramVarArgs != null))
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
    this.QQQ = paramBoolean;
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
    this.QQC = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.QQC.getConstantState().newDrawable());
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
    if (this.QQF != paramInt)
    {
      this.QQF = paramInt;
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
    this.BpJ = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.BpJ);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.gPN != paramFloat)
    {
      this.gPN = paramFloat;
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
    if (this.QQL != paramInt)
    {
      this.QQL = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.pME != paramInt)
    {
      this.pME = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.QQN != paramInt)
    {
      this.QQN = paramInt;
      if (this.QQM == e.QRd) {
        hbP();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.QQO = paramInt;
  }
  
  public void setOnLabelClickListener(LabelsView.b paramb)
  {
    AppMethodBeat.i(143599);
    this.QQW = paramb;
    hbN();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.QQX = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.QQY = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.QQM != parame)
    {
      this.QQM = parame;
      hbP();
      if (this.QQM == e.QRc) {
        setSelects(new int[] { 0 });
      }
      if (this.QQM != e.QRd) {
        this.QQV.clear();
      }
      hbN();
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
    if (this.QQM != e.QRa)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.QQM == e.QRb) || (this.QQM == e.QRc)) {}
      for (int i = 1;; i = this.QQN)
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
    if (this.OYB != paramBoolean)
    {
      this.OYB = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.QQK != paramInt)
    {
      this.QQK = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean hbR();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      QRa = new e("NONE", 0, 1);
      QRb = new e("SINGLE", 1, 2);
      QRc = new e("SINGLE_IRREVOCABLY", 2, 3);
      QRd = new e("MULTI", 3, 4);
      QRe = new e[] { QRa, QRb, QRc, QRd };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e aph(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return QRa;
      case 1: 
        return QRa;
      case 2: 
        return QRb;
      case 3: 
        return QRc;
      }
      return QRd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */