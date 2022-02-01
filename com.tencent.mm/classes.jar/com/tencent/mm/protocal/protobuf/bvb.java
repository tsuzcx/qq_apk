package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvb
  extends com.tencent.mm.bw.a
{
  public int FkY;
  public int FkZ;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.FkY);
      paramVarArgs.aR(3, this.FkZ);
      AppMethodBeat.o(194048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FkY);
      int j = f.a.a.b.b.a.bx(3, this.FkZ);
      AppMethodBeat.o(194048);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194048);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvb localbvb = (bvb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194048);
          return -1;
        case 1: 
          localbvb.ncR = locala.LVo.readString();
          AppMethodBeat.o(194048);
          return 0;
        case 2: 
          localbvb.FkY = locala.LVo.xF();
          AppMethodBeat.o(194048);
          return 0;
        }
        localbvb.FkZ = locala.LVo.xF();
        AppMethodBeat.o(194048);
        return 0;
      }
      AppMethodBeat.o(194048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvb
 * JD-Core Version:    0.7.0.1
 */