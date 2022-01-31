package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bix
  extends com.tencent.mm.bv.a
{
  public int id;
  public bml tCT;
  public bml tCU;
  public bml tCV;
  public bml tCW;
  public bml tCX;
  public bml tCY;
  public bml tCZ;
  public bml tDa;
  public bml tDb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tCU == null) {
        throw new b("Not all required fields were included: province");
      }
      if (this.tCV == null) {
        throw new b("Not all required fields were included: city");
      }
      if (this.tCW == null) {
        throw new b("Not all required fields were included: district");
      }
      if (this.tCX == null) {
        throw new b("Not all required fields were included: zipcode");
      }
      if (this.tCY == null) {
        throw new b("Not all required fields were included: detail");
      }
      if (this.tCZ == null) {
        throw new b("Not all required fields were included: name");
      }
      if (this.tDa == null) {
        throw new b("Not all required fields were included: phone");
      }
      paramVarArgs.gB(1, this.id);
      if (this.tCT != null)
      {
        paramVarArgs.gD(2, this.tCT.btq());
        this.tCT.a(paramVarArgs);
      }
      if (this.tCU != null)
      {
        paramVarArgs.gD(3, this.tCU.btq());
        this.tCU.a(paramVarArgs);
      }
      if (this.tCV != null)
      {
        paramVarArgs.gD(4, this.tCV.btq());
        this.tCV.a(paramVarArgs);
      }
      if (this.tCW != null)
      {
        paramVarArgs.gD(5, this.tCW.btq());
        this.tCW.a(paramVarArgs);
      }
      if (this.tCX != null)
      {
        paramVarArgs.gD(6, this.tCX.btq());
        this.tCX.a(paramVarArgs);
      }
      if (this.tCY != null)
      {
        paramVarArgs.gD(7, this.tCY.btq());
        this.tCY.a(paramVarArgs);
      }
      if (this.tCZ != null)
      {
        paramVarArgs.gD(8, this.tCZ.btq());
        this.tCZ.a(paramVarArgs);
      }
      if (this.tDa != null)
      {
        paramVarArgs.gD(9, this.tDa.btq());
        this.tDa.a(paramVarArgs);
      }
      if (this.tDb != null)
      {
        paramVarArgs.gD(10, this.tDb.btq());
        this.tDb.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.tCT != null) {
        paramInt = i + d.a.a.a.gA(2, this.tCT.btq());
      }
      i = paramInt;
      if (this.tCU != null) {
        i = paramInt + d.a.a.a.gA(3, this.tCU.btq());
      }
      paramInt = i;
      if (this.tCV != null) {
        paramInt = i + d.a.a.a.gA(4, this.tCV.btq());
      }
      i = paramInt;
      if (this.tCW != null) {
        i = paramInt + d.a.a.a.gA(5, this.tCW.btq());
      }
      paramInt = i;
      if (this.tCX != null) {
        paramInt = i + d.a.a.a.gA(6, this.tCX.btq());
      }
      i = paramInt;
      if (this.tCY != null) {
        i = paramInt + d.a.a.a.gA(7, this.tCY.btq());
      }
      paramInt = i;
      if (this.tCZ != null) {
        paramInt = i + d.a.a.a.gA(8, this.tCZ.btq());
      }
      i = paramInt;
      if (this.tDa != null) {
        i = paramInt + d.a.a.a.gA(9, this.tDa.btq());
      }
      paramInt = i;
    } while (this.tDb == null);
    return i + d.a.a.a.gA(10, this.tDb.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tCU == null) {
        throw new b("Not all required fields were included: province");
      }
      if (this.tCV == null) {
        throw new b("Not all required fields were included: city");
      }
      if (this.tCW == null) {
        throw new b("Not all required fields were included: district");
      }
      if (this.tCX == null) {
        throw new b("Not all required fields were included: zipcode");
      }
      if (this.tCY == null) {
        throw new b("Not all required fields were included: detail");
      }
      if (this.tCZ == null) {
        throw new b("Not all required fields were included: name");
      }
      if (this.tDa == null) {
        throw new b("Not all required fields were included: phone");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bix localbix = (bix)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbix.id = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localbix.tCT = ((bml)localObject1);
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
          localbix.tCU = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbix.tCV = ((bml)localObject1);
          paramInt += 1;
        }
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
          localbix.tCW = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbix.tCX = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbix.tCY = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbix.tCZ = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbix.tDa = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bml();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbix.tDb = ((bml)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bix
 * JD-Core Version:    0.7.0.1
 */