package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bom
  extends com.tencent.mm.bv.a
{
  public uq syg;
  public bmk syh;
  public bmk syi;
  public int syw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syi == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      if (this.syg == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.syh == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.syi != null)
      {
        paramVarArgs.gD(1, this.syi.btq());
        this.syi.a(paramVarArgs);
      }
      if (this.syg != null)
      {
        paramVarArgs.gD(2, this.syg.btq());
        this.syg.a(paramVarArgs);
      }
      if (this.syh != null)
      {
        paramVarArgs.gD(3, this.syh.btq());
        this.syh.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.syw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.syi == null) {
        break label706;
      }
    }
    label706:
    for (int i = d.a.a.a.gA(1, this.syi.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syg != null) {
        paramInt = i + d.a.a.a.gA(2, this.syg.btq());
      }
      i = paramInt;
      if (this.syh != null) {
        i = paramInt + d.a.a.a.gA(3, this.syh.btq());
      }
      return i + d.a.a.a.gy(4, this.syw);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.syi == null) {
          throw new b("Not all required fields were included: AutoAuthKey");
        }
        if (this.syg == null) {
          throw new b("Not all required fields were included: SvrPubECDHKey");
        }
        if (this.syh != null) {
          break;
        }
        throw new b("Not all required fields were included: SessionKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bom localbom = (bom)paramVarArgs[1];
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
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbom.syi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbom.syg = ((uq)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbom.syh = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localbom.syw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bom
 * JD-Core Version:    0.7.0.1
 */