package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyw
  extends com.tencent.mm.bw.a
{
  public String FIc;
  public String FId;
  public String FIe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIc != null) {
        paramVarArgs.d(1, this.FIc);
      }
      if (this.FId != null) {
        paramVarArgs.d(2, this.FId);
      }
      if (this.FIe != null) {
        paramVarArgs.d(3, this.FIe);
      }
      AppMethodBeat.o(32455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIc == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.e(1, this.FIc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FId);
      }
      i = paramInt;
      if (this.FIe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FIe);
      }
      AppMethodBeat.o(32455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyw localcyw = (cyw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32455);
          return -1;
        case 1: 
          localcyw.FIc = locala.LVo.readString();
          AppMethodBeat.o(32455);
          return 0;
        case 2: 
          localcyw.FId = locala.LVo.readString();
          AppMethodBeat.o(32455);
          return 0;
        }
        localcyw.FIe = locala.LVo.readString();
        AppMethodBeat.o(32455);
        return 0;
      }
      AppMethodBeat.o(32455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyw
 * JD-Core Version:    0.7.0.1
 */