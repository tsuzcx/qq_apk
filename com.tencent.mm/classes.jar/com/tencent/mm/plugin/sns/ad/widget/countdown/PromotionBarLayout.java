package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.f.a;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.i.f;

public class PromotionBarLayout
  extends RelativeLayout
  implements c
{
  private d JLS;
  private a JLT;
  private View JLZ;
  private TextView JMa;
  private TextView JMb;
  
  public PromotionBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PromotionBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void b(long paramLong, f.a parama)
  {
    AppMethodBeat.i(201079);
    if (paramLong <= 0L) {}
    try
    {
      setVisibility(8);
      View localView = this.JLZ;
      if ((localView instanceof c)) {
        ((c)localView).b(paramLong, parama);
      }
      AppMethodBeat.o(201079);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(201079);
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(201075);
    try
    {
      a locala = this.JLT;
      if ((locala != null) && (locala.JLU != null))
      {
        d locald = locala.JLU.getCountDownVM();
        if ((locald != null) && (locald != paramd)) {
          a.a(locald);
        }
        paramd.a(locala.JLU);
        paramd.fMb();
      }
      this.JLS = paramd;
      AppMethodBeat.o(201075);
      return;
    }
    catch (Throwable paramd)
    {
      AppMethodBeat.o(201075);
    }
  }
  
  public d getCountDownVM()
  {
    return this.JLS;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(201077);
    super.onDetachedFromWindow();
    try
    {
      if (this.JLT != null) {
        a.a(this.JLS);
      }
      AppMethodBeat.o(201077);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201077);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(201070);
    super.onFinishInflate();
    try
    {
      this.JLT = new a(this);
      this.JLZ = findViewById(i.f.ad_promotion_countdown);
      this.JMa = ((TextView)findViewById(i.f.ad_promotion_price));
      this.JMb = ((TextView)findViewById(i.f.sns_ad_countdown_title));
      AppMethodBeat.o(201070);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201070);
    }
  }
  
  public void setPromotionalPrice(String paramString)
  {
    AppMethodBeat.i(201072);
    if ((this.JMa != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.JMa.setText(paramString);
      l.C(this.JMa);
    }
    AppMethodBeat.o(201072);
  }
  
  public void setRightTitle(String paramString)
  {
    AppMethodBeat.i(201073);
    if (this.JMb != null) {
      this.JMb.setText(paramString);
    }
    AppMethodBeat.o(201073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout
 * JD-Core Version:    0.7.0.1
 */