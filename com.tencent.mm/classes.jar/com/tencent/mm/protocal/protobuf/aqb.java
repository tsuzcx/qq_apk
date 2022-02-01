package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqb
  extends com.tencent.mm.bw.a
{
  public int Ebf;
  public String tLG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ebf);
      if (this.tLG != null) {
        paramVarArgs.d(2, this.tLG);
      }
      AppMethodBeat.o(124491);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ebf) + 0;
      paramInt = i;
      if (this.tLG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tLG);
      }
      AppMethodBeat.o(124491);
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
      AppMethodBeat.o(124491);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqb localaqb = (aqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124491);
        return -1;
      case 1: 
        localaqb.Ebf = locala.LVo.xF();
        AppMethodBeat.o(124491);
        return 0;
      }
      localaqb.tLG = locala.LVo.readString();
      AppMethodBeat.o(124491);
      return 0;
    }
    AppMethodBeat.o(124491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqb
 * JD-Core Version:    0.7.0.1
 */