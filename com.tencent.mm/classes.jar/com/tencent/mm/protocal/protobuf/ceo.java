package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ceo
  extends esc
{
  public int aaoB;
  public com.tencent.mm.bx.b wuZ;
  public String wuy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114001);
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
      paramVarArgs.bS(3, this.aaoB);
      if (this.wuZ != null) {
        paramVarArgs.d(4, this.wuZ);
      }
      AppMethodBeat.o(114001);
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
      if (this.wuy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wuy);
      }
      i += i.a.a.b.b.a.cJ(3, this.aaoB);
      paramInt = i;
      if (this.wuZ != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.wuZ);
      }
      AppMethodBeat.o(114001);
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
          AppMethodBeat.o(114001);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114001);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ceo localceo = (ceo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114001);
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
            localceo.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114001);
          return 0;
        case 2: 
          localceo.wuy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114001);
          return 0;
        case 3: 
          localceo.aaoB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114001);
          return 0;
        }
        localceo.wuZ = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(114001);
        return 0;
      }
      AppMethodBeat.o(114001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceo
 * JD-Core Version:    0.7.0.1
 */