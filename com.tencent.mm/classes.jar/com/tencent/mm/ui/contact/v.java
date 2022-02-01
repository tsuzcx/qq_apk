package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.List;

public final class v
  extends u
{
  private HashSet<String> affm;
  
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    AppMethodBeat.i(102890);
    this.affm = new HashSet();
    if (!Util.isNullOrNil(paramString))
    {
      this.affm.addAll(Util.stringsToList(paramString.split(",")));
      Log.i("MicroMsg.MMSearchSportContactAdapter", "matchUsernameSet %s", new Object[] { Integer.valueOf(this.affm.size()) });
    }
    AppMethodBeat.o(102890);
  }
  
  protected final void nV(List<o> paramList)
  {
    AppMethodBeat.i(102891);
    super.nV(paramList);
    if (this.affm.size() > 0)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        o localo = (o)paramList.get(i);
        if (!this.affm.contains(localo.Hsz)) {
          paramList.remove(i);
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(102891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.v
 * JD-Core Version:    0.7.0.1
 */