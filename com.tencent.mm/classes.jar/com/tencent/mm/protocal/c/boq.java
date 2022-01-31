package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class boq
  extends blm
{
  public String bOL;
  public int sEs;
  public String sIn;
  public String sOz;
  public int scene;
  public int source;
  public String tGX;
  public String url;
  
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
      if (this.sOz != null) {
        paramVarArgs.d(2, this.sOz);
      }
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.tGX != null) {
        paramVarArgs.d(5, this.tGX);
      }
      paramVarArgs.gB(6, this.scene);
      paramVarArgs.gB(7, this.source);
      if (this.sIn != null) {
        paramVarArgs.d(8, this.sIn);
      }
      paramVarArgs.gB(9, this.sEs);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label669;
      }
    }
    label669:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sOz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sOz);
      }
      i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bOL);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.tGX != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tGX);
      }
      i = i + d.a.a.a.gy(6, this.scene) + d.a.a.a.gy(7, this.source);
      paramInt = i;
      if (this.sIn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sIn);
      }
      return paramInt + d.a.a.a.gy(9, this.sEs);
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
        boq localboq = (boq)paramVarArgs[1];
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
            localboq.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localboq.sOz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localboq.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localboq.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localboq.tGX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localboq.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localboq.source = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localboq.sIn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localboq.sEs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.boq
 * JD-Core Version:    0.7.0.1
 */