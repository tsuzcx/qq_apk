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
  private TextView FMT;
  private ImageView FPA;
  public int hlk;
  private TextView ica;
  private int index;
  private int padding;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141470);
    this.hlk = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141470);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(141471);
    this.index = paramInt;
    eRf();
    AppMethodBeat.o(141471);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141469);
    this.hlk = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141469);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141468);
    this.hlk = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141468);
  }
  
  private void init()
  {
    AppMethodBeat.i(141473);
    this.padding = getResources().getDimensionPixelSize(2131165575);
    Object localObject = ac.eFu();
    boolean bool1 = ac.eFq();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cd.a.dT(getContext()) * com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.ica = new TextView(getContext());
      this.ica.setSingleLine();
      this.ica.setEllipsize(TextUtils.TruncateAt.END);
      this.ica.setTextColor(getResources().getColorStateList(2131101171));
      this.ica.setTextSize(0, com.tencent.mm.cd.a.ao(getContext(), 2131165466));
      this.ica.setText("");
      if (bool1)
      {
        localObject = this.ica;
        float f = this.ica.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.ica.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.ica);
        this.FPA = new ImageView(getContext());
        this.FPA.setBackgroundResource(2131234447);
        this.FPA.setVisibility(4);
        addView(this.FPA);
        this.FMT = new TextView(getContext());
        this.FMT.setTextColor(getResources().getColor(2131101182));
        this.FMT.setTextSize(1, 11.0F);
        this.FMT.setBackgroundResource(u.kh(getContext()));
        this.FMT.setTypeface(Typeface.DEFAULT_BOLD);
        this.FMT.setGravity(17);
        this.FMT.setVisibility(4);
        addView(this.FMT);
        setBackgroundResource(2131232878);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.ica.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void eRf()
  {
    AppMethodBeat.i(141472);
    ad.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.eSf().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.ica.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.FMT.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.ica.getMeasuredWidth()) / 2;
    paramInt4 = this.ica.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.ica.getMeasuredHeight()) / 2;
    int j = this.ica.getMeasuredHeight();
    this.ica.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.FPA.getMeasuredWidth();
    int k = (paramInt1 - this.FPA.getMeasuredHeight()) / 2;
    int m = this.FPA.getMeasuredHeight();
    this.FPA.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.FMT.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.FMT.getMeasuredWidth();
      paramInt3 = this.FMT.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.FMT.getMeasuredHeight()) / 2;
      paramInt4 = this.FMT.getMeasuredHeight();
      this.FMT.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.FMT.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.FMT.getMeasuredHeight()) / 2;
    paramInt4 = this.FMT.getMeasuredHeight();
    this.FMT.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
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
      this.ica.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.FPA.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.FMT.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.ica.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.ica.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.ica.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(final String paramString)
  {
    AppMethodBeat.i(141479);
    if (bt.isNullOrNil(paramString))
    {
      this.FMT.setVisibility(4);
      AppMethodBeat.o(141479);
      return;
    }
    this.FMT.setVisibility(0);
    this.FMT.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(u.aG(MMTabView.this.getContext(), Integer.parseInt(paramString)));
        MMTabView.this.eRf();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(141479);
  }
  
  public final void vz(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.FPA;
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