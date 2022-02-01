package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buu
  extends com.tencent.mm.bx.a
{
  public int CLY;
  public int CYi;
  public int DRY;
  public String DRZ;
  public String DSa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32361);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CLY);
      if (this.DSa != null) {
        paramVarArgs.d(3, this.DSa);
      }
      paramVarArgs.aR(4, this.DRY);
      paramVarArgs.aR(5, this.CYi);
      if (this.DRZ != null) {
        paramVarArgs.d(6, this.DRZ);
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CLY) + 0;
      paramInt = i;
      if (this.DSa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DSa);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DRY) + f.a.a.b.b.a.bA(5, this.CYi);
      paramInt = i;
      if (this.DRZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRZ);
      }
      AppMethodBeat.o(32361);
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
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buu localbuu = (buu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(32361);
        return -1;
      case 1: 
        localbuu.CLY = locala.KhF.xS();
        AppMethodBeat.o(32361);
        return 0;
      case 3: 
        localbuu.DSa = locala.KhF.readString();
        AppMethodBeat.o(32361);
        return 0;
      case 4: 
        localbuu.DRY = locala.KhF.xS();
        AppMethodBeat.o(32361);
        return 0;
      case 5: 
        localbuu.CYi = locala.KhF.xS();
        AppMethodBeat.o(32361);
        return 0;
      }
      localbuu.DRZ = locala.KhF.readString();
      AppMethodBeat.o(32361);
      return 0;
    }
    AppMethodBeat.o(32361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buu
 * JD-Core Version:    0.7.0.1
 */