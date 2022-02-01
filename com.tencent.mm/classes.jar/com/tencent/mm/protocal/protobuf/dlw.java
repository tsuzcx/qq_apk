package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlw
  extends com.tencent.mm.bw.a
{
  public int MJg;
  public String MPA;
  public int MPB;
  public String MPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91667);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MJg);
      if (this.MPz != null) {
        paramVarArgs.e(2, this.MPz);
      }
      if (this.MPA != null) {
        paramVarArgs.e(3, this.MPA);
      }
      paramVarArgs.aM(4, this.MPB);
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MJg) + 0;
      paramInt = i;
      if (this.MPz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MPz);
      }
      i = paramInt;
      if (this.MPA != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MPA);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MPB);
      AppMethodBeat.o(91667);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91667);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dlw localdlw = (dlw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91667);
        return -1;
      case 1: 
        localdlw.MJg = locala.UbS.zi();
        AppMethodBeat.o(91667);
        return 0;
      case 2: 
        localdlw.MPz = locala.UbS.readString();
        AppMethodBeat.o(91667);
        return 0;
      case 3: 
        localdlw.MPA = locala.UbS.readString();
        AppMethodBeat.o(91667);
        return 0;
      }
      localdlw.MPB = locala.UbS.zi();
      AppMethodBeat.o(91667);
      return 0;
    }
    AppMethodBeat.o(91667);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlw
 * JD-Core Version:    0.7.0.1
 */