package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aco
  extends com.tencent.mm.bx.a
{
  public boolean DcV;
  public boolean DcW;
  public String DcX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.DcV);
      paramVarArgs.bg(2, this.DcW);
      if (this.DcX != null) {
        paramVarArgs.d(3, this.DcX);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0 + (f.a.a.b.b.a.fY(2) + 1);
      paramInt = i;
      if (this.DcX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DcX);
      }
      AppMethodBeat.o(113998);
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
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aco localaco = (aco)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localaco.DcV = locala.KhF.fHu();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localaco.DcW = locala.KhF.fHu();
        AppMethodBeat.o(113998);
        return 0;
      }
      localaco.DcX = locala.KhF.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aco
 * JD-Core Version:    0.7.0.1
 */