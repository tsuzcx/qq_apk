package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ada
  extends com.tencent.mm.bx.a
{
  public int DdH;
  public String MD5;
  public int Ret;
  public int uKQ;
  public int uKR;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.aR(5, this.DdH);
      paramVarArgs.aG(6, this.uKZ);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ret) + 0 + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = f.a.a.b.b.a.bA(5, this.DdH);
      int j = f.a.a.b.b.a.q(6, this.uKZ);
      AppMethodBeat.o(109447);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ada localada = (ada)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localada.Ret = locala.KhF.xS();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localada.uKR = locala.KhF.xS();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localada.uKQ = locala.KhF.xS();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localada.MD5 = locala.KhF.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localada.DdH = locala.KhF.xS();
        AppMethodBeat.o(109447);
        return 0;
      }
      localada.uKZ = locala.KhF.xT();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ada
 * JD-Core Version:    0.7.0.1
 */