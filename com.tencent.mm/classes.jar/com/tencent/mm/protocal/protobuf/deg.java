package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deg
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32450);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.FileSize);
      AppMethodBeat.o(32450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FileSize);
      AppMethodBeat.o(32450);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32450);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deg localdeg = (deg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32450);
          return -1;
        case 1: 
          localdeg.MD5 = locala.OmT.readString();
          AppMethodBeat.o(32450);
          return 0;
        }
        localdeg.FileSize = locala.OmT.zc();
        AppMethodBeat.o(32450);
        return 0;
      }
      AppMethodBeat.o(32450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deg
 * JD-Core Version:    0.7.0.1
 */