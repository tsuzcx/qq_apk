package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cds
  extends com.tencent.mm.bx.a
{
  public fgz CNI;
  public awr YGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257398);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGg != null)
      {
        paramVarArgs.qD(1, this.YGg.computeSize());
        this.YGg.writeFields(paramVarArgs);
      }
      if (this.CNI != null)
      {
        paramVarArgs.qD(2, this.CNI.computeSize());
        this.CNI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257398);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGg == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.YGg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CNI != null) {
        i = paramInt + i.a.a.a.qC(2, this.CNI.computeSize());
      }
      AppMethodBeat.o(257398);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257398);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cds localcds = (cds)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257398);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awr)localObject2).parseFrom((byte[])localObject1);
            }
            localcds.YGg = ((awr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257398);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgz)localObject2).parseFrom((byte[])localObject1);
          }
          localcds.CNI = ((fgz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257398);
        return 0;
      }
      AppMethodBeat.o(257398);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */