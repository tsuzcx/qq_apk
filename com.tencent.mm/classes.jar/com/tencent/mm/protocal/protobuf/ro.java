package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ro
  extends esc
{
  public int Tps;
  public elf YRW;
  public com.tencent.mm.bx.b YWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257615);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257615);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Tps);
      if (this.YWy != null) {
        paramVarArgs.d(3, this.YWy);
      }
      if (this.YRW != null)
      {
        paramVarArgs.qD(4, this.YRW.computeSize());
        this.YRW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Tps);
      paramInt = i;
      if (this.YWy != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YWy);
      }
      i = paramInt;
      if (this.YRW != null) {
        i = paramInt + i.a.a.a.qC(4, this.YRW.computeSize());
      }
      AppMethodBeat.o(257615);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257615);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ro localro = (ro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257615);
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
            localro.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257615);
          return 0;
        case 2: 
          localro.Tps = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257615);
          return 0;
        case 3: 
          localro.YWy = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257615);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elf)localObject2).parseFrom((byte[])localObject1);
          }
          localro.YRW = ((elf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257615);
        return 0;
      }
      AppMethodBeat.o(257615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ro
 * JD-Core Version:    0.7.0.1
 */