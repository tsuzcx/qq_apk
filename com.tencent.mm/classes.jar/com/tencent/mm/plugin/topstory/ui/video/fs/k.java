package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class k
  extends e
{
  public TextView qzL;
  public ImageView tiu;
  public View tkG;
  public View tkt;
  public View tku;
  public ImageView tkv;
  public TextView tkw;
  public View tli;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void aEN()
  {
    AppMethodBeat.i(141948);
    this.tkh = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new k.a(this));
    AppMethodBeat.o(141948);
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(141946);
    super.bJ();
    h.d locald = c(this.tfm);
    ViewGroup.LayoutParams localLayoutParams = this.kha.getLayoutParams();
    if (locald == h.d.vQK)
    {
      localLayoutParams.width = com.tencent.mm.cb.a.gw(ah.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.tfm.fgR / this.tfm.fgQ)));
      this.kha.setLayoutParams(localLayoutParams);
      if ((this.tkG != null) && (this.qzL != null) && (this.tiu != null))
      {
        this.tkG.setVisibility(8);
        this.qzL.setVisibility(8);
        this.tiu.setVisibility(8);
        if (!bo.isNullOrNil(this.tfm.source))
        {
          this.qzL.setText(this.tfm.source);
          this.qzL.setVisibility(0);
          if (!bo.isNullOrNil(this.tfm.puE)) {
            this.tkG.setVisibility(0);
          }
          if (bo.isNullOrNil(this.tfm.xVg)) {
            break label247;
          }
          o.ahG().a(this.tfm.xVg, this.tiu, d.tfD);
        }
      }
    }
    for (;;)
    {
      this.tiu.setVisibility(0);
      cKl();
      AppMethodBeat.o(141946);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label247:
      this.tiu.setImageResource(2130838493);
    }
  }
  
  public final h.d c(ckx paramckx)
  {
    AppMethodBeat.i(141945);
    float f1 = com.tencent.mm.cb.a.gw(ah.getContext());
    float f2 = com.tencent.mm.cb.a.gx(ah.getContext()) - com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramckx.fgR / paramckx.fgQ;
    ab.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramckx = h.d.vQK;
      AppMethodBeat.o(141945);
      return paramckx;
    }
    paramckx = h.d.vQL;
    AppMethodBeat.o(141945);
    return paramckx;
  }
  
  protected final void cKl()
  {
    AppMethodBeat.i(141947);
    if ((this.tfm.xVl & 0x80) > 0)
    {
      this.tku.setVisibility(0);
      if (this.tfm.xVp)
      {
        this.tkv.setImageResource(2131232125);
        this.tkw.setTextColor(getResources().getColor(2131690603));
        AppMethodBeat.o(141947);
        return;
      }
      this.tkv.setImageResource(2131232126);
      this.tkw.setTextColor(getResources().getColor(2131690709));
      AppMethodBeat.o(141947);
      return;
    }
    this.tku.setVisibility(8);
    AppMethodBeat.o(141947);
  }
  
  public final int getLayoutId()
  {
    return 2130971011;
  }
  
  public final void init()
  {
    AppMethodBeat.i(141944);
    super.init();
    this.tkt = findViewById(2131828545);
    this.tli = findViewById(2131828546);
    this.tku = findViewById(2131828542);
    this.tkv = ((ImageView)findViewById(2131828543));
    this.tkw = ((TextView)findViewById(2131828544));
    this.tiu = ((ImageView)findViewById(2131828540));
    this.qzL = ((TextView)findViewById(2131821550));
    this.tkG = findViewById(2131828541);
    this.tli.setOnClickListener(this.tkj);
    this.tku.setOnClickListener(this.tkl);
    this.tiu.setOnClickListener(this.tkn);
    this.tkt.setOnClickListener(this.tkk);
    AppMethodBeat.o(141944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */