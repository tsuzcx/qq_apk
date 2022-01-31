package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cao
  extends bly
{
  public String euK;
  public String euN;
  public String hPY;
  public int mPL;
  public int ndf;
  public int ndg;
  public int ndh;
  public String tPI;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.euN != null) {
        paramVarArgs.d(3, this.euN);
      }
      if (this.tPI != null) {
        paramVarArgs.d(4, this.tPI);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      paramVarArgs.gB(6, this.ndf);
      paramVarArgs.gB(7, this.ndg);
      paramVarArgs.gB(8, this.ndh);
      paramVarArgs.gB(9, this.mPL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label681;
      }
    }
    label681:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.euN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.euN);
      }
      paramInt = i;
      if (this.tPI != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tPI);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      return i + d.a.a.a.gy(6, this.ndf) + d.a.a.a.gy(7, this.ndg) + d.a.a.a.gy(8, this.ndh) + d.a.a.a.gy(9, this.mPL);
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
        cao localcao = (cao)paramVarArgs[1];
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
            localcao.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcao.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcao.euN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcao.tPI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcao.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcao.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcao.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcao.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcao.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cao
 * JD-Core Version:    0.7.0.1
 */