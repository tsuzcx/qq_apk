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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.protobuf.ddb;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public class f
  extends g
{
  public TextView snE;
  public TextView titleTv;
  private ddb yLY;
  public ImageView yOU;
  public View yQY;
  public View yQZ;
  public ImageView yRa;
  public TextView yRb;
  public View yRc;
  public View yRd;
  public View yRe;
  public View yRf;
  public View yRg;
  public View yRh;
  public View yRi;
  public TextView yRj;
  public TextView yRk;
  public ImageView yRl;
  public ImageView yRm;
  public View yRn;
  av yRo;
  private a yRp;
  private boolean yRq;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bGT()
  {
    AppMethodBeat.i(126311);
    if (this.yRo != null) {
      this.yRo.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final boolean bcB()
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
  
  public final void bcH()
  {
    AppMethodBeat.i(126312);
    if (this.yRo != null)
    {
      this.yRo.stopTimer();
      this.yRo.av(2000L, 2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final void bdT()
  {
    AppMethodBeat.i(126321);
    super.bdT();
    if ((this.yRp != null) && (this.yLY != null)) {
      this.yRp.b(this.yLY, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void dPU()
  {
    AppMethodBeat.i(126319);
    this.kth.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void dPV()
  {
    AppMethodBeat.i(126320);
    this.kth.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.ktg.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495778;
  }
  
  public View getWowView()
  {
    return this.yQZ;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(202283);
    setVisibility(8);
    AppMethodBeat.o(202283);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.yRc = this.contentView.findViewById(2131298748);
    this.yQY = this.contentView.findViewById(2131304744);
    this.yQZ = this.contentView.findViewById(2131307019);
    this.yRa = ((ImageView)this.contentView.findViewById(2131307018));
    this.yRb = ((TextView)this.contentView.findViewById(2131307017));
    this.yRd = this.contentView.findViewById(2131303530);
    this.yRe = this.contentView.findViewById(2131303529);
    this.yRf = this.contentView.findViewById(2131305623);
    this.yRg = this.contentView.findViewById(2131297472);
    this.yRh = this.contentView.findViewById(2131305612);
    this.yRi = this.contentView.findViewById(2131305616);
    this.yRj = ((TextView)this.contentView.findViewById(2131305613));
    this.yRk = ((TextView)this.contentView.findViewById(2131305617));
    this.yRl = ((ImageView)this.contentView.findViewById(2131305611));
    this.yRm = ((ImageView)this.contentView.findViewById(2131305615));
    this.yOU = ((ImageView)this.contentView.findViewById(2131305130));
    this.snE = ((TextView)this.contentView.findViewById(2131305134));
    this.yRn = this.contentView.findViewById(2131305129);
    this.titleTv = ((TextView)this.contentView.findViewById(2131305948));
    AppMethodBeat.o(126305);
  }
  
  public final void l(ddb paramddb)
  {
    AppMethodBeat.i(126306);
    if ((paramddb.EuW & 0x80) > 0)
    {
      this.yQZ.setVisibility(0);
      if (paramddb.Evb)
      {
        this.yRa.setImageResource(2131691329);
        this.yRb.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.yRb.setText(d.Pe(paramddb.Evg));
        AppMethodBeat.o(126306);
        return;
        this.yRa.setImageResource(2131691330);
        this.yRb.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.yQZ.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void m(ddb paramddb)
  {
    AppMethodBeat.i(126307);
    this.yLY = paramddb;
    this.yQY.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131166392);
    this.kti.setTextSize(0, f);
    this.ktj.setTextSize(0, f);
    Object localObject = this.yRe.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131166391);
    this.yRe.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramddb.rNO.size() > 0)
    {
      if (this.yRf != null) {
        this.yRf.setVisibility(0);
      }
      this.yRg.setVisibility(0);
      localObject = (ctk)paramddb.rNO.get(0);
      this.yRh.setTag(localObject);
      this.yRj.setText(((ctk)localObject).doh);
      this.yRj.setVisibility(0);
      this.yRh.setVisibility(0);
      this.yRl.setVisibility(8);
      if (!bt.isNullOrNil(((ctk)localObject).dub))
      {
        o.ayJ().a(((ctk)localObject).dub, this.yRl, d.yMn);
        this.yRl.setVisibility(0);
      }
      if (paramddb.rNO.size() > 1)
      {
        localObject = (ctk)paramddb.rNO.get(1);
        this.yRi.setTag(localObject);
        this.yRk.setText(((ctk)localObject).doh);
        this.yRk.setVisibility(0);
        this.yRi.setVisibility(0);
        this.yRm.setVisibility(8);
        if (!bt.isNullOrNil(((ctk)localObject).dub))
        {
          o.ayJ().a(((ctk)localObject).dub, this.yRm, d.yMn);
          this.yRm.setVisibility(0);
        }
        l(paramddb);
        if (this.yRq) {
          this.yRg.setVisibility(8);
        }
        if ((this.yRn != null) && (this.snE != null) && (this.yOU != null))
        {
          this.yRn.setVisibility(8);
          this.snE.setVisibility(8);
          this.yOU.setVisibility(8);
          if (!bt.isNullOrNil(paramddb.source))
          {
            this.snE.setText(paramddb.source);
            this.snE.setVisibility(0);
            if (!bt.isNullOrNil(paramddb.kqB)) {
              this.yRn.setVisibility(0);
            }
            if (bt.isNullOrNil(paramddb.EuS)) {
              break label527;
            }
            o.ayJ().a(paramddb.EuS, this.yOU, d.yMm);
          }
        }
      }
    }
    for (;;)
    {
      this.yOU.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramddb.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.yRi.setVisibility(8);
      this.yRk.setVisibility(8);
      break;
      if (this.yRf != null) {
        this.yRf.setVisibility(8);
      }
      this.yRg.setVisibility(8);
      break;
      label527:
      this.yOU.setImageResource(2131231875);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.yRp = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.yRq = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.yQY.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.snE != null) {
      this.snE.setOnClickListener(paramOnClickListener);
    }
    if (this.yOU != null) {
      this.yOU.setOnClickListener(paramOnClickListener);
    }
    if (this.yRn != null) {
      this.yRn.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.yRh.setOnClickListener(paramOnClickListener);
    this.yRi.setOnClickListener(paramOnClickListener);
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
      if (this.yRp != null)
      {
        this.yRp.dPT();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.yRp != null)) {
      this.yRp.dPS();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.yQZ.setVisibility(0);
    this.yQZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    dPV();
    if (this.yRo == null) {
      this.yRo = new av(new av.a()
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
    this.yRo.stopTimer();
    this.yRo.av(2000L, 2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(ddb paramddb, int paramInt1, int paramInt2);
    
    public abstract void dPS();
    
    public abstract void dPT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */