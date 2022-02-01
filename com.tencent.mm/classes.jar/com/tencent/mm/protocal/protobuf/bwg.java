package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwg
  extends com.tencent.mm.bw.a
{
  public int GZl;
  public int Gdm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gdm);
      paramVarArgs.aS(2, this.GZl);
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gdm);
      int i = f.a.a.b.b.a.bz(2, this.GZl);
      AppMethodBeat.o(175246);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(175246);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bwg localbwg = (bwg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(175246);
        return -1;
      case 1: 
        localbwg.Gdm = locala.OmT.zc();
        AppMethodBeat.o(175246);
        return 0;
      }
      localbwg.GZl = locala.OmT.zc();
      AppMethodBeat.o(175246);
      return 0;
    }
    AppMethodBeat.o(175246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwg
 * JD-Core Version:    0.7.0.1
 */