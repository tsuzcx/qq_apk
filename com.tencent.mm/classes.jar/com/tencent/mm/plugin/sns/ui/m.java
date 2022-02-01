package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.dfn;

public final class m
  implements a
{
  public String hDa = "";
  public String nDo = "";
  public int scene = -1;
  public Object tag;
  public String zPR = "";
  public String zPS = "";
  public View zPT;
  public String zPU;
  public dfn zhw;
  
  public m(String paramString1, String paramString2, dfn paramdfn, String paramString3, String paramString4, View paramView, int paramInt, String paramString5)
  {
    this.zPR = paramString1;
    this.zPS = paramString2;
    this.zhw = paramdfn;
    this.nDo = paramString3;
    this.hDa = paramString4;
    this.zPT = paramView;
    this.zPU = paramString5;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.zhw == null) {
      return null;
    }
    return this.zhw.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */