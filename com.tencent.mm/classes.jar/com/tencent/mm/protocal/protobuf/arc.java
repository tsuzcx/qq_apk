package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arc
  extends com.tencent.mm.cd.a
{
  public String SEf;
  public long commentId;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202736);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xbk);
      paramVarArgs.bm(2, this.commentId);
      if (this.SEf != null) {
        paramVarArgs.f(3, this.SEf);
      }
      AppMethodBeat.o(202736);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xbk) + 0 + g.a.a.b.b.a.p(2, this.commentId);
      paramInt = i;
      if (this.SEf != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SEf);
      }
      AppMethodBeat.o(202736);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(202736);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      arc localarc = (arc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202736);
        return -1;
      case 1: 
        localarc.xbk = locala.abFh.AN();
        AppMethodBeat.o(202736);
        return 0;
      case 2: 
        localarc.commentId = locala.abFh.AN();
        AppMethodBeat.o(202736);
        return 0;
      }
      localarc.SEf = locala.abFh.readString();
      AppMethodBeat.o(202736);
      return 0;
    }
    AppMethodBeat.o(202736);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arc
 * JD-Core Version:    0.7.0.1
 */