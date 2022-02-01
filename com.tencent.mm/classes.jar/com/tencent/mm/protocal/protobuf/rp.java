package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class rp
  extends com.tencent.mm.bx.a
{
  public b YWA;
  public b YWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257599);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWz != null) {
        paramVarArgs.d(1, this.YWz);
      }
      if (this.YWA != null) {
        paramVarArgs.d(2, this.YWA);
      }
      AppMethodBeat.o(257599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWz == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.c(1, this.YWz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YWA != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YWA);
      }
      AppMethodBeat.o(257599);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257599);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        rp localrp = (rp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257599);
          return -1;
        case 1: 
          localrp.YWz = locala.ajGk.kFX();
          AppMethodBeat.o(257599);
          return 0;
        }
        localrp.YWA = locala.ajGk.kFX();
        AppMethodBeat.o(257599);
        return 0;
      }
      AppMethodBeat.o(257599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rp
 * JD-Core Version:    0.7.0.1
 */