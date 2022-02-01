package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqm
  extends com.tencent.mm.bw.a
{
  public int FfK;
  public String Ffi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ffi != null) {
        paramVarArgs.d(1, this.Ffi);
      }
      paramVarArgs.aR(2, this.FfK);
      AppMethodBeat.o(190896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ffi == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ffi) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FfK);
      AppMethodBeat.o(190896);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190896);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqm localbqm = (bqm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(190896);
          return -1;
        case 1: 
          localbqm.Ffi = locala.LVo.readString();
          AppMethodBeat.o(190896);
          return 0;
        }
        localbqm.FfK = locala.LVo.xF();
        AppMethodBeat.o(190896);
        return 0;
      }
      AppMethodBeat.o(190896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqm
 * JD-Core Version:    0.7.0.1
 */