package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gfl
  extends com.tencent.mm.bx.a
{
  public long accG;
  public b vgA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32516);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.accG);
      if (this.vgA != null) {
        paramVarArgs.d(2, this.vgA);
      }
      AppMethodBeat.o(32516);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.accG) + 0;
      paramInt = i;
      if (this.vgA != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.vgA);
      }
      AppMethodBeat.o(32516);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32516);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gfl localgfl = (gfl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32516);
        return -1;
      case 1: 
        localgfl.accG = locala.ajGk.aaw();
        AppMethodBeat.o(32516);
        return 0;
      }
      localgfl.vgA = locala.ajGk.kFX();
      AppMethodBeat.o(32516);
      return 0;
    }
    AppMethodBeat.o(32516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfl
 * JD-Core Version:    0.7.0.1
 */