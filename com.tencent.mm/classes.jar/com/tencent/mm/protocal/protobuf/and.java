package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class and
  extends com.tencent.mm.bx.a
{
  public boolean Dok;
  public boolean Dol;
  public boolean Dom;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.Dok);
      paramVarArgs.bg(2, this.Dol);
      paramVarArgs.bg(3, this.Dom);
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(116470);
      return paramInt + 1 + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(116470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      and localand = (and)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116470);
        return -1;
      case 1: 
        localand.Dok = locala.KhF.fHu();
        AppMethodBeat.o(116470);
        return 0;
      case 2: 
        localand.Dol = locala.KhF.fHu();
        AppMethodBeat.o(116470);
        return 0;
      }
      localand.Dom = locala.KhF.fHu();
      AppMethodBeat.o(116470);
      return 0;
    }
    AppMethodBeat.o(116470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.and
 * JD-Core Version:    0.7.0.1
 */