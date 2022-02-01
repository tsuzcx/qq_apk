package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebw
  extends com.tencent.mm.bw.a
{
  public int Ghm;
  public int Ghn;
  public int Gho;
  public int Ghp;
  public String Ghq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ghm);
      paramVarArgs.aR(2, this.Ghn);
      paramVarArgs.aR(3, this.Gho);
      paramVarArgs.aR(4, this.Ghp);
      if (this.Ghq != null) {
        paramVarArgs.d(5, this.Ghq);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ghm) + 0 + f.a.a.b.b.a.bx(2, this.Ghn) + f.a.a.b.b.a.bx(3, this.Gho) + f.a.a.b.b.a.bx(4, this.Ghp);
      paramInt = i;
      if (this.Ghq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ghq);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebw localebw = (ebw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localebw.Ghm = locala.LVo.xF();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localebw.Ghn = locala.LVo.xF();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localebw.Gho = locala.LVo.xF();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localebw.Ghp = locala.LVo.xF();
        AppMethodBeat.o(153337);
        return 0;
      }
      localebw.Ghq = locala.LVo.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebw
 * JD-Core Version:    0.7.0.1
 */