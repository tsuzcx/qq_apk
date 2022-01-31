package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public String Url;
  public int jKs;
  public String wmG;
  public String wmH;
  public String wmI;
  public at wmJ;
  public String wmK;
  public dj wmL;
  public dw wmM;
  public dv wmN;
  public dv wmO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94490);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      paramVarArgs.aO(3, this.Scene);
      if (this.wmG != null) {
        paramVarArgs.e(4, this.wmG);
      }
      if (this.wmH != null) {
        paramVarArgs.e(5, this.wmH);
      }
      if (this.wmI != null) {
        paramVarArgs.e(6, this.wmI);
      }
      if (this.wmJ != null)
      {
        paramVarArgs.iQ(7, this.wmJ.computeSize());
        this.wmJ.writeFields(paramVarArgs);
      }
      if (this.wmK != null) {
        paramVarArgs.e(8, this.wmK);
      }
      if (this.wmL != null)
      {
        paramVarArgs.iQ(9, this.wmL.computeSize());
        this.wmL.writeFields(paramVarArgs);
      }
      if (this.wmM != null)
      {
        paramVarArgs.iQ(10, this.wmM.computeSize());
        this.wmM.writeFields(paramVarArgs);
      }
      if (this.wmN != null)
      {
        paramVarArgs.iQ(11, this.wmN.computeSize());
        this.wmN.writeFields(paramVarArgs);
      }
      if (this.wmO != null)
      {
        paramVarArgs.iQ(12, this.wmO.computeSize());
        this.wmO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jKs) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.wmG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wmG);
      }
      i = paramInt;
      if (this.wmH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wmH);
      }
      paramInt = i;
      if (this.wmI != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wmI);
      }
      i = paramInt;
      if (this.wmJ != null) {
        i = paramInt + e.a.a.a.iP(7, this.wmJ.computeSize());
      }
      paramInt = i;
      if (this.wmK != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wmK);
      }
      i = paramInt;
      if (this.wmL != null) {
        i = paramInt + e.a.a.a.iP(9, this.wmL.computeSize());
      }
      paramInt = i;
      if (this.wmM != null) {
        paramInt = i + e.a.a.a.iP(10, this.wmM.computeSize());
      }
      i = paramInt;
      if (this.wmN != null) {
        i = paramInt + e.a.a.a.iP(11, this.wmN.computeSize());
      }
      paramInt = i;
      if (this.wmO != null) {
        paramInt = i + e.a.a.a.iP(12, this.wmO.computeSize());
      }
      AppMethodBeat.o(94490);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      av localav = (av)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(94490);
        return -1;
      case 1: 
        localav.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94490);
        return 0;
      case 2: 
        localav.Url = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94490);
        return 0;
      case 3: 
        localav.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94490);
        return 0;
      case 4: 
        localav.wmG = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94490);
        return 0;
      case 5: 
        localav.wmH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94490);
        return 0;
      case 6: 
        localav.wmI = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94490);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new at();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((at)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localav.wmJ = ((at)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94490);
        return 0;
      case 8: 
        localav.wmK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94490);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localav.wmL = ((dj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94490);
        return 0;
      case 10: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localav.wmM = ((dw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94490);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localav.wmN = ((dv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94490);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dv();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localav.wmO = ((dv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(94490);
      return 0;
    }
    AppMethodBeat.o(94490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.av
 * JD-Core Version:    0.7.0.1
 */