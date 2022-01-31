package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnn
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public int sDT;
  public long sFC;
  public String sFF;
  public int tGx;
  public LinkedList<ccd> tGy = new LinkedList();
  public String tcJ;
  public atp tqT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tcJ == null) {
        throw new b("Not all required fields were included: KeyWord");
      }
      paramVarArgs.Y(1, this.sFC);
      if (this.tcJ != null) {
        paramVarArgs.d(2, this.tcJ);
      }
      paramVarArgs.gB(3, this.sDT);
      if (this.tqT != null)
      {
        paramVarArgs.gD(4, this.tqT.btq());
        this.tqT.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tGx);
      paramVarArgs.d(6, 8, this.tGy);
      paramVarArgs.gB(7, this.pyo);
      if (this.sFF != null) {
        paramVarArgs.d(8, this.sFF);
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
      i = d.a.a.a.X(1, this.sFC) + 0;
      paramInt = i;
      if (this.tcJ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tcJ);
      }
      i = paramInt + d.a.a.a.gy(3, this.sDT);
      paramInt = i;
      if (this.tqT != null) {
        paramInt = i + d.a.a.a.gA(4, this.tqT.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.tGx) + d.a.a.a.c(6, 8, this.tGy) + d.a.a.a.gy(7, this.pyo);
      paramInt = i;
    } while (this.sFF == null);
    return i + d.a.a.b.b.a.e(8, this.sFF);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tGy.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tcJ == null) {
        throw new b("Not all required fields were included: KeyWord");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bnn localbnn = (bnn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbnn.sFC = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localbnn.tcJ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbnn.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((atp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbnn.tqT = ((atp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localbnn.tGx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbnn.tGy.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localbnn.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localbnn.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnn
 * JD-Core Version:    0.7.0.1
 */