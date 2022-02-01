package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpi
  extends com.tencent.mm.bw.a
{
  public String HcU;
  public String HcV;
  public int HcW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HcU != null) {
        paramVarArgs.d(1, this.HcU);
      }
      if (this.HcV != null) {
        paramVarArgs.d(2, this.HcV);
      }
      paramVarArgs.aS(3, this.HcW);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HcU == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HcU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HcV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HcV);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HcW);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpi localbpi = (bpi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localbpi.HcU = locala.OmT.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localbpi.HcV = locala.OmT.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localbpi.HcW = locala.OmT.zc();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpi
 * JD-Core Version:    0.7.0.1
 */