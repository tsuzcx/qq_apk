package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class avb
  extends com.tencent.mm.bx.a
{
  public int ZFr;
  public b ZFs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257571);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZFr);
      if (this.ZFs != null) {
        paramVarArgs.d(2, this.ZFs);
      }
      AppMethodBeat.o(257571);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZFr) + 0;
      paramInt = i;
      if (this.ZFs != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZFs);
      }
      AppMethodBeat.o(257571);
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
      AppMethodBeat.o(257571);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      avb localavb = (avb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257571);
        return -1;
      case 1: 
        localavb.ZFr = locala.ajGk.aar();
        AppMethodBeat.o(257571);
        return 0;
      }
      localavb.ZFs = locala.ajGk.kFX();
      AppMethodBeat.o(257571);
      return 0;
    }
    AppMethodBeat.o(257571);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avb
 * JD-Core Version:    0.7.0.1
 */