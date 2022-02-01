package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yx
  extends com.tencent.mm.bw.a
{
  public String dwb;
  public long hGH;
  public int idx;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.hGH);
      paramVarArgs.aS(2, this.idx);
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.hGH) + 0 + f.a.a.b.b.a.bz(2, this.idx);
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dwb);
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
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yx localyx = (yx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localyx.hGH = locala.OmT.zd();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localyx.idx = locala.OmT.zc();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localyx.dwb = locala.OmT.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localyx.path = locala.OmT.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yx
 * JD-Core Version:    0.7.0.1
 */