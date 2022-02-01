package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bwu
  extends cvp
{
  public String GQM;
  public int type;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124536);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.type);
      if (this.version != null) {
        paramVarArgs.d(3, this.version);
      }
      if (this.GQM != null) {
        paramVarArgs.d(4, this.GQM);
      }
      AppMethodBeat.o(124536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.version);
      }
      i = paramInt;
      if (this.GQM != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GQM);
      }
      AppMethodBeat.o(124536);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwu localbwu = (bwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124536);
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
            localbwu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124536);
          return 0;
        case 2: 
          localbwu.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124536);
          return 0;
        case 3: 
          localbwu.version = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124536);
          return 0;
        }
        localbwu.GQM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124536);
        return 0;
      }
      AppMethodBeat.o(124536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwu
 * JD-Core Version:    0.7.0.1
 */