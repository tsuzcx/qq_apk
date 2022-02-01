package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dw
  extends com.tencent.mm.bw.a
{
  public String DQG;
  public String DQH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQG != null) {
        paramVarArgs.d(1, this.DQG);
      }
      if (this.DQH != null) {
        paramVarArgs.d(2, this.DQH);
      }
      AppMethodBeat.o(32115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQG == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.DQG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DQH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DQH);
      }
      AppMethodBeat.o(32115);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32115);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dw localdw = (dw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32115);
          return -1;
        case 1: 
          localdw.DQG = locala.LVo.readString();
          AppMethodBeat.o(32115);
          return 0;
        }
        localdw.DQH = locala.LVo.readString();
        AppMethodBeat.o(32115);
        return 0;
      }
      AppMethodBeat.o(32115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dw
 * JD-Core Version:    0.7.0.1
 */