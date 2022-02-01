package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bwd
  extends com.tencent.mm.bx.a
{
  public FinderObject aaef;
  public b aaeg;
  public int jump_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258748);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaef != null)
      {
        paramVarArgs.qD(1, this.aaef.computeSize());
        this.aaef.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.jump_type);
      if (this.aaeg != null) {
        paramVarArgs.d(3, this.aaeg);
      }
      AppMethodBeat.o(258748);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaef == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.aaef.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.jump_type);
      paramInt = i;
      if (this.aaeg != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aaeg);
      }
      AppMethodBeat.o(258748);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258748);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bwd localbwd = (bwd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258748);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderObject localFinderObject = new FinderObject();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderObject.parseFrom((byte[])localObject);
            }
            localbwd.aaef = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(258748);
          return 0;
        case 2: 
          localbwd.jump_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258748);
          return 0;
        }
        localbwd.aaeg = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258748);
        return 0;
      }
      AppMethodBeat.o(258748);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwd
 * JD-Core Version:    0.7.0.1
 */