package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.cpj;
import java.util.LinkedList;

public abstract class a
  extends m
{
  protected int Fb;
  protected String cCX;
  protected int mScene;
  protected int uIB;
  protected String uIC;
  protected Bundle uID;
  
  public final void IX(int paramInt)
  {
    this.uIB = paramInt;
  }
  
  public void aB(LinkedList<cpj> paramLinkedList) {}
  
  public abstract String act();
  
  public abstract int acu();
  
  public final String bBW()
  {
    return this.uIC;
  }
  
  public final int cZa()
  {
    return this.uIB;
  }
  
  public final boolean cZb()
  {
    return this.Fb == 0;
  }
  
  public final Bundle cZc()
  {
    return this.uID;
  }
  
  public final String cZd()
  {
    return this.cCX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */