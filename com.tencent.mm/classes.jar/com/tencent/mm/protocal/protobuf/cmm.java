package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmm
  extends com.tencent.mm.bw.a
{
  public int MrI;
  public int MrJ;
  public long hFK;
  public int pHw;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hFK);
      paramVarArgs.aM(2, this.scene);
      paramVarArgs.aM(3, this.pHw);
      paramVarArgs.aM(4, this.MrI);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(5, this.sessionBuffer);
      }
      paramVarArgs.aM(6, this.MrJ);
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.hFK) + 0 + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.pHw) + g.a.a.b.b.a.bu(4, this.MrI);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.sessionBuffer);
      }
      i = g.a.a.b.b.a.bu(6, this.MrJ);
      AppMethodBeat.o(184214);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cmm localcmm = (cmm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localcmm.hFK = locala.UbS.zl();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localcmm.scene = locala.UbS.zi();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localcmm.pHw = locala.UbS.zi();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localcmm.MrI = locala.UbS.zi();
        AppMethodBeat.o(184214);
        return 0;
      case 5: 
        localcmm.sessionBuffer = locala.UbS.readString();
        AppMethodBeat.o(184214);
        return 0;
      }
      localcmm.MrJ = locala.UbS.zi();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmm
 * JD-Core Version:    0.7.0.1
 */