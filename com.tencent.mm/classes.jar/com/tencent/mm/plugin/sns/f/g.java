package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import java.util.List;

public final class g
  implements f
{
  h owM;
  
  public final boolean bEy()
  {
    return (this.owM != null) && (this.owM.owB.size() != 0);
  }
  
  public final h bEz()
  {
    if ((this.owM == null) || (this.owM.owB.size() == 0)) {
      return null;
    }
    return this.owM;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.g
 * JD-Core Version:    0.7.0.1
 */