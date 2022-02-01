package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class awq
  extends com.tencent.mm.cd.a
{
  public long SJc;
  public b SJd;
  public String SJm;
  public String SJn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199076);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SJc);
      if (this.SJm != null) {
        paramVarArgs.f(2, this.SJm);
      }
      if (this.SJd != null) {
        paramVarArgs.c(3, this.SJd);
      }
      if (this.SJn != null) {
        paramVarArgs.f(4, this.SJn);
      }
      AppMethodBeat.o(199076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SJc) + 0;
      paramInt = i;
      if (this.SJm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SJm);
      }
      i = paramInt;
      if (this.SJd != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SJd);
      }
      paramInt = i;
      if (this.SJn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SJn);
      }
      AppMethodBeat.o(199076);
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
      AppMethodBeat.o(199076);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      awq localawq = (awq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199076);
        return -1;
      case 1: 
        localawq.SJc = locala.abFh.AN();
        AppMethodBeat.o(199076);
        return 0;
      case 2: 
        localawq.SJm = locala.abFh.readString();
        AppMethodBeat.o(199076);
        return 0;
      case 3: 
        localawq.SJd = locala.abFh.iUw();
        AppMethodBeat.o(199076);
        return 0;
      }
      localawq.SJn = locala.abFh.readString();
      AppMethodBeat.o(199076);
      return 0;
    }
    AppMethodBeat.o(199076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awq
 * JD-Core Version:    0.7.0.1
 */