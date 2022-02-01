package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eip
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int HeR;
  public int Hko;
  public int Hkp;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HeR);
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.aS(5, this.Hkp);
      paramVarArgs.aS(6, this.Hko);
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HeR);
      int i = f.a.a.b.b.a.bz(2, this.FYj);
      int j = f.a.a.b.b.a.bz(3, this.Scene);
      int k = f.a.a.b.b.a.bz(5, this.Hkp);
      int m = f.a.a.b.b.a.bz(6, this.Hko);
      AppMethodBeat.o(50118);
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
      AppMethodBeat.o(50118);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eip localeip = (eip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      default: 
        AppMethodBeat.o(50118);
        return -1;
      case 1: 
        localeip.HeR = locala.OmT.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 2: 
        localeip.FYj = locala.OmT.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 3: 
        localeip.Scene = locala.OmT.zc();
        AppMethodBeat.o(50118);
        return 0;
      case 5: 
        localeip.Hkp = locala.OmT.zc();
        AppMethodBeat.o(50118);
        return 0;
      }
      localeip.Hko = locala.OmT.zc();
      AppMethodBeat.o(50118);
      return 0;
    }
    AppMethodBeat.o(50118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eip
 * JD-Core Version:    0.7.0.1
 */