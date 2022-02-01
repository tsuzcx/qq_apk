package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbx
  extends com.tencent.mm.bw.a
{
  public int FpT;
  public String FpU;
  public String IconUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50095);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FpT);
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.FpU != null) {
        paramVarArgs.d(3, this.FpU);
      }
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FpT) + 0;
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.FpU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FpU);
      }
      AppMethodBeat.o(50095);
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
      AppMethodBeat.o(50095);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbx localcbx = (cbx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50095);
        return -1;
      case 1: 
        localcbx.FpT = locala.LVo.xF();
        AppMethodBeat.o(50095);
        return 0;
      case 2: 
        localcbx.IconUrl = locala.LVo.readString();
        AppMethodBeat.o(50095);
        return 0;
      }
      localcbx.FpU = locala.LVo.readString();
      AppMethodBeat.o(50095);
      return 0;
    }
    AppMethodBeat.o(50095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbx
 * JD-Core Version:    0.7.0.1
 */