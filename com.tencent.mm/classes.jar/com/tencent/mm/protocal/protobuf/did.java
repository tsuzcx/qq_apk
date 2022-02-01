package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class did
  extends com.tencent.mm.bx.a
{
  public int uKQ;
  public int uKR;
  public int uKS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uKQ);
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKS);
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.uKQ);
      int i = f.a.a.b.b.a.bA(2, this.uKR);
      int j = f.a.a.b.b.a.bA(3, this.uKS);
      AppMethodBeat.o(32486);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32486);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      did localdid = (did)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32486);
        return -1;
      case 1: 
        localdid.uKQ = locala.KhF.xS();
        AppMethodBeat.o(32486);
        return 0;
      case 2: 
        localdid.uKR = locala.KhF.xS();
        AppMethodBeat.o(32486);
        return 0;
      }
      localdid.uKS = locala.KhF.xS();
      AppMethodBeat.o(32486);
      return 0;
    }
    AppMethodBeat.o(32486);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.did
 * JD-Core Version:    0.7.0.1
 */