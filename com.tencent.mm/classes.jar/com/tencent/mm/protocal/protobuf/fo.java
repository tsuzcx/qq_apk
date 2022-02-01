package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fo
  extends com.tencent.mm.bx.a
{
  public long FxL;
  public int FxM;
  public String FxN;
  public int FxO;
  public int Scene;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aY(2, this.FxL);
      paramVarArgs.aS(3, this.FxM);
      if (this.FxN != null) {
        paramVarArgs.d(4, this.FxN);
      }
      paramVarArgs.aS(5, this.Scene);
      paramVarArgs.aS(6, this.FxO);
      AppMethodBeat.o(6390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FxL) + f.a.a.b.b.a.bz(3, this.FxM);
      paramInt = i;
      if (this.FxN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FxN);
      }
      i = f.a.a.b.b.a.bz(5, this.Scene);
      int j = f.a.a.b.b.a.bz(6, this.FxO);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6390);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fo localfo = (fo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6390);
          return -1;
        case 1: 
          localfo.Url = locala.NPN.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localfo.FxL = locala.NPN.zd();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localfo.FxM = locala.NPN.zc();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localfo.FxN = locala.NPN.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localfo.Scene = locala.NPN.zc();
          AppMethodBeat.o(6390);
          return 0;
        }
        localfo.FxO = locala.NPN.zc();
        AppMethodBeat.o(6390);
        return 0;
      }
      AppMethodBeat.o(6390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fo
 * JD-Core Version:    0.7.0.1
 */