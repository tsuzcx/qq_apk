package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dfo
  extends com.tencent.mm.bx.a
{
  public int aaLf;
  public b aaLg;
  public int aaLn;
  public int aaLo;
  public int vgN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaLf);
      if (this.aaLg != null) {
        paramVarArgs.d(2, this.aaLg);
      }
      paramVarArgs.bS(3, this.aaLn);
      paramVarArgs.bS(4, this.vgN);
      paramVarArgs.bS(5, this.aaLo);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaLf) + 0;
      paramInt = i;
      if (this.aaLg != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaLg);
      }
      i = i.a.a.b.b.a.cJ(3, this.aaLn);
      int j = i.a.a.b.b.a.cJ(4, this.vgN);
      int k = i.a.a.b.b.a.cJ(5, this.aaLo);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dfo localdfo = (dfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localdfo.aaLf = locala.ajGk.aar();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localdfo.aaLg = locala.ajGk.kFX();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localdfo.aaLn = locala.ajGk.aar();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localdfo.vgN = locala.ajGk.aar();
        AppMethodBeat.o(116337);
        return 0;
      }
      localdfo.aaLo = locala.ajGk.aar();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfo
 * JD-Core Version:    0.7.0.1
 */