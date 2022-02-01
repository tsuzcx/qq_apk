package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apv
  extends com.tencent.mm.bw.a
{
  public String EIM;
  public int Exx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Exx);
      if (this.EIM != null) {
        paramVarArgs.d(2, this.EIM);
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Exx) + 0;
      paramInt = i;
      if (this.EIM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EIM);
      }
      AppMethodBeat.o(155407);
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
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apv localapv = (apv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155407);
        return -1;
      case 1: 
        localapv.Exx = locala.LVo.xF();
        AppMethodBeat.o(155407);
        return 0;
      }
      localapv.EIM = locala.LVo.readString();
      AppMethodBeat.o(155407);
      return 0;
    }
    AppMethodBeat.o(155407);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apv
 * JD-Core Version:    0.7.0.1
 */