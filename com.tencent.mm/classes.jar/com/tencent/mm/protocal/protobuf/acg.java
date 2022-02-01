package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acg
  extends com.tencent.mm.bx.a
{
  public int jdq;
  public String jdr;
  public String jds;
  public String jdt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.jdq);
      if (this.jdr != null) {
        paramVarArgs.d(2, this.jdr);
      }
      if (this.jds != null) {
        paramVarArgs.d(3, this.jds);
      }
      if (this.jdt != null) {
        paramVarArgs.d(4, this.jdt);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.jdq) + 0;
      paramInt = i;
      if (this.jdr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jdr);
      }
      i = paramInt;
      if (this.jds != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jds);
      }
      paramInt = i;
      if (this.jdt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jdt);
      }
      AppMethodBeat.o(117864);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acg localacg = (acg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localacg.jdq = locala.NPN.zc();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localacg.jdr = locala.NPN.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localacg.jds = locala.NPN.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localacg.jdt = locala.NPN.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acg
 * JD-Core Version:    0.7.0.1
 */