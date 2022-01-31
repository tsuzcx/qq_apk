package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.b.c.a.b;

public final class g$a
{
  public c gwf;
  public DialogInterface.OnDismissListener jiU;
  Context mContext;
  final c.a vTt;
  String vTu;
  
  public g$a(Context paramContext)
  {
    AppMethodBeat.i(27657);
    this.vTu = null;
    this.mContext = paramContext;
    this.vTt = new c.a(this.mContext);
    this.vTt.rG(false);
    this.vTt.rH(false);
    this.vTt.a(new g.a.1(this));
    AppMethodBeat.o(27657);
  }
  
  public final a LU(int paramInt)
  {
    AppMethodBeat.i(27668);
    this.vTu = this.mContext.getResources().getString(paramInt);
    AppMethodBeat.o(27668);
    return this;
  }
  
  public final a a(q.a parama)
  {
    AppMethodBeat.i(27669);
    this.gwf = this.vTt.aLZ();
    if (this.jiU != null) {
      this.gwf.setOnDismissListener(this.jiU);
    }
    g.a(this.mContext, this.gwf, this.vTu, parama, parama);
    AppMethodBeat.o(27669);
    return this;
  }
  
  public final a a(c.a.b paramb)
  {
    AppMethodBeat.i(27664);
    this.vTt.c(paramb);
    AppMethodBeat.o(27664);
    return this;
  }
  
  public final a amm(String paramString)
  {
    AppMethodBeat.i(27660);
    int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, (int)(14.0F * com.tencent.mm.cb.a.dr(this.mContext)));
    if (!bo.isNullOrNil(paramString))
    {
      paramString = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, paramString.toString(), i);
      this.vTt.ai(paramString);
    }
    AppMethodBeat.o(27660);
    return this;
  }
  
  public final a amn(String paramString)
  {
    AppMethodBeat.i(27661);
    this.vTt.avo(paramString);
    AppMethodBeat.o(27661);
    return this;
  }
  
  public final a amo(String paramString)
  {
    AppMethodBeat.i(27663);
    g.a(this.mContext, this.vTt, paramString);
    this.vTt.rE(false);
    AppMethodBeat.o(27663);
    return this;
  }
  
  public final a cq(Object paramObject)
  {
    AppMethodBeat.i(27658);
    g.b(this.mContext, this.vTt, paramObject);
    this.vTt.rE(true);
    AppMethodBeat.o(27658);
    return this;
  }
  
  public final a d(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(27662);
    this.vTt.a(paramBitmap, true, paramInt);
    this.vTt.rE(false);
    g.b(this.vTt, paramBitmap);
    AppMethodBeat.o(27662);
    return this;
  }
  
  public final a dnA()
  {
    AppMethodBeat.i(27667);
    this.vTt.rE(false);
    AppMethodBeat.o(27667);
    return this;
  }
  
  public final a dny()
  {
    AppMethodBeat.i(27659);
    this.vTt.Rg(2);
    AppMethodBeat.o(27659);
    return this;
  }
  
  public final a dnz()
  {
    this.vTt.AGP.AGj = 8;
    return this;
  }
  
  public final a eC(View paramView)
  {
    AppMethodBeat.i(27665);
    this.vTt.fu(paramView);
    AppMethodBeat.o(27665);
    return this;
  }
  
  public final a i(Boolean paramBoolean)
  {
    AppMethodBeat.i(27666);
    this.vTt.rF(paramBoolean.booleanValue());
    if (paramBoolean.booleanValue()) {
      this.vTt.avq(this.mContext.getString(2131298500));
    }
    AppMethodBeat.o(27666);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.a
 * JD-Core Version:    0.7.0.1
 */