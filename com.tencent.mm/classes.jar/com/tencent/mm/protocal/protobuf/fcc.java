package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fcc
  extends esc
{
  public fca abBE;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153303);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153303);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abBE != null)
      {
        paramVarArgs.qD(2, this.abBE.computeSize());
        this.abBE.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      AppMethodBeat.o(153303);
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
      if (this.abBE != null) {
        paramInt = i + i.a.a.a.qC(2, this.abBE.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      AppMethodBeat.o(153303);
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
          AppMethodBeat.o(153303);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153303);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fcc localfcc = (fcc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153303);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfcc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153303);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fca)localObject2).parseFrom((byte[])localObject1);
            }
            localfcc.abBE = ((fca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153303);
          return 0;
        }
        localfcc.username = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(153303);
        return 0;
      }
      AppMethodBeat.o(153303);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcc
 * JD-Core Version:    0.7.0.1
 */