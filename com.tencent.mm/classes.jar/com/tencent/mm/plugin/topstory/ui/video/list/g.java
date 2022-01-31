package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class g
  extends com.tencent.mm.plugin.topstory.ui.video.g
{
  ap tkH;
  private View tlt;
  private a tlu;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(2076);
    this.tlt = this.contentView.findViewById(2131828592);
    AppMethodBeat.o(2076);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(141953);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(141953);
      return true;
    }
    AppMethodBeat.o(141953);
    return false;
  }
  
  public final void aFn()
  {
    AppMethodBeat.i(2081);
    if (this.tkH != null)
    {
      this.tkH.stopTimer();
      this.tkH.ag(2000L, 2000L);
    }
    AppMethodBeat.o(2081);
  }
  
  public final void aFy()
  {
    AppMethodBeat.i(2086);
    super.aFy();
    if (this.tlu != null) {
      this.tlu.update(this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(2086);
  }
  
  public final void baj()
  {
    AppMethodBeat.i(2080);
    if (this.tkH != null) {
      this.tkH.stopTimer();
    }
    AppMethodBeat.o(2080);
  }
  
  public final void cKo()
  {
    AppMethodBeat.i(2083);
    this.qTF.setVisibility(8);
    AppMethodBeat.o(2083);
  }
  
  public final void cKp()
  {
    AppMethodBeat.i(2084);
    this.qTF.setVisibility(0);
    AppMethodBeat.o(2084);
  }
  
  public final int getBarPointWidth()
  {
    AppMethodBeat.i(2082);
    int i = this.qTE.getWidth();
    AppMethodBeat.o(2082);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2130971027;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(156797);
    setVisibility(8);
    AppMethodBeat.o(156797);
  }
  
  public final void setFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(2077);
    this.tlt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(2077);
  }
  
  public final void setOnUpdateProgressLenListener(a parama)
  {
    this.tlu = parama;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(2085);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.tlu != null)
      {
        this.tlu.cKn();
        AppMethodBeat.o(2085);
      }
    }
    else if ((paramInt == 0) && (this.tlu != null)) {
      this.tlu.cKm();
    }
    AppMethodBeat.o(2085);
  }
  
  public final void show()
  {
    AppMethodBeat.i(2079);
    setVisibility(0);
    cKp();
    if (this.tkH == null) {
      this.tkH = new ap(new g.1(this), false);
    }
    this.tkH.stopTimer();
    this.tkH.ag(2000L, 2000L);
    AppMethodBeat.o(2079);
  }
  
  public static abstract interface a
  {
    public abstract void cKm();
    
    public abstract void cKn();
    
    public abstract void update(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.g
 * JD-Core Version:    0.7.0.1
 */