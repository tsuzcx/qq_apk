package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctf
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public long Brn;
  public int xKb;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNH != null) {
        paramVarArgs.e(1, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(2, this.xNG);
      }
      paramVarArgs.aM(3, this.Brl);
      paramVarArgs.aM(4, this.xKb);
      paramVarArgs.bb(5, this.Brn);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNH == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xNG);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Brl);
      int j = g.a.a.b.b.a.bu(4, this.xKb);
      int k = g.a.a.b.b.a.r(5, this.Brn);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctf localctf = (ctf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localctf.xNH = locala.UbS.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localctf.xNG = locala.UbS.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localctf.Brl = locala.UbS.zi();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localctf.xKb = locala.UbS.zi();
          AppMethodBeat.o(43113);
          return 0;
        }
        localctf.Brn = locala.UbS.zl();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctf
 * JD-Core Version:    0.7.0.1
 */