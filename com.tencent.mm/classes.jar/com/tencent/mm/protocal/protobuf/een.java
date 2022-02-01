package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class een
  extends com.tencent.mm.bx.a
{
  public float ZaG;
  public float ZaH;
  public int Zyl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259981);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.ZaG);
      paramVarArgs.l(2, this.ZaH);
      paramVarArgs.bS(3, this.Zyl);
      AppMethodBeat.o(259981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.Zyl);
      AppMethodBeat.o(259981);
      return paramInt + 4 + 0 + (i + 4) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259981);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      een localeen = (een)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259981);
        return -1;
      case 1: 
        localeen.ZaG = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259981);
        return 0;
      case 2: 
        localeen.ZaH = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(259981);
        return 0;
      }
      localeen.Zyl = locala.ajGk.aar();
      AppMethodBeat.o(259981);
      return 0;
    }
    AppMethodBeat.o(259981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.een
 * JD-Core Version:    0.7.0.1
 */