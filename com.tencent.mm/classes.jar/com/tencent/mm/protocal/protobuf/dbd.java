package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class dbd
  extends com.tencent.mm.cd.a
{
  public boolean Gch;
  public b GdC;
  public String TIm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230052);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIm != null) {
        paramVarArgs.f(1, this.TIm);
      }
      if (this.GdC != null) {
        paramVarArgs.c(2, this.GdC);
      }
      paramVarArgs.co(3, this.Gch);
      AppMethodBeat.o(230052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIm == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.TIm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GdC != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.GdC);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(230052);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230052);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbd localdbd = (dbd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230052);
          return -1;
        case 1: 
          localdbd.TIm = locala.abFh.readString();
          AppMethodBeat.o(230052);
          return 0;
        case 2: 
          localdbd.GdC = locala.abFh.iUw();
          AppMethodBeat.o(230052);
          return 0;
        }
        localdbd.Gch = locala.abFh.AB();
        AppMethodBeat.o(230052);
        return 0;
      }
      AppMethodBeat.o(230052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbd
 * JD-Core Version:    0.7.0.1
 */