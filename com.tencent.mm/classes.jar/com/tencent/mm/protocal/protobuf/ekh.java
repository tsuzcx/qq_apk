package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekh
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int HeR;
  public int Inm;
  public int Inn;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HeR);
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.Inm);
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(10, this.Inn);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HeR);
      int i = f.a.a.b.b.a.bz(2, this.FYj);
      int j = f.a.a.b.b.a.bz(3, this.Inm);
      int k = f.a.a.b.b.a.bz(4, this.Scene);
      int m = f.a.a.b.b.a.bz(10, this.Inn);
      AppMethodBeat.o(123712);
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
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ekh localekh = (ekh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localekh.HeR = locala.OmT.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localekh.FYj = locala.OmT.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localekh.Inm = locala.OmT.zc();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localekh.Scene = locala.OmT.zc();
        AppMethodBeat.o(123712);
        return 0;
      }
      localekh.Inn = locala.OmT.zc();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekh
 * JD-Core Version:    0.7.0.1
 */