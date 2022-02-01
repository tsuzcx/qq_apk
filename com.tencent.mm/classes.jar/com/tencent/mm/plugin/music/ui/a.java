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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private c kzS;
  private View nFO;
  private View nFP;
  private TextView wCG;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    if (this.view != null)
    {
      this.wCG = ((TextView)this.view.findViewById(2131302598));
      this.nFO = this.view.findViewById(2131302599);
      this.nFP = this.view.findViewById(2131297183);
      this.wCG.setTextSize(0, com.tencent.mm.cb.a.ax(ak.getContext(), 2131165466));
      this.view.setOnClickListener(new a.1(this));
    }
    this.kzS = new a.2(this);
    com.tencent.mm.sdk.b.a.IvT.c(this.kzS);
    AppMethodBeat.o(63196);
  }
  
  private void aua(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.wCG != null) {
      this.wCG.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean dwX()
  {
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.hms))
    {
      this.nFP.setBackgroundResource(2131234377);
      this.nFO.setBackground(null);
      this.wCG.setBackground(null);
      if (!com.tencent.mm.ay.a.aJZ()) {
        break label240;
      }
      localf = com.tencent.mm.ay.a.aKc();
      aua(ak.getContext().getString(2131761464) + ak.getContext().getString(2131761465) + localf.ikb);
      if (!localf.ikv) {
        break label228;
      }
    }
    label228:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      if (localf.ikv) {
        break label233;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackgroundResource(2131232870);
        this.wCG.setBackgroundResource(2131232867);
        break;
      }
      if (this.hms)
      {
        this.nFP.setBackgroundResource(2131232872);
        this.nFO.setBackgroundResource(2131232867);
        this.wCG.setBackground(null);
        break;
      }
      this.nFP.setBackgroundResource(2131232872);
      this.nFO.setBackground(null);
      this.wCG.setBackgroundResource(2131232867);
      break;
    }
    label233:
    AppMethodBeat.o(63201);
    return false;
    label240:
    if (com.tencent.mm.ay.a.aKa())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(63198);
    boolean bool = dwX();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
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
        if (com.tencent.mm.compatible.d.b.cc(ak.getContext()))
        {
          ae.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          ((View)localObject).setVisibility(8);
          if (com.tencent.mm.ay.a.aJZ())
          {
            ae.i("MicroMsg.MusicBanner", "resume music to float ball");
            localObject = a.a.wAp;
            if (!((com.tencent.mm.plugin.music.model.a)localObject).bLw())
            {
              ((com.tencent.mm.plugin.music.model.a)localObject).iV(true);
              f localf = com.tencent.mm.ay.a.aKc();
              ((com.tencent.mm.plugin.music.model.a)localObject).WY(localf.ikb);
              ((com.tencent.mm.plugin.music.model.a)localObject).WZ(localf.ikc);
              ((com.tencent.mm.plugin.music.model.a)localObject).eD("song_id", localf.ijZ);
              ((com.tencent.mm.plugin.music.model.a)localObject).eD("db_music_id", com.tencent.mm.plugin.music.h.b.O(localf));
              ((com.tencent.mm.plugin.music.model.a)localObject).yc(d.eI(((com.tencent.mm.plugin.music.model.a)localObject).nLK.state, 2));
              ((com.tencent.mm.plugin.music.model.a)localObject).bLD().nLB = localf.ijX;
              ((com.tencent.mm.plugin.ball.service.a)localObject).bLz();
              ((com.tencent.mm.plugin.music.model.a)localObject).x(localf);
              ((com.tencent.mm.plugin.music.model.a)localObject).bLy();
            }
            AppMethodBeat.o(63197);
          }
        }
        else
        {
          ae.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
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