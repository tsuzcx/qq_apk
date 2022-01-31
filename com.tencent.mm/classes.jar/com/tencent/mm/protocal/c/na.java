package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class na
  extends bly
{
  public String desc;
  public int iHq;
  public String iHr;
  public String iet;
  public String imZ;
  public String nxM;
  public String qsJ;
  public boolean sKF;
  public String sKG;
  public int sKH;
  public LinkedList<Integer> sKI = new LinkedList();
  public String sKJ;
  public int sKK;
  public int sKL;
  
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
      paramVarArgs.aA(4, this.sKF);
      if (this.nxM != null) {
        paramVarArgs.d(5, this.nxM);
      }
      if (this.sKG != null) {
        paramVarArgs.d(6, this.sKG);
      }
      if (this.iet != null) {
        paramVarArgs.d(7, this.iet);
      }
      paramVarArgs.gB(8, this.sKH);
      if (this.desc != null) {
        paramVarArgs.d(9, this.desc);
      }
      if (this.qsJ != null) {
        paramVarArgs.d(10, this.qsJ);
      }
      paramVarArgs.d(11, 2, this.sKI);
      if (this.sKJ != null) {
        paramVarArgs.d(12, this.sKJ);
      }
      if (this.imZ != null) {
        paramVarArgs.d(13, this.imZ);
      }
      paramVarArgs.gB(14, this.sKK);
      paramVarArgs.gB(15, this.sKL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1007;
      }
    }
    label1007:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(4) + 1);
      paramInt = i;
      if (this.nxM != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.nxM);
      }
      i = paramInt;
      if (this.sKG != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sKG);
      }
      paramInt = i;
      if (this.iet != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.iet);
      }
      i = paramInt + d.a.a.a.gy(8, this.sKH);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.desc);
      }
      i = paramInt;
      if (this.qsJ != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.qsJ);
      }
      i += d.a.a.a.c(11, 2, this.sKI);
      paramInt = i;
      if (this.sKJ != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.sKJ);
      }
      i = paramInt;
      if (this.imZ != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.imZ);
      }
      return i + d.a.a.a.gy(14, this.sKK) + d.a.a.a.gy(15, this.sKL);
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
        na localna = (na)paramVarArgs[1];
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
            localna.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localna.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localna.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localna.sKF = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 5: 
          localna.nxM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localna.sKG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localna.iet = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localna.sKH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localna.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localna.qsJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localna.sKI.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
          return 0;
        case 12: 
          localna.sKJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localna.imZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localna.sKK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localna.sKL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.na
 * JD-Core Version:    0.7.0.1
 */