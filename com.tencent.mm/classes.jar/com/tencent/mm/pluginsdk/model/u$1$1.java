package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.x5.sdk.d.a;

final class u$1$1
  implements d.a
{
  u$1$1(u.1 param1) {}
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    y.i("MicroMsg.TBSFileBrowseHelper", "tbs preInit callback, %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      u.fR(this.rTT.val$filePath, this.rTT.rTS);
      return;
    }
    u.fQ(this.rTT.val$filePath, this.rTT.rTS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u.1.1
 * JD-Core Version:    0.7.0.1
 */