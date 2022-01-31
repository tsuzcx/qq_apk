package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class can
  extends blm
{
  public String euK;
  public String hPY;
  public int hQR;
  public int ndf;
  public int ndg;
  public int ndh;
  public bmk ndi;
  public String sRE;
  public int swP;
  public String tPI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.swP);
      if (this.tPI != null) {
        paramVarArgs.d(4, this.tPI);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      paramVarArgs.gB(6, this.ndf);
      paramVarArgs.gB(7, this.ndg);
      paramVarArgs.gB(8, this.ndh);
      if (this.ndi != null)
      {
        paramVarArgs.gD(9, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.hQR);
      if (this.sRE != null) {
        paramVarArgs.d(11, this.sRE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label877;
      }
    }
    label877:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.euK);
      }
      i += d.a.a.a.gy(3, this.swP);
      paramInt = i;
      if (this.tPI != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tPI);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      i = i + d.a.a.a.gy(6, this.ndf) + d.a.a.a.gy(7, this.ndg) + d.a.a.a.gy(8, this.ndh);
      paramInt = i;
      if (this.ndi != null) {
        paramInt = i + d.a.a.a.gA(9, this.ndi.btq());
      }
      i = paramInt + d.a.a.a.gy(10, this.hQR);
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sRE);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        can localcan = (can)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcan.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcan.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcan.swP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcan.tPI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcan.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcan.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcan.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcan.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcan.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 10: 
          localcan.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcan.sRE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.can
 * JD-Core Version:    0.7.0.1
 */