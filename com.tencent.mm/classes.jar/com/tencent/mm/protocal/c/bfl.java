package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfl
  extends bly
{
  public String sHh;
  public int sHi;
  public String sHj;
  public LinkedList<wi> tAe = new LinkedList();
  public LinkedList<au> tAf = new LinkedList();
  public int tAg;
  public int teu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.teu);
      paramVarArgs.d(3, 8, this.tAe);
      if (this.sHh != null) {
        paramVarArgs.d(4, this.sHh);
      }
      paramVarArgs.gB(5, this.sHi);
      if (this.sHj != null) {
        paramVarArgs.d(6, this.sHj);
      }
      paramVarArgs.d(7, 8, this.tAf);
      paramVarArgs.gB(8, this.tAg);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.teu) + d.a.a.a.c(3, 8, this.tAe);
      paramInt = i;
      if (this.sHh != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sHh);
      }
      i = paramInt + d.a.a.a.gy(5, this.sHi);
      paramInt = i;
      if (this.sHj != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sHj);
      }
      return paramInt + d.a.a.a.c(7, 8, this.tAf) + d.a.a.a.gy(8, this.tAg);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tAe.clear();
        this.tAf.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bfl localbfl = (bfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbfl.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfl.teu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbfl.tAe.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbfl.sHh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbfl.sHi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbfl.sHj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new au();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((au)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbfl.tAf.add(localObject1);
            paramInt += 1;
          }
        }
        localbfl.tAg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfl
 * JD-Core Version:    0.7.0.1
 */