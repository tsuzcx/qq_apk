package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  aw BOn;
  private View BPf;
  private a BPg;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.BPf = this.contentView.findViewById(2131300326);
    AppMethodBeat.o(126476);
  }
  
  public final void bTU()
  {
    AppMethodBeat.i(126481);
    if (this.BOn != null) {
      this.BOn.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(126478);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(126478);
      return true;
    }
    AppMethodBeat.o(126478);
    return false;
  }
  
  public final void bnY()
  {
    AppMethodBeat.i(126482);
    if (this.BOn != null)
    {
      this.BOn.stopTimer();
      this.BOn.ay(2000L, 2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(126487);
    super.bpi();
    if (this.BPg != null) {
      this.BPg.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void eur()
  {
    AppMethodBeat.i(126484);
    this.lvU.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void eus()
  {
    AppMethodBeat.i(126485);
    this.lvU.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.lvT.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495791;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(224390);
    setVisibility(8);
    AppMethodBeat.o(224390);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.BPf.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.BPg = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.BPg != null)
      {
        this.BPg.euq();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.BPg != null)) {
      this.BPg.eup();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    eus();
    if (this.BOn == null) {
      this.BOn = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(126475);
          g.this.setVisibility(8);
          g.a(g.this).stopTimer();
          AppMethodBeat.o(126475);
          return false;
        }
      }, false);
    }
    this.BOn.stopTimer();
    this.BOn.ay(2000L, 2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void eup();
    
    public abstract void euq();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */