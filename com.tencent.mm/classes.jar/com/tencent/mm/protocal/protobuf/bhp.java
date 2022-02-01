package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bhp
  extends com.tencent.mm.bx.a
{
  public long DFv;
  public int DFw;
  public int key;
  public int length;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111786);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.key);
      paramVarArgs.aG(2, this.DFv);
      paramVarArgs.aR(3, this.length);
      paramVarArgs.aR(4, this.DFw);
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.key);
      int i = f.a.a.b.b.a.q(2, this.DFv);
      int j = f.a.a.b.b.a.bA(3, this.length);
      int k = f.a.a.b.b.a.bA(4, this.DFw);
      AppMethodBeat.o(111786);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(111786);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bhp localbhp = (bhp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111786);
        return -1;
      case 1: 
        localbhp.key = locala.KhF.xS();
        AppMethodBeat.o(111786);
        return 0;
      case 2: 
        localbhp.DFv = locala.KhF.xT();
        AppMethodBeat.o(111786);
        return 0;
      case 3: 
        localbhp.length = locala.KhF.xS();
        AppMethodBeat.o(111786);
        return 0;
      }
      localbhp.DFw = locala.KhF.xS();
      AppMethodBeat.o(111786);
      return 0;
    }
    AppMethodBeat.o(111786);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhp
 * JD-Core Version:    0.7.0.1
 */