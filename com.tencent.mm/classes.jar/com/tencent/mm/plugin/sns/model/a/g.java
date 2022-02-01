package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.vfs.o;

public final class g
  extends c
{
  public g(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  public final String aAM(String paramString)
  {
    return paramString;
  }
  
  public final boolean dYJ()
  {
    AppMethodBeat.i(96072);
    if ((this.zFt != null) && (!TextUtils.isEmpty(this.zFt.zuk))) {}
    for (String str = this.zFt.zuk;; str = r.i(this.dKe))
    {
      o.bc(this.zFt.getPath(), this.zFt.dYH(), str);
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