package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjv
  extends com.tencent.mm.bw.a
{
  public String EyJ;
  public int Fye;
  public String pAt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAt != null) {
        paramVarArgs.d(1, this.pAt);
      }
      paramVarArgs.aR(2, this.Fye);
      if (this.EyJ != null) {
        paramVarArgs.d(3, this.EyJ);
      }
      AppMethodBeat.o(32394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAt == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.pAt) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fye);
      paramInt = i;
      if (this.EyJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EyJ);
      }
      AppMethodBeat.o(32394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32394);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cjv localcjv = (cjv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32394);
          return -1;
        case 1: 
          localcjv.pAt = locala.LVo.readString();
          AppMethodBeat.o(32394);
          return 0;
        case 2: 
          localcjv.Fye = locala.LVo.xF();
          AppMethodBeat.o(32394);
          return 0;
        }
        localcjv.EyJ = locala.LVo.readString();
        AppMethodBeat.o(32394);
        return 0;
      }
      AppMethodBeat.o(32394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjv
 * JD-Core Version:    0.7.0.1
 */