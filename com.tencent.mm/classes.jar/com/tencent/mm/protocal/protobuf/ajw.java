package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajw
  extends com.tencent.mm.bx.a
{
  public String DkZ;
  public int opType;
  public long qoE;
  public long refObjectId;
  public String refObjectNonceId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169012);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.opType);
      paramVarArgs.aG(2, this.refObjectId);
      paramVarArgs.aG(3, this.qoE);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.DkZ != null) {
        paramVarArgs.d(5, this.DkZ);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.d(6, this.refObjectNonceId);
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.opType) + 0 + f.a.a.b.b.a.q(2, this.refObjectId) + f.a.a.b.b.a.q(3, this.qoE);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.DkZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DkZ);
      }
      paramInt = i;
      if (this.refObjectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.refObjectNonceId);
      }
      AppMethodBeat.o(169012);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169012);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajw localajw = (ajw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169012);
        return -1;
      case 1: 
        localajw.opType = locala.KhF.xS();
        AppMethodBeat.o(169012);
        return 0;
      case 2: 
        localajw.refObjectId = locala.KhF.xT();
        AppMethodBeat.o(169012);
        return 0;
      case 3: 
        localajw.qoE = locala.KhF.xT();
        AppMethodBeat.o(169012);
        return 0;
      case 4: 
        localajw.username = locala.KhF.readString();
        AppMethodBeat.o(169012);
        return 0;
      case 5: 
        localajw.DkZ = locala.KhF.readString();
        AppMethodBeat.o(169012);
        return 0;
      }
      localajw.refObjectNonceId = locala.KhF.readString();
      AppMethodBeat.o(169012);
      return 0;
    }
    AppMethodBeat.o(169012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajw
 * JD-Core Version:    0.7.0.1
 */