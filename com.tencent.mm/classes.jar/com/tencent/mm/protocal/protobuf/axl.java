package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class axl
  extends com.tencent.mm.bw.a
{
  public b LHW;
  public String LHX;
  public int infoType;
  public int jlm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.infoType);
      if (this.LHW != null) {
        paramVarArgs.c(2, this.LHW);
      }
      if (this.LHX != null) {
        paramVarArgs.e(3, this.LHX);
      }
      paramVarArgs.aM(4, this.jlm);
      AppMethodBeat.o(209565);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.infoType) + 0;
      paramInt = i;
      if (this.LHW != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.LHW);
      }
      i = paramInt;
      if (this.LHX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LHX);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.jlm);
      AppMethodBeat.o(209565);
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
      AppMethodBeat.o(209565);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      axl localaxl = (axl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209565);
        return -1;
      case 1: 
        localaxl.infoType = locala.UbS.zi();
        AppMethodBeat.o(209565);
        return 0;
      case 2: 
        localaxl.LHW = locala.UbS.hPo();
        AppMethodBeat.o(209565);
        return 0;
      case 3: 
        localaxl.LHX = locala.UbS.readString();
        AppMethodBeat.o(209565);
        return 0;
      }
      localaxl.jlm = locala.UbS.zi();
      AppMethodBeat.o(209565);
      return 0;
    }
    AppMethodBeat.o(209565);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axl
 * JD-Core Version:    0.7.0.1
 */