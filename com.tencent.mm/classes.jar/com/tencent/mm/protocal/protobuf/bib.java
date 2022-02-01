package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bib
  extends com.tencent.mm.bx.a
{
  public String GCZ;
  public int GDa;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      if (this.GCZ != null) {
        paramVarArgs.d(2, this.GCZ);
      }
      paramVarArgs.aS(3, this.GDa);
      AppMethodBeat.o(217652);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0;
      paramInt = i;
      if (this.GCZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GCZ);
      }
      i = f.a.a.b.b.a.bz(3, this.GDa);
      AppMethodBeat.o(217652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(217652);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bib localbib = (bib)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217652);
        return -1;
      case 1: 
        localbib.Scene = locala.NPN.zc();
        AppMethodBeat.o(217652);
        return 0;
      case 2: 
        localbib.GCZ = locala.NPN.readString();
        AppMethodBeat.o(217652);
        return 0;
      }
      localbib.GDa = locala.NPN.zc();
      AppMethodBeat.o(217652);
      return 0;
    }
    AppMethodBeat.o(217652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bib
 * JD-Core Version:    0.7.0.1
 */