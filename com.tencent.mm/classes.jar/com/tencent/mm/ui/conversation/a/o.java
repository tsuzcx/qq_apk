package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends b
{
  private TextView eXO;
  private ImageView gSx;
  private View hNa = null;
  private boolean vVk = false;
  boolean vVw = false;
  private c vVx;
  
  public o(Context paramContext)
  {
    super(paramContext);
    if ((!this.vVk) && (this.view != null))
    {
      this.hNa = this.view.findViewById(R.h.tniview);
      this.eXO = ((TextView)this.view.findViewById(R.h.tni_detail));
      this.gSx = ((ImageView)this.view.findViewById(R.h.tni_icon));
      this.vVk = true;
      this.vVx = new o.1(this);
      a.udP.c(this.vVx);
    }
  }
  
  public final boolean apu()
  {
    if (!this.vVw)
    {
      y.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", new Object[] { Boolean.valueOf(this.vVw) });
      this.hNa.setVisibility(8);
      return false;
    }
    if (!k.Pj())
    {
      y.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
      this.vVw = false;
      this.hNa.setVisibility(8);
      return false;
    }
    this.eXO.setText(R.l.banner_new_init_retry);
    this.gSx.setVisibility(0);
    this.hNa.setOnClickListener(new o.2(this));
    this.hNa.setVisibility(0);
    if (this.hNa.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", new Object[] { Boolean.valueOf(bool) });
      return true;
    }
  }
  
  public final void destroy()
  {
    a.udP.d(this.vVx);
  }
  
  public final int getLayoutId()
  {
    return R.i.try_newinit_banner;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.hNa != null) {
      this.hNa.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o
 * JD-Core Version:    0.7.0.1
 */