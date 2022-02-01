package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efg
  extends com.tencent.mm.bx.a
{
  public int FKM;
  public int HQC;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123680);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HQC);
      paramVarArgs.aS(2, this.FKM);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HQC) + 0 + f.a.a.b.b.a.bz(2, this.FKM);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.md5);
      }
      AppMethodBeat.o(123680);
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
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efg localefg = (efg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123680);
        return -1;
      case 1: 
        localefg.HQC = locala.NPN.zc();
        AppMethodBeat.o(123680);
        return 0;
      case 2: 
        localefg.FKM = locala.NPN.zc();
        AppMethodBeat.o(123680);
        return 0;
      case 3: 
        localefg.url = locala.NPN.readString();
        AppMethodBeat.o(123680);
        return 0;
      }
      localefg.md5 = locala.NPN.readString();
      AppMethodBeat.o(123680);
      return 0;
    }
    AppMethodBeat.o(123680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efg
 * JD-Core Version:    0.7.0.1
 */