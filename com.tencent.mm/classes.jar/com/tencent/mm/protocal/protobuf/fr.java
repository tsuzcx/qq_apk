package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fr
  extends com.tencent.mm.bw.a
{
  public int DSN;
  public String fZB;
  public String fZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      paramVarArgs.aR(2, this.DSN);
      if (this.fZB != null) {
        paramVarArgs.d(3, this.fZB);
      }
      AppMethodBeat.o(152494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.fZx) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DSN);
      paramInt = i;
      if (this.fZB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.fZB);
      }
      AppMethodBeat.o(152494);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152494);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152494);
          return -1;
        case 1: 
          localfr.fZx = locala.LVo.readString();
          AppMethodBeat.o(152494);
          return 0;
        case 2: 
          localfr.DSN = locala.LVo.xF();
          AppMethodBeat.o(152494);
          return 0;
        }
        localfr.fZB = locala.LVo.readString();
        AppMethodBeat.o(152494);
        return 0;
      }
      AppMethodBeat.o(152494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */