package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class nr
  extends com.tencent.mm.bv.a
{
  public int lGw;
  public int wCN;
  public int wCO;
  public int wCP;
  public int wCQ;
  public LinkedList<bwc> wCR;
  public String wCS;
  public SKBuiltinBuffer_t wCT;
  public int wCU;
  public int wCV;
  public LinkedList<bwc> wCW;
  public LinkedList<ns> wCX;
  public LinkedList<ns> wCY;
  public int wCZ;
  public int wDa;
  
  public nr()
  {
    AppMethodBeat.i(58898);
    this.wCR = new LinkedList();
    this.wCW = new LinkedList();
    this.wCX = new LinkedList();
    this.wCY = new LinkedList();
    AppMethodBeat.o(58898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58899);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wCT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(58899);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wCN);
      paramVarArgs.aO(2, this.lGw);
      paramVarArgs.aO(3, this.wCO);
      paramVarArgs.aO(4, this.wCP);
      paramVarArgs.aO(5, this.wCQ);
      paramVarArgs.e(6, 8, this.wCR);
      if (this.wCS != null) {
        paramVarArgs.e(7, this.wCS);
      }
      if (this.wCT != null)
      {
        paramVarArgs.iQ(8, this.wCT.computeSize());
        this.wCT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.wCU);
      paramVarArgs.aO(10, this.wCV);
      paramVarArgs.e(11, 8, this.wCW);
      paramVarArgs.e(12, 8, this.wCX);
      paramVarArgs.e(13, 8, this.wCY);
      paramVarArgs.aO(14, this.wCZ);
      paramVarArgs.aO(15, this.wDa);
      AppMethodBeat.o(58899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wCN) + 0 + e.a.a.b.b.a.bl(2, this.lGw) + e.a.a.b.b.a.bl(3, this.wCO) + e.a.a.b.b.a.bl(4, this.wCP) + e.a.a.b.b.a.bl(5, this.wCQ) + e.a.a.a.c(6, 8, this.wCR);
      paramInt = i;
      if (this.wCS != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wCS);
      }
      i = paramInt;
      if (this.wCT != null) {
        i = paramInt + e.a.a.a.iP(8, this.wCT.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(9, this.wCU);
      int j = e.a.a.b.b.a.bl(10, this.wCV);
      int k = e.a.a.a.c(11, 8, this.wCW);
      int m = e.a.a.a.c(12, 8, this.wCX);
      int n = e.a.a.a.c(13, 8, this.wCY);
      int i1 = e.a.a.b.b.a.bl(14, this.wCZ);
      int i2 = e.a.a.b.b.a.bl(15, this.wDa);
      AppMethodBeat.o(58899);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wCR.clear();
      this.wCW.clear();
      this.wCX.clear();
      this.wCY.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wCT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(58899);
        throw paramVarArgs;
      }
      AppMethodBeat.o(58899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      nr localnr = (nr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(58899);
        return -1;
      case 1: 
        localnr.wCN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 2: 
        localnr.lGw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 3: 
        localnr.wCO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 4: 
        localnr.wCP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 5: 
        localnr.wCQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnr.wCR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58899);
        return 0;
      case 7: 
        localnr.wCS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58899);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnr.wCT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58899);
        return 0;
      case 9: 
        localnr.wCU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 10: 
        localnr.wCV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnr.wCW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58899);
        return 0;
      case 12: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ns();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ns)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnr.wCX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58899);
        return 0;
      case 13: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ns();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ns)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnr.wCY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58899);
        return 0;
      case 14: 
        localnr.wCZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58899);
        return 0;
      }
      localnr.wDa = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(58899);
      return 0;
    }
    AppMethodBeat.o(58899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nr
 * JD-Core Version:    0.7.0.1
 */