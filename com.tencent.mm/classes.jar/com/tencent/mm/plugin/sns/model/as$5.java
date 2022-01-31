package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.Map;

final class as$5
  implements Runnable
{
  as$5(as paramas, String paramString, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(36649);
    o.alF().j(this.riH, this.fzu);
    if ((this.riG.riB != null) && (bo.isEqual(this.riG.riB.fVf, this.riH))) {
      as.a(this.riG);
    }
    az localaz = (az)this.riG.riD.get(this.riH);
    this.riG.riC.remove(localaz);
    AppMethodBeat.o(36649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.5
 * JD-Core Version:    0.7.0.1
 */