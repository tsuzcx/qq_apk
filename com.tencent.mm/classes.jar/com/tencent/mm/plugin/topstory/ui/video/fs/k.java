package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.esy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends e
{
  public TextView Ddd;
  public ImageView MZm;
  public View NbF;
  public View Nbq;
  public View Nbr;
  public ImageView Nbs;
  public TextView Nbt;
  public View Nci;
  public View Ncj;
  public View Nck;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void bUH()
  {
    AppMethodBeat.i(126404);
    this.Nbb = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final i.e c(esy paramesy)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()) - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramesy.thumbWidth / paramesy.thumbHeight;
    Log.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramesy = i.e.RcG;
      AppMethodBeat.o(126401);
      return paramesy;
    }
    paramesy = i.e.RcH;
    AppMethodBeat.o(126401);
    return paramesy;
  }
  
  public final int getLayoutId()
  {
    return c.e.top_story_fs_v_video_container;
  }
  
  protected final void grJ()
  {
    AppMethodBeat.i(126403);
    if ((this.MWs.Uvd & 0x80) > 0)
    {
      this.Nbr.setVisibility(0);
      if (this.MWs.Uvi)
      {
        this.Nbs.setImageResource(c.f.top_story_wow_selected);
        this.Nbt.setTextColor(getResources().getColor(c.a.top_story_wow_like));
      }
      for (;;)
      {
        this.Nbt.setText(d.ajw(this.MWs.Uvm));
        AppMethodBeat.o(126403);
        return;
        this.Nbs.setImageResource(c.f.top_story_wow_unselected);
        this.Nbt.setTextColor(getResources().getColor(c.a.white_text_color));
      }
    }
    this.Nbr.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean grK()
  {
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126400);
    super.init();
    this.Nbq = findViewById(c.d.share_iv);
    this.Nci = findViewById(c.d.more_iv);
    this.Ncj = findViewById(c.d.more_divider);
    this.Nbr = findViewById(c.d.wow_iv);
    this.Nbs = ((ImageView)findViewById(c.d.wow_icon_view));
    this.Nbt = ((TextView)findViewById(c.d.wow_icon_text));
    this.Nck = findViewById(c.d.source_layout);
    this.MZm = ((ImageView)findViewById(c.d.source_iv));
    this.Ddd = ((TextView)findViewById(c.d.source_tv));
    this.NbF = findViewById(c.d.source_arrow);
    this.Nci.setOnClickListener(this.Nbc);
    this.Nbr.setOnClickListener(this.Nbe);
    this.Nck.setOnClickListener(this.Nbg);
    this.Nbq.setOnClickListener(this.Nbd);
    AppMethodBeat.o(126400);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126402);
    super.updateView();
    i.e locale = c(this.MWs);
    ViewGroup.LayoutParams localLayoutParams = this.sDJ.getLayoutParams();
    if (locale == i.e.RcG)
    {
      localLayoutParams.width = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.MWs.thumbWidth / this.MWs.thumbHeight)));
      this.sDJ.setLayoutParams(localLayoutParams);
      if ((this.NbF != null) && (this.Ddd != null) && (this.MZm != null))
      {
        this.NbF.setVisibility(8);
        this.Ddd.setVisibility(8);
        this.MZm.setVisibility(8);
        if (!Util.isNullOrNil(this.MWs.source))
        {
          this.Ddd.setText(this.MWs.source);
          this.Ddd.setVisibility(0);
          if (n.i(this.MWs)) {
            this.NbF.setVisibility(0);
          }
          if (Util.isNullOrNil(this.MWs.TIg)) {
            break label274;
          }
          q.bml().a(this.MWs.TIg, this.MZm, d.MWF);
          label214:
          this.MZm.setVisibility(0);
        }
      }
      if (!this.MYE.gqG()) {
        break label287;
      }
      this.Ncj.setVisibility(0);
      this.Nci.setVisibility(0);
    }
    for (;;)
    {
      grJ();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label274:
      this.MZm.setImageResource(c.c.default_avatar);
      break label214;
      label287:
      this.Ncj.setVisibility(8);
      this.Nci.setVisibility(8);
    }
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void ajD(int paramInt) {}
    
    public final void bUU() {}
    
    public final int cn(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */