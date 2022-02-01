package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.dis;
import java.util.LinkedList;

public abstract class a
  extends n
{
  protected int AFI;
  protected Bundle AFJ;
  protected int LZ;
  protected String dtx;
  protected int mScene;
  protected String rLL;
  
  public final void RW(int paramInt)
  {
    this.AFI = paramInt;
  }
  
  public void aT(LinkedList<dis> paramLinkedList) {}
  
  public final String cxj()
  {
    return this.rLL;
  }
  
  public final int ehC()
  {
    return this.AFI;
  }
  
  public final boolean ehD()
  {
    return this.LZ == 0;
  }
  
  public final Bundle ehE()
  {
    return this.AFJ;
  }
  
  public abstract String ehF();
  
  public abstract int ehG();
  
  public final String ehH()
  {
    return this.dtx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */