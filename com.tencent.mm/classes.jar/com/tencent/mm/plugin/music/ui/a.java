package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.av.e;
import com.tencent.mm.h.a.jx;
import com.tencent.mm.h.a.jx.b;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private c giK;
  private TextView mBq;
  
  public a(Context paramContext)
  {
    super(paramContext);
    if (this.view != null)
    {
      this.mBq = ((TextView)this.view.findViewById(a.d.music_banner_text_view));
      this.mBq.setTextSize(0, com.tencent.mm.cb.a.aa(ae.getContext(), a.b.HintTextSize));
      this.view.setOnClickListener(new a.1(this));
    }
    this.giK = new a.2(this);
    com.tencent.mm.sdk.b.a.udP.c(this.giK);
  }
  
  private boolean bnP()
  {
    int i = 8;
    boolean bool = false;
    if (com.tencent.mm.av.a.Pu())
    {
      localObject = com.tencent.mm.av.a.Pw();
      String str = ae.getContext().getString(a.f.music_detail_playing) + ae.getContext().getString(a.f.music_detail_split) + ((e)localObject).euz;
      if (this.mBq != null) {
        this.mBq.setText(str);
      }
      if (((e)localObject).euT) {}
      for (;;)
      {
        setVisibility(i);
        if (!((e)localObject).euT) {
          bool = true;
        }
        return bool;
        i = 0;
      }
    }
    Object localObject = new jx();
    ((jx)localObject).bSs.action = 10;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (((jx)localObject).bSt.bFQ)
    {
      setVisibility(0);
      return true;
    }
    setVisibility(8);
    return false;
  }
  
  public final boolean apu()
  {
    return bnP();
  }
  
  public final void destroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
  }
  
  public final int getLayoutId()
  {
    return a.e.music_banner_view;
  }
  
  public final int getOrder()
  {
    return 1;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (this.view != null) {
      this.view.findViewById(a.d.music_banner_view).setVisibility(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a
 * JD-Core Version:    0.7.0.1
 */