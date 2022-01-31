package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.storage.ac.a;

final class SightSettingsUI$b
{
  public String oQE;
  String[] oQF;
  int[] oQG;
  ac.a oQH;
  
  public SightSettingsUI$b(SightSettingsUI paramSightSettingsUI, String paramString, ac.a parama, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.oQE = paramString;
    this.oQF = paramArrayOfString;
    this.oQH = parama;
    this.oQG = paramArrayOfInt;
  }
  
  final String zC(int paramInt)
  {
    int i = 0;
    while (i < this.oQG.length)
    {
      if ((paramInt == this.oQG[i]) && (i < this.oQF.length)) {
        return this.oQF[i];
      }
      i += 1;
    }
    return this.oQF[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b
 * JD-Core Version:    0.7.0.1
 */