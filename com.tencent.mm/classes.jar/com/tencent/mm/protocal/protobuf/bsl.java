package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bsl
  extends com.tencent.mm.bx.a
{
  public int GNa;
  public b GNb;
  public int GNh;
  public int GNi;
  public int nDi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GNa);
      if (this.GNb != null) {
        paramVarArgs.c(2, this.GNb);
      }
      paramVarArgs.aS(3, this.GNh);
      paramVarArgs.aS(4, this.nDi);
      paramVarArgs.aS(5, this.GNi);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GNa) + 0;
      paramInt = i;
      if (this.GNb != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GNb);
      }
      i = f.a.a.b.b.a.bz(3, this.GNh);
      int j = f.a.a.b.b.a.bz(4, this.nDi);
      int k = f.a.a.b.b.a.bz(5, this.GNi);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsl localbsl = (bsl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localbsl.GNa = locala.NPN.zc();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localbsl.GNb = locala.NPN.gxI();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localbsl.GNh = locala.NPN.zc();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localbsl.nDi = locala.NPN.zc();
        AppMethodBeat.o(116337);
        return 0;
      }
      localbsl.GNi = locala.NPN.zc();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsl
 * JD-Core Version:    0.7.0.1
 */