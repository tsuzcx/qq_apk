package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqt
  extends com.tencent.mm.bw.a
{
  public String KUC;
  public String Noc;
  public String Noo;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212313);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Noc != null) {
        paramVarArgs.e(1, this.Noc);
      }
      if (this.KUC != null) {
        paramVarArgs.e(2, this.KUC);
      }
      if (this.Noo != null) {
        paramVarArgs.e(3, this.Noo);
      }
      paramVarArgs.aM(4, this.scene);
      AppMethodBeat.o(212313);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Noc == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Noc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KUC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KUC);
      }
      i = paramInt;
      if (this.Noo != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Noo);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.scene);
      AppMethodBeat.o(212313);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212313);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eqt localeqt = (eqt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212313);
          return -1;
        case 1: 
          localeqt.Noc = locala.UbS.readString();
          AppMethodBeat.o(212313);
          return 0;
        case 2: 
          localeqt.KUC = locala.UbS.readString();
          AppMethodBeat.o(212313);
          return 0;
        case 3: 
          localeqt.Noo = locala.UbS.readString();
          AppMethodBeat.o(212313);
          return 0;
        }
        localeqt.scene = locala.UbS.zi();
        AppMethodBeat.o(212313);
        return 0;
      }
      AppMethodBeat.o(212313);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqt
 * JD-Core Version:    0.7.0.1
 */