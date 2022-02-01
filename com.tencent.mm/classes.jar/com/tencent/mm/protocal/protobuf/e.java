package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class e
  extends esc
{
  public String YzN;
  public int hAV = 268513600;
  public String wYI = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91314);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91314);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.YzN != null) {
        paramVarArgs.g(4, this.YzN);
      }
      AppMethodBeat.o(91314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.YzN != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YzN);
      }
      AppMethodBeat.o(91314);
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
          AppMethodBeat.o(91314);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91314);
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
            locale.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(91314);
          return 0;
        case 2: 
          locale.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91314);
          return 0;
        case 3: 
          locale.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91314);
          return 0;
        }
        locale.YzN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91314);
        return 0;
      }
      AppMethodBeat.o(91314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.e
 * JD-Core Version:    0.7.0.1
 */