package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ux
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kWm;
  public int ndf;
  public int ndg;
  public String sRE;
  public bmk sRF;
  public String sRG;
  public String sRH;
  public String sRI;
  public int sRJ;
  public String svK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRF == null) {
        throw new b("Not all required fields were included: EmojiBuffer");
      }
      if (this.sRE != null) {
        paramVarArgs.d(1, this.sRE);
      }
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.sRF != null)
      {
        paramVarArgs.gD(4, this.sRF.btq());
        this.sRF.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.hQR);
      if (this.kWm != null) {
        paramVarArgs.d(6, this.kWm);
      }
      if (this.sRG != null) {
        paramVarArgs.d(7, this.sRG);
      }
      if (this.sRH != null) {
        paramVarArgs.d(8, this.sRH);
      }
      if (this.sRI != null) {
        paramVarArgs.d(9, this.sRI);
      }
      if (this.svK != null) {
        paramVarArgs.d(10, this.svK);
      }
      paramVarArgs.gB(11, this.sRJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRE == null) {
        break label799;
      }
    }
    label799:
    for (paramInt = d.a.a.b.b.a.e(1, this.sRE) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.sRF != null) {
        paramInt = i + d.a.a.a.gA(4, this.sRF.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.hQR);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kWm);
      }
      i = paramInt;
      if (this.sRG != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sRG);
      }
      paramInt = i;
      if (this.sRH != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sRH);
      }
      i = paramInt;
      if (this.sRI != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sRI);
      }
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.svK);
      }
      return paramInt + d.a.a.a.gy(11, this.sRJ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sRF != null) {
          break;
        }
        throw new b("Not all required fields were included: EmojiBuffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ux localux = (ux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localux.sRE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localux.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localux.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localux.sRF = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          localux.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localux.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localux.sRG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localux.sRH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localux.sRI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localux.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localux.sRJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ux
 * JD-Core Version:    0.7.0.1
 */