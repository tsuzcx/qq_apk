package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctu
  extends com.tencent.mm.bw.a
{
  public String Mzd;
  public String Mze;
  public String Mzf;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mzd != null) {
        paramVarArgs.e(1, this.Mzd);
      }
      if (this.Mze != null) {
        paramVarArgs.e(2, this.Mze);
      }
      if (this.Mzf != null) {
        paramVarArgs.e(3, this.Mzf);
      }
      paramVarArgs.aM(4, this.action);
      AppMethodBeat.o(194512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mzd == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Mzd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mze != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mze);
      }
      i = paramInt;
      if (this.Mzf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mzf);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.action);
      AppMethodBeat.o(194512);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194512);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctu localctu = (ctu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194512);
          return -1;
        case 1: 
          localctu.Mzd = locala.UbS.readString();
          AppMethodBeat.o(194512);
          return 0;
        case 2: 
          localctu.Mze = locala.UbS.readString();
          AppMethodBeat.o(194512);
          return 0;
        case 3: 
          localctu.Mzf = locala.UbS.readString();
          AppMethodBeat.o(194512);
          return 0;
        }
        localctu.action = locala.UbS.zi();
        AppMethodBeat.o(194512);
        return 0;
      }
      AppMethodBeat.o(194512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctu
 * JD-Core Version:    0.7.0.1
 */