package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apo
  extends com.tencent.mm.bw.a
{
  public String LBw;
  public long commentId;
  public long hFK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209355);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hFK);
      paramVarArgs.bb(2, this.commentId);
      if (this.LBw != null) {
        paramVarArgs.e(3, this.LBw);
      }
      AppMethodBeat.o(209355);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.hFK) + 0 + g.a.a.b.b.a.r(2, this.commentId);
      paramInt = i;
      if (this.LBw != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LBw);
      }
      AppMethodBeat.o(209355);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209355);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apo localapo = (apo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209355);
        return -1;
      case 1: 
        localapo.hFK = locala.UbS.zl();
        AppMethodBeat.o(209355);
        return 0;
      case 2: 
        localapo.commentId = locala.UbS.zl();
        AppMethodBeat.o(209355);
        return 0;
      }
      localapo.LBw = locala.UbS.readString();
      AppMethodBeat.o(209355);
      return 0;
    }
    AppMethodBeat.o(209355);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */