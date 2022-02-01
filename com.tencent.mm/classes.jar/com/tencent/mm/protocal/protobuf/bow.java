package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bow
  extends com.tencent.mm.bx.a
{
  public int LzO;
  public int niJ;
  public long objectId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.objectId);
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.niJ);
      paramVarArgs.aR(4, this.LzO);
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.objectId);
      int i = f.a.a.b.b.a.bA(2, this.scene);
      int j = f.a.a.b.b.a.bA(3, this.niJ);
      int k = f.a.a.b.b.a.bA(4, this.LzO);
      AppMethodBeat.o(184214);
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
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bow localbow = (bow)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localbow.objectId = locala.KhF.xT();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localbow.scene = locala.KhF.xS();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localbow.niJ = locala.KhF.xS();
        AppMethodBeat.o(184214);
        return 0;
      }
      localbow.LzO = locala.KhF.xS();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */