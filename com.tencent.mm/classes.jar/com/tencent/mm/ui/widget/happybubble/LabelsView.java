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
import com.tencent.mm.ae.a.a;
import java.util.ArrayList;
import java.util.List;

public class LabelsView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final int Jhw = 2131305625;
  private static final int Jhx = 2131305627;
  private boolean HET;
  private ArrayList<Integer> JhA;
  private LabelsView.b JhB;
  private c JhC;
  private d JhD;
  private Drawable Jhi;
  private int Jhj;
  private int Jhk;
  private int Jhl;
  private int Jhm;
  private int Jhn;
  private int Jho;
  private int Jhp;
  private int Jhq;
  private int Jhr;
  private e Jhs;
  private int Jht;
  private int Jhu;
  private boolean Jhv;
  private ArrayList<Object> Jhy;
  private ArrayList<Integer> Jhz;
  private Context mContext;
  private int nPN;
  private float oTC;
  private ColorStateList vSw;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.Jhj = -2;
    this.Jhk = -2;
    this.Jhl = 17;
    this.HET = false;
    this.Jhy = new ArrayList();
    this.Jhz = new ArrayList();
    this.JhA = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fvF();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.Jhj = -2;
    this.Jhk = -2;
    this.Jhl = 17;
    this.HET = false;
    this.Jhy = new ArrayList();
    this.Jhz = new ArrayList();
    this.JhA = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fvF();
    AppMethodBeat.o(143564);
  }
  
  private <T> void a(T paramT, int paramInt, a<T> parama)
  {
    AppMethodBeat.i(143574);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setPadding(this.Jhm, this.Jhn, this.Jho, this.Jhp);
    localTextView.setTextSize(0, this.oTC);
    localTextView.setGravity(this.Jhl);
    localTextView.setTextColor(this.vSw);
    localTextView.setBackgroundDrawable(this.Jhi.getConstantState().newDrawable());
    localTextView.setTag(Jhw, paramT);
    localTextView.setTag(Jhx, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    addView(localTextView, this.Jhj, this.Jhk);
    localTextView.setText(parama.cP(paramT));
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
      this.Jhz.add((Integer)paramTextView.getTag(Jhx));
    }
    for (;;)
    {
      if (this.JhC != null)
      {
        paramTextView.getTag(Jhw);
        ((Integer)paramTextView.getTag(Jhx)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label75:
      this.Jhz.remove((Integer)paramTextView.getTag(Jhx));
    }
  }
  
  private int bU(float paramFloat)
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
      this.Jhs = e.acU(paramContext.getInt(16, 1));
      this.Jht = paramContext.getInteger(14, 0);
      this.Jhu = paramContext.getInteger(15, 0);
      this.nPN = paramContext.getInteger(13, 0);
      this.Jhv = paramContext.getBoolean(0, false);
      this.Jhl = paramContext.getInt(2, this.Jhl);
      this.Jhj = paramContext.getLayoutDimension(11, this.Jhj);
      this.Jhk = paramContext.getLayoutDimension(4, this.Jhk);
      if (!paramContext.hasValue(3)) {
        break label268;
      }
      this.vSw = paramContext.getColorStateList(3);
      this.oTC = paramContext.getDimension(10, fvJ());
      if (!paramContext.hasValue(5)) {
        break label281;
      }
      int i = paramContext.getDimensionPixelOffset(5, 0);
      this.Jhp = i;
      this.Jho = i;
      this.Jhn = i;
      this.Jhm = i;
      label182:
      this.Jhr = paramContext.getDimensionPixelOffset(12, bU(5.0F));
      this.Jhq = paramContext.getDimensionPixelOffset(18, bU(5.0F));
      if (!paramContext.hasValue(1)) {
        break label372;
      }
      i = paramContext.getResourceId(1, 0);
      if (i == 0) {
        break label352;
      }
      this.Jhi = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.HET = paramContext.getBoolean(17, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label268:
      this.vSw = ColorStateList.valueOf(-16777216);
      break;
      label281:
      this.Jhm = paramContext.getDimensionPixelOffset(7, bU(10.0F));
      this.Jhn = paramContext.getDimensionPixelOffset(9, bU(5.0F));
      this.Jho = paramContext.getDimensionPixelOffset(8, bU(10.0F));
      this.Jhp = paramContext.getDimensionPixelOffset(6, bU(5.0F));
      break label182;
      label352:
      this.Jhi = new ColorDrawable(paramContext.getColor(1, 0));
      continue;
      label372:
      this.Jhi = getResources().getDrawable(2131231881);
    }
  }
  
  private void fvF()
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
  
  private void fvG()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.JhB != null) || (this.Jhs != e.JhF)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void fvI()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      b((TextView)getChildAt(i), false);
      i += 1;
    }
    this.Jhz.clear();
    AppMethodBeat.o(143580);
  }
  
  private int fvJ()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int jT(int paramInt1, int paramInt2)
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
    if (this.JhD != null)
    {
      d locald = this.JhD;
      paramTextView.getTag(Jhw);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(Jhx)).intValue();
      if (locald.fvK())
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
    fvI();
    removeAllViews();
    this.Jhy.clear();
    if (paramList != null)
    {
      this.Jhy.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      fvG();
    }
    if (this.Jhs == e.JhH) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public final void fvH()
  {
    AppMethodBeat.i(143579);
    if (this.Jhs != e.JhH)
    {
      if ((this.Jhs == e.JhI) && (!this.JhA.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.JhA.contains(Integer.valueOf(i)))
          {
            b((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.Jhz.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      fvI();
    }
    AppMethodBeat.o(143579);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.JhA;
  }
  
  public int getLabelGravity()
  {
    return this.Jhl;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.vSw;
  }
  
  public float getLabelTextSize()
  {
    return this.oTC;
  }
  
  public <T> List<T> getLabels()
  {
    return this.Jhy;
  }
  
  public int getLineMargin()
  {
    return this.Jhr;
  }
  
  public int getMaxLines()
  {
    return this.nPN;
  }
  
  public int getMaxSelect()
  {
    return this.Jht;
  }
  
  public int getMinSelect()
  {
    return this.Jhu;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.Jhz.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.Jhz.get(i)).intValue()).getTag(Jhw);
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
    return this.Jhz;
  }
  
  public e getSelectType()
  {
    return this.Jhs;
  }
  
  public int getTextPaddingBottom()
  {
    return this.Jhp;
  }
  
  public int getTextPaddingLeft()
  {
    return this.Jhm;
  }
  
  public int getTextPaddingRight()
  {
    return this.Jho;
  }
  
  public int getTextPaddingTop()
  {
    return this.Jhn;
  }
  
  public int getWordMargin()
  {
    return this.Jhq;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.Jhv) && (this.Jhs != e.JhF))
      {
        if (!paramView.isSelected()) {
          break label200;
        }
        if ((this.Jhs != e.JhI) || (!this.JhA.contains((Integer)paramView.getTag(Jhx)))) {
          break label185;
        }
        i = 1;
        if ((i == 0) && ((this.Jhs != e.JhI) || (this.Jhz.size() > this.Jhu))) {
          break label190;
        }
        i = 1;
        label104:
        if ((i == 0) && (this.Jhs != e.JhH)) {
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
      if (this.JhB != null)
      {
        LabelsView.b localb = this.JhB;
        paramView.getTag(Jhw);
        ((Integer)paramView.getTag(Jhx)).intValue();
        localb.bKc();
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
      if ((this.Jhs == e.JhG) || (this.Jhs == e.JhH))
      {
        if (!x(paramView))
        {
          fvI();
          b(paramView, true);
        }
      }
      else if ((this.Jhs == e.JhI) && ((this.Jht <= 0) || (this.Jht > this.Jhz.size())) && (!x(paramView))) {
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
      if (!this.HET)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.nPN > 0) && (n > this.nPN)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.Jhr + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.Jhq;
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
    if (this.HET)
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
          i = m + this.Jhq;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(jT(paramInt1, i + getPaddingLeft() + getPaddingRight()), jT(paramInt2, getPaddingTop() + k + getPaddingBottom()));
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
        if (this.nPN > 0)
        {
          i3 = n;
          i7 = k;
          i8 = m;
          i9 = i1;
          if (i2 > this.nPN) {}
        }
        else
        {
          i = i1 + this.Jhr + n;
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
          if (this.Jhq + i5 <= i11) {
            break label457;
          }
          i2 = i3 + 1;
          if (this.nPN > 0)
          {
            i3 = i6;
            i7 = j;
            i8 = i5;
            i9 = i;
            if (i2 > this.nPN) {
              break label484;
            }
          }
          i1 = i + this.Jhr + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label457:
          m = i5 + this.Jhq;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label484:
    setMeasuredDimension(jT(paramInt1, Math.max(i7, i8) + getPaddingLeft() + getPaddingRight()), jT(paramInt2, i9 + i3 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.oTC));
      this.Jhj = paramParcelable.getInt("key_label_width_state", this.Jhj);
      this.Jhk = paramParcelable.getInt("key_label_height_state", this.Jhk);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.Jhl));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.Jhm != k) || (this.Jhn != m) || (this.Jho != n) || (this.Jhp != i1))
        {
          this.Jhm = k;
          this.Jhn = m;
          this.Jho = n;
          this.Jhp = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.Jhq));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.Jhr));
      setSelectType(e.acU(paramParcelable.getInt("key_select_type_state", this.Jhs.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.Jht));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.Jhu));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.nPN));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.Jhv));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.HET));
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
    if (this.vSw != null) {
      localBundle.putParcelable("key_text_color_state", this.vSw);
    }
    localBundle.putFloat("key_text_size_state", this.oTC);
    localBundle.putInt("key_label_width_state", this.Jhj);
    localBundle.putInt("key_label_height_state", this.Jhk);
    localBundle.putInt("key_label_gravity_state", this.Jhl);
    localBundle.putIntArray("key_padding_state", new int[] { this.Jhm, this.Jhn, this.Jho, this.Jhp });
    localBundle.putInt("key_word_margin_state", this.Jhq);
    localBundle.putInt("key_line_margin_state", this.Jhr);
    localBundle.putInt("key_select_type_state", this.Jhs.value);
    localBundle.putInt("key_max_select_state", this.Jht);
    localBundle.putInt("key_min_select_state", this.Jhu);
    localBundle.putInt("key_max_lines_state", this.nPN);
    localBundle.putBoolean("key_indicator_state", this.Jhv);
    if (!this.Jhz.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.Jhz);
    }
    if (!this.JhA.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.JhA);
    }
    localBundle.putBoolean("key_single_line_state", this.HET);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.Jhs == e.JhI) && (paramList != null))
    {
      this.JhA.clear();
      this.JhA.addAll(paramList);
      fvI();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.Jhs == e.JhI) && (paramVarArgs != null))
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
    this.Jhv = paramBoolean;
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
    this.Jhi = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.Jhi.getConstantState().newDrawable());
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
    if (this.Jhl != paramInt)
    {
      this.Jhl = paramInt;
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
    this.vSw = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.vSw);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.oTC != paramFloat)
    {
      this.oTC = paramFloat;
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
    if (this.Jhr != paramInt)
    {
      this.Jhr = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.nPN != paramInt)
    {
      this.nPN = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.Jht != paramInt)
    {
      this.Jht = paramInt;
      if (this.Jhs == e.JhI) {
        fvI();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.Jhu = paramInt;
  }
  
  public void setOnLabelClickListener(LabelsView.b paramb)
  {
    AppMethodBeat.i(143599);
    this.JhB = paramb;
    fvG();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.JhC = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.JhD = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.Jhs != parame)
    {
      this.Jhs = parame;
      fvI();
      if (this.Jhs == e.JhH) {
        setSelects(new int[] { 0 });
      }
      if (this.Jhs != e.JhI) {
        this.JhA.clear();
      }
      fvG();
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
    if (this.Jhs != e.JhF)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.Jhs == e.JhG) || (this.Jhs == e.JhH)) {}
      for (int i = 1;; i = this.Jht)
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
    if (this.HET != paramBoolean)
    {
      this.HET = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.Jhq != paramInt)
    {
      this.Jhq = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface a<T>
  {
    public abstract CharSequence cP(T paramT);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean fvK();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      JhF = new e("NONE", 0, 1);
      JhG = new e("SINGLE", 1, 2);
      JhH = new e("SINGLE_IRREVOCABLY", 2, 3);
      JhI = new e("MULTI", 3, 4);
      JhJ = new e[] { JhF, JhG, JhH, JhI };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e acU(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return JhF;
      case 1: 
        return JhF;
      case 2: 
        return JhG;
      case 3: 
        return JhH;
      }
      return JhI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */