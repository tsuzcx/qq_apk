package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.List;

public final class t
  extends s
{
  private HashSet<String> IwN;
  
  public t(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    AppMethodBeat.i(102890);
    this.IwN = new HashSet();
    if (!bs.isNullOrNil(paramString))
    {
      this.IwN.addAll(bs.S(paramString.split(",")));
      ac.i("MicroMsg.MMSearchSportContactAdapter", "matchUsernameSet %s", new Object[] { Integer.valueOf(this.IwN.size()) });
    }
    AppMethodBeat.o(102890);
  }
  
  protected final void ik(List<m> paramList)
  {
    AppMethodBeat.i(102891);
    super.ik(paramList);
    if (this.IwN.size() > 0)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        m localm = (m)paramList.get(i);
        if (!this.IwN.contains(localm.sxG)) {
          paramList.remove(i);
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(102891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.t
 * JD-Core Version:    0.7.0.1
 */