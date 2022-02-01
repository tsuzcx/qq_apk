package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buv
  extends com.tencent.mm.bx.a
{
  public int CLY;
  public int CYi;
  public int DRY;
  public String DRZ;
  public String DSb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CLY);
      if (this.DSb != null) {
        paramVarArgs.d(3, this.DSb);
      }
      paramVarArgs.aR(4, this.DRY);
      paramVarArgs.aR(5, this.CYi);
      if (this.DRZ != null) {
        paramVarArgs.d(6, this.DRZ);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CLY) + 0;
      paramInt = i;
      if (this.DSb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DSb);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DRY) + f.a.a.b.b.a.bA(5, this.CYi);
      paramInt = i;
      if (this.DRZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRZ);
      }
      AppMethodBeat.o(43114);
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
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buv localbuv = (buv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localbuv.CLY = locala.KhF.xS();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localbuv.DSb = locala.KhF.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localbuv.DRY = locala.KhF.xS();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localbuv.CYi = locala.KhF.xS();
        AppMethodBeat.o(43114);
        return 0;
      }
      localbuv.DRZ = locala.KhF.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buv
 * JD-Core Version:    0.7.0.1
 */