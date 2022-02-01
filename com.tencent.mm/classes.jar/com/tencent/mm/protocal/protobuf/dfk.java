package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfk
  extends com.tencent.mm.bw.a
{
  public String EVJ;
  public String FOZ;
  public int FeA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FeA);
      if (this.EVJ != null) {
        paramVarArgs.d(2, this.EVJ);
      }
      if (this.FOZ != null) {
        paramVarArgs.d(3, this.FOZ);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FeA) + 0;
      paramInt = i;
      if (this.EVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EVJ);
      }
      i = paramInt;
      if (this.FOZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FOZ);
      }
      AppMethodBeat.o(152708);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dfk localdfk = (dfk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localdfk.FeA = locala.LVo.xF();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localdfk.EVJ = locala.LVo.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localdfk.FOZ = locala.LVo.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfk
 * JD-Core Version:    0.7.0.1
 */