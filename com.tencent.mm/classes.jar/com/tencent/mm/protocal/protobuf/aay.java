package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aay
  extends com.tencent.mm.cd.a
{
  public long Snl;
  public String Snm;
  public int Snn;
  public long Sno;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208465);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Snl);
      if (this.Snm != null) {
        paramVarArgs.f(2, this.Snm);
      }
      paramVarArgs.aY(3, this.Snn);
      paramVarArgs.bm(4, this.Sno);
      AppMethodBeat.o(208465);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Snl) + 0;
      paramInt = i;
      if (this.Snm != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Snm);
      }
      i = g.a.a.b.b.a.bM(3, this.Snn);
      int j = g.a.a.b.b.a.p(4, this.Sno);
      AppMethodBeat.o(208465);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208465);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aay localaay = (aay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208465);
        return -1;
      case 1: 
        localaay.Snl = locala.abFh.AN();
        AppMethodBeat.o(208465);
        return 0;
      case 2: 
        localaay.Snm = locala.abFh.readString();
        AppMethodBeat.o(208465);
        return 0;
      case 3: 
        localaay.Snn = locala.abFh.AK();
        AppMethodBeat.o(208465);
        return 0;
      }
      localaay.Sno = locala.abFh.AN();
      AppMethodBeat.o(208465);
      return 0;
    }
    AppMethodBeat.o(208465);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aay
 * JD-Core Version:    0.7.0.1
 */