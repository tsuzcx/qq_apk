package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.f.a;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.b.f;

public class PromotionBarLayout
  extends RelativeLayout
  implements c
{
  private View QfA;
  private TextView QfB;
  private TextView QfC;
  private d Qft;
  private a Qfu;
  
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
    AppMethodBeat.i(310475);
    if (paramLong <= 0L) {}
    try
    {
      setVisibility(8);
      View localView = this.QfA;
      if ((localView instanceof c)) {
        ((c)localView).b(paramLong, parama);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310475);
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(310451);
    try
    {
      a locala = this.Qfu;
      if ((locala != null) && (locala.Qfv != null))
      {
        d locald = locala.Qfv.getCountDownVM();
        if ((locald != null) && (locald != paramd)) {
          a.a(locald);
        }
        paramd.a(locala.Qfv);
        paramd.exT();
      }
      this.Qft = paramd;
      return;
    }
    finally
    {
      AppMethodBeat.o(310451);
    }
  }
  
  public d getCountDownVM()
  {
    return this.Qft;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310459);
    super.onDetachedFromWindow();
    try
    {
      if (this.Qfu != null) {
        a.a(this.Qft);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310459);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(310428);
    super.onFinishInflate();
    try
    {
      this.Qfu = new a(this);
      this.QfA = findViewById(b.f.ad_promotion_countdown);
      this.QfB = ((TextView)findViewById(b.f.ad_promotion_price));
      this.QfC = ((TextView)findViewById(b.f.sns_ad_countdown_title));
      return;
    }
    finally
    {
      AppMethodBeat.o(310428);
    }
  }
  
  public void setPromotionalPrice(String paramString)
  {
    AppMethodBeat.i(310435);
    if ((this.QfB != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.QfB.setText(paramString);
      l.F(this.QfB);
    }
    AppMethodBeat.o(310435);
  }
  
  public void setRightTitle(String paramString)
  {
    AppMethodBeat.i(310443);
    if (this.QfC != null) {
      this.QfC.setText(paramString);
    }
    AppMethodBeat.o(310443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout
 * JD-Core Version:    0.7.0.1
 */