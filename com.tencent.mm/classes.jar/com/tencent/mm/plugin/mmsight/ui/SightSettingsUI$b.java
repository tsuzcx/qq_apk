package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.storage.ac.a;

final class SightSettingsUI$b
{
  public String mqP;
  String[] mqQ;
  int[] mqR;
  ac.a mqS;
  
  public SightSettingsUI$b(SightSettingsUI paramSightSettingsUI, String paramString, ac.a parama, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mqP = paramString;
    this.mqQ = paramArrayOfString;
    this.mqS = parama;
    this.mqR = paramArrayOfInt;
  }
  
  final String ul(int paramInt)
  {
    int i = 0;
    while (i < this.mqR.length)
    {
      if ((paramInt == this.mqR[i]) && (i < this.mqQ.length)) {
        return this.mqQ[i];
      }
      i += 1;
    }
    return this.mqQ[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b
 * JD-Core Version:    0.7.0.1
 */