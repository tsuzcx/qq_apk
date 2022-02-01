package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.ejo;

public final class m
  implements a
{
  public ejo JVu;
  public String KCD = "";
  public String KCE = "";
  public View KCF;
  public String KCG;
  public String UserName = "";
  public String lpy = "";
  public int scene = -1;
  public Object tag;
  
  public m(String paramString1, String paramString2, ejo paramejo, String paramString3, String paramString4, View paramView, int paramInt, String paramString5)
  {
    this.KCD = paramString1;
    this.KCE = paramString2;
    this.JVu = paramejo;
    this.UserName = paramString3;
    this.lpy = paramString4;
    this.KCF = paramView;
    this.KCG = paramString5;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.JVu == null) {
      return null;
    }
    return this.JVu.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */