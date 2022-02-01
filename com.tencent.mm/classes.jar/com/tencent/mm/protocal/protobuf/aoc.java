package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoc
  extends com.tencent.mm.bx.a
{
  public String OcA;
  public int OcB;
  public int Ocy;
  public String Ocz;
  public String nRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Ocy);
      if (this.Ocz != null) {
        paramVarArgs.g(2, this.Ocz);
      }
      if (this.OcA != null) {
        paramVarArgs.g(3, this.OcA);
      }
      paramVarArgs.bS(4, this.OcB);
      if (this.nRQ != null) {
        paramVarArgs.g(5, this.nRQ);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Ocy) + 0;
      paramInt = i;
      if (this.Ocz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Ocz);
      }
      i = paramInt;
      if (this.OcA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.OcA);
      }
      i += i.a.a.b.b.a.cJ(4, this.OcB);
      paramInt = i;
      if (this.nRQ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nRQ);
      }
      AppMethodBeat.o(72474);
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
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aoc localaoc = (aoc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localaoc.Ocy = locala.ajGk.aar();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localaoc.Ocz = locala.ajGk.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localaoc.OcA = locala.ajGk.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localaoc.OcB = locala.ajGk.aar();
        AppMethodBeat.o(72474);
        return 0;
      }
      localaoc.nRQ = locala.ajGk.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoc
 * JD-Core Version:    0.7.0.1
 */