package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aof
  extends com.tencent.mm.bw.a
{
  public String EHq;
  public long EHr;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169059);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EHq != null) {
        paramVarArgs.d(1, this.EHq);
      }
      paramVarArgs.aR(2, this.type);
      paramVarArgs.aO(3, this.EHr);
      AppMethodBeat.o(169059);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EHq == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.EHq) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.type);
      int j = f.a.a.b.b.a.p(3, this.EHr);
      AppMethodBeat.o(169059);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169059);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aof localaof = (aof)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169059);
          return -1;
        case 1: 
          localaof.EHq = locala.LVo.readString();
          AppMethodBeat.o(169059);
          return 0;
        case 2: 
          localaof.type = locala.LVo.xF();
          AppMethodBeat.o(169059);
          return 0;
        }
        localaof.EHr = locala.LVo.xG();
        AppMethodBeat.o(169059);
        return 0;
      }
      AppMethodBeat.o(169059);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aof
 * JD-Core Version:    0.7.0.1
 */