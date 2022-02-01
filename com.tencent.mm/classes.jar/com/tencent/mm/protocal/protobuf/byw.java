package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byw
  extends cwj
{
  public String oEb;
  public int oEc;
  public String oEd;
  public String oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114045);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114045);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oEb != null) {
        paramVarArgs.d(2, this.oEb);
      }
      paramVarArgs.aS(3, this.oEc);
      if (this.oEd != null) {
        paramVarArgs.d(4, this.oEd);
      }
      if (this.oGs != null) {
        paramVarArgs.d(5, this.oGs);
      }
      AppMethodBeat.o(114045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oEb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oEb);
      }
      i += f.a.a.b.b.a.bz(3, this.oEc);
      paramInt = i;
      if (this.oEd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oEd);
      }
      i = paramInt;
      if (this.oGs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oGs);
      }
      AppMethodBeat.o(114045);
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
          AppMethodBeat.o(114045);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byw localbyw = (byw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114045);
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
            localbyw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114045);
          return 0;
        case 2: 
          localbyw.oEb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114045);
          return 0;
        case 3: 
          localbyw.oEc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114045);
          return 0;
        case 4: 
          localbyw.oEd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114045);
          return 0;
        }
        localbyw.oGs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(114045);
        return 0;
      }
      AppMethodBeat.o(114045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byw
 * JD-Core Version:    0.7.0.1
 */