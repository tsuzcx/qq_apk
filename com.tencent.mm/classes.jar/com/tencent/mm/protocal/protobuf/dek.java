package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dek
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b HsN;
  public int Version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HsN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Version);
      if (this.HsN != null) {
        paramVarArgs.c(2, this.HsN);
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Version) + 0;
      paramInt = i;
      if (this.HsN != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HsN);
      }
      AppMethodBeat.o(152695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HsN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Signature");
        AppMethodBeat.o(152695);
        throw paramVarArgs;
      }
      AppMethodBeat.o(152695);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dek localdek = (dek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152695);
        return -1;
      case 1: 
        localdek.Version = locala.NPN.zc();
        AppMethodBeat.o(152695);
        return 0;
      }
      localdek.HsN = locala.NPN.gxI();
      AppMethodBeat.o(152695);
      return 0;
    }
    AppMethodBeat.o(152695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dek
 * JD-Core Version:    0.7.0.1
 */