package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pk
  extends com.tencent.mm.bx.a
{
  public String FFW;
  public int FIf;
  public int FIg;
  public int FKC;
  public String FKD;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FIf);
      paramVarArgs.aS(2, this.FIg);
      paramVarArgs.aS(3, this.FKC);
      if (this.Title != null) {
        paramVarArgs.d(4, this.Title);
      }
      if (this.FKD != null) {
        paramVarArgs.d(5, this.FKD);
      }
      if (this.FFW != null) {
        paramVarArgs.d(6, this.FFW);
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FIf) + 0 + f.a.a.b.b.a.bz(2, this.FIg) + f.a.a.b.b.a.bz(3, this.FKC);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Title);
      }
      i = paramInt;
      if (this.FKD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FKD);
      }
      paramInt = i;
      if (this.FFW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FFW);
      }
      AppMethodBeat.o(124464);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(124464);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pk localpk = (pk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124464);
        return -1;
      case 1: 
        localpk.FIf = locala.NPN.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 2: 
        localpk.FIg = locala.NPN.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 3: 
        localpk.FKC = locala.NPN.zc();
        AppMethodBeat.o(124464);
        return 0;
      case 4: 
        localpk.Title = locala.NPN.readString();
        AppMethodBeat.o(124464);
        return 0;
      case 5: 
        localpk.FKD = locala.NPN.readString();
        AppMethodBeat.o(124464);
        return 0;
      }
      localpk.FFW = locala.NPN.readString();
      AppMethodBeat.o(124464);
      return 0;
    }
    AppMethodBeat.o(124464);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pk
 * JD-Core Version:    0.7.0.1
 */