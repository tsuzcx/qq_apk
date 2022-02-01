package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fot
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public double YTc;
  public double YTd;
  public String abeG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, this.YTd);
      paramVarArgs.d(2, this.YTc);
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.abeG != null) {
        paramVarArgs.g(4, this.abeG);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 8 + 0 + (i.a.a.b.b.a.ko(2) + 8);
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IGU);
      }
      i = paramInt;
      if (this.abeG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abeG);
      }
      AppMethodBeat.o(56262);
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
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fot localfot = (fot)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localfot.YTd = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localfot.YTc = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localfot.IGU = locala.ajGk.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localfot.abeG = locala.ajGk.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fot
 * JD-Core Version:    0.7.0.1
 */