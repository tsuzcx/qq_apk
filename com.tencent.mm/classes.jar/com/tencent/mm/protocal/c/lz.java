package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class lz
  extends com.tencent.mm.bv.a
{
  public int sHP;
  public String sHQ;
  public String sHR;
  public String sHS;
  public int sHT;
  public String sHU;
  public lx sHV;
  public String sHW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sHP);
      if (this.sHQ != null) {
        paramVarArgs.d(2, this.sHQ);
      }
      if (this.sHR != null) {
        paramVarArgs.d(3, this.sHR);
      }
      if (this.sHS != null) {
        paramVarArgs.d(4, this.sHS);
      }
      paramVarArgs.gB(5, this.sHT);
      if (this.sHU != null) {
        paramVarArgs.d(6, this.sHU);
      }
      if (this.sHV != null)
      {
        paramVarArgs.gD(7, this.sHV.btq());
        this.sHV.a(paramVarArgs);
      }
      if (this.sHW != null) {
        paramVarArgs.d(8, this.sHW);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sHP) + 0;
      paramInt = i;
      if (this.sHQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sHQ);
      }
      i = paramInt;
      if (this.sHR != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sHR);
      }
      paramInt = i;
      if (this.sHS != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sHS);
      }
      i = paramInt + d.a.a.a.gy(5, this.sHT);
      paramInt = i;
      if (this.sHU != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sHU);
      }
      i = paramInt;
      if (this.sHV != null) {
        i = paramInt + d.a.a.a.gA(7, this.sHV.btq());
      }
      paramInt = i;
    } while (this.sHW == null);
    return i + d.a.a.b.b.a.e(8, this.sHW);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      lz locallz = (lz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locallz.sHP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locallz.sHQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        locallz.sHR = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        locallz.sHS = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        locallz.sHT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        locallz.sHU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locallz.sHV = ((lx)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      locallz.sHW = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lz
 * JD-Core Version:    0.7.0.1
 */