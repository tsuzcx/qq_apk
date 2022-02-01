package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfq
  extends com.tencent.mm.bw.a
{
  public int LPh = 7;
  public long LPi = 0L;
  public int LPj = 0;
  public String LPk = "";
  public boolean LPl = false;
  public int aHK = 0;
  public int jlm = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LPh);
      paramVarArgs.bb(2, this.LPi);
      paramVarArgs.aM(3, this.LPj);
      if (this.LPk != null) {
        paramVarArgs.e(4, this.LPk);
      }
      paramVarArgs.aM(5, this.aHK);
      paramVarArgs.aM(6, this.jlm);
      paramVarArgs.cc(7, this.LPl);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.LPh) + 0 + g.a.a.b.b.a.r(2, this.LPi) + g.a.a.b.b.a.bu(3, this.LPj);
      paramInt = i;
      if (this.LPk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LPk);
      }
      i = g.a.a.b.b.a.bu(5, this.aHK);
      int j = g.a.a.b.b.a.bu(6, this.jlm);
      int k = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(122494);
      return paramInt + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfq localbfq = (bfq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localbfq.LPh = locala.UbS.zi();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localbfq.LPi = locala.UbS.zl();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localbfq.LPj = locala.UbS.zi();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localbfq.LPk = locala.UbS.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localbfq.aHK = locala.UbS.zi();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localbfq.jlm = locala.UbS.zi();
        AppMethodBeat.o(122494);
        return 0;
      }
      localbfq.LPl = locala.UbS.yZ();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfq
 * JD-Core Version:    0.7.0.1
 */