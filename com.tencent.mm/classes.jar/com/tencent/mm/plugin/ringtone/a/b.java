package com.tencent.mm.plugin.ringtone.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.g.d;

public final class b
{
  public d OBS;
  public int OBT;
  public boolean OBU;
  public int OBV;
  public int cXK;
  
  public b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, d paramd)
  {
    this.OBV = paramInt1;
    this.cXK = paramInt2;
    this.OBT = paramInt3;
    this.OBU = paramBoolean;
    this.OBS = paramd;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(272786);
    int i;
    long l;
    if (this.OBV == 1)
    {
      if (this.OBS == null) {
        break label99;
      }
      i = this.OBS.ODC;
      if (i != 0) {}
    }
    else
    {
      if ((this.OBV != 2) || (this.OBU)) {
        break label116;
      }
      if (this.OBS == null) {
        break label104;
      }
      l = this.OBS.mIH;
      label62:
      if (l == 0L) {
        break label116;
      }
      if (this.OBS == null) {
        break label109;
      }
    }
    label99:
    label104:
    label109:
    for (String str = this.OBS.LYS;; str = "")
    {
      if (str.isEmpty()) {
        break label116;
      }
      AppMethodBeat.o(272786);
      return true;
      i = 0;
      break;
      l = 0L;
      break label62;
    }
    label116:
    AppMethodBeat.o(272786);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.a.b
 * JD-Core Version:    0.7.0.1
 */