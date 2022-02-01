package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ja
  extends com.tencent.mm.bw.a
{
  public String AOk;
  public String KNw;
  public String dDj;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNw != null) {
        paramVarArgs.e(1, this.KNw);
      }
      if (this.dDj != null) {
        paramVarArgs.e(2, this.dDj);
      }
      if (this.ynT != null) {
        paramVarArgs.e(3, this.ynT);
      }
      if (this.AOk != null) {
        paramVarArgs.e(4, this.AOk);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNw == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.KNw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dDj);
      }
      i = paramInt;
      if (this.ynT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ynT);
      }
      paramInt = i;
      if (this.AOk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.AOk);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ja localja = (ja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localja.KNw = locala.UbS.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localja.dDj = locala.UbS.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localja.ynT = locala.UbS.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localja.AOk = locala.UbS.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ja
 * JD-Core Version:    0.7.0.1
 */