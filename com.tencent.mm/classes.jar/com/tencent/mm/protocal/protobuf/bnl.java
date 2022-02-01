package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bnl
  extends com.tencent.mm.bx.a
{
  public b ZTU;
  public b ZUe;
  public long ZVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258741);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZVU);
      if (this.ZUe != null) {
        paramVarArgs.d(2, this.ZUe);
      }
      if (this.ZTU != null) {
        paramVarArgs.d(3, this.ZTU);
      }
      AppMethodBeat.o(258741);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZVU) + 0;
      paramInt = i;
      if (this.ZUe != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZUe);
      }
      i = paramInt;
      if (this.ZTU != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZTU);
      }
      AppMethodBeat.o(258741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258741);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bnl localbnl = (bnl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258741);
        return -1;
      case 1: 
        localbnl.ZVU = locala.ajGk.aaw();
        AppMethodBeat.o(258741);
        return 0;
      case 2: 
        localbnl.ZUe = locala.ajGk.kFX();
        AppMethodBeat.o(258741);
        return 0;
      }
      localbnl.ZTU = locala.ajGk.kFX();
      AppMethodBeat.o(258741);
      return 0;
    }
    AppMethodBeat.o(258741);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnl
 * JD-Core Version:    0.7.0.1
 */