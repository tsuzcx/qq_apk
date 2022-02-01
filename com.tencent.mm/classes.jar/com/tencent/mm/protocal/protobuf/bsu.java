package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsu
  extends com.tencent.mm.bw.a
{
  public String EfU;
  public String FhN;
  public long FhO;
  public long FhP;
  public int ndI;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.scene);
      if (this.FhN != null) {
        paramVarArgs.d(2, this.FhN);
      }
      paramVarArgs.aO(3, this.FhO);
      paramVarArgs.aO(4, this.FhP);
      if (this.EfU != null) {
        paramVarArgs.d(5, this.EfU);
      }
      paramVarArgs.aR(6, this.ndI);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.scene) + 0;
      paramInt = i;
      if (this.FhN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FhN);
      }
      i = paramInt + f.a.a.b.b.a.p(3, this.FhO) + f.a.a.b.b.a.p(4, this.FhP);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EfU);
      }
      i = f.a.a.b.b.a.bx(6, this.ndI);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsu localbsu = (bsu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localbsu.scene = locala.LVo.xF();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localbsu.FhN = locala.LVo.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localbsu.FhO = locala.LVo.xG();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localbsu.FhP = locala.LVo.xG();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localbsu.EfU = locala.LVo.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localbsu.ndI = locala.LVo.xF();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsu
 * JD-Core Version:    0.7.0.1
 */