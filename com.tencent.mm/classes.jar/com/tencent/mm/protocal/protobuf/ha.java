package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ha
  extends com.tencent.mm.bw.a
{
  public String DUi;
  public String DUj;
  public String cZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUi != null) {
        paramVarArgs.d(1, this.DUi);
      }
      if (this.DUj != null) {
        paramVarArgs.d(2, this.DUj);
      }
      if (this.cZz != null) {
        paramVarArgs.d(3, this.cZz);
      }
      AppMethodBeat.o(123549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUi == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DUj);
      }
      i = paramInt;
      if (this.cZz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.cZz);
      }
      AppMethodBeat.o(123549);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ha localha = (ha)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123549);
          return -1;
        case 1: 
          localha.DUi = locala.LVo.readString();
          AppMethodBeat.o(123549);
          return 0;
        case 2: 
          localha.DUj = locala.LVo.readString();
          AppMethodBeat.o(123549);
          return 0;
        }
        localha.cZz = locala.LVo.readString();
        AppMethodBeat.o(123549);
        return 0;
      }
      AppMethodBeat.o(123549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ha
 * JD-Core Version:    0.7.0.1
 */