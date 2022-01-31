package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class amq
  extends bly
{
  public int tde;
  public LinkedList<chl> tdf = new LinkedList();
  public String tiA;
  public String tiu;
  public String tiw;
  public int tix;
  public String tiy;
  public String tiz;
  
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
      paramVarArgs.gB(2, this.tde);
      paramVarArgs.d(3, 8, this.tdf);
      if (this.tiw != null) {
        paramVarArgs.d(4, this.tiw);
      }
      if (this.tiu != null) {
        paramVarArgs.d(5, this.tiu);
      }
      paramVarArgs.gB(6, this.tix);
      if (this.tiy != null) {
        paramVarArgs.d(7, this.tiy);
      }
      if (this.tiz != null) {
        paramVarArgs.d(8, this.tiz);
      }
      if (this.tiA != null) {
        paramVarArgs.d(9, this.tiA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label799;
      }
    }
    label799:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tde) + d.a.a.a.c(3, 8, this.tdf);
      paramInt = i;
      if (this.tiw != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tiw);
      }
      i = paramInt;
      if (this.tiu != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tiu);
      }
      i += d.a.a.a.gy(6, this.tix);
      paramInt = i;
      if (this.tiy != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tiy);
      }
      i = paramInt;
      if (this.tiz != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tiz);
      }
      paramInt = i;
      if (this.tiA != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tiA);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tdf.clear();
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
        amq localamq = (amq)paramVarArgs[1];
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
            localamq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localamq.tde = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localamq.tdf.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localamq.tiw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localamq.tiu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localamq.tix = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localamq.tiy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localamq.tiz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localamq.tiA = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.amq
 * JD-Core Version:    0.7.0.1
 */