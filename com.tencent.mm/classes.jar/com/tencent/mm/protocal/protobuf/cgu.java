package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cgu
  extends esc
{
  public String wuy;
  public String wws;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114021);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114021);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wuy != null) {
        paramVarArgs.g(2, this.wuy);
      }
      if (this.wws != null) {
        paramVarArgs.g(3, this.wws);
      }
      AppMethodBeat.o(114021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wuy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wuy);
      }
      i = paramInt;
      if (this.wws != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wws);
      }
      AppMethodBeat.o(114021);
      return i;
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
          AppMethodBeat.o(114021);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgu localcgu = (cgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114021);
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
            localcgu.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114021);
          return 0;
        case 2: 
          localcgu.wuy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114021);
          return 0;
        }
        localcgu.wws = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114021);
        return 0;
      }
      AppMethodBeat.o(114021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgu
 * JD-Core Version:    0.7.0.1
 */