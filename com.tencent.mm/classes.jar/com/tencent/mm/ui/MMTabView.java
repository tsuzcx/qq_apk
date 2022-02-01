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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.u;

public class MMTabView
  extends ViewGroup
{
  private TextView Hmb;
  private ImageView Hpl;
  public int hLN;
  private TextView iCg;
  private int index;
  private int padding;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141470);
    this.hLN = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141470);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(141471);
    this.index = paramInt;
    fgO();
    AppMethodBeat.o(141471);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141469);
    this.hLN = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141469);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141468);
    this.hLN = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141468);
  }
  
  private void init()
  {
    AppMethodBeat.i(141473);
    this.padding = getResources().getDimensionPixelSize(2131165575);
    Object localObject = ab.eUO();
    boolean bool1 = ab.eUK();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cc.a.eb(getContext()) * com.tencent.mm.cc.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.iCg = new TextView(getContext());
      this.iCg.setSingleLine();
      this.iCg.setEllipsize(TextUtils.TruncateAt.END);
      this.iCg.setTextColor(getResources().getColorStateList(2131101171));
      this.iCg.setTextSize(0, com.tencent.mm.cc.a.au(getContext(), 2131165466));
      this.iCg.setText("");
      if (bool1)
      {
        localObject = this.iCg;
        float f = this.iCg.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.iCg.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.iCg);
        this.Hpl = new ImageView(getContext());
        this.Hpl.setBackgroundResource(2131234447);
        this.Hpl.setVisibility(4);
        addView(this.Hpl);
        this.Hmb = new TextView(getContext());
        this.Hmb.setTextColor(getResources().getColor(2131101182));
        this.Hmb.setTextSize(1, 11.0F);
        this.Hmb.setBackgroundResource(u.ks(getContext()));
        this.Hmb.setTypeface(Typeface.DEFAULT_BOLD);
        this.Hmb.setGravity(17);
        this.Hmb.setVisibility(4);
        addView(this.Hmb);
        setBackgroundResource(2131232878);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.iCg.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void fgO()
  {
    AppMethodBeat.i(141472);
    ac.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.fhP().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.iCg.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.Hmb.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.iCg.getMeasuredWidth()) / 2;
    paramInt4 = this.iCg.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.iCg.getMeasuredHeight()) / 2;
    int j = this.iCg.getMeasuredHeight();
    this.iCg.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.Hpl.getMeasuredWidth();
    int k = (paramInt1 - this.Hpl.getMeasuredHeight()) / 2;
    int m = this.Hpl.getMeasuredHeight();
    this.Hpl.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.Hmb.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.Hmb.getMeasuredWidth();
      paramInt3 = this.Hmb.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.Hmb.getMeasuredHeight()) / 2;
      paramInt4 = this.Hmb.getMeasuredHeight();
      this.Hmb.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.Hmb.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.Hmb.getMeasuredHeight()) / 2;
    paramInt4 = this.Hmb.getMeasuredHeight();
    this.Hmb.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
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
      this.iCg.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.Hpl.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.Hmb.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.iCg.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.iCg.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.iCg.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(final String paramString)
  {
    AppMethodBeat.i(141479);
    if (bs.isNullOrNil(paramString))
    {
      this.Hmb.setVisibility(4);
      AppMethodBeat.o(141479);
      return;
    }
    this.Hmb.setVisibility(0);
    this.Hmb.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(u.aM(MMTabView.this.getContext(), Integer.parseInt(paramString)));
        MMTabView.this.fgO();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(141479);
  }
  
  public final void wB(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.Hpl;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141480);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */