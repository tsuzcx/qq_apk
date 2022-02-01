package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agp
  extends cwj
{
  public boolean GwP;
  public String GwQ;
  public String GwR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104762);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104762);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.GwP);
      if (this.GwQ != null) {
        paramVarArgs.d(3, this.GwQ);
      }
      if (this.GwR != null) {
        paramVarArgs.d(4, this.GwR);
      }
      AppMethodBeat.o(104762);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.GwQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GwQ);
      }
      i = paramInt;
      if (this.GwR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GwR);
      }
      AppMethodBeat.o(104762);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104762);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104762);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agp localagp = (agp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104762);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104762);
          return 0;
        case 2: 
          localagp.GwP = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(104762);
          return 0;
        case 3: 
          localagp.GwQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104762);
          return 0;
        }
        localagp.GwR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104762);
        return 0;
      }
      AppMethodBeat.o(104762);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agp
 * JD-Core Version:    0.7.0.1
 */