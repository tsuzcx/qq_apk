package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djy
  extends com.tencent.mm.bx.a
{
  public String EzP;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.EzP != null) {
        paramVarArgs.d(2, this.EzP);
      }
      AppMethodBeat.o(32493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EzP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EzP);
      }
      AppMethodBeat.o(32493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djy localdjy = (djy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32493);
          return -1;
        case 1: 
          localdjy.username = locala.KhF.readString();
          AppMethodBeat.o(32493);
          return 0;
        }
        localdjy.EzP = locala.KhF.readString();
        AppMethodBeat.o(32493);
        return 0;
      }
      AppMethodBeat.o(32493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djy
 * JD-Core Version:    0.7.0.1
 */