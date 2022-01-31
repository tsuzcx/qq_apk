package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aly
  extends buy
{
  public int Scene;
  public azt wOE;
  public String wXt;
  public int wsW;
  public SKBuiltinBuffer_t xcE;
  public int xcF;
  public int xcG;
  public LinkedList<bmj> xcH;
  public int xcI;
  
  public aly()
  {
    AppMethodBeat.i(28445);
    this.xcH = new LinkedList();
    AppMethodBeat.o(28445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28446);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(28446);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wsW);
      paramVarArgs.aO(3, this.Scene);
      if (this.xcE != null)
      {
        paramVarArgs.iQ(4, this.xcE.computeSize());
        this.xcE.writeFields(paramVarArgs);
      }
      if (this.wOE != null)
      {
        paramVarArgs.iQ(5, this.wOE.computeSize());
        this.wOE.writeFields(paramVarArgs);
      }
      if (this.wXt != null) {
        paramVarArgs.e(6, this.wXt);
      }
      paramVarArgs.aO(7, this.xcF);
      paramVarArgs.aO(8, this.xcG);
      paramVarArgs.e(11, 8, this.xcH);
      paramVarArgs.aO(12, this.xcI);
      AppMethodBeat.o(28446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsW) + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.xcE != null) {
        paramInt = i + e.a.a.a.iP(4, this.xcE.computeSize());
      }
      i = paramInt;
      if (this.wOE != null) {
        i = paramInt + e.a.a.a.iP(5, this.wOE.computeSize());
      }
      paramInt = i;
      if (this.wXt != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wXt);
      }
      i = e.a.a.b.b.a.bl(7, this.xcF);
      int j = e.a.a.b.b.a.bl(8, this.xcG);
      int k = e.a.a.a.c(11, 8, this.xcH);
      int m = e.a.a.b.b.a.bl(12, this.xcI);
      AppMethodBeat.o(28446);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(28446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aly localaly = (aly)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(28446);
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
            localaly.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28446);
          return 0;
        case 2: 
          localaly.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28446);
          return 0;
        case 3: 
          localaly.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28446);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaly.xcE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28446);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaly.wOE = ((azt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28446);
          return 0;
        case 6: 
          localaly.wXt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28446);
          return 0;
        case 7: 
          localaly.xcF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28446);
          return 0;
        case 8: 
          localaly.xcG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28446);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaly.xcH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28446);
          return 0;
        }
        localaly.xcI = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28446);
        return 0;
      }
      AppMethodBeat.o(28446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aly
 * JD-Core Version:    0.7.0.1
 */