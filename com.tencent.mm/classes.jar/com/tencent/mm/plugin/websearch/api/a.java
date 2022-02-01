package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.fvd;
import java.util.LinkedList;

public abstract class a
  extends p
{
  protected String HQI;
  protected int Sc;
  protected int WnM;
  protected Bundle WnN;
  protected String hVo;
  protected int mScene;
  
  public final void asT(int paramInt)
  {
    this.WnM = paramInt;
  }
  
  public final void biq(String paramString)
  {
    this.hVo = paramString;
  }
  
  public void cg(LinkedList<fvd> paramLinkedList) {}
  
  public final String getKeyword()
  {
    return this.HQI;
  }
  
  public final int ipD()
  {
    return this.WnM;
  }
  
  public final boolean ipE()
  {
    return this.Sc == 0;
  }
  
  public final Bundle ipF()
  {
    return this.WnN;
  }
  
  public abstract String ipG();
  
  public abstract int ipH();
  
  public final String ipI()
  {
    return this.hVo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */