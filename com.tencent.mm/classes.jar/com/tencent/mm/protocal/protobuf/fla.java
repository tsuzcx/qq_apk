package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fla
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> SWx;
  public String key;
  
  public fla()
  {
    AppMethodBeat.i(206587);
    this.SWx = new LinkedList();
    AppMethodBeat.o(206587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206588);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(206588);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      paramVarArgs.e(2, 1, this.SWx);
      AppMethodBeat.o(206588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.SWx);
      AppMethodBeat.o(206588);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SWx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(206588);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206588);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fla localfla = (fla)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(206588);
          return -1;
        case 1: 
          localfla.key = locala.abFh.readString();
          AppMethodBeat.o(206588);
          return 0;
        }
        localfla.SWx.add(locala.abFh.readString());
        AppMethodBeat.o(206588);
        return 0;
      }
      AppMethodBeat.o(206588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fla
 * JD-Core Version:    0.7.0.1
 */