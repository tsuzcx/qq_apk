package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfd
  extends com.tencent.mm.bw.a
{
  public String HMn;
  public String HMo;
  public String HMp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMn != null) {
        paramVarArgs.d(1, this.HMn);
      }
      if (this.HMo != null) {
        paramVarArgs.d(2, this.HMo);
      }
      if (this.HMp != null) {
        paramVarArgs.d(3, this.HMp);
      }
      AppMethodBeat.o(32455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMn == null) {
        break label343;
      }
    }
    label343:
    for (int i = f.a.a.b.b.a.e(1, this.HMn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HMo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HMo);
      }
      i = paramInt;
      if (this.HMp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HMp);
      }
      AppMethodBeat.o(32455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfd localdfd = (dfd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32455);
          return -1;
        case 1: 
          localdfd.HMn = locala.OmT.readString();
          AppMethodBeat.o(32455);
          return 0;
        case 2: 
          localdfd.HMo = locala.OmT.readString();
          AppMethodBeat.o(32455);
          return 0;
        }
        localdfd.HMp = locala.OmT.readString();
        AppMethodBeat.o(32455);
        return 0;
      }
      AppMethodBeat.o(32455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfd
 * JD-Core Version:    0.7.0.1
 */