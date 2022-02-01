package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.List;

public final class t
  extends s
{
  private HashSet<String> KJP;
  
  public t(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    AppMethodBeat.i(102890);
    this.KJP = new HashSet();
    if (!bu.isNullOrNil(paramString))
    {
      this.KJP.addAll(bu.U(paramString.split(",")));
      ae.i("MicroMsg.MMSearchSportContactAdapter", "matchUsernameSet %s", new Object[] { Integer.valueOf(this.KJP.size()) });
    }
    AppMethodBeat.o(102890);
  }
  
  protected final void iG(List<m> paramList)
  {
    AppMethodBeat.i(102891);
    super.iG(paramList);
    if (this.KJP.size() > 0)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        m localm = (m)paramList.get(i);
        if (!this.KJP.contains(localm.tEY)) {
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