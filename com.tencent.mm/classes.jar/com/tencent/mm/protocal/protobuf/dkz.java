package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dkz
  extends com.tencent.mm.cd.a
{
  public String TSg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TSg == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNum");
        AppMethodBeat.o(43122);
        throw paramVarArgs;
      }
      if (this.TSg != null) {
        paramVarArgs.f(1, this.TSg);
      }
      AppMethodBeat.o(43122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TSg == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.g(1, this.TSg) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43122);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TSg == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNum");
          AppMethodBeat.o(43122);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43122);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dkz localdkz = (dkz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43122);
          return -1;
        }
        localdkz.TSg = locala.abFh.readString();
        AppMethodBeat.o(43122);
        return 0;
      }
      AppMethodBeat.o(43122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */