package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eey
  extends com.tencent.mm.bx.a
{
  public String HQo;
  public boolean HQp;
  public int HQq;
  public int HQr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQo != null) {
        paramVarArgs.d(1, this.HQo);
      }
      paramVarArgs.bt(2, this.HQp);
      paramVarArgs.aS(3, this.HQq);
      paramVarArgs.aS(4, this.HQr);
      AppMethodBeat.o(110856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQo == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = f.a.a.b.b.a.e(1, this.HQo) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.bz(3, this.HQq);
      int k = f.a.a.b.b.a.bz(4, this.HQr);
      AppMethodBeat.o(110856);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(110856);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eey localeey = (eey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110856);
          return -1;
        case 1: 
          localeey.HQo = locala.NPN.readString();
          AppMethodBeat.o(110856);
          return 0;
        case 2: 
          localeey.HQp = locala.NPN.grw();
          AppMethodBeat.o(110856);
          return 0;
        case 3: 
          localeey.HQq = locala.NPN.zc();
          AppMethodBeat.o(110856);
          return 0;
        }
        localeey.HQr = locala.NPN.zc();
        AppMethodBeat.o(110856);
        return 0;
      }
      AppMethodBeat.o(110856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eey
 * JD-Core Version:    0.7.0.1
 */