package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bft
  extends com.tencent.mm.cd.a
{
  public String SHp;
  public long SQw;
  public long SQx;
  public int SQy;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      if (this.SHp != null) {
        paramVarArgs.f(2, this.SHp);
      }
      paramVarArgs.bm(3, this.SQw);
      paramVarArgs.bm(4, this.SQx);
      paramVarArgs.aY(5, this.SQy);
      AppMethodBeat.o(199408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.id) + 0;
      paramInt = i;
      if (this.SHp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SHp);
      }
      i = g.a.a.b.b.a.p(3, this.SQw);
      int j = g.a.a.b.b.a.p(4, this.SQx);
      int k = g.a.a.b.b.a.bM(5, this.SQy);
      AppMethodBeat.o(199408);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(199408);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bft localbft = (bft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199408);
        return -1;
      case 1: 
        localbft.id = locala.abFh.AN();
        AppMethodBeat.o(199408);
        return 0;
      case 2: 
        localbft.SHp = locala.abFh.readString();
        AppMethodBeat.o(199408);
        return 0;
      case 3: 
        localbft.SQw = locala.abFh.AN();
        AppMethodBeat.o(199408);
        return 0;
      case 4: 
        localbft.SQx = locala.abFh.AN();
        AppMethodBeat.o(199408);
        return 0;
      }
      localbft.SQy = locala.abFh.AK();
      AppMethodBeat.o(199408);
      return 0;
    }
    AppMethodBeat.o(199408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bft
 * JD-Core Version:    0.7.0.1
 */