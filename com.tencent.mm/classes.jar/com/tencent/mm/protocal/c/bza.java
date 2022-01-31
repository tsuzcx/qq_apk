package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bza
  extends com.tencent.mm.bv.a
{
  public bmk sZU;
  public int sze;
  public int tPa;
  public String tPd;
  public String tPe;
  public int tPf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tPa);
      if (this.tPd != null) {
        paramVarArgs.d(2, this.tPd);
      }
      paramVarArgs.gB(3, this.sze);
      if (this.tPe != null) {
        paramVarArgs.d(4, this.tPe);
      }
      if (this.sZU != null)
      {
        paramVarArgs.gD(5, this.sZU.btq());
        this.sZU.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tPf);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tPa) + 0;
      paramInt = i;
      if (this.tPd != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tPd);
      }
      i = paramInt + d.a.a.a.gy(3, this.sze);
      paramInt = i;
      if (this.tPe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tPe);
      }
      i = paramInt;
      if (this.sZU != null) {
        i = paramInt + d.a.a.a.gA(5, this.sZU.btq());
      }
      return i + d.a.a.a.gy(6, this.tPf);
    }
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
      bza localbza = (bza)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbza.tPa = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbza.tPd = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbza.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localbza.tPe = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbza.sZU = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localbza.tPf = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bza
 * JD-Core Version:    0.7.0.1
 */