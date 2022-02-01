package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  private View AfV;
  private a AfW;
  au Afd;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126476);
    this.AfV = this.contentView.findViewById(2131300326);
    AppMethodBeat.o(126476);
  }
  
  public final void bOg()
  {
    AppMethodBeat.i(126481);
    if (this.Afd != null) {
      this.Afd.stopTimer();
    }
    AppMethodBeat.o(126481);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(126482);
    if (this.Afd != null)
    {
      this.Afd.stopTimer();
      this.Afd.au(2000L, 2000L);
    }
    AppMethodBeat.o(126482);
  }
  
  public final boolean bjw()
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
  
  public final void bkN()
  {
    AppMethodBeat.i(126487);
    super.bkN();
    if (this.AfW != null) {
      this.AfW.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126487);
  }
  
  public final void eet()
  {
    AppMethodBeat.i(126484);
    this.kUw.setVisibility(8);
    AppMethodBeat.o(126484);
  }
  
  public final void eeu()
  {
    AppMethodBeat.i(126485);
    this.kUw.setVisibility(0);
    AppMethodBeat.o(126485);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(126483);
    int i = this.kUv.getWidth();
    AppMethodBeat.o(126483);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495791;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(210288);
    setVisibility(8);
    AppMethodBeat.o(210288);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126477);
    this.AfV.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126477);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.AfW = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126486);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.AfW != null)
      {
        this.AfW.ees();
        AppMethodBeat.o(126486);
      }
    }
    else if ((paramInt == 0) && (this.AfW != null)) {
      this.AfW.eer();
    }
    AppMethodBeat.o(126486);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126480);
    setVisibility(0);
    eeu();
    if (this.Afd == null) {
      this.Afd = new au(new au.a()
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
    this.Afd.stopTimer();
    this.Afd.au(2000L, 2000L);
    AppMethodBeat.o(126480);
  }
  
  public static abstract interface a
  {
    public abstract void eer();
    
    public abstract void ees();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */