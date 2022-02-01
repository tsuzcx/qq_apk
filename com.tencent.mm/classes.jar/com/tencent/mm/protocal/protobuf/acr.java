package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acr
  extends com.tencent.mm.bx.a
{
  public String appid;
  public int idx;
  public long nVr;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124473);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.nVr);
      paramVarArgs.bS(2, this.idx);
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.nVr) + 0 + i.a.a.b.b.a.cJ(2, this.idx);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.appid);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.path);
      }
      AppMethodBeat.o(124473);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(124473);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      acr localacr = (acr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124473);
        return -1;
      case 1: 
        localacr.nVr = locala.ajGk.aaw();
        AppMethodBeat.o(124473);
        return 0;
      case 2: 
        localacr.idx = locala.ajGk.aar();
        AppMethodBeat.o(124473);
        return 0;
      case 3: 
        localacr.appid = locala.ajGk.readString();
        AppMethodBeat.o(124473);
        return 0;
      }
      localacr.path = locala.ajGk.readString();
      AppMethodBeat.o(124473);
      return 0;
    }
    AppMethodBeat.o(124473);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */