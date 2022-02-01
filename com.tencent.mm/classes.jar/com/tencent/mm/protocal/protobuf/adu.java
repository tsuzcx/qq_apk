package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adu
  extends com.tencent.mm.bx.a
{
  public String KtE;
  public String ZlZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32168);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZlZ != null) {
        paramVarArgs.g(1, this.ZlZ);
      }
      if (this.KtE != null) {
        paramVarArgs.g(2, this.KtE);
      }
      AppMethodBeat.o(32168);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZlZ == null) {
        break label278;
      }
    }
    label278:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZlZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KtE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.KtE);
      }
      AppMethodBeat.o(32168);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32168);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32168);
          return -1;
        case 1: 
          localadu.ZlZ = locala.ajGk.readString();
          AppMethodBeat.o(32168);
          return 0;
        }
        localadu.KtE = locala.ajGk.readString();
        AppMethodBeat.o(32168);
        return 0;
      }
      AppMethodBeat.o(32168);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */