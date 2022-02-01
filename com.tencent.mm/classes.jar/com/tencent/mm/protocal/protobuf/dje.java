package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dje
  extends com.tencent.mm.cd.a
{
  public String Hma;
  public long TQG;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hma != null) {
        paramVarArgs.f(1, this.Hma);
      }
      paramVarArgs.bm(2, this.TQG);
      if (this.url != null) {
        paramVarArgs.f(3, this.url);
      }
      AppMethodBeat.o(72541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hma == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.Hma) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.TQG);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.url);
      }
      AppMethodBeat.o(72541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72541);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dje localdje = (dje)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72541);
          return -1;
        case 1: 
          localdje.Hma = locala.abFh.readString();
          AppMethodBeat.o(72541);
          return 0;
        case 2: 
          localdje.TQG = locala.abFh.AN();
          AppMethodBeat.o(72541);
          return 0;
        }
        localdje.url = locala.abFh.readString();
        AppMethodBeat.o(72541);
        return 0;
      }
      AppMethodBeat.o(72541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dje
 * JD-Core Version:    0.7.0.1
 */