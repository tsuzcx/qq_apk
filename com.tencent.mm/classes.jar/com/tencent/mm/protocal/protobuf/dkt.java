package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkt
  extends com.tencent.mm.cd.a
{
  public String TRU;
  public String TRV;
  public String TRW;
  public boolean TRX;
  public String TRY;
  public String fvP;
  public String word_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TRU != null) {
        paramVarArgs.f(1, this.TRU);
      }
      if (this.word_color != null) {
        paramVarArgs.f(2, this.word_color);
      }
      if (this.fvP != null) {
        paramVarArgs.f(3, this.fvP);
      }
      if (this.TRV != null) {
        paramVarArgs.f(4, this.TRV);
      }
      if (this.TRW != null) {
        paramVarArgs.f(5, this.TRW);
      }
      paramVarArgs.co(6, this.TRX);
      if (this.TRY != null) {
        paramVarArgs.f(7, this.TRY);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TRU == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.TRU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.word_color != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.word_color);
      }
      i = paramInt;
      if (this.fvP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fvP);
      }
      paramInt = i;
      if (this.TRV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TRV);
      }
      i = paramInt;
      if (this.TRW != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TRW);
      }
      i += g.a.a.b.b.a.gL(6) + 1;
      paramInt = i;
      if (this.TRY != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TRY);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dkt localdkt = (dkt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localdkt.TRU = locala.abFh.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localdkt.word_color = locala.abFh.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localdkt.fvP = locala.abFh.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localdkt.TRV = locala.abFh.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localdkt.TRW = locala.abFh.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localdkt.TRX = locala.abFh.AB();
          AppMethodBeat.o(72547);
          return 0;
        }
        localdkt.TRY = locala.abFh.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkt
 * JD-Core Version:    0.7.0.1
 */