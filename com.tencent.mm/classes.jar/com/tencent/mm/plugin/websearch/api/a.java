package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.ezc;
import java.util.LinkedList;

public abstract class a
  extends q
{
  protected String CeE;
  protected int PxG;
  protected Bundle PxH;
  protected String fPt;
  protected int mScene;
  protected int zP;
  
  public final void anc(int paramInt)
  {
    this.PxG = paramInt;
  }
  
  public void bV(LinkedList<ezc> paramLinkedList) {}
  
  public final void biI(String paramString)
  {
    this.fPt = paramString;
  }
  
  public final int gQm()
  {
    return this.PxG;
  }
  
  public final boolean gQn()
  {
    return this.zP == 0;
  }
  
  public final Bundle gQo()
  {
    return this.PxH;
  }
  
  public abstract String gQp();
  
  public abstract int gQq();
  
  public final String gQr()
  {
    return this.fPt;
  }
  
  public final String getKeyword()
  {
    return this.CeE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */