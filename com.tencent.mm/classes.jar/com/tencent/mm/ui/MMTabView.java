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
import com.tencent.mm.ui.tools.v;

public class MMTabView
  extends ViewGroup
{
  private int index;
  private TextView pJJ;
  private int padding;
  public int total;
  private ImageView yaP;
  private TextView yaQ;
  
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
    dCS();
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
    for (int i = (int)(com.tencent.mm.cd.a.getScaleSize(getContext()) * com.tencent.mm.cd.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.pJJ = new TextView(getContext());
      this.pJJ.setSingleLine();
      this.pJJ.setEllipsize(TextUtils.TruncateAt.END);
      this.pJJ.setTextColor(getResources().getColorStateList(a.d.wechat_green));
      this.pJJ.setTextSize(0, com.tencent.mm.cd.a.br(getContext(), a.e.HintTextSize));
      this.pJJ.setText("");
      if (bool1)
      {
        localObject = this.pJJ;
        float f = this.pJJ.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.pJJ.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.pJJ);
        this.yaP = new ImageView(getContext());
        this.yaP.setBackgroundResource(a.f.unread_dot_shape);
        this.yaP.setVisibility(4);
        addView(this.yaP);
        this.yaQ = new TextView(getContext());
        this.yaQ.setTextColor(getResources().getColor(a.d.white_text_color));
        this.yaQ.setTextSize(1, 11.0F);
        this.yaQ.setBackgroundResource(v.nH(getContext()));
        this.yaQ.setTypeface(Typeface.DEFAULT_BOLD);
        this.yaQ.setGravity(17);
        this.yaQ.setVisibility(4);
        addView(this.yaQ);
        setBackgroundResource(a.f.list_thicklinecell_bg);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.pJJ.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void dCS()
  {
    AppMethodBeat.i(141472);
    Log.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.jlv().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.pJJ.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.yaQ.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  public final void kb(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(369619);
    if (Util.isNullOrNil(paramString))
    {
      this.yaQ.setVisibility(4);
      AppMethodBeat.o(369619);
      return;
    }
    this.yaQ.setVisibility(0);
    this.yaQ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(paramInt);
        MMTabView.this.dCS();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(369619);
  }
  
  public final void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.yaP;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141480);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.pJJ.getMeasuredWidth()) / 2;
    paramInt4 = this.pJJ.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.pJJ.getMeasuredHeight()) / 2;
    int j = this.pJJ.getMeasuredHeight();
    this.pJJ.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.yaP.getMeasuredWidth();
    int k = (paramInt1 - this.yaP.getMeasuredHeight()) / 2;
    int m = this.yaP.getMeasuredHeight();
    this.yaP.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.yaQ.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.yaQ.getMeasuredWidth();
      paramInt3 = this.yaQ.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.yaQ.getMeasuredHeight()) / 2;
      paramInt4 = this.yaQ.getMeasuredHeight();
      this.yaQ.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.yaQ.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.yaQ.getMeasuredHeight()) / 2;
    paramInt4 = this.yaQ.getMeasuredHeight();
    this.yaQ.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
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
      this.pJJ.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.yaP.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.yaQ.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.pJJ.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.pJJ.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.pJJ.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(String paramString)
  {
    AppMethodBeat.i(141479);
    kb(paramString, v.bC(getContext(), Integer.parseInt(paramString)));
    AppMethodBeat.o(141479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */