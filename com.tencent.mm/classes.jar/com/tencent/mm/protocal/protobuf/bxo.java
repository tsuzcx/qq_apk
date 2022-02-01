package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxo
  extends com.tencent.mm.bw.a
{
  public int tit;
  public String tlJ;
  public String tlK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlK != null) {
        paramVarArgs.d(1, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(2, this.tlJ);
      }
      paramVarArgs.aR(3, this.vTO);
      paramVarArgs.aR(4, this.tit);
      paramVarArgs.aO(5, this.vTQ);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlK == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlJ);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.vTO);
      int j = f.a.a.b.b.a.bx(4, this.tit);
      int k = f.a.a.b.b.a.p(5, this.vTQ);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxo localbxo = (bxo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localbxo.tlK = locala.LVo.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localbxo.tlJ = locala.LVo.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localbxo.vTO = locala.LVo.xF();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localbxo.tit = locala.LVo.xF();
          AppMethodBeat.o(43113);
          return 0;
        }
        localbxo.vTQ = locala.LVo.xG();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxo
 * JD-Core Version:    0.7.0.1
 */