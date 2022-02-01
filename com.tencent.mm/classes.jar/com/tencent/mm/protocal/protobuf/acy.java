package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acy
  extends com.tencent.mm.bx.a
{
  public long ZlA;
  public long Zlx;
  public String Zly;
  public int Zlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257945);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Zlx);
      if (this.Zly != null) {
        paramVarArgs.g(2, this.Zly);
      }
      paramVarArgs.bS(3, this.Zlz);
      paramVarArgs.bv(4, this.ZlA);
      AppMethodBeat.o(257945);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Zlx) + 0;
      paramInt = i;
      if (this.Zly != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zly);
      }
      i = i.a.a.b.b.a.cJ(3, this.Zlz);
      int j = i.a.a.b.b.a.q(4, this.ZlA);
      AppMethodBeat.o(257945);
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
      AppMethodBeat.o(257945);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      acy localacy = (acy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257945);
        return -1;
      case 1: 
        localacy.Zlx = locala.ajGk.aaw();
        AppMethodBeat.o(257945);
        return 0;
      case 2: 
        localacy.Zly = locala.ajGk.readString();
        AppMethodBeat.o(257945);
        return 0;
      case 3: 
        localacy.Zlz = locala.ajGk.aar();
        AppMethodBeat.o(257945);
        return 0;
      }
      localacy.ZlA = locala.ajGk.aaw();
      AppMethodBeat.o(257945);
      return 0;
    }
    AppMethodBeat.o(257945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acy
 * JD-Core Version:    0.7.0.1
 */