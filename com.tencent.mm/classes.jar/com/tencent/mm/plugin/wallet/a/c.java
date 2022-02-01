package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public String GGC;
  public LinkedList<d> Owd;
  
  public c()
  {
    AppMethodBeat.i(91286);
    this.Owd = new LinkedList();
    AppMethodBeat.o(91286);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91287);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.GGC != null) {
        paramVarArgs.f(1, this.GGC);
      }
      paramVarArgs.e(2, 8, this.Owd);
      AppMethodBeat.o(91287);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGC == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.GGC) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Owd);
      AppMethodBeat.o(91287);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Owd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91287);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91287);
          return -1;
        case 1: 
          localc.GGC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91287);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          d locald = new d();
          if ((localObject != null) && (localObject.length > 0)) {
            locald.parseFrom((byte[])localObject);
          }
          localc.Owd.add(locald);
          paramInt += 1;
        }
        AppMethodBeat.o(91287);
        return 0;
      }
      AppMethodBeat.o(91287);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.c
 * JD-Core Version:    0.7.0.1
 */