package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.protocal.c.ccd;
import java.util.LinkedList;

public abstract class a
  extends m
{
  public int El;
  public String bVq;
  public int fzn;
  public int qTt;
  public String qTu;
  public Bundle qTv;
  
  public abstract String Jv();
  
  public abstract int Jw();
  
  public void ar(LinkedList<ccd> paramLinkedList) {}
  
  public final boolean bZj()
  {
    return this.El == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.a
 * JD-Core Version:    0.7.0.1
 */