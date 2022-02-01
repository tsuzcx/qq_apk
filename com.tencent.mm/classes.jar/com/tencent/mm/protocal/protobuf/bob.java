package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bob
  extends com.tencent.mm.bx.a
{
  public int DLv;
  public String DLw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DLv);
      if (this.DLw != null) {
        paramVarArgs.d(2, this.DLw);
      }
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DLv) + 0;
      paramInt = i;
      if (this.DLw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DLw);
      }
      AppMethodBeat.o(169926);
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
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bob localbob = (bob)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169926);
        return -1;
      case 1: 
        localbob.DLv = locala.KhF.xS();
        AppMethodBeat.o(169926);
        return 0;
      }
      localbob.DLw = locala.KhF.readString();
      AppMethodBeat.o(169926);
      return 0;
    }
    AppMethodBeat.o(169926);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bob
 * JD-Core Version:    0.7.0.1
 */