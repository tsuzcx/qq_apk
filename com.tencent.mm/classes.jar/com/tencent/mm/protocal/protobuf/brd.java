package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brd
  extends com.tencent.mm.bx.a
{
  public long YZf;
  public long ZZg;
  public int hJr;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257448);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZZg);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bv(3, this.YZf);
      paramVarArgs.bS(4, this.hJr);
      AppMethodBeat.o(257448);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZZg) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = i.a.a.b.b.a.q(3, this.YZf);
      int j = i.a.a.b.b.a.cJ(4, this.hJr);
      AppMethodBeat.o(257448);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257448);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      brd localbrd = (brd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257448);
        return -1;
      case 1: 
        localbrd.ZZg = locala.ajGk.aaw();
        AppMethodBeat.o(257448);
        return 0;
      case 2: 
        localbrd.wording = locala.ajGk.readString();
        AppMethodBeat.o(257448);
        return 0;
      case 3: 
        localbrd.YZf = locala.ajGk.aaw();
        AppMethodBeat.o(257448);
        return 0;
      }
      localbrd.hJr = locala.ajGk.aar();
      AppMethodBeat.o(257448);
      return 0;
    }
    AppMethodBeat.o(257448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brd
 * JD-Core Version:    0.7.0.1
 */