package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class f
  extends g
{
  private eiw GjK;
  public ImageView GmA;
  public View GoE;
  public View GoF;
  public ImageView GoG;
  public TextView GoH;
  public View GoI;
  public View GoJ;
  public View GoK;
  public View GoL;
  public View GoM;
  public View GoN;
  public View GoO;
  public TextView GoP;
  public TextView GoQ;
  public ImageView GoR;
  public ImageView GoS;
  public View GoT;
  MTimerHandler GoU;
  private a GoV;
  private boolean GoW;
  public TextView titleTv;
  public TextView xYx;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(126312);
    if (this.GoU != null)
    {
      this.GoU.stopTimer();
      this.GoU.startTimer(2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(126309);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(126309);
      return true;
    }
    AppMethodBeat.o(126309);
    return false;
  }
  
  public final void bKO()
  {
    AppMethodBeat.i(126321);
    super.bKO();
    if ((this.GoV != null) && (this.GjK != null)) {
      this.GoV.b(this.GjK, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void crH()
  {
    AppMethodBeat.i(126311);
    if (this.GoU != null) {
      this.GoU.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final void fzM()
  {
    AppMethodBeat.i(126319);
    this.mCP.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void fzN()
  {
    AppMethodBeat.i(126320);
    this.mCP.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.mCO.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131496736;
  }
  
  public View getWowView()
  {
    return this.GoF;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(258727);
    setVisibility(8);
    AppMethodBeat.o(258727);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.GoI = this.contentView.findViewById(2131299191);
    this.GoE = this.contentView.findViewById(2131307810);
    this.GoF = this.contentView.findViewById(2131310543);
    this.GoG = ((ImageView)this.contentView.findViewById(2131310542));
    this.GoH = ((TextView)this.contentView.findViewById(2131310541));
    this.GoJ = this.contentView.findViewById(2131306298);
    this.GoK = this.contentView.findViewById(2131306297);
    this.GoL = this.contentView.findViewById(2131308864);
    this.GoM = this.contentView.findViewById(2131297709);
    this.GoN = this.contentView.findViewById(2131308853);
    this.GoO = this.contentView.findViewById(2131308857);
    this.GoP = ((TextView)this.contentView.findViewById(2131308854));
    this.GoQ = ((TextView)this.contentView.findViewById(2131308858));
    this.GoR = ((ImageView)this.contentView.findViewById(2131308852));
    this.GoS = ((ImageView)this.contentView.findViewById(2131308856));
    this.GmA = ((ImageView)this.contentView.findViewById(2131308308));
    this.xYx = ((TextView)this.contentView.findViewById(2131308313));
    this.GoT = this.contentView.findViewById(2131308307);
    this.titleTv = ((TextView)this.contentView.findViewById(2131309249));
    AppMethodBeat.o(126305);
  }
  
  public final void m(eiw parameiw)
  {
    AppMethodBeat.i(126306);
    if ((parameiw.Nix & 0x80) > 0)
    {
      this.GoF.setVisibility(0);
      if (parameiw.NiC)
      {
        this.GoG.setImageResource(2131691661);
        this.GoH.setTextColor(getResources().getColor(2131101284));
      }
      for (;;)
      {
        this.GoH.setText(c.abR(parameiw.NiH));
        AppMethodBeat.o(126306);
        return;
        this.GoG.setImageResource(2131691662);
        this.GoH.setTextColor(getResources().getColor(2131101427));
      }
    }
    this.GoF.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void n(eiw parameiw)
  {
    AppMethodBeat.i(126307);
    this.GjK = parameiw;
    this.GoE.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131166484);
    this.mCQ.setTextSize(0, f);
    this.mCR.setTextSize(0, f);
    Object localObject = this.GoK.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131166483);
    this.GoK.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (parameiw.xuO.size() > 0)
    {
      if (this.GoL != null) {
        this.GoL.setVisibility(0);
      }
      this.GoM.setVisibility(0);
      localObject = (dyi)parameiw.xuO.get(0);
      this.GoN.setTag(localObject);
      this.GoP.setText(((dyi)localObject).dQx);
      this.GoP.setVisibility(0);
      this.GoN.setVisibility(0);
      this.GoR.setVisibility(8);
      if (!Util.isNullOrNil(((dyi)localObject).icon))
      {
        q.bcV().a(((dyi)localObject).icon, this.GoR, c.GjV);
        this.GoR.setVisibility(0);
      }
      if (parameiw.xuO.size() > 1)
      {
        localObject = (dyi)parameiw.xuO.get(1);
        this.GoO.setTag(localObject);
        this.GoQ.setText(((dyi)localObject).dQx);
        this.GoQ.setVisibility(0);
        this.GoO.setVisibility(0);
        this.GoS.setVisibility(8);
        if (!Util.isNullOrNil(((dyi)localObject).icon))
        {
          q.bcV().a(((dyi)localObject).icon, this.GoS, c.GjV);
          this.GoS.setVisibility(0);
        }
        m(parameiw);
        if (this.GoW) {
          this.GoM.setVisibility(8);
        }
        if ((this.GoT != null) && (this.xYx != null) && (this.GmA != null))
        {
          this.GoT.setVisibility(8);
          this.xYx.setVisibility(8);
          this.GmA.setVisibility(8);
          if (!Util.isNullOrNil(parameiw.source))
          {
            this.xYx.setText(parameiw.source);
            this.xYx.setVisibility(0);
            if (n.i(parameiw)) {
              this.GoT.setVisibility(0);
            }
            if (Util.isNullOrNil(parameiw.MwR)) {
              break label524;
            }
            q.bcV().a(parameiw.MwR, this.GmA, c.GjU);
          }
        }
      }
    }
    for (;;)
    {
      this.GmA.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(parameiw.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.GoO.setVisibility(8);
      this.GoQ.setVisibility(8);
      break;
      if (this.GoL != null) {
        this.GoL.setVisibility(8);
      }
      this.GoM.setVisibility(8);
      break;
      label524:
      this.GmA.setImageResource(2131231957);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.GoV = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.GoW = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.GoE.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.xYx != null) {
      this.xYx.setOnClickListener(paramOnClickListener);
    }
    if (this.GmA != null) {
      this.GmA.setOnClickListener(paramOnClickListener);
    }
    if (this.GoT != null) {
      this.GoT.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.GoN.setOnClickListener(paramOnClickListener);
    this.GoO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126315);
  }
  
  public void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126318);
    this.titleTv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126318);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(126322);
    super.setVisibility(paramInt);
    if ((paramInt == 8) || (paramInt == 4))
    {
      if (this.GoV != null)
      {
        this.GoV.fzL();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.GoV != null)) {
      this.GoV.fzK();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.GoF.setVisibility(0);
    this.GoF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    fzN();
    if (this.GoU == null) {
      this.GoU = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(126304);
          f.this.setVisibility(8);
          f.a(f.this).stopTimer();
          AppMethodBeat.o(126304);
          return false;
        }
      }, false);
    }
    this.GoU.stopTimer();
    this.GoU.startTimer(2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(eiw parameiw, int paramInt1, int paramInt2);
    
    public abstract void fzK();
    
    public abstract void fzL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */