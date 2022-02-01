package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.c.a;
import com.tencent.mm.protocal.protobuf.cuo;

public final class m
  implements a
{
  public String gKr = "";
  public String mAQ = "";
  public int scene = -1;
  public Object tag;
  public cuo wFh;
  public String xlO = "";
  public String xlP = "";
  public View xlQ;
  
  public m(String paramString1, String paramString2, cuo paramcuo, String paramString3, String paramString4, View paramView, int paramInt)
  {
    this.xlO = paramString1;
    this.xlP = paramString2;
    this.wFh = paramcuo;
    this.mAQ = paramString3;
    this.gKr = paramString4;
    this.xlQ = paramView;
    this.scene = paramInt;
  }
  
  public final String getUserName()
  {
    if (this.wFh == null) {
      return null;
    }
    return this.wFh.Username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.m
 * JD-Core Version:    0.7.0.1
 */