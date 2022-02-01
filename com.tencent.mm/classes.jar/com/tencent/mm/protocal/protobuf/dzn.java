package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzn
  extends com.tencent.mm.bw.a
{
  public String ETZ;
  public String EUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ETZ != null) {
        paramVarArgs.d(1, this.ETZ);
      }
      if (this.EUa != null) {
        paramVarArgs.d(2, this.EUa);
      }
      AppMethodBeat.o(133208);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ETZ == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.ETZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EUa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EUa);
      }
      AppMethodBeat.o(133208);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133208);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzn localdzn = (dzn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133208);
          return -1;
        case 1: 
          localdzn.ETZ = locala.LVo.readString();
          AppMethodBeat.o(133208);
          return 0;
        }
        localdzn.EUa = locala.LVo.readString();
        AppMethodBeat.o(133208);
        return 0;
      }
      AppMethodBeat.o(133208);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */