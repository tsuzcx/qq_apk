package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqr
  extends com.tencent.mm.bw.a
{
  public String KUC;
  public String Mzk;
  public int Mzl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mzl);
      if (this.KUC != null) {
        paramVarArgs.e(2, this.KUC);
      }
      if (this.Mzk != null) {
        paramVarArgs.e(3, this.Mzk);
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Mzl) + 0;
      paramInt = i;
      if (this.KUC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KUC);
      }
      i = paramInt;
      if (this.Mzk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mzk);
      }
      AppMethodBeat.o(176156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(176156);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqr localeqr = (eqr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(176156);
        return -1;
      case 1: 
        localeqr.Mzl = locala.UbS.zi();
        AppMethodBeat.o(176156);
        return 0;
      case 2: 
        localeqr.KUC = locala.UbS.readString();
        AppMethodBeat.o(176156);
        return 0;
      }
      localeqr.Mzk = locala.UbS.readString();
      AppMethodBeat.o(176156);
      return 0;
    }
    AppMethodBeat.o(176156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqr
 * JD-Core Version:    0.7.0.1
 */