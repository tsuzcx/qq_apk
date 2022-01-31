package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bus
  extends bly
{
  public int hQR;
  public String nde;
  public int ndf;
  public int ndg;
  public long sGd;
  public bta tLo;
  public int tsJ;
  public LinkedList<bta> tsK = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tLo == null) {
        throw new b("Not all required fields were included: BufferUrl");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.nde != null) {
        paramVarArgs.d(4, this.nde);
      }
      if (this.tLo != null)
      {
        paramVarArgs.gD(5, this.tLo.btq());
        this.tLo.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tsJ);
      paramVarArgs.d(7, 8, this.tsK);
      paramVarArgs.Y(8, this.sGd);
      paramVarArgs.gB(9, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label869;
      }
    }
    label869:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.nde != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.nde);
      }
      i = paramInt;
      if (this.tLo != null) {
        i = paramInt + d.a.a.a.gA(5, this.tLo.btq());
      }
      return i + d.a.a.a.gy(6, this.tsJ) + d.a.a.a.c(7, 8, this.tsK) + d.a.a.a.X(8, this.sGd) + d.a.a.a.gy(9, this.hQR);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tsK.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tLo != null) {
          break;
        }
        throw new b("Not all required fields were included: BufferUrl");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bus localbus = (bus)paramVarArgs[1];
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
            localbus.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbus.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbus.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbus.nde = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bta)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbus.tLo = ((bta)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbus.tsJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bta)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbus.tsK.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localbus.sGd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbus.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bus
 * JD-Core Version:    0.7.0.1
 */