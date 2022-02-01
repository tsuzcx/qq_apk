package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzs
  extends com.tencent.mm.bx.a
{
  public int DWu;
  public String DWv;
  public String gKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DWu);
      if (this.DWv != null) {
        paramVarArgs.d(2, this.DWv);
      }
      if (this.gKm != null) {
        paramVarArgs.d(3, this.gKm);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DWu) + 0;
      paramInt = i;
      if (this.DWv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWv);
      }
      i = paramInt;
      if (this.gKm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKm);
      }
      AppMethodBeat.o(124538);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzs localbzs = (bzs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localbzs.DWu = locala.KhF.xS();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localbzs.DWv = locala.KhF.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localbzs.gKm = locala.KhF.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */