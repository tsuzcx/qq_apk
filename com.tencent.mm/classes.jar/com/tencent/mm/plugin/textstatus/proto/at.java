package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class at
  extends com.tencent.mm.bx.a
{
  public as TpX;
  public LinkedList<ap> wwD;
  
  public at()
  {
    AppMethodBeat.i(289941);
    this.wwD = new LinkedList();
    AppMethodBeat.o(289941);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289958);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.TpX != null)
      {
        paramVarArgs.qD(1, this.TpX.computeSize());
        this.TpX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wwD);
      AppMethodBeat.o(289958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TpX == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.TpX.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.wwD);
      AppMethodBeat.o(289958);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wwD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289958);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289958);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new as();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((as)localObject2).parseFrom((byte[])localObject1);
            }
            localat.TpX = ((as)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(289958);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ap();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ap)localObject2).parseFrom((byte[])localObject1);
          }
          localat.wwD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(289958);
        return 0;
      }
      AppMethodBeat.o(289958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.at
 * JD-Core Version:    0.7.0.1
 */