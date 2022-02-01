package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dep
  extends esc
{
  public com.tencent.mm.bx.b YJa;
  public dix ZOg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(2, this.YJa);
      }
      if (this.ZOg != null)
      {
        paramVarArgs.qD(3, this.ZOg.computeSize());
        this.ZOg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258510);
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
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.YJa);
      }
      i = paramInt;
      if (this.ZOg != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZOg.computeSize());
      }
      AppMethodBeat.o(258510);
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
          AppMethodBeat.o(258510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dep localdep = (dep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258510);
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
            localdep.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258510);
          return 0;
        case 2: 
          localdep.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258510);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dix();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dix)localObject2).parseFrom((byte[])localObject1);
          }
          localdep.ZOg = ((dix)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258510);
        return 0;
      }
      AppMethodBeat.o(258510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dep
 * JD-Core Version:    0.7.0.1
 */