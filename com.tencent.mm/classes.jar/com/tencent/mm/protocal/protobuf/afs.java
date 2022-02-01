package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afs
  extends com.tencent.mm.bw.a
{
  public int Eyd;
  public String Name;
  public long pnx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.pnx);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aR(3, this.Eyd);
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.pnx) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = f.a.a.b.b.a.bx(3, this.Eyd);
      AppMethodBeat.o(155404);
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
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afs localafs = (afs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155404);
        return -1;
      case 1: 
        localafs.pnx = locala.LVo.xG();
        AppMethodBeat.o(155404);
        return 0;
      case 2: 
        localafs.Name = locala.LVo.readString();
        AppMethodBeat.o(155404);
        return 0;
      }
      localafs.Eyd = locala.LVo.xF();
      AppMethodBeat.o(155404);
      return 0;
    }
    AppMethodBeat.o(155404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afs
 * JD-Core Version:    0.7.0.1
 */