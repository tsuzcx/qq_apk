package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class elo
  extends com.tencent.mm.bw.a
{
  public String MXr;
  public int MXv;
  public String MXx;
  public String content;
  public int dDN;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153308);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MXx != null) {
        paramVarArgs.e(1, this.MXx);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.content != null) {
        paramVarArgs.e(3, this.content);
      }
      if (this.MXr != null) {
        paramVarArgs.e(4, this.MXr);
      }
      paramVarArgs.aM(5, this.MXv);
      paramVarArgs.aM(6, this.state);
      AppMethodBeat.o(153308);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MXx == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.f(1, this.MXx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.content);
      }
      i = paramInt;
      if (this.MXr != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MXr);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.MXv);
      int j = g.a.a.b.b.a.bu(6, this.state);
      AppMethodBeat.o(153308);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153308);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        elo localelo = (elo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153308);
          return -1;
        case 1: 
          localelo.MXx = locala.UbS.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 2: 
          localelo.dDN = locala.UbS.zi();
          AppMethodBeat.o(153308);
          return 0;
        case 3: 
          localelo.content = locala.UbS.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 4: 
          localelo.MXr = locala.UbS.readString();
          AppMethodBeat.o(153308);
          return 0;
        case 5: 
          localelo.MXv = locala.UbS.zi();
          AppMethodBeat.o(153308);
          return 0;
        }
        localelo.state = locala.UbS.zi();
        AppMethodBeat.o(153308);
        return 0;
      }
      AppMethodBeat.o(153308);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elo
 * JD-Core Version:    0.7.0.1
 */