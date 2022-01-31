package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aaq
  extends bly
{
  public int sSK;
  public LinkedList<com.tencent.mm.bv.b> tan = new LinkedList();
  public int tao;
  public LinkedList<Integer> tap = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.d(2, 6, this.tan);
      paramVarArgs.gB(3, this.tao);
      paramVarArgs.gB(4, this.sSK);
      paramVarArgs.d(5, 2, this.tap);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label485;
      }
    }
    label485:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 6, this.tan) + d.a.a.a.gy(3, this.tao) + d.a.a.a.gy(4, this.sSK) + d.a.a.a.c(5, 2, this.tap);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tan.clear();
        this.tap.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aaq localaaq = (aaq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaaq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaaq.tan.add(((d.a.a.a.a)localObject1).cUs());
          return 0;
        case 3: 
          localaaq.tao = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaaq.sSK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaaq.tap.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aaq
 * JD-Core Version:    0.7.0.1
 */