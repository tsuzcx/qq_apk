package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ak.n;
import com.tencent.mm.protocal.protobuf.doh;
import java.util.LinkedList;

public abstract class a
  extends n
{
  protected int BYb;
  protected Bundle BYc;
  protected int MW;
  protected String drg;
  protected int mScene;
  protected String sTA;
  
  public final void Ug(int paramInt)
  {
    this.BYb = paramInt;
  }
  
  public void ba(LinkedList<doh> paramLinkedList) {}
  
  public final String cKv()
  {
    return this.sTA;
  }
  
  public final int ewW()
  {
    return this.BYb;
  }
  
  public final boolean ewX()
  {
    return this.MW == 0;
  }
  
  public final Bundle ewY()
  {
    return this.BYc;
  }
  
  public abstract String ewZ();
  
  public abstract int exa();
  
  public final String exb()
  {
    return this.drg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */