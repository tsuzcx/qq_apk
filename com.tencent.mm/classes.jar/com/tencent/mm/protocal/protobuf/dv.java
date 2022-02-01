package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dv
  extends com.tencent.mm.bx.a
{
  public String YFY;
  public du YFZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258845);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFY != null) {
        paramVarArgs.g(1, this.YFY);
      }
      if (this.YFZ != null)
      {
        paramVarArgs.qD(2, this.YFZ.computeSize());
        this.YFZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFY == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.YFY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFZ != null) {
        i = paramInt + i.a.a.a.qC(2, this.YFZ.computeSize());
      }
      AppMethodBeat.o(258845);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258845);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258845);
          return -1;
        case 1: 
          localdv.YFY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258845);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          du localdu = new du();
          if ((localObject != null) && (localObject.length > 0)) {
            localdu.parseFrom((byte[])localObject);
          }
          localdv.YFZ = localdu;
          paramInt += 1;
        }
        AppMethodBeat.o(258845);
        return 0;
      }
      AppMethodBeat.o(258845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */