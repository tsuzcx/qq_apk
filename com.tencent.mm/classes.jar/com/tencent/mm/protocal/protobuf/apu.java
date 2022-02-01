package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apu
  extends com.tencent.mm.bx.a
{
  public String drf;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194941);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      if (this.drf != null) {
        paramVarArgs.d(2, this.drf);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(3, this.sessionId);
      }
      AppMethodBeat.o(194941);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0;
      paramInt = i;
      if (this.drf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.drf);
      }
      i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sessionId);
      }
      AppMethodBeat.o(194941);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(194941);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apu localapu = (apu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194941);
        return -1;
      case 1: 
        localapu.scene = locala.NPN.zc();
        AppMethodBeat.o(194941);
        return 0;
      case 2: 
        localapu.drf = locala.NPN.readString();
        AppMethodBeat.o(194941);
        return 0;
      }
      localapu.sessionId = locala.NPN.readString();
      AppMethodBeat.o(194941);
      return 0;
    }
    AppMethodBeat.o(194941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apu
 * JD-Core Version:    0.7.0.1
 */