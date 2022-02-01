package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bat
  extends cvp
{
  public com.tencent.mm.bx.b GxI;
  public int GxJ;
  public com.tencent.mm.bx.b GxK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152569);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GxJ);
      if (this.GxK != null) {
        paramVarArgs.c(4, this.GxK);
      }
      if (this.GxI != null) {
        paramVarArgs.c(5, this.GxI);
      }
      AppMethodBeat.o(152569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.GxJ);
      paramInt = i;
      if (this.GxK != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GxK);
      }
      i = paramInt;
      if (this.GxI != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.GxI);
      }
      AppMethodBeat.o(152569);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bat localbat = (bat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(152569);
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
            localbat.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152569);
          return 0;
        case 3: 
          localbat.GxJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152569);
          return 0;
        case 4: 
          localbat.GxK = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(152569);
          return 0;
        }
        localbat.GxI = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(152569);
        return 0;
      }
      AppMethodBeat.o(152569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bat
 * JD-Core Version:    0.7.0.1
 */