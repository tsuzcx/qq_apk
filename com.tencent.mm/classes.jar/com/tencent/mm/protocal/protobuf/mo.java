package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mo
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FNw;
  public int FYo;
  public int FYp;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FYo);
      paramVarArgs.aS(2, this.CreateTime);
      paramVarArgs.aS(3, this.FNw);
      paramVarArgs.aS(4, this.nJA);
      paramVarArgs.aS(5, this.FYp);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FYo);
      int i = f.a.a.b.b.a.bz(2, this.CreateTime);
      int j = f.a.a.b.b.a.bz(3, this.FNw);
      int k = f.a.a.b.b.a.bz(4, this.nJA);
      int m = f.a.a.b.b.a.bz(5, this.FYp);
      AppMethodBeat.o(124398);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mo localmo = (mo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        localmo.FYo = locala.OmT.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        localmo.CreateTime = locala.OmT.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        localmo.FNw = locala.OmT.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        localmo.nJA = locala.OmT.zc();
        AppMethodBeat.o(124398);
        return 0;
      }
      localmo.FYp = locala.OmT.zc();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mo
 * JD-Core Version:    0.7.0.1
 */