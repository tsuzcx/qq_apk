package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class crb
  extends buy
{
  public int fKi;
  public String jJA;
  public SKBuiltinBuffer_t pIA;
  public int wrs;
  public int wrv;
  public int wzS;
  public String xWW;
  public int xWX;
  public int xWY;
  public int xZG;
  public int xZH;
  public LinkedList<bwc> xZI;
  public LinkedList<SKBuiltinBuffer_t> xZJ;
  
  public crb()
  {
    AppMethodBeat.i(116813);
    this.xZI = new LinkedList();
    this.xZJ = new LinkedList();
    AppMethodBeat.o(116813);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116814);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116814);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(3, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wzS);
      if (this.xWW != null) {
        paramVarArgs.e(5, this.xWW);
      }
      paramVarArgs.aO(6, this.fKi);
      paramVarArgs.aO(7, this.xWX);
      paramVarArgs.aO(8, this.wrv);
      paramVarArgs.aO(9, this.xWY);
      paramVarArgs.aO(10, this.wrs);
      paramVarArgs.aO(11, this.xZG);
      paramVarArgs.aO(12, this.xZH);
      paramVarArgs.e(13, 8, this.xZI);
      paramVarArgs.e(14, 8, this.xZJ);
      AppMethodBeat.o(116814);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(3, this.pIA.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.wzS);
      paramInt = i;
      if (this.xWW != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xWW);
      }
      i = e.a.a.b.b.a.bl(6, this.fKi);
      int j = e.a.a.b.b.a.bl(7, this.xWX);
      int k = e.a.a.b.b.a.bl(8, this.wrv);
      int m = e.a.a.b.b.a.bl(9, this.xWY);
      int n = e.a.a.b.b.a.bl(10, this.wrs);
      int i1 = e.a.a.b.b.a.bl(11, this.xZG);
      int i2 = e.a.a.b.b.a.bl(12, this.xZH);
      int i3 = e.a.a.a.c(13, 8, this.xZI);
      int i4 = e.a.a.a.c(14, 8, this.xZJ);
      AppMethodBeat.o(116814);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xZI.clear();
        this.xZJ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(116814);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116814);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crb localcrb = (crb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116814);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116814);
          return 0;
        case 2: 
          localcrb.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116814);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrb.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116814);
          return 0;
        case 4: 
          localcrb.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 5: 
          localcrb.xWW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116814);
          return 0;
        case 6: 
          localcrb.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 7: 
          localcrb.xWX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 8: 
          localcrb.wrv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 9: 
          localcrb.xWY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 10: 
          localcrb.wrs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 11: 
          localcrb.xZG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 12: 
          localcrb.xZH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116814);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrb.xZI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116814);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcrb.xZJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116814);
        return 0;
      }
      AppMethodBeat.o(116814);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crb
 * JD-Core Version:    0.7.0.1
 */