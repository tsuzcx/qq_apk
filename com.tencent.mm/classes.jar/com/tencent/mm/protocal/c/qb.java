package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class qb
  extends bly
{
  public String aJD;
  public String gkk;
  public int status;
  
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
      paramVarArgs.gB(2, this.status);
      if (this.gkk != null) {
        paramVarArgs.d(3, this.gkk);
      }
      if (this.aJD != null) {
        paramVarArgs.d(4, this.aJD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.status);
      paramInt = i;
      if (this.gkk != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.gkk);
      }
      i = paramInt;
      if (this.aJD != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.aJD);
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
        qb localqb = (qb)paramVarArgs[1];
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
            localqb.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localqb.status = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localqb.gkk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localqb.aJD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qb
 * JD-Core Version:    0.7.0.1
 */