package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqb
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int RTb;
  public int TuP;
  public int UNQ;
  public int UNR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TuP);
      paramVarArgs.aY(2, this.RTb);
      paramVarArgs.aY(3, this.UNQ);
      paramVarArgs.aY(4, this.CPw);
      paramVarArgs.aY(10, this.UNR);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TuP);
      int i = g.a.a.b.b.a.bM(2, this.RTb);
      int j = g.a.a.b.b.a.bM(3, this.UNQ);
      int k = g.a.a.b.b.a.bM(4, this.CPw);
      int m = g.a.a.b.b.a.bM(10, this.UNR);
      AppMethodBeat.o(123712);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fqb localfqb = (fqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localfqb.TuP = locala.abFh.AK();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localfqb.RTb = locala.abFh.AK();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localfqb.UNQ = locala.abFh.AK();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localfqb.CPw = locala.abFh.AK();
        AppMethodBeat.o(123712);
        return 0;
      }
      localfqb.UNR = locala.abFh.AK();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqb
 * JD-Core Version:    0.7.0.1
 */