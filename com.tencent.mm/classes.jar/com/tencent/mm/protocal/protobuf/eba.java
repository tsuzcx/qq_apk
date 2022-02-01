package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eba
  extends com.tencent.mm.bw.a
{
  public boolean GgA;
  public String GgI;
  public b GgJ;
  public int GgK;
  public int GgL;
  public int GgM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50123);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.GgA);
      if (this.GgI != null) {
        paramVarArgs.d(2, this.GgI);
      }
      if (this.GgJ != null) {
        paramVarArgs.c(3, this.GgJ);
      }
      paramVarArgs.aR(4, this.GgK);
      paramVarArgs.aR(5, this.GgL);
      paramVarArgs.aR(6, this.GgM);
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.GgI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GgI);
      }
      i = paramInt;
      if (this.GgJ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GgJ);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.GgK);
      int j = f.a.a.b.b.a.bx(5, this.GgL);
      int k = f.a.a.b.b.a.bx(6, this.GgM);
      AppMethodBeat.o(50123);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50123);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eba localeba = (eba)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50123);
        return -1;
      case 1: 
        localeba.GgA = locala.LVo.fZX();
        AppMethodBeat.o(50123);
        return 0;
      case 2: 
        localeba.GgI = locala.LVo.readString();
        AppMethodBeat.o(50123);
        return 0;
      case 3: 
        localeba.GgJ = locala.LVo.gfk();
        AppMethodBeat.o(50123);
        return 0;
      case 4: 
        localeba.GgK = locala.LVo.xF();
        AppMethodBeat.o(50123);
        return 0;
      case 5: 
        localeba.GgL = locala.LVo.xF();
        AppMethodBeat.o(50123);
        return 0;
      }
      localeba.GgM = locala.LVo.xF();
      AppMethodBeat.o(50123);
      return 0;
    }
    AppMethodBeat.o(50123);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eba
 * JD-Core Version:    0.7.0.1
 */