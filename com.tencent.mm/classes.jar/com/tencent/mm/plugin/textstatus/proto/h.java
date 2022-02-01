package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.cd.a
{
  public String MFj;
  public int tpK;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243772);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tpK);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.MFj != null) {
        paramVarArgs.f(3, this.MFj);
      }
      AppMethodBeat.o(243772);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.tpK) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.MFj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MFj);
      }
      AppMethodBeat.o(243772);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(243772);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(243772);
        return -1;
      case 1: 
        localh.tpK = locala.abFh.AK();
        AppMethodBeat.o(243772);
        return 0;
      case 2: 
        localh.url = locala.abFh.readString();
        AppMethodBeat.o(243772);
        return 0;
      }
      localh.MFj = locala.abFh.readString();
      AppMethodBeat.o(243772);
      return 0;
    }
    AppMethodBeat.o(243772);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.h
 * JD-Core Version:    0.7.0.1
 */