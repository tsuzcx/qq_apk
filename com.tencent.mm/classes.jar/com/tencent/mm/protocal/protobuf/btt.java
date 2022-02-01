package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btt
  extends com.tencent.mm.bw.a
{
  public int GbY;
  public int HgQ;
  public String HgR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HgQ);
      if (this.HgR != null) {
        paramVarArgs.d(2, this.HgR);
      }
      paramVarArgs.aS(3, this.GbY);
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HgQ) + 0;
      paramInt = i;
      if (this.HgR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HgR);
      }
      i = f.a.a.b.b.a.bz(3, this.GbY);
      AppMethodBeat.o(146308);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btt localbtt = (btt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(146308);
        return -1;
      case 1: 
        localbtt.HgQ = locala.OmT.zc();
        AppMethodBeat.o(146308);
        return 0;
      case 2: 
        localbtt.HgR = locala.OmT.readString();
        AppMethodBeat.o(146308);
        return 0;
      }
      localbtt.GbY = locala.OmT.zc();
      AppMethodBeat.o(146308);
      return 0;
    }
    AppMethodBeat.o(146308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btt
 * JD-Core Version:    0.7.0.1
 */