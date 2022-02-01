package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhz
  extends com.tencent.mm.bx.a
{
  public String HwN;
  public boolean HwO;
  public boolean HwP;
  public String appName;
  public int cbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HwN != null) {
        paramVarArgs.d(1, this.HwN);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      paramVarArgs.aS(3, this.cbX);
      paramVarArgs.bt(4, this.HwO);
      paramVarArgs.bt(5, this.HwP);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HwN == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.HwN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appName);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.cbX);
      int j = f.a.a.b.b.a.alV(4);
      int k = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(116816);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dhz localdhz = (dhz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localdhz.HwN = locala.NPN.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localdhz.appName = locala.NPN.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localdhz.cbX = locala.NPN.zc();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localdhz.HwO = locala.NPN.grw();
          AppMethodBeat.o(116816);
          return 0;
        }
        localdhz.HwP = locala.NPN.grw();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhz
 * JD-Core Version:    0.7.0.1
 */