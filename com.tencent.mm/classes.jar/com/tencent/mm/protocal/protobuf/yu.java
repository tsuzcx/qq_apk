package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yu
  extends com.tencent.mm.bx.a
{
  public String duW;
  public long hDP;
  public int idx;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.hDP);
      paramVarArgs.aS(2, this.idx);
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.hDP) + 0 + f.a.a.b.b.a.bz(2, this.idx);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.duW);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.path);
      }
      AppMethodBeat.o(124473);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yu localyu = (yu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localyu.hDP = locala.NPN.zd();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localyu.idx = locala.NPN.zc();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localyu.duW = locala.NPN.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localyu.path = locala.NPN.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yu
 * JD-Core Version:    0.7.0.1
 */