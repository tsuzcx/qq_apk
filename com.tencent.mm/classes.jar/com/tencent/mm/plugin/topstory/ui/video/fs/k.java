package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.f;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends e
{
  public TextView IXv;
  public ImageView TLV;
  public View TNZ;
  public View TOS;
  public View TOT;
  public View TOU;
  public View TOa;
  public ImageView TOb;
  public TextView TOc;
  public View TOo;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  public final i.e c(foh paramfoh)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()) - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramfoh.thumbWidth / paramfoh.thumbHeight;
    Log.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramfoh = i.e.XYM;
      AppMethodBeat.o(126401);
      return paramfoh;
    }
    paramfoh = i.e.XYN;
    AppMethodBeat.o(126401);
    return paramfoh;
  }
  
  protected final void cuW()
  {
    AppMethodBeat.i(126404);
    this.TNK = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final int getLayoutId()
  {
    return c.e.top_story_fs_v_video_container;
  }
  
  protected final void hOJ()
  {
    AppMethodBeat.i(126403);
    if ((this.TIW.abOE & 0x80) > 0)
    {
      this.TOa.setVisibility(0);
      if (this.TIW.abOJ)
      {
        this.TOb.setImageResource(c.f.top_story_wow_selected);
        this.TOc.setTextColor(getResources().getColor(c.a.top_story_wow_like));
      }
      for (;;)
      {
        this.TOc.setText(d.aoN(this.TIW.abON));
        AppMethodBeat.o(126403);
        return;
        this.TOb.setImageResource(c.f.top_story_wow_unselected);
        this.TOc.setTextColor(getResources().getColor(c.a.white_text_color));
      }
    }
    this.TOa.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean hOK()
  {
    return true;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126400);
    super.init();
    this.TNZ = findViewById(c.d.share_iv);
    this.TOS = findViewById(c.d.more_iv);
    this.TOT = findViewById(c.d.more_divider);
    this.TOa = findViewById(c.d.wow_iv);
    this.TOb = ((ImageView)findViewById(c.d.wow_icon_view));
    this.TOc = ((TextView)findViewById(c.d.wow_icon_text));
    this.TOU = findViewById(c.d.source_layout);
    this.TLV = ((ImageView)findViewById(c.d.source_iv));
    this.IXv = ((TextView)findViewById(c.d.source_tv));
    this.TOo = findViewById(c.d.source_arrow);
    this.TOS.setOnClickListener(this.TNL);
    this.TOa.setOnClickListener(this.TNN);
    this.TOU.setOnClickListener(this.TNP);
    this.TNZ.setOnClickListener(this.TNM);
    AppMethodBeat.o(126400);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126402);
    super.updateView();
    i.e locale = c(this.TIW);
    ViewGroup.LayoutParams localLayoutParams = this.coverIv.getLayoutParams();
    if (locale == i.e.XYM)
    {
      localLayoutParams.width = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.TIW.thumbWidth / this.TIW.thumbHeight)));
      this.coverIv.setLayoutParams(localLayoutParams);
      if ((this.TOo != null) && (this.IXv != null) && (this.TLV != null))
      {
        this.TOo.setVisibility(8);
        this.IXv.setVisibility(8);
        this.TLV.setVisibility(8);
        if (!Util.isNullOrNil(this.TIW.source))
        {
          this.IXv.setText(this.TIW.source);
          this.IXv.setVisibility(0);
          if (n.i(this.TIW)) {
            this.TOo.setVisibility(0);
          }
          if (Util.isNullOrNil(this.TIW.aaXP)) {
            break label274;
          }
          r.bKe().a(this.TIW.aaXP, this.TLV, d.TJj);
          label214:
          this.TLV.setVisibility(0);
        }
      }
      if (!this.TLn.hNF()) {
        break label287;
      }
      this.TOT.setVisibility(0);
      this.TOS.setVisibility(0);
    }
    for (;;)
    {
      hOJ();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label274:
      this.TLV.setImageResource(c.c.default_avatar);
      break label214;
      label287:
      this.TOT.setVisibility(8);
      this.TOS.setVisibility(8);
    }
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void aoW(int paramInt) {}
    
    public final void cvj() {}
    
    public final int dz(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */