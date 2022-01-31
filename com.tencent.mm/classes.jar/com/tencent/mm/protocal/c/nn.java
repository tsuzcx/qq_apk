package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class nn
  extends bly
{
  public String desc;
  public int iHq;
  public String iHr;
  public String nyK;
  public LinkedList<Integer> sKI = new LinkedList();
  public int sKK;
  public String sKV;
  public String sKY;
  public String sLb;
  public String sLe;
  public String sLf;
  public String sLi;
  
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
      if (this.sKY != null) {
        paramVarArgs.d(4, this.sKY);
      }
      paramVarArgs.d(5, 2, this.sKI);
      if (this.desc != null) {
        paramVarArgs.d(6, this.desc);
      }
      if (this.sLi != null) {
        paramVarArgs.d(7, this.sLi);
      }
      if (this.nyK != null) {
        paramVarArgs.d(8, this.nyK);
      }
      if (this.sLb != null) {
        paramVarArgs.d(9, this.sLb);
      }
      if (this.sLe != null) {
        paramVarArgs.d(10, this.sLe);
      }
      if (this.sLf != null) {
        paramVarArgs.d(11, this.sLf);
      }
      paramVarArgs.gB(12, this.sKK);
      if (this.sKV != null) {
        paramVarArgs.d(13, this.sKV);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label952;
      }
    }
    label952:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.sKY != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sKY);
      }
      i += d.a.a.a.c(5, 2, this.sKI);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.desc);
      }
      i = paramInt;
      if (this.sLi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sLi);
      }
      paramInt = i;
      if (this.nyK != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.nyK);
      }
      i = paramInt;
      if (this.sLb != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sLb);
      }
      paramInt = i;
      if (this.sLe != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sLe);
      }
      i = paramInt;
      if (this.sLf != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sLf);
      }
      i += d.a.a.a.gy(12, this.sKK);
      paramInt = i;
      if (this.sKV != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.sKV);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sKI.clear();
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
        nn localnn = (nn)paramVarArgs[1];
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
            localnn.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnn.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localnn.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localnn.sKY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localnn.sKI.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
          return 0;
        case 6: 
          localnn.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localnn.sLi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localnn.nyK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localnn.sLb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localnn.sLe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localnn.sLf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localnn.sKK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localnn.sKV = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nn
 * JD-Core Version:    0.7.0.1
 */