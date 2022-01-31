package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dat
  extends com.tencent.mm.bv.a
{
  public String nickname;
  public String oiD;
  public int wyt;
  public boolean yhc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115012);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wyt);
      if (this.oiD != null) {
        paramVarArgs.e(2, this.oiD);
      }
      if (this.nickname != null) {
        paramVarArgs.e(3, this.nickname);
      }
      paramVarArgs.aS(4, this.yhc);
      AppMethodBeat.o(115012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wyt) + 0;
      paramInt = i;
      if (this.oiD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.oiD);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nickname);
      }
      paramInt = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(115012);
      return i + (paramInt + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(115012);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dat localdat = (dat)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115012);
        return -1;
      case 1: 
        localdat.wyt = locala.CLY.sl();
        AppMethodBeat.o(115012);
        return 0;
      case 2: 
        localdat.oiD = locala.CLY.readString();
        AppMethodBeat.o(115012);
        return 0;
      case 3: 
        localdat.nickname = locala.CLY.readString();
        AppMethodBeat.o(115012);
        return 0;
      }
      localdat.yhc = locala.CLY.emu();
      AppMethodBeat.o(115012);
      return 0;
    }
    AppMethodBeat.o(115012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dat
 * JD-Core Version:    0.7.0.1
 */