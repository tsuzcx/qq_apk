package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axs
  extends com.tencent.mm.cd.a
{
  public String SKi;
  public String SKj;
  public int SKk;
  public int SKl;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229606);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKi != null) {
        paramVarArgs.f(1, this.SKi);
      }
      paramVarArgs.aY(2, this.status);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.SKj != null) {
        paramVarArgs.f(4, this.SKj);
      }
      paramVarArgs.aY(5, this.SKk);
      paramVarArgs.aY(6, this.SKl);
      AppMethodBeat.o(229606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKi == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.status);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      i = paramInt;
      if (this.SKj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SKj);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.SKk);
      int j = g.a.a.b.b.a.bM(6, this.SKl);
      AppMethodBeat.o(229606);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229606);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axs localaxs = (axs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(229606);
          return -1;
        case 1: 
          localaxs.SKi = locala.abFh.readString();
          AppMethodBeat.o(229606);
          return 0;
        case 2: 
          localaxs.status = locala.abFh.AK();
          AppMethodBeat.o(229606);
          return 0;
        case 3: 
          localaxs.title = locala.abFh.readString();
          AppMethodBeat.o(229606);
          return 0;
        case 4: 
          localaxs.SKj = locala.abFh.readString();
          AppMethodBeat.o(229606);
          return 0;
        case 5: 
          localaxs.SKk = locala.abFh.AK();
          AppMethodBeat.o(229606);
          return 0;
        }
        localaxs.SKl = locala.abFh.AK();
        AppMethodBeat.o(229606);
        return 0;
      }
      AppMethodBeat.o(229606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axs
 * JD-Core Version:    0.7.0.1
 */