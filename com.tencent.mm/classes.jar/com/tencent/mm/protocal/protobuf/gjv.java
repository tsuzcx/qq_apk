package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class gjv
  extends com.tencent.mm.bx.a
{
  public gjs acfR;
  public b acfS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258101);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acfR != null)
      {
        paramVarArgs.qD(1, this.acfR.computeSize());
        this.acfR.writeFields(paramVarArgs);
      }
      if (this.acfS != null) {
        paramVarArgs.d(2, this.acfS);
      }
      AppMethodBeat.o(258101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acfR == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.acfR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acfS != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.acfS);
      }
      AppMethodBeat.o(258101);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258101);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gjv localgjv = (gjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258101);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gjs localgjs = new gjs();
            if ((localObject != null) && (localObject.length > 0)) {
              localgjs.parseFrom((byte[])localObject);
            }
            localgjv.acfR = localgjs;
            paramInt += 1;
          }
          AppMethodBeat.o(258101);
          return 0;
        }
        localgjv.acfS = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258101);
        return 0;
      }
      AppMethodBeat.o(258101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjv
 * JD-Core Version:    0.7.0.1
 */