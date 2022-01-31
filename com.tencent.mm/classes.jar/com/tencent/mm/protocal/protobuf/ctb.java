package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctb
  extends com.tencent.mm.bv.a
{
  public int yck;
  public int ycl;
  public int ycm;
  public int ycn;
  public int yco;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5264);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yck);
      paramVarArgs.aO(2, this.ycl);
      paramVarArgs.aO(3, this.ycm);
      paramVarArgs.aO(4, this.ycn);
      paramVarArgs.aO(5, this.yco);
      AppMethodBeat.o(5264);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.yck);
      int i = e.a.a.b.b.a.bl(2, this.ycl);
      int j = e.a.a.b.b.a.bl(3, this.ycm);
      int k = e.a.a.b.b.a.bl(4, this.ycn);
      int m = e.a.a.b.b.a.bl(5, this.yco);
      AppMethodBeat.o(5264);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(5264);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ctb localctb = (ctb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5264);
        return -1;
      case 1: 
        localctb.yck = locala.CLY.sl();
        AppMethodBeat.o(5264);
        return 0;
      case 2: 
        localctb.ycl = locala.CLY.sl();
        AppMethodBeat.o(5264);
        return 0;
      case 3: 
        localctb.ycm = locala.CLY.sl();
        AppMethodBeat.o(5264);
        return 0;
      case 4: 
        localctb.ycn = locala.CLY.sl();
        AppMethodBeat.o(5264);
        return 0;
      }
      localctb.yco = locala.CLY.sl();
      AppMethodBeat.o(5264);
      return 0;
    }
    AppMethodBeat.o(5264);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */