package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehk
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public int HeR;
  public int Hko;
  public int Hkp;
  public String Hkq;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HeR);
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.Scene);
      if (this.Hkq != null) {
        paramVarArgs.d(4, this.Hkq);
      }
      paramVarArgs.aS(5, this.Hkp);
      paramVarArgs.aS(6, this.Hko);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HeR) + 0 + f.a.a.b.b.a.bz(2, this.FYj) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.Hkq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hkq);
      }
      i = f.a.a.b.b.a.bz(5, this.Hkp);
      int j = f.a.a.b.b.a.bz(6, this.Hko);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehk localehk = (ehk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localehk.HeR = locala.OmT.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localehk.FYj = locala.OmT.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localehk.Scene = locala.OmT.zc();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localehk.Hkq = locala.OmT.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localehk.Hkp = locala.OmT.zc();
        AppMethodBeat.o(123683);
        return 0;
      }
      localehk.Hko = locala.OmT.zc();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehk
 * JD-Core Version:    0.7.0.1
 */