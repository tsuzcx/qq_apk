package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.a.e;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class a$2
  implements View.OnLongClickListener
{
  private Context context;
  private g jZN;
  private b nut;
  private xv nuu;
  private String path;
  
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    if (paramView != null)
    {
      this.context = paramView.getContext();
      this.nut = ((b)paramView.getTag());
      this.jZN = this.nut.khA;
      this.nuu = this.nut.bNt;
    }
    paramView = new gf();
    paramView.bNF.type = 2;
    paramView.bNF.bNH = this.nut.bNt;
    com.tencent.mm.sdk.b.a.udP.m(paramView);
    this.path = paramView.bNG.path;
    if (!e.bK(this.path))
    {
      y.w("MicroMsg.ImageViewWrapper", "file not exists");
      return true;
    }
    if (this.nus.gvM == null) {
      this.nus.gvM = new j(this.context);
    }
    this.nus.gvM.phH = new a.2.1(this);
    this.nus.gvM.phI = new a.2.2(this);
    this.nus.gvM.bJQ();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2
 * JD-Core Version:    0.7.0.1
 */