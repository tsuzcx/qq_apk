package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.w;

public class MMTabView
  extends ViewGroup
{
  private TextView VYd;
  private ImageView Wbq;
  private int index;
  private TextView mNb;
  private int padding;
  public int total;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141470);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141470);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(141471);
    this.index = paramInt;
    hHT();
    AppMethodBeat.o(141471);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141469);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141469);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141468);
    this.total = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141468);
  }
  
  private void init()
  {
    AppMethodBeat.i(141473);
    this.padding = getResources().getDimensionPixelSize(a.e.SmallestPadding);
    Object localObject = LocaleUtil.getApplicationLanguage();
    boolean bool1 = LocaleUtil.isChineseAppLang();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.ci.a.ez(getContext()) * com.tencent.mm.ci.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.mNb = new TextView(getContext());
      this.mNb.setSingleLine();
      this.mNb.setEllipsize(TextUtils.TruncateAt.END);
      this.mNb.setTextColor(getResources().getColorStateList(a.d.wechat_green));
      this.mNb.setTextSize(0, com.tencent.mm.ci.a.aY(getContext(), a.e.HintTextSize));
      this.mNb.setText("");
      if (bool1)
      {
        localObject = this.mNb;
        float f = this.mNb.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.mNb.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.mNb);
        this.Wbq = new ImageView(getContext());
        this.Wbq.setBackgroundResource(a.f.unread_dot_shape);
        this.Wbq.setVisibility(4);
        addView(this.Wbq);
        this.VYd = new TextView(getContext());
        this.VYd.setTextColor(getResources().getColor(a.d.white_text_color));
        this.VYd.setTextSize(1, 11.0F);
        this.VYd.setBackgroundResource(w.lE(getContext()));
        this.VYd.setTypeface(Typeface.DEFAULT_BOLD);
        this.VYd.setGravity(17);
        this.VYd.setVisibility(4);
        addView(this.VYd);
        setBackgroundResource(a.f.list_thicklinecell_bg);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.mNb.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void FA(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.Wbq;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141480);
      return;
    }
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.mNb.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.VYd.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  public final void hHT()
  {
    AppMethodBeat.i(141472);
    Log.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.hJg().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.mNb.getMeasuredWidth()) / 2;
    paramInt4 = this.mNb.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.mNb.getMeasuredHeight()) / 2;
    int j = this.mNb.getMeasuredHeight();
    this.mNb.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.Wbq.getMeasuredWidth();
    int k = (paramInt1 - this.Wbq.getMeasuredHeight()) / 2;
    int m = this.Wbq.getMeasuredHeight();
    this.Wbq.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.VYd.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.VYd.getMeasuredWidth();
      paramInt3 = this.VYd.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.VYd.getMeasuredHeight()) / 2;
      paramInt4 = this.VYd.getMeasuredHeight();
      this.VYd.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.VYd.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.VYd.getMeasuredHeight()) / 2;
    paramInt4 = this.VYd.getMeasuredHeight();
    this.VYd.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
    AppMethodBeat.o(141482);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141481);
    int i = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    int j = View.MeasureSpec.getSize(paramInt2) - getPaddingTop() - getPaddingBottom();
    if (View.MeasureSpec.getMode(paramInt2) == -2147483648) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.mNb.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.Wbq.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.VYd.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.mNb.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.mNb.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.mNb.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(final String paramString)
  {
    AppMethodBeat.i(141479);
    if (Util.isNullOrNil(paramString))
    {
      this.VYd.setVisibility(4);
      AppMethodBeat.o(141479);
      return;
    }
    this.VYd.setVisibility(0);
    this.VYd.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(w.bj(MMTabView.this.getContext(), Integer.parseInt(paramString)));
        MMTabView.this.hHT();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(141479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */