package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nu
  extends com.tencent.mm.bx.a
{
  public String FFW;
  public int FIf;
  public int FIg;
  public long FIh;
  public String FIi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FIf);
      paramVarArgs.aS(2, this.FIg);
      paramVarArgs.aY(3, this.FIh);
      if (this.FIi != null) {
        paramVarArgs.d(4, this.FIi);
      }
      if (this.FFW != null) {
        paramVarArgs.d(5, this.FFW);
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FIf) + 0 + f.a.a.b.b.a.bz(2, this.FIg) + f.a.a.b.b.a.p(3, this.FIh);
      paramInt = i;
      if (this.FIi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FIi);
      }
      i = paramInt;
      if (this.FFW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FFW);
      }
      AppMethodBeat.o(124433);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124433);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      nu localnu = (nu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124433);
        return -1;
      case 1: 
        localnu.FIf = locala.NPN.zc();
        AppMethodBeat.o(124433);
        return 0;
      case 2: 
        localnu.FIg = locala.NPN.zc();
        AppMethodBeat.o(124433);
        return 0;
      case 3: 
        localnu.FIh = locala.NPN.zd();
        AppMethodBeat.o(124433);
        return 0;
      case 4: 
        localnu.FIi = locala.NPN.readString();
        AppMethodBeat.o(124433);
        return 0;
      }
      localnu.FFW = locala.NPN.readString();
      AppMethodBeat.o(124433);
      return 0;
    }
    AppMethodBeat.o(124433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nu
 * JD-Core Version:    0.7.0.1
 */