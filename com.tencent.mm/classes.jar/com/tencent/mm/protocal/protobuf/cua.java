package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cua
  extends esc
{
  public String YEv;
  public fqn aazA;
  public String iaI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257933);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257933);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iaI != null) {
        paramVarArgs.g(2, this.iaI);
      }
      if (this.YEv != null) {
        paramVarArgs.g(3, this.YEv);
      }
      if (this.aazA != null)
      {
        paramVarArgs.qD(4, this.aazA.computeSize());
        this.aazA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257933);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.iaI);
      }
      i = paramInt;
      if (this.YEv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YEv);
      }
      paramInt = i;
      if (this.aazA != null) {
        paramInt = i + i.a.a.a.qC(4, this.aazA.computeSize());
      }
      AppMethodBeat.o(257933);
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
          AppMethodBeat.o(257933);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257933);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cua localcua = (cua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257933);
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
            localcua.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257933);
          return 0;
        case 2: 
          localcua.iaI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257933);
          return 0;
        case 3: 
          localcua.YEv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257933);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqn)localObject2).parseFrom((byte[])localObject1);
          }
          localcua.aazA = ((fqn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257933);
        return 0;
      }
      AppMethodBeat.o(257933);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cua
 * JD-Core Version:    0.7.0.1
 */