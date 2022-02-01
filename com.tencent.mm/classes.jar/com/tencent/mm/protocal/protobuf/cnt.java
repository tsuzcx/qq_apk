package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnt
  extends com.tencent.mm.bx.a
{
  public int GeL;
  public String GrE;
  public int GrW;
  public int HgT;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GrW);
      if (this.GrE != null) {
        paramVarArgs.d(2, this.GrE);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aS(4, this.GeL);
      paramVarArgs.aS(5, this.HgT);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GrW) + 0;
      paramInt = i;
      if (this.GrE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GrE);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GeL);
      int j = f.a.a.b.b.a.bz(5, this.HgT);
      AppMethodBeat.o(155451);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnt localcnt = (cnt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localcnt.GrW = locala.NPN.zc();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localcnt.GrE = locala.NPN.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localcnt.MD5 = locala.NPN.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localcnt.GeL = locala.NPN.zc();
        AppMethodBeat.o(155451);
        return 0;
      }
      localcnt.HgT = locala.NPN.zc();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnt
 * JD-Core Version:    0.7.0.1
 */