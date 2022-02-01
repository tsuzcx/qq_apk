package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czy
  extends com.tencent.mm.bx.a
{
  public String DAn;
  public int DJf;
  public String ErX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJf);
      if (this.DAn != null) {
        paramVarArgs.d(2, this.DAn);
      }
      if (this.ErX != null) {
        paramVarArgs.d(3, this.ErX);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DJf) + 0;
      paramInt = i;
      if (this.DAn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DAn);
      }
      i = paramInt;
      if (this.ErX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ErX);
      }
      AppMethodBeat.o(152708);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      czy localczy = (czy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localczy.DJf = locala.KhF.xS();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localczy.DAn = locala.KhF.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localczy.ErX = locala.KhF.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czy
 * JD-Core Version:    0.7.0.1
 */