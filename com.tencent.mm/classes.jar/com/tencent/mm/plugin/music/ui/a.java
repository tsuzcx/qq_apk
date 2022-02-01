package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private c kce;
  private View mZW;
  private View mZX;
  private TextView vhC;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    if (this.view != null)
    {
      this.vhC = ((TextView)this.view.findViewById(2131302598));
      this.mZW = this.view.findViewById(2131302599);
      this.mZX = this.view.findViewById(2131297183);
      this.vhC.setTextSize(0, com.tencent.mm.cc.a.au(ai.getContext(), 2131165466));
      this.view.setOnClickListener(new a.1(this));
    }
    this.kce = new a.2(this);
    com.tencent.mm.sdk.b.a.GpY.c(this.kce);
    AppMethodBeat.o(63196);
  }
  
  private void anO(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.vhC != null) {
      this.vhC.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean djw()
  {
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.gRm))
    {
      this.mZX.setBackgroundResource(2131234377);
      this.mZW.setBackground(null);
      this.vhC.setBackground(null);
      if (!com.tencent.mm.ay.a.aGv()) {
        break label240;
      }
      localf = com.tencent.mm.ay.a.aGy();
      anO(ai.getContext().getString(2131761464) + ai.getContext().getString(2131761465) + localf.hNU);
      if (!localf.hOo) {
        break label228;
      }
    }
    label228:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      if (localf.hOo) {
        break label233;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackgroundResource(2131232870);
        this.vhC.setBackgroundResource(2131232867);
        break;
      }
      if (this.gRm)
      {
        this.mZX.setBackgroundResource(2131232872);
        this.mZW.setBackgroundResource(2131232867);
        this.vhC.setBackground(null);
        break;
      }
      this.mZX.setBackgroundResource(2131232872);
      this.mZW.setBackground(null);
      this.vhC.setBackgroundResource(2131232867);
      break;
    }
    label233:
    AppMethodBeat.o(63201);
    return false;
    label240:
    if (com.tencent.mm.ay.a.aGw())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(63198);
    boolean bool = djw();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    AppMethodBeat.o(63199);
  }
  
  public final int getLayoutId()
  {
    return 2131494982;
  }
  
  public final int getOrder()
  {
    return 1;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(63197);
    if (this.view != null)
    {
      Object localObject = this.view.findViewById(2131302599);
      if (paramInt == 0)
      {
        if (com.tencent.mm.compatible.d.b.cc(ai.getContext()))
        {
          ac.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          ((View)localObject).setVisibility(8);
          if (com.tencent.mm.ay.a.aGv())
          {
            ac.i("MicroMsg.MusicBanner", "resume music to float ball");
            localObject = a.a.vfl;
            if (!((com.tencent.mm.plugin.music.model.a)localObject).bGo())
            {
              ((com.tencent.mm.plugin.music.model.a)localObject).iN(true);
              f localf = com.tencent.mm.ay.a.aGy();
              ((com.tencent.mm.plugin.music.model.a)localObject).SO(localf.hNU);
              ((com.tencent.mm.plugin.music.model.a)localObject).SP(localf.hNV);
              ((com.tencent.mm.plugin.music.model.a)localObject).er("song_id", localf.hNS);
              ((com.tencent.mm.plugin.music.model.a)localObject).er("db_music_id", com.tencent.mm.plugin.music.h.b.O(localf));
              ((com.tencent.mm.plugin.music.model.a)localObject).xs(d.eE(((com.tencent.mm.plugin.music.model.a)localObject).nfN.state, 2));
              ((com.tencent.mm.plugin.music.model.a)localObject).bGv().nfF = localf.hNQ;
              ((com.tencent.mm.plugin.ball.service.a)localObject).bGr();
              ((com.tencent.mm.plugin.music.model.a)localObject).x(localf);
              ((com.tencent.mm.plugin.music.model.a)localObject).bGq();
            }
            AppMethodBeat.o(63197);
          }
        }
        else
        {
          ac.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
        }
      }
      else {
        ((View)localObject).setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(63197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */