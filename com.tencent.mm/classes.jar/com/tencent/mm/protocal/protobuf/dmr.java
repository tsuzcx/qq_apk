package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmr
  extends com.tencent.mm.bw.a
{
  public int LCN;
  public String dNI;
  public String tsW;
  public String tsX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.tsX != null) {
        paramVarArgs.e(2, this.tsX);
      }
      if (this.tsW != null) {
        paramVarArgs.e(3, this.tsW);
      }
      paramVarArgs.aM(4, this.LCN);
      AppMethodBeat.o(209812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tsX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.tsX);
      }
      i = paramInt;
      if (this.tsW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.tsW);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LCN);
      AppMethodBeat.o(209812);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209812);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmr localdmr = (dmr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209812);
          return -1;
        case 1: 
          localdmr.dNI = locala.UbS.readString();
          AppMethodBeat.o(209812);
          return 0;
        case 2: 
          localdmr.tsX = locala.UbS.readString();
          AppMethodBeat.o(209812);
          return 0;
        case 3: 
          localdmr.tsW = locala.UbS.readString();
          AppMethodBeat.o(209812);
          return 0;
        }
        localdmr.LCN = locala.UbS.zi();
        AppMethodBeat.o(209812);
        return 0;
      }
      AppMethodBeat.o(209812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmr
 * JD-Core Version:    0.7.0.1
 */