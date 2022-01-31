package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class anj
  extends buy
{
  public int OpCode;
  public int Scene;
  public String wXt;
  public double wyO;
  public double wyP;
  public SKBuiltinBuffer_t xcE;
  public int xcG;
  public double xdJ;
  public double xdK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113782);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xcE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(113782);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Scene);
      paramVarArgs.aO(3, this.OpCode);
      if (this.wXt != null) {
        paramVarArgs.e(4, this.wXt);
      }
      if (this.xcE != null)
      {
        paramVarArgs.iQ(5, this.xcE.computeSize());
        this.xcE.writeFields(paramVarArgs);
      }
      paramVarArgs.f(6, this.wyO);
      paramVarArgs.f(7, this.wyP);
      paramVarArgs.f(8, this.xdJ);
      paramVarArgs.f(9, this.xdK);
      paramVarArgs.aO(10, this.xcG);
      AppMethodBeat.o(113782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Scene) + e.a.a.b.b.a.bl(3, this.OpCode);
      paramInt = i;
      if (this.wXt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXt);
      }
      i = paramInt;
      if (this.xcE != null) {
        i = paramInt + e.a.a.a.iP(5, this.xcE.computeSize());
      }
      paramInt = e.a.a.b.b.a.eW(6);
      int j = e.a.a.b.b.a.eW(7);
      int k = e.a.a.b.b.a.eW(8);
      int m = e.a.a.b.b.a.eW(9);
      int n = e.a.a.b.b.a.bl(10, this.xcG);
      AppMethodBeat.o(113782);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xcE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(113782);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        anj localanj = (anj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113782);
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
            localanj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113782);
          return 0;
        case 2: 
          localanj.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113782);
          return 0;
        case 3: 
          localanj.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113782);
          return 0;
        case 4: 
          localanj.wXt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113782);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localanj.xcE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113782);
          return 0;
        case 6: 
          localanj.wyO = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(113782);
          return 0;
        case 7: 
          localanj.wyP = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(113782);
          return 0;
        case 8: 
          localanj.xdJ = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(113782);
          return 0;
        case 9: 
          localanj.xdK = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(113782);
          return 0;
        }
        localanj.xcG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(113782);
        return 0;
      }
      AppMethodBeat.o(113782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anj
 * JD-Core Version:    0.7.0.1
 */