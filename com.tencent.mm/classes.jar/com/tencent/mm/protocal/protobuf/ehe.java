package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ehe
  extends com.tencent.mm.bx.a
{
  public boolean HRN;
  public String HRV;
  public b HRW;
  public int HRX;
  public int HRY;
  public int HRZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.HRN);
      if (this.HRV != null) {
        paramVarArgs.d(2, this.HRV);
      }
      if (this.HRW != null) {
        paramVarArgs.c(3, this.HRW);
      }
      paramVarArgs.aS(4, this.HRX);
      paramVarArgs.aS(5, this.HRY);
      paramVarArgs.aS(6, this.HRZ);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.HRV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HRV);
      }
      i = paramInt;
      if (this.HRW != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HRW);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HRX);
      int j = f.a.a.b.b.a.bz(5, this.HRY);
      int k = f.a.a.b.b.a.bz(6, this.HRZ);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehe localehe = (ehe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localehe.HRN = locala.NPN.grw();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localehe.HRV = locala.NPN.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localehe.HRW = locala.NPN.gxI();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localehe.HRX = locala.NPN.zc();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localehe.HRY = locala.NPN.zc();
        AppMethodBeat.o(50123);
        return 0;
      }
      localehe.HRZ = locala.NPN.zc();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehe
 * JD-Core Version:    0.7.0.1
 */