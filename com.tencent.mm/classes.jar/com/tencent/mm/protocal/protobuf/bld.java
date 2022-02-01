package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bld
  extends com.tencent.mm.bx.a
{
  public float COI;
  public float COJ;
  public int DfE;
  public String DfF;
  public String DfG;
  public int DfH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.COI);
      paramVarArgs.x(2, this.COJ);
      paramVarArgs.aR(3, this.DfE);
      if (this.DfF != null) {
        paramVarArgs.d(4, this.DfF);
      }
      if (this.DfG != null) {
        paramVarArgs.d(5, this.DfG);
      }
      paramVarArgs.aR(6, this.DfH);
      AppMethodBeat.o(152619);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 4 + 0 + (f.a.a.b.b.a.fY(2) + 4) + f.a.a.b.b.a.bA(3, this.DfE);
      paramInt = i;
      if (this.DfF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DfF);
      }
      i = paramInt;
      if (this.DfG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DfG);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.DfH);
      AppMethodBeat.o(152619);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152619);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bld localbld = (bld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152619);
        return -1;
      case 1: 
        localbld.COI = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(152619);
        return 0;
      case 2: 
        localbld.COJ = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(152619);
        return 0;
      case 3: 
        localbld.DfE = locala.KhF.xS();
        AppMethodBeat.o(152619);
        return 0;
      case 4: 
        localbld.DfF = locala.KhF.readString();
        AppMethodBeat.o(152619);
        return 0;
      case 5: 
        localbld.DfG = locala.KhF.readString();
        AppMethodBeat.o(152619);
        return 0;
      }
      localbld.DfH = locala.KhF.xS();
      AppMethodBeat.o(152619);
      return 0;
    }
    AppMethodBeat.o(152619);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bld
 * JD-Core Version:    0.7.0.1
 */