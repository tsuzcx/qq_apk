package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzr
  extends com.tencent.mm.bx.a
{
  public int Lyv;
  public String Lyw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Lyv);
      if (this.Lyw != null) {
        paramVarArgs.d(2, this.Lyw);
      }
      AppMethodBeat.o(203878);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Lyv) + 0;
      paramInt = i;
      if (this.Lyw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Lyw);
      }
      AppMethodBeat.o(203878);
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
      AppMethodBeat.o(203878);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzr localdzr = (dzr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203878);
        return -1;
      case 1: 
        localdzr.Lyv = locala.KhF.xS();
        AppMethodBeat.o(203878);
        return 0;
      }
      localdzr.Lyw = locala.KhF.readString();
      AppMethodBeat.o(203878);
      return 0;
    }
    AppMethodBeat.o(203878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzr
 * JD-Core Version:    0.7.0.1
 */