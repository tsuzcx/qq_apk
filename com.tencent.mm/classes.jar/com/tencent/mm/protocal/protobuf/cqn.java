package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqn
  extends com.tencent.mm.bw.a
{
  public String FtK;
  public int fZz;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117905);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FtK != null) {
        paramVarArgs.d(1, this.FtK);
      }
      paramVarArgs.aR(2, this.fZz);
      if (this.thh != null) {
        paramVarArgs.d(3, this.thh);
      }
      AppMethodBeat.o(117905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FtK == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FtK) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.fZz);
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.thh);
      }
      AppMethodBeat.o(117905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117905);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqn localcqn = (cqn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117905);
          return -1;
        case 1: 
          localcqn.FtK = locala.LVo.readString();
          AppMethodBeat.o(117905);
          return 0;
        case 2: 
          localcqn.fZz = locala.LVo.xF();
          AppMethodBeat.o(117905);
          return 0;
        }
        localcqn.thh = locala.LVo.readString();
        AppMethodBeat.o(117905);
        return 0;
      }
      AppMethodBeat.o(117905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqn
 * JD-Core Version:    0.7.0.1
 */