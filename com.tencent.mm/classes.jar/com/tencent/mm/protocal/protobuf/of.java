package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class of
  extends com.tencent.mm.bw.a
{
  public String Ean;
  public int Ecj;
  public int Eck;
  public int Eed;
  public String Eee;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ecj);
      paramVarArgs.aR(2, this.Eck);
      paramVarArgs.aR(3, this.Eed);
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.Eee != null) {
        paramVarArgs.d(5, this.Eee);
      }
      if (this.Ean != null) {
        paramVarArgs.d(6, this.Ean);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ecj) + 0 + f.a.a.b.b.a.bx(2, this.Eck) + f.a.a.b.b.a.bx(3, this.Eed);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.Eee != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eee);
      }
      paramInt = i;
      if (this.Ean != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ean);
      }
      AppMethodBeat.o(124464);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      of localof = (of)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localof.Ecj = locala.LVo.xF();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localof.Eck = locala.LVo.xF();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localof.Eed = locala.LVo.xF();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localof.Title = locala.LVo.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localof.Eee = locala.LVo.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localof.Ean = locala.LVo.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.of
 * JD-Core Version:    0.7.0.1
 */