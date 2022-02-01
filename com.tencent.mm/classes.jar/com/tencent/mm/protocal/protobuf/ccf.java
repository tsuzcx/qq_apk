package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccf
  extends com.tencent.mm.bx.a
{
  public int ugm;
  public String uki;
  public String ukj;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ukj != null) {
        paramVarArgs.d(1, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(2, this.uki);
      }
      paramVarArgs.aS(3, this.xbr);
      paramVarArgs.aS(4, this.ugm);
      paramVarArgs.aY(5, this.xbt);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukj == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.ukj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uki);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.xbr);
      int j = f.a.a.b.b.a.bz(4, this.ugm);
      int k = f.a.a.b.b.a.p(5, this.xbt);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccf localccf = (ccf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localccf.ukj = locala.NPN.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localccf.uki = locala.NPN.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localccf.xbr = locala.NPN.zc();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localccf.ugm = locala.NPN.zc();
          AppMethodBeat.o(43113);
          return 0;
        }
        localccf.xbt = locala.NPN.zd();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccf
 * JD-Core Version:    0.7.0.1
 */