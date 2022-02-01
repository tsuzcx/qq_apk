package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fge
  extends com.tencent.mm.cd.a
{
  public String RFj;
  public boolean UGr;
  public String UGs;
  public int UGt;
  public int UGu;
  public int UGv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.UGr);
      if (this.RFj != null) {
        paramVarArgs.f(2, this.RFj);
      }
      if (this.UGs != null) {
        paramVarArgs.f(3, this.UGs);
      }
      paramVarArgs.aY(4, this.UGt);
      paramVarArgs.aY(5, this.UGu);
      paramVarArgs.aY(6, this.UGv);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.RFj != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RFj);
      }
      i = paramInt;
      if (this.UGs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UGs);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UGt);
      int j = g.a.a.b.b.a.bM(5, this.UGu);
      int k = g.a.a.b.b.a.bM(6, this.UGv);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fge localfge = (fge)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localfge.UGr = locala.abFh.AB();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localfge.RFj = locala.abFh.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localfge.UGs = locala.abFh.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localfge.UGt = locala.abFh.AK();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localfge.UGu = locala.abFh.AK();
        AppMethodBeat.o(147805);
        return 0;
      }
      localfge.UGv = locala.abFh.AK();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fge
 * JD-Core Version:    0.7.0.1
 */