package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbp
  extends com.tencent.mm.cd.a
{
  public int SNn;
  public int SNo;
  public int SNp;
  public int SNq;
  public int SNr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SNn);
      paramVarArgs.aY(2, this.SNo);
      paramVarArgs.aY(3, this.SNp);
      paramVarArgs.aY(4, this.SNq);
      paramVarArgs.aY(5, this.SNr);
      AppMethodBeat.o(230555);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SNn);
      int i = g.a.a.b.b.a.bM(2, this.SNo);
      int j = g.a.a.b.b.a.bM(3, this.SNp);
      int k = g.a.a.b.b.a.bM(4, this.SNq);
      int m = g.a.a.b.b.a.bM(5, this.SNr);
      AppMethodBeat.o(230555);
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
      AppMethodBeat.o(230555);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbp localbbp = (bbp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(230555);
        return -1;
      case 1: 
        localbbp.SNn = locala.abFh.AK();
        AppMethodBeat.o(230555);
        return 0;
      case 2: 
        localbbp.SNo = locala.abFh.AK();
        AppMethodBeat.o(230555);
        return 0;
      case 3: 
        localbbp.SNp = locala.abFh.AK();
        AppMethodBeat.o(230555);
        return 0;
      case 4: 
        localbbp.SNq = locala.abFh.AK();
        AppMethodBeat.o(230555);
        return 0;
      }
      localbbp.SNr = locala.abFh.AK();
      AppMethodBeat.o(230555);
      return 0;
    }
    AppMethodBeat.o(230555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */