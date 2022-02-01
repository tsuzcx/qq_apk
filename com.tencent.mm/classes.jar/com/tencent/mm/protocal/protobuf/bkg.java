package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkg
  extends com.tencent.mm.bw.a
{
  public String EZU;
  public String EZV;
  public int EZW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EZU != null) {
        paramVarArgs.d(1, this.EZU);
      }
      if (this.EZV != null) {
        paramVarArgs.d(2, this.EZV);
      }
      paramVarArgs.aR(3, this.EZW);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EZU == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.EZU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EZV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EZV);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.EZW);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localbkg.EZU = locala.LVo.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localbkg.EZV = locala.LVo.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localbkg.EZW = locala.LVo.xF();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkg
 * JD-Core Version:    0.7.0.1
 */