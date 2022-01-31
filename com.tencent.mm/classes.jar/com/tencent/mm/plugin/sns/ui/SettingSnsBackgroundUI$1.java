package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.ui.tools.a.a;

final class SettingSnsBackgroundUI$1
  implements a.a
{
  SettingSnsBackgroundUI$1(SettingSnsBackgroundUI paramSettingSnsBackgroundUI) {}
  
  public final String Pj(String paramString)
  {
    paramString = g.o((this.oTg.filePath + System.currentTimeMillis()).getBytes());
    return af.getAccSnsTmpPath() + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI.1
 * JD-Core Version:    0.7.0.1
 */