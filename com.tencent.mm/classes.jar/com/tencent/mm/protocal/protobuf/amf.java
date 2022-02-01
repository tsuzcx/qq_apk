package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amf
  extends com.tencent.mm.bx.a
{
  public int index;
  public int jzV;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32211);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.index);
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aR(3, this.jzV);
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = f.a.a.b.b.a.bA(3, this.jzV);
      AppMethodBeat.o(32211);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amf localamf = (amf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32211);
        return -1;
      case 1: 
        localamf.index = locala.KhF.xS();
        AppMethodBeat.o(32211);
        return 0;
      case 2: 
        localamf.username = locala.KhF.readString();
        AppMethodBeat.o(32211);
        return 0;
      }
      localamf.jzV = locala.KhF.xS();
      AppMethodBeat.o(32211);
      return 0;
    }
    AppMethodBeat.o(32211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amf
 * JD-Core Version:    0.7.0.1
 */