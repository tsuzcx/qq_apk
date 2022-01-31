package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class rz
  extends bly
{
  public int dne;
  public String sLD;
  public String sLE;
  public bml sPY;
  public bml sQa;
  public bml sQb;
  public bmk svJ;
  public LinkedList<awi> svo = new LinkedList();
  public bml svp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.sPY == null) {
        throw new b("Not all required fields were included: Topic");
      }
      if (this.sQa == null) {
        throw new b("Not all required fields were included: PYInitial");
      }
      if (this.sQb == null) {
        throw new b("Not all required fields were included: QuanPin");
      }
      if (this.svp == null) {
        throw new b("Not all required fields were included: ChatRoomName");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sPY != null)
      {
        paramVarArgs.gD(2, this.sPY.btq());
        this.sPY.a(paramVarArgs);
      }
      if (this.sQa != null)
      {
        paramVarArgs.gD(3, this.sQa.btq());
        this.sQa.a(paramVarArgs);
      }
      if (this.sQb != null)
      {
        paramVarArgs.gD(4, this.sQb.btq());
        this.sQb.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.dne);
      paramVarArgs.d(6, 8, this.svo);
      if (this.svp != null)
      {
        paramVarArgs.gD(7, this.svp.btq());
        this.svp.a(paramVarArgs);
      }
      if (this.svJ != null)
      {
        paramVarArgs.gD(8, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      if (this.sLD != null) {
        paramVarArgs.d(9, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(10, this.sLE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1500;
      }
    }
    label1500:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPY != null) {
        paramInt = i + d.a.a.a.gA(2, this.sPY.btq());
      }
      i = paramInt;
      if (this.sQa != null) {
        i = paramInt + d.a.a.a.gA(3, this.sQa.btq());
      }
      paramInt = i;
      if (this.sQb != null) {
        paramInt = i + d.a.a.a.gA(4, this.sQb.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.dne) + d.a.a.a.c(6, 8, this.svo);
      paramInt = i;
      if (this.svp != null) {
        paramInt = i + d.a.a.a.gA(7, this.svp.btq());
      }
      i = paramInt;
      if (this.svJ != null) {
        i = paramInt + d.a.a.a.gA(8, this.svJ.btq());
      }
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sLE);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.svo.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.sPY == null) {
          throw new b("Not all required fields were included: Topic");
        }
        if (this.sQa == null) {
          throw new b("Not all required fields were included: PYInitial");
        }
        if (this.sQb == null) {
          throw new b("Not all required fields were included: QuanPin");
        }
        if (this.svp == null) {
          throw new b("Not all required fields were included: ChatRoomName");
        }
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
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
            localrz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.sPY = ((bml)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.sQa = ((bml)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.sQb = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localrz.dne = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.svo.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.svp = ((bml)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localrz.svJ = ((bmk)localObject1);
            paramInt += 1;
          }
        case 9: 
          localrz.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localrz.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rz
 * JD-Core Version:    0.7.0.1
 */