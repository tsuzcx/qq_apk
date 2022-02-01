package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aac
  extends com.tencent.mm.bw.a
{
  public String hpH;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.key);
      if (this.hpH != null) {
        paramVarArgs.d(2, this.hpH);
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.key) + 0;
      paramInt = i;
      if (this.hpH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hpH);
      }
      AppMethodBeat.o(91430);
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
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aac localaac = (aac)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91430);
        return -1;
      case 1: 
        localaac.key = locala.LVo.xF();
        AppMethodBeat.o(91430);
        return 0;
      }
      localaac.hpH = locala.LVo.readString();
      AppMethodBeat.o(91430);
      return 0;
    }
    AppMethodBeat.o(91430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aac
 * JD-Core Version:    0.7.0.1
 */