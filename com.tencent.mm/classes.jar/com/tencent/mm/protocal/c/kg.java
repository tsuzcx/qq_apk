package com.tencent.mm.protocal.c;

import b.a.a.c;
import d.a.a.b;
import java.util.LinkedList;

public final class kg
  extends bly
{
  public int ino;
  public String inp;
  public c qxJ;
  public long qxL;
  public long sFp;
  public LinkedList<String> sFq = new LinkedList();
  public int sFr;
  public int sFs;
  public String sFt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      paramVarArgs.Y(4, this.qxL);
      if (this.qxJ != null)
      {
        paramVarArgs.gD(5, this.qxJ.btq());
        this.qxJ.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.sFp);
      paramVarArgs.d(7, 1, this.sFq);
      paramVarArgs.gB(8, this.sFr);
      paramVarArgs.gB(9, this.sFs);
      if (this.sFt != null) {
        paramVarArgs.d(10, this.sFt);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + d.a.a.a.X(4, this.qxL);
      paramInt = i;
      if (this.qxJ != null) {
        paramInt = i + d.a.a.a.gA(5, this.qxJ.btq());
      }
      i = paramInt + d.a.a.a.X(6, this.sFp) + d.a.a.a.c(7, 1, this.sFq) + d.a.a.a.gy(8, this.sFr) + d.a.a.a.gy(9, this.sFs);
      paramInt = i;
      if (this.sFt != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sFt);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sFq.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        kg localkg = (kg)paramVarArgs[1];
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
            localkg.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localkg.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localkg.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localkg.qxL = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localkg.qxJ = ((c)localObject1);
            paramInt += 1;
          }
        case 6: 
          localkg.sFp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          localkg.sFq.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 8: 
          localkg.sFr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localkg.sFs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localkg.sFt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kg
 * JD-Core Version:    0.7.0.1
 */