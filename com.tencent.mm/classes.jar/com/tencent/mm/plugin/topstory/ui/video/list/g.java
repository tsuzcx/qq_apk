package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  MTimerHandler GoU;
  private View GpM;
  private a GpN;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.GpM = this.contentView.findViewById(2131301833);
    AppMethodBeat.o(126476);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(126482);
    if (this.GoU != null)
    {
      this.GoU.stopTimer();
      this.GoU.startTimer(2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final boolean bJw()
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
  
  public final void bKO()
  {
    AppMethodBeat.i(126487);
    super.bKO();
    if (this.GpN != null) {
      this.GpN.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void crH()
  {
    AppMethodBeat.i(126481);
    if (this.GoU != null) {
      this.GoU.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public final void fzM()
  {
    AppMethodBeat.i(126484);
    this.mCP.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void fzN()
  {
    AppMethodBeat.i(126485);
    this.mCP.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.mCO.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131496749;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(258729);
    setVisibility(8);
    AppMethodBeat.o(258729);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.GpM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.GpN = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.GpN != null)
      {
        this.GpN.fzL();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.GpN != null)) {
      this.GpN.fzK();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    fzN();
    if (this.GoU == null) {
      this.GoU = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.GoU.stopTimer();
    this.GoU.startTimer(2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void fzK();
    
    public abstract void fzL();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */