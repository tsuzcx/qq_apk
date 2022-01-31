package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bur
  extends blm
{
  public String euK;
  public int hQR;
  public String nde;
  public int ndf;
  public int ndg;
  public int sNU;
  public String sRE;
  public String sxZ;
  public bmk szp;
  public int tLm;
  public int tLn;
  public int tsl;
  public int tsm;
  public int ttI;
  public bzd tzP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.szp == null) {
        throw new b("Not all required fields were included: Buffer");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.ndg);
      paramVarArgs.gB(4, this.ndf);
      if (this.szp != null)
      {
        paramVarArgs.gD(5, this.szp.btq());
        this.szp.a(paramVarArgs);
      }
      if (this.nde != null) {
        paramVarArgs.d(6, this.nde);
      }
      paramVarArgs.gB(7, this.tsl);
      paramVarArgs.gB(8, this.tsm);
      if (this.sxZ != null) {
        paramVarArgs.d(9, this.sxZ);
      }
      paramVarArgs.gB(10, this.tLm);
      paramVarArgs.gB(11, this.sNU);
      if (this.tzP != null)
      {
        paramVarArgs.gD(12, this.tzP.btq());
        this.tzP.a(paramVarArgs);
      }
      if (this.euK != null) {
        paramVarArgs.d(13, this.euK);
      }
      paramVarArgs.gB(14, this.ttI);
      if (this.sRE != null) {
        paramVarArgs.d(15, this.sRE);
      }
      paramVarArgs.gB(16, this.tLn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.ndg) + d.a.a.a.gy(4, this.ndf);
      paramInt = i;
      if (this.szp != null) {
        paramInt = i + d.a.a.a.gA(5, this.szp.btq());
      }
      i = paramInt;
      if (this.nde != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nde);
      }
      i = i + d.a.a.a.gy(7, this.tsl) + d.a.a.a.gy(8, this.tsm);
      paramInt = i;
      if (this.sxZ != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sxZ);
      }
      i = paramInt + d.a.a.a.gy(10, this.tLm) + d.a.a.a.gy(11, this.sNU);
      paramInt = i;
      if (this.tzP != null) {
        paramInt = i + d.a.a.a.gA(12, this.tzP.btq());
      }
      i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.euK);
      }
      i += d.a.a.a.gy(14, this.ttI);
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.sRE);
      }
      return paramInt + d.a.a.a.gy(16, this.tLn);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.szp != null) {
          break;
        }
        throw new b("Not all required fields were included: Buffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bur localbur = (bur)paramVarArgs[1];
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
            localbur.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbur.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbur.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbur.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbur.szp = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbur.nde = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbur.tsl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbur.tsm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbur.sxZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbur.tLm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbur.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbur.tzP = ((bzd)localObject1);
            paramInt += 1;
          }
        case 13: 
          localbur.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbur.ttI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localbur.sRE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbur.tLn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bur
 * JD-Core Version:    0.7.0.1
 */