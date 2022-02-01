package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.dty;
import java.util.LinkedList;

public abstract class a
  extends n
{
  protected int DAT;
  protected Bundle DAU;
  protected String dCX;
  protected int fq;
  protected int mScene;
  protected String tQe;
  
  public final void VZ(int paramInt)
  {
    this.DAT = paramInt;
  }
  
  public void bb(LinkedList<dty> paramLinkedList) {}
  
  public final String cSK()
  {
    return this.tQe;
  }
  
  public final int eLK()
  {
    return this.DAT;
  }
  
  public final boolean eLL()
  {
    return this.fq == 0;
  }
  
  public final Bundle eLM()
  {
    return this.DAU;
  }
  
  public abstract String eLN();
  
  public abstract int eLO();
  
  public final String eLP()
  {
    return this.dCX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */