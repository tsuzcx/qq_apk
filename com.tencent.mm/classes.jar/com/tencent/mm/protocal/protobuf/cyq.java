package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyq
  extends com.tencent.mm.bx.a
{
  public String HpD;
  public int HpE;
  public String dzn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HpD != null) {
        paramVarArgs.d(1, this.HpD);
      }
      if (this.dzn != null) {
        paramVarArgs.d(2, this.dzn);
      }
      paramVarArgs.aS(3, this.HpE);
      AppMethodBeat.o(152686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HpD == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HpD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dzn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dzn);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HpE);
      AppMethodBeat.o(152686);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152686);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyq localcyq = (cyq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152686);
          return -1;
        case 1: 
          localcyq.HpD = locala.NPN.readString();
          AppMethodBeat.o(152686);
          return 0;
        case 2: 
          localcyq.dzn = locala.NPN.readString();
          AppMethodBeat.o(152686);
          return 0;
        }
        localcyq.HpE = locala.NPN.zc();
        AppMethodBeat.o(152686);
        return 0;
      }
      AppMethodBeat.o(152686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyq
 * JD-Core Version:    0.7.0.1
 */