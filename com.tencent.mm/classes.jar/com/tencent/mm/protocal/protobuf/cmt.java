package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmt
  extends com.tencent.mm.bw.a
{
  public int GuO;
  public int GuP;
  public String info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125755);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GuO);
      paramVarArgs.aS(2, this.GuP);
      if (this.info != null) {
        paramVarArgs.d(3, this.info);
      }
      AppMethodBeat.o(125755);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GuO) + 0 + f.a.a.b.b.a.bz(2, this.GuP);
      paramInt = i;
      if (this.info != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.info);
      }
      AppMethodBeat.o(125755);
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
      AppMethodBeat.o(125755);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmt localcmt = (cmt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125755);
        return -1;
      case 1: 
        localcmt.GuO = locala.OmT.zc();
        AppMethodBeat.o(125755);
        return 0;
      case 2: 
        localcmt.GuP = locala.OmT.zc();
        AppMethodBeat.o(125755);
        return 0;
      }
      localcmt.info = locala.OmT.readString();
      AppMethodBeat.o(125755);
      return 0;
    }
    AppMethodBeat.o(125755);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmt
 * JD-Core Version:    0.7.0.1
 */