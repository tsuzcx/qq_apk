package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bgz
  extends com.tencent.mm.bx.a
{
  public b ZQv;
  public int ZQw;
  public boolean ZQx;
  public int visibility;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.visibility);
      if (this.ZQv != null) {
        paramVarArgs.d(2, this.ZQv);
      }
      paramVarArgs.bS(3, this.ZQw);
      paramVarArgs.di(4, this.ZQx);
      AppMethodBeat.o(257829);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.visibility) + 0;
      paramInt = i;
      if (this.ZQv != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZQv);
      }
      i = i.a.a.b.b.a.cJ(3, this.ZQw);
      int j = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(257829);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257829);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bgz localbgz = (bgz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257829);
        return -1;
      case 1: 
        localbgz.visibility = locala.ajGk.aar();
        AppMethodBeat.o(257829);
        return 0;
      case 2: 
        localbgz.ZQv = locala.ajGk.kFX();
        AppMethodBeat.o(257829);
        return 0;
      case 3: 
        localbgz.ZQw = locala.ajGk.aar();
        AppMethodBeat.o(257829);
        return 0;
      }
      localbgz.ZQx = locala.ajGk.aai();
      AppMethodBeat.o(257829);
      return 0;
    }
    AppMethodBeat.o(257829);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgz
 * JD-Core Version:    0.7.0.1
 */