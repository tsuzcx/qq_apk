package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.dgh;

public final class m
  implements a
{
  public String AgY = "";
  public String AgZ = "";
  public View Aha;
  public String Ahb;
  public String hFS = "";
  public String nIJ = "";
  public int scene = -1;
  public Object tag;
  public dgh zyl;
  
  public m(String paramString1, String paramString2, dgh paramdgh, String paramString3, String paramString4, View paramView, int paramInt, String paramString5)
  {
    this.AgY = paramString1;
    this.AgZ = paramString2;
    this.zyl = paramdgh;
    this.nIJ = paramString3;
    this.hFS = paramString4;
    this.Aha = paramView;
    this.Ahb = paramString5;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.zyl == null) {
      return null;
    }
    return this.zyl.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */