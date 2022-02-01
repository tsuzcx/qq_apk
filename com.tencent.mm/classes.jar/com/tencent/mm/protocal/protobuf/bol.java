package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bol
  extends com.tencent.mm.cd.a
{
  public String SZt;
  public int SZu;
  public int SZv;
  public long SZw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SZt != null) {
        paramVarArgs.f(1, this.SZt);
      }
      paramVarArgs.aY(2, this.SZu);
      paramVarArgs.aY(3, this.SZv);
      paramVarArgs.bm(99, this.SZw);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SZt == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.SZt) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SZu);
      int j = g.a.a.b.b.a.bM(3, this.SZv);
      int k = g.a.a.b.b.a.p(99, this.SZw);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bol localbol = (bol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localbol.SZt = locala.abFh.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localbol.SZu = locala.abFh.AK();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localbol.SZv = locala.abFh.AK();
          AppMethodBeat.o(152542);
          return 0;
        }
        localbol.SZw = locala.abFh.AN();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */