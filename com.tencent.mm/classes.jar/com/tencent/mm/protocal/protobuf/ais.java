package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ais
  extends com.tencent.mm.bw.a
{
  public int Gyx;
  public String Name;
  public long pXC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.pXC);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aS(3, this.Gyx);
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.pXC) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = f.a.a.b.b.a.bz(3, this.Gyx);
      AppMethodBeat.o(155404);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ais localais = (ais)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155404);
        return -1;
      case 1: 
        localais.pXC = locala.OmT.zd();
        AppMethodBeat.o(155404);
        return 0;
      case 2: 
        localais.Name = locala.OmT.readString();
        AppMethodBeat.o(155404);
        return 0;
      }
      localais.Gyx = locala.OmT.zc();
      AppMethodBeat.o(155404);
      return 0;
    }
    AppMethodBeat.o(155404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ais
 * JD-Core Version:    0.7.0.1
 */