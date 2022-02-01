package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bra
  extends com.tencent.mm.bx.a
{
  public String ZJK;
  public long ZZb;
  public long ZZc;
  public int ZZd;
  public String ZZe;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257393);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      if (this.ZJK != null) {
        paramVarArgs.g(2, this.ZJK);
      }
      paramVarArgs.bv(3, this.ZZb);
      paramVarArgs.bv(4, this.ZZc);
      paramVarArgs.bS(5, this.ZZd);
      if (this.ZZe != null) {
        paramVarArgs.g(6, this.ZZe);
      }
      AppMethodBeat.o(257393);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.id) + 0;
      paramInt = i;
      if (this.ZJK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZJK);
      }
      i = paramInt + i.a.a.b.b.a.q(3, this.ZZb) + i.a.a.b.b.a.q(4, this.ZZc) + i.a.a.b.b.a.cJ(5, this.ZZd);
      paramInt = i;
      if (this.ZZe != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZZe);
      }
      AppMethodBeat.o(257393);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257393);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bra localbra = (bra)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257393);
        return -1;
      case 1: 
        localbra.id = locala.ajGk.aaw();
        AppMethodBeat.o(257393);
        return 0;
      case 2: 
        localbra.ZJK = locala.ajGk.readString();
        AppMethodBeat.o(257393);
        return 0;
      case 3: 
        localbra.ZZb = locala.ajGk.aaw();
        AppMethodBeat.o(257393);
        return 0;
      case 4: 
        localbra.ZZc = locala.ajGk.aaw();
        AppMethodBeat.o(257393);
        return 0;
      case 5: 
        localbra.ZZd = locala.ajGk.aar();
        AppMethodBeat.o(257393);
        return 0;
      }
      localbra.ZZe = locala.ajGk.readString();
      AppMethodBeat.o(257393);
      return 0;
    }
    AppMethodBeat.o(257393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bra
 * JD-Core Version:    0.7.0.1
 */