package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.List;

public final class t
  extends s
{
  private HashSet<String> Knv;
  
  public t(MMBaseSelectContactUI paramMMBaseSelectContactUI, List<String> paramList, boolean paramBoolean, String paramString)
  {
    super(paramMMBaseSelectContactUI, paramList, paramBoolean, 0);
    AppMethodBeat.i(102890);
    this.Knv = new HashSet();
    if (!bt.isNullOrNil(paramString))
    {
      this.Knv.addAll(bt.U(paramString.split(",")));
      ad.i("MicroMsg.MMSearchSportContactAdapter", "matchUsernameSet %s", new Object[] { Integer.valueOf(this.Knv.size()) });
    }
    AppMethodBeat.o(102890);
  }
  
  protected final void iw(List<m> paramList)
  {
    AppMethodBeat.i(102891);
    super.iw(paramList);
    if (this.Knv.size() > 0)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        m localm = (m)paramList.get(i);
        if (!this.Knv.contains(localm.tuh)) {
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