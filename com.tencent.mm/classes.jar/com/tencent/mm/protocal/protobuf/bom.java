package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bom
  extends com.tencent.mm.bw.a
{
  public int Edq;
  public int FdM;
  public String FdN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(146308);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FdM);
      if (this.FdN != null) {
        paramVarArgs.d(2, this.FdN);
      }
      paramVarArgs.aR(3, this.Edq);
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FdM) + 0;
      paramInt = i;
      if (this.FdN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FdN);
      }
      i = f.a.a.b.b.a.bx(3, this.Edq);
      AppMethodBeat.o(146308);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(146308);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bom localbom = (bom)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(146308);
        return -1;
      case 1: 
        localbom.FdM = locala.LVo.xF();
        AppMethodBeat.o(146308);
        return 0;
      case 2: 
        localbom.FdN = locala.LVo.readString();
        AppMethodBeat.o(146308);
        return 0;
      }
      localbom.Edq = locala.LVo.xF();
      AppMethodBeat.o(146308);
      return 0;
    }
    AppMethodBeat.o(146308);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bom
 * JD-Core Version:    0.7.0.1
 */