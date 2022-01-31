package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class abp
  extends bly
{
  public int ino;
  public String inp;
  public int taR;
  public String taS;
  public String taT;
  
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
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      paramVarArgs.gB(4, this.taR);
      if (this.taS != null) {
        paramVarArgs.d(5, this.taS);
      }
      if (this.taT != null) {
        paramVarArgs.d(6, this.taT);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + d.a.a.a.gy(4, this.taR);
      paramInt = i;
      if (this.taS != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.taS);
      }
      i = paramInt;
      if (this.taT != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.taT);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        abp localabp = (abp)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localabp.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localabp.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localabp.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localabp.taR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localabp.taS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localabp.taT = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abp
 * JD-Core Version:    0.7.0.1
 */