package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajy
  extends com.tencent.mm.bx.a
{
  public int FuW;
  public int FuX;
  public int FuY;
  public int FuZ;
  public String Fvc;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuW);
      paramVarArgs.aS(2, this.nDG);
      if (this.Fvc != null) {
        paramVarArgs.d(3, this.Fvc);
      }
      paramVarArgs.aS(4, this.FuX);
      paramVarArgs.aS(5, this.FuY);
      paramVarArgs.aS(6, this.FuZ);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FuW) + 0 + f.a.a.b.b.a.bz(2, this.nDG);
      paramInt = i;
      if (this.Fvc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fvc);
      }
      i = f.a.a.b.b.a.bz(4, this.FuX);
      int j = f.a.a.b.b.a.bz(5, this.FuY);
      int k = f.a.a.b.b.a.bz(6, this.FuZ);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajy localajy = (ajy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localajy.FuW = locala.NPN.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localajy.nDG = locala.NPN.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localajy.Fvc = locala.NPN.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localajy.FuX = locala.NPN.zc();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localajy.FuY = locala.NPN.zc();
        AppMethodBeat.o(127470);
        return 0;
      }
      localajy.FuZ = locala.NPN.zc();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajy
 * JD-Core Version:    0.7.0.1
 */