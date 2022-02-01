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
  av yRo;
  private View ySg;
  private a ySh;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.ySg = this.contentView.findViewById(2131300326);
    AppMethodBeat.o(126476);
  }
  
  public final void bGT()
  {
    AppMethodBeat.i(126481);
    if (this.yRo != null) {
      this.yRo.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public final boolean bcB()
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
  
  public final void bcH()
  {
    AppMethodBeat.i(126482);
    if (this.yRo != null)
    {
      this.yRo.stopTimer();
      this.yRo.av(2000L, 2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final void bdT()
  {
    AppMethodBeat.i(126487);
    super.bdT();
    if (this.ySh != null) {
      this.ySh.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void dPU()
  {
    AppMethodBeat.i(126484);
    this.kth.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void dPV()
  {
    AppMethodBeat.i(126485);
    this.kth.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.ktg.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495791;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(202285);
    setVisibility(8);
    AppMethodBeat.o(202285);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.ySg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.ySh = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.ySh != null)
      {
        this.ySh.dPT();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.ySh != null)) {
      this.ySh.dPS();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    dPV();
    if (this.yRo == null) {
      this.yRo = new av(new av.a()
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
    this.yRo.stopTimer();
    this.yRo.av(2000L, 2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void dPS();
    
    public abstract void dPT();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */