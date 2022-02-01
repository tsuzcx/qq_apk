package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class k
  extends e
{
  public ImageView AcL;
  public View AeN;
  public View AeO;
  public ImageView AeP;
  public TextView AeQ;
  public View AfF;
  public View AfG;
  public View AfH;
  public View Afc;
  public TextView tvx;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void biY()
  {
    AppMethodBeat.i(126404);
    this.Aex = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final h.e c(dio paramdio)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cc.a.ig(ai.getContext());
    float f2 = com.tencent.mm.cc.a.ih(ai.getContext()) - com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramdio.thumbWidth / paramdio.thumbHeight;
    ac.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramdio = h.e.DnJ;
      AppMethodBeat.o(126401);
      return paramdio;
    }
    paramdio = h.e.DnK;
    AppMethodBeat.o(126401);
    return paramdio;
  }
  
  public final void cL()
  {
    AppMethodBeat.i(126402);
    super.cL();
    h.e locale = c(this.zZN);
    ViewGroup.LayoutParams localLayoutParams = this.opg.getLayoutParams();
    if (locale == h.e.DnJ)
    {
      localLayoutParams.width = com.tencent.mm.cc.a.ig(ai.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.zZN.thumbWidth / this.zZN.thumbHeight)));
      this.opg.setLayoutParams(localLayoutParams);
      if ((this.Afc != null) && (this.tvx != null) && (this.AcL != null))
      {
        this.Afc.setVisibility(8);
        this.tvx.setVisibility(8);
        this.AcL.setVisibility(8);
        if (!bs.isNullOrNil(this.zZN.source))
        {
          this.tvx.setText(this.zZN.source);
          this.tvx.setVisibility(0);
          if (!bs.isNullOrNil(this.zZN.kRU)) {
            this.Afc.setVisibility(0);
          }
          if (bs.isNullOrNil(this.zZN.FRT)) {
            break label275;
          }
          o.aFB().a(this.zZN.FRT, this.AcL, d.Aae);
          label216:
          this.AcL.setVisibility(0);
        }
      }
      if (!this.Acd.edo()) {
        break label287;
      }
      this.AfG.setVisibility(0);
      this.AfF.setVisibility(0);
    }
    for (;;)
    {
      eep();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label275:
      this.AcL.setImageResource(2131231875);
      break label216;
      label287:
      this.AfG.setVisibility(8);
      this.AfF.setVisibility(8);
    }
  }
  
  protected final void eep()
  {
    AppMethodBeat.i(126403);
    if ((this.zZN.FRX & 0x80) > 0)
    {
      this.AeO.setVisibility(0);
      if (this.zZN.FSc)
      {
        this.AeP.setImageResource(2131691329);
        this.AeQ.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.AeQ.setText(d.Rk(this.zZN.FSh));
        AppMethodBeat.o(126403);
        return;
        this.AeP.setImageResource(2131691330);
        this.AeQ.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.AeO.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean eeq()
  {
    return true;
  }
  
  public final int getLayoutId()
  {
    return 2131495775;
  }
  
  public final void init()
  {
    AppMethodBeat.i(126400);
    super.init();
    this.AeN = findViewById(2131304744);
    this.AfF = findViewById(2131302474);
    this.AfG = findViewById(2131302464);
    this.AeO = findViewById(2131307019);
    this.AeP = ((ImageView)findViewById(2131307018));
    this.AeQ = ((TextView)findViewById(2131307017));
    this.AfH = findViewById(2131305131);
    this.AcL = ((ImageView)findViewById(2131305130));
    this.tvx = ((TextView)findViewById(2131305134));
    this.Afc = findViewById(2131305129);
    this.AfF.setOnClickListener(this.Aez);
    this.AeO.setOnClickListener(this.AeB);
    this.AfH.setOnClickListener(this.AeD);
    this.AeN.setOnClickListener(this.AeA);
    AppMethodBeat.o(126400);
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void Rq(int paramInt) {}
    
    public final int bG(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
    
    public final void bjl() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */