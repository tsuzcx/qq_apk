package com.tencent.mm.plugin.sns.ui.a;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.u;
import java.util.List;

public final class b
  extends u
{
  public View.OnClickListener RGB = null;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
  }
  
  public final com.tencent.mm.ui.contact.a.a Py(int paramInt)
  {
    AppMethodBeat.i(99812);
    int i = this.afbN;
    com.tencent.mm.plugin.sns.ui.a.a.a locala = new com.tencent.mm.plugin.sns.ui.a.a.a(paramInt);
    locala.query = this.query;
    locala.RGB = this.RGB;
    locala.rpp = ((o)this.Hwr.get(paramInt - i - 1));
    locala.afey = gZe();
    AppMethodBeat.o(99812);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b
 * JD-Core Version:    0.7.0.1
 */