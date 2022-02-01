package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coc
  extends com.tencent.mm.bw.a
{
  public int HzX;
  public int HzY;
  public int HzZ;
  public int qkQ;
  public String qkR;
  public int uXl;
  public String uXm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HzY);
      paramVarArgs.aS(2, this.HzZ);
      paramVarArgs.aS(3, this.HzX);
      paramVarArgs.aS(4, this.qkQ);
      if (this.qkR != null) {
        paramVarArgs.d(5, this.qkR);
      }
      paramVarArgs.aS(6, this.uXl);
      if (this.uXm != null) {
        paramVarArgs.d(7, this.uXm);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HzY) + 0 + f.a.a.b.b.a.bz(2, this.HzZ) + f.a.a.b.b.a.bz(3, this.HzX) + f.a.a.b.b.a.bz(4, this.qkQ);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qkR);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.uXl);
      paramInt = i;
      if (this.uXm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uXm);
      }
      AppMethodBeat.o(32392);
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
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      coc localcoc = (coc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localcoc.HzY = locala.OmT.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localcoc.HzZ = locala.OmT.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localcoc.HzX = locala.OmT.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localcoc.qkQ = locala.OmT.zc();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localcoc.qkR = locala.OmT.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localcoc.uXl = locala.OmT.zc();
        AppMethodBeat.o(32392);
        return 0;
      }
      localcoc.uXm = locala.OmT.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */