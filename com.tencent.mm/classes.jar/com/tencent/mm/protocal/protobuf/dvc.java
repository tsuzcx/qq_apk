package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvc
  extends com.tencent.mm.cd.a
{
  public long RWK;
  public String SRj;
  public int status;
  public String zaX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205352);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.zaX != null) {
        paramVarArgs.f(1, this.zaX);
      }
      paramVarArgs.bm(2, this.RWK);
      paramVarArgs.aY(3, this.status);
      if (this.SRj != null) {
        paramVarArgs.f(4, this.SRj);
      }
      AppMethodBeat.o(205352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zaX == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.zaX) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.RWK) + g.a.a.b.b.a.bM(3, this.status);
      paramInt = i;
      if (this.SRj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SRj);
      }
      AppMethodBeat.o(205352);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205352);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dvc localdvc = (dvc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(205352);
          return -1;
        case 1: 
          localdvc.zaX = locala.abFh.readString();
          AppMethodBeat.o(205352);
          return 0;
        case 2: 
          localdvc.RWK = locala.abFh.AN();
          AppMethodBeat.o(205352);
          return 0;
        case 3: 
          localdvc.status = locala.abFh.AK();
          AppMethodBeat.o(205352);
          return 0;
        }
        localdvc.SRj = locala.abFh.readString();
        AppMethodBeat.o(205352);
        return 0;
      }
      AppMethodBeat.o(205352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvc
 * JD-Core Version:    0.7.0.1
 */