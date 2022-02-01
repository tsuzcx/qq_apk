package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.protocal.protobuf.fdv;

public final class m
  implements a
{
  public fdv Qsv;
  public String Rcl = "";
  public String Rcm = "";
  public View Rcn;
  public String Rco;
  public String Rcp;
  public String UserName = "";
  public String nUB = "";
  public int scene = -1;
  public Object tag;
  
  public m(String paramString1, String paramString2, fdv paramfdv, String paramString3, String paramString4, View paramView, int paramInt, String paramString5, String paramString6)
  {
    this.Rcl = paramString1;
    this.Rcm = paramString2;
    this.Qsv = paramfdv;
    this.UserName = paramString3;
    this.nUB = paramString4;
    this.Rcn = paramView;
    this.Rco = paramString5;
    this.scene = paramInt;
    this.Rcp = paramString6;
  }
  
  public final String getUserName()
  {
    if (this.Qsv == null) {
      return null;
    }
    return this.Qsv.Username;
  }
  
  public final int hlN()
  {
    return 3;
  }
  
  public final String hlO()
  {
    AppMethodBeat.i(308153);
    String str = String.format("%s_%s", new Object[] { this.Rcp, Integer.valueOf(this.Qsv.abDh) });
    AppMethodBeat.o(308153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */