package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agv
  extends com.tencent.mm.bx.a
{
  public String hAD;
  public int xSm;
  public String xSn;
  public String xSo;
  public int xSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xSm);
      if (this.xSn != null) {
        paramVarArgs.d(2, this.xSn);
      }
      if (this.xSo != null) {
        paramVarArgs.d(3, this.xSo);
      }
      paramVarArgs.aS(4, this.xSp);
      if (this.hAD != null) {
        paramVarArgs.d(5, this.hAD);
      }
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.xSm) + 0;
      paramInt = i;
      if (this.xSn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xSn);
      }
      i = paramInt;
      if (this.xSo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xSo);
      }
      i += f.a.a.b.b.a.bz(4, this.xSp);
      paramInt = i;
      if (this.hAD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hAD);
      }
      AppMethodBeat.o(72474);
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
      AppMethodBeat.o(72474);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agv localagv = (agv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72474);
        return -1;
      case 1: 
        localagv.xSm = locala.NPN.zc();
        AppMethodBeat.o(72474);
        return 0;
      case 2: 
        localagv.xSn = locala.NPN.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 3: 
        localagv.xSo = locala.NPN.readString();
        AppMethodBeat.o(72474);
        return 0;
      case 4: 
        localagv.xSp = locala.NPN.zc();
        AppMethodBeat.o(72474);
        return 0;
      }
      localagv.hAD = locala.NPN.readString();
      AppMethodBeat.o(72474);
      return 0;
    }
    AppMethodBeat.o(72474);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agv
 * JD-Core Version:    0.7.0.1
 */