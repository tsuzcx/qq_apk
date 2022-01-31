package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class baw
  extends bly
{
  public int ino;
  public String inp;
  public String sAV;
  public bez sAW;
  public bcd sAX;
  public String twJ;
  public String twP;
  
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
      if (this.twJ != null) {
        paramVarArgs.d(4, this.twJ);
      }
      if (this.sAV != null) {
        paramVarArgs.d(5, this.sAV);
      }
      if (this.twP != null) {
        paramVarArgs.d(6, this.twP);
      }
      if (this.sAW != null)
      {
        paramVarArgs.gD(7, this.sAW.btq());
        this.sAW.a(paramVarArgs);
      }
      if (this.sAX != null)
      {
        paramVarArgs.gD(8, this.sAX.btq());
        this.sAX.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt;
      if (this.twJ != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.twJ);
      }
      paramInt = i;
      if (this.sAV != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sAV);
      }
      i = paramInt;
      if (this.twP != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.twP);
      }
      paramInt = i;
      if (this.sAW != null) {
        paramInt = i + d.a.a.a.gA(7, this.sAW.btq());
      }
      i = paramInt;
      if (this.sAX != null) {
        i = paramInt + d.a.a.a.gA(8, this.sAX.btq());
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
        baw localbaw = (baw)paramVarArgs[1];
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
            localbaw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbaw.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbaw.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbaw.twJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbaw.sAV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbaw.twP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bez();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bez)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbaw.sAW = ((bez)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbaw.sAX = ((bcd)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.baw
 * JD-Core Version:    0.7.0.1
 */