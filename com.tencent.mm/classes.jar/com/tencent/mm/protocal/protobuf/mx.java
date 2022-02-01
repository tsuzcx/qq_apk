package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mx
  extends com.tencent.mm.bw.a
{
  public int FZd;
  public int FZe;
  public int FZf;
  public String FZg;
  public String FZh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FZd);
      paramVarArgs.aS(2, this.FZe);
      paramVarArgs.aS(3, this.FZf);
      if (this.FZg != null) {
        paramVarArgs.d(4, this.FZg);
      }
      if (this.FZh != null) {
        paramVarArgs.d(5, this.FZh);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FZd) + 0 + f.a.a.b.b.a.bz(2, this.FZe) + f.a.a.b.b.a.bz(3, this.FZf);
      paramInt = i;
      if (this.FZg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FZg);
      }
      i = paramInt;
      if (this.FZh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FZh);
      }
      AppMethodBeat.o(124410);
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
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mx localmx = (mx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localmx.FZd = locala.OmT.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localmx.FZe = locala.OmT.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localmx.FZf = locala.OmT.zc();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localmx.FZg = locala.OmT.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localmx.FZh = locala.OmT.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mx
 * JD-Core Version:    0.7.0.1
 */