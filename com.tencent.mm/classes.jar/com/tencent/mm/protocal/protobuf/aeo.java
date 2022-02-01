package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeo
  extends com.tencent.mm.bx.a
{
  public boolean ZmA;
  public int ZmB;
  public int ZmC;
  public int hUn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257374);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hUn);
      paramVarArgs.di(2, this.ZmA);
      paramVarArgs.bS(3, this.ZmB);
      paramVarArgs.bS(4, this.ZmC);
      AppMethodBeat.o(257374);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.hUn);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.cJ(3, this.ZmB);
      int k = i.a.a.b.b.a.cJ(4, this.ZmC);
      AppMethodBeat.o(257374);
      return paramInt + 0 + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257374);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aeo localaeo = (aeo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257374);
        return -1;
      case 1: 
        localaeo.hUn = locala.ajGk.aar();
        AppMethodBeat.o(257374);
        return 0;
      case 2: 
        localaeo.ZmA = locala.ajGk.aai();
        AppMethodBeat.o(257374);
        return 0;
      case 3: 
        localaeo.ZmB = locala.ajGk.aar();
        AppMethodBeat.o(257374);
        return 0;
      }
      localaeo.ZmC = locala.ajGk.aar();
      AppMethodBeat.o(257374);
      return 0;
    }
    AppMethodBeat.o(257374);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeo
 * JD-Core Version:    0.7.0.1
 */