package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class km
  extends com.tencent.mm.bx.a
{
  public int CEj;
  public int CFp;
  public int CFq;
  public int CFr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CEj);
      paramVarArgs.aR(2, this.CFp);
      paramVarArgs.aR(3, this.CFq);
      paramVarArgs.aR(4, this.CFr);
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CEj);
      int i = f.a.a.b.b.a.bA(2, this.CFp);
      int j = f.a.a.b.b.a.bA(3, this.CFq);
      int k = f.a.a.b.b.a.bA(4, this.CFr);
      AppMethodBeat.o(32145);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      km localkm = (km)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32145);
        return -1;
      case 1: 
        localkm.CEj = locala.KhF.xS();
        AppMethodBeat.o(32145);
        return 0;
      case 2: 
        localkm.CFp = locala.KhF.xS();
        AppMethodBeat.o(32145);
        return 0;
      case 3: 
        localkm.CFq = locala.KhF.xS();
        AppMethodBeat.o(32145);
        return 0;
      }
      localkm.CFr = locala.KhF.xS();
      AppMethodBeat.o(32145);
      return 0;
    }
    AppMethodBeat.o(32145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.km
 * JD-Core Version:    0.7.0.1
 */