package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dmm
  extends esc
{
  public String wsl;
  public int wsm;
  public String wsn;
  public String wuy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114045);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114045);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wsl != null) {
        paramVarArgs.g(2, this.wsl);
      }
      paramVarArgs.bS(3, this.wsm);
      if (this.wsn != null) {
        paramVarArgs.g(4, this.wsn);
      }
      if (this.wuy != null) {
        paramVarArgs.g(5, this.wuy);
      }
      AppMethodBeat.o(114045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wsl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wsl);
      }
      i += i.a.a.b.b.a.cJ(3, this.wsm);
      paramInt = i;
      if (this.wsn != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wsn);
      }
      i = paramInt;
      if (this.wuy != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.wuy);
      }
      AppMethodBeat.o(114045);
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
          AppMethodBeat.o(114045);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dmm localdmm = (dmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114045);
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
            localdmm.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114045);
          return 0;
        case 2: 
          localdmm.wsl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114045);
          return 0;
        case 3: 
          localdmm.wsm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114045);
          return 0;
        case 4: 
          localdmm.wsn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114045);
          return 0;
        }
        localdmm.wuy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114045);
        return 0;
      }
      AppMethodBeat.o(114045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmm
 * JD-Core Version:    0.7.0.1
 */