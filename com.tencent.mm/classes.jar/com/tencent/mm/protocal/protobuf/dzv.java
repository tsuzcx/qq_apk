package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzv
  extends com.tencent.mm.bx.a
{
  public String LyA;
  public int Lyv;
  public long Lyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203883);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Lyz);
      if (this.LyA != null) {
        paramVarArgs.d(2, this.LyA);
      }
      paramVarArgs.aR(3, this.Lyv);
      AppMethodBeat.o(203883);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Lyz) + 0;
      paramInt = i;
      if (this.LyA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LyA);
      }
      i = f.a.a.b.b.a.bA(3, this.Lyv);
      AppMethodBeat.o(203883);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203883);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzv localdzv = (dzv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203883);
        return -1;
      case 1: 
        localdzv.Lyz = locala.KhF.xT();
        AppMethodBeat.o(203883);
        return 0;
      case 2: 
        localdzv.LyA = locala.KhF.readString();
        AppMethodBeat.o(203883);
        return 0;
      }
      localdzv.Lyv = locala.KhF.xS();
      AppMethodBeat.o(203883);
      return 0;
    }
    AppMethodBeat.o(203883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzv
 * JD-Core Version:    0.7.0.1
 */