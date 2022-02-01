package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgk
  extends com.tencent.mm.bw.a
{
  public int FPM;
  public String FPN;
  public String FPO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FPM);
      if (this.FPN != null) {
        paramVarArgs.d(2, this.FPN);
      }
      if (this.FPO != null) {
        paramVarArgs.d(3, this.FPO);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FPM) + 0;
      paramInt = i;
      if (this.FPN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FPN);
      }
      i = paramInt;
      if (this.FPO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FPO);
      }
      AppMethodBeat.o(117933);
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
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dgk localdgk = (dgk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localdgk.FPM = locala.LVo.xF();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localdgk.FPN = locala.LVo.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localdgk.FPO = locala.LVo.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgk
 * JD-Core Version:    0.7.0.1
 */