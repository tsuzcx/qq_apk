package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aie
  extends com.tencent.mm.bx.a
{
  public String GfF;
  public int mediaType;
  public long rIZ;
  public String rTn;
  public String sessionBuffer;
  public int videoDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rIZ);
      if (this.rTn != null) {
        paramVarArgs.d(2, this.rTn);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(3, this.sessionBuffer);
      }
      if (this.GfF != null) {
        paramVarArgs.d(4, this.GfF);
      }
      paramVarArgs.aS(5, this.videoDuration);
      paramVarArgs.aS(6, this.mediaType);
      AppMethodBeat.o(209262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rIZ) + 0;
      paramInt = i;
      if (this.rTn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rTn);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sessionBuffer);
      }
      paramInt = i;
      if (this.GfF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GfF);
      }
      i = f.a.a.b.b.a.bz(5, this.videoDuration);
      int j = f.a.a.b.b.a.bz(6, this.mediaType);
      AppMethodBeat.o(209262);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aie localaie = (aie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209262);
        return -1;
      case 1: 
        localaie.rIZ = locala.NPN.zd();
        AppMethodBeat.o(209262);
        return 0;
      case 2: 
        localaie.rTn = locala.NPN.readString();
        AppMethodBeat.o(209262);
        return 0;
      case 3: 
        localaie.sessionBuffer = locala.NPN.readString();
        AppMethodBeat.o(209262);
        return 0;
      case 4: 
        localaie.GfF = locala.NPN.readString();
        AppMethodBeat.o(209262);
        return 0;
      case 5: 
        localaie.videoDuration = locala.NPN.zc();
        AppMethodBeat.o(209262);
        return 0;
      }
      localaie.mediaType = locala.NPN.zc();
      AppMethodBeat.o(209262);
      return 0;
    }
    AppMethodBeat.o(209262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aie
 * JD-Core Version:    0.7.0.1
 */