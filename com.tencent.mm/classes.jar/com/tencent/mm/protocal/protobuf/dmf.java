package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmf
  extends com.tencent.mm.bw.a
{
  public int HTD;
  public String HTE;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.HTD);
      if (this.HTE != null) {
        paramVarArgs.d(4, this.HTE);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(2, this.nJA) + 0 + f.a.a.b.b.a.bz(3, this.HTD);
      paramInt = i;
      if (this.HTE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HTE);
      }
      AppMethodBeat.o(153305);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmf localdmf = (dmf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localdmf.nJA = locala.OmT.zc();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localdmf.HTD = locala.OmT.zc();
        AppMethodBeat.o(153305);
        return 0;
      }
      localdmf.HTE = locala.OmT.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmf
 * JD-Core Version:    0.7.0.1
 */