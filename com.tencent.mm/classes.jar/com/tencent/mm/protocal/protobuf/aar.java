package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aar
  extends com.tencent.mm.cd.a
{
  public String appid;
  public int idx;
  public long lqo;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.lqo);
      paramVarArgs.aY(2, this.idx);
      if (this.appid != null) {
        paramVarArgs.f(3, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.f(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.lqo) + 0 + g.a.a.b.b.a.bM(2, this.idx);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.appid);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.path);
      }
      AppMethodBeat.o(124473);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aar localaar = (aar)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localaar.lqo = locala.abFh.AN();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localaar.idx = locala.abFh.AK();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localaar.appid = locala.abFh.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localaar.path = locala.abFh.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aar
 * JD-Core Version:    0.7.0.1
 */