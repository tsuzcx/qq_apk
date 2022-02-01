package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsz
  extends com.tencent.mm.bx.a
{
  public int FJz;
  public int GNq;
  public String GNr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GNq);
      if (this.GNr != null) {
        paramVarArgs.d(2, this.GNr);
      }
      paramVarArgs.aS(3, this.FJz);
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GNq) + 0;
      paramInt = i;
      if (this.GNr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNr);
      }
      i = f.a.a.b.b.a.bz(3, this.FJz);
      AppMethodBeat.o(146308);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsz localbsz = (bsz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(146308);
        return -1;
      case 1: 
        localbsz.GNq = locala.NPN.zc();
        AppMethodBeat.o(146308);
        return 0;
      case 2: 
        localbsz.GNr = locala.NPN.readString();
        AppMethodBeat.o(146308);
        return 0;
      }
      localbsz.FJz = locala.NPN.zc();
      AppMethodBeat.o(146308);
      return 0;
    }
    AppMethodBeat.o(146308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsz
 * JD-Core Version:    0.7.0.1
 */