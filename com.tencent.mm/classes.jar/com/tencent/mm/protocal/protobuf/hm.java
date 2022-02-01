package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class hm
  extends com.tencent.mm.bx.a
{
  public dmz YIS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125713);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIS == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaObj");
        AppMethodBeat.o(125713);
        throw paramVarArgs;
      }
      if (this.YIS != null)
      {
        paramVarArgs.qD(1, this.YIS.computeSize());
        this.YIS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIS == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.YIS.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125713);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YIS == null)
        {
          paramVarArgs = new b("Not all required fields were included: MediaObj");
          AppMethodBeat.o(125713);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hm localhm = (hm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125713);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dmz localdmz = new dmz();
          if ((localObject != null) && (localObject.length > 0)) {
            localdmz.parseFrom((byte[])localObject);
          }
          localhm.YIS = localdmz;
          paramInt += 1;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      AppMethodBeat.o(125713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hm
 * JD-Core Version:    0.7.0.1
 */