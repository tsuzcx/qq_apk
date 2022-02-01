package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgg
  extends com.tencent.mm.bx.a
{
  public int GZs;
  public int GZt;
  public String dHX;
  public String ozE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      if (this.ozE != null) {
        paramVarArgs.d(2, this.ozE);
      }
      paramVarArgs.aS(3, this.GZs);
      paramVarArgs.aS(4, this.GZt);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.dHX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ozE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ozE);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GZs);
      int j = f.a.a.b.b.a.bz(4, this.GZt);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgg localcgg = (cgg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localcgg.dHX = locala.NPN.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localcgg.ozE = locala.NPN.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localcgg.GZs = locala.NPN.zc();
          AppMethodBeat.o(114046);
          return 0;
        }
        localcgg.GZt = locala.NPN.zc();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgg
 * JD-Core Version:    0.7.0.1
 */