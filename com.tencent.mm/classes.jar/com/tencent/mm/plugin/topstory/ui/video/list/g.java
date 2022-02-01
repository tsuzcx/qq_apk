package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  av BwP;
  private View BxH;
  private a BxI;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.BxH = this.contentView.findViewById(2131300326);
    AppMethodBeat.o(126476);
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(126481);
    if (this.BwP != null) {
      this.BwP.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public final boolean bni()
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
  
  public final void bno()
  {
    AppMethodBeat.i(126482);
    if (this.BwP != null)
    {
      this.BwP.stopTimer();
      this.BwP.az(2000L, 2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final void boy()
  {
    AppMethodBeat.i(126487);
    super.boy();
    if (this.BxI != null) {
      this.BxI.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void eqK()
  {
    AppMethodBeat.i(126484);
    this.lru.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void eqL()
  {
    AppMethodBeat.i(126485);
    this.lru.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.lrt.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495791;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(221368);
    setVisibility(8);
    AppMethodBeat.o(221368);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.BxH.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.BxI = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.BxI != null)
      {
        this.BxI.eqJ();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.BxI != null)) {
      this.BxI.eqI();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    eqL();
    if (this.BwP == null) {
      this.BwP = new av(new av.a()
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
    this.BwP.stopTimer();
    this.BwP.az(2000L, 2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void eqI();
    
    public abstract void eqJ();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */