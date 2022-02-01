package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bop
  extends com.tencent.mm.bw.a
{
  public int DLI;
  public String EVJ;
  public String FdO;
  public boolean FdP;
  public String FdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DLI);
      if (this.FdO != null) {
        paramVarArgs.d(2, this.FdO);
      }
      paramVarArgs.bl(3, this.FdP);
      if (this.FdQ != null) {
        paramVarArgs.d(4, this.FdQ);
      }
      if (this.EVJ != null) {
        paramVarArgs.d(5, this.EVJ);
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DLI) + 0;
      paramInt = i;
      if (this.FdO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FdO);
      }
      i = paramInt + (f.a.a.b.b.a.fK(3) + 1);
      paramInt = i;
      if (this.FdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FdQ);
      }
      i = paramInt;
      if (this.EVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EVJ);
      }
      AppMethodBeat.o(123623);
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
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bop localbop = (bop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123623);
        return -1;
      case 1: 
        localbop.DLI = locala.LVo.xF();
        AppMethodBeat.o(123623);
        return 0;
      case 2: 
        localbop.FdO = locala.LVo.readString();
        AppMethodBeat.o(123623);
        return 0;
      case 3: 
        localbop.FdP = locala.LVo.fZX();
        AppMethodBeat.o(123623);
        return 0;
      case 4: 
        localbop.FdQ = locala.LVo.readString();
        AppMethodBeat.o(123623);
        return 0;
      }
      localbop.EVJ = locala.LVo.readString();
      AppMethodBeat.o(123623);
      return 0;
    }
    AppMethodBeat.o(123623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bop
 * JD-Core Version:    0.7.0.1
 */