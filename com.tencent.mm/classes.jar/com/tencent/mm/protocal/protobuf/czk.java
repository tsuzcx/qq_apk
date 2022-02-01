package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czk
  extends com.tencent.mm.bx.a
{
  public String Ern;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133200);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.vJz);
      if (this.Ern != null) {
        paramVarArgs.d(2, this.Ern);
      }
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.vJz) + 0;
      paramInt = i;
      if (this.Ern != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ern);
      }
      AppMethodBeat.o(133200);
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
      AppMethodBeat.o(133200);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      czk localczk = (czk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133200);
        return -1;
      case 1: 
        localczk.vJz = locala.KhF.xS();
        AppMethodBeat.o(133200);
        return 0;
      }
      localczk.Ern = locala.KhF.readString();
      AppMethodBeat.o(133200);
      return 0;
    }
    AppMethodBeat.o(133200);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czk
 * JD-Core Version:    0.7.0.1
 */