package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eao
  extends com.tencent.mm.bw.a
{
  public int DPJ;
  public int Fho;
  public int Ggp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fho);
      paramVarArgs.aR(2, this.DPJ);
      paramVarArgs.aR(3, this.Ggp);
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Fho);
      int i = f.a.a.b.b.a.bx(2, this.DPJ);
      int j = f.a.a.b.b.a.bx(3, this.Ggp);
      AppMethodBeat.o(123703);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eao localeao = (eao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123703);
        return -1;
      case 1: 
        localeao.Fho = locala.LVo.xF();
        AppMethodBeat.o(123703);
        return 0;
      case 2: 
        localeao.DPJ = locala.LVo.xF();
        AppMethodBeat.o(123703);
        return 0;
      }
      localeao.Ggp = locala.LVo.xF();
      AppMethodBeat.o(123703);
      return 0;
    }
    AppMethodBeat.o(123703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eao
 * JD-Core Version:    0.7.0.1
 */