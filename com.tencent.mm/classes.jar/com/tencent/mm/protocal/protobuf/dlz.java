package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlz
  extends com.tencent.mm.cd.a
{
  public String RIC;
  public String TST;
  public float TSX;
  public float TSY;
  public String URL;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200150);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.RIC != null) {
        paramVarArgs.f(2, this.RIC);
      }
      paramVarArgs.i(3, this.TSX);
      paramVarArgs.i(4, this.TSY);
      if (this.URL != null) {
        paramVarArgs.f(5, this.URL);
      }
      if (this.TST != null) {
        paramVarArgs.f(6, this.TST);
      }
      AppMethodBeat.o(200150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RIC != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RIC);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.URL);
      }
      i = paramInt;
      if (this.TST != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TST);
      }
      AppMethodBeat.o(200150);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200150);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlz localdlz = (dlz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200150);
          return -1;
        case 1: 
          localdlz.fwr = locala.abFh.readString();
          AppMethodBeat.o(200150);
          return 0;
        case 2: 
          localdlz.RIC = locala.abFh.readString();
          AppMethodBeat.o(200150);
          return 0;
        case 3: 
          localdlz.TSX = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(200150);
          return 0;
        case 4: 
          localdlz.TSY = Float.intBitsToFloat(locala.abFh.AO());
          AppMethodBeat.o(200150);
          return 0;
        case 5: 
          localdlz.URL = locala.abFh.readString();
          AppMethodBeat.o(200150);
          return 0;
        }
        localdlz.TST = locala.abFh.readString();
        AppMethodBeat.o(200150);
        return 0;
      }
      AppMethodBeat.o(200150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlz
 * JD-Core Version:    0.7.0.1
 */