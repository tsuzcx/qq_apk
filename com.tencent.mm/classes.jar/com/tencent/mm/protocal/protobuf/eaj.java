package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eaj
  extends com.tencent.mm.bw.a
{
  public b EaW;
  public String Fed;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fed != null) {
        paramVarArgs.d(1, this.Fed);
      }
      if (this.EaW != null) {
        paramVarArgs.c(2, this.EaW);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fed == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Fed) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EaW != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.EaW);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      AppMethodBeat.o(123700);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eaj localeaj = (eaj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localeaj.Fed = locala.LVo.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localeaj.EaW = locala.LVo.gfk();
          AppMethodBeat.o(123700);
          return 0;
        }
        localeaj.djj = locala.LVo.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */