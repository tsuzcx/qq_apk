package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private TextView LPk;
  private com.tencent.mm.aw.f LPl;
  private IListener rDF;
  private View vdX;
  private View vdY;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    this.LPl = null;
    if (this.view != null)
    {
      this.LPk = ((TextView)this.view.findViewById(a.e.music_banner_text_view));
      this.vdX = this.view.findViewById(a.e.music_banner_view);
      this.vdY = this.view.findViewById(a.e.banner_root);
      this.LPk.setTextSize(0, com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.c.HintTextSize));
      this.view.setOnClickListener(new a.1(this));
    }
    this.rDF = new MusicBanner.2(this, com.tencent.mm.app.f.hfK);
    this.rDF.alive();
    AppMethodBeat.o(63196);
  }
  
  private void aPk(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.LPk != null) {
      this.LPk.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean goN()
  {
    int i = 8;
    AppMethodBeat.i(63201);
    com.tencent.mm.aw.f localf;
    if ((this.isFirst) && (this.nzL))
    {
      this.vdY.setBackgroundResource(a.d.tips_bar_white_selector);
      this.vdX.setBackground(null);
      this.LPk.setBackground(null);
      if (!com.tencent.mm.aw.a.bLk()) {
        break label260;
      }
      localf = com.tencent.mm.aw.a.bLn();
      this.LPl = localf;
      aPk(MMApplicationContext.getContext().getString(a.h.music_detail_playing) + MMApplicationContext.getContext().getString(a.h.music_detail_split) + localf.oOx);
      if (!localf.oOR) {
        break label248;
      }
    }
    for (;;)
    {
      setVisibility(i);
      this.LPl = null;
      if (localf.oOR) {
        break label253;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.vdY.setBackgroundResource(a.d.list_item_top_selector);
        this.vdX.setBackgroundResource(a.d.list_item_top_normal);
        this.LPk.setBackgroundResource(a.d.list_item_normal);
        break;
      }
      if (this.nzL)
      {
        this.vdY.setBackgroundResource(a.d.list_item_top_selector);
        this.vdX.setBackgroundResource(a.d.list_item_normal);
        this.LPk.setBackground(null);
        break;
      }
      this.vdY.setBackgroundResource(a.d.list_item_top_selector);
      this.vdX.setBackground(null);
      this.LPk.setBackgroundResource(a.d.list_item_normal);
      break;
      label248:
      i = 0;
    }
    label253:
    AppMethodBeat.o(63201);
    return false;
    label260:
    if (com.tencent.mm.aw.a.bLl())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(63198);
    boolean bool = goN();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    this.rDF.dead();
    AppMethodBeat.o(63199);
  }
  
  public final int getLayoutId()
  {
    return a.g.music_banner_view;
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
      View localView = this.view.findViewById(a.e.music_banner_view);
      if (paramInt == 0)
      {
        if (com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          localView.setVisibility(8);
          if (com.tencent.mm.aw.a.bLk())
          {
            Log.i("MicroMsg.MusicBanner", "resume music to float ball");
            com.tencent.mm.plugin.music.model.b.B(this.LPl);
            AppMethodBeat.o(63197);
          }
        }
        else
        {
          Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return false");
        }
      }
      else {
        localView.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(63197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */