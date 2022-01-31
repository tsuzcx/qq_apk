package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class x
  extends bly
{
  public int iHq = 268513600;
  public String iHr = "请求不成功，请稍候再试";
  public String sse;
  public int ssf;
  public int ssg;
  public String ssh;
  public LinkedList<k> ssi = new LinkedList();
  public String ssj;
  
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
      paramVarArgs.gB(2, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      paramVarArgs.d(4, 8, this.ssi);
      if (this.ssj != null) {
        paramVarArgs.d(5, this.ssj);
      }
      if (this.sse != null) {
        paramVarArgs.d(6, this.sse);
      }
      paramVarArgs.gB(7, this.ssf);
      paramVarArgs.gB(8, this.ssg);
      if (this.ssh != null) {
        paramVarArgs.d(9, this.ssh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label783;
      }
    }
    label783:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + d.a.a.a.c(4, 8, this.ssi);
      paramInt = i;
      if (this.ssj != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.ssj);
      }
      i = paramInt;
      if (this.sse != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sse);
      }
      i = i + d.a.a.a.gy(7, this.ssf) + d.a.a.a.gy(8, this.ssg);
      paramInt = i;
      if (this.ssh != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.ssh);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ssi.clear();
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
        x localx = (x)paramVarArgs[1];
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
            localx.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localx.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localx.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localx.ssi.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localx.ssj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localx.sse = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localx.ssf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localx.ssg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localx.ssh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.x
 * JD-Core Version:    0.7.0.1
 */