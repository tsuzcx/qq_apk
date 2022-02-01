package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csu
  extends com.tencent.mm.bw.a
{
  public String LYu;
  public int Loh;
  public int MxQ;
  public String MxR;
  public String MxS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LYu != null) {
        paramVarArgs.e(1, this.LYu);
      }
      paramVarArgs.aM(2, this.MxQ);
      if (this.MxR != null) {
        paramVarArgs.e(3, this.MxR);
      }
      paramVarArgs.aM(4, this.Loh);
      if (this.MxS != null) {
        paramVarArgs.e(5, this.MxS);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LYu == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.LYu) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MxQ);
      paramInt = i;
      if (this.MxR != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MxR);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Loh);
      paramInt = i;
      if (this.MxS != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MxS);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        csu localcsu = (csu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localcsu.LYu = locala.UbS.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localcsu.MxQ = locala.UbS.zi();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localcsu.MxR = locala.UbS.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localcsu.Loh = locala.UbS.zi();
          AppMethodBeat.o(115847);
          return 0;
        }
        localcsu.MxS = locala.UbS.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csu
 * JD-Core Version:    0.7.0.1
 */