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
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.a.b;
import com.tencent.mm.ui.tools.q;

public class MMTabView
  extends ViewGroup
{
  private TextView eXO;
  private int index;
  private int padding = 0;
  public int total = 3;
  private TextView uLH;
  private ImageView uOA;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    this.index = paramInt;
    czG();
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.padding = getResources().getDimensionPixelSize(a.e.SmallestPadding);
    Object localObject = x.cqJ();
    boolean bool1 = x.cqF();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cb.a.cJ(getContext()) * com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.eXO = new TextView(getContext());
      this.eXO.setSingleLine();
      this.eXO.setEllipsize(TextUtils.TruncateAt.END);
      this.eXO.setTextColor(getResources().getColorStateList(a.d.wechat_green));
      this.eXO.setTextSize(0, com.tencent.mm.cb.a.aa(getContext(), a.e.HintTextSize));
      this.eXO.setText("");
      if (bool1)
      {
        localObject = this.eXO;
        float f = this.eXO.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.eXO.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.eXO);
        this.uOA = new ImageView(getContext());
        this.uOA.setBackgroundResource(a.f.unread_dot_shape);
        this.uOA.setVisibility(4);
        addView(this.uOA);
        this.uLH = new TextView(getContext());
        this.uLH.setTextColor(getResources().getColor(a.d.white));
        this.uLH.setTextSize(1, 11.0F);
        this.uLH.setBackgroundResource(q.hh(getContext()));
        this.uLH.setTypeface(Typeface.DEFAULT_BOLD);
        this.uLH.setGravity(17);
        this.uLH.setVisibility(4);
        addView(this.uLH);
        setBackgroundResource(a.f.list_thicklinecell_bg);
        return;
        if (bool2) {
          this.eXO.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void czG()
  {
    y.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    com.tencent.mm.ui.a.a locala = a.a.cAj();
    String str1 = getText();
    String str2 = getUnread();
    int j = this.index;
    if ((!locala.cAi()) || (this == null) || (bk.bl(str1)) || (locala.ze == null)) {
      return;
    }
    b localb = new b();
    localb.acY(str1);
    if (!bk.bl(str2)) {}
    for (;;)
    {
      try
      {
        i = bk.getInt(str2, 0);
        if (i > 0)
        {
          if (i > 0) {
            localb.acY(locala.ze.getResources().getQuantityString(a.i.tab_desc_unread, 1, new Object[] { Integer.valueOf(i) }));
          }
          localb.acY(locala.ze.getResources().getQuantityString(a.i.tab_name_site_desc, 5, new Object[] { Integer.valueOf(3), Integer.valueOf(j + 1) }));
          localb.dB(this);
          return;
        }
      }
      catch (Exception localException) {}
      int i = 0;
    }
  }
  
  public String getText()
  {
    return this.eXO.getText().toString();
  }
  
  public String getUnread()
  {
    return this.uLH.getText().toString();
  }
  
  public final void mV(boolean paramBoolean)
  {
    ImageView localImageView = this.uOA;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.eXO.getMeasuredWidth()) / 2;
    paramInt4 = this.eXO.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.eXO.getMeasuredHeight()) / 2;
    int j = this.eXO.getMeasuredHeight();
    this.eXO.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.uOA.getMeasuredWidth();
    int k = (paramInt1 - this.uOA.getMeasuredHeight()) / 2;
    int m = this.uOA.getMeasuredHeight();
    this.uOA.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.uLH.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.uLH.getMeasuredWidth();
      paramInt3 = this.uLH.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.uLH.getMeasuredHeight()) / 2;
      paramInt4 = this.uLH.getMeasuredHeight();
      this.uLH.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.uLH.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.uLH.getMeasuredHeight()) / 2;
    paramInt4 = this.uLH.getMeasuredHeight();
    this.uLH.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.eXO.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.uOA.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.uLH.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    this.eXO.setText(paramInt);
  }
  
  public void setText(String paramString)
  {
    this.eXO.setText(paramString);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.eXO.setTextColor(paramColorStateList);
  }
  
  public void setUnread(String paramString)
  {
    if (bk.bl(paramString))
    {
      this.uLH.setVisibility(4);
      return;
    }
    this.uLH.setVisibility(0);
    this.uLH.post(new MMTabView.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */