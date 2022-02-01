package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arl
  extends com.tencent.mm.cd.a
{
  public int SEq;
  public int SEr;
  public int SEs;
  public int SEt;
  public int SEu;
  public int SEv;
  public int SEw;
  public int count;
  public int fans_count;
  public int lYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.count);
      paramVarArgs.aY(2, this.SEq);
      paramVarArgs.aY(3, this.SEr);
      paramVarArgs.aY(4, this.SEs);
      paramVarArgs.aY(5, this.SEt);
      paramVarArgs.aY(7, this.fans_count);
      paramVarArgs.aY(8, this.SEu);
      paramVarArgs.aY(9, this.lYt);
      paramVarArgs.aY(10, this.SEv);
      paramVarArgs.aY(11, this.SEw);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.count);
      int i = g.a.a.b.b.a.bM(2, this.SEq);
      int j = g.a.a.b.b.a.bM(3, this.SEr);
      int k = g.a.a.b.b.a.bM(4, this.SEs);
      int m = g.a.a.b.b.a.bM(5, this.SEt);
      int n = g.a.a.b.b.a.bM(7, this.fans_count);
      int i1 = g.a.a.b.b.a.bM(8, this.SEu);
      int i2 = g.a.a.b.b.a.bM(9, this.lYt);
      int i3 = g.a.a.b.b.a.bM(10, this.SEv);
      int i4 = g.a.a.b.b.a.bM(11, this.SEw);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      arl localarl = (arl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localarl.count = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localarl.SEq = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localarl.SEr = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localarl.SEs = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localarl.SEt = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localarl.fans_count = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localarl.SEu = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localarl.lYt = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      case 10: 
        localarl.SEv = locala.abFh.AK();
        AppMethodBeat.o(168947);
        return 0;
      }
      localarl.SEw = locala.abFh.AK();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */