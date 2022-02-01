package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.vfs.u;

public final class g
  extends c
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String baE(String paramString)
  {
    return paramString;
  }
  
  public final boolean fPQ()
  {
    AppMethodBeat.i(96072);
    if ((this.KcA != null) && (!TextUtils.isEmpty(this.KcA.JRp))) {}
    for (String str = this.KcA.JRp;; str = t.i(this.fVT))
    {
      u.bj(this.KcA.getPath(), this.KcA.fPO(), str);
      AppMethodBeat.o(96072);
      return true;
    }
  }
  
  protected final int getMediaType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.g
 * JD-Core Version:    0.7.0.1
 */