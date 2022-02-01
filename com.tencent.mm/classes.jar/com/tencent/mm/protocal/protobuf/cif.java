package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cif
  extends com.tencent.mm.bx.a
{
  public int DYb;
  public String EdF;
  public String EdG;
  public int EdH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DYb);
      if (this.EdF != null) {
        paramVarArgs.d(2, this.EdF);
      }
      if (this.EdG != null) {
        paramVarArgs.d(3, this.EdG);
      }
      paramVarArgs.aR(4, this.EdH);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DYb) + 0;
      paramInt = i;
      if (this.EdF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EdF);
      }
      i = paramInt;
      if (this.EdG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EdG);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.EdH);
      AppMethodBeat.o(91667);
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
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cif localcif = (cif)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localcif.DYb = locala.KhF.xS();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localcif.EdF = locala.KhF.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localcif.EdG = locala.KhF.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localcif.EdH = locala.KhF.xS();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cif
 * JD-Core Version:    0.7.0.1
 */