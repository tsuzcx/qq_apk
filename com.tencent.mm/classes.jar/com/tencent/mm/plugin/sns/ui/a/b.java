package com.tencent.mm.plugin.sns.ui.a;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.s;
import java.util.List;

public final class b
  extends s
{
  public View.OnClickListener Arb = null;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
  }
  
  public final com.tencent.mm.ui.contact.a.a Rx(int paramInt)
  {
    AppMethodBeat.i(99812);
    int i = this.Kki;
    com.tencent.mm.plugin.sns.ui.a.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
    locala.query = this.query;
    locala.Arb = this.Arb;
    locala.kjY = ((m)this.txG.get(paramInt - i - 1));
    locala.KmP = dQK();
    AppMethodBeat.o(99812);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b
 * JD-Core Version:    0.7.0.1
 */