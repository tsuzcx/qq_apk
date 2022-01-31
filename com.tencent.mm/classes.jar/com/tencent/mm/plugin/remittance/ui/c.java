package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.b.e.a;

public final class c
{
  Context mContext;
  c.a qkY;
  private sn qka;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(v paramv, sn paramsn, c.a parama)
  {
    AppMethodBeat.i(142138);
    this.qkY = parama;
    this.qka = paramsn;
    Object localObject = View.inflate(this.mContext, 2130970523, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131827073);
    parama = (EditText)((View)localObject).findViewById(2131827072);
    ((MMNeat7extView)((View)localObject).findViewById(2131820946)).af(this.qka.cyA);
    localTextView.setText(paramsn.ppA);
    paramsn = new e.a(this.mContext);
    paramsn.aj(this.qka.title).fv((View)localObject);
    localObject = com.tencent.mm.ui.tools.b.c.d(parama);
    ((com.tencent.mm.ui.tools.b.c)localObject).jmp = f.a.Avm;
    localObject = ((com.tencent.mm.ui.tools.b.c)localObject).hR(1, 1);
    ((com.tencent.mm.ui.tools.b.c)localObject).AyD = false;
    ((com.tencent.mm.ui.tools.b.c)localObject).a(null);
    al.p(new c.1(this, parama), 200L);
    localObject = new bv();
    ((bv)localObject).cYX = paramv.okH;
    localObject = ((bv)localObject).gR(paramv.username);
    ((bv)localObject).cYR = 1L;
    ((bv)localObject).ake();
    paramsn.c(new c.2(this, paramv, parama)).show();
    AppMethodBeat.o(142138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.c
 * JD-Core Version:    0.7.0.1
 */