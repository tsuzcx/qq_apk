package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djb
  extends com.tencent.mm.bx.a
{
  public int Ezl;
  public long LAn;
  public long LAo;
  public long xBr;
  public int xil;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ezl);
      paramVarArgs.aR(2, this.xil);
      paramVarArgs.aG(3, this.xBr);
      paramVarArgs.aG(4, this.LAn);
      paramVarArgs.aG(5, this.LAo);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Ezl);
      int i = f.a.a.b.b.a.bA(2, this.xil);
      int j = f.a.a.b.b.a.q(3, this.xBr);
      int k = f.a.a.b.b.a.q(4, this.LAn);
      int m = f.a.a.b.b.a.q(5, this.LAo);
      AppMethodBeat.o(169092);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djb localdjb = (djb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localdjb.Ezl = locala.KhF.xS();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localdjb.xil = locala.KhF.xS();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localdjb.xBr = locala.KhF.xT();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localdjb.LAn = locala.KhF.xT();
        AppMethodBeat.o(169092);
        return 0;
      }
      localdjb.LAo = locala.KhF.xT();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djb
 * JD-Core Version:    0.7.0.1
 */