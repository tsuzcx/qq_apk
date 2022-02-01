package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aqq
  extends cvp
{
  public String FAE;
  public b GoI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169040);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GoI != null) {
        paramVarArgs.c(2, this.GoI);
      }
      if (this.FAE != null) {
        paramVarArgs.d(3, this.FAE);
      }
      AppMethodBeat.o(169040);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GoI != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GoI);
      }
      i = paramInt;
      if (this.FAE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAE);
      }
      AppMethodBeat.o(169040);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169040);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqq localaqq = (aqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169040);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169040);
          return 0;
        case 2: 
          localaqq.GoI = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(169040);
          return 0;
        }
        localaqq.FAE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169040);
        return 0;
      }
      AppMethodBeat.o(169040);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqq
 * JD-Core Version:    0.7.0.1
 */