package com.tencent.mm.plugin.sns.ui.a;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import java.util.List;

public final class b
  extends r
{
  public View.OnClickListener sdq = null;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
  }
  
  public final com.tencent.mm.ui.contact.a.a Ff(int paramInt)
  {
    AppMethodBeat.i(145680);
    int i = this.AaZ;
    com.tencent.mm.plugin.sns.ui.a.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
    locala.query = this.query;
    locala.sdq = this.sdq;
    locala.hrL = ((l)this.mVt.get(paramInt - i - 1));
    locala.Adl = cni();
    AppMethodBeat.o(145680);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b
 * JD-Core Version:    0.7.0.1
 */