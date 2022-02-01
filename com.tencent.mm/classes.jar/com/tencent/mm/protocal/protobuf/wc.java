package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wc
  extends com.tencent.mm.bw.a
{
  public int KWR;
  public String Lhr;
  public String eaO;
  public int pSb;
  public String pWh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113981);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      if (this.pWh != null) {
        paramVarArgs.e(2, this.pWh);
      }
      paramVarArgs.aM(3, this.pSb);
      paramVarArgs.aM(4, this.KWR);
      if (this.Lhr != null) {
        paramVarArgs.e(5, this.Lhr);
      }
      AppMethodBeat.o(113981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.b.b.a.f(1, this.eaO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pWh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pWh);
      }
      i = i + g.a.a.b.b.a.bu(3, this.pSb) + g.a.a.b.b.a.bu(4, this.KWR);
      paramInt = i;
      if (this.Lhr != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lhr);
      }
      AppMethodBeat.o(113981);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113981);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        wc localwc = (wc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113981);
          return -1;
        case 1: 
          localwc.eaO = locala.UbS.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 2: 
          localwc.pWh = locala.UbS.readString();
          AppMethodBeat.o(113981);
          return 0;
        case 3: 
          localwc.pSb = locala.UbS.zi();
          AppMethodBeat.o(113981);
          return 0;
        case 4: 
          localwc.KWR = locala.UbS.zi();
          AppMethodBeat.o(113981);
          return 0;
        }
        localwc.Lhr = locala.UbS.readString();
        AppMethodBeat.o(113981);
        return 0;
      }
      AppMethodBeat.o(113981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wc
 * JD-Core Version:    0.7.0.1
 */