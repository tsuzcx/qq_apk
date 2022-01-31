package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.t;

public class MMTabView
  extends ViewGroup
{
  private TextView gpL;
  private int index;
  private int padding;
  public int total;
  private TextView yZM;
  private ImageView zct;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(106112);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(106112);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(106113);
    this.index = paramInt;
    dCA();
    AppMethodBeat.o(106113);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106111);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(106111);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106110);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(106110);
  }
  
  private void init()
  {
    AppMethodBeat.i(106115);
    this.padding = getResources().getDimensionPixelSize(2131427861);
    Object localObject = aa.dsG();
    boolean bool1 = aa.dsC();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cb.a.dr(getContext()) * com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.gpL = new TextView(getContext());
      this.gpL.setSingleLine();
      this.gpL.setEllipsize(TextUtils.TruncateAt.END);
      this.gpL.setTextColor(getResources().getColorStateList(2131690701));
      this.gpL.setTextSize(0, com.tencent.mm.cb.a.ao(getContext(), 2131427758));
      this.gpL.setText("");
      if (bool1)
      {
        localObject = this.gpL;
        float f = this.gpL.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.gpL.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.gpL);
        this.zct = new ImageView(getContext());
        this.zct.setBackgroundResource(2130840641);
        this.zct.setVisibility(4);
        addView(this.zct);
        this.yZM = new TextView(getContext());
        this.yZM.setTextColor(getResources().getColor(2131690709));
        this.yZM.setTextSize(1, 11.0F);
        this.yZM.setBackgroundResource(t.iF(getContext()));
        this.yZM.setTypeface(Typeface.DEFAULT_BOLD);
        this.yZM.setGravity(17);
        this.yZM.setVisibility(4);
        addView(this.yZM);
        setBackgroundResource(2130839285);
        AppMethodBeat.o(106115);
        return;
        if (bool2) {
          this.gpL.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void dCA()
  {
    AppMethodBeat.i(106114);
    ab.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.dDt().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(106114);
  }
  
  public String getText()
  {
    AppMethodBeat.i(106119);
    String str = this.gpL.getText().toString();
    AppMethodBeat.o(106119);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(106120);
    String str = this.yZM.getText().toString();
    AppMethodBeat.o(106120);
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106124);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.gpL.getMeasuredWidth()) / 2;
    paramInt4 = this.gpL.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.gpL.getMeasuredHeight()) / 2;
    int j = this.gpL.getMeasuredHeight();
    this.gpL.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.zct.getMeasuredWidth();
    int k = (paramInt1 - this.zct.getMeasuredHeight()) / 2;
    int m = this.zct.getMeasuredHeight();
    this.zct.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.yZM.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.yZM.getMeasuredWidth();
      paramInt3 = this.yZM.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.yZM.getMeasuredHeight()) / 2;
      paramInt4 = this.yZM.getMeasuredHeight();
      this.yZM.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(106124);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.yZM.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.yZM.getMeasuredHeight()) / 2;
    paramInt4 = this.yZM.getMeasuredHeight();
    this.yZM.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
    AppMethodBeat.o(106124);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106123);
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.gpL.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.zct.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.yZM.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(106123);
      return;
    }
  }
  
  public final void qs(boolean paramBoolean)
  {
    AppMethodBeat.i(106122);
    ImageView localImageView = this.zct;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(106122);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(106116);
    this.gpL.setText(paramInt);
    AppMethodBeat.o(106116);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106117);
    this.gpL.setText(paramString);
    AppMethodBeat.o(106117);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(106118);
    this.gpL.setTextColor(paramColorStateList);
    AppMethodBeat.o(106118);
  }
  
  public void setUnread(String paramString)
  {
    AppMethodBeat.i(106121);
    if (bo.isNullOrNil(paramString))
    {
      this.yZM.setVisibility(4);
      AppMethodBeat.o(106121);
      return;
    }
    this.yZM.setVisibility(0);
    this.yZM.post(new MMTabView.1(this, paramString));
    AppMethodBeat.o(106121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */