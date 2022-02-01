package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bya
  extends com.tencent.mm.bx.a
{
  public int GRV;
  public int ooi;
  public long rIZ;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rIZ);
      paramVarArgs.aS(2, this.scene);
      paramVarArgs.aS(3, this.ooi);
      paramVarArgs.aS(4, this.GRV);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rIZ) + 0 + f.a.a.b.b.a.bz(2, this.scene) + f.a.a.b.b.a.bz(3, this.ooi) + f.a.a.b.b.a.bz(4, this.GRV);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sessionBuffer);
      }
      AppMethodBeat.o(184214);
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
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bya localbya = (bya)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localbya.rIZ = locala.NPN.zd();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localbya.scene = locala.NPN.zc();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localbya.ooi = locala.NPN.zc();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localbya.GRV = locala.NPN.zc();
        AppMethodBeat.o(184214);
        return 0;
      }
      localbya.sessionBuffer = locala.NPN.readString();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bya
 * JD-Core Version:    0.7.0.1
 */