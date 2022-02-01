package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dox
  extends com.tencent.mm.bw.a
{
  public int MSs;
  public String MSt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152669);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MSt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MSs);
      if (this.MSt != null) {
        paramVarArgs.e(2, this.MSt);
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MSs) + 0;
      paramInt = i;
      if (this.MSt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MSt);
      }
      AppMethodBeat.o(152669);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MSt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResKey");
        AppMethodBeat.o(152669);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152669);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dox localdox = (dox)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152669);
        return -1;
      case 1: 
        localdox.MSs = locala.UbS.zi();
        AppMethodBeat.o(152669);
        return 0;
      }
      localdox.MSt = locala.UbS.readString();
      AppMethodBeat.o(152669);
      return 0;
    }
    AppMethodBeat.o(152669);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dox
 * JD-Core Version:    0.7.0.1
 */