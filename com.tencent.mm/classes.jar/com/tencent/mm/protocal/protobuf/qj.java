package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qj
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String IGH;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257976);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGH != null) {
        paramVarArgs.g(1, this.IGH);
      }
      paramVarArgs.bS(2, this.Width);
      paramVarArgs.bS(3, this.Height);
      AppMethodBeat.o(257976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGH == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGH) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Width);
      int j = i.a.a.b.b.a.cJ(3, this.Height);
      AppMethodBeat.o(257976);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257976);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        qj localqj = (qj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257976);
          return -1;
        case 1: 
          localqj.IGH = locala.ajGk.readString();
          AppMethodBeat.o(257976);
          return 0;
        case 2: 
          localqj.Width = locala.ajGk.aar();
          AppMethodBeat.o(257976);
          return 0;
        }
        localqj.Height = locala.ajGk.aar();
        AppMethodBeat.o(257976);
        return 0;
      }
      AppMethodBeat.o(257976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qj
 * JD-Core Version:    0.7.0.1
 */