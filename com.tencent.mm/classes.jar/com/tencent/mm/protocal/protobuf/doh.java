package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doh
  extends com.tencent.mm.cd.a
{
  public String GdS;
  public LinkedList<dog> jEz;
  
  public doh()
  {
    AppMethodBeat.i(227614);
    this.jEz = new LinkedList();
    AppMethodBeat.o(227614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(227625);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.jEz);
      if (this.GdS != null) {
        paramVarArgs.f(2, this.GdS);
      }
      AppMethodBeat.o(227625);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.jEz) + 0;
      paramInt = i;
      if (this.GdS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.GdS);
      }
      AppMethodBeat.o(227625);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.jEz.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(227625);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      doh localdoh = (doh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(227625);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dog localdog = new dog();
          if ((localObject != null) && (localObject.length > 0)) {
            localdog.parseFrom((byte[])localObject);
          }
          localdoh.jEz.add(localdog);
          paramInt += 1;
        }
        AppMethodBeat.o(227625);
        return 0;
      }
      localdoh.GdS = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(227625);
      return 0;
    }
    AppMethodBeat.o(227625);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doh
 * JD-Core Version:    0.7.0.1
 */