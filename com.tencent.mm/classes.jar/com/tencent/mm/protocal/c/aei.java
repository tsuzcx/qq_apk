package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aei
  extends bly
{
  public String ID;
  public int hQR;
  public long hQm;
  public int pyo;
  public bmk syK;
  public int syY;
  public LinkedList<ri> syZ = new LinkedList();
  public String sza;
  public String szb;
  public String szc;
  public int szh;
  public String szi;
  public String szj;
  public String tcs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.syK == null) {
        throw new b("Not all required fields were included: Key");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.syK != null)
      {
        paramVarArgs.gD(3, this.syK.btq());
        this.syK.a(paramVarArgs);
      }
      if (this.szi != null) {
        paramVarArgs.d(4, this.szi);
      }
      if (this.szj != null) {
        paramVarArgs.d(5, this.szj);
      }
      paramVarArgs.gB(6, this.hQR);
      paramVarArgs.gB(7, this.syY);
      paramVarArgs.d(8, 8, this.syZ);
      if (this.tcs != null) {
        paramVarArgs.d(9, this.tcs);
      }
      if (this.sza != null) {
        paramVarArgs.d(10, this.sza);
      }
      if (this.szb != null) {
        paramVarArgs.d(11, this.szb);
      }
      paramVarArgs.gB(12, this.szh);
      paramVarArgs.gB(13, this.pyo);
      paramVarArgs.Y(14, this.hQm);
      if (this.szc != null) {
        paramVarArgs.d(15, this.szc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1211;
      }
    }
    label1211:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.syK != null) {
        i = paramInt + d.a.a.a.gA(3, this.syK.btq());
      }
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.szi);
      }
      i = paramInt;
      if (this.szj != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.szj);
      }
      i = i + d.a.a.a.gy(6, this.hQR) + d.a.a.a.gy(7, this.syY) + d.a.a.a.c(8, 8, this.syZ);
      paramInt = i;
      if (this.tcs != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tcs);
      }
      i = paramInt;
      if (this.sza != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sza);
      }
      paramInt = i;
      if (this.szb != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.szb);
      }
      i = paramInt + d.a.a.a.gy(12, this.szh) + d.a.a.a.gy(13, this.pyo) + d.a.a.a.X(14, this.hQm);
      paramInt = i;
      if (this.szc != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.szc);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syZ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.syK != null) {
          break;
        }
        throw new b("Not all required fields were included: Key");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aei localaei = (aei)paramVarArgs[1];
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
            localaei.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaei.ID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaei.syK = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localaei.szi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaei.szj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaei.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localaei.syY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ri();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ri)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaei.syZ.add(localObject1);
            paramInt += 1;
          }
        case 9: 
          localaei.tcs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localaei.sza = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localaei.szb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localaei.szh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localaei.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localaei.hQm = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localaei.szc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aei
 * JD-Core Version:    0.7.0.1
 */