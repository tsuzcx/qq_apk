package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cof
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116807);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(116807);
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
      AppMethodBeat.o(116807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
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
      AppMethodBeat.o(116807);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(116807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cof localcof = (cof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116807);
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
            localcof.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116807);
          return 0;
        case 2: 
          localcof.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116807);
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
            localcof.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116807);
          return 0;
        case 4: 
          localcof.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116807);
          return 0;
        case 5: 
          localcof.xWW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116807);
          return 0;
        case 6: 
          localcof.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116807);
          return 0;
        case 7: 
          localcof.xWX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116807);
          return 0;
        case 8: 
          localcof.wrv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116807);
          return 0;
        case 9: 
          localcof.xWY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116807);
          return 0;
        }
        localcof.wrs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116807);
        return 0;
      }
      AppMethodBeat.o(116807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cof
 * JD-Core Version:    0.7.0.1
 */