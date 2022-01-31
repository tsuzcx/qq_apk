package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class qd
  extends bly
{
  public int hQq;
  public cdx sNO;
  public cbr sNP;
  public bhy sNQ;
  public int sNR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sNO == null) {
        throw new b("Not all required fields were included: TransRes");
      }
      if (this.sNP == null) {
        throw new b("Not all required fields were included: UploadCtx");
      }
      if (this.sNQ == null) {
        throw new b("Not all required fields were included: QueryCtx");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hQq);
      if (this.sNO != null)
      {
        paramVarArgs.gD(3, this.sNO.btq());
        this.sNO.a(paramVarArgs);
      }
      if (this.sNP != null)
      {
        paramVarArgs.gD(4, this.sNP.btq());
        this.sNP.a(paramVarArgs);
      }
      if (this.sNQ != null)
      {
        paramVarArgs.gD(5, this.sNQ.btq());
        this.sNQ.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.sNR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQq);
      paramInt = i;
      if (this.sNO != null) {
        paramInt = i + d.a.a.a.gA(3, this.sNO.btq());
      }
      i = paramInt;
      if (this.sNP != null) {
        i = paramInt + d.a.a.a.gA(4, this.sNP.btq());
      }
      paramInt = i;
      if (this.sNQ != null) {
        paramInt = i + d.a.a.a.gA(5, this.sNQ.btq());
      }
      return paramInt + d.a.a.a.gy(6, this.sNR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sNO == null) {
          throw new b("Not all required fields were included: TransRes");
        }
        if (this.sNP == null) {
          throw new b("Not all required fields were included: UploadCtx");
        }
        if (this.sNQ != null) {
          break;
        }
        throw new b("Not all required fields were included: QueryCtx");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
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
            localqd.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localqd.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localqd.sNO = ((cdx)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localqd.sNP = ((cbr)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localqd.sNQ = ((bhy)localObject1);
            paramInt += 1;
          }
        }
        localqd.sNR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qd
 * JD-Core Version:    0.7.0.1
 */