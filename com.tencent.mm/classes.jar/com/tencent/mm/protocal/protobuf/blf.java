package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blf
  extends com.tencent.mm.bx.a
{
  public int ZGN;
  public boolean ZUj;
  public int ZUk;
  public long ZUl;
  public int ZUm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259268);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZGN);
      paramVarArgs.di(2, this.ZUj);
      paramVarArgs.bS(3, this.ZUk);
      paramVarArgs.bv(4, this.ZUl);
      paramVarArgs.bS(5, this.ZUm);
      AppMethodBeat.o(259268);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZGN);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.ZUk);
      int k = i.a.a.b.b.a.q(4, this.ZUl);
      int m = i.a.a.b.b.a.cJ(5, this.ZUm);
      AppMethodBeat.o(259268);
      return paramInt + 0 + (i + 1) + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259268);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      blf localblf = (blf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259268);
        return -1;
      case 1: 
        localblf.ZGN = locala.ajGk.aar();
        AppMethodBeat.o(259268);
        return 0;
      case 2: 
        localblf.ZUj = locala.ajGk.aai();
        AppMethodBeat.o(259268);
        return 0;
      case 3: 
        localblf.ZUk = locala.ajGk.aar();
        AppMethodBeat.o(259268);
        return 0;
      case 4: 
        localblf.ZUl = locala.ajGk.aaw();
        AppMethodBeat.o(259268);
        return 0;
      }
      localblf.ZUm = locala.ajGk.aar();
      AppMethodBeat.o(259268);
      return 0;
    }
    AppMethodBeat.o(259268);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blf
 * JD-Core Version:    0.7.0.1
 */