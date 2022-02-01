package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ags
  extends com.tencent.mm.bw.a
{
  public String EyO;
  public String SmallImgUrl;
  public String ncR;
  public String ndW;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.EyO != null) {
        paramVarArgs.d(2, this.EyO);
      }
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      paramVarArgs.aR(5, this.ndj);
      AppMethodBeat.o(32210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label449;
      }
    }
    label449:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EyO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EyO);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ndW);
      }
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      i = f.a.a.b.b.a.bx(5, this.ndj);
      AppMethodBeat.o(32210);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32210);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ags localags = (ags)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32210);
          return -1;
        case 1: 
          localags.ncR = locala.LVo.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 2: 
          localags.EyO = locala.LVo.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 3: 
          localags.ndW = locala.LVo.readString();
          AppMethodBeat.o(32210);
          return 0;
        case 4: 
          localags.SmallImgUrl = locala.LVo.readString();
          AppMethodBeat.o(32210);
          return 0;
        }
        localags.ndj = locala.LVo.xF();
        AppMethodBeat.o(32210);
        return 0;
      }
      AppMethodBeat.o(32210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ags
 * JD-Core Version:    0.7.0.1
 */