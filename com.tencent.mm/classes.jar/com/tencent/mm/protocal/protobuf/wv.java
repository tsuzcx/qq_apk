package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wv
  extends com.tencent.mm.bw.a
{
  public String djj;
  public long hlF;
  public int idx;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.hlF);
      paramVarArgs.aR(2, this.idx);
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.hlF) + 0 + f.a.a.b.b.a.bx(2, this.idx);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.djj);
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
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      wv localwv = (wv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localwv.hlF = locala.LVo.xG();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localwv.idx = locala.LVo.xF();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localwv.djj = locala.LVo.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localwv.path = locala.LVo.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wv
 * JD-Core Version:    0.7.0.1
 */