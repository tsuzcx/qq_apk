package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.duv;
import java.util.LinkedList;

public abstract class a
  extends n
{
  protected int DSQ;
  protected Bundle DSR;
  protected String dEc;
  protected int fq;
  protected int mScene;
  protected String uaV;
  
  public final void WG(int paramInt)
  {
    this.DSQ = paramInt;
  }
  
  public void bc(LinkedList<duv> paramLinkedList) {}
  
  public final String cVp()
  {
    return this.uaV;
  }
  
  public final int ePt()
  {
    return this.DSQ;
  }
  
  public final boolean ePu()
  {
    return this.fq == 0;
  }
  
  public final Bundle ePv()
  {
    return this.DSR;
  }
  
  public abstract String ePw();
  
  public abstract int ePx();
  
  public final String ePy()
  {
    return this.dEc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */