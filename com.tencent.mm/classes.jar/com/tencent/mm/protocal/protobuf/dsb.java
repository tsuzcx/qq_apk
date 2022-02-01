package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsb
  extends com.tencent.mm.bx.a
{
  public int CBs;
  public long CCn;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.CBs);
      paramVarArgs.aG(3, this.CCn);
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.Ret);
      int i = f.a.a.b.b.a.bA(2, this.CBs);
      int j = f.a.a.b.b.a.q(3, this.CCn);
      AppMethodBeat.o(32561);
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
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dsb localdsb = (dsb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32561);
        return -1;
      case 1: 
        localdsb.Ret = locala.KhF.xS();
        AppMethodBeat.o(32561);
        return 0;
      case 2: 
        localdsb.CBs = locala.KhF.xS();
        AppMethodBeat.o(32561);
        return 0;
      }
      localdsb.CCn = locala.KhF.xT();
      AppMethodBeat.o(32561);
      return 0;
    }
    AppMethodBeat.o(32561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsb
 * JD-Core Version:    0.7.0.1
 */