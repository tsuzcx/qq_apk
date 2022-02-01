package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.cd.a
{
  public af MFJ;
  public LinkedList<ac> tse;
  
  public ag()
  {
    AppMethodBeat.i(243769);
    this.tse = new LinkedList();
    AppMethodBeat.o(243769);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243771);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFJ != null)
      {
        paramVarArgs.oE(1, this.MFJ.computeSize());
        this.MFJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.tse);
      AppMethodBeat.o(243771);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFJ == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.a.oD(1, this.MFJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.tse);
      AppMethodBeat.o(243771);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tse.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243771);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243771);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new af();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((af)localObject2).parseFrom((byte[])localObject1);
            }
            localag.MFJ = ((af)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(243771);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ac();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ac)localObject2).parseFrom((byte[])localObject1);
          }
          localag.tse.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243771);
        return 0;
      }
      AppMethodBeat.o(243771);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ag
 * JD-Core Version:    0.7.0.1
 */