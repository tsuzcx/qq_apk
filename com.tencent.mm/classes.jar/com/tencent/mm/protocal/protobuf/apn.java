package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apn
  extends com.tencent.mm.bx.a
{
  public long GnU;
  public int dFJ;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GnU);
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.dFJ);
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GnU) + 0 + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.dFJ);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
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
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apn localapn = (apn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169013);
        return -1;
      case 1: 
        localapn.GnU = locala.NPN.zd();
        AppMethodBeat.o(169013);
        return 0;
      case 2: 
        localapn.scene = locala.NPN.zc();
        AppMethodBeat.o(169013);
        return 0;
      case 3: 
        localapn.dFJ = locala.NPN.zc();
        AppMethodBeat.o(169013);
        return 0;
      }
      localapn.objectNonceId = locala.NPN.readString();
      AppMethodBeat.o(169013);
      return 0;
    }
    AppMethodBeat.o(169013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apn
 * JD-Core Version:    0.7.0.1
 */