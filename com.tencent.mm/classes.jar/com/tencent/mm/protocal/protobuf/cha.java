package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cha
  extends com.tencent.mm.bw.a
{
  public int EuN;
  public int EuO;
  public String info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125755);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EuN);
      paramVarArgs.aR(2, this.EuO);
      if (this.info != null) {
        paramVarArgs.d(3, this.info);
      }
      AppMethodBeat.o(125755);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EuN) + 0 + f.a.a.b.b.a.bx(2, this.EuO);
      paramInt = i;
      if (this.info != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.info);
      }
      AppMethodBeat.o(125755);
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
      AppMethodBeat.o(125755);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cha localcha = (cha)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125755);
        return -1;
      case 1: 
        localcha.EuN = locala.LVo.xF();
        AppMethodBeat.o(125755);
        return 0;
      case 2: 
        localcha.EuO = locala.LVo.xF();
        AppMethodBeat.o(125755);
        return 0;
      }
      localcha.info = locala.LVo.readString();
      AppMethodBeat.o(125755);
      return 0;
    }
    AppMethodBeat.o(125755);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cha
 * JD-Core Version:    0.7.0.1
 */