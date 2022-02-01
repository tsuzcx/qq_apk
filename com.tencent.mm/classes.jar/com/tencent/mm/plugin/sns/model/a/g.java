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
  
  public final String apd(String paramString)
  {
    return paramString;
  }
  
  public final boolean duv()
  {
    AppMethodBeat.i(96072);
    if ((this.wLz != null) && (!TextUtils.isEmpty(this.wLz.wBf))) {}
    for (String str = this.wLz.wBf;; str = q.i(this.dyS))
    {
      i.aQ(this.wLz.getPath(), this.wLz.dut(), str);
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