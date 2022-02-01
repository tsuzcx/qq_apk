package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bw.a
{
  public String pTd;
  public String pTe;
  public String pTf;
  public String pTg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pTd != null) {
        paramVarArgs.e(1, this.pTd);
      }
      if (this.pTe != null) {
        paramVarArgs.e(2, this.pTe);
      }
      if (this.pTf != null) {
        paramVarArgs.e(3, this.pTf);
      }
      if (this.pTg != null) {
        paramVarArgs.e(4, this.pTg);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pTd == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.pTd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pTe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pTe);
      }
      i = paramInt;
      if (this.pTf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pTf);
      }
      paramInt = i;
      if (this.pTg != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pTg);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localaw.pTd = locala.UbS.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localaw.pTe = locala.UbS.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localaw.pTf = locala.UbS.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localaw.pTg = locala.UbS.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */