package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eig
  extends com.tencent.mm.cd.a
{
  public String oDJ;
  public String oDK;
  public String tVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oDJ != null) {
        paramVarArgs.f(1, this.oDJ);
      }
      if (this.oDK != null) {
        paramVarArgs.f(2, this.oDK);
      }
      if (this.tVu != null) {
        paramVarArgs.f(3, this.tVu);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oDJ == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.oDJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oDK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.oDK);
      }
      i = paramInt;
      if (this.tVu != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.tVu);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eig localeig = (eig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localeig.oDJ = locala.abFh.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localeig.oDK = locala.abFh.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localeig.tVu = locala.abFh.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eig
 * JD-Core Version:    0.7.0.1
 */