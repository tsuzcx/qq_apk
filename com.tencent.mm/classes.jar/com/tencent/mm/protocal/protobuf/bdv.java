package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bdv
  extends com.tencent.mm.bx.a
{
  public bfs ZOA;
  public b ZOz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258999);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOz != null) {
        paramVarArgs.d(1, this.ZOz);
      }
      if (this.ZOA != null)
      {
        paramVarArgs.qD(106, this.ZOA.computeSize());
        this.ZOA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOz == null) {
        break label352;
      }
    }
    label352:
    for (paramInt = i.a.a.b.b.a.c(1, this.ZOz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZOA != null) {
        i = paramInt + i.a.a.a.qC(106, this.ZOA.computeSize());
      }
      AppMethodBeat.o(258999);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bdv localbdv = (bdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258999);
          return -1;
        case 1: 
          localbdv.ZOz = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258999);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bfs localbfs = new bfs();
          if ((localObject != null) && (localObject.length > 0)) {
            localbfs.parseFrom((byte[])localObject);
          }
          localbdv.ZOA = localbfs;
          paramInt += 1;
        }
        AppMethodBeat.o(258999);
        return 0;
      }
      AppMethodBeat.o(258999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdv
 * JD-Core Version:    0.7.0.1
 */