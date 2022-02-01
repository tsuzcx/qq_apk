package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.cd.a
{
  public c FlK;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      if (this.FlK != null)
      {
        paramVarArgs.oE(2, this.FlK.computeSize());
        this.FlK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(187551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FlK != null) {
        i = paramInt + g.a.a.a.oD(2, this.FlK.computeSize());
      }
      AppMethodBeat.o(187551);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(187551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187551);
          return -1;
        case 1: 
          locala.key = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(187551);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          c localc = new c();
          if ((localObject != null) && (localObject.length > 0)) {
            localc.parseFrom((byte[])localObject);
          }
          locala.FlK = localc;
          paramInt += 1;
        }
        AppMethodBeat.o(187551);
        return 0;
      }
      AppMethodBeat.o(187551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.a
 * JD-Core Version:    0.7.0.1
 */