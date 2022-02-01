package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqa
  extends com.tencent.mm.bw.a
{
  public long GHa;
  public int dGO;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GHa);
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.dGO);
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GHa) + 0 + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.dGO);
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
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqa localaqa = (aqa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169013);
        return -1;
      case 1: 
        localaqa.GHa = locala.OmT.zd();
        AppMethodBeat.o(169013);
        return 0;
      case 2: 
        localaqa.scene = locala.OmT.zc();
        AppMethodBeat.o(169013);
        return 0;
      case 3: 
        localaqa.dGO = locala.OmT.zc();
        AppMethodBeat.o(169013);
        return 0;
      }
      localaqa.objectNonceId = locala.OmT.readString();
      AppMethodBeat.o(169013);
      return 0;
    }
    AppMethodBeat.o(169013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqa
 * JD-Core Version:    0.7.0.1
 */