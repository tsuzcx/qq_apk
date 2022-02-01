package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kl
  extends com.tencent.mm.bx.a
{
  public long CFn;
  public String CFo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110891);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CFn);
      if (this.CFo != null) {
        paramVarArgs.d(2, this.CFo);
      }
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.CFn) + 0;
      paramInt = i;
      if (this.CFo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CFo);
      }
      AppMethodBeat.o(110891);
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
      AppMethodBeat.o(110891);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      kl localkl = (kl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110891);
        return -1;
      case 1: 
        localkl.CFn = locala.KhF.xT();
        AppMethodBeat.o(110891);
        return 0;
      }
      localkl.CFo = locala.KhF.readString();
      AppMethodBeat.o(110891);
      return 0;
    }
    AppMethodBeat.o(110891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kl
 * JD-Core Version:    0.7.0.1
 */