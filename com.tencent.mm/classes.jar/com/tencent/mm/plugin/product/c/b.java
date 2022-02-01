package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public LinkedList<i> GTH;
  public String name;
  
  public b()
  {
    AppMethodBeat.i(91265);
    this.GTH = new LinkedList();
    AppMethodBeat.o(91265);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91266);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      paramVarArgs.e(2, 8, this.GTH);
      AppMethodBeat.o(91266);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.name) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.GTH);
      AppMethodBeat.o(91266);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91266);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91266);
          return -1;
        case 1: 
          localb.name = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91266);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          i locali = new i();
          if ((localObject != null) && (localObject.length > 0)) {
            locali.parseFrom((byte[])localObject);
          }
          localb.GTH.add(locali);
          paramInt += 1;
        }
        AppMethodBeat.o(91266);
        return 0;
      }
      AppMethodBeat.o(91266);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.b
 * JD-Core Version:    0.7.0.1
 */