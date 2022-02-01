package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cfj
  extends com.tencent.mm.bw.a
{
  public String FtP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FtP == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNum");
        AppMethodBeat.o(43122);
        throw paramVarArgs;
      }
      if (this.FtP != null) {
        paramVarArgs.d(1, this.FtP);
      }
      AppMethodBeat.o(43122);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FtP == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.FtP) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43122);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FtP == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNum");
          AppMethodBeat.o(43122);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43122);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfj localcfj = (cfj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43122);
          return -1;
        }
        localcfj.FtP = locala.LVo.readString();
        AppMethodBeat.o(43122);
        return 0;
      }
      AppMethodBeat.o(43122);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfj
 * JD-Core Version:    0.7.0.1
 */