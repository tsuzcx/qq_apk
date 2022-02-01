package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class flp
  extends com.tencent.mm.cd.a
{
  public String UKx;
  public LinkedList<String> UKy;
  
  public flp()
  {
    AppMethodBeat.i(246074);
    this.UKy = new LinkedList();
    AppMethodBeat.o(246074);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(246075);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UKx != null) {
        paramVarArgs.f(1, this.UKx);
      }
      paramVarArgs.e(2, 1, this.UKy);
      AppMethodBeat.o(246075);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UKx == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.UKx) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.UKy);
      AppMethodBeat.o(246075);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UKy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(246075);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        flp localflp = (flp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(246075);
          return -1;
        case 1: 
          localflp.UKx = locala.abFh.readString();
          AppMethodBeat.o(246075);
          return 0;
        }
        localflp.UKy.add(locala.abFh.readString());
        AppMethodBeat.o(246075);
        return 0;
      }
      AppMethodBeat.o(246075);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flp
 * JD-Core Version:    0.7.0.1
 */