package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fds
  extends com.tencent.mm.bw.a
{
  public int LEg;
  public String MjN;
  public String Nzn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MjN != null) {
        paramVarArgs.e(1, this.MjN);
      }
      paramVarArgs.aM(2, this.LEg);
      if (this.Nzn != null) {
        paramVarArgs.e(3, this.Nzn);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MjN == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.MjN) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LEg);
      paramInt = i;
      if (this.Nzn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Nzn);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fds localfds = (fds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localfds.MjN = locala.UbS.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localfds.LEg = locala.UbS.zi();
          AppMethodBeat.o(123706);
          return 0;
        }
        localfds.Nzn = locala.UbS.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fds
 * JD-Core Version:    0.7.0.1
 */