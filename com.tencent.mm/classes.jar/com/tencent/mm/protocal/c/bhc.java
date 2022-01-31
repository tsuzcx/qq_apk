package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bhc
  extends bly
{
  public String ilp;
  public int ino;
  public String inp;
  public String mOb;
  public String mOc;
  public String tBJ;
  public String tBK;
  public lj tBL;
  public String tBM;
  public String tBN;
  public byo tBO;
  
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
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      if (this.tBJ != null) {
        paramVarArgs.d(4, this.tBJ);
      }
      if (this.ilp != null) {
        paramVarArgs.d(5, this.ilp);
      }
      if (this.tBK != null) {
        paramVarArgs.d(6, this.tBK);
      }
      if (this.tBL != null)
      {
        paramVarArgs.gD(7, this.tBL.btq());
        this.tBL.a(paramVarArgs);
      }
      if (this.tBM != null) {
        paramVarArgs.d(8, this.tBM);
      }
      if (this.mOc != null) {
        paramVarArgs.d(9, this.mOc);
      }
      if (this.mOb != null) {
        paramVarArgs.d(10, this.mOb);
      }
      if (this.tBN != null) {
        paramVarArgs.d(11, this.tBN);
      }
      if (this.tBO != null)
      {
        paramVarArgs.gD(12, this.tBO.btq());
        this.tBO.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt;
      if (this.tBJ != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tBJ);
      }
      paramInt = i;
      if (this.ilp != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.ilp);
      }
      i = paramInt;
      if (this.tBK != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tBK);
      }
      paramInt = i;
      if (this.tBL != null) {
        paramInt = i + d.a.a.a.gA(7, this.tBL.btq());
      }
      i = paramInt;
      if (this.tBM != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tBM);
      }
      paramInt = i;
      if (this.mOc != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.mOc);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.mOb);
      }
      paramInt = i;
      if (this.tBN != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tBN);
      }
      i = paramInt;
      if (this.tBO != null) {
        i = paramInt + d.a.a.a.gA(12, this.tBO.btq());
      }
      return i;
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
        bhc localbhc = (bhc)paramVarArgs[1];
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
            localbhc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbhc.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbhc.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbhc.tBJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbhc.ilp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbhc.tBK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhc.tBL = ((lj)localObject1);
            paramInt += 1;
          }
        case 8: 
          localbhc.tBM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbhc.mOc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbhc.mOb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbhc.tBN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbhc.tBO = ((byo)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhc
 * JD-Core Version:    0.7.0.1
 */