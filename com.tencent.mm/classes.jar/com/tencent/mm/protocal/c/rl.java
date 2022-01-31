package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class rl
  extends com.tencent.mm.bv.a
{
  public int ffh;
  public String ffm;
  public String hPY;
  public String hRf;
  public String kWx;
  public String sPA;
  public int sPB;
  public int sPC;
  public int sPD;
  public int sPE;
  public String sPp;
  public String sPq;
  public int sPr;
  public int sPs;
  public String sPt;
  public int sPu;
  public String sPv;
  public String sPw;
  public int sPx;
  public int sPy;
  public LinkedList<bmj> sPz = new LinkedList();
  public bmk svJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.sPp != null) {
        paramVarArgs.d(3, this.sPp);
      }
      if (this.sPq != null) {
        paramVarArgs.d(4, this.sPq);
      }
      paramVarArgs.gB(5, this.ffh);
      if (this.svJ != null)
      {
        paramVarArgs.gD(6, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.sPr);
      paramVarArgs.gB(8, this.sPs);
      if (this.sPt != null) {
        paramVarArgs.d(9, this.sPt);
      }
      paramVarArgs.gB(10, this.sPu);
      if (this.sPv != null) {
        paramVarArgs.d(11, this.sPv);
      }
      if (this.sPw != null) {
        paramVarArgs.d(12, this.sPw);
      }
      paramVarArgs.gB(13, this.sPx);
      paramVarArgs.gB(14, this.sPy);
      paramVarArgs.d(15, 8, this.sPz);
      if (this.sPA != null) {
        paramVarArgs.d(16, this.sPA);
      }
      paramVarArgs.gB(17, this.sPB);
      paramVarArgs.gB(18, this.sPC);
      if (this.kWx != null) {
        paramVarArgs.d(19, this.kWx);
      }
      paramVarArgs.gB(20, this.sPD);
      paramVarArgs.gB(21, this.sPE);
      if (this.ffm != null) {
        paramVarArgs.d(22, this.ffm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.sPp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sPp);
      }
      paramInt = i;
      if (this.sPq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPq);
      }
      i = paramInt + d.a.a.a.gy(5, this.ffh);
      paramInt = i;
      if (this.svJ != null) {
        paramInt = i + d.a.a.a.gA(6, this.svJ.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.sPr) + d.a.a.a.gy(8, this.sPs);
      paramInt = i;
      if (this.sPt != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sPt);
      }
      i = paramInt + d.a.a.a.gy(10, this.sPu);
      paramInt = i;
      if (this.sPv != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sPv);
      }
      i = paramInt;
      if (this.sPw != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sPw);
      }
      i = i + d.a.a.a.gy(13, this.sPx) + d.a.a.a.gy(14, this.sPy) + d.a.a.a.c(15, 8, this.sPz);
      paramInt = i;
      if (this.sPA != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sPA);
      }
      i = paramInt + d.a.a.a.gy(17, this.sPB) + d.a.a.a.gy(18, this.sPC);
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.kWx);
      }
      i = paramInt + d.a.a.a.gy(20, this.sPD) + d.a.a.a.gy(21, this.sPE);
      paramInt = i;
      if (this.ffm != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.ffm);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sPz.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        rl localrl = (rl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localrl.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localrl.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localrl.sPp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localrl.sPq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localrl.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localrl.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          localrl.sPr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localrl.sPs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localrl.sPt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localrl.sPu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localrl.sPv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localrl.sPw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localrl.sPx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localrl.sPy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localrl.sPz.add(localObject1);
            paramInt += 1;
          }
        case 16: 
          localrl.sPA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localrl.sPB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localrl.sPC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localrl.kWx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localrl.sPD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localrl.sPE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localrl.ffm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rl
 * JD-Core Version:    0.7.0.1
 */