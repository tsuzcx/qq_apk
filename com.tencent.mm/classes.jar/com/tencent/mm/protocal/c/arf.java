package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class arf
  extends blm
{
  public String bIK;
  public String bOL;
  public int scene;
  public String signature;
  public String tmB;
  public String tmC;
  public LinkedList<String> tmR = new LinkedList();
  public String tmS;
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
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      paramVarArgs.d(4, 1, this.tmR);
      if (this.bIK != null) {
        paramVarArgs.d(5, this.bIK);
      }
      if (this.tmB != null) {
        paramVarArgs.d(6, this.tmB);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.tmC != null) {
        paramVarArgs.d(8, this.tmC);
      }
      paramVarArgs.gB(9, this.scene);
      if (this.tmS != null) {
        paramVarArgs.d(10, this.tmS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label760;
      }
    }
    label760:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bOL);
      }
      i += d.a.a.a.c(4, 1, this.tmR);
      paramInt = i;
      if (this.bIK != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bIK);
      }
      i = paramInt;
      if (this.tmB != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tmB);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.signature);
      }
      i = paramInt;
      if (this.tmC != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tmC);
      }
      i += d.a.a.a.gy(9, this.scene);
      paramInt = i;
      if (this.tmS != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tmS);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tmR.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        arf localarf = (arf)paramVarArgs[1];
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
            localarf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localarf.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localarf.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localarf.tmR.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 5: 
          localarf.bIK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localarf.tmB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localarf.signature = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localarf.tmC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localarf.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localarf.tmS = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.arf
 * JD-Core Version:    0.7.0.1
 */