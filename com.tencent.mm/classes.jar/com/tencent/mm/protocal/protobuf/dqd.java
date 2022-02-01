package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dqd
  extends com.tencent.mm.bx.a
{
  public b HEn;
  public String HEo;
  public b HEp;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HEn != null) {
        paramVarArgs.c(1, this.HEn);
      }
      if (this.HEo != null) {
        paramVarArgs.d(2, this.HEo);
      }
      if (this.HEp != null) {
        paramVarArgs.c(3, this.HEp);
      }
      paramVarArgs.aS(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HEn == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.b(1, this.HEn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HEo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEo);
      }
      i = paramInt;
      if (this.HEp != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HEp);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqd localdqd = (dqd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localdqd.HEn = locala.NPN.gxI();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localdqd.HEo = locala.NPN.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localdqd.HEp = locala.NPN.gxI();
          AppMethodBeat.o(82480);
          return 0;
        }
        localdqd.uin = locala.NPN.zc();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqd
 * JD-Core Version:    0.7.0.1
 */