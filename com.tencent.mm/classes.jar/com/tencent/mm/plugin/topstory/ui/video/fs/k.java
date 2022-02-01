package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends e
{
  public TextView snE;
  public ImageView yOU;
  public View yQY;
  public View yQZ;
  public View yRQ;
  public View yRR;
  public View yRS;
  public ImageView yRa;
  public TextView yRb;
  public View yRn;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void bcd()
  {
    AppMethodBeat.i(126404);
    this.yQH = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final h.e c(ddb paramddb)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cd.a.hV(aj.getContext());
    float f2 = com.tencent.mm.cd.a.hW(aj.getContext()) - com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramddb.thumbWidth / paramddb.thumbHeight;
    ad.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramddb = h.e.BVs;
      AppMethodBeat.o(126401);
      return paramddb;
    }
    paramddb = h.e.BVt;
    AppMethodBeat.o(126401);
    return paramddb;
  }
  
  public final void cE()
  {
    AppMethodBeat.i(126402);
    super.cE();
    h.e locale = c(this.yLU);
    ViewGroup.LayoutParams localLayoutParams = this.nMg.getLayoutParams();
    if (locale == h.e.BVs)
    {
      localLayoutParams.width = com.tencent.mm.cd.a.hV(aj.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.yLU.thumbWidth / this.yLU.thumbHeight)));
      this.nMg.setLayoutParams(localLayoutParams);
      if ((this.yRn != null) && (this.snE != null) && (this.yOU != null))
      {
        this.yRn.setVisibility(8);
        this.snE.setVisibility(8);
        this.yOU.setVisibility(8);
        if (!bt.isNullOrNil(this.yLU.source))
        {
          this.snE.setText(this.yLU.source);
          this.snE.setVisibility(0);
          if (!bt.isNullOrNil(this.yLU.kqB)) {
            this.yRn.setVisibility(0);
          }
          if (bt.isNullOrNil(this.yLU.EuS)) {
            break label275;
          }
          o.ayJ().a(this.yLU.EuS, this.yOU, d.yMm);
          label216:
          this.yOU.setVisibility(0);
        }
      }
      if (!this.yOm.dOO()) {
        break label287;
      }
      this.yRR.setVisibility(0);
      this.yRQ.setVisibility(0);
    }
    for (;;)
    {
      dPQ();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label275:
      this.yOU.setImageResource(2131231875);
      break label216;
      label287:
      this.yRR.setVisibility(8);
      this.yRQ.setVisibility(8);
    }
  }
  
  protected final void dPQ()
  {
    AppMethodBeat.i(126403);
    if ((this.yLU.EuW & 0x80) > 0)
    {
      this.yQZ.setVisibility(0);
      if (this.yLU.Evb)
      {
        this.yRa.setImageResource(2131691329);
        this.yRb.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.yRb.setText(d.Pe(this.yLU.Evg));
        AppMethodBeat.o(126403);
        return;
        this.yRa.setImageResource(2131691330);
        this.yRb.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.yQZ.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean dPR()
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
    this.yQY = findViewById(2131304744);
    this.yRQ = findViewById(2131302474);
    this.yRR = findViewById(2131302464);
    this.yQZ = findViewById(2131307019);
    this.yRa = ((ImageView)findViewById(2131307018));
    this.yRb = ((TextView)findViewById(2131307017));
    this.yRS = findViewById(2131305131);
    this.yOU = ((ImageView)findViewById(2131305130));
    this.snE = ((TextView)findViewById(2131305134));
    this.yRn = findViewById(2131305129);
    this.yRQ.setOnClickListener(this.yQJ);
    this.yQZ.setOnClickListener(this.yQL);
    this.yRS.setOnClickListener(this.yQN);
    this.yQY.setOnClickListener(this.yQK);
    AppMethodBeat.o(126400);
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void Pk(int paramInt) {}
    
    public final void bcp() {}
    
    public final int by(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */