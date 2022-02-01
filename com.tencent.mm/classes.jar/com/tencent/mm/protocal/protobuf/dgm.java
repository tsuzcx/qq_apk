package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgm
  extends cwj
{
  public SKBuiltinBuffer_t FTj;
  public String HNG;
  public int nJA;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125783);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.FTj != null)
      {
        paramVarArgs.lJ(4, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      if (this.HNG != null) {
        paramVarArgs.d(5, this.HNG);
      }
      paramVarArgs.aS(6, this.nJA);
      AppMethodBeat.o(125783);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lI(4, this.FTj.computeSize());
      }
      i = paramInt;
      if (this.HNG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HNG);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.nJA);
      AppMethodBeat.o(125783);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        if (this.FTj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125783);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgm localdgm = (dgm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125783);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 2: 
          localdgm.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125783);
          return 0;
        case 3: 
          localdgm.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125783);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgm.FTj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 5: 
          localdgm.HNG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125783);
          return 0;
        }
        localdgm.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125783);
        return 0;
      }
      AppMethodBeat.o(125783);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgm
 * JD-Core Version:    0.7.0.1
 */