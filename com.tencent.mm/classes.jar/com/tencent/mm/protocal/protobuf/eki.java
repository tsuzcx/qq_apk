package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eki
  extends com.tencent.mm.bw.a
{
  public int Ino;
  public boolean Inp;
  public boolean Inq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ino);
      paramVarArgs.bC(2, this.Inp);
      paramVarArgs.bC(3, this.Inq);
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Ino);
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(123713);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123713);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eki localeki = (eki)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123713);
        return -1;
      case 1: 
        localeki.Ino = locala.OmT.zc();
        AppMethodBeat.o(123713);
        return 0;
      case 2: 
        localeki.Inp = locala.OmT.gvY();
        AppMethodBeat.o(123713);
        return 0;
      }
      localeki.Inq = locala.OmT.gvY();
      AppMethodBeat.o(123713);
      return 0;
    }
    AppMethodBeat.o(123713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eki
 * JD-Core Version:    0.7.0.1
 */