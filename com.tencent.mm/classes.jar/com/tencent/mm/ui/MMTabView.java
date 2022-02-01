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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.u;

public class MMTabView
  extends ViewGroup
{
  private TextView IZI;
  private ImageView JcR;
  private TextView iVq;
  public int ieH;
  private int index;
  private int padding;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141470);
    this.ieH = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141470);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(141471);
    this.index = paramInt;
    fxa();
    AppMethodBeat.o(141471);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141469);
    this.ieH = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141469);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141468);
    this.ieH = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141468);
  }
  
  private void init()
  {
    AppMethodBeat.i(141473);
    this.padding = getResources().getDimensionPixelSize(2131165575);
    Object localObject = ac.fks();
    boolean bool1 = ac.fko();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cc.a.eb(getContext()) * com.tencent.mm.cc.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.iVq = new TextView(getContext());
      this.iVq.setSingleLine();
      this.iVq.setEllipsize(TextUtils.TruncateAt.END);
      this.iVq.setTextColor(getResources().getColorStateList(2131101171));
      this.iVq.setTextSize(0, com.tencent.mm.cc.a.ax(getContext(), 2131165466));
      this.iVq.setText("");
      if (bool1)
      {
        localObject = this.iVq;
        float f = this.iVq.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.iVq.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.iVq);
        this.JcR = new ImageView(getContext());
        this.JcR.setBackgroundResource(2131234447);
        this.JcR.setVisibility(4);
        addView(this.JcR);
        this.IZI = new TextView(getContext());
        this.IZI.setTextColor(getResources().getColor(2131101182));
        this.IZI.setTextSize(1, 11.0F);
        this.IZI.setBackgroundResource(u.kE(getContext()));
        this.IZI.setTypeface(Typeface.DEFAULT_BOLD);
        this.IZI.setGravity(17);
        this.IZI.setVisibility(4);
        addView(this.IZI);
        setBackgroundResource(2131232878);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.iVq.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void fxa()
  {
    AppMethodBeat.i(141472);
    ad.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.fyf().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.iVq.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.IZI.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.iVq.getMeasuredWidth()) / 2;
    paramInt4 = this.iVq.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.iVq.getMeasuredHeight()) / 2;
    int j = this.iVq.getMeasuredHeight();
    this.iVq.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.JcR.getMeasuredWidth();
    int k = (paramInt1 - this.JcR.getMeasuredHeight()) / 2;
    int m = this.JcR.getMeasuredHeight();
    this.JcR.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.IZI.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.IZI.getMeasuredWidth();
      paramInt3 = this.IZI.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.IZI.getMeasuredHeight()) / 2;
      paramInt4 = this.IZI.getMeasuredHeight();
      this.IZI.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.IZI.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.IZI.getMeasuredHeight()) / 2;
    paramInt4 = this.IZI.getMeasuredHeight();
    this.IZI.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
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
      this.iVq.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.JcR.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.IZI.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.iVq.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.iVq.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.iVq.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(final String paramString)
  {
    AppMethodBeat.i(141479);
    if (bt.isNullOrNil(paramString))
    {
      this.IZI.setVisibility(4);
      AppMethodBeat.o(141479);
      return;
    }
    this.IZI.setVisibility(0);
    this.IZI.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(u.aP(MMTabView.this.getContext(), Integer.parseInt(paramString)));
        MMTabView.this.fxa();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(141479);
  }
  
  public final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.JcR;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141480);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */