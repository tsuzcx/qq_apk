package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccf
  extends com.tencent.mm.bx.a
{
  public long CKj;
  public long DYC;
  public int nvl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.nvl);
      paramVarArgs.aG(2, this.CKj);
      paramVarArgs.aG(3, this.DYC);
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.nvl);
      int i = f.a.a.b.b.a.q(2, this.CKj);
      int j = f.a.a.b.b.a.q(3, this.DYC);
      AppMethodBeat.o(104829);
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
      AppMethodBeat.o(104829);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccf localccf = (ccf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104829);
        return -1;
      case 1: 
        localccf.nvl = locala.KhF.xS();
        AppMethodBeat.o(104829);
        return 0;
      case 2: 
        localccf.CKj = locala.KhF.xT();
        AppMethodBeat.o(104829);
        return 0;
      }
      localccf.DYC = locala.KhF.xT();
      AppMethodBeat.o(104829);
      return 0;
    }
    AppMethodBeat.o(104829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccf
 * JD-Core Version:    0.7.0.1
 */