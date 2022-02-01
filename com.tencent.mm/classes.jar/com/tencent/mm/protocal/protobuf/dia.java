package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dia
  extends com.tencent.mm.bw.a
{
  public int HPm;
  public int HPn;
  public int jgg;
  public String jgh;
  public long jgi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.jgg);
      if (this.jgh != null) {
        paramVarArgs.d(2, this.jgh);
      }
      paramVarArgs.aZ(3, this.jgi);
      paramVarArgs.aS(4, this.HPm);
      paramVarArgs.aS(5, this.HPn);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.jgg) + 0;
      paramInt = i;
      if (this.jgh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jgh);
      }
      i = f.a.a.b.b.a.p(3, this.jgi);
      int j = f.a.a.b.b.a.bz(4, this.HPm);
      int k = f.a.a.b.b.a.bz(5, this.HPn);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dia localdia = (dia)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localdia.jgg = locala.OmT.zc();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localdia.jgh = locala.OmT.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localdia.jgi = locala.OmT.zd();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localdia.HPm = locala.OmT.zc();
        AppMethodBeat.o(43131);
        return 0;
      }
      localdia.HPn = locala.OmT.zc();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dia
 * JD-Core Version:    0.7.0.1
 */