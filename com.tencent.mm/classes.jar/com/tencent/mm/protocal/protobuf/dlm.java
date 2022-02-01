package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlm
  extends com.tencent.mm.cd.a
{
  public int RFu;
  public int TSy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RFu);
      paramVarArgs.aY(2, this.TSy);
      AppMethodBeat.o(43125);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.RFu);
      int i = g.a.a.b.b.a.bM(2, this.TSy);
      AppMethodBeat.o(43125);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43125);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dlm localdlm = (dlm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43125);
        return -1;
      case 1: 
        localdlm.RFu = locala.abFh.AK();
        AppMethodBeat.o(43125);
        return 0;
      }
      localdlm.TSy = locala.abFh.AK();
      AppMethodBeat.o(43125);
      return 0;
    }
    AppMethodBeat.o(43125);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlm
 * JD-Core Version:    0.7.0.1
 */