package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fpn
  extends com.tencent.mm.cd.a
{
  public int UNl;
  public int UNm;
  public int UNn;
  public int UNo;
  public String UNp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UNl);
      paramVarArgs.aY(2, this.UNm);
      paramVarArgs.aY(3, this.UNn);
      paramVarArgs.aY(4, this.UNo);
      if (this.UNp != null) {
        paramVarArgs.f(5, this.UNp);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UNl) + 0 + g.a.a.b.b.a.bM(2, this.UNm) + g.a.a.b.b.a.bM(3, this.UNn) + g.a.a.b.b.a.bM(4, this.UNo);
      paramInt = i;
      if (this.UNp != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UNp);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fpn localfpn = (fpn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localfpn.UNl = locala.abFh.AK();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localfpn.UNm = locala.abFh.AK();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localfpn.UNn = locala.abFh.AK();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localfpn.UNo = locala.abFh.AK();
        AppMethodBeat.o(153337);
        return 0;
      }
      localfpn.UNp = locala.abFh.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpn
 * JD-Core Version:    0.7.0.1
 */