package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dmh
  extends com.tencent.mm.bx.a
{
  public dmi aaSr;
  public dmg aaSs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133177);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaSr == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.aaSs == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.aaSr != null)
      {
        paramVarArgs.qD(1, this.aaSr.computeSize());
        this.aaSr.writeFields(paramVarArgs);
      }
      if (this.aaSs != null)
      {
        paramVarArgs.qD(2, this.aaSs.computeSize());
        this.aaSs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaSr == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.aaSr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaSs != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaSs.computeSize());
      }
      AppMethodBeat.o(133177);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaSr == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        if (this.aaSs == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dmh localdmh = (dmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133177);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmi)localObject2).parseFrom((byte[])localObject1);
            }
            localdmh.aaSr = ((dmi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133177);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmg)localObject2).parseFrom((byte[])localObject1);
          }
          localdmh.aaSs = ((dmg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      AppMethodBeat.o(133177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmh
 * JD-Core Version:    0.7.0.1
 */