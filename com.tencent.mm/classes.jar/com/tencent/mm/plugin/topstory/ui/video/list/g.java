package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  MTimerHandler NbG;
  private View Ncy;
  private a Ncz;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.Ncy = this.contentView.findViewById(c.d.full_screen_iv);
    AppMethodBeat.o(126476);
  }
  
  public final boolean bVd()
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
  
  public final void bVi()
  {
    AppMethodBeat.i(126482);
    if (this.NbG != null)
    {
      this.NbG.stopTimer();
      this.NbG.startTimer(2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final void bWO()
  {
    AppMethodBeat.i(126487);
    super.bWO();
    if (this.Ncz != null) {
      this.Ncz.kC(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void cEO()
  {
    AppMethodBeat.i(126481);
    if (this.NbG != null) {
      this.NbG.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.pCb.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public int getLayoutId()
  {
    return c.e.top_story_list_video_control_bar;
  }
  
  public final void grN()
  {
    AppMethodBeat.i(126484);
    this.pCc.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void grO()
  {
    AppMethodBeat.i(126485);
    this.pCc.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(292768);
    setVisibility(8);
    AppMethodBeat.o(292768);
  }
  
  public void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.Ncy.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.Ncz = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.Ncz != null)
      {
        this.Ncz.grM();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.Ncz != null)) {
      this.Ncz.grL();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    grO();
    if (this.NbG == null) {
      this.NbG = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.NbG.stopTimer();
    this.NbG.startTimer(2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void grL();
    
    public abstract void grM();
    
    public abstract void kC(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */