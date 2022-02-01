package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gf
  extends com.tencent.mm.bw.a
{
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      AppMethodBeat.o(32123);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32123);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32123);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gf localgf = (gf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32123);
          return -1;
        }
        localgf.Username = locala.OmT.readString();
        AppMethodBeat.o(32123);
        return 0;
      }
      AppMethodBeat.o(32123);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gf
 * JD-Core Version:    0.7.0.1
 */