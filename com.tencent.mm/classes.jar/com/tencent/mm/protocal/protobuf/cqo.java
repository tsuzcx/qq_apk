package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqo
  extends esc
{
  public String fileid;
  public String nickname;
  public String rHi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152595);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.rHi != null) {
        paramVarArgs.g(3, this.rHi);
      }
      if (this.fileid != null) {
        paramVarArgs.g(4, this.fileid);
      }
      AppMethodBeat.o(152595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.rHi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rHi);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.fileid);
      }
      AppMethodBeat.o(152595);
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
          AppMethodBeat.o(152595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cqo localcqo = (cqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152595);
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
            localcqo.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(152595);
          return 0;
        case 2: 
          localcqo.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152595);
          return 0;
        case 3: 
          localcqo.rHi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152595);
          return 0;
        }
        localcqo.fileid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152595);
        return 0;
      }
      AppMethodBeat.o(152595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqo
 * JD-Core Version:    0.7.0.1
 */