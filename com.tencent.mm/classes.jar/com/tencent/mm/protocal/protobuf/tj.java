package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tj
  extends com.tencent.mm.cd.a
{
  public int Sdf;
  public int Sdg;
  public String Sdh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Sdf);
      paramVarArgs.aY(2, this.Sdg);
      if (this.Sdh != null) {
        paramVarArgs.f(3, this.Sdh);
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Sdf) + 0 + g.a.a.b.b.a.bM(2, this.Sdg);
      paramInt = i;
      if (this.Sdh != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Sdh);
      }
      AppMethodBeat.o(91386);
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
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      tj localtj = (tj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91386);
        return -1;
      case 1: 
        localtj.Sdf = locala.abFh.AK();
        AppMethodBeat.o(91386);
        return 0;
      case 2: 
        localtj.Sdg = locala.abFh.AK();
        AppMethodBeat.o(91386);
        return 0;
      }
      localtj.Sdh = locala.abFh.readString();
      AppMethodBeat.o(91386);
      return 0;
    }
    AppMethodBeat.o(91386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */