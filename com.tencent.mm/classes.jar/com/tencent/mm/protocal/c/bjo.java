package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bjo
  extends bly
{
  public String ioU;
  public int lLk;
  public int lLl;
  public String lLm;
  public String txD;
  public String txE;
  public String txF;
  public int txG;
  public String txI;
  public com.tencent.mm.bv.b txw;
  public int txx;
  public int txy;
  
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
      paramVarArgs.gB(2, this.txx);
      if (this.lLm != null) {
        paramVarArgs.d(3, this.lLm);
      }
      if (this.txE != null) {
        paramVarArgs.d(4, this.txE);
      }
      if (this.txF != null) {
        paramVarArgs.d(5, this.txF);
      }
      if (this.txw != null) {
        paramVarArgs.b(6, this.txw);
      }
      paramVarArgs.gB(7, this.txy);
      paramVarArgs.gB(8, this.lLk);
      paramVarArgs.gB(9, this.txG);
      paramVarArgs.gB(10, this.lLl);
      if (this.ioU != null) {
        paramVarArgs.d(11, this.ioU);
      }
      if (this.txI != null) {
        paramVarArgs.d(12, this.txI);
      }
      if (this.txD != null) {
        paramVarArgs.d(13, this.txD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.txx);
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.lLm);
      }
      i = paramInt;
      if (this.txE != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.txE);
      }
      paramInt = i;
      if (this.txF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.txF);
      }
      i = paramInt;
      if (this.txw != null) {
        i = paramInt + d.a.a.a.a(6, this.txw);
      }
      i = i + d.a.a.a.gy(7, this.txy) + d.a.a.a.gy(8, this.lLk) + d.a.a.a.gy(9, this.txG) + d.a.a.a.gy(10, this.lLl);
      paramInt = i;
      if (this.ioU != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.ioU);
      }
      i = paramInt;
      if (this.txI != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.txI);
      }
      paramInt = i;
      if (this.txD != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.txD);
      }
      return paramInt;
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
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bjo localbjo = (bjo)paramVarArgs[1];
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
            localbjo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbjo.txx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbjo.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbjo.txE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbjo.txF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbjo.txw = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 7: 
          localbjo.txy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbjo.lLk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbjo.txG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbjo.lLl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbjo.ioU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localbjo.txI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbjo.txD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjo
 * JD-Core Version:    0.7.0.1
 */