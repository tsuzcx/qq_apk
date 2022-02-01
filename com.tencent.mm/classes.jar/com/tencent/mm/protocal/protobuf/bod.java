package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bod
  extends com.tencent.mm.bw.a
{
  public String FdG;
  public String wTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32334);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wTM != null) {
        paramVarArgs.d(1, this.wTM);
      }
      if (this.FdG != null) {
        paramVarArgs.d(2, this.FdG);
      }
      AppMethodBeat.o(32334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wTM == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.wTM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FdG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FdG);
      }
      AppMethodBeat.o(32334);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32334);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bod localbod = (bod)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32334);
          return -1;
        case 1: 
          localbod.wTM = locala.LVo.readString();
          AppMethodBeat.o(32334);
          return 0;
        }
        localbod.FdG = locala.LVo.readString();
        AppMethodBeat.o(32334);
        return 0;
      }
      AppMethodBeat.o(32334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bod
 * JD-Core Version:    0.7.0.1
 */