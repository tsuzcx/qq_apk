package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.cd.a
{
  public j GTW;
  public String GTX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91272);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GTW != null)
      {
        paramVarArgs.oE(1, this.GTW.computeSize());
        this.GTW.writeFields(paramVarArgs);
      }
      if (this.GTX != null) {
        paramVarArgs.f(2, this.GTX);
      }
      AppMethodBeat.o(91272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GTW == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.GTW.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GTX != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.GTX);
      }
      AppMethodBeat.o(91272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91272);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            j localj = new j();
            if ((localObject != null) && (localObject.length > 0)) {
              localj.parseFrom((byte[])localObject);
            }
            localf.GTW = localj;
            paramInt += 1;
          }
          AppMethodBeat.o(91272);
          return 0;
        }
        localf.GTX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91272);
        return 0;
      }
      AppMethodBeat.o(91272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.f
 * JD-Core Version:    0.7.0.1
 */