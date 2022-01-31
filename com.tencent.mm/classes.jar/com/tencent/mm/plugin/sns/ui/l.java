package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.cds;

public final class l
  implements a
{
  public String jJA = "";
  public String ntu = "";
  public String rFX = "";
  public String rFY = "";
  public View rFZ;
  public cds reJ;
  public int scene = -1;
  public Object tag;
  
  public l(String paramString1, String paramString2, cds paramcds, String paramString3, String paramString4, View paramView, int paramInt)
  {
    this.rFX = paramString1;
    this.rFY = paramString2;
    this.reJ = paramcds;
    this.jJA = paramString3;
    this.ntu = paramString4;
    this.rFZ = paramView;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.reJ == null) {
      return null;
    }
    return this.reJ.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.l
 * JD-Core Version:    0.7.0.1
 */