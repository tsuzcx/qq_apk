package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckd
  extends com.tencent.mm.cd.a
{
  public String TrK;
  public String TrL;
  public int TrM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TrK != null) {
        paramVarArgs.f(1, this.TrK);
      }
      if (this.TrL != null) {
        paramVarArgs.f(2, this.TrL);
      }
      paramVarArgs.aY(3, this.TrM);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TrK == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TrK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TrL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TrL);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TrM);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckd localckd = (ckd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localckd.TrK = locala.abFh.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localckd.TrL = locala.abFh.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localckd.TrM = locala.abFh.AK();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckd
 * JD-Core Version:    0.7.0.1
 */