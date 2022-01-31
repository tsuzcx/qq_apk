package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.k;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class a
  extends k
{
  ay.a pKX = new ay.a();
  ay.b pKY = new ay.b();
  
  protected final k.d HE()
  {
    return this.pKX;
  }
  
  public final k.e HF()
  {
    return this.pKY;
  }
  
  public final int Kq()
  {
    return 1;
  }
  
  public final int getType()
  {
    return 616;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.a
 * JD-Core Version:    0.7.0.1
 */