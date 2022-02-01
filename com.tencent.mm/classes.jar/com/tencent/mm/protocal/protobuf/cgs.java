package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgs
  extends com.tencent.mm.bw.a
{
  public int FOX;
  public String uqs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125753);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FOX);
      if (this.uqs != null) {
        paramVarArgs.d(2, this.uqs);
      }
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FOX) + 0;
      paramInt = i;
      if (this.uqs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqs);
      }
      AppMethodBeat.o(125753);
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
      AppMethodBeat.o(125753);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgs localcgs = (cgs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125753);
        return -1;
      case 1: 
        localcgs.FOX = locala.OmT.zc();
        AppMethodBeat.o(125753);
        return 0;
      }
      localcgs.uqs = locala.OmT.readString();
      AppMethodBeat.o(125753);
      return 0;
    }
    AppMethodBeat.o(125753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */