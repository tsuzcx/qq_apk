package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bsa
  extends bly
{
  public String bJY;
  public String dRQ;
  public eu tHq;
  public int tIC;
  public et tID;
  public String tIE;
  public LinkedList<ev> tIF = new LinkedList();
  public String tIG;
  public String tIH;
  public ew tII;
  public LinkedList<ew> tIJ = new LinkedList();
  public cdk tIK;
  public boolean tIL;
  public String tIM;
  public String title;
  public String tvJ;
  
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
      if (this.tHq != null)
      {
        paramVarArgs.gD(2, this.tHq.btq());
        this.tHq.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tIC);
      if (this.tID != null)
      {
        paramVarArgs.gD(4, this.tID.btq());
        this.tID.a(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.tvJ != null) {
        paramVarArgs.d(6, this.tvJ);
      }
      if (this.dRQ != null) {
        paramVarArgs.d(7, this.dRQ);
      }
      if (this.tIE != null) {
        paramVarArgs.d(8, this.tIE);
      }
      paramVarArgs.d(9, 8, this.tIF);
      if (this.tIG != null) {
        paramVarArgs.d(10, this.tIG);
      }
      if (this.tIH != null) {
        paramVarArgs.d(11, this.tIH);
      }
      if (this.tII != null)
      {
        paramVarArgs.gD(12, this.tII.btq());
        this.tII.a(paramVarArgs);
      }
      paramVarArgs.d(13, 8, this.tIJ);
      if (this.bJY != null) {
        paramVarArgs.d(14, this.bJY);
      }
      if (this.tIK != null)
      {
        paramVarArgs.gD(15, this.tIK.btq());
        this.tIK.a(paramVarArgs);
      }
      paramVarArgs.aA(16, this.tIL);
      if (this.tIM != null) {
        paramVarArgs.d(17, this.tIM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1698;
      }
    }
    label1698:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tHq != null) {
        i = paramInt + d.a.a.a.gA(2, this.tHq.btq());
      }
      i += d.a.a.a.gy(3, this.tIC);
      paramInt = i;
      if (this.tID != null) {
        paramInt = i + d.a.a.a.gA(4, this.tID.btq());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.tvJ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tvJ);
      }
      i = paramInt;
      if (this.dRQ != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.dRQ);
      }
      paramInt = i;
      if (this.tIE != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tIE);
      }
      i = paramInt + d.a.a.a.c(9, 8, this.tIF);
      paramInt = i;
      if (this.tIG != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tIG);
      }
      i = paramInt;
      if (this.tIH != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.tIH);
      }
      paramInt = i;
      if (this.tII != null) {
        paramInt = i + d.a.a.a.gA(12, this.tII.btq());
      }
      i = paramInt + d.a.a.a.c(13, 8, this.tIJ);
      paramInt = i;
      if (this.bJY != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.bJY);
      }
      i = paramInt;
      if (this.tIK != null) {
        i = paramInt + d.a.a.a.gA(15, this.tIK.btq());
      }
      i += d.a.a.b.b.a.dQ(16) + 1;
      paramInt = i;
      if (this.tIM != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.tIM);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tIF.clear();
        this.tIJ.clear();
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
        bsa localbsa = (bsa)paramVarArgs[1];
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
            localbsa.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tHq = ((eu)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbsa.tIC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new et();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((et)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tID = ((et)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbsa.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbsa.tvJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbsa.dRQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbsa.tIE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ev();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ev)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tIF.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          localbsa.tIG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbsa.tIH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ew();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ew)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tII = ((ew)localObject1);
            paramInt += 1;
          }
        case 13: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ew();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ew)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tIJ.add(localObject1);
            paramInt += 1;
          }
        case 14: 
          localbsa.bJY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbsa.tIK = ((cdk)localObject1);
            paramInt += 1;
          }
        case 16: 
          localbsa.tIL = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localbsa.tIM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsa
 * JD-Core Version:    0.7.0.1
 */