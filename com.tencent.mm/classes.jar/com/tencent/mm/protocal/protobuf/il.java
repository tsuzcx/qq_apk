package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class il
  extends com.tencent.mm.bx.a
{
  public im YKg;
  public ij YKh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133148);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKg == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.YKh == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133148);
        throw paramVarArgs;
      }
      if (this.YKg != null)
      {
        paramVarArgs.qD(1, this.YKg.computeSize());
        this.YKg.writeFields(paramVarArgs);
      }
      if (this.YKh != null)
      {
        paramVarArgs.qD(2, this.YKh.computeSize());
        this.YKh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YKg == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.YKg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YKh != null) {
        i = paramInt + i.a.a.a.qC(2, this.YKh.computeSize());
      }
      AppMethodBeat.o(133148);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YKg == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        if (this.YKh == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        il localil = (il)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133148);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new im();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((im)localObject2).parseFrom((byte[])localObject1);
            }
            localil.YKg = ((im)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133148);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ij();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ij)localObject2).parseFrom((byte[])localObject1);
          }
          localil.YKh = ((ij)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133148);
        return 0;
      }
      AppMethodBeat.o(133148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.il
 * JD-Core Version:    0.7.0.1
 */