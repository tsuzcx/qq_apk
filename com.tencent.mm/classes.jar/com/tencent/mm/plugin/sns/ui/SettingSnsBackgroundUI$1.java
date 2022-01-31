package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.ui.tools.a.a;

final class SettingSnsBackgroundUI$1
  implements a.a
{
  SettingSnsBackgroundUI$1(SettingSnsBackgroundUI paramSettingSnsBackgroundUI) {}
  
  public final String acd(String paramString)
  {
    AppMethodBeat.i(38553);
    paramString = g.w((this.rLd.filePath + System.currentTimeMillis()).getBytes());
    paramString = ag.getAccSnsTmpPath() + paramString;
    AppMethodBeat.o(38553);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.1
 * JD-Core Version:    0.7.0.1
 */