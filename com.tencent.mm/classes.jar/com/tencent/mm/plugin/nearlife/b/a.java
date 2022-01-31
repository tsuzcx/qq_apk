package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import java.util.LinkedList;

public final class a
{
  public String bGw;
  public int cCu;
  public int hQR;
  public String lJP;
  public String lJQ;
  public String mDU;
  public float mDV;
  public int mDW;
  public LinkedList<Integer> mDX = new LinkedList();
  public int mDY;
  public LinkedList<bml> mDZ = new LinkedList();
  public float mEa;
  public String mEb;
  public bmk mEc;
  public atn mEd;
  
  public a(String paramString, atn paramatn)
  {
    this.lJP = paramString;
    this.mDU = paramatn.mDU;
    this.bGw = paramatn.bGw;
    this.mDV = paramatn.mDV;
    this.mDW = paramatn.mDW;
    this.mDX = paramatn.mDX;
    this.mDY = paramatn.mDY;
    this.mDZ = paramatn.mDZ;
    this.mEa = paramatn.mEa;
    this.mEb = paramatn.mEb;
    this.hQR = paramatn.hQR;
    this.mEc = paramatn.mEc;
    this.cCu = paramatn.tpr;
    this.mEd = paramatn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.a
 * JD-Core Version:    0.7.0.1
 */