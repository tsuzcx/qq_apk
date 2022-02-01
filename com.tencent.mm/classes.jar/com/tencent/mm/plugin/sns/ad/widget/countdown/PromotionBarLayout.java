package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.e.a;
import com.tencent.mm.plugin.sns.ad.i.m;

public class PromotionBarLayout
  extends RelativeLayout
  implements c
{
  private d DAp;
  private a DAq;
  private View DAw;
  private TextView DAx;
  private TextView DAy;
  
  public PromotionBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PromotionBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void b(long paramLong, e.a parama)
  {
    AppMethodBeat.i(202406);
    if (paramLong <= 0L) {}
    try
    {
      setVisibility(8);
      View localView = this.DAw;
      if ((localView instanceof c)) {
        ((c)localView).b(paramLong, parama);
      }
      AppMethodBeat.o(202406);
      return;
    }
    catch (Throwable parama)
    {
      AppMethodBeat.o(202406);
    }
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(202404);
    try
    {
      a locala = this.DAq;
      if ((locala != null) && (locala.DAr != null))
      {
        d locald = locala.DAr.getCountDownVM();
        if ((locald != null) && (locald != paramd)) {
          a.a(locald);
        }
        paramd.a(locala.DAr);
        paramd.eYr();
      }
      this.DAp = paramd;
      AppMethodBeat.o(202404);
      return;
    }
    catch (Throwable paramd)
    {
      AppMethodBeat.o(202404);
    }
  }
  
  public d getCountDownVM()
  {
    return this.DAp;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(202405);
    super.onDetachedFromWindow();
    try
    {
      if (this.DAq != null) {
        a.a(this.DAp);
      }
      AppMethodBeat.o(202405);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202405);
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(202401);
    super.onFinishInflate();
    try
    {
      this.DAq = new a(this);
      this.DAw = findViewById(2131296504);
      this.DAx = ((TextView)findViewById(2131296505));
      this.DAy = ((TextView)findViewById(2131307987));
      AppMethodBeat.o(202401);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202401);
    }
  }
  
  public void setPromotionalPrice(String paramString)
  {
    AppMethodBeat.i(202402);
    if ((this.DAx != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.DAx.setText(paramString);
      m.u(this.DAx);
    }
    AppMethodBeat.o(202402);
  }
  
  public void setRightTitle(String paramString)
  {
    AppMethodBeat.i(202403);
    if (this.DAy != null) {
      this.DAy.setText(paramString);
    }
    AppMethodBeat.o(202403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.countdown.PromotionBarLayout
 * JD-Core Version:    0.7.0.1
 */