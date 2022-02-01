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
  private c kwD;
  private View nAt;
  private View nAu;
  private TextView wmX;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    if (this.view != null)
    {
      this.wmX = ((TextView)this.view.findViewById(2131302598));
      this.nAt = this.view.findViewById(2131302599);
      this.nAu = this.view.findViewById(2131297183);
      this.wmX.setTextSize(0, com.tencent.mm.cc.a.ax(aj.getContext(), 2131165466));
      this.view.setOnClickListener(new a.1(this));
    }
    this.kwD = new a.2(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.kwD);
    AppMethodBeat.o(63196);
  }
  
  private void asN(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.wmX != null) {
      this.wmX.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean dtI()
  {
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.hjE))
    {
      this.nAu.setBackgroundResource(2131234377);
      this.nAt.setBackground(null);
      this.wmX.setBackground(null);
      if (!com.tencent.mm.az.a.aJG()) {
        break label240;
      }
      localf = com.tencent.mm.az.a.aJJ();
      asN(aj.getContext().getString(2131761464) + aj.getContext().getString(2131761465) + localf.ihi);
      if (!localf.ihC) {
        break label228;
      }
    }
    label228:
    for (int i = 8;; i = 0)
    {
      setVisibility(i);
      if (localf.ihC) {
        break label233;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackgroundResource(2131232870);
        this.wmX.setBackgroundResource(2131232867);
        break;
      }
      if (this.hjE)
      {
        this.nAu.setBackgroundResource(2131232872);
        this.nAt.setBackgroundResource(2131232867);
        this.wmX.setBackground(null);
        break;
      }
      this.nAu.setBackgroundResource(2131232872);
      this.nAt.setBackground(null);
      this.wmX.setBackgroundResource(2131232867);
      break;
    }
    label233:
    AppMethodBeat.o(63201);
    return false;
    label240:
    if (com.tencent.mm.az.a.aJH())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(63198);
    boolean bool = dtI();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
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
        if (com.tencent.mm.compatible.d.b.ca(aj.getContext()))
        {
          ad.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          ((View)localObject).setVisibility(8);
          if (com.tencent.mm.az.a.aJG())
          {
            ad.i("MicroMsg.MusicBanner", "resume music to float ball");
            localObject = a.a.wkG;
            if (!((com.tencent.mm.plugin.music.model.a)localObject).bKz())
            {
              ((com.tencent.mm.plugin.music.model.a)localObject).iW(true);
              f localf = com.tencent.mm.az.a.aJJ();
              ((com.tencent.mm.plugin.music.model.a)localObject).Wm(localf.ihi);
              ((com.tencent.mm.plugin.music.model.a)localObject).Wn(localf.ihj);
              ((com.tencent.mm.plugin.music.model.a)localObject).eA("song_id", localf.ihg);
              ((com.tencent.mm.plugin.music.model.a)localObject).eA("db_music_id", com.tencent.mm.plugin.music.h.b.O(localf));
              ((com.tencent.mm.plugin.music.model.a)localObject).xY(d.eH(((com.tencent.mm.plugin.music.model.a)localObject).nGj.state, 2));
              ((com.tencent.mm.plugin.music.model.a)localObject).bKG().nGb = localf.ihe;
              ((com.tencent.mm.plugin.ball.service.a)localObject).bKC();
              ((com.tencent.mm.plugin.music.model.a)localObject).x(localf);
              ((com.tencent.mm.plugin.music.model.a)localObject).bKB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */