package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public long DKN;
  public String DKT;
  public long DKU;
  public int DKV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKT != null) {
        paramVarArgs.d(1, this.DKT);
      }
      paramVarArgs.aO(2, this.DKN);
      paramVarArgs.aO(3, this.DKU);
      paramVarArgs.aR(4, this.DKV);
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKT == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.DKT) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.DKN);
      int j = f.a.a.b.b.a.p(3, this.DKU);
      int k = f.a.a.b.b.a.bx(4, this.DKV);
      AppMethodBeat.o(91332);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localu.DKT = locala.LVo.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localu.DKN = locala.LVo.xG();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localu.DKU = locala.LVo.xG();
          AppMethodBeat.o(91332);
          return 0;
        }
        localu.DKV = locala.LVo.xF();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.u
 * JD-Core Version:    0.7.0.1
 */