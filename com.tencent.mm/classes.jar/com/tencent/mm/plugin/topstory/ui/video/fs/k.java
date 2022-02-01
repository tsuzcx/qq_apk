package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class k
  extends e
{
  public ImageView BLU;
  public View BNX;
  public View BNY;
  public ImageView BNZ;
  public View BOP;
  public View BOQ;
  public View BOR;
  public TextView BOa;
  public View BOm;
  public TextView uGl;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void bnu()
  {
    AppMethodBeat.i(126404);
    this.BNH = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final i.e c(dpa paramdpa)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cb.a.iu(ak.getContext());
    float f2 = com.tencent.mm.cb.a.iv(ak.getContext()) - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramdpa.thumbWidth / paramdpa.thumbHeight;
    ae.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramdpa = i.e.Flj;
      AppMethodBeat.o(126401);
      return paramdpa;
    }
    paramdpa = i.e.Flk;
    AppMethodBeat.o(126401);
    return paramdpa;
  }
  
  protected final void eun()
  {
    AppMethodBeat.i(126403);
    if ((this.BIY.HWq & 0x80) > 0)
    {
      this.BNY.setVisibility(0);
      if (this.BIY.HWv)
      {
        this.BNZ.setImageResource(2131691329);
        this.BOa.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.BOa.setText(d.TB(this.BIY.HWA));
        AppMethodBeat.o(126403);
        return;
        this.BNZ.setImageResource(2131691330);
        this.BOa.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.BNY.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean euo()
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
    this.BNX = findViewById(2131304744);
    this.BOP = findViewById(2131302474);
    this.BOQ = findViewById(2131302464);
    this.BNY = findViewById(2131307019);
    this.BNZ = ((ImageView)findViewById(2131307018));
    this.BOa = ((TextView)findViewById(2131307017));
    this.BOR = findViewById(2131305131);
    this.BLU = ((ImageView)findViewById(2131305130));
    this.uGl = ((TextView)findViewById(2131305134));
    this.BOm = findViewById(2131305129);
    this.BOP.setOnClickListener(this.BNJ);
    this.BNY.setOnClickListener(this.BNL);
    this.BOR.setOnClickListener(this.BNN);
    this.BNX.setOnClickListener(this.BNK);
    AppMethodBeat.o(126400);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126402);
    super.updateView();
    i.e locale = c(this.BIY);
    ViewGroup.LayoutParams localLayoutParams = this.oZd.getLayoutParams();
    if (locale == i.e.Flj)
    {
      localLayoutParams.width = com.tencent.mm.cb.a.iu(ak.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.BIY.thumbWidth / this.BIY.thumbHeight)));
      this.oZd.setLayoutParams(localLayoutParams);
      if ((this.BOm != null) && (this.uGl != null) && (this.BLU != null))
      {
        this.BOm.setVisibility(8);
        this.uGl.setVisibility(8);
        this.BLU.setVisibility(8);
        if (!bu.isNullOrNil(this.BIY.source))
        {
          this.uGl.setText(this.BIY.source);
          this.uGl.setVisibility(0);
          if (!bu.isNullOrNil(this.BIY.dJL)) {
            this.BOm.setVisibility(0);
          }
          if (bu.isNullOrNil(this.BIY.HWm)) {
            break label275;
          }
          q.aJb().a(this.BIY.HWm, this.BLU, d.BJp);
          label216:
          this.BLU.setVisibility(0);
        }
      }
      if (!this.BLm.etn()) {
        break label288;
      }
      this.BOQ.setVisibility(0);
      this.BOP.setVisibility(0);
    }
    for (;;)
    {
      eun();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label275:
      this.BLU.setImageResource(2131231875);
      break label216;
      label288:
      this.BOQ.setVisibility(8);
      this.BOP.setVisibility(8);
    }
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void TH(int paramInt) {}
    
    public final int bH(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
    
    public final void bnH() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */