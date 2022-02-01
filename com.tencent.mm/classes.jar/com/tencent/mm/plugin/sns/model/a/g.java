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
  
  public final String azv(String paramString)
  {
    return paramString;
  }
  
  public final boolean dVi()
  {
    AppMethodBeat.i(96072);
    if ((this.zoe != null) && (!TextUtils.isEmpty(this.zoe.zdu))) {}
    for (String str = this.zoe.zdu;; str = q.i(this.dIQ))
    {
      i.bb(this.zoe.getPath(), this.zoe.dVg(), str);
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