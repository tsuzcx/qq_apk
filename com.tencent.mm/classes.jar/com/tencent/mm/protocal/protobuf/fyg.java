package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyg
  extends esc
{
  public int aaqo;
  public com.tencent.mm.bx.b abWh;
  public String abWi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257693);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257693);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abWh != null) {
        paramVarArgs.d(2, this.abWh);
      }
      paramVarArgs.bS(3, this.aaqo);
      if (this.abWi != null) {
        paramVarArgs.g(4, this.abWi);
      }
      AppMethodBeat.o(257693);
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
      int i = paramInt;
      if (this.abWh != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.abWh);
      }
      i += i.a.a.b.b.a.cJ(3, this.aaqo);
      paramInt = i;
      if (this.abWi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abWi);
      }
      AppMethodBeat.o(257693);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257693);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fyg localfyg = (fyg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257693);
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
            localfyg.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257693);
          return 0;
        case 2: 
          localfyg.abWh = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(257693);
          return 0;
        case 3: 
          localfyg.aaqo = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257693);
          return 0;
        }
        localfyg.abWi = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257693);
        return 0;
      }
      AppMethodBeat.o(257693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyg
 * JD-Core Version:    0.7.0.1
 */