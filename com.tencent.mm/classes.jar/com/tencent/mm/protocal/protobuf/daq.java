package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daq
  extends com.tencent.mm.bx.a
{
  public String ILD;
  public float X;
  public float Y;
  public float aaGi;
  public String aaGj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.X);
      paramVarArgs.l(2, this.Y);
      paramVarArgs.l(3, this.aaGi);
      if (this.ILD != null) {
        paramVarArgs.g(4, this.ILD);
      }
      if (this.aaGj != null) {
        paramVarArgs.g(5, this.aaGj);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4) + (i.a.a.b.b.a.ko(3) + 4);
      paramInt = i;
      if (this.ILD != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILD);
      }
      i = paramInt;
      if (this.aaGj != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaGj);
      }
      AppMethodBeat.o(32326);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      daq localdaq = (daq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localdaq.X = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localdaq.Y = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localdaq.aaGi = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localdaq.ILD = locala.ajGk.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localdaq.aaGj = locala.ajGk.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daq
 * JD-Core Version:    0.7.0.1
 */