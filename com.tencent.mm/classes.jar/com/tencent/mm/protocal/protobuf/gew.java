package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gew
  extends esc
{
  public String hMi;
  public int interval;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121114);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hMi != null) {
        paramVarArgs.g(2, this.hMi);
      }
      paramVarArgs.bS(3, this.interval);
      AppMethodBeat.o(121114);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hMi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.hMi);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.interval);
      AppMethodBeat.o(121114);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(121114);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gew localgew = (gew)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121114);
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
            localgew.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(121114);
          return 0;
        case 2: 
          localgew.hMi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(121114);
          return 0;
        }
        localgew.interval = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(121114);
        return 0;
      }
      AppMethodBeat.o(121114);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gew
 * JD-Core Version:    0.7.0.1
 */