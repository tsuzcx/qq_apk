package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czw
  extends com.tencent.mm.bw.a
{
  public String ELm;
  public String FJj;
  public int FJk;
  public int FJl;
  public int FeA;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FJj != null) {
        paramVarArgs.d(1, this.FJj);
      }
      paramVarArgs.aR(2, this.FJk);
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      if (this.ELm != null) {
        paramVarArgs.d(4, this.ELm);
      }
      paramVarArgs.aR(5, this.FeA);
      paramVarArgs.aR(6, this.FJl);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FJj == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.FJj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FJk);
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ncR);
      }
      i = paramInt;
      if (this.ELm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ELm);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FeA);
      int j = f.a.a.b.b.a.bx(6, this.FJl);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czw localczw = (czw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localczw.FJj = locala.LVo.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localczw.FJk = locala.LVo.xF();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localczw.ncR = locala.LVo.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localczw.ELm = locala.LVo.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localczw.FeA = locala.LVo.xF();
          AppMethodBeat.o(125773);
          return 0;
        }
        localczw.FJl = locala.LVo.xF();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */