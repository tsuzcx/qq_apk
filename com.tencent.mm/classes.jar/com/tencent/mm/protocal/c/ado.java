package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ado
  extends blm
{
  public String ioI;
  public double latitude;
  public double longitude;
  public String tbI;
  public String tbJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.b(2, this.latitude);
      paramVarArgs.b(3, this.longitude);
      if (this.ioI != null) {
        paramVarArgs.d(4, this.ioI);
      }
      if (this.tbI != null) {
        paramVarArgs.d(5, this.tbI);
      }
      if (this.tbJ != null) {
        paramVarArgs.d(6, this.tbJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8);
      paramInt = i;
      if (this.ioI != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ioI);
      }
      i = paramInt;
      if (this.tbI != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tbI);
      }
      paramInt = i;
      if (this.tbJ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tbJ);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ado localado = (ado)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localado.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localado.latitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 3: 
          localado.longitude = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 4: 
          localado.ioI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localado.tbI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localado.tbJ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ado
 * JD-Core Version:    0.7.0.1
 */