package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int DJF;
  public com.tencent.mm.bw.b DJO;
  public int DJP;
  public int count;
  public int xxQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DJF);
      if (this.DJO != null) {
        paramVarArgs.c(2, this.DJO);
      }
      paramVarArgs.aR(3, this.DJP);
      paramVarArgs.aR(4, this.xxQ);
      paramVarArgs.aR(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DJF) + 0;
      paramInt = i;
      if (this.DJO != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.DJO);
      }
      i = f.a.a.b.b.a.bx(3, this.DJP);
      int j = f.a.a.b.b.a.bx(4, this.xxQ);
      int k = f.a.a.b.b.a.bx(5, this.count);
      AppMethodBeat.o(143943);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.DJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.DJF = locala.LVo.xF();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.DJO = locala.LVo.gfk();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.DJP = locala.LVo.xF();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.xxQ = locala.LVo.xF();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.LVo.xF();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */