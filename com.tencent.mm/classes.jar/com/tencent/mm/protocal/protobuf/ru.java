package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ru
  extends com.tencent.mm.bw.a
{
  public int Ekd;
  public int Eke;
  public String Ekf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ekd);
      paramVarArgs.aR(2, this.Eke);
      if (this.Ekf != null) {
        paramVarArgs.d(3, this.Ekf);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ekd) + 0 + f.a.a.b.b.a.bx(2, this.Eke);
      paramInt = i;
      if (this.Ekf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ekf);
      }
      AppMethodBeat.o(113972);
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
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ru localru = (ru)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localru.Ekd = locala.LVo.xF();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localru.Eke = locala.LVo.xF();
        AppMethodBeat.o(113972);
        return 0;
      }
      localru.Ekf = locala.LVo.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */