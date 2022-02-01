package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzp
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public int FbR;
  public int Fhl;
  public int Fhm;
  public String Fhn;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FbR);
      paramVarArgs.aR(2, this.Eae);
      paramVarArgs.aR(3, this.Scene);
      if (this.Fhn != null) {
        paramVarArgs.d(4, this.Fhn);
      }
      paramVarArgs.aR(5, this.Fhm);
      paramVarArgs.aR(6, this.Fhl);
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FbR) + 0 + f.a.a.b.b.a.bx(2, this.Eae) + f.a.a.b.b.a.bx(3, this.Scene);
      paramInt = i;
      if (this.Fhn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fhn);
      }
      i = f.a.a.b.b.a.bx(5, this.Fhm);
      int j = f.a.a.b.b.a.bx(6, this.Fhl);
      AppMethodBeat.o(123683);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123683);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzp localdzp = (dzp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123683);
        return -1;
      case 1: 
        localdzp.FbR = locala.LVo.xF();
        AppMethodBeat.o(123683);
        return 0;
      case 2: 
        localdzp.Eae = locala.LVo.xF();
        AppMethodBeat.o(123683);
        return 0;
      case 3: 
        localdzp.Scene = locala.LVo.xF();
        AppMethodBeat.o(123683);
        return 0;
      case 4: 
        localdzp.Fhn = locala.LVo.readString();
        AppMethodBeat.o(123683);
        return 0;
      case 5: 
        localdzp.Fhm = locala.LVo.xF();
        AppMethodBeat.o(123683);
        return 0;
      }
      localdzp.Fhl = locala.LVo.xF();
      AppMethodBeat.o(123683);
      return 0;
    }
    AppMethodBeat.o(123683);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzp
 * JD-Core Version:    0.7.0.1
 */