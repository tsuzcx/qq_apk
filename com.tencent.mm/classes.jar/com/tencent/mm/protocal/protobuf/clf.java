package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clf
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String EyO;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ELg != null) {
        paramVarArgs.d(2, this.ELg);
      }
      if (this.EyO != null) {
        paramVarArgs.d(3, this.EyO);
      }
      AppMethodBeat.o(127291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ELg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ELg);
      }
      i = paramInt;
      if (this.EyO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EyO);
      }
      AppMethodBeat.o(127291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127291);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clf localclf = (clf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127291);
          return -1;
        case 1: 
          localclf.ncR = locala.LVo.readString();
          AppMethodBeat.o(127291);
          return 0;
        case 2: 
          localclf.ELg = locala.LVo.readString();
          AppMethodBeat.o(127291);
          return 0;
        }
        localclf.EyO = locala.LVo.readString();
        AppMethodBeat.o(127291);
        return 0;
      }
      AppMethodBeat.o(127291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clf
 * JD-Core Version:    0.7.0.1
 */