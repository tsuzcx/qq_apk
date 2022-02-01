package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afj
  extends com.tencent.mm.bw.a
{
  public int ExE;
  public String ExF;
  public String ExG;
  public String ExH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ExE);
      if (this.ExF != null) {
        paramVarArgs.d(2, this.ExF);
      }
      if (this.ExG != null) {
        paramVarArgs.d(3, this.ExG);
      }
      if (this.ExH != null) {
        paramVarArgs.d(4, this.ExH);
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ExE) + 0;
      paramInt = i;
      if (this.ExF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ExF);
      }
      i = paramInt;
      if (this.ExG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ExG);
      }
      paramInt = i;
      if (this.ExH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ExH);
      }
      AppMethodBeat.o(32199);
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
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afj localafj = (afj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localafj.ExE = locala.LVo.xF();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localafj.ExF = locala.LVo.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localafj.ExG = locala.LVo.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localafj.ExH = locala.LVo.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afj
 * JD-Core Version:    0.7.0.1
 */