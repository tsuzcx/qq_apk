package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class k
  extends e
{
  public ImageView Buw;
  public View BwA;
  public ImageView BwB;
  public TextView BwC;
  public View BwO;
  public View Bwz;
  public View Bxr;
  public View Bxs;
  public View Bxt;
  public TextView uuM;
  
  public k(Context paramContext, b paramb, com.tencent.mm.plugin.topstory.ui.video.a parama)
  {
    super(paramContext, paramb, parama);
  }
  
  protected final void bmK()
  {
    AppMethodBeat.i(126404);
    this.Bwj = new com.tencent.mm.plugin.topstory.ui.video.k(getContext(), this, new a());
    AppMethodBeat.o(126404);
  }
  
  public final i.e c(dod paramdod)
  {
    AppMethodBeat.i(126401);
    float f1 = com.tencent.mm.cc.a.ip(aj.getContext());
    float f2 = com.tencent.mm.cc.a.iq(aj.getContext()) - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 64);
    float f3 = f1 / f2;
    float f4 = paramdod.thumbWidth / paramdod.thumbHeight;
    ad.i("MicroMsg.TopStory.TopStoryVerticalFSVideoContainer", "getScaleType playAreaRatio %.2f videoRatio %.2f playAreaWidth %.2f playAreaHeight %.2f", new Object[] { Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f1), Float.valueOf(f2) });
    if (f3 <= f4)
    {
      paramdod = i.e.ESO;
      AppMethodBeat.o(126401);
      return paramdod;
    }
    paramdod = i.e.ESP;
    AppMethodBeat.o(126401);
    return paramdod;
  }
  
  protected final void eqG()
  {
    AppMethodBeat.i(126403);
    if ((this.Brz.HCD & 0x80) > 0)
    {
      this.BwA.setVisibility(0);
      if (this.Brz.HCI)
      {
        this.BwB.setImageResource(2131691329);
        this.BwC.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.BwC.setText(d.SU(this.Brz.HCN));
        AppMethodBeat.o(126403);
        return;
        this.BwB.setImageResource(2131691330);
        this.BwC.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.BwA.setVisibility(8);
    AppMethodBeat.o(126403);
  }
  
  public final boolean eqH()
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
    this.Bwz = findViewById(2131304744);
    this.Bxr = findViewById(2131302474);
    this.Bxs = findViewById(2131302464);
    this.BwA = findViewById(2131307019);
    this.BwB = ((ImageView)findViewById(2131307018));
    this.BwC = ((TextView)findViewById(2131307017));
    this.Bxt = findViewById(2131305131);
    this.Buw = ((ImageView)findViewById(2131305130));
    this.uuM = ((TextView)findViewById(2131305134));
    this.BwO = findViewById(2131305129);
    this.Bxr.setOnClickListener(this.Bwl);
    this.BwA.setOnClickListener(this.Bwn);
    this.Bxt.setOnClickListener(this.Bwp);
    this.Bwz.setOnClickListener(this.Bwm);
    AppMethodBeat.o(126400);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(126402);
    super.updateView();
    i.e locale = c(this.Brz);
    ViewGroup.LayoutParams localLayoutParams = this.oSB.getLayoutParams();
    if (locale == i.e.ESO)
    {
      localLayoutParams.width = com.tencent.mm.cc.a.ip(aj.getContext());
      localLayoutParams.height = ((int)(localLayoutParams.width / (this.Brz.thumbWidth / this.Brz.thumbHeight)));
      this.oSB.setLayoutParams(localLayoutParams);
      if ((this.BwO != null) && (this.uuM != null) && (this.Buw != null))
      {
        this.BwO.setVisibility(8);
        this.uuM.setVisibility(8);
        this.Buw.setVisibility(8);
        if (!bt.isNullOrNil(this.Brz.source))
        {
          this.uuM.setText(this.Brz.source);
          this.uuM.setVisibility(0);
          if (!bt.isNullOrNil(this.Brz.lox)) {
            this.BwO.setVisibility(0);
          }
          if (bt.isNullOrNil(this.Brz.HCz)) {
            break label275;
          }
          q.aIJ().a(this.Brz.HCz, this.Buw, d.BrQ);
          label216:
          this.Buw.setVisibility(0);
        }
      }
      if (!this.BtO.epG()) {
        break label288;
      }
      this.Bxs.setVisibility(0);
      this.Bxr.setVisibility(0);
    }
    for (;;)
    {
      eqG();
      AppMethodBeat.o(126402);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      break;
      label275:
      this.Buw.setImageResource(2131231875);
      break label216;
      label288:
      this.Bxs.setVisibility(8);
      this.Bxr.setVisibility(8);
    }
  }
  
  public final class a
    extends e.a
  {
    public a()
    {
      super();
    }
    
    public final void Ta(int paramInt) {}
    
    public final int bJ(float paramFloat)
    {
      AppMethodBeat.i(126399);
      int i = getCurrentPosition();
      AppMethodBeat.o(126399);
      return i;
    }
    
    public final void bmX() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.k
 * JD-Core Version:    0.7.0.1
 */