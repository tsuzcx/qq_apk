package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.vfs.y;

public final class i
  extends c
{
  public i(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String aYY(String paramString)
  {
    return paramString;
  }
  
  protected final int getMediaType()
  {
    return 2;
  }
  
  public final boolean hhI()
  {
    AppMethodBeat.i(96072);
    if ((this.QzS != null) && (!TextUtils.isEmpty(this.QzS.Qoa))) {}
    for (String str = this.QzS.Qoa;; str = t.i(this.ibT))
    {
      y.bF(this.QzS.getPath(), this.QzS.hhG(), str);
      AppMethodBeat.o(96072);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.i
 * JD-Core Version:    0.7.0.1
 */