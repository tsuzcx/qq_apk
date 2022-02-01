package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eff
  extends com.tencent.mm.bx.a
{
  public int FKN;
  public String HQB;
  public String duW;
  public String xcP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      paramVarArgs.aS(2, this.FKN);
      if (this.HQB != null) {
        paramVarArgs.d(3, this.HQB);
      }
      if (this.xcP != null) {
        paramVarArgs.d(4, this.xcP);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FKN);
      paramInt = i;
      if (this.HQB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HQB);
      }
      i = paramInt;
      if (this.xcP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xcP);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eff localeff = (eff)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localeff.duW = locala.NPN.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localeff.FKN = locala.NPN.zc();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localeff.HQB = locala.NPN.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localeff.xcP = locala.NPN.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eff
 * JD-Core Version:    0.7.0.1
 */