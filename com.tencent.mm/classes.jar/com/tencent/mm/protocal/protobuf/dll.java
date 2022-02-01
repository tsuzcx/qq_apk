package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dll
  extends com.tencent.mm.bx.a
{
  public String GNH;
  public int HzV;
  public int HzW;
  public String iht;
  public String ujc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GNH != null) {
        paramVarArgs.d(1, this.GNH);
      }
      paramVarArgs.aS(2, this.HzV);
      paramVarArgs.aS(3, this.HzW);
      if (this.ujc != null) {
        paramVarArgs.d(4, this.ujc);
      }
      if (this.iht != null) {
        paramVarArgs.d(5, this.iht);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GNH == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.GNH) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HzV) + f.a.a.b.b.a.bz(3, this.HzW);
      paramInt = i;
      if (this.ujc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ujc);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iht);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dll localdll = (dll)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localdll.GNH = locala.NPN.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localdll.HzV = locala.NPN.zc();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localdll.HzW = locala.NPN.zc();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localdll.ujc = locala.NPN.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localdll.iht = locala.NPN.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dll
 * JD-Core Version:    0.7.0.1
 */