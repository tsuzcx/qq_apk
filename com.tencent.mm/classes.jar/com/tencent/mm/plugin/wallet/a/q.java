package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bv.a
{
  public String mOX;
  public String qkQ;
  public String qkR;
  public String qkS;
  public int qlJ;
  public int qlK;
  public long qlL;
  public String qlM;
  public String qlN;
  public String qlO;
  public double qlP;
  public double qlQ;
  public int qlR;
  public String qlS;
  public String qlT;
  public LinkedList<b> qlU = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.qlJ);
      paramVarArgs.gB(2, this.qlK);
      paramVarArgs.Y(3, this.qlL);
      if (this.qlM != null) {
        paramVarArgs.d(4, this.qlM);
      }
      if (this.qkQ != null) {
        paramVarArgs.d(5, this.qkQ);
      }
      if (this.qlN != null) {
        paramVarArgs.d(6, this.qlN);
      }
      if (this.qlO != null) {
        paramVarArgs.d(7, this.qlO);
      }
      if (this.qkR != null) {
        paramVarArgs.d(8, this.qkR);
      }
      if (this.qkS != null) {
        paramVarArgs.d(9, this.qkS);
      }
      paramVarArgs.b(10, this.qlP);
      paramVarArgs.b(11, this.qlQ);
      paramVarArgs.gB(12, this.qlR);
      if (this.qlS != null) {
        paramVarArgs.d(13, this.qlS);
      }
      if (this.mOX != null) {
        paramVarArgs.d(14, this.mOX);
      }
      if (this.qlT != null) {
        paramVarArgs.d(16, this.qlT);
      }
      paramVarArgs.d(17, 6, this.qlU);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.qlJ) + 0 + d.a.a.a.gy(2, this.qlK) + d.a.a.a.X(3, this.qlL);
      paramInt = i;
      if (this.qlM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qlM);
      }
      i = paramInt;
      if (this.qkQ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.qkQ);
      }
      paramInt = i;
      if (this.qlN != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.qlN);
      }
      i = paramInt;
      if (this.qlO != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.qlO);
      }
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.qkR);
      }
      i = paramInt;
      if (this.qkS != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.qkS);
      }
      i = i + (d.a.a.b.b.a.dQ(10) + 8) + (d.a.a.b.b.a.dQ(11) + 8) + d.a.a.a.gy(12, this.qlR);
      paramInt = i;
      if (this.qlS != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.qlS);
      }
      i = paramInt;
      if (this.mOX != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.mOX);
      }
      paramInt = i;
      if (this.qlT != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.qlT);
      }
      return paramInt + d.a.a.a.c(17, 6, this.qlU);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.qlU.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        return -1;
      case 1: 
        localq.qlJ = locala.xpH.oD();
        return 0;
      case 2: 
        localq.qlK = locala.xpH.oD();
        return 0;
      case 3: 
        localq.qlL = locala.xpH.oE();
        return 0;
      case 4: 
        localq.qlM = locala.xpH.readString();
        return 0;
      case 5: 
        localq.qkQ = locala.xpH.readString();
        return 0;
      case 6: 
        localq.qlN = locala.xpH.readString();
        return 0;
      case 7: 
        localq.qlO = locala.xpH.readString();
        return 0;
      case 8: 
        localq.qkR = locala.xpH.readString();
        return 0;
      case 9: 
        localq.qkS = locala.xpH.readString();
        return 0;
      case 10: 
        localq.qlP = locala.xpH.readDouble();
        return 0;
      case 11: 
        localq.qlQ = locala.xpH.readDouble();
        return 0;
      case 12: 
        localq.qlR = locala.xpH.oD();
        return 0;
      case 13: 
        localq.qlS = locala.xpH.readString();
        return 0;
      case 14: 
        localq.mOX = locala.xpH.readString();
        return 0;
      case 16: 
        localq.qlT = locala.xpH.readString();
        return 0;
      }
      localq.qlU.add(locala.cUs());
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.q
 * JD-Core Version:    0.7.0.1
 */