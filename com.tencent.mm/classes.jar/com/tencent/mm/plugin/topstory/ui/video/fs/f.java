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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.topstory.ui.video.g;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public class f
  extends g
{
  public ImageView AcL;
  public View AeN;
  public View AeO;
  public ImageView AeP;
  public TextView AeQ;
  public View AeR;
  public View AeS;
  public View AeT;
  public View AeU;
  public View AeV;
  public View AeW;
  public View AeX;
  public TextView AeY;
  public TextView AeZ;
  public ImageView Afa;
  public ImageView Afb;
  public View Afc;
  au Afd;
  private a Afe;
  private boolean Aff;
  public TextView titleTv;
  public TextView tvx;
  private dio zZQ;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void bOg()
  {
    AppMethodBeat.i(126311);
    if (this.Afd != null) {
      this.Afd.stopTimer();
    }
    AppMethodBeat.o(126311);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(126312);
    if (this.Afd != null)
    {
      this.Afd.stopTimer();
      this.Afd.au(2000L, 2000L);
    }
    AppMethodBeat.o(126312);
  }
  
  public final boolean bjw()
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
  
  public final void bkN()
  {
    AppMethodBeat.i(126321);
    super.bkN();
    if ((this.Afe != null) && (this.zZQ != null)) {
      this.Afe.b(this.zZQ, this.mPosition, getVideoTotalTime());
    }
    AppMethodBeat.o(126321);
  }
  
  public final void eet()
  {
    AppMethodBeat.i(126319);
    this.kUw.setVisibility(8);
    AppMethodBeat.o(126319);
  }
  
  public final void eeu()
  {
    AppMethodBeat.i(126320);
    this.kUw.setVisibility(0);
    AppMethodBeat.o(126320);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(126313);
    int i = this.kUv.getWidth();
    AppMethodBeat.o(126313);
    return i;
  }
  
  public int getLayoutId()
  {
    return 2131495778;
  }
  
  public View getWowView()
  {
    return this.AeO;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(210286);
    setVisibility(8);
    AppMethodBeat.o(210286);
  }
  
  public void init()
  {
    AppMethodBeat.i(126305);
    super.init();
    this.AeR = this.contentView.findViewById(2131298748);
    this.AeN = this.contentView.findViewById(2131304744);
    this.AeO = this.contentView.findViewById(2131307019);
    this.AeP = ((ImageView)this.contentView.findViewById(2131307018));
    this.AeQ = ((TextView)this.contentView.findViewById(2131307017));
    this.AeS = this.contentView.findViewById(2131303530);
    this.AeT = this.contentView.findViewById(2131303529);
    this.AeU = this.contentView.findViewById(2131305623);
    this.AeV = this.contentView.findViewById(2131297472);
    this.AeW = this.contentView.findViewById(2131305612);
    this.AeX = this.contentView.findViewById(2131305616);
    this.AeY = ((TextView)this.contentView.findViewById(2131305613));
    this.AeZ = ((TextView)this.contentView.findViewById(2131305617));
    this.Afa = ((ImageView)this.contentView.findViewById(2131305611));
    this.Afb = ((ImageView)this.contentView.findViewById(2131305615));
    this.AcL = ((ImageView)this.contentView.findViewById(2131305130));
    this.tvx = ((TextView)this.contentView.findViewById(2131305134));
    this.Afc = this.contentView.findViewById(2131305129);
    this.titleTv = ((TextView)this.contentView.findViewById(2131305948));
    AppMethodBeat.o(126305);
  }
  
  public final void l(dio paramdio)
  {
    AppMethodBeat.i(126306);
    if ((paramdio.FRX & 0x80) > 0)
    {
      this.AeO.setVisibility(0);
      if (paramdio.FSc)
      {
        this.AeP.setImageResource(2131691329);
        this.AeQ.setTextColor(getResources().getColor(2131101051));
      }
      for (;;)
      {
        this.AeQ.setText(d.Rk(paramdio.FSh));
        AppMethodBeat.o(126306);
        return;
        this.AeP.setImageResource(2131691330);
        this.AeQ.setTextColor(getResources().getColor(2131101182));
      }
    }
    this.AeO.setVisibility(8);
    AppMethodBeat.o(126306);
  }
  
  public void m(dio paramdio)
  {
    AppMethodBeat.i(126307);
    this.zZQ = paramdio;
    this.AeN.setVisibility(0);
    float f = getResources().getDimensionPixelSize(2131166392);
    this.kUx.setTextSize(0, f);
    this.kUy.setTextSize(0, f);
    Object localObject = this.AeT.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = getResources().getDimensionPixelSize(2131166391);
    this.AeT.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (paramdio.sVE.size() > 0)
    {
      if (this.AeU != null) {
        this.AeU.setVisibility(0);
      }
      this.AeV.setVisibility(0);
      localObject = (cyv)paramdio.sVE.get(0);
      this.AeW.setTag(localObject);
      this.AeY.setText(((cyv)localObject).dlQ);
      this.AeY.setVisibility(0);
      this.AeW.setVisibility(0);
      this.Afa.setVisibility(8);
      if (!bs.isNullOrNil(((cyv)localObject).drM))
      {
        o.aFB().a(((cyv)localObject).drM, this.Afa, d.Aaf);
        this.Afa.setVisibility(0);
      }
      if (paramdio.sVE.size() > 1)
      {
        localObject = (cyv)paramdio.sVE.get(1);
        this.AeX.setTag(localObject);
        this.AeZ.setText(((cyv)localObject).dlQ);
        this.AeZ.setVisibility(0);
        this.AeX.setVisibility(0);
        this.Afb.setVisibility(8);
        if (!bs.isNullOrNil(((cyv)localObject).drM))
        {
          o.aFB().a(((cyv)localObject).drM, this.Afb, d.Aaf);
          this.Afb.setVisibility(0);
        }
        l(paramdio);
        if (this.Aff) {
          this.AeV.setVisibility(8);
        }
        if ((this.Afc != null) && (this.tvx != null) && (this.AcL != null))
        {
          this.Afc.setVisibility(8);
          this.tvx.setVisibility(8);
          this.AcL.setVisibility(8);
          if (!bs.isNullOrNil(paramdio.source))
          {
            this.tvx.setText(paramdio.source);
            this.tvx.setVisibility(0);
            if (!bs.isNullOrNil(paramdio.kRU)) {
              this.Afc.setVisibility(0);
            }
            if (bs.isNullOrNil(paramdio.FRT)) {
              break label527;
            }
            o.aFB().a(paramdio.FRT, this.AcL, d.Aae);
          }
        }
      }
    }
    for (;;)
    {
      this.AcL.setVisibility(0);
      if (this.titleTv != null) {
        this.titleTv.setText(paramdio.title);
      }
      AppMethodBeat.o(126307);
      return;
      this.AeX.setVisibility(8);
      this.AeZ.setVisibility(8);
      break;
      if (this.AeU != null) {
        this.AeU.setVisibility(8);
      }
      this.AeV.setVisibility(8);
      break;
      label527:
      this.AcL.setImageResource(2131231875);
    }
  }
  
  public void setOnUpdateProgressLenListener(a parama)
  {
    this.Afe = parama;
  }
  
  public void setOnlyFS(boolean paramBoolean)
  {
    this.Aff = paramBoolean;
  }
  
  public void setShareBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126314);
    this.AeN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126314);
  }
  
  public void setSourceItemClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126317);
    if (this.tvx != null) {
      this.tvx.setOnClickListener(paramOnClickListener);
    }
    if (this.AcL != null) {
      this.AcL.setOnClickListener(paramOnClickListener);
    }
    if (this.Afc != null) {
      this.Afc.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(126317);
  }
  
  public void setTagBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126315);
    this.AeW.setOnClickListener(paramOnClickListener);
    this.AeX.setOnClickListener(paramOnClickListener);
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
      if (this.Afe != null)
      {
        this.Afe.ees();
        AppMethodBeat.o(126322);
      }
    }
    else if ((paramInt == 0) && (this.Afe != null)) {
      this.Afe.eer();
    }
    AppMethodBeat.o(126322);
  }
  
  public void setWowBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(126316);
    this.AeO.setVisibility(0);
    this.AeO.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(126316);
  }
  
  public final void show()
  {
    AppMethodBeat.i(126310);
    setVisibility(0);
    eeu();
    if (this.Afd == null) {
      this.Afd = new au(new au.a()
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
    this.Afd.stopTimer();
    this.Afd.au(2000L, 2000L);
    AppMethodBeat.o(126310);
  }
  
  public static abstract interface a
  {
    public abstract void b(dio paramdio, int paramInt1, int paramInt2);
    
    public abstract void eer();
    
    public abstract void ees();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.f
 * JD-Core Version:    0.7.0.1
 */