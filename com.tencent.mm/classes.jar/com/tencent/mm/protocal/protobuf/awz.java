package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awz
  extends com.tencent.mm.bw.a
{
  public String dqk;
  public String dwx;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwx != null) {
        paramVarArgs.d(1, this.dwx);
      }
      if (this.dqk != null) {
        paramVarArgs.d(2, this.dqk);
      }
      paramVarArgs.aS(3, this.scene);
      AppMethodBeat.o(181501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwx == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dqk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dqk);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.scene);
      AppMethodBeat.o(181501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(181501);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        awz localawz = (awz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181501);
          return -1;
        case 1: 
          localawz.dwx = locala.OmT.readString();
          AppMethodBeat.o(181501);
          return 0;
        case 2: 
          localawz.dqk = locala.OmT.readString();
          AppMethodBeat.o(181501);
          return 0;
        }
        localawz.scene = locala.OmT.zc();
        AppMethodBeat.o(181501);
        return 0;
      }
      AppMethodBeat.o(181501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awz
 * JD-Core Version:    0.7.0.1
 */