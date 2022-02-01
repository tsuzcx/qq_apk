package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adz
  extends com.tencent.mm.bw.a
{
  public int EwN;
  public String MD5;
  public int Ret;
  public int vTH;
  public int vTI;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.aR(5, this.EwN);
      paramVarArgs.aO(6, this.vTQ);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ret) + 0 + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = f.a.a.b.b.a.bx(5, this.EwN);
      int j = f.a.a.b.b.a.p(6, this.vTQ);
      AppMethodBeat.o(109447);
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
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      adz localadz = (adz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localadz.Ret = locala.LVo.xF();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localadz.vTI = locala.LVo.xF();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localadz.vTH = locala.LVo.xF();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localadz.MD5 = locala.LVo.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localadz.EwN = locala.LVo.xF();
        AppMethodBeat.o(109447);
        return 0;
      }
      localadz.vTQ = locala.LVo.xG();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adz
 * JD-Core Version:    0.7.0.1
 */