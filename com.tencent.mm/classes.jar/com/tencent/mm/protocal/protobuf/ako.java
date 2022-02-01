package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ako
  extends com.tencent.mm.bw.a
{
  public int Lty;
  public String key;
  public String oxJ;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215275);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.oxJ != null) {
        paramVarArgs.e(3, this.oxJ);
      }
      paramVarArgs.aM(4, this.Lty);
      paramVarArgs.aM(5, this.type);
      AppMethodBeat.o(215275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.oxJ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oxJ);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Lty);
      int j = g.a.a.b.b.a.bu(5, this.type);
      AppMethodBeat.o(215275);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(215275);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ako localako = (ako)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215275);
          return -1;
        case 1: 
          localako.key = locala.UbS.readString();
          AppMethodBeat.o(215275);
          return 0;
        case 2: 
          localako.title = locala.UbS.readString();
          AppMethodBeat.o(215275);
          return 0;
        case 3: 
          localako.oxJ = locala.UbS.readString();
          AppMethodBeat.o(215275);
          return 0;
        case 4: 
          localako.Lty = locala.UbS.zi();
          AppMethodBeat.o(215275);
          return 0;
        }
        localako.type = locala.UbS.zi();
        AppMethodBeat.o(215275);
        return 0;
      }
      AppMethodBeat.o(215275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ako
 * JD-Core Version:    0.7.0.1
 */