package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btm
  extends com.tencent.mm.bw.a
{
  public int Fiu;
  public int nLC;
  public long qXP;
  public int scene;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184214);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qXP);
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.nLC);
      paramVarArgs.aR(4, this.Fiu);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(5, this.sessionBuffer);
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.qXP) + 0 + f.a.a.b.b.a.bx(2, this.scene) + f.a.a.b.b.a.bx(3, this.nLC) + f.a.a.b.b.a.bx(4, this.Fiu);
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
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184214);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      btm localbtm = (btm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184214);
        return -1;
      case 1: 
        localbtm.qXP = locala.LVo.xG();
        AppMethodBeat.o(184214);
        return 0;
      case 2: 
        localbtm.scene = locala.LVo.xF();
        AppMethodBeat.o(184214);
        return 0;
      case 3: 
        localbtm.nLC = locala.LVo.xF();
        AppMethodBeat.o(184214);
        return 0;
      case 4: 
        localbtm.Fiu = locala.LVo.xF();
        AppMethodBeat.o(184214);
        return 0;
      }
      localbtm.sessionBuffer = locala.LVo.readString();
      AppMethodBeat.o(184214);
      return 0;
    }
    AppMethodBeat.o(184214);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btm
 * JD-Core Version:    0.7.0.1
 */