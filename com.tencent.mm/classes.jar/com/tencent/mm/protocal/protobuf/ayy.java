package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayy
  extends com.tencent.mm.bw.a
{
  public long LIV;
  public int dYx;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169013);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LIV);
      paramVarArgs.aM(2, this.scene);
      paramVarArgs.aM(3, this.dYx);
      if (this.objectNonceId != null) {
        paramVarArgs.e(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LIV) + 0 + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.dYx);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ayy localayy = (ayy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169013);
        return -1;
      case 1: 
        localayy.LIV = locala.UbS.zl();
        AppMethodBeat.o(169013);
        return 0;
      case 2: 
        localayy.scene = locala.UbS.zi();
        AppMethodBeat.o(169013);
        return 0;
      case 3: 
        localayy.dYx = locala.UbS.zi();
        AppMethodBeat.o(169013);
        return 0;
      }
      localayy.objectNonceId = locala.UbS.readString();
      AppMethodBeat.o(169013);
      return 0;
    }
    AppMethodBeat.o(169013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayy
 * JD-Core Version:    0.7.0.1
 */