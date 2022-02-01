package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.daa;

public final class m
  implements a
{
  public String hkR = "";
  public String ncR = "";
  public int scene = -1;
  public Object tag;
  public daa xRC;
  public String yyG = "";
  public String yyH = "";
  public View yyI;
  
  public m(String paramString1, String paramString2, daa paramdaa, String paramString3, String paramString4, View paramView, int paramInt)
  {
    this.yyG = paramString1;
    this.yyH = paramString2;
    this.xRC = paramdaa;
    this.ncR = paramString3;
    this.hkR = paramString4;
    this.yyI = paramView;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.xRC == null) {
      return null;
    }
    return this.xRC.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */