package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class csj
  extends com.tencent.mm.cd.a
{
  public String chatroomName;
  public int fMC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258811);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroomName == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroomName");
        AppMethodBeat.o(258811);
        throw paramVarArgs;
      }
      if (this.chatroomName != null) {
        paramVarArgs.f(1, this.chatroomName);
      }
      paramVarArgs.aY(2, this.fMC);
      AppMethodBeat.o(258811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroomName == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.g(1, this.chatroomName) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.fMC);
      AppMethodBeat.o(258811);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.chatroomName == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroomName");
          AppMethodBeat.o(258811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258811);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        csj localcsj = (csj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258811);
          return -1;
        case 1: 
          localcsj.chatroomName = locala.abFh.readString();
          AppMethodBeat.o(258811);
          return 0;
        }
        localcsj.fMC = locala.abFh.AK();
        AppMethodBeat.o(258811);
        return 0;
      }
      AppMethodBeat.o(258811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csj
 * JD-Core Version:    0.7.0.1
 */