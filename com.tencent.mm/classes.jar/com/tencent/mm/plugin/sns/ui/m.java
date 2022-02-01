package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.dzo;

public final class m
  implements a
{
  public dzo DIu;
  public String Epu = "";
  public String Epv = "";
  public View Epw;
  public String Epx;
  public String UserName = "";
  public String iAc = "";
  public int scene = -1;
  public Object tag;
  
  public m(String paramString1, String paramString2, dzo paramdzo, String paramString3, String paramString4, View paramView, int paramInt, String paramString5)
  {
    this.Epu = paramString1;
    this.Epv = paramString2;
    this.DIu = paramdzo;
    this.UserName = paramString3;
    this.iAc = paramString4;
    this.Epw = paramView;
    this.Epx = paramString5;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.DIu == null) {
      return null;
    }
    return this.DIu.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */