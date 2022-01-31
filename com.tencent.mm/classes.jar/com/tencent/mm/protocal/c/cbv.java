package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbv
  extends bly
{
  public int euw;
  public String kWm;
  public String kWn;
  public int mPL;
  public int ndm;
  public long ndp;
  public int sDT;
  public int sRd;
  public int sRf;
  public int sRg;
  public String swQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.kWn != null) {
        paramVarArgs.d(1, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(2, this.kWm);
      }
      paramVarArgs.gB(3, this.sDT);
      paramVarArgs.gB(4, this.sRd);
      paramVarArgs.gB(5, this.mPL);
      if (this.swQ != null) {
        paramVarArgs.d(6, this.swQ);
      }
      paramVarArgs.gB(7, this.ndm);
      paramVarArgs.gB(8, this.sRf);
      paramVarArgs.gB(9, this.euw);
      if (this.tFx != null)
      {
        paramVarArgs.gD(10, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.sRg);
      paramVarArgs.Y(12, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWn == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kWm);
      }
      i = i + d.a.a.a.gy(3, this.sDT) + d.a.a.a.gy(4, this.sRd) + d.a.a.a.gy(5, this.mPL);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.swQ);
      }
      i = paramInt + d.a.a.a.gy(7, this.ndm) + d.a.a.a.gy(8, this.sRf) + d.a.a.a.gy(9, this.euw);
      paramInt = i;
      if (this.tFx != null) {
        paramInt = i + d.a.a.a.gA(10, this.tFx.btq());
      }
      return paramInt + d.a.a.a.gy(11, this.sRg) + d.a.a.a.X(12, this.ndp);
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
        cbv localcbv = (cbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcbv.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcbv.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcbv.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcbv.sRd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcbv.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcbv.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localcbv.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcbv.sRf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcbv.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcbv.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 11: 
          localcbv.sRg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcbv.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbv
 * JD-Core Version:    0.7.0.1
 */