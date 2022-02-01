package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.vfs.i;

public final class g
  extends c
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String aup(String paramString)
  {
    return paramString;
  }
  
  public final boolean dIV()
  {
    AppMethodBeat.i(96072);
    if ((this.xYf != null) && (!TextUtils.isEmpty(this.xYf.xNA))) {}
    for (String str = this.xYf.xNA;; str = q.i(this.dwE))
    {
      i.aT(this.xYf.getPath(), this.xYf.dIT(), str);
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