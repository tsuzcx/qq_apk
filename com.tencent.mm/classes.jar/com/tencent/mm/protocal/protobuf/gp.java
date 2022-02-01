package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gp
  extends com.tencent.mm.bx.a
{
  public int ApX;
  public String CBA;
  public boolean CBz;
  public String dlK;
  public String dlL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.CBz);
      paramVarArgs.aR(2, this.ApX);
      if (this.dlK != null) {
        paramVarArgs.d(3, this.dlK);
      }
      if (this.dlL != null) {
        paramVarArgs.d(4, this.dlL);
      }
      if (this.CBA != null) {
        paramVarArgs.d(5, this.CBA);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0 + f.a.a.b.b.a.bA(2, this.ApX);
      paramInt = i;
      if (this.dlK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlK);
      }
      i = paramInt;
      if (this.dlL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dlL);
      }
      paramInt = i;
      if (this.CBA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CBA);
      }
      AppMethodBeat.o(19404);
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
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gp localgp = (gp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localgp.CBz = locala.KhF.fHu();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localgp.ApX = locala.KhF.xS();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localgp.dlK = locala.KhF.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localgp.dlL = locala.KhF.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localgp.CBA = locala.KhF.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */