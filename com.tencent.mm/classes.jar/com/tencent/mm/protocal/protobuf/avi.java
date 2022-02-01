package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avi
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public bkk ZFA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257639);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIZ != null) {
        paramVarArgs.g(1, this.YIZ);
      }
      if (this.ZFA != null)
      {
        paramVarArgs.qD(2, this.ZFA.computeSize());
        this.ZFA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIZ == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZFA != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZFA.computeSize());
      }
      AppMethodBeat.o(257639);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        avi localavi = (avi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257639);
          return -1;
        case 1: 
          localavi.YIZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257639);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bkk localbkk = new bkk();
          if ((localObject != null) && (localObject.length > 0)) {
            localbkk.parseFrom((byte[])localObject);
          }
          localavi.ZFA = localbkk;
          paramInt += 1;
        }
        AppMethodBeat.o(257639);
        return 0;
      }
      AppMethodBeat.o(257639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avi
 * JD-Core Version:    0.7.0.1
 */