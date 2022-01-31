package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class f
  extends g
{
  public TextView naO;
  public TextView naP;
  public TextView qzL;
  public TextView titleTv;
  public ImageView tiu;
  private ckx tjR;
  public View tkA;
  public View tkB;
  public View tkC;
  public View tkD;
  public ImageView tkE;
  public ImageView tkF;
  public View tkG;
  ap tkH;
  private f.a tkI;
  private boolean tkp;
  public View tkt;
  public View tku;
  public ImageView tkv;
  public TextView tkw;
  public View tkx;
  public View tky;
  public View tkz;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(141941);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(141941);
      return true;
    }
    AppMethodBeat.o(141941);
    return false;
  }
  
  public final void aFn()
  {
    AppMethodBeat.i(1931);
    if (this.tkH != null)
    {
      this.tkH.stopTimer();
      this.tkH.ag(2000L, 2000L);
    }
    AppMethodBeat.o(1931);
  }
  
  public final void aFy()
  {
    AppMethodBeat.i(1942);
    super.aFy();
    if ((this.tkI != null) && (this.tjR != null)) {
      this.tkI.a(this.tjR, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(1942);
  }
  
  public final void baj()
  {
    AppMethodBeat.i(1930);
    if (this.tkH != null) {
      this.tkH.stopTimer();
    }
    AppMethodBeat.o(1930);
  }
  
  public final void cKo()
  {
    AppMethodBeat.i(1940);
    this.qTF.setVisibility(8);
    AppMethodBeat.o(1940);
  }
  
  public final void cKp()
  {
    AppMethodBeat.i(1941);
    this.qTF.setVisibility(0);
    AppMethodBeat.o(1941);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(1932);
    int i = this.qTE.getWidth();
    AppMethodBeat.o(1932);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2130971014;
  }
  
  public View getWowView()
  {
    return this.tku;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(156795);
    setVisibility(8);
    AppMethodBeat.o(156795);
  }
  
  public final void i(ckx paramckx)
  {
    AppMethodBeat.i(1927);
    if ((paramckx.xVl & 0x80) > 0)
    {
      this.tku.setVisibility(0);
      if (paramckx.xVp)
      {
        this.tkv.setImageResource(2131232125);
        this.tkw.setTextColor(getResources().getColor(2131690603));
        AppMethodBeat.o(1927);
        return;
      }
      this.tkv.setImageResource(2131232126);
      this.tkw.setTextColor(getResources().getColor(2131690709));
      AppMethodBeat.o(1927);
      return;
    }
    this.tku.setVisibility(8);
    AppMethodBeat.o(1927);
  }
  
  public void init()
  {
    AppMethodBeat.i(1926);
    super.init();
    this.tkx = this.contentView.findViewById(2131828558);
    this.tkt = this.contentView.findViewById(2131828545);
    this.tku = this.contentView.findViewById(2131828542);
    this.tkv = ((ImageView)this.contentView.findViewById(2131828543));
    this.tkw = ((TextView)this.contentView.findViewById(2131828544));
    this.tky = this.contentView.findViewById(2131828547);
    this.tkz = this.contentView.findViewById(2131828557);
    this.tkA = this.contentView.findViewById(2131828549);
    this.tkB = this.contentView.findViewById(2131828550);
    this.tkC = this.contentView.findViewById(2131828551);
    this.tkD = this.contentView.findViewById(2131828554);
    this.naO = ((TextView)this.contentView.findViewById(2131828553));
    this.naP = ((TextView)this.contentView.findViewById(2131828556));
    this.tkE = ((ImageView)this.contentView.findViewById(2131828552));
    this.tkF = ((ImageView)this.contentView.findViewById(2131828555));
    this.tiu = ((ImageView)this.contentView.findViewById(2131828540));
    this.qzL = ((TextView)this.contentView.findViewById(2131821550));
    this.tkG = this.contentView.findViewById(2131828541);
    this.titleTv = ((TextView)this.contentView.findViewById(2131821212));
    AppMethodBeat.o(1926);
  }
  
  public void j(ckx paramckx)
  {
    AppMethodBeat.i(141939);
    this.tjR = paramckx;
    this.tkt.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131428433);
    this.qTG.setTextSize(0, f);
    this.qTH.setTextSize(0, f);
    Object localObject = this.tkz.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131428432);
    this.tkz.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramckx.wVo.size() > 0)
    {
      if (this.tkA != null) {
        this.tkA.setVisibility(0);
      }
      this.tkB.setVisibility(0);
      localObject = (ccp)paramckx.wVo.get(0);
      this.tkC.setTag(localObject);
      this.naO.setText(((ccp)localObject).cyA);
      this.naO.setVisibility(0);
      this.tkC.setVisibility(0);
      this.tkE.setVisibility(8);
      if (!bo.isNullOrNil(((ccp)localObject).cDz))
      {
        o.ahG().a(((ccp)localObject).cDz, this.tkE, d.tfE);
        this.tkE.setVisibility(0);
      }
      if (paramckx.wVo.size() > 1)
      {
        localObject = (ccp)paramckx.wVo.get(1);
        this.tkD.setTag(localObject);
        this.naP.setText(((ccp)localObject).cyA);
        this.naP.setVisibility(0);
        this.tkD.setVisibility(0);
        this.tkF.setVisibility(8);
        if (!bo.isNullOrNil(((ccp)localObject).cDz))
        {
          o.ahG().a(((ccp)localObject).cDz, this.tkF, d.tfE);
          this.tkF.setVisibility(0);
        }
        i(paramckx);
        if (this.tkp) {
          this.tkB.setVisibility(8);
        }
        if ((this.tkG != null) && (this.qzL != null) && (this.tiu != null))
        {
          this.tkG.setVisibility(8);
          this.qzL.setVisibility(8);
          this.tiu.setVisibility(8);
          if (!bo.isNullOrNil(paramckx.source))
          {
            this.qzL.setText(paramckx.source);
            this.qzL.setVisibility(0);
            if (!bo.isNullOrNil(paramckx.puE)) {
              this.tkG.setVisibility(0);
            }
            if (bo.isNullOrNil(paramckx.xVg)) {
              break label526;
            }
            o.ahG().a(paramckx.xVg, this.tiu, d.tfD);
          }
        }
      }
    }
    for (;;)
    {
      this.tiu.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramckx.title);
      }
      AppMethodBeat.o(141939);
      return;
      this.tkD.setVisibility(8);
      this.naP.setVisibility(8);
      break;
      if (this.tkA != null) {
        this.tkA.setVisibility(8);
      }
      this.tkB.setVisibility(8);
      break;
      label526:
      this.tiu.setImageResource(2130838493);
    }
  }
  
  public void setOnUpdateProgressLenListener(f.a parama)
  {
    this.tkI = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.tkp = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(1935);
    this.tkt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(1935);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(1938);
    if (this.qzL != null) {
      this.qzL.setOnClickListener(paramOnClickListener);
    }
    if (this.tiu != null) {
      this.tiu.setOnClickListener(paramOnClickListener);
    }
    if (this.tkG != null) {
      this.tkG.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(1938);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(1936);
    this.tkC.setOnClickListener(paramOnClickListener);
    this.tkD.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(1936);
  }
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(1939);
    this.titleTv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(1939);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(1943);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.tkI != null)
      {
        this.tkI.cKn();
        AppMethodBeat.o(1943);
      }
    }
    else if ((paramInt == 0) && (this.tkI != null)) {
      this.tkI.cKm();
    }
    AppMethodBeat.o(1943);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(1937);
    this.tku.setVisibility(0);
    this.tku.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(1937);
  }
  
  public final void show()
  {
    AppMethodBeat.i(1929);
    setVisibility(0);
    cKp();
    if (this.tkH == null) {
      this.tkH = new ap(new f.1(this), false);
    }
    this.tkH.stopTimer();
    this.tkH.ag(2000L, 2000L);
    AppMethodBeat.o(1929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */