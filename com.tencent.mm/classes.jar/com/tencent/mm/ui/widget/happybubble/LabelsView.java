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
  private static final int Lvi = 2131305625;
  private static final int Lvj = 2131305627;
  private boolean JNz;
  private Drawable LuU;
  private int LuV;
  private int LuW;
  private int LuX;
  private int LuY;
  private int LuZ;
  private int Lva;
  private int Lvb;
  private int Lvc;
  private int Lvd;
  private e Lve;
  private int Lvf;
  private int Lvg;
  private boolean Lvh;
  private ArrayList<Object> Lvk;
  private ArrayList<Integer> Lvl;
  private ArrayList<Integer> Lvm;
  private b Lvn;
  private c Lvo;
  private d Lvp;
  private Context mContext;
  private int oyV;
  private float pDQ;
  private ColorStateList xpx;
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143563);
    this.LuV = -2;
    this.LuW = -2;
    this.LuX = 17;
    this.JNz = false;
    this.Lvk = new ArrayList();
    this.Lvl = new ArrayList();
    this.Lvm = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fQN();
    AppMethodBeat.o(143563);
  }
  
  public LabelsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143564);
    this.LuV = -2;
    this.LuW = -2;
    this.LuX = 17;
    this.JNz = false;
    this.Lvk = new ArrayList();
    this.Lvl = new ArrayList();
    this.Lvm = new ArrayList();
    this.mContext = paramContext;
    e(paramContext, paramAttributeSet);
    fQN();
    AppMethodBeat.o(143564);
  }
  
  private <T> void a(T paramT, int paramInt, a<T> parama)
  {
    AppMethodBeat.i(143574);
    TextView localTextView = new TextView(this.mContext);
    localTextView.setPadding(this.LuY, this.LuZ, this.Lva, this.Lvb);
    localTextView.setTextSize(0, this.pDQ);
    localTextView.setGravity(this.LuX);
    localTextView.setTextColor(this.xpx);
    localTextView.setBackgroundDrawable(this.LuU.getConstantState().newDrawable());
    localTextView.setTag(Lvi, paramT);
    localTextView.setTag(Lvj, Integer.valueOf(paramInt));
    localTextView.setOnClickListener(this);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    addView(localTextView, this.LuV, this.LuW);
    localTextView.setText(parama.cS(paramT));
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
      this.Lvl.add((Integer)paramTextView.getTag(Lvj));
    }
    for (;;)
    {
      if (this.Lvo != null)
      {
        paramTextView.getTag(Lvi);
        ((Integer)paramTextView.getTag(Lvj)).intValue();
      }
      AppMethodBeat.o(143577);
      return;
      label75:
      this.Lvl.remove((Integer)paramTextView.getTag(Lvj));
    }
  }
  
  private int bX(float paramFloat)
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
      this.Lve = e.age(paramContext.getInt(16, 1));
      this.Lvf = paramContext.getInteger(14, 0);
      this.Lvg = paramContext.getInteger(15, 0);
      this.oyV = paramContext.getInteger(13, 0);
      this.Lvh = paramContext.getBoolean(0, false);
      this.LuX = paramContext.getInt(2, this.LuX);
      this.LuV = paramContext.getLayoutDimension(11, this.LuV);
      this.LuW = paramContext.getLayoutDimension(4, this.LuW);
      if (!paramContext.hasValue(3)) {
        break label268;
      }
      this.xpx = paramContext.getColorStateList(3);
      this.pDQ = paramContext.getDimension(10, fQR());
      if (!paramContext.hasValue(5)) {
        break label281;
      }
      int i = paramContext.getDimensionPixelOffset(5, 0);
      this.Lvb = i;
      this.Lva = i;
      this.LuZ = i;
      this.LuY = i;
      label182:
      this.Lvd = paramContext.getDimensionPixelOffset(12, bX(5.0F));
      this.Lvc = paramContext.getDimensionPixelOffset(18, bX(5.0F));
      if (!paramContext.hasValue(1)) {
        break label372;
      }
      i = paramContext.getResourceId(1, 0);
      if (i == 0) {
        break label352;
      }
      this.LuU = getResources().getDrawable(i);
    }
    for (;;)
    {
      this.JNz = paramContext.getBoolean(17, false);
      paramContext.recycle();
      AppMethodBeat.o(143565);
      return;
      label268:
      this.xpx = ColorStateList.valueOf(-16777216);
      break;
      label281:
      this.LuY = paramContext.getDimensionPixelOffset(7, bX(10.0F));
      this.LuZ = paramContext.getDimensionPixelOffset(9, bX(5.0F));
      this.Lva = paramContext.getDimensionPixelOffset(8, bX(10.0F));
      this.Lvb = paramContext.getDimensionPixelOffset(6, bX(5.0F));
      break label182;
      label352:
      this.LuU = new ColorDrawable(paramContext.getColor(1, 0));
      continue;
      label372:
      this.LuU = getResources().getDrawable(2131231881);
    }
  }
  
  private void fQN()
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
  
  private void fQO()
  {
    AppMethodBeat.i(143575);
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)getChildAt(i);
      if ((this.Lvn != null) || (this.Lve != e.Lvr)) {}
      for (boolean bool = true;; bool = false)
      {
        localTextView.setClickable(bool);
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(143575);
  }
  
  private void fQQ()
  {
    AppMethodBeat.i(143580);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      b((TextView)getChildAt(i), false);
      i += 1;
    }
    this.Lvl.clear();
    AppMethodBeat.o(143580);
  }
  
  private int fQR()
  {
    AppMethodBeat.i(143600);
    int i = (int)TypedValue.applyDimension(2, 14.0F, getResources().getDisplayMetrics());
    AppMethodBeat.o(143600);
    return i;
  }
  
  private int km(int paramInt1, int paramInt2)
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
  
  private boolean v(TextView paramTextView)
  {
    AppMethodBeat.i(143578);
    if (this.Lvp != null)
    {
      d locald = this.Lvp;
      paramTextView.getTag(Lvi);
      paramTextView.isSelected();
      paramTextView.isSelected();
      ((Integer)paramTextView.getTag(Lvj)).intValue();
      if (locald.fQS())
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
    fQQ();
    removeAllViews();
    this.Lvk.clear();
    if (paramList != null)
    {
      this.Lvk.addAll(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        a(paramList.get(i), i, parama);
        i += 1;
      }
      fQO();
    }
    if (this.Lve == e.Lvt) {
      setSelects(new int[] { 0 });
    }
    AppMethodBeat.o(143573);
  }
  
  public final void fQP()
  {
    AppMethodBeat.i(143579);
    if (this.Lve != e.Lvt)
    {
      if ((this.Lve == e.Lvu) && (!this.Lvm.isEmpty()))
      {
        int j = getChildCount();
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          if (!this.Lvm.contains(Integer.valueOf(i)))
          {
            b((TextView)getChildAt(i), false);
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
        this.Lvl.removeAll(localArrayList);
        AppMethodBeat.o(143579);
        return;
      }
      fQQ();
    }
    AppMethodBeat.o(143579);
  }
  
  public List<Integer> getCompulsorys()
  {
    return this.Lvm;
  }
  
  public int getLabelGravity()
  {
    return this.LuX;
  }
  
  public ColorStateList getLabelTextColor()
  {
    return this.xpx;
  }
  
  public float getLabelTextSize()
  {
    return this.pDQ;
  }
  
  public <T> List<T> getLabels()
  {
    return this.Lvk;
  }
  
  public int getLineMargin()
  {
    return this.Lvd;
  }
  
  public int getMaxLines()
  {
    return this.oyV;
  }
  
  public int getMaxSelect()
  {
    return this.Lvf;
  }
  
  public int getMinSelect()
  {
    return this.Lvg;
  }
  
  public <T> List<T> getSelectLabelDatas()
  {
    AppMethodBeat.i(143585);
    ArrayList localArrayList = new ArrayList();
    int j = this.Lvl.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(((Integer)this.Lvl.get(i)).intValue()).getTag(Lvi);
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
    return this.Lvl;
  }
  
  public e getSelectType()
  {
    return this.Lve;
  }
  
  public int getTextPaddingBottom()
  {
    return this.Lvb;
  }
  
  public int getTextPaddingLeft()
  {
    return this.LuY;
  }
  
  public int getTextPaddingRight()
  {
    return this.Lva;
  }
  
  public int getTextPaddingTop()
  {
    return this.LuZ;
  }
  
  public int getWordMargin()
  {
    return this.Lvc;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143576);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/ui/widget/happybubble/LabelsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    int i;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if ((!this.Lvh) && (this.Lve != e.Lvr))
      {
        if (!paramView.isSelected()) {
          break label249;
        }
        if ((this.Lve != e.Lvu) || (!this.Lvm.contains((Integer)paramView.getTag(Lvj)))) {
          break label234;
        }
        i = 1;
        if ((i == 0) && ((this.Lve != e.Lvu) || (this.Lvl.size() > this.Lvg))) {
          break label239;
        }
        i = 1;
        label137:
        if ((i == 0) && (this.Lve != e.Lvt)) {
          break label244;
        }
        i = 1;
        label153:
        if ((i == 0) && (!v(paramView))) {
          b(paramView, false);
        }
      }
    }
    for (;;)
    {
      if (this.Lvn != null)
      {
        localObject = this.Lvn;
        paramView.getTag(Lvi);
        ((Integer)paramView.getTag(Lvj)).intValue();
        ((b)localObject).bPu();
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
      if ((this.Lve == e.Lvs) || (this.Lve == e.Lvt))
      {
        if (!v(paramView))
        {
          fQQ();
          b(paramView, true);
        }
      }
      else if ((this.Lve == e.Lvu) && ((this.Lvf <= 0) || (this.Lvf > this.Lvl.size())) && (!v(paramView))) {
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
      if (!this.JNz)
      {
        n = m;
        i2 = paramInt2;
        k = j;
        i1 = paramInt4;
        if (paramInt3 - paramInt1 < localView.getMeasuredWidth() + paramInt4 + getPaddingRight())
        {
          n = m + 1;
          if ((this.oyV > 0) && (n > this.oyV)) {
            break;
          }
          i1 = getPaddingLeft();
          k = j + this.Lvd + paramInt2;
          i2 = 0;
        }
      }
      localView.layout(i1, k, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + k);
      paramInt4 = i1 + localView.getMeasuredWidth() + this.Lvc;
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
    if (this.JNz)
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
          i = m + this.Lvc;
        }
        k = Math.max(k, localView.getMeasuredHeight());
        j += 1;
      }
      setMeasuredDimension(km(paramInt1, i + getPaddingLeft() + getPaddingRight()), km(paramInt2, getPaddingTop() + k + getPaddingBottom()));
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
        if (this.oyV > 0)
        {
          i3 = n;
          i7 = k;
          i8 = m;
          i9 = i1;
          if (i2 > this.oyV) {}
        }
        else
        {
          i = i1 + this.Lvd + n;
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
          if (this.Lvc + i5 <= i11) {
            break label457;
          }
          i2 = i3 + 1;
          if (this.oyV > 0)
          {
            i3 = i6;
            i7 = j;
            i8 = i5;
            i9 = i;
            if (i2 > this.oyV) {
              break label484;
            }
          }
          i1 = i + this.Lvd + i6;
          k = Math.max(j, i5);
          n = 0;
          m = 0;
        }
        for (;;)
        {
          i4 += 1;
          break;
          label457:
          m = i5 + this.Lvc;
          i2 = i3;
          n = i6;
          k = j;
          i1 = i;
        }
      }
    }
    label484:
    setMeasuredDimension(km(paramInt1, Math.max(i7, i8) + getPaddingLeft() + getPaddingRight()), km(paramInt2, i9 + i3 + getPaddingTop() + getPaddingBottom()));
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
      setLabelTextSize(paramParcelable.getFloat("key_text_size_state", this.pDQ));
      this.LuV = paramParcelable.getInt("key_label_width_state", this.LuV);
      this.LuW = paramParcelable.getInt("key_label_height_state", this.LuW);
      setLabelGravity(paramParcelable.getInt("key_label_gravity_state", this.LuX));
      localObject = paramParcelable.getIntArray("key_padding_state");
      int k;
      int i;
      if ((localObject != null) && (localObject.length == 4))
      {
        k = localObject[0];
        int m = localObject[1];
        int n = localObject[2];
        int i1 = localObject[3];
        if ((this.LuY != k) || (this.LuZ != m) || (this.Lva != n) || (this.Lvb != i1))
        {
          this.LuY = k;
          this.LuZ = m;
          this.Lva = n;
          this.Lvb = i1;
          int i2 = getChildCount();
          i = 0;
          while (i < i2)
          {
            ((TextView)getChildAt(i)).setPadding(k, m, n, i1);
            i += 1;
          }
        }
      }
      setWordMargin(paramParcelable.getInt("key_word_margin_state", this.Lvc));
      setLineMargin(paramParcelable.getInt("key_line_margin_state", this.Lvd));
      setSelectType(e.age(paramParcelable.getInt("key_select_type_state", this.Lve.value)));
      setMaxSelect(paramParcelable.getInt("key_max_select_state", this.Lvf));
      setMinSelect(paramParcelable.getInt("key_min_select_state", this.Lvg));
      setMaxLines(paramParcelable.getInt("key_max_lines_state", this.oyV));
      setIndicator(paramParcelable.getBoolean("key_indicator_state", this.Lvh));
      setSingleLine(paramParcelable.getBoolean("key_single_line_state", this.JNz));
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
    if (this.xpx != null) {
      localBundle.putParcelable("key_text_color_state", this.xpx);
    }
    localBundle.putFloat("key_text_size_state", this.pDQ);
    localBundle.putInt("key_label_width_state", this.LuV);
    localBundle.putInt("key_label_height_state", this.LuW);
    localBundle.putInt("key_label_gravity_state", this.LuX);
    localBundle.putIntArray("key_padding_state", new int[] { this.LuY, this.LuZ, this.Lva, this.Lvb });
    localBundle.putInt("key_word_margin_state", this.Lvc);
    localBundle.putInt("key_line_margin_state", this.Lvd);
    localBundle.putInt("key_select_type_state", this.Lve.value);
    localBundle.putInt("key_max_select_state", this.Lvf);
    localBundle.putInt("key_min_select_state", this.Lvg);
    localBundle.putInt("key_max_lines_state", this.oyV);
    localBundle.putBoolean("key_indicator_state", this.Lvh);
    if (!this.Lvl.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_labels_state", this.Lvl);
    }
    if (!this.Lvm.isEmpty()) {
      localBundle.putIntegerArrayList("key_select_compulsory_state", this.Lvm);
    }
    localBundle.putBoolean("key_single_line_state", this.JNz);
    AppMethodBeat.o(143570);
    return localBundle;
  }
  
  public void setCompulsorys(List<Integer> paramList)
  {
    AppMethodBeat.i(143583);
    if ((this.Lve == e.Lvu) && (paramList != null))
    {
      this.Lvm.clear();
      this.Lvm.addAll(paramList);
      fQQ();
      setSelects(paramList);
    }
    AppMethodBeat.o(143583);
  }
  
  public void setCompulsorys(int... paramVarArgs)
  {
    AppMethodBeat.i(143584);
    if ((this.Lve == e.Lvu) && (paramVarArgs != null))
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
    this.Lvh = paramBoolean;
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
    this.LuU = paramDrawable;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setBackgroundDrawable(this.LuU.getConstantState().newDrawable());
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
    if (this.LuX != paramInt)
    {
      this.LuX = paramInt;
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
    this.xpx = paramColorStateList;
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      ((TextView)getChildAt(i)).setTextColor(this.xpx);
      i += 1;
    }
    AppMethodBeat.o(143591);
  }
  
  public void setLabelTextSize(float paramFloat)
  {
    AppMethodBeat.i(143589);
    if (this.pDQ != paramFloat)
    {
      this.pDQ = paramFloat;
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
    if (this.Lvd != paramInt)
    {
      this.Lvd = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143593);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(143597);
    if (this.oyV != paramInt)
    {
      this.oyV = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143597);
  }
  
  public void setMaxSelect(int paramInt)
  {
    AppMethodBeat.i(143596);
    if (this.Lvf != paramInt)
    {
      this.Lvf = paramInt;
      if (this.Lve == e.Lvu) {
        fQQ();
      }
    }
    AppMethodBeat.o(143596);
  }
  
  public void setMinSelect(int paramInt)
  {
    this.Lvg = paramInt;
  }
  
  public void setOnLabelClickListener(b paramb)
  {
    AppMethodBeat.i(143599);
    this.Lvn = paramb;
    fQO();
    AppMethodBeat.o(143599);
  }
  
  public void setOnLabelSelectChangeListener(c paramc)
  {
    this.Lvo = paramc;
  }
  
  public void setOnSelectChangeIntercept(d paramd)
  {
    this.Lvp = paramd;
  }
  
  public void setSelectType(e parame)
  {
    AppMethodBeat.i(143595);
    if (this.Lve != parame)
    {
      this.Lve = parame;
      fQQ();
      if (this.Lve == e.Lvt) {
        setSelects(new int[] { 0 });
      }
      if (this.Lve != e.Lvu) {
        this.Lvm.clear();
      }
      fQO();
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
    if (this.Lve != e.Lvr)
    {
      ArrayList localArrayList = new ArrayList();
      int k = getChildCount();
      if ((this.Lve == e.Lvs) || (this.Lve == e.Lvt)) {}
      for (int i = 1;; i = this.Lvf)
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
    if (this.JNz != paramBoolean)
    {
      this.JNz = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(143598);
  }
  
  public void setWordMargin(int paramInt)
  {
    AppMethodBeat.i(143594);
    if (this.Lvc != paramInt)
    {
      this.Lvc = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(143594);
  }
  
  public static abstract interface a<T>
  {
    public abstract CharSequence cS(T paramT);
  }
  
  public static abstract interface b
  {
    public abstract void bPu();
  }
  
  public static abstract interface c {}
  
  public static abstract interface d
  {
    public abstract boolean fQS();
  }
  
  public static enum e
  {
    int value;
    
    static
    {
      AppMethodBeat.i(143562);
      Lvr = new e("NONE", 0, 1);
      Lvs = new e("SINGLE", 1, 2);
      Lvt = new e("SINGLE_IRREVOCABLY", 2, 3);
      Lvu = new e("MULTI", 3, 4);
      Lvv = new e[] { Lvr, Lvs, Lvt, Lvu };
      AppMethodBeat.o(143562);
    }
    
    private e(int paramInt)
    {
      this.value = paramInt;
    }
    
    static e age(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return Lvr;
      case 1: 
        return Lvr;
      case 2: 
        return Lvs;
      case 3: 
        return Lvt;
      }
      return Lvu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.LabelsView
 * JD-Core Version:    0.7.0.1
 */