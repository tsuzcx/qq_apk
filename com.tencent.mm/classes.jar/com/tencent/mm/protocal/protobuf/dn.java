package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dn
  extends com.tencent.mm.bw.a
{
  public boolean DQA;
  public String DQB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.DQA);
      if (this.DQB != null) {
        paramVarArgs.d(2, this.DQB);
      }
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.DQB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQB);
      }
      AppMethodBeat.o(123538);
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
      AppMethodBeat.o(123538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dn localdn = (dn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123538);
        return -1;
      case 1: 
        localdn.DQA = locala.LVo.fZX();
        AppMethodBeat.o(123538);
        return 0;
      }
      localdn.DQB = locala.LVo.readString();
      AppMethodBeat.o(123538);
      return 0;
    }
    AppMethodBeat.o(123538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dn
 * JD-Core Version:    0.7.0.1
 */