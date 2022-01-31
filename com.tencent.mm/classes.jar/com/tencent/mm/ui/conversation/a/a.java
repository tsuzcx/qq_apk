package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  int arO = 0;
  private View hNa = null;
  b vUh;
  private d vUi;
  a.a vUj;
  
  public a(Context paramContext)
  {
    super(paramContext);
    if (this.view != null)
    {
      this.hNa = this.view.findViewById(R.h.adlist);
      this.vUi = new d();
      this.vUi.vUn = this.hNa;
      this.vUi.vUo = ((Button)this.view.findViewById(R.h.ad_close));
      this.vUi.vUo.setOnClickListener(new a.1(this));
      this.hNa.setOnClickListener(new a.2(this));
    }
  }
  
  public final boolean apu()
  {
    this.vUh = new b((Context)this.sdy.get());
    this.vUj = new a.3(this);
    com.tencent.mm.pluginsdk.h.a.a locala = com.tencent.mm.pluginsdk.h.a.a.eW(ae.getContext());
    if (this.vUh != null)
    {
      if (locala != null)
      {
        this.vUh.vUl = locala;
        this.vUh.yc();
        if ((this.vUh != null) && (this.vUh.getCount() > 0) && (this.vUh.HT(0).a(this.vUi) == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          y.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
          setVisibility(0);
          return true;
        }
      }
      setVisibility(8);
    }
    setVisibility(8);
    return false;
  }
  
  public final void destroy()
  {
    if (g.DN().Dc())
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().b(this.vUh);
    }
  }
  
  public final int getLayoutId()
  {
    return R.i.adlist_item;
  }
  
  public final void release()
  {
    this.vUh = null;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.hNa != null) {
      this.hNa.setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */