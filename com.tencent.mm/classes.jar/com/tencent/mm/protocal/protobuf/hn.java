package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hn
  extends com.tencent.mm.bw.a
{
  public int Ijz;
  public boolean KLw;
  public String KLx;
  public String dNR;
  public String dNS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.KLw);
      paramVarArgs.aM(2, this.Ijz);
      if (this.dNR != null) {
        paramVarArgs.e(3, this.dNR);
      }
      if (this.dNS != null) {
        paramVarArgs.e(4, this.dNS);
      }
      if (this.KLx != null) {
        paramVarArgs.e(5, this.KLx);
      }
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.bu(2, this.Ijz);
      paramInt = i;
      if (this.dNR != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dNR);
      }
      i = paramInt;
      if (this.dNS != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dNS);
      }
      paramInt = i;
      if (this.KLx != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KLx);
      }
      AppMethodBeat.o(19404);
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
      AppMethodBeat.o(19404);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      hn localhn = (hn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19404);
        return -1;
      case 1: 
        localhn.KLw = locala.UbS.yZ();
        AppMethodBeat.o(19404);
        return 0;
      case 2: 
        localhn.Ijz = locala.UbS.zi();
        AppMethodBeat.o(19404);
        return 0;
      case 3: 
        localhn.dNR = locala.UbS.readString();
        AppMethodBeat.o(19404);
        return 0;
      case 4: 
        localhn.dNS = locala.UbS.readString();
        AppMethodBeat.o(19404);
        return 0;
      }
      localhn.KLx = locala.UbS.readString();
      AppMethodBeat.o(19404);
      return 0;
    }
    AppMethodBeat.o(19404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hn
 * JD-Core Version:    0.7.0.1
 */