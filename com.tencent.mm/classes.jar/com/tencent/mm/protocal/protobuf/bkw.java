package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkw
  extends com.tencent.mm.bw.a
{
  public int Epu;
  public String thV;
  public String vFm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Epu);
      if (this.vFm != null) {
        paramVarArgs.d(2, this.vFm);
      }
      if (this.thV != null) {
        paramVarArgs.d(3, this.thV);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Epu) + 0;
      paramInt = i;
      if (this.vFm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vFm);
      }
      i = paramInt;
      if (this.thV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thV);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkw localbkw = (bkw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localbkw.Epu = locala.LVo.xF();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localbkw.vFm = locala.LVo.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localbkw.thV = locala.LVo.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkw
 * JD-Core Version:    0.7.0.1
 */