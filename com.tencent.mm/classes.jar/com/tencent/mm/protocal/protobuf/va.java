package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class va
  extends com.tencent.mm.bw.a
{
  public String Lfm;
  public String code;
  public String dNI;
  public String pRX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113977);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.pRX != null) {
        paramVarArgs.e(1, this.pRX);
      }
      if (this.code != null) {
        paramVarArgs.e(2, this.code);
      }
      if (this.Lfm != null) {
        paramVarArgs.e(3, this.Lfm);
      }
      if (this.dNI != null) {
        paramVarArgs.e(4, this.dNI);
      }
      AppMethodBeat.o(113977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pRX == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.pRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.code != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.code);
      }
      i = paramInt;
      if (this.Lfm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lfm);
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dNI);
      }
      AppMethodBeat.o(113977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113977);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        va localva = (va)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113977);
          return -1;
        case 1: 
          localva.pRX = locala.UbS.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 2: 
          localva.code = locala.UbS.readString();
          AppMethodBeat.o(113977);
          return 0;
        case 3: 
          localva.Lfm = locala.UbS.readString();
          AppMethodBeat.o(113977);
          return 0;
        }
        localva.dNI = locala.UbS.readString();
        AppMethodBeat.o(113977);
        return 0;
      }
      AppMethodBeat.o(113977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.va
 * JD-Core Version:    0.7.0.1
 */