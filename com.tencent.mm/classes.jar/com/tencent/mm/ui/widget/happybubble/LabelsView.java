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
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a.a;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int HGZ = 2131305625;
  private static final int HHa = 2131305627;
  private boolean Gfe;
  private Drawable HGL;
  private int HGM;
  private int HGN;
  private int HGO;
  private int HGP;
  private int HGQ;
  private int HGR;
  private int HGS;
  private int HGT;
  private int HGU;
  private e HGV;
  private int HGW;
  private int HGX;
  private boolean HGY;
  private ArrayList<Object> HHb;
  private ArrayList<Integer> HHc;
  private ArrayList<Integer> HHd;
  private b HHe;
  private c HHf;
  private d HHg;
  private Context mContext;
  private int nmN;
  private float oqc;
  private ColorStateList uJF;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.HGM = -2;
    this.HGN = -2;
    this.HGO = 17;
    this.Gfe = false;
    this.HHb = new ArrayList();
    this.HHc = new ArrayList();
    this.HHd = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    ffG();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.HGM = -2;
    this.HGN = -2;
    this.HGO = 17;
    this.Gfe = false;
    this.HHb = new ArrayList();
    this.HHc = new ArrayList();
    this.HHd = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    ffG();
    AppMethodBeat.o(143564);
  }
  
  private <T> void a(T paramT, int paramInt, a<T> parama)
  {
    AppMethodBeat.i(143574);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setPadding(this.HGP, this.HGQ, this.HGR, this.HGS);
    localTextView.setTextSize(0, this.oqc);
    localTextView.setGravity(this.HGO);
    localTextView.setTextColor(this.uJF);
    localTextView.setBackgroundDrawable(this.HGL.getConstantState().newDrawable());
    localTextView.setTag(HGZ, paramT);
    localTextView.setTag(HHa, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    addView(localTextView, this.HGM, this.HGN);
    localTextView.setText(parama.cQ(paramT));
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
      this.HHc.add((Integer)paramTextView.getTag(HHa));
    }
    for (;;)
    {
      if (this.HHf != null)
      {
        paramTextView.getTag(HGZ);
        ((Integer)paramTextView.getTag(HHa)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label75:
      this.HHc.remove((Integer)paramTextView.getTag(HHa));
    }
  }
  
  private int bL(float paramFloat)
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
      this.HGV = e.aaJ(paramContext.getInt(16, 1));
      this.HGW = paramContext.getInteger(14, 0);
      this.HGX = paramContext.getInteger(15, 0);
      this.nmN = paramContext.getInteger(13, 0);
      this.HGY = paramContext.getBoolean(0, false);
      this.HGO = paramContext.getInt(2, this.HGO);
      this.HGM = paramContext.getLayoutDimension(11, this.HGM);
      this.HGN = paramContext.getLayoutDimension(4, this.HGN);
      if (!paramContext.hasValue(3)) {
        break label268;
      }
      this.uJF = paramContext.getColorStateList(3);
      this.oqc = paramContext.getDimension(10, ffK());
      if (!paramContext.hasValue(5)) {
        break label281;
      }
      int i = paramContext.getDimensionPixelOffset(5, 0);
      this.HGS = i;
      this.HGR = i;
      this.HGQ = i;
      this.HGP = i;
      label182:
      this.HGU = paramContext.getDimensionPixelOffset(12, bL(5.0F));
      this.HGT = paramContext.getDimensionPixelOffset(18, bL(5.0F));
      if (!paramContext.hasValue(1)) {
        break label372;
      }
      i = paramContext.getResourceId(1, 0);
      if (i == 0) {
        break label352;
      }
      this.HGL = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.Gfe = paramContext.getBoolean(17, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label268:
      this.uJF = ColorStateList.valueOf(-16777216);
      break;
      label281:
      this.HGP = paramContext.getDimensionPixelOffset(7, bL(10.0F));
      this.HGQ = paramContext.getDimensionPixelOffset(9, bL(5.0F));
      this.HGR = paramContext.getDimensionPixelOffset(8, bL(10.0F));
      this.HGS = paramContext.getDimensionPixelOffset(6, bL(5.0F));
      break label182;
      label352:
      this.HGL = new ColorDrawable(paramContext.getColor(1, 0));
      continue;
      label372:
      this.HGL = getResources().getDrawable(2131231881);
    }
  }
  
  private void ffG()
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
  
  private void ffH()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.HHe != null) || (this.HGV != e.HHi)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void ffJ()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      b((TextView)getChildAt(i), false);
      i += 1;
    }
    this.HHc.clear();
    AppMethodBeat.o(143580);
  }
  
  private int ffK()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int jH(int paramInt1, int paramInt2)
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
    if (this.HHg != null)
    {
      d locald = this.HHg;
      paramTextView.getTag(HGZ);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(HHa)).intValue();
      if (locald.ffL())
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
    ffJ();
    removeAllViews();
    this.HHb.clear();
    if (paramList != null)
    {
      this.HHb.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      ffH();
    }
    if (this.HGV == e.HHk) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public final void ffI()
  {
    AppMethodBeat.i(143579);
    if (this.HGV != e.HHk)
    {
      if ((this.HGV == e.HHl) && (!this.HHd.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.HHd.contains(Integer.valueOf(i)))
          {
            b((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.HHc.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      ffJ();
    }
    AppMethodBeat.o(143579);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.HHd;
  }
  
  public int getLabelGravity()
  {
    return this.HGO;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.uJF;
  }
  
  public float getLabelTextSize()
  {
    return this.oqc;
  }
  
  public <T> List<T> getLabels()
  {
    return this.HHb;
  }
  
  public int getLineMargin()
  {
    return this.HGU;
  }
  
  public int getMaxLines()
  {
    return this.nmN;
  }
  
  public int getMaxSelect()
  {
    return this.HGW;
  }
  
  public int getMinSelect()
  {
    return this.HGX;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.HHc.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.HHc.get(i)).intValue()).getTag(HGZ);
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
    return this.HHc;
  }
  
  public e getSelectType()
  {
    return this.HGV;
  }
  
  public int getTextPaddingBottom()
  {
    return this.HGS;
  }
  
  public int getTextPaddingLeft()
  {
    return this.HGP;
  }
  
  public int getTextPaddingRight()
  {
    return this.HGR;
  }
  
  public int getTextPaddingTop()
  {
    return this.HGQ;
  }
  
  public int getWordMargin()
  {
    return this.HGT;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.HGY) && (this.HGV != e.HHi))
      {
        if (!paramView.isSelected()) {
          break label200;
        }
        if ((this.HGV != e.HHl) || (!this.HHd.contains((Integer)paramView.getTag(HHa)))) {
          break label185;
        }
        i = 1;
        if ((i == 0) && ((this.HGV != e.HHl) || (this.HHc.size() > this.HGX))) {
          break label190;
        }
        i = 1;
        label104:
        if ((i == 0) && (this.HGV != e.HHk)) {
          break label195;
        }
        i = 1;
        label120:
        if ((i == 0) && (!x(paramView))) {
          b(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.HHe != null)
      {
        b localb = this.HHe;
        paramView.getTag(HGZ);
        ((Integer)paramView.getTag(HHa)).intValue();
        localb.bCU();
      }
      AppMethodBeat.o(143576);
      return;
      label185:
      i = 0;
      break;
      label190:
      i = 0;
      break label104;
      label195:
      i = 0;
      break label120;
      label200:
      if ((this.HGV == e.HHj) || (this.HGV == e.HHk))
      {
        if (!x(paramView))
        {
          ffJ();
          b(paramView, true);
        }
      }
      else if ((this.HGV == e.HHl) && ((this.HGW <= 0) || (this.HGW > this.HHc.size())) && (!x(paramView))) {
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
      if (!this.Gfe)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.nmN > 0) && (n > this.nmN)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.HGU + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.HGT;
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
    if (this.Gfe)
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
          i = m + this.HGT;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(jH(paramInt1, i + getPaddingLeft() + getPaddingRight()), jH(paramInt2, getPaddingTop() + k + getPaddingBottom()));
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
        if (this.nmN > 0)
        {
          i3 = n;
          i7 = k;
          i8 = m;
          i9 = i1;
          if (i2 > this.nmN) {}
        }
        else
        {
          i = i1 + this.HGU + n;
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
          if (this.HGT + i5 <= i11) {
            break label457;
          }
          i2 = i3 + 1;
          if (this.nmN > 0)
          {
            i3 = i6;
            i7 = j;
            i8 = i5;
            i9 = i;
            if (i2 > this.nmN) {
              break label484;
            }
          }
          i1 = i + this.HGU + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label457:
          m = i5 + this.HGT;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label484:
    setMeasuredDimension(jH(paramInt1, Math.max(i7, i8) + getPaddingLeft() + getPaddingRight()), jH(paramInt2, i9 + i3 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.oqc));
      this.HGM = paramParcelable.getInt("key_label_width_state", this.HGM);
      this.HGN = paramParcelable.getInt("key_label_height_state", this.HGN);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.HGO));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.HGP != k) || (this.HGQ != m) || (this.HGR != n) || (this.HGS != i1))
        {
          this.HGP = k;
          this.HGQ = m;
          this.HGR = n;
          this.HGS = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.HGT));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.HGU));
      setSelectType(e.aaJ(paramParcelable.getInt("key_select_type_state", this.HGV.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.HGW));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.HGX));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.nmN));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.HGY));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.Gfe));
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
    if (this.uJF != null) {
      localBundle.putParcelable("key_text_color_state", this.uJF);
    }
    localBundle.putFloat("key_text_size_state", this.oqc);
    localBundle.putInt("key_label_width_state", this.HGM);
    localBundle.putInt("key_label_height_state", this.HGN);
    localBundle.putInt("key_label_gravity_state", this.HGO);
    localBundle.putIntArray("key_padding_state", new int[] { this.HGP, this.HGQ, this.HGR, this.HGS });
    localBundle.putInt("key_word_margin_state", this.HGT);
    localBundle.putInt("key_line_margin_state", this.HGU);
    localBundle.putInt("key_select_type_state", this.HGV.value);
    localBundle.putInt("key_max_select_state", this.HGW);
    localBundle.putInt("key_min_select_state", this.HGX);
    localBundle.putInt("key_max_lines_state", this.nmN);
    localBundle.putBoolean("key_indicator_state", this.HGY);
    if (!this.HHc.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.HHc);
    }
    if (!this.HHd.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.HHd);
    }
    localBundle.putBoolean("key_single_line_state", this.Gfe);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.HGV == e.HHl) && (paramList != null))
    {
      this.HHd.clear();
      this.HHd.addAll(paramList);
      ffJ();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.HGV == e.HHl) && (paramVarArgs != null))
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
    this.HGY = paramBoolean;
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
    this.HGL = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.HGL.getConstantState().newDrawable());
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
    if (this.HGO != paramInt)
    {
      this.HGO = paramInt;
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
    this.uJF = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.uJF);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.oqc != paramFloat)
    {
      this.oqc = paramFloat;
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
    if (this.HGU != paramInt)
    {
      this.HGU = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.nmN != paramInt)
    {
      this.nmN = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.HGW != paramInt)
    {
      this.HGW = paramInt;
      if (this.HGV == e.HHl) {
        ffJ();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.HGX = paramInt;
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    AppMethodBeat.i(143599);
    this.HHe = paramb;
    ffH();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.HHf = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.HHg = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.HGV != parame)
    {
      this.HGV = parame;
      ffJ();
      if (this.HGV == e.HHk) {
        setSelects(new int[] { 0 });
      }
      if (this.HGV != e.HHl) {
        this.HHd.clear();
      }
      ffH();
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
    if (this.HGV != e.HHi)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.HGV == e.HHj) || (this.HGV == e.HHk)) {}
      for (int i = 1;; i = this.HGW)
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
    if (this.Gfe != paramBoolean)
    {
      this.Gfe = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.HGT != paramInt)
    {
      this.HGT = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface a<T>
  {
    public abstract CharSequence cQ(T paramT);
  }
  
  public static abstract interface b
  {
    public abstract void bCU();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean ffL();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      HHi = new e("NONE", 0, 1);
      HHj = new e("SINGLE", 1, 2);
      HHk = new e("SINGLE_IRREVOCABLY", 2, 3);
      HHl = new e("MULTI", 3, 4);
      HHm = new e[] { HHi, HHj, HHk, HHl };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e aaJ(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return HHi;
      case 1: 
        return HHi;
      case 2: 
        return HHj;
      case 3: 
        return HHk;
      }
      return HHl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */