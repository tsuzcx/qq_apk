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
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public class f
  extends g
{
  private dpa BJb;
  public ImageView BLU;
  public View BNX;
  public View BNY;
  public ImageView BNZ;
  public TextView BOa;
  public View BOb;
  public View BOc;
  public View BOd;
  public View BOe;
  public View BOf;
  public View BOg;
  public View BOh;
  public TextView BOi;
  public TextView BOj;
  public ImageView BOk;
  public ImageView BOl;
  public View BOm;
  aw BOn;
  private a BOo;
  private boolean BOp;
  public TextView titleTv;
  public TextView uGl;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bTU()
  {
    AppMethodBeat.i(126311);
    if (this.BOn != null) {
      this.BOn.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final boolean bnS()
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
  
  public final void bnY()
  {
    AppMethodBeat.i(126312);
    if (this.BOn != null)
    {
      this.BOn.stopTimer();
      this.BOn.ay(2000L, 2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final void bpi()
  {
    AppMethodBeat.i(126321);
    super.bpi();
    if ((this.BOo != null) && (this.BJb != null)) {
      this.BOo.b(this.BJb, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void eur()
  {
    AppMethodBeat.i(126319);
    this.lvU.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void eus()
  {
    AppMethodBeat.i(126320);
    this.lvU.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.lvT.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495778;
  }
  
  public View getWowView()
  {
    return this.BNY;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(224388);
    setVisibility(8);
    AppMethodBeat.o(224388);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.BOb = this.contentView.findViewById(2131298748);
    this.BNX = this.contentView.findViewById(2131304744);
    this.BNY = this.contentView.findViewById(2131307019);
    this.BNZ = ((ImageView)this.contentView.findViewById(2131307018));
    this.BOa = ((TextView)this.contentView.findViewById(2131307017));
    this.BOc = this.contentView.findViewById(2131303530);
    this.BOd = this.contentView.findViewById(2131303529);
    this.BOe = this.contentView.findViewById(2131305623);
    this.BOf = this.contentView.findViewById(2131297472);
    this.BOg = this.contentView.findViewById(2131305612);
    this.BOh = this.contentView.findViewById(2131305616);
    this.BOi = ((TextView)this.contentView.findViewById(2131305613));
    this.BOj = ((TextView)this.contentView.findViewById(2131305617));
    this.BOk = ((ImageView)this.contentView.findViewById(2131305611));
    this.BOl = ((ImageView)this.contentView.findViewById(2131305615));
    this.BLU = ((ImageView)this.contentView.findViewById(2131305130));
    this.uGl = ((TextView)this.contentView.findViewById(2131305134));
    this.BOm = this.contentView.findViewById(2131305129);
    this.titleTv = ((TextView)this.contentView.findViewById(2131305948));
    AppMethodBeat.o(126305);
  }
  
  public final void l(dpa paramdpa)
  {
    AppMethodBeat.i(126306);
    if ((paramdpa.HWq & 0x80) > 0)
    {
      this.BNY.setVisibility(0);
      if (paramdpa.HWv)
      {
        this.BNZ.setImageResource(2131691329);
        this.BOa.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.BOa.setText(d.TB(paramdpa.HWA));
        AppMethodBeat.o(126306);
        return;
        this.BNZ.setImageResource(2131691330);
        this.BOa.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.BNY.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void m(dpa paramdpa)
  {
    AppMethodBeat.i(126307);
    this.BJb = paramdpa;
    this.BNX.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131166392);
    this.lvV.setTextSize(0, f);
    this.lvW.setTextSize(0, f);
    Object localObject = this.BOd.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131166391);
    this.BOd.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramdpa.uda.size() > 0)
    {
      if (this.BOe != null) {
        this.BOe.setVisibility(0);
      }
      this.BOf.setVisibility(0);
      localObject = (dfc)paramdpa.uda.get(0);
      this.BOg.setTag(localObject);
      this.BOi.setText(((dfc)localObject).dyI);
      this.BOi.setVisibility(0);
      this.BOg.setVisibility(0);
      this.BOk.setVisibility(8);
      if (!bu.isNullOrNil(((dfc)localObject).dEM))
      {
        q.aJb().a(((dfc)localObject).dEM, this.BOk, d.BJq);
        this.BOk.setVisibility(0);
      }
      if (paramdpa.uda.size() > 1)
      {
        localObject = (dfc)paramdpa.uda.get(1);
        this.BOh.setTag(localObject);
        this.BOj.setText(((dfc)localObject).dyI);
        this.BOj.setVisibility(0);
        this.BOh.setVisibility(0);
        this.BOl.setVisibility(8);
        if (!bu.isNullOrNil(((dfc)localObject).dEM))
        {
          q.aJb().a(((dfc)localObject).dEM, this.BOl, d.BJq);
          this.BOl.setVisibility(0);
        }
        l(paramdpa);
        if (this.BOp) {
          this.BOf.setVisibility(8);
        }
        if ((this.BOm != null) && (this.uGl != null) && (this.BLU != null))
        {
          this.BOm.setVisibility(8);
          this.uGl.setVisibility(8);
          this.BLU.setVisibility(8);
          if (!bu.isNullOrNil(paramdpa.source))
          {
            this.uGl.setText(paramdpa.source);
            this.uGl.setVisibility(0);
            if (!bu.isNullOrNil(paramdpa.dJL)) {
              this.BOm.setVisibility(0);
            }
            if (bu.isNullOrNil(paramdpa.HWm)) {
              break label527;
            }
            q.aJb().a(paramdpa.HWm, this.BLU, d.BJp);
          }
        }
      }
    }
    for (;;)
    {
      this.BLU.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramdpa.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.BOh.setVisibility(8);
      this.BOj.setVisibility(8);
      break;
      if (this.BOe != null) {
        this.BOe.setVisibility(8);
      }
      this.BOf.setVisibility(8);
      break;
      label527:
      this.BLU.setImageResource(2131231875);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.BOo = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.BOp = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.BNX.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.uGl != null) {
      this.uGl.setOnClickListener(paramOnClickListener);
    }
    if (this.BLU != null) {
      this.BLU.setOnClickListener(paramOnClickListener);
    }
    if (this.BOm != null) {
      this.BOm.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.BOg.setOnClickListener(paramOnClickListener);
    this.BOh.setOnClickListener(paramOnClickListener);
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
      if (this.BOo != null)
      {
        this.BOo.euq();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.BOo != null)) {
      this.BOo.eup();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.BNY.setVisibility(0);
    this.BNY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    eus();
    if (this.BOn == null) {
      this.BOn = new aw(new aw.a()
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
    this.BOn.stopTimer();
    this.BOn.ay(2000L, 2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(dpa paramdpa, int paramInt1, int paramInt2);
    
    public abstract void eup();
    
    public abstract void euq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */