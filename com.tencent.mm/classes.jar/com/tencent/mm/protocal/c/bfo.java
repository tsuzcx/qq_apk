package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bfo
  extends bly
{
  public String tAk;
  public String tAl;
  public String tAm;
  public String tAn;
  
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
      if (this.tAk != null) {
        paramVarArgs.d(2, this.tAk);
      }
      if (this.tAl != null) {
        paramVarArgs.d(3, this.tAl);
      }
      if (this.tAm != null) {
        paramVarArgs.d(4, this.tAm);
      }
      if (this.tAn != null) {
        paramVarArgs.d(5, this.tAn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label525;
      }
    }
    label525:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tAk != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tAk);
      }
      i = paramInt;
      if (this.tAl != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tAl);
      }
      paramInt = i;
      if (this.tAm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tAm);
      }
      i = paramInt;
      if (this.tAn != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tAn);
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
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bfo localbfo = (bfo)paramVarArgs[1];
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
            localbfo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfo.tAk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbfo.tAl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbfo.tAm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbfo.tAn = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfo
 * JD-Core Version:    0.7.0.1
 */