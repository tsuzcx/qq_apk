package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dca
  extends com.tencent.mm.cd.a
{
  public int TJA;
  public int TJB;
  public int TJC;
  public String TJx;
  public String TJy;
  public int TJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TJx != null) {
        paramVarArgs.f(1, this.TJx);
      }
      if (this.TJy != null) {
        paramVarArgs.f(2, this.TJy);
      }
      paramVarArgs.aY(3, this.TJz);
      paramVarArgs.aY(4, this.TJA);
      paramVarArgs.aY(5, this.TJB);
      paramVarArgs.aY(7, this.TJC);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TJx == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.b.b.a.g(1, this.TJx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TJy != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TJy);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TJz);
      int j = g.a.a.b.b.a.bM(4, this.TJA);
      int k = g.a.a.b.b.a.bM(5, this.TJB);
      int m = g.a.a.b.b.a.bM(7, this.TJC);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dca localdca = (dca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localdca.TJx = locala.abFh.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localdca.TJy = locala.abFh.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localdca.TJz = locala.abFh.AK();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localdca.TJA = locala.abFh.AK();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localdca.TJB = locala.abFh.AK();
          AppMethodBeat.o(133179);
          return 0;
        }
        localdca.TJC = locala.abFh.AK();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dca
 * JD-Core Version:    0.7.0.1
 */