package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class b
{
  LinearLayout nXC;
  LinearLayout nXD;
  LinearLayout nXE;
  LinearLayout nXF;
  LinearLayout nXG;
  
  public final void Mt(String paramString)
  {
    if (paramString.equals("downloading"))
    {
      this.nXC.setVisibility(0);
      this.nXD.setVisibility(8);
      this.nXE.setVisibility(8);
      this.nXF.setVisibility(8);
      this.nXG.setVisibility(8);
    }
    do
    {
      return;
      if (paramString.equals("downloaded"))
      {
        this.nXC.setVisibility(8);
        this.nXD.setVisibility(0);
        this.nXE.setVisibility(8);
        this.nXF.setVisibility(8);
        this.nXG.setVisibility(8);
        return;
      }
      if (paramString.equals("undownloaded"))
      {
        this.nXC.setVisibility(8);
        this.nXD.setVisibility(8);
        this.nXE.setVisibility(0);
        this.nXF.setVisibility(8);
        this.nXG.setVisibility(8);
        return;
      }
      if (paramString.equals("using"))
      {
        this.nXC.setVisibility(8);
        this.nXD.setVisibility(8);
        this.nXE.setVisibility(8);
        this.nXF.setVisibility(0);
        this.nXG.setVisibility(8);
        return;
      }
    } while (!paramString.equals("canceling"));
    this.nXC.setVisibility(8);
    this.nXD.setVisibility(8);
    this.nXE.setVisibility(8);
    this.nXF.setVisibility(8);
    this.nXG.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */