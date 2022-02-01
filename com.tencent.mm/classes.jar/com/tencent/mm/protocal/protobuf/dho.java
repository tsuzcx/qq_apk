package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dho
  extends com.tencent.mm.bw.a
{
  public String FvM;
  public String FvN;
  public String nWj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194024);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FvM != null) {
        paramVarArgs.d(1, this.FvM);
      }
      if (this.FvN != null) {
        paramVarArgs.d(2, this.FvN);
      }
      if (this.nWj != null) {
        paramVarArgs.d(3, this.nWj);
      }
      AppMethodBeat.o(194024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FvM == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FvM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FvN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FvN);
      }
      i = paramInt;
      if (this.nWj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nWj);
      }
      AppMethodBeat.o(194024);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194024);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dho localdho = (dho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194024);
          return -1;
        case 1: 
          localdho.FvM = locala.LVo.readString();
          AppMethodBeat.o(194024);
          return 0;
        case 2: 
          localdho.FvN = locala.LVo.readString();
          AppMethodBeat.o(194024);
          return 0;
        }
        localdho.nWj = locala.LVo.readString();
        AppMethodBeat.o(194024);
        return 0;
      }
      AppMethodBeat.o(194024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dho
 * JD-Core Version:    0.7.0.1
 */