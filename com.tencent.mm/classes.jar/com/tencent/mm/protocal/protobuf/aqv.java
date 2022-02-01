package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aqv
  extends esc
{
  public String ZxQ;
  public String ZxX;
  public String ZxY;
  public boolean Zyi = true;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104364);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104364);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZxY != null) {
        paramVarArgs.g(2, this.ZxY);
      }
      paramVarArgs.di(3, this.Zyi);
      if (this.ZxQ != null) {
        paramVarArgs.g(4, this.ZxQ);
      }
      if (this.ZxX != null) {
        paramVarArgs.g(5, this.ZxX);
      }
      AppMethodBeat.o(104364);
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
      if (this.ZxY != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZxY);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.ZxQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZxQ);
      }
      i = paramInt;
      if (this.ZxX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZxX);
      }
      AppMethodBeat.o(104364);
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
          AppMethodBeat.o(104364);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104364);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqv localaqv = (aqv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104364);
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
            localaqv.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(104364);
          return 0;
        case 2: 
          localaqv.ZxY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104364);
          return 0;
        case 3: 
          localaqv.Zyi = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(104364);
          return 0;
        case 4: 
          localaqv.ZxQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104364);
          return 0;
        }
        localaqv.ZxX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104364);
        return 0;
      }
      AppMethodBeat.o(104364);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqv
 * JD-Core Version:    0.7.0.1
 */