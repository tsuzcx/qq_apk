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
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.tools.v;

public class MMTabView
  extends ViewGroup
{
  private TextView OEK;
  private ImageView OHV;
  private int index;
  private TextView jVO;
  public int jcu;
  private int padding;
  
  private MMTabView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(141470);
    this.jcu = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141470);
  }
  
  public MMTabView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(141471);
    this.index = paramInt;
    gIW();
    AppMethodBeat.o(141471);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141469);
    this.jcu = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141469);
  }
  
  public MMTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141468);
    this.jcu = 3;
    this.padding = 0;
    init();
    AppMethodBeat.o(141468);
  }
  
  private void init()
  {
    AppMethodBeat.i(141473);
    this.padding = getResources().getDimensionPixelSize(2131165593);
    Object localObject = LocaleUtil.getApplicationLanguage();
    boolean bool1 = LocaleUtil.isChineseAppLang();
    boolean bool2 = ((String)localObject).equalsIgnoreCase("en");
    if (bool1) {}
    for (int i = (int)(com.tencent.mm.cb.a.ez(getContext()) * com.tencent.mm.cb.a.fromDPToPix(getContext(), 2));; i = 0)
    {
      this.jVO = new TextView(getContext());
      this.jVO.setSingleLine();
      this.jVO.setEllipsize(TextUtils.TruncateAt.END);
      this.jVO.setTextColor(getResources().getColorStateList(2131101414));
      this.jVO.setTextSize(0, com.tencent.mm.cb.a.aG(getContext(), 2131165482));
      this.jVO.setText("");
      if (bool1)
      {
        localObject = this.jVO;
        float f = this.jVO.getTextSize();
        ((TextView)localObject).setTextSize(0, i + f);
        this.jVO.setTypeface(null, 0);
      }
      for (;;)
      {
        addView(this.jVO);
        this.OHV = new ImageView(getContext());
        this.OHV.setBackgroundResource(2131235385);
        this.OHV.setVisibility(4);
        addView(this.OHV);
        this.OEK = new TextView(getContext());
        this.OEK.setTextColor(getResources().getColor(2131101427));
        this.OEK.setTextSize(1, 11.0F);
        this.OEK.setBackgroundResource(v.kH(getContext()));
        this.OEK.setTypeface(Typeface.DEFAULT_BOLD);
        this.OEK.setGravity(17);
        this.OEK.setVisibility(4);
        addView(this.OEK);
        setBackgroundResource(2131233338);
        AppMethodBeat.o(141473);
        return;
        if (bool2) {
          this.jVO.setTypeface(null, 1);
        }
      }
    }
  }
  
  public final void Bk(boolean paramBoolean)
  {
    AppMethodBeat.i(141480);
    ImageView localImageView = this.OHV;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      AppMethodBeat.o(141480);
      return;
    }
  }
  
  public final void gIW()
  {
    AppMethodBeat.i(141472);
    Log.d("MicroMsg.MMTabView", "jacks build : %d desc, unread: %s", new Object[] { Integer.valueOf(this.index), getUnread() });
    a.a.gKe().a(this, getText(), getUnread(), this.index);
    AppMethodBeat.o(141472);
  }
  
  public String getText()
  {
    AppMethodBeat.i(141477);
    String str = this.jVO.getText().toString();
    AppMethodBeat.o(141477);
    return str;
  }
  
  public String getUnread()
  {
    AppMethodBeat.i(141478);
    String str = this.OEK.getText().toString();
    AppMethodBeat.o(141478);
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141482);
    paramInt3 -= paramInt1;
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = (paramInt3 - this.jVO.getMeasuredWidth()) / 2;
    paramInt4 = this.jVO.getMeasuredWidth() + paramInt2;
    int i = (paramInt1 - this.jVO.getMeasuredHeight()) / 2;
    int j = this.jVO.getMeasuredHeight();
    this.jVO.layout(paramInt2, i, paramInt4, j + i);
    i = this.padding + paramInt4;
    j = this.OHV.getMeasuredWidth();
    int k = (paramInt1 - this.OHV.getMeasuredHeight()) / 2;
    int m = this.OHV.getMeasuredHeight();
    this.OHV.layout(i, k, j + i, m + k);
    if (paramInt2 - this.padding < this.OEK.getMeasuredWidth())
    {
      paramInt2 = paramInt3 - this.OEK.getMeasuredWidth();
      paramInt3 = this.OEK.getMeasuredWidth();
      paramInt1 = (paramInt1 - this.OEK.getMeasuredHeight()) / 2;
      paramInt4 = this.OEK.getMeasuredHeight();
      this.OEK.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
      AppMethodBeat.o(141482);
      return;
    }
    paramInt2 = this.padding + paramInt4;
    paramInt3 = this.OEK.getMeasuredWidth();
    paramInt1 = (paramInt1 - this.OEK.getMeasuredHeight()) / 2;
    paramInt4 = this.OEK.getMeasuredHeight();
    this.OEK.layout(paramInt2, paramInt1, paramInt3 + paramInt2, paramInt4 + paramInt1);
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
      this.jVO.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.OHV.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      this.OEK.measure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), paramInt1);
      setMeasuredDimension(i, j);
      AppMethodBeat.o(141481);
      return;
    }
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(141474);
    this.jVO.setText(paramInt);
    AppMethodBeat.o(141474);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141475);
    this.jVO.setText(paramString);
    AppMethodBeat.o(141475);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(141476);
    this.jVO.setTextColor(paramInt);
    AppMethodBeat.o(141476);
  }
  
  public void setUnread(final String paramString)
  {
    AppMethodBeat.i(141479);
    if (Util.isNullOrNil(paramString))
    {
      this.OEK.setVisibility(4);
      AppMethodBeat.o(141479);
      return;
    }
    this.OEK.setVisibility(0);
    this.OEK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141467);
        MMTabView.a(MMTabView.this).setText(paramString);
        MMTabView.a(MMTabView.this).setBackgroundResource(v.aQ(MMTabView.this.getContext(), Integer.parseInt(paramString)));
        MMTabView.this.gIW();
        AppMethodBeat.o(141467);
      }
    });
    AppMethodBeat.o(141479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView
 * JD-Core Version:    0.7.0.1
 */