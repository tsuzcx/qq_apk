package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class akc
  extends com.tencent.mm.cd.a
{
  public String SuR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104778);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SuR == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104778);
        throw paramVarArgs;
      }
      if (this.SuR != null) {
        paramVarArgs.f(1, this.SuR);
      }
      AppMethodBeat.o(104778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SuR == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.g(1, this.SuR) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104778);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SuR == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104778);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akc localakc = (akc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104778);
          return -1;
        }
        localakc.SuR = locala.abFh.readString();
        AppMethodBeat.o(104778);
        return 0;
      }
      AppMethodBeat.o(104778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akc
 * JD-Core Version:    0.7.0.1
 */