package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vh
  extends com.tencent.mm.bw.a
{
  public int LfB;
  public int LfC;
  public int jlJ;
  public String qHk;
  public int tag;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196378);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.tag);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aM(3, this.LfB);
      if (this.qHk != null) {
        paramVarArgs.e(4, this.qHk);
      }
      paramVarArgs.aM(5, this.jlJ);
      paramVarArgs.aM(6, this.LfC);
      AppMethodBeat.o(196378);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.tag) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.LfB);
      paramInt = i;
      if (this.qHk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qHk);
      }
      i = g.a.a.b.b.a.bu(5, this.jlJ);
      int j = g.a.a.b.b.a.bu(6, this.LfC);
      AppMethodBeat.o(196378);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(196378);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      vh localvh = (vh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(196378);
        return -1;
      case 1: 
        localvh.tag = locala.UbS.zi();
        AppMethodBeat.o(196378);
        return 0;
      case 2: 
        localvh.url = locala.UbS.readString();
        AppMethodBeat.o(196378);
        return 0;
      case 3: 
        localvh.LfB = locala.UbS.zi();
        AppMethodBeat.o(196378);
        return 0;
      case 4: 
        localvh.qHk = locala.UbS.readString();
        AppMethodBeat.o(196378);
        return 0;
      case 5: 
        localvh.jlJ = locala.UbS.zi();
        AppMethodBeat.o(196378);
        return 0;
      }
      localvh.LfC = locala.UbS.zi();
      AppMethodBeat.o(196378);
      return 0;
    }
    AppMethodBeat.o(196378);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vh
 * JD-Core Version:    0.7.0.1
 */