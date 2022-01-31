package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgm
  extends buy
{
  public int wzP;
  public SKBuiltinBuffer_t wzQ;
  public int wzT;
  public int wzU;
  public String xvM;
  public String xvN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(81505);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImageBuffer");
        AppMethodBeat.o(81505);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wzP);
      if (this.wzQ != null)
      {
        paramVarArgs.iQ(3, this.wzQ.computeSize());
        this.wzQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wzT);
      if (this.xvM != null) {
        paramVarArgs.e(5, this.xvM);
      }
      if (this.xvN != null) {
        paramVarArgs.e(6, this.xvN);
      }
      paramVarArgs.aO(7, this.wzU);
      AppMethodBeat.o(81505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wzP);
      paramInt = i;
      if (this.wzQ != null) {
        paramInt = i + e.a.a.a.iP(3, this.wzQ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wzT);
      paramInt = i;
      if (this.xvM != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xvM);
      }
      i = paramInt;
      if (this.xvN != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xvN);
      }
      paramInt = e.a.a.b.b.a.bl(7, this.wzU);
      AppMethodBeat.o(81505);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wzQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImageBuffer");
          AppMethodBeat.o(81505);
          throw paramVarArgs;
        }
        AppMethodBeat.o(81505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgm localbgm = (bgm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(81505);
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
            localbgm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(81505);
          return 0;
        case 2: 
          localbgm.wzP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81505);
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
            localbgm.wzQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(81505);
          return 0;
        case 4: 
          localbgm.wzT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(81505);
          return 0;
        case 5: 
          localbgm.xvM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81505);
          return 0;
        case 6: 
          localbgm.xvN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(81505);
          return 0;
        }
        localbgm.wzU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(81505);
        return 0;
      }
      AppMethodBeat.o(81505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgm
 * JD-Core Version:    0.7.0.1
 */