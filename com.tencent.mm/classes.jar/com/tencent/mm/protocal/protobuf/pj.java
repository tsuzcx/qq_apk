package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pj
  extends cwj
{
  public cqt FZD;
  public int GcW;
  public com.tencent.mm.bw.b GcX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(188947);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GcW);
      if (this.GcX != null) {
        paramVarArgs.c(3, this.GcX);
      }
      if (this.FZD != null)
      {
        paramVarArgs.lJ(4, this.FZD.computeSize());
        this.FZD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(188947);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GcW);
      paramInt = i;
      if (this.GcX != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GcX);
      }
      i = paramInt;
      if (this.FZD != null) {
        i = paramInt + f.a.a.a.lI(4, this.FZD.computeSize());
      }
      AppMethodBeat.o(188947);
      return i;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(188947);
          throw paramVarArgs;
        }
        AppMethodBeat.o(188947);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pj localpj = (pj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188947);
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
            localpj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188947);
          return 0;
        case 2: 
          localpj.GcW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188947);
          return 0;
        case 3: 
          localpj.GcX = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(188947);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpj.FZD = ((cqt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188947);
        return 0;
      }
      AppMethodBeat.o(188947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pj
 * JD-Core Version:    0.7.0.1
 */