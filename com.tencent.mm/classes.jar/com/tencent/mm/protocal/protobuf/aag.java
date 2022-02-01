package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aag
  extends com.tencent.mm.bw.a
{
  public int iKh;
  public String iKi;
  public String iKj;
  public String iKk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.iKh);
      if (this.iKi != null) {
        paramVarArgs.d(2, this.iKi);
      }
      if (this.iKj != null) {
        paramVarArgs.d(3, this.iKj);
      }
      if (this.iKk != null) {
        paramVarArgs.d(4, this.iKk);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.iKh) + 0;
      paramInt = i;
      if (this.iKi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iKi);
      }
      i = paramInt;
      if (this.iKj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iKj);
      }
      paramInt = i;
      if (this.iKk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iKk);
      }
      AppMethodBeat.o(117864);
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
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aag localaag = (aag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localaag.iKh = locala.LVo.xF();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localaag.iKi = locala.LVo.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localaag.iKj = locala.LVo.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localaag.iKk = locala.LVo.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aag
 * JD-Core Version:    0.7.0.1
 */