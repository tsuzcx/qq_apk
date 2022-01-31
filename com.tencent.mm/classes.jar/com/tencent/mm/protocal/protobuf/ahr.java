package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ahr
  extends bvk
{
  public int wZQ;
  public nr wwA;
  public SKBuiltinBuffer_t wwB;
  public SKBuiltinBuffer_t wwC;
  public nr wwD;
  public int wwE;
  public nq wwF;
  public nq wwG;
  public nr wwy;
  public nr wwz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80070);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80070);
        throw paramVarArgs;
      }
      if (this.wwy == null)
      {
        paramVarArgs = new b("Not all required fields were included: DnsInfo");
        AppMethodBeat.o(80070);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wwy != null)
      {
        paramVarArgs.iQ(2, this.wwy.computeSize());
        this.wwy.writeFields(paramVarArgs);
      }
      if (this.wwz != null)
      {
        paramVarArgs.iQ(3, this.wwz.computeSize());
        this.wwz.writeFields(paramVarArgs);
      }
      if (this.wwA != null)
      {
        paramVarArgs.iQ(4, this.wwA.computeSize());
        this.wwA.writeFields(paramVarArgs);
      }
      if (this.wwB != null)
      {
        paramVarArgs.iQ(5, this.wwB.computeSize());
        this.wwB.writeFields(paramVarArgs);
      }
      if (this.wwC != null)
      {
        paramVarArgs.iQ(6, this.wwC.computeSize());
        this.wwC.writeFields(paramVarArgs);
      }
      if (this.wwD != null)
      {
        paramVarArgs.iQ(7, this.wwD.computeSize());
        this.wwD.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wwE);
      if (this.wwF != null)
      {
        paramVarArgs.iQ(9, this.wwF.computeSize());
        this.wwF.writeFields(paramVarArgs);
      }
      if (this.wwG != null)
      {
        paramVarArgs.iQ(10, this.wwG.computeSize());
        this.wwG.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.wZQ);
      AppMethodBeat.o(80070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wwy != null) {
        paramInt = i + e.a.a.a.iP(2, this.wwy.computeSize());
      }
      i = paramInt;
      if (this.wwz != null) {
        i = paramInt + e.a.a.a.iP(3, this.wwz.computeSize());
      }
      paramInt = i;
      if (this.wwA != null) {
        paramInt = i + e.a.a.a.iP(4, this.wwA.computeSize());
      }
      i = paramInt;
      if (this.wwB != null) {
        i = paramInt + e.a.a.a.iP(5, this.wwB.computeSize());
      }
      paramInt = i;
      if (this.wwC != null) {
        paramInt = i + e.a.a.a.iP(6, this.wwC.computeSize());
      }
      i = paramInt;
      if (this.wwD != null) {
        i = paramInt + e.a.a.a.iP(7, this.wwD.computeSize());
      }
      i += e.a.a.b.b.a.bl(8, this.wwE);
      paramInt = i;
      if (this.wwF != null) {
        paramInt = i + e.a.a.a.iP(9, this.wwF.computeSize());
      }
      i = paramInt;
      if (this.wwG != null) {
        i = paramInt + e.a.a.a.iP(10, this.wwG.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(11, this.wZQ);
      AppMethodBeat.o(80070);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80070);
          throw paramVarArgs;
        }
        if (this.wwy == null)
        {
          paramVarArgs = new b("Not all required fields were included: DnsInfo");
          AppMethodBeat.o(80070);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ahr localahr = (ahr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80070);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwy = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwz = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwA = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwD = ((nr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 8: 
          localahr.wwE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80070);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwF = ((nq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localahr.wwG = ((nq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80070);
          return 0;
        }
        localahr.wZQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80070);
        return 0;
      }
      AppMethodBeat.o(80070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahr
 * JD-Core Version:    0.7.0.1
 */