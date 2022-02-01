package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnc
  extends com.tencent.mm.bw.a
{
  public int Hao;
  public int Hap;
  public boolean Haq;
  public boolean Har;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hao);
      paramVarArgs.aS(2, this.Hap);
      paramVarArgs.bC(3, this.Haq);
      paramVarArgs.bC(4, this.Har);
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hao);
      int i = f.a.a.b.b.a.bz(2, this.Hap);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(50094);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bnc localbnc = (bnc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50094);
        return -1;
      case 1: 
        localbnc.Hao = locala.OmT.zc();
        AppMethodBeat.o(50094);
        return 0;
      case 2: 
        localbnc.Hap = locala.OmT.zc();
        AppMethodBeat.o(50094);
        return 0;
      case 3: 
        localbnc.Haq = locala.OmT.gvY();
        AppMethodBeat.o(50094);
        return 0;
      }
      localbnc.Har = locala.OmT.gvY();
      AppMethodBeat.o(50094);
      return 0;
    }
    AppMethodBeat.o(50094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnc
 * JD-Core Version:    0.7.0.1
 */