package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class anp
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String Zug;
  public String akjW;
  public int akjX;
  public int nUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104772);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zug != null) {
        paramVarArgs.g(1, this.Zug);
      }
      paramVarArgs.bS(2, this.nUz);
      paramVarArgs.bS(3, this.akjX);
      if (this.IHo != null) {
        paramVarArgs.g(4, this.IHo);
      }
      if (this.akjW != null) {
        paramVarArgs.g(5, this.akjW);
      }
      AppMethodBeat.o(104772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zug == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zug) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nUz) + i.a.a.b.b.a.cJ(3, this.akjX);
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHo);
      }
      i = paramInt;
      if (this.akjW != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.akjW);
      }
      AppMethodBeat.o(104772);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104772);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        anp localanp = (anp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104772);
          return -1;
        case 1: 
          localanp.Zug = locala.ajGk.readString();
          AppMethodBeat.o(104772);
          return 0;
        case 2: 
          localanp.nUz = locala.ajGk.aar();
          AppMethodBeat.o(104772);
          return 0;
        case 3: 
          localanp.akjX = locala.ajGk.aar();
          AppMethodBeat.o(104772);
          return 0;
        case 4: 
          localanp.IHo = locala.ajGk.readString();
          AppMethodBeat.o(104772);
          return 0;
        }
        localanp.akjW = locala.ajGk.readString();
        AppMethodBeat.o(104772);
        return 0;
      }
      AppMethodBeat.o(104772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anp
 * JD-Core Version:    0.7.0.1
 */