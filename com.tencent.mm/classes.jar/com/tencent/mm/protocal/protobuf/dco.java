package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dco
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String URL;
  public String xMK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209792);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      if (this.xMK != null) {
        paramVarArgs.e(3, this.xMK);
      }
      AppMethodBeat.o(209792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.URL);
      }
      i = paramInt;
      if (this.xMK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xMK);
      }
      AppMethodBeat.o(209792);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209792);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dco localdco = (dco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209792);
          return -1;
        case 1: 
          localdco.Title = locala.UbS.readString();
          AppMethodBeat.o(209792);
          return 0;
        case 2: 
          localdco.URL = locala.UbS.readString();
          AppMethodBeat.o(209792);
          return 0;
        }
        localdco.xMK = locala.UbS.readString();
        AppMethodBeat.o(209792);
        return 0;
      }
      AppMethodBeat.o(209792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dco
 * JD-Core Version:    0.7.0.1
 */