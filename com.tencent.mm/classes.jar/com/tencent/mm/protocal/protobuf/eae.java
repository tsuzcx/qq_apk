package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eae
  extends com.tencent.mm.bw.a
{
  public int Igd;
  public int Ige;
  public int Igf;
  public int Igg;
  public int Igh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Igd);
      paramVarArgs.aS(2, this.Ige);
      paramVarArgs.aS(3, this.Igf);
      paramVarArgs.aS(4, this.Igg);
      paramVarArgs.aS(5, this.Igh);
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Igd);
      int i = f.a.a.b.b.a.bz(2, this.Ige);
      int j = f.a.a.b.b.a.bz(3, this.Igf);
      int k = f.a.a.b.b.a.bz(4, this.Igg);
      int m = f.a.a.b.b.a.bz(5, this.Igh);
      AppMethodBeat.o(115910);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115910);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eae localeae = (eae)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115910);
        return -1;
      case 1: 
        localeae.Igd = locala.OmT.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 2: 
        localeae.Ige = locala.OmT.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 3: 
        localeae.Igf = locala.OmT.zc();
        AppMethodBeat.o(115910);
        return 0;
      case 4: 
        localeae.Igg = locala.OmT.zc();
        AppMethodBeat.o(115910);
        return 0;
      }
      localeae.Igh = locala.OmT.zc();
      AppMethodBeat.o(115910);
      return 0;
    }
    AppMethodBeat.o(115910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eae
 * JD-Core Version:    0.7.0.1
 */