package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ewi
  extends com.tencent.mm.bw.a
{
  public String MJz;
  public String Nue;
  public String Nuf;
  public String xJE;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MJz != null) {
        paramVarArgs.e(1, this.MJz);
      }
      if (this.Nue != null) {
        paramVarArgs.e(2, this.Nue);
      }
      if (this.xNH != null) {
        paramVarArgs.e(3, this.xNH);
      }
      if (this.xJE != null) {
        paramVarArgs.e(4, this.xJE);
      }
      if (this.Nuf != null) {
        paramVarArgs.e(5, this.Nuf);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MJz == null) {
        break label465;
      }
    }
    label465:
    for (int i = g.a.a.b.b.a.f(1, this.MJz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nue != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nue);
      }
      i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNH);
      }
      paramInt = i;
      if (this.xJE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJE);
      }
      i = paramInt;
      if (this.Nuf != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Nuf);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ewi localewi = (ewi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localewi.MJz = locala.UbS.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localewi.Nue = locala.UbS.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localewi.xNH = locala.UbS.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localewi.xJE = locala.UbS.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localewi.Nuf = locala.UbS.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewi
 * JD-Core Version:    0.7.0.1
 */