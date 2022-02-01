package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwh
  extends com.tencent.mm.bx.a
{
  public int Eoc;
  public int Eod;
  public int ijX;
  public String ijY;
  public long ijZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ijX);
      if (this.ijY != null) {
        paramVarArgs.d(2, this.ijY);
      }
      paramVarArgs.aG(3, this.ijZ);
      paramVarArgs.aR(4, this.Eoc);
      paramVarArgs.aR(5, this.Eod);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.ijX) + 0;
      paramInt = i;
      if (this.ijY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijY);
      }
      i = f.a.a.b.b.a.q(3, this.ijZ);
      int j = f.a.a.b.b.a.bA(4, this.Eoc);
      int k = f.a.a.b.b.a.bA(5, this.Eod);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cwh localcwh = (cwh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localcwh.ijX = locala.KhF.xS();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localcwh.ijY = locala.KhF.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localcwh.ijZ = locala.KhF.xT();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localcwh.Eoc = locala.KhF.xS();
        AppMethodBeat.o(43131);
        return 0;
      }
      localcwh.Eod = locala.KhF.xS();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwh
 * JD-Core Version:    0.7.0.1
 */