package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cd
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public int kSW;
  public int mPL;
  public int ndm;
  public long ndp;
  public bml svF;
  public bml svG;
  public bml svH;
  public int svI;
  public bmk svJ;
  public String svK;
  public String svL;
  public int svM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.svH == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      paramVarArgs.gB(1, this.ndm);
      if (this.svF != null)
      {
        paramVarArgs.gD(2, this.svF.btq());
        this.svF.a(paramVarArgs);
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(3, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.kSW);
      if (this.svH != null)
      {
        paramVarArgs.gD(5, this.svH.btq());
        this.svH.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.hQq);
      paramVarArgs.gB(7, this.svI);
      if (this.svJ != null)
      {
        paramVarArgs.gD(8, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.mPL);
      if (this.svK != null) {
        paramVarArgs.d(10, this.svK);
      }
      if (this.svL != null) {
        paramVarArgs.d(11, this.svL);
      }
      paramVarArgs.Y(12, this.ndp);
      paramVarArgs.gB(13, this.svM);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.ndm) + 0;
      paramInt = i;
      if (this.svF != null) {
        paramInt = i + d.a.a.a.gA(2, this.svF.btq());
      }
      i = paramInt;
      if (this.svG != null) {
        i = paramInt + d.a.a.a.gA(3, this.svG.btq());
      }
      i += d.a.a.a.gy(4, this.kSW);
      paramInt = i;
      if (this.svH != null) {
        paramInt = i + d.a.a.a.gA(5, this.svH.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.hQq) + d.a.a.a.gy(7, this.svI);
      paramInt = i;
      if (this.svJ != null) {
        paramInt = i + d.a.a.a.gA(8, this.svJ.btq());
      }
      i = paramInt + d.a.a.a.gy(9, this.mPL);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.svK);
      }
      i = paramInt;
      if (this.svL != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.svL);
      }
      return i + d.a.a.a.X(12, this.ndp) + d.a.a.a.gy(13, this.svM);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.svH == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cd localcd = (cd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcd.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcd.svF = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcd.svG = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localcd.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcd.svH = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localcd.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localcd.svI = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcd.svJ = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 9: 
        localcd.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localcd.svK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 11: 
        localcd.svL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localcd.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      localcd.svM = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cd
 * JD-Core Version:    0.7.0.1
 */