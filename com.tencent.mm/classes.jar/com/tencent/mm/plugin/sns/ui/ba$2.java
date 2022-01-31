package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

final class ba$2
  implements a.a
{
  ba$2(ba paramba) {}
  
  public final String Pj(String paramString)
  {
    paramString = g.o((this.piF.filePath + System.currentTimeMillis()).getBytes());
    return af.getAccSnsTmpPath() + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.2
 * JD-Core Version:    0.7.0.1
 */