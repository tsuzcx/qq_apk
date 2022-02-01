package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class f
  extends g
{
  private dod BrC;
  public ImageView Buw;
  public View BwA;
  public ImageView BwB;
  public TextView BwC;
  public View BwD;
  public View BwE;
  public View BwF;
  public View BwG;
  public View BwH;
  public View BwI;
  public View BwJ;
  public TextView BwK;
  public TextView BwL;
  public ImageView BwM;
  public ImageView BwN;
  public View BwO;
  av BwP;
  private a BwQ;
  private boolean BwR;
  public View Bwz;
  public TextView titleTv;
  public TextView uuM;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(126311);
    if (this.BwP != null) {
      this.BwP.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final boolean bni()
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
  
  public final void bno()
  {
    AppMethodBeat.i(126312);
    if (this.BwP != null)
    {
      this.BwP.stopTimer();
      this.BwP.az(2000L, 2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final void boy()
  {
    AppMethodBeat.i(126321);
    super.boy();
    if ((this.BwQ != null) && (this.BrC != null)) {
      this.BwQ.b(this.BrC, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void eqK()
  {
    AppMethodBeat.i(126319);
    this.lru.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void eqL()
  {
    AppMethodBeat.i(126320);
    this.lru.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.lrt.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495778;
  }
  
  public View getWowView()
  {
    return this.BwA;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(221364);
    setVisibility(8);
    AppMethodBeat.o(221364);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.BwD = this.contentView.findViewById(2131298748);
    this.Bwz = this.contentView.findViewById(2131304744);
    this.BwA = this.contentView.findViewById(2131307019);
    this.BwB = ((ImageView)this.contentView.findViewById(2131307018));
    this.BwC = ((TextView)this.contentView.findViewById(2131307017));
    this.BwE = this.contentView.findViewById(2131303530);
    this.BwF = this.contentView.findViewById(2131303529);
    this.BwG = this.contentView.findViewById(2131305623);
    this.BwH = this.contentView.findViewById(2131297472);
    this.BwI = this.contentView.findViewById(2131305612);
    this.BwJ = this.contentView.findViewById(2131305616);
    this.BwK = ((TextView)this.contentView.findViewById(2131305613));
    this.BwL = ((TextView)this.contentView.findViewById(2131305617));
    this.BwM = ((ImageView)this.contentView.findViewById(2131305611));
    this.BwN = ((ImageView)this.contentView.findViewById(2131305615));
    this.Buw = ((ImageView)this.contentView.findViewById(2131305130));
    this.uuM = ((TextView)this.contentView.findViewById(2131305134));
    this.BwO = this.contentView.findViewById(2131305129);
    this.titleTv = ((TextView)this.contentView.findViewById(2131305948));
    AppMethodBeat.o(126305);
  }
  
  public final void l(dod paramdod)
  {
    AppMethodBeat.i(126306);
    if ((paramdod.HCD & 0x80) > 0)
    {
      this.BwA.setVisibility(0);
      if (paramdod.HCI)
      {
        this.BwB.setImageResource(2131691329);
        this.BwC.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.BwC.setText(d.SU(paramdod.HCN));
        AppMethodBeat.o(126306);
        return;
        this.BwB.setImageResource(2131691330);
        this.BwC.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.BwA.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void m(dod paramdod)
  {
    AppMethodBeat.i(126307);
    this.BrC = paramdod;
    this.Bwz.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131166392);
    this.lrv.setTextSize(0, f);
    this.lrw.setTextSize(0, f);
    Object localObject = this.BwF.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131166391);
    this.BwF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramdod.tSj.size() > 0)
    {
      if (this.BwG != null) {
        this.BwG.setVisibility(0);
      }
      this.BwH.setVisibility(0);
      localObject = (dei)paramdod.tSj.get(0);
      this.BwI.setTag(localObject);
      this.BwK.setText(((dei)localObject).dxD);
      this.BwK.setVisibility(0);
      this.BwI.setVisibility(0);
      this.BwM.setVisibility(8);
      if (!bt.isNullOrNil(((dei)localObject).dDH))
      {
        q.aIJ().a(((dei)localObject).dDH, this.BwM, d.BrR);
        this.BwM.setVisibility(0);
      }
      if (paramdod.tSj.size() > 1)
      {
        localObject = (dei)paramdod.tSj.get(1);
        this.BwJ.setTag(localObject);
        this.BwL.setText(((dei)localObject).dxD);
        this.BwL.setVisibility(0);
        this.BwJ.setVisibility(0);
        this.BwN.setVisibility(8);
        if (!bt.isNullOrNil(((dei)localObject).dDH))
        {
          q.aIJ().a(((dei)localObject).dDH, this.BwN, d.BrR);
          this.BwN.setVisibility(0);
        }
        l(paramdod);
        if (this.BwR) {
          this.BwH.setVisibility(8);
        }
        if ((this.BwO != null) && (this.uuM != null) && (this.Buw != null))
        {
          this.BwO.setVisibility(8);
          this.uuM.setVisibility(8);
          this.Buw.setVisibility(8);
          if (!bt.isNullOrNil(paramdod.source))
          {
            this.uuM.setText(paramdod.source);
            this.uuM.setVisibility(0);
            if (!bt.isNullOrNil(paramdod.lox)) {
              this.BwO.setVisibility(0);
            }
            if (bt.isNullOrNil(paramdod.HCz)) {
              break label527;
            }
            q.aIJ().a(paramdod.HCz, this.Buw, d.BrQ);
          }
        }
      }
    }
    for (;;)
    {
      this.Buw.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramdod.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.BwJ.setVisibility(8);
      this.BwL.setVisibility(8);
      break;
      if (this.BwG != null) {
        this.BwG.setVisibility(8);
      }
      this.BwH.setVisibility(8);
      break;
      label527:
      this.Buw.setImageResource(2131231875);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.BwQ = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.BwR = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.Bwz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.uuM != null) {
      this.uuM.setOnClickListener(paramOnClickListener);
    }
    if (this.Buw != null) {
      this.Buw.setOnClickListener(paramOnClickListener);
    }
    if (this.BwO != null) {
      this.BwO.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.BwI.setOnClickListener(paramOnClickListener);
    this.BwJ.setOnClickListener(paramOnClickListener);
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
      if (this.BwQ != null)
      {
        this.BwQ.eqJ();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.BwQ != null)) {
      this.BwQ.eqI();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.BwA.setVisibility(0);
    this.BwA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    eqL();
    if (this.BwP == null) {
      this.BwP = new av(new av.a()
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
    this.BwP.stopTimer();
    this.BwP.az(2000L, 2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(dod paramdod, int paramInt1, int paramInt2);
    
    public abstract void eqI();
    
    public abstract void eqJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */