package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int FoM;
  public com.tencent.mm.bx.b FoV;
  public int FoW;
  public int count;
  public int yMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FoV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.FoM);
      if (this.FoV != null) {
        paramVarArgs.c(2, this.FoV);
      }
      paramVarArgs.aS(3, this.FoW);
      paramVarArgs.aS(4, this.yMB);
      paramVarArgs.aS(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FoM) + 0;
      paramInt = i;
      if (this.FoV != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FoV);
      }
      i = f.a.a.b.b.a.bz(3, this.FoW);
      int j = f.a.a.b.b.a.bz(4, this.yMB);
      int k = f.a.a.b.b.a.bz(5, this.count);
      AppMethodBeat.o(143943);
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
      if (this.FoV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.FoM = locala.NPN.zc();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.FoV = locala.NPN.gxI();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.FoW = locala.NPN.zc();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.yMB = locala.NPN.zc();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.NPN.zc();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */