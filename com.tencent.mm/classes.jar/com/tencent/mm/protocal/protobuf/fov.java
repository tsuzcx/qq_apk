package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fov
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public long IcI;
  public String YKw;
  public int abPb;
  public int abPc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abPb);
      if (this.YKw != null) {
        paramVarArgs.g(2, this.YKw);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(3, this.AesKey);
      }
      paramVarArgs.bS(4, this.abPc);
      paramVarArgs.bv(5, this.IcI);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abPb) + 0;
      paramInt = i;
      if (this.YKw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YKw);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.AesKey);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.abPc);
      int j = i.a.a.b.b.a.q(5, this.IcI);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fov localfov = (fov)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localfov.abPb = locala.ajGk.aar();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localfov.YKw = locala.ajGk.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localfov.AesKey = locala.ajGk.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localfov.abPc = locala.ajGk.aar();
        AppMethodBeat.o(127506);
        return 0;
      }
      localfov.IcI = locala.ajGk.aaw();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fov
 * JD-Core Version:    0.7.0.1
 */