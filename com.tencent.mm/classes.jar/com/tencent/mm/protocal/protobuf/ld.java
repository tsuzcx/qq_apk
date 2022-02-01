package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ld
  extends com.tencent.mm.bw.a
{
  public String dwb;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209897);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      AppMethodBeat.o(209897);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nickname);
      }
      AppMethodBeat.o(209897);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(209897);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ld localld = (ld)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209897);
          return -1;
        case 1: 
          localld.dwb = locala.OmT.readString();
          AppMethodBeat.o(209897);
          return 0;
        }
        localld.nickname = locala.OmT.readString();
        AppMethodBeat.o(209897);
        return 0;
      }
      AppMethodBeat.o(209897);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ld
 * JD-Core Version:    0.7.0.1
 */