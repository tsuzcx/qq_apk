package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfm
  extends com.tencent.mm.bw.a
{
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152635);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      AppMethodBeat.o(152635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152635);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152635);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfm localcfm = (cfm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152635);
          return -1;
        }
        localcfm.userName = locala.OmT.readString();
        AppMethodBeat.o(152635);
        return 0;
      }
      AppMethodBeat.o(152635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfm
 * JD-Core Version:    0.7.0.1
 */