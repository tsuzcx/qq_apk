package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpl
  extends com.tencent.mm.bx.a
{
  public String ntj;
  public String odo;
  public int type;
  public String uoA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.uoA != null) {
        paramVarArgs.d(2, this.uoA);
      }
      if (this.odo != null) {
        paramVarArgs.d(3, this.odo);
      }
      if (this.ntj != null) {
        paramVarArgs.d(4, this.ntj);
      }
      AppMethodBeat.o(191097);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.uoA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uoA);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.odo);
      }
      paramInt = i;
      if (this.ntj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ntj);
      }
      AppMethodBeat.o(191097);
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
      AppMethodBeat.o(191097);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpl localdpl = (dpl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(191097);
        return -1;
      case 1: 
        localdpl.type = locala.KhF.xS();
        AppMethodBeat.o(191097);
        return 0;
      case 2: 
        localdpl.uoA = locala.KhF.readString();
        AppMethodBeat.o(191097);
        return 0;
      case 3: 
        localdpl.odo = locala.KhF.readString();
        AppMethodBeat.o(191097);
        return 0;
      }
      localdpl.ntj = locala.KhF.readString();
      AppMethodBeat.o(191097);
      return 0;
    }
    AppMethodBeat.o(191097);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpl
 * JD-Core Version:    0.7.0.1
 */