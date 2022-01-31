package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class aed
  extends com.tencent.mm.bv.a
{
  public int sNV;
  public int sNW;
  public int sNX;
  public b sNZ;
  public apa sOa;
  public int tck;
  public int tcl;
  public int tcm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sNV);
      paramVarArgs.gB(2, this.sNW);
      paramVarArgs.gB(3, this.sNX);
      if (this.sNZ != null) {
        paramVarArgs.b(4, this.sNZ);
      }
      paramVarArgs.gB(5, this.tck);
      paramVarArgs.gB(6, this.tcl);
      paramVarArgs.gB(7, this.tcm);
      if (this.sOa != null)
      {
        paramVarArgs.gD(8, this.sOa.btq());
        this.sOa.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.sNV) + 0 + d.a.a.a.gy(2, this.sNW) + d.a.a.a.gy(3, this.sNX);
      paramInt = i;
      if (this.sNZ != null) {
        paramInt = i + d.a.a.a.a(4, this.sNZ);
      }
      i = paramInt + d.a.a.a.gy(5, this.tck) + d.a.a.a.gy(6, this.tcl) + d.a.a.a.gy(7, this.tcm);
      paramInt = i;
    } while (this.sOa == null);
    return i + d.a.a.a.gA(8, this.sOa.btq());
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
      aed localaed = (aed)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaed.sNV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localaed.sNW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localaed.sNX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localaed.sNZ = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      case 5: 
        localaed.tck = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localaed.tcl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localaed.tcm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new apa();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((apa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localaed.sOa = ((apa)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aed
 * JD-Core Version:    0.7.0.1
 */