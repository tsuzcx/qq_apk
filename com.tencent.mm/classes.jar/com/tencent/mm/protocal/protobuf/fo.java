package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fo
  extends com.tencent.mm.bw.a
{
  public long FQj;
  public int FQk;
  public String FQl;
  public int FQm;
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
      paramVarArgs.aZ(2, this.FQj);
      paramVarArgs.aS(3, this.FQk);
      if (this.FQl != null) {
        paramVarArgs.d(4, this.FQl);
      }
      paramVarArgs.aS(5, this.Scene);
      paramVarArgs.aS(6, this.FQm);
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
      int i = paramInt + f.a.a.b.b.a.p(2, this.FQj) + f.a.a.b.b.a.bz(3, this.FQk);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FQl);
      }
      i = f.a.a.b.b.a.bz(5, this.Scene);
      int j = f.a.a.b.b.a.bz(6, this.FQm);
      AppMethodBeat.o(6390);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localfo.Url = locala.OmT.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 2: 
          localfo.FQj = locala.OmT.zd();
          AppMethodBeat.o(6390);
          return 0;
        case 3: 
          localfo.FQk = locala.OmT.zc();
          AppMethodBeat.o(6390);
          return 0;
        case 4: 
          localfo.FQl = locala.OmT.readString();
          AppMethodBeat.o(6390);
          return 0;
        case 5: 
          localfo.Scene = locala.OmT.zc();
          AppMethodBeat.o(6390);
          return 0;
        }
        localfo.FQm = locala.OmT.zc();
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