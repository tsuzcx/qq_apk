package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class car
  extends com.tencent.mm.bx.a
{
  public gee aajH;
  public LinkedList<caq> aajI;
  
  public car()
  {
    AppMethodBeat.i(258439);
    this.aajI = new LinkedList();
    AppMethodBeat.o(258439);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258442);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aajH != null)
      {
        paramVarArgs.qD(1, this.aajH.computeSize());
        this.aajH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aajI);
      AppMethodBeat.o(258442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aajH == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.aajH.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aajI);
      AppMethodBeat.o(258442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        car localcar = (car)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258442);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gee();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gee)localObject2).parseFrom((byte[])localObject1);
            }
            localcar.aajH = ((gee)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258442);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new caq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((caq)localObject2).parseFrom((byte[])localObject1);
          }
          localcar.aajI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258442);
        return 0;
      }
      AppMethodBeat.o(258442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.car
 * JD-Core Version:    0.7.0.1
 */