package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amg
  extends com.tencent.mm.bw.a
{
  public long EFE;
  public int dtJ;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EFE);
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.dtJ);
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.EFE) + 0 + f.a.a.b.b.a.bx(2, this.scene) + f.a.a.b.b.a.bx(3, this.dtJ);
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
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amg localamg = (amg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169013);
        return -1;
      case 1: 
        localamg.EFE = locala.LVo.xG();
        AppMethodBeat.o(169013);
        return 0;
      case 2: 
        localamg.scene = locala.LVo.xF();
        AppMethodBeat.o(169013);
        return 0;
      case 3: 
        localamg.dtJ = locala.LVo.xF();
        AppMethodBeat.o(169013);
        return 0;
      }
      localamg.objectNonceId = locala.LVo.readString();
      AppMethodBeat.o(169013);
      return 0;
    }
    AppMethodBeat.o(169013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amg
 * JD-Core Version:    0.7.0.1
 */