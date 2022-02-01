package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.vfs.s;

public final class g
  extends c
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String aPI(String paramString)
  {
    return paramString;
  }
  
  public final boolean fbX()
  {
    AppMethodBeat.i(96072);
    if ((this.DPt != null) && (!TextUtils.isEmpty(this.DPt.DEu))) {}
    for (String str = this.DPt.DEu;; str = r.j(this.ebR))
    {
      s.bo(this.DPt.getPath(), this.DPt.fbV(), str);
      AppMethodBeat.o(96072);
      return true;
    }
  }
  
  protected final int getMediaType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.g
 * JD-Core Version:    0.7.0.1
 */