package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxh
  extends com.tencent.mm.bw.a
{
  public int MBP;
  public int MBQ;
  public String eaO;
  public String pTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      if (this.pTM != null) {
        paramVarArgs.e(2, this.pTM);
      }
      paramVarArgs.aM(3, this.MBP);
      paramVarArgs.aM(4, this.MBQ);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.eaO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pTM != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pTM);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MBP);
      int j = g.a.a.b.b.a.bu(4, this.MBQ);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxh localcxh = (cxh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localcxh.eaO = locala.UbS.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localcxh.pTM = locala.UbS.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localcxh.MBP = locala.UbS.zi();
          AppMethodBeat.o(114046);
          return 0;
        }
        localcxh.MBQ = locala.UbS.zi();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxh
 * JD-Core Version:    0.7.0.1
 */