package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzb
  extends com.tencent.mm.bw.a
{
  public int EeA;
  public String Ewu;
  public String dmy;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      paramVarArgs.aR(3, this.EeA);
      if (this.ndW != null) {
        paramVarArgs.d(4, this.ndW);
      }
      if (this.dmy != null) {
        paramVarArgs.d(5, this.dmy);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ewu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ewu);
      }
      i += f.a.a.b.b.a.bx(3, this.EeA);
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ndW);
      }
      i = paramInt;
      if (this.dmy != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dmy);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzb localbzb = (bzb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localbzb.ncR = locala.LVo.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localbzb.Ewu = locala.LVo.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localbzb.EeA = locala.LVo.xF();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localbzb.ndW = locala.LVo.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localbzb.dmy = locala.LVo.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzb
 * JD-Core Version:    0.7.0.1
 */