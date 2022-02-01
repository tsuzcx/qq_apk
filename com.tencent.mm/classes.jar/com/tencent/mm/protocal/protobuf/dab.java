package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dab
  extends com.tencent.mm.cd.a
{
  public String Inf;
  public long THw;
  public String THx;
  public String THy;
  public long gbJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.THw);
      if (this.Inf != null) {
        paramVarArgs.f(2, this.Inf);
      }
      paramVarArgs.bm(3, this.gbJ);
      if (this.THx != null) {
        paramVarArgs.f(4, this.THx);
      }
      if (this.THy != null) {
        paramVarArgs.f(5, this.THy);
      }
      AppMethodBeat.o(217118);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.THw) + 0;
      paramInt = i;
      if (this.Inf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Inf);
      }
      i = paramInt + g.a.a.b.b.a.p(3, this.gbJ);
      paramInt = i;
      if (this.THx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.THx);
      }
      i = paramInt;
      if (this.THy != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.THy);
      }
      AppMethodBeat.o(217118);
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
      AppMethodBeat.o(217118);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dab localdab = (dab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217118);
        return -1;
      case 1: 
        localdab.THw = locala.abFh.AN();
        AppMethodBeat.o(217118);
        return 0;
      case 2: 
        localdab.Inf = locala.abFh.readString();
        AppMethodBeat.o(217118);
        return 0;
      case 3: 
        localdab.gbJ = locala.abFh.AN();
        AppMethodBeat.o(217118);
        return 0;
      case 4: 
        localdab.THx = locala.abFh.readString();
        AppMethodBeat.o(217118);
        return 0;
      }
      localdab.THy = locala.abFh.readString();
      AppMethodBeat.o(217118);
      return 0;
    }
    AppMethodBeat.o(217118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */