package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ct
  extends com.tencent.mm.bw.a
{
  public String DPQ;
  public int DPR;
  public String DPS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPQ != null) {
        paramVarArgs.d(1, this.DPQ);
      }
      paramVarArgs.aR(2, this.DPR);
      if (this.DPS != null) {
        paramVarArgs.d(3, this.DPS);
      }
      AppMethodBeat.o(149137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPQ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DPQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DPR);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DPS);
      }
      AppMethodBeat.o(149137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(149137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149137);
          return -1;
        case 1: 
          localct.DPQ = locala.LVo.readString();
          AppMethodBeat.o(149137);
          return 0;
        case 2: 
          localct.DPR = locala.LVo.xF();
          AppMethodBeat.o(149137);
          return 0;
        }
        localct.DPS = locala.LVo.readString();
        AppMethodBeat.o(149137);
        return 0;
      }
      AppMethodBeat.o(149137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ct
 * JD-Core Version:    0.7.0.1
 */