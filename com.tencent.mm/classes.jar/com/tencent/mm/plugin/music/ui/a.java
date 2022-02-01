package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private TextView FUk;
  private f FUl;
  private IListener ozM;
  private View rSI;
  private View rSJ;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63196);
    this.FUl = null;
    if (this.view != null)
    {
      this.FUk = ((TextView)this.view.findViewById(a.e.music_banner_text_view));
      this.rSI = this.view.findViewById(a.e.music_banner_view);
      this.rSJ = this.view.findViewById(a.e.banner_root);
      this.FUk.setTextSize(0, com.tencent.mm.ci.a.aY(MMApplicationContext.getContext(), a.c.HintTextSize));
      this.view.setOnClickListener(new a.1(this));
    }
    this.ozM = new a.2(this);
    EventCenter.instance.addListener(this.ozM);
    AppMethodBeat.o(63196);
  }
  
  private void aSq(String paramString)
  {
    AppMethodBeat.i(63200);
    if (this.FUk != null) {
      this.FUk.setText(paramString);
    }
    AppMethodBeat.o(63200);
  }
  
  private boolean ffz()
  {
    int i = 8;
    AppMethodBeat.i(63201);
    f localf;
    if ((this.isFirst) && (this.kUc))
    {
      this.rSJ.setBackgroundResource(a.d.tips_bar_white_selector);
      this.rSI.setBackground(null);
      this.FUk.setBackground(null);
      if (!com.tencent.mm.bb.a.bnx()) {
        break label260;
      }
      localf = com.tencent.mm.bb.a.bnA();
      this.FUl = localf;
      aSq(MMApplicationContext.getContext().getString(a.h.music_detail_playing) + MMApplicationContext.getContext().getString(a.h.music_detail_split) + localf.lVv);
      if (!localf.lVP) {
        break label248;
      }
    }
    for (;;)
    {
      setVisibility(i);
      this.FUl = null;
      if (localf.lVP) {
        break label253;
      }
      AppMethodBeat.o(63201);
      return true;
      if (this.isFirst)
      {
        this.rSJ.setBackgroundResource(a.d.list_item_top_selector);
        this.rSI.setBackgroundResource(a.d.list_item_top_normal);
        this.FUk.setBackgroundResource(a.d.list_item_normal);
        break;
      }
      if (this.kUc)
      {
        this.rSJ.setBackgroundResource(a.d.list_item_top_selector);
        this.rSI.setBackgroundResource(a.d.list_item_normal);
        this.FUk.setBackground(null);
        break;
      }
      this.rSJ.setBackgroundResource(a.d.list_item_top_selector);
      this.rSI.setBackground(null);
      this.FUk.setBackgroundResource(a.d.list_item_normal);
      break;
      label248:
      i = 0;
    }
    label253:
    AppMethodBeat.o(63201);
    return false;
    label260:
    if (com.tencent.mm.bb.a.bny())
    {
      setVisibility(0);
      AppMethodBeat.o(63201);
      return true;
    }
    setVisibility(8);
    AppMethodBeat.o(63201);
    return false;
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(63198);
    boolean bool = ffz();
    AppMethodBeat.o(63198);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63199);
    EventCenter.instance.removeListener(this.ozM);
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
        if (com.tencent.mm.compatible.e.b.ct(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.MusicBanner", "isFloatWindowOpAllowed return true");
          localView.setVisibility(8);
          if (com.tencent.mm.bb.a.bnx())
          {
            Log.i("MicroMsg.MusicBanner", "resume music to float ball");
            com.tencent.mm.plugin.music.model.b.x(this.FUl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */