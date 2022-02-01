package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmj
  extends com.tencent.mm.bw.a
{
  public int Hyq;
  public int Hyr;
  public String Hys;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hyq);
      paramVarArgs.aS(2, this.Hyr);
      if (this.Hys != null) {
        paramVarArgs.d(3, this.Hys);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hyq) + 0 + f.a.a.b.b.a.bz(2, this.Hyr);
      paramInt = i;
      if (this.Hys != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hys);
      }
      AppMethodBeat.o(125754);
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
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmj localcmj = (cmj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localcmj.Hyq = locala.OmT.zc();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localcmj.Hyr = locala.OmT.zc();
        AppMethodBeat.o(125754);
        return 0;
      }
      localcmj.Hys = locala.OmT.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmj
 * JD-Core Version:    0.7.0.1
 */