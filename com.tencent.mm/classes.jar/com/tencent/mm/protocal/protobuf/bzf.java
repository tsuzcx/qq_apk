package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzf
  extends com.tencent.mm.bw.a
{
  public String FQl;
  public int HgC;
  public int Hmg;
  public int ucK;
  public int udg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ucK);
      paramVarArgs.aS(2, this.udg);
      paramVarArgs.aS(3, this.Hmg);
      if (this.FQl != null) {
        paramVarArgs.d(4, this.FQl);
      }
      paramVarArgs.aS(5, this.HgC);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ucK) + 0 + f.a.a.b.b.a.bz(2, this.udg) + f.a.a.b.b.a.bz(3, this.Hmg);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FQl);
      }
      i = f.a.a.b.b.a.bz(5, this.HgC);
      AppMethodBeat.o(125742);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzf localbzf = (bzf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localbzf.ucK = locala.OmT.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localbzf.udg = locala.OmT.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localbzf.Hmg = locala.OmT.zc();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localbzf.FQl = locala.OmT.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localbzf.HgC = locala.OmT.zc();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzf
 * JD-Core Version:    0.7.0.1
 */