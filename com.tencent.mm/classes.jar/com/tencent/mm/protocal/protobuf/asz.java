package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asz
  extends com.tencent.mm.bw.a
{
  public int dvm;
  public String objectNonceId;
  public long rRn;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.rRn);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aS(3, this.dvm);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(4, this.sessionBuffer);
      }
      AppMethodBeat.o(189417);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rRn) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.dvm);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionBuffer);
      }
      AppMethodBeat.o(189417);
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
      AppMethodBeat.o(189417);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      asz localasz = (asz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189417);
        return -1;
      case 1: 
        localasz.rRn = locala.OmT.zd();
        AppMethodBeat.o(189417);
        return 0;
      case 2: 
        localasz.objectNonceId = locala.OmT.readString();
        AppMethodBeat.o(189417);
        return 0;
      case 3: 
        localasz.dvm = locala.OmT.zc();
        AppMethodBeat.o(189417);
        return 0;
      }
      localasz.sessionBuffer = locala.OmT.readString();
      AppMethodBeat.o(189417);
      return 0;
    }
    AppMethodBeat.o(189417);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asz
 * JD-Core Version:    0.7.0.1
 */