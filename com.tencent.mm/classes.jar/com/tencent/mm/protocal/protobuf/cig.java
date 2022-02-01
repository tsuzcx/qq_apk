package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cig
  extends esc
{
  public String pSg;
  public String pSh;
  public String pSo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32237);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32237);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(2, this.pSo);
      }
      if (this.pSg != null) {
        paramVarArgs.g(3, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(4, this.pSh);
      }
      AppMethodBeat.o(32237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSo);
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSh);
      }
      AppMethodBeat.o(32237);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32237);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cig localcig = (cig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32237);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcig.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(32237);
          return 0;
        case 2: 
          localcig.pSo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32237);
          return 0;
        case 3: 
          localcig.pSg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32237);
          return 0;
        }
        localcig.pSh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32237);
        return 0;
      }
      AppMethodBeat.o(32237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cig
 * JD-Core Version:    0.7.0.1
 */