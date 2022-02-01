package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqw
  extends com.tencent.mm.bw.a
{
  public String HCm;
  public String HCn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133191);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCm != null) {
        paramVarArgs.d(1, this.HCm);
      }
      if (this.HCn != null) {
        paramVarArgs.d(2, this.HCn);
      }
      AppMethodBeat.o(133191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCm == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HCm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HCn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HCn);
      }
      AppMethodBeat.o(133191);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133191);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqw localcqw = (cqw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133191);
          return -1;
        case 1: 
          localcqw.HCm = locala.OmT.readString();
          AppMethodBeat.o(133191);
          return 0;
        }
        localcqw.HCn = locala.OmT.readString();
        AppMethodBeat.o(133191);
        return 0;
      }
      AppMethodBeat.o(133191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqw
 * JD-Core Version:    0.7.0.1
 */