package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buw
  extends com.tencent.mm.bw.a
{
  public String DPx;
  public String Eoe;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPx != null) {
        paramVarArgs.d(1, this.DPx);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.Eoe != null) {
        paramVarArgs.d(3, this.Eoe);
      }
      AppMethodBeat.o(101825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPx == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DPx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.Eoe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eoe);
      }
      AppMethodBeat.o(101825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(101825);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buw localbuw = (buw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101825);
          return -1;
        case 1: 
          localbuw.DPx = locala.LVo.readString();
          AppMethodBeat.o(101825);
          return 0;
        case 2: 
          localbuw.ncR = locala.LVo.readString();
          AppMethodBeat.o(101825);
          return 0;
        }
        localbuw.Eoe = locala.LVo.readString();
        AppMethodBeat.o(101825);
        return 0;
      }
      AppMethodBeat.o(101825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buw
 * JD-Core Version:    0.7.0.1
 */