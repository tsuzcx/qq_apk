package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgw
  extends com.tencent.mm.bw.a
{
  public String Bri;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      if (this.Bri != null) {
        paramVarArgs.e(2, this.Bri);
      }
      AppMethodBeat.o(256597);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.Bri != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Bri);
      }
      AppMethodBeat.o(256597);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256597);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bgw localbgw = (bgw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(256597);
        return -1;
      case 1: 
        localbgw.oUv = locala.UbS.zi();
        AppMethodBeat.o(256597);
        return 0;
      }
      localbgw.Bri = locala.UbS.readString();
      AppMethodBeat.o(256597);
      return 0;
    }
    AppMethodBeat.o(256597);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgw
 * JD-Core Version:    0.7.0.1
 */