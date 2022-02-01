package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bso
  extends com.tencent.mm.bx.a
{
  public int DPI;
  public String DPJ;
  public int DPK;
  public String DPL;
  public String DvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DvP != null) {
        paramVarArgs.d(1, this.DvP);
      }
      paramVarArgs.aR(2, this.DPI);
      if (this.DPJ != null) {
        paramVarArgs.d(3, this.DPJ);
      }
      paramVarArgs.aR(4, this.DPK);
      if (this.DPL != null) {
        paramVarArgs.d(5, this.DPL);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DvP == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.DvP) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DPI);
      paramInt = i;
      if (this.DPJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DPJ);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.DPK);
      paramInt = i;
      if (this.DPL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DPL);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bso localbso = (bso)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localbso.DvP = locala.KhF.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localbso.DPI = locala.KhF.xS();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localbso.DPJ = locala.KhF.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localbso.DPK = locala.KhF.xS();
          AppMethodBeat.o(115847);
          return 0;
        }
        localbso.DPL = locala.KhF.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bso
 * JD-Core Version:    0.7.0.1
 */