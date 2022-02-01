package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daj
  extends com.tencent.mm.bx.a
{
  public int Esd;
  public String Ese;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Esd);
      if (this.Ese != null) {
        paramVarArgs.d(4, this.Ese);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(2, this.mBH) + 0 + f.a.a.b.b.a.bA(3, this.Esd);
      paramInt = i;
      if (this.Ese != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ese);
      }
      AppMethodBeat.o(153305);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      daj localdaj = (daj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localdaj.mBH = locala.KhF.xS();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localdaj.Esd = locala.KhF.xS();
        AppMethodBeat.o(153305);
        return 0;
      }
      localdaj.Ese = locala.KhF.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daj
 * JD-Core Version:    0.7.0.1
 */