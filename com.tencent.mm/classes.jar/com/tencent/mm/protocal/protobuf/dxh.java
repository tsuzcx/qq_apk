package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxh
  extends com.tencent.mm.bw.a
{
  public int KWR;
  public String eaO;
  public int pVR;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.eaO != null) {
        paramVarArgs.e(1, this.eaO);
      }
      paramVarArgs.aM(2, this.pVR);
      paramVarArgs.aM(3, this.KWR);
      paramVarArgs.bb(4, this.seq);
      AppMethodBeat.o(114074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.eaO == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = g.a.a.b.b.a.f(1, this.eaO) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.pVR);
      int j = g.a.a.b.b.a.bu(3, this.KWR);
      int k = g.a.a.b.b.a.r(4, this.seq);
      AppMethodBeat.o(114074);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114074);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxh localdxh = (dxh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114074);
          return -1;
        case 1: 
          localdxh.eaO = locala.UbS.readString();
          AppMethodBeat.o(114074);
          return 0;
        case 2: 
          localdxh.pVR = locala.UbS.zi();
          AppMethodBeat.o(114074);
          return 0;
        case 3: 
          localdxh.KWR = locala.UbS.zi();
          AppMethodBeat.o(114074);
          return 0;
        }
        localdxh.seq = locala.UbS.zl();
        AppMethodBeat.o(114074);
        return 0;
      }
      AppMethodBeat.o(114074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxh
 * JD-Core Version:    0.7.0.1
 */