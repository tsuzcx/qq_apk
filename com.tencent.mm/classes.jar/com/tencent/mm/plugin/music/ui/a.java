package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.music.model.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private c jBI;
  private View mxV;
  private View mxW;
  private TextView tYJ;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    if (this.view != null)
    {
      this.tYJ = ((TextView)this.view.findViewById(2131302598));
      this.mxV = this.view.findViewById(2131302599);
      this.mxW = this.view.findViewById(2131297183);
      this.tYJ.setTextSize(0, com.tencent.mm.cd.a.ao(aj.getContext(), 2131165466));
      this.view.setOnClickListener(new a.1(this));
    }
    this.jBI = new a.2(this);
    com.tencent.mm.sdk.b.a.ESL.c(this.jBI);
    AppMethodBeat.o(63196);
  }
  
  private void aiT(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.tYJ != null) {
      this.tYJ.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean cVO()
  {
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.gqE))
    {
      this.mxW.setBackgroundResource(2131234377);
      this.mxV.setBackground(null);
      this.tYJ.setBackground(null);
      if (!com.tencent.mm.az.a.azF()) {
        break label240;
      }
      localf = com.tencent.mm.az.a.azI();
      aiT(aj.getContext().getString(2131761464) + aj.getContext().getString(2131761465) + localf.hnr);
      if (!localf.hnL) {
        break label228;
      }
    }
    label228:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      if (localf.hnL) {
        break label233;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackgroundResource(2131232870);
        this.tYJ.setBackgroundResource(2131232867);
        break;
      }
      if (this.gqE)
      {
        this.mxW.setBackgroundResource(2131232872);
        this.mxV.setBackgroundResource(2131232867);
        this.tYJ.setBackground(null);
        break;
      }
      this.mxW.setBackgroundResource(2131232872);
      this.mxV.setBackground(null);
      this.tYJ.setBackgroundResource(2131232867);
      break;
    }
    label233:
    AppMethodBeat.o(63201);
    return false;
    label240:
    if (com.tencent.mm.az.a.azG())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(63198);
    boolean bool = cVO();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
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
        if (com.tencent.mm.compatible.d.b.bZ(aj.getContext()))
        {
          ad.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          ((View)localObject).setVisibility(8);
          if (com.tencent.mm.az.a.azF())
          {
            ad.i("MicroMsg.MusicBanner", "resume music to float ball");
            localObject = a.a.tWA;
            if (!((com.tencent.mm.plugin.music.model.a)localObject).bzs())
            {
              ((com.tencent.mm.plugin.music.model.a)localObject).in(true);
              f localf = com.tencent.mm.az.a.azI();
              ((com.tencent.mm.plugin.music.model.a)localObject).OE(localf.hnr);
              ((com.tencent.mm.plugin.music.model.a)localObject).OF(localf.hns);
              ((com.tencent.mm.plugin.music.model.a)localObject).ef("song_id", localf.hnp);
              ((com.tencent.mm.plugin.music.model.a)localObject).ef("db_music_id", com.tencent.mm.plugin.music.h.b.N(localf));
              ((com.tencent.mm.plugin.music.model.a)localObject).wB(d.eB(((com.tencent.mm.plugin.music.model.a)localObject).mDH.state, 2));
              ((com.tencent.mm.plugin.music.model.a)localObject).bzz().mDy = localf.hnn;
              ((com.tencent.mm.plugin.ball.service.a)localObject).bzv();
              ((com.tencent.mm.plugin.music.model.a)localObject).bzu();
            }
            AppMethodBeat.o(63197);
          }
        }
        else
        {
          ad.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
        }
      }
      else {
        ((View)localObject).setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(63197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */