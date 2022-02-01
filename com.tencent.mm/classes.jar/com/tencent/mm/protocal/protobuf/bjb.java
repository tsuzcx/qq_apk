package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjb
  extends com.tencent.mm.bw.a
{
  public String DUp;
  public String ncU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82424);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUp != null) {
        paramVarArgs.d(1, this.DUp);
      }
      if (this.ncU != null) {
        paramVarArgs.d(2, this.ncU);
      }
      AppMethodBeat.o(82424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUp == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.DUp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncU);
      }
      AppMethodBeat.o(82424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82424);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjb localbjb = (bjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82424);
          return -1;
        case 1: 
          localbjb.DUp = locala.LVo.readString();
          AppMethodBeat.o(82424);
          return 0;
        }
        localbjb.ncU = locala.LVo.readString();
        AppMethodBeat.o(82424);
        return 0;
      }
      AppMethodBeat.o(82424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjb
 * JD-Core Version:    0.7.0.1
 */