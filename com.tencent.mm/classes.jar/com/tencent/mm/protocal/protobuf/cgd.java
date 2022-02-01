package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgd
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b HsB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43115);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HsB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.HsB != null) {
        paramVarArgs.c(2, this.HsB);
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.HsB != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HsB);
      }
      AppMethodBeat.o(43115);
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
      if (this.HsB == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: buf");
        AppMethodBeat.o(43115);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43115);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cgd localcgd = (cgd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43115);
        return -1;
      case 1: 
        localcgd.type = locala.OmT.zc();
        AppMethodBeat.o(43115);
        return 0;
      }
      localcgd.HsB = locala.OmT.gCk();
      AppMethodBeat.o(43115);
      return 0;
    }
    AppMethodBeat.o(43115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgd
 * JD-Core Version:    0.7.0.1
 */