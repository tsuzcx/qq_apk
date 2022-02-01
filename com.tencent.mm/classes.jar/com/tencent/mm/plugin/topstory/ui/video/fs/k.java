package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class k
  extends e
{
  public ImageView GmA;
  public View GoE;
  public View GoF;
  public ImageView GoG;
  public TextView GoH;
  public View GoT;
  public View Gpw;
  public View Gpx;
  public View Gpy;
  public TextView xYx;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void bIY()
  {
    AppMethodBeat.i(126404);
    this.Goo = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final i.e c(eiw parameiw)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
    float f2 = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = parameiw.thumbWidth / parameiw.thumbHeight;
    Log.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      parameiw = i.e.Kcb;
      AppMethodBeat.o(126401);
      return parameiw;
    }
    parameiw = i.e.Kcc;
    AppMethodBeat.o(126401);
    return parameiw;
  }
  
  protected final void fzI()
  {
    AppMethodBeat.i(126403);
    if ((this.GjH.Nix & 0x80) > 0)
    {
      this.GoF.setVisibility(0);
      if (this.GjH.NiC)
      {
        this.GoG.setImageResource(2131691661);
        this.GoH.setTextColor(getResources().getColor(2131101284));
      }
      for (;;)
      {
        this.GoH.setText(c.abR(this.GjH.NiH));
        AppMethodBeat.o(126403);
        return;
        this.GoG.setImageResource(2131691662);
        this.GoH.setTextColor(getResources().getColor(2131101427));
      }
    }
    this.GoF.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean fzJ()
  {
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2131496733;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126400);
    super.init();
    this.GoE = findViewById(2131307810);
    this.Gpw = findViewById(2131304887);
    this.Gpx = findViewById(2131304874);
    this.GoF = findViewById(2131310543);
    this.GoG = ((ImageView)findViewById(2131310542));
    this.GoH = ((TextView)findViewById(2131310541));
    this.Gpy = findViewById(2131308309);
    this.GmA = ((ImageView)findViewById(2131308308));
    this.xYx = ((TextView)findViewById(2131308313));
    this.GoT = findViewById(2131308307);
    this.Gpw.setOnClickListener(this.Goq);
    this.GoF.setOnClickListener(this.Gos);
    this.Gpy.setOnClickListener(this.Gou);
    this.GoE.setOnClickListener(this.Gor);
    AppMethodBeat.o(126400);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126402);
    super.updateView();
    i.e locale = c(this.GjH);
    ViewGroup.LayoutParams localLayoutParams = this.puw.getLayoutParams();
    if (locale == i.e.Kcb)
    {
      localLayoutParams.width = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.GjH.thumbWidth / this.GjH.thumbHeight)));
      this.puw.setLayoutParams(localLayoutParams);
      if ((this.GoT != null) && (this.xYx != null) && (this.GmA != null))
      {
        this.GoT.setVisibility(8);
        this.xYx.setVisibility(8);
        this.GmA.setVisibility(8);
        if (!Util.isNullOrNil(this.GjH.source))
        {
          this.xYx.setText(this.GjH.source);
          this.xYx.setVisibility(0);
          if (n.i(this.GjH)) {
            this.GoT.setVisibility(0);
          }
          if (Util.isNullOrNil(this.GjH.MwR)) {
            break label272;
          }
          q.bcV().a(this.GjH.MwR, this.GmA, c.GjU);
          label213:
          this.GmA.setVisibility(0);
        }
      }
      if (!this.GlS.fyJ()) {
        break label285;
      }
      this.Gpx.setVisibility(0);
      this.Gpw.setVisibility(0);
    }
    for (;;)
    {
      fzI();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label272:
      this.GmA.setImageResource(2131231957);
      break label213;
      label285:
      this.Gpx.setVisibility(8);
      this.Gpw.setVisibility(8);
    }
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void abX(int paramInt) {}
    
    public final void bJl() {}
    
    public final int ce(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */