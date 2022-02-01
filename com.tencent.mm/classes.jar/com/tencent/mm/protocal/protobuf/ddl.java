package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddl
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String CCm;
  public int Evm;
  public int Evn;
  public long rNY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Evm);
      if (this.CCm != null) {
        paramVarArgs.d(2, this.CCm);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(3, this.AesKey);
      }
      paramVarArgs.aR(4, this.Evn);
      paramVarArgs.aG(5, this.rNY);
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Evm) + 0;
      paramInt = i;
      if (this.CCm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CCm);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.AesKey);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Evn);
      int j = f.a.a.b.b.a.q(5, this.rNY);
      AppMethodBeat.o(127506);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127506);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ddl localddl = (ddl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127506);
        return -1;
      case 1: 
        localddl.Evm = locala.KhF.xS();
        AppMethodBeat.o(127506);
        return 0;
      case 2: 
        localddl.CCm = locala.KhF.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 3: 
        localddl.AesKey = locala.KhF.readString();
        AppMethodBeat.o(127506);
        return 0;
      case 4: 
        localddl.Evn = locala.KhF.xS();
        AppMethodBeat.o(127506);
        return 0;
      }
      localddl.rNY = locala.KhF.xT();
      AppMethodBeat.o(127506);
      return 0;
    }
    AppMethodBeat.o(127506);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddl
 * JD-Core Version:    0.7.0.1
 */