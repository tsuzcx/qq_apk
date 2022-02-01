package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class cap
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public int GVf;
  public int GVg;
  public b GVh;
  public String GVi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32353);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GVf);
      paramVarArgs.aS(2, this.GVg);
      if (this.GVh != null) {
        paramVarArgs.c(3, this.GVh);
      }
      if (this.GVi != null) {
        paramVarArgs.d(4, this.GVi);
      }
      if (this.FVo != null) {
        paramVarArgs.d(5, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(6, this.FVp);
      }
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GVf) + 0 + f.a.a.b.b.a.bz(2, this.GVg);
      paramInt = i;
      if (this.GVh != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GVh);
      }
      i = paramInt;
      if (this.GVi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GVi);
      }
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FVp);
      }
      AppMethodBeat.o(32353);
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
      AppMethodBeat.o(32353);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cap localcap = (cap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32353);
        return -1;
      case 1: 
        localcap.GVf = locala.NPN.zc();
        AppMethodBeat.o(32353);
        return 0;
      case 2: 
        localcap.GVg = locala.NPN.zc();
        AppMethodBeat.o(32353);
        return 0;
      case 3: 
        localcap.GVh = locala.NPN.gxI();
        AppMethodBeat.o(32353);
        return 0;
      case 4: 
        localcap.GVi = locala.NPN.readString();
        AppMethodBeat.o(32353);
        return 0;
      case 5: 
        localcap.FVo = locala.NPN.readString();
        AppMethodBeat.o(32353);
        return 0;
      }
      localcap.FVp = locala.NPN.readString();
      AppMethodBeat.o(32353);
      return 0;
    }
    AppMethodBeat.o(32353);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cap
 * JD-Core Version:    0.7.0.1
 */