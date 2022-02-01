package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.eou;
import java.util.LinkedList;

public abstract class a
  extends q
{
  protected int IDq;
  protected Bundle IDr;
  protected String dVP;
  protected int fs;
  protected int mScene;
  protected String xsj;
  
  public final void aWX(String paramString)
  {
    this.dVP = paramString;
  }
  
  public final void afo(int paramInt)
  {
    this.IDq = paramInt;
  }
  
  public void by(LinkedList<eou> paramLinkedList) {}
  
  public final boolean fXA()
  {
    return this.fs == 0;
  }
  
  public final Bundle fXB()
  {
    return this.IDr;
  }
  
  public abstract String fXC();
  
  public abstract int fXD();
  
  public final String fXE()
  {
    return this.dVP;
  }
  
  public final int fXz()
  {
    return this.IDq;
  }
  
  public final String getKeyword()
  {
    return this.xsj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */