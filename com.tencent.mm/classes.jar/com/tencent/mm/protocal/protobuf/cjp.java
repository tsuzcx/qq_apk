package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cjp
  extends com.tencent.mm.bx.a
{
  public int Hds;
  public String Hdt;
  public String hCV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hds);
      if (this.Hdt != null) {
        paramVarArgs.d(2, this.Hdt);
      }
      if (this.hCV != null) {
        paramVarArgs.d(3, this.hCV);
      }
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hds) + 0;
      paramInt = i;
      if (this.Hdt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hdt);
      }
      i = paramInt;
      if (this.hCV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCV);
      }
      AppMethodBeat.o(124538);
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
      AppMethodBeat.o(124538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cjp localcjp = (cjp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124538);
        return -1;
      case 1: 
        localcjp.Hds = locala.NPN.zc();
        AppMethodBeat.o(124538);
        return 0;
      case 2: 
        localcjp.Hdt = locala.NPN.readString();
        AppMethodBeat.o(124538);
        return 0;
      }
      localcjp.hCV = locala.NPN.readString();
      AppMethodBeat.o(124538);
      return 0;
    }
    AppMethodBeat.o(124538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjp
 * JD-Core Version:    0.7.0.1
 */