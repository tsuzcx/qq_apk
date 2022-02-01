package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eea
  extends com.tencent.mm.bw.a
{
  public String MD5;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32518);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32518);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nJA);
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      AppMethodBeat.o(32518);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.MD5);
      }
      AppMethodBeat.o(32518);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32518);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32518);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eea localeea = (eea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32518);
        return -1;
      case 1: 
        localeea.nJA = locala.OmT.zc();
        AppMethodBeat.o(32518);
        return 0;
      }
      localeea.MD5 = locala.OmT.readString();
      AppMethodBeat.o(32518);
      return 0;
    }
    AppMethodBeat.o(32518);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eea
 * JD-Core Version:    0.7.0.1
 */