package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drb
  extends com.tencent.mm.bx.a
{
  public String DAq;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DAq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.sdO);
      if (this.DAq != null) {
        paramVarArgs.d(2, this.DAq);
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sdO) + 0;
      paramInt = i;
      if (this.DAq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DAq);
      }
      AppMethodBeat.o(32530);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.DAq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32530);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32530);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      drb localdrb = (drb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32530);
        return -1;
      case 1: 
        localdrb.sdO = locala.KhF.xS();
        AppMethodBeat.o(32530);
        return 0;
      }
      localdrb.DAq = locala.KhF.readString();
      AppMethodBeat.o(32530);
      return 0;
    }
    AppMethodBeat.o(32530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drb
 * JD-Core Version:    0.7.0.1
 */