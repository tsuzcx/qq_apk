package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzm
  extends com.tencent.mm.bw.a
{
  public int GfI;
  public String GfJ;
  public String GfK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.GfI);
      if (this.GfJ != null) {
        paramVarArgs.d(2, this.GfJ);
      }
      if (this.GfK != null) {
        paramVarArgs.d(3, this.GfK);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.GfI) + 0;
      paramInt = i;
      if (this.GfJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GfJ);
      }
      i = paramInt;
      if (this.GfK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GfK);
      }
      AppMethodBeat.o(124575);
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
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzm localdzm = (dzm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localdzm.GfI = locala.LVo.xF();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localdzm.GfJ = locala.LVo.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localdzm.GfK = locala.LVo.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzm
 * JD-Core Version:    0.7.0.1
 */