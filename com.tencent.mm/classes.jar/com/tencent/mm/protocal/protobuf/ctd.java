package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ctd
  extends com.tencent.mm.bx.a
{
  public b Gcf;
  public int HfH;
  public String Hlt;
  public int nEf;
  public int qex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hlt != null) {
        paramVarArgs.d(1, this.Hlt);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.qex);
      paramVarArgs.aS(4, this.HfH);
      if (this.Gcf != null) {
        paramVarArgs.c(5, this.Gcf);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hlt == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hlt) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.qex) + f.a.a.b.b.a.bz(4, this.HfH);
      paramInt = i;
      if (this.Gcf != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Gcf);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctd localctd = (ctd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localctd.Hlt = locala.NPN.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localctd.nEf = locala.NPN.zc();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localctd.qex = locala.NPN.zc();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localctd.HfH = locala.NPN.zc();
          AppMethodBeat.o(138185);
          return 0;
        }
        localctd.Gcf = locala.NPN.gxI();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctd
 * JD-Core Version:    0.7.0.1
 */