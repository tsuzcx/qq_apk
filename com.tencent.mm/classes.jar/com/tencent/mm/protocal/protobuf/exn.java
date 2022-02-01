package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exn
  extends com.tencent.mm.bw.a
{
  public String Cqk;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200239);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.Cqk != null) {
        paramVarArgs.e(2, this.Cqk);
      }
      paramVarArgs.aM(3, this.version);
      AppMethodBeat.o(200239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cqk != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Cqk);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.version);
      AppMethodBeat.o(200239);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200239);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exn localexn = (exn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200239);
          return -1;
        case 1: 
          localexn.username = locala.UbS.readString();
          AppMethodBeat.o(200239);
          return 0;
        case 2: 
          localexn.Cqk = locala.UbS.readString();
          AppMethodBeat.o(200239);
          return 0;
        }
        localexn.version = locala.UbS.zi();
        AppMethodBeat.o(200239);
        return 0;
      }
      AppMethodBeat.o(200239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exn
 * JD-Core Version:    0.7.0.1
 */