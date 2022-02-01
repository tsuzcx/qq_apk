package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xu
  extends com.tencent.mm.bx.a
{
  public boolean gBl;
  public boolean vgr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101527);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.gBl);
      paramVarArgs.bg(2, this.vgr);
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(101527);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(101527);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xu localxu = (xu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(101527);
        return -1;
      case 1: 
        localxu.gBl = locala.KhF.fHu();
        AppMethodBeat.o(101527);
        return 0;
      }
      localxu.vgr = locala.KhF.fHu();
      AppMethodBeat.o(101527);
      return 0;
    }
    AppMethodBeat.o(101527);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xu
 * JD-Core Version:    0.7.0.1
 */