package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ani
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String JJP;
  public int Width;
  public String akjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104769);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.JJP != null) {
        paramVarArgs.g(1, this.JJP);
      }
      paramVarArgs.bS(2, this.Width);
      paramVarArgs.bS(3, this.Height);
      if (this.akjT != null) {
        paramVarArgs.g(4, this.akjT);
      }
      AppMethodBeat.o(104769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.JJP == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.JJP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Width) + i.a.a.b.b.a.cJ(3, this.Height);
      paramInt = i;
      if (this.akjT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.akjT);
      }
      AppMethodBeat.o(104769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104769);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ani localani = (ani)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104769);
          return -1;
        case 1: 
          localani.JJP = locala.ajGk.readString();
          AppMethodBeat.o(104769);
          return 0;
        case 2: 
          localani.Width = locala.ajGk.aar();
          AppMethodBeat.o(104769);
          return 0;
        case 3: 
          localani.Height = locala.ajGk.aar();
          AppMethodBeat.o(104769);
          return 0;
        }
        localani.akjT = locala.ajGk.readString();
        AppMethodBeat.o(104769);
        return 0;
      }
      AppMethodBeat.o(104769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ani
 * JD-Core Version:    0.7.0.1
 */